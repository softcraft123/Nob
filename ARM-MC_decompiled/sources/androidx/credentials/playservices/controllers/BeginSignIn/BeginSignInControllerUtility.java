package androidx.credentials.playservices.controllers.BeginSignIn;

import android.content.Context;
import android.content.pm.PackageManager;
import com.google.android.gms.auth.api.identity.BeginSignInRequest;
import com.google.android.libraries.identity.googleid.GetGoogleIdOption;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0000\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Landroidx/credentials/playservices/controllers/BeginSignIn/BeginSignInControllerUtility;", "", "()V", "Companion", "credentials-play-services-auth_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: BeginSignInControllerUtility.kt */
public final class BeginSignInControllerUtility {
    private static final long AUTH_MIN_VERSION_JSON_PARSING = 231815000;
    private static final long AUTH_MIN_VERSION_PREFER_IMME_CRED = 241217000;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String TAG = "BeginSignInUtility";

    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001d\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0000¢\u0006\u0002\b\u000eJ\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u0010\u0010\u0013\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\rH\u0002J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0004H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Landroidx/credentials/playservices/controllers/BeginSignIn/BeginSignInControllerUtility$Companion;", "", "()V", "AUTH_MIN_VERSION_JSON_PARSING", "", "AUTH_MIN_VERSION_PREFER_IMME_CRED", "TAG", "", "constructBeginSignInRequest", "Lcom/google/android/gms/auth/api/identity/BeginSignInRequest;", "request", "Landroidx/credentials/GetCredentialRequest;", "context", "Landroid/content/Context;", "constructBeginSignInRequest$credentials_play_services_auth_release", "convertToGoogleIdTokenOption", "Lcom/google/android/gms/auth/api/identity/BeginSignInRequest$GoogleIdTokenRequestOptions;", "option", "Lcom/google/android/libraries/identity/googleid/GetGoogleIdOption;", "determineDeviceGMSVersionCode", "needsBackwardsCompatibleRequest", "", "curAuthVersion", "credentials-play-services-auth_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: BeginSignInControllerUtility.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final boolean needsBackwardsCompatibleRequest(long j) {
            return j < BeginSignInControllerUtility.AUTH_MIN_VERSION_JSON_PARSING;
        }

        private Companion() {
        }

        /* JADX WARNING: Code restructure failed: missing block: B:24:0x0084, code lost:
            if (r6.getAutoSelectEnabled() == false) goto L_0x0048;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:8:0x0045, code lost:
            if (r6.isAutoSelectAllowed() == false) goto L_0x0048;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final com.google.android.gms.auth.api.identity.BeginSignInRequest constructBeginSignInRequest$credentials_play_services_auth_release(androidx.credentials.GetCredentialRequest r10, android.content.Context r11) {
            /*
                r9 = this;
                java.lang.String r0 = "request"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
                java.lang.String r0 = "context"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
                com.google.android.gms.auth.api.identity.BeginSignInRequest$Builder r0 = new com.google.android.gms.auth.api.identity.BeginSignInRequest$Builder
                r0.<init>()
                long r1 = r9.determineDeviceGMSVersionCode(r11)
                java.util.List r11 = r10.getCredentialOptions()
                java.util.Iterator r11 = r11.iterator()
                r3 = 0
                r4 = r3
                r5 = r4
            L_0x001e:
                boolean r6 = r11.hasNext()
                if (r6 == 0) goto L_0x0087
                java.lang.Object r6 = r11.next()
                androidx.credentials.CredentialOption r6 = (androidx.credentials.CredentialOption) r6
                boolean r7 = r6 instanceof androidx.credentials.GetPasswordOption
                r8 = 1
                if (r7 == 0) goto L_0x004c
                com.google.android.gms.auth.api.identity.BeginSignInRequest$PasswordRequestOptions$Builder r7 = new com.google.android.gms.auth.api.identity.BeginSignInRequest$PasswordRequestOptions$Builder
                r7.<init>()
                com.google.android.gms.auth.api.identity.BeginSignInRequest$PasswordRequestOptions$Builder r7 = r7.setSupported(r8)
                com.google.android.gms.auth.api.identity.BeginSignInRequest$PasswordRequestOptions r7 = r7.build()
                r0.setPasswordRequestOptions(r7)
                if (r4 != 0) goto L_0x004a
                boolean r4 = r6.isAutoSelectAllowed()
                if (r4 == 0) goto L_0x0048
                goto L_0x004a
            L_0x0048:
                r4 = r3
                goto L_0x001e
            L_0x004a:
                r4 = r8
                goto L_0x001e
            L_0x004c:
                boolean r7 = r6 instanceof androidx.credentials.GetPublicKeyCredentialOption
                if (r7 == 0) goto L_0x0071
                if (r5 != 0) goto L_0x0071
                boolean r5 = r9.needsBackwardsCompatibleRequest(r1)
                if (r5 == 0) goto L_0x0064
                androidx.credentials.playservices.controllers.CreatePublicKeyCredential.PublicKeyCredentialControllerUtility$Companion r5 = androidx.credentials.playservices.controllers.CreatePublicKeyCredential.PublicKeyCredentialControllerUtility.Companion
                androidx.credentials.GetPublicKeyCredentialOption r6 = (androidx.credentials.GetPublicKeyCredentialOption) r6
                com.google.android.gms.auth.api.identity.BeginSignInRequest$PasskeysRequestOptions r5 = r5.convertToPlayAuthPasskeyRequest(r6)
                r0.setPasskeysSignInRequestOptions(r5)
                goto L_0x006f
            L_0x0064:
                androidx.credentials.playservices.controllers.CreatePublicKeyCredential.PublicKeyCredentialControllerUtility$Companion r5 = androidx.credentials.playservices.controllers.CreatePublicKeyCredential.PublicKeyCredentialControllerUtility.Companion
                androidx.credentials.GetPublicKeyCredentialOption r6 = (androidx.credentials.GetPublicKeyCredentialOption) r6
                com.google.android.gms.auth.api.identity.BeginSignInRequest$PasskeyJsonRequestOptions r5 = r5.convertToPlayAuthPasskeyJsonRequest(r6)
                r0.setPasskeyJsonSignInRequestOptions(r5)
            L_0x006f:
                r5 = r8
                goto L_0x001e
            L_0x0071:
                boolean r7 = r6 instanceof com.google.android.libraries.identity.googleid.GetGoogleIdOption
                if (r7 == 0) goto L_0x001e
                com.google.android.libraries.identity.googleid.GetGoogleIdOption r6 = (com.google.android.libraries.identity.googleid.GetGoogleIdOption) r6
                com.google.android.gms.auth.api.identity.BeginSignInRequest$GoogleIdTokenRequestOptions r7 = r9.convertToGoogleIdTokenOption(r6)
                r0.setGoogleIdTokenRequestOptions(r7)
                if (r4 != 0) goto L_0x004a
                boolean r4 = r6.getAutoSelectEnabled()
                if (r4 == 0) goto L_0x0048
                goto L_0x004a
            L_0x0087:
                r5 = 241217000(0xe60ade8, double:1.19177033E-315)
                int r11 = (r1 > r5 ? 1 : (r1 == r5 ? 0 : -1))
                if (r11 <= 0) goto L_0x0095
                boolean r10 = r10.preferImmediatelyAvailableCredentials()
                r0.setPreferImmediatelyAvailableCredentials(r10)
            L_0x0095:
                com.google.android.gms.auth.api.identity.BeginSignInRequest$Builder r10 = r0.setAutoSelectEnabled(r4)
                com.google.android.gms.auth.api.identity.BeginSignInRequest r10 = r10.build()
                java.lang.String r11 = "requestBuilder.setAutoSe…abled(autoSelect).build()"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r10, r11)
                return r10
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.credentials.playservices.controllers.BeginSignIn.BeginSignInControllerUtility.Companion.constructBeginSignInRequest$credentials_play_services_auth_release(androidx.credentials.GetCredentialRequest, android.content.Context):com.google.android.gms.auth.api.identity.BeginSignInRequest");
        }

        private final long determineDeviceGMSVersionCode(Context context) {
            PackageManager packageManager = context.getPackageManager();
            Intrinsics.checkNotNullExpressionValue(packageManager, "context.packageManager");
            return (long) packageManager.getPackageInfo("com.google.android.gms", 0).versionCode;
        }

        private final BeginSignInRequest.GoogleIdTokenRequestOptions convertToGoogleIdTokenOption(GetGoogleIdOption getGoogleIdOption) {
            BeginSignInRequest.GoogleIdTokenRequestOptions.Builder supported = BeginSignInRequest.GoogleIdTokenRequestOptions.builder().setFilterByAuthorizedAccounts(getGoogleIdOption.getFilterByAuthorizedAccounts()).setNonce(getGoogleIdOption.getNonce()).setRequestVerifiedPhoneNumber(getGoogleIdOption.getRequestVerifiedPhoneNumber()).setServerClientId(getGoogleIdOption.getServerClientId()).setSupported(true);
            Intrinsics.checkNotNullExpressionValue(supported, "builder()\n              …      .setSupported(true)");
            if (getGoogleIdOption.getLinkedServiceId() != null) {
                String linkedServiceId = getGoogleIdOption.getLinkedServiceId();
                Intrinsics.checkNotNull(linkedServiceId);
                supported.associateLinkedAccounts(linkedServiceId, getGoogleIdOption.getIdTokenDepositionScopes());
            }
            BeginSignInRequest.GoogleIdTokenRequestOptions build = supported.build();
            Intrinsics.checkNotNullExpressionValue(build, "idTokenOption.build()");
            return build;
        }
    }
}
