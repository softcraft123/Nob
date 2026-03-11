package androidx.datastore.core;

import androidx.datastore.core.Message;
import androidx.datastore.core.UpdatingDataContextElement;
import androidx.datastore.core.handlers.NoOpCorruptionHandler;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;

@Metadata(d1 = {"\u0000°\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0000\u0018\u0000 V*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002:\u0002VWBn\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012?\b\u0002\u0010\u0005\u001a9\u00125\u00123\b\u0001\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00028\u00000\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\u00070\u0006\u0012\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0010\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0012¢\u0006\u0002\u0010\u0013J\u000e\u00103\u001a\u00020\rH@¢\u0006\u0002\u00104JG\u00105\u001a\u0002H6\"\u0004\b\u0001\u001062\u0006\u00107\u001a\u0002082\u001c\u00109\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H60\f\u0012\u0006\u0012\u0004\u0018\u00010\u000e0:H@\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0002 \u0001¢\u0006\u0002\u0010;J\u001c\u0010<\u001a\u00020\r2\f\u0010=\u001a\b\u0012\u0004\u0012\u00028\u000002H@¢\u0006\u0002\u0010>J\u000e\u0010?\u001a\u00020\rH@¢\u0006\u0002\u00104J\u000e\u0010@\u001a\u00020\rH@¢\u0006\u0002\u00104J\u001c\u0010A\u001a\b\u0012\u0004\u0012\u00028\u00000B2\u0006\u0010C\u001a\u000208H@¢\u0006\u0002\u0010DJ\u000e\u0010E\u001a\u00028\u0000H@¢\u0006\u0002\u00104J\u001c\u0010F\u001a\b\u0012\u0004\u0012\u00028\u00000G2\u0006\u00107\u001a\u000208H@¢\u0006\u0002\u0010DJ\u001c\u0010H\u001a\b\u0012\u0004\u0012\u00028\u00000B2\u0006\u0010C\u001a\u000208H@¢\u0006\u0002\u0010DJI\u0010I\u001a\u00028\u000021\u0010J\u001a-\b\u0001\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(K\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\f\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\u00072\u0006\u0010L\u001a\u00020MH@¢\u0006\u0002\u0010NJA\u0010O\u001a\u00028\u000021\u0010J\u001a-\b\u0001\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(K\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\f\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\u0007H@¢\u0006\u0002\u0010PJ \u0010Q\u001a\u00020\u00152\u0006\u0010R\u001a\u00028\u00002\u0006\u0010S\u001a\u000208H@¢\u0006\u0004\bT\u0010UR\u000e\u0010\u0014\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u001a\u001a\u00020\u001b8BX\u0002¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b\u001c\u0010\u001dR\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0010X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010 \u001a\b\u0012\u0004\u0012\u00028\u00000!X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0014\u0010$\u001a\b\u0012\u0004\u0012\u00028\u00000%X\u0004¢\u0006\u0002\n\u0000R\u0018\u0010&\u001a\f0'R\b\u0012\u0004\u0012\u00028\u00000\u0000X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004X\u0004¢\u0006\u0002\n\u0000R!\u0010(\u001a\b\u0012\u0004\u0012\u00028\u00000)8@X\u0002¢\u0006\f\u001a\u0004\b,\u0010-*\u0004\b*\u0010+R\u001a\u0010.\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000)0/X\u0004¢\u0006\u0002\n\u0000R\u001a\u00100\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000201X\u0004¢\u0006\u0002\n\u0000¨\u0006X"}, d2 = {"Landroidx/datastore/core/DataStoreImpl;", "T", "Landroidx/datastore/core/DataStore;", "storage", "Landroidx/datastore/core/Storage;", "initTasksList", "", "Lkotlin/Function2;", "Landroidx/datastore/core/InitializerApi;", "Lkotlin/ParameterName;", "name", "api", "Lkotlin/coroutines/Continuation;", "", "", "corruptionHandler", "Landroidx/datastore/core/CorruptionHandler;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "(Landroidx/datastore/core/Storage;Ljava/util/List;Landroidx/datastore/core/CorruptionHandler;Lkotlinx/coroutines/CoroutineScope;)V", "collectorCounter", "", "collectorJob", "Lkotlinx/coroutines/Job;", "collectorMutex", "Lkotlinx/coroutines/sync/Mutex;", "coordinator", "Landroidx/datastore/core/InterProcessCoordinator;", "getCoordinator", "()Landroidx/datastore/core/InterProcessCoordinator;", "coordinator$delegate", "Lkotlin/Lazy;", "data", "Lkotlinx/coroutines/flow/Flow;", "getData", "()Lkotlinx/coroutines/flow/Flow;", "inMemoryCache", "Landroidx/datastore/core/DataStoreInMemoryCache;", "readAndInit", "Landroidx/datastore/core/DataStoreImpl$InitDataStore;", "storageConnection", "Landroidx/datastore/core/StorageConnection;", "getStorageConnection$datastore_core_release$delegate", "(Landroidx/datastore/core/DataStoreImpl;)Ljava/lang/Object;", "getStorageConnection$datastore_core_release", "()Landroidx/datastore/core/StorageConnection;", "storageConnectionDelegate", "Lkotlin/Lazy;", "writeActor", "Landroidx/datastore/core/SimpleActor;", "Landroidx/datastore/core/Message$Update;", "decrementCollector", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "doWithWriteFileLock", "R", "hasWriteFileLock", "", "block", "Lkotlin/Function1;", "(ZLkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "handleUpdate", "update", "(Landroidx/datastore/core/Message$Update;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "incrementCollector", "readAndInitOrPropagateAndThrowFailure", "readDataAndUpdateCache", "Landroidx/datastore/core/State;", "requireLock", "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "readDataFromFileOrDefault", "readDataOrHandleCorruption", "Landroidx/datastore/core/Data;", "readState", "transformAndWrite", "transform", "t", "callerContext", "Lkotlin/coroutines/CoroutineContext;", "(Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/CoroutineContext;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateData", "(Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "writeData", "newData", "updateCache", "writeData$datastore_core_release", "(Ljava/lang/Object;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "InitDataStore", "datastore-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: DataStoreImpl.kt */
public final class DataStoreImpl<T> implements DataStore<T> {
    private static final String BUG_MESSAGE = "This is a bug in DataStore. Please file a bug at: https://issuetracker.google.com/issues/new?component=907884&template=1466542";
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private int collectorCounter;
    private Job collectorJob;
    private final Mutex collectorMutex;
    private final Lazy coordinator$delegate;
    private final CorruptionHandler<T> corruptionHandler;
    private final Flow<T> data;
    /* access modifiers changed from: private */
    public final DataStoreInMemoryCache<T> inMemoryCache;
    /* access modifiers changed from: private */
    public final DataStoreImpl<T>.InitDataStore readAndInit;
    private final CoroutineScope scope;
    /* access modifiers changed from: private */
    public final Storage<T> storage;
    /* access modifiers changed from: private */
    public final Lazy<StorageConnection<T>> storageConnectionDelegate;
    /* access modifiers changed from: private */
    public final SimpleActor<Message.Update<T>> writeActor;

    public DataStoreImpl(Storage<T> storage2, List<? extends Function2<? super InitializerApi<T>, ? super Continuation<? super Unit>, ? extends Object>> list, CorruptionHandler<T> corruptionHandler2, CoroutineScope coroutineScope) {
        Intrinsics.checkNotNullParameter(storage2, "storage");
        Intrinsics.checkNotNullParameter(list, "initTasksList");
        Intrinsics.checkNotNullParameter(corruptionHandler2, "corruptionHandler");
        Intrinsics.checkNotNullParameter(coroutineScope, "scope");
        this.storage = storage2;
        this.corruptionHandler = corruptionHandler2;
        this.scope = coroutineScope;
        this.data = FlowKt.flow(new DataStoreImpl$data$1(this, (Continuation<? super DataStoreImpl$data$1>) null));
        this.collectorMutex = MutexKt.Mutex$default(false, 1, (Object) null);
        this.inMemoryCache = new DataStoreInMemoryCache<>();
        this.readAndInit = new InitDataStore(this, list);
        this.storageConnectionDelegate = LazyKt.lazy(new DataStoreImpl$storageConnectionDelegate$1(this));
        this.coordinator$delegate = LazyKt.lazy(new DataStoreImpl$coordinator$2(this));
        this.writeActor = new SimpleActor<>(coroutineScope, new DataStoreImpl$writeActor$1(this), DataStoreImpl$writeActor$2.INSTANCE, new DataStoreImpl$writeActor$3(this, (Continuation<? super DataStoreImpl$writeActor$3>) null));
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ DataStoreImpl(Storage storage2, List list, CorruptionHandler corruptionHandler2, CoroutineScope coroutineScope, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(storage2, (i & 2) != 0 ? CollectionsKt.emptyList() : list, (i & 4) != 0 ? new NoOpCorruptionHandler() : corruptionHandler2, (i & 8) != 0 ? CoroutineScopeKt.CoroutineScope(Actual_jvmKt.ioDispatcher().plus(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null))) : coroutineScope);
    }

    public Flow<T> getData() {
        return this.data;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x003b  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0056 A[Catch:{ all -> 0x0072 }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object incrementCollector(kotlin.coroutines.Continuation<? super kotlin.Unit> r12) {
        /*
            r11 = this;
            boolean r0 = r12 instanceof androidx.datastore.core.DataStoreImpl$incrementCollector$1
            if (r0 == 0) goto L_0x0014
            r0 = r12
            androidx.datastore.core.DataStoreImpl$incrementCollector$1 r0 = (androidx.datastore.core.DataStoreImpl$incrementCollector$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r12 = r0.label
            int r12 = r12 - r2
            r0.label = r12
            goto L_0x0019
        L_0x0014:
            androidx.datastore.core.DataStoreImpl$incrementCollector$1 r0 = new androidx.datastore.core.DataStoreImpl$incrementCollector$1
            r0.<init>(r11, r12)
        L_0x0019:
            java.lang.Object r12 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L_0x003b
            if (r2 != r4) goto L_0x0033
            java.lang.Object r1 = r0.L$1
            kotlinx.coroutines.sync.Mutex r1 = (kotlinx.coroutines.sync.Mutex) r1
            java.lang.Object r0 = r0.L$0
            androidx.datastore.core.DataStoreImpl r0 = (androidx.datastore.core.DataStoreImpl) r0
            kotlin.ResultKt.throwOnFailure(r12)
            goto L_0x004f
        L_0x0033:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r0)
            throw r12
        L_0x003b:
            kotlin.ResultKt.throwOnFailure(r12)
            kotlinx.coroutines.sync.Mutex r12 = r11.collectorMutex
            r0.L$0 = r11
            r0.L$1 = r12
            r0.label = r4
            java.lang.Object r0 = r12.lock(r3, r0)
            if (r0 != r1) goto L_0x004d
            return r1
        L_0x004d:
            r0 = r11
            r1 = r12
        L_0x004f:
            int r12 = r0.collectorCounter     // Catch:{ all -> 0x0072 }
            int r12 = r12 + r4
            r0.collectorCounter = r12     // Catch:{ all -> 0x0072 }
            if (r12 != r4) goto L_0x006a
            kotlinx.coroutines.CoroutineScope r5 = r0.scope     // Catch:{ all -> 0x0072 }
            androidx.datastore.core.DataStoreImpl$incrementCollector$2$1 r12 = new androidx.datastore.core.DataStoreImpl$incrementCollector$2$1     // Catch:{ all -> 0x0072 }
            r12.<init>(r0, r3)     // Catch:{ all -> 0x0072 }
            r8 = r12
            kotlin.jvm.functions.Function2 r8 = (kotlin.jvm.functions.Function2) r8     // Catch:{ all -> 0x0072 }
            r9 = 3
            r10 = 0
            r6 = 0
            r7 = 0
            kotlinx.coroutines.Job r12 = kotlinx.coroutines.BuildersKt__Builders_commonKt.launch$default(r5, r6, r7, r8, r9, r10)     // Catch:{ all -> 0x0072 }
            r0.collectorJob = r12     // Catch:{ all -> 0x0072 }
        L_0x006a:
            kotlin.Unit r12 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0072 }
            r1.unlock(r3)
            kotlin.Unit r12 = kotlin.Unit.INSTANCE
            return r12
        L_0x0072:
            r0 = move-exception
            r12 = r0
            r1.unlock(r3)
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.DataStoreImpl.incrementCollector(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: finally extract failed */
    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x003b  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0057 A[Catch:{ all -> 0x0068 }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object decrementCollector(kotlin.coroutines.Continuation<? super kotlin.Unit> r6) {
        /*
            r5 = this;
            boolean r0 = r6 instanceof androidx.datastore.core.DataStoreImpl$decrementCollector$1
            if (r0 == 0) goto L_0x0014
            r0 = r6
            androidx.datastore.core.DataStoreImpl$decrementCollector$1 r0 = (androidx.datastore.core.DataStoreImpl$decrementCollector$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r6 = r0.label
            int r6 = r6 - r2
            r0.label = r6
            goto L_0x0019
        L_0x0014:
            androidx.datastore.core.DataStoreImpl$decrementCollector$1 r0 = new androidx.datastore.core.DataStoreImpl$decrementCollector$1
            r0.<init>(r5, r6)
        L_0x0019:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L_0x003b
            if (r2 != r3) goto L_0x0033
            java.lang.Object r1 = r0.L$1
            kotlinx.coroutines.sync.Mutex r1 = (kotlinx.coroutines.sync.Mutex) r1
            java.lang.Object r0 = r0.L$0
            androidx.datastore.core.DataStoreImpl r0 = (androidx.datastore.core.DataStoreImpl) r0
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x004f
        L_0x0033:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L_0x003b:
            kotlin.ResultKt.throwOnFailure(r6)
            kotlinx.coroutines.sync.Mutex r6 = r5.collectorMutex
            r0.L$0 = r5
            r0.L$1 = r6
            r0.label = r3
            java.lang.Object r0 = r6.lock(r4, r0)
            if (r0 != r1) goto L_0x004d
            return r1
        L_0x004d:
            r0 = r5
            r1 = r6
        L_0x004f:
            int r6 = r0.collectorCounter     // Catch:{ all -> 0x0068 }
            int r6 = r6 + -1
            r0.collectorCounter = r6     // Catch:{ all -> 0x0068 }
            if (r6 != 0) goto L_0x0060
            kotlinx.coroutines.Job r6 = r0.collectorJob     // Catch:{ all -> 0x0068 }
            if (r6 == 0) goto L_0x005e
            kotlinx.coroutines.Job.DefaultImpls.cancel$default((kotlinx.coroutines.Job) r6, (java.util.concurrent.CancellationException) r4, (int) r3, (java.lang.Object) r4)     // Catch:{ all -> 0x0068 }
        L_0x005e:
            r0.collectorJob = r4     // Catch:{ all -> 0x0068 }
        L_0x0060:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0068 }
            r1.unlock(r4)
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        L_0x0068:
            r6 = move-exception
            r1.unlock(r4)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.DataStoreImpl.decrementCollector(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public Object updateData(Function2<? super T, ? super Continuation<? super T>, ? extends Object> function2, Continuation<? super T> continuation) {
        UpdatingDataContextElement updatingDataContextElement = (UpdatingDataContextElement) continuation.getContext().get(UpdatingDataContextElement.Companion.Key.INSTANCE);
        if (updatingDataContextElement != null) {
            updatingDataContextElement.checkNotUpdating(this);
        }
        return BuildersKt.withContext(new UpdatingDataContextElement(updatingDataContextElement, this), new DataStoreImpl$updateData$2(this, function2, (Continuation<? super DataStoreImpl$updateData$2>) null), continuation);
    }

    private static Object getStorageConnection$datastore_core_release$delegate(DataStoreImpl<Object> dataStoreImpl) {
        return dataStoreImpl.storageConnectionDelegate;
    }

    public final StorageConnection<T> getStorageConnection$datastore_core_release() {
        return this.storageConnectionDelegate.getValue();
    }

    /* access modifiers changed from: private */
    public final InterProcessCoordinator getCoordinator() {
        return (InterProcessCoordinator) this.coordinator$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final Object readState(boolean z, Continuation<? super State<T>> continuation) {
        return BuildersKt.withContext(this.scope.getCoroutineContext(), new DataStoreImpl$readState$2(this, z, (Continuation<? super DataStoreImpl$readState$2>) null), continuation);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00b8, code lost:
        if (r9 != r1) goto L_0x0080;
     */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0057  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0026  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object handleUpdate(androidx.datastore.core.Message.Update<T> r9, kotlin.coroutines.Continuation<? super kotlin.Unit> r10) {
        /*
            r8 = this;
            boolean r0 = r10 instanceof androidx.datastore.core.DataStoreImpl$handleUpdate$1
            if (r0 == 0) goto L_0x0014
            r0 = r10
            androidx.datastore.core.DataStoreImpl$handleUpdate$1 r0 = (androidx.datastore.core.DataStoreImpl$handleUpdate$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r10 = r0.label
            int r10 = r10 - r2
            r0.label = r10
            goto L_0x0019
        L_0x0014:
            androidx.datastore.core.DataStoreImpl$handleUpdate$1 r0 = new androidx.datastore.core.DataStoreImpl$handleUpdate$1
            r0.<init>(r8, r10)
        L_0x0019:
            java.lang.Object r10 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 3
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L_0x0057
            if (r2 == r5) goto L_0x004b
            if (r2 == r4) goto L_0x0039
            if (r2 != r3) goto L_0x0031
            java.lang.Object r9 = r0.L$0
            kotlinx.coroutines.CompletableDeferred r9 = (kotlinx.coroutines.CompletableDeferred) r9
            goto L_0x004f
        L_0x0031:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L_0x0039:
            java.lang.Object r9 = r0.L$2
            kotlinx.coroutines.CompletableDeferred r9 = (kotlinx.coroutines.CompletableDeferred) r9
            java.lang.Object r2 = r0.L$1
            androidx.datastore.core.DataStoreImpl r2 = (androidx.datastore.core.DataStoreImpl) r2
            java.lang.Object r4 = r0.L$0
            androidx.datastore.core.Message$Update r4 = (androidx.datastore.core.Message.Update) r4
            kotlin.ResultKt.throwOnFailure(r10)     // Catch:{ all -> 0x0054 }
            r10 = r9
            r9 = r4
            goto L_0x00a3
        L_0x004b:
            java.lang.Object r9 = r0.L$0
            kotlinx.coroutines.CompletableDeferred r9 = (kotlinx.coroutines.CompletableDeferred) r9
        L_0x004f:
            kotlin.ResultKt.throwOnFailure(r10)     // Catch:{ all -> 0x0054 }
            goto L_0x00bb
        L_0x0054:
            r10 = move-exception
            goto L_0x00e1
        L_0x0057:
            kotlin.ResultKt.throwOnFailure(r10)
            kotlinx.coroutines.CompletableDeferred r10 = r9.getAck()
            kotlin.Result$Companion r2 = kotlin.Result.Companion     // Catch:{ all -> 0x00dd }
            r2 = r8
            androidx.datastore.core.DataStoreImpl r2 = (androidx.datastore.core.DataStoreImpl) r2     // Catch:{ all -> 0x00dd }
            androidx.datastore.core.DataStoreInMemoryCache<T> r2 = r8.inMemoryCache     // Catch:{ all -> 0x00dd }
            androidx.datastore.core.State r2 = r2.getCurrentState()     // Catch:{ all -> 0x00dd }
            boolean r6 = r2 instanceof androidx.datastore.core.Data     // Catch:{ all -> 0x00dd }
            if (r6 == 0) goto L_0x0084
            kotlin.jvm.functions.Function2 r2 = r9.getTransform()     // Catch:{ all -> 0x00dd }
            kotlin.coroutines.CoroutineContext r9 = r9.getCallerContext()     // Catch:{ all -> 0x00dd }
            r0.L$0 = r10     // Catch:{ all -> 0x00dd }
            r0.label = r5     // Catch:{ all -> 0x00dd }
            java.lang.Object r9 = r8.transformAndWrite(r2, r9, r0)     // Catch:{ all -> 0x00dd }
            if (r9 != r1) goto L_0x0080
            goto L_0x00ba
        L_0x0080:
            r7 = r10
            r10 = r9
            r9 = r7
            goto L_0x00bb
        L_0x0084:
            boolean r6 = r2 instanceof androidx.datastore.core.ReadException     // Catch:{ all -> 0x00dd }
            if (r6 == 0) goto L_0x0089
            goto L_0x008b
        L_0x0089:
            boolean r5 = r2 instanceof androidx.datastore.core.UnInitialized     // Catch:{ all -> 0x00dd }
        L_0x008b:
            if (r5 == 0) goto L_0x00cc
            androidx.datastore.core.State r5 = r9.getLastState()     // Catch:{ all -> 0x00dd }
            if (r2 != r5) goto L_0x00c0
            r0.L$0 = r9     // Catch:{ all -> 0x00dd }
            r0.L$1 = r8     // Catch:{ all -> 0x00dd }
            r0.L$2 = r10     // Catch:{ all -> 0x00dd }
            r0.label = r4     // Catch:{ all -> 0x00dd }
            java.lang.Object r2 = r8.readAndInitOrPropagateAndThrowFailure(r0)     // Catch:{ all -> 0x00dd }
            if (r2 != r1) goto L_0x00a2
            goto L_0x00ba
        L_0x00a2:
            r2 = r8
        L_0x00a3:
            kotlin.jvm.functions.Function2 r4 = r9.getTransform()     // Catch:{ all -> 0x00dd }
            kotlin.coroutines.CoroutineContext r9 = r9.getCallerContext()     // Catch:{ all -> 0x00dd }
            r0.L$0 = r10     // Catch:{ all -> 0x00dd }
            r5 = 0
            r0.L$1 = r5     // Catch:{ all -> 0x00dd }
            r0.L$2 = r5     // Catch:{ all -> 0x00dd }
            r0.label = r3     // Catch:{ all -> 0x00dd }
            java.lang.Object r9 = r2.transformAndWrite(r4, r9, r0)     // Catch:{ all -> 0x00dd }
            if (r9 != r1) goto L_0x0080
        L_0x00ba:
            return r1
        L_0x00bb:
            java.lang.Object r10 = kotlin.Result.m516constructorimpl(r10)     // Catch:{ all -> 0x0054 }
            goto L_0x00eb
        L_0x00c0:
            java.lang.String r9 = "null cannot be cast to non-null type androidx.datastore.core.ReadException<T of androidx.datastore.core.DataStoreImpl.handleUpdate$lambda$2>"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r2, r9)     // Catch:{ all -> 0x00dd }
            androidx.datastore.core.ReadException r2 = (androidx.datastore.core.ReadException) r2     // Catch:{ all -> 0x00dd }
            java.lang.Throwable r9 = r2.getReadException()     // Catch:{ all -> 0x00dd }
            throw r9     // Catch:{ all -> 0x00dd }
        L_0x00cc:
            boolean r9 = r2 instanceof androidx.datastore.core.Final     // Catch:{ all -> 0x00dd }
            if (r9 == 0) goto L_0x00d7
            androidx.datastore.core.Final r2 = (androidx.datastore.core.Final) r2     // Catch:{ all -> 0x00dd }
            java.lang.Throwable r9 = r2.getFinalException()     // Catch:{ all -> 0x00dd }
            throw r9     // Catch:{ all -> 0x00dd }
        L_0x00d7:
            kotlin.NoWhenBranchMatchedException r9 = new kotlin.NoWhenBranchMatchedException     // Catch:{ all -> 0x00dd }
            r9.<init>()     // Catch:{ all -> 0x00dd }
            throw r9     // Catch:{ all -> 0x00dd }
        L_0x00dd:
            r9 = move-exception
            r7 = r10
            r10 = r9
            r9 = r7
        L_0x00e1:
            kotlin.Result$Companion r0 = kotlin.Result.Companion
            java.lang.Object r10 = kotlin.ResultKt.createFailure(r10)
            java.lang.Object r10 = kotlin.Result.m516constructorimpl(r10)
        L_0x00eb:
            kotlinx.coroutines.CompletableDeferredKt.completeWith(r9, r10)
            kotlin.Unit r9 = kotlin.Unit.INSTANCE
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.DataStoreImpl.handleUpdate(androidx.datastore.core.Message$Update, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x006a, code lost:
        if (r4.runIfNeeded(r0) != r1) goto L_0x006d;
     */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0045  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object readAndInitOrPropagateAndThrowFailure(kotlin.coroutines.Continuation<? super kotlin.Unit> r6) {
        /*
            r5 = this;
            boolean r0 = r6 instanceof androidx.datastore.core.DataStoreImpl$readAndInitOrPropagateAndThrowFailure$1
            if (r0 == 0) goto L_0x0014
            r0 = r6
            androidx.datastore.core.DataStoreImpl$readAndInitOrPropagateAndThrowFailure$1 r0 = (androidx.datastore.core.DataStoreImpl$readAndInitOrPropagateAndThrowFailure$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r6 = r0.label
            int r6 = r6 - r2
            r0.label = r6
            goto L_0x0019
        L_0x0014:
            androidx.datastore.core.DataStoreImpl$readAndInitOrPropagateAndThrowFailure$1 r0 = new androidx.datastore.core.DataStoreImpl$readAndInitOrPropagateAndThrowFailure$1
            r0.<init>(r5, r6)
        L_0x0019:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x0045
            if (r2 == r4) goto L_0x003d
            if (r2 != r3) goto L_0x0035
            int r1 = r0.I$0
            java.lang.Object r0 = r0.L$0
            androidx.datastore.core.DataStoreImpl r0 = (androidx.datastore.core.DataStoreImpl) r0
            kotlin.ResultKt.throwOnFailure(r6)     // Catch:{ all -> 0x0033 }
            goto L_0x006d
        L_0x0033:
            r6 = move-exception
            goto L_0x0074
        L_0x0035:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L_0x003d:
            java.lang.Object r2 = r0.L$0
            androidx.datastore.core.DataStoreImpl r2 = (androidx.datastore.core.DataStoreImpl) r2
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x0058
        L_0x0045:
            kotlin.ResultKt.throwOnFailure(r6)
            androidx.datastore.core.InterProcessCoordinator r6 = r5.getCoordinator()
            r0.L$0 = r5
            r0.label = r4
            java.lang.Object r6 = r6.getVersion(r0)
            if (r6 != r1) goto L_0x0057
            goto L_0x006c
        L_0x0057:
            r2 = r5
        L_0x0058:
            java.lang.Number r6 = (java.lang.Number) r6
            int r6 = r6.intValue()
            androidx.datastore.core.DataStoreImpl<T>$InitDataStore r4 = r2.readAndInit     // Catch:{ all -> 0x0070 }
            r0.L$0 = r2     // Catch:{ all -> 0x0070 }
            r0.I$0 = r6     // Catch:{ all -> 0x0070 }
            r0.label = r3     // Catch:{ all -> 0x0070 }
            java.lang.Object r6 = r4.runIfNeeded(r0)     // Catch:{ all -> 0x0070 }
            if (r6 != r1) goto L_0x006d
        L_0x006c:
            return r1
        L_0x006d:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        L_0x0070:
            r0 = move-exception
            r1 = r6
            r6 = r0
            r0 = r2
        L_0x0074:
            androidx.datastore.core.DataStoreInMemoryCache<T> r0 = r0.inMemoryCache
            androidx.datastore.core.ReadException r2 = new androidx.datastore.core.ReadException
            r2.<init>(r6, r1)
            androidx.datastore.core.State r2 = (androidx.datastore.core.State) r2
            r0.tryUpdate(r2)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.DataStoreImpl.readAndInitOrPropagateAndThrowFailure(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00aa, code lost:
        if (r11 == r1) goto L_0x00c7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00c5, code lost:
        if (r11 == r1) goto L_0x00c7;
     */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0059  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0087  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x008c  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0095  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00b0  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00dc  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0026  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object readDataAndUpdateCache(boolean r10, kotlin.coroutines.Continuation<? super androidx.datastore.core.State<T>> r11) {
        /*
            r9 = this;
            boolean r0 = r11 instanceof androidx.datastore.core.DataStoreImpl$readDataAndUpdateCache$1
            if (r0 == 0) goto L_0x0014
            r0 = r11
            androidx.datastore.core.DataStoreImpl$readDataAndUpdateCache$1 r0 = (androidx.datastore.core.DataStoreImpl$readDataAndUpdateCache$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r11 = r0.label
            int r11 = r11 - r2
            r0.label = r11
            goto L_0x0019
        L_0x0014:
            androidx.datastore.core.DataStoreImpl$readDataAndUpdateCache$1 r0 = new androidx.datastore.core.DataStoreImpl$readDataAndUpdateCache$1
            r0.<init>(r9, r11)
        L_0x0019:
            java.lang.Object r11 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 3
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L_0x0059
            if (r2 == r5) goto L_0x0046
            if (r2 == r4) goto L_0x003d
            if (r2 != r3) goto L_0x0035
            java.lang.Object r10 = r0.L$0
            androidx.datastore.core.DataStoreImpl r10 = (androidx.datastore.core.DataStoreImpl) r10
            kotlin.ResultKt.throwOnFailure(r11)
            goto L_0x00c8
        L_0x0035:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L_0x003d:
            java.lang.Object r10 = r0.L$0
            androidx.datastore.core.DataStoreImpl r10 = (androidx.datastore.core.DataStoreImpl) r10
            kotlin.ResultKt.throwOnFailure(r11)
            goto L_0x00ad
        L_0x0046:
            boolean r10 = r0.Z$0
            java.lang.Object r2 = r0.L$1
            androidx.datastore.core.State r2 = (androidx.datastore.core.State) r2
            java.lang.Object r5 = r0.L$0
            androidx.datastore.core.DataStoreImpl r5 = (androidx.datastore.core.DataStoreImpl) r5
            kotlin.ResultKt.throwOnFailure(r11)
            r8 = r11
            r11 = r10
            r10 = r5
            r5 = r2
            r2 = r8
            goto L_0x007d
        L_0x0059:
            kotlin.ResultKt.throwOnFailure(r11)
            androidx.datastore.core.DataStoreInMemoryCache<T> r11 = r9.inMemoryCache
            androidx.datastore.core.State r2 = r11.getCurrentState()
            boolean r11 = r2 instanceof androidx.datastore.core.UnInitialized
            if (r11 != 0) goto L_0x00e2
            androidx.datastore.core.InterProcessCoordinator r11 = r9.getCoordinator()
            r0.L$0 = r9
            r0.L$1 = r2
            r0.Z$0 = r10
            r0.label = r5
            java.lang.Object r11 = r11.getVersion(r0)
            if (r11 != r1) goto L_0x0079
            goto L_0x00c7
        L_0x0079:
            r5 = r2
            r2 = r11
            r11 = r10
            r10 = r9
        L_0x007d:
            java.lang.Number r2 = (java.lang.Number) r2
            int r2 = r2.intValue()
            boolean r6 = r5 instanceof androidx.datastore.core.Data
            if (r6 == 0) goto L_0x008c
            int r7 = r5.getVersion()
            goto L_0x008d
        L_0x008c:
            r7 = -1
        L_0x008d:
            if (r6 == 0) goto L_0x0092
            if (r2 != r7) goto L_0x0092
            return r5
        L_0x0092:
            r2 = 0
            if (r11 == 0) goto L_0x00b0
            androidx.datastore.core.InterProcessCoordinator r11 = r10.getCoordinator()
            androidx.datastore.core.DataStoreImpl$readDataAndUpdateCache$3 r3 = new androidx.datastore.core.DataStoreImpl$readDataAndUpdateCache$3
            r3.<init>(r10, r2)
            kotlin.jvm.functions.Function1 r3 = (kotlin.jvm.functions.Function1) r3
            r0.L$0 = r10
            r0.L$1 = r2
            r0.label = r4
            java.lang.Object r11 = r11.lock(r3, r0)
            if (r11 != r1) goto L_0x00ad
            goto L_0x00c7
        L_0x00ad:
            kotlin.Pair r11 = (kotlin.Pair) r11
            goto L_0x00ca
        L_0x00b0:
            androidx.datastore.core.InterProcessCoordinator r11 = r10.getCoordinator()
            androidx.datastore.core.DataStoreImpl$readDataAndUpdateCache$4 r4 = new androidx.datastore.core.DataStoreImpl$readDataAndUpdateCache$4
            r4.<init>(r10, r7, r2)
            kotlin.jvm.functions.Function2 r4 = (kotlin.jvm.functions.Function2) r4
            r0.L$0 = r10
            r0.L$1 = r2
            r0.label = r3
            java.lang.Object r11 = r11.tryLock(r4, r0)
            if (r11 != r1) goto L_0x00c8
        L_0x00c7:
            return r1
        L_0x00c8:
            kotlin.Pair r11 = (kotlin.Pair) r11
        L_0x00ca:
            java.lang.Object r0 = r11.component1()
            androidx.datastore.core.State r0 = (androidx.datastore.core.State) r0
            java.lang.Object r11 = r11.component2()
            java.lang.Boolean r11 = (java.lang.Boolean) r11
            boolean r11 = r11.booleanValue()
            if (r11 == 0) goto L_0x00e1
            androidx.datastore.core.DataStoreInMemoryCache<T> r10 = r10.inMemoryCache
            r10.tryUpdate(r0)
        L_0x00e1:
            return r0
        L_0x00e2:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "This is a bug in DataStore. Please file a bug at: https://issuetracker.google.com/issues/new?component=907884&template=1466542"
            java.lang.String r11 = r11.toString()
            r10.<init>(r11)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.DataStoreImpl.readDataAndUpdateCache(boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    public final Object readDataFromFileOrDefault(Continuation<? super T> continuation) {
        return StorageConnectionKt.readData(getStorageConnection$datastore_core_release(), continuation);
    }

    /* access modifiers changed from: private */
    public final Object transformAndWrite(Function2<? super T, ? super Continuation<? super T>, ? extends Object> function2, CoroutineContext coroutineContext, Continuation<? super T> continuation) {
        return getCoordinator().lock(new DataStoreImpl$transformAndWrite$2(this, coroutineContext, function2, (Continuation<? super DataStoreImpl$transformAndWrite$2>) null), continuation);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object writeData$datastore_core_release(T r11, boolean r12, kotlin.coroutines.Continuation<? super java.lang.Integer> r13) {
        /*
            r10 = this;
            boolean r0 = r13 instanceof androidx.datastore.core.DataStoreImpl$writeData$1
            if (r0 == 0) goto L_0x0014
            r0 = r13
            androidx.datastore.core.DataStoreImpl$writeData$1 r0 = (androidx.datastore.core.DataStoreImpl$writeData$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r13 = r0.label
            int r13 = r13 - r2
            r0.label = r13
            goto L_0x0019
        L_0x0014:
            androidx.datastore.core.DataStoreImpl$writeData$1 r0 = new androidx.datastore.core.DataStoreImpl$writeData$1
            r0.<init>(r10, r13)
        L_0x0019:
            java.lang.Object r13 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0036
            if (r2 != r3) goto L_0x002e
            java.lang.Object r11 = r0.L$0
            kotlin.jvm.internal.Ref$IntRef r11 = (kotlin.jvm.internal.Ref.IntRef) r11
            kotlin.ResultKt.throwOnFailure(r13)
            goto L_0x0059
        L_0x002e:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L_0x0036:
            kotlin.ResultKt.throwOnFailure(r13)
            kotlin.jvm.internal.Ref$IntRef r5 = new kotlin.jvm.internal.Ref$IntRef
            r5.<init>()
            androidx.datastore.core.StorageConnection r13 = r10.getStorageConnection$datastore_core_release()
            androidx.datastore.core.DataStoreImpl$writeData$2 r4 = new androidx.datastore.core.DataStoreImpl$writeData$2
            r9 = 0
            r6 = r10
            r7 = r11
            r8 = r12
            r4.<init>(r5, r6, r7, r8, r9)
            kotlin.jvm.functions.Function2 r4 = (kotlin.jvm.functions.Function2) r4
            r0.L$0 = r5
            r0.label = r3
            java.lang.Object r11 = r13.writeScope(r4, r0)
            if (r11 != r1) goto L_0x0058
            return r1
        L_0x0058:
            r11 = r5
        L_0x0059:
            int r11 = r11.element
            java.lang.Integer r11 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r11)
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.DataStoreImpl.writeData$datastore_core_release(java.lang.Object, boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0083, code lost:
        r7 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00a9, code lost:
        if (r11 == null) goto L_0x00b2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:?, code lost:
        r2 = r11.hashCode();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00b0, code lost:
        r11 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00b2, code lost:
        r2 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00b3, code lost:
        r3 = r6.getCoordinator();
        r0.L$0 = r6;
        r0.L$1 = r11;
        r0.Z$0 = r10;
        r0.I$0 = r2;
        r0.label = 2;
        r3 = r3.getVersion(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00c6, code lost:
        if (r3 != r1) goto L_0x00ca;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00ca, code lost:
        r8 = r2;
        r2 = r10;
        r10 = r8;
        r8 = r3;
        r3 = r11;
        r11 = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x00db, code lost:
        return new androidx.datastore.core.Data(r3, r10, ((java.lang.Number) r11).intValue());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:?, code lost:
        r11 = ((java.lang.Number) r11).intValue();
        r0.L$0 = r2;
        r0.Z$0 = r10;
        r0.label = 4;
        r11 = r2.getCoordinator().tryLock(new androidx.datastore.core.DataStoreImpl$readDataOrHandleCorruption$2(r2, r11, (kotlin.coroutines.Continuation<? super androidx.datastore.core.DataStoreImpl$readDataOrHandleCorruption$2>) null), r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x010b, code lost:
        if (r11 != r1) goto L_0x010e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x0110, code lost:
        return (androidx.datastore.core.Data) r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x012e, code lost:
        r6 = r11;
        r11 = r3;
        r3 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x0131, code lost:
        r3.element = r11;
        r11 = new kotlin.jvm.internal.Ref.IntRef();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:?, code lost:
        r0.L$0 = r6;
        r0.L$1 = r2;
        r0.L$2 = r11;
        r0.L$3 = null;
        r0.label = 6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x014e, code lost:
        if (r7.doWithWriteFileLock(r10, new androidx.datastore.core.DataStoreImpl$readDataOrHandleCorruption$3(r2, r7, r11, (kotlin.coroutines.Continuation<? super androidx.datastore.core.DataStoreImpl$readDataOrHandleCorruption$3>) null), r0) != r1) goto L_0x0151;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x0151, code lost:
        r10 = r11;
        r1 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x0153, code lost:
        r0 = r1.element;
        r1 = r1.element;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x0159, code lost:
        if (r1 != null) goto L_0x015b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x015b, code lost:
        r5 = r1.hashCode();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x0164, code lost:
        return new androidx.datastore.core.Data(r0, r5, r10.element);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x0165, code lost:
        r10 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x0166, code lost:
        r0 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x0167, code lost:
        kotlin.ExceptionsKt.addSuppressed(r0, r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x016d, code lost:
        throw r0;
     */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x002f  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0043  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x005d  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0068  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0073  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0086  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0095  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x012e  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0027  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object readDataOrHandleCorruption(boolean r10, kotlin.coroutines.Continuation<? super androidx.datastore.core.Data<T>> r11) {
        /*
            r9 = this;
            boolean r0 = r11 instanceof androidx.datastore.core.DataStoreImpl$readDataOrHandleCorruption$1
            if (r0 == 0) goto L_0x0014
            r0 = r11
            androidx.datastore.core.DataStoreImpl$readDataOrHandleCorruption$1 r0 = (androidx.datastore.core.DataStoreImpl$readDataOrHandleCorruption$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r11 = r0.label
            int r11 = r11 - r2
            r0.label = r11
            goto L_0x0019
        L_0x0014:
            androidx.datastore.core.DataStoreImpl$readDataOrHandleCorruption$1 r0 = new androidx.datastore.core.DataStoreImpl$readDataOrHandleCorruption$1
            r0.<init>(r9, r11)
        L_0x0019:
            java.lang.Object r11 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            r4 = 0
            r5 = 0
            switch(r2) {
                case 0: goto L_0x0095;
                case 1: goto L_0x0086;
                case 2: goto L_0x0073;
                case 3: goto L_0x0068;
                case 4: goto L_0x005d;
                case 5: goto L_0x0043;
                case 6: goto L_0x002f;
                default: goto L_0x0027;
            }
        L_0x0027:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L_0x002f:
            java.lang.Object r10 = r0.L$2
            kotlin.jvm.internal.Ref$IntRef r10 = (kotlin.jvm.internal.Ref.IntRef) r10
            java.lang.Object r1 = r0.L$1
            kotlin.jvm.internal.Ref$ObjectRef r1 = (kotlin.jvm.internal.Ref.ObjectRef) r1
            java.lang.Object r0 = r0.L$0
            androidx.datastore.core.CorruptionException r0 = (androidx.datastore.core.CorruptionException) r0
            kotlin.ResultKt.throwOnFailure(r11)     // Catch:{ all -> 0x0040 }
            goto L_0x0153
        L_0x0040:
            r10 = move-exception
            goto L_0x0167
        L_0x0043:
            boolean r10 = r0.Z$0
            java.lang.Object r2 = r0.L$3
            kotlin.jvm.internal.Ref$ObjectRef r2 = (kotlin.jvm.internal.Ref.ObjectRef) r2
            java.lang.Object r3 = r0.L$2
            kotlin.jvm.internal.Ref$ObjectRef r3 = (kotlin.jvm.internal.Ref.ObjectRef) r3
            java.lang.Object r6 = r0.L$1
            androidx.datastore.core.CorruptionException r6 = (androidx.datastore.core.CorruptionException) r6
            java.lang.Object r7 = r0.L$0
            androidx.datastore.core.DataStoreImpl r7 = (androidx.datastore.core.DataStoreImpl) r7
            kotlin.ResultKt.throwOnFailure(r11)
            r8 = r3
            r3 = r2
            r2 = r8
            goto L_0x0131
        L_0x005d:
            boolean r10 = r0.Z$0
            java.lang.Object r2 = r0.L$0
            androidx.datastore.core.DataStoreImpl r2 = (androidx.datastore.core.DataStoreImpl) r2
            kotlin.ResultKt.throwOnFailure(r11)     // Catch:{ CorruptionException -> 0x0091 }
            goto L_0x010e
        L_0x0068:
            boolean r10 = r0.Z$0
            java.lang.Object r2 = r0.L$0
            androidx.datastore.core.DataStoreImpl r2 = (androidx.datastore.core.DataStoreImpl) r2
            kotlin.ResultKt.throwOnFailure(r11)     // Catch:{ CorruptionException -> 0x0091 }
            goto L_0x00ef
        L_0x0073:
            int r10 = r0.I$0
            boolean r2 = r0.Z$0
            java.lang.Object r3 = r0.L$1
            java.lang.Object r6 = r0.L$0
            androidx.datastore.core.DataStoreImpl r6 = (androidx.datastore.core.DataStoreImpl) r6
            kotlin.ResultKt.throwOnFailure(r11)     // Catch:{ CorruptionException -> 0x0081 }
            goto L_0x00d0
        L_0x0081:
            r11 = move-exception
            r10 = r2
        L_0x0083:
            r7 = r6
            goto L_0x0113
        L_0x0086:
            boolean r10 = r0.Z$0
            java.lang.Object r2 = r0.L$0
            androidx.datastore.core.DataStoreImpl r2 = (androidx.datastore.core.DataStoreImpl) r2
            kotlin.ResultKt.throwOnFailure(r11)     // Catch:{ CorruptionException -> 0x0091 }
            r6 = r2
            goto L_0x00a9
        L_0x0091:
            r11 = move-exception
            r7 = r2
            goto L_0x0113
        L_0x0095:
            kotlin.ResultKt.throwOnFailure(r11)
            if (r10 == 0) goto L_0x00dc
            r0.L$0 = r9     // Catch:{ CorruptionException -> 0x0111 }
            r0.Z$0 = r10     // Catch:{ CorruptionException -> 0x0111 }
            r0.label = r3     // Catch:{ CorruptionException -> 0x0111 }
            java.lang.Object r11 = r9.readDataFromFileOrDefault(r0)     // Catch:{ CorruptionException -> 0x0111 }
            if (r11 != r1) goto L_0x00a8
            goto L_0x0150
        L_0x00a8:
            r6 = r9
        L_0x00a9:
            if (r11 == 0) goto L_0x00b2
            int r2 = r11.hashCode()     // Catch:{ CorruptionException -> 0x00b0 }
            goto L_0x00b3
        L_0x00b0:
            r11 = move-exception
            goto L_0x0083
        L_0x00b2:
            r2 = r5
        L_0x00b3:
            androidx.datastore.core.InterProcessCoordinator r3 = r6.getCoordinator()     // Catch:{ CorruptionException -> 0x00b0 }
            r0.L$0 = r6     // Catch:{ CorruptionException -> 0x00b0 }
            r0.L$1 = r11     // Catch:{ CorruptionException -> 0x00b0 }
            r0.Z$0 = r10     // Catch:{ CorruptionException -> 0x00b0 }
            r0.I$0 = r2     // Catch:{ CorruptionException -> 0x00b0 }
            r7 = 2
            r0.label = r7     // Catch:{ CorruptionException -> 0x00b0 }
            java.lang.Object r3 = r3.getVersion(r0)     // Catch:{ CorruptionException -> 0x00b0 }
            if (r3 != r1) goto L_0x00ca
            goto L_0x0150
        L_0x00ca:
            r8 = r2
            r2 = r10
            r10 = r8
            r8 = r3
            r3 = r11
            r11 = r8
        L_0x00d0:
            java.lang.Number r11 = (java.lang.Number) r11     // Catch:{ CorruptionException -> 0x0081 }
            int r11 = r11.intValue()     // Catch:{ CorruptionException -> 0x0081 }
            androidx.datastore.core.Data r7 = new androidx.datastore.core.Data     // Catch:{ CorruptionException -> 0x0081 }
            r7.<init>(r3, r10, r11)     // Catch:{ CorruptionException -> 0x0081 }
            return r7
        L_0x00dc:
            androidx.datastore.core.InterProcessCoordinator r11 = r9.getCoordinator()     // Catch:{ CorruptionException -> 0x0111 }
            r0.L$0 = r9     // Catch:{ CorruptionException -> 0x0111 }
            r0.Z$0 = r10     // Catch:{ CorruptionException -> 0x0111 }
            r2 = 3
            r0.label = r2     // Catch:{ CorruptionException -> 0x0111 }
            java.lang.Object r11 = r11.getVersion(r0)     // Catch:{ CorruptionException -> 0x0111 }
            if (r11 != r1) goto L_0x00ee
            goto L_0x0150
        L_0x00ee:
            r2 = r9
        L_0x00ef:
            java.lang.Number r11 = (java.lang.Number) r11     // Catch:{ CorruptionException -> 0x0091 }
            int r11 = r11.intValue()     // Catch:{ CorruptionException -> 0x0091 }
            androidx.datastore.core.InterProcessCoordinator r3 = r2.getCoordinator()     // Catch:{ CorruptionException -> 0x0091 }
            androidx.datastore.core.DataStoreImpl$readDataOrHandleCorruption$2 r6 = new androidx.datastore.core.DataStoreImpl$readDataOrHandleCorruption$2     // Catch:{ CorruptionException -> 0x0091 }
            r6.<init>(r2, r11, r4)     // Catch:{ CorruptionException -> 0x0091 }
            kotlin.jvm.functions.Function2 r6 = (kotlin.jvm.functions.Function2) r6     // Catch:{ CorruptionException -> 0x0091 }
            r0.L$0 = r2     // Catch:{ CorruptionException -> 0x0091 }
            r0.Z$0 = r10     // Catch:{ CorruptionException -> 0x0091 }
            r11 = 4
            r0.label = r11     // Catch:{ CorruptionException -> 0x0091 }
            java.lang.Object r11 = r3.tryLock(r6, r0)     // Catch:{ CorruptionException -> 0x0091 }
            if (r11 != r1) goto L_0x010e
            goto L_0x0150
        L_0x010e:
            androidx.datastore.core.Data r11 = (androidx.datastore.core.Data) r11     // Catch:{ CorruptionException -> 0x0091 }
            return r11
        L_0x0111:
            r11 = move-exception
            r7 = r9
        L_0x0113:
            kotlin.jvm.internal.Ref$ObjectRef r2 = new kotlin.jvm.internal.Ref$ObjectRef
            r2.<init>()
            androidx.datastore.core.CorruptionHandler<T> r3 = r7.corruptionHandler
            r0.L$0 = r7
            r0.L$1 = r11
            r0.L$2 = r2
            r0.L$3 = r2
            r0.Z$0 = r10
            r6 = 5
            r0.label = r6
            java.lang.Object r3 = r3.handleCorruption(r11, r0)
            if (r3 != r1) goto L_0x012e
            goto L_0x0150
        L_0x012e:
            r6 = r11
            r11 = r3
            r3 = r2
        L_0x0131:
            r3.element = r11
            kotlin.jvm.internal.Ref$IntRef r11 = new kotlin.jvm.internal.Ref$IntRef
            r11.<init>()
            androidx.datastore.core.DataStoreImpl$readDataOrHandleCorruption$3 r3 = new androidx.datastore.core.DataStoreImpl$readDataOrHandleCorruption$3     // Catch:{ all -> 0x0165 }
            r3.<init>(r2, r7, r11, r4)     // Catch:{ all -> 0x0165 }
            kotlin.jvm.functions.Function1 r3 = (kotlin.jvm.functions.Function1) r3     // Catch:{ all -> 0x0165 }
            r0.L$0 = r6     // Catch:{ all -> 0x0165 }
            r0.L$1 = r2     // Catch:{ all -> 0x0165 }
            r0.L$2 = r11     // Catch:{ all -> 0x0165 }
            r0.L$3 = r4     // Catch:{ all -> 0x0165 }
            r4 = 6
            r0.label = r4     // Catch:{ all -> 0x0165 }
            java.lang.Object r10 = r7.doWithWriteFileLock(r10, r3, r0)     // Catch:{ all -> 0x0165 }
            if (r10 != r1) goto L_0x0151
        L_0x0150:
            return r1
        L_0x0151:
            r10 = r11
            r1 = r2
        L_0x0153:
            androidx.datastore.core.Data r11 = new androidx.datastore.core.Data
            T r0 = r1.element
            T r1 = r1.element
            if (r1 == 0) goto L_0x015f
            int r5 = r1.hashCode()
        L_0x015f:
            int r10 = r10.element
            r11.<init>(r0, r5, r10)
            return r11
        L_0x0165:
            r10 = move-exception
            r0 = r6
        L_0x0167:
            r11 = r0
            java.lang.Throwable r11 = (java.lang.Throwable) r11
            kotlin.ExceptionsKt.addSuppressed(r11, r10)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.DataStoreImpl.readDataOrHandleCorruption(boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    public final <R> Object doWithWriteFileLock(boolean z, Function1<? super Continuation<? super R>, ? extends Object> function1, Continuation<? super R> continuation) {
        if (z) {
            return function1.invoke(continuation);
        }
        return getCoordinator().lock(new DataStoreImpl$doWithWriteFileLock$3(function1, (Continuation<? super DataStoreImpl$doWithWriteFileLock$3>) null), continuation);
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\b\u0004\u0018\u00002\u00020\u0001BD\u0012=\u0010\u0002\u001a9\u00125\u00123\b\u0001\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00028\u00000\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u00040\u0003¢\u0006\u0002\u0010\fJ\u000e\u0010\u000e\u001a\u00020\nH@¢\u0006\u0002\u0010\u000fRG\u0010\r\u001a;\u00125\u00123\b\u0001\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00028\u00000\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Landroidx/datastore/core/DataStoreImpl$InitDataStore;", "Landroidx/datastore/core/RunOnce;", "initTasksList", "", "Lkotlin/Function2;", "Landroidx/datastore/core/InitializerApi;", "Lkotlin/ParameterName;", "name", "api", "Lkotlin/coroutines/Continuation;", "", "", "(Landroidx/datastore/core/DataStoreImpl;Ljava/util/List;)V", "initTasks", "doRun", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "datastore-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: DataStoreImpl.kt */
    private final class InitDataStore extends RunOnce {
        /* access modifiers changed from: private */
        public List<? extends Function2<? super InitializerApi<T>, ? super Continuation<? super Unit>, ? extends Object>> initTasks;
        final /* synthetic */ DataStoreImpl<T> this$0;

        public InitDataStore(DataStoreImpl dataStoreImpl, List<? extends Function2<? super InitializerApi<T>, ? super Continuation<? super Unit>, ? extends Object>> list) {
            Intrinsics.checkNotNullParameter(list, "initTasksList");
            this.this$0 = dataStoreImpl;
            this.initTasks = CollectionsKt.toList(list);
        }

        /* access modifiers changed from: protected */
        /* JADX WARNING: Removed duplicated region for block: B:14:0x0041  */
        /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.Object doRun(kotlin.coroutines.Continuation<? super kotlin.Unit> r7) {
            /*
                r6 = this;
                boolean r0 = r7 instanceof androidx.datastore.core.DataStoreImpl$InitDataStore$doRun$1
                if (r0 == 0) goto L_0x0014
                r0 = r7
                androidx.datastore.core.DataStoreImpl$InitDataStore$doRun$1 r0 = (androidx.datastore.core.DataStoreImpl$InitDataStore$doRun$1) r0
                int r1 = r0.label
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r1 = r1 & r2
                if (r1 == 0) goto L_0x0014
                int r7 = r0.label
                int r7 = r7 - r2
                r0.label = r7
                goto L_0x0019
            L_0x0014:
                androidx.datastore.core.DataStoreImpl$InitDataStore$doRun$1 r0 = new androidx.datastore.core.DataStoreImpl$InitDataStore$doRun$1
                r0.<init>(r6, r7)
            L_0x0019:
                java.lang.Object r7 = r0.result
                java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r2 = r0.label
                r3 = 2
                r4 = 1
                if (r2 == 0) goto L_0x0041
                if (r2 == r4) goto L_0x0039
                if (r2 != r3) goto L_0x0031
                java.lang.Object r0 = r0.L$0
                androidx.datastore.core.DataStoreImpl$InitDataStore r0 = (androidx.datastore.core.DataStoreImpl.InitDataStore) r0
                kotlin.ResultKt.throwOnFailure(r7)
                goto L_0x006e
            L_0x0031:
                java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r7.<init>(r0)
                throw r7
            L_0x0039:
                java.lang.Object r0 = r0.L$0
                androidx.datastore.core.DataStoreImpl$InitDataStore r0 = (androidx.datastore.core.DataStoreImpl.InitDataStore) r0
                kotlin.ResultKt.throwOnFailure(r7)
                goto L_0x0080
            L_0x0041:
                kotlin.ResultKt.throwOnFailure(r7)
                java.util.List<? extends kotlin.jvm.functions.Function2<? super androidx.datastore.core.InitializerApi<T>, ? super kotlin.coroutines.Continuation<? super kotlin.Unit>, ? extends java.lang.Object>> r7 = r6.initTasks
                if (r7 == 0) goto L_0x0071
                kotlin.jvm.internal.Intrinsics.checkNotNull(r7)
                boolean r7 = r7.isEmpty()
                if (r7 == 0) goto L_0x0052
                goto L_0x0071
            L_0x0052:
                androidx.datastore.core.DataStoreImpl<T> r7 = r6.this$0
                androidx.datastore.core.InterProcessCoordinator r7 = r7.getCoordinator()
                androidx.datastore.core.DataStoreImpl$InitDataStore$doRun$initData$1 r2 = new androidx.datastore.core.DataStoreImpl$InitDataStore$doRun$initData$1
                androidx.datastore.core.DataStoreImpl<T> r4 = r6.this$0
                r5 = 0
                r2.<init>(r4, r6, r5)
                kotlin.jvm.functions.Function1 r2 = (kotlin.jvm.functions.Function1) r2
                r0.L$0 = r6
                r0.label = r3
                java.lang.Object r7 = r7.lock(r2, r0)
                if (r7 != r1) goto L_0x006d
                goto L_0x007e
            L_0x006d:
                r0 = r6
            L_0x006e:
                androidx.datastore.core.Data r7 = (androidx.datastore.core.Data) r7
                goto L_0x0082
            L_0x0071:
                androidx.datastore.core.DataStoreImpl<T> r7 = r6.this$0
                r0.L$0 = r6
                r0.label = r4
                r2 = 0
                java.lang.Object r7 = r7.readDataOrHandleCorruption(r2, r0)
                if (r7 != r1) goto L_0x007f
            L_0x007e:
                return r1
            L_0x007f:
                r0 = r6
            L_0x0080:
                androidx.datastore.core.Data r7 = (androidx.datastore.core.Data) r7
            L_0x0082:
                androidx.datastore.core.DataStoreImpl<T> r0 = r0.this$0
                androidx.datastore.core.DataStoreInMemoryCache r0 = r0.inMemoryCache
                androidx.datastore.core.State r7 = (androidx.datastore.core.State) r7
                r0.tryUpdate(r7)
                kotlin.Unit r7 = kotlin.Unit.INSTANCE
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.DataStoreImpl.InitDataStore.doRun(kotlin.coroutines.Continuation):java.lang.Object");
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Landroidx/datastore/core/DataStoreImpl$Companion;", "", "()V", "BUG_MESSAGE", "", "datastore-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: DataStoreImpl.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
