package com.google.android.gms.common.internal;

import java.util.concurrent.ConcurrentHashMap;

@Deprecated
/* compiled from: com.google.android.gms:play-services-basement@@18.8.0 */
public class LibraryVersion {
    private static final GmsLogger zza = new GmsLogger("LibraryVersion", "");
    private static final LibraryVersion zzb = new LibraryVersion();
    private final ConcurrentHashMap zzc = new ConcurrentHashMap();

    protected LibraryVersion() {
    }

    public static LibraryVersion getInstance() {
        return zzb;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v1, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v2, resolved type: java.io.Closeable} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v3, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v4, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v6, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v3, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v7, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v5, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v8, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v9, resolved type: java.io.Closeable} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v11, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v12, resolved type: java.io.Closeable} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v13, resolved type: java.lang.String} */
    /* JADX WARNING: type inference failed for: r5v1, types: [java.io.Closeable] */
    /* JADX WARNING: Failed to insert additional move for type inference */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x00b2  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x00b7  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00c8  */
    @java.lang.Deprecated
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String getVersion(java.lang.String r9) {
        /*
            r8 = this;
            java.lang.String r0 = "LibraryVersion"
            java.lang.String r1 = "Please provide a valid libraryName"
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r9, r1)
            java.lang.String r1 = " version is "
            java.lang.String r2 = "Failed to get app version for libraryName: "
            java.util.concurrent.ConcurrentHashMap r3 = r8.zzc
            boolean r4 = r3.containsKey(r9)
            if (r4 == 0) goto L_0x001a
            java.lang.Object r9 = r3.get(r9)
            java.lang.String r9 = (java.lang.String) r9
            return r9
        L_0x001a:
            java.util.Properties r3 = new java.util.Properties
            r3.<init>()
            r4 = 0
            java.lang.String r5 = "/%s.properties"
            java.lang.Object[] r6 = new java.lang.Object[]{r9}     // Catch:{ IOException -> 0x008e }
            java.lang.String r5 = java.lang.String.format(r5, r6)     // Catch:{ IOException -> 0x008e }
            java.lang.Class<com.google.android.gms.common.internal.LibraryVersion> r6 = com.google.android.gms.common.internal.LibraryVersion.class
            java.io.InputStream r5 = r6.getResourceAsStream(r5)     // Catch:{ IOException -> 0x008e }
            if (r5 == 0) goto L_0x0066
            r3.load(r5)     // Catch:{ IOException -> 0x0088, all -> 0x0085 }
            java.lang.String r6 = "version"
            java.lang.String r4 = r3.getProperty(r6, r4)     // Catch:{ IOException -> 0x0088, all -> 0x0085 }
            com.google.android.gms.common.internal.GmsLogger r3 = zza     // Catch:{ IOException -> 0x0088, all -> 0x0085 }
            java.lang.String r6 = java.lang.String.valueOf(r9)     // Catch:{ IOException -> 0x0088, all -> 0x0085 }
            int r6 = r6.length()     // Catch:{ IOException -> 0x0088, all -> 0x0085 }
            int r6 = r6 + 12
            java.lang.String r7 = java.lang.String.valueOf(r4)     // Catch:{ IOException -> 0x0088, all -> 0x0085 }
            int r7 = r7.length()     // Catch:{ IOException -> 0x0088, all -> 0x0085 }
            int r6 = r6 + r7
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0088, all -> 0x0085 }
            r7.<init>(r6)     // Catch:{ IOException -> 0x0088, all -> 0x0085 }
            r7.append(r9)     // Catch:{ IOException -> 0x0088, all -> 0x0085 }
            r7.append(r1)     // Catch:{ IOException -> 0x0088, all -> 0x0085 }
            r7.append(r4)     // Catch:{ IOException -> 0x0088, all -> 0x0085 }
            java.lang.String r1 = r7.toString()     // Catch:{ IOException -> 0x0088, all -> 0x0085 }
            r3.v(r0, r1)     // Catch:{ IOException -> 0x0088, all -> 0x0085 }
            goto L_0x00b0
        L_0x0066:
            com.google.android.gms.common.internal.GmsLogger r1 = zza     // Catch:{ IOException -> 0x0088, all -> 0x0085 }
            java.lang.String r3 = java.lang.String.valueOf(r9)     // Catch:{ IOException -> 0x0088, all -> 0x0085 }
            int r3 = r3.length()     // Catch:{ IOException -> 0x0088, all -> 0x0085 }
            int r3 = r3 + 43
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0088, all -> 0x0085 }
            r6.<init>(r3)     // Catch:{ IOException -> 0x0088, all -> 0x0085 }
            r6.append(r2)     // Catch:{ IOException -> 0x0088, all -> 0x0085 }
            r6.append(r9)     // Catch:{ IOException -> 0x0088, all -> 0x0085 }
            java.lang.String r3 = r6.toString()     // Catch:{ IOException -> 0x0088, all -> 0x0085 }
            r1.w(r0, r3)     // Catch:{ IOException -> 0x0088, all -> 0x0085 }
            goto L_0x00b0
        L_0x0085:
            r9 = move-exception
            r4 = r5
            goto L_0x00c6
        L_0x0088:
            r1 = move-exception
            r3 = r4
            r4 = r5
            goto L_0x0090
        L_0x008c:
            r9 = move-exception
            goto L_0x00c6
        L_0x008e:
            r1 = move-exception
            r3 = r4
        L_0x0090:
            com.google.android.gms.common.internal.GmsLogger r5 = zza     // Catch:{ all -> 0x008c }
            java.lang.String r6 = java.lang.String.valueOf(r9)     // Catch:{ all -> 0x008c }
            int r6 = r6.length()     // Catch:{ all -> 0x008c }
            int r6 = r6 + 43
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x008c }
            r7.<init>(r6)     // Catch:{ all -> 0x008c }
            r7.append(r2)     // Catch:{ all -> 0x008c }
            r7.append(r9)     // Catch:{ all -> 0x008c }
            java.lang.String r2 = r7.toString()     // Catch:{ all -> 0x008c }
            r5.e(r0, r2, r1)     // Catch:{ all -> 0x008c }
            r5 = r4
            r4 = r3
        L_0x00b0:
            if (r5 == 0) goto L_0x00b5
            com.google.android.gms.common.util.IOUtils.closeQuietly((java.io.Closeable) r5)
        L_0x00b5:
            if (r4 != 0) goto L_0x00c0
            com.google.android.gms.common.internal.GmsLogger r1 = zza
            java.lang.String r2 = ".properties file is dropped during release process. Failure to read app version is expected during Google internal testing where locally-built libraries are used"
            r1.d(r0, r2)
            java.lang.String r4 = "UNKNOWN"
        L_0x00c0:
            java.util.concurrent.ConcurrentHashMap r0 = r8.zzc
            r0.put(r9, r4)
            return r4
        L_0x00c6:
            if (r4 == 0) goto L_0x00cb
            com.google.android.gms.common.util.IOUtils.closeQuietly((java.io.Closeable) r4)
        L_0x00cb:
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.internal.LibraryVersion.getVersion(java.lang.String):java.lang.String");
    }
}
