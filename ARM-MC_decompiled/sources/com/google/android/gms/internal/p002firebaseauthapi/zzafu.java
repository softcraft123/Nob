package com.google.android.gms.internal.p002firebaseauthapi;

import com.bumptech.glide.load.Key;
import com.google.android.gms.common.internal.Preconditions;
import com.google.common.net.HttpHeaders;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.URLConnection;
import java.net.UnknownHostException;
import java.nio.charset.Charset;
import org.json.JSONException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzafu  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
public final class zzafu {
    private static void zza(HttpURLConnection httpURLConnection, zzafv<?> zzafv, Type type) {
        InputStream inputStream;
        BufferedReader bufferedReader;
        try {
            int responseCode = httpURLConnection.getResponseCode();
            if (zza(responseCode)) {
                inputStream = httpURLConnection.getInputStream();
            } else {
                inputStream = httpURLConnection.getErrorStream();
            }
            StringBuilder sb = new StringBuilder();
            bufferedReader = new BufferedReader(new InputStreamReader(inputStream, Key.STRING_CHARSET_NAME));
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                sb.append(readLine);
            }
            bufferedReader.close();
            String sb2 = sb.toString();
            if (!zza(responseCode)) {
                zzafv.zza((String) zzaex.zza(sb2, String.class));
            } else {
                zzafv.zza((zzaez) zzaex.zza(sb2, type));
            }
            httpURLConnection.disconnect();
            return;
        } catch (SocketTimeoutException unused) {
            zzafv.zza("TIMEOUT");
            httpURLConnection.disconnect();
            return;
        } catch (zzacn | IOException e) {
            try {
                zzafv.zza(e.getMessage());
                return;
            } finally {
                httpURLConnection.disconnect();
            }
        } catch (Throwable th) {
            th.addSuppressed(th);
        }
        throw th;
    }

    private static final boolean zza(int i) {
        return i >= 200 && i < 300;
    }

    public static void zza(String str, zzafv<?> zzafv, Type type, zzafe zzafe) {
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            httpURLConnection.setConnectTimeout(60000);
            zzafe.zza((URLConnection) httpURLConnection);
            zza(httpURLConnection, zzafv, type);
        } catch (SocketTimeoutException unused) {
            zzafv.zza("TIMEOUT");
        } catch (UnknownHostException unused2) {
            zzafv.zza("<<Network Error>>");
        } catch (IOException e) {
            zzafv.zza(e.getMessage());
        }
    }

    public static void zza(String str, zzafa zzafa, zzafv<?> zzafv, Type type, zzafe zzafe) {
        BufferedOutputStream bufferedOutputStream;
        try {
            Preconditions.checkNotNull(zzafa);
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            httpURLConnection.setDoOutput(true);
            byte[] bytes = zzafa.zza().getBytes(Charset.defaultCharset());
            httpURLConnection.setFixedLengthStreamingMode(bytes.length);
            httpURLConnection.setRequestProperty(HttpHeaders.CONTENT_TYPE, "application/json");
            httpURLConnection.setConnectTimeout(60000);
            zzafe.zza((URLConnection) httpURLConnection);
            bufferedOutputStream = new BufferedOutputStream(httpURLConnection.getOutputStream(), bytes.length);
            bufferedOutputStream.write(bytes, 0, bytes.length);
            bufferedOutputStream.close();
            zza(httpURLConnection, zzafv, type);
            return;
        } catch (SocketTimeoutException unused) {
            zzafv.zza("TIMEOUT");
            return;
        } catch (UnknownHostException unused2) {
            zzafv.zza("<<Network Error>>");
            return;
        } catch (IOException | NullPointerException | JSONException e) {
            zzafv.zza(e.getMessage());
            return;
        } catch (Throwable th) {
            th.addSuppressed(th);
        }
        throw th;
    }
}
