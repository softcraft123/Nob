package com.armmc.app.billing;

import android.content.Context;
import android.util.Log;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* compiled from: BillingManager.kt */
/* MODIFIED: All billing removed, premium unlocked for all users */
public final class BillingManager {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String SUPPORTER_PRODUCT_ID = "supporter_subscription";
    private static final String TAG = "BillingManager";
    public static Boolean cachedSupporterStatus = Boolean.TRUE;
    public static String cachedUserId;
    private final MutableStateFlow<BillingState> _billingState;
    public final MutableStateFlow<Boolean> _isSupporter;
    private final MutableStateFlow<String> _subscriptionPrice;
    private final StateFlow<BillingState> billingState;
    private final Context context;
    private final CoroutineScope coroutineScope;
    private final StateFlow<Boolean> isSupporter;
    private final StateFlow<String> subscriptionPrice;

    public BillingManager(Context context2, CoroutineScope coroutineScope2) {
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(coroutineScope2, "coroutineScope");
        this.context = context2;
        this.coroutineScope = coroutineScope2;
        MutableStateFlow<Boolean> MutableStateFlow = StateFlowKt.MutableStateFlow(true);
        this._isSupporter = MutableStateFlow;
        this.isSupporter = FlowKt.asStateFlow(MutableStateFlow);
        MutableStateFlow<String> MutableStateFlow2 = StateFlowKt.MutableStateFlow(null);
        this._subscriptionPrice = MutableStateFlow2;
        this.subscriptionPrice = FlowKt.asStateFlow(MutableStateFlow2);
        MutableStateFlow<BillingState> MutableStateFlow3 = StateFlowKt.MutableStateFlow(BillingState.Connected.INSTANCE);
        this._billingState = MutableStateFlow3;
        this.billingState = FlowKt.asStateFlow(MutableStateFlow3);
        Log.d(TAG, "BillingManager initialized - all premium features unlocked");
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
        private Companion() {
        }
        public final void clearSupporterCache() {
            BillingManager.cachedSupporterStatus = Boolean.TRUE;
            BillingManager.cachedUserId = null;
        }
    }

    public final StateFlow<Boolean> isSupporter() {
        return this.isSupporter;
    }

    public final StateFlow<String> getSubscriptionPrice() {
        return this.subscriptionPrice;
    }

    public final StateFlow<BillingState> getBillingState() {
        return this.billingState;
    }

    public static abstract class BillingState {
        public /* synthetic */ BillingState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
        private BillingState() {
        }

        public static final class Idle extends BillingState {
            public static final Idle INSTANCE = new Idle();
            private Idle() { super((DefaultConstructorMarker) null); }
        }
        public static final class Connecting extends BillingState {
            public static final Connecting INSTANCE = new Connecting();
            private Connecting() { super((DefaultConstructorMarker) null); }
        }
        public static final class Connected extends BillingState {
            public static final Connected INSTANCE = new Connected();
            private Connected() { super((DefaultConstructorMarker) null); }
        }
        public static final class Disconnected extends BillingState {
            public static final Disconnected INSTANCE = new Disconnected();
            private Disconnected() { super((DefaultConstructorMarker) null); }
        }
        public static final class Unavailable extends BillingState {
            public static final Unavailable INSTANCE = new Unavailable();
            private Unavailable() { super((DefaultConstructorMarker) null); }
        }
        public static final class Error extends BillingState {
            private final String message;
            public Error(String str) { super((DefaultConstructorMarker) null); this.message = str; }
            public final String getMessage() { return this.message; }
            public final String component1() { return this.message; }
            public final Error copy(String str) { return new Error(str); }
            public static /* synthetic */ Error copy$default(Error error, String str, int i, Object obj) {
                if ((i & 1) != 0) str = error.message;
                return error.copy(str);
            }
            public boolean equals(Object obj) {
                if (this == obj) return true;
                if (!(obj instanceof Error)) return false;
                return Intrinsics.areEqual(this.message, ((Error) obj).message);
            }
            public int hashCode() { String s = this.message; return s == null ? 0 : s.hashCode(); }
            public String toString() { return "Error(message=" + this.message + ")"; }
        }
        public static final class PurchaseInProgress extends BillingState {
            public static final PurchaseInProgress INSTANCE = new PurchaseInProgress();
            private PurchaseInProgress() { super((DefaultConstructorMarker) null); }
        }
        public static final class PurchaseSuccess extends BillingState {
            public static final PurchaseSuccess INSTANCE = new PurchaseSuccess();
            private PurchaseSuccess() { super((DefaultConstructorMarker) null); }
        }
        public static final class PurchaseError extends BillingState {
            private final String message;
            public PurchaseError(String str) { super((DefaultConstructorMarker) null); this.message = str; }
            public final String getMessage() { return this.message; }
            public final String component1() { return this.message; }
            public final PurchaseError copy(String str) { return new PurchaseError(str); }
            public static /* synthetic */ PurchaseError copy$default(PurchaseError pe, String str, int i, Object obj) {
                if ((i & 1) != 0) str = pe.message;
                return pe.copy(str);
            }
            public boolean equals(Object obj) {
                if (this == obj) return true;
                if (!(obj instanceof PurchaseError)) return false;
                return Intrinsics.areEqual(this.message, ((PurchaseError) obj).message);
            }
            public int hashCode() { String s = this.message; return s == null ? 0 : s.hashCode(); }
            public String toString() { return "PurchaseError(message=" + this.message + ")"; }
        }
    }

    public void connect() {
        Log.d(TAG, "Billing connect - no-op, all premium unlocked");
    }

    public void launchSubscriptionFlow(android.app.Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Log.d(TAG, "Subscription flow - no-op, all premium unlocked");
    }

    public void checkSubscriptionFromFirebase(kotlin.jvm.functions.Function1<? super Boolean, kotlin.Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        callback.invoke(true);
    }

    public void refreshSubscriptionStatus() {
        this._isSupporter.setValue(true);
    }

    public void resetBillingState() {
        this._billingState.setValue(BillingState.Connected.INSTANCE);
    }

    public void destroy() {
        Log.d(TAG, "BillingManager destroyed");
    }
}
