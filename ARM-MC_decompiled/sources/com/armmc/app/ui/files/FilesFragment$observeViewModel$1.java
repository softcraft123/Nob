package com.armmc.app.ui.files;

import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowKt;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.armmc.app.ui.files.FilesFragment$observeViewModel$1", f = "FilesFragment.kt", i = {}, l = {114}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: FilesFragment.kt */
final class FilesFragment$observeViewModel$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ FilesFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FilesFragment$observeViewModel$1(FilesFragment filesFragment, Continuation<? super FilesFragment$observeViewModel$1> continuation) {
        super(2, continuation);
        this.this$0 = filesFragment;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new FilesFragment$observeViewModel$1(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((FilesFragment$observeViewModel$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\n"}, d2 = {"<anonymous>", "", "items", "", "Lcom/armmc/app/ui/files/FileItem;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.armmc.app.ui.files.FilesFragment$observeViewModel$1$1", f = "FilesFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.armmc.app.ui.files.FilesFragment$observeViewModel$1$1  reason: invalid class name */
    /* compiled from: FilesFragment.kt */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<List<? extends FileItem>, Continuation<? super Unit>, Object> {
        /* synthetic */ Object L$0;
        int label;

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 r0 = new AnonymousClass1(filesFragment, continuation);
            r0.L$0 = obj;
            return r0;
        }

        public final Object invoke(List<FileItem> list, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(list, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                List list = (List) this.L$0;
                FileAdapter access$getAdapter$p = filesFragment.adapter;
                if (access$getAdapter$p == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adapter");
                    access$getAdapter$p = null;
                }
                access$getAdapter$p.updateItems(list);
                int i = 0;
                filesFragment.getBinding().emptyText.setVisibility(list.isEmpty() ? 0 : 8);
                RecyclerView recyclerView = filesFragment.getBinding().fileRecyclerView;
                if (list.isEmpty()) {
                    i = 8;
                }
                recyclerView.setVisibility(i);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            FilesViewModel access$getViewModel$p = this.this$0.viewModel;
            if (access$getViewModel$p == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                access$getViewModel$p = null;
            }
            final FilesFragment filesFragment = this.this$0;
            this.label = 1;
            if (FlowKt.collectLatest(access$getViewModel$p.getItems(), new AnonymousClass1((Continuation<? super AnonymousClass1>) null), this) == coroutine_suspended) {
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
