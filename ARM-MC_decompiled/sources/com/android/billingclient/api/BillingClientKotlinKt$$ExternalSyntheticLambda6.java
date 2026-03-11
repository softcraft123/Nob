package com.android.billingclient.api;

import java.util.List;
import kotlinx.coroutines.CompletableDeferred;

/* compiled from: com.android.billingclient:billing-ktx@@7.0.0 */
public final /* synthetic */ class BillingClientKotlinKt$$ExternalSyntheticLambda6 implements PurchaseHistoryResponseListener {
    public /* synthetic */ CompletableDeferred f$0;

    public /* synthetic */ BillingClientKotlinKt$$ExternalSyntheticLambda6(CompletableDeferred completableDeferred) {
        this.f$0 = completableDeferred;
    }

    public final void onPurchaseHistoryResponse(BillingResult billingResult, List list) {
        BillingClientKotlinKt.m139$r8$lambda$Jmx2bDJUejQbQfqNRRvqVuz0(this.f$0, billingResult, list);
    }
}
