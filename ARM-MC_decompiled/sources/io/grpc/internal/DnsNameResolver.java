package io.grpc.internal;

import androidx.core.app.NotificationCompat;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.base.Stopwatch;
import com.google.common.base.Throwables;
import io.grpc.Attributes;
import io.grpc.EquivalentAddressGroup;
import io.grpc.NameResolver;
import io.grpc.ProxiedSocketAddress;
import io.grpc.ProxyDetector;
import io.grpc.Status;
import io.grpc.SynchronizationContext;
import io.grpc.internal.SharedResourceHolder;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.net.URI;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;

public class DnsNameResolver extends NameResolver {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    static final long DEFAULT_NETWORK_CACHE_TTL_SECONDS = 30;
    private static final String JNDI_LOCALHOST_PROPERTY;
    private static final String JNDI_PROPERTY;
    private static final String JNDI_TXT_PROPERTY;
    static final String NETWORKADDRESS_CACHE_TTL_PROPERTY = "networkaddress.cache.ttl";
    private static final String SERVICE_CONFIG_CHOICE_CLIENT_HOSTNAME_KEY = "clientHostname";
    private static final String SERVICE_CONFIG_CHOICE_CLIENT_LANGUAGE_KEY = "clientLanguage";
    private static final Set<String> SERVICE_CONFIG_CHOICE_KEYS = Collections.unmodifiableSet(new HashSet(Arrays.asList(new String[]{SERVICE_CONFIG_CHOICE_CLIENT_LANGUAGE_KEY, SERVICE_CONFIG_CHOICE_PERCENTAGE_KEY, SERVICE_CONFIG_CHOICE_CLIENT_HOSTNAME_KEY, SERVICE_CONFIG_CHOICE_SERVICE_CONFIG_KEY})));
    private static final String SERVICE_CONFIG_CHOICE_PERCENTAGE_KEY = "percentage";
    private static final String SERVICE_CONFIG_CHOICE_SERVICE_CONFIG_KEY = "serviceConfig";
    private static final String SERVICE_CONFIG_NAME_PREFIX = "_grpc_config.";
    static final String SERVICE_CONFIG_PREFIX = "grpc_config=";
    static boolean enableJndi;
    static boolean enableJndiLocalhost;
    protected static boolean enableTxt;
    private static String localHostname;
    /* access modifiers changed from: private */
    public static final Logger logger;
    private static final ResourceResolverFactory resourceResolverFactory;
    protected volatile AddressResolver addressResolver = JdkAddressResolver.INSTANCE;
    private final String authority;
    /* access modifiers changed from: private */
    public final long cacheTtlNanos;
    private Executor executor;
    private final SharedResourceHolder.Resource<Executor> executorResource;
    /* access modifiers changed from: private */
    public final String host;
    private NameResolver.Listener2 listener;
    private final int port;
    final ProxyDetector proxyDetector;
    private final Random random = new Random();
    protected boolean resolved;
    /* access modifiers changed from: private */
    public boolean resolving;
    private final AtomicReference<ResourceResolver> resourceResolver = new AtomicReference<>();
    private final NameResolver.ServiceConfigParser serviceConfigParser;
    private boolean shutdown;
    /* access modifiers changed from: private */
    public final Stopwatch stopwatch;
    /* access modifiers changed from: private */
    public final SynchronizationContext syncContext;
    private final boolean usingExecutorResource;

    public interface AddressResolver {
        List<InetAddress> resolveAddress(String str) throws Exception;
    }

    public interface ResourceResolver {
        List<SrvRecord> resolveSrv(String str) throws Exception;

        List<String> resolveTxt(String str) throws Exception;
    }

    interface ResourceResolverFactory {
        @Nullable
        ResourceResolver newResourceResolver();

        @Nullable
        Throwable unavailabilityCause();
    }

    static {
        Class<DnsNameResolver> cls = DnsNameResolver.class;
        logger = Logger.getLogger(cls.getName());
        String property = System.getProperty("io.grpc.internal.DnsNameResolverProvider.enable_jndi", "true");
        JNDI_PROPERTY = property;
        String property2 = System.getProperty("io.grpc.internal.DnsNameResolverProvider.enable_jndi_localhost", "false");
        JNDI_LOCALHOST_PROPERTY = property2;
        String property3 = System.getProperty("io.grpc.internal.DnsNameResolverProvider.enable_service_config", "false");
        JNDI_TXT_PROPERTY = property3;
        enableJndi = Boolean.parseBoolean(property);
        enableJndiLocalhost = Boolean.parseBoolean(property2);
        enableTxt = Boolean.parseBoolean(property3);
        resourceResolverFactory = getResourceResolverFactory(cls.getClassLoader());
    }

    protected DnsNameResolver(@Nullable String str, String str2, NameResolver.Args args, SharedResourceHolder.Resource<Executor> resource, Stopwatch stopwatch2, boolean z) {
        Preconditions.checkNotNull(args, "args");
        this.executorResource = resource;
        URI create = URI.create("//" + ((String) Preconditions.checkNotNull(str2, "name")));
        boolean z2 = true;
        Preconditions.checkArgument(create.getHost() != null, "Invalid DNS name: %s", (Object) str2);
        this.authority = (String) Preconditions.checkNotNull(create.getAuthority(), "nameUri (%s) doesn't have an authority", (Object) create);
        this.host = create.getHost();
        if (create.getPort() == -1) {
            this.port = args.getDefaultPort();
        } else {
            this.port = create.getPort();
        }
        this.proxyDetector = (ProxyDetector) Preconditions.checkNotNull(args.getProxyDetector(), "proxyDetector");
        this.cacheTtlNanos = getNetworkAddressCacheTtlNanos(z);
        this.stopwatch = (Stopwatch) Preconditions.checkNotNull(stopwatch2, NotificationCompat.CATEGORY_STOPWATCH);
        this.syncContext = (SynchronizationContext) Preconditions.checkNotNull(args.getSynchronizationContext(), "syncContext");
        Executor offloadExecutor = args.getOffloadExecutor();
        this.executor = offloadExecutor;
        this.usingExecutorResource = offloadExecutor != null ? false : z2;
        this.serviceConfigParser = (NameResolver.ServiceConfigParser) Preconditions.checkNotNull(args.getServiceConfigParser(), "serviceConfigParser");
    }

    public String getServiceAuthority() {
        return this.authority;
    }

    /* access modifiers changed from: protected */
    public String getHost() {
        return this.host;
    }

    public void start(NameResolver.Listener2 listener2) {
        Preconditions.checkState(this.listener == null, "already started");
        if (this.usingExecutorResource) {
            this.executor = (Executor) SharedResourceHolder.get(this.executorResource);
        }
        this.listener = (NameResolver.Listener2) Preconditions.checkNotNull(listener2, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        resolve();
    }

    public void refresh() {
        Preconditions.checkState(this.listener != null, "not started");
        resolve();
    }

    private List<EquivalentAddressGroup> resolveAddresses() {
        try {
            List<InetAddress> resolveAddress = this.addressResolver.resolveAddress(this.host);
            ArrayList arrayList = new ArrayList(resolveAddress.size());
            for (InetAddress inetSocketAddress : resolveAddress) {
                arrayList.add(new EquivalentAddressGroup((SocketAddress) new InetSocketAddress(inetSocketAddress, this.port)));
            }
            return Collections.unmodifiableList(arrayList);
        } catch (Exception e) {
            Throwables.throwIfUnchecked(e);
            throw new RuntimeException(e);
        } catch (Throwable th) {
            if (e != null) {
                logger.log(Level.FINE, "Address resolution failure", e);
            }
            throw th;
        }
    }

    @Nullable
    private NameResolver.ConfigOrError resolveServiceConfig() {
        List<String> emptyList = Collections.emptyList();
        ResourceResolver resourceResolver2 = getResourceResolver();
        if (resourceResolver2 != null) {
            try {
                emptyList = resourceResolver2.resolveTxt(SERVICE_CONFIG_NAME_PREFIX + this.host);
            } catch (Exception e) {
                logger.log(Level.FINE, "ServiceConfig resolution failure", e);
            }
        }
        if (!emptyList.isEmpty()) {
            NameResolver.ConfigOrError parseServiceConfig = parseServiceConfig(emptyList, this.random, getLocalHostname());
            if (parseServiceConfig == null) {
                return null;
            }
            if (parseServiceConfig.getError() != null) {
                return NameResolver.ConfigOrError.fromError(parseServiceConfig.getError());
            }
            return this.serviceConfigParser.parseServiceConfig((Map) parseServiceConfig.getConfig());
        }
        logger.log(Level.FINE, "No TXT records found for {0}", new Object[]{this.host});
        return null;
    }

    /* access modifiers changed from: private */
    @Nullable
    public EquivalentAddressGroup detectProxy() throws IOException {
        ProxiedSocketAddress proxyFor = this.proxyDetector.proxyFor(InetSocketAddress.createUnresolved(this.host, this.port));
        if (proxyFor != null) {
            return new EquivalentAddressGroup((SocketAddress) proxyFor);
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public InternalResolutionResult doResolve(boolean z) {
        InternalResolutionResult internalResolutionResult = new InternalResolutionResult();
        try {
            List unused = internalResolutionResult.addresses = resolveAddresses();
        } catch (Exception e) {
            if (!z) {
                Status unused2 = internalResolutionResult.error = Status.UNAVAILABLE.withDescription("Unable to resolve host " + this.host).withCause(e);
                return internalResolutionResult;
            }
        }
        if (enableTxt) {
            NameResolver.ConfigOrError unused3 = internalResolutionResult.config = resolveServiceConfig();
        }
        return internalResolutionResult;
    }

    private final class Resolve implements Runnable {
        private final NameResolver.Listener2 savedListener;

        Resolve(NameResolver.Listener2 listener2) {
            this.savedListener = (NameResolver.Listener2) Preconditions.checkNotNull(listener2, "savedListener");
        }

        public void run() {
            SynchronizationContext access$1000;
            AnonymousClass1 r1;
            if (DnsNameResolver.logger.isLoggable(Level.FINER)) {
                DnsNameResolver.logger.finer("Attempting DNS resolution of " + DnsNameResolver.this.host);
            }
            final boolean z = true;
            InternalResolutionResult internalResolutionResult = null;
            try {
                EquivalentAddressGroup access$600 = DnsNameResolver.this.detectProxy();
                NameResolver.ResolutionResult.Builder newBuilder = NameResolver.ResolutionResult.newBuilder();
                if (access$600 != null) {
                    if (DnsNameResolver.logger.isLoggable(Level.FINER)) {
                        DnsNameResolver.logger.finer("Using proxy address " + access$600);
                    }
                    newBuilder.setAddresses(Collections.singletonList(access$600));
                    this.savedListener.onResult(newBuilder.build());
                    if (internalResolutionResult == null || internalResolutionResult.error != null) {
                        z = false;
                    }
                    access$1000 = DnsNameResolver.this.syncContext;
                    r1 = new Runnable() {
                        public void run() {
                            if (z) {
                                DnsNameResolver.this.resolved = true;
                                if (DnsNameResolver.this.cacheTtlNanos > 0) {
                                    DnsNameResolver.this.stopwatch.reset().start();
                                }
                            }
                            boolean unused = DnsNameResolver.this.resolving = false;
                        }
                    };
                } else {
                    internalResolutionResult = DnsNameResolver.this.doResolve(false);
                    if (internalResolutionResult.error != null) {
                        this.savedListener.onError(internalResolutionResult.error);
                        if (internalResolutionResult == null || internalResolutionResult.error != null) {
                            z = false;
                        }
                        access$1000 = DnsNameResolver.this.syncContext;
                        r1 = new Runnable() {
                            public void run() {
                                if (z) {
                                    DnsNameResolver.this.resolved = true;
                                    if (DnsNameResolver.this.cacheTtlNanos > 0) {
                                        DnsNameResolver.this.stopwatch.reset().start();
                                    }
                                }
                                boolean unused = DnsNameResolver.this.resolving = false;
                            }
                        };
                    } else {
                        if (internalResolutionResult.addresses != null) {
                            newBuilder.setAddresses(internalResolutionResult.addresses);
                        }
                        if (internalResolutionResult.config != null) {
                            newBuilder.setServiceConfig(internalResolutionResult.config);
                        }
                        if (internalResolutionResult.attributes != null) {
                            newBuilder.setAttributes(internalResolutionResult.attributes);
                        }
                        this.savedListener.onResult(newBuilder.build());
                        z = false;
                        access$1000 = DnsNameResolver.this.syncContext;
                        r1 = new Runnable() {
                            public void run() {
                                if (z) {
                                    DnsNameResolver.this.resolved = true;
                                    if (DnsNameResolver.this.cacheTtlNanos > 0) {
                                        DnsNameResolver.this.stopwatch.reset().start();
                                    }
                                }
                                boolean unused = DnsNameResolver.this.resolving = false;
                            }
                        };
                    }
                }
                access$1000.execute(r1);
            } catch (IOException e) {
                this.savedListener.onError(Status.UNAVAILABLE.withDescription("Unable to resolve host " + DnsNameResolver.this.host).withCause(e));
                if (internalResolutionResult == null || internalResolutionResult.error != null) {
                    z = false;
                }
                DnsNameResolver.this.syncContext.execute(new Runnable() {
                    public void run() {
                        if (z) {
                            DnsNameResolver.this.resolved = true;
                            if (DnsNameResolver.this.cacheTtlNanos > 0) {
                                DnsNameResolver.this.stopwatch.reset().start();
                            }
                        }
                        boolean unused = DnsNameResolver.this.resolving = false;
                    }
                });
            } catch (Throwable th) {
                if (internalResolutionResult == null || internalResolutionResult.error != null) {
                    z = false;
                }
                DnsNameResolver.this.syncContext.execute(new Runnable() {
                    public void run() {
                        if (z) {
                            DnsNameResolver.this.resolved = true;
                            if (DnsNameResolver.this.cacheTtlNanos > 0) {
                                DnsNameResolver.this.stopwatch.reset().start();
                            }
                        }
                        boolean unused = DnsNameResolver.this.resolving = false;
                    }
                });
                throw th;
            }
        }
    }

    @Nullable
    static NameResolver.ConfigOrError parseServiceConfig(List<String> list, Random random2, String str) {
        try {
            Map<String, ?> map = null;
            for (Map maybeChooseServiceConfig : parseTxtResults(list)) {
                try {
                    map = maybeChooseServiceConfig(maybeChooseServiceConfig, random2, str);
                    if (map != null) {
                        break;
                    }
                } catch (RuntimeException e) {
                    return NameResolver.ConfigOrError.fromError(Status.UNKNOWN.withDescription("failed to pick service config choice").withCause(e));
                }
            }
            if (map == null) {
                return null;
            }
            return NameResolver.ConfigOrError.fromConfig(map);
        } catch (IOException | RuntimeException e2) {
            return NameResolver.ConfigOrError.fromError(Status.UNKNOWN.withDescription("failed to parse TXT records").withCause(e2));
        }
    }

    private void resolve() {
        if (!this.resolving && !this.shutdown && cacheRefreshRequired()) {
            this.resolving = true;
            this.executor.execute(new Resolve(this.listener));
        }
    }

    private boolean cacheRefreshRequired() {
        if (!this.resolved) {
            return true;
        }
        long j = this.cacheTtlNanos;
        if (j != 0) {
            return j > 0 && this.stopwatch.elapsed(TimeUnit.NANOSECONDS) > this.cacheTtlNanos;
        }
        return true;
    }

    public void shutdown() {
        if (!this.shutdown) {
            this.shutdown = true;
            Executor executor2 = this.executor;
            if (executor2 != null && this.usingExecutorResource) {
                this.executor = (Executor) SharedResourceHolder.release(this.executorResource, executor2);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final int getPort() {
        return this.port;
    }

    static List<Map<String, ?>> parseTxtResults(List<String> list) throws IOException {
        ArrayList arrayList = new ArrayList();
        for (String next : list) {
            if (!next.startsWith(SERVICE_CONFIG_PREFIX)) {
                logger.log(Level.FINE, "Ignoring non service config {0}", new Object[]{next});
            } else {
                Object parse = JsonParser.parse(next.substring(SERVICE_CONFIG_PREFIX.length()));
                if (parse instanceof List) {
                    arrayList.addAll(JsonUtil.checkObjectList((List) parse));
                } else {
                    throw new ClassCastException("wrong type " + parse);
                }
            }
        }
        return arrayList;
    }

    @Nullable
    private static final Double getPercentageFromChoice(Map<String, ?> map) {
        return JsonUtil.getNumberAsDouble(map, SERVICE_CONFIG_CHOICE_PERCENTAGE_KEY);
    }

    @Nullable
    private static final List<String> getClientLanguagesFromChoice(Map<String, ?> map) {
        return JsonUtil.getListOfStrings(map, SERVICE_CONFIG_CHOICE_CLIENT_LANGUAGE_KEY);
    }

    @Nullable
    private static final List<String> getHostnamesFromChoice(Map<String, ?> map) {
        return JsonUtil.getListOfStrings(map, SERVICE_CONFIG_CHOICE_CLIENT_HOSTNAME_KEY);
    }

    private static long getNetworkAddressCacheTtlNanos(boolean z) {
        if (z) {
            return 0;
        }
        String property = System.getProperty(NETWORKADDRESS_CACHE_TTL_PROPERTY);
        long j = DEFAULT_NETWORK_CACHE_TTL_SECONDS;
        if (property != null) {
            try {
                j = Long.parseLong(property);
            } catch (NumberFormatException unused) {
                logger.log(Level.WARNING, "Property({0}) valid is not valid number format({1}), fall back to default({2})", new Object[]{NETWORKADDRESS_CACHE_TTL_PROPERTY, property, Long.valueOf(DEFAULT_NETWORK_CACHE_TTL_SECONDS)});
            }
        }
        return j > 0 ? TimeUnit.SECONDS.toNanos(j) : j;
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0051  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0076  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x008e  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0096 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0097  */
    @javax.annotation.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static java.util.Map<java.lang.String, ?> maybeChooseServiceConfig(java.util.Map<java.lang.String, ?> r6, java.util.Random r7, java.lang.String r8) {
        /*
            java.util.Set r0 = r6.entrySet()
            java.util.Iterator r0 = r0.iterator()
        L_0x0008:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0024
            java.lang.Object r1 = r0.next()
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1
            java.util.Set<java.lang.String> r2 = SERVICE_CONFIG_CHOICE_KEYS
            java.lang.Object r3 = r1.getKey()
            boolean r2 = r2.contains(r3)
            java.lang.String r3 = "Bad key: %s"
            com.google.common.base.Verify.verify((boolean) r2, (java.lang.String) r3, (java.lang.Object) r1)
            goto L_0x0008
        L_0x0024:
            java.util.List r0 = getClientLanguagesFromChoice(r6)
            r1 = 0
            if (r0 == 0) goto L_0x004b
            boolean r2 = r0.isEmpty()
            if (r2 != 0) goto L_0x004b
            java.util.Iterator r0 = r0.iterator()
        L_0x0035:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x004a
            java.lang.Object r2 = r0.next()
            java.lang.String r2 = (java.lang.String) r2
            java.lang.String r3 = "java"
            boolean r2 = r3.equalsIgnoreCase(r2)
            if (r2 == 0) goto L_0x0035
            goto L_0x004b
        L_0x004a:
            return r1
        L_0x004b:
            java.lang.Double r0 = getPercentageFromChoice(r6)
            if (r0 == 0) goto L_0x006a
            int r2 = r0.intValue()
            r3 = 100
            if (r2 < 0) goto L_0x005d
            if (r2 > r3) goto L_0x005d
            r4 = 1
            goto L_0x005e
        L_0x005d:
            r4 = 0
        L_0x005e:
            java.lang.String r5 = "Bad percentage: %s"
            com.google.common.base.Verify.verify((boolean) r4, (java.lang.String) r5, (java.lang.Object) r0)
            int r7 = r7.nextInt(r3)
            if (r7 < r2) goto L_0x006a
            return r1
        L_0x006a:
            java.util.List r7 = getHostnamesFromChoice(r6)
            if (r7 == 0) goto L_0x008e
            boolean r0 = r7.isEmpty()
            if (r0 != 0) goto L_0x008e
            java.util.Iterator r7 = r7.iterator()
        L_0x007a:
            boolean r0 = r7.hasNext()
            if (r0 == 0) goto L_0x008d
            java.lang.Object r0 = r7.next()
            java.lang.String r0 = (java.lang.String) r0
            boolean r0 = r0.equals(r8)
            if (r0 == 0) goto L_0x007a
            goto L_0x008e
        L_0x008d:
            return r1
        L_0x008e:
            java.lang.String r7 = "serviceConfig"
            java.util.Map r8 = io.grpc.internal.JsonUtil.getObject(r6, r7)
            if (r8 == 0) goto L_0x0097
            return r8
        L_0x0097:
            com.google.common.base.VerifyException r8 = new com.google.common.base.VerifyException
            java.lang.String r0 = "key '%s' missing in '%s'"
            java.lang.Object[] r6 = new java.lang.Object[]{r6, r7}
            java.lang.String r6 = java.lang.String.format(r0, r6)
            r8.<init>((java.lang.String) r6)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: io.grpc.internal.DnsNameResolver.maybeChooseServiceConfig(java.util.Map, java.util.Random, java.lang.String):java.util.Map");
    }

    protected static final class InternalResolutionResult {
        /* access modifiers changed from: private */
        public List<EquivalentAddressGroup> addresses;
        public Attributes attributes;
        /* access modifiers changed from: private */
        public NameResolver.ConfigOrError config;
        /* access modifiers changed from: private */
        public Status error;

        private InternalResolutionResult() {
        }
    }

    public static final class SrvRecord {
        public final String host;
        public final int port;

        public SrvRecord(String str, int i) {
            this.host = str;
            this.port = i;
        }

        public int hashCode() {
            return Objects.hashCode(this.host, Integer.valueOf(this.port));
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && getClass() == obj.getClass()) {
                SrvRecord srvRecord = (SrvRecord) obj;
                return this.port == srvRecord.port && this.host.equals(srvRecord.host);
            }
        }

        public String toString() {
            return MoreObjects.toStringHelper((Object) this).add("host", (Object) this.host).add("port", this.port).toString();
        }
    }

    /* access modifiers changed from: protected */
    public void setAddressResolver(AddressResolver addressResolver2) {
        this.addressResolver = addressResolver2;
    }

    /* access modifiers changed from: protected */
    public void setResourceResolver(ResourceResolver resourceResolver2) {
        this.resourceResolver.set(resourceResolver2);
    }

    private enum JdkAddressResolver implements AddressResolver {
        INSTANCE;

        public List<InetAddress> resolveAddress(String str) throws UnknownHostException {
            return Collections.unmodifiableList(Arrays.asList(InetAddress.getAllByName(str)));
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0018, code lost:
        r1 = resourceResolverFactory;
     */
    @javax.annotation.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public io.grpc.internal.DnsNameResolver.ResourceResolver getResourceResolver() {
        /*
            r3 = this;
            boolean r0 = enableJndi
            boolean r1 = enableJndiLocalhost
            java.lang.String r2 = r3.host
            boolean r0 = shouldUseJndi(r0, r1, r2)
            if (r0 != 0) goto L_0x000e
            r0 = 0
            return r0
        L_0x000e:
            java.util.concurrent.atomic.AtomicReference<io.grpc.internal.DnsNameResolver$ResourceResolver> r0 = r3.resourceResolver
            java.lang.Object r0 = r0.get()
            io.grpc.internal.DnsNameResolver$ResourceResolver r0 = (io.grpc.internal.DnsNameResolver.ResourceResolver) r0
            if (r0 != 0) goto L_0x0020
            io.grpc.internal.DnsNameResolver$ResourceResolverFactory r1 = resourceResolverFactory
            if (r1 == 0) goto L_0x0020
            io.grpc.internal.DnsNameResolver$ResourceResolver r0 = r1.newResourceResolver()
        L_0x0020:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.grpc.internal.DnsNameResolver.getResourceResolver():io.grpc.internal.DnsNameResolver$ResourceResolver");
    }

    @Nullable
    static ResourceResolverFactory getResourceResolverFactory(ClassLoader classLoader) {
        try {
            try {
                try {
                    ResourceResolverFactory resourceResolverFactory2 = (ResourceResolverFactory) Class.forName("io.grpc.internal.JndiResourceResolverFactory", true, classLoader).asSubclass(ResourceResolverFactory.class).getConstructor(new Class[0]).newInstance(new Object[0]);
                    if (resourceResolverFactory2.unavailabilityCause() == null) {
                        return resourceResolverFactory2;
                    }
                    logger.log(Level.FINE, "JndiResourceResolverFactory not available, skipping.", resourceResolverFactory2.unavailabilityCause());
                    return null;
                } catch (Exception e) {
                    logger.log(Level.FINE, "Can't construct JndiResourceResolverFactory, skipping.", e);
                    return null;
                }
            } catch (Exception e2) {
                logger.log(Level.FINE, "Can't find JndiResourceResolverFactory ctor, skipping.", e2);
                return null;
            }
        } catch (ClassNotFoundException e3) {
            logger.log(Level.FINE, "Unable to find JndiResourceResolverFactory, skipping.", e3);
            return null;
        } catch (ClassCastException e4) {
            logger.log(Level.FINE, "Unable to cast JndiResourceResolverFactory, skipping.", e4);
            return null;
        }
    }

    private static String getLocalHostname() {
        if (localHostname == null) {
            try {
                localHostname = InetAddress.getLocalHost().getHostName();
            } catch (UnknownHostException e) {
                throw new RuntimeException(e);
            }
        }
        return localHostname;
    }

    protected static boolean shouldUseJndi(boolean z, boolean z2, String str) {
        if (!z) {
            return false;
        }
        if ("localhost".equalsIgnoreCase(str)) {
            return z2;
        }
        if (str.contains(":")) {
            return false;
        }
        boolean z3 = true;
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (charAt != '.') {
                z3 &= charAt >= '0' && charAt <= '9';
            }
        }
        return true ^ z3;
    }
}
