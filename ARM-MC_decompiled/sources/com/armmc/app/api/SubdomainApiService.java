package com.armmc.app.api;

import android.util.Log;
import com.armmc.app.LogManager;
import com.armmc.app.billing.UserSubscriptionManager;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u00112\u00020\u0001:\u0004\u0011\u0012\u0013\u0014B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u0016\u0010\b\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0007J\u0016\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0007J\u0010\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u0007H\u0002J\u0010\u0010\u000f\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u0007H\u0002J\u0010\u0010\u0010\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u0007H\u0002¨\u0006\u0015"}, d2 = {"Lcom/armmc/app/api/SubdomainApiService;", "", "<init>", "()V", "getSubdomainStatus", "Lcom/armmc/app/api/SubdomainApiService$SubdomainStatusResponse;", "firebaseIdToken", "", "checkSubdomainAvailability", "Lcom/armmc/app/api/SubdomainApiService$SubdomainAvailabilityResponse;", "subdomain", "claimSubdomain", "Lcom/armmc/app/api/SubdomainApiService$SubdomainClaimResponse;", "parseSubdomainStatusResponse", "response", "parseAvailabilityResponse", "parseClaimResponse", "Companion", "SubdomainStatusResponse", "SubdomainAvailabilityResponse", "SubdomainClaimResponse", "app_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* compiled from: SubdomainApiService.kt */
public final class SubdomainApiService {
    private static final String BASE_URL = "https://api.witherhost.com/api/supporter";
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String TAG = "SubdomainApiService";
    private static final int TIMEOUT_MS = 30000;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bXT¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/armmc/app/api/SubdomainApiService$Companion;", "", "<init>", "()V", "TAG", "", "BASE_URL", "TIMEOUT_MS", "", "app_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* compiled from: SubdomainApiService.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0018\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001BO\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0007HÆ\u0003JW\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u001d\u001a\u00020\u00032\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020 HÖ\u0001J\t\u0010!\u001a\u00020\u0007HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0011¨\u0006\""}, d2 = {"Lcom/armmc/app/api/SubdomainApiService$SubdomainStatusResponse;", "", "success", "", "isSupporter", "hasClaimed", "subdomain", "", "fullDomain", "message", "error", "<init>", "(ZZZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getSuccess", "()Z", "getHasClaimed", "getSubdomain", "()Ljava/lang/String;", "getFullDomain", "getMessage", "getError", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* compiled from: SubdomainApiService.kt */
    public static final class SubdomainStatusResponse {
        private final String error;
        private final String fullDomain;
        private final boolean hasClaimed;
        private final boolean isSupporter;
        private final String message;
        private final String subdomain;
        private final boolean success;

        public static /* synthetic */ SubdomainStatusResponse copy$default(SubdomainStatusResponse subdomainStatusResponse, boolean z, boolean z2, boolean z3, String str, String str2, String str3, String str4, int i, Object obj) {
            if ((i & 1) != 0) {
                z = subdomainStatusResponse.success;
            }
            if ((i & 2) != 0) {
                z2 = subdomainStatusResponse.isSupporter;
            }
            if ((i & 4) != 0) {
                z3 = subdomainStatusResponse.hasClaimed;
            }
            if ((i & 8) != 0) {
                str = subdomainStatusResponse.subdomain;
            }
            if ((i & 16) != 0) {
                str2 = subdomainStatusResponse.fullDomain;
            }
            if ((i & 32) != 0) {
                str3 = subdomainStatusResponse.message;
            }
            if ((i & 64) != 0) {
                str4 = subdomainStatusResponse.error;
            }
            String str5 = str3;
            String str6 = str4;
            String str7 = str;
            String str8 = str2;
            return subdomainStatusResponse.copy(z, z2, z3, str7, str8, str5, str6);
        }

        public final boolean component1() {
            return this.success;
        }

        public final boolean component2() {
            return this.isSupporter;
        }

        public final boolean component3() {
            return this.hasClaimed;
        }

        public final String component4() {
            return this.subdomain;
        }

        public final String component5() {
            return this.fullDomain;
        }

        public final String component6() {
            return this.message;
        }

        public final String component7() {
            return this.error;
        }

        public final SubdomainStatusResponse copy(boolean z, boolean z2, boolean z3, String str, String str2, String str3, String str4) {
            return new SubdomainStatusResponse(z, z2, z3, str, str2, str3, str4);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof SubdomainStatusResponse)) {
                return false;
            }
            SubdomainStatusResponse subdomainStatusResponse = (SubdomainStatusResponse) obj;
            return this.success == subdomainStatusResponse.success && this.isSupporter == subdomainStatusResponse.isSupporter && this.hasClaimed == subdomainStatusResponse.hasClaimed && Intrinsics.areEqual((Object) this.subdomain, (Object) subdomainStatusResponse.subdomain) && Intrinsics.areEqual((Object) this.fullDomain, (Object) subdomainStatusResponse.fullDomain) && Intrinsics.areEqual((Object) this.message, (Object) subdomainStatusResponse.message) && Intrinsics.areEqual((Object) this.error, (Object) subdomainStatusResponse.error);
        }

        public int hashCode() {
            int hashCode = ((((Boolean.hashCode(this.success) * 31) + Boolean.hashCode(this.isSupporter)) * 31) + Boolean.hashCode(this.hasClaimed)) * 31;
            String str = this.subdomain;
            int i = 0;
            int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.fullDomain;
            int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.message;
            int hashCode4 = (hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
            String str4 = this.error;
            if (str4 != null) {
                i = str4.hashCode();
            }
            return hashCode4 + i;
        }

        public String toString() {
            boolean z = this.success;
            boolean z2 = this.isSupporter;
            boolean z3 = this.hasClaimed;
            String str = this.subdomain;
            String str2 = this.fullDomain;
            String str3 = this.message;
            return "SubdomainStatusResponse(success=" + z + ", isSupporter=" + z2 + ", hasClaimed=" + z3 + ", subdomain=" + str + ", fullDomain=" + str2 + ", message=" + str3 + ", error=" + this.error + ")";
        }

        public SubdomainStatusResponse(boolean z, boolean z2, boolean z3, String str, String str2, String str3, String str4) {
            this.success = z;
            this.isSupporter = z2;
            this.hasClaimed = z3;
            this.subdomain = str;
            this.fullDomain = str2;
            this.message = str3;
            this.error = str4;
        }

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public /* synthetic */ SubdomainStatusResponse(boolean r2, boolean r3, boolean r4, java.lang.String r5, java.lang.String r6, java.lang.String r7, java.lang.String r8, int r9, kotlin.jvm.internal.DefaultConstructorMarker r10) {
            /*
                r1 = this;
                r10 = r9 & 8
                r0 = 0
                if (r10 == 0) goto L_0x0006
                r5 = r0
            L_0x0006:
                r10 = r9 & 16
                if (r10 == 0) goto L_0x000b
                r6 = r0
            L_0x000b:
                r10 = r9 & 32
                if (r10 == 0) goto L_0x0010
                r7 = r0
            L_0x0010:
                r9 = r9 & 64
                if (r9 == 0) goto L_0x0016
                r9 = r0
                goto L_0x0017
            L_0x0016:
                r9 = r8
            L_0x0017:
                r8 = r7
                r7 = r6
                r6 = r5
                r5 = r4
                r4 = r3
                r3 = r2
                r2 = r1
                r2.<init>(r3, r4, r5, r6, r7, r8, r9)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.armmc.app.api.SubdomainApiService.SubdomainStatusResponse.<init>(boolean, boolean, boolean, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
        }

        public final boolean getSuccess() {
            return this.success;
        }

        public final boolean isSupporter() {
            return this.isSupporter;
        }

        public final boolean getHasClaimed() {
            return this.hasClaimed;
        }

        public final String getSubdomain() {
            return this.subdomain;
        }

        public final String getFullDomain() {
            return this.fullDomain;
        }

        public final String getMessage() {
            return this.message;
        }

        public final String getError() {
            return this.error;
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0005HÆ\u0003J7\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00032\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\r¨\u0006\u001a"}, d2 = {"Lcom/armmc/app/api/SubdomainApiService$SubdomainAvailabilityResponse;", "", "available", "", "subdomain", "", "reason", "error", "<init>", "(ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAvailable", "()Z", "getSubdomain", "()Ljava/lang/String;", "getReason", "getError", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* compiled from: SubdomainApiService.kt */
    public static final class SubdomainAvailabilityResponse {
        private final boolean available;
        private final String error;
        private final String reason;
        private final String subdomain;

        public static /* synthetic */ SubdomainAvailabilityResponse copy$default(SubdomainAvailabilityResponse subdomainAvailabilityResponse, boolean z, String str, String str2, String str3, int i, Object obj) {
            if ((i & 1) != 0) {
                z = subdomainAvailabilityResponse.available;
            }
            if ((i & 2) != 0) {
                str = subdomainAvailabilityResponse.subdomain;
            }
            if ((i & 4) != 0) {
                str2 = subdomainAvailabilityResponse.reason;
            }
            if ((i & 8) != 0) {
                str3 = subdomainAvailabilityResponse.error;
            }
            return subdomainAvailabilityResponse.copy(z, str, str2, str3);
        }

        public final boolean component1() {
            return this.available;
        }

        public final String component2() {
            return this.subdomain;
        }

        public final String component3() {
            return this.reason;
        }

        public final String component4() {
            return this.error;
        }

        public final SubdomainAvailabilityResponse copy(boolean z, String str, String str2, String str3) {
            return new SubdomainAvailabilityResponse(z, str, str2, str3);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof SubdomainAvailabilityResponse)) {
                return false;
            }
            SubdomainAvailabilityResponse subdomainAvailabilityResponse = (SubdomainAvailabilityResponse) obj;
            return this.available == subdomainAvailabilityResponse.available && Intrinsics.areEqual((Object) this.subdomain, (Object) subdomainAvailabilityResponse.subdomain) && Intrinsics.areEqual((Object) this.reason, (Object) subdomainAvailabilityResponse.reason) && Intrinsics.areEqual((Object) this.error, (Object) subdomainAvailabilityResponse.error);
        }

        public int hashCode() {
            int hashCode = Boolean.hashCode(this.available) * 31;
            String str = this.subdomain;
            int i = 0;
            int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.reason;
            int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.error;
            if (str3 != null) {
                i = str3.hashCode();
            }
            return hashCode3 + i;
        }

        public String toString() {
            boolean z = this.available;
            String str = this.subdomain;
            String str2 = this.reason;
            return "SubdomainAvailabilityResponse(available=" + z + ", subdomain=" + str + ", reason=" + str2 + ", error=" + this.error + ")";
        }

        public SubdomainAvailabilityResponse(boolean z, String str, String str2, String str3) {
            this.available = z;
            this.subdomain = str;
            this.reason = str2;
            this.error = str3;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ SubdomainAvailabilityResponse(boolean z, String str, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(z, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : str3);
        }

        public final boolean getAvailable() {
            return this.available;
        }

        public final String getSubdomain() {
            return this.subdomain;
        }

        public final String getReason() {
            return this.reason;
        }

        public final String getError() {
            return this.error;
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0005HÆ\u0003J7\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00032\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\r¨\u0006\u001a"}, d2 = {"Lcom/armmc/app/api/SubdomainApiService$SubdomainClaimResponse;", "", "success", "", "subdomain", "", "message", "error", "<init>", "(ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getSuccess", "()Z", "getSubdomain", "()Ljava/lang/String;", "getMessage", "getError", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* compiled from: SubdomainApiService.kt */
    public static final class SubdomainClaimResponse {
        private final String error;
        private final String message;
        private final String subdomain;
        private final boolean success;

        public static /* synthetic */ SubdomainClaimResponse copy$default(SubdomainClaimResponse subdomainClaimResponse, boolean z, String str, String str2, String str3, int i, Object obj) {
            if ((i & 1) != 0) {
                z = subdomainClaimResponse.success;
            }
            if ((i & 2) != 0) {
                str = subdomainClaimResponse.subdomain;
            }
            if ((i & 4) != 0) {
                str2 = subdomainClaimResponse.message;
            }
            if ((i & 8) != 0) {
                str3 = subdomainClaimResponse.error;
            }
            return subdomainClaimResponse.copy(z, str, str2, str3);
        }

        public final boolean component1() {
            return this.success;
        }

        public final String component2() {
            return this.subdomain;
        }

        public final String component3() {
            return this.message;
        }

        public final String component4() {
            return this.error;
        }

        public final SubdomainClaimResponse copy(boolean z, String str, String str2, String str3) {
            return new SubdomainClaimResponse(z, str, str2, str3);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof SubdomainClaimResponse)) {
                return false;
            }
            SubdomainClaimResponse subdomainClaimResponse = (SubdomainClaimResponse) obj;
            return this.success == subdomainClaimResponse.success && Intrinsics.areEqual((Object) this.subdomain, (Object) subdomainClaimResponse.subdomain) && Intrinsics.areEqual((Object) this.message, (Object) subdomainClaimResponse.message) && Intrinsics.areEqual((Object) this.error, (Object) subdomainClaimResponse.error);
        }

        public int hashCode() {
            int hashCode = Boolean.hashCode(this.success) * 31;
            String str = this.subdomain;
            int i = 0;
            int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.message;
            int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.error;
            if (str3 != null) {
                i = str3.hashCode();
            }
            return hashCode3 + i;
        }

        public String toString() {
            boolean z = this.success;
            String str = this.subdomain;
            String str2 = this.message;
            return "SubdomainClaimResponse(success=" + z + ", subdomain=" + str + ", message=" + str2 + ", error=" + this.error + ")";
        }

        public SubdomainClaimResponse(boolean z, String str, String str2, String str3) {
            this.success = z;
            this.subdomain = str;
            this.message = str2;
            this.error = str3;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ SubdomainClaimResponse(boolean z, String str, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(z, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : str3);
        }

        public final boolean getSuccess() {
            return this.success;
        }

        public final String getSubdomain() {
            return this.subdomain;
        }

        public final String getMessage() {
            return this.message;
        }

        public final String getError() {
            return this.error;
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(7:17|18|19|20|21|35|36) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x00a6 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.armmc.app.api.SubdomainApiService.SubdomainStatusResponse getSubdomainStatus(java.lang.String r14) {
        /*
            r13 = this;
            java.lang.String r1 = "SubdomainApiService"
            java.lang.String r0 = "Request failed with code "
            java.lang.String r2 = "Get subdomain status response: "
            java.lang.String r3 = "Get subdomain status response code: "
            java.lang.String r4 = "Bearer "
            java.lang.String r5 = "firebaseIdToken"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r5)
            java.net.URL r5 = new java.net.URL     // Catch:{ Exception -> 0x00d5 }
            java.lang.String r6 = "https://api.witherhost.com/api/supporter/subdomain"
            r5.<init>(r6)     // Catch:{ Exception -> 0x00d5 }
            java.net.URLConnection r5 = r5.openConnection()     // Catch:{ Exception -> 0x00d5 }
            java.lang.String r6 = "null cannot be cast to non-null type java.net.HttpURLConnection"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r5, r6)     // Catch:{ Exception -> 0x00d5 }
            java.net.HttpURLConnection r5 = (java.net.HttpURLConnection) r5     // Catch:{ Exception -> 0x00d5 }
            java.lang.String r6 = "GET"
            r5.setRequestMethod(r6)     // Catch:{ Exception -> 0x00d5 }
            r6 = 30000(0x7530, float:4.2039E-41)
            r5.setConnectTimeout(r6)     // Catch:{ Exception -> 0x00d5 }
            r5.setReadTimeout(r6)     // Catch:{ Exception -> 0x00d5 }
            java.lang.String r6 = "Authorization"
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00d5 }
            r7.<init>(r4)     // Catch:{ Exception -> 0x00d5 }
            java.lang.StringBuilder r14 = r7.append(r14)     // Catch:{ Exception -> 0x00d5 }
            java.lang.String r14 = r14.toString()     // Catch:{ Exception -> 0x00d5 }
            r5.setRequestProperty(r6, r14)     // Catch:{ Exception -> 0x00d5 }
            java.lang.String r14 = "Content-Type"
            java.lang.String r4 = "application/json"
            r5.setRequestProperty(r14, r4)     // Catch:{ Exception -> 0x00d5 }
            int r14 = r5.getResponseCode()     // Catch:{ Exception -> 0x00d5 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00d5 }
            r4.<init>(r3)     // Catch:{ Exception -> 0x00d5 }
            java.lang.StringBuilder r3 = r4.append(r14)     // Catch:{ Exception -> 0x00d5 }
            java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x00d5 }
            android.util.Log.d(r1, r3)     // Catch:{ Exception -> 0x00d5 }
            r3 = 300(0x12c, float:4.2E-43)
            r4 = 200(0xc8, float:2.8E-43)
            if (r4 > r14) goto L_0x0068
            if (r14 >= r3) goto L_0x0068
            java.io.InputStream r5 = r5.getInputStream()     // Catch:{ Exception -> 0x00d5 }
            goto L_0x006c
        L_0x0068:
            java.io.InputStream r5 = r5.getErrorStream()     // Catch:{ Exception -> 0x00d5 }
        L_0x006c:
            java.io.BufferedReader r6 = new java.io.BufferedReader     // Catch:{ Exception -> 0x00d5 }
            java.io.InputStreamReader r7 = new java.io.InputStreamReader     // Catch:{ Exception -> 0x00d5 }
            r7.<init>(r5)     // Catch:{ Exception -> 0x00d5 }
            java.io.Reader r7 = (java.io.Reader) r7     // Catch:{ Exception -> 0x00d5 }
            r6.<init>(r7)     // Catch:{ Exception -> 0x00d5 }
            java.io.Closeable r6 = (java.io.Closeable) r6     // Catch:{ Exception -> 0x00d5 }
            r5 = r6
            java.io.BufferedReader r5 = (java.io.BufferedReader) r5     // Catch:{ all -> 0x00cd }
            java.io.Reader r5 = (java.io.Reader) r5     // Catch:{ all -> 0x00cd }
            java.lang.String r5 = kotlin.io.TextStreamsKt.readText(r5)     // Catch:{ all -> 0x00cd }
            r7 = 0
            kotlin.io.CloseableKt.closeFinally(r6, r7)     // Catch:{ Exception -> 0x00d5 }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00d5 }
            r6.<init>(r2)     // Catch:{ Exception -> 0x00d5 }
            java.lang.StringBuilder r2 = r6.append(r5)     // Catch:{ Exception -> 0x00d5 }
            java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x00d5 }
            android.util.Log.d(r1, r2)     // Catch:{ Exception -> 0x00d5 }
            if (r4 > r14) goto L_0x00a0
            if (r14 >= r3) goto L_0x00a0
            com.armmc.app.api.SubdomainApiService$SubdomainStatusResponse r14 = r13.parseSubdomainStatusResponse(r5)     // Catch:{ Exception -> 0x00d5 }
            goto L_0x00f7
        L_0x00a0:
            org.json.JSONObject r2 = new org.json.JSONObject     // Catch:{ Exception -> 0x00a6 }
            r2.<init>(r5)     // Catch:{ Exception -> 0x00a6 }
            goto L_0x00ab
        L_0x00a6:
            org.json.JSONObject r2 = new org.json.JSONObject     // Catch:{ Exception -> 0x00d5 }
            r2.<init>()     // Catch:{ Exception -> 0x00d5 }
        L_0x00ab:
            com.armmc.app.api.SubdomainApiService$SubdomainStatusResponse r3 = new com.armmc.app.api.SubdomainApiService$SubdomainStatusResponse     // Catch:{ Exception -> 0x00d5 }
            java.lang.String r4 = "error"
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00d5 }
            r5.<init>(r0)     // Catch:{ Exception -> 0x00d5 }
            java.lang.StringBuilder r14 = r5.append(r14)     // Catch:{ Exception -> 0x00d5 }
            java.lang.String r14 = r14.toString()     // Catch:{ Exception -> 0x00d5 }
            java.lang.String r10 = r2.optString(r4, r14)     // Catch:{ Exception -> 0x00d5 }
            r11 = 56
            r12 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12)     // Catch:{ Exception -> 0x00d5 }
            goto L_0x00f6
        L_0x00cd:
            r0 = move-exception
            r14 = r0
            throw r14     // Catch:{ all -> 0x00d0 }
        L_0x00d0:
            r0 = move-exception
            kotlin.io.CloseableKt.closeFinally(r6, r14)     // Catch:{ Exception -> 0x00d5 }
            throw r0     // Catch:{ Exception -> 0x00d5 }
        L_0x00d5:
            r0 = move-exception
            r14 = r0
            java.lang.String r0 = "Error getting subdomain status"
            r2 = r14
            java.lang.Throwable r2 = (java.lang.Throwable) r2
            android.util.Log.e(r1, r0, r2)
            com.armmc.app.api.SubdomainApiService$SubdomainStatusResponse r3 = new com.armmc.app.api.SubdomainApiService$SubdomainStatusResponse
            java.lang.String r14 = r14.getMessage()
            if (r14 != 0) goto L_0x00e9
            java.lang.String r14 = "Network error"
        L_0x00e9:
            r10 = r14
            r11 = 56
            r12 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12)
        L_0x00f6:
            r14 = r3
        L_0x00f7:
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.armmc.app.api.SubdomainApiService.getSubdomainStatus(java.lang.String):com.armmc.app.api.SubdomainApiService$SubdomainStatusResponse");
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(7:17|18|19|20|21|22|38) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x00cd */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.armmc.app.api.SubdomainApiService.SubdomainAvailabilityResponse checkSubdomainAvailability(java.lang.String r11, java.lang.String r12) {
        /*
            r10 = this;
            java.lang.String r1 = "SubdomainApiService"
            java.lang.String r0 = "Request failed with code "
            java.lang.String r2 = "Check subdomain availability response: "
            java.lang.String r3 = "Check subdomain availability response code: "
            java.lang.String r4 = "Bearer "
            java.lang.String r5 = "https://api.witherhost.com/api/supporter/subdomain/check/"
            java.lang.String r6 = "firebaseIdToken"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r6)
            java.lang.String r6 = "subdomain"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r6)
            java.net.URL r6 = new java.net.URL     // Catch:{ Exception -> 0x00fb }
            java.util.Locale r7 = java.util.Locale.ROOT     // Catch:{ Exception -> 0x00fb }
            java.lang.String r12 = r12.toLowerCase(r7)     // Catch:{ Exception -> 0x00fb }
            java.lang.String r7 = "toLowerCase(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r12, r7)     // Catch:{ Exception -> 0x00fb }
            java.lang.CharSequence r12 = (java.lang.CharSequence) r12     // Catch:{ Exception -> 0x00fb }
            java.lang.CharSequence r12 = kotlin.text.StringsKt.trim((java.lang.CharSequence) r12)     // Catch:{ Exception -> 0x00fb }
            java.lang.String r12 = r12.toString()     // Catch:{ Exception -> 0x00fb }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00fb }
            r7.<init>(r5)     // Catch:{ Exception -> 0x00fb }
            java.lang.StringBuilder r12 = r7.append(r12)     // Catch:{ Exception -> 0x00fb }
            java.lang.String r12 = r12.toString()     // Catch:{ Exception -> 0x00fb }
            r6.<init>(r12)     // Catch:{ Exception -> 0x00fb }
            java.net.URLConnection r12 = r6.openConnection()     // Catch:{ Exception -> 0x00fb }
            java.lang.String r5 = "null cannot be cast to non-null type java.net.HttpURLConnection"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r12, r5)     // Catch:{ Exception -> 0x00fb }
            java.net.HttpURLConnection r12 = (java.net.HttpURLConnection) r12     // Catch:{ Exception -> 0x00fb }
            java.lang.String r5 = "GET"
            r12.setRequestMethod(r5)     // Catch:{ Exception -> 0x00fb }
            r5 = 30000(0x7530, float:4.2039E-41)
            r12.setConnectTimeout(r5)     // Catch:{ Exception -> 0x00fb }
            r12.setReadTimeout(r5)     // Catch:{ Exception -> 0x00fb }
            java.lang.String r5 = "Authorization"
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00fb }
            r6.<init>(r4)     // Catch:{ Exception -> 0x00fb }
            java.lang.StringBuilder r11 = r6.append(r11)     // Catch:{ Exception -> 0x00fb }
            java.lang.String r11 = r11.toString()     // Catch:{ Exception -> 0x00fb }
            r12.setRequestProperty(r5, r11)     // Catch:{ Exception -> 0x00fb }
            java.lang.String r11 = "Content-Type"
            java.lang.String r4 = "application/json"
            r12.setRequestProperty(r11, r4)     // Catch:{ Exception -> 0x00fb }
            int r11 = r12.getResponseCode()     // Catch:{ Exception -> 0x00fb }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00fb }
            r4.<init>(r3)     // Catch:{ Exception -> 0x00fb }
            java.lang.StringBuilder r3 = r4.append(r11)     // Catch:{ Exception -> 0x00fb }
            java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x00fb }
            android.util.Log.d(r1, r3)     // Catch:{ Exception -> 0x00fb }
            r3 = 300(0x12c, float:4.2E-43)
            r4 = 200(0xc8, float:2.8E-43)
            if (r4 > r11) goto L_0x008f
            if (r11 >= r3) goto L_0x008f
            java.io.InputStream r12 = r12.getInputStream()     // Catch:{ Exception -> 0x00fb }
            goto L_0x0093
        L_0x008f:
            java.io.InputStream r12 = r12.getErrorStream()     // Catch:{ Exception -> 0x00fb }
        L_0x0093:
            java.io.BufferedReader r5 = new java.io.BufferedReader     // Catch:{ Exception -> 0x00fb }
            java.io.InputStreamReader r6 = new java.io.InputStreamReader     // Catch:{ Exception -> 0x00fb }
            r6.<init>(r12)     // Catch:{ Exception -> 0x00fb }
            java.io.Reader r6 = (java.io.Reader) r6     // Catch:{ Exception -> 0x00fb }
            r5.<init>(r6)     // Catch:{ Exception -> 0x00fb }
            java.io.Closeable r5 = (java.io.Closeable) r5     // Catch:{ Exception -> 0x00fb }
            r12 = r5
            java.io.BufferedReader r12 = (java.io.BufferedReader) r12     // Catch:{ all -> 0x00f2 }
            java.io.Reader r12 = (java.io.Reader) r12     // Catch:{ all -> 0x00f2 }
            java.lang.String r12 = kotlin.io.TextStreamsKt.readText(r12)     // Catch:{ all -> 0x00f2 }
            r6 = 0
            kotlin.io.CloseableKt.closeFinally(r5, r6)     // Catch:{ Exception -> 0x00fb }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00fb }
            r5.<init>(r2)     // Catch:{ Exception -> 0x00fb }
            java.lang.StringBuilder r2 = r5.append(r12)     // Catch:{ Exception -> 0x00fb }
            java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x00fb }
            android.util.Log.d(r1, r2)     // Catch:{ Exception -> 0x00fb }
            if (r4 > r11) goto L_0x00c7
            if (r11 >= r3) goto L_0x00c7
            com.armmc.app.api.SubdomainApiService$SubdomainAvailabilityResponse r11 = r10.parseAvailabilityResponse(r12)     // Catch:{ Exception -> 0x00fb }
            goto L_0x0119
        L_0x00c7:
            org.json.JSONObject r2 = new org.json.JSONObject     // Catch:{ Exception -> 0x00cd }
            r2.<init>(r12)     // Catch:{ Exception -> 0x00cd }
            goto L_0x00d2
        L_0x00cd:
            org.json.JSONObject r2 = new org.json.JSONObject     // Catch:{ Exception -> 0x00fb }
            r2.<init>()     // Catch:{ Exception -> 0x00fb }
        L_0x00d2:
            com.armmc.app.api.SubdomainApiService$SubdomainAvailabilityResponse r3 = new com.armmc.app.api.SubdomainApiService$SubdomainAvailabilityResponse     // Catch:{ Exception -> 0x00fb }
            java.lang.String r12 = "error"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00fb }
            r4.<init>(r0)     // Catch:{ Exception -> 0x00fb }
            java.lang.StringBuilder r11 = r4.append(r11)     // Catch:{ Exception -> 0x00fb }
            java.lang.String r11 = r11.toString()     // Catch:{ Exception -> 0x00fb }
            java.lang.String r6 = r2.optString(r12, r11)     // Catch:{ Exception -> 0x00fb }
            r8 = 10
            r9 = 0
            r4 = 0
            r5 = 0
            r7 = 0
            r3.<init>(r4, r5, r6, r7, r8, r9)     // Catch:{ Exception -> 0x00fb }
            r11 = r3
            goto L_0x0119
        L_0x00f2:
            r0 = move-exception
            r11 = r0
            throw r11     // Catch:{ all -> 0x00f5 }
        L_0x00f5:
            r0 = move-exception
            r12 = r0
            kotlin.io.CloseableKt.closeFinally(r5, r11)     // Catch:{ Exception -> 0x00fb }
            throw r12     // Catch:{ Exception -> 0x00fb }
        L_0x00fb:
            r0 = move-exception
            r11 = r0
            java.lang.String r12 = "Error checking subdomain availability"
            r0 = r11
            java.lang.Throwable r0 = (java.lang.Throwable) r0
            android.util.Log.e(r1, r12, r0)
            com.armmc.app.api.SubdomainApiService$SubdomainAvailabilityResponse r2 = new com.armmc.app.api.SubdomainApiService$SubdomainAvailabilityResponse
            java.lang.String r11 = r11.getMessage()
            if (r11 != 0) goto L_0x010f
            java.lang.String r11 = "Network error"
        L_0x010f:
            r6 = r11
            r7 = 6
            r8 = 0
            r3 = 0
            r4 = 0
            r5 = 0
            r2.<init>(r3, r4, r5, r6, r7, r8)
            r11 = r2
        L_0x0119:
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.armmc.app.api.SubdomainApiService.checkSubdomainAvailability(java.lang.String, java.lang.String):com.armmc.app.api.SubdomainApiService$SubdomainAvailabilityResponse");
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(7:22|23|24|25|26|49|50) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:24:0x00e6 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.armmc.app.api.SubdomainApiService.SubdomainClaimResponse claimSubdomain(java.lang.String r10, java.lang.String r11) {
        /*
            r9 = this;
            java.lang.String r1 = "SubdomainApiService"
            java.lang.String r0 = "Request failed with code "
            java.lang.String r2 = "Claim subdomain response: "
            java.lang.String r3 = "Claim subdomain response code: "
            java.lang.String r4 = "Bearer "
            java.lang.String r5 = "firebaseIdToken"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r5)
            java.lang.String r5 = "subdomain"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r5)
            java.net.URL r6 = new java.net.URL     // Catch:{ Exception -> 0x011a }
            java.lang.String r7 = "https://api.witherhost.com/api/supporter/subdomain/claim"
            r6.<init>(r7)     // Catch:{ Exception -> 0x011a }
            java.net.URLConnection r6 = r6.openConnection()     // Catch:{ Exception -> 0x011a }
            java.lang.String r7 = "null cannot be cast to non-null type java.net.HttpURLConnection"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r6, r7)     // Catch:{ Exception -> 0x011a }
            java.net.HttpURLConnection r6 = (java.net.HttpURLConnection) r6     // Catch:{ Exception -> 0x011a }
            java.lang.String r7 = "POST"
            r6.setRequestMethod(r7)     // Catch:{ Exception -> 0x011a }
            r7 = 30000(0x7530, float:4.2039E-41)
            r6.setConnectTimeout(r7)     // Catch:{ Exception -> 0x011a }
            r6.setReadTimeout(r7)     // Catch:{ Exception -> 0x011a }
            r7 = 1
            r6.setDoOutput(r7)     // Catch:{ Exception -> 0x011a }
            java.lang.String r7 = "Authorization"
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x011a }
            r8.<init>(r4)     // Catch:{ Exception -> 0x011a }
            java.lang.StringBuilder r10 = r8.append(r10)     // Catch:{ Exception -> 0x011a }
            java.lang.String r10 = r10.toString()     // Catch:{ Exception -> 0x011a }
            r6.setRequestProperty(r7, r10)     // Catch:{ Exception -> 0x011a }
            java.lang.String r10 = "Content-Type"
            java.lang.String r4 = "application/json"
            r6.setRequestProperty(r10, r4)     // Catch:{ Exception -> 0x011a }
            org.json.JSONObject r10 = new org.json.JSONObject     // Catch:{ Exception -> 0x011a }
            r10.<init>()     // Catch:{ Exception -> 0x011a }
            java.util.Locale r4 = java.util.Locale.ROOT     // Catch:{ Exception -> 0x011a }
            java.lang.String r11 = r11.toLowerCase(r4)     // Catch:{ Exception -> 0x011a }
            java.lang.String r4 = "toLowerCase(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r11, r4)     // Catch:{ Exception -> 0x011a }
            java.lang.CharSequence r11 = (java.lang.CharSequence) r11     // Catch:{ Exception -> 0x011a }
            java.lang.CharSequence r11 = kotlin.text.StringsKt.trim((java.lang.CharSequence) r11)     // Catch:{ Exception -> 0x011a }
            java.lang.String r11 = r11.toString()     // Catch:{ Exception -> 0x011a }
            r10.put(r5, r11)     // Catch:{ Exception -> 0x011a }
            java.io.OutputStreamWriter r11 = new java.io.OutputStreamWriter     // Catch:{ Exception -> 0x011a }
            java.io.OutputStream r4 = r6.getOutputStream()     // Catch:{ Exception -> 0x011a }
            r11.<init>(r4)     // Catch:{ Exception -> 0x011a }
            java.io.Closeable r11 = (java.io.Closeable) r11     // Catch:{ Exception -> 0x011a }
            r4 = r11
            java.io.OutputStreamWriter r4 = (java.io.OutputStreamWriter) r4     // Catch:{ all -> 0x0112 }
            java.lang.String r10 = r10.toString()     // Catch:{ all -> 0x0112 }
            r4.write(r10)     // Catch:{ all -> 0x0112 }
            kotlin.Unit r10 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0112 }
            r10 = 0
            kotlin.io.CloseableKt.closeFinally(r11, r10)     // Catch:{ Exception -> 0x011a }
            int r11 = r6.getResponseCode()     // Catch:{ Exception -> 0x011a }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x011a }
            r4.<init>(r3)     // Catch:{ Exception -> 0x011a }
            java.lang.StringBuilder r3 = r4.append(r11)     // Catch:{ Exception -> 0x011a }
            java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x011a }
            android.util.Log.d(r1, r3)     // Catch:{ Exception -> 0x011a }
            r3 = 300(0x12c, float:4.2E-43)
            r4 = 200(0xc8, float:2.8E-43)
            if (r4 > r11) goto L_0x00a9
            if (r11 >= r3) goto L_0x00a9
            java.io.InputStream r5 = r6.getInputStream()     // Catch:{ Exception -> 0x011a }
            goto L_0x00ad
        L_0x00a9:
            java.io.InputStream r5 = r6.getErrorStream()     // Catch:{ Exception -> 0x011a }
        L_0x00ad:
            java.io.BufferedReader r6 = new java.io.BufferedReader     // Catch:{ Exception -> 0x011a }
            java.io.InputStreamReader r7 = new java.io.InputStreamReader     // Catch:{ Exception -> 0x011a }
            r7.<init>(r5)     // Catch:{ Exception -> 0x011a }
            java.io.Reader r7 = (java.io.Reader) r7     // Catch:{ Exception -> 0x011a }
            r6.<init>(r7)     // Catch:{ Exception -> 0x011a }
            java.io.Closeable r6 = (java.io.Closeable) r6     // Catch:{ Exception -> 0x011a }
            r5 = r6
            java.io.BufferedReader r5 = (java.io.BufferedReader) r5     // Catch:{ all -> 0x0109 }
            java.io.Reader r5 = (java.io.Reader) r5     // Catch:{ all -> 0x0109 }
            java.lang.String r5 = kotlin.io.TextStreamsKt.readText(r5)     // Catch:{ all -> 0x0109 }
            kotlin.io.CloseableKt.closeFinally(r6, r10)     // Catch:{ Exception -> 0x011a }
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x011a }
            r10.<init>(r2)     // Catch:{ Exception -> 0x011a }
            java.lang.StringBuilder r10 = r10.append(r5)     // Catch:{ Exception -> 0x011a }
            java.lang.String r10 = r10.toString()     // Catch:{ Exception -> 0x011a }
            android.util.Log.d(r1, r10)     // Catch:{ Exception -> 0x011a }
            if (r4 > r11) goto L_0x00e0
            if (r11 >= r3) goto L_0x00e0
            com.armmc.app.api.SubdomainApiService$SubdomainClaimResponse r10 = r9.parseClaimResponse(r5)     // Catch:{ Exception -> 0x011a }
            goto L_0x0138
        L_0x00e0:
            org.json.JSONObject r10 = new org.json.JSONObject     // Catch:{ Exception -> 0x00e6 }
            r10.<init>(r5)     // Catch:{ Exception -> 0x00e6 }
            goto L_0x00eb
        L_0x00e6:
            org.json.JSONObject r10 = new org.json.JSONObject     // Catch:{ Exception -> 0x011a }
            r10.<init>()     // Catch:{ Exception -> 0x011a }
        L_0x00eb:
            com.armmc.app.api.SubdomainApiService$SubdomainClaimResponse r2 = new com.armmc.app.api.SubdomainApiService$SubdomainClaimResponse     // Catch:{ Exception -> 0x011a }
            java.lang.String r3 = "error"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x011a }
            r4.<init>(r0)     // Catch:{ Exception -> 0x011a }
            java.lang.StringBuilder r11 = r4.append(r11)     // Catch:{ Exception -> 0x011a }
            java.lang.String r11 = r11.toString()     // Catch:{ Exception -> 0x011a }
            java.lang.String r6 = r10.optString(r3, r11)     // Catch:{ Exception -> 0x011a }
            r7 = 6
            r8 = 0
            r3 = 0
            r4 = 0
            r5 = 0
            r2.<init>(r3, r4, r5, r6, r7, r8)     // Catch:{ Exception -> 0x011a }
            goto L_0x0137
        L_0x0109:
            r0 = move-exception
            r10 = r0
            throw r10     // Catch:{ all -> 0x010c }
        L_0x010c:
            r0 = move-exception
            r11 = r0
            kotlin.io.CloseableKt.closeFinally(r6, r10)     // Catch:{ Exception -> 0x011a }
            throw r11     // Catch:{ Exception -> 0x011a }
        L_0x0112:
            r0 = move-exception
            r10 = r0
            throw r10     // Catch:{ all -> 0x0115 }
        L_0x0115:
            r0 = move-exception
            kotlin.io.CloseableKt.closeFinally(r11, r10)     // Catch:{ Exception -> 0x011a }
            throw r0     // Catch:{ Exception -> 0x011a }
        L_0x011a:
            r0 = move-exception
            r10 = r0
            java.lang.String r11 = "Error claiming subdomain"
            r0 = r10
            java.lang.Throwable r0 = (java.lang.Throwable) r0
            android.util.Log.e(r1, r11, r0)
            com.armmc.app.api.SubdomainApiService$SubdomainClaimResponse r2 = new com.armmc.app.api.SubdomainApiService$SubdomainClaimResponse
            java.lang.String r10 = r10.getMessage()
            if (r10 != 0) goto L_0x012e
            java.lang.String r10 = "Network error"
        L_0x012e:
            r6 = r10
            r7 = 6
            r8 = 0
            r3 = 0
            r4 = 0
            r5 = 0
            r2.<init>(r3, r4, r5, r6, r7, r8)
        L_0x0137:
            r10 = r2
        L_0x0138:
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.armmc.app.api.SubdomainApiService.claimSubdomain(java.lang.String, java.lang.String):com.armmc.app.api.SubdomainApiService$SubdomainClaimResponse");
    }

    private final SubdomainStatusResponse parseSubdomainStatusResponse(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            boolean optBoolean = jSONObject.optBoolean("success", false);
            return new SubdomainStatusResponse(optBoolean, jSONObject.optBoolean(UserSubscriptionManager.FIELD_IS_SUPPORTER, false), jSONObject.optBoolean("hasClaimed", false), jSONObject.optString("subdomain", (String) null), jSONObject.optString("fullDomain", (String) null), jSONObject.optString(LogManager.EXTRA_MESSAGE, (String) null), (String) null, 64, (DefaultConstructorMarker) null);
        } catch (Exception e) {
            Log.e(TAG, "Error parsing subdomain status response", e);
            return new SubdomainStatusResponse(false, false, false, (String) null, (String) null, (String) null, "Failed to parse response", 56, (DefaultConstructorMarker) null);
        }
    }

    private final SubdomainAvailabilityResponse parseAvailabilityResponse(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            return new SubdomainAvailabilityResponse(jSONObject.optBoolean("available", false), jSONObject.optString("subdomain", (String) null), jSONObject.optString("reason", (String) null), (String) null, 8, (DefaultConstructorMarker) null);
        } catch (Exception e) {
            Log.e(TAG, "Error parsing availability response", e);
            return new SubdomainAvailabilityResponse(false, (String) null, (String) null, "Failed to parse response", 6, (DefaultConstructorMarker) null);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0014, code lost:
        if (r10 == null) goto L_0x0016;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final com.armmc.app.api.SubdomainApiService.SubdomainClaimResponse parseClaimResponse(java.lang.String r10) {
        /*
            r9 = this;
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ Exception -> 0x0032 }
            r0.<init>(r10)     // Catch:{ Exception -> 0x0032 }
            java.lang.String r10 = "tunnel"
            org.json.JSONObject r10 = r0.optJSONObject(r10)     // Catch:{ Exception -> 0x0032 }
            r1 = 0
            java.lang.String r2 = "subdomain"
            if (r10 == 0) goto L_0x0016
            java.lang.String r10 = r10.optString(r2)     // Catch:{ Exception -> 0x0032 }
            if (r10 != 0) goto L_0x001a
        L_0x0016:
            java.lang.String r10 = r0.optString(r2, r1)     // Catch:{ Exception -> 0x0032 }
        L_0x001a:
            r4 = r10
            com.armmc.app.api.SubdomainApiService$SubdomainClaimResponse r2 = new com.armmc.app.api.SubdomainApiService$SubdomainClaimResponse     // Catch:{ Exception -> 0x0032 }
            java.lang.String r10 = "success"
            r3 = 0
            boolean r3 = r0.optBoolean(r10, r3)     // Catch:{ Exception -> 0x0032 }
            java.lang.String r10 = "message"
            java.lang.String r5 = r0.optString(r10, r1)     // Catch:{ Exception -> 0x0032 }
            r7 = 8
            r8 = 0
            r6 = 0
            r2.<init>(r3, r4, r5, r6, r7, r8)     // Catch:{ Exception -> 0x0032 }
            return r2
        L_0x0032:
            r0 = move-exception
            r10 = r0
            java.lang.String r0 = "Error parsing claim response"
            java.lang.Throwable r10 = (java.lang.Throwable) r10
            java.lang.String r1 = "SubdomainApiService"
            android.util.Log.e(r1, r0, r10)
            com.armmc.app.api.SubdomainApiService$SubdomainClaimResponse r2 = new com.armmc.app.api.SubdomainApiService$SubdomainClaimResponse
            r7 = 6
            r8 = 0
            r3 = 0
            r4 = 0
            r5 = 0
            java.lang.String r6 = "Failed to parse response"
            r2.<init>(r3, r4, r5, r6, r7, r8)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.armmc.app.api.SubdomainApiService.parseClaimResponse(java.lang.String):com.armmc.app.api.SubdomainApiService$SubdomainClaimResponse");
    }
}
