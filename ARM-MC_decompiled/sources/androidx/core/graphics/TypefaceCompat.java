package androidx.core.graphics;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.graphics.fonts.Font;
import android.graphics.fonts.FontFamily;
import android.graphics.text.PositionedGlyphs;
import android.graphics.text.TextRunShaper;
import android.os.Build;
import android.os.CancellationSignal;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import androidx.collection.LruCache;
import androidx.core.content.res.FontResourcesParserCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.provider.FontRequest;
import androidx.core.provider.FontsContractCompat;
import androidx.core.util.Preconditions;
import androidx.tracing.Trace;
import java.io.IOException;
import java.util.List;

public class TypefaceCompat {
    public static final boolean DOWNLOADABLE_FALLBACK_DEBUG = false;
    public static final boolean DOWNLOADABLE_FONT_TRACING = true;
    private static final String REFERENCE_CHAR_FOR_PRIMARY_FONT = " ";
    private static final String TAG = "TypefaceCompat";
    private static Paint sCachedPaint = null;
    private static final LruCache<String, Typeface> sTypefaceCache = new LruCache<>(16);
    private static final TypefaceCompatBaseImpl sTypefaceCompatImpl;

    static {
        Trace.beginSection("TypefaceCompat static init");
        if (Build.VERSION.SDK_INT >= 31) {
            sTypefaceCompatImpl = new TypefaceCompatApi31Impl();
        } else if (Build.VERSION.SDK_INT >= 29) {
            sTypefaceCompatImpl = new TypefaceCompatApi29Impl();
        } else if (Build.VERSION.SDK_INT >= 28) {
            sTypefaceCompatImpl = new TypefaceCompatApi28Impl();
        } else {
            sTypefaceCompatImpl = new TypefaceCompatApi26Impl();
        }
        Trace.endSection();
    }

    private TypefaceCompat() {
    }

    public static Typeface findFromCache(Resources resources, int i, String str, int i2, int i3) {
        return sTypefaceCache.get(createResourceUid(resources, i, str, i2, i3));
    }

    @Deprecated
    public static Typeface findFromCache(Resources resources, int i, int i2) {
        return findFromCache(resources, i, (String) null, 0, i2);
    }

    private static String createResourceUid(Resources resources, int i, String str, int i2, int i3) {
        return resources.getResourcePackageName(i) + '-' + str + '-' + i2 + '-' + i + '-' + i3;
    }

    public static Font guessPrimaryFont(Typeface typeface) {
        if (sCachedPaint == null) {
            sCachedPaint = new Paint();
        }
        sCachedPaint.setTextSize(10.0f);
        sCachedPaint.setTypeface(typeface);
        PositionedGlyphs shapeTextRun = TextRunShaper.shapeTextRun(REFERENCE_CHAR_FOR_PRIMARY_FONT, 0, REFERENCE_CHAR_FOR_PRIMARY_FONT.length(), 0, REFERENCE_CHAR_FOR_PRIMARY_FONT.length(), 0.0f, 0.0f, false, sCachedPaint);
        if (shapeTextRun.glyphCount() == 0) {
            return null;
        }
        return shapeTextRun.getFont(0);
    }

    public static Typeface getSystemFontFamily(String str) {
        if (str != null && !str.isEmpty()) {
            Typeface create = Typeface.create(str, 0);
            Typeface create2 = Typeface.create(Typeface.DEFAULT, 0);
            if (create == null || create.equals(create2)) {
                return null;
            }
            return create;
        }
        return null;
    }

    private static Typeface getSystemFontFamilyWithFallback(FontResourcesParserCompat.ProviderResourceEntry providerResourceEntry) {
        FontFamily fontFamily;
        Typeface systemFontFamily;
        String systemFontFamilyName = providerResourceEntry.getSystemFontFamilyName();
        if (!TextUtils.isEmpty(systemFontFamilyName) && (systemFontFamily = getSystemFontFamily(systemFontFamilyName)) != null) {
            return systemFontFamily;
        }
        List<FontRequest> requests = providerResourceEntry.getRequests();
        int i = 0;
        if (requests.size() == 1) {
            return getSystemFontFamily(requests.get(0).getSystemFont());
        }
        if (Build.VERSION.SDK_INT < 31) {
            return null;
        }
        for (int i2 = 0; i2 < requests.size(); i2++) {
            if (getSystemFontFamily(requests.get(i2).getSystemFont()) == null) {
                return null;
            }
        }
        Typeface.CustomFallbackBuilder customFallbackBuilder = null;
        while (true) {
            if (i >= requests.size()) {
                break;
            }
            FontRequest fontRequest = requests.get(i);
            if (i == requests.size() - 1 && TextUtils.isEmpty(fontRequest.getVariationSettings())) {
                customFallbackBuilder.setSystemFallback(fontRequest.getSystemFont());
                break;
            }
            Font guessPrimaryFont = guessPrimaryFont(getSystemFontFamily(fontRequest.getSystemFont()));
            if (guessPrimaryFont == null) {
                Log.w(TAG, "Unable identify the primary font for " + fontRequest.getSystemFont() + ". Falling back to provider font.");
                return null;
            }
            if (TextUtils.isEmpty(fontRequest.getVariationSettings())) {
                try {
                    fontFamily = new FontFamily.Builder(new Font.Builder(guessPrimaryFont).setFontVariationSettings(fontRequest.getVariationSettings()).build()).build();
                } catch (IOException unused) {
                    Log.e(TAG, "Failed to clone Font instance. Fall back to provider font.");
                    return null;
                }
            } else {
                fontFamily = new FontFamily.Builder(guessPrimaryFont).build();
            }
            if (customFallbackBuilder == null) {
                customFallbackBuilder = new Typeface.CustomFallbackBuilder(fontFamily);
            } else {
                customFallbackBuilder.addCustomFallback(fontFamily);
            }
            i++;
        }
        return customFallbackBuilder.build();
    }

    public static Typeface createFromResourcesFamilyXml(Context context, FontResourcesParserCompat.FamilyResourceEntry familyResourceEntry, Resources resources, int i, String str, int i2, int i3, ResourcesCompat.FontCallback fontCallback, Handler handler, boolean z) {
        Typeface typeface;
        ResourcesCompat.FontCallback fontCallback2 = fontCallback;
        Handler handler2 = handler;
        if (familyResourceEntry instanceof FontResourcesParserCompat.ProviderResourceEntry) {
            FontResourcesParserCompat.ProviderResourceEntry providerResourceEntry = (FontResourcesParserCompat.ProviderResourceEntry) familyResourceEntry;
            Typeface systemFontFamilyWithFallback = getSystemFontFamilyWithFallback(providerResourceEntry);
            if (systemFontFamilyWithFallback != null) {
                if (fontCallback2 != null) {
                    fontCallback2.callbackSuccessAsync(systemFontFamilyWithFallback, handler2);
                }
                sTypefaceCache.put(createResourceUid(resources, i, str, i2, i3), systemFontFamilyWithFallback);
                return systemFontFamilyWithFallback;
            }
            typeface = FontsContractCompat.requestFont(context, providerResourceEntry.getRequests(), i3, !z ? fontCallback2 == null : providerResourceEntry.getFetchStrategy() == 0, z ? providerResourceEntry.getTimeout() : -1, ResourcesCompat.FontCallback.getHandler(handler2), (FontsContractCompat.FontRequestCallback) new ResourcesCallbackAdapter(fontCallback2));
        } else {
            typeface = sTypefaceCompatImpl.createFromFontFamilyFilesResourceEntry(context, (FontResourcesParserCompat.FontFamilyFilesResourceEntry) familyResourceEntry, resources, i3);
            if (fontCallback2 != null) {
                if (typeface != null) {
                    fontCallback2.callbackSuccessAsync(typeface, handler2);
                } else {
                    fontCallback2.callbackFailAsync(-3, handler2);
                }
            }
        }
        if (typeface != null) {
            sTypefaceCache.put(createResourceUid(resources, i, str, i2, i3), typeface);
        }
        return typeface;
    }

    @Deprecated
    public static Typeface createFromResourcesFamilyXml(Context context, FontResourcesParserCompat.FamilyResourceEntry familyResourceEntry, Resources resources, int i, int i2, ResourcesCompat.FontCallback fontCallback, Handler handler, boolean z) {
        return createFromResourcesFamilyXml(context, familyResourceEntry, resources, i, (String) null, 0, i2, fontCallback, handler, z);
    }

    public static Typeface createFromResourcesFontFile(Context context, Resources resources, int i, String str, int i2, int i3) {
        Resources resources2 = resources;
        int i4 = i;
        String str2 = str;
        int i5 = i3;
        Typeface createFromResourcesFontFile = sTypefaceCompatImpl.createFromResourcesFontFile(context, resources2, i4, str2, i5);
        if (createFromResourcesFontFile != null) {
            sTypefaceCache.put(createResourceUid(resources2, i4, str2, i2, i5), createFromResourcesFontFile);
        }
        return createFromResourcesFontFile;
    }

    @Deprecated
    public static Typeface createFromResourcesFontFile(Context context, Resources resources, int i, String str, int i2) {
        return createFromResourcesFontFile(context, resources, i, str, 0, i2);
    }

    public static Typeface createFromFontInfo(Context context, CancellationSignal cancellationSignal, FontsContractCompat.FontInfo[] fontInfoArr, int i) {
        Trace.beginSection("TypefaceCompat.createFromFontInfo");
        try {
            return sTypefaceCompatImpl.createFromFontInfo(context, cancellationSignal, fontInfoArr, i);
        } finally {
            Trace.endSection();
        }
    }

    public static Typeface createFromFontInfoWithFallback(Context context, CancellationSignal cancellationSignal, List<FontsContractCompat.FontInfo[]> list, int i) {
        Trace.beginSection("TypefaceCompat.createFromFontInfoWithFallback");
        try {
            return sTypefaceCompatImpl.createFromFontInfoWithFallback(context, cancellationSignal, list, i);
        } finally {
            Trace.endSection();
        }
    }

    private static Typeface getBestFontFromFamily(Context context, Typeface typeface, int i) {
        TypefaceCompatBaseImpl typefaceCompatBaseImpl = sTypefaceCompatImpl;
        FontResourcesParserCompat.FontFamilyFilesResourceEntry fontFamily = typefaceCompatBaseImpl.getFontFamily(typeface);
        if (fontFamily == null) {
            return null;
        }
        return typefaceCompatBaseImpl.createFromFontFamilyFilesResourceEntry(context, fontFamily, context.getResources(), i);
    }

    public static Typeface create(Context context, Typeface typeface, int i) {
        if (context != null) {
            return Typeface.create(typeface, i);
        }
        throw new IllegalArgumentException("Context cannot be null");
    }

    public static Typeface create(Context context, Typeface typeface, int i, boolean z) {
        if (context != null) {
            Preconditions.checkArgumentInRange(i, 1, 1000, "weight");
            if (typeface == null) {
                typeface = Typeface.DEFAULT;
            }
            return sTypefaceCompatImpl.createWeightStyle(context, typeface, i, z);
        }
        throw new IllegalArgumentException("Context cannot be null");
    }

    public static void clearCache() {
        sTypefaceCache.evictAll();
    }

    public static class ResourcesCallbackAdapter extends FontsContractCompat.FontRequestCallback {
        private ResourcesCompat.FontCallback mFontCallback;

        public ResourcesCallbackAdapter(ResourcesCompat.FontCallback fontCallback) {
            this.mFontCallback = fontCallback;
        }

        public void onTypefaceRetrieved(Typeface typeface) {
            ResourcesCompat.FontCallback fontCallback = this.mFontCallback;
            if (fontCallback != null) {
                fontCallback.m41lambda$callbackSuccessAsync$0$androidxcorecontentresResourcesCompat$FontCallback(typeface);
            }
        }

        public void onTypefaceRequestFailed(int i) {
            ResourcesCompat.FontCallback fontCallback = this.mFontCallback;
            if (fontCallback != null) {
                fontCallback.m40lambda$callbackFailAsync$1$androidxcorecontentresResourcesCompat$FontCallback(i);
            }
        }
    }
}
