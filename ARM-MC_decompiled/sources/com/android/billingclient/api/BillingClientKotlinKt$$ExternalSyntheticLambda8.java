package com.android.billingclient.api;

import java.util.List;
import kotlinx.coroutines.CompletableDeferred;

/* compiled from: com.android.billingclient:billing-ktx@@7.0.0 */
public final /* synthetic */ class BillingClientKotlinKt$$ExternalSyntheticLambda8 implements PurchaseHistoryResponseListener {
    public /* synthetic */ CompletableDeferred f$0;

    public /* synthetic */ BillingClientKotlinKt$$ExternalSyntheticLambda8(CompletableDeferred completableDeferred) {
        this.f$0 = completableDeferred;
    }

    public final void onPurchaseHistoryResponse(BillingResult billingResult, List list) {
        BillingClientKotlinKt.$r8$lambda$ZzkEujuP9GqFND2FbZB_kuqycGM(this.f$0, billingResult, list);
    }
}
