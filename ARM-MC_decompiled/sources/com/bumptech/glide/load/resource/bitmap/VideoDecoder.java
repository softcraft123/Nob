package com.bumptech.glide.load.resource.bitmap;

import android.content.res.AssetFileDescriptor;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.media.MediaDataSource;
import android.media.MediaExtractor;
import android.media.MediaMetadataRetriever;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import com.bumptech.glide.load.Option;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class VideoDecoder<T> implements ResourceDecoder<T, Bitmap> {
    private static final MediaMetadataRetrieverFactory DEFAULT_FACTORY = new MediaMetadataRetrieverFactory();
    public static final long DEFAULT_FRAME = -1;
    static final int DEFAULT_FRAME_OPTION = 2;
    public static final Option<Integer> FRAME_OPTION = Option.disk("com.bumptech.glide.load.resource.bitmap.VideoBitmapDecode.FrameOption", 2, new Option.CacheKeyUpdater<Integer>() {
        private final ByteBuffer buffer = ByteBuffer.allocate(4);

        public void update(byte[] bArr, Integer num, MessageDigest messageDigest) {
            if (num != null) {
                messageDigest.update(bArr);
                synchronized (this.buffer) {
                    this.buffer.position(0);
                    messageDigest.update(this.buffer.putInt(num.intValue()).array());
                }
            }
        }
    });
    private static final List<String> PIXEL_T_BUILD_ID_PREFIXES_REQUIRING_HDR_180_ROTATION_FIX = Collections.unmodifiableList(Arrays.asList(new String[]{"TP1A", "TD1A.220804.031"}));
    private static final String TAG = "VideoDecoder";
    public static final Option<Long> TARGET_FRAME = Option.disk("com.bumptech.glide.load.resource.bitmap.VideoBitmapDecode.TargetFrame", -1L, new Option.CacheKeyUpdater<Long>() {
        private final ByteBuffer buffer = ByteBuffer.allocate(8);

        public void update(byte[] bArr, Long l, MessageDigest messageDigest) {
            messageDigest.update(bArr);
            synchronized (this.buffer) {
                this.buffer.position(0);
                messageDigest.update(this.buffer.putLong(l.longValue()).array());
            }
        }
    });
    private static final String WEBM_MIME_TYPE = "video/webm";
    private final BitmapPool bitmapPool;
    private final MediaMetadataRetrieverFactory factory;
    private final MediaInitializer<T> initializer;

    interface MediaInitializer<T> {
        void initializeExtractor(MediaExtractor mediaExtractor, T t) throws IOException;

        void initializeRetriever(MediaMetadataRetriever mediaMetadataRetriever, T t);
    }

    public boolean handles(T t, Options options) {
        return true;
    }

    public static ResourceDecoder<AssetFileDescriptor, Bitmap> asset(BitmapPool bitmapPool2) {
        return new VideoDecoder(bitmapPool2, new AssetFileDescriptorInitializer());
    }

    public static ResourceDecoder<ParcelFileDescriptor, Bitmap> parcel(BitmapPool bitmapPool2) {
        return new VideoDecoder(bitmapPool2, new ParcelFileDescriptorInitializer());
    }

    public static ResourceDecoder<ByteBuffer, Bitmap> byteBuffer(BitmapPool bitmapPool2) {
        return new VideoDecoder(bitmapPool2, new ByteBufferInitializer());
    }

    VideoDecoder(BitmapPool bitmapPool2, MediaInitializer<T> mediaInitializer) {
        this(bitmapPool2, mediaInitializer, DEFAULT_FACTORY);
    }

    VideoDecoder(BitmapPool bitmapPool2, MediaInitializer<T> mediaInitializer, MediaMetadataRetrieverFactory mediaMetadataRetrieverFactory) {
        this.bitmapPool = bitmapPool2;
        this.initializer = mediaInitializer;
        this.factory = mediaMetadataRetrieverFactory;
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x007e  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0082  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.bumptech.glide.load.engine.Resource<android.graphics.Bitmap> decode(T r11, int r12, int r13, com.bumptech.glide.load.Options r14) throws java.io.IOException {
        /*
            r10 = this;
            com.bumptech.glide.load.Option<java.lang.Long> r0 = TARGET_FRAME
            java.lang.Object r0 = r14.get(r0)
            java.lang.Long r0 = (java.lang.Long) r0
            long r4 = r0.longValue()
            r0 = 0
            int r0 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1))
            if (r0 >= 0) goto L_0x002e
            r0 = -1
            int r0 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1))
            if (r0 != 0) goto L_0x0019
            goto L_0x002e
        L_0x0019:
            java.lang.IllegalArgumentException r11 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            java.lang.String r13 = "Requested frame must be non-negative, or DEFAULT_FRAME, given: "
            r12.<init>(r13)
            java.lang.StringBuilder r12 = r12.append(r4)
            java.lang.String r12 = r12.toString()
            r11.<init>(r12)
            throw r11
        L_0x002e:
            com.bumptech.glide.load.Option<java.lang.Integer> r0 = FRAME_OPTION
            java.lang.Object r0 = r14.get(r0)
            java.lang.Integer r0 = (java.lang.Integer) r0
            if (r0 != 0) goto L_0x003d
            r0 = 2
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
        L_0x003d:
            com.bumptech.glide.load.Option<com.bumptech.glide.load.resource.bitmap.DownsampleStrategy> r1 = com.bumptech.glide.load.resource.bitmap.DownsampleStrategy.OPTION
            java.lang.Object r14 = r14.get(r1)
            com.bumptech.glide.load.resource.bitmap.DownsampleStrategy r14 = (com.bumptech.glide.load.resource.bitmap.DownsampleStrategy) r14
            if (r14 != 0) goto L_0x0049
            com.bumptech.glide.load.resource.bitmap.DownsampleStrategy r14 = com.bumptech.glide.load.resource.bitmap.DownsampleStrategy.DEFAULT
        L_0x0049:
            r9 = r14
            com.bumptech.glide.load.resource.bitmap.VideoDecoder$MediaMetadataRetrieverFactory r14 = r10.factory
            android.media.MediaMetadataRetriever r3 = r14.build()
            r14 = 29
            com.bumptech.glide.load.resource.bitmap.VideoDecoder$MediaInitializer<T> r1 = r10.initializer     // Catch:{ all -> 0x0077 }
            r1.initializeRetriever(r3, r11)     // Catch:{ all -> 0x0077 }
            int r6 = r0.intValue()     // Catch:{ all -> 0x0077 }
            r1 = r10
            r2 = r11
            r7 = r12
            r8 = r13
            android.graphics.Bitmap r11 = r1.decodeFrame(r2, r3, r4, r6, r7, r8, r9)     // Catch:{ all -> 0x0075 }
            int r12 = android.os.Build.VERSION.SDK_INT
            if (r12 < r14) goto L_0x006b
            r3.release()
            goto L_0x006e
        L_0x006b:
            r3.release()
        L_0x006e:
            com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool r12 = r1.bitmapPool
            com.bumptech.glide.load.resource.bitmap.BitmapResource r11 = com.bumptech.glide.load.resource.bitmap.BitmapResource.obtain(r11, r12)
            return r11
        L_0x0075:
            r0 = move-exception
            goto L_0x0079
        L_0x0077:
            r0 = move-exception
            r1 = r10
        L_0x0079:
            r11 = r0
            int r12 = android.os.Build.VERSION.SDK_INT
            if (r12 < r14) goto L_0x0082
            r3.release()
            goto L_0x0085
        L_0x0082:
            r3.release()
        L_0x0085:
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.resource.bitmap.VideoDecoder.decode(java.lang.Object, int, int, com.bumptech.glide.load.Options):com.bumptech.glide.load.engine.Resource");
    }

    private Bitmap decodeFrame(T t, MediaMetadataRetriever mediaMetadataRetriever, long j, int i, int i2, int i3, DownsampleStrategy downsampleStrategy) {
        if (!isUnsupportedFormat(t, mediaMetadataRetriever)) {
            Bitmap decodeScaledFrame = (Build.VERSION.SDK_INT < 27 || i2 == Integer.MIN_VALUE || i3 == Integer.MIN_VALUE || downsampleStrategy == DownsampleStrategy.NONE) ? null : decodeScaledFrame(mediaMetadataRetriever, j, i, i2, i3, downsampleStrategy);
            if (decodeScaledFrame == null) {
                decodeScaledFrame = decodeOriginalFrame(mediaMetadataRetriever, j, i);
            }
            Bitmap correctHdr180DegVideoFrameOrientation = correctHdr180DegVideoFrameOrientation(mediaMetadataRetriever, decodeScaledFrame);
            if (correctHdr180DegVideoFrameOrientation != null) {
                return correctHdr180DegVideoFrameOrientation;
            }
            throw new VideoDecoderException();
        }
        throw new IllegalStateException("Cannot decode VP8 video on CrOS.");
    }

    private static Bitmap correctHdr180DegVideoFrameOrientation(MediaMetadataRetriever mediaMetadataRetriever, Bitmap bitmap) {
        if (isHdr180RotationFixRequired()) {
            try {
                if (isHDR(mediaMetadataRetriever)) {
                    if (Math.abs(Integer.parseInt(mediaMetadataRetriever.extractMetadata(24))) != 180) {
                        return bitmap;
                    }
                    if (Log.isLoggable(TAG, 3)) {
                        Log.d(TAG, "Applying HDR 180 deg thumbnail correction");
                    }
                    Matrix matrix = new Matrix();
                    matrix.postRotate(180.0f, ((float) bitmap.getWidth()) / 2.0f, ((float) bitmap.getHeight()) / 2.0f);
                    return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
                }
            } catch (NumberFormatException unused) {
                Bitmap bitmap2 = bitmap;
                if (!Log.isLoggable(TAG, 3)) {
                    return bitmap2;
                }
                Log.d(TAG, "Exception trying to extract HDR transfer function or rotation");
                return bitmap2;
            }
        }
        return bitmap;
    }

    private static boolean isHDR(MediaMetadataRetriever mediaMetadataRetriever) throws NumberFormatException {
        String extractMetadata = mediaMetadataRetriever.extractMetadata(36);
        String extractMetadata2 = mediaMetadataRetriever.extractMetadata(35);
        int parseInt = Integer.parseInt(extractMetadata);
        return (parseInt == 7 || parseInt == 6) && Integer.parseInt(extractMetadata2) == 6;
    }

    static boolean isHdr180RotationFixRequired() {
        if (!Build.MODEL.startsWith("Pixel") || Build.VERSION.SDK_INT != 33) {
            return Build.VERSION.SDK_INT >= 30 && Build.VERSION.SDK_INT < 33;
        }
        return isTBuildRequiringRotationFix();
    }

    private static boolean isTBuildRequiringRotationFix() {
        for (String startsWith : PIXEL_T_BUILD_ID_PREFIXES_REQUIRING_HDR_180_ROTATION_FIX) {
            if (Build.ID.startsWith(startsWith)) {
                return true;
            }
        }
        return false;
    }

    private static Bitmap decodeScaledFrame(MediaMetadataRetriever mediaMetadataRetriever, long j, int i, int i2, int i3, DownsampleStrategy downsampleStrategy) {
        try {
            int parseInt = Integer.parseInt(mediaMetadataRetriever.extractMetadata(18));
            int parseInt2 = Integer.parseInt(mediaMetadataRetriever.extractMetadata(19));
            int parseInt3 = Integer.parseInt(mediaMetadataRetriever.extractMetadata(24));
            if (parseInt3 == 90 || parseInt3 == 270) {
                int i4 = parseInt2;
                parseInt2 = parseInt;
                parseInt = i4;
            }
            float scaleFactor = downsampleStrategy.getScaleFactor(parseInt, parseInt2, i2, i3);
            return mediaMetadataRetriever.getScaledFrameAtTime(j, i, Math.round(((float) parseInt) * scaleFactor), Math.round(scaleFactor * ((float) parseInt2)));
        } catch (Throwable th) {
            Throwable th2 = th;
            if (!Log.isLoggable(TAG, 3)) {
                return null;
            }
            Log.d(TAG, "Exception trying to decode a scaled frame on oreo+, falling back to a fullsize frame", th2);
            return null;
        }
    }

    private static Bitmap decodeOriginalFrame(MediaMetadataRetriever mediaMetadataRetriever, long j, int i) {
        return mediaMetadataRetriever.getFrameAtTime(j, i);
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x005b A[Catch:{ all -> 0x0066 }] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0062 A[DONT_GENERATE] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean isUnsupportedFormat(T r6, android.media.MediaMetadataRetriever r7) {
        /*
            r5 = this;
            java.lang.String r0 = "VideoDecoder"
            java.lang.String r1 = android.os.Build.DEVICE
            r2 = 0
            if (r1 == 0) goto L_0x006d
            java.lang.String r1 = android.os.Build.DEVICE
            java.lang.String r3 = ".+_cheets|cheets_.+"
            boolean r1 = r1.matches(r3)
            if (r1 == 0) goto L_0x006d
            r1 = 12
            r3 = 0
            java.lang.String r7 = r7.extractMetadata(r1)     // Catch:{ all -> 0x0053 }
            java.lang.String r1 = "video/webm"
            boolean r7 = r1.equals(r7)     // Catch:{ all -> 0x0053 }
            if (r7 != 0) goto L_0x0021
            return r2
        L_0x0021:
            android.media.MediaExtractor r7 = new android.media.MediaExtractor     // Catch:{ all -> 0x0053 }
            r7.<init>()     // Catch:{ all -> 0x0053 }
            com.bumptech.glide.load.resource.bitmap.VideoDecoder$MediaInitializer<T> r1 = r5.initializer     // Catch:{ all -> 0x0050 }
            r1.initializeExtractor(r7, r6)     // Catch:{ all -> 0x0050 }
            int r6 = r7.getTrackCount()     // Catch:{ all -> 0x0050 }
            r1 = r2
        L_0x0030:
            if (r1 >= r6) goto L_0x004c
            android.media.MediaFormat r3 = r7.getTrackFormat(r1)     // Catch:{ all -> 0x0050 }
            java.lang.String r4 = "mime"
            java.lang.String r3 = r3.getString(r4)     // Catch:{ all -> 0x0050 }
            java.lang.String r4 = "video/x-vnd.on2.vp8"
            boolean r3 = r4.equals(r3)     // Catch:{ all -> 0x0050 }
            if (r3 == 0) goto L_0x0049
            r7.release()
            r6 = 1
            return r6
        L_0x0049:
            int r1 = r1 + 1
            goto L_0x0030
        L_0x004c:
            r7.release()
            goto L_0x0065
        L_0x0050:
            r6 = move-exception
            r3 = r7
            goto L_0x0054
        L_0x0053:
            r6 = move-exception
        L_0x0054:
            r7 = 3
            boolean r7 = android.util.Log.isLoggable(r0, r7)     // Catch:{ all -> 0x0066 }
            if (r7 == 0) goto L_0x0060
            java.lang.String r7 = "Exception trying to extract track info for a webm video on CrOS."
            android.util.Log.d(r0, r7, r6)     // Catch:{ all -> 0x0066 }
        L_0x0060:
            if (r3 == 0) goto L_0x0065
            r3.release()
        L_0x0065:
            return r2
        L_0x0066:
            r6 = move-exception
            if (r3 == 0) goto L_0x006c
            r3.release()
        L_0x006c:
            throw r6
        L_0x006d:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.resource.bitmap.VideoDecoder.isUnsupportedFormat(java.lang.Object, android.media.MediaMetadataRetriever):boolean");
    }

    static class MediaMetadataRetrieverFactory {
        MediaMetadataRetrieverFactory() {
        }

        public MediaMetadataRetriever build() {
            return new MediaMetadataRetriever();
        }
    }

    private static final class AssetFileDescriptorInitializer implements MediaInitializer<AssetFileDescriptor> {
        private AssetFileDescriptorInitializer() {
        }

        public void initializeRetriever(MediaMetadataRetriever mediaMetadataRetriever, AssetFileDescriptor assetFileDescriptor) {
            mediaMetadataRetriever.setDataSource(assetFileDescriptor.getFileDescriptor(), assetFileDescriptor.getStartOffset(), assetFileDescriptor.getLength());
        }

        public void initializeExtractor(MediaExtractor mediaExtractor, AssetFileDescriptor assetFileDescriptor) throws IOException {
            mediaExtractor.setDataSource(assetFileDescriptor.getFileDescriptor(), assetFileDescriptor.getStartOffset(), assetFileDescriptor.getLength());
        }
    }

    static final class ParcelFileDescriptorInitializer implements MediaInitializer<ParcelFileDescriptor> {
        ParcelFileDescriptorInitializer() {
        }

        public void initializeRetriever(MediaMetadataRetriever mediaMetadataRetriever, ParcelFileDescriptor parcelFileDescriptor) {
            mediaMetadataRetriever.setDataSource(parcelFileDescriptor.getFileDescriptor());
        }

        public void initializeExtractor(MediaExtractor mediaExtractor, ParcelFileDescriptor parcelFileDescriptor) throws IOException {
            mediaExtractor.setDataSource(parcelFileDescriptor.getFileDescriptor());
        }
    }

    static final class ByteBufferInitializer implements MediaInitializer<ByteBuffer> {
        ByteBufferInitializer() {
        }

        public void initializeRetriever(MediaMetadataRetriever mediaMetadataRetriever, ByteBuffer byteBuffer) {
            mediaMetadataRetriever.setDataSource(getMediaDataSource(byteBuffer));
        }

        public void initializeExtractor(MediaExtractor mediaExtractor, ByteBuffer byteBuffer) throws IOException {
            mediaExtractor.setDataSource(getMediaDataSource(byteBuffer));
        }

        private MediaDataSource getMediaDataSource(final ByteBuffer byteBuffer) {
            return new MediaDataSource() {
                public void close() {
                }

                public int readAt(long j, byte[] bArr, int i, int i2) {
                    if (j >= ((long) byteBuffer.limit())) {
                        return -1;
                    }
                    byteBuffer.position((int) j);
                    int min = Math.min(i2, byteBuffer.remaining());
                    byteBuffer.get(bArr, i, min);
                    return min;
                }

                public long getSize() {
                    return (long) byteBuffer.limit();
                }
            };
        }
    }

    private static final class VideoDecoderException extends RuntimeException {
        private static final long serialVersionUID = -2556382523004027815L;

        VideoDecoderException() {
            super("MediaMetadataRetriever failed to retrieve a frame without throwing, check the adb logs for .*MetadataRetriever.* prior to this exception for details");
        }
    }
}
