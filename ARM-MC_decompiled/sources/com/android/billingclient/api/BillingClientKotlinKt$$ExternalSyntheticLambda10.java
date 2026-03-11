package com.android.billingclient.api;

import java.util.List;
import kotlinx.coroutines.CompletableDeferred;

/* compiled from: com.android.billingclient:billing-ktx@@7.0.0 */
public final /* synthetic */ class BillingClientKotlinKt$$ExternalSyntheticLambda10 implements PurchasesResponseListener {
    public /* synthetic */ CompletableDeferred f$0;

    public /* synthetic */ BillingClientKotlinKt$$ExternalSyntheticLambda10(CompletableDeferred completableDeferred) {
        this.f$0 = completableDeferred;
    }

    public final void onQueryPurchasesResponse(BillingResult billingResult, List list) {
        BillingClientKotlinKt.m138$r8$lambda$Iy_vpeZ_JHNmajeE6ZBdUlqJKA(this.f$0, billingResult, list);
    }
}
