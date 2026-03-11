package com.armmc.app.frp;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b3\b\b\u0018\u0000 =2\u00020\u0001:\u0001=B\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\r\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0003\u0012\u0006\u0010\u0010\u001a\u00020\u0005\u0012\u0006\u0010\u0011\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u000b¢\u0006\u0004\b\u0014\u0010\u0015J\u0006\u0010(\u001a\u00020\u0003J\t\u0010)\u001a\u00020\u0003HÆ\u0003J\t\u0010*\u001a\u00020\u0005HÆ\u0003J\t\u0010+\u001a\u00020\u0003HÆ\u0003J\t\u0010,\u001a\u00020\u0003HÆ\u0003J\t\u0010-\u001a\u00020\u0003HÆ\u0003J\t\u0010.\u001a\u00020\u0003HÆ\u0003J\t\u0010/\u001a\u00020\u000bHÆ\u0003J\t\u00100\u001a\u00020\u0003HÆ\u0003J\t\u00101\u001a\u00020\u0003HÆ\u0003J\t\u00102\u001a\u00020\u0003HÆ\u0003J\t\u00103\u001a\u00020\u0003HÆ\u0003J\t\u00104\u001a\u00020\u0005HÆ\u0003J\t\u00105\u001a\u00020\u0005HÆ\u0003J\t\u00106\u001a\u00020\u000bHÆ\u0003J\t\u00107\u001a\u00020\u000bHÆ\u0003J\u0001\u00108\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u00052\b\b\u0002\u0010\u0011\u001a\u00020\u00052\b\b\u0002\u0010\u0012\u001a\u00020\u000b2\b\b\u0002\u0010\u0013\u001a\u00020\u000bHÆ\u0001J\u0013\u00109\u001a\u00020\u000b2\b\u0010:\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010;\u001a\u00020\u0005HÖ\u0001J\t\u0010<\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0017R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0017R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0017R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0017R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0017R\u0011\u0010\r\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0017R\u0011\u0010\u000e\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0017R\u0011\u0010\u000f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0017R\u0011\u0010\u0010\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0019R\u0011\u0010\u0011\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0019R\u0011\u0010\u0012\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u001fR\u0011\u0010\u0013\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u001f¨\u0006>"}, d2 = {"Lcom/armmc/app/frp/FRPConfig;", "", "serverAddr", "", "serverPort", "", "authMethod", "authToken", "user", "protocol", "tlsEnable", "", "tlsServerName", "proxyName", "proxyType", "localIP", "localPort", "remotePort", "useEncryption", "useCompression", "<init>", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IIZZ)V", "getServerAddr", "()Ljava/lang/String;", "getServerPort", "()I", "getAuthMethod", "getAuthToken", "getUser", "getProtocol", "getTlsEnable", "()Z", "getTlsServerName", "getProxyName", "getProxyType", "getLocalIP", "getLocalPort", "getRemotePort", "getUseEncryption", "getUseCompression", "toJson", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "copy", "equals", "other", "hashCode", "toString", "Companion", "app_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* compiled from: FRPClient.kt */
public final class FRPConfig {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final String authMethod;
    private final String authToken;
    private final String localIP;
    private final int localPort;
    private final String protocol;
    private final String proxyName;
    private final String proxyType;
    private final int remotePort;
    private final String serverAddr;
    private final int serverPort;
    private final boolean tlsEnable;
    private final String tlsServerName;
    private final boolean useCompression;
    private final boolean useEncryption;
    private final String user;

    public static /* synthetic */ FRPConfig copy$default(FRPConfig fRPConfig, String str, int i, String str2, String str3, String str4, String str5, boolean z, String str6, String str7, String str8, String str9, int i2, int i3, boolean z2, boolean z3, int i4, Object obj) {
        FRPConfig fRPConfig2 = fRPConfig;
        int i5 = i4;
        return fRPConfig2.copy((i5 & 1) != 0 ? fRPConfig2.serverAddr : str, (i5 & 2) != 0 ? fRPConfig2.serverPort : i, (i5 & 4) != 0 ? fRPConfig2.authMethod : str2, (i5 & 8) != 0 ? fRPConfig2.authToken : str3, (i5 & 16) != 0 ? fRPConfig2.user : str4, (i5 & 32) != 0 ? fRPConfig2.protocol : str5, (i5 & 64) != 0 ? fRPConfig2.tlsEnable : z, (i5 & 128) != 0 ? fRPConfig2.tlsServerName : str6, (i5 & 256) != 0 ? fRPConfig2.proxyName : str7, (i5 & 512) != 0 ? fRPConfig2.proxyType : str8, (i5 & 1024) != 0 ? fRPConfig2.localIP : str9, (i5 & 2048) != 0 ? fRPConfig2.localPort : i2, (i5 & 4096) != 0 ? fRPConfig2.remotePort : i3, (i5 & 8192) != 0 ? fRPConfig2.useEncryption : z2, (i5 & 16384) != 0 ? fRPConfig2.useCompression : z3);
    }

    public final String component1() {
        return this.serverAddr;
    }

    public final String component10() {
        return this.proxyType;
    }

    public final String component11() {
        return this.localIP;
    }

    public final int component12() {
        return this.localPort;
    }

    public final int component13() {
        return this.remotePort;
    }

    public final boolean component14() {
        return this.useEncryption;
    }

    public final boolean component15() {
        return this.useCompression;
    }

    public final int component2() {
        return this.serverPort;
    }

    public final String component3() {
        return this.authMethod;
    }

    public final String component4() {
        return this.authToken;
    }

    public final String component5() {
        return this.user;
    }

    public final String component6() {
        return this.protocol;
    }

    public final boolean component7() {
        return this.tlsEnable;
    }

    public final String component8() {
        return this.tlsServerName;
    }

    public final String component9() {
        return this.proxyName;
    }

    public final FRPConfig copy(String str, int i, String str2, String str3, String str4, String str5, boolean z, String str6, String str7, String str8, String str9, int i2, int i3, boolean z2, boolean z3) {
        String str10 = str;
        Intrinsics.checkNotNullParameter(str10, "serverAddr");
        String str11 = str2;
        Intrinsics.checkNotNullParameter(str11, "authMethod");
        String str12 = str3;
        Intrinsics.checkNotNullParameter(str12, "authToken");
        String str13 = str4;
        Intrinsics.checkNotNullParameter(str13, "user");
        String str14 = str5;
        Intrinsics.checkNotNullParameter(str14, "protocol");
        String str15 = str6;
        Intrinsics.checkNotNullParameter(str15, "tlsServerName");
        String str16 = str7;
        Intrinsics.checkNotNullParameter(str16, "proxyName");
        String str17 = str8;
        Intrinsics.checkNotNullParameter(str17, "proxyType");
        String str18 = str9;
        Intrinsics.checkNotNullParameter(str18, "localIP");
        return new FRPConfig(str10, i, str11, str12, str13, str14, z, str15, str16, str17, str18, i2, i3, z2, z3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FRPConfig)) {
            return false;
        }
        FRPConfig fRPConfig = (FRPConfig) obj;
        return Intrinsics.areEqual((Object) this.serverAddr, (Object) fRPConfig.serverAddr) && this.serverPort == fRPConfig.serverPort && Intrinsics.areEqual((Object) this.authMethod, (Object) fRPConfig.authMethod) && Intrinsics.areEqual((Object) this.authToken, (Object) fRPConfig.authToken) && Intrinsics.areEqual((Object) this.user, (Object) fRPConfig.user) && Intrinsics.areEqual((Object) this.protocol, (Object) fRPConfig.protocol) && this.tlsEnable == fRPConfig.tlsEnable && Intrinsics.areEqual((Object) this.tlsServerName, (Object) fRPConfig.tlsServerName) && Intrinsics.areEqual((Object) this.proxyName, (Object) fRPConfig.proxyName) && Intrinsics.areEqual((Object) this.proxyType, (Object) fRPConfig.proxyType) && Intrinsics.areEqual((Object) this.localIP, (Object) fRPConfig.localIP) && this.localPort == fRPConfig.localPort && this.remotePort == fRPConfig.remotePort && this.useEncryption == fRPConfig.useEncryption && this.useCompression == fRPConfig.useCompression;
    }

    public int hashCode() {
        return (((((((((((((((((((((((((((this.serverAddr.hashCode() * 31) + Integer.hashCode(this.serverPort)) * 31) + this.authMethod.hashCode()) * 31) + this.authToken.hashCode()) * 31) + this.user.hashCode()) * 31) + this.protocol.hashCode()) * 31) + Boolean.hashCode(this.tlsEnable)) * 31) + this.tlsServerName.hashCode()) * 31) + this.proxyName.hashCode()) * 31) + this.proxyType.hashCode()) * 31) + this.localIP.hashCode()) * 31) + Integer.hashCode(this.localPort)) * 31) + Integer.hashCode(this.remotePort)) * 31) + Boolean.hashCode(this.useEncryption)) * 31) + Boolean.hashCode(this.useCompression);
    }

    public String toString() {
        String str = this.serverAddr;
        int i = this.serverPort;
        String str2 = this.authMethod;
        String str3 = this.authToken;
        String str4 = this.user;
        String str5 = this.protocol;
        boolean z = this.tlsEnable;
        String str6 = this.tlsServerName;
        String str7 = this.proxyName;
        String str8 = this.proxyType;
        String str9 = this.localIP;
        int i2 = this.localPort;
        int i3 = this.remotePort;
        return "FRPConfig(serverAddr=" + str + ", serverPort=" + i + ", authMethod=" + str2 + ", authToken=" + str3 + ", user=" + str4 + ", protocol=" + str5 + ", tlsEnable=" + z + ", tlsServerName=" + str6 + ", proxyName=" + str7 + ", proxyType=" + str8 + ", localIP=" + str9 + ", localPort=" + i2 + ", remotePort=" + i3 + ", useEncryption=" + this.useEncryption + ", useCompression=" + this.useCompression + ")";
    }

    public FRPConfig(String str, int i, String str2, String str3, String str4, String str5, boolean z, String str6, String str7, String str8, String str9, int i2, int i3, boolean z2, boolean z3) {
        Intrinsics.checkNotNullParameter(str, "serverAddr");
        Intrinsics.checkNotNullParameter(str2, "authMethod");
        Intrinsics.checkNotNullParameter(str3, "authToken");
        Intrinsics.checkNotNullParameter(str4, "user");
        Intrinsics.checkNotNullParameter(str5, "protocol");
        Intrinsics.checkNotNullParameter(str6, "tlsServerName");
        Intrinsics.checkNotNullParameter(str7, "proxyName");
        Intrinsics.checkNotNullParameter(str8, "proxyType");
        Intrinsics.checkNotNullParameter(str9, "localIP");
        this.serverAddr = str;
        this.serverPort = i;
        this.authMethod = str2;
        this.authToken = str3;
        this.user = str4;
        this.protocol = str5;
        this.tlsEnable = z;
        this.tlsServerName = str6;
        this.proxyName = str7;
        this.proxyType = str8;
        this.localIP = str9;
        this.localPort = i2;
        this.remotePort = i3;
        this.useEncryption = z2;
        this.useCompression = z3;
    }

    public final String getServerAddr() {
        return this.serverAddr;
    }

    public final int getServerPort() {
        return this.serverPort;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ FRPConfig(java.lang.String r19, int r20, java.lang.String r21, java.lang.String r22, java.lang.String r23, java.lang.String r24, boolean r25, java.lang.String r26, java.lang.String r27, java.lang.String r28, java.lang.String r29, int r30, int r31, boolean r32, boolean r33, int r34, kotlin.jvm.internal.DefaultConstructorMarker r35) {
        /*
            r18 = this;
            r0 = r34
            r1 = r0 & 2
            if (r1 == 0) goto L_0x000a
            r1 = 7000(0x1b58, float:9.809E-42)
            r4 = r1
            goto L_0x000c
        L_0x000a:
            r4 = r20
        L_0x000c:
            r1 = r0 & 4
            if (r1 == 0) goto L_0x0014
            java.lang.String r1 = "token"
            r5 = r1
            goto L_0x0016
        L_0x0014:
            r5 = r21
        L_0x0016:
            r1 = r0 & 8
            java.lang.String r2 = ""
            if (r1 == 0) goto L_0x001e
            r6 = r2
            goto L_0x0020
        L_0x001e:
            r6 = r22
        L_0x0020:
            r1 = r0 & 16
            if (r1 == 0) goto L_0x0026
            r7 = r2
            goto L_0x0028
        L_0x0026:
            r7 = r23
        L_0x0028:
            r1 = r0 & 32
            java.lang.String r3 = "tcp"
            if (r1 == 0) goto L_0x0030
            r8 = r3
            goto L_0x0032
        L_0x0030:
            r8 = r24
        L_0x0032:
            r1 = r0 & 64
            r9 = 0
            if (r1 == 0) goto L_0x0039
            r1 = r9
            goto L_0x003b
        L_0x0039:
            r1 = r25
        L_0x003b:
            r10 = r0 & 128(0x80, float:1.794E-43)
            if (r10 == 0) goto L_0x0041
            r10 = r2
            goto L_0x0043
        L_0x0041:
            r10 = r26
        L_0x0043:
            r2 = r0 & 256(0x100, float:3.59E-43)
            if (r2 == 0) goto L_0x004b
            java.lang.String r2 = "minecraft"
            r11 = r2
            goto L_0x004d
        L_0x004b:
            r11 = r27
        L_0x004d:
            r2 = r0 & 512(0x200, float:7.175E-43)
            if (r2 == 0) goto L_0x0053
            r12 = r3
            goto L_0x0055
        L_0x0053:
            r12 = r28
        L_0x0055:
            r2 = r0 & 1024(0x400, float:1.435E-42)
            if (r2 == 0) goto L_0x005d
            java.lang.String r2 = "127.0.0.1"
            r13 = r2
            goto L_0x005f
        L_0x005d:
            r13 = r29
        L_0x005f:
            r2 = r0 & 8192(0x2000, float:1.14794E-41)
            if (r2 == 0) goto L_0x0066
            r16 = r9
            goto L_0x0068
        L_0x0066:
            r16 = r32
        L_0x0068:
            r0 = r0 & 16384(0x4000, float:2.2959E-41)
            if (r0 == 0) goto L_0x006f
            r17 = r9
            goto L_0x0071
        L_0x006f:
            r17 = r33
        L_0x0071:
            r2 = r18
            r3 = r19
            r14 = r30
            r15 = r31
            r9 = r1
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.armmc.app.frp.FRPConfig.<init>(java.lang.String, int, java.lang.String, java.lang.String, java.lang.String, java.lang.String, boolean, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, int, boolean, boolean, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final String getAuthMethod() {
        return this.authMethod;
    }

    public final String getAuthToken() {
        return this.authToken;
    }

    public final String getUser() {
        return this.user;
    }

    public final String getProtocol() {
        return this.protocol;
    }

    public final boolean getTlsEnable() {
        return this.tlsEnable;
    }

    public final String getTlsServerName() {
        return this.tlsServerName;
    }

    public final String getProxyName() {
        return this.proxyName;
    }

    public final String getProxyType() {
        return this.proxyType;
    }

    public final String getLocalIP() {
        return this.localIP;
    }

    public final int getLocalPort() {
        return this.localPort;
    }

    public final int getRemotePort() {
        return this.remotePort;
    }

    public final boolean getUseEncryption() {
        return this.useEncryption;
    }

    public final boolean getUseCompression() {
        return this.useCompression;
    }

    public final String toJson() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("serverAddr", this.serverAddr);
        jSONObject.put("serverPort", this.serverPort);
        jSONObject.put("authMethod", this.authMethod);
        jSONObject.put("authToken", this.authToken);
        jSONObject.put("user", this.user);
        jSONObject.put("protocol", this.protocol);
        jSONObject.put("tlsEnable", this.tlsEnable);
        jSONObject.put("tlsServerName", this.tlsServerName);
        jSONObject.put("proxyName", this.proxyName);
        jSONObject.put("proxyType", this.proxyType);
        jSONObject.put("localIP", this.localIP);
        jSONObject.put("localPort", this.localPort);
        jSONObject.put("remotePort", this.remotePort);
        jSONObject.put("useEncryption", this.useEncryption);
        jSONObject.put("useCompression", this.useCompression);
        String jSONObject2 = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject2, "toString(...)");
        return jSONObject2;
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J4\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00072\b\b\u0002\u0010\u000b\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\t¨\u0006\r"}, d2 = {"Lcom/armmc/app/frp/FRPConfig$Companion;", "", "<init>", "()V", "forMinecraft", "Lcom/armmc/app/frp/FRPConfig;", "serverAddr", "", "serverPort", "", "authToken", "localPort", "remotePort", "app_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* compiled from: FRPClient.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static /* synthetic */ FRPConfig forMinecraft$default(Companion companion, String str, int i, String str2, int i2, int i3, int i4, Object obj) {
            if ((i4 & 2) != 0) {
                i = 7000;
            }
            return companion.forMinecraft(str, i, str2, (i4 & 8) != 0 ? 25565 : i2, (i4 & 16) != 0 ? 25565 : i3);
        }

        public final FRPConfig forMinecraft(String str, int i, String str2, int i2, int i3) {
            String str3 = str;
            Intrinsics.checkNotNullParameter(str3, "serverAddr");
            String str4 = str2;
            Intrinsics.checkNotNullParameter(str4, "authToken");
            return new FRPConfig(str3, i, (String) null, str4, (String) null, (String) null, false, (String) null, "minecraft", "tcp", "127.0.0.1", i2, i3, false, false, 24820, (DefaultConstructorMarker) null);
        }
    }
}
