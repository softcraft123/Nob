package androidx.core.hardware.display;

import android.content.Context;
import android.hardware.display.DisplayManager;
import android.os.Build;
import android.view.Display;
import java.util.Objects;

public final class DisplayManagerCompat {
    static final String DISPLAY_CATEGORY_ALL = "android.hardware.display.category.ALL_INCLUDING_DISABLED";
    public static final String DISPLAY_CATEGORY_BUILT_IN_DISPLAYS = "android.hardware.display.category.BUILT_IN_DISPLAYS";
    public static final String DISPLAY_CATEGORY_PRESENTATION = "android.hardware.display.category.PRESENTATION";
    static final int DISPLAY_TYPE_INTERNAL = 1;
    private final Context mContext;

    private DisplayManagerCompat(Context context) {
        this.mContext = context;
    }

    public static DisplayManagerCompat getInstance(Context context) {
        return new DisplayManagerCompat(context);
    }

    public Display getDisplay(int i) {
        return ((DisplayManager) this.mContext.getSystemService("display")).getDisplay(i);
    }

    public Display[] getDisplays() {
        return ((DisplayManager) this.mContext.getSystemService("display")).getDisplays();
    }

    public Display[] getDisplays(String str) {
        DisplayManager displayManager = (DisplayManager) this.mContext.getSystemService("display");
        if (DISPLAY_CATEGORY_BUILT_IN_DISPLAYS.equals(str)) {
            return computeBuiltInDisplays(displayManager);
        }
        return ((DisplayManager) this.mContext.getSystemService("display")).getDisplays(str);
    }

    private static Display[] computeBuiltInDisplays(DisplayManager displayManager) {
        Display[] displayArr;
        if (Build.VERSION.SDK_INT >= 33) {
            displayArr = displayManager.getDisplays(DISPLAY_CATEGORY_ALL);
        } else {
            displayArr = displayManager.getDisplays();
        }
        Display[] displayArr2 = new Display[numberOfDisplaysByType(1, displayArr)];
        int i = 0;
        for (Display display : displayArr) {
            if (1 == getTypeCompat(display)) {
                displayArr2[i] = display;
                i++;
            }
        }
        return displayArr2;
    }

    private static int numberOfDisplaysByType(int i, Display[] displayArr) {
        int i2 = 0;
        for (Display typeCompat : displayArr) {
            if (i == getTypeCompat(typeCompat)) {
                i2++;
            }
        }
        return i2;
    }

    static int getTypeCompat(Display display) {
        try {
            return ((Integer) Objects.requireNonNull(Display.class.getMethod("getType", new Class[0]).invoke(display, new Object[0]))).intValue();
        } catch (NoSuchMethodException unused) {
            return 0;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
