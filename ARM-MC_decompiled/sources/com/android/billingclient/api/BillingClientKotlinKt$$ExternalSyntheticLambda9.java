package com.android.billingclient.api;

import kotlinx.coroutines.CompletableDeferred;

/* compiled from: com.android.billingclient:billing-ktx@@7.0.0 */
public final /* synthetic */ class BillingClientKotlinKt$$ExternalSyntheticLambda9 implements AlternativeBillingOnlyReportingDetailsListener {
    public /* synthetic */ CompletableDeferred f$0;

    public /* synthetic */ BillingClientKotlinKt$$ExternalSyntheticLambda9(CompletableDeferred completableDeferred) {
        this.f$0 = completableDeferred;
    }

    public final void onAlternativeBillingOnlyTokenResponse(BillingResult billingResult, AlternativeBillingOnlyReportingDetails alternativeBillingOnlyReportingDetails) {
        BillingClientKotlinKt.m140$r8$lambda$NdU5wcJ8m2M9H_puX2oHpjb25w(this.f$0, billingResult, alternativeBillingOnlyReportingDetails);
    }
}
