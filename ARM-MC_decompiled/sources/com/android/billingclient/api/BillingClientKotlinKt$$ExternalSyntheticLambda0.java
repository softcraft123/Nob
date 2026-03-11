package com.android.billingclient.api;

import java.util.List;
import kotlinx.coroutines.CompletableDeferred;

/* compiled from: com.android.billingclient:billing-ktx@@7.0.0 */
public final /* synthetic */ class BillingClientKotlinKt$$ExternalSyntheticLambda0 implements PurchasesResponseListener {
    public /* synthetic */ CompletableDeferred f$0;

    public /* synthetic */ BillingClientKotlinKt$$ExternalSyntheticLambda0(CompletableDeferred completableDeferred) {
        this.f$0 = completableDeferred;
    }

    public final void onQueryPurchasesResponse(BillingResult billingResult, List list) {
        BillingClientKotlinKt.$r8$lambda$wzezm1LgRtzooDMmMf2vgdwDzEw(this.f$0, billingResult, list);
    }
}
