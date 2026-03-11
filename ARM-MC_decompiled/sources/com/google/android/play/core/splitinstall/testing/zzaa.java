package com.google.android.play.core.splitinstall.testing;

import com.google.android.play.core.splitinstall.internal.zzu;
import com.google.android.play.core.splitinstall.model.zza;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* compiled from: com.google.android.play:feature-delivery@@2.1.0 */
public final class zzaa {
    private static final zzu zza = new zzu("LocalTestingConfigParser");
    private final XmlPullParser zzb;
    private final zzu zzc = zzv.zzc();

    zzaa(XmlPullParser xmlPullParser) {
        this.zzb = xmlPullParser;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(2:18|19) */
    /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
        throw r0;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:18:0x0056 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.android.play.core.splitinstall.testing.zzv zza(java.io.File r7) {
        /*
            java.io.File r0 = new java.io.File
            java.lang.String r1 = "local_testing_config.xml"
            r0.<init>(r7, r1)
            boolean r7 = r0.exists()
            if (r7 != 0) goto L_0x0010
            com.google.android.play.core.splitinstall.testing.zzv r7 = com.google.android.play.core.splitinstall.testing.zzv.zza
            return r7
        L_0x0010:
            java.io.FileReader r7 = new java.io.FileReader     // Catch:{ IOException -> 0x005b, XmlPullParserException -> 0x0059, RuntimeException -> 0x0057 }
            r7.<init>(r0)     // Catch:{ IOException -> 0x005b, XmlPullParserException -> 0x0059, RuntimeException -> 0x0057 }
            org.xmlpull.v1.XmlPullParserFactory r0 = org.xmlpull.v1.XmlPullParserFactory.newInstance()     // Catch:{ all -> 0x0039 }
            org.xmlpull.v1.XmlPullParser r0 = r0.newPullParser()     // Catch:{ all -> 0x0039 }
            r0.setInput(r7)     // Catch:{ all -> 0x0039 }
            com.google.android.play.core.splitinstall.testing.zzaa r2 = new com.google.android.play.core.splitinstall.testing.zzaa     // Catch:{ all -> 0x0039 }
            r2.<init>(r0)     // Catch:{ all -> 0x0039 }
            java.lang.String r0 = "local-testing-config"
            com.google.android.play.core.splitinstall.testing.zzy r3 = new com.google.android.play.core.splitinstall.testing.zzy     // Catch:{ all -> 0x0039 }
            r3.<init>(r2)     // Catch:{ all -> 0x0039 }
            r2.zze(r0, r3)     // Catch:{ all -> 0x0039 }
            com.google.android.play.core.splitinstall.testing.zzu r0 = r2.zzc     // Catch:{ all -> 0x0039 }
            com.google.android.play.core.splitinstall.testing.zzv r0 = r0.zze()     // Catch:{ all -> 0x0039 }
            r7.close()     // Catch:{ IOException -> 0x005b, XmlPullParserException -> 0x0059, RuntimeException -> 0x0057 }
            return r0
        L_0x0039:
            r0 = move-exception
            r7.close()     // Catch:{ all -> 0x003e }
            goto L_0x0056
        L_0x003e:
            r7 = move-exception
            java.lang.Class<java.lang.Throwable> r2 = java.lang.Throwable.class
            java.lang.String r3 = "addSuppressed"
            r4 = 1
            java.lang.Class[] r4 = new java.lang.Class[r4]     // Catch:{ Exception -> 0x0056 }
            java.lang.Class<java.lang.Throwable> r5 = java.lang.Throwable.class
            r6 = 0
            r4[r6] = r5     // Catch:{ Exception -> 0x0056 }
            java.lang.reflect.Method r2 = r2.getDeclaredMethod(r3, r4)     // Catch:{ Exception -> 0x0056 }
            java.lang.Object[] r7 = new java.lang.Object[]{r7}     // Catch:{ Exception -> 0x0056 }
            r2.invoke(r0, r7)     // Catch:{ Exception -> 0x0056 }
        L_0x0056:
            throw r0     // Catch:{ IOException -> 0x005b, XmlPullParserException -> 0x0059, RuntimeException -> 0x0057 }
        L_0x0057:
            r7 = move-exception
            goto L_0x005c
        L_0x0059:
            r7 = move-exception
            goto L_0x005c
        L_0x005b:
            r7 = move-exception
        L_0x005c:
            com.google.android.play.core.splitinstall.internal.zzu r0 = zza
            java.lang.String r7 = r7.getMessage()
            java.lang.Object[] r7 = new java.lang.Object[]{r1, r7}
            java.lang.String r1 = "%s can not be parsed, using default. Error: %s"
            r0.zze(r1, r7)
            com.google.android.play.core.splitinstall.testing.zzv r7 = com.google.android.play.core.splitinstall.testing.zzv.zza
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.play.core.splitinstall.testing.zzaa.zza(java.io.File):com.google.android.play.core.splitinstall.testing.zzv");
    }

    public static /* synthetic */ void zzb(zzaa zzaa) {
        for (int i = 0; i < zzaa.zzb.getAttributeCount(); i++) {
            if ("defaultErrorCode".equals(zzaa.zzb.getAttributeName(i))) {
                zzaa.zzc.zza(zza.zza(zzaa.zzb.getAttributeValue(i)));
            }
        }
        zzaa.zze("split-install-error", new zzw(zzaa));
    }

    public static /* synthetic */ void zzc(zzaa zzaa) {
        String str = null;
        String str2 = null;
        for (int i = 0; i < zzaa.zzb.getAttributeCount(); i++) {
            if ("module".equals(zzaa.zzb.getAttributeName(i))) {
                str = zzaa.zzb.getAttributeValue(i);
            }
            if ("errorCode".equals(zzaa.zzb.getAttributeName(i))) {
                str2 = zzaa.zzb.getAttributeValue(i);
            }
        }
        if (str == null || str2 == null) {
            throw new XmlPullParserException(String.format("'%s' element does not contain 'module'/'errorCode' attributes.", new Object[]{"split-install-error"}), zzaa.zzb, (Throwable) null);
        }
        zzaa.zzc.zzd().put(str, Integer.valueOf(zza.zza(str2)));
        do {
        } while (zzaa.zzb.next() != 3);
    }

    private final void zze(String str, zzz zzz) throws IOException, XmlPullParserException {
        while (true) {
            int next = this.zzb.next();
            if (next != 3 && next != 1) {
                if (this.zzb.getEventType() == 2) {
                    if (this.zzb.getName().equals(str)) {
                        zzz.zza();
                    } else {
                        throw new XmlPullParserException(String.format("Expected '%s' tag but found '%s'.", new Object[]{str, this.zzb.getName()}), this.zzb, (Throwable) null);
                    }
                }
            } else {
                return;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzd() throws IOException, XmlPullParserException {
        zze("split-install-errors", new zzx(this));
    }
}
