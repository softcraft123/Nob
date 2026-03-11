package com.armmc.app.ui.files;

import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u001a\b\b\u0018\u00002\u00020\u0001BC\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\b\b\u0002\u0010\r\u001a\u00020\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001d\u001a\u00020\tHÆ\u0003J\t\u0010\u001e\u001a\u00020\tHÆ\u0003J\t\u0010\u001f\u001a\u00020\fHÆ\u0003J\t\u0010 \u001a\u00020\u0007HÆ\u0003JO\u0010!\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\"\u001a\u00020\u00072\b\u0010#\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010$\u001a\u00020\fHÖ\u0001J\t\u0010%\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0014R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\n\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\r\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u0014¨\u0006&"}, d2 = {"Lcom/armmc/app/ui/files/FileItem;", "", "name", "", "file", "Ljava/io/File;", "isDirectory", "", "size", "", "lastModified", "childCount", "", "isServer", "<init>", "(Ljava/lang/String;Ljava/io/File;ZJJIZ)V", "getName", "()Ljava/lang/String;", "getFile", "()Ljava/io/File;", "()Z", "getSize", "()J", "getLastModified", "getChildCount", "()I", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "hashCode", "toString", "app_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* compiled from: FileItem.kt */
public final class FileItem {
    private final int childCount;
    private final File file;
    private final boolean isDirectory;
    private final boolean isServer;
    private final long lastModified;
    private final String name;
    private final long size;

    public static /* synthetic */ FileItem copy$default(FileItem fileItem, String str, File file2, boolean z, long j, long j2, int i, boolean z2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = fileItem.name;
        }
        if ((i2 & 2) != 0) {
            file2 = fileItem.file;
        }
        if ((i2 & 4) != 0) {
            z = fileItem.isDirectory;
        }
        if ((i2 & 8) != 0) {
            j = fileItem.size;
        }
        if ((i2 & 16) != 0) {
            j2 = fileItem.lastModified;
        }
        if ((i2 & 32) != 0) {
            i = fileItem.childCount;
        }
        if ((i2 & 64) != 0) {
            z2 = fileItem.isServer;
        }
        long j3 = j2;
        long j4 = j;
        File file3 = file2;
        boolean z3 = z;
        return fileItem.copy(str, file3, z3, j4, j3, i, z2);
    }

    public final String component1() {
        return this.name;
    }

    public final File component2() {
        return this.file;
    }

    public final boolean component3() {
        return this.isDirectory;
    }

    public final long component4() {
        return this.size;
    }

    public final long component5() {
        return this.lastModified;
    }

    public final int component6() {
        return this.childCount;
    }

    public final boolean component7() {
        return this.isServer;
    }

    public final FileItem copy(String str, File file2, boolean z, long j, long j2, int i, boolean z2) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(file2, "file");
        return new FileItem(str, file2, z, j, j2, i, z2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FileItem)) {
            return false;
        }
        FileItem fileItem = (FileItem) obj;
        return Intrinsics.areEqual((Object) this.name, (Object) fileItem.name) && Intrinsics.areEqual((Object) this.file, (Object) fileItem.file) && this.isDirectory == fileItem.isDirectory && this.size == fileItem.size && this.lastModified == fileItem.lastModified && this.childCount == fileItem.childCount && this.isServer == fileItem.isServer;
    }

    public int hashCode() {
        return (((((((((((this.name.hashCode() * 31) + this.file.hashCode()) * 31) + Boolean.hashCode(this.isDirectory)) * 31) + Long.hashCode(this.size)) * 31) + Long.hashCode(this.lastModified)) * 31) + Integer.hashCode(this.childCount)) * 31) + Boolean.hashCode(this.isServer);
    }

    public String toString() {
        String str = this.name;
        File file2 = this.file;
        boolean z = this.isDirectory;
        long j = this.size;
        long j2 = this.lastModified;
        int i = this.childCount;
        return "FileItem(name=" + str + ", file=" + file2 + ", isDirectory=" + z + ", size=" + j + ", lastModified=" + j2 + ", childCount=" + i + ", isServer=" + this.isServer + ")";
    }

    public FileItem(String str, File file2, boolean z, long j, long j2, int i, boolean z2) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(file2, "file");
        this.name = str;
        this.file = file2;
        this.isDirectory = z;
        this.size = j;
        this.lastModified = j2;
        this.childCount = i;
        this.isServer = z2;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ FileItem(java.lang.String r2, java.io.File r3, boolean r4, long r5, long r7, int r9, boolean r10, int r11, kotlin.jvm.internal.DefaultConstructorMarker r12) {
        /*
            r1 = this;
            r12 = r11 & 32
            r0 = 0
            if (r12 == 0) goto L_0x0006
            r9 = r0
        L_0x0006:
            r11 = r11 & 64
            if (r11 == 0) goto L_0x000c
            r11 = r0
            goto L_0x000d
        L_0x000c:
            r11 = r10
        L_0x000d:
            r10 = r9
            r8 = r7
            r6 = r5
            r5 = r4
            r4 = r3
            r3 = r2
            r2 = r1
            r2.<init>(r3, r4, r5, r6, r8, r10, r11)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.armmc.app.ui.files.FileItem.<init>(java.lang.String, java.io.File, boolean, long, long, int, boolean, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final String getName() {
        return this.name;
    }

    public final File getFile() {
        return this.file;
    }

    public final boolean isDirectory() {
        return this.isDirectory;
    }

    public final long getSize() {
        return this.size;
    }

    public final long getLastModified() {
        return this.lastModified;
    }

    public final int getChildCount() {
        return this.childCount;
    }

    public final boolean isServer() {
        return this.isServer;
    }
}
