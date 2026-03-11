package com.google.android.recaptcha.internal;

import android.net.Uri;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.bumptech.glide.load.Key;
import java.io.ByteArrayInputStream;
import java.util.concurrent.TimeUnit;
import kotlin.Deprecated;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.6.1 */
public final class zzik extends WebViewClient {
    final /* synthetic */ zzja zza;

    zzik(zzja zzja) {
        this.zza = zzja;
    }

    public final void onLoadResource(WebView webView, String str) {
        System.currentTimeMillis();
    }

    public final void onPageFinished(WebView webView, String str) {
        long zza2 = this.zza.zzh.zza(TimeUnit.MICROSECONDS);
        int i = zzbk.zza;
        zzbk.zza(zzbl.zzg.zza(), zza2);
    }

    @Deprecated(message = "Use onReceivedError(WebView,request,error) instead")
    public final void onReceivedError(WebView webView, int i, String str, String str2) {
        super.onReceivedError(webView, i, str, str2);
        zzbb zzbb = zzbb.zzc;
        zzba zzba = (zzba) this.zza.zzd.get(Integer.valueOf(i));
        if (zzba == null) {
            zzba = zzba.zzM;
        }
        zzbd zzbd = new zzbd(zzbb, zzba, (String) null);
        this.zza.zzA().hashCode();
        zzbd.getMessage();
        this.zza.zzA().completeExceptionally(zzbd);
    }

    @Deprecated(message = "Use shouldInterceptRequest(WebView,WebResourceRequest) instead")
    public final WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        zzja zzja = this.zza;
        Uri parse = Uri.parse(str);
        zzja.zzp(zzja);
        Intrinsics.checkNotNull(parse);
        if (!zzfk.zzc(parse) || zzja.zzp(this.zza).zza(parse)) {
            return super.shouldInterceptRequest(webView, str);
        }
        zzbd zzbd = new zzbd(zzbb.zzb, zzba.zzQ, (String) null);
        this.zza.zzA().hashCode();
        parse.toString();
        this.zza.zzA().completeExceptionally(zzbd);
        return new WebResourceResponse("text/plain", Key.STRING_CHARSET_NAME, new ByteArrayInputStream(new byte[0]));
    }
}
