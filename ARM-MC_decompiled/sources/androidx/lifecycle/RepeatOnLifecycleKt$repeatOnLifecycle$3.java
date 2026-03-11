package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.lifecycle.RepeatOnLifecycleKt$repeatOnLifecycle$3", f = "RepeatOnLifecycle.kt", i = {}, l = {84}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: RepeatOnLifecycle.kt */
final class RepeatOnLifecycleKt$repeatOnLifecycle$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function2<CoroutineScope, Continuation<? super Unit>, Object> $block;
    final /* synthetic */ Lifecycle.State $state;
    final /* synthetic */ Lifecycle $this_repeatOnLifecycle;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    RepeatOnLifecycleKt$repeatOnLifecycle$3(Lifecycle lifecycle, Lifecycle.State state, Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super RepeatOnLifecycleKt$repeatOnLifecycle$3> continuation) {
        super(2, continuation);
        this.$this_repeatOnLifecycle = lifecycle;
        this.$state = state;
        this.$block = function2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        RepeatOnLifecycleKt$repeatOnLifecycle$3 repeatOnLifecycleKt$repeatOnLifecycle$3 = new RepeatOnLifecycleKt$repeatOnLifecycle$3(this.$this_repeatOnLifecycle, this.$state, this.$block, continuation);
        repeatOnLifecycleKt$repeatOnLifecycle$3.L$0 = obj;
        return repeatOnLifecycleKt$repeatOnLifecycle$3;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((RepeatOnLifecycleKt$repeatOnLifecycle$3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.lifecycle.RepeatOnLifecycleKt$repeatOnLifecycle$3$1", f = "RepeatOnLifecycle.kt", i = {0, 0}, l = {166}, m = "invokeSuspend", n = {"launchedJob", "observer"}, s = {"L$0", "L$1"})
    /* renamed from: androidx.lifecycle.RepeatOnLifecycleKt$repeatOnLifecycle$3$1  reason: invalid class name */
    /* compiled from: RepeatOnLifecycle.kt */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(lifecycle, state, coroutineScope, function2, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v17, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v6, resolved type: kotlin.jvm.internal.Ref$ObjectRef} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v18, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v14, resolved type: kotlin.jvm.internal.Ref$ObjectRef} */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r15) {
            /*
                r14 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r14.label
                r2 = 0
                r3 = 1
                if (r1 == 0) goto L_0x0037
                if (r1 != r3) goto L_0x002f
                java.lang.Object r0 = r14.L$5
                kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
                java.lang.Object r0 = r14.L$4
                kotlinx.coroutines.CoroutineScope r0 = (kotlinx.coroutines.CoroutineScope) r0
                java.lang.Object r0 = r14.L$3
                androidx.lifecycle.Lifecycle r0 = (androidx.lifecycle.Lifecycle) r0
                java.lang.Object r0 = r14.L$2
                androidx.lifecycle.Lifecycle$State r0 = (androidx.lifecycle.Lifecycle.State) r0
                java.lang.Object r0 = r14.L$1
                r1 = r0
                kotlin.jvm.internal.Ref$ObjectRef r1 = (kotlin.jvm.internal.Ref.ObjectRef) r1
                java.lang.Object r0 = r14.L$0
                r4 = r0
                kotlin.jvm.internal.Ref$ObjectRef r4 = (kotlin.jvm.internal.Ref.ObjectRef) r4
                kotlin.ResultKt.throwOnFailure(r15)     // Catch:{ all -> 0x002b }
                goto L_0x00b3
            L_0x002b:
                r0 = move-exception
                r15 = r0
                goto L_0x00cf
            L_0x002f:
                java.lang.IllegalStateException r15 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r15.<init>(r0)
                throw r15
            L_0x0037:
                kotlin.ResultKt.throwOnFailure(r15)
                androidx.lifecycle.Lifecycle r15 = r4
                androidx.lifecycle.Lifecycle$State r15 = r15.getCurrentState()
                androidx.lifecycle.Lifecycle$State r1 = androidx.lifecycle.Lifecycle.State.DESTROYED
                if (r15 != r1) goto L_0x0047
                kotlin.Unit r15 = kotlin.Unit.INSTANCE
                return r15
            L_0x0047:
                kotlin.jvm.internal.Ref$ObjectRef r6 = new kotlin.jvm.internal.Ref$ObjectRef
                r6.<init>()
                kotlin.jvm.internal.Ref$ObjectRef r1 = new kotlin.jvm.internal.Ref$ObjectRef
                r1.<init>()
                androidx.lifecycle.Lifecycle$State r15 = r5     // Catch:{ all -> 0x00cc }
                androidx.lifecycle.Lifecycle r12 = r4     // Catch:{ all -> 0x00cc }
                kotlinx.coroutines.CoroutineScope r7 = r6     // Catch:{ all -> 0x00cc }
                kotlin.jvm.functions.Function2<kotlinx.coroutines.CoroutineScope, kotlin.coroutines.Continuation<? super kotlin.Unit>, java.lang.Object> r11 = r7     // Catch:{ all -> 0x00cc }
                r14.L$0 = r6     // Catch:{ all -> 0x00cc }
                r14.L$1 = r1     // Catch:{ all -> 0x00cc }
                r14.L$2 = r15     // Catch:{ all -> 0x00cc }
                r14.L$3 = r12     // Catch:{ all -> 0x00cc }
                r14.L$4 = r7     // Catch:{ all -> 0x00cc }
                r14.L$5 = r11     // Catch:{ all -> 0x00cc }
                r14.label = r3     // Catch:{ all -> 0x00cc }
                r4 = r14
                kotlin.coroutines.Continuation r4 = (kotlin.coroutines.Continuation) r4     // Catch:{ all -> 0x00cc }
                kotlinx.coroutines.CancellableContinuationImpl r13 = new kotlinx.coroutines.CancellableContinuationImpl     // Catch:{ all -> 0x00cc }
                kotlin.coroutines.Continuation r4 = kotlin.coroutines.intrinsics.IntrinsicsKt.intercepted(r4)     // Catch:{ all -> 0x00cc }
                r13.<init>(r4, r3)     // Catch:{ all -> 0x00cc }
                r13.initCancellability()     // Catch:{ all -> 0x00cc }
                r9 = r13
                kotlinx.coroutines.CancellableContinuation r9 = (kotlinx.coroutines.CancellableContinuation) r9     // Catch:{ all -> 0x00cc }
                androidx.lifecycle.Lifecycle$Event$Companion r4 = androidx.lifecycle.Lifecycle.Event.Companion     // Catch:{ all -> 0x00cc }
                androidx.lifecycle.Lifecycle$Event r5 = r4.upTo(r15)     // Catch:{ all -> 0x00cc }
                androidx.lifecycle.Lifecycle$Event$Companion r4 = androidx.lifecycle.Lifecycle.Event.Companion     // Catch:{ all -> 0x00cc }
                androidx.lifecycle.Lifecycle$Event r8 = r4.downFrom(r15)     // Catch:{ all -> 0x00cc }
                r15 = 0
                kotlinx.coroutines.sync.Mutex r10 = kotlinx.coroutines.sync.MutexKt.Mutex$default(r15, r3, r2)     // Catch:{ all -> 0x00cc }
                androidx.lifecycle.RepeatOnLifecycleKt$repeatOnLifecycle$3$1$1$1 r4 = new androidx.lifecycle.RepeatOnLifecycleKt$repeatOnLifecycle$3$1$1$1     // Catch:{ all -> 0x00cc }
                r4.<init>(r5, r6, r7, r8, r9, r10, r11)     // Catch:{ all -> 0x00cc }
                r1.element = r4     // Catch:{ all -> 0x00cc }
                T r15 = r1.element     // Catch:{ all -> 0x00cc }
                java.lang.String r4 = "null cannot be cast to non-null type androidx.lifecycle.LifecycleEventObserver"
                kotlin.jvm.internal.Intrinsics.checkNotNull(r15, r4)     // Catch:{ all -> 0x00cc }
                androidx.lifecycle.LifecycleEventObserver r15 = (androidx.lifecycle.LifecycleEventObserver) r15     // Catch:{ all -> 0x00cc }
                androidx.lifecycle.LifecycleObserver r15 = (androidx.lifecycle.LifecycleObserver) r15     // Catch:{ all -> 0x00cc }
                r12.addObserver(r15)     // Catch:{ all -> 0x00cc }
                java.lang.Object r15 = r13.getResult()     // Catch:{ all -> 0x00cc }
                java.lang.Object r4 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()     // Catch:{ all -> 0x00cc }
                if (r15 != r4) goto L_0x00af
                r4 = r14
                kotlin.coroutines.Continuation r4 = (kotlin.coroutines.Continuation) r4     // Catch:{ all -> 0x00cc }
                kotlin.coroutines.jvm.internal.DebugProbesKt.probeCoroutineSuspended(r4)     // Catch:{ all -> 0x00cc }
            L_0x00af:
                if (r15 != r0) goto L_0x00b2
                return r0
            L_0x00b2:
                r4 = r6
            L_0x00b3:
                T r15 = r4.element
                kotlinx.coroutines.Job r15 = (kotlinx.coroutines.Job) r15
                if (r15 == 0) goto L_0x00bc
                kotlinx.coroutines.Job.DefaultImpls.cancel$default((kotlinx.coroutines.Job) r15, (java.util.concurrent.CancellationException) r2, (int) r3, (java.lang.Object) r2)
            L_0x00bc:
                T r15 = r1.element
                androidx.lifecycle.LifecycleEventObserver r15 = (androidx.lifecycle.LifecycleEventObserver) r15
                if (r15 == 0) goto L_0x00c9
                androidx.lifecycle.Lifecycle r0 = r4
                androidx.lifecycle.LifecycleObserver r15 = (androidx.lifecycle.LifecycleObserver) r15
                r0.removeObserver(r15)
            L_0x00c9:
                kotlin.Unit r15 = kotlin.Unit.INSTANCE
                return r15
            L_0x00cc:
                r0 = move-exception
                r15 = r0
                r4 = r6
            L_0x00cf:
                T r0 = r4.element
                kotlinx.coroutines.Job r0 = (kotlinx.coroutines.Job) r0
                if (r0 == 0) goto L_0x00d8
                kotlinx.coroutines.Job.DefaultImpls.cancel$default((kotlinx.coroutines.Job) r0, (java.util.concurrent.CancellationException) r2, (int) r3, (java.lang.Object) r2)
            L_0x00d8:
                T r0 = r1.element
                androidx.lifecycle.LifecycleEventObserver r0 = (androidx.lifecycle.LifecycleEventObserver) r0
                if (r0 == 0) goto L_0x00e5
                androidx.lifecycle.Lifecycle r1 = r4
                androidx.lifecycle.LifecycleObserver r0 = (androidx.lifecycle.LifecycleObserver) r0
                r1.removeObserver(r0)
            L_0x00e5:
                throw r15
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.lifecycle.RepeatOnLifecycleKt$repeatOnLifecycle$3.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            final CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            final Lifecycle lifecycle = this.$this_repeatOnLifecycle;
            final Lifecycle.State state = this.$state;
            final Function2<CoroutineScope, Continuation<? super Unit>, Object> function2 = this.$block;
            this.label = 1;
            if (BuildersKt.withContext(Dispatchers.getMain().getImmediate(), new AnonymousClass1((Continuation<? super AnonymousClass1>) null), this) == coroutine_suspended) {
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
