package com.google.android.play.core.ktx;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.play.core.splitinstall.SplitInstallManager;
import com.google.android.play.core.splitinstall.SplitInstallSessionState;
import com.google.android.play.core.splitinstall.SplitInstallStateUpdatedListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.ProducerScope;

@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00010\u0000H@"}, d2 = {"Lkotlinx/coroutines/channels/ProducerScope;", "Lcom/google/android/play/core/splitinstall/SplitInstallSessionState;", "", "<anonymous>"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "com.google.android.play.core.ktx.SplitInstallManagerKtxKt$requestProgressFlow$1", f = "SplitInstallManagerKtx.kt", i = {}, l = {84}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: com.google.android.play:feature-delivery-ktx@@2.1.0 */
final class SplitInstallManagerKtxKt$requestProgressFlow$1 extends SuspendLambda implements Function2<ProducerScope<? super SplitInstallSessionState>, Continuation<? super Unit>, Object> {
    final /* synthetic */ SplitInstallManager $this_requestProgressFlow;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SplitInstallManagerKtxKt$requestProgressFlow$1(SplitInstallManager splitInstallManager, Continuation<? super SplitInstallManagerKtxKt$requestProgressFlow$1> continuation) {
        super(2, continuation);
        this.$this_requestProgressFlow = splitInstallManager;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        SplitInstallManagerKtxKt$requestProgressFlow$1 splitInstallManagerKtxKt$requestProgressFlow$1 = new SplitInstallManagerKtxKt$requestProgressFlow$1(this.$this_requestProgressFlow, continuation);
        splitInstallManagerKtxKt$requestProgressFlow$1.L$0 = obj;
        return splitInstallManagerKtxKt$requestProgressFlow$1;
    }

    public final Object invoke(ProducerScope<? super SplitInstallSessionState> producerScope, Continuation<? super Unit> continuation) {
        return ((SplitInstallManagerKtxKt$requestProgressFlow$1) create(producerScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            final ProducerScope producerScope = (ProducerScope) this.L$0;
            final Set linkedHashSet = new LinkedHashSet();
            final SplitInstallStateUpdatedListener splitInstallManagerKtxKt$requestProgressFlow$1$globalSessionListener$1 = new SplitInstallManagerKtxKt$requestProgressFlow$1$globalSessionListener$1(linkedHashSet, producerScope);
            this.$this_requestProgressFlow.registerListener(splitInstallManagerKtxKt$requestProgressFlow$1$globalSessionListener$1);
            this.$this_requestProgressFlow.getSessionStates().addOnSuccessListener(new OnSuccessListener() {
                public final void onSuccess(List<? extends SplitInstallSessionState> list) {
                    Intrinsics.checkNotNullParameter(list, "sessionList");
                    Set<Integer> set = linkedHashSet;
                    Collection arrayList = new ArrayList();
                    for (Object next : list) {
                        if (!set.contains(Integer.valueOf(((SplitInstallSessionState) next).sessionId()))) {
                            arrayList.add(next);
                        }
                    }
                    ProducerScope<SplitInstallSessionState> producerScope = producerScope;
                    for (SplitInstallSessionState tryOffer : (List) arrayList) {
                        SplitInstallManagerKtxKt.tryOffer(producerScope, tryOffer);
                    }
                }
            }).addOnFailureListener(new OnFailureListener() {
                public final void onFailure(Exception exc) {
                    Intrinsics.checkNotNullParameter(exc, "exception");
                    producerScope.close(exc);
                }
            });
            final SplitInstallManager splitInstallManager = this.$this_requestProgressFlow;
            this.label = 1;
            if (ProduceKt.awaitClose(producerScope, new Function0<Unit>() {
                public final void invoke() {
                    splitInstallManager.unregisterListener(splitInstallManagerKtxKt$requestProgressFlow$1$globalSessionListener$1);
                }
            }, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}
