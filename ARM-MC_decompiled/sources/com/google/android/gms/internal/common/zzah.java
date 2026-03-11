package com.google.android.gms.internal.common;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

/* compiled from: com.google.android.gms:play-services-basement@@18.8.0 */
public abstract class zzah extends zzac implements List, RandomAccess {
    private static final zzal zza = new zzae(zzaj.zza, 0);
    public static final /* synthetic */ int zzd = 0;

    zzah() {
    }

    public static zzah zzj() {
        return zzaj.zza;
    }

    public static zzah zzk(Object obj) {
        Object[] objArr = {obj};
        zzai.zza(objArr, 1);
        return zzq(objArr, 1);
    }

    public static zzah zzl(Object obj, Object obj2) {
        Object[] objArr = {obj, obj2};
        zzai.zza(objArr, 2);
        return zzq(objArr, 2);
    }

    public static zzah zzm(Object obj, Object obj2, Object obj3) {
        Object[] objArr = {obj, obj2, obj3};
        zzai.zza(objArr, 3);
        return zzq(objArr, 3);
    }

    public static zzah zzn(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6) {
        Object[] objArr = {obj, obj2, obj3, obj4, obj5, obj6};
        zzai.zza(objArr, 6);
        return zzq(objArr, 6);
    }

    public static zzah zzp(Collection collection) {
        if (collection instanceof zzac) {
            zzah zze = ((zzac) collection).zze();
            if (!zze.zzf()) {
                return zze;
            }
            Object[] array = zze.toArray();
            return zzq(array, array.length);
        }
        Object[] array2 = collection.toArray();
        int length = array2.length;
        zzai.zza(array2, length);
        return zzq(array2, length);
    }

    static zzah zzq(Object[] objArr, int i) {
        if (i == 0) {
            return zzaj.zza;
        }
        return new zzaj(objArr, i);
    }

    @Deprecated
    public final void add(int i, Object obj) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final boolean addAll(int i, Collection collection) {
        throw new UnsupportedOperationException();
    }

    public boolean contains(Object obj) {
        return indexOf(obj) >= 0;
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x003f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean equals(java.lang.Object r7) {
        /*
            r6 = this;
            r0 = 1
            if (r7 != r6) goto L_0x0004
            return r0
        L_0x0004:
            boolean r1 = r7 instanceof java.util.List
            r2 = 0
            if (r1 != 0) goto L_0x000a
            return r2
        L_0x000a:
            java.util.List r7 = (java.util.List) r7
            int r1 = r6.size()
            int r3 = r7.size()
            if (r1 == r3) goto L_0x0017
            return r2
        L_0x0017:
            boolean r3 = r7 instanceof java.util.RandomAccess
            if (r3 == 0) goto L_0x0031
            r3 = r2
        L_0x001c:
            if (r3 >= r1) goto L_0x0030
            java.lang.Object r4 = r6.get(r3)
            java.lang.Object r5 = r7.get(r3)
            boolean r4 = java.util.Objects.equals(r4, r5)
            if (r4 != 0) goto L_0x002d
            return r2
        L_0x002d:
            int r3 = r3 + 1
            goto L_0x001c
        L_0x0030:
            return r0
        L_0x0031:
            java.util.Iterator r1 = r6.iterator()
            java.util.Iterator r7 = r7.iterator()
        L_0x0039:
            boolean r3 = r1.hasNext()
            if (r3 == 0) goto L_0x0055
            boolean r3 = r7.hasNext()
            if (r3 != 0) goto L_0x0046
            return r2
        L_0x0046:
            java.lang.Object r3 = r1.next()
            java.lang.Object r4 = r7.next()
            boolean r3 = java.util.Objects.equals(r3, r4)
            if (r3 != 0) goto L_0x0039
            return r2
        L_0x0055:
            boolean r7 = r7.hasNext()
            if (r7 != 0) goto L_0x005c
            return r0
        L_0x005c:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.common.zzah.equals(java.lang.Object):boolean");
    }

    public final int hashCode() {
        int size = size();
        int i = 1;
        for (int i2 = 0; i2 < size; i2++) {
            i = (i * 31) + get(i2).hashCode();
        }
        return i;
    }

    public int indexOf(Object obj) {
        if (obj == null) {
            return -1;
        }
        int size = size();
        for (int i = 0; i < size; i++) {
            if (obj.equals(get(i))) {
                return i;
            }
        }
        return -1;
    }

    public final /* synthetic */ Iterator iterator() {
        return listIterator(0);
    }

    public int lastIndexOf(Object obj) {
        if (obj == null) {
            return -1;
        }
        for (int size = size() - 1; size >= 0; size--) {
            if (obj.equals(get(size))) {
                return size;
            }
        }
        return -1;
    }

    public final /* synthetic */ ListIterator listIterator() {
        return listIterator(0);
    }

    @Deprecated
    public final Object remove(int i) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final Object set(int i, Object obj) {
        throw new UnsupportedOperationException();
    }

    public final zzak zza() {
        return listIterator(0);
    }

    @Deprecated
    public final zzah zze() {
        return this;
    }

    /* access modifiers changed from: package-private */
    public int zzg(Object[] objArr, int i) {
        int size = size();
        for (int i2 = 0; i2 < size; i2++) {
            objArr[i2] = get(i2);
        }
        return size;
    }

    public zzah zzh() {
        return size() <= 1 ? this : new zzaf(this);
    }

    /* renamed from: zzi */
    public zzah subList(int i, int i2) {
        zzr.zzd(i, i2, size());
        int i3 = i2 - i;
        if (i3 == size()) {
            return this;
        }
        if (i3 == 0) {
            return zzaj.zza;
        }
        return new zzag(this, i, i3);
    }

    /* renamed from: zzr */
    public final zzal listIterator(int i) {
        zzr.zzc(i, size(), "index");
        if (isEmpty()) {
            return zza;
        }
        return new zzae(this, i);
    }

    public static zzah zzo(Iterable iterable) {
        iterable.getClass();
        if (iterable instanceof Collection) {
            return zzp((Collection) iterable);
        }
        Iterator it = iterable.iterator();
        if (!it.hasNext()) {
            return zzaj.zza;
        }
        Object next = it.next();
        if (!it.hasNext()) {
            return zzk(next);
        }
        zzad zzad = new zzad(4);
        zzad.zzb(next);
        zzad.zzc(it);
        return zzad.zzd();
    }
}
