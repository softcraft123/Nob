package com.google.android.gms.internal.p002firebaseauthapi;

import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.Arrays;
import java.util.Collection;
import java.util.Spliterator;
import java.util.Spliterators;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzag  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
public abstract class zzag<E> extends AbstractCollection<E> implements Serializable {
    private static final Object[] zza = new Object[0];

    public abstract boolean contains(Object obj);

    /* access modifiers changed from: package-private */
    public int zza(Object[] objArr, int i) {
        zzay zzay = (zzay) iterator();
        while (zzay.hasNext()) {
            objArr[i] = zzay.next();
            i++;
        }
        return i;
    }

    /* renamed from: zzd */
    public abstract zzay<E> iterator();

    /* access modifiers changed from: package-private */
    public Object[] zze() {
        return null;
    }

    /* access modifiers changed from: package-private */
    public int zza() {
        throw new UnsupportedOperationException();
    }

    /* access modifiers changed from: package-private */
    public int zzb() {
        throw new UnsupportedOperationException();
    }

    public zzah<E> zzc() {
        return isEmpty() ? zzah.zzg() : zzah.zza(toArray());
    }

    public Spliterator<E> spliterator() {
        return Spliterators.spliterator(this, 1296);
    }

    zzag() {
    }

    @Deprecated
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final boolean add(E e) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final boolean addAll(Collection<? extends E> collection) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final boolean remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final boolean removeAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final boolean retainAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    public final Object[] toArray() {
        return toArray(zza);
    }

    public final <T> T[] toArray(T[] tArr) {
        zzu.zza(tArr);
        int size = size();
        if (tArr.length < size) {
            Object[] zze = zze();
            if (zze != null) {
                return Arrays.copyOfRange(zze, zzb(), zza(), tArr.getClass());
            }
            if (tArr.length != 0) {
                tArr = Arrays.copyOf(tArr, 0);
            }
            tArr = Arrays.copyOf(tArr, size);
        } else if (tArr.length > size) {
            tArr[size] = null;
        }
        zza(tArr, 0);
        return tArr;
    }
}
