package com.armmc.app.api;

import android.util.Log;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SubscriptionApiService.kt */
/* MODIFIED: All API calls to original owner removed, always returns supporter=true */
public final class SubscriptionApiService {
    private static final String BASE_URL = "";
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String TAG = "SubscriptionApiService";
    private static final int TIMEOUT_MS = 30000;

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
        private Companion() {
        }
    }

    public static final class VerifySubscriptionResponse {
        private final Boolean autoRenewing;
        private final String error;
        private final Long expiryTime;
        private final boolean isSupporter;
        private final String reason;
        private final boolean success;

        public static /* synthetic */ VerifySubscriptionResponse copy$default(VerifySubscriptionResponse v, boolean z, boolean z2, Long l, Boolean bool, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) z = v.success;
            if ((i & 2) != 0) z2 = v.isSupporter;
            if ((i & 4) != 0) l = v.expiryTime;
            if ((i & 8) != 0) bool = v.autoRenewing;
            if ((i & 16) != 0) str = v.reason;
            if ((i & 32) != 0) str2 = v.error;
            return v.copy(z, z2, l, bool, str, str2);
        }

        public final boolean component1() { return this.success; }
        public final boolean component2() { return this.isSupporter; }
        public final Long component3() { return this.expiryTime; }
        public final Boolean component4() { return this.autoRenewing; }
        public final String component5() { return this.reason; }
        public final String component6() { return this.error; }

        public final VerifySubscriptionResponse copy(boolean z, boolean z2, Long l, Boolean bool, String str, String str2) {
            return new VerifySubscriptionResponse(z, z2, l, bool, str, str2);
        }

        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (!(obj instanceof VerifySubscriptionResponse)) return false;
            VerifySubscriptionResponse v = (VerifySubscriptionResponse) obj;
            return this.success == v.success && this.isSupporter == v.isSupporter && Intrinsics.areEqual(this.expiryTime, v.expiryTime) && Intrinsics.areEqual(this.autoRenewing, v.autoRenewing) && Intrinsics.areEqual(this.reason, v.reason) && Intrinsics.areEqual(this.error, v.error);
        }

        public int hashCode() {
            int h = ((Boolean.hashCode(this.success) * 31) + Boolean.hashCode(this.isSupporter)) * 31;
            Long l = this.expiryTime;
            h = (h + (l == null ? 0 : l.hashCode())) * 31;
            Boolean b = this.autoRenewing;
            h = (h + (b == null ? 0 : b.hashCode())) * 31;
            String s = this.reason;
            h = (h + (s == null ? 0 : s.hashCode())) * 31;
            String s2 = this.error;
            return h + (s2 == null ? 0 : s2.hashCode());
        }

        public String toString() {
            return "VerifySubscriptionResponse(success=" + this.success + ", isSupporter=" + this.isSupporter + ", expiryTime=" + this.expiryTime + ", autoRenewing=" + this.autoRenewing + ", reason=" + this.reason + ", error=" + this.error + ")";
        }

        public VerifySubscriptionResponse(boolean z, boolean z2, Long l, Boolean bool, String str, String str2) {
            this.success = z; this.isSupporter = z2; this.expiryTime = l; this.autoRenewing = bool; this.reason = str; this.error = str2;
        }

        public /* synthetic */ VerifySubscriptionResponse(boolean z, boolean z2, Long l, Boolean bool, String str, String str2, int i, DefaultConstructorMarker m) {
            this(z, z2, l, bool, str, (i & 32) != 0 ? null : str2);
        }

        public final boolean getSuccess() { return this.success; }
        public final boolean isSupporter() { return this.isSupporter; }
        public final Long getExpiryTime() { return this.expiryTime; }
        public final Boolean getAutoRenewing() { return this.autoRenewing; }
        public final String getReason() { return this.reason; }
        public final String getError() { return this.error; }
    }

    public static final class SubscriptionStatusResponse {
        private final String error;
        private final Long expiryTime;
        private final Boolean isExpired;
        private final boolean isSupporter;
        private final boolean success;

        public static /* synthetic */ SubscriptionStatusResponse copy$default(SubscriptionStatusResponse v, boolean z, boolean z2, Long l, Boolean bool, String str, int i, Object obj) {
            if ((i & 1) != 0) z = v.success;
            if ((i & 2) != 0) z2 = v.isSupporter;
            if ((i & 4) != 0) l = v.expiryTime;
            if ((i & 8) != 0) bool = v.isExpired;
            if ((i & 16) != 0) str = v.error;
            return v.copy(z, z2, l, bool, str);
        }

        public final boolean component1() { return this.success; }
        public final boolean component2() { return this.isSupporter; }
        public final Long component3() { return this.expiryTime; }
        public final Boolean component4() { return this.isExpired; }
        public final String component5() { return this.error; }

        public final SubscriptionStatusResponse copy(boolean z, boolean z2, Long l, Boolean bool, String str) {
            return new SubscriptionStatusResponse(z, z2, l, bool, str);
        }

        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (!(obj instanceof SubscriptionStatusResponse)) return false;
            SubscriptionStatusResponse v = (SubscriptionStatusResponse) obj;
            return this.success == v.success && this.isSupporter == v.isSupporter && Intrinsics.areEqual(this.expiryTime, v.expiryTime) && Intrinsics.areEqual(this.isExpired, v.isExpired) && Intrinsics.areEqual(this.error, v.error);
        }

        public int hashCode() {
            int h = ((Boolean.hashCode(this.success) * 31) + Boolean.hashCode(this.isSupporter)) * 31;
            Long l = this.expiryTime;
            h = (h + (l == null ? 0 : l.hashCode())) * 31;
            Boolean b = this.isExpired;
            h = (h + (b == null ? 0 : b.hashCode())) * 31;
            String s = this.error;
            return h + (s == null ? 0 : s.hashCode());
        }

        public String toString() {
            return "SubscriptionStatusResponse(success=" + this.success + ", isSupporter=" + this.isSupporter + ", expiryTime=" + this.expiryTime + ", isExpired=" + this.isExpired + ", error=" + this.error + ")";
        }

        public SubscriptionStatusResponse(boolean z, boolean z2, Long l, Boolean bool, String str) {
            this.success = z; this.isSupporter = z2; this.expiryTime = l; this.isExpired = bool; this.error = str;
        }

        public /* synthetic */ SubscriptionStatusResponse(boolean z, boolean z2, Long l, Boolean bool, String str, int i, DefaultConstructorMarker m) {
            this(z, z2, l, bool, (i & 16) != 0 ? null : str);
        }

        public final boolean getSuccess() { return this.success; }
        public final boolean isSupporter() { return this.isSupporter; }
        public final Long getExpiryTime() { return this.expiryTime; }
        public final Boolean isExpired() { return this.isExpired; }
        public final String getError() { return this.error; }
    }

    public static /* synthetic */ VerifySubscriptionResponse verifySubscription$default(SubscriptionApiService s, String str, String str2, String str3, int i, Object obj) {
        if ((i & 4) != 0) str3 = null;
        return s.verifySubscription(str, str2, str3);
    }

    /* MODIFIED: No-op, always returns supporter=true */
    public final VerifySubscriptionResponse verifySubscription(String str, String str2, String str3) {
        Intrinsics.checkNotNullParameter(str, "firebaseIdToken");
        Intrinsics.checkNotNullParameter(str2, "purchaseToken");
        Log.d(TAG, "verifySubscription - no-op, all premium unlocked");
        return new VerifySubscriptionResponse(true, true, null, Boolean.TRUE, "Premium unlocked", null);
    }

    /* MODIFIED: No-op, always returns supporter=true */
    public final SubscriptionStatusResponse getSubscriptionStatus(String str) {
        Intrinsics.checkNotNullParameter(str, "firebaseIdToken");
        Log.d(TAG, "getSubscriptionStatus - no-op, all premium unlocked");
        return new SubscriptionStatusResponse(true, true, null, Boolean.FALSE, null);
    }

    /* MODIFIED: No-op, always returns supporter=true */
    public final VerifySubscriptionResponse refreshSubscription(String str) {
        Intrinsics.checkNotNullParameter(str, "firebaseIdToken");
        Log.d(TAG, "refreshSubscription - no-op, all premium unlocked");
        return new VerifySubscriptionResponse(true, true, null, Boolean.TRUE, "Premium unlocked", null);
    }
}
