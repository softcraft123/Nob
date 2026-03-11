package androidx.datastore.preferences.core;

import androidx.datastore.preferences.core.Preferences;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0000\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\b\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B+\b\u0000\u0012\u0018\b\u0002\u0010\u0002\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0018\u0010\r\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0004\u0012\u0004\u0012\u00020\u00050\u000eH\u0016J\r\u0010\u000f\u001a\u00020\u0010H\u0000¢\u0006\u0002\b\u0011J\u0006\u0010\u0012\u001a\u00020\u0010J\u001d\u0010\u0013\u001a\u00020\u0007\"\u0004\b\u0000\u0010\u00142\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u0002H\u00140\u0004H\u0002J\u0013\u0010\u0016\u001a\u00020\u00072\b\u0010\u0017\u001a\u0004\u0018\u00010\u0005H\u0002J\r\u0010\u0018\u001a\u00020\u0010H\u0000¢\u0006\u0002\b\u0019J$\u0010\u001a\u001a\u0004\u0018\u0001H\u0014\"\u0004\b\u0000\u0010\u00142\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u0002H\u00140\u0004H\u0002¢\u0006\u0002\u0010\u001bJ\b\u0010\u001c\u001a\u00020\u001dH\u0016J\u0015\u0010\u001e\u001a\u00020\u00102\n\u0010\u0015\u001a\u0006\u0012\u0002\b\u00030\u0004H\u0002J\u0011\u0010\u001f\u001a\u00020\u00102\u0006\u0010 \u001a\u00020\u0001H\u0002J\u0015\u0010\u001f\u001a\u00020\u00102\n\u0010!\u001a\u0006\u0012\u0002\b\u00030\"H\u0002J'\u0010#\u001a\u00020\u00102\u001a\u0010$\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\"0%\"\u0006\u0012\u0002\b\u00030\"¢\u0006\u0002\u0010&J\u001f\u0010'\u001a\u0002H\u0014\"\u0004\b\u0000\u0010\u00142\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u0002H\u00140\u0004¢\u0006\u0002\u0010\u001bJ*\u0010(\u001a\u00020\u0010\"\u0004\b\u0000\u0010\u00142\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u0002H\u00140\u00042\u0006\u0010)\u001a\u0002H\u0014H\u0002¢\u0006\u0002\u0010*J#\u0010+\u001a\u00020\u00102\n\u0010\u0015\u001a\u0006\u0012\u0002\b\u00030\u00042\b\u0010)\u001a\u0004\u0018\u00010\u0005H\u0000¢\u0006\u0002\b,J\b\u0010-\u001a\u00020.H\u0016R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R$\u0010\u0002\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0004\u0012\u0004\u0012\u00020\u00050\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006/"}, d2 = {"Landroidx/datastore/preferences/core/MutablePreferences;", "Landroidx/datastore/preferences/core/Preferences;", "preferencesMap", "", "Landroidx/datastore/preferences/core/Preferences$Key;", "", "startFrozen", "", "(Ljava/util/Map;Z)V", "frozen", "Landroidx/datastore/preferences/core/AtomicBoolean;", "getPreferencesMap$datastore_preferences_core_release", "()Ljava/util/Map;", "asMap", "", "checkNotFrozen", "", "checkNotFrozen$datastore_preferences_core_release", "clear", "contains", "T", "key", "equals", "other", "freeze", "freeze$datastore_preferences_core_release", "get", "(Landroidx/datastore/preferences/core/Preferences$Key;)Ljava/lang/Object;", "hashCode", "", "minusAssign", "plusAssign", "prefs", "pair", "Landroidx/datastore/preferences/core/Preferences$Pair;", "putAll", "pairs", "", "([Landroidx/datastore/preferences/core/Preferences$Pair;)V", "remove", "set", "value", "(Landroidx/datastore/preferences/core/Preferences$Key;Ljava/lang/Object;)V", "setUnchecked", "setUnchecked$datastore_preferences_core_release", "toString", "", "datastore-preferences-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: Preferences.kt */
public final class MutablePreferences extends Preferences {
    private final AtomicBoolean frozen;
    private final Map<Preferences.Key<?>, Object> preferencesMap;

    public MutablePreferences() {
        this((Map) null, false, 3, (DefaultConstructorMarker) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ MutablePreferences(Map map, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new LinkedHashMap() : map, (i & 2) != 0 ? true : z);
    }

    public final Map<Preferences.Key<?>, Object> getPreferencesMap$datastore_preferences_core_release() {
        return this.preferencesMap;
    }

    public MutablePreferences(Map<Preferences.Key<?>, Object> map, boolean z) {
        Intrinsics.checkNotNullParameter(map, "preferencesMap");
        this.preferencesMap = map;
        this.frozen = new AtomicBoolean(z);
    }

    public final void checkNotFrozen$datastore_preferences_core_release() {
        if (this.frozen.get()) {
            throw new IllegalStateException("Do mutate preferences once returned to DataStore.".toString());
        }
    }

    public final void freeze$datastore_preferences_core_release() {
        this.frozen.set(true);
    }

    public <T> boolean contains(Preferences.Key<T> key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return this.preferencesMap.containsKey(key);
    }

    public <T> T get(Preferences.Key<T> key) {
        Intrinsics.checkNotNullParameter(key, "key");
        T t = this.preferencesMap.get(key);
        if (!(t instanceof byte[])) {
            return t;
        }
        byte[] bArr = (byte[]) t;
        Object copyOf = Arrays.copyOf(bArr, bArr.length);
        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, size)");
        return copyOf;
    }

    public Map<Preferences.Key<?>, Object> asMap() {
        Pair pair;
        Iterable<Map.Entry> entrySet = this.preferencesMap.entrySet();
        Map linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(entrySet, 10)), 16));
        for (Map.Entry entry : entrySet) {
            Object value = entry.getValue();
            if (value instanceof byte[]) {
                Object key = entry.getKey();
                byte[] bArr = (byte[]) value;
                byte[] copyOf = Arrays.copyOf(bArr, bArr.length);
                Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, size)");
                pair = new Pair(key, copyOf);
            } else {
                pair = new Pair(entry.getKey(), entry.getValue());
            }
            linkedHashMap.put(pair.getFirst(), pair.getSecond());
        }
        return Actual_jvmAndroidKt.immutableMap(linkedHashMap);
    }

    public final <T> void set(Preferences.Key<T> key, T t) {
        Intrinsics.checkNotNullParameter(key, "key");
        setUnchecked$datastore_preferences_core_release(key, t);
    }

    public final void setUnchecked$datastore_preferences_core_release(Preferences.Key<?> key, Object obj) {
        Intrinsics.checkNotNullParameter(key, "key");
        checkNotFrozen$datastore_preferences_core_release();
        if (obj == null) {
            remove(key);
        } else if (obj instanceof Set) {
            this.preferencesMap.put(key, Actual_jvmAndroidKt.immutableCopyOfSet((Set) obj));
        } else if (obj instanceof byte[]) {
            Map<Preferences.Key<?>, Object> map = this.preferencesMap;
            byte[] bArr = (byte[]) obj;
            byte[] copyOf = Arrays.copyOf(bArr, bArr.length);
            Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, size)");
            map.put(key, copyOf);
        } else {
            this.preferencesMap.put(key, obj);
        }
    }

    public final void plusAssign(Preferences preferences) {
        Intrinsics.checkNotNullParameter(preferences, "prefs");
        checkNotFrozen$datastore_preferences_core_release();
        this.preferencesMap.putAll(preferences.asMap());
    }

    public final void plusAssign(Preferences.Pair<?> pair) {
        Intrinsics.checkNotNullParameter(pair, "pair");
        checkNotFrozen$datastore_preferences_core_release();
        putAll(pair);
    }

    public final void minusAssign(Preferences.Key<?> key) {
        Intrinsics.checkNotNullParameter(key, "key");
        checkNotFrozen$datastore_preferences_core_release();
        remove(key);
    }

    public final void putAll(Preferences.Pair<?>... pairArr) {
        Intrinsics.checkNotNullParameter(pairArr, "pairs");
        checkNotFrozen$datastore_preferences_core_release();
        for (Preferences.Pair<?> pair : pairArr) {
            setUnchecked$datastore_preferences_core_release(pair.getKey$datastore_preferences_core_release(), pair.getValue$datastore_preferences_core_release());
        }
    }

    public final <T> T remove(Preferences.Key<T> key) {
        Intrinsics.checkNotNullParameter(key, "key");
        checkNotFrozen$datastore_preferences_core_release();
        return this.preferencesMap.remove(key);
    }

    public final void clear() {
        checkNotFrozen$datastore_preferences_core_release();
        this.preferencesMap.clear();
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x0066 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(java.lang.Object r6) {
        /*
            r5 = this;
            boolean r0 = r6 instanceof androidx.datastore.preferences.core.MutablePreferences
            r1 = 0
            if (r0 != 0) goto L_0x0006
            return r1
        L_0x0006:
            androidx.datastore.preferences.core.MutablePreferences r6 = (androidx.datastore.preferences.core.MutablePreferences) r6
            java.util.Map<androidx.datastore.preferences.core.Preferences$Key<?>, java.lang.Object> r0 = r6.preferencesMap
            java.util.Map<androidx.datastore.preferences.core.Preferences$Key<?>, java.lang.Object> r2 = r5.preferencesMap
            r3 = 1
            if (r0 != r2) goto L_0x0010
            return r3
        L_0x0010:
            int r0 = r0.size()
            java.util.Map<androidx.datastore.preferences.core.Preferences$Key<?>, java.lang.Object> r2 = r5.preferencesMap
            int r2 = r2.size()
            if (r0 == r2) goto L_0x001d
            return r1
        L_0x001d:
            java.util.Map<androidx.datastore.preferences.core.Preferences$Key<?>, java.lang.Object> r6 = r6.preferencesMap
            boolean r0 = r6.isEmpty()
            if (r0 == 0) goto L_0x0026
            return r3
        L_0x0026:
            java.util.Set r6 = r6.entrySet()
            java.util.Iterator r6 = r6.iterator()
        L_0x002e:
            boolean r0 = r6.hasNext()
            if (r0 == 0) goto L_0x0067
            java.lang.Object r0 = r6.next()
            java.util.Map$Entry r0 = (java.util.Map.Entry) r0
            java.util.Map<androidx.datastore.preferences.core.Preferences$Key<?>, java.lang.Object> r2 = r5.preferencesMap
            java.lang.Object r4 = r0.getKey()
            java.lang.Object r2 = r2.get(r4)
            if (r2 == 0) goto L_0x0063
            java.lang.Object r0 = r0.getValue()
            boolean r4 = r0 instanceof byte[]
            if (r4 == 0) goto L_0x005e
            boolean r4 = r2 instanceof byte[]
            if (r4 == 0) goto L_0x0063
            byte[] r0 = (byte[]) r0
            byte[] r2 = (byte[]) r2
            boolean r0 = java.util.Arrays.equals(r0, r2)
            if (r0 == 0) goto L_0x0063
            r0 = r3
            goto L_0x0064
        L_0x005e:
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r2)
            goto L_0x0064
        L_0x0063:
            r0 = r1
        L_0x0064:
            if (r0 != 0) goto L_0x002e
            return r1
        L_0x0067:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.core.MutablePreferences.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        int i;
        int i2 = 0;
        for (Map.Entry value : this.preferencesMap.entrySet()) {
            Object value2 = value.getValue();
            if (value2 instanceof byte[]) {
                i = Arrays.hashCode((byte[]) value2);
            } else {
                i = value2.hashCode();
            }
            i2 += i;
        }
        return i2;
    }

    public String toString() {
        return CollectionsKt.joinToString$default(this.preferencesMap.entrySet(), ",\n", "{\n", "\n}", 0, (CharSequence) null, MutablePreferences$toString$1.INSTANCE, 24, (Object) null);
    }
}
