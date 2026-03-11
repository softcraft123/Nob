package com.armmc.app.ui.files;

import java.io.File;
import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.armmc.app.ui.files.FilePreviewFragment$loadText$1$text$1", f = "FilePreviewFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: FilePreviewFragment.kt */
final class FilePreviewFragment$loadText$1$text$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super String>, Object> {
    final /* synthetic */ String $ext;
    final /* synthetic */ File $file;
    int label;
    final /* synthetic */ FilePreviewFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FilePreviewFragment$loadText$1$text$1(File file, String str, FilePreviewFragment filePreviewFragment, Continuation<? super FilePreviewFragment$loadText$1$text$1> continuation) {
        super(2, continuation);
        this.$file = file;
        this.$ext = str;
        this.this$0 = filePreviewFragment;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new FilePreviewFragment$loadText$1$text$1(this.$file, this.$ext, this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super String> continuation) {
        return ((FilePreviewFragment$loadText$1$text$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            try {
                if (this.$file.length() > 524288) {
                    return "File too large to preview (" + (this.$file.length() / ((long) 1024)) + " KB)\n\nMaximum preview size is 512 KB.";
                }
                String readText$default = FilesKt.readText$default(this.$file, (Charset) null, 1, (Object) null);
                return Intrinsics.areEqual((Object) this.$ext, (Object) "json") ? this.this$0.prettyPrintJson(readText$default) : readText$default;
            } catch (Exception e) {
                return "Error reading file: " + e.getMessage();
            }
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
