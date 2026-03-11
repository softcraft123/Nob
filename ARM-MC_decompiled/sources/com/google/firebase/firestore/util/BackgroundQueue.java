package com.google.firebase.firestore.util;

import java.util.concurrent.Executor;
import java.util.concurrent.Semaphore;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.ExecutorsKt;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000 \f2\u00020\u0001:\u0002\u000b\fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ\u0006\u0010\n\u001a\u00020\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/google/firebase/firestore/util/BackgroundQueue;", "", "<init>", "()V", "state", "Lcom/google/firebase/firestore/util/BackgroundQueue$State;", "submit", "", "runnable", "Ljava/lang/Runnable;", "drain", "State", "Companion", "com.google.firebase-firebase-firestore"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* compiled from: BackgroundQueue.kt */
public final class BackgroundQueue {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final Executor executor;
    /* access modifiers changed from: private */
    public static final int maxParallelism;
    private State state = new State.Submitting();

    public final void submit(Runnable runnable) {
        Intrinsics.checkNotNullParameter(runnable, "runnable");
        State state2 = this.state;
        if (state2 instanceof State.Submitting) {
            State.Submitting submitting = (State.Submitting) state2;
            submitting.setTaskCount(submitting.getTaskCount() + 1);
            executor.execute(new BackgroundQueue$$ExternalSyntheticLambda0(runnable, state2));
            return;
        }
        throw new IllegalStateException("submit() may not be called after drain()".toString());
    }

    /* access modifiers changed from: private */
    public static final void submit$lambda$1(Runnable runnable, State state2) {
        try {
            runnable.run();
        } finally {
            ((State.Submitting) state2).getCompletedTasks().release();
        }
    }

    public final void drain() {
        State state2 = this.state;
        if (state2 instanceof State.Submitting) {
            this.state = State.Draining.INSTANCE;
            State.Submitting submitting = (State.Submitting) state2;
            submitting.getCompletedTasks().acquire(submitting.getTaskCount());
            return;
        }
        throw new IllegalStateException("drain() may not be called more than once".toString());
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\br\u0018\u00002\u00020\u0001:\u0002\u0002\u0003\u0001\u0002\u0004\u0005¨\u0006\u0006"}, d2 = {"Lcom/google/firebase/firestore/util/BackgroundQueue$State;", "", "Submitting", "Draining", "Lcom/google/firebase/firestore/util/BackgroundQueue$State$Draining;", "Lcom/google/firebase/firestore/util/BackgroundQueue$State$Submitting;", "com.google.firebase-firebase-firestore"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* compiled from: BackgroundQueue.kt */
    private interface State {

        @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/google/firebase/firestore/util/BackgroundQueue$State$Submitting;", "Lcom/google/firebase/firestore/util/BackgroundQueue$State;", "<init>", "()V", "completedTasks", "Ljava/util/concurrent/Semaphore;", "getCompletedTasks", "()Ljava/util/concurrent/Semaphore;", "taskCount", "", "getTaskCount", "()I", "setTaskCount", "(I)V", "com.google.firebase-firebase-firestore"}, k = 1, mv = {2, 0, 0}, xi = 48)
        /* compiled from: BackgroundQueue.kt */
        public static final class Submitting implements State {
            private final Semaphore completedTasks = new Semaphore(0);
            private int taskCount;

            public final Semaphore getCompletedTasks() {
                return this.completedTasks;
            }

            public final int getTaskCount() {
                return this.taskCount;
            }

            public final void setTaskCount(int i) {
                this.taskCount = i;
            }
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/google/firebase/firestore/util/BackgroundQueue$State$Draining;", "Lcom/google/firebase/firestore/util/BackgroundQueue$State;", "<init>", "()V", "com.google.firebase-firebase-firestore"}, k = 1, mv = {2, 0, 0}, xi = 48)
        /* compiled from: BackgroundQueue.kt */
        public static final class Draining implements State {
            public static final Draining INSTANCE = new Draining();

            private Draining() {
            }
        }
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/google/firebase/firestore/util/BackgroundQueue$Companion;", "", "<init>", "()V", "maxParallelism", "", "getMaxParallelism", "()I", "executor", "Ljava/util/concurrent/Executor;", "com.google.firebase-firebase-firestore"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* compiled from: BackgroundQueue.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final int getMaxParallelism() {
            return BackgroundQueue.maxParallelism;
        }
    }

    static {
        int coerceAtLeast = RangesKt.coerceAtLeast(Runtime.getRuntime().availableProcessors(), 2);
        maxParallelism = coerceAtLeast;
        executor = ExecutorsKt.asExecutor(Dispatchers.getIO().limitedParallelism(coerceAtLeast, "firestore.BackgroundQueue"));
    }
}
