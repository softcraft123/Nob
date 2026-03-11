package com.google.android.gms.dynamite;

import android.content.Context;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import android.os.SystemClock;
import android.util.Log;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.CrashUtils;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

/* compiled from: com.google.android.gms:play-services-basement@@18.8.0 */
public final class DynamiteModule {
    public static final int LOCAL = -1;
    public static final int NONE = 0;
    public static final int NO_SELECTION = 0;
    public static final VersionPolicy PREFER_HIGHEST_OR_LOCAL_VERSION = new zzj();
    public static final VersionPolicy PREFER_HIGHEST_OR_LOCAL_VERSION_NO_FORCE_STAGING = new zzk();
    public static final VersionPolicy PREFER_HIGHEST_OR_REMOTE_VERSION = new zzl();
    public static final VersionPolicy PREFER_LOCAL = new zzh();
    public static final VersionPolicy PREFER_REMOTE = new zzg();
    public static final VersionPolicy PREFER_REMOTE_VERSION_NO_FORCE_STAGING = new zzi();
    public static final int REMOTE = 1;
    public static final VersionPolicy zza = new zzm();
    public static final VersionPolicy zzb = new zzc();
    private static Boolean zzc = null;
    private static String zzd = null;
    private static boolean zze = false;
    private static int zzf = -1;
    private static Boolean zzg;
    private static final ThreadLocal zzh = new ThreadLocal();
    private static final ThreadLocal zzi = new zze();
    private static final VersionPolicy.IVersions zzj = new zzf();
    private static zzp zzl;
    private static zzq zzm;
    private final Context zzk;

    /* compiled from: com.google.android.gms:play-services-basement@@18.8.0 */
    public static class DynamiteLoaderClassLoader {
        public static ClassLoader sClassLoader;
    }

    /* compiled from: com.google.android.gms:play-services-basement@@18.8.0 */
    public static class LoadingException extends Exception {
        /* synthetic */ LoadingException(String str, Throwable th, byte[] bArr) {
            super(str, th);
        }

        /* synthetic */ LoadingException(String str, byte[] bArr) {
            super(str);
        }
    }

    /* compiled from: com.google.android.gms:play-services-basement@@18.8.0 */
    public interface VersionPolicy {

        /* compiled from: com.google.android.gms:play-services-basement@@18.8.0 */
        public interface IVersions {
            int zza(Context context, String str, boolean z) throws LoadingException;

            int zzb(Context context, String str);
        }

        /* compiled from: com.google.android.gms:play-services-basement@@18.8.0 */
        public static class SelectionResult {
            public int localVersion = 0;
            public int remoteVersion = 0;
            public int selection = 0;
        }

        SelectionResult selectModule(Context context, String str, IVersions iVersions) throws LoadingException;
    }

    private DynamiteModule(Context context) {
        Preconditions.checkNotNull(context);
        Context context2 = context;
        this.zzk = context;
    }

    public static int getLocalVersion(Context context, String str) {
        try {
            ClassLoader classLoader = context.getApplicationContext().getClassLoader();
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 61);
            sb.append("com.google.android.gms.dynamite.descriptors.");
            sb.append(str);
            sb.append(".ModuleDescriptor");
            Class<?> loadClass = classLoader.loadClass(sb.toString());
            Field declaredField = loadClass.getDeclaredField("MODULE_ID");
            Field declaredField2 = loadClass.getDeclaredField("MODULE_VERSION");
            if (Objects.equal(declaredField.get((Object) null), str)) {
                return declaredField2.getInt((Object) null);
            }
            String valueOf = String.valueOf(declaredField.get((Object) null));
            StringBuilder sb2 = new StringBuilder(String.valueOf(valueOf).length() + 50 + String.valueOf(str).length() + 1);
            sb2.append("Module descriptor id '");
            sb2.append(valueOf);
            sb2.append("' didn't match expected id '");
            sb2.append(str);
            sb2.append("'");
            Log.e("DynamiteModule", sb2.toString());
            return 0;
        } catch (ClassNotFoundException unused) {
            StringBuilder sb3 = new StringBuilder(String.valueOf(str).length() + 45);
            sb3.append("Local module descriptor class for ");
            sb3.append(str);
            sb3.append(" not found.");
            Log.w("DynamiteModule", sb3.toString());
            return 0;
        } catch (Exception e) {
            String message = e.getMessage();
            String.valueOf(message);
            Log.e("DynamiteModule", "Failed to load module descriptor class: ".concat(String.valueOf(message)));
            return 0;
        }
    }

    public static int getRemoteVersion(Context context, String str) {
        return zza(context, str, false);
    }

    public static DynamiteModule load(Context context, VersionPolicy versionPolicy, String str) throws LoadingException {
        DynamiteModule dynamiteModule;
        int i;
        Boolean bool;
        IObjectWrapper iObjectWrapper;
        zzq zzq;
        Boolean valueOf;
        IObjectWrapper iObjectWrapper2;
        Context context2 = context;
        VersionPolicy versionPolicy2 = versionPolicy;
        String str2 = str;
        Context applicationContext = context2.getApplicationContext();
        if (applicationContext != null) {
            ThreadLocal threadLocal = zzh;
            zzn zzn = (zzn) threadLocal.get();
            String str3 = ".";
            zzn zzn2 = new zzn((byte[]) null);
            threadLocal.set(zzn2);
            ThreadLocal threadLocal2 = zzi;
            long longValue = ((Long) threadLocal2.get()).longValue();
            try {
                String str4 = " and remote version is ";
                threadLocal2.set(Long.valueOf(SystemClock.uptimeMillis()));
                VersionPolicy.SelectionResult selectModule = versionPolicy2.selectModule(context2, str2, zzj);
                String str5 = " found. Local version is ";
                String str6 = "No acceptable module ";
                int i2 = selectModule.localVersion;
                String str7 = "VersionPolicy returned invalid code:";
                int i3 = selectModule.remoteVersion;
                String str8 = "Failed to load remote module: ";
                StringBuilder sb = new StringBuilder(String.valueOf(str2).length() + 26 + String.valueOf(i2).length() + 19 + String.valueOf(str2).length() + 1 + String.valueOf(i3).length());
                sb.append("Considering local module ");
                sb.append(str2);
                sb.append(":");
                sb.append(i2);
                sb.append(" and remote module ");
                sb.append(str2);
                sb.append(":");
                sb.append(i3);
                Log.i("DynamiteModule", sb.toString());
                int i4 = selectModule.selection;
                if (i4 != 0) {
                    if (i4 == -1) {
                        if (selectModule.localVersion != 0) {
                            i4 = -1;
                        }
                    }
                    if (!(i4 == 1 && selectModule.remoteVersion == 0)) {
                        if (i4 == -1) {
                            DynamiteModule zze2 = zze(applicationContext, str2);
                            if (longValue == 0) {
                                threadLocal2.remove();
                            } else {
                                threadLocal2.set(Long.valueOf(longValue));
                            }
                            Cursor cursor = zzn2.zza;
                            if (cursor != null) {
                                cursor.close();
                            }
                            threadLocal.set(zzn);
                            return zze2;
                        } else if (i4 == 1) {
                            try {
                                int i5 = selectModule.remoteVersion;
                                try {
                                    synchronized (DynamiteModule.class) {
                                        if (zzb(context2)) {
                                            bool = zzc;
                                        } else {
                                            throw new LoadingException("Remote loading disabled", (byte[]) null);
                                        }
                                    }
                                    if (bool != null) {
                                        if (bool.booleanValue()) {
                                            StringBuilder sb2 = new StringBuilder(String.valueOf(str2).length() + 40 + String.valueOf(i5).length());
                                            sb2.append("Selected remote version of ");
                                            sb2.append(str2);
                                            sb2.append(", version >= ");
                                            sb2.append(i5);
                                            Log.i("DynamiteModule", sb2.toString());
                                            synchronized (DynamiteModule.class) {
                                                zzq = zzm;
                                            }
                                            if (zzq != null) {
                                                zzn zzn3 = (zzn) threadLocal.get();
                                                if (zzn3 == null || zzn3.zza == null) {
                                                    throw new LoadingException("No result cursor", (byte[]) null);
                                                }
                                                Context applicationContext2 = context2.getApplicationContext();
                                                Cursor cursor2 = zzn3.zza;
                                                ObjectWrapper.wrap(null);
                                                synchronized (DynamiteModule.class) {
                                                    valueOf = Boolean.valueOf(zzf >= 2);
                                                }
                                                if (valueOf.booleanValue()) {
                                                    Log.v("DynamiteModule", "Dynamite loader version >= 2, using loadModule2NoCrashUtils");
                                                    iObjectWrapper2 = zzq.zzf(ObjectWrapper.wrap(applicationContext2), str2, i5, ObjectWrapper.wrap(cursor2));
                                                } else {
                                                    Log.w("DynamiteModule", "Dynamite loader version < 2, falling back to loadModule2");
                                                    iObjectWrapper2 = zzq.zze(ObjectWrapper.wrap(applicationContext2), str2, i5, ObjectWrapper.wrap(cursor2));
                                                }
                                                Context context3 = (Context) ObjectWrapper.unwrap(iObjectWrapper2);
                                                if (context3 != null) {
                                                    dynamiteModule = new DynamiteModule(context3);
                                                } else {
                                                    throw new LoadingException("Failed to get module context", (byte[]) null);
                                                }
                                            } else {
                                                throw new LoadingException("DynamiteLoaderV2 was not cached.", (byte[]) null);
                                            }
                                        } else {
                                            StringBuilder sb3 = new StringBuilder(String.valueOf(str2).length() + 40 + String.valueOf(i5).length());
                                            sb3.append("Selected remote version of ");
                                            sb3.append(str2);
                                            sb3.append(", version >= ");
                                            sb3.append(i5);
                                            Log.i("DynamiteModule", sb3.toString());
                                            zzp zzg2 = zzg(context2);
                                            if (zzg2 != null) {
                                                int zzi2 = zzg2.zzi();
                                                if (zzi2 >= 3) {
                                                    zzn zzn4 = (zzn) threadLocal.get();
                                                    if (zzn4 != null) {
                                                        iObjectWrapper = zzg2.zzk(ObjectWrapper.wrap(context2), str2, i5, ObjectWrapper.wrap(zzn4.zza));
                                                    } else {
                                                        throw new LoadingException("No cached result cursor holder", (byte[]) null);
                                                    }
                                                } else if (zzi2 == 2) {
                                                    Log.w("DynamiteModule", "IDynamite loader version = 2");
                                                    iObjectWrapper = zzg2.zzg(ObjectWrapper.wrap(context2), str2, i5);
                                                } else {
                                                    Log.w("DynamiteModule", "Dynamite loader version < 2, falling back to createModuleContext");
                                                    iObjectWrapper = zzg2.zze(ObjectWrapper.wrap(context2), str2, i5);
                                                }
                                                Object unwrap = ObjectWrapper.unwrap(iObjectWrapper);
                                                if (unwrap != null) {
                                                    dynamiteModule = new DynamiteModule((Context) unwrap);
                                                } else {
                                                    throw new LoadingException("Failed to load remote module.", (byte[]) null);
                                                }
                                            } else {
                                                throw new LoadingException("Failed to create IDynamiteLoader.", (byte[]) null);
                                            }
                                        }
                                        if (i != 0) {
                                            zzi.set(Long.valueOf(longValue));
                                        }
                                        return dynamiteModule;
                                    }
                                    throw new LoadingException("Failed to determine which loading route to use.", (byte[]) null);
                                } catch (RemoteException e) {
                                    throw new LoadingException("Failed to load remote module.", e, (byte[]) null);
                                } catch (LoadingException e2) {
                                    throw e2;
                                } catch (Throwable th) {
                                    CrashUtils.addDynamiteErrorToDropBox(context2, th);
                                    throw new LoadingException("Failed to load remote module.", th, (byte[]) null);
                                }
                            } catch (LoadingException e3) {
                                String message = e3.getMessage();
                                StringBuilder sb4 = new StringBuilder(String.valueOf(message).length() + 30);
                                sb4.append(str8);
                                sb4.append(message);
                                Log.w("DynamiteModule", sb4.toString());
                                int i6 = selectModule.localVersion;
                                if (i6 != 0) {
                                    if (versionPolicy.selectModule(context2, str2, new zzo(i6, 0)).selection == -1) {
                                        dynamiteModule = zze(applicationContext, str2);
                                    }
                                }
                                throw new LoadingException("Remote load failed. No local fallback found.", e3, (byte[]) null);
                            }
                        } else {
                            StringBuilder sb5 = new StringBuilder(String.valueOf(i4).length() + 36);
                            sb5.append(str7);
                            sb5.append(i4);
                            throw new LoadingException(sb5.toString(), (byte[]) null);
                        }
                    }
                }
                int i7 = selectModule.localVersion;
                int i8 = selectModule.remoteVersion;
                StringBuilder sb6 = new StringBuilder(String.valueOf(str2).length() + 46 + String.valueOf(i7).length() + 23 + String.valueOf(i8).length() + 1);
                sb6.append(str6);
                sb6.append(str2);
                sb6.append(str5);
                sb6.append(i7);
                sb6.append(str4);
                sb6.append(i8);
                sb6.append(str3);
                throw new LoadingException(sb6.toString(), (byte[]) null);
            } finally {
                if (longValue == 0) {
                    zzi.remove();
                } else {
                    zzi.set(Long.valueOf(longValue));
                }
                Cursor cursor3 = zzn2.zza;
                if (cursor3 != null) {
                    cursor3.close();
                }
                zzh.set(zzn);
            }
        } else {
            throw new LoadingException("null application Context", (byte[]) null);
        }
    }

    /* JADX INFO: finally extract failed */
    /*  JADX ERROR: IndexOutOfBoundsException in pass: RegionMakerVisitor
        java.lang.IndexOutOfBoundsException: Index: 0, Size: 0
        	at java.util.ArrayList.rangeCheck(ArrayList.java:659)
        	at java.util.ArrayList.get(ArrayList.java:435)
        	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:101)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:611)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:693)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:598)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:49)
        */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:50:0x00a6=Splitter:B:50:0x00a6, B:31:0x005a=Splitter:B:31:0x005a, B:17:0x003f=Splitter:B:17:0x003f} */
    public static int zza(android.content.Context r12, java.lang.String r13, boolean r14) {
        /*
            java.lang.String r1 = "Failed to retrieve remote module version: "
            java.lang.String r2 = "Failed to load module via V2: "
            java.lang.Class<com.google.android.gms.dynamite.DynamiteModule> r3 = com.google.android.gms.dynamite.DynamiteModule.class
            monitor-enter(r3)     // Catch:{ all -> 0x01ed }
            java.lang.Boolean r0 = zzc     // Catch:{ all -> 0x01e9 }
            r4 = 0
            r5 = 0
            if (r0 != 0) goto L_0x00e8
            android.content.Context r0 = r12.getApplicationContext()     // Catch:{ ClassNotFoundException -> 0x00c5, IllegalAccessException -> 0x00c3, NoSuchFieldException -> 0x00c1 }
            java.lang.ClassLoader r0 = r0.getClassLoader()     // Catch:{ ClassNotFoundException -> 0x00c5, IllegalAccessException -> 0x00c3, NoSuchFieldException -> 0x00c1 }
            java.lang.Class<com.google.android.gms.dynamite.DynamiteModule$DynamiteLoaderClassLoader> r6 = com.google.android.gms.dynamite.DynamiteModule.DynamiteLoaderClassLoader.class
            java.lang.String r6 = r6.getName()     // Catch:{ ClassNotFoundException -> 0x00c5, IllegalAccessException -> 0x00c3, NoSuchFieldException -> 0x00c1 }
            java.lang.Class r0 = r0.loadClass(r6)     // Catch:{ ClassNotFoundException -> 0x00c5, IllegalAccessException -> 0x00c3, NoSuchFieldException -> 0x00c1 }
            java.lang.String r6 = "sClassLoader"
            java.lang.reflect.Field r0 = r0.getDeclaredField(r6)     // Catch:{ ClassNotFoundException -> 0x00c5, IllegalAccessException -> 0x00c3, NoSuchFieldException -> 0x00c1 }
            java.lang.Class r6 = r0.getDeclaringClass()     // Catch:{ ClassNotFoundException -> 0x00c5, IllegalAccessException -> 0x00c3, NoSuchFieldException -> 0x00c1 }
            monitor-enter(r6)     // Catch:{ ClassNotFoundException -> 0x00c5, IllegalAccessException -> 0x00c3, NoSuchFieldException -> 0x00c1 }
            java.lang.Object r7 = r0.get(r4)     // Catch:{ all -> 0x00be }
            java.lang.ClassLoader r7 = (java.lang.ClassLoader) r7     // Catch:{ all -> 0x00be }
            java.lang.ClassLoader r8 = java.lang.ClassLoader.getSystemClassLoader()     // Catch:{ all -> 0x00be }
            if (r7 != r8) goto L_0x003a
            java.lang.Boolean r0 = java.lang.Boolean.FALSE     // Catch:{ all -> 0x00be }
            goto L_0x00bc
        L_0x003a:
            if (r7 == 0) goto L_0x0043
            zzf(r7)     // Catch:{ LoadingException -> 0x003f }
        L_0x003f:
            java.lang.Boolean r0 = java.lang.Boolean.TRUE     // Catch:{ all -> 0x00be }
            goto L_0x00bc
        L_0x0043:
            boolean r7 = zzb(r12)     // Catch:{ all -> 0x00be }
            if (r7 != 0) goto L_0x004c
            monitor-exit(r6)     // Catch:{ all -> 0x00be }
            monitor-exit(r3)     // Catch:{ all -> 0x01e9 }
            return r5
        L_0x004c:
            boolean r7 = zze     // Catch:{ all -> 0x00be }
            if (r7 != 0) goto L_0x00b3
            java.lang.Boolean r7 = java.lang.Boolean.TRUE     // Catch:{ all -> 0x00be }
            boolean r7 = r7.equals(r4)     // Catch:{ all -> 0x00be }
            if (r7 == 0) goto L_0x0059
            goto L_0x00b3
        L_0x0059:
            r7 = 1
            int r7 = zzc(r12, r13, r14, r7)     // Catch:{ LoadingException -> 0x00a9 }
            java.lang.String r8 = zzd     // Catch:{ LoadingException -> 0x00a9 }
            if (r8 == 0) goto L_0x00a6
            boolean r8 = r8.isEmpty()     // Catch:{ LoadingException -> 0x00a9 }
            if (r8 == 0) goto L_0x0069
            goto L_0x00a6
        L_0x0069:
            java.lang.ClassLoader r8 = com.google.android.gms.dynamite.zzb.zza()     // Catch:{ LoadingException -> 0x00a9 }
            if (r8 == 0) goto L_0x0070
            goto L_0x0099
        L_0x0070:
            int r8 = android.os.Build.VERSION.SDK_INT     // Catch:{ LoadingException -> 0x00a9 }
            r9 = 29
            if (r8 < r9) goto L_0x0088
            dalvik.system.DelegateLastClassLoader r8 = new dalvik.system.DelegateLastClassLoader     // Catch:{ LoadingException -> 0x00a9 }
            java.lang.String r9 = zzd     // Catch:{ LoadingException -> 0x00a9 }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r9)     // Catch:{ LoadingException -> 0x00a9 }
            r10 = r9
            java.lang.String r10 = (java.lang.String) r10     // Catch:{ LoadingException -> 0x00a9 }
            java.lang.ClassLoader r10 = java.lang.ClassLoader.getSystemClassLoader()     // Catch:{ LoadingException -> 0x00a9 }
            r8.<init>(r9, r10)     // Catch:{ LoadingException -> 0x00a9 }
            goto L_0x0099
        L_0x0088:
            com.google.android.gms.dynamite.zzd r8 = new com.google.android.gms.dynamite.zzd     // Catch:{ LoadingException -> 0x00a9 }
            java.lang.String r9 = zzd     // Catch:{ LoadingException -> 0x00a9 }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r9)     // Catch:{ LoadingException -> 0x00a9 }
            r10 = r9
            java.lang.String r10 = (java.lang.String) r10     // Catch:{ LoadingException -> 0x00a9 }
            java.lang.ClassLoader r10 = java.lang.ClassLoader.getSystemClassLoader()     // Catch:{ LoadingException -> 0x00a9 }
            r8.<init>(r9, r10)     // Catch:{ LoadingException -> 0x00a9 }
        L_0x0099:
            zzf(r8)     // Catch:{ LoadingException -> 0x00a9 }
            r0.set(r4, r8)     // Catch:{ LoadingException -> 0x00a9 }
            java.lang.Boolean r8 = java.lang.Boolean.TRUE     // Catch:{ LoadingException -> 0x00a9 }
            zzc = r8     // Catch:{ LoadingException -> 0x00a9 }
            monitor-exit(r6)     // Catch:{ all -> 0x00be }
            monitor-exit(r3)     // Catch:{ all -> 0x01e9 }
            return r7
        L_0x00a6:
            monitor-exit(r6)     // Catch:{ all -> 0x00be }
            monitor-exit(r3)     // Catch:{ all -> 0x01e9 }
            return r7
        L_0x00a9:
            java.lang.ClassLoader r7 = java.lang.ClassLoader.getSystemClassLoader()     // Catch:{ all -> 0x00be }
            r0.set(r4, r7)     // Catch:{ all -> 0x00be }
            java.lang.Boolean r0 = java.lang.Boolean.FALSE     // Catch:{ all -> 0x00be }
            goto L_0x00bc
        L_0x00b3:
            java.lang.ClassLoader r7 = java.lang.ClassLoader.getSystemClassLoader()     // Catch:{ all -> 0x00be }
            r0.set(r4, r7)     // Catch:{ all -> 0x00be }
            java.lang.Boolean r0 = java.lang.Boolean.FALSE     // Catch:{ all -> 0x00be }
        L_0x00bc:
            monitor-exit(r6)     // Catch:{ all -> 0x00be }
            goto L_0x00e6
        L_0x00be:
            r0 = move-exception
            monitor-exit(r6)     // Catch:{ all -> 0x00be }
            throw r0     // Catch:{ ClassNotFoundException -> 0x00c5, IllegalAccessException -> 0x00c3, NoSuchFieldException -> 0x00c1 }
        L_0x00c1:
            r0 = move-exception
            goto L_0x00c6
        L_0x00c3:
            r0 = move-exception
            goto L_0x00c6
        L_0x00c5:
            r0 = move-exception
        L_0x00c6:
            java.lang.String r6 = "DynamiteModule"
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x01e9 }
            int r7 = r0.length()     // Catch:{ all -> 0x01e9 }
            int r7 = r7 + 30
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ all -> 0x01e9 }
            r8.<init>(r7)     // Catch:{ all -> 0x01e9 }
            r8.append(r2)     // Catch:{ all -> 0x01e9 }
            r8.append(r0)     // Catch:{ all -> 0x01e9 }
            java.lang.String r0 = r8.toString()     // Catch:{ all -> 0x01e9 }
            android.util.Log.w(r6, r0)     // Catch:{ all -> 0x01e9 }
            java.lang.Boolean r0 = java.lang.Boolean.FALSE     // Catch:{ all -> 0x01e9 }
        L_0x00e6:
            zzc = r0     // Catch:{ all -> 0x01e9 }
        L_0x00e8:
            monitor-exit(r3)     // Catch:{ all -> 0x01e9 }
            boolean r0 = r0.booleanValue()     // Catch:{ all -> 0x01ed }
            if (r0 == 0) goto L_0x0119
            int r12 = zzc(r12, r13, r14, r5)     // Catch:{ LoadingException -> 0x00f4 }
            return r12
        L_0x00f4:
            r0 = move-exception
            r13 = r0
            java.lang.String r14 = "DynamiteModule"
            java.lang.String r13 = r13.getMessage()     // Catch:{ all -> 0x01ed }
            java.lang.String r0 = java.lang.String.valueOf(r13)     // Catch:{ all -> 0x01ed }
            int r0 = r0.length()     // Catch:{ all -> 0x01ed }
            int r0 = r0 + 42
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x01ed }
            r2.<init>(r0)     // Catch:{ all -> 0x01ed }
            r2.append(r1)     // Catch:{ all -> 0x01ed }
            r2.append(r13)     // Catch:{ all -> 0x01ed }
            java.lang.String r13 = r2.toString()     // Catch:{ all -> 0x01ed }
            android.util.Log.w(r14, r13)     // Catch:{ all -> 0x01ed }
            return r5
        L_0x0119:
            java.lang.String r1 = "Failed to retrieve remote module version: "
            com.google.android.gms.dynamite.zzp r6 = zzg(r12)     // Catch:{ all -> 0x01ed }
            if (r6 != 0) goto L_0x0123
            goto L_0x01df
        L_0x0123:
            int r0 = r6.zzi()     // Catch:{ RemoteException -> 0x01b5 }
            r2 = 3
            if (r0 < r2) goto L_0x018e
            java.lang.ThreadLocal r0 = zzh     // Catch:{ RemoteException -> 0x01b5 }
            java.lang.Object r0 = r0.get()     // Catch:{ RemoteException -> 0x01b5 }
            com.google.android.gms.dynamite.zzn r0 = (com.google.android.gms.dynamite.zzn) r0     // Catch:{ RemoteException -> 0x01b5 }
            if (r0 == 0) goto L_0x013e
            android.database.Cursor r0 = r0.zza     // Catch:{ RemoteException -> 0x01b5 }
            if (r0 == 0) goto L_0x013e
            int r5 = r0.getInt(r5)     // Catch:{ RemoteException -> 0x01b5 }
            goto L_0x01df
        L_0x013e:
            com.google.android.gms.dynamic.IObjectWrapper r7 = com.google.android.gms.dynamic.ObjectWrapper.wrap(r12)     // Catch:{ RemoteException -> 0x01b5 }
            java.lang.ThreadLocal r0 = zzi     // Catch:{ RemoteException -> 0x01b5 }
            java.lang.Object r0 = r0.get()     // Catch:{ RemoteException -> 0x01b5 }
            java.lang.Long r0 = (java.lang.Long) r0     // Catch:{ RemoteException -> 0x01b5 }
            long r10 = r0.longValue()     // Catch:{ RemoteException -> 0x01b5 }
            r8 = r13
            r9 = r14
            com.google.android.gms.dynamic.IObjectWrapper r13 = r6.zzj(r7, r8, r9, r10)     // Catch:{ RemoteException -> 0x01b5 }
            java.lang.Object r13 = com.google.android.gms.dynamic.ObjectWrapper.unwrap(r13)     // Catch:{ RemoteException -> 0x01b5 }
            android.database.Cursor r13 = (android.database.Cursor) r13     // Catch:{ RemoteException -> 0x01b5 }
            if (r13 == 0) goto L_0x0179
            boolean r14 = r13.moveToFirst()     // Catch:{ RemoteException -> 0x018a, all -> 0x0186 }
            if (r14 != 0) goto L_0x0163
            goto L_0x0179
        L_0x0163:
            int r14 = r13.getInt(r5)     // Catch:{ RemoteException -> 0x018a, all -> 0x0186 }
            if (r14 <= 0) goto L_0x0170
            boolean r0 = zzd(r13)     // Catch:{ RemoteException -> 0x018a, all -> 0x0186 }
            if (r0 == 0) goto L_0x0170
            goto L_0x0171
        L_0x0170:
            r4 = r13
        L_0x0171:
            if (r4 == 0) goto L_0x0176
            r4.close()     // Catch:{ all -> 0x01ed }
        L_0x0176:
            r5 = r14
            goto L_0x01df
        L_0x0179:
            java.lang.String r14 = "DynamiteModule"
            java.lang.String r0 = "Failed to retrieve remote module version."
            android.util.Log.w(r14, r0)     // Catch:{ RemoteException -> 0x018a, all -> 0x0186 }
            if (r13 == 0) goto L_0x01df
            r13.close()     // Catch:{ all -> 0x01ed }
            goto L_0x01df
        L_0x0186:
            r0 = move-exception
            r14 = r0
            r4 = r13
            goto L_0x01e3
        L_0x018a:
            r0 = move-exception
            r14 = r0
            r4 = r13
            goto L_0x01b8
        L_0x018e:
            r8 = r13
            r9 = r14
            r13 = 2
            if (r0 != r13) goto L_0x01a3
            java.lang.String r13 = "DynamiteModule"
            java.lang.String r14 = "IDynamite loader version = 2, no high precision latency measurement."
            android.util.Log.w(r13, r14)     // Catch:{ RemoteException -> 0x01b5 }
            com.google.android.gms.dynamic.IObjectWrapper r13 = com.google.android.gms.dynamic.ObjectWrapper.wrap(r12)     // Catch:{ RemoteException -> 0x01b5 }
            int r5 = r6.zzh(r13, r8, r9)     // Catch:{ RemoteException -> 0x01b5 }
            goto L_0x01df
        L_0x01a3:
            java.lang.String r13 = "DynamiteModule"
            java.lang.String r14 = "IDynamite loader version < 2, falling back to getModuleVersion2"
            android.util.Log.w(r13, r14)     // Catch:{ RemoteException -> 0x01b5 }
            com.google.android.gms.dynamic.IObjectWrapper r13 = com.google.android.gms.dynamic.ObjectWrapper.wrap(r12)     // Catch:{ RemoteException -> 0x01b5 }
            int r5 = r6.zzf(r13, r8, r9)     // Catch:{ RemoteException -> 0x01b5 }
            goto L_0x01df
        L_0x01b3:
            r14 = r13
            goto L_0x01e3
        L_0x01b5:
            r0 = move-exception
            r13 = r0
            r14 = r13
        L_0x01b8:
            java.lang.String r13 = "DynamiteModule"
            java.lang.String r14 = r14.getMessage()     // Catch:{ all -> 0x01e0 }
            java.lang.String r0 = java.lang.String.valueOf(r14)     // Catch:{ all -> 0x01e0 }
            int r0 = r0.length()     // Catch:{ all -> 0x01e0 }
            int r0 = r0 + 42
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x01e0 }
            r2.<init>(r0)     // Catch:{ all -> 0x01e0 }
            r2.append(r1)     // Catch:{ all -> 0x01e0 }
            r2.append(r14)     // Catch:{ all -> 0x01e0 }
            java.lang.String r14 = r2.toString()     // Catch:{ all -> 0x01e0 }
            android.util.Log.w(r13, r14)     // Catch:{ all -> 0x01e0 }
            if (r4 == 0) goto L_0x01df
            r4.close()     // Catch:{ all -> 0x01ed }
        L_0x01df:
            return r5
        L_0x01e0:
            r0 = move-exception
            r13 = r0
            goto L_0x01b3
        L_0x01e3:
            if (r4 == 0) goto L_0x01e8
            r4.close()     // Catch:{ all -> 0x01ed }
        L_0x01e8:
            throw r14     // Catch:{ all -> 0x01ed }
        L_0x01e9:
            r0 = move-exception
            r13 = r0
            monitor-exit(r3)     // Catch:{ all -> 0x01e9 }
            throw r13     // Catch:{ all -> 0x01ed }
        L_0x01ed:
            r0 = move-exception
            r13 = r0
            com.google.android.gms.common.util.CrashUtils.addDynamiteErrorToDropBox(r12, r13)
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.dynamite.DynamiteModule.zza(android.content.Context, java.lang.String, boolean):int");
    }

    private static boolean zzb(Context context) {
        if (Boolean.TRUE.equals((Object) null) || Boolean.TRUE.equals(zzg)) {
            return true;
        }
        boolean z = false;
        if (zzg == null) {
            ProviderInfo resolveContentProvider = context.getPackageManager().resolveContentProvider("com.google.android.gms.chimera", true != PlatformVersion.isAtLeastQ() ? 0 : 268435456);
            if (GoogleApiAvailabilityLight.getInstance().isGooglePlayServicesAvailable(context, 10000000) == 0 && resolveContentProvider != null && "com.google.android.gms".equals(resolveContentProvider.packageName)) {
                z = true;
            }
            Boolean valueOf = Boolean.valueOf(z);
            zzg = valueOf;
            z = valueOf.booleanValue();
            if (z && resolveContentProvider.applicationInfo != null && (resolveContentProvider.applicationInfo.flags & 129) == 0) {
                Log.i("DynamiteModule", "Non-system-image GmsCore APK, forcing V1");
                zze = true;
            }
        }
        if (!z) {
            Log.e("DynamiteModule", "Invalid GmsCore APK, remote loading disabled.");
        }
        return z;
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0059 */
    /* JADX WARNING: Removed duplicated region for block: B:115:0x0180  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x00e5 A[SYNTHETIC, Splitter:B:59:0x00e5] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static int zzc(android.content.Context r14, java.lang.String r15, boolean r16, boolean r17) throws com.google.android.gms.dynamite.DynamiteModule.LoadingException {
        /*
            java.lang.String r1 = "V2 version check failed: "
            r2 = 0
            java.lang.ThreadLocal r0 = zzi     // Catch:{ Exception -> 0x0150, all -> 0x014d }
            java.lang.Object r0 = r0.get()     // Catch:{ Exception -> 0x0150, all -> 0x014d }
            java.lang.Long r0 = (java.lang.Long) r0     // Catch:{ Exception -> 0x0150, all -> 0x014d }
            long r3 = r0.longValue()     // Catch:{ Exception -> 0x0150, all -> 0x014d }
            java.lang.String r0 = "api_force_staging"
            java.lang.String r5 = "api"
            r6 = 1
            r7 = r16
            if (r6 == r7) goto L_0x0019
            r0 = r5
        L_0x0019:
            android.net.Uri$Builder r5 = new android.net.Uri$Builder     // Catch:{ Exception -> 0x0150, all -> 0x014d }
            r5.<init>()     // Catch:{ Exception -> 0x0150, all -> 0x014d }
            java.lang.String r7 = "content"
            android.net.Uri$Builder r5 = r5.scheme(r7)     // Catch:{ Exception -> 0x0150, all -> 0x014d }
            java.lang.String r7 = "com.google.android.gms.chimera"
            android.net.Uri$Builder r5 = r5.authority(r7)     // Catch:{ Exception -> 0x0150, all -> 0x014d }
            android.net.Uri$Builder r0 = r5.path(r0)     // Catch:{ Exception -> 0x0150, all -> 0x014d }
            android.net.Uri$Builder r0 = r0.appendPath(r15)     // Catch:{ Exception -> 0x0150, all -> 0x014d }
            java.lang.String r5 = "requestStartUptime"
            java.lang.String r3 = java.lang.String.valueOf(r3)     // Catch:{ Exception -> 0x0150, all -> 0x014d }
            android.net.Uri$Builder r0 = r0.appendQueryParameter(r5, r3)     // Catch:{ Exception -> 0x0150, all -> 0x014d }
            android.net.Uri r8 = r0.build()     // Catch:{ Exception -> 0x0150, all -> 0x014d }
            android.content.ContentResolver r14 = r14.getContentResolver()     // Catch:{ Exception -> 0x0150, all -> 0x014d }
            android.content.ContentProviderClient r7 = r14.acquireUnstableContentProviderClient(r8)     // Catch:{ Exception -> 0x0150, all -> 0x014d }
            r14 = 2
            r3 = 0
            if (r7 != 0) goto L_0x004f
        L_0x004c:
            r8 = r2
            goto L_0x00e3
        L_0x004f:
            r11 = 0
            r12 = 0
            r9 = 0
            r10 = 0
            android.database.Cursor r4 = r7.query(r8, r9, r10, r11, r12)     // Catch:{ RemoteException -> 0x0059, all -> 0x00dd }
            if (r4 != 0) goto L_0x005d
        L_0x0059:
            r7.release()     // Catch:{ Exception -> 0x0150, all -> 0x014d }
            goto L_0x004c
        L_0x005d:
            int r0 = r4.getCount()     // Catch:{ all -> 0x00d2 }
            int r5 = r4.getColumnCount()     // Catch:{ all -> 0x00d2 }
            android.database.MatrixCursor r8 = new android.database.MatrixCursor     // Catch:{ all -> 0x00d2 }
            java.lang.String[] r9 = r4.getColumnNames()     // Catch:{ all -> 0x00d2 }
            r8.<init>(r9, r0)     // Catch:{ all -> 0x00d2 }
            r9 = r3
        L_0x006f:
            if (r9 >= r0) goto L_0x00cb
            boolean r10 = r4.moveToPosition(r9)     // Catch:{ all -> 0x00d2 }
            if (r10 == 0) goto L_0x00c3
            java.lang.Object[] r10 = new java.lang.Object[r5]     // Catch:{ all -> 0x00d2 }
            r11 = r3
        L_0x007a:
            if (r11 >= r5) goto L_0x00bd
            int r12 = r4.getType(r11)     // Catch:{ all -> 0x00d2 }
            if (r12 == 0) goto L_0x00b8
            if (r12 == r6) goto L_0x00ad
            if (r12 == r14) goto L_0x00a2
            r13 = 3
            if (r12 == r13) goto L_0x009b
            r13 = 4
            if (r12 != r13) goto L_0x0093
            byte[] r12 = r4.getBlob(r11)     // Catch:{ all -> 0x00d2 }
            r10[r11] = r12     // Catch:{ all -> 0x00d2 }
            goto L_0x00ba
        L_0x0093:
            android.os.RemoteException r0 = new android.os.RemoteException     // Catch:{ all -> 0x00d2 }
            java.lang.String r5 = "Unknown column type"
            r0.<init>(r5)     // Catch:{ all -> 0x00d2 }
            throw r0     // Catch:{ all -> 0x00d2 }
        L_0x009b:
            java.lang.String r12 = r4.getString(r11)     // Catch:{ all -> 0x00d2 }
            r10[r11] = r12     // Catch:{ all -> 0x00d2 }
            goto L_0x00ba
        L_0x00a2:
            double r12 = r4.getDouble(r11)     // Catch:{ all -> 0x00d2 }
            java.lang.Double r12 = java.lang.Double.valueOf(r12)     // Catch:{ all -> 0x00d2 }
            r10[r11] = r12     // Catch:{ all -> 0x00d2 }
            goto L_0x00ba
        L_0x00ad:
            long r12 = r4.getLong(r11)     // Catch:{ all -> 0x00d2 }
            java.lang.Long r12 = java.lang.Long.valueOf(r12)     // Catch:{ all -> 0x00d2 }
            r10[r11] = r12     // Catch:{ all -> 0x00d2 }
            goto L_0x00ba
        L_0x00b8:
            r10[r11] = r2     // Catch:{ all -> 0x00d2 }
        L_0x00ba:
            int r11 = r11 + 1
            goto L_0x007a
        L_0x00bd:
            r8.addRow(r10)     // Catch:{ all -> 0x00d2 }
            int r9 = r9 + 1
            goto L_0x006f
        L_0x00c3:
            android.os.RemoteException r0 = new android.os.RemoteException     // Catch:{ all -> 0x00d2 }
            java.lang.String r5 = "Cursor read incomplete (ContentProvider dead?)"
            r0.<init>(r5)     // Catch:{ all -> 0x00d2 }
            throw r0     // Catch:{ all -> 0x00d2 }
        L_0x00cb:
            r4.close()     // Catch:{ RemoteException -> 0x0059, all -> 0x00dd }
            r7.release()     // Catch:{ Exception -> 0x0150, all -> 0x014d }
            goto L_0x00e3
        L_0x00d2:
            r0 = move-exception
            r5 = r0
            r4.close()     // Catch:{ all -> 0x00d8 }
            goto L_0x00dc
        L_0x00d8:
            r0 = move-exception
            r5.addSuppressed(r0)     // Catch:{ RemoteException -> 0x0059, all -> 0x00dd }
        L_0x00dc:
            throw r5     // Catch:{ RemoteException -> 0x0059, all -> 0x00dd }
        L_0x00dd:
            r0 = move-exception
            r14 = r0
            r7.release()     // Catch:{ Exception -> 0x0150, all -> 0x014d }
            throw r14     // Catch:{ Exception -> 0x0150, all -> 0x014d }
        L_0x00e3:
            if (r8 == 0) goto L_0x013e
            boolean r0 = r8.moveToFirst()     // Catch:{ Exception -> 0x0135 }
            if (r0 == 0) goto L_0x013e
            int r0 = r8.getInt(r3)     // Catch:{ Exception -> 0x0135 }
            if (r0 <= 0) goto L_0x0128
            java.lang.Class<com.google.android.gms.dynamite.DynamiteModule> r4 = com.google.android.gms.dynamite.DynamiteModule.class
            monitor-enter(r4)     // Catch:{ Exception -> 0x0135 }
            java.lang.String r14 = r8.getString(r14)     // Catch:{ all -> 0x0124 }
            zzd = r14     // Catch:{ all -> 0x0124 }
            java.lang.String r14 = "loaderVersion"
            int r14 = r8.getColumnIndex(r14)     // Catch:{ all -> 0x0124 }
            if (r14 < 0) goto L_0x0108
            int r14 = r8.getInt(r14)     // Catch:{ all -> 0x0124 }
            zzf = r14     // Catch:{ all -> 0x0124 }
        L_0x0108:
            java.lang.String r14 = "disableStandaloneDynamiteLoader2"
            int r14 = r8.getColumnIndex(r14)     // Catch:{ all -> 0x0124 }
            if (r14 < 0) goto L_0x011b
            int r14 = r8.getInt(r14)     // Catch:{ all -> 0x0124 }
            if (r14 == 0) goto L_0x0117
            goto L_0x0118
        L_0x0117:
            r6 = r3
        L_0x0118:
            zze = r6     // Catch:{ all -> 0x0124 }
            r3 = r6
        L_0x011b:
            monitor-exit(r4)     // Catch:{ all -> 0x0124 }
            boolean r14 = zzd(r8)     // Catch:{ Exception -> 0x0135 }
            if (r14 == 0) goto L_0x0128
            r8 = r2
            goto L_0x0128
        L_0x0124:
            r0 = move-exception
            r14 = r0
            monitor-exit(r4)     // Catch:{ all -> 0x0124 }
            throw r14     // Catch:{ Exception -> 0x0135 }
        L_0x0128:
            if (r17 == 0) goto L_0x0138
            if (r3 != 0) goto L_0x012d
            goto L_0x0138
        L_0x012d:
            com.google.android.gms.dynamite.DynamiteModule$LoadingException r14 = new com.google.android.gms.dynamite.DynamiteModule$LoadingException     // Catch:{ Exception -> 0x0135 }
            java.lang.String r0 = "forcing fallback to container DynamiteLoader impl"
            r14.<init>(r0, r2)     // Catch:{ Exception -> 0x0135 }
            throw r14     // Catch:{ Exception -> 0x0135 }
        L_0x0135:
            r0 = move-exception
            r14 = r0
            goto L_0x0153
        L_0x0138:
            if (r8 == 0) goto L_0x013d
            r8.close()
        L_0x013d:
            return r0
        L_0x013e:
            java.lang.String r14 = "DynamiteModule"
            java.lang.String r0 = "Failed to retrieve remote module version."
            android.util.Log.w(r14, r0)     // Catch:{ Exception -> 0x0135 }
            com.google.android.gms.dynamite.DynamiteModule$LoadingException r14 = new com.google.android.gms.dynamite.DynamiteModule$LoadingException     // Catch:{ Exception -> 0x0135 }
            java.lang.String r0 = "Failed to connect to dynamite module ContentResolver."
            r14.<init>(r0, r2)     // Catch:{ Exception -> 0x0135 }
            throw r14     // Catch:{ Exception -> 0x0135 }
        L_0x014d:
            r0 = move-exception
            r14 = r0
            goto L_0x017e
        L_0x0150:
            r0 = move-exception
            r14 = r0
            r8 = r2
        L_0x0153:
            boolean r0 = r14 instanceof com.google.android.gms.dynamite.DynamiteModule.LoadingException     // Catch:{ all -> 0x017b }
            if (r0 != 0) goto L_0x017a
            com.google.android.gms.dynamite.DynamiteModule$LoadingException r0 = new com.google.android.gms.dynamite.DynamiteModule$LoadingException     // Catch:{ all -> 0x017b }
            java.lang.String r3 = r14.getMessage()     // Catch:{ all -> 0x017b }
            java.lang.String r4 = java.lang.String.valueOf(r3)     // Catch:{ all -> 0x017b }
            int r4 = r4.length()     // Catch:{ all -> 0x017b }
            int r4 = r4 + 25
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x017b }
            r5.<init>(r4)     // Catch:{ all -> 0x017b }
            r5.append(r1)     // Catch:{ all -> 0x017b }
            r5.append(r3)     // Catch:{ all -> 0x017b }
            java.lang.String r1 = r5.toString()     // Catch:{ all -> 0x017b }
            r0.<init>(r1, r14, r2)     // Catch:{ all -> 0x017b }
            throw r0     // Catch:{ all -> 0x017b }
        L_0x017a:
            throw r14     // Catch:{ all -> 0x017b }
        L_0x017b:
            r0 = move-exception
            r14 = r0
            r2 = r8
        L_0x017e:
            if (r2 == 0) goto L_0x0183
            r2.close()
        L_0x0183:
            throw r14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.dynamite.DynamiteModule.zzc(android.content.Context, java.lang.String, boolean, boolean):int");
    }

    private static boolean zzd(Cursor cursor) {
        zzn zzn = (zzn) zzh.get();
        if (zzn == null || zzn.zza != null) {
            return false;
        }
        zzn.zza = cursor;
        return true;
    }

    private static DynamiteModule zze(Context context, String str) {
        String.valueOf(str);
        Log.i("DynamiteModule", "Selected local version of ".concat(String.valueOf(str)));
        return new DynamiteModule(context);
    }

    private static void zzf(ClassLoader classLoader) throws LoadingException {
        zzq zzq;
        try {
            IBinder iBinder = (IBinder) classLoader.loadClass("com.google.android.gms.dynamiteloader.DynamiteLoaderV2").getConstructor(new Class[0]).newInstance(new Object[0]);
            if (iBinder == null) {
                zzq = null;
            } else {
                IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamite.IDynamiteLoaderV2");
                if (queryLocalInterface instanceof zzq) {
                    zzq = (zzq) queryLocalInterface;
                } else {
                    zzq = new zzq(iBinder);
                }
            }
            zzm = zzq;
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e) {
            throw new LoadingException("Failed to instantiate dynamite loader", e, (byte[]) null);
        }
    }

    private static zzp zzg(Context context) {
        zzp zzp;
        synchronized (DynamiteModule.class) {
            zzp zzp2 = zzl;
            if (zzp2 != null) {
                return zzp2;
            }
            try {
                IBinder iBinder = (IBinder) context.createPackageContext("com.google.android.gms", 3).getClassLoader().loadClass("com.google.android.gms.chimera.container.DynamiteLoaderImpl").newInstance();
                if (iBinder == null) {
                    zzp = null;
                } else {
                    IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamite.IDynamiteLoader");
                    zzp = queryLocalInterface instanceof zzp ? (zzp) queryLocalInterface : new zzp(iBinder);
                }
                if (zzp != null) {
                    zzl = zzp;
                    return zzp;
                }
            } catch (Exception e) {
                String message = e.getMessage();
                StringBuilder sb = new StringBuilder(String.valueOf(message).length() + 45);
                sb.append("Failed to load IDynamiteLoader from GmsCore: ");
                sb.append(message);
                Log.e("DynamiteModule", sb.toString());
            }
        }
        return null;
    }

    public Context getModuleContext() {
        return this.zzk;
    }

    public IBinder instantiate(String str) throws LoadingException {
        try {
            return (IBinder) this.zzk.getClassLoader().loadClass(str).newInstance();
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            String.valueOf(str);
            throw new LoadingException("Failed to instantiate module class: ".concat(String.valueOf(str)), e, (byte[]) null);
        }
    }
}
