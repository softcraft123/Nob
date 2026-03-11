package com.armmc.app;

import android.util.Log;
import com.armmc.app.ui.servers.WhitelistEntry;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00102\u00020\u0001:\u0002\u0010\u0011B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u0010\u0010\r\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u0010\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\tH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/armmc/app/MinecraftApiService;", "", "<init>", "()V", "gson", "Lcom/google/gson/Gson;", "lookupPlayer", "Lcom/armmc/app/MinecraftApiService$LookupResult;", "username", "", "readResponse", "connection", "Ljava/net/HttpURLConnection;", "readErrorResponse", "parsePlayerResponse", "response", "Companion", "LookupResult", "app_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* compiled from: MinecraftApiService.kt */
public final class MinecraftApiService {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String PROFILE_LOOKUP_URL = "https://api.minecraftservices.com/minecraft/profile/lookup/name/";
    private static final String TAG = "MinecraftApiService";
    private static final int TIMEOUT_MS = 10000;
    private final Gson gson = new Gson();

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bXT¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/armmc/app/MinecraftApiService$Companion;", "", "<init>", "()V", "TAG", "", "PROFILE_LOOKUP_URL", "TIMEOUT_MS", "", "app_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* compiled from: MinecraftApiService.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0004\u0004\u0005\u0006\u0007B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0001\u0004\b\t\n\u000b¨\u0006\f"}, d2 = {"Lcom/armmc/app/MinecraftApiService$LookupResult;", "", "<init>", "()V", "Success", "NotFound", "Error", "RateLimited", "Lcom/armmc/app/MinecraftApiService$LookupResult$Error;", "Lcom/armmc/app/MinecraftApiService$LookupResult$NotFound;", "Lcom/armmc/app/MinecraftApiService$LookupResult$RateLimited;", "Lcom/armmc/app/MinecraftApiService$LookupResult$Success;", "app_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* compiled from: MinecraftApiService.kt */
    public static abstract class LookupResult {
        public /* synthetic */ LookupResult(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/armmc/app/MinecraftApiService$LookupResult$Success;", "Lcom/armmc/app/MinecraftApiService$LookupResult;", "entry", "Lcom/armmc/app/ui/servers/WhitelistEntry;", "<init>", "(Lcom/armmc/app/ui/servers/WhitelistEntry;)V", "getEntry", "()Lcom/armmc/app/ui/servers/WhitelistEntry;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "app_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
        /* compiled from: MinecraftApiService.kt */
        public static final class Success extends LookupResult {
            private final WhitelistEntry entry;

            public static /* synthetic */ Success copy$default(Success success, WhitelistEntry whitelistEntry, int i, Object obj) {
                if ((i & 1) != 0) {
                    whitelistEntry = success.entry;
                }
                return success.copy(whitelistEntry);
            }

            public final WhitelistEntry component1() {
                return this.entry;
            }

            public final Success copy(WhitelistEntry whitelistEntry) {
                Intrinsics.checkNotNullParameter(whitelistEntry, "entry");
                return new Success(whitelistEntry);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof Success) && Intrinsics.areEqual((Object) this.entry, (Object) ((Success) obj).entry);
            }

            public int hashCode() {
                return this.entry.hashCode();
            }

            public String toString() {
                return "Success(entry=" + this.entry + ")";
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public Success(WhitelistEntry whitelistEntry) {
                super((DefaultConstructorMarker) null);
                Intrinsics.checkNotNullParameter(whitelistEntry, "entry");
                this.entry = whitelistEntry;
            }

            public final WhitelistEntry getEntry() {
                return this.entry;
            }
        }

        private LookupResult() {
        }

        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/armmc/app/MinecraftApiService$LookupResult$NotFound;", "Lcom/armmc/app/MinecraftApiService$LookupResult;", "username", "", "<init>", "(Ljava/lang/String;)V", "getUsername", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "app_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
        /* compiled from: MinecraftApiService.kt */
        public static final class NotFound extends LookupResult {
            private final String username;

            public static /* synthetic */ NotFound copy$default(NotFound notFound, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = notFound.username;
                }
                return notFound.copy(str);
            }

            public final String component1() {
                return this.username;
            }

            public final NotFound copy(String str) {
                Intrinsics.checkNotNullParameter(str, "username");
                return new NotFound(str);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof NotFound) && Intrinsics.areEqual((Object) this.username, (Object) ((NotFound) obj).username);
            }

            public int hashCode() {
                return this.username.hashCode();
            }

            public String toString() {
                return "NotFound(username=" + this.username + ")";
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public NotFound(String str) {
                super((DefaultConstructorMarker) null);
                Intrinsics.checkNotNullParameter(str, "username");
                this.username = str;
            }

            public final String getUsername() {
                return this.username;
            }
        }

        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/armmc/app/MinecraftApiService$LookupResult$Error;", "Lcom/armmc/app/MinecraftApiService$LookupResult;", "message", "", "errorCode", "", "<init>", "(Ljava/lang/String;I)V", "getMessage", "()Ljava/lang/String;", "getErrorCode", "()I", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "app_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
        /* compiled from: MinecraftApiService.kt */
        public static final class Error extends LookupResult {
            private final int errorCode;
            private final String message;

            public static /* synthetic */ Error copy$default(Error error, String str, int i, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    str = error.message;
                }
                if ((i2 & 2) != 0) {
                    i = error.errorCode;
                }
                return error.copy(str, i);
            }

            public final String component1() {
                return this.message;
            }

            public final int component2() {
                return this.errorCode;
            }

            public final Error copy(String str, int i) {
                Intrinsics.checkNotNullParameter(str, LogManager.EXTRA_MESSAGE);
                return new Error(str, i);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof Error)) {
                    return false;
                }
                Error error = (Error) obj;
                return Intrinsics.areEqual((Object) this.message, (Object) error.message) && this.errorCode == error.errorCode;
            }

            public int hashCode() {
                return (this.message.hashCode() * 31) + Integer.hashCode(this.errorCode);
            }

            public String toString() {
                String str = this.message;
                return "Error(message=" + str + ", errorCode=" + this.errorCode + ")";
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public Error(String str, int i) {
                super((DefaultConstructorMarker) null);
                Intrinsics.checkNotNullParameter(str, LogManager.EXTRA_MESSAGE);
                this.message = str;
                this.errorCode = i;
            }

            /* JADX INFO: this call moved to the top of the method (can break code semantics) */
            public /* synthetic */ Error(String str, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
                this(str, (i2 & 2) != 0 ? 0 : i);
            }

            public final int getErrorCode() {
                return this.errorCode;
            }

            public final String getMessage() {
                return this.message;
            }
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/armmc/app/MinecraftApiService$LookupResult$RateLimited;", "Lcom/armmc/app/MinecraftApiService$LookupResult;", "<init>", "()V", "app_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
        /* compiled from: MinecraftApiService.kt */
        public static final class RateLimited extends LookupResult {
            public static final RateLimited INSTANCE = new RateLimited();

            private RateLimited() {
                super((DefaultConstructorMarker) null);
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:40:0x016c  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0174  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.armmc.app.MinecraftApiService.LookupResult lookupPlayer(java.lang.String r15) {
        /*
            r14 = this;
            java.lang.String r0 = "MinecraftApiService"
            java.lang.String r1 = "Access forbidden: "
            java.lang.String r2 = "HTTP "
            java.lang.String r3 = "Bad request: "
            java.lang.String r4 = "Lookup for '"
            java.lang.String r5 = "Network error: "
            java.lang.String r6 = "Error looking up player '"
            java.lang.String r7 = "https://api.minecraftservices.com/minecraft/profile/lookup/name/"
            java.lang.String r8 = "username"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r8)
            r8 = r15
            java.lang.CharSequence r8 = (java.lang.CharSequence) r8
            boolean r9 = kotlin.text.StringsKt.isBlank(r8)
            r10 = 2
            r11 = 0
            r12 = 0
            if (r9 == 0) goto L_0x002b
            com.armmc.app.MinecraftApiService$LookupResult$Error r15 = new com.armmc.app.MinecraftApiService$LookupResult$Error
            java.lang.String r0 = "Username cannot be empty"
            r15.<init>(r0, r11, r10, r12)
            com.armmc.app.MinecraftApiService$LookupResult r15 = (com.armmc.app.MinecraftApiService.LookupResult) r15
            return r15
        L_0x002b:
            kotlin.text.Regex r9 = new kotlin.text.Regex
            java.lang.String r13 = "^[a-zA-Z0-9_]{3,16}$"
            r9.<init>((java.lang.String) r13)
            boolean r8 = r9.matches(r8)
            if (r8 != 0) goto L_0x0042
            com.armmc.app.MinecraftApiService$LookupResult$Error r15 = new com.armmc.app.MinecraftApiService$LookupResult$Error
            java.lang.String r0 = "Invalid username format. Must be 3-16 characters, alphanumeric and underscores only."
            r15.<init>(r0, r11, r10, r12)
            com.armmc.app.MinecraftApiService$LookupResult r15 = (com.armmc.app.MinecraftApiService.LookupResult) r15
            return r15
        L_0x0042:
            java.net.URL r8 = new java.net.URL     // Catch:{ Exception -> 0x0137, all -> 0x0135 }
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0137, all -> 0x0135 }
            r9.<init>(r7)     // Catch:{ Exception -> 0x0137, all -> 0x0135 }
            java.lang.StringBuilder r7 = r9.append(r15)     // Catch:{ Exception -> 0x0137, all -> 0x0135 }
            java.lang.String r7 = r7.toString()     // Catch:{ Exception -> 0x0137, all -> 0x0135 }
            r8.<init>(r7)     // Catch:{ Exception -> 0x0137, all -> 0x0135 }
            java.net.URLConnection r7 = r8.openConnection()     // Catch:{ Exception -> 0x0137, all -> 0x0135 }
            java.lang.String r8 = "null cannot be cast to non-null type java.net.HttpURLConnection"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r7, r8)     // Catch:{ Exception -> 0x0137, all -> 0x0135 }
            java.net.HttpURLConnection r7 = (java.net.HttpURLConnection) r7     // Catch:{ Exception -> 0x0137, all -> 0x0135 }
            java.lang.String r8 = "GET"
            r7.setRequestMethod(r8)     // Catch:{ Exception -> 0x0137, all -> 0x0135 }
            r8 = 10000(0x2710, float:1.4013E-41)
            r7.setConnectTimeout(r8)     // Catch:{ Exception -> 0x0137, all -> 0x0135 }
            r7.setReadTimeout(r8)     // Catch:{ Exception -> 0x0137, all -> 0x0135 }
            java.lang.String r8 = "Accept"
            java.lang.String r9 = "application/json"
            r7.setRequestProperty(r8, r9)     // Catch:{ Exception -> 0x0137, all -> 0x0135 }
            int r8 = r7.getResponseCode()     // Catch:{ Exception -> 0x0133 }
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0133 }
            r9.<init>(r4)     // Catch:{ Exception -> 0x0133 }
            java.lang.StringBuilder r4 = r9.append(r15)     // Catch:{ Exception -> 0x0133 }
            java.lang.String r9 = "' returned HTTP "
            java.lang.StringBuilder r4 = r4.append(r9)     // Catch:{ Exception -> 0x0133 }
            java.lang.StringBuilder r4 = r4.append(r8)     // Catch:{ Exception -> 0x0133 }
            java.lang.String r4 = r4.toString()     // Catch:{ Exception -> 0x0133 }
            android.util.Log.d(r0, r4)     // Catch:{ Exception -> 0x0133 }
            r4 = 200(0xc8, float:2.8E-43)
            if (r8 == r4) goto L_0x0127
            r4 = 400(0x190, float:5.6E-43)
            if (r8 == r4) goto L_0x010d
            r3 = 429(0x1ad, float:6.01E-43)
            if (r8 == r3) goto L_0x0102
            r3 = 403(0x193, float:5.65E-43)
            if (r8 == r3) goto L_0x00d1
            r1 = 404(0x194, float:5.66E-43)
            if (r8 == r1) goto L_0x00c8
            java.lang.String r1 = r14.readErrorResponse(r7)     // Catch:{ Exception -> 0x0133 }
            com.armmc.app.MinecraftApiService$LookupResult$Error r3 = new com.armmc.app.MinecraftApiService$LookupResult$Error     // Catch:{ Exception -> 0x0133 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0133 }
            r4.<init>(r2)     // Catch:{ Exception -> 0x0133 }
            java.lang.StringBuilder r2 = r4.append(r8)     // Catch:{ Exception -> 0x0133 }
            java.lang.String r4 = ": "
            java.lang.StringBuilder r2 = r2.append(r4)     // Catch:{ Exception -> 0x0133 }
            java.lang.StringBuilder r1 = r2.append(r1)     // Catch:{ Exception -> 0x0133 }
            java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x0133 }
            r3.<init>(r1, r8)     // Catch:{ Exception -> 0x0133 }
            com.armmc.app.MinecraftApiService$LookupResult r3 = (com.armmc.app.MinecraftApiService.LookupResult) r3     // Catch:{ Exception -> 0x0133 }
            goto L_0x012f
        L_0x00c8:
            com.armmc.app.MinecraftApiService$LookupResult$NotFound r1 = new com.armmc.app.MinecraftApiService$LookupResult$NotFound     // Catch:{ Exception -> 0x0133 }
            r1.<init>(r15)     // Catch:{ Exception -> 0x0133 }
            r3 = r1
            com.armmc.app.MinecraftApiService$LookupResult r3 = (com.armmc.app.MinecraftApiService.LookupResult) r3     // Catch:{ Exception -> 0x0133 }
            goto L_0x012f
        L_0x00d1:
            java.lang.String r2 = r14.readErrorResponse(r7)     // Catch:{ Exception -> 0x0133 }
            r3 = r2
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3     // Catch:{ Exception -> 0x0133 }
            java.lang.String r4 = "ACCOUNT_SUSPENDED"
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4     // Catch:{ Exception -> 0x0133 }
            r9 = 1
            boolean r3 = kotlin.text.StringsKt.contains((java.lang.CharSequence) r3, (java.lang.CharSequence) r4, (boolean) r9)     // Catch:{ Exception -> 0x0133 }
            if (r3 == 0) goto L_0x00eb
            com.armmc.app.MinecraftApiService$LookupResult$Error r1 = new com.armmc.app.MinecraftApiService$LookupResult$Error     // Catch:{ Exception -> 0x0133 }
            java.lang.String r2 = "Account lookup temporarily unavailable"
            r1.<init>(r2, r8)     // Catch:{ Exception -> 0x0133 }
            goto L_0x00fe
        L_0x00eb:
            com.armmc.app.MinecraftApiService$LookupResult$Error r3 = new com.armmc.app.MinecraftApiService$LookupResult$Error     // Catch:{ Exception -> 0x0133 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0133 }
            r4.<init>(r1)     // Catch:{ Exception -> 0x0133 }
            java.lang.StringBuilder r1 = r4.append(r2)     // Catch:{ Exception -> 0x0133 }
            java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x0133 }
            r3.<init>(r1, r8)     // Catch:{ Exception -> 0x0133 }
            r1 = r3
        L_0x00fe:
            r3 = r1
            com.armmc.app.MinecraftApiService$LookupResult r3 = (com.armmc.app.MinecraftApiService.LookupResult) r3     // Catch:{ Exception -> 0x0133 }
            goto L_0x012f
        L_0x0102:
            java.lang.String r1 = "Rate limited by Minecraft API"
            android.util.Log.w(r0, r1)     // Catch:{ Exception -> 0x0133 }
            com.armmc.app.MinecraftApiService$LookupResult$RateLimited r1 = com.armmc.app.MinecraftApiService.LookupResult.RateLimited.INSTANCE     // Catch:{ Exception -> 0x0133 }
            r3 = r1
            com.armmc.app.MinecraftApiService$LookupResult r3 = (com.armmc.app.MinecraftApiService.LookupResult) r3     // Catch:{ Exception -> 0x0133 }
            goto L_0x012f
        L_0x010d:
            java.lang.String r1 = r14.readErrorResponse(r7)     // Catch:{ Exception -> 0x0133 }
            com.armmc.app.MinecraftApiService$LookupResult$Error r2 = new com.armmc.app.MinecraftApiService$LookupResult$Error     // Catch:{ Exception -> 0x0133 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0133 }
            r4.<init>(r3)     // Catch:{ Exception -> 0x0133 }
            java.lang.StringBuilder r1 = r4.append(r1)     // Catch:{ Exception -> 0x0133 }
            java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x0133 }
            r2.<init>(r1, r8)     // Catch:{ Exception -> 0x0133 }
            r3 = r2
            com.armmc.app.MinecraftApiService$LookupResult r3 = (com.armmc.app.MinecraftApiService.LookupResult) r3     // Catch:{ Exception -> 0x0133 }
            goto L_0x012f
        L_0x0127:
            java.lang.String r1 = r14.readResponse(r7)     // Catch:{ Exception -> 0x0133 }
            com.armmc.app.MinecraftApiService$LookupResult r3 = r14.parsePlayerResponse(r1)     // Catch:{ Exception -> 0x0133 }
        L_0x012f:
            r7.disconnect()
            return r3
        L_0x0133:
            r1 = move-exception
            goto L_0x0139
        L_0x0135:
            r15 = move-exception
            goto L_0x0172
        L_0x0137:
            r1 = move-exception
            r7 = r12
        L_0x0139:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0170 }
            r2.<init>(r6)     // Catch:{ all -> 0x0170 }
            java.lang.StringBuilder r15 = r2.append(r15)     // Catch:{ all -> 0x0170 }
            java.lang.String r2 = "'"
            java.lang.StringBuilder r15 = r15.append(r2)     // Catch:{ all -> 0x0170 }
            java.lang.String r15 = r15.toString()     // Catch:{ all -> 0x0170 }
            r2 = r1
            java.lang.Throwable r2 = (java.lang.Throwable) r2     // Catch:{ all -> 0x0170 }
            android.util.Log.e(r0, r15, r2)     // Catch:{ all -> 0x0170 }
            com.armmc.app.MinecraftApiService$LookupResult$Error r15 = new com.armmc.app.MinecraftApiService$LookupResult$Error     // Catch:{ all -> 0x0170 }
            java.lang.String r0 = r1.getMessage()     // Catch:{ all -> 0x0170 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0170 }
            r1.<init>(r5)     // Catch:{ all -> 0x0170 }
            java.lang.StringBuilder r0 = r1.append(r0)     // Catch:{ all -> 0x0170 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0170 }
            r15.<init>(r0, r11, r10, r12)     // Catch:{ all -> 0x0170 }
            com.armmc.app.MinecraftApiService$LookupResult r15 = (com.armmc.app.MinecraftApiService.LookupResult) r15     // Catch:{ all -> 0x0170 }
            if (r7 == 0) goto L_0x016f
            r7.disconnect()
        L_0x016f:
            return r15
        L_0x0170:
            r15 = move-exception
            r12 = r7
        L_0x0172:
            if (r12 == 0) goto L_0x0177
            r12.disconnect()
        L_0x0177:
            throw r15
        */
        throw new UnsupportedOperationException("Method not decompiled: com.armmc.app.MinecraftApiService.lookupPlayer(java.lang.String):com.armmc.app.MinecraftApiService$LookupResult");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0026, code lost:
        throw r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0022, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0023, code lost:
        kotlin.io.CloseableKt.closeFinally(r0, r3);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.lang.String readResponse(java.net.HttpURLConnection r3) {
        /*
            r2 = this;
            java.io.BufferedReader r0 = new java.io.BufferedReader
            java.io.InputStreamReader r1 = new java.io.InputStreamReader
            java.io.InputStream r3 = r3.getInputStream()
            r1.<init>(r3)
            java.io.Reader r1 = (java.io.Reader) r1
            r0.<init>(r1)
            java.io.Closeable r0 = (java.io.Closeable) r0
            r3 = r0
            java.io.BufferedReader r3 = (java.io.BufferedReader) r3     // Catch:{ all -> 0x0020 }
            java.io.Reader r3 = (java.io.Reader) r3     // Catch:{ all -> 0x0020 }
            java.lang.String r3 = kotlin.io.TextStreamsKt.readText(r3)     // Catch:{ all -> 0x0020 }
            r1 = 0
            kotlin.io.CloseableKt.closeFinally(r0, r1)
            return r3
        L_0x0020:
            r3 = move-exception
            throw r3     // Catch:{ all -> 0x0022 }
        L_0x0022:
            r1 = move-exception
            kotlin.io.CloseableKt.closeFinally(r0, r3)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.armmc.app.MinecraftApiService.readResponse(java.net.HttpURLConnection):java.lang.String");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0022, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:?, code lost:
        kotlin.io.CloseableKt.closeFinally(r0, r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0026, code lost:
        throw r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.lang.String readErrorResponse(java.net.HttpURLConnection r3) {
        /*
            r2 = this;
            java.io.BufferedReader r0 = new java.io.BufferedReader     // Catch:{ Exception -> 0x0027 }
            java.io.InputStreamReader r1 = new java.io.InputStreamReader     // Catch:{ Exception -> 0x0027 }
            java.io.InputStream r3 = r3.getErrorStream()     // Catch:{ Exception -> 0x0027 }
            r1.<init>(r3)     // Catch:{ Exception -> 0x0027 }
            java.io.Reader r1 = (java.io.Reader) r1     // Catch:{ Exception -> 0x0027 }
            r0.<init>(r1)     // Catch:{ Exception -> 0x0027 }
            java.io.Closeable r0 = (java.io.Closeable) r0     // Catch:{ Exception -> 0x0027 }
            r3 = r0
            java.io.BufferedReader r3 = (java.io.BufferedReader) r3     // Catch:{ all -> 0x0020 }
            java.io.Reader r3 = (java.io.Reader) r3     // Catch:{ all -> 0x0020 }
            java.lang.String r3 = kotlin.io.TextStreamsKt.readText(r3)     // Catch:{ all -> 0x0020 }
            r1 = 0
            kotlin.io.CloseableKt.closeFinally(r0, r1)     // Catch:{ Exception -> 0x0027 }
            return r3
        L_0x0020:
            r3 = move-exception
            throw r3     // Catch:{ all -> 0x0022 }
        L_0x0022:
            r1 = move-exception
            kotlin.io.CloseableKt.closeFinally(r0, r3)     // Catch:{ Exception -> 0x0027 }
            throw r1     // Catch:{ Exception -> 0x0027 }
        L_0x0027:
            java.lang.String r3 = "Unable to read error response"
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.armmc.app.MinecraftApiService.readErrorResponse(java.net.HttpURLConnection):java.lang.String");
    }

    private final LookupResult parsePlayerResponse(String str) {
        try {
            JsonObject jsonObject = (JsonObject) this.gson.fromJson(str, JsonObject.class);
            JsonElement jsonElement = jsonObject.get("id");
            String asString = jsonElement != null ? jsonElement.getAsString() : null;
            JsonElement jsonElement2 = jsonObject.get("name");
            String asString2 = jsonElement2 != null ? jsonElement2.getAsString() : null;
            if (asString == null || asString2 == null) {
                return new LookupResult.Error("Invalid response format", 0, 2, (DefaultConstructorMarker) null);
            }
            return new LookupResult.Success(new WhitelistEntry(WhitelistEntry.Companion.formatUuid(asString), asString2));
        } catch (Exception e) {
            Log.e(TAG, "Error parsing player response", e);
            return new LookupResult.Error("Failed to parse response: " + e.getMessage(), 0, 2, (DefaultConstructorMarker) null);
        }
    }
}
