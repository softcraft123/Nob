package com.armmc.app.ui.files;

import com.armmc.app.ui.servers.ServerData;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.armmc.app.ui.files.FilesViewModel$loadRoot$1", f = "FilesViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: FilesViewModel.kt */
final class FilesViewModel$loadRoot$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ FilesViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FilesViewModel$loadRoot$1(FilesViewModel filesViewModel, Continuation<? super FilesViewModel$loadRoot$1> continuation) {
        super(2, continuation);
        this.this$0 = filesViewModel;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new FilesViewModel$loadRoot$1(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((FilesViewModel$loadRoot$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        File[] listFiles;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            List<ServerData> allServers = this.this$0.serverRepository.getAllServers();
            File filesDir = this.this$0.getApplication().getFilesDir();
            Iterable<ServerData> iterable = allServers;
            Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
            for (ServerData serverData : iterable) {
                File file = new File(filesDir, "server_" + serverData.getId());
                String name = serverData.getName();
                long lastModified = file.exists() ? file.lastModified() : System.currentTimeMillis();
                int i = 0;
                if (file.exists() && (listFiles = file.listFiles()) != null) {
                    i = listFiles.length;
                }
                arrayList.add(new FileItem(name, file, true, 0, lastModified, i, true));
            }
            this.this$0._allItems.setValue((List) arrayList);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
