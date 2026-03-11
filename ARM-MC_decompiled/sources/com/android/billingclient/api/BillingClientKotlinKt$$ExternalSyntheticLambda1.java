package com.android.billingclient.api;

import kotlinx.coroutines.CompletableDeferred;

/* compiled from: com.android.billingclient:billing-ktx@@7.0.0 */
public final /* synthetic */ class BillingClientKotlinKt$$ExternalSyntheticLambda1 implements ConsumeResponseListener {
    public /* synthetic */ CompletableDeferred f$0;

    public /* synthetic */ BillingClientKotlinKt$$ExternalSyntheticLambda1(CompletableDeferred completableDeferred) {
        this.f$0 = completableDeferred;
    }

    public final void onConsumeResponse(BillingResult billingResult, String str) {
        BillingClientKotlinKt.m137$r8$lambda$BC2cAL2vk_I3dVpkSAsSywRIek(this.f$0, billingResult, str);
    }
}
