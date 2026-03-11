package androidx.datastore.core;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u0003H@"}, d2 = {"<anonymous>", "Landroidx/datastore/core/State;", "T", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.datastore.core.DataStoreImpl$readState$2", f = "DataStoreImpl.kt", i = {}, l = {218, 226}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: DataStoreImpl.kt */
final class DataStoreImpl$readState$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super State<T>>, Object> {
    final /* synthetic */ boolean $requireLock;
    int label;
    final /* synthetic */ DataStoreImpl<T> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DataStoreImpl$readState$2(DataStoreImpl<T> dataStoreImpl, boolean z, Continuation<? super DataStoreImpl$readState$2> continuation) {
        super(2, continuation);
        this.this$0 = dataStoreImpl;
        this.$requireLock = z;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DataStoreImpl$readState$2(this.this$0, this.$requireLock, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super State<T>> continuation) {
        return ((DataStoreImpl$readState$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0047, code lost:
        if (r4.this$0.readAndInitOrPropagateAndThrowFailure(r4) == r0) goto L_0x0059;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0057, code lost:
        if (r5 == r0) goto L_0x0059;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0059, code lost:
        return r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r5) {
        /*
            r4 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r4.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L_0x0020
            if (r1 == r3) goto L_0x001a
            if (r1 != r2) goto L_0x0012
            kotlin.ResultKt.throwOnFailure(r5)
            goto L_0x005a
        L_0x0012:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L_0x001a:
            kotlin.ResultKt.throwOnFailure(r5)     // Catch:{ all -> 0x001e }
            goto L_0x004a
        L_0x001e:
            r5 = move-exception
            goto L_0x005d
        L_0x0020:
            kotlin.ResultKt.throwOnFailure(r5)
            androidx.datastore.core.DataStoreImpl<T> r5 = r4.this$0
            androidx.datastore.core.DataStoreInMemoryCache r5 = r5.inMemoryCache
            androidx.datastore.core.State r5 = r5.getCurrentState()
            boolean r5 = r5 instanceof androidx.datastore.core.Final
            if (r5 == 0) goto L_0x003c
            androidx.datastore.core.DataStoreImpl<T> r5 = r4.this$0
            androidx.datastore.core.DataStoreInMemoryCache r5 = r5.inMemoryCache
            androidx.datastore.core.State r5 = r5.getCurrentState()
            return r5
        L_0x003c:
            androidx.datastore.core.DataStoreImpl<T> r5 = r4.this$0     // Catch:{ all -> 0x001e }
            r1 = r4
            kotlin.coroutines.Continuation r1 = (kotlin.coroutines.Continuation) r1     // Catch:{ all -> 0x001e }
            r4.label = r3     // Catch:{ all -> 0x001e }
            java.lang.Object r5 = r5.readAndInitOrPropagateAndThrowFailure(r1)     // Catch:{ all -> 0x001e }
            if (r5 != r0) goto L_0x004a
            goto L_0x0059
        L_0x004a:
            androidx.datastore.core.DataStoreImpl<T> r5 = r4.this$0
            boolean r1 = r4.$requireLock
            r3 = r4
            kotlin.coroutines.Continuation r3 = (kotlin.coroutines.Continuation) r3
            r4.label = r2
            java.lang.Object r5 = r5.readDataAndUpdateCache(r1, r3)
            if (r5 != r0) goto L_0x005a
        L_0x0059:
            return r0
        L_0x005a:
            androidx.datastore.core.State r5 = (androidx.datastore.core.State) r5
            return r5
        L_0x005d:
            androidx.datastore.core.ReadException r0 = new androidx.datastore.core.ReadException
            r1 = -1
            r0.<init>(r5, r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.DataStoreImpl$readState$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
