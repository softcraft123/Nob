package com.google.android.gms.internal.fido;

import com.bumptech.glide.load.Key;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/* compiled from: com.google.android.gms:play-services-fido@@21.0.0 */
public final class zzhc {
    static final Charset zza = Charset.forName("US-ASCII");
    static final Charset zzb = Charset.forName(Key.STRING_CHARSET_NAME);
    static final Charset zzc = Charset.forName("ISO-8859-1");
    public static final byte[] zzd;
    public static final ByteBuffer zze;
    public static final zzhb zzf;

    static {
        byte[] bArr = new byte[0];
        zzd = bArr;
        zze = ByteBuffer.wrap(bArr);
        int i = zzhb.zza;
        zzgz zzgz = new zzgz(bArr, 0, 0, false, (zzgy) null);
        try {
            zzgz.zza(0);
            zzf = zzgz;
        } catch (zzhd e) {
            throw new IllegalArgumentException(e);
        }
    }
}
