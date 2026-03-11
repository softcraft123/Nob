package com.android.billingclient.api;

import kotlinx.coroutines.CompletableDeferred;

/* compiled from: com.android.billingclient:billing-ktx@@7.0.0 */
public final /* synthetic */ class BillingClientKotlinKt$$ExternalSyntheticLambda2 implements ExternalOfferAvailabilityListener {
    public /* synthetic */ CompletableDeferred f$0;

    public /* synthetic */ BillingClientKotlinKt$$ExternalSyntheticLambda2(CompletableDeferred completableDeferred) {
        this.f$0 = completableDeferred;
    }

    public final void onExternalOfferAvailabilityResponse(BillingResult billingResult) {
        BillingClientKotlinKt.m141$r8$lambda$OmYoMPMU8NGGTTJRupXijq_ag(this.f$0, billingResult);
    }
}
