package androidx.core.location;

import android.location.Location;
import android.os.Build;
import android.os.Bundle;
import androidx.annotation.ReplaceWith;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

public final class LocationCompat {
    public static final String EXTRA_BEARING_ACCURACY = "bearingAccuracy";
    public static final String EXTRA_IS_MOCK = "mockLocation";
    public static final String EXTRA_MSL_ALTITUDE = "androidx.core.location.extra.MSL_ALTITUDE";
    public static final String EXTRA_MSL_ALTITUDE_ACCURACY = "androidx.core.location.extra.MSL_ALTITUDE_ACCURACY";
    public static final String EXTRA_SPEED_ACCURACY = "speedAccuracy";
    public static final String EXTRA_VERTICAL_ACCURACY = "verticalAccuracy";
    private static Field sFieldsMaskField;
    private static Integer sHasBearingAccuracyMask;
    private static Integer sHasSpeedAccuracyMask;
    private static Integer sHasVerticalAccuracyMask;
    private static Method sSetIsFromMockProviderMethod;

    private LocationCompat() {
    }

    @ReplaceWith(expression = "location.getElapsedRealtimeNanos()")
    @Deprecated
    public static long getElapsedRealtimeNanos(Location location) {
        return location.getElapsedRealtimeNanos();
    }

    public static long getElapsedRealtimeMillis(Location location) {
        return TimeUnit.NANOSECONDS.toMillis(location.getElapsedRealtimeNanos());
    }

    public static boolean hasVerticalAccuracy(Location location) {
        return Api26Impl.hasVerticalAccuracy(location);
    }

    public static float getVerticalAccuracyMeters(Location location) {
        return Api26Impl.getVerticalAccuracyMeters(location);
    }

    public static void setVerticalAccuracyMeters(Location location, float f) {
        Api26Impl.setVerticalAccuracyMeters(location, f);
    }

    public static void removeVerticalAccuracy(Location location) {
        if (Build.VERSION.SDK_INT >= 33) {
            Api33Impl.removeVerticalAccuracy(location);
        } else if (Build.VERSION.SDK_INT >= 29) {
            Api29Impl.removeVerticalAccuracy(location);
        } else if (Build.VERSION.SDK_INT >= 28) {
            Api28Impl.removeVerticalAccuracy(location);
        } else {
            Api26Impl.removeVerticalAccuracy(location);
        }
    }

    public static boolean hasSpeedAccuracy(Location location) {
        return Api26Impl.hasSpeedAccuracy(location);
    }

    public static float getSpeedAccuracyMetersPerSecond(Location location) {
        return Api26Impl.getSpeedAccuracyMetersPerSecond(location);
    }

    public static void setSpeedAccuracyMetersPerSecond(Location location, float f) {
        Api26Impl.setSpeedAccuracyMetersPerSecond(location, f);
    }

    public static void removeSpeedAccuracy(Location location) {
        if (Build.VERSION.SDK_INT >= 33) {
            Api33Impl.removeSpeedAccuracy(location);
        } else if (Build.VERSION.SDK_INT >= 29) {
            Api29Impl.removeSpeedAccuracy(location);
        } else if (Build.VERSION.SDK_INT >= 28) {
            Api28Impl.removeSpeedAccuracy(location);
        } else {
            Api26Impl.removeSpeedAccuracy(location);
        }
    }

    public static boolean hasBearingAccuracy(Location location) {
        return Api26Impl.hasBearingAccuracy(location);
    }

    public static float getBearingAccuracyDegrees(Location location) {
        return Api26Impl.getBearingAccuracyDegrees(location);
    }

    public static void setBearingAccuracyDegrees(Location location, float f) {
        Api26Impl.setBearingAccuracyDegrees(location, f);
    }

    public static void removeBearingAccuracy(Location location) {
        if (Build.VERSION.SDK_INT >= 33) {
            Api33Impl.removeBearingAccuracy(location);
        } else if (Build.VERSION.SDK_INT >= 29) {
            Api29Impl.removeBearingAccuracy(location);
        } else if (Build.VERSION.SDK_INT >= 28) {
            Api28Impl.removeBearingAccuracy(location);
        } else {
            Api26Impl.removeBearingAccuracy(location);
        }
    }

    public static double getMslAltitudeMeters(Location location) {
        if (Build.VERSION.SDK_INT >= 34) {
            return Api34Impl.getMslAltitudeMeters(location);
        }
        return getOrCreateExtras(location).getDouble(EXTRA_MSL_ALTITUDE);
    }

    public static void setMslAltitudeMeters(Location location, double d) {
        if (Build.VERSION.SDK_INT >= 34) {
            Api34Impl.setMslAltitudeMeters(location, d);
        } else {
            getOrCreateExtras(location).putDouble(EXTRA_MSL_ALTITUDE, d);
        }
    }

    public static boolean hasMslAltitude(Location location) {
        if (Build.VERSION.SDK_INT >= 34) {
            return Api34Impl.hasMslAltitude(location);
        }
        return containsExtra(location, EXTRA_MSL_ALTITUDE);
    }

    public static void removeMslAltitude(Location location) {
        if (Build.VERSION.SDK_INT >= 34) {
            Api34Impl.removeMslAltitude(location);
        } else {
            removeExtra(location, EXTRA_MSL_ALTITUDE);
        }
    }

    public static float getMslAltitudeAccuracyMeters(Location location) {
        if (Build.VERSION.SDK_INT >= 34) {
            return Api34Impl.getMslAltitudeAccuracyMeters(location);
        }
        return getOrCreateExtras(location).getFloat(EXTRA_MSL_ALTITUDE_ACCURACY);
    }

    public static void setMslAltitudeAccuracyMeters(Location location, float f) {
        if (Build.VERSION.SDK_INT >= 34) {
            Api34Impl.setMslAltitudeAccuracyMeters(location, f);
        } else {
            getOrCreateExtras(location).putFloat(EXTRA_MSL_ALTITUDE_ACCURACY, f);
        }
    }

    public static boolean hasMslAltitudeAccuracy(Location location) {
        if (Build.VERSION.SDK_INT >= 34) {
            return Api34Impl.hasMslAltitudeAccuracy(location);
        }
        return containsExtra(location, EXTRA_MSL_ALTITUDE_ACCURACY);
    }

    public static void removeMslAltitudeAccuracy(Location location) {
        if (Build.VERSION.SDK_INT >= 34) {
            Api34Impl.removeMslAltitudeAccuracy(location);
        } else {
            removeExtra(location, EXTRA_MSL_ALTITUDE_ACCURACY);
        }
    }

    public static boolean isMock(Location location) {
        if (Build.VERSION.SDK_INT >= 31) {
            return Api31Impl.isMock(location);
        }
        return location.isFromMockProvider();
    }

    public static void setMock(Location location, boolean z) {
        try {
            getSetIsFromMockProviderMethod().invoke(location, new Object[]{Boolean.valueOf(z)});
        } catch (NoSuchMethodException e) {
            NoSuchMethodError noSuchMethodError = new NoSuchMethodError();
            noSuchMethodError.initCause(e);
            throw noSuchMethodError;
        } catch (IllegalAccessException e2) {
            IllegalAccessError illegalAccessError = new IllegalAccessError();
            illegalAccessError.initCause(e2);
            throw illegalAccessError;
        } catch (InvocationTargetException e3) {
            throw new RuntimeException(e3);
        }
    }

    private static class Api34Impl {
        private Api34Impl() {
        }

        static double getMslAltitudeMeters(Location location) {
            return location.getMslAltitudeMeters();
        }

        static void setMslAltitudeMeters(Location location, double d) {
            location.setMslAltitudeMeters(d);
        }

        static boolean hasMslAltitude(Location location) {
            return location.hasMslAltitude();
        }

        static void removeMslAltitude(Location location) {
            location.removeMslAltitude();
        }

        static float getMslAltitudeAccuracyMeters(Location location) {
            return location.getMslAltitudeAccuracyMeters();
        }

        static void setMslAltitudeAccuracyMeters(Location location, float f) {
            location.setMslAltitudeAccuracyMeters(f);
        }

        static boolean hasMslAltitudeAccuracy(Location location) {
            return location.hasMslAltitudeAccuracy();
        }

        static void removeMslAltitudeAccuracy(Location location) {
            location.removeMslAltitudeAccuracy();
        }
    }

    private static class Api33Impl {
        private Api33Impl() {
        }

        static void removeVerticalAccuracy(Location location) {
            location.removeVerticalAccuracy();
        }

        static void removeSpeedAccuracy(Location location) {
            location.removeSpeedAccuracy();
        }

        static void removeBearingAccuracy(Location location) {
            location.removeBearingAccuracy();
        }
    }

    private static class Api29Impl {
        private Api29Impl() {
        }

        static void removeVerticalAccuracy(Location location) {
            if (location.hasVerticalAccuracy()) {
                double elapsedRealtimeUncertaintyNanos = location.getElapsedRealtimeUncertaintyNanos();
                Api28Impl.removeVerticalAccuracy(location);
                location.setElapsedRealtimeUncertaintyNanos(elapsedRealtimeUncertaintyNanos);
            }
        }

        static void removeSpeedAccuracy(Location location) {
            if (location.hasSpeedAccuracy()) {
                double elapsedRealtimeUncertaintyNanos = location.getElapsedRealtimeUncertaintyNanos();
                Api28Impl.removeSpeedAccuracy(location);
                location.setElapsedRealtimeUncertaintyNanos(elapsedRealtimeUncertaintyNanos);
            }
        }

        static void removeBearingAccuracy(Location location) {
            if (location.hasBearingAccuracy()) {
                double elapsedRealtimeUncertaintyNanos = location.getElapsedRealtimeUncertaintyNanos();
                Api28Impl.removeBearingAccuracy(location);
                location.setElapsedRealtimeUncertaintyNanos(elapsedRealtimeUncertaintyNanos);
            }
        }
    }

    private static class Api28Impl {
        private Api28Impl() {
        }

        static void removeVerticalAccuracy(Location location) {
            Location location2 = location;
            if (location2.hasVerticalAccuracy()) {
                String provider = location2.getProvider();
                long time = location2.getTime();
                long elapsedRealtimeNanos = location2.getElapsedRealtimeNanos();
                double latitude = location2.getLatitude();
                double longitude = location2.getLongitude();
                boolean hasAltitude = location2.hasAltitude();
                double altitude = location2.getAltitude();
                boolean hasSpeed = location2.hasSpeed();
                float speed = location2.getSpeed();
                boolean hasBearing = location2.hasBearing();
                boolean z = hasAltitude;
                float bearing = location2.getBearing();
                boolean hasAccuracy = location2.hasAccuracy();
                boolean z2 = hasSpeed;
                float accuracy = location2.getAccuracy();
                boolean hasSpeedAccuracy = location2.hasSpeedAccuracy();
                boolean z3 = hasBearing;
                float speedAccuracyMetersPerSecond = location2.getSpeedAccuracyMetersPerSecond();
                boolean hasBearingAccuracy = location2.hasBearingAccuracy();
                float f = speedAccuracyMetersPerSecond;
                float bearingAccuracyDegrees = location2.getBearingAccuracyDegrees();
                Bundle extras = location2.getExtras();
                location2.reset();
                location2.setProvider(provider);
                location2.setTime(time);
                location2.setElapsedRealtimeNanos(elapsedRealtimeNanos);
                location2.setLatitude(latitude);
                location2.setLongitude(longitude);
                if (z) {
                    location2.setAltitude(altitude);
                }
                if (z2) {
                    location2.setSpeed(speed);
                }
                if (z3) {
                    location2.setBearing(bearing);
                }
                if (hasAccuracy) {
                    location2.setAccuracy(accuracy);
                }
                if (hasSpeedAccuracy) {
                    location2.setSpeedAccuracyMetersPerSecond(f);
                }
                if (hasBearingAccuracy) {
                    location2.setBearingAccuracyDegrees(bearingAccuracyDegrees);
                }
                if (extras != null) {
                    location2.setExtras(extras);
                }
            }
        }

        static void removeSpeedAccuracy(Location location) {
            Location location2 = location;
            if (location2.hasSpeedAccuracy()) {
                String provider = location2.getProvider();
                long time = location2.getTime();
                long elapsedRealtimeNanos = location2.getElapsedRealtimeNanos();
                double latitude = location2.getLatitude();
                double longitude = location2.getLongitude();
                boolean hasAltitude = location2.hasAltitude();
                double altitude = location2.getAltitude();
                boolean hasSpeed = location2.hasSpeed();
                float speed = location2.getSpeed();
                boolean hasBearing = location2.hasBearing();
                boolean z = hasAltitude;
                float bearing = location2.getBearing();
                boolean hasAccuracy = location2.hasAccuracy();
                boolean z2 = hasSpeed;
                float accuracy = location2.getAccuracy();
                boolean hasVerticalAccuracy = location2.hasVerticalAccuracy();
                boolean z3 = hasBearing;
                float verticalAccuracyMeters = location2.getVerticalAccuracyMeters();
                boolean hasBearingAccuracy = location2.hasBearingAccuracy();
                float f = verticalAccuracyMeters;
                float bearingAccuracyDegrees = location2.getBearingAccuracyDegrees();
                Bundle extras = location2.getExtras();
                location2.reset();
                location2.setProvider(provider);
                location2.setTime(time);
                location2.setElapsedRealtimeNanos(elapsedRealtimeNanos);
                location2.setLatitude(latitude);
                location2.setLongitude(longitude);
                if (z) {
                    location2.setAltitude(altitude);
                }
                if (z2) {
                    location2.setSpeed(speed);
                }
                if (z3) {
                    location2.setBearing(bearing);
                }
                if (hasAccuracy) {
                    location2.setAccuracy(accuracy);
                }
                if (hasVerticalAccuracy) {
                    location2.setVerticalAccuracyMeters(f);
                }
                if (hasBearingAccuracy) {
                    location2.setBearingAccuracyDegrees(bearingAccuracyDegrees);
                }
                if (extras != null) {
                    location2.setExtras(extras);
                }
            }
        }

        static void removeBearingAccuracy(Location location) {
            Location location2 = location;
            if (location2.hasBearingAccuracy()) {
                String provider = location2.getProvider();
                long time = location2.getTime();
                long elapsedRealtimeNanos = location2.getElapsedRealtimeNanos();
                double latitude = location2.getLatitude();
                double longitude = location2.getLongitude();
                boolean hasAltitude = location2.hasAltitude();
                double altitude = location2.getAltitude();
                boolean hasSpeed = location2.hasSpeed();
                float speed = location2.getSpeed();
                boolean hasBearing = location2.hasBearing();
                boolean z = hasAltitude;
                float bearing = location2.getBearing();
                boolean hasAccuracy = location2.hasAccuracy();
                boolean z2 = hasSpeed;
                float accuracy = location2.getAccuracy();
                boolean hasVerticalAccuracy = location2.hasVerticalAccuracy();
                boolean z3 = hasBearing;
                float verticalAccuracyMeters = location2.getVerticalAccuracyMeters();
                boolean hasSpeedAccuracy = location2.hasSpeedAccuracy();
                float f = verticalAccuracyMeters;
                float speedAccuracyMetersPerSecond = location2.getSpeedAccuracyMetersPerSecond();
                Bundle extras = location2.getExtras();
                location2.reset();
                location2.setProvider(provider);
                location2.setTime(time);
                location2.setElapsedRealtimeNanos(elapsedRealtimeNanos);
                location2.setLatitude(latitude);
                location2.setLongitude(longitude);
                if (z) {
                    location2.setAltitude(altitude);
                }
                if (z2) {
                    location2.setSpeed(speed);
                }
                if (z3) {
                    location2.setBearing(bearing);
                }
                if (hasAccuracy) {
                    location2.setAccuracy(accuracy);
                }
                if (hasVerticalAccuracy) {
                    location2.setVerticalAccuracyMeters(f);
                }
                if (hasSpeedAccuracy) {
                    location2.setBearingAccuracyDegrees(speedAccuracyMetersPerSecond);
                }
                if (extras != null) {
                    location2.setExtras(extras);
                }
            }
        }
    }

    private static class Api26Impl {
        private Api26Impl() {
        }

        static boolean hasVerticalAccuracy(Location location) {
            return location.hasVerticalAccuracy();
        }

        static float getVerticalAccuracyMeters(Location location) {
            return location.getVerticalAccuracyMeters();
        }

        static void setVerticalAccuracyMeters(Location location, float f) {
            location.setVerticalAccuracyMeters(f);
        }

        static void removeVerticalAccuracy(Location location) {
            try {
                LocationCompat.getFieldsMaskField().setByte(location, (byte) (LocationCompat.getFieldsMaskField().getByte(location) & (~LocationCompat.getHasVerticalAccuracyMask())));
            } catch (IllegalAccessException | NoSuchFieldException e) {
                IllegalAccessError illegalAccessError = new IllegalAccessError();
                illegalAccessError.initCause(e);
                throw illegalAccessError;
            }
        }

        static boolean hasSpeedAccuracy(Location location) {
            return location.hasSpeedAccuracy();
        }

        static float getSpeedAccuracyMetersPerSecond(Location location) {
            return location.getSpeedAccuracyMetersPerSecond();
        }

        static void setSpeedAccuracyMetersPerSecond(Location location, float f) {
            location.setSpeedAccuracyMetersPerSecond(f);
        }

        static void removeSpeedAccuracy(Location location) {
            try {
                LocationCompat.getFieldsMaskField().setByte(location, (byte) (LocationCompat.getFieldsMaskField().getByte(location) & (~LocationCompat.getHasSpeedAccuracyMask())));
            } catch (NoSuchFieldException e) {
                NoSuchFieldError noSuchFieldError = new NoSuchFieldError();
                noSuchFieldError.initCause(e);
                throw noSuchFieldError;
            } catch (IllegalAccessException e2) {
                IllegalAccessError illegalAccessError = new IllegalAccessError();
                illegalAccessError.initCause(e2);
                throw illegalAccessError;
            }
        }

        static boolean hasBearingAccuracy(Location location) {
            return location.hasBearingAccuracy();
        }

        static float getBearingAccuracyDegrees(Location location) {
            return location.getBearingAccuracyDegrees();
        }

        static void setBearingAccuracyDegrees(Location location, float f) {
            location.setBearingAccuracyDegrees(f);
        }

        static void removeBearingAccuracy(Location location) {
            try {
                LocationCompat.getFieldsMaskField().setByte(location, (byte) (LocationCompat.getFieldsMaskField().getByte(location) & (~LocationCompat.getHasBearingAccuracyMask())));
            } catch (NoSuchFieldException e) {
                NoSuchFieldError noSuchFieldError = new NoSuchFieldError();
                noSuchFieldError.initCause(e);
                throw noSuchFieldError;
            } catch (IllegalAccessException e2) {
                IllegalAccessError illegalAccessError = new IllegalAccessError();
                illegalAccessError.initCause(e2);
                throw illegalAccessError;
            }
        }
    }

    private static Method getSetIsFromMockProviderMethod() throws NoSuchMethodException {
        if (sSetIsFromMockProviderMethod == null) {
            Method declaredMethod = Location.class.getDeclaredMethod("setIsFromMockProvider", new Class[]{Boolean.TYPE});
            sSetIsFromMockProviderMethod = declaredMethod;
            declaredMethod.setAccessible(true);
        }
        return sSetIsFromMockProviderMethod;
    }

    static Field getFieldsMaskField() throws NoSuchFieldException {
        if (sFieldsMaskField == null) {
            Field declaredField = Location.class.getDeclaredField("mFieldsMask");
            sFieldsMaskField = declaredField;
            declaredField.setAccessible(true);
        }
        return sFieldsMaskField;
    }

    static int getHasSpeedAccuracyMask() throws NoSuchFieldException, IllegalAccessException {
        if (sHasSpeedAccuracyMask == null) {
            Field declaredField = Location.class.getDeclaredField("HAS_SPEED_ACCURACY_MASK");
            declaredField.setAccessible(true);
            sHasSpeedAccuracyMask = Integer.valueOf(declaredField.getInt((Object) null));
        }
        return sHasSpeedAccuracyMask.intValue();
    }

    static int getHasBearingAccuracyMask() throws NoSuchFieldException, IllegalAccessException {
        if (sHasBearingAccuracyMask == null) {
            Field declaredField = Location.class.getDeclaredField("HAS_BEARING_ACCURACY_MASK");
            declaredField.setAccessible(true);
            sHasBearingAccuracyMask = Integer.valueOf(declaredField.getInt((Object) null));
        }
        return sHasBearingAccuracyMask.intValue();
    }

    static int getHasVerticalAccuracyMask() throws NoSuchFieldException, IllegalAccessException {
        if (sHasVerticalAccuracyMask == null) {
            Field declaredField = Location.class.getDeclaredField("HAS_VERTICAL_ACCURACY_MASK");
            declaredField.setAccessible(true);
            sHasVerticalAccuracyMask = Integer.valueOf(declaredField.getInt((Object) null));
        }
        return sHasVerticalAccuracyMask.intValue();
    }

    private static Bundle getOrCreateExtras(Location location) {
        Bundle extras = location.getExtras();
        if (extras != null) {
            return extras;
        }
        location.setExtras(new Bundle());
        return location.getExtras();
    }

    private static boolean containsExtra(Location location, String str) {
        Bundle extras = location.getExtras();
        return extras != null && extras.containsKey(str);
    }

    private static void removeExtra(Location location, String str) {
        Bundle extras = location.getExtras();
        if (extras != null) {
            extras.remove(str);
            if (extras.isEmpty()) {
                location.setExtras((Bundle) null);
            }
        }
    }

    static class Api31Impl {
        private Api31Impl() {
        }

        static boolean isMock(Location location) {
            return location.isMock();
        }
    }
}
