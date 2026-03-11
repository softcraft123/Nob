package com.google.android.recaptcha.internal;

import androidx.browser.trusted.sharing.ShareTarget;
import com.google.common.net.HttpHeaders;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.zip.GZIPInputStream;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.6.1 */
public final class zzfa implements zzey {
    private final Lazy zza = LazyKt.lazy(zzez.zza);

    public zzfa() {
        int i = zzav.zza;
    }

    public final zzsc zza(String str, zzto zzto) throws zzbd {
        Throwable th;
        zzbd zzbd;
        zzew zzew = null;
        try {
            zzew = ((zzex) this.zza.getValue()).zza(str);
            zzew.zzc();
            zzew.zze(zzto.zzd());
            zzsc zzsc = (zzsc) zzew.zza(zzsc.zzi());
            zzew.zzd();
            return zzsc;
        } catch (zzbd e) {
            if (zzew != null) {
                if (Intrinsics.areEqual((Object) e.zza(), (Object) zzba.zzau)) {
                    try {
                        zzbd = zzbc.zza(zztu.zzg(zzew.zzb().getErrorStream()).zzi());
                    } catch (Exception e2) {
                        zzbd = new zzbd(zzbb.zzc, zzba.zzG, e2.getMessage());
                    }
                    th = zzbd;
                } else {
                    th = e;
                }
                throw th;
            }
            throw e;
        } catch (Exception e3) {
            throw new zzbd(zzbb.zzc, zzba.zzF, e3.getMessage());
        } catch (Throwable th2) {
            if (zzew != null) {
                zzew.zzd();
            }
            throw th2;
        }
    }

    public final String zzb(String str) throws zzbd {
        InputStreamReader inputStreamReader;
        try {
            try {
                URLConnection openConnection = new URL(str).openConnection();
                Intrinsics.checkNotNull(openConnection, "null cannot be cast to non-null type java.net.HttpURLConnection");
                HttpURLConnection httpURLConnection = (HttpURLConnection) openConnection;
                httpURLConnection.setRequestMethod(ShareTarget.METHOD_GET);
                httpURLConnection.setDoInput(true);
                httpURLConnection.setRequestProperty(HttpHeaders.ACCEPT, "application/x-protobuffer");
                httpURLConnection.setRequestProperty(HttpHeaders.ACCEPT_ENCODING, "gzip");
                httpURLConnection.connect();
                if (httpURLConnection.getResponseCode() == 200) {
                    try {
                        if (Intrinsics.areEqual((Object) "gzip", (Object) httpURLConnection.getContentEncoding())) {
                            inputStreamReader = new InputStreamReader(new GZIPInputStream(httpURLConnection.getInputStream()));
                        } else {
                            inputStreamReader = new InputStreamReader(httpURLConnection.getInputStream());
                        }
                        return TextStreamsKt.readText(inputStreamReader);
                    } catch (Exception unused) {
                        throw new zzbd(zzbb.zzc, zzba.zzP, (String) null);
                    }
                } else {
                    throw new zzbd(zzbb.zzc, new zzba(httpURLConnection.getResponseCode()), (String) null);
                }
            } catch (Exception unused2) {
                throw new zzbd(zzbb.zzc, zzba.zzO, (String) null);
            }
        } catch (Exception unused3) {
            throw new zzbd(zzbb.zzb, zzba.zzN, (String) null);
        }
    }
}
