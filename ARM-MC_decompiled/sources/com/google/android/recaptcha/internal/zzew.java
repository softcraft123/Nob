package com.google.android.recaptcha.internal;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.UnknownServiceException;
import kotlin.io.ByteStreamsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.6.1 */
public final class zzew {
    private final HttpURLConnection zza;

    public zzew(HttpURLConnection httpURLConnection) {
        this.zza = httpURLConnection;
    }

    private final InputStream zzf() {
        try {
            return this.zza.getInputStream();
        } catch (UnknownServiceException e) {
            throw new zzbd(zzbb.zzc, zzba.zzaf, e.getMessage());
        } catch (IOException e2) {
            throw new zzbd(zzbb.zzc, zzba.zzae, e2.getMessage());
        } catch (Exception e3) {
            throw new zzbd(zzbb.zzc, zzba.zzak, e3.getMessage());
        }
    }

    private final OutputStream zzg() {
        try {
            return this.zza.getOutputStream();
        } catch (UnknownServiceException e) {
            throw new zzbd(zzbb.zzc, zzba.zzaf, e.getMessage());
        } catch (IOException e2) {
            throw new zzbd(zzbb.zzc, zzba.zzae, e2.getMessage());
        } catch (Exception e3) {
            throw new zzbd(zzbb.zzc, zzba.zzak, e3.getMessage());
        }
    }

    public final zzoi zza(zzoi zzoi) {
        zzbd zzbd;
        try {
            int responseCode = this.zza.getResponseCode();
            if (responseCode != 200) {
                if (responseCode == 400) {
                    zzbd = new zzbd(zzbb.zzc, zzba.zzau, (String) null);
                } else if (responseCode == 503) {
                    zzbd = new zzbd(zzbb.zzi, zzba.zzJ, (String) null);
                } else if (responseCode == 403) {
                    zzbd = new zzbd(zzbb.zzi, zzba.zzJ, (String) null);
                } else if (responseCode != 404) {
                    zzbd = new zzbd(zzbb.zzc, zzba.zzK, (String) null);
                } else {
                    zzbd = new zzbd(zzbb.zzc, zzba.zzi, (String) null);
                }
                throw zzbd;
            }
            byte[] readBytes = ByteStreamsKt.readBytes(zzf());
            if (readBytes.length != 0) {
                try {
                    Object zzb = zzoi.zzD().zzb(readBytes);
                    Intrinsics.checkNotNull(zzb, "null cannot be cast to non-null type T of com.google.android.libraries.abuse.recaptcha.network.CaptchaFeConnection.getResponse");
                    return (zzoi) zzb;
                } catch (Exception e) {
                    throw new zzbd(zzbb.zzc, zzba.zzG, e.getMessage());
                }
            } else {
                throw new zzbd(zzbb.zzc, zzba.zzat, (String) null);
            }
        } catch (Exception e2) {
            throw new zzbd(zzbb.zzc, zzba.zzah, e2.getMessage());
        }
    }

    public final HttpURLConnection zzb() {
        return this.zza;
    }

    public final void zzd() {
        this.zza.disconnect();
    }

    public final void zze(byte[] bArr) {
        try {
            zzg().write(bArr);
        } catch (zzbd e) {
            throw e;
        } catch (IOException e2) {
            throw new zzbd(zzbb.zzc, zzba.zzag, e2.getMessage());
        } catch (Exception e3) {
            throw new zzbd(zzbb.zzc, zzba.zzal, e3.getMessage());
        }
    }

    public final void zzc() {
        try {
            this.zza.connect();
        } catch (SocketTimeoutException e) {
            throw new zzbd(zzbb.zzc, zzba.zzac, e.getMessage());
        } catch (IOException e2) {
            throw new zzbd(zzbb.zzc, zzba.zzad, e2.getMessage());
        } catch (Exception e3) {
            throw new zzbd(zzbb.zzc, zzba.zzaj, e3.getMessage());
        }
    }
}
