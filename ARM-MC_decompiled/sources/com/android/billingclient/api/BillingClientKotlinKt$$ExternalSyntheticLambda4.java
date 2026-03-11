package com.android.billingclient.api;

import kotlinx.coroutines.CompletableDeferred;

/* compiled from: com.android.billingclient:billing-ktx@@7.0.0 */
public final /* synthetic */ class BillingClientKotlinKt$$ExternalSyntheticLambda4 implements AcknowledgePurchaseResponseListener {
    public /* synthetic */ CompletableDeferred f$0;

    public /* synthetic */ BillingClientKotlinKt$$ExternalSyntheticLambda4(CompletableDeferred completableDeferred) {
        this.f$0 = completableDeferred;
    }

    public final void onAcknowledgePurchaseResponse(BillingResult billingResult) {
        BillingClientKotlinKt.$r8$lambda$mNiIov37EcRv6CLKJbxie9rmtK8(this.f$0, billingResult);
    }
}
