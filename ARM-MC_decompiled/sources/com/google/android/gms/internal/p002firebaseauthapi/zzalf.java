package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzalf;
import com.google.android.gms.internal.p002firebaseauthapi.zzalf.zzb;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzalf  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
public abstract class zzalf<MessageType extends zzalf<MessageType, BuilderType>, BuilderType extends zzb<MessageType, BuilderType>> extends zzajm<MessageType, BuilderType> {
    private static Map<Class<?>, zzalf<?, ?>> zzc = new ConcurrentHashMap();
    protected zzanx zzb = zzanx.zzc();
    private int zzd = -1;

    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzalf$zza */
    /* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
    protected static class zza<T extends zzalf<T, ?>> extends zzajq<T> {
        public zza(T t) {
        }
    }

    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzalf$zzc */
    /* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
    static final class zzc implements zzakz<zzc> {
        public final /* synthetic */ int compareTo(Object obj) {
            throw new NoSuchMethodError();
        }

        public final int zza() {
            throw new NoSuchMethodError();
        }

        public final zzaml zza(zzaml zzaml, zzamm zzamm) {
            throw new NoSuchMethodError();
        }

        public final zzamr zza(zzamr zzamr, zzamr zzamr2) {
            throw new NoSuchMethodError();
        }

        public final zzaog zzb() {
            throw new NoSuchMethodError();
        }

        public final zzaoj zzc() {
            throw new NoSuchMethodError();
        }

        public final boolean zzd() {
            throw new NoSuchMethodError();
        }

        public final boolean zze() {
            throw new NoSuchMethodError();
        }
    }

    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzalf$zzd */
    /* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
    public static abstract class zzd<MessageType extends zzd<MessageType, BuilderType>, BuilderType> extends zzalf<MessageType, BuilderType> implements zzamo {
        protected zzakx<zzc> zzc = zzakx.zzb();

        /* access modifiers changed from: package-private */
        public final zzakx<zzc> zza() {
            if (this.zzc.zzf()) {
                this.zzc = (zzakx) this.zzc.clone();
            }
            return this.zzc;
        }
    }

    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzalf$zzf */
    /* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
    public static class zzf<ContainingType extends zzamm, Type> extends zzakr<ContainingType, Type> {
    }

    private final int zza() {
        return zzamx.zza().zza(this).zzb(this);
    }

    /* access modifiers changed from: protected */
    public abstract Object zza(int i, Object obj, Object obj2);

    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzalf$zzb */
    /* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
    public static abstract class zzb<MessageType extends zzalf<MessageType, BuilderType>, BuilderType extends zzb<MessageType, BuilderType>> extends zzajo<MessageType, BuilderType> {
        protected MessageType zza;
        private final MessageType zzb;

        public final /* synthetic */ zzajo zzb() {
            return (zzb) clone();
        }

        public final BuilderType zza(MessageType messagetype) {
            MessageType messagetype2 = this.zzb;
            zzalf zzalf = (zzalf) messagetype2;
            if (messagetype2.equals(messagetype)) {
                return this;
            }
            if (!this.zza.zzw()) {
                zzh();
            }
            zza(this.zza, messagetype);
            return this;
        }

        /* renamed from: zzc */
        public final MessageType zze() {
            MessageType messagetype = (zzalf) zzf();
            if (messagetype.zzv()) {
                return messagetype;
            }
            throw new zzanv(messagetype);
        }

        /* renamed from: zzd */
        public MessageType zzf() {
            if (!this.zza.zzw()) {
                return this.zza;
            }
            this.zza.zzt();
            return this.zza;
        }

        public final /* synthetic */ zzamm zzs() {
            return this.zzb;
        }

        public /* synthetic */ Object clone() throws CloneNotSupportedException {
            MessageType messagetype = this.zzb;
            zzalf zzalf = (zzalf) messagetype;
            zzb zzb2 = (zzb) messagetype.zza(zze.zze, (Object) null, (Object) null);
            zzb2.zza = (zzalf) zzf();
            return zzb2;
        }

        protected zzb(MessageType messagetype) {
            this.zzb = messagetype;
            if (!messagetype.zzw()) {
                this.zza = messagetype.zzo();
                return;
            }
            throw new IllegalArgumentException("Default instance must be immutable.");
        }

        /* access modifiers changed from: protected */
        public final void zzg() {
            if (!this.zza.zzw()) {
                zzh();
            }
        }

        /* access modifiers changed from: protected */
        public void zzh() {
            MessageType zzo = this.zzb.zzo();
            zza(zzo, this.zza);
            this.zza = zzo;
        }

        private static <MessageType> void zza(MessageType messagetype, MessageType messagetype2) {
            zzamx.zza().zza(messagetype).zza(messagetype, messagetype2);
        }

        public final boolean zzv() {
            return zzalf.zzb(this.zza, false);
        }
    }

    private final int zzb(zzanb<?> zzanb) {
        if (zzanb == null) {
            return zzamx.zza().zza(this).zza(this);
        }
        return zzanb.zza(this);
    }

    /* access modifiers changed from: package-private */
    public final int zzi() {
        return this.zzd & Integer.MAX_VALUE;
    }

    public final int zzl() {
        return zza((zzanb) null);
    }

    /* 'enum' modifier removed */
    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzalf$zze */
    /* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
    public static final class zze {
        public static final int zza = 1;
        public static final int zzb = 2;
        public static final int zzc = 3;
        public static final int zzd = 4;
        public static final int zze = 5;
        public static final int zzf = 6;
        public static final int zzg = 7;
        private static final /* synthetic */ int[] zzh = {1, 2, 3, 4, 5, 6, 7};

        public static int[] zza() {
            return (int[]) zzh.clone();
        }
    }

    /* access modifiers changed from: package-private */
    public final int zza(zzanb zzanb) {
        if (zzw()) {
            int zzb2 = zzb((zzanb<?>) zzanb);
            if (zzb2 >= 0) {
                return zzb2;
            }
            throw new IllegalStateException("serialized size must be non-negative, was " + zzb2);
        } else if (zzi() != Integer.MAX_VALUE) {
            return zzi();
        } else {
            int zzb3 = zzb((zzanb<?>) zzanb);
            zzb(zzb3);
            return zzb3;
        }
    }

    public int hashCode() {
        if (zzw()) {
            return zza();
        }
        if (this.zza == 0) {
            this.zza = zza();
        }
        return this.zza;
    }

    /* access modifiers changed from: protected */
    public final <MessageType2 extends zzalf<MessageType2, BuilderType2>, BuilderType2 extends zzb<MessageType2, BuilderType2>> BuilderType2 zzm() {
        return (zzb) zza(zze.zze, (Object) null, (Object) null);
    }

    public final BuilderType zzn() {
        return ((zzb) zza(zze.zze, (Object) null, (Object) null)).zza(this);
    }

    private static <T extends zzalf<T, ?>> T zza(T t) throws zzall {
        if (t == null || zzb(t, true)) {
            return t;
        }
        zzall zza2 = new zzanv(t).zza();
        zza2.getClass();
        throw zza2;
    }

    static <T extends zzalf<?, ?>> T zza(Class<T> cls) {
        T t = (zzalf) zzc.get(cls);
        if (t == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                t = (zzalf) zzc.get(cls);
            } catch (ClassNotFoundException e) {
                throw new IllegalStateException("Class initialization cannot fail.", e);
            }
        }
        if (t != null) {
            return t;
        }
        T t2 = (zzalf) ((zzalf) zzanz.zza(cls)).zza(zze.zzf, (Object) null, (Object) null);
        if (t2 != null) {
            zzc.put(cls, t2);
            return t2;
        }
        throw new IllegalStateException();
    }

    /* access modifiers changed from: package-private */
    public final MessageType zzo() {
        return (zzalf) zza(zze.zzd, (Object) null, (Object) null);
    }

    protected static <T extends zzalf<T, ?>> T zza(T t, zzajv zzajv, zzaku zzaku) throws zzall {
        return zza(zzb(t, zzajv, zzaku));
    }

    protected static <T extends zzalf<T, ?>> T zza(T t, InputStream inputStream, zzaku zzaku) throws zzall {
        zzakh zzakh;
        if (inputStream == null) {
            byte[] bArr = zzalh.zzb;
            zzakh = zzakh.zza(bArr, 0, bArr.length, false);
        } else {
            zzakh = new zzakj(inputStream);
        }
        return zza(zza(t, zzakh, zzaku));
    }

    protected static <T extends zzalf<T, ?>> T zza(T t, byte[] bArr, zzaku zzaku) throws zzall {
        return zza(zza(t, bArr, 0, bArr.length, zzaku));
    }

    private static <T extends zzalf<T, ?>> T zzb(T t, zzajv zzajv, zzaku zzaku) throws zzall {
        zzakh zzc2 = zzajv.zzc();
        T zza2 = zza(t, zzc2, zzaku);
        zzc2.zzc(0);
        return zza2;
    }

    private static <T extends zzalf<T, ?>> T zza(T t, zzakh zzakh, zzaku zzaku) throws zzall {
        T zzo = t.zzo();
        try {
            zzanb zza2 = zzamx.zza().zza(zzo);
            zza2.zza(zzo, zzakl.zza(zzakh), zzaku);
            zza2.zzd(zzo);
            return zzo;
        } catch (zzall e) {
            e = e;
            if (e.zzl()) {
                e = new zzall((IOException) e);
            }
            throw e;
        } catch (zzanv e2) {
            zzall zza3 = e2.zza();
            zza3.getClass();
            throw zza3;
        } catch (IOException e3) {
            if (e3.getCause() instanceof zzall) {
                throw ((zzall) e3.getCause());
            }
            throw new zzall(e3);
        } catch (RuntimeException e4) {
            if (e4.getCause() instanceof zzall) {
                throw ((zzall) e4.getCause());
            }
            throw e4;
        }
    }

    private static <T extends zzalf<T, ?>> T zza(T t, byte[] bArr, int i, int i2, zzaku zzaku) throws zzall {
        if (i2 == 0) {
            return t;
        }
        T zzo = t.zzo();
        try {
            zzanb zza2 = zzamx.zza().zza(zzo);
            zza2.zza(zzo, bArr, 0, i2, new zzaju(zzaku));
            zza2.zzd(zzo);
            return zzo;
        } catch (zzall e) {
            zzall zzall = e;
            if (zzall.zzl()) {
                zzall = new zzall((IOException) zzall);
            }
            throw zzall;
        } catch (zzanv e2) {
            zzall zza3 = e2.zza();
            zza3.getClass();
            throw zza3;
        } catch (IOException e3) {
            IOException iOException = e3;
            if (iOException.getCause() instanceof zzall) {
                throw ((zzall) iOException.getCause());
            }
            throw new zzall(iOException);
        } catch (IndexOutOfBoundsException unused) {
            zzall zzj = zzall.zzj();
            zzj.getClass();
            throw zzj;
        }
    }

    protected static <E> zzalm<E> zzp() {
        return zzana.zzd();
    }

    protected static <E> zzalm<E> zza(zzalm<E> zzalm) {
        return zzalm.zza(zzalm.size() << 1);
    }

    public final /* synthetic */ zzaml zzq() {
        return (zzb) zza(zze.zze, (Object) null, (Object) null);
    }

    public final /* synthetic */ zzaml zzr() {
        return ((zzb) zza(zze.zze, (Object) null, (Object) null)).zza(this);
    }

    public final /* synthetic */ zzamm zzs() {
        return (zzalf) zza(zze.zzf, (Object) null, (Object) null);
    }

    static Object zza(Method method, Object obj, Object... objArr) {
        try {
            return method.invoke(obj, objArr);
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", e);
        } catch (InvocationTargetException e2) {
            Throwable cause = e2.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            } else if (cause instanceof Error) {
                throw ((Error) cause);
            } else {
                throw new RuntimeException("Unexpected exception thrown by generated accessor method.", cause);
            }
        }
    }

    protected static Object zza(zzamm zzamm, String str, Object[] objArr) {
        return new zzamz(zzamm, str, objArr);
    }

    public String toString() {
        return zzamn.zza((zzamm) this, super.toString());
    }

    /* access modifiers changed from: protected */
    public final void zzt() {
        zzamx.zza().zza(this).zzd(this);
        zzu();
    }

    /* access modifiers changed from: package-private */
    public final void zzu() {
        this.zzd &= Integer.MAX_VALUE;
    }

    protected static <T extends zzalf<?, ?>> void zza(Class<T> cls, T t) {
        t.zzu();
        zzc.put(cls, t);
    }

    /* access modifiers changed from: package-private */
    public final void zzb(int i) {
        if (i >= 0) {
            this.zzd = (i & Integer.MAX_VALUE) | (this.zzd & Integer.MIN_VALUE);
            return;
        }
        throw new IllegalStateException("serialized size must be non-negative, was " + i);
    }

    public final void zza(zzakn zzakn) throws IOException {
        zzamx.zza().zza(this).zza(this, (zzaol) zzakp.zza(zzakn));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            return zzamx.zza().zza(this).zzb(this, (zzalf) obj);
        }
        return false;
    }

    public final boolean zzv() {
        return zzb(this, true);
    }

    /* access modifiers changed from: private */
    public static final <T extends zzalf<T, ?>> boolean zzb(T t, boolean z) {
        byte byteValue = ((Byte) t.zza(zze.zza, (Object) null, (Object) null)).byteValue();
        if (byteValue == 1) {
            return true;
        }
        if (byteValue == 0) {
            return false;
        }
        boolean zze2 = zzamx.zza().zza(t).zze(t);
        if (z) {
            t.zza(zze.zzb, (Object) zze2 ? t : null, (Object) null);
        }
        return zze2;
    }

    /* access modifiers changed from: package-private */
    public final boolean zzw() {
        return (this.zzd & Integer.MIN_VALUE) != 0;
    }
}
