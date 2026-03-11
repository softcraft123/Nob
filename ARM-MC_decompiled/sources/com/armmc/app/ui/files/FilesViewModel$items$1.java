package com.armmc.app.ui.files;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0005H\n"}, d2 = {"<anonymous>", "", "Lcom/armmc/app/ui/files/FileItem;", "all", "query", ""}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.armmc.app.ui.files.FilesViewModel$items$1", f = "FilesViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: FilesViewModel.kt */
final class FilesViewModel$items$1 extends SuspendLambda implements Function3<List<? extends FileItem>, String, Continuation<? super List<? extends FileItem>>, Object> {
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;

    FilesViewModel$items$1(Continuation<? super FilesViewModel$items$1> continuation) {
        super(3, continuation);
    }

    public final Object invoke(List<FileItem> list, String str, Continuation<? super List<FileItem>> continuation) {
        FilesViewModel$items$1 filesViewModel$items$1 = new FilesViewModel$items$1(continuation);
        filesViewModel$items$1.L$0 = list;
        filesViewModel$items$1.L$1 = str;
        return filesViewModel$items$1.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            List list = (List) this.L$0;
            CharSequence charSequence = (String) this.L$1;
            if (StringsKt.isBlank(charSequence)) {
                return list;
            }
            Collection arrayList = new ArrayList();
            for (Object next : list) {
                if (StringsKt.contains((CharSequence) ((FileItem) next).getName(), charSequence, true)) {
                    arrayList.add(next);
                }
            }
            return (List) arrayList;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
