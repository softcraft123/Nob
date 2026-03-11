package com.armmc.app.ui.files;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import java.io.File;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Landroid/graphics/Bitmap;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.armmc.app.ui.files.FilePreviewFragment$loadImage$1$bitmap$1", f = "FilePreviewFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: FilePreviewFragment.kt */
final class FilePreviewFragment$loadImage$1$bitmap$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Bitmap>, Object> {
    final /* synthetic */ File $file;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FilePreviewFragment$loadImage$1$bitmap$1(File file, Continuation<? super FilePreviewFragment$loadImage$1$bitmap$1> continuation) {
        super(2, continuation);
        this.$file = file;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new FilePreviewFragment$loadImage$1$bitmap$1(this.$file, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Bitmap> continuation) {
        return ((FilePreviewFragment$loadImage$1$bitmap$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            try {
                BitmapFactory.Options options = new BitmapFactory.Options();
                int i = 1;
                options.inJustDecodeBounds = true;
                BitmapFactory.decodeFile(this.$file.getAbsolutePath(), options);
                int i2 = options.outWidth;
                int i3 = options.outHeight;
                while (true) {
                    if (i2 <= 2048) {
                        if (i3 <= 2048) {
                            String absolutePath = this.$file.getAbsolutePath();
                            BitmapFactory.Options options2 = new BitmapFactory.Options();
                            options2.inSampleSize = i;
                            return BitmapFactory.decodeFile(absolutePath, options2);
                        }
                    }
                    i *= 2;
                    i2 /= 2;
                    i3 /= 2;
                }
            } catch (Exception unused) {
                return null;
            }
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
