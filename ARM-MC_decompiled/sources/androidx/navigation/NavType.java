package androidx.navigation;

import android.os.Bundle;
import android.os.Parcelable;
import com.google.firebase.firestore.model.Values;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\u000b\b&\u0018\u0000 \u001e*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0006\u001e\u001f !\"#B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J \u0010\u000b\u001a\u0004\u0018\u00018\u00002\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\bH¦\u0002¢\u0006\u0002\u0010\u000fJ%\u0010\u0010\u001a\u00028\u00002\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\bH\u0007¢\u0006\u0002\u0010\u0012J/\u0010\u0010\u001a\u00028\u00002\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\b2\b\u0010\u0011\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0013\u001a\u00028\u0000H\u0007¢\u0006\u0002\u0010\u0014J\u0015\u0010\u0015\u001a\u00028\u00002\u0006\u0010\u0011\u001a\u00020\bH&¢\u0006\u0002\u0010\u0016J\u001d\u0010\u0015\u001a\u00028\u00002\u0006\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0017J%\u0010\u0018\u001a\u00020\u00192\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00028\u0000H&¢\u0006\u0002\u0010\u001aJ\u0015\u0010\u001b\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u001cJ\b\u0010\u001d\u001a\u00020\bH\u0016R\u0014\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\bXD¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006$"}, d2 = {"Landroidx/navigation/NavType;", "T", "", "isNullableAllowed", "", "(Z)V", "()Z", "name", "", "getName", "()Ljava/lang/String;", "get", "bundle", "Landroid/os/Bundle;", "key", "(Landroid/os/Bundle;Ljava/lang/String;)Ljava/lang/Object;", "parseAndPut", "value", "(Landroid/os/Bundle;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;", "previousValue", "(Landroid/os/Bundle;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;", "parseValue", "(Ljava/lang/String;)Ljava/lang/Object;", "(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;", "put", "", "(Landroid/os/Bundle;Ljava/lang/String;Ljava/lang/Object;)V", "serializeAsValue", "(Ljava/lang/Object;)Ljava/lang/String;", "toString", "Companion", "EnumType", "ParcelableArrayType", "ParcelableType", "SerializableArrayType", "SerializableType", "navigation-common_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: NavType.kt */
public abstract class NavType<T> {
    public static final NavType<boolean[]> BoolArrayType = new NavType$Companion$BoolArrayType$1();
    public static final NavType<Boolean> BoolType = new NavType$Companion$BoolType$1();
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final NavType<float[]> FloatArrayType = new NavType$Companion$FloatArrayType$1();
    public static final NavType<Float> FloatType = new NavType$Companion$FloatType$1();
    public static final NavType<int[]> IntArrayType = new NavType$Companion$IntArrayType$1();
    public static final NavType<Integer> IntType = new NavType$Companion$IntType$1();
    public static final NavType<long[]> LongArrayType = new NavType$Companion$LongArrayType$1();
    public static final NavType<Long> LongType = new NavType$Companion$LongType$1();
    public static final NavType<Integer> ReferenceType = new NavType$Companion$ReferenceType$1();
    public static final NavType<String[]> StringArrayType = new NavType$Companion$StringArrayType$1();
    public static final NavType<String> StringType = new NavType$Companion$StringType$1();
    private final boolean isNullableAllowed;
    private final String name = "nav_type";

    @JvmStatic
    public static NavType<?> fromArgType(String str, String str2) {
        return Companion.fromArgType(str, str2);
    }

    @JvmStatic
    public static final NavType<Object> inferFromValue(String str) {
        return Companion.inferFromValue(str);
    }

    @JvmStatic
    public static final NavType<Object> inferFromValueType(Object obj) {
        return Companion.inferFromValueType(obj);
    }

    public abstract T get(Bundle bundle, String str);

    public abstract T parseValue(String str);

    public abstract void put(Bundle bundle, String str, T t);

    public NavType(boolean z) {
        this.isNullableAllowed = z;
    }

    public boolean isNullableAllowed() {
        return this.isNullableAllowed;
    }

    public T parseValue(String str, T t) {
        Intrinsics.checkNotNullParameter(str, Values.VECTOR_MAP_VECTORS_KEY);
        return parseValue(str);
    }

    public final T parseAndPut(Bundle bundle, String str, String str2) {
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        Intrinsics.checkNotNullParameter(str, "key");
        Intrinsics.checkNotNullParameter(str2, Values.VECTOR_MAP_VECTORS_KEY);
        T parseValue = parseValue(str2);
        put(bundle, str, parseValue);
        return parseValue;
    }

    public final T parseAndPut(Bundle bundle, String str, String str2, T t) {
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        Intrinsics.checkNotNullParameter(str, "key");
        if (!bundle.containsKey(str)) {
            throw new IllegalArgumentException("There is no previous value in this bundle.");
        } else if (str2 == null) {
            return t;
        } else {
            T parseValue = parseValue(str2, t);
            put(bundle, str, parseValue);
            return parseValue;
        }
    }

    public String serializeAsValue(T t) {
        return String.valueOf(t);
    }

    public String getName() {
        return this.name;
    }

    public String toString() {
        return getName();
    }

    @Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0018\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0016\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\b\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\u0019\u001a\u0006\u0012\u0002\b\u00030\u00042\b\u0010\u001a\u001a\u0004\u0018\u00010\u00172\b\u0010\u001b\u001a\u0004\u0018\u00010\u0017H\u0017J\u0016\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00010\u00042\u0006\u0010\u001d\u001a\u00020\u0017H\u0007J\u0018\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00010\u00042\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001H\u0007R\u0018\u0010\u0003\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00048\u0006X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u00048\u0006X\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u00048\u0006X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00048\u0006X\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\u00048\u0006X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00048\u0006X\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u0010\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u00048\u0006X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u00048\u0006X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00048\u0006X\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0015\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u00160\u00048\u0006X\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u0018\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u00048\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Landroidx/navigation/NavType$Companion;", "", "()V", "BoolArrayType", "Landroidx/navigation/NavType;", "", "BoolType", "", "FloatArrayType", "", "FloatType", "", "IntArrayType", "", "IntType", "", "LongArrayType", "", "LongType", "", "ReferenceType", "StringArrayType", "", "", "StringType", "fromArgType", "type", "packageName", "inferFromValue", "value", "inferFromValueType", "navigation-common_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: NavType.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public NavType<?> fromArgType(String str, String str2) {
            if (Intrinsics.areEqual((Object) NavType.IntType.getName(), (Object) str)) {
                return NavType.IntType;
            }
            if (Intrinsics.areEqual((Object) NavType.IntArrayType.getName(), (Object) str)) {
                return NavType.IntArrayType;
            }
            if (Intrinsics.areEqual((Object) NavType.LongType.getName(), (Object) str)) {
                return NavType.LongType;
            }
            if (Intrinsics.areEqual((Object) NavType.LongArrayType.getName(), (Object) str)) {
                return NavType.LongArrayType;
            }
            if (Intrinsics.areEqual((Object) NavType.BoolType.getName(), (Object) str)) {
                return NavType.BoolType;
            }
            if (Intrinsics.areEqual((Object) NavType.BoolArrayType.getName(), (Object) str)) {
                return NavType.BoolArrayType;
            }
            if (Intrinsics.areEqual((Object) NavType.StringType.getName(), (Object) str)) {
                return NavType.StringType;
            }
            if (Intrinsics.areEqual((Object) NavType.StringArrayType.getName(), (Object) str)) {
                return NavType.StringArrayType;
            }
            if (Intrinsics.areEqual((Object) NavType.FloatType.getName(), (Object) str)) {
                return NavType.FloatType;
            }
            if (Intrinsics.areEqual((Object) NavType.FloatArrayType.getName(), (Object) str)) {
                return NavType.FloatArrayType;
            }
            if (Intrinsics.areEqual((Object) NavType.ReferenceType.getName(), (Object) str)) {
                return NavType.ReferenceType;
            }
            CharSequence charSequence = str;
            if (charSequence == null || charSequence.length() == 0) {
                return NavType.StringType;
            }
            try {
                String str3 = (!StringsKt.startsWith$default(str, ".", false, 2, (Object) null) || str2 == null) ? str : str2 + str;
                if (StringsKt.endsWith$default(str, "[]", false, 2, (Object) null)) {
                    str3 = str3.substring(0, str3.length() - 2);
                    Intrinsics.checkNotNullExpressionValue(str3, "this as java.lang.String…ing(startIndex, endIndex)");
                    Class<?> cls = Class.forName(str3);
                    if (Parcelable.class.isAssignableFrom(cls)) {
                        Intrinsics.checkNotNull(cls, "null cannot be cast to non-null type java.lang.Class<android.os.Parcelable>");
                        return new ParcelableArrayType<>(cls);
                    } else if (Serializable.class.isAssignableFrom(cls)) {
                        Intrinsics.checkNotNull(cls, "null cannot be cast to non-null type java.lang.Class<java.io.Serializable>");
                        return new SerializableArrayType<>(cls);
                    }
                } else {
                    Class<?> cls2 = Class.forName(str3);
                    if (Parcelable.class.isAssignableFrom(cls2)) {
                        Intrinsics.checkNotNull(cls2, "null cannot be cast to non-null type java.lang.Class<kotlin.Any?>");
                        return new ParcelableType<>(cls2);
                    } else if (Enum.class.isAssignableFrom(cls2)) {
                        Intrinsics.checkNotNull(cls2, "null cannot be cast to non-null type java.lang.Class<kotlin.Enum<*>>");
                        return new EnumType<>(cls2);
                    } else if (Serializable.class.isAssignableFrom(cls2)) {
                        Intrinsics.checkNotNull(cls2, "null cannot be cast to non-null type java.lang.Class<java.io.Serializable>");
                        return new SerializableType<>(cls2);
                    }
                }
                throw new IllegalArgumentException(str3 + " is not Serializable or Parcelable.");
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }

        /* JADX WARNING: Can't wrap try/catch for region: R(3:10|11|12) */
        /* JADX WARNING: Can't wrap try/catch for region: R(3:4|5|6) */
        /* JADX WARNING: Can't wrap try/catch for region: R(3:7|8|9) */
        /* JADX WARNING: Code restructure failed: missing block: B:11:?, code lost:
            androidx.navigation.NavType.BoolType.parseValue(r3);
            r3 = androidx.navigation.NavType.BoolType;
            kotlin.jvm.internal.Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type androidx.navigation.NavType<kotlin.Any>");
         */
        /* JADX WARNING: Code restructure failed: missing block: B:12:0x0032, code lost:
            return r3;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:13:0x0033, code lost:
            r3 = androidx.navigation.NavType.StringType;
            kotlin.jvm.internal.Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type androidx.navigation.NavType<kotlin.Any>");
         */
        /* JADX WARNING: Code restructure failed: missing block: B:15:0x0038, code lost:
            return r3;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:5:?, code lost:
            androidx.navigation.NavType.LongType.parseValue(r3);
            r1 = androidx.navigation.NavType.LongType;
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type androidx.navigation.NavType<kotlin.Any>");
         */
        /* JADX WARNING: Code restructure failed: missing block: B:6:0x001c, code lost:
            return r1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:8:?, code lost:
            androidx.navigation.NavType.FloatType.parseValue(r3);
            r1 = androidx.navigation.NavType.FloatType;
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type androidx.navigation.NavType<kotlin.Any>");
         */
        /* JADX WARNING: Code restructure failed: missing block: B:9:0x0027, code lost:
            return r1;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:10:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:4:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x001d */
        @kotlin.jvm.JvmStatic
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final androidx.navigation.NavType<java.lang.Object> inferFromValue(java.lang.String r3) {
            /*
                r2 = this;
                java.lang.String r0 = "null cannot be cast to non-null type androidx.navigation.NavType<kotlin.Any>"
                java.lang.String r1 = "value"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r1)
                androidx.navigation.NavType<java.lang.Integer> r1 = androidx.navigation.NavType.IntType     // Catch:{ IllegalArgumentException -> 0x0012 }
                r1.parseValue(r3)     // Catch:{ IllegalArgumentException -> 0x0012 }
                androidx.navigation.NavType<java.lang.Integer> r1 = androidx.navigation.NavType.IntType     // Catch:{ IllegalArgumentException -> 0x0012 }
                kotlin.jvm.internal.Intrinsics.checkNotNull(r1, r0)     // Catch:{ IllegalArgumentException -> 0x0012 }
                return r1
            L_0x0012:
                androidx.navigation.NavType<java.lang.Long> r1 = androidx.navigation.NavType.LongType     // Catch:{ IllegalArgumentException -> 0x001d }
                r1.parseValue(r3)     // Catch:{ IllegalArgumentException -> 0x001d }
                androidx.navigation.NavType<java.lang.Long> r1 = androidx.navigation.NavType.LongType     // Catch:{ IllegalArgumentException -> 0x001d }
                kotlin.jvm.internal.Intrinsics.checkNotNull(r1, r0)     // Catch:{ IllegalArgumentException -> 0x001d }
                return r1
            L_0x001d:
                androidx.navigation.NavType<java.lang.Float> r1 = androidx.navigation.NavType.FloatType     // Catch:{ IllegalArgumentException -> 0x0028 }
                r1.parseValue(r3)     // Catch:{ IllegalArgumentException -> 0x0028 }
                androidx.navigation.NavType<java.lang.Float> r1 = androidx.navigation.NavType.FloatType     // Catch:{ IllegalArgumentException -> 0x0028 }
                kotlin.jvm.internal.Intrinsics.checkNotNull(r1, r0)     // Catch:{ IllegalArgumentException -> 0x0028 }
                return r1
            L_0x0028:
                androidx.navigation.NavType<java.lang.Boolean> r1 = androidx.navigation.NavType.BoolType     // Catch:{ IllegalArgumentException -> 0x0033 }
                r1.parseValue(r3)     // Catch:{ IllegalArgumentException -> 0x0033 }
                androidx.navigation.NavType<java.lang.Boolean> r3 = androidx.navigation.NavType.BoolType     // Catch:{ IllegalArgumentException -> 0x0033 }
                kotlin.jvm.internal.Intrinsics.checkNotNull(r3, r0)     // Catch:{ IllegalArgumentException -> 0x0033 }
                return r3
            L_0x0033:
                androidx.navigation.NavType<java.lang.String> r3 = androidx.navigation.NavType.StringType
                kotlin.jvm.internal.Intrinsics.checkNotNull(r3, r0)
                return r3
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.navigation.NavType.Companion.inferFromValue(java.lang.String):androidx.navigation.NavType");
        }

        @JvmStatic
        public final NavType<Object> inferFromValueType(Object obj) {
            if (obj instanceof Integer) {
                NavType<Integer> navType = NavType.IntType;
                Intrinsics.checkNotNull(navType, "null cannot be cast to non-null type androidx.navigation.NavType<kotlin.Any>");
                return navType;
            } else if (obj instanceof int[]) {
                NavType<int[]> navType2 = NavType.IntArrayType;
                Intrinsics.checkNotNull(navType2, "null cannot be cast to non-null type androidx.navigation.NavType<kotlin.Any>");
                return navType2;
            } else if (obj instanceof Long) {
                NavType<Long> navType3 = NavType.LongType;
                Intrinsics.checkNotNull(navType3, "null cannot be cast to non-null type androidx.navigation.NavType<kotlin.Any>");
                return navType3;
            } else if (obj instanceof long[]) {
                NavType<long[]> navType4 = NavType.LongArrayType;
                Intrinsics.checkNotNull(navType4, "null cannot be cast to non-null type androidx.navigation.NavType<kotlin.Any>");
                return navType4;
            } else if (obj instanceof Float) {
                NavType<Float> navType5 = NavType.FloatType;
                Intrinsics.checkNotNull(navType5, "null cannot be cast to non-null type androidx.navigation.NavType<kotlin.Any>");
                return navType5;
            } else if (obj instanceof float[]) {
                NavType<float[]> navType6 = NavType.FloatArrayType;
                Intrinsics.checkNotNull(navType6, "null cannot be cast to non-null type androidx.navigation.NavType<kotlin.Any>");
                return navType6;
            } else if (obj instanceof Boolean) {
                NavType<Boolean> navType7 = NavType.BoolType;
                Intrinsics.checkNotNull(navType7, "null cannot be cast to non-null type androidx.navigation.NavType<kotlin.Any>");
                return navType7;
            } else if (obj instanceof boolean[]) {
                NavType<boolean[]> navType8 = NavType.BoolArrayType;
                Intrinsics.checkNotNull(navType8, "null cannot be cast to non-null type androidx.navigation.NavType<kotlin.Any>");
                return navType8;
            } else if ((obj instanceof String) || obj == null) {
                NavType<String> navType9 = NavType.StringType;
                Intrinsics.checkNotNull(navType9, "null cannot be cast to non-null type androidx.navigation.NavType<kotlin.Any>");
                return navType9;
            } else if (!(obj instanceof Object[]) || !(((Object[]) obj) instanceof String[])) {
                if (obj.getClass().isArray()) {
                    Class<?> componentType = obj.getClass().getComponentType();
                    Intrinsics.checkNotNull(componentType);
                    if (Parcelable.class.isAssignableFrom(componentType)) {
                        Class<?> componentType2 = obj.getClass().getComponentType();
                        Intrinsics.checkNotNull(componentType2, "null cannot be cast to non-null type java.lang.Class<android.os.Parcelable>");
                        return new ParcelableArrayType<>(componentType2);
                    }
                }
                if (obj.getClass().isArray()) {
                    Class<?> componentType3 = obj.getClass().getComponentType();
                    Intrinsics.checkNotNull(componentType3);
                    if (Serializable.class.isAssignableFrom(componentType3)) {
                        Class<?> componentType4 = obj.getClass().getComponentType();
                        Intrinsics.checkNotNull(componentType4, "null cannot be cast to non-null type java.lang.Class<java.io.Serializable>");
                        return new SerializableArrayType<>(componentType4);
                    }
                }
                if (obj instanceof Parcelable) {
                    return new ParcelableType<>(obj.getClass());
                }
                if (obj instanceof Enum) {
                    return new EnumType<>(obj.getClass());
                }
                if (obj instanceof Serializable) {
                    return new SerializableType<>(obj.getClass());
                }
                throw new IllegalArgumentException("Object of type " + obj.getClass().getName() + " is not supported for navigation arguments.");
            } else {
                NavType<String[]> navType10 = NavType.StringArrayType;
                Intrinsics.checkNotNull(navType10, "null cannot be cast to non-null type androidx.navigation.NavType<kotlin.Any>");
                return navType10;
            }
        }
    }

    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0013\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00010\u0004¢\u0006\u0002\u0010\u0005J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0002J \u0010\u000e\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0007H\u0002¢\u0006\u0002\u0010\u0012J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\u0015\u0010\u0015\u001a\u00028\u00012\u0006\u0010\u0016\u001a\u00020\u0007H\u0016¢\u0006\u0002\u0010\u0017J%\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\u001aR\u0014\u0010\u0006\u001a\u00020\u00078VX\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00010\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Landroidx/navigation/NavType$ParcelableType;", "D", "Landroidx/navigation/NavType;", "type", "Ljava/lang/Class;", "(Ljava/lang/Class;)V", "name", "", "getName", "()Ljava/lang/String;", "equals", "", "other", "", "get", "bundle", "Landroid/os/Bundle;", "key", "(Landroid/os/Bundle;Ljava/lang/String;)Ljava/lang/Object;", "hashCode", "", "parseValue", "value", "(Ljava/lang/String;)Ljava/lang/Object;", "put", "", "(Landroid/os/Bundle;Ljava/lang/String;Ljava/lang/Object;)V", "navigation-common_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: NavType.kt */
    public static final class ParcelableType<D> extends NavType<D> {
        private final Class<D> type;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ParcelableType(Class<D> cls) {
            super(true);
            Intrinsics.checkNotNullParameter(cls, "type");
            if (Parcelable.class.isAssignableFrom(cls) || Serializable.class.isAssignableFrom(cls)) {
                this.type = cls;
                return;
            }
            throw new IllegalArgumentException((cls + " does not implement Parcelable or Serializable.").toString());
        }

        public String getName() {
            String name = this.type.getName();
            Intrinsics.checkNotNullExpressionValue(name, "type.name");
            return name;
        }

        public void put(Bundle bundle, String str, D d) {
            Intrinsics.checkNotNullParameter(bundle, "bundle");
            Intrinsics.checkNotNullParameter(str, "key");
            this.type.cast(d);
            if (d == null || (d instanceof Parcelable)) {
                bundle.putParcelable(str, (Parcelable) d);
            } else if (d instanceof Serializable) {
                bundle.putSerializable(str, (Serializable) d);
            }
        }

        public D get(Bundle bundle, String str) {
            Intrinsics.checkNotNullParameter(bundle, "bundle");
            Intrinsics.checkNotNullParameter(str, "key");
            return bundle.get(str);
        }

        public D parseValue(String str) {
            Intrinsics.checkNotNullParameter(str, Values.VECTOR_MAP_VECTORS_KEY);
            throw new UnsupportedOperationException("Parcelables don't support default values.");
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || !Intrinsics.areEqual((Object) getClass(), (Object) obj.getClass())) {
                return false;
            }
            return Intrinsics.areEqual((Object) this.type, (Object) ((ParcelableType) obj).type);
        }

        public int hashCode() {
            return this.type.hashCode();
        }
    }

    @Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u0000*\b\b\u0001\u0010\u0001*\u00020\u00022\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u0002H\u0001\u0018\u00010\u00040\u0003B\u0013\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00010\u0006¢\u0006\u0002\u0010\u0007J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0002J&\u0010\u0011\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00042\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\nH\u0002¢\u0006\u0002\u0010\u0015J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\u001b\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00010\u00042\u0006\u0010\u0019\u001a\u00020\nH\u0016¢\u0006\u0002\u0010\u001aJ-\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\n2\u000e\u0010\u0019\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u0004H\u0016¢\u0006\u0002\u0010\u001dR\u001a\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00040\u0006X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u00020\n8VX\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f¨\u0006\u001e"}, d2 = {"Landroidx/navigation/NavType$ParcelableArrayType;", "D", "Landroid/os/Parcelable;", "Landroidx/navigation/NavType;", "", "type", "Ljava/lang/Class;", "(Ljava/lang/Class;)V", "arrayType", "name", "", "getName", "()Ljava/lang/String;", "equals", "", "other", "", "get", "bundle", "Landroid/os/Bundle;", "key", "(Landroid/os/Bundle;Ljava/lang/String;)[Landroid/os/Parcelable;", "hashCode", "", "parseValue", "value", "(Ljava/lang/String;)[Landroid/os/Parcelable;", "put", "", "(Landroid/os/Bundle;Ljava/lang/String;[Landroid/os/Parcelable;)V", "navigation-common_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: NavType.kt */
    public static final class ParcelableArrayType<D extends Parcelable> extends NavType<D[]> {
        private final Class<D[]> arrayType;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ParcelableArrayType(Class<D> cls) {
            super(true);
            Intrinsics.checkNotNullParameter(cls, "type");
            if (Parcelable.class.isAssignableFrom(cls)) {
                try {
                    Class<?> cls2 = Class.forName("[L" + cls.getName() + ';');
                    Intrinsics.checkNotNull(cls2, "null cannot be cast to non-null type java.lang.Class<kotlin.Array<D of androidx.navigation.NavType.ParcelableArrayType>>");
                    this.arrayType = cls2;
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
            } else {
                throw new IllegalArgumentException((cls + " does not implement Parcelable.").toString());
            }
        }

        public String getName() {
            String name = this.arrayType.getName();
            Intrinsics.checkNotNullExpressionValue(name, "arrayType.name");
            return name;
        }

        public void put(Bundle bundle, String str, D[] dArr) {
            Intrinsics.checkNotNullParameter(bundle, "bundle");
            Intrinsics.checkNotNullParameter(str, "key");
            this.arrayType.cast(dArr);
            bundle.putParcelableArray(str, dArr);
        }

        public D[] get(Bundle bundle, String str) {
            Intrinsics.checkNotNullParameter(bundle, "bundle");
            Intrinsics.checkNotNullParameter(str, "key");
            return (Parcelable[]) bundle.get(str);
        }

        public D[] parseValue(String str) {
            Intrinsics.checkNotNullParameter(str, Values.VECTOR_MAP_VECTORS_KEY);
            throw new UnsupportedOperationException("Arrays don't support default values.");
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || !Intrinsics.areEqual((Object) getClass(), (Object) obj.getClass())) {
                return false;
            }
            return Intrinsics.areEqual((Object) this.arrayType, (Object) ((ParcelableArrayType) obj).arrayType);
        }

        public int hashCode() {
            return this.arrayType.hashCode();
        }
    }

    @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0016\u0018\u0000*\b\b\u0001\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u0015\b\u0016\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00010\u0005¢\u0006\u0002\u0010\u0006B\u001d\b\u0010\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00010\u0005¢\u0006\u0002\u0010\tJ\u0013\u0010\u000e\u001a\u00020\b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0002J \u0010\u0011\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u000bH\u0002¢\u0006\u0002\u0010\u0015J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\u0015\u0010\u0018\u001a\u00028\u00012\u0006\u0010\u0019\u001a\u00020\u000bH\u0016¢\u0006\u0002\u0010\u001aJ%\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\u001dR\u0014\u0010\n\u001a\u00020\u000b8VX\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00010\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Landroidx/navigation/NavType$SerializableType;", "D", "Ljava/io/Serializable;", "Landroidx/navigation/NavType;", "type", "Ljava/lang/Class;", "(Ljava/lang/Class;)V", "nullableAllowed", "", "(ZLjava/lang/Class;)V", "name", "", "getName", "()Ljava/lang/String;", "equals", "other", "", "get", "bundle", "Landroid/os/Bundle;", "key", "(Landroid/os/Bundle;Ljava/lang/String;)Ljava/io/Serializable;", "hashCode", "", "parseValue", "value", "(Ljava/lang/String;)Ljava/io/Serializable;", "put", "", "(Landroid/os/Bundle;Ljava/lang/String;Ljava/io/Serializable;)V", "navigation-common_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: NavType.kt */
    public static class SerializableType<D extends Serializable> extends NavType<D> {
        private final Class<D> type;

        public String getName() {
            String name = this.type.getName();
            Intrinsics.checkNotNullExpressionValue(name, "type.name");
            return name;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public SerializableType(Class<D> cls) {
            super(true);
            Intrinsics.checkNotNullParameter(cls, "type");
            if (!Serializable.class.isAssignableFrom(cls)) {
                throw new IllegalArgumentException((cls + " does not implement Serializable.").toString());
            } else if (!cls.isEnum()) {
                this.type = cls;
            } else {
                throw new IllegalArgumentException((cls + " is an Enum. You should use EnumType instead.").toString());
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public SerializableType(boolean z, Class<D> cls) {
            super(z);
            Intrinsics.checkNotNullParameter(cls, "type");
            if (Serializable.class.isAssignableFrom(cls)) {
                this.type = cls;
                return;
            }
            throw new IllegalArgumentException((cls + " does not implement Serializable.").toString());
        }

        public void put(Bundle bundle, String str, D d) {
            Intrinsics.checkNotNullParameter(bundle, "bundle");
            Intrinsics.checkNotNullParameter(str, "key");
            Intrinsics.checkNotNullParameter(d, Values.VECTOR_MAP_VECTORS_KEY);
            this.type.cast(d);
            bundle.putSerializable(str, d);
        }

        public D get(Bundle bundle, String str) {
            Intrinsics.checkNotNullParameter(bundle, "bundle");
            Intrinsics.checkNotNullParameter(str, "key");
            return (Serializable) bundle.get(str);
        }

        public D parseValue(String str) {
            Intrinsics.checkNotNullParameter(str, Values.VECTOR_MAP_VECTORS_KEY);
            throw new UnsupportedOperationException("Serializables don't support default values.");
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof SerializableType)) {
                return false;
            }
            return Intrinsics.areEqual((Object) this.type, (Object) ((SerializableType) obj).type);
        }

        public int hashCode() {
            return this.type.hashCode();
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u0000*\f\b\u0001\u0010\u0001*\u0006\u0012\u0002\b\u00030\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u0013\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0015\u0010\u000b\u001a\u00028\u00012\u0006\u0010\f\u001a\u00020\bH\u0016¢\u0006\u0002\u0010\rR\u0014\u0010\u0007\u001a\u00020\b8VX\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00010\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Landroidx/navigation/NavType$EnumType;", "D", "", "Landroidx/navigation/NavType$SerializableType;", "type", "Ljava/lang/Class;", "(Ljava/lang/Class;)V", "name", "", "getName", "()Ljava/lang/String;", "parseValue", "value", "(Ljava/lang/String;)Ljava/lang/Enum;", "navigation-common_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: NavType.kt */
    public static final class EnumType<D extends Enum<?>> extends SerializableType<D> {
        private final Class<D> type;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public EnumType(Class<D> cls) {
            super(false, cls);
            Intrinsics.checkNotNullParameter(cls, "type");
            if (cls.isEnum()) {
                this.type = cls;
                return;
            }
            throw new IllegalArgumentException((cls + " is not an Enum type.").toString());
        }

        public String getName() {
            String name = this.type.getName();
            Intrinsics.checkNotNullExpressionValue(name, "type.name");
            return name;
        }

        public D parseValue(String str) {
            D d;
            Intrinsics.checkNotNullParameter(str, Values.VECTOR_MAP_VECTORS_KEY);
            D[] enumConstants = this.type.getEnumConstants();
            Intrinsics.checkNotNullExpressionValue(enumConstants, "type.enumConstants");
            int length = enumConstants.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    d = null;
                    break;
                }
                d = enumConstants[i];
                if (StringsKt.equals(((Enum) d).name(), str, true)) {
                    break;
                }
                i++;
            }
            D d2 = (Enum) d;
            if (d2 != null) {
                return d2;
            }
            throw new IllegalArgumentException("Enum value " + str + " not found for type " + this.type.getName() + '.');
        }
    }

    @Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u0000*\b\b\u0001\u0010\u0001*\u00020\u00022\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u0002H\u0001\u0018\u00010\u00040\u0003B\u0013\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00010\u0006¢\u0006\u0002\u0010\u0007J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0002J&\u0010\u0011\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00042\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\nH\u0002¢\u0006\u0002\u0010\u0015J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\u001b\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00010\u00042\u0006\u0010\u0019\u001a\u00020\nH\u0016¢\u0006\u0002\u0010\u001aJ-\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\n2\u000e\u0010\u0019\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u0004H\u0016¢\u0006\u0002\u0010\u001dR\u001a\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00040\u0006X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u00020\n8VX\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f¨\u0006\u001e"}, d2 = {"Landroidx/navigation/NavType$SerializableArrayType;", "D", "Ljava/io/Serializable;", "Landroidx/navigation/NavType;", "", "type", "Ljava/lang/Class;", "(Ljava/lang/Class;)V", "arrayType", "name", "", "getName", "()Ljava/lang/String;", "equals", "", "other", "", "get", "bundle", "Landroid/os/Bundle;", "key", "(Landroid/os/Bundle;Ljava/lang/String;)[Ljava/io/Serializable;", "hashCode", "", "parseValue", "value", "(Ljava/lang/String;)[Ljava/io/Serializable;", "put", "", "(Landroid/os/Bundle;Ljava/lang/String;[Ljava/io/Serializable;)V", "navigation-common_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: NavType.kt */
    public static final class SerializableArrayType<D extends Serializable> extends NavType<D[]> {
        private final Class<D[]> arrayType;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public SerializableArrayType(Class<D> cls) {
            super(true);
            Intrinsics.checkNotNullParameter(cls, "type");
            if (Serializable.class.isAssignableFrom(cls)) {
                try {
                    Class<?> cls2 = Class.forName("[L" + cls.getName() + ';');
                    Intrinsics.checkNotNull(cls2, "null cannot be cast to non-null type java.lang.Class<kotlin.Array<D of androidx.navigation.NavType.SerializableArrayType>>");
                    this.arrayType = cls2;
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
            } else {
                throw new IllegalArgumentException((cls + " does not implement Serializable.").toString());
            }
        }

        public String getName() {
            String name = this.arrayType.getName();
            Intrinsics.checkNotNullExpressionValue(name, "arrayType.name");
            return name;
        }

        public void put(Bundle bundle, String str, D[] dArr) {
            Intrinsics.checkNotNullParameter(bundle, "bundle");
            Intrinsics.checkNotNullParameter(str, "key");
            this.arrayType.cast(dArr);
            bundle.putSerializable(str, (Serializable) dArr);
        }

        public D[] get(Bundle bundle, String str) {
            Intrinsics.checkNotNullParameter(bundle, "bundle");
            Intrinsics.checkNotNullParameter(str, "key");
            return (Serializable[]) bundle.get(str);
        }

        public D[] parseValue(String str) {
            Intrinsics.checkNotNullParameter(str, Values.VECTOR_MAP_VECTORS_KEY);
            throw new UnsupportedOperationException("Arrays don't support default values.");
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || !Intrinsics.areEqual((Object) getClass(), (Object) obj.getClass())) {
                return false;
            }
            return Intrinsics.areEqual((Object) this.arrayType, (Object) ((SerializableArrayType) obj).arrayType);
        }

        public int hashCode() {
            return this.arrayType.hashCode();
        }
    }
}
