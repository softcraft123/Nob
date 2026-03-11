package com.google.android.recaptcha.internal;

import android.content.Context;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.6.1 */
public final class zzen {
    private static zzqk zza;
    private final String zzb;
    private final String zzc;
    private final String zzd;
    private final String zze;
    private final zzeo zzf;
    private final Context zzg;
    private final Integer zzh;
    private final String zzi = zzqb.zzc(zzqb.zzb(System.currentTimeMillis()));
    private final long zzj = System.currentTimeMillis();
    private final int zzk;
    private final int zzl;

    public zzen(int i, String str, int i2, String str2, String str3, String str4, String str5, zzeo zzeo, zzcc zzcc, Context context, Integer num) {
        this.zzk = i;
        this.zzb = str;
        this.zzl = i2;
        this.zzc = str2;
        this.zzd = str3;
        this.zze = str4;
        this.zzf = zzeo;
        this.zzg = context;
        this.zzh = num;
    }

    /* JADX WARNING: type inference failed for: r13v31, types: [com.google.android.recaptcha.internal.zznd] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0120 A[Catch:{ NameNotFoundException -> 0x0168 }] */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x013b A[Catch:{ NameNotFoundException -> 0x0168 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void zzc(int r13, com.google.android.recaptcha.internal.zzqq r14) {
        /*
            r12 = this;
            java.lang.String r0 = ""
            java.lang.String r1 = "unknown"
            com.google.android.recaptcha.internal.zzra r2 = com.google.android.recaptcha.internal.zzrc.zzi()
            int r3 = r12.zzk
            r2.zzy(r3)
            java.lang.String r3 = r12.zzc
            r2.zzq(r3)
            java.lang.String r3 = r12.zzd
            r2.zzt(r3)
            int r3 = r12.zzl
            r2.zzz(r3)
            java.lang.String r3 = r12.zze
            if (r3 == 0) goto L_0x0023
            r2.zzx(r3)
        L_0x0023:
            java.lang.Integer r3 = r12.zzh
            if (r3 == 0) goto L_0x002e
            int r3 = r3.intValue()
            r2.zzv(r3)
        L_0x002e:
            if (r14 == 0) goto L_0x0033
            r2.zzs(r14)
        L_0x0033:
            r2.zzA(r13)
            java.lang.String r13 = r12.zzi
            r2.zzw(r13)
            long r13 = r12.zzj
            long r3 = java.lang.System.currentTimeMillis()
            long r3 = r3 - r13
            r2.zzr(r3)
            int r13 = com.google.android.recaptcha.internal.zzav.zza
            com.google.android.recaptcha.internal.zzel r13 = com.google.android.recaptcha.internal.zzel.zza
            kotlin.jvm.functions.Function0 r13 = (kotlin.jvm.functions.Function0) r13
            kotlin.Lazy r13 = kotlin.LazyKt.lazy(r13)
            java.lang.Object r13 = r13.getValue()
            com.google.android.recaptcha.internal.zzaz r13 = (com.google.android.recaptcha.internal.zzaz) r13
            java.util.List r13 = r13.zza()
            java.util.Iterator r13 = r13.iterator()
        L_0x005d:
            boolean r14 = r13.hasNext()
            r3 = 0
            if (r14 == 0) goto L_0x006e
            java.lang.Object r14 = r13.next()
            com.google.android.recaptcha.internal.zzax r14 = (com.google.android.recaptcha.internal.zzax) r14
            r2.zzf(r3)
            goto L_0x005d
        L_0x006e:
            int r13 = com.google.android.recaptcha.internal.zzbk.zza
            int r13 = r12.zzk
            long r4 = r2.zze()
            r6 = 1000(0x3e8, double:4.94E-321)
            long r4 = r4 * r6
            int r13 = r13 + -2
            r14 = 4
            if (r13 == r14) goto L_0x009a
            r14 = 5
            if (r13 == r14) goto L_0x0097
            r14 = 6
            if (r13 == r14) goto L_0x0094
            r14 = 7
            if (r13 == r14) goto L_0x0091
            r14 = 14
            if (r13 == r14) goto L_0x008e
            com.google.android.recaptcha.internal.zzbl r13 = com.google.android.recaptcha.internal.zzbl.zza
            goto L_0x009c
        L_0x008e:
            com.google.android.recaptcha.internal.zzbl r13 = com.google.android.recaptcha.internal.zzbl.zzf
            goto L_0x009c
        L_0x0091:
            com.google.android.recaptcha.internal.zzbl r13 = com.google.android.recaptcha.internal.zzbl.zze
            goto L_0x009c
        L_0x0094:
            com.google.android.recaptcha.internal.zzbl r13 = com.google.android.recaptcha.internal.zzbl.zzd
            goto L_0x009c
        L_0x0097:
            com.google.android.recaptcha.internal.zzbl r13 = com.google.android.recaptcha.internal.zzbl.zzc
            goto L_0x009c
        L_0x009a:
            com.google.android.recaptcha.internal.zzbl r13 = com.google.android.recaptcha.internal.zzbl.zzb
        L_0x009c:
            int r13 = r13.zza()
            com.google.android.recaptcha.internal.zzbk.zza(r13, r4)
            com.google.android.recaptcha.internal.zzem r13 = com.google.android.recaptcha.internal.zzem.zza
            kotlin.jvm.functions.Function0 r13 = (kotlin.jvm.functions.Function0) r13
            kotlin.Lazy r13 = kotlin.LazyKt.lazy(r13)
            java.lang.Object r13 = r13.getValue()
            com.google.android.recaptcha.internal.zzbe r13 = (com.google.android.recaptcha.internal.zzbe) r13
            android.content.Context r13 = r12.zzg
            java.util.Set r14 = com.google.android.recaptcha.internal.zzbe.zza(r13)
            com.google.android.recaptcha.internal.zzqk r4 = zza
            if (r4 != 0) goto L_0x0172
            com.google.android.recaptcha.internal.zzqh r4 = com.google.android.recaptcha.internal.zzqk.zzf()
            int r5 = android.os.Build.VERSION.SDK_INT
            r4.zzf(r5)
            r5 = 33
            int r6 = android.os.Build.VERSION.SDK_INT     // Catch:{ NameNotFoundException -> 0x0109 }
            java.lang.String r7 = "com.google.android.gms.version"
            r8 = -1
            if (r6 < r5) goto L_0x00ed
            android.content.pm.PackageManager r6 = r13.getPackageManager()     // Catch:{ NameNotFoundException -> 0x0109 }
            java.lang.String r9 = r13.getPackageName()     // Catch:{ NameNotFoundException -> 0x0109 }
            r10 = 128(0x80, double:6.32E-322)
            android.content.pm.PackageManager$ApplicationInfoFlags r10 = android.content.pm.PackageManager.ApplicationInfoFlags.of(r10)     // Catch:{ NameNotFoundException -> 0x0109 }
            android.content.pm.ApplicationInfo r6 = r6.getApplicationInfo(r9, r10)     // Catch:{ NameNotFoundException -> 0x0109 }
            android.os.Bundle r6 = r6.metaData     // Catch:{ NameNotFoundException -> 0x0109 }
            int r6 = r6.getInt(r7, r8)     // Catch:{ NameNotFoundException -> 0x0109 }
            if (r6 != r8) goto L_0x00e8
            goto L_0x0109
        L_0x00e8:
            java.lang.String r6 = java.lang.String.valueOf(r6)     // Catch:{ NameNotFoundException -> 0x0109 }
            goto L_0x010a
        L_0x00ed:
            android.content.pm.PackageManager r6 = r13.getPackageManager()     // Catch:{ NameNotFoundException -> 0x0109 }
            java.lang.String r9 = r13.getPackageName()     // Catch:{ NameNotFoundException -> 0x0109 }
            r10 = 128(0x80, float:1.794E-43)
            android.content.pm.ApplicationInfo r6 = r6.getApplicationInfo(r9, r10)     // Catch:{ NameNotFoundException -> 0x0109 }
            android.os.Bundle r6 = r6.metaData     // Catch:{ NameNotFoundException -> 0x0109 }
            int r6 = r6.getInt(r7, r8)     // Catch:{ NameNotFoundException -> 0x0109 }
            if (r6 != r8) goto L_0x0104
            goto L_0x0109
        L_0x0104:
            java.lang.String r6 = java.lang.String.valueOf(r6)     // Catch:{ NameNotFoundException -> 0x0109 }
            goto L_0x010a
        L_0x0109:
            r6 = r1
        L_0x010a:
            r4.zzs(r6)
            java.lang.String r6 = "18.6.1"
            r4.zzu(r6)
            java.lang.String r6 = android.os.Build.MODEL
            r4.zzr(r6)
            java.lang.String r6 = android.os.Build.MANUFACTURER
            r4.zzt(r6)
            int r6 = android.os.Build.VERSION.SDK_INT     // Catch:{ NameNotFoundException -> 0x0168 }
            if (r6 < r5) goto L_0x013b
            android.content.pm.PackageManager r3 = r13.getPackageManager()     // Catch:{ NameNotFoundException -> 0x0168 }
            java.lang.String r13 = r13.getPackageName()     // Catch:{ NameNotFoundException -> 0x0168 }
            r5 = 0
            android.content.pm.PackageManager$PackageInfoFlags r5 = android.content.pm.PackageManager.PackageInfoFlags.of(r5)     // Catch:{ NameNotFoundException -> 0x0168 }
            android.content.pm.PackageInfo r13 = r3.getPackageInfo(r13, r5)     // Catch:{ NameNotFoundException -> 0x0168 }
            long r5 = r13.getLongVersionCode()     // Catch:{ NameNotFoundException -> 0x0168 }
            java.lang.String r1 = java.lang.String.valueOf(r5)     // Catch:{ NameNotFoundException -> 0x0168 }
            goto L_0x0168
        L_0x013b:
            int r5 = android.os.Build.VERSION.SDK_INT     // Catch:{ NameNotFoundException -> 0x0168 }
            r6 = 28
            if (r5 < r6) goto L_0x0156
            android.content.pm.PackageManager r5 = r13.getPackageManager()     // Catch:{ NameNotFoundException -> 0x0168 }
            java.lang.String r13 = r13.getPackageName()     // Catch:{ NameNotFoundException -> 0x0168 }
            android.content.pm.PackageInfo r13 = r5.getPackageInfo(r13, r3)     // Catch:{ NameNotFoundException -> 0x0168 }
            long r5 = r13.getLongVersionCode()     // Catch:{ NameNotFoundException -> 0x0168 }
            java.lang.String r1 = java.lang.String.valueOf(r5)     // Catch:{ NameNotFoundException -> 0x0168 }
            goto L_0x0168
        L_0x0156:
            android.content.pm.PackageManager r5 = r13.getPackageManager()     // Catch:{ NameNotFoundException -> 0x0168 }
            java.lang.String r13 = r13.getPackageName()     // Catch:{ NameNotFoundException -> 0x0168 }
            android.content.pm.PackageInfo r13 = r5.getPackageInfo(r13, r3)     // Catch:{ NameNotFoundException -> 0x0168 }
            int r13 = r13.versionCode     // Catch:{ NameNotFoundException -> 0x0168 }
            java.lang.String r1 = java.lang.String.valueOf(r13)     // Catch:{ NameNotFoundException -> 0x0168 }
        L_0x0168:
            r4.zzq(r1)
            com.google.android.recaptcha.internal.zznd r13 = r4.zzk()
            r4 = r13
            com.google.android.recaptcha.internal.zzqk r4 = (com.google.android.recaptcha.internal.zzqk) r4
        L_0x0172:
            zza = r4
            com.google.android.recaptcha.internal.zzmx r13 = r4.zzr()
            com.google.android.recaptcha.internal.zzqh r13 = (com.google.android.recaptcha.internal.zzqh) r13
            java.lang.Iterable r14 = (java.lang.Iterable) r14
            r13.zze(r14)
            com.google.android.recaptcha.internal.zznd r13 = r13.zzk()
            com.google.android.recaptcha.internal.zzqk r13 = (com.google.android.recaptcha.internal.zzqk) r13
            java.util.Locale r14 = java.util.Locale.getDefault()     // Catch:{ MissingResourceException -> 0x018e }
            java.lang.String r14 = r14.getISO3Language()     // Catch:{ MissingResourceException -> 0x018e }
            goto L_0x018f
        L_0x018e:
            r14 = r0
        L_0x018f:
            java.util.Locale r1 = java.util.Locale.getDefault()     // Catch:{ MissingResourceException -> 0x0197 }
            java.lang.String r0 = r1.getISO3Country()     // Catch:{ MissingResourceException -> 0x0197 }
        L_0x0197:
            java.lang.String r1 = r12.zzb
            com.google.android.recaptcha.internal.zzrm r3 = com.google.android.recaptcha.internal.zzro.zzf()
            r3.zzr(r1)
            r3.zze(r13)
            r3.zzq(r14)
            r3.zzf(r0)
            com.google.android.recaptcha.internal.zznd r13 = r3.zzk()
            com.google.android.recaptcha.internal.zzro r13 = (com.google.android.recaptcha.internal.zzro) r13
            r2.zzu(r13)
            com.google.android.recaptcha.internal.zztw r13 = com.google.android.recaptcha.internal.zztx.zzi()
            r13.zze(r2)
            com.google.android.recaptcha.internal.zznd r13 = r13.zzk()
            com.google.android.recaptcha.internal.zztx r13 = (com.google.android.recaptcha.internal.zztx) r13
            com.google.android.recaptcha.internal.zzeo r14 = r12.zzf
            r14.zza(r13)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.recaptcha.internal.zzen.zzc(int, com.google.android.recaptcha.internal.zzqq):void");
    }

    public final void zza() {
        zzc(3, (zzqq) null);
    }

    public final void zzb(zzbd zzbd) {
        zzqo zzg2 = zzqq.zzg();
        zzg2.zzr(String.valueOf(zzbd.zzb().zza()));
        zzg2.zze(zzbd.zza().zza());
        zzg2.zzq(zzbd.zzc().getErrorCode().getErrorCode());
        String zzd2 = zzbd.zzd();
        if (zzd2 != null) {
            zzg2.zzf(zzd2);
        }
        zzc(4, (zzqq) zzg2.zzk());
    }
}
