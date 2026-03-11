package androidx.datastore.core;

import kotlin.Metadata;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.sync.Mutex;

@Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001JA\u0010\u0002\u001a\u00028\u000021\u0010\u0003\u001a-\b\u0001\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\b\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0004H@¢\u0006\u0002\u0010\n¨\u0006\u000b"}, d2 = {"androidx/datastore/core/DataStoreImpl$InitDataStore$doRun$initData$1$api$1", "Landroidx/datastore/core/InitializerApi;", "updateData", "transform", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "t", "Lkotlin/coroutines/Continuation;", "", "(Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "datastore-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: DataStoreImpl.kt */
public final class DataStoreImpl$InitDataStore$doRun$initData$1$api$1 implements InitializerApi<T> {
    final /* synthetic */ Ref.ObjectRef<T> $currentData;
    final /* synthetic */ Ref.BooleanRef $initializationComplete;
    final /* synthetic */ Mutex $updateLock;
    final /* synthetic */ DataStoreImpl<T> this$0;

    DataStoreImpl$InitDataStore$doRun$initData$1$api$1(Mutex mutex, Ref.BooleanRef booleanRef, Ref.ObjectRef<T> objectRef, DataStoreImpl<T> dataStoreImpl) {
        this.$updateLock = mutex;
        this.$initializationComplete = booleanRef;
        this.$currentData = objectRef;
        this.this$0 = dataStoreImpl;
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x0077  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x009b A[Catch:{ all -> 0x00e5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00bb A[Catch:{ all -> 0x0057 }] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00d2 A[Catch:{ all -> 0x003c }] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00d9  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0027  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object updateData(kotlin.jvm.functions.Function2<? super T, ? super kotlin.coroutines.Continuation<? super T>, ? extends java.lang.Object> r10, kotlin.coroutines.Continuation<? super T> r11) {
        /*
            r9 = this;
            boolean r0 = r11 instanceof androidx.datastore.core.DataStoreImpl$InitDataStore$doRun$initData$1$api$1$updateData$1
            if (r0 == 0) goto L_0x0014
            r0 = r11
            androidx.datastore.core.DataStoreImpl$InitDataStore$doRun$initData$1$api$1$updateData$1 r0 = (androidx.datastore.core.DataStoreImpl$InitDataStore$doRun$initData$1$api$1$updateData$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r11 = r0.label
            int r11 = r11 - r2
            r0.label = r11
            goto L_0x0019
        L_0x0014:
            androidx.datastore.core.DataStoreImpl$InitDataStore$doRun$initData$1$api$1$updateData$1 r0 = new androidx.datastore.core.DataStoreImpl$InitDataStore$doRun$initData$1$api$1$updateData$1
            r0.<init>(r9, r11)
        L_0x0019:
            java.lang.Object r11 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 3
            r4 = 2
            r5 = 1
            r6 = 0
            if (r2 == 0) goto L_0x0077
            if (r2 == r5) goto L_0x005b
            if (r2 == r4) goto L_0x0047
            if (r2 != r3) goto L_0x003f
            java.lang.Object r10 = r0.L$2
            java.lang.Object r1 = r0.L$1
            kotlin.jvm.internal.Ref$ObjectRef r1 = (kotlin.jvm.internal.Ref.ObjectRef) r1
            java.lang.Object r0 = r0.L$0
            kotlinx.coroutines.sync.Mutex r0 = (kotlinx.coroutines.sync.Mutex) r0
            kotlin.ResultKt.throwOnFailure(r11)     // Catch:{ all -> 0x003c }
            goto L_0x00ce
        L_0x003c:
            r10 = move-exception
            goto L_0x00e7
        L_0x003f:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L_0x0047:
            java.lang.Object r10 = r0.L$2
            androidx.datastore.core.DataStoreImpl r10 = (androidx.datastore.core.DataStoreImpl) r10
            java.lang.Object r2 = r0.L$1
            kotlin.jvm.internal.Ref$ObjectRef r2 = (kotlin.jvm.internal.Ref.ObjectRef) r2
            java.lang.Object r4 = r0.L$0
            kotlinx.coroutines.sync.Mutex r4 = (kotlinx.coroutines.sync.Mutex) r4
            kotlin.ResultKt.throwOnFailure(r11)     // Catch:{ all -> 0x0057 }
            goto L_0x00b3
        L_0x0057:
            r10 = move-exception
            r0 = r4
            goto L_0x00e7
        L_0x005b:
            java.lang.Object r10 = r0.L$4
            androidx.datastore.core.DataStoreImpl r10 = (androidx.datastore.core.DataStoreImpl) r10
            java.lang.Object r2 = r0.L$3
            kotlin.jvm.internal.Ref$ObjectRef r2 = (kotlin.jvm.internal.Ref.ObjectRef) r2
            java.lang.Object r5 = r0.L$2
            kotlin.jvm.internal.Ref$BooleanRef r5 = (kotlin.jvm.internal.Ref.BooleanRef) r5
            java.lang.Object r7 = r0.L$1
            kotlinx.coroutines.sync.Mutex r7 = (kotlinx.coroutines.sync.Mutex) r7
            java.lang.Object r8 = r0.L$0
            kotlin.jvm.functions.Function2 r8 = (kotlin.jvm.functions.Function2) r8
            kotlin.ResultKt.throwOnFailure(r11)
            r11 = r8
            r8 = r10
            r10 = r11
            r11 = r7
            goto L_0x0097
        L_0x0077:
            kotlin.ResultKt.throwOnFailure(r11)
            kotlinx.coroutines.sync.Mutex r11 = r9.$updateLock
            kotlin.jvm.internal.Ref$BooleanRef r2 = r9.$initializationComplete
            kotlin.jvm.internal.Ref$ObjectRef<T> r7 = r9.$currentData
            androidx.datastore.core.DataStoreImpl<T> r8 = r9.this$0
            r0.L$0 = r10
            r0.L$1 = r11
            r0.L$2 = r2
            r0.L$3 = r7
            r0.L$4 = r8
            r0.label = r5
            java.lang.Object r5 = r11.lock(r6, r0)
            if (r5 != r1) goto L_0x0095
            goto L_0x00ca
        L_0x0095:
            r5 = r2
            r2 = r7
        L_0x0097:
            boolean r5 = r5.element     // Catch:{ all -> 0x00e5 }
            if (r5 != 0) goto L_0x00d9
            T r5 = r2.element     // Catch:{ all -> 0x00e5 }
            r0.L$0 = r11     // Catch:{ all -> 0x00e5 }
            r0.L$1 = r2     // Catch:{ all -> 0x00e5 }
            r0.L$2 = r8     // Catch:{ all -> 0x00e5 }
            r0.L$3 = r6     // Catch:{ all -> 0x00e5 }
            r0.L$4 = r6     // Catch:{ all -> 0x00e5 }
            r0.label = r4     // Catch:{ all -> 0x00e5 }
            java.lang.Object r10 = r10.invoke(r5, r0)     // Catch:{ all -> 0x00e5 }
            if (r10 != r1) goto L_0x00b0
            goto L_0x00ca
        L_0x00b0:
            r4 = r11
            r11 = r10
            r10 = r8
        L_0x00b3:
            T r5 = r2.element     // Catch:{ all -> 0x0057 }
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r11, (java.lang.Object) r5)     // Catch:{ all -> 0x0057 }
            if (r5 != 0) goto L_0x00d2
            r0.L$0 = r4     // Catch:{ all -> 0x0057 }
            r0.L$1 = r2     // Catch:{ all -> 0x0057 }
            r0.L$2 = r11     // Catch:{ all -> 0x0057 }
            r0.label = r3     // Catch:{ all -> 0x0057 }
            r3 = 0
            java.lang.Object r10 = r10.writeData$datastore_core_release(r11, r3, r0)     // Catch:{ all -> 0x0057 }
            if (r10 != r1) goto L_0x00cb
        L_0x00ca:
            return r1
        L_0x00cb:
            r10 = r11
            r1 = r2
            r0 = r4
        L_0x00ce:
            r1.element = r10     // Catch:{ all -> 0x003c }
            r2 = r1
            goto L_0x00d3
        L_0x00d2:
            r0 = r4
        L_0x00d3:
            T r10 = r2.element     // Catch:{ all -> 0x003c }
            r0.unlock(r6)
            return r10
        L_0x00d9:
            java.lang.String r10 = "InitializerApi.updateData should not be called after initialization is complete."
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException     // Catch:{ all -> 0x00e5 }
            java.lang.String r10 = r10.toString()     // Catch:{ all -> 0x00e5 }
            r0.<init>(r10)     // Catch:{ all -> 0x00e5 }
            throw r0     // Catch:{ all -> 0x00e5 }
        L_0x00e5:
            r10 = move-exception
            r0 = r11
        L_0x00e7:
            r0.unlock(r6)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.DataStoreImpl$InitDataStore$doRun$initData$1$api$1.updateData(kotlin.jvm.functions.Function2, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
