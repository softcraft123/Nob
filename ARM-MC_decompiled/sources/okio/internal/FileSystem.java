package okio.internal;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.ArrayDeque;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import okio.FileMetadata;
import okio.Path;

@Metadata(d1 = {"\u00004\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aI\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00072\u0006\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH@ø\u0001\u0000¢\u0006\u0002\u0010\f\u001a\u001c\u0010\r\u001a\u00020\u0001*\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0003H\u0000\u001a\u001c\u0010\u0010\u001a\u00020\u0001*\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\nH\u0000\u001a\u001c\u0010\u0013\u001a\u00020\u0001*\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\nH\u0000\u001a\u0014\u0010\u0016\u001a\u00020\n*\u00020\u00052\u0006\u0010\b\u001a\u00020\u0003H\u0000\u001a\"\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00030\u0018*\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH\u0000\u001a\u0014\u0010\u0019\u001a\u00020\u001a*\u00020\u00052\u0006\u0010\b\u001a\u00020\u0003H\u0000\u001a\u0016\u0010\u001b\u001a\u0004\u0018\u00010\u0003*\u00020\u00052\u0006\u0010\b\u001a\u00020\u0003H\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u001c"}, d2 = {"collectRecursively", "", "Lkotlin/sequences/SequenceScope;", "Lokio/Path;", "fileSystem", "Lokio/FileSystem;", "stack", "Lkotlin/collections/ArrayDeque;", "path", "followSymlinks", "", "postorder", "(Lkotlin/sequences/SequenceScope;Lokio/FileSystem;Lkotlin/collections/ArrayDeque;Lokio/Path;ZZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "commonCopy", "source", "target", "commonCreateDirectories", "dir", "mustCreate", "commonDeleteRecursively", "fileOrDirectory", "mustExist", "commonExists", "commonListRecursively", "Lkotlin/sequences/Sequence;", "commonMetadata", "Lokio/FileMetadata;", "symlinkTarget", "okio"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* renamed from: okio.internal.-FileSystem  reason: invalid class name */
/* compiled from: FileSystem.kt */
public final class FileSystem {
    public static final FileMetadata commonMetadata(okio.FileSystem fileSystem, Path path) throws IOException {
        Intrinsics.checkNotNullParameter(fileSystem, "<this>");
        Intrinsics.checkNotNullParameter(path, "path");
        FileMetadata metadataOrNull = fileSystem.metadataOrNull(path);
        if (metadataOrNull != null) {
            return metadataOrNull;
        }
        throw new FileNotFoundException("no such file: " + path);
    }

    public static final boolean commonExists(okio.FileSystem fileSystem, Path path) throws IOException {
        Intrinsics.checkNotNullParameter(fileSystem, "<this>");
        Intrinsics.checkNotNullParameter(path, "path");
        return fileSystem.metadataOrNull(path) != null;
    }

    public static final void commonCreateDirectories(okio.FileSystem fileSystem, Path path, boolean z) throws IOException {
        Intrinsics.checkNotNullParameter(fileSystem, "<this>");
        Intrinsics.checkNotNullParameter(path, "dir");
        ArrayDeque arrayDeque = new ArrayDeque();
        Path path2 = path;
        while (path2 != null && !fileSystem.exists(path2)) {
            arrayDeque.addFirst(path2);
            path2 = path2.parent();
        }
        if (!z || !arrayDeque.isEmpty()) {
            Iterator it = arrayDeque.iterator();
            while (it.hasNext()) {
                fileSystem.createDirectory((Path) it.next());
            }
            return;
        }
        throw new IOException(path + " already exist.");
    }

    public static final void commonDeleteRecursively(okio.FileSystem fileSystem, Path path, boolean z) throws IOException {
        Intrinsics.checkNotNullParameter(fileSystem, "<this>");
        Intrinsics.checkNotNullParameter(path, "fileOrDirectory");
        Iterator it = SequencesKt.sequence(new FileSystem$commonDeleteRecursively$sequence$1(fileSystem, path, (Continuation<? super FileSystem$commonDeleteRecursively$sequence$1>) null)).iterator();
        while (it.hasNext()) {
            fileSystem.delete((Path) it.next(), z && !it.hasNext());
        }
    }

    public static final Sequence<Path> commonListRecursively(okio.FileSystem fileSystem, Path path, boolean z) throws IOException {
        Intrinsics.checkNotNullParameter(fileSystem, "<this>");
        Intrinsics.checkNotNullParameter(path, "dir");
        return SequencesKt.sequence(new FileSystem$commonListRecursively$1(path, fileSystem, z, (Continuation<? super FileSystem$commonListRecursively$1>) null));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x009e, code lost:
        if (r15.yield(r1, r4) == r5) goto L_0x015d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00e3, code lost:
        if (r0 != false) goto L_0x00e7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00e5, code lost:
        if (r7 != 0) goto L_0x0148;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00e7, code lost:
        r6.addLast(r12);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:?, code lost:
        r14 = r3.iterator();
        r3 = r1;
        r1 = r2;
        r2 = r14;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x013d, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x013e, code lost:
        r7 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x015b, code lost:
        if (r11.yield(r1, r4) == r5) goto L_0x015d;
     */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0081  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00b1  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00be  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00f8 A[Catch:{ all -> 0x013d }] */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x014a  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x0161  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object collectRecursively(kotlin.sequences.SequenceScope<? super okio.Path> r15, okio.FileSystem r16, kotlin.collections.ArrayDeque<okio.Path> r17, okio.Path r18, boolean r19, boolean r20, kotlin.coroutines.Continuation<? super kotlin.Unit> r21) {
        /*
            r1 = r18
            r2 = r20
            r3 = r21
            boolean r4 = r3 instanceof okio.internal.FileSystem$collectRecursively$1
            if (r4 == 0) goto L_0x001a
            r4 = r3
            okio.internal.-FileSystem$collectRecursively$1 r4 = (okio.internal.FileSystem$collectRecursively$1) r4
            int r5 = r4.label
            r6 = -2147483648(0xffffffff80000000, float:-0.0)
            r5 = r5 & r6
            if (r5 == 0) goto L_0x001a
            int r3 = r4.label
            int r3 = r3 - r6
            r4.label = r3
            goto L_0x001f
        L_0x001a:
            okio.internal.-FileSystem$collectRecursively$1 r4 = new okio.internal.-FileSystem$collectRecursively$1
            r4.<init>(r3)
        L_0x001f:
            java.lang.Object r3 = r4.result
            java.lang.Object r5 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r6 = r4.label
            r7 = 0
            r8 = 3
            r9 = 2
            r10 = 1
            if (r6 == 0) goto L_0x0081
            if (r6 == r10) goto L_0x0065
            if (r6 == r9) goto L_0x0040
            if (r6 != r8) goto L_0x0038
            kotlin.ResultKt.throwOnFailure(r3)
            goto L_0x015e
        L_0x0038:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x0040:
            boolean r0 = r4.Z$1
            boolean r1 = r4.Z$0
            java.lang.Object r2 = r4.L$4
            java.util.Iterator r2 = (java.util.Iterator) r2
            java.lang.Object r6 = r4.L$3
            okio.Path r6 = (okio.Path) r6
            java.lang.Object r7 = r4.L$2
            kotlin.collections.ArrayDeque r7 = (kotlin.collections.ArrayDeque) r7
            java.lang.Object r10 = r4.L$1
            okio.FileSystem r10 = (okio.FileSystem) r10
            java.lang.Object r11 = r4.L$0
            kotlin.sequences.SequenceScope r11 = (kotlin.sequences.SequenceScope) r11
            kotlin.ResultKt.throwOnFailure(r3)     // Catch:{ all -> 0x0062 }
            r3 = r1
            r1 = r0
            r0 = r3
            r3 = r6
        L_0x005f:
            r6 = r7
            goto L_0x00f2
        L_0x0062:
            r0 = move-exception
            goto L_0x013f
        L_0x0065:
            boolean r0 = r4.Z$1
            boolean r1 = r4.Z$0
            java.lang.Object r2 = r4.L$3
            okio.Path r2 = (okio.Path) r2
            java.lang.Object r6 = r4.L$2
            kotlin.collections.ArrayDeque r6 = (kotlin.collections.ArrayDeque) r6
            java.lang.Object r10 = r4.L$1
            okio.FileSystem r10 = (okio.FileSystem) r10
            java.lang.Object r11 = r4.L$0
            kotlin.sequences.SequenceScope r11 = (kotlin.sequences.SequenceScope) r11
            kotlin.ResultKt.throwOnFailure(r3)
            r14 = r2
            r2 = r0
            r0 = r1
            r1 = r14
            goto L_0x00ab
        L_0x0081:
            kotlin.ResultKt.throwOnFailure(r3)
            if (r2 != 0) goto L_0x00a2
            r4.L$0 = r15
            r3 = r16
            r4.L$1 = r3
            r6 = r17
            r4.L$2 = r6
            r4.L$3 = r1
            r11 = r19
            r4.Z$0 = r11
            r4.Z$1 = r2
            r4.label = r10
            java.lang.Object r10 = r15.yield(r1, r4)
            if (r10 != r5) goto L_0x00a8
            goto L_0x015d
        L_0x00a2:
            r3 = r16
            r6 = r17
            r11 = r19
        L_0x00a8:
            r10 = r3
            r0 = r11
            r11 = r15
        L_0x00ab:
            java.util.List r3 = r10.listOrNull(r1)
            if (r3 != 0) goto L_0x00b5
            java.util.List r3 = kotlin.collections.CollectionsKt.emptyList()
        L_0x00b5:
            r12 = r3
            java.util.Collection r12 = (java.util.Collection) r12
            boolean r12 = r12.isEmpty()
            if (r12 != 0) goto L_0x0148
            r12 = r1
        L_0x00bf:
            if (r0 == 0) goto L_0x00dd
            boolean r13 = r6.contains(r12)
            if (r13 != 0) goto L_0x00c8
            goto L_0x00dd
        L_0x00c8:
            java.io.IOException r0 = new java.io.IOException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "symlink cycle at "
            r2.<init>(r3)
            java.lang.StringBuilder r1 = r2.append(r1)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x00dd:
            okio.Path r13 = symlinkTarget(r10, r12)
            if (r13 != 0) goto L_0x0143
            if (r0 != 0) goto L_0x00e7
            if (r7 != 0) goto L_0x0148
        L_0x00e7:
            r6.addLast(r12)
            java.util.Iterator r3 = r3.iterator()     // Catch:{ all -> 0x013d }
            r14 = r3
            r3 = r1
            r1 = r2
            r2 = r14
        L_0x00f2:
            boolean r7 = r2.hasNext()     // Catch:{ all -> 0x013d }
            if (r7 == 0) goto L_0x0135
            java.lang.Object r7 = r2.next()     // Catch:{ all -> 0x013d }
            okio.Path r7 = (okio.Path) r7     // Catch:{ all -> 0x013d }
            r4.L$0 = r11     // Catch:{ all -> 0x013d }
            r4.L$1 = r10     // Catch:{ all -> 0x013d }
            r4.L$2 = r6     // Catch:{ all -> 0x013d }
            r4.L$3 = r3     // Catch:{ all -> 0x013d }
            r4.L$4 = r2     // Catch:{ all -> 0x013d }
            r4.Z$0 = r0     // Catch:{ all -> 0x013d }
            r4.Z$1 = r1     // Catch:{ all -> 0x013d }
            r4.label = r9     // Catch:{ all -> 0x013d }
            r19 = r0
            r20 = r1
            r21 = r4
            r17 = r6
            r18 = r7
            r16 = r10
            r15 = r11
            java.lang.Object r0 = collectRecursively(r15, r16, r17, r18, r19, r20, r21)     // Catch:{ all -> 0x0131 }
            r11 = r15
            r10 = r16
            r7 = r17
            r4 = r19
            r1 = r20
            r6 = r21
            if (r0 != r5) goto L_0x012d
            goto L_0x015d
        L_0x012d:
            r0 = r4
            r4 = r6
            goto L_0x005f
        L_0x0131:
            r0 = move-exception
            r7 = r17
            goto L_0x013f
        L_0x0135:
            r7 = r6
            r6 = r4
            r7.removeLast()
            r2 = r1
            r1 = r3
            goto L_0x0148
        L_0x013d:
            r0 = move-exception
            r7 = r6
        L_0x013f:
            r7.removeLast()
            throw r0
        L_0x0143:
            int r7 = r7 + 1
            r12 = r13
            goto L_0x00bf
        L_0x0148:
            if (r2 == 0) goto L_0x0161
            r0 = 0
            r4.L$0 = r0
            r4.L$1 = r0
            r4.L$2 = r0
            r4.L$3 = r0
            r4.L$4 = r0
            r4.label = r8
            java.lang.Object r0 = r11.yield(r1, r4)
            if (r0 != r5) goto L_0x015e
        L_0x015d:
            return r5
        L_0x015e:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        L_0x0161:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.internal.FileSystem.collectRecursively(kotlin.sequences.SequenceScope, okio.FileSystem, kotlin.collections.ArrayDeque, okio.Path, boolean, boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static final Path symlinkTarget(okio.FileSystem fileSystem, Path path) throws IOException {
        Intrinsics.checkNotNullParameter(fileSystem, "<this>");
        Intrinsics.checkNotNullParameter(path, "path");
        Path symlinkTarget = fileSystem.metadata(path).getSymlinkTarget();
        if (symlinkTarget == null) {
            return null;
        }
        Path parent = path.parent();
        Intrinsics.checkNotNull(parent);
        return parent.resolve(symlinkTarget);
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0047 A[Catch:{ all -> 0x0038, all -> 0x003f, all -> 0x005d }] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x005c A[SYNTHETIC, Splitter:B:25:0x005c] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void commonCopy(okio.FileSystem r4, okio.Path r5, okio.Path r6) throws java.io.IOException {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            java.lang.String r0 = "source"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            java.lang.String r0 = "target"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            okio.Source r5 = r4.source(r5)
            java.io.Closeable r5 = (java.io.Closeable) r5
            r0 = 0
            r1 = r5
            okio.Source r1 = (okio.Source) r1     // Catch:{ all -> 0x005d }
            okio.Sink r4 = r4.sink(r6)     // Catch:{ all -> 0x005d }
            okio.BufferedSink r4 = okio.Okio.buffer((okio.Sink) r4)     // Catch:{ all -> 0x005d }
            java.io.Closeable r4 = (java.io.Closeable) r4     // Catch:{ all -> 0x005d }
            r6 = r4
            okio.BufferedSink r6 = (okio.BufferedSink) r6     // Catch:{ all -> 0x0038 }
            long r1 = r6.writeAll(r1)     // Catch:{ all -> 0x0038 }
            java.lang.Long r6 = java.lang.Long.valueOf(r1)     // Catch:{ all -> 0x0038 }
            if (r4 == 0) goto L_0x0036
            r4.close()     // Catch:{ all -> 0x0034 }
            goto L_0x0036
        L_0x0034:
            r4 = move-exception
            goto L_0x0045
        L_0x0036:
            r4 = r0
            goto L_0x0045
        L_0x0038:
            r6 = move-exception
            if (r4 == 0) goto L_0x0043
            r4.close()     // Catch:{ all -> 0x003f }
            goto L_0x0043
        L_0x003f:
            r4 = move-exception
            kotlin.ExceptionsKt.addSuppressed(r6, r4)     // Catch:{ all -> 0x005d }
        L_0x0043:
            r4 = r6
            r6 = r0
        L_0x0045:
            if (r4 != 0) goto L_0x005c
            kotlin.jvm.internal.Intrinsics.checkNotNull(r6)     // Catch:{ all -> 0x005d }
            java.lang.Number r6 = (java.lang.Number) r6     // Catch:{ all -> 0x005d }
            long r1 = r6.longValue()     // Catch:{ all -> 0x005d }
            java.lang.Long r4 = java.lang.Long.valueOf(r1)     // Catch:{ all -> 0x005d }
            if (r5 == 0) goto L_0x006b
            r5.close()     // Catch:{ all -> 0x005a }
            goto L_0x006b
        L_0x005a:
            r0 = move-exception
            goto L_0x006b
        L_0x005c:
            throw r4     // Catch:{ all -> 0x005d }
        L_0x005d:
            r4 = move-exception
            if (r5 == 0) goto L_0x0068
            r5.close()     // Catch:{ all -> 0x0064 }
            goto L_0x0068
        L_0x0064:
            r5 = move-exception
            kotlin.ExceptionsKt.addSuppressed(r4, r5)
        L_0x0068:
            r3 = r0
            r0 = r4
            r4 = r3
        L_0x006b:
            if (r0 != 0) goto L_0x0071
            kotlin.jvm.internal.Intrinsics.checkNotNull(r4)
            return
        L_0x0071:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.internal.FileSystem.commonCopy(okio.FileSystem, okio.Path, okio.Path):void");
    }
}
