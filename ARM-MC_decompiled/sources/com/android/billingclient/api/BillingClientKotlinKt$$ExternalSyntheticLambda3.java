package com.android.billingclient.api;

import java.util.List;
import kotlinx.coroutines.CompletableDeferred;

/* compiled from: com.android.billingclient:billing-ktx@@7.0.0 */
public final /* synthetic */ class BillingClientKotlinKt$$ExternalSyntheticLambda3 implements ProductDetailsResponseListener {
    public /* synthetic */ CompletableDeferred f$0;

    public /* synthetic */ BillingClientKotlinKt$$ExternalSyntheticLambda3(CompletableDeferred completableDeferred) {
        this.f$0 = completableDeferred;
    }

    public final void onProductDetailsResponse(BillingResult billingResult, List list) {
        BillingClientKotlinKt.m142$r8$lambda$_HjOTKlijnqR5v_YYSPcvW1bw(this.f$0, billingResult, list);
    }
}
