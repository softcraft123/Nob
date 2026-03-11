package androidx.credentials.webauthn;

import com.google.android.gms.fido.u2f.api.common.ClientData;
import java.security.MessageDigest;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0007\u0018\u00002\u00020\u0001B]\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\t\u0012\u0006\u0010\f\u001a\u00020\t\u0012\u0006\u0010\r\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0010J\u0006\u0010\u001f\u001a\u00020\u0005J\u0006\u0010 \u001a\u00020\u0005J\b\u0010!\u001a\u00020\u0017H\u0016R\u001a\u0010\u0011\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u000e\u0010\u000b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0005X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0016\u001a\u00020\u0017X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u001c\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0013\"\u0004\b\u001e\u0010\u0015R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Landroidx/credentials/webauthn/AuthenticatorAssertionResponse;", "Landroidx/credentials/webauthn/AuthenticatorResponse;", "requestOptions", "Landroidx/credentials/webauthn/PublicKeyCredentialRequestOptions;", "credentialId", "", "origin", "", "up", "", "uv", "be", "bs", "userHandle", "packageName", "clientDataHash", "(Landroidx/credentials/webauthn/PublicKeyCredentialRequestOptions;[BLjava/lang/String;ZZZZ[BLjava/lang/String;[B)V", "authenticatorData", "getAuthenticatorData", "()[B", "setAuthenticatorData", "([B)V", "clientJson", "Lorg/json/JSONObject;", "getClientJson", "()Lorg/json/JSONObject;", "setClientJson", "(Lorg/json/JSONObject;)V", "signature", "getSignature", "setSignature", "dataToSign", "defaultAuthenticatorData", "json", "credentials_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: AuthenticatorAssertionResponse.kt */
public final class AuthenticatorAssertionResponse implements AuthenticatorResponse {
    private byte[] authenticatorData;
    private final boolean be;
    private final boolean bs;
    private final byte[] clientDataHash;
    private JSONObject clientJson;
    private final byte[] credentialId;
    private final String origin;
    private final String packageName;
    private final PublicKeyCredentialRequestOptions requestOptions;
    private byte[] signature;
    private final boolean up;
    private byte[] userHandle;
    private final boolean uv;

    public AuthenticatorAssertionResponse(PublicKeyCredentialRequestOptions publicKeyCredentialRequestOptions, byte[] bArr, String str, boolean z, boolean z2, boolean z3, boolean z4, byte[] bArr2, String str2, byte[] bArr3) {
        Intrinsics.checkNotNullParameter(publicKeyCredentialRequestOptions, "requestOptions");
        Intrinsics.checkNotNullParameter(bArr, "credentialId");
        Intrinsics.checkNotNullParameter(str, "origin");
        Intrinsics.checkNotNullParameter(bArr2, "userHandle");
        this.requestOptions = publicKeyCredentialRequestOptions;
        this.credentialId = bArr;
        this.origin = str;
        this.up = z;
        this.uv = z2;
        this.be = z3;
        this.bs = z4;
        this.userHandle = bArr2;
        this.packageName = str2;
        this.clientDataHash = bArr3;
        this.clientJson = new JSONObject();
        this.signature = new byte[0];
        getClientJson().put("type", "webauthn.get");
        getClientJson().put(ClientData.KEY_CHALLENGE, WebAuthnUtils.Companion.b64Encode(publicKeyCredentialRequestOptions.getChallenge()));
        getClientJson().put("origin", str);
        if (str2 != null) {
            getClientJson().put("androidPackageName", str2);
        }
        this.authenticatorData = defaultAuthenticatorData();
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ AuthenticatorAssertionResponse(androidx.credentials.webauthn.PublicKeyCredentialRequestOptions r2, byte[] r3, java.lang.String r4, boolean r5, boolean r6, boolean r7, boolean r8, byte[] r9, java.lang.String r10, byte[] r11, int r12, kotlin.jvm.internal.DefaultConstructorMarker r13) {
        /*
            r1 = this;
            r13 = r12 & 256(0x100, float:3.59E-43)
            r0 = 0
            if (r13 == 0) goto L_0x0006
            r10 = r0
        L_0x0006:
            r12 = r12 & 512(0x200, float:7.175E-43)
            if (r12 == 0) goto L_0x000c
            r12 = r0
            goto L_0x000d
        L_0x000c:
            r12 = r11
        L_0x000d:
            r11 = r10
            r10 = r9
            r9 = r8
            r8 = r7
            r7 = r6
            r6 = r5
            r5 = r4
            r4 = r3
            r3 = r2
            r2 = r1
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.credentials.webauthn.AuthenticatorAssertionResponse.<init>(androidx.credentials.webauthn.PublicKeyCredentialRequestOptions, byte[], java.lang.String, boolean, boolean, boolean, boolean, byte[], java.lang.String, byte[], int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public JSONObject getClientJson() {
        return this.clientJson;
    }

    public void setClientJson(JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(jSONObject, "<set-?>");
        this.clientJson = jSONObject;
    }

    public final byte[] getAuthenticatorData() {
        return this.authenticatorData;
    }

    public final void setAuthenticatorData(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "<set-?>");
        this.authenticatorData = bArr;
    }

    public final byte[] getSignature() {
        return this.signature;
    }

    public final void setSignature(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "<set-?>");
        this.signature = bArr;
    }

    public final byte[] defaultAuthenticatorData() {
        MessageDigest instance = MessageDigest.getInstance("SHA-256");
        byte[] bytes = this.requestOptions.getRpId().getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
        byte[] digest = instance.digest(bytes);
        boolean z = this.up;
        if (this.uv) {
            z |= true;
        }
        if (this.be) {
            z |= true;
        }
        if (this.bs) {
            z |= true;
        }
        Intrinsics.checkNotNullExpressionValue(digest, "rpHash");
        return ArraysKt.plus(ArraysKt.plus(digest, new byte[]{z ? (byte) 1 : 0}), new byte[]{0, 0, 0, 0});
    }

    public final byte[] dataToSign() {
        MessageDigest instance = MessageDigest.getInstance("SHA-256");
        byte[] bArr = this.clientDataHash;
        if (bArr == null) {
            String jSONObject = getClientJson().toString();
            Intrinsics.checkNotNullExpressionValue(jSONObject, "clientJson.toString()");
            byte[] bytes = jSONObject.getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
            bArr = instance.digest(bytes);
            Intrinsics.checkNotNullExpressionValue(bArr, "md.digest(clientJson.toString().toByteArray())");
        }
        return ArraysKt.plus(this.authenticatorData, bArr);
    }

    public JSONObject json() {
        String jSONObject = getClientJson().toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject, "clientJson.toString()");
        byte[] bytes = jSONObject.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
        JSONObject jSONObject2 = new JSONObject();
        if (this.clientDataHash == null) {
            jSONObject2.put("clientDataJSON", WebAuthnUtils.Companion.b64Encode(bytes));
        }
        jSONObject2.put("authenticatorData", WebAuthnUtils.Companion.b64Encode(this.authenticatorData));
        jSONObject2.put("signature", WebAuthnUtils.Companion.b64Encode(this.signature));
        jSONObject2.put("userHandle", WebAuthnUtils.Companion.b64Encode(this.userHandle));
        return jSONObject2;
    }
}
