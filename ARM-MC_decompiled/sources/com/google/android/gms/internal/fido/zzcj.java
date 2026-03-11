package com.google.android.gms.internal.fido;

import java.util.Collection;
import java.util.Comparator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.Set;
import java.util.SortedMap;
import javax.annotation.CheckForNull;

/* compiled from: com.google.android.gms:play-services-fido@@21.0.0 */
public final class zzcj extends zzcd implements NavigableMap {
    private static final Comparator zzb;
    private static final zzcj zzc;
    /* access modifiers changed from: private */
    public final transient zzcv zzd;
    /* access modifiers changed from: private */
    public final transient zzcc zze;
    @CheckForNull
    private final transient zzcj zzf;

    static {
        zzcq zzcq = zzcq.zza;
        zzb = zzcq;
        zzcv zzs = zzck.zzs(zzcq);
        int i = zzcc.zzd;
        zzc = new zzcj(zzs, zzct.zza, (zzcj) null);
    }

    zzcj(zzcv zzcv, zzcc zzcc, @CheckForNull zzcj zzcj) {
        this.zzd = zzcv;
        this.zze = zzcc;
        this.zzf = zzcj;
    }

    /* JADX WARNING: type inference failed for: r11v0, types: [java.util.Map, java.util.SortedMap] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.android.gms.internal.fido.zzcj zzf(java.util.Map r11) {
        /*
            java.util.Comparator r0 = zzb
            java.util.Comparator r1 = r11.comparator()
            r2 = 1
            if (r1 != 0) goto L_0x000b
            r1 = r2
            goto L_0x000f
        L_0x000b:
            boolean r1 = r0.equals(r1)
        L_0x000f:
            java.util.Set r11 = r11.entrySet()
            java.util.Map$Entry[] r3 = zza
            boolean r4 = r11 instanceof java.util.Collection
            if (r4 != 0) goto L_0x0034
            java.util.Iterator r11 = r11.iterator()
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
            r11.getClass()
        L_0x0025:
            boolean r5 = r11.hasNext()
            if (r5 == 0) goto L_0x0033
            java.lang.Object r5 = r11.next()
            r4.add(r5)
            goto L_0x0025
        L_0x0033:
            r11 = r4
        L_0x0034:
            java.lang.Object[] r11 = r11.toArray(r3)
            java.util.Map$Entry[] r11 = (java.util.Map.Entry[]) r11
            int r3 = r11.length
            if (r3 == 0) goto L_0x010b
            r4 = 0
            r5 = 0
            if (r3 == r2) goto L_0x00e8
            java.lang.Object[] r6 = new java.lang.Object[r3]
            java.lang.Object[] r7 = new java.lang.Object[r3]
            if (r1 == 0) goto L_0x0063
        L_0x0047:
            if (r5 >= r3) goto L_0x00d5
            r1 = r11[r5]
            java.lang.Object r1 = java.util.Objects.requireNonNull(r1)
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1
            java.lang.Object r2 = r1.getKey()
            java.lang.Object r1 = r1.getValue()
            com.google.android.gms.internal.fido.zzbv.zza(r2, r1)
            r6[r5] = r2
            r7[r5] = r1
            int r5 = r5 + 1
            goto L_0x0047
        L_0x0063:
            com.google.android.gms.internal.fido.zzcg r1 = new com.google.android.gms.internal.fido.zzcg
            r1.<init>(r0)
            java.util.Arrays.sort(r11, r5, r3, r1)
            r1 = r11[r5]
            java.lang.Object r1 = java.util.Objects.requireNonNull(r1)
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1
            java.lang.Object r8 = r1.getKey()
            r6[r5] = r8
            java.lang.Object r1 = r1.getValue()
            r7[r5] = r1
            r5 = r6[r5]
            com.google.android.gms.internal.fido.zzbv.zza(r5, r1)
        L_0x0084:
            if (r2 >= r3) goto L_0x00d5
            int r1 = r2 + -1
            r1 = r11[r1]
            java.lang.Object r1 = java.util.Objects.requireNonNull(r1)
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1
            r5 = r11[r2]
            java.lang.Object r5 = java.util.Objects.requireNonNull(r5)
            java.util.Map$Entry r5 = (java.util.Map.Entry) r5
            java.lang.Object r9 = r5.getKey()
            java.lang.Object r10 = r5.getValue()
            com.google.android.gms.internal.fido.zzbv.zza(r9, r10)
            r6[r2] = r9
            r7[r2] = r10
            int r8 = r0.compare(r8, r9)
            if (r8 == 0) goto L_0x00b1
            int r2 = r2 + 1
            r8 = r9
            goto L_0x0084
        L_0x00b1:
            java.lang.IllegalArgumentException r11 = new java.lang.IllegalArgumentException
            java.lang.String r0 = java.lang.String.valueOf(r1)
            java.lang.String r1 = java.lang.String.valueOf(r5)
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "Multiple entries with same key: "
            r2.<init>(r3)
            r2.append(r0)
            java.lang.String r0 = " and "
            r2.append(r0)
            r2.append(r1)
            java.lang.String r0 = r2.toString()
            r11.<init>(r0)
            throw r11
        L_0x00d5:
            com.google.android.gms.internal.fido.zzcj r11 = new com.google.android.gms.internal.fido.zzcj
            com.google.android.gms.internal.fido.zzcv r1 = new com.google.android.gms.internal.fido.zzcv
            com.google.android.gms.internal.fido.zzcc r2 = com.google.android.gms.internal.fido.zzcc.zzh(r6, r3)
            r1.<init>(r2, r0)
            com.google.android.gms.internal.fido.zzcc r0 = com.google.android.gms.internal.fido.zzcc.zzh(r7, r3)
            r11.<init>(r1, r0, r4)
            return r11
        L_0x00e8:
            r11 = r11[r5]
            java.lang.Object r11 = java.util.Objects.requireNonNull(r11)
            java.util.Map$Entry r11 = (java.util.Map.Entry) r11
            java.lang.Object r1 = r11.getKey()
            java.lang.Object r11 = r11.getValue()
            com.google.android.gms.internal.fido.zzcj r2 = new com.google.android.gms.internal.fido.zzcj
            com.google.android.gms.internal.fido.zzcv r3 = new com.google.android.gms.internal.fido.zzcv
            com.google.android.gms.internal.fido.zzcc r1 = com.google.android.gms.internal.fido.zzcc.zzj(r1)
            r3.<init>(r1, r0)
            com.google.android.gms.internal.fido.zzcc r11 = com.google.android.gms.internal.fido.zzcc.zzj(r11)
            r2.<init>(r3, r11, r4)
            return r2
        L_0x010b:
            com.google.android.gms.internal.fido.zzcj r11 = zzg(r0)
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.fido.zzcj.zzf(java.util.Map):com.google.android.gms.internal.fido.zzcj");
    }

    static zzcj zzg(Comparator comparator) {
        if (zzcq.zza.equals(comparator)) {
            return zzc;
        }
        zzcv zzs = zzck.zzs(comparator);
        int i = zzcc.zzd;
        return new zzcj(zzs, zzct.zza, (zzcj) null);
    }

    private final zzcj zzl(int i, int i2) {
        if (i == 0) {
            if (i2 == this.zze.size()) {
                return this;
            }
            i = 0;
        }
        if (i == i2) {
            return zzg(this.zzd.zza);
        }
        return new zzcj(this.zzd.zzw(i, i2), this.zze.subList(i, i2), (zzcj) null);
    }

    @CheckForNull
    public final Map.Entry ceilingEntry(Object obj) {
        return tailMap(obj, true).firstEntry();
    }

    @CheckForNull
    public final Object ceilingKey(Object obj) {
        return zzco.zza(ceilingEntry(obj));
    }

    public final Comparator comparator() {
        return this.zzd.zza;
    }

    public final /* synthetic */ NavigableSet descendingKeySet() {
        return this.zzd.descendingSet();
    }

    public final /* bridge */ /* synthetic */ NavigableMap descendingMap() {
        zzcs zzcs;
        zzcj zzcj = this.zzf;
        if (zzcj != null) {
            return zzcj;
        }
        if (!isEmpty()) {
            return new zzcj((zzcv) this.zzd.descendingSet(), this.zze.zzf(), this);
        }
        Comparator comparator = this.zzd.zza;
        if (comparator instanceof zzcs) {
            zzcs = (zzcs) comparator;
        } else {
            zzcs = new zzbw(comparator);
        }
        return zzg(zzcs.zza());
    }

    public final /* bridge */ /* synthetic */ Set entrySet() {
        return entrySet();
    }

    @CheckForNull
    public final Map.Entry firstEntry() {
        if (isEmpty()) {
            return null;
        }
        return (Map.Entry) entrySet().zzi().get(0);
    }

    public final Object firstKey() {
        return this.zzd.first();
    }

    @CheckForNull
    public final Map.Entry floorEntry(Object obj) {
        return headMap(obj, true).lastEntry();
    }

    @CheckForNull
    public final Object floorKey(Object obj) {
        return zzco.zza(floorEntry(obj));
    }

    public final /* synthetic */ SortedMap headMap(Object obj) {
        return headMap(obj, false);
    }

    @CheckForNull
    public final Map.Entry higherEntry(Object obj) {
        return tailMap(obj, false).firstEntry();
    }

    @CheckForNull
    public final Object higherKey(Object obj) {
        return zzco.zza(higherEntry(obj));
    }

    public final /* synthetic */ Set keySet() {
        return this.zzd;
    }

    @CheckForNull
    public final Map.Entry lastEntry() {
        if (isEmpty()) {
            return null;
        }
        return (Map.Entry) entrySet().zzi().get(this.zze.size() - 1);
    }

    public final Object lastKey() {
        return this.zzd.last();
    }

    @CheckForNull
    public final Map.Entry lowerEntry(Object obj) {
        return headMap(obj, false).lastEntry();
    }

    @CheckForNull
    public final Object lowerKey(Object obj) {
        return zzco.zza(lowerEntry(obj));
    }

    public final /* synthetic */ NavigableSet navigableKeySet() {
        return this.zzd;
    }

    @CheckForNull
    @Deprecated
    public final Map.Entry pollFirstEntry() {
        throw new UnsupportedOperationException();
    }

    @CheckForNull
    @Deprecated
    public final Map.Entry pollLastEntry() {
        throw new UnsupportedOperationException();
    }

    public final int size() {
        return this.zze.size();
    }

    public final /* bridge */ /* synthetic */ SortedMap subMap(Object obj, Object obj2) {
        return subMap(obj, true, obj2, false);
    }

    public final /* synthetic */ SortedMap tailMap(Object obj) {
        return tailMap(obj, true);
    }

    public final /* synthetic */ Collection values() {
        return this.zze;
    }

    public final zzby zza() {
        return this.zze;
    }

    /* access modifiers changed from: package-private */
    public final zzcf zzb() {
        if (isEmpty()) {
            return zzcu.zza;
        }
        return new zzci(this);
    }

    public final /* synthetic */ zzcf zzd() {
        return this.zzd;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x000f, code lost:
        if (r4 < 0) goto L_0x0005;
     */
    @javax.annotation.CheckForNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object get(@javax.annotation.CheckForNull java.lang.Object r4) {
        /*
            r3 = this;
            com.google.android.gms.internal.fido.zzcv r0 = r3.zzd
            r1 = -1
            if (r4 != 0) goto L_0x0007
        L_0x0005:
            r4 = r1
            goto L_0x0012
        L_0x0007:
            com.google.android.gms.internal.fido.zzcc r2 = r0.zzd     // Catch:{ ClassCastException -> 0x0005 }
            java.util.Comparator r0 = r0.zza     // Catch:{ ClassCastException -> 0x0005 }
            int r4 = java.util.Collections.binarySearch(r2, r4, r0)     // Catch:{ ClassCastException -> 0x0005 }
            if (r4 >= 0) goto L_0x0012
            goto L_0x0005
        L_0x0012:
            if (r4 != r1) goto L_0x0016
            r4 = 0
            return r4
        L_0x0016:
            com.google.android.gms.internal.fido.zzcc r0 = r3.zze
            java.lang.Object r4 = r0.get(r4)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.fido.zzcj.get(java.lang.Object):java.lang.Object");
    }

    /* renamed from: zzh */
    public final zzcj headMap(Object obj, boolean z) {
        obj.getClass();
        return zzl(0, this.zzd.zzu(obj, z));
    }

    /* renamed from: zzj */
    public final zzcj tailMap(Object obj, boolean z) {
        obj.getClass();
        return zzl(this.zzd.zzv(obj, z), this.zze.size());
    }

    /* renamed from: zzi */
    public final zzcj subMap(Object obj, boolean z, Object obj2, boolean z2) {
        obj.getClass();
        obj2.getClass();
        if (this.zzd.zza.compare(obj, obj2) <= 0) {
            return headMap(obj2, z2).tailMap(obj, z);
        }
        throw new IllegalArgumentException(zzbo.zza("expected fromKey <= toKey but %s > %s", obj, obj2));
    }
}
