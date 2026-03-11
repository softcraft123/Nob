package com.android.billingclient.api;

import java.util.List;
import kotlinx.coroutines.CompletableDeferred;

/* compiled from: com.android.billingclient:billing-ktx@@7.0.0 */
public final /* synthetic */ class BillingClientKotlinKt$$ExternalSyntheticLambda11 implements SkuDetailsResponseListener {
    public /* synthetic */ CompletableDeferred f$0;

    public /* synthetic */ BillingClientKotlinKt$$ExternalSyntheticLambda11(CompletableDeferred completableDeferred) {
        this.f$0 = completableDeferred;
    }

    public final void onSkuDetailsResponse(BillingResult billingResult, List list) {
        BillingClientKotlinKt.$r8$lambda$9SKPFUMhNCJ3v0PMCwGqle8zR10(this.f$0, billingResult, list);
    }
}
