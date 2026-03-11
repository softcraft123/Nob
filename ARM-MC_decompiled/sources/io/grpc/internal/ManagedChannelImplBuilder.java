package io.grpc.internal;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.credentials.exceptions.publickeycredential.DomExceptionUtils;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.MoreExecutors;
import io.grpc.Attributes;
import io.grpc.BinaryLog;
import io.grpc.CallCredentials;
import io.grpc.ChannelCredentials;
import io.grpc.ClientInterceptor;
import io.grpc.ClientTransportFilter;
import io.grpc.CompressorRegistry;
import io.grpc.DecompressorRegistry;
import io.grpc.EquivalentAddressGroup;
import io.grpc.InternalChannelz;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.NameResolver;
import io.grpc.NameResolverProvider;
import io.grpc.NameResolverRegistry;
import io.grpc.ProxyDetector;
import io.grpc.internal.ExponentialBackoffPolicy;
import java.lang.reflect.Method;
import java.net.SocketAddress;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;

public final class ManagedChannelImplBuilder extends ManagedChannelBuilder<ManagedChannelImplBuilder> {
    private static final CompressorRegistry DEFAULT_COMPRESSOR_REGISTRY = CompressorRegistry.getDefaultInstance();
    private static final DecompressorRegistry DEFAULT_DECOMPRESSOR_REGISTRY = DecompressorRegistry.getDefaultInstance();
    private static final ObjectPool<? extends Executor> DEFAULT_EXECUTOR_POOL = SharedResourcePool.forResource(GrpcUtil.SHARED_CHANNEL_EXECUTOR);
    private static final long DEFAULT_PER_RPC_BUFFER_LIMIT_IN_BYTES = 1048576;
    private static final long DEFAULT_RETRY_BUFFER_SIZE_IN_BYTES = 16777216;
    private static final String DIRECT_ADDRESS_SCHEME = "directaddress";
    private static final Method GET_CLIENT_INTERCEPTOR_METHOD;
    static final long IDLE_MODE_DEFAULT_TIMEOUT_MILLIS = TimeUnit.MINUTES.toMillis(IDLE_MODE_MAX_TIMEOUT_DAYS);
    static final long IDLE_MODE_MAX_TIMEOUT_DAYS = 30;
    static final long IDLE_MODE_MIN_TIMEOUT_MILLIS = TimeUnit.SECONDS.toMillis(1);
    private static final Logger log = Logger.getLogger(ManagedChannelImplBuilder.class.getName());
    private boolean authorityCheckerDisabled;
    @Nullable
    String authorityOverride;
    @Nullable
    BinaryLog binlog;
    @Nullable
    final CallCredentials callCredentials;
    private final ChannelBuilderDefaultPortProvider channelBuilderDefaultPortProvider;
    @Nullable
    final ChannelCredentials channelCredentials;
    InternalChannelz channelz;
    private final ClientTransportFactoryBuilder clientTransportFactoryBuilder;
    CompressorRegistry compressorRegistry;
    DecompressorRegistry decompressorRegistry;
    String defaultLbPolicy;
    @Nullable
    Map<String, ?> defaultServiceConfig;
    @Nullable
    private final SocketAddress directServerAddress;
    ObjectPool<? extends Executor> executorPool;
    boolean fullStreamDecompression;
    long idleTimeoutMillis;
    private final List<ClientInterceptor> interceptors;
    boolean lookUpServiceConfig;
    int maxHedgedAttempts;
    int maxRetryAttempts;
    int maxTraceEvents;
    NameResolverRegistry nameResolverRegistry;
    ObjectPool<? extends Executor> offloadExecutorPool;
    long perRpcBufferLimit;
    @Nullable
    ProxyDetector proxyDetector;
    private boolean recordFinishedRpcs;
    private boolean recordRealTimeMetrics;
    private boolean recordRetryMetrics;
    private boolean recordStartedRpcs;
    long retryBufferSize;
    boolean retryEnabled;
    private boolean statsEnabled;
    final String target;
    private boolean tracingEnabled;
    final List<ClientTransportFilter> transportFilters;
    @Nullable
    String userAgent;

    public interface ChannelBuilderDefaultPortProvider {
        int getDefaultPort();
    }

    public interface ClientTransportFactoryBuilder {
        ClientTransportFactory buildClientTransportFactory();
    }

    static {
        Method method;
        try {
            method = Class.forName("io.grpc.census.InternalCensusStatsAccessor").getDeclaredMethod("getClientInterceptor", new Class[]{Boolean.TYPE, Boolean.TYPE, Boolean.TYPE, Boolean.TYPE});
        } catch (ClassNotFoundException e) {
            log.log(Level.FINE, "Unable to apply census stats", e);
            method = null;
            GET_CLIENT_INTERCEPTOR_METHOD = method;
        } catch (NoSuchMethodException e2) {
            log.log(Level.FINE, "Unable to apply census stats", e2);
            method = null;
            GET_CLIENT_INTERCEPTOR_METHOD = method;
        }
        GET_CLIENT_INTERCEPTOR_METHOD = method;
    }

    public static ManagedChannelBuilder<?> forAddress(String str, int i) {
        throw new UnsupportedOperationException("ClientTransportFactoryBuilder is required, use a constructor");
    }

    public static ManagedChannelBuilder<?> forTarget(String str) {
        throw new UnsupportedOperationException("ClientTransportFactoryBuilder is required, use a constructor");
    }

    public static class UnsupportedClientTransportFactoryBuilder implements ClientTransportFactoryBuilder {
        public ClientTransportFactory buildClientTransportFactory() {
            throw new UnsupportedOperationException();
        }
    }

    public static final class FixedPortProvider implements ChannelBuilderDefaultPortProvider {
        private final int port;

        public FixedPortProvider(int i) {
            this.port = i;
        }

        public int getDefaultPort() {
            return this.port;
        }
    }

    private static final class ManagedChannelDefaultPortProvider implements ChannelBuilderDefaultPortProvider {
        public int getDefaultPort() {
            return GrpcUtil.DEFAULT_PORT_SSL;
        }

        private ManagedChannelDefaultPortProvider() {
        }
    }

    public ManagedChannelImplBuilder(String str, ClientTransportFactoryBuilder clientTransportFactoryBuilder2, @Nullable ChannelBuilderDefaultPortProvider channelBuilderDefaultPortProvider2) {
        this(str, (ChannelCredentials) null, (CallCredentials) null, clientTransportFactoryBuilder2, channelBuilderDefaultPortProvider2);
    }

    public ManagedChannelImplBuilder(String str, @Nullable ChannelCredentials channelCredentials2, @Nullable CallCredentials callCredentials2, ClientTransportFactoryBuilder clientTransportFactoryBuilder2, @Nullable ChannelBuilderDefaultPortProvider channelBuilderDefaultPortProvider2) {
        ObjectPool<? extends Executor> objectPool = DEFAULT_EXECUTOR_POOL;
        this.executorPool = objectPool;
        this.offloadExecutorPool = objectPool;
        this.interceptors = new ArrayList();
        this.nameResolverRegistry = NameResolverRegistry.getDefaultRegistry();
        this.transportFilters = new ArrayList();
        this.defaultLbPolicy = GrpcUtil.DEFAULT_LB_POLICY;
        this.decompressorRegistry = DEFAULT_DECOMPRESSOR_REGISTRY;
        this.compressorRegistry = DEFAULT_COMPRESSOR_REGISTRY;
        this.idleTimeoutMillis = IDLE_MODE_DEFAULT_TIMEOUT_MILLIS;
        this.maxRetryAttempts = 5;
        this.maxHedgedAttempts = 5;
        this.retryBufferSize = DEFAULT_RETRY_BUFFER_SIZE_IN_BYTES;
        this.perRpcBufferLimit = DEFAULT_PER_RPC_BUFFER_LIMIT_IN_BYTES;
        this.retryEnabled = true;
        this.channelz = InternalChannelz.instance();
        this.lookUpServiceConfig = true;
        this.statsEnabled = true;
        this.recordStartedRpcs = true;
        this.recordFinishedRpcs = true;
        this.recordRealTimeMetrics = false;
        this.recordRetryMetrics = true;
        this.tracingEnabled = true;
        this.target = (String) Preconditions.checkNotNull(str, TypedValues.AttributesType.S_TARGET);
        this.channelCredentials = channelCredentials2;
        this.callCredentials = callCredentials2;
        this.clientTransportFactoryBuilder = (ClientTransportFactoryBuilder) Preconditions.checkNotNull(clientTransportFactoryBuilder2, "clientTransportFactoryBuilder");
        this.directServerAddress = null;
        if (channelBuilderDefaultPortProvider2 != null) {
            this.channelBuilderDefaultPortProvider = channelBuilderDefaultPortProvider2;
        } else {
            this.channelBuilderDefaultPortProvider = new ManagedChannelDefaultPortProvider();
        }
    }

    static String makeTargetStringForDirectAddress(SocketAddress socketAddress) {
        try {
            return new URI(DIRECT_ADDRESS_SCHEME, "", DomExceptionUtils.SEPARATOR + socketAddress, (String) null).toString();
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }

    public ManagedChannelImplBuilder(SocketAddress socketAddress, String str, ClientTransportFactoryBuilder clientTransportFactoryBuilder2, @Nullable ChannelBuilderDefaultPortProvider channelBuilderDefaultPortProvider2) {
        this(socketAddress, str, (ChannelCredentials) null, (CallCredentials) null, clientTransportFactoryBuilder2, channelBuilderDefaultPortProvider2);
    }

    public ManagedChannelImplBuilder(SocketAddress socketAddress, String str, @Nullable ChannelCredentials channelCredentials2, @Nullable CallCredentials callCredentials2, ClientTransportFactoryBuilder clientTransportFactoryBuilder2, @Nullable ChannelBuilderDefaultPortProvider channelBuilderDefaultPortProvider2) {
        ObjectPool<? extends Executor> objectPool = DEFAULT_EXECUTOR_POOL;
        this.executorPool = objectPool;
        this.offloadExecutorPool = objectPool;
        this.interceptors = new ArrayList();
        this.nameResolverRegistry = NameResolverRegistry.getDefaultRegistry();
        this.transportFilters = new ArrayList();
        this.defaultLbPolicy = GrpcUtil.DEFAULT_LB_POLICY;
        this.decompressorRegistry = DEFAULT_DECOMPRESSOR_REGISTRY;
        this.compressorRegistry = DEFAULT_COMPRESSOR_REGISTRY;
        this.idleTimeoutMillis = IDLE_MODE_DEFAULT_TIMEOUT_MILLIS;
        this.maxRetryAttempts = 5;
        this.maxHedgedAttempts = 5;
        this.retryBufferSize = DEFAULT_RETRY_BUFFER_SIZE_IN_BYTES;
        this.perRpcBufferLimit = DEFAULT_PER_RPC_BUFFER_LIMIT_IN_BYTES;
        this.retryEnabled = true;
        this.channelz = InternalChannelz.instance();
        this.lookUpServiceConfig = true;
        this.statsEnabled = true;
        this.recordStartedRpcs = true;
        this.recordFinishedRpcs = true;
        this.recordRealTimeMetrics = false;
        this.recordRetryMetrics = true;
        this.tracingEnabled = true;
        this.target = makeTargetStringForDirectAddress(socketAddress);
        this.channelCredentials = channelCredentials2;
        this.callCredentials = callCredentials2;
        this.clientTransportFactoryBuilder = (ClientTransportFactoryBuilder) Preconditions.checkNotNull(clientTransportFactoryBuilder2, "clientTransportFactoryBuilder");
        this.directServerAddress = socketAddress;
        NameResolverRegistry nameResolverRegistry2 = new NameResolverRegistry();
        nameResolverRegistry2.register(new DirectAddressNameResolverProvider(socketAddress, str));
        this.nameResolverRegistry = nameResolverRegistry2;
        if (channelBuilderDefaultPortProvider2 != null) {
            this.channelBuilderDefaultPortProvider = channelBuilderDefaultPortProvider2;
        } else {
            this.channelBuilderDefaultPortProvider = new ManagedChannelDefaultPortProvider();
        }
    }

    public ManagedChannelImplBuilder directExecutor() {
        return executor(MoreExecutors.directExecutor());
    }

    public ManagedChannelImplBuilder executor(Executor executor) {
        if (executor != null) {
            this.executorPool = new FixedObjectPool(executor);
            return this;
        }
        this.executorPool = DEFAULT_EXECUTOR_POOL;
        return this;
    }

    public ManagedChannelImplBuilder offloadExecutor(Executor executor) {
        if (executor != null) {
            this.offloadExecutorPool = new FixedObjectPool(executor);
            return this;
        }
        this.offloadExecutorPool = DEFAULT_EXECUTOR_POOL;
        return this;
    }

    public ManagedChannelImplBuilder intercept(List<ClientInterceptor> list) {
        this.interceptors.addAll(list);
        return this;
    }

    public ManagedChannelImplBuilder intercept(ClientInterceptor... clientInterceptorArr) {
        return intercept(Arrays.asList(clientInterceptorArr));
    }

    public ManagedChannelImplBuilder addTransportFilter(ClientTransportFilter clientTransportFilter) {
        this.transportFilters.add((ClientTransportFilter) Preconditions.checkNotNull(clientTransportFilter, "transport filter"));
        return this;
    }

    @Deprecated
    public ManagedChannelImplBuilder nameResolverFactory(NameResolver.Factory factory) {
        SocketAddress socketAddress = this.directServerAddress;
        Preconditions.checkState(socketAddress == null, "directServerAddress is set (%s), which forbids the use of NameResolverFactory", (Object) socketAddress);
        if (factory != null) {
            NameResolverRegistry nameResolverRegistry2 = new NameResolverRegistry();
            if (factory instanceof NameResolverProvider) {
                nameResolverRegistry2.register((NameResolverProvider) factory);
            } else {
                nameResolverRegistry2.register(new NameResolverFactoryToProviderFacade(factory));
            }
            this.nameResolverRegistry = nameResolverRegistry2;
            return this;
        }
        this.nameResolverRegistry = NameResolverRegistry.getDefaultRegistry();
        return this;
    }

    /* access modifiers changed from: package-private */
    public ManagedChannelImplBuilder nameResolverRegistry(NameResolverRegistry nameResolverRegistry2) {
        this.nameResolverRegistry = nameResolverRegistry2;
        return this;
    }

    public ManagedChannelImplBuilder defaultLoadBalancingPolicy(String str) {
        SocketAddress socketAddress = this.directServerAddress;
        boolean z = true;
        Preconditions.checkState(socketAddress == null, "directServerAddress is set (%s), which forbids the use of load-balancing policy", (Object) socketAddress);
        if (str == null) {
            z = false;
        }
        Preconditions.checkArgument(z, "policy cannot be null");
        this.defaultLbPolicy = str;
        return this;
    }

    public ManagedChannelImplBuilder decompressorRegistry(DecompressorRegistry decompressorRegistry2) {
        if (decompressorRegistry2 != null) {
            this.decompressorRegistry = decompressorRegistry2;
            return this;
        }
        this.decompressorRegistry = DEFAULT_DECOMPRESSOR_REGISTRY;
        return this;
    }

    public ManagedChannelImplBuilder compressorRegistry(CompressorRegistry compressorRegistry2) {
        if (compressorRegistry2 != null) {
            this.compressorRegistry = compressorRegistry2;
            return this;
        }
        this.compressorRegistry = DEFAULT_COMPRESSOR_REGISTRY;
        return this;
    }

    public ManagedChannelImplBuilder userAgent(@Nullable String str) {
        this.userAgent = str;
        return this;
    }

    public ManagedChannelImplBuilder overrideAuthority(String str) {
        this.authorityOverride = checkAuthority(str);
        return this;
    }

    public ManagedChannelImplBuilder idleTimeout(long j, TimeUnit timeUnit) {
        Preconditions.checkArgument(j > 0, "idle timeout is %s, but must be positive", j);
        if (timeUnit.toDays(j) >= IDLE_MODE_MAX_TIMEOUT_DAYS) {
            this.idleTimeoutMillis = -1;
            return this;
        }
        this.idleTimeoutMillis = Math.max(timeUnit.toMillis(j), IDLE_MODE_MIN_TIMEOUT_MILLIS);
        return this;
    }

    public ManagedChannelImplBuilder maxRetryAttempts(int i) {
        this.maxRetryAttempts = i;
        return this;
    }

    public ManagedChannelImplBuilder maxHedgedAttempts(int i) {
        this.maxHedgedAttempts = i;
        return this;
    }

    public ManagedChannelImplBuilder retryBufferSize(long j) {
        Preconditions.checkArgument(j > 0, "retry buffer size must be positive");
        this.retryBufferSize = j;
        return this;
    }

    public ManagedChannelImplBuilder perRpcBufferLimit(long j) {
        Preconditions.checkArgument(j > 0, "per RPC buffer limit must be positive");
        this.perRpcBufferLimit = j;
        return this;
    }

    public ManagedChannelImplBuilder disableRetry() {
        this.retryEnabled = false;
        return this;
    }

    public ManagedChannelImplBuilder enableRetry() {
        this.retryEnabled = true;
        return this;
    }

    public ManagedChannelImplBuilder setBinaryLog(BinaryLog binaryLog) {
        this.binlog = binaryLog;
        return this;
    }

    public ManagedChannelImplBuilder maxTraceEvents(int i) {
        Preconditions.checkArgument(i >= 0, "maxTraceEvents must be non-negative");
        this.maxTraceEvents = i;
        return this;
    }

    public ManagedChannelImplBuilder proxyDetector(@Nullable ProxyDetector proxyDetector2) {
        this.proxyDetector = proxyDetector2;
        return this;
    }

    public ManagedChannelImplBuilder defaultServiceConfig(@Nullable Map<String, ?> map) {
        this.defaultServiceConfig = checkMapEntryTypes(map);
        return this;
    }

    @Nullable
    private static Map<String, ?> checkMapEntryTypes(@Nullable Map<?, ?> map) {
        if (map == null) {
            return null;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry next : map.entrySet()) {
            Preconditions.checkArgument(next.getKey() instanceof String, "The key of the entry '%s' is not of String type", (Object) next);
            String str = (String) next.getKey();
            Object value = next.getValue();
            if (value == null) {
                linkedHashMap.put(str, (Object) null);
            } else if (value instanceof Map) {
                linkedHashMap.put(str, checkMapEntryTypes((Map) value));
            } else if (value instanceof List) {
                linkedHashMap.put(str, checkListEntryTypes((List) value));
            } else if (value instanceof String) {
                linkedHashMap.put(str, value);
            } else if (value instanceof Double) {
                linkedHashMap.put(str, value);
            } else if (value instanceof Boolean) {
                linkedHashMap.put(str, value);
            } else {
                throw new IllegalArgumentException("The value of the map entry '" + next + "' is of type '" + value.getClass() + "', which is not supported");
            }
        }
        return Collections.unmodifiableMap(linkedHashMap);
    }

    private static List<?> checkListEntryTypes(List<?> list) {
        ArrayList arrayList = new ArrayList(list.size());
        for (Object next : list) {
            if (next == null) {
                arrayList.add((Object) null);
            } else if (next instanceof Map) {
                arrayList.add(checkMapEntryTypes((Map) next));
            } else if (next instanceof List) {
                arrayList.add(checkListEntryTypes((List) next));
            } else if (next instanceof String) {
                arrayList.add(next);
            } else if (next instanceof Double) {
                arrayList.add(next);
            } else if (next instanceof Boolean) {
                arrayList.add(next);
            } else {
                throw new IllegalArgumentException("The entry '" + next + "' is of type '" + next.getClass() + "', which is not supported");
            }
        }
        return Collections.unmodifiableList(arrayList);
    }

    public ManagedChannelImplBuilder disableServiceConfigLookUp() {
        this.lookUpServiceConfig = false;
        return this;
    }

    public void setStatsEnabled(boolean z) {
        this.statsEnabled = z;
    }

    public void setStatsRecordStartedRpcs(boolean z) {
        this.recordStartedRpcs = z;
    }

    public void setStatsRecordFinishedRpcs(boolean z) {
        this.recordFinishedRpcs = z;
    }

    public void setStatsRecordRealTimeMetrics(boolean z) {
        this.recordRealTimeMetrics = z;
    }

    public void setStatsRecordRetryMetrics(boolean z) {
        this.recordRetryMetrics = z;
    }

    public void setTracingEnabled(boolean z) {
        this.tracingEnabled = z;
    }

    /* access modifiers changed from: package-private */
    public String checkAuthority(String str) {
        if (this.authorityCheckerDisabled) {
            return str;
        }
        return GrpcUtil.checkAuthority(str);
    }

    public ManagedChannelImplBuilder disableCheckAuthority() {
        this.authorityCheckerDisabled = true;
        return this;
    }

    public ManagedChannelImplBuilder enableCheckAuthority() {
        this.authorityCheckerDisabled = false;
        return this;
    }

    public ManagedChannel build() {
        return new ManagedChannelOrphanWrapper(new ManagedChannelImpl(this, this.clientTransportFactoryBuilder.buildClientTransportFactory(), new ExponentialBackoffPolicy.Provider(), SharedResourcePool.forResource(GrpcUtil.SHARED_CHANNEL_EXECUTOR), GrpcUtil.STOPWATCH_SUPPLIER, getEffectiveInterceptors(), TimeProvider.SYSTEM_TIME_PROVIDER));
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0058  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.List<io.grpc.ClientInterceptor> getEffectiveInterceptors() {
        /*
            r10 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            java.util.List<io.grpc.ClientInterceptor> r1 = r10.interceptors
            r0.<init>(r1)
            java.util.List r1 = io.grpc.InternalGlobalInterceptors.getClientInterceptors()
            r2 = 0
            if (r1 == 0) goto L_0x0013
            r0.addAll(r1)
            r1 = 1
            goto L_0x0014
        L_0x0013:
            r1 = r2
        L_0x0014:
            r3 = 0
            java.lang.String r4 = "Unable to apply census stats"
            if (r1 != 0) goto L_0x005b
            boolean r5 = r10.statsEnabled
            if (r5 == 0) goto L_0x005b
            java.lang.reflect.Method r5 = GET_CLIENT_INTERCEPTOR_METHOD
            if (r5 == 0) goto L_0x0055
            boolean r6 = r10.recordStartedRpcs     // Catch:{ IllegalAccessException -> 0x004d, InvocationTargetException -> 0x0044 }
            java.lang.Boolean r6 = java.lang.Boolean.valueOf(r6)     // Catch:{ IllegalAccessException -> 0x004d, InvocationTargetException -> 0x0044 }
            boolean r7 = r10.recordFinishedRpcs     // Catch:{ IllegalAccessException -> 0x004d, InvocationTargetException -> 0x0044 }
            java.lang.Boolean r7 = java.lang.Boolean.valueOf(r7)     // Catch:{ IllegalAccessException -> 0x004d, InvocationTargetException -> 0x0044 }
            boolean r8 = r10.recordRealTimeMetrics     // Catch:{ IllegalAccessException -> 0x004d, InvocationTargetException -> 0x0044 }
            java.lang.Boolean r8 = java.lang.Boolean.valueOf(r8)     // Catch:{ IllegalAccessException -> 0x004d, InvocationTargetException -> 0x0044 }
            boolean r9 = r10.recordRetryMetrics     // Catch:{ IllegalAccessException -> 0x004d, InvocationTargetException -> 0x0044 }
            java.lang.Boolean r9 = java.lang.Boolean.valueOf(r9)     // Catch:{ IllegalAccessException -> 0x004d, InvocationTargetException -> 0x0044 }
            java.lang.Object[] r6 = new java.lang.Object[]{r6, r7, r8, r9}     // Catch:{ IllegalAccessException -> 0x004d, InvocationTargetException -> 0x0044 }
            java.lang.Object r5 = r5.invoke(r3, r6)     // Catch:{ IllegalAccessException -> 0x004d, InvocationTargetException -> 0x0044 }
            io.grpc.ClientInterceptor r5 = (io.grpc.ClientInterceptor) r5     // Catch:{ IllegalAccessException -> 0x004d, InvocationTargetException -> 0x0044 }
            goto L_0x0056
        L_0x0044:
            r5 = move-exception
            java.util.logging.Logger r6 = log
            java.util.logging.Level r7 = java.util.logging.Level.FINE
            r6.log(r7, r4, r5)
            goto L_0x0055
        L_0x004d:
            r5 = move-exception
            java.util.logging.Logger r6 = log
            java.util.logging.Level r7 = java.util.logging.Level.FINE
            r6.log(r7, r4, r5)
        L_0x0055:
            r5 = r3
        L_0x0056:
            if (r5 == 0) goto L_0x005b
            r0.add(r2, r5)
        L_0x005b:
            if (r1 != 0) goto L_0x00a1
            boolean r1 = r10.tracingEnabled
            if (r1 == 0) goto L_0x00a1
            java.lang.String r1 = "io.grpc.census.InternalCensusTracingAccessor"
            java.lang.Class r1 = java.lang.Class.forName(r1)     // Catch:{ ClassNotFoundException -> 0x0094, NoSuchMethodException -> 0x008b, IllegalAccessException -> 0x0082, InvocationTargetException -> 0x0079 }
            java.lang.String r5 = "getClientInterceptor"
            java.lang.Class[] r6 = new java.lang.Class[r2]     // Catch:{ ClassNotFoundException -> 0x0094, NoSuchMethodException -> 0x008b, IllegalAccessException -> 0x0082, InvocationTargetException -> 0x0079 }
            java.lang.reflect.Method r1 = r1.getDeclaredMethod(r5, r6)     // Catch:{ ClassNotFoundException -> 0x0094, NoSuchMethodException -> 0x008b, IllegalAccessException -> 0x0082, InvocationTargetException -> 0x0079 }
            java.lang.Object[] r5 = new java.lang.Object[r2]     // Catch:{ ClassNotFoundException -> 0x0094, NoSuchMethodException -> 0x008b, IllegalAccessException -> 0x0082, InvocationTargetException -> 0x0079 }
            java.lang.Object r1 = r1.invoke(r3, r5)     // Catch:{ ClassNotFoundException -> 0x0094, NoSuchMethodException -> 0x008b, IllegalAccessException -> 0x0082, InvocationTargetException -> 0x0079 }
            io.grpc.ClientInterceptor r1 = (io.grpc.ClientInterceptor) r1     // Catch:{ ClassNotFoundException -> 0x0094, NoSuchMethodException -> 0x008b, IllegalAccessException -> 0x0082, InvocationTargetException -> 0x0079 }
            r3 = r1
            goto L_0x009c
        L_0x0079:
            r1 = move-exception
            java.util.logging.Logger r5 = log
            java.util.logging.Level r6 = java.util.logging.Level.FINE
            r5.log(r6, r4, r1)
            goto L_0x009c
        L_0x0082:
            r1 = move-exception
            java.util.logging.Logger r5 = log
            java.util.logging.Level r6 = java.util.logging.Level.FINE
            r5.log(r6, r4, r1)
            goto L_0x009c
        L_0x008b:
            r1 = move-exception
            java.util.logging.Logger r5 = log
            java.util.logging.Level r6 = java.util.logging.Level.FINE
            r5.log(r6, r4, r1)
            goto L_0x009c
        L_0x0094:
            r1 = move-exception
            java.util.logging.Logger r5 = log
            java.util.logging.Level r6 = java.util.logging.Level.FINE
            r5.log(r6, r4, r1)
        L_0x009c:
            if (r3 == 0) goto L_0x00a1
            r0.add(r2, r3)
        L_0x00a1:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.grpc.internal.ManagedChannelImplBuilder.getEffectiveInterceptors():java.util.List");
    }

    /* access modifiers changed from: package-private */
    public int getDefaultPort() {
        return this.channelBuilderDefaultPortProvider.getDefaultPort();
    }

    private static class DirectAddressNameResolverProvider extends NameResolverProvider {
        final SocketAddress address;
        final String authority;
        final Collection<Class<? extends SocketAddress>> producedSocketAddressTypes;

        /* access modifiers changed from: protected */
        public boolean isAvailable() {
            return true;
        }

        /* access modifiers changed from: protected */
        public int priority() {
            return 5;
        }

        DirectAddressNameResolverProvider(SocketAddress socketAddress, String str) {
            this.address = socketAddress;
            this.authority = str;
            this.producedSocketAddressTypes = Collections.singleton(socketAddress.getClass());
        }

        public NameResolver newNameResolver(URI uri, NameResolver.Args args) {
            return new NameResolver() {
                public void shutdown() {
                }

                public String getServiceAuthority() {
                    return DirectAddressNameResolverProvider.this.authority;
                }

                public void start(NameResolver.Listener2 listener2) {
                    listener2.onResult(NameResolver.ResolutionResult.newBuilder().setAddresses(Collections.singletonList(new EquivalentAddressGroup(DirectAddressNameResolverProvider.this.address))).setAttributes(Attributes.EMPTY).build());
                }
            };
        }

        public String getDefaultScheme() {
            return ManagedChannelImplBuilder.DIRECT_ADDRESS_SCHEME;
        }

        public Collection<Class<? extends SocketAddress>> getProducedSocketAddressTypes() {
            return this.producedSocketAddressTypes;
        }
    }

    public ObjectPool<? extends Executor> getOffloadExecutorPool() {
        return this.offloadExecutorPool;
    }
}
