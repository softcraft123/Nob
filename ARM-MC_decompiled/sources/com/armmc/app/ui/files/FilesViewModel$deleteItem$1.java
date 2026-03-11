package com.armmc.app.ui.files;

import com.armmc.app.ui.files.FilesViewModel;
import java.io.File;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.armmc.app.ui.files.FilesViewModel$deleteItem$1", f = "FilesViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: FilesViewModel.kt */
final class FilesViewModel$deleteItem$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ FileItem $item;
    int label;
    final /* synthetic */ FilesViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FilesViewModel$deleteItem$1(FileItem fileItem, FilesViewModel filesViewModel, Continuation<? super FilesViewModel$deleteItem$1> continuation) {
        super(2, continuation);
        this.$item = fileItem;
        this.this$0 = filesViewModel;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new FilesViewModel$deleteItem$1(this.$item, this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((FilesViewModel$deleteItem$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            FilesKt.deleteRecursively(this.$item.getFile());
            FilesViewModel.DirectoryEntry directoryEntry = (FilesViewModel.DirectoryEntry) CollectionsKt.lastOrNull(this.this$0.directoryStack);
            File file = directoryEntry != null ? directoryEntry.getFile() : null;
            if (file != null) {
                this.this$0.loadDirectory(file);
            } else {
                this.this$0.loadRoot();
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
