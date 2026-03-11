package com.android.billingclient.api;

import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000h\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001a\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H@¢\u0006\u0002\u0010\u0005\u001a\u001a\u0010\u0006\u001a\u00020\u0007*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\bH@¢\u0006\u0002\u0010\t\u001a\u0012\u0010\n\u001a\u00020\u000b*\u00020\u0002H@¢\u0006\u0002\u0010\f\u001a\u0012\u0010\r\u001a\u00020\u000e*\u00020\u0002H@¢\u0006\u0002\u0010\f\u001a\u0012\u0010\u000f\u001a\u00020\u0001*\u00020\u0002H@¢\u0006\u0002\u0010\f\u001a\u0012\u0010\u0010\u001a\u00020\u0001*\u00020\u0002H@¢\u0006\u0002\u0010\f\u001a\u001a\u0010\u0011\u001a\u00020\u0012*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0013H@¢\u0006\u0002\u0010\u0014\u001a\u001a\u0010\u0015\u001a\u00020\u0016*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0017H@¢\u0006\u0002\u0010\u0018\u001a\u001a\u0010\u0015\u001a\u00020\u0016*\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u001aH@¢\u0006\u0002\u0010\u001b\u001a\u001a\u0010\u001c\u001a\u00020\u001d*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u001eH@¢\u0006\u0002\u0010\u001f\u001a\u001a\u0010\u001c\u001a\u00020\u001d*\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u001aH@¢\u0006\u0002\u0010\u001b\u001a\u001a\u0010 \u001a\u00020!*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\"H@¢\u0006\u0002\u0010#¨\u0006$"}, d2 = {"acknowledgePurchase", "Lcom/android/billingclient/api/BillingResult;", "Lcom/android/billingclient/api/BillingClient;", "params", "Lcom/android/billingclient/api/AcknowledgePurchaseParams;", "(Lcom/android/billingclient/api/BillingClient;Lcom/android/billingclient/api/AcknowledgePurchaseParams;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "consumePurchase", "Lcom/android/billingclient/api/ConsumeResult;", "Lcom/android/billingclient/api/ConsumeParams;", "(Lcom/android/billingclient/api/BillingClient;Lcom/android/billingclient/api/ConsumeParams;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createAlternativeBillingOnlyReportingDetails", "Lcom/android/billingclient/api/CreateAlternativeBillingOnlyReportingDetailsResult;", "(Lcom/android/billingclient/api/BillingClient;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createExternalOfferReportingDetails", "Lcom/android/billingclient/api/CreateExternalOfferReportingDetailsResult;", "isAlternativeBillingOnlyAvailable", "isExternalOfferAvailable", "queryProductDetails", "Lcom/android/billingclient/api/ProductDetailsResult;", "Lcom/android/billingclient/api/QueryProductDetailsParams;", "(Lcom/android/billingclient/api/BillingClient;Lcom/android/billingclient/api/QueryProductDetailsParams;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "queryPurchaseHistory", "Lcom/android/billingclient/api/PurchaseHistoryResult;", "Lcom/android/billingclient/api/QueryPurchaseHistoryParams;", "(Lcom/android/billingclient/api/BillingClient;Lcom/android/billingclient/api/QueryPurchaseHistoryParams;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "skuType", "", "(Lcom/android/billingclient/api/BillingClient;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "queryPurchasesAsync", "Lcom/android/billingclient/api/PurchasesResult;", "Lcom/android/billingclient/api/QueryPurchasesParams;", "(Lcom/android/billingclient/api/BillingClient;Lcom/android/billingclient/api/QueryPurchasesParams;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "querySkuDetails", "Lcom/android/billingclient/api/SkuDetailsResult;", "Lcom/android/billingclient/api/SkuDetailsParams;", "(Lcom/android/billingclient/api/BillingClient;Lcom/android/billingclient/api/SkuDetailsParams;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "java.com.google.android.libraries.play.billing.public.ktbilling_granule"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* compiled from: com.android.billingclient:billing-ktx@@7.0.0 */
public final class BillingClientKotlinKt {
    public static /* synthetic */ void $r8$lambda$1JhcD_0Y_gWWNKF2aNTk2toOOyY(CompletableDeferred completableDeferred, BillingResult billingResult) {
        Intrinsics.checkNotNullParameter(completableDeferred, "$deferred");
        Intrinsics.checkNotNull(billingResult);
        completableDeferred.complete(billingResult);
    }

    public static /* synthetic */ void $r8$lambda$9SKPFUMhNCJ3v0PMCwGqle8zR10(CompletableDeferred completableDeferred, BillingResult billingResult, List list) {
        Intrinsics.checkNotNullParameter(completableDeferred, "$deferred");
        Intrinsics.checkNotNull(billingResult);
        completableDeferred.complete(new SkuDetailsResult(billingResult, list));
    }

    /* renamed from: $r8$lambda$BC2cAL2vk_I3dV-pkSAsSywRIek  reason: not valid java name */
    public static /* synthetic */ void m137$r8$lambda$BC2cAL2vk_I3dVpkSAsSywRIek(CompletableDeferred completableDeferred, BillingResult billingResult, String str) {
        Intrinsics.checkNotNullParameter(completableDeferred, "$deferred");
        Intrinsics.checkNotNull(billingResult);
        completableDeferred.complete(new ConsumeResult(billingResult, str));
    }

    public static /* synthetic */ void $r8$lambda$Bt5YvFTOU7XGqhy1u2vanp4Jc20(CompletableDeferred completableDeferred, BillingResult billingResult, ExternalOfferReportingDetails externalOfferReportingDetails) {
        Intrinsics.checkNotNullParameter(completableDeferred, "$deferred");
        Intrinsics.checkNotNull(billingResult);
        completableDeferred.complete(new CreateExternalOfferReportingDetailsResult(billingResult, externalOfferReportingDetails));
    }

    /* renamed from: $r8$lambda$Iy_vpeZ_JH-NmajeE6ZBdUlqJKA  reason: not valid java name */
    public static /* synthetic */ void m138$r8$lambda$Iy_vpeZ_JHNmajeE6ZBdUlqJKA(CompletableDeferred completableDeferred, BillingResult billingResult, List list) {
        Intrinsics.checkNotNullParameter(completableDeferred, "$deferred");
        Intrinsics.checkNotNull(billingResult);
        Intrinsics.checkNotNull(list);
        completableDeferred.complete(new PurchasesResult(billingResult, list));
    }

    /* renamed from: $r8$lambda$Jmx2bDJUe-jQbQfqNR-Rv-qVuz0  reason: not valid java name */
    public static /* synthetic */ void m139$r8$lambda$Jmx2bDJUejQbQfqNRRvqVuz0(CompletableDeferred completableDeferred, BillingResult billingResult, List list) {
        Intrinsics.checkNotNullParameter(completableDeferred, "$deferred");
        Intrinsics.checkNotNull(billingResult);
        completableDeferred.complete(new PurchaseHistoryResult(billingResult, list));
    }

    /* renamed from: $r8$lambda$NdU5wcJ8m2M9H_puX2oHpjb25-w  reason: not valid java name */
    public static /* synthetic */ void m140$r8$lambda$NdU5wcJ8m2M9H_puX2oHpjb25w(CompletableDeferred completableDeferred, BillingResult billingResult, AlternativeBillingOnlyReportingDetails alternativeBillingOnlyReportingDetails) {
        Intrinsics.checkNotNullParameter(completableDeferred, "$deferred");
        Intrinsics.checkNotNull(billingResult);
        completableDeferred.complete(new CreateAlternativeBillingOnlyReportingDetailsResult(billingResult, alternativeBillingOnlyReportingDetails));
    }

    /* renamed from: $r8$lambda$OmYoMPMU8NG-G-TTJRupXijq_ag  reason: not valid java name */
    public static /* synthetic */ void m141$r8$lambda$OmYoMPMU8NGGTTJRupXijq_ag(CompletableDeferred completableDeferred, BillingResult billingResult) {
        Intrinsics.checkNotNullParameter(completableDeferred, "$deferred");
        Intrinsics.checkNotNull(billingResult);
        completableDeferred.complete(billingResult);
    }

    public static /* synthetic */ void $r8$lambda$ZzkEujuP9GqFND2FbZB_kuqycGM(CompletableDeferred completableDeferred, BillingResult billingResult, List list) {
        Intrinsics.checkNotNullParameter(completableDeferred, "$deferred");
        Intrinsics.checkNotNull(billingResult);
        completableDeferred.complete(new PurchaseHistoryResult(billingResult, list));
    }

    /* renamed from: $r8$lambda$_HjOTKlijnqR-5v_YY-SPcvW1bw  reason: not valid java name */
    public static /* synthetic */ void m142$r8$lambda$_HjOTKlijnqR5v_YYSPcvW1bw(CompletableDeferred completableDeferred, BillingResult billingResult, List list) {
        Intrinsics.checkNotNullParameter(completableDeferred, "$deferred");
        Intrinsics.checkNotNull(billingResult);
        completableDeferred.complete(new ProductDetailsResult(billingResult, list));
    }

    public static /* synthetic */ void $r8$lambda$mNiIov37EcRv6CLKJbxie9rmtK8(CompletableDeferred completableDeferred, BillingResult billingResult) {
        Intrinsics.checkNotNullParameter(completableDeferred, "$deferred");
        Intrinsics.checkNotNull(billingResult);
        completableDeferred.complete(billingResult);
    }

    public static /* synthetic */ void $r8$lambda$wzezm1LgRtzooDMmMf2vgdwDzEw(CompletableDeferred completableDeferred, BillingResult billingResult, List list) {
        Intrinsics.checkNotNullParameter(completableDeferred, "$deferred");
        Intrinsics.checkNotNull(billingResult);
        Intrinsics.checkNotNull(list);
        completableDeferred.complete(new PurchasesResult(billingResult, list));
    }

    public static final Object acknowledgePurchase(BillingClient billingClient, AcknowledgePurchaseParams acknowledgePurchaseParams, Continuation<? super BillingResult> continuation) {
        CompletableDeferred CompletableDeferred$default = CompletableDeferredKt.CompletableDeferred$default((Job) null, 1, (Object) null);
        billingClient.acknowledgePurchase(acknowledgePurchaseParams, new BillingClientKotlinKt$$ExternalSyntheticLambda4(CompletableDeferred$default));
        return CompletableDeferred$default.await(continuation);
    }

    public static final Object consumePurchase(BillingClient billingClient, ConsumeParams consumeParams, Continuation<? super ConsumeResult> continuation) {
        CompletableDeferred CompletableDeferred$default = CompletableDeferredKt.CompletableDeferred$default((Job) null, 1, (Object) null);
        billingClient.consumeAsync(consumeParams, new BillingClientKotlinKt$$ExternalSyntheticLambda1(CompletableDeferred$default));
        return CompletableDeferred$default.await(continuation);
    }

    public static final Object createAlternativeBillingOnlyReportingDetails(BillingClient billingClient, Continuation<? super CreateAlternativeBillingOnlyReportingDetailsResult> continuation) {
        CompletableDeferred CompletableDeferred$default = CompletableDeferredKt.CompletableDeferred$default((Job) null, 1, (Object) null);
        billingClient.createAlternativeBillingOnlyReportingDetailsAsync(new BillingClientKotlinKt$$ExternalSyntheticLambda9(CompletableDeferred$default));
        return CompletableDeferred$default.await(continuation);
    }

    public static final Object createExternalOfferReportingDetails(BillingClient billingClient, Continuation<? super CreateExternalOfferReportingDetailsResult> continuation) {
        CompletableDeferred CompletableDeferred$default = CompletableDeferredKt.CompletableDeferred$default((Job) null, 1, (Object) null);
        billingClient.createExternalOfferReportingDetailsAsync(new BillingClientKotlinKt$$ExternalSyntheticLambda5(CompletableDeferred$default));
        return CompletableDeferred$default.await(continuation);
    }

    public static final Object isAlternativeBillingOnlyAvailable(BillingClient billingClient, Continuation<? super BillingResult> continuation) {
        CompletableDeferred CompletableDeferred$default = CompletableDeferredKt.CompletableDeferred$default((Job) null, 1, (Object) null);
        billingClient.isAlternativeBillingOnlyAvailableAsync(new BillingClientKotlinKt$$ExternalSyntheticLambda7(CompletableDeferred$default));
        return CompletableDeferred$default.await(continuation);
    }

    public static final Object isExternalOfferAvailable(BillingClient billingClient, Continuation<? super BillingResult> continuation) {
        CompletableDeferred CompletableDeferred$default = CompletableDeferredKt.CompletableDeferred$default((Job) null, 1, (Object) null);
        billingClient.isExternalOfferAvailableAsync(new BillingClientKotlinKt$$ExternalSyntheticLambda2(CompletableDeferred$default));
        return CompletableDeferred$default.await(continuation);
    }

    public static final Object queryProductDetails(BillingClient billingClient, QueryProductDetailsParams queryProductDetailsParams, Continuation<? super ProductDetailsResult> continuation) {
        CompletableDeferred CompletableDeferred$default = CompletableDeferredKt.CompletableDeferred$default((Job) null, 1, (Object) null);
        billingClient.queryProductDetailsAsync(queryProductDetailsParams, new BillingClientKotlinKt$$ExternalSyntheticLambda3(CompletableDeferred$default));
        return CompletableDeferred$default.await(continuation);
    }

    public static final Object queryPurchaseHistory(BillingClient billingClient, QueryPurchaseHistoryParams queryPurchaseHistoryParams, Continuation<? super PurchaseHistoryResult> continuation) {
        CompletableDeferred CompletableDeferred$default = CompletableDeferredKt.CompletableDeferred$default((Job) null, 1, (Object) null);
        billingClient.queryPurchaseHistoryAsync(queryPurchaseHistoryParams, (PurchaseHistoryResponseListener) new BillingClientKotlinKt$$ExternalSyntheticLambda6(CompletableDeferred$default));
        return CompletableDeferred$default.await(continuation);
    }

    public static final Object queryPurchasesAsync(BillingClient billingClient, QueryPurchasesParams queryPurchasesParams, Continuation<? super PurchasesResult> continuation) {
        CompletableDeferred CompletableDeferred$default = CompletableDeferredKt.CompletableDeferred$default((Job) null, 1, (Object) null);
        billingClient.queryPurchasesAsync(queryPurchasesParams, (PurchasesResponseListener) new BillingClientKotlinKt$$ExternalSyntheticLambda10(CompletableDeferred$default));
        return CompletableDeferred$default.await(continuation);
    }

    @Deprecated(message = "Use [BillingClient.queryProductDetails] instead")
    public static final Object querySkuDetails(BillingClient billingClient, SkuDetailsParams skuDetailsParams, Continuation<? super SkuDetailsResult> continuation) {
        CompletableDeferred CompletableDeferred$default = CompletableDeferredKt.CompletableDeferred$default((Job) null, 1, (Object) null);
        billingClient.querySkuDetailsAsync(skuDetailsParams, new BillingClientKotlinKt$$ExternalSyntheticLambda11(CompletableDeferred$default));
        return CompletableDeferred$default.await(continuation);
    }

    @Deprecated(message = "Use [BillingClient.queryPurchaseHistory(QueryPurchaseHistoryParams)] instead")
    public static final Object queryPurchaseHistory(BillingClient billingClient, String str, Continuation<? super PurchaseHistoryResult> continuation) {
        CompletableDeferred CompletableDeferred$default = CompletableDeferredKt.CompletableDeferred$default((Job) null, 1, (Object) null);
        billingClient.queryPurchaseHistoryAsync(str, (PurchaseHistoryResponseListener) new BillingClientKotlinKt$$ExternalSyntheticLambda8(CompletableDeferred$default));
        return CompletableDeferred$default.await(continuation);
    }

    @Deprecated(message = "Use [BillingClient.queryPurchasesAsync(QueryPurchasesParams)] instead")
    public static final Object queryPurchasesAsync(BillingClient billingClient, String str, Continuation<? super PurchasesResult> continuation) {
        CompletableDeferred CompletableDeferred$default = CompletableDeferredKt.CompletableDeferred$default((Job) null, 1, (Object) null);
        billingClient.queryPurchasesAsync(str, (PurchasesResponseListener) new BillingClientKotlinKt$$ExternalSyntheticLambda0(CompletableDeferred$default));
        return CompletableDeferred$default.await(continuation);
    }
}
