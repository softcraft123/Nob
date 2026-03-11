package androidx.datastore.core;

import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u001b\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007¢\u0006\u0002\u0010\bJ\u0016\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00028\u0000H@¢\u0006\u0002\u0010\f¨\u0006\r"}, d2 = {"Landroidx/datastore/core/FileWriteScope;", "T", "Landroidx/datastore/core/FileReadScope;", "Landroidx/datastore/core/WriteScope;", "file", "Ljava/io/File;", "serializer", "Landroidx/datastore/core/Serializer;", "(Ljava/io/File;Landroidx/datastore/core/Serializer;)V", "writeData", "", "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "datastore-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: FileStorage.kt */
public final class FileWriteScope<T> extends FileReadScope<T> implements WriteScope<T> {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FileWriteScope(File file, Serializer<T> serializer) {
        super(file, serializer);
        Intrinsics.checkNotNullParameter(file, "file");
        Intrinsics.checkNotNullParameter(serializer, "serializer");
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x003c  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object writeData(T r7, kotlin.coroutines.Continuation<? super kotlin.Unit> r8) {
        /*
            r6 = this;
            boolean r0 = r8 instanceof androidx.datastore.core.FileWriteScope$writeData$1
            if (r0 == 0) goto L_0x0014
            r0 = r8
            androidx.datastore.core.FileWriteScope$writeData$1 r0 = (androidx.datastore.core.FileWriteScope$writeData$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r8 = r0.label
            int r8 = r8 - r2
            r0.label = r8
            goto L_0x0019
        L_0x0014:
            androidx.datastore.core.FileWriteScope$writeData$1 r0 = new androidx.datastore.core.FileWriteScope$writeData$1
            r0.<init>(r6, r8)
        L_0x0019:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x003c
            if (r2 != r3) goto L_0x0034
            java.lang.Object r7 = r0.L$1
            java.io.FileOutputStream r7 = (java.io.FileOutputStream) r7
            java.lang.Object r0 = r0.L$0
            java.io.Closeable r0 = (java.io.Closeable) r0
            kotlin.ResultKt.throwOnFailure(r8)     // Catch:{ all -> 0x0032 }
            goto L_0x006a
        L_0x0032:
            r7 = move-exception
            goto L_0x007c
        L_0x0034:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L_0x003c:
            kotlin.ResultKt.throwOnFailure(r8)
            r6.checkNotClosed()
            java.io.FileOutputStream r8 = new java.io.FileOutputStream
            java.io.File r2 = r6.getFile()
            r8.<init>(r2)
            java.io.Closeable r8 = (java.io.Closeable) r8
            r2 = r8
            java.io.FileOutputStream r2 = (java.io.FileOutputStream) r2     // Catch:{ all -> 0x007a }
            androidx.datastore.core.Serializer r4 = r6.getSerializer()     // Catch:{ all -> 0x007a }
            androidx.datastore.core.UncloseableOutputStream r5 = new androidx.datastore.core.UncloseableOutputStream     // Catch:{ all -> 0x007a }
            r5.<init>(r2)     // Catch:{ all -> 0x007a }
            java.io.OutputStream r5 = (java.io.OutputStream) r5     // Catch:{ all -> 0x007a }
            r0.L$0 = r8     // Catch:{ all -> 0x007a }
            r0.L$1 = r2     // Catch:{ all -> 0x007a }
            r0.label = r3     // Catch:{ all -> 0x007a }
            java.lang.Object r7 = r4.writeTo(r7, r5, r0)     // Catch:{ all -> 0x007a }
            if (r7 != r1) goto L_0x0068
            return r1
        L_0x0068:
            r0 = r8
            r7 = r2
        L_0x006a:
            java.io.FileDescriptor r7 = r7.getFD()     // Catch:{ all -> 0x0032 }
            r7.sync()     // Catch:{ all -> 0x0032 }
            kotlin.Unit r7 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0032 }
            r7 = 0
            kotlin.io.CloseableKt.closeFinally(r0, r7)
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        L_0x007a:
            r7 = move-exception
            r0 = r8
        L_0x007c:
            throw r7     // Catch:{ all -> 0x007d }
        L_0x007d:
            r8 = move-exception
            kotlin.io.CloseableKt.closeFinally(r0, r7)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.FileWriteScope.writeData(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
