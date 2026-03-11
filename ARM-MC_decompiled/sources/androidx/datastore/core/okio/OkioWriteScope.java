package androidx.datastore.core.okio;

import androidx.datastore.core.WriteScope;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okio.FileSystem;
import okio.Path;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B#\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\t¢\u0006\u0002\u0010\nJ\u0016\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00028\u0000H@¢\u0006\u0002\u0010\u000e¨\u0006\u000f"}, d2 = {"Landroidx/datastore/core/okio/OkioWriteScope;", "T", "Landroidx/datastore/core/okio/OkioReadScope;", "Landroidx/datastore/core/WriteScope;", "fileSystem", "Lokio/FileSystem;", "path", "Lokio/Path;", "serializer", "Landroidx/datastore/core/okio/OkioSerializer;", "(Lokio/FileSystem;Lokio/Path;Landroidx/datastore/core/okio/OkioSerializer;)V", "writeData", "", "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "datastore-core-okio"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: OkioStorage.kt */
public final class OkioWriteScope<T> extends OkioReadScope<T> implements WriteScope<T> {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public OkioWriteScope(FileSystem fileSystem, Path path, OkioSerializer<T> okioSerializer) {
        super(fileSystem, path, okioSerializer);
        Intrinsics.checkNotNullParameter(fileSystem, "fileSystem");
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(okioSerializer, "serializer");
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0041  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0084 A[SYNTHETIC, Splitter:B:27:0x0084] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00a2 A[Catch:{ all -> 0x0096, all -> 0x009b }] */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00af A[SYNTHETIC, Splitter:B:48:0x00af] */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00c0  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x00c6  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object writeData(T r10, kotlin.coroutines.Continuation<? super kotlin.Unit> r11) {
        /*
            r9 = this;
            boolean r0 = r11 instanceof androidx.datastore.core.okio.OkioWriteScope$writeData$1
            if (r0 == 0) goto L_0x0014
            r0 = r11
            androidx.datastore.core.okio.OkioWriteScope$writeData$1 r0 = (androidx.datastore.core.okio.OkioWriteScope$writeData$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r11 = r0.label
            int r11 = r11 - r2
            r0.label = r11
            goto L_0x0019
        L_0x0014:
            androidx.datastore.core.okio.OkioWriteScope$writeData$1 r0 = new androidx.datastore.core.okio.OkioWriteScope$writeData$1
            r0.<init>(r9, r11)
        L_0x0019:
            java.lang.Object r11 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L_0x0041
            if (r2 != r3) goto L_0x0039
            java.lang.Object r10 = r0.L$2
            java.io.Closeable r10 = (java.io.Closeable) r10
            java.lang.Object r1 = r0.L$1
            okio.FileHandle r1 = (okio.FileHandle) r1
            java.lang.Object r0 = r0.L$0
            java.io.Closeable r0 = (java.io.Closeable) r0
            kotlin.ResultKt.throwOnFailure(r11)     // Catch:{ all -> 0x0037 }
            goto L_0x007d
        L_0x0037:
            r11 = move-exception
            goto L_0x0090
        L_0x0039:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L_0x0041:
            kotlin.ResultKt.throwOnFailure(r11)
            r9.checkClose()
            okio.FileSystem r11 = r9.getFileSystem()
            okio.Path r2 = r9.getPath()
            okio.FileHandle r11 = r11.openReadWrite(r2)
            java.io.Closeable r11 = (java.io.Closeable) r11
            r2 = r11
            okio.FileHandle r2 = (okio.FileHandle) r2     // Catch:{ all -> 0x00b0 }
            r5 = 0
            okio.Sink r5 = okio.FileHandle.sink$default(r2, r5, r3, r4)     // Catch:{ all -> 0x00b0 }
            okio.BufferedSink r5 = okio.Okio.buffer((okio.Sink) r5)     // Catch:{ all -> 0x00b0 }
            java.io.Closeable r5 = (java.io.Closeable) r5     // Catch:{ all -> 0x00b0 }
            r6 = r5
            okio.BufferedSink r6 = (okio.BufferedSink) r6     // Catch:{ all -> 0x008c }
            androidx.datastore.core.okio.OkioSerializer r7 = r9.getSerializer()     // Catch:{ all -> 0x008c }
            r0.L$0 = r11     // Catch:{ all -> 0x008c }
            r0.L$1 = r2     // Catch:{ all -> 0x008c }
            r0.L$2 = r5     // Catch:{ all -> 0x008c }
            r0.label = r3     // Catch:{ all -> 0x008c }
            java.lang.Object r10 = r7.writeTo(r10, r6, r0)     // Catch:{ all -> 0x008c }
            if (r10 != r1) goto L_0x007a
            return r1
        L_0x007a:
            r0 = r11
            r1 = r2
            r10 = r5
        L_0x007d:
            r1.flush()     // Catch:{ all -> 0x0037 }
            kotlin.Unit r11 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0037 }
            if (r10 == 0) goto L_0x008a
            r10.close()     // Catch:{ all -> 0x0088 }
            goto L_0x008a
        L_0x0088:
            r10 = move-exception
            goto L_0x00a0
        L_0x008a:
            r10 = r4
            goto L_0x00a0
        L_0x008c:
            r10 = move-exception
            r0 = r11
            r11 = r10
            r10 = r5
        L_0x0090:
            if (r10 == 0) goto L_0x009e
            r10.close()     // Catch:{ all -> 0x0096 }
            goto L_0x009e
        L_0x0096:
            r10 = move-exception
            kotlin.ExceptionsKt.addSuppressed(r11, r10)     // Catch:{ all -> 0x009b }
            goto L_0x009e
        L_0x009b:
            r10 = move-exception
            r11 = r0
            goto L_0x00b1
        L_0x009e:
            r10 = r11
            r11 = r4
        L_0x00a0:
            if (r10 != 0) goto L_0x00af
            kotlin.jvm.internal.Intrinsics.checkNotNull(r11)     // Catch:{ all -> 0x009b }
            kotlin.Unit r10 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x009b }
            if (r0 == 0) goto L_0x00be
            r0.close()     // Catch:{ all -> 0x00ad }
            goto L_0x00be
        L_0x00ad:
            r4 = move-exception
            goto L_0x00be
        L_0x00af:
            throw r10     // Catch:{ all -> 0x009b }
        L_0x00b0:
            r10 = move-exception
        L_0x00b1:
            if (r11 == 0) goto L_0x00bb
            r11.close()     // Catch:{ all -> 0x00b7 }
            goto L_0x00bb
        L_0x00b7:
            r11 = move-exception
            kotlin.ExceptionsKt.addSuppressed(r10, r11)
        L_0x00bb:
            r8 = r4
            r4 = r10
            r10 = r8
        L_0x00be:
            if (r4 != 0) goto L_0x00c6
            kotlin.jvm.internal.Intrinsics.checkNotNull(r10)
            kotlin.Unit r10 = kotlin.Unit.INSTANCE
            return r10
        L_0x00c6:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.okio.OkioWriteScope.writeData(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
