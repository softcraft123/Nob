package com.armmc.app.ui.files;

import com.armmc.app.ui.files.FilesViewModel;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.MutableStateFlow;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.armmc.app.ui.files.FilesViewModel$navigateTo$1", f = "FilesViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: FilesViewModel.kt */
final class FilesViewModel$navigateTo$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ FileItem $item;
    int label;
    final /* synthetic */ FilesViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FilesViewModel$navigateTo$1(FilesViewModel filesViewModel, FileItem fileItem, Continuation<? super FilesViewModel$navigateTo$1> continuation) {
        super(2, continuation);
        this.this$0 = filesViewModel;
        this.$item = fileItem;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new FilesViewModel$navigateTo$1(this.this$0, this.$item, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((FilesViewModel$navigateTo$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            this.this$0.directoryStack.add(new FilesViewModel.DirectoryEntry(this.$item.getName(), this.$item.getFile()));
            MutableStateFlow access$get_breadcrumb$p = this.this$0._breadcrumb;
            Collection listOf = CollectionsKt.listOf("Home");
            Iterable<FilesViewModel.DirectoryEntry> access$getDirectoryStack$p = this.this$0.directoryStack;
            Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(access$getDirectoryStack$p, 10));
            for (FilesViewModel.DirectoryEntry label2 : access$getDirectoryStack$p) {
                arrayList.add(label2.getLabel());
            }
            access$get_breadcrumb$p.setValue(CollectionsKt.plus(listOf, (List) arrayList));
            this.this$0._isAtRoot.setValue(Boxing.boxBoolean(false));
            this.this$0._searchQuery.setValue("");
            this.this$0.loadDirectory(this.$item.getFile());
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
