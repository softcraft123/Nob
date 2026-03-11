package com.armmc.app.ui.files;

import com.armmc.app.ui.files.FilesViewModel;
import java.io.File;
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

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.armmc.app.ui.files.FilesViewModel$navigateUp$2", f = "FilesViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: FilesViewModel.kt */
final class FilesViewModel$navigateUp$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ FilesViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FilesViewModel$navigateUp$2(FilesViewModel filesViewModel, Continuation<? super FilesViewModel$navigateUp$2> continuation) {
        super(2, continuation);
        this.this$0 = filesViewModel;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new FilesViewModel$navigateUp$2(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((FilesViewModel$navigateUp$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            if (this.this$0.directoryStack.isEmpty()) {
                this.this$0._isAtRoot.setValue(Boxing.boxBoolean(true));
                this.this$0.loadRoot();
            } else {
                File file = ((FilesViewModel.DirectoryEntry) CollectionsKt.last(this.this$0.directoryStack)).getFile();
                if (file != null) {
                    this.this$0.loadDirectory(file);
                } else {
                    this.this$0._isAtRoot.setValue(Boxing.boxBoolean(true));
                    this.this$0.loadRoot();
                }
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
