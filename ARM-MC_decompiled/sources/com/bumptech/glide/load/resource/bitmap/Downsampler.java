package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.ColorSpace;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.util.DisplayMetrics;
import android.util.Log;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.Option;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.PreferredColorSpace;
import com.bumptech.glide.load.data.ParcelFileDescriptorRewinder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.DownsampleStrategy;
import com.bumptech.glide.load.resource.bitmap.ImageReader;
import com.bumptech.glide.util.LogTime;
import com.bumptech.glide.util.Preconditions;
import com.bumptech.glide.util.Util;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Collections;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public final class Downsampler {
    public static final Option<Boolean> ALLOW_HARDWARE_CONFIG = Option.memory("com.bumptech.glide.load.resource.bitmap.Downsampler.AllowHardwareDecode", false);
    public static final Option<DecodeFormat> DECODE_FORMAT = Option.memory("com.bumptech.glide.load.resource.bitmap.Downsampler.DecodeFormat", DecodeFormat.DEFAULT);
    @Deprecated
    public static final Option<DownsampleStrategy> DOWNSAMPLE_STRATEGY = DownsampleStrategy.OPTION;
    private static final DecodeCallbacks EMPTY_CALLBACKS = new DecodeCallbacks() {
        public void onDecodeComplete(BitmapPool bitmapPool, Bitmap bitmap) {
        }

        public void onObtainBounds() {
        }
    };
    public static final Option<Boolean> FIX_BITMAP_SIZE_TO_REQUESTED_DIMENSIONS = Option.memory("com.bumptech.glide.load.resource.bitmap.Downsampler.FixBitmapSize", false);
    private static final String ICO_MIME_TYPE = "image/x-ico";
    private static final Set<String> NO_DOWNSAMPLE_PRE_N_MIME_TYPES = Collections.unmodifiableSet(new HashSet(Arrays.asList(new String[]{WBMP_MIME_TYPE, ICO_MIME_TYPE})));
    private static final Queue<BitmapFactory.Options> OPTIONS_QUEUE = Util.createQueue(0);
    public static final Option<PreferredColorSpace> PREFERRED_COLOR_SPACE = Option.memory("com.bumptech.glide.load.resource.bitmap.Downsampler.PreferredColorSpace");
    static final String TAG = "Downsampler";
    private static final Set<ImageHeaderParser.ImageType> TYPES_THAT_USE_POOL_PRE_KITKAT = Collections.unmodifiableSet(EnumSet.of(ImageHeaderParser.ImageType.JPEG, ImageHeaderParser.ImageType.PNG_A, ImageHeaderParser.ImageType.PNG));
    private static final String WBMP_MIME_TYPE = "image/vnd.wap.wbmp";
    private final BitmapPool bitmapPool;
    private final ArrayPool byteArrayPool;
    private final DisplayMetrics displayMetrics;
    private final HardwareConfigState hardwareConfigState = HardwareConfigState.getInstance();
    private final List<ImageHeaderParser> parsers;

    public interface DecodeCallbacks {
        void onDecodeComplete(BitmapPool bitmapPool, Bitmap bitmap) throws IOException;

        void onObtainBounds();
    }

    private static boolean isRotationRequired(int i) {
        return i == 90 || i == 270;
    }

    private static int round(double d) {
        return (int) (d + 0.5d);
    }

    private boolean shouldUsePool(ImageHeaderParser.ImageType imageType) {
        return true;
    }

    public boolean handles(InputStream inputStream) {
        return true;
    }

    public boolean handles(ByteBuffer byteBuffer) {
        return true;
    }

    public Downsampler(List<ImageHeaderParser> list, DisplayMetrics displayMetrics2, BitmapPool bitmapPool2, ArrayPool arrayPool) {
        this.parsers = list;
        this.displayMetrics = (DisplayMetrics) Preconditions.checkNotNull(displayMetrics2);
        this.bitmapPool = (BitmapPool) Preconditions.checkNotNull(bitmapPool2);
        this.byteArrayPool = (ArrayPool) Preconditions.checkNotNull(arrayPool);
    }

    public boolean handles(ParcelFileDescriptor parcelFileDescriptor) {
        return ParcelFileDescriptorRewinder.isSupported();
    }

    public Resource<Bitmap> decode(InputStream inputStream, int i, int i2, Options options) throws IOException {
        return decode(inputStream, i, i2, options, EMPTY_CALLBACKS);
    }

    public Resource<Bitmap> decode(ByteBuffer byteBuffer, int i, int i2, Options options) throws IOException {
        return decode((ImageReader) new ImageReader.ByteBufferReader(byteBuffer, this.parsers, this.byteArrayPool), i, i2, options, EMPTY_CALLBACKS);
    }

    public Resource<Bitmap> decode(InputStream inputStream, int i, int i2, Options options, DecodeCallbacks decodeCallbacks) throws IOException {
        return decode((ImageReader) new ImageReader.InputStreamImageReader(inputStream, this.parsers, this.byteArrayPool), i, i2, options, decodeCallbacks);
    }

    /* access modifiers changed from: package-private */
    public void decode(byte[] bArr, int i, int i2, Options options) throws IOException {
        decode((ImageReader) new ImageReader.ByteArrayReader(bArr, this.parsers, this.byteArrayPool), i, i2, options, EMPTY_CALLBACKS);
    }

    /* access modifiers changed from: package-private */
    public void decode(File file, int i, int i2, Options options) throws IOException {
        decode((ImageReader) new ImageReader.FileReader(file, this.parsers, this.byteArrayPool), i, i2, options, EMPTY_CALLBACKS);
    }

    public Resource<Bitmap> decode(ParcelFileDescriptor parcelFileDescriptor, int i, int i2, Options options) throws IOException {
        return decode((ImageReader) new ImageReader.ParcelFileDescriptorImageReader(parcelFileDescriptor, this.parsers, this.byteArrayPool), i, i2, options, EMPTY_CALLBACKS);
    }

    private Resource<Bitmap> decode(ImageReader imageReader, int i, int i2, Options options, DecodeCallbacks decodeCallbacks) throws IOException {
        Options options2 = options;
        byte[] bArr = (byte[]) this.byteArrayPool.get(65536, byte[].class);
        BitmapFactory.Options defaultOptions = getDefaultOptions();
        defaultOptions.inTempStorage = bArr;
        DecodeFormat decodeFormat = (DecodeFormat) options2.get(DECODE_FORMAT);
        PreferredColorSpace preferredColorSpace = (PreferredColorSpace) options2.get(PREFERRED_COLOR_SPACE);
        DownsampleStrategy downsampleStrategy = (DownsampleStrategy) options2.get(DownsampleStrategy.OPTION);
        boolean booleanValue = ((Boolean) options2.get(FIX_BITMAP_SIZE_TO_REQUESTED_DIMENSIONS)).booleanValue();
        Option option = ALLOW_HARDWARE_CONFIG;
        try {
            BitmapResource obtain = BitmapResource.obtain(decodeFromWrappedStreams(imageReader, defaultOptions, downsampleStrategy, decodeFormat, preferredColorSpace, options2.get(option) != null && ((Boolean) options2.get(option)).booleanValue(), i, i2, booleanValue, decodeCallbacks), this.bitmapPool);
            releaseOptions(defaultOptions);
            this.byteArrayPool.put(bArr);
            return obtain;
        } catch (Throwable th) {
            Throwable th2 = th;
            releaseOptions(defaultOptions);
            this.byteArrayPool.put(bArr);
            throw th2;
        }
    }

    private Bitmap decodeFromWrappedStreams(ImageReader imageReader, BitmapFactory.Options options, DownsampleStrategy downsampleStrategy, DecodeFormat decodeFormat, PreferredColorSpace preferredColorSpace, boolean z, int i, int i2, boolean z2, DecodeCallbacks decodeCallbacks) throws IOException {
        int i3;
        String str;
        int i4;
        int i5;
        ImageReader imageReader2 = imageReader;
        BitmapFactory.Options options2 = options;
        PreferredColorSpace preferredColorSpace2 = preferredColorSpace;
        DecodeCallbacks decodeCallbacks2 = decodeCallbacks;
        long logTime = LogTime.getLogTime();
        int[] dimensions = getDimensions(imageReader2, options2, decodeCallbacks2, this.bitmapPool);
        int i6 = dimensions[0];
        int i7 = dimensions[1];
        String str2 = options2.outMimeType;
        boolean z3 = (i6 == -1 || i7 == -1) ? false : z;
        int imageOrientation = imageReader2.getImageOrientation();
        int exifOrientationDegrees = TransformationUtils.getExifOrientationDegrees(imageOrientation);
        boolean isExifOrientationRequired = TransformationUtils.isExifOrientationRequired(imageOrientation);
        int i8 = i;
        if (i8 != Integer.MIN_VALUE) {
            i3 = i2;
        } else if (isRotationRequired(exifOrientationDegrees)) {
            i3 = i2;
            i8 = i7;
        } else {
            i3 = i2;
            i8 = i6;
        }
        if (i3 == Integer.MIN_VALUE) {
            i3 = isRotationRequired(exifOrientationDegrees) ? i6 : i7;
        }
        ImageHeaderParser.ImageType imageType = imageReader.getImageType();
        BitmapFactory.Options options3 = options2;
        long j = logTime;
        int i9 = imageOrientation;
        ImageReader imageReader3 = imageReader;
        calculateScaling(imageType, imageReader3, decodeCallbacks2, this.bitmapPool, downsampleStrategy, exifOrientationDegrees, i6, i7, i8, i3, options3);
        int i10 = i8;
        BitmapFactory.Options options4 = options3;
        ImageHeaderParser.ImageType imageType2 = imageType;
        ImageReader imageReader4 = imageReader3;
        int i11 = i6;
        int i12 = i3;
        int i13 = i7;
        DecodeCallbacks decodeCallbacks3 = decodeCallbacks2;
        calculateConfig(imageReader4, decodeFormat, z3, isExifOrientationRequired, options4, i10, i12);
        int i14 = options4.inSampleSize;
        if (shouldUsePool(imageType2)) {
            if (i11 < 0 || i13 < 0 || !z2) {
                float f = isScaling(options4) ? ((float) options4.inTargetDensity) / ((float) options4.inDensity) : 1.0f;
                int i15 = options4.inSampleSize;
                float f2 = (float) i15;
                String str3 = TAG;
                int round = Math.round(((float) ((int) Math.ceil((double) (((float) i11) / f2)))) * f);
                i4 = Math.round(((float) ((int) Math.ceil((double) (((float) i13) / f2)))) * f);
                str = str3;
                if (Log.isLoggable(str, 2)) {
                    i5 = round;
                    Log.v(str, "Calculated target [" + round + "x" + i4 + "] for source [" + i11 + "x" + i13 + "], sampleSize: " + i15 + ", targetDensity: " + options4.inTargetDensity + ", density: " + options4.inDensity + ", density multiplier: " + f);
                } else {
                    i5 = round;
                }
                i10 = i5;
            } else {
                int i16 = i12;
                str = TAG;
                i4 = i16;
            }
            if (i10 > 0 && i4 > 0) {
                setInBitmap(options4, this.bitmapPool, i10, i4);
            }
        } else {
            str = TAG;
        }
        if (preferredColorSpace2 != null) {
            if (Build.VERSION.SDK_INT >= 28) {
                options4.inPreferredColorSpace = ColorSpace.get((preferredColorSpace2 != PreferredColorSpace.DISPLAY_P3 || options4.outColorSpace == null || !options4.outColorSpace.isWideGamut()) ? ColorSpace.Named.SRGB : ColorSpace.Named.DISPLAY_P3);
            } else {
                options4.inPreferredColorSpace = ColorSpace.get(ColorSpace.Named.SRGB);
            }
        }
        Bitmap decodeStream = decodeStream(imageReader4, options4, decodeCallbacks3, this.bitmapPool);
        decodeCallbacks3.onDecodeComplete(this.bitmapPool, decodeStream);
        if (Log.isLoggable(str, 2)) {
            logDecode(i11, i13, str2, options4, decodeStream, i, i2, j);
        }
        if (decodeStream == null) {
            return null;
        }
        decodeStream.setDensity(this.displayMetrics.densityDpi);
        Bitmap rotateImageExif = TransformationUtils.rotateImageExif(this.bitmapPool, decodeStream, i9);
        if (!decodeStream.equals(rotateImageExif)) {
            this.bitmapPool.put(decodeStream);
        }
        return rotateImageExif;
    }

    private static void calculateScaling(ImageHeaderParser.ImageType imageType, ImageReader imageReader, DecodeCallbacks decodeCallbacks, BitmapPool bitmapPool2, DownsampleStrategy downsampleStrategy, int i, int i2, int i3, int i4, int i5, BitmapFactory.Options options) throws IOException {
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        ImageHeaderParser.ImageType imageType2 = imageType;
        DownsampleStrategy downsampleStrategy2 = downsampleStrategy;
        int i12 = i2;
        int i13 = i3;
        int i14 = i4;
        int i15 = i5;
        BitmapFactory.Options options2 = options;
        if (i12 > 0 && i13 > 0) {
            if (isRotationRequired(i)) {
                i6 = i12;
                i7 = i13;
            } else {
                i7 = i12;
                i6 = i13;
            }
            float scaleFactor = downsampleStrategy2.getScaleFactor(i7, i6, i14, i15);
            if (scaleFactor > 0.0f) {
                DownsampleStrategy.SampleSizeRounding sampleSizeRounding = downsampleStrategy2.getSampleSizeRounding(i7, i6, i14, i15);
                if (sampleSizeRounding != null) {
                    float f = (float) i7;
                    float f2 = (float) i6;
                    int i16 = i7;
                    int i17 = i6;
                    int round = i16 / round((double) (scaleFactor * f));
                    int round2 = i17 / round((double) (scaleFactor * f2));
                    if (sampleSizeRounding == DownsampleStrategy.SampleSizeRounding.MEMORY) {
                        i8 = Math.max(round, round2);
                    } else {
                        i8 = Math.min(round, round2);
                    }
                    int max = Math.max(1, Integer.highestOneBit(i8));
                    if (sampleSizeRounding == DownsampleStrategy.SampleSizeRounding.MEMORY && ((float) max) < 1.0f / scaleFactor) {
                        max <<= 1;
                    }
                    options2.inSampleSize = max;
                    if (imageType2 == ImageHeaderParser.ImageType.JPEG) {
                        float min = (float) Math.min(max, 8);
                        i9 = 0;
                        i10 = (int) Math.ceil((double) (f / min));
                        i11 = (int) Math.ceil((double) (f2 / min));
                        int i18 = max / 8;
                        if (i18 > 0) {
                            i10 /= i18;
                            i11 /= i18;
                        }
                    } else {
                        float f3 = f2;
                        i9 = 0;
                        if (imageType2 == ImageHeaderParser.ImageType.PNG || imageType2 == ImageHeaderParser.ImageType.PNG_A) {
                            float f4 = (float) max;
                            i10 = (int) Math.floor((double) (f / f4));
                            i11 = (int) Math.floor((double) (f3 / f4));
                        } else if (imageType2.isWebp()) {
                            float f5 = (float) max;
                            i10 = Math.round(f / f5);
                            i11 = Math.round(f3 / f5);
                        } else if (i16 % max == 0 && i17 % max == 0) {
                            i10 = i16 / max;
                            i11 = i17 / max;
                        } else {
                            int[] dimensions = getDimensions(imageReader, options2, decodeCallbacks, bitmapPool2);
                            i10 = dimensions[0];
                            i11 = dimensions[1];
                        }
                    }
                    double scaleFactor2 = (double) downsampleStrategy2.getScaleFactor(i10, i11, i14, i15);
                    options2.inTargetDensity = adjustTargetDensityForError(scaleFactor2);
                    options2.inDensity = getDensityMultiplier(scaleFactor2);
                    if (isScaling(options2)) {
                        options2.inScaled = true;
                    } else {
                        int i19 = i9;
                        options2.inTargetDensity = i19;
                        options2.inDensity = i19;
                    }
                    if (Log.isLoggable(TAG, 2)) {
                        Log.v(TAG, "Calculate scaling, source: [" + i12 + "x" + i13 + "], degreesToRotate: " + i + ", target: [" + i14 + "x" + i15 + "], power of two scaled: [" + i10 + "x" + i11 + "], exact scale factor: " + scaleFactor + ", power of 2 sample size: " + max + ", adjusted scale factor: " + scaleFactor2 + ", target density: " + options2.inTargetDensity + ", density: " + options2.inDensity);
                        return;
                    }
                    return;
                }
                throw new IllegalArgumentException("Cannot round with null rounding");
            }
            throw new IllegalArgumentException("Cannot scale with factor: " + scaleFactor + " from: " + downsampleStrategy2 + ", source: [" + i12 + "x" + i13 + "], target: [" + i14 + "x" + i15 + "]");
        } else if (Log.isLoggable(TAG, 3)) {
            Log.d(TAG, "Unable to determine dimensions for: " + imageType2 + " with target [" + i14 + "x" + i15 + "]");
        }
    }

    private static int adjustTargetDensityForError(double d) {
        int densityMultiplier = getDensityMultiplier(d);
        int round = round(((double) densityMultiplier) * d);
        return round((d / ((double) (((float) round) / ((float) densityMultiplier)))) * ((double) round));
    }

    private static int getDensityMultiplier(double d) {
        if (d > 1.0d) {
            d = 1.0d / d;
        }
        return (int) Math.round(d * 2.147483647E9d);
    }

    private void calculateConfig(ImageReader imageReader, DecodeFormat decodeFormat, boolean z, boolean z2, BitmapFactory.Options options, int i, int i2) {
        boolean z3;
        BitmapFactory.Options options2 = options;
        if (!this.hardwareConfigState.setHardwareConfigIfAllowed(i, i2, options2, z, z2)) {
            if (decodeFormat != DecodeFormat.PREFER_ARGB_8888) {
                try {
                    z3 = imageReader.getImageType().hasAlpha();
                } catch (IOException e) {
                    IOException iOException = e;
                    if (Log.isLoggable(TAG, 3)) {
                        Log.d(TAG, "Cannot determine whether the image has alpha or not from header, format " + decodeFormat, iOException);
                    }
                    z3 = false;
                }
                options2.inPreferredConfig = z3 ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565;
                if (options2.inPreferredConfig == Bitmap.Config.RGB_565) {
                    options2.inDither = true;
                    return;
                }
                return;
            }
            options2.inPreferredConfig = Bitmap.Config.ARGB_8888;
        }
    }

    private static int[] getDimensions(ImageReader imageReader, BitmapFactory.Options options, DecodeCallbacks decodeCallbacks, BitmapPool bitmapPool2) throws IOException {
        options.inJustDecodeBounds = true;
        decodeStream(imageReader, options, decodeCallbacks, bitmapPool2);
        options.inJustDecodeBounds = false;
        return new int[]{options.outWidth, options.outHeight};
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(2:17|18) */
    /* JADX WARNING: Code restructure failed: missing block: B:18:?, code lost:
        throw r1;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0047 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static android.graphics.Bitmap decodeStream(com.bumptech.glide.load.resource.bitmap.ImageReader r5, android.graphics.BitmapFactory.Options r6, com.bumptech.glide.load.resource.bitmap.Downsampler.DecodeCallbacks r7, com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool r8) throws java.io.IOException {
        /*
            java.lang.String r0 = "Downsampler"
            boolean r1 = r6.inJustDecodeBounds
            if (r1 != 0) goto L_0x000c
            r7.onObtainBounds()
            r5.stopGrowingBuffers()
        L_0x000c:
            int r1 = r6.outWidth
            int r2 = r6.outHeight
            java.lang.String r3 = r6.outMimeType
            java.util.concurrent.locks.Lock r4 = com.bumptech.glide.load.resource.bitmap.TransformationUtils.getBitmapDrawableLock()
            r4.lock()
            android.graphics.Bitmap r5 = r5.decodeBitmap(r6)     // Catch:{ IllegalArgumentException -> 0x0025 }
        L_0x001d:
            java.util.concurrent.locks.Lock r6 = com.bumptech.glide.load.resource.bitmap.TransformationUtils.getBitmapDrawableLock()
            r6.unlock()
            return r5
        L_0x0025:
            r4 = move-exception
            java.io.IOException r1 = newIoExceptionForInBitmapAssertion(r4, r1, r2, r3, r6)     // Catch:{ all -> 0x0049 }
            r2 = 3
            boolean r2 = android.util.Log.isLoggable(r0, r2)     // Catch:{ all -> 0x0049 }
            if (r2 == 0) goto L_0x0036
            java.lang.String r2 = "Failed to decode with inBitmap, trying again without Bitmap re-use"
            android.util.Log.d(r0, r2, r1)     // Catch:{ all -> 0x0049 }
        L_0x0036:
            android.graphics.Bitmap r0 = r6.inBitmap     // Catch:{ all -> 0x0049 }
            if (r0 == 0) goto L_0x0048
            android.graphics.Bitmap r0 = r6.inBitmap     // Catch:{ IOException -> 0x0047 }
            r8.put(r0)     // Catch:{ IOException -> 0x0047 }
            r0 = 0
            r6.inBitmap = r0     // Catch:{ IOException -> 0x0047 }
            android.graphics.Bitmap r5 = decodeStream(r5, r6, r7, r8)     // Catch:{ IOException -> 0x0047 }
            goto L_0x001d
        L_0x0047:
            throw r1     // Catch:{ all -> 0x0049 }
        L_0x0048:
            throw r1     // Catch:{ all -> 0x0049 }
        L_0x0049:
            r5 = move-exception
            java.util.concurrent.locks.Lock r6 = com.bumptech.glide.load.resource.bitmap.TransformationUtils.getBitmapDrawableLock()
            r6.unlock()
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.resource.bitmap.Downsampler.decodeStream(com.bumptech.glide.load.resource.bitmap.ImageReader, android.graphics.BitmapFactory$Options, com.bumptech.glide.load.resource.bitmap.Downsampler$DecodeCallbacks, com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool):android.graphics.Bitmap");
    }

    private static boolean isScaling(BitmapFactory.Options options) {
        return options.inTargetDensity > 0 && options.inDensity > 0 && options.inTargetDensity != options.inDensity;
    }

    private static void logDecode(int i, int i2, String str, BitmapFactory.Options options, Bitmap bitmap, int i3, int i4, long j) {
        Log.v(TAG, "Decoded " + getBitmapString(bitmap) + " from [" + i + "x" + i2 + "] " + str + " with inBitmap " + getInBitmapString(options) + " for [" + i3 + "x" + i4 + "], sample size: " + options.inSampleSize + ", density: " + options.inDensity + ", target density: " + options.inTargetDensity + ", thread: " + Thread.currentThread().getName() + ", duration: " + LogTime.getElapsedMillis(j));
    }

    private static String getInBitmapString(BitmapFactory.Options options) {
        return getBitmapString(options.inBitmap);
    }

    private static String getBitmapString(Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        return "[" + bitmap.getWidth() + "x" + bitmap.getHeight() + "] " + bitmap.getConfig() + (" (" + bitmap.getAllocationByteCount() + ")");
    }

    private static IOException newIoExceptionForInBitmapAssertion(IllegalArgumentException illegalArgumentException, int i, int i2, String str, BitmapFactory.Options options) {
        return new IOException("Exception decoding bitmap, outWidth: " + i + ", outHeight: " + i2 + ", outMimeType: " + str + ", inBitmap: " + getInBitmapString(options), illegalArgumentException);
    }

    private static void setInBitmap(BitmapFactory.Options options, BitmapPool bitmapPool2, int i, int i2) {
        if (options.inPreferredConfig != Bitmap.Config.HARDWARE) {
            Bitmap.Config config = options.outConfig;
            if (config == null) {
                config = options.inPreferredConfig;
            }
            options.inBitmap = bitmapPool2.getDirty(i, i2, config);
        }
    }

    private static synchronized BitmapFactory.Options getDefaultOptions() {
        BitmapFactory.Options poll;
        synchronized (Downsampler.class) {
            Queue<BitmapFactory.Options> queue = OPTIONS_QUEUE;
            synchronized (queue) {
                poll = queue.poll();
            }
            if (poll == null) {
                poll = new BitmapFactory.Options();
                resetOptions(poll);
            }
        }
        return poll;
    }

    private static void releaseOptions(BitmapFactory.Options options) {
        resetOptions(options);
        Queue<BitmapFactory.Options> queue = OPTIONS_QUEUE;
        synchronized (queue) {
            queue.offer(options);
        }
    }

    private static void resetOptions(BitmapFactory.Options options) {
        options.inTempStorage = null;
        options.inDither = false;
        options.inScaled = false;
        options.inSampleSize = 1;
        options.inPreferredConfig = null;
        options.inJustDecodeBounds = false;
        options.inDensity = 0;
        options.inTargetDensity = 0;
        options.inPreferredColorSpace = null;
        options.outColorSpace = null;
        options.outConfig = null;
        options.outWidth = 0;
        options.outHeight = 0;
        options.outMimeType = null;
        options.inBitmap = null;
        options.inMutable = true;
    }
}
