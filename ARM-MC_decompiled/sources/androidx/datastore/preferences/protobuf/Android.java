package androidx.datastore.preferences.protobuf;

final class Android {
    private static boolean ASSUME_ANDROID;
    private static final boolean IS_ROBOLECTRIC = (!ASSUME_ANDROID && getClassForName("org.robolectric.Robolectric") != null);
    private static final Class<?> MEMORY_CLASS = getClassForName("libcore.io.Memory");

    private Android() {
    }

    static boolean isOnAndroidDevice() {
        if (!ASSUME_ANDROID) {
            return MEMORY_CLASS != null && !IS_ROBOLECTRIC;
        }
        return true;
    }

    static Class<?> getMemoryClass() {
        return MEMORY_CLASS;
    }

    private static <T> Class<T> getClassForName(String str) {
        try {
            return Class.forName(str);
        } catch (Throwable unused) {
            return null;
        }
    }
}
