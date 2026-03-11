package com.armmc.app;

import android.content.Context;
import android.os.Build;
import android.util.Log;
import androidx.credentials.exceptions.publickeycredential.DomExceptionUtils;
import com.google.android.play.core.splitcompat.SplitCompat;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u0007J\u0010\u0010\n\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u0007J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u0007J\u0018\u0010\r\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u0007J\u0006\u0010\u000e\u001a\u00020\u0007J\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00070\u0010R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/armmc/app/LibraryManager;", "", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "getLibraryPathForModule", "", "moduleName", "libraryFileName", "getLibraryName", "loadLibraryFromModule", "", "isLibraryAvailable", "getPrimaryAbi", "getSupportedAbis", "", "Companion", "app_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* compiled from: LibraryManager.kt */
public final class LibraryManager {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String TAG = "LibraryManager";
    private final Context context;

    public LibraryManager(Context context2) {
        Intrinsics.checkNotNullParameter(context2, "context");
        this.context = context2;
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/armmc/app/LibraryManager$Companion;", "", "<init>", "()V", "TAG", "", "app_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* compiled from: LibraryManager.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public static /* synthetic */ String getLibraryPathForModule$default(LibraryManager libraryManager, String str, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = "libpumpkin.so";
        }
        return libraryManager.getLibraryPathForModule(str, str2);
    }

    public final String getLibraryPathForModule(String str, String str2) {
        String str3 = str;
        String str4 = str2;
        Intrinsics.checkNotNullParameter(str3, PumpkinService.EXTRA_MODULE_NAME);
        Intrinsics.checkNotNullParameter(str4, "libraryFileName");
        SplitCompat.installActivity(this.context);
        String[] strArr = Build.SUPPORTED_ABIS;
        Intrinsics.checkNotNullExpressionValue(strArr, "SUPPORTED_ABIS");
        String str5 = (String) ArraysKt.firstOrNull((T[]) (Object[]) strArr);
        if (str5 == null) {
            str5 = "arm64-v8a";
        }
        String str6 = str5;
        Log.d(TAG, "Looking for library in module '" + str3 + "' for ABI: " + str6);
        File file = new File(this.context.getApplicationInfo().nativeLibraryDir, str4);
        if (file.exists()) {
            Log.d(TAG, "Found library at: " + file.getAbsolutePath());
            return file.getAbsolutePath();
        }
        String[] strArr2 = this.context.getApplicationInfo().splitSourceDirs;
        if (strArr2 != null) {
            Iterator it = ArrayIteratorKt.iterator(strArr2);
            while (it.hasNext()) {
                String str7 = (String) it.next();
                Log.d(TAG, "Checking split source: " + str7);
                Intrinsics.checkNotNull(str7);
                String str8 = str7;
                Iterator it2 = it;
                CharSequence charSequence = str7;
                if (StringsKt.contains$default(charSequence, (CharSequence) StringsKt.replace$default(str3, "-", "_", false, 4, (Object) null), false, 2, (Object) null) || StringsKt.contains$default(charSequence, (CharSequence) str, false, 2, (Object) null)) {
                    File file2 = new File(StringsKt.replace$default(str8, ".apk", "/lib/" + str6 + DomExceptionUtils.SEPARATOR + str4, false, 4, (Object) null));
                    if (file2.exists()) {
                        Log.d(TAG, "Found library in split at: " + file2.getAbsolutePath());
                        return file2.getAbsolutePath();
                    }
                }
                str3 = str;
                it = it2;
            }
        }
        String str9 = this.context.getApplicationInfo().nativeLibraryDir;
        String parent = this.context.getFilesDir().getParent();
        File codeCacheDir = this.context.getCodeCacheDir();
        String str10 = str;
        for (String str11 : CollectionsKt.listOf(str9 + DomExceptionUtils.SEPARATOR + str4, parent + "/lib/" + str6 + DomExceptionUtils.SEPARATOR + str4, codeCacheDir + "/splitcompat/" + StringsKt.replace$default(str10, "-", "_", false, 4, (Object) null) + "/native-libraries/" + str6 + DomExceptionUtils.SEPARATOR + str4)) {
            File file3 = new File(str11);
            Log.d(TAG, "Checking path: " + str11 + ", exists: " + file3.exists());
            if (file3.exists()) {
                return str11;
            }
        }
        Log.w(TAG, "Library not found for module: " + str10);
        return null;
    }

    public static /* synthetic */ String getLibraryName$default(LibraryManager libraryManager, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = "libpumpkin.so";
        }
        return libraryManager.getLibraryName(str);
    }

    public final String getLibraryName(String str) {
        Intrinsics.checkNotNullParameter(str, "libraryFileName");
        return StringsKt.removeSuffix(StringsKt.removePrefix(str, (CharSequence) "lib"), (CharSequence) ".so");
    }

    public static /* synthetic */ boolean loadLibraryFromModule$default(LibraryManager libraryManager, String str, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = "libpumpkin.so";
        }
        return libraryManager.loadLibraryFromModule(str, str2);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:?, code lost:
        android.util.Log.d(TAG, "System.loadLibrary failed, trying explicit path", r5);
        r9 = getLibraryPathForModule(r8, r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0042, code lost:
        if (r9 != null) goto L_0x0044;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0044, code lost:
        android.util.Log.d(TAG, "Loading library from path: " + r9);
        java.lang.System.load(r9);
        android.util.Log.d(TAG, "Library loaded successfully from path");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x005e, code lost:
        android.util.Log.e(TAG, "Could not find library path for module: " + r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x006f, code lost:
        r9 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0070, code lost:
        android.util.Log.e(TAG, "Error loading library from module: " + r8, r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:?, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0036, code lost:
        r5 = move-exception;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x006f A[ExcHandler: Exception (r9v3 'e' java.lang.Exception A[CUSTOM_DECLARE]), Splitter:B:1:0x0018] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean loadLibraryFromModule(java.lang.String r8, java.lang.String r9) {
        /*
            r7 = this;
            java.lang.String r0 = "LibraryManager"
            java.lang.String r1 = "Loading library from path: "
            java.lang.String r2 = "Could not find library path for module: "
            java.lang.String r3 = "Attempting to load library: "
            java.lang.String r4 = "moduleName"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r4)
            java.lang.String r4 = "libraryFileName"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r4)
            android.content.Context r4 = r7.context
            com.google.android.play.core.splitcompat.SplitCompat.installActivity(r4)
            r4 = 0
            java.lang.String r5 = r7.getLibraryName(r9)     // Catch:{ UnsatisfiedLinkError -> 0x0085, Exception -> 0x006f }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ UnsatisfiedLinkError -> 0x0085, Exception -> 0x006f }
            r6.<init>(r3)     // Catch:{ UnsatisfiedLinkError -> 0x0085, Exception -> 0x006f }
            java.lang.StringBuilder r3 = r6.append(r5)     // Catch:{ UnsatisfiedLinkError -> 0x0085, Exception -> 0x006f }
            java.lang.String r3 = r3.toString()     // Catch:{ UnsatisfiedLinkError -> 0x0085, Exception -> 0x006f }
            android.util.Log.d(r0, r3)     // Catch:{ UnsatisfiedLinkError -> 0x0085, Exception -> 0x006f }
            r3 = 1
            java.lang.System.loadLibrary(r5)     // Catch:{ UnsatisfiedLinkError -> 0x0036, Exception -> 0x006f }
            java.lang.String r5 = "Library loaded successfully via System.loadLibrary"
            android.util.Log.d(r0, r5)     // Catch:{ UnsatisfiedLinkError -> 0x0036, Exception -> 0x006f }
            return r3
        L_0x0036:
            r5 = move-exception
            java.lang.String r6 = "System.loadLibrary failed, trying explicit path"
            java.lang.Throwable r5 = (java.lang.Throwable) r5     // Catch:{ UnsatisfiedLinkError -> 0x0085, Exception -> 0x006f }
            android.util.Log.d(r0, r6, r5)     // Catch:{ UnsatisfiedLinkError -> 0x0085, Exception -> 0x006f }
            java.lang.String r9 = r7.getLibraryPathForModule(r8, r9)     // Catch:{ UnsatisfiedLinkError -> 0x0085, Exception -> 0x006f }
            if (r9 == 0) goto L_0x005e
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ UnsatisfiedLinkError -> 0x0085, Exception -> 0x006f }
            r2.<init>(r1)     // Catch:{ UnsatisfiedLinkError -> 0x0085, Exception -> 0x006f }
            java.lang.StringBuilder r1 = r2.append(r9)     // Catch:{ UnsatisfiedLinkError -> 0x0085, Exception -> 0x006f }
            java.lang.String r1 = r1.toString()     // Catch:{ UnsatisfiedLinkError -> 0x0085, Exception -> 0x006f }
            android.util.Log.d(r0, r1)     // Catch:{ UnsatisfiedLinkError -> 0x0085, Exception -> 0x006f }
            java.lang.System.load(r9)     // Catch:{ UnsatisfiedLinkError -> 0x0085, Exception -> 0x006f }
            java.lang.String r9 = "Library loaded successfully from path"
            android.util.Log.d(r0, r9)     // Catch:{ UnsatisfiedLinkError -> 0x0085, Exception -> 0x006f }
            r4 = r3
            goto L_0x009a
        L_0x005e:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ UnsatisfiedLinkError -> 0x0085, Exception -> 0x006f }
            r9.<init>(r2)     // Catch:{ UnsatisfiedLinkError -> 0x0085, Exception -> 0x006f }
            java.lang.StringBuilder r9 = r9.append(r8)     // Catch:{ UnsatisfiedLinkError -> 0x0085, Exception -> 0x006f }
            java.lang.String r9 = r9.toString()     // Catch:{ UnsatisfiedLinkError -> 0x0085, Exception -> 0x006f }
            android.util.Log.e(r0, r9)     // Catch:{ UnsatisfiedLinkError -> 0x0085, Exception -> 0x006f }
            goto L_0x009a
        L_0x006f:
            r9 = move-exception
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "Error loading library from module: "
            r1.<init>(r2)
            java.lang.StringBuilder r8 = r1.append(r8)
            java.lang.String r8 = r8.toString()
            java.lang.Throwable r9 = (java.lang.Throwable) r9
            android.util.Log.e(r0, r8, r9)
            goto L_0x009a
        L_0x0085:
            r9 = move-exception
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "Failed to load library from module: "
            r1.<init>(r2)
            java.lang.StringBuilder r8 = r1.append(r8)
            java.lang.String r8 = r8.toString()
            java.lang.Throwable r9 = (java.lang.Throwable) r9
            android.util.Log.e(r0, r8, r9)
        L_0x009a:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.armmc.app.LibraryManager.loadLibraryFromModule(java.lang.String, java.lang.String):boolean");
    }

    public static /* synthetic */ boolean isLibraryAvailable$default(LibraryManager libraryManager, String str, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = "libpumpkin.so";
        }
        return libraryManager.isLibraryAvailable(str, str2);
    }

    public final boolean isLibraryAvailable(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, PumpkinService.EXTRA_MODULE_NAME);
        Intrinsics.checkNotNullParameter(str2, "libraryFileName");
        return getLibraryPathForModule(str, str2) != null;
    }

    public final String getPrimaryAbi() {
        String[] strArr = Build.SUPPORTED_ABIS;
        Intrinsics.checkNotNullExpressionValue(strArr, "SUPPORTED_ABIS");
        String str = (String) ArraysKt.firstOrNull((T[]) (Object[]) strArr);
        return str == null ? "arm64-v8a" : str;
    }

    public final List<String> getSupportedAbis() {
        String[] strArr = Build.SUPPORTED_ABIS;
        Intrinsics.checkNotNullExpressionValue(strArr, "SUPPORTED_ABIS");
        return ArraysKt.toList((T[]) (Object[]) strArr);
    }
}
