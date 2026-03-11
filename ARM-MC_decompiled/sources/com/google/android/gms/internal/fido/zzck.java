package com.google.android.gms.internal.fido;

import java.util.Comparator;
import java.util.NavigableSet;
import java.util.SortedSet;
import javax.annotation.CheckForNull;

/* compiled from: com.google.android.gms:play-services-fido@@21.0.0 */
public abstract class zzck extends zzcf implements NavigableSet, zzda {
    final transient Comparator zza;
    @CheckForNull
    transient zzck zzb;

    zzck(Comparator comparator) {
        this.zza = comparator;
    }

    static zzcv zzs(Comparator comparator) {
        if (zzcq.zza.equals(comparator)) {
            return zzcv.zzc;
        }
        int i = zzcc.zzd;
        return new zzcv(zzct.zza, comparator);
    }

    @CheckForNull
    @Deprecated
    public final void addFirst(Object obj) {
        throw new UnsupportedOperationException();
    }

    @CheckForNull
    @Deprecated
    public final void addLast(Object obj) {
        throw new UnsupportedOperationException();
    }

    public final Comparator comparator() {
        return this.zza;
    }

    public Object first() {
        return iterator().next();
    }

    public final Object getFirst() {
        return first();
    }

    public final Object getLast() {
        return last();
    }

    public Object last() {
        return descendingIterator().next();
    }

    @CheckForNull
    @Deprecated
    public final Object pollFirst() {
        throw new UnsupportedOperationException();
    }

    @CheckForNull
    @Deprecated
    public final Object pollLast() {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final Object removeFirst() {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final Object removeLast() {
        throw new UnsupportedOperationException();
    }

    public final /* bridge */ /* synthetic */ SortedSet subSet(Object obj, Object obj2) {
        return subSet(obj, true, obj2, false);
    }

    /* renamed from: zzd */
    public abstract zzdc iterator();

    /* access modifiers changed from: package-private */
    public abstract zzck zzf();

    /* renamed from: zzn */
    public final zzck descendingSet() {
        zzck zzck = this.zzb;
        if (zzck != null) {
            return zzck;
        }
        zzck zzf = zzf();
        this.zzb = zzf;
        zzf.zzb = this;
        return zzf;
    }

    /* access modifiers changed from: package-private */
    public abstract zzck zzo(Object obj, boolean z);

    /* access modifiers changed from: package-private */
    public abstract zzck zzq(Object obj, boolean z, Object obj2, boolean z2);

    /* access modifiers changed from: package-private */
    public abstract zzck zzr(Object obj, boolean z);

    /* renamed from: zzt */
    public abstract zzdc descendingIterator();

    public final /* synthetic */ SortedSet headSet(Object obj) {
        obj.getClass();
        return zzo(obj, false);
    }

    public final /* synthetic */ SortedSet tailSet(Object obj) {
        obj.getClass();
        return zzr(obj, true);
    }

    @CheckForNull
    public Object ceiling(Object obj) {
        obj.getClass();
        return zzcl.zza(zzr(obj, true), (Object) null);
    }

    @CheckForNull
    public Object floor(Object obj) {
        obj.getClass();
        return zzcn.zza(zzo(obj, true).descendingIterator(), (Object) null);
    }

    @CheckForNull
    public Object higher(Object obj) {
        obj.getClass();
        return zzcl.zza(zzr(obj, false), (Object) null);
    }

    @CheckForNull
    public Object lower(Object obj) {
        obj.getClass();
        return zzcn.zza(zzo(obj, false).descendingIterator(), (Object) null);
    }

    public final /* synthetic */ NavigableSet headSet(Object obj, boolean z) {
        obj.getClass();
        return zzo(obj, z);
    }

    public final /* synthetic */ NavigableSet tailSet(Object obj, boolean z) {
        obj.getClass();
        return zzr(obj, z);
    }

    /* renamed from: zzp */
    public final zzck subSet(Object obj, boolean z, Object obj2, boolean z2) {
        obj.getClass();
        obj2.getClass();
        zzbm.zzc(this.zza.compare(obj, obj2) <= 0);
        return zzq(obj, z, obj2, z2);
    }
}
