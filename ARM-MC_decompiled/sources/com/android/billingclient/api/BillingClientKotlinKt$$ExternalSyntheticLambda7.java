package com.android.billingclient.api;

import kotlinx.coroutines.CompletableDeferred;

/* compiled from: com.android.billingclient:billing-ktx@@7.0.0 */
public final /* synthetic */ class BillingClientKotlinKt$$ExternalSyntheticLambda7 implements AlternativeBillingOnlyAvailabilityListener {
    public /* synthetic */ CompletableDeferred f$0;

    public /* synthetic */ BillingClientKotlinKt$$ExternalSyntheticLambda7(CompletableDeferred completableDeferred) {
        this.f$0 = completableDeferred;
    }

    public final void onAlternativeBillingOnlyAvailabilityResponse(BillingResult billingResult) {
        BillingClientKotlinKt.$r8$lambda$1JhcD_0Y_gWWNKF2aNTk2toOOyY(this.f$0, billingResult);
    }
}
