package androidx.core.provider;

import android.content.ContentProviderClient;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.Signature;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Build;
import android.os.CancellationSignal;
import android.os.RemoteException;
import android.util.Log;
import androidx.collection.LruCache;
import androidx.core.content.res.FontResourcesParserCompat;
import androidx.core.graphics.TypefaceCompat;
import androidx.core.provider.FontsContractCompat;
import androidx.tracing.Trace;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

class FontProvider {
    private static final Comparator<byte[]> sByteArrayComparator = new FontProvider$$ExternalSyntheticLambda0();
    private static final LruCache<ProviderCacheKey, ProviderInfo> sProviderCache = new LruCache<>(2);

    private FontProvider() {
    }

    static FontsContractCompat.FontFamilyResult getFontFamilyResult(Context context, List<FontRequest> list, CancellationSignal cancellationSignal) throws PackageManager.NameNotFoundException {
        String systemFont;
        Typeface systemFontFamily;
        Trace.beginSection("FontProvider.getFontFamilyResult");
        try {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < list.size(); i++) {
                FontRequest fontRequest = list.get(i);
                if (Build.VERSION.SDK_INT < 31 || (systemFontFamily = TypefaceCompat.getSystemFontFamily(systemFont)) == null || TypefaceCompat.guessPrimaryFont(systemFontFamily) == null) {
                    ProviderInfo provider = getProvider(context.getPackageManager(), fontRequest, context.getResources());
                    if (provider == null) {
                        FontsContractCompat.FontInfo[] fontInfoArr = null;
                        return FontsContractCompat.FontFamilyResult.create(1, (FontsContractCompat.FontInfo[]) null);
                    }
                    arrayList.add(query(context, fontRequest, provider.authority, cancellationSignal));
                } else {
                    arrayList.add(new FontsContractCompat.FontInfo[]{new FontsContractCompat.FontInfo((systemFont = fontRequest.getSystemFont()), fontRequest.getVariationSettings())});
                }
            }
            FontsContractCompat.FontFamilyResult create = FontsContractCompat.FontFamilyResult.create(0, (List<FontsContractCompat.FontInfo[]>) arrayList);
            Trace.endSection();
            return create;
        } finally {
            Trace.endSection();
        }
    }

    private static class ProviderCacheKey {
        String mAuthority;
        List<List<byte[]>> mCertificates;
        String mPackageName;

        ProviderCacheKey(String str, String str2, List<List<byte[]>> list) {
            this.mAuthority = str;
            this.mPackageName = str2;
            this.mCertificates = list;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ProviderCacheKey)) {
                return false;
            }
            ProviderCacheKey providerCacheKey = (ProviderCacheKey) obj;
            return Objects.equals(this.mAuthority, providerCacheKey.mAuthority) && Objects.equals(this.mPackageName, providerCacheKey.mPackageName) && Objects.equals(this.mCertificates, providerCacheKey.mCertificates);
        }

        public int hashCode() {
            return Objects.hash(new Object[]{this.mAuthority, this.mPackageName, this.mCertificates});
        }
    }

    static void clearProviderCache() {
        sProviderCache.evictAll();
    }

    static ProviderInfo getProvider(PackageManager packageManager, FontRequest fontRequest, Resources resources) throws PackageManager.NameNotFoundException {
        Trace.beginSection("FontProvider.getProvider");
        try {
            List<List<byte[]>> certificates = getCertificates(fontRequest, resources);
            ProviderCacheKey providerCacheKey = new ProviderCacheKey(fontRequest.getProviderAuthority(), fontRequest.getProviderPackage(), certificates);
            ProviderInfo providerInfo = sProviderCache.get(providerCacheKey);
            if (providerInfo != null) {
                return providerInfo;
            }
            String providerAuthority = fontRequest.getProviderAuthority();
            ProviderInfo resolveContentProvider = packageManager.resolveContentProvider(providerAuthority, 0);
            if (resolveContentProvider == null) {
                throw new PackageManager.NameNotFoundException("No package found for authority: " + providerAuthority);
            } else if (resolveContentProvider.packageName.equals(fontRequest.getProviderPackage())) {
                List<byte[]> convertToByteArrayList = convertToByteArrayList(packageManager.getPackageInfo(resolveContentProvider.packageName, 64).signatures);
                Collections.sort(convertToByteArrayList, sByteArrayComparator);
                for (int i = 0; i < certificates.size(); i++) {
                    ArrayList arrayList = new ArrayList(certificates.get(i));
                    Collections.sort(arrayList, sByteArrayComparator);
                    if (equalsByteArrayList(convertToByteArrayList, arrayList)) {
                        sProviderCache.put(providerCacheKey, resolveContentProvider);
                        Trace.endSection();
                        return resolveContentProvider;
                    }
                }
                Trace.endSection();
                return null;
            } else {
                throw new PackageManager.NameNotFoundException("Found content provider " + providerAuthority + ", but package was not " + fontRequest.getProviderPackage());
            }
        } finally {
            Trace.endSection();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:52:0x0114 A[SYNTHETIC, Splitter:B:52:0x0114] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static androidx.core.provider.FontsContractCompat.FontInfo[] query(android.content.Context r17, androidx.core.provider.FontRequest r18, java.lang.String r19, android.os.CancellationSignal r20) {
        /*
            r0 = r19
            java.lang.String r1 = "result_code"
            java.lang.String r2 = "font_italic"
            java.lang.String r3 = "font_weight"
            java.lang.String r4 = "font_ttc_index"
            java.lang.String r5 = "file_id"
            java.lang.String r6 = "_id"
            java.lang.String r7 = "content"
            java.lang.String r8 = "FontProvider.query"
            androidx.tracing.Trace.beginSection(r8)
            java.util.ArrayList r8 = new java.util.ArrayList     // Catch:{ all -> 0x011b }
            r8.<init>()     // Catch:{ all -> 0x011b }
            android.net.Uri$Builder r9 = new android.net.Uri$Builder     // Catch:{ all -> 0x011b }
            r9.<init>()     // Catch:{ all -> 0x011b }
            android.net.Uri$Builder r9 = r9.scheme(r7)     // Catch:{ all -> 0x011b }
            android.net.Uri$Builder r9 = r9.authority(r0)     // Catch:{ all -> 0x011b }
            android.net.Uri r11 = r9.build()     // Catch:{ all -> 0x011b }
            android.net.Uri$Builder r9 = new android.net.Uri$Builder     // Catch:{ all -> 0x011b }
            r9.<init>()     // Catch:{ all -> 0x011b }
            android.net.Uri$Builder r7 = r9.scheme(r7)     // Catch:{ all -> 0x011b }
            android.net.Uri$Builder r0 = r7.authority(r0)     // Catch:{ all -> 0x011b }
            java.lang.String r7 = "file"
            android.net.Uri$Builder r0 = r0.appendPath(r7)     // Catch:{ all -> 0x011b }
            android.net.Uri r0 = r0.build()     // Catch:{ all -> 0x011b }
            r7 = r17
            androidx.core.provider.FontProvider$ContentQueryWrapper r10 = androidx.core.provider.FontProvider.ContentQueryWrapper.make(r7, r11)     // Catch:{ all -> 0x011b }
            r7 = 7
            java.lang.String[] r12 = new java.lang.String[r7]     // Catch:{ all -> 0x0110 }
            r7 = 0
            r12[r7] = r6     // Catch:{ all -> 0x0110 }
            r13 = 1
            r12[r13] = r5     // Catch:{ all -> 0x0110 }
            r14 = 2
            r12[r14] = r4     // Catch:{ all -> 0x0110 }
            java.lang.String r14 = "font_variation_settings"
            r15 = 3
            r12[r15] = r14     // Catch:{ all -> 0x0110 }
            r14 = 4
            r12[r14] = r3     // Catch:{ all -> 0x0110 }
            r14 = 5
            r12[r14] = r2     // Catch:{ all -> 0x0110 }
            r14 = 6
            r12[r14] = r1     // Catch:{ all -> 0x0110 }
            java.lang.String r14 = "ContentQueryWrapper.query"
            androidx.tracing.Trace.beginSection(r14)     // Catch:{ all -> 0x0110 }
            java.lang.String r14 = "query = ?"
            r15 = r14
            java.lang.String[] r14 = new java.lang.String[r13]     // Catch:{ all -> 0x010b }
            java.lang.String r16 = r18.getQuery()     // Catch:{ all -> 0x010b }
            r14[r7] = r16     // Catch:{ all -> 0x010b }
            r16 = r13
            r13 = r15
            r15 = 0
            r9 = r16
            r16 = r20
            android.database.Cursor r12 = r10.query(r11, r12, r13, r14, r15, r16)     // Catch:{ all -> 0x010b }
            androidx.tracing.Trace.endSection()     // Catch:{ all -> 0x0108 }
            if (r12 == 0) goto L_0x00f3
            int r13 = r12.getCount()     // Catch:{ all -> 0x0108 }
            if (r13 <= 0) goto L_0x00f3
            int r1 = r12.getColumnIndex(r1)     // Catch:{ all -> 0x0108 }
            java.util.ArrayList r8 = new java.util.ArrayList     // Catch:{ all -> 0x0108 }
            r8.<init>()     // Catch:{ all -> 0x0108 }
            int r6 = r12.getColumnIndex(r6)     // Catch:{ all -> 0x0108 }
            int r5 = r12.getColumnIndex(r5)     // Catch:{ all -> 0x0108 }
            int r4 = r12.getColumnIndex(r4)     // Catch:{ all -> 0x0108 }
            int r3 = r12.getColumnIndex(r3)     // Catch:{ all -> 0x0108 }
            int r2 = r12.getColumnIndex(r2)     // Catch:{ all -> 0x0108 }
        L_0x00a6:
            boolean r13 = r12.moveToNext()     // Catch:{ all -> 0x0108 }
            if (r13 == 0) goto L_0x00f3
            r13 = -1
            if (r1 == r13) goto L_0x00b4
            int r14 = r12.getInt(r1)     // Catch:{ all -> 0x0108 }
            goto L_0x00b5
        L_0x00b4:
            r14 = r7
        L_0x00b5:
            if (r4 == r13) goto L_0x00bc
            int r15 = r12.getInt(r4)     // Catch:{ all -> 0x0108 }
            goto L_0x00bd
        L_0x00bc:
            r15 = r7
        L_0x00bd:
            if (r5 != r13) goto L_0x00ca
            r17 = r8
            long r7 = r12.getLong(r6)     // Catch:{ all -> 0x0108 }
            android.net.Uri r7 = android.content.ContentUris.withAppendedId(r11, r7)     // Catch:{ all -> 0x0108 }
            goto L_0x00d4
        L_0x00ca:
            r17 = r8
            long r7 = r12.getLong(r5)     // Catch:{ all -> 0x0108 }
            android.net.Uri r7 = android.content.ContentUris.withAppendedId(r0, r7)     // Catch:{ all -> 0x0108 }
        L_0x00d4:
            if (r3 == r13) goto L_0x00db
            int r8 = r12.getInt(r3)     // Catch:{ all -> 0x0108 }
            goto L_0x00dd
        L_0x00db:
            r8 = 400(0x190, float:5.6E-43)
        L_0x00dd:
            if (r2 == r13) goto L_0x00e7
            int r13 = r12.getInt(r2)     // Catch:{ all -> 0x0108 }
            if (r13 != r9) goto L_0x00e7
            r13 = r9
            goto L_0x00e8
        L_0x00e7:
            r13 = 0
        L_0x00e8:
            androidx.core.provider.FontsContractCompat$FontInfo r7 = androidx.core.provider.FontsContractCompat.FontInfo.create(r7, r15, r8, r13, r14)     // Catch:{ all -> 0x0108 }
            r8 = r17
            r8.add(r7)     // Catch:{ all -> 0x0108 }
            r7 = 0
            goto L_0x00a6
        L_0x00f3:
            if (r12 == 0) goto L_0x00f8
            r12.close()     // Catch:{ all -> 0x011b }
        L_0x00f8:
            r10.close()     // Catch:{ all -> 0x011b }
            r0 = 0
            androidx.core.provider.FontsContractCompat$FontInfo[] r0 = new androidx.core.provider.FontsContractCompat.FontInfo[r0]     // Catch:{ all -> 0x011b }
            java.lang.Object[] r0 = r8.toArray(r0)     // Catch:{ all -> 0x011b }
            androidx.core.provider.FontsContractCompat$FontInfo[] r0 = (androidx.core.provider.FontsContractCompat.FontInfo[]) r0     // Catch:{ all -> 0x011b }
            androidx.tracing.Trace.endSection()
            return r0
        L_0x0108:
            r0 = move-exception
            r9 = r12
            goto L_0x0112
        L_0x010b:
            r0 = move-exception
            androidx.tracing.Trace.endSection()     // Catch:{ all -> 0x0110 }
            throw r0     // Catch:{ all -> 0x0110 }
        L_0x0110:
            r0 = move-exception
            r9 = 0
        L_0x0112:
            if (r9 == 0) goto L_0x0117
            r9.close()     // Catch:{ all -> 0x011b }
        L_0x0117:
            r10.close()     // Catch:{ all -> 0x011b }
            throw r0     // Catch:{ all -> 0x011b }
        L_0x011b:
            r0 = move-exception
            androidx.tracing.Trace.endSection()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.provider.FontProvider.query(android.content.Context, androidx.core.provider.FontRequest, java.lang.String, android.os.CancellationSignal):androidx.core.provider.FontsContractCompat$FontInfo[]");
    }

    private static List<List<byte[]>> getCertificates(FontRequest fontRequest, Resources resources) {
        if (fontRequest.getCertificates() != null) {
            return fontRequest.getCertificates();
        }
        return FontResourcesParserCompat.readCerts(resources, fontRequest.getCertificatesArrayResId());
    }

    static /* synthetic */ int lambda$static$0(byte[] bArr, byte[] bArr2) {
        if (bArr.length != bArr2.length) {
            return bArr.length - bArr2.length;
        }
        for (int i = 0; i < bArr.length; i++) {
            byte b = bArr[i];
            byte b2 = bArr2[i];
            if (b != b2) {
                return b - b2;
            }
        }
        return 0;
    }

    private static boolean equalsByteArrayList(List<byte[]> list, List<byte[]> list2) {
        if (list.size() != list2.size()) {
            return false;
        }
        for (int i = 0; i < list.size(); i++) {
            if (!Arrays.equals(list.get(i), list2.get(i))) {
                return false;
            }
        }
        return true;
    }

    private static List<byte[]> convertToByteArrayList(Signature[] signatureArr) {
        ArrayList arrayList = new ArrayList();
        for (Signature byteArray : signatureArr) {
            arrayList.add(byteArray.toByteArray());
        }
        return arrayList;
    }

    private interface ContentQueryWrapper {
        void close();

        Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2, CancellationSignal cancellationSignal);

        static ContentQueryWrapper make(Context context, Uri uri) {
            return new ContentQueryWrapperApi24Impl(context, uri);
        }
    }

    private static class ContentQueryWrapperApi16Impl implements ContentQueryWrapper {
        private final ContentProviderClient mClient;

        ContentQueryWrapperApi16Impl(Context context, Uri uri) {
            this.mClient = context.getContentResolver().acquireUnstableContentProviderClient(uri);
        }

        public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2, CancellationSignal cancellationSignal) {
            ContentProviderClient contentProviderClient = this.mClient;
            if (contentProviderClient == null) {
                return null;
            }
            try {
                return contentProviderClient.query(uri, strArr, str, strArr2, str2, cancellationSignal);
            } catch (RemoteException e) {
                Log.w("FontsProvider", "Unable to query the content provider", e);
                return null;
            }
        }

        public void close() {
            ContentProviderClient contentProviderClient = this.mClient;
            if (contentProviderClient != null) {
                contentProviderClient.release();
            }
        }
    }

    private static class ContentQueryWrapperApi24Impl implements ContentQueryWrapper {
        private final ContentProviderClient mClient;

        ContentQueryWrapperApi24Impl(Context context, Uri uri) {
            this.mClient = context.getContentResolver().acquireUnstableContentProviderClient(uri);
        }

        public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2, CancellationSignal cancellationSignal) {
            ContentProviderClient contentProviderClient = this.mClient;
            if (contentProviderClient == null) {
                return null;
            }
            try {
                return contentProviderClient.query(uri, strArr, str, strArr2, str2, cancellationSignal);
            } catch (RemoteException e) {
                Log.w("FontsProvider", "Unable to query the content provider", e);
                return null;
            }
        }

        public void close() {
            ContentProviderClient contentProviderClient = this.mClient;
            if (contentProviderClient != null) {
                contentProviderClient.close();
            }
        }
    }
}
