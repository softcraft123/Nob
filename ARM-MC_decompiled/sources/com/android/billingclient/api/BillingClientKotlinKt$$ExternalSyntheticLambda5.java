package com.android.billingclient.api;

import kotlinx.coroutines.CompletableDeferred;

/* compiled from: com.android.billingclient:billing-ktx@@7.0.0 */
public final /* synthetic */ class BillingClientKotlinKt$$ExternalSyntheticLambda5 implements ExternalOfferReportingDetailsListener {
    public /* synthetic */ CompletableDeferred f$0;

    public /* synthetic */ BillingClientKotlinKt$$ExternalSyntheticLambda5(CompletableDeferred completableDeferred) {
        this.f$0 = completableDeferred;
    }

    public final void onExternalOfferReportingDetailsResponse(BillingResult billingResult, ExternalOfferReportingDetails externalOfferReportingDetails) {
        BillingClientKotlinKt.$r8$lambda$Bt5YvFTOU7XGqhy1u2vanp4Jc20(this.f$0, billingResult, externalOfferReportingDetails);
    }
}
