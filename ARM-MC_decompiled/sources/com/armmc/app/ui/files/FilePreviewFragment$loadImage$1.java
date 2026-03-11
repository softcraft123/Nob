package com.armmc.app.ui.files;

import android.graphics.Bitmap;
import java.io.File;
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

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.armmc.app.ui.files.FilePreviewFragment$loadImage$1", f = "FilePreviewFragment.kt", i = {}, l = {72}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: FilePreviewFragment.kt */
final class FilePreviewFragment$loadImage$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ File $file;
    int label;
    final /* synthetic */ FilePreviewFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FilePreviewFragment$loadImage$1(FilePreviewFragment filePreviewFragment, File file, Continuation<? super FilePreviewFragment$loadImage$1> continuation) {
        super(2, continuation);
        this.this$0 = filePreviewFragment;
        this.$file = file;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new FilePreviewFragment$loadImage$1(this.this$0, this.$file, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((FilePreviewFragment$loadImage$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            obj = BuildersKt.withContext(Dispatchers.getIO(), new FilePreviewFragment$loadImage$1$bitmap$1(this.$file, (Continuation<? super FilePreviewFragment$loadImage$1$bitmap$1>) null), this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        Bitmap bitmap = (Bitmap) obj;
        this.this$0.getBinding().previewProgress.setVisibility(8);
        if (bitmap != null) {
            this.this$0.getBinding().imageContent.setImageBitmap(bitmap);
            this.this$0.getBinding().imageScrollView.setVisibility(0);
        } else {
            this.this$0.showError("Failed to load image");
        }
        return Unit.INSTANCE;
    }
}
