package com.armmc.app.api;

import android.util.Log;
import androidx.browser.trusted.sharing.ShareTarget;
import androidx.core.app.NotificationCompat;
import com.armmc.app.LogManager;
import com.google.common.net.HttpHeaders;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import kotlin.Metadata;
import kotlin.io.CloseableKt;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u0000 \u00102\u00020\u0001:\u0004\u0010\u0011\u0012\u0013B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u0007J\u001a\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u00072\b\b\u0002\u0010\u000e\u001a\u00020\u000fH\u0002¨\u0006\u0014"}, d2 = {"Lcom/armmc/app/api/TunnelApiService;", "", "<init>", "()V", "requestTunnel", "Lcom/armmc/app/api/TunnelApiService$TunnelRequestResponse;", "firebaseIdToken", "", "terminateTunnel", "Lcom/armmc/app/api/TunnelApiService$TunnelTerminateResponse;", "getTunnelStatus", "Lcom/armmc/app/api/TunnelApiService$TunnelStatusResponse;", "parseTunnelRequestResponse", "responseBody", "statusCode", "", "Companion", "TunnelRequestResponse", "TunnelStatusResponse", "TunnelTerminateResponse", "app_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* compiled from: TunnelApiService.kt */
public final class TunnelApiService {
    private static final String BASE_URL = "https://api.witherhost.com/api/tunnel";
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String TAG = "TunnelApiService";
    private static final int TIMEOUT_MS = 30000;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bXT¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/armmc/app/api/TunnelApiService$Companion;", "", "<init>", "()V", "TAG", "", "BASE_URL", "TIMEOUT_MS", "", "app_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* compiled from: TunnelApiService.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b%\b\b\u0018\u00002\u00020\u0001B]\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u0006\u0012\u0006\u0010\u000b\u001a\u00020\t\u0012\u0006\u0010\f\u001a\u00020\u0006\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u000e\u001a\u00020\t¢\u0006\u0004\b\u000f\u0010\u0010J\u0006\u0010\u001e\u001a\u00020\u0006J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0006HÆ\u0003J\t\u0010\"\u001a\u00020\u0006HÆ\u0003J\t\u0010#\u001a\u00020\tHÆ\u0003J\t\u0010$\u001a\u00020\u0006HÆ\u0003J\t\u0010%\u001a\u00020\tHÆ\u0003J\t\u0010&\u001a\u00020\u0006HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\t\u0010(\u001a\u00020\tHÆ\u0003Jo\u0010)\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u00062\b\b\u0002\u0010\u000b\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\u00062\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u000e\u001a\u00020\tHÆ\u0001J\u0013\u0010*\u001a\u00020\u00032\b\u0010+\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010,\u001a\u00020\tHÖ\u0001J\t\u0010-\u001a\u00020\u0006HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\n\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0015R\u0011\u0010\u000b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0018R\u0011\u0010\f\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0015R\u0013\u0010\r\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0015R\u0011\u0010\u000e\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0018¨\u0006."}, d2 = {"Lcom/armmc/app/api/TunnelApiService$TunnelRequestResponse;", "", "success", "", "existing", "subdomain", "", "token", "remotePort", "", "serverAddress", "serverPort", "message", "error", "statusCode", "<init>", "(ZZLjava/lang/String;Ljava/lang/String;ILjava/lang/String;ILjava/lang/String;Ljava/lang/String;I)V", "getSuccess", "()Z", "getExisting", "getSubdomain", "()Ljava/lang/String;", "getToken", "getRemotePort", "()I", "getServerAddress", "getServerPort", "getMessage", "getError", "getStatusCode", "getFullAddress", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "copy", "equals", "other", "hashCode", "toString", "app_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* compiled from: TunnelApiService.kt */
    public static final class TunnelRequestResponse {
        private final String error;
        private final boolean existing;
        private final String message;
        private final int remotePort;
        private final String serverAddress;
        private final int serverPort;
        private final int statusCode;
        private final String subdomain;
        private final boolean success;
        private final String token;

        public static /* synthetic */ TunnelRequestResponse copy$default(TunnelRequestResponse tunnelRequestResponse, boolean z, boolean z2, String str, String str2, int i, String str3, int i2, String str4, String str5, int i3, int i4, Object obj) {
            if ((i4 & 1) != 0) {
                z = tunnelRequestResponse.success;
            }
            if ((i4 & 2) != 0) {
                z2 = tunnelRequestResponse.existing;
            }
            if ((i4 & 4) != 0) {
                str = tunnelRequestResponse.subdomain;
            }
            if ((i4 & 8) != 0) {
                str2 = tunnelRequestResponse.token;
            }
            if ((i4 & 16) != 0) {
                i = tunnelRequestResponse.remotePort;
            }
            if ((i4 & 32) != 0) {
                str3 = tunnelRequestResponse.serverAddress;
            }
            if ((i4 & 64) != 0) {
                i2 = tunnelRequestResponse.serverPort;
            }
            if ((i4 & 128) != 0) {
                str4 = tunnelRequestResponse.message;
            }
            if ((i4 & 256) != 0) {
                str5 = tunnelRequestResponse.error;
            }
            if ((i4 & 512) != 0) {
                i3 = tunnelRequestResponse.statusCode;
            }
            String str6 = str5;
            int i5 = i3;
            int i6 = i2;
            String str7 = str4;
            int i7 = i;
            String str8 = str3;
            String str9 = str2;
            boolean z3 = z2;
            return tunnelRequestResponse.copy(z, z3, str, str9, i7, str8, i6, str7, str6, i5);
        }

        public final boolean component1() {
            return this.success;
        }

        public final int component10() {
            return this.statusCode;
        }

        public final boolean component2() {
            return this.existing;
        }

        public final String component3() {
            return this.subdomain;
        }

        public final String component4() {
            return this.token;
        }

        public final int component5() {
            return this.remotePort;
        }

        public final String component6() {
            return this.serverAddress;
        }

        public final int component7() {
            return this.serverPort;
        }

        public final String component8() {
            return this.message;
        }

        public final String component9() {
            return this.error;
        }

        public final TunnelRequestResponse copy(boolean z, boolean z2, String str, String str2, int i, String str3, int i2, String str4, String str5, int i3) {
            Intrinsics.checkNotNullParameter(str, "subdomain");
            String str6 = str2;
            Intrinsics.checkNotNullParameter(str6, "token");
            String str7 = str3;
            Intrinsics.checkNotNullParameter(str7, "serverAddress");
            String str8 = str4;
            Intrinsics.checkNotNullParameter(str8, LogManager.EXTRA_MESSAGE);
            return new TunnelRequestResponse(z, z2, str, str6, i, str7, i2, str8, str5, i3);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof TunnelRequestResponse)) {
                return false;
            }
            TunnelRequestResponse tunnelRequestResponse = (TunnelRequestResponse) obj;
            return this.success == tunnelRequestResponse.success && this.existing == tunnelRequestResponse.existing && Intrinsics.areEqual((Object) this.subdomain, (Object) tunnelRequestResponse.subdomain) && Intrinsics.areEqual((Object) this.token, (Object) tunnelRequestResponse.token) && this.remotePort == tunnelRequestResponse.remotePort && Intrinsics.areEqual((Object) this.serverAddress, (Object) tunnelRequestResponse.serverAddress) && this.serverPort == tunnelRequestResponse.serverPort && Intrinsics.areEqual((Object) this.message, (Object) tunnelRequestResponse.message) && Intrinsics.areEqual((Object) this.error, (Object) tunnelRequestResponse.error) && this.statusCode == tunnelRequestResponse.statusCode;
        }

        public int hashCode() {
            int hashCode = ((((((((((((((Boolean.hashCode(this.success) * 31) + Boolean.hashCode(this.existing)) * 31) + this.subdomain.hashCode()) * 31) + this.token.hashCode()) * 31) + Integer.hashCode(this.remotePort)) * 31) + this.serverAddress.hashCode()) * 31) + Integer.hashCode(this.serverPort)) * 31) + this.message.hashCode()) * 31;
            String str = this.error;
            return ((hashCode + (str == null ? 0 : str.hashCode())) * 31) + Integer.hashCode(this.statusCode);
        }

        public String toString() {
            boolean z = this.success;
            boolean z2 = this.existing;
            String str = this.subdomain;
            String str2 = this.token;
            int i = this.remotePort;
            String str3 = this.serverAddress;
            int i2 = this.serverPort;
            String str4 = this.message;
            String str5 = this.error;
            return "TunnelRequestResponse(success=" + z + ", existing=" + z2 + ", subdomain=" + str + ", token=" + str2 + ", remotePort=" + i + ", serverAddress=" + str3 + ", serverPort=" + i2 + ", message=" + str4 + ", error=" + str5 + ", statusCode=" + this.statusCode + ")";
        }

        public TunnelRequestResponse(boolean z, boolean z2, String str, String str2, int i, String str3, int i2, String str4, String str5, int i3) {
            Intrinsics.checkNotNullParameter(str, "subdomain");
            Intrinsics.checkNotNullParameter(str2, "token");
            Intrinsics.checkNotNullParameter(str3, "serverAddress");
            Intrinsics.checkNotNullParameter(str4, LogManager.EXTRA_MESSAGE);
            this.success = z;
            this.existing = z2;
            this.subdomain = str;
            this.token = str2;
            this.remotePort = i;
            this.serverAddress = str3;
            this.serverPort = i2;
            this.message = str4;
            this.error = str5;
            this.statusCode = i3;
        }

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public /* synthetic */ TunnelRequestResponse(boolean r14, boolean r15, java.lang.String r16, java.lang.String r17, int r18, java.lang.String r19, int r20, java.lang.String r21, java.lang.String r22, int r23, int r24, kotlin.jvm.internal.DefaultConstructorMarker r25) {
            /*
                r13 = this;
                r0 = r24
                r1 = r0 & 256(0x100, float:3.59E-43)
                if (r1 == 0) goto L_0x0009
                r1 = 0
                r11 = r1
                goto L_0x000b
            L_0x0009:
                r11 = r22
            L_0x000b:
                r0 = r0 & 512(0x200, float:7.175E-43)
                if (r0 == 0) goto L_0x0013
                r0 = 200(0xc8, float:2.8E-43)
                r12 = r0
                goto L_0x0015
            L_0x0013:
                r12 = r23
            L_0x0015:
                r2 = r13
                r3 = r14
                r4 = r15
                r5 = r16
                r6 = r17
                r7 = r18
                r8 = r19
                r9 = r20
                r10 = r21
                r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.armmc.app.api.TunnelApiService.TunnelRequestResponse.<init>(boolean, boolean, java.lang.String, java.lang.String, int, java.lang.String, int, java.lang.String, java.lang.String, int, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
        }

        public final boolean getSuccess() {
            return this.success;
        }

        public final boolean getExisting() {
            return this.existing;
        }

        public final String getSubdomain() {
            return this.subdomain;
        }

        public final String getToken() {
            return this.token;
        }

        public final int getRemotePort() {
            return this.remotePort;
        }

        public final String getServerAddress() {
            return this.serverAddress;
        }

        public final int getServerPort() {
            return this.serverPort;
        }

        public final String getMessage() {
            return this.message;
        }

        public final String getError() {
            return this.error;
        }

        public final int getStatusCode() {
            return this.statusCode;
        }

        public final String getFullAddress() {
            return this.subdomain + ".witherhost.com";
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u001f\b\b\u0018\u00002\u00020\u0001BK\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\f\u0010\rJ\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0013J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J^\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\n\u001a\u00020\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010!J\u0013\u0010\"\u001a\u00020\u00032\b\u0010#\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010$\u001a\u00020\u0007HÖ\u0001J\t\u0010%\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0011R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0011R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u000fR\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0011¨\u0006&"}, d2 = {"Lcom/armmc/app/api/TunnelApiService$TunnelStatusResponse;", "", "active", "", "subdomain", "", "remotePort", "", "status", "token", "processRunning", "error", "<init>", "(ZLjava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;)V", "getActive", "()Z", "getSubdomain", "()Ljava/lang/String;", "getRemotePort", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getStatus", "getToken", "getProcessRunning", "getError", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(ZLjava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;)Lcom/armmc/app/api/TunnelApiService$TunnelStatusResponse;", "equals", "other", "hashCode", "toString", "app_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* compiled from: TunnelApiService.kt */
    public static final class TunnelStatusResponse {
        private final boolean active;
        private final String error;
        private final boolean processRunning;
        private final Integer remotePort;
        private final String status;
        private final String subdomain;
        private final String token;

        public static /* synthetic */ TunnelStatusResponse copy$default(TunnelStatusResponse tunnelStatusResponse, boolean z, String str, Integer num, String str2, String str3, boolean z2, String str4, int i, Object obj) {
            if ((i & 1) != 0) {
                z = tunnelStatusResponse.active;
            }
            if ((i & 2) != 0) {
                str = tunnelStatusResponse.subdomain;
            }
            if ((i & 4) != 0) {
                num = tunnelStatusResponse.remotePort;
            }
            if ((i & 8) != 0) {
                str2 = tunnelStatusResponse.status;
            }
            if ((i & 16) != 0) {
                str3 = tunnelStatusResponse.token;
            }
            if ((i & 32) != 0) {
                z2 = tunnelStatusResponse.processRunning;
            }
            if ((i & 64) != 0) {
                str4 = tunnelStatusResponse.error;
            }
            boolean z3 = z2;
            String str5 = str4;
            String str6 = str2;
            String str7 = str3;
            return tunnelStatusResponse.copy(z, str, num, str6, str7, z3, str5);
        }

        public final boolean component1() {
            return this.active;
        }

        public final String component2() {
            return this.subdomain;
        }

        public final Integer component3() {
            return this.remotePort;
        }

        public final String component4() {
            return this.status;
        }

        public final String component5() {
            return this.token;
        }

        public final boolean component6() {
            return this.processRunning;
        }

        public final String component7() {
            return this.error;
        }

        public final TunnelStatusResponse copy(boolean z, String str, Integer num, String str2, String str3, boolean z2, String str4) {
            return new TunnelStatusResponse(z, str, num, str2, str3, z2, str4);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof TunnelStatusResponse)) {
                return false;
            }
            TunnelStatusResponse tunnelStatusResponse = (TunnelStatusResponse) obj;
            return this.active == tunnelStatusResponse.active && Intrinsics.areEqual((Object) this.subdomain, (Object) tunnelStatusResponse.subdomain) && Intrinsics.areEqual((Object) this.remotePort, (Object) tunnelStatusResponse.remotePort) && Intrinsics.areEqual((Object) this.status, (Object) tunnelStatusResponse.status) && Intrinsics.areEqual((Object) this.token, (Object) tunnelStatusResponse.token) && this.processRunning == tunnelStatusResponse.processRunning && Intrinsics.areEqual((Object) this.error, (Object) tunnelStatusResponse.error);
        }

        public int hashCode() {
            int hashCode = Boolean.hashCode(this.active) * 31;
            String str = this.subdomain;
            int i = 0;
            int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
            Integer num = this.remotePort;
            int hashCode3 = (hashCode2 + (num == null ? 0 : num.hashCode())) * 31;
            String str2 = this.status;
            int hashCode4 = (hashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.token;
            int hashCode5 = (((hashCode4 + (str3 == null ? 0 : str3.hashCode())) * 31) + Boolean.hashCode(this.processRunning)) * 31;
            String str4 = this.error;
            if (str4 != null) {
                i = str4.hashCode();
            }
            return hashCode5 + i;
        }

        public String toString() {
            boolean z = this.active;
            String str = this.subdomain;
            Integer num = this.remotePort;
            String str2 = this.status;
            String str3 = this.token;
            boolean z2 = this.processRunning;
            return "TunnelStatusResponse(active=" + z + ", subdomain=" + str + ", remotePort=" + num + ", status=" + str2 + ", token=" + str3 + ", processRunning=" + z2 + ", error=" + this.error + ")";
        }

        public TunnelStatusResponse(boolean z, String str, Integer num, String str2, String str3, boolean z2, String str4) {
            this.active = z;
            this.subdomain = str;
            this.remotePort = num;
            this.status = str2;
            this.token = str3;
            this.processRunning = z2;
            this.error = str4;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ TunnelStatusResponse(boolean z, String str, Integer num, String str2, String str3, boolean z2, String str4, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(z, str, num, str2, str3, z2, (i & 64) != 0 ? null : str4);
        }

        public final boolean getActive() {
            return this.active;
        }

        public final String getSubdomain() {
            return this.subdomain;
        }

        public final Integer getRemotePort() {
            return this.remotePort;
        }

        public final String getStatus() {
            return this.status;
        }

        public final String getToken() {
            return this.token;
        }

        public final boolean getProcessRunning() {
            return this.processRunning;
        }

        public final String getError() {
            return this.error;
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003J)\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00032\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u0017"}, d2 = {"Lcom/armmc/app/api/TunnelApiService$TunnelTerminateResponse;", "", "success", "", "message", "", "error", "<init>", "(ZLjava/lang/String;Ljava/lang/String;)V", "getSuccess", "()Z", "getMessage", "()Ljava/lang/String;", "getError", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* compiled from: TunnelApiService.kt */
    public static final class TunnelTerminateResponse {
        private final String error;
        private final String message;
        private final boolean success;

        public static /* synthetic */ TunnelTerminateResponse copy$default(TunnelTerminateResponse tunnelTerminateResponse, boolean z, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                z = tunnelTerminateResponse.success;
            }
            if ((i & 2) != 0) {
                str = tunnelTerminateResponse.message;
            }
            if ((i & 4) != 0) {
                str2 = tunnelTerminateResponse.error;
            }
            return tunnelTerminateResponse.copy(z, str, str2);
        }

        public final boolean component1() {
            return this.success;
        }

        public final String component2() {
            return this.message;
        }

        public final String component3() {
            return this.error;
        }

        public final TunnelTerminateResponse copy(boolean z, String str, String str2) {
            Intrinsics.checkNotNullParameter(str, LogManager.EXTRA_MESSAGE);
            return new TunnelTerminateResponse(z, str, str2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof TunnelTerminateResponse)) {
                return false;
            }
            TunnelTerminateResponse tunnelTerminateResponse = (TunnelTerminateResponse) obj;
            return this.success == tunnelTerminateResponse.success && Intrinsics.areEqual((Object) this.message, (Object) tunnelTerminateResponse.message) && Intrinsics.areEqual((Object) this.error, (Object) tunnelTerminateResponse.error);
        }

        public int hashCode() {
            int hashCode = ((Boolean.hashCode(this.success) * 31) + this.message.hashCode()) * 31;
            String str = this.error;
            return hashCode + (str == null ? 0 : str.hashCode());
        }

        public String toString() {
            boolean z = this.success;
            String str = this.message;
            return "TunnelTerminateResponse(success=" + z + ", message=" + str + ", error=" + this.error + ")";
        }

        public TunnelTerminateResponse(boolean z, String str, String str2) {
            Intrinsics.checkNotNullParameter(str, LogManager.EXTRA_MESSAGE);
            this.success = z;
            this.message = str;
            this.error = str2;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ TunnelTerminateResponse(boolean z, String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(z, str, (i & 4) != 0 ? null : str2);
        }

        public final boolean getSuccess() {
            return this.success;
        }

        public final String getMessage() {
            return this.message;
        }

        public final String getError() {
            return this.error;
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(8:19|20|21|22|23|24|25|42) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:22:0x00ad */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00f9  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.armmc.app.api.TunnelApiService.TunnelRequestResponse requestTunnel(java.lang.String r19) {
        /*
            r18 = this;
            r0 = r19
            java.lang.String r1 = "TunnelApiService"
            java.lang.String r2 = "Request failed with code "
            java.lang.String r3 = "Request tunnel response: "
            java.lang.String r4 = "Request tunnel response code: "
            java.lang.String r5 = "Bearer "
            java.lang.String r6 = "firebaseIdToken"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r6)
            java.net.URL r6 = new java.net.URL     // Catch:{ Exception -> 0x00e6 }
            java.lang.String r7 = "https://api.witherhost.com/api/tunnel/request"
            r6.<init>(r7)     // Catch:{ Exception -> 0x00e6 }
            java.net.URLConnection r6 = r6.openConnection()     // Catch:{ Exception -> 0x00e6 }
            java.lang.String r7 = "null cannot be cast to non-null type java.net.HttpURLConnection"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r6, r7)     // Catch:{ Exception -> 0x00e6 }
            java.net.HttpURLConnection r6 = (java.net.HttpURLConnection) r6     // Catch:{ Exception -> 0x00e6 }
            java.lang.String r7 = "GET"
            r6.setRequestMethod(r7)     // Catch:{ Exception -> 0x00e6 }
            r7 = 30000(0x7530, float:4.2039E-41)
            r6.setConnectTimeout(r7)     // Catch:{ Exception -> 0x00e6 }
            r6.setReadTimeout(r7)     // Catch:{ Exception -> 0x00e6 }
            java.lang.String r7 = "Authorization"
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00e6 }
            r8.<init>(r5)     // Catch:{ Exception -> 0x00e6 }
            java.lang.StringBuilder r0 = r8.append(r0)     // Catch:{ Exception -> 0x00e6 }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x00e6 }
            r6.setRequestProperty(r7, r0)     // Catch:{ Exception -> 0x00e6 }
            java.lang.String r0 = "Content-Type"
            java.lang.String r5 = "application/json"
            r6.setRequestProperty(r0, r5)     // Catch:{ Exception -> 0x00e6 }
            int r0 = r6.getResponseCode()     // Catch:{ Exception -> 0x00e6 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00e6 }
            r5.<init>(r4)     // Catch:{ Exception -> 0x00e6 }
            java.lang.StringBuilder r4 = r5.append(r0)     // Catch:{ Exception -> 0x00e6 }
            java.lang.String r4 = r4.toString()     // Catch:{ Exception -> 0x00e6 }
            android.util.Log.d(r1, r4)     // Catch:{ Exception -> 0x00e6 }
            r4 = 300(0x12c, float:4.2E-43)
            r5 = 200(0xc8, float:2.8E-43)
            if (r5 > r0) goto L_0x006a
            if (r0 >= r4) goto L_0x006a
            java.io.InputStream r6 = r6.getInputStream()     // Catch:{ Exception -> 0x00e6 }
            goto L_0x006e
        L_0x006a:
            java.io.InputStream r6 = r6.getErrorStream()     // Catch:{ Exception -> 0x00e6 }
        L_0x006e:
            java.io.BufferedReader r7 = new java.io.BufferedReader     // Catch:{ Exception -> 0x00e6 }
            java.io.InputStreamReader r8 = new java.io.InputStreamReader     // Catch:{ Exception -> 0x00e6 }
            r8.<init>(r6)     // Catch:{ Exception -> 0x00e6 }
            java.io.Reader r8 = (java.io.Reader) r8     // Catch:{ Exception -> 0x00e6 }
            r7.<init>(r8)     // Catch:{ Exception -> 0x00e6 }
            java.io.Closeable r7 = (java.io.Closeable) r7     // Catch:{ Exception -> 0x00e6 }
            r6 = r7
            java.io.BufferedReader r6 = (java.io.BufferedReader) r6     // Catch:{ all -> 0x00da }
            java.io.Reader r6 = (java.io.Reader) r6     // Catch:{ all -> 0x00da }
            java.lang.String r6 = kotlin.io.TextStreamsKt.readText(r6)     // Catch:{ all -> 0x00da }
            r8 = 0
            kotlin.io.CloseableKt.closeFinally(r7, r8)     // Catch:{ Exception -> 0x00e6 }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00e6 }
            r7.<init>(r3)     // Catch:{ Exception -> 0x00e6 }
            java.lang.StringBuilder r3 = r7.append(r6)     // Catch:{ Exception -> 0x00e6 }
            java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x00e6 }
            android.util.Log.d(r1, r3)     // Catch:{ Exception -> 0x00e6 }
            if (r5 > r0) goto L_0x00a5
            if (r0 >= r4) goto L_0x00a5
            r3 = r18
            com.armmc.app.api.TunnelApiService$TunnelRequestResponse r0 = r3.parseTunnelRequestResponse(r6, r0)     // Catch:{ Exception -> 0x00e4 }
            goto L_0x0111
        L_0x00a5:
            r3 = r18
            org.json.JSONObject r4 = new org.json.JSONObject     // Catch:{ Exception -> 0x00ad }
            r4.<init>(r6)     // Catch:{ Exception -> 0x00ad }
            goto L_0x00b2
        L_0x00ad:
            org.json.JSONObject r4 = new org.json.JSONObject     // Catch:{ Exception -> 0x00e4 }
            r4.<init>()     // Catch:{ Exception -> 0x00e4 }
        L_0x00b2:
            com.armmc.app.api.TunnelApiService$TunnelRequestResponse r7 = new com.armmc.app.api.TunnelApiService$TunnelRequestResponse     // Catch:{ Exception -> 0x00e4 }
            java.lang.String r10 = ""
            java.lang.String r11 = ""
            java.lang.String r13 = ""
            java.lang.String r15 = ""
            java.lang.String r5 = "message"
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00e4 }
            r6.<init>(r2)     // Catch:{ Exception -> 0x00e4 }
            java.lang.StringBuilder r2 = r6.append(r0)     // Catch:{ Exception -> 0x00e4 }
            java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x00e4 }
            java.lang.String r16 = r4.optString(r5, r2)     // Catch:{ Exception -> 0x00e4 }
            r8 = 0
            r9 = 0
            r12 = 0
            r14 = 0
            r17 = r0
            r7.<init>(r8, r9, r10, r11, r12, r13, r14, r15, r16, r17)     // Catch:{ Exception -> 0x00e4 }
            r0 = r7
            goto L_0x0111
        L_0x00da:
            r0 = move-exception
            r3 = r18
            r2 = r0
            throw r2     // Catch:{ all -> 0x00df }
        L_0x00df:
            r0 = move-exception
            kotlin.io.CloseableKt.closeFinally(r7, r2)     // Catch:{ Exception -> 0x00e4 }
            throw r0     // Catch:{ Exception -> 0x00e4 }
        L_0x00e4:
            r0 = move-exception
            goto L_0x00e9
        L_0x00e6:
            r0 = move-exception
            r3 = r18
        L_0x00e9:
            java.lang.String r2 = "Error requesting tunnel"
            r4 = r0
            java.lang.Throwable r4 = (java.lang.Throwable) r4
            android.util.Log.e(r1, r2, r4)
            com.armmc.app.api.TunnelApiService$TunnelRequestResponse r5 = new com.armmc.app.api.TunnelApiService$TunnelRequestResponse
            java.lang.String r0 = r0.getMessage()
            if (r0 != 0) goto L_0x00fb
            java.lang.String r0 = "Network error"
        L_0x00fb:
            r14 = r0
            r16 = 512(0x200, float:7.175E-43)
            r17 = 0
            r6 = 0
            r7 = 0
            java.lang.String r8 = ""
            java.lang.String r9 = ""
            r10 = 0
            java.lang.String r11 = ""
            r12 = 0
            java.lang.String r13 = ""
            r15 = 0
            r5.<init>(r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17)
            r0 = r5
        L_0x0111:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.armmc.app.api.TunnelApiService.requestTunnel(java.lang.String):com.armmc.app.api.TunnelApiService$TunnelRequestResponse");
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(6:24|25|26|27|28|52) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:26:0x00e4 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.armmc.app.api.TunnelApiService.TunnelTerminateResponse terminateTunnel(java.lang.String r15) {
        /*
            r14 = this;
            java.lang.String r1 = ""
            java.lang.String r2 = "TunnelApiService"
            java.lang.String r0 = "Terminate failed with code "
            java.lang.String r3 = "Terminate tunnel response: "
            java.lang.String r4 = "Terminate tunnel response code: "
            java.lang.String r5 = "Bearer "
            java.lang.String r6 = "firebaseIdToken"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r6)
            r6 = 0
            java.net.URL r7 = new java.net.URL     // Catch:{ Exception -> 0x0110 }
            java.lang.String r8 = "https://api.witherhost.com/api/tunnel/terminate"
            r7.<init>(r8)     // Catch:{ Exception -> 0x0110 }
            java.net.URLConnection r7 = r7.openConnection()     // Catch:{ Exception -> 0x0110 }
            java.lang.String r8 = "null cannot be cast to non-null type java.net.HttpURLConnection"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r7, r8)     // Catch:{ Exception -> 0x0110 }
            java.net.HttpURLConnection r7 = (java.net.HttpURLConnection) r7     // Catch:{ Exception -> 0x0110 }
            java.lang.String r8 = "POST"
            r7.setRequestMethod(r8)     // Catch:{ Exception -> 0x0110 }
            r8 = 30000(0x7530, float:4.2039E-41)
            r7.setConnectTimeout(r8)     // Catch:{ Exception -> 0x0110 }
            r7.setReadTimeout(r8)     // Catch:{ Exception -> 0x0110 }
            java.lang.String r8 = "Authorization"
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0110 }
            r9.<init>(r5)     // Catch:{ Exception -> 0x0110 }
            java.lang.StringBuilder r15 = r9.append(r15)     // Catch:{ Exception -> 0x0110 }
            java.lang.String r15 = r15.toString()     // Catch:{ Exception -> 0x0110 }
            r7.setRequestProperty(r8, r15)     // Catch:{ Exception -> 0x0110 }
            java.lang.String r15 = "Content-Type"
            java.lang.String r5 = "application/json"
            r7.setRequestProperty(r15, r5)     // Catch:{ Exception -> 0x0110 }
            r15 = 1
            r7.setDoOutput(r15)     // Catch:{ Exception -> 0x0110 }
            java.io.OutputStreamWriter r15 = new java.io.OutputStreamWriter     // Catch:{ Exception -> 0x0110 }
            java.io.OutputStream r5 = r7.getOutputStream()     // Catch:{ Exception -> 0x0110 }
            r15.<init>(r5)     // Catch:{ Exception -> 0x0110 }
            java.io.Closeable r15 = (java.io.Closeable) r15     // Catch:{ Exception -> 0x0110 }
            r5 = r15
            java.io.OutputStreamWriter r5 = (java.io.OutputStreamWriter) r5     // Catch:{ all -> 0x0108 }
            java.lang.String r8 = "{}"
            r5.write(r8)     // Catch:{ all -> 0x0108 }
            r5.flush()     // Catch:{ all -> 0x0108 }
            kotlin.Unit r5 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0108 }
            r5 = 0
            kotlin.io.CloseableKt.closeFinally(r15, r5)     // Catch:{ Exception -> 0x0110 }
            int r15 = r7.getResponseCode()     // Catch:{ Exception -> 0x0110 }
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0110 }
            r8.<init>(r4)     // Catch:{ Exception -> 0x0110 }
            java.lang.StringBuilder r4 = r8.append(r15)     // Catch:{ Exception -> 0x0110 }
            java.lang.String r4 = r4.toString()     // Catch:{ Exception -> 0x0110 }
            android.util.Log.d(r2, r4)     // Catch:{ Exception -> 0x0110 }
            r4 = 300(0x12c, float:4.2E-43)
            r8 = 200(0xc8, float:2.8E-43)
            if (r8 > r15) goto L_0x008b
            if (r15 >= r4) goto L_0x008b
            java.io.InputStream r7 = r7.getInputStream()     // Catch:{ Exception -> 0x0110 }
            goto L_0x008f
        L_0x008b:
            java.io.InputStream r7 = r7.getErrorStream()     // Catch:{ Exception -> 0x0110 }
        L_0x008f:
            java.io.BufferedReader r9 = new java.io.BufferedReader     // Catch:{ Exception -> 0x0110 }
            java.io.InputStreamReader r10 = new java.io.InputStreamReader     // Catch:{ Exception -> 0x0110 }
            r10.<init>(r7)     // Catch:{ Exception -> 0x0110 }
            java.io.Reader r10 = (java.io.Reader) r10     // Catch:{ Exception -> 0x0110 }
            r9.<init>(r10)     // Catch:{ Exception -> 0x0110 }
            java.io.Closeable r9 = (java.io.Closeable) r9     // Catch:{ Exception -> 0x0110 }
            r7 = r9
            java.io.BufferedReader r7 = (java.io.BufferedReader) r7     // Catch:{ all -> 0x0100 }
            java.io.Reader r7 = (java.io.Reader) r7     // Catch:{ all -> 0x0100 }
            java.lang.String r7 = kotlin.io.TextStreamsKt.readText(r7)     // Catch:{ all -> 0x0100 }
            kotlin.io.CloseableKt.closeFinally(r9, r5)     // Catch:{ Exception -> 0x0110 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0110 }
            r5.<init>(r3)     // Catch:{ Exception -> 0x0110 }
            java.lang.StringBuilder r3 = r5.append(r7)     // Catch:{ Exception -> 0x0110 }
            java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x0110 }
            android.util.Log.d(r2, r3)     // Catch:{ Exception -> 0x0110 }
            java.lang.String r3 = "message"
            if (r8 > r15) goto L_0x00de
            if (r15 >= r4) goto L_0x00de
            org.json.JSONObject r15 = new org.json.JSONObject     // Catch:{ Exception -> 0x0110 }
            r15.<init>(r7)     // Catch:{ Exception -> 0x0110 }
            com.armmc.app.api.TunnelApiService$TunnelTerminateResponse r8 = new com.armmc.app.api.TunnelApiService$TunnelTerminateResponse     // Catch:{ Exception -> 0x0110 }
            java.lang.String r0 = "success"
            boolean r9 = r15.optBoolean(r0, r6)     // Catch:{ Exception -> 0x0110 }
            java.lang.String r0 = "Tunnel terminated"
            java.lang.String r10 = r15.optString(r3, r0)     // Catch:{ Exception -> 0x0110 }
            java.lang.String r15 = "optString(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r10, r15)     // Catch:{ Exception -> 0x0110 }
            r12 = 4
            r13 = 0
            r11 = 0
            r8.<init>(r9, r10, r11, r12, r13)     // Catch:{ Exception -> 0x0110 }
            goto L_0x0127
        L_0x00de:
            org.json.JSONObject r4 = new org.json.JSONObject     // Catch:{ Exception -> 0x00e4 }
            r4.<init>(r7)     // Catch:{ Exception -> 0x00e4 }
            goto L_0x00e9
        L_0x00e4:
            org.json.JSONObject r4 = new org.json.JSONObject     // Catch:{ Exception -> 0x0110 }
            r4.<init>()     // Catch:{ Exception -> 0x0110 }
        L_0x00e9:
            com.armmc.app.api.TunnelApiService$TunnelTerminateResponse r8 = new com.armmc.app.api.TunnelApiService$TunnelTerminateResponse     // Catch:{ Exception -> 0x0110 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0110 }
            r5.<init>(r0)     // Catch:{ Exception -> 0x0110 }
            java.lang.StringBuilder r15 = r5.append(r15)     // Catch:{ Exception -> 0x0110 }
            java.lang.String r15 = r15.toString()     // Catch:{ Exception -> 0x0110 }
            java.lang.String r15 = r4.optString(r3, r15)     // Catch:{ Exception -> 0x0110 }
            r8.<init>(r6, r1, r15)     // Catch:{ Exception -> 0x0110 }
            goto L_0x0127
        L_0x0100:
            r0 = move-exception
            r15 = r0
            throw r15     // Catch:{ all -> 0x0103 }
        L_0x0103:
            r0 = move-exception
            kotlin.io.CloseableKt.closeFinally(r9, r15)     // Catch:{ Exception -> 0x0110 }
            throw r0     // Catch:{ Exception -> 0x0110 }
        L_0x0108:
            r0 = move-exception
            r3 = r0
            throw r3     // Catch:{ all -> 0x010b }
        L_0x010b:
            r0 = move-exception
            kotlin.io.CloseableKt.closeFinally(r15, r3)     // Catch:{ Exception -> 0x0110 }
            throw r0     // Catch:{ Exception -> 0x0110 }
        L_0x0110:
            r0 = move-exception
            r15 = r0
            java.lang.String r0 = "Error terminating tunnel"
            r3 = r15
            java.lang.Throwable r3 = (java.lang.Throwable) r3
            android.util.Log.e(r2, r0, r3)
            com.armmc.app.api.TunnelApiService$TunnelTerminateResponse r8 = new com.armmc.app.api.TunnelApiService$TunnelTerminateResponse
            java.lang.String r15 = r15.getMessage()
            if (r15 != 0) goto L_0x0124
            java.lang.String r15 = "Network error"
        L_0x0124:
            r8.<init>(r6, r1, r15)
        L_0x0127:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.armmc.app.api.TunnelApiService.terminateTunnel(java.lang.String):com.armmc.app.api.TunnelApiService$TunnelTerminateResponse");
    }

    public final TunnelStatusResponse getTunnelStatus(String str) {
        InputStream inputStream;
        Throwable th;
        String str2 = str;
        Intrinsics.checkNotNullParameter(str2, "firebaseIdToken");
        try {
            URLConnection openConnection = new URL("https://api.witherhost.com/api/tunnel/status").openConnection();
            Intrinsics.checkNotNull(openConnection, "null cannot be cast to non-null type java.net.HttpURLConnection");
            HttpURLConnection httpURLConnection = (HttpURLConnection) openConnection;
            httpURLConnection.setRequestMethod(ShareTarget.METHOD_GET);
            httpURLConnection.setConnectTimeout(TIMEOUT_MS);
            httpURLConnection.setReadTimeout(TIMEOUT_MS);
            httpURLConnection.setRequestProperty(HttpHeaders.AUTHORIZATION, "Bearer " + str2);
            httpURLConnection.setRequestProperty(HttpHeaders.CONTENT_TYPE, "application/json");
            int responseCode = httpURLConnection.getResponseCode();
            Log.d(TAG, "Tunnel status response code: " + responseCode);
            if (200 > responseCode || responseCode >= 300) {
                inputStream = httpURLConnection.getErrorStream();
            } else {
                inputStream = httpURLConnection.getInputStream();
            }
            Closeable bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            try {
                String readText = TextStreamsKt.readText((BufferedReader) bufferedReader);
                String str3 = null;
                CloseableKt.closeFinally(bufferedReader, (Throwable) null);
                Log.d(TAG, "Tunnel status response: " + readText);
                if (200 > responseCode || responseCode >= 300) {
                    return new TunnelStatusResponse(false, (String) null, (Integer) null, (String) null, (String) null, false, "Status check failed with code " + responseCode);
                }
                JSONObject jSONObject = new JSONObject(readText);
                JSONObject optJSONObject = jSONObject.optJSONObject("tunnel");
                boolean optBoolean = jSONObject.optBoolean("active", false);
                String optString = optJSONObject != null ? optJSONObject.optString("subdomain") : null;
                Integer valueOf = optJSONObject != null ? Integer.valueOf(optJSONObject.optInt("remotePort")) : null;
                String optString2 = optJSONObject != null ? optJSONObject.optString(NotificationCompat.CATEGORY_STATUS) : null;
                if (optJSONObject != null) {
                    str3 = optJSONObject.optString("token");
                }
                return new TunnelStatusResponse(optBoolean, optString, valueOf, optString2, str3, jSONObject.optBoolean("processRunning", false), (String) null, 64, (DefaultConstructorMarker) null);
            } catch (Throwable th2) {
                CloseableKt.closeFinally(bufferedReader, th);
                throw th2;
            }
        } catch (Exception e) {
            Log.e(TAG, "Error checking tunnel status", e);
            String message = e.getMessage();
            if (message == null) {
                message = "Network error";
            }
            return new TunnelStatusResponse(false, (String) null, (Integer) null, (String) null, (String) null, false, message);
        }
    }

    static /* synthetic */ TunnelRequestResponse parseTunnelRequestResponse$default(TunnelApiService tunnelApiService, String str, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 200;
        }
        return tunnelApiService.parseTunnelRequestResponse(str, i);
    }

    private final TunnelRequestResponse parseTunnelRequestResponse(String str, int i) {
        int optInt;
        String str2;
        String str3;
        String str4;
        JSONObject jSONObject = new JSONObject(str);
        JSONObject optJSONObject = jSONObject.optJSONObject("tunnel");
        JSONObject optJSONObject2 = jSONObject.optJSONObject("connectionInfo");
        if (optJSONObject2 != null) {
            optInt = optJSONObject2.optInt("serverPort");
        } else {
            optInt = optJSONObject != null ? optJSONObject.optInt("bindPort") : 7000;
        }
        int i2 = optInt;
        int i3 = 0;
        boolean optBoolean = jSONObject.optBoolean("success", false);
        boolean optBoolean2 = jSONObject.optBoolean("existing", false);
        if (optJSONObject == null || (str2 = optJSONObject.optString("subdomain")) == null) {
            str2 = "";
        }
        if (optJSONObject2 == null || (str3 = optJSONObject2.optString("token")) == null) {
            str3 = optJSONObject != null ? optJSONObject.optString("token") : null;
            if (str3 == null) {
                str3 = "";
            }
        }
        if (optJSONObject2 != null) {
            i3 = optJSONObject2.optInt("remotePort");
        } else if (optJSONObject != null) {
            i3 = optJSONObject.optInt("remotePort");
        }
        int i4 = i3;
        if (optJSONObject2 == null || (str4 = optJSONObject2.optString("serverAddress")) == null) {
            str4 = "witherhost.com";
        }
        String optString = jSONObject.optString(LogManager.EXTRA_MESSAGE, "");
        Intrinsics.checkNotNullExpressionValue(optString, "optString(...)");
        return new TunnelRequestResponse(optBoolean, optBoolean2, str2, str3, i4, str4, i2, optString, (String) null, i, 256, (DefaultConstructorMarker) null);
    }
}
