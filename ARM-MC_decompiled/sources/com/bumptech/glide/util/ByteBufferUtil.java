package com.bumptech.glide.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicReference;

public final class ByteBufferUtil {
    private static final AtomicReference<byte[]> BUFFER_REF = new AtomicReference<>();
    private static final int BUFFER_SIZE = 16384;

    private ByteBufferUtil() {
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(6:9|10|(2:12|13)|14|15|16) */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:14:0x002e */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x004e A[SYNTHETIC, Splitter:B:30:0x004e] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0053 A[SYNTHETIC, Splitter:B:34:0x0053] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.nio.ByteBuffer fromFile(java.io.File r9) throws java.io.IOException {
        /*
            r1 = 0
            long r6 = r9.length()     // Catch:{ all -> 0x0049 }
            r2 = 2147483647(0x7fffffff, double:1.060997895E-314)
            int r0 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1))
            if (r0 > 0) goto L_0x0041
            r2 = 0
            int r0 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1))
            if (r0 == 0) goto L_0x0039
            java.io.RandomAccessFile r8 = new java.io.RandomAccessFile     // Catch:{ all -> 0x0049 }
            java.lang.String r0 = "r"
            r8.<init>(r9, r0)     // Catch:{ all -> 0x0049 }
            java.nio.channels.FileChannel r2 = r8.getChannel()     // Catch:{ all -> 0x0036 }
            java.nio.channels.FileChannel$MapMode r3 = java.nio.channels.FileChannel.MapMode.READ_ONLY     // Catch:{ all -> 0x0032 }
            r4 = 0
            java.nio.MappedByteBuffer r9 = r2.map(r3, r4, r6)     // Catch:{ all -> 0x0032 }
            java.nio.MappedByteBuffer r9 = r9.load()     // Catch:{ all -> 0x0032 }
            if (r2 == 0) goto L_0x002e
            r2.close()     // Catch:{ IOException -> 0x002e }
        L_0x002e:
            r8.close()     // Catch:{ IOException -> 0x0031 }
        L_0x0031:
            return r9
        L_0x0032:
            r0 = move-exception
            r9 = r0
            r1 = r2
            goto L_0x004c
        L_0x0036:
            r0 = move-exception
            r9 = r0
            goto L_0x004c
        L_0x0039:
            java.io.IOException r9 = new java.io.IOException     // Catch:{ all -> 0x0049 }
            java.lang.String r0 = "File unsuitable for memory mapping"
            r9.<init>(r0)     // Catch:{ all -> 0x0049 }
            throw r9     // Catch:{ all -> 0x0049 }
        L_0x0041:
            java.io.IOException r9 = new java.io.IOException     // Catch:{ all -> 0x0049 }
            java.lang.String r0 = "File too large to map into memory"
            r9.<init>(r0)     // Catch:{ all -> 0x0049 }
            throw r9     // Catch:{ all -> 0x0049 }
        L_0x0049:
            r0 = move-exception
            r9 = r0
            r8 = r1
        L_0x004c:
            if (r1 == 0) goto L_0x0051
            r1.close()     // Catch:{ IOException -> 0x0051 }
        L_0x0051:
            if (r8 == 0) goto L_0x0056
            r8.close()     // Catch:{ IOException -> 0x0056 }
        L_0x0056:
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.util.ByteBufferUtil.fromFile(java.io.File):java.nio.ByteBuffer");
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(9:0|1|2|3|4|(2:6|7)|8|9|23) */
    /* JADX WARNING: Code restructure failed: missing block: B:24:?, code lost:
        return;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:8:0x0021 */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x002b A[SYNTHETIC, Splitter:B:15:0x002b] */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0030 A[SYNTHETIC, Splitter:B:19:0x0030] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void toFile(java.nio.ByteBuffer r3, java.io.File r4) throws java.io.IOException {
        /*
            rewind(r3)
            r0 = 0
            java.io.RandomAccessFile r1 = new java.io.RandomAccessFile     // Catch:{ all -> 0x0027 }
            java.lang.String r2 = "rw"
            r1.<init>(r4, r2)     // Catch:{ all -> 0x0027 }
            java.nio.channels.FileChannel r0 = r1.getChannel()     // Catch:{ all -> 0x0025 }
            r0.write(r3)     // Catch:{ all -> 0x0025 }
            r3 = 0
            r0.force(r3)     // Catch:{ all -> 0x0025 }
            r0.close()     // Catch:{ all -> 0x0025 }
            r1.close()     // Catch:{ all -> 0x0025 }
            if (r0 == 0) goto L_0x0021
            r0.close()     // Catch:{ IOException -> 0x0021 }
        L_0x0021:
            r1.close()     // Catch:{ IOException -> 0x0024 }
        L_0x0024:
            return
        L_0x0025:
            r3 = move-exception
            goto L_0x0029
        L_0x0027:
            r3 = move-exception
            r1 = r0
        L_0x0029:
            if (r0 == 0) goto L_0x002e
            r0.close()     // Catch:{ IOException -> 0x002e }
        L_0x002e:
            if (r1 == 0) goto L_0x0033
            r1.close()     // Catch:{ IOException -> 0x0033 }
        L_0x0033:
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.util.ByteBufferUtil.toFile(java.nio.ByteBuffer, java.io.File):void");
    }

    public static void toStream(ByteBuffer byteBuffer, OutputStream outputStream) throws IOException {
        SafeArray safeArray = getSafeArray(byteBuffer);
        if (safeArray != null) {
            outputStream.write(safeArray.data, safeArray.offset, safeArray.offset + safeArray.limit);
            return;
        }
        byte[] andSet = BUFFER_REF.getAndSet((Object) null);
        if (andSet == null) {
            andSet = new byte[16384];
        }
        while (byteBuffer.remaining() > 0) {
            int min = Math.min(byteBuffer.remaining(), andSet.length);
            byteBuffer.get(andSet, 0, min);
            outputStream.write(andSet, 0, min);
        }
        BUFFER_REF.set(andSet);
    }

    public static byte[] toBytes(ByteBuffer byteBuffer) {
        SafeArray safeArray = getSafeArray(byteBuffer);
        if (safeArray != null && safeArray.offset == 0 && safeArray.limit == safeArray.data.length) {
            return byteBuffer.array();
        }
        ByteBuffer asReadOnlyBuffer = byteBuffer.asReadOnlyBuffer();
        byte[] bArr = new byte[asReadOnlyBuffer.limit()];
        rewind(asReadOnlyBuffer);
        asReadOnlyBuffer.get(bArr);
        return bArr;
    }

    public static InputStream toStream(ByteBuffer byteBuffer) {
        return new ByteBufferStream(byteBuffer);
    }

    public static ByteBuffer fromStream(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(16384);
        byte[] andSet = BUFFER_REF.getAndSet((Object) null);
        if (andSet == null) {
            andSet = new byte[16384];
        }
        while (true) {
            int read = inputStream.read(andSet);
            if (read >= 0) {
                byteArrayOutputStream.write(andSet, 0, read);
            } else {
                BUFFER_REF.set(andSet);
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                return rewind(ByteBuffer.allocateDirect(byteArray.length).put(byteArray));
            }
        }
    }

    public static ByteBuffer rewind(ByteBuffer byteBuffer) {
        return (ByteBuffer) byteBuffer.position(0);
    }

    private static SafeArray getSafeArray(ByteBuffer byteBuffer) {
        if (byteBuffer.isReadOnly() || !byteBuffer.hasArray()) {
            return null;
        }
        return new SafeArray(byteBuffer.array(), byteBuffer.arrayOffset(), byteBuffer.limit());
    }

    static final class SafeArray {
        final byte[] data;
        final int limit;
        final int offset;

        SafeArray(byte[] bArr, int i, int i2) {
            this.data = bArr;
            this.offset = i;
            this.limit = i2;
        }
    }

    private static class ByteBufferStream extends InputStream {
        private static final int UNSET = -1;
        private final ByteBuffer byteBuffer;
        private int markPos = -1;

        public boolean markSupported() {
            return true;
        }

        ByteBufferStream(ByteBuffer byteBuffer2) {
            this.byteBuffer = byteBuffer2;
        }

        public int available() {
            return this.byteBuffer.remaining();
        }

        public int read() {
            if (!this.byteBuffer.hasRemaining()) {
                return -1;
            }
            return this.byteBuffer.get() & 255;
        }

        public synchronized void mark(int i) {
            this.markPos = this.byteBuffer.position();
        }

        public int read(byte[] bArr, int i, int i2) {
            if (!this.byteBuffer.hasRemaining()) {
                return -1;
            }
            int min = Math.min(i2, available());
            this.byteBuffer.get(bArr, i, min);
            return min;
        }

        public synchronized void reset() throws IOException {
            int i = this.markPos;
            if (i != -1) {
                this.byteBuffer.position(i);
            } else {
                throw new IOException("Cannot reset to unset mark position");
            }
        }

        public long skip(long j) {
            if (!this.byteBuffer.hasRemaining()) {
                return -1;
            }
            long min = Math.min(j, (long) available());
            ByteBuffer byteBuffer2 = this.byteBuffer;
            byteBuffer2.position((int) (((long) byteBuffer2.position()) + min));
            return min;
        }
    }
}
