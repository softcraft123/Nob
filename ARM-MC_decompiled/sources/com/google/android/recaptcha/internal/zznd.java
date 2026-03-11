package com.google.android.recaptcha.internal;

import com.google.android.recaptcha.internal.zzmx;
import com.google.android.recaptcha.internal.zznd;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.6.1 */
public abstract class zznd<MessageType extends zznd<MessageType, BuilderType>, BuilderType extends zzmx<MessageType, BuilderType>> extends zzko<MessageType, BuilderType> {
    private static final Map zzb = new ConcurrentHashMap();
    protected zzpm zzc = zzpm.zzc();
    private int zzd = -1;

    protected static zznj zzA() {
        return zznx.zzf();
    }

    protected static zznk zzB() {
        return zzot.zze();
    }

    protected static zznk zzC(zznk zznk) {
        int size = zznk.size();
        return zznk.zzd(size + size);
    }

    static Object zzE(Method method, Object obj, Object... objArr) {
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

    protected static Object zzF(zzoi zzoi, String str, Object[] objArr) {
        return new zzou(zzoi, str, objArr);
    }

    protected static void zzI(Class cls, zznd zznd) {
        zznd.zzH();
        zzb.put(cls, zznd);
    }

    protected static final boolean zzK(zznd zznd, boolean z) {
        byte byteValue = ((Byte) zznd.zzh(1, (Object) null, (Object) null)).byteValue();
        if (byteValue == 1) {
            return true;
        }
        if (byteValue == 0) {
            return false;
        }
        boolean zzl = zzos.zza().zzb(zznd.getClass()).zzl(zznd);
        if (z) {
            zznd.zzh(2, true != zzl ? null : zznd, (Object) null);
        }
        return zzl;
    }

    private final int zzf(zzow zzow) {
        return zzos.zza().zzb(getClass()).zza(this);
    }

    private static zznd zzg(zznd zznd) throws zznn {
        if (zznd == null || zzK(zznd, true)) {
            return zznd;
        }
        throw new zzpk(zznd).zza();
    }

    /* access modifiers changed from: private */
    public static zznd zzi(zznd zznd, byte[] bArr, int i, int i2, zzmo zzmo) throws zznn {
        if (i2 == 0) {
            return zznd;
        }
        zznd zzv = zznd.zzv();
        try {
            zzow zzb2 = zzos.zza().zzb(zzv.getClass());
            zzb2.zzi(zzv, bArr, 0, i2, new zzkt(zzmo));
            zzb2.zzf(zzv);
            return zzv;
        } catch (zznn e) {
            zznn zznn = e;
            if (zznn.zzb()) {
                throw new zznn((IOException) zznn);
            }
            throw zznn;
        } catch (zzpk e2) {
            throw e2.zza();
        } catch (IOException e3) {
            IOException iOException = e3;
            if (iOException.getCause() instanceof zznn) {
                throw ((zznn) iOException.getCause());
            }
            throw new zznn(iOException);
        } catch (IndexOutOfBoundsException unused) {
            throw new zznn("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
    }

    public static zznc zzs(zzoi zzoi, Object obj, zzoi zzoi2, zzng zzng, int i, zzpw zzpw, Class cls) {
        return new zznc(zzoi, "", (zzoi) null, new zznb((zzng) null, i, zzpw, false, false), cls);
    }

    static zznd zzu(Class cls) {
        Map map = zzb;
        zznd zznd = (zznd) map.get(cls);
        if (zznd == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                zznd = (zznd) map.get(cls);
            } catch (ClassNotFoundException e) {
                throw new IllegalStateException("Class initialization cannot fail.", e);
            }
        }
        if (zznd != null) {
            return zznd;
        }
        zznd zznd2 = (zznd) ((zznd) zzps.zze(cls)).zzh(6, (Object) null, (Object) null);
        if (zznd2 != null) {
            map.put(cls, zznd2);
            return zznd2;
        }
        throw new IllegalStateException();
    }

    protected static zznd zzw(zznd zznd, InputStream inputStream) throws zznn {
        zzli zzli;
        int i = zzli.zzd;
        if (inputStream == null) {
            byte[] bArr = zznl.zzb;
            int length = bArr.length;
            zzli = zzli.zzH(bArr, 0, 0, false);
        } else {
            zzli = new zzlg(inputStream, 4096, (zzlh) null);
        }
        int i2 = zzmo.zzb;
        int i3 = zzos.zza;
        zzmo zzmo = zzmo.zza;
        zznd zzv = zznd.zzv();
        try {
            zzow zzb2 = zzos.zza().zzb(zzv.getClass());
            zzb2.zzh(zzv, zzlj.zzq(zzli), zzmo);
            zzb2.zzf(zzv);
            zzg(zzv);
            return zzv;
        } catch (zznn e) {
            if (e.zzb()) {
                throw new zznn((IOException) e);
            }
            throw e;
        } catch (zzpk e2) {
            throw e2.zza();
        } catch (IOException e3) {
            if (e3.getCause() instanceof zznn) {
                throw ((zznn) e3.getCause());
            }
            throw new zznn(e3);
        } catch (RuntimeException e4) {
            if (e4.getCause() instanceof zznn) {
                throw ((zznn) e4.getCause());
            }
            throw e4;
        }
    }

    protected static zznd zzx(zznd zznd, byte[] bArr) throws zznn {
        int i = zzmo.zzb;
        int i2 = zzos.zza;
        zznd zzi = zzi(zznd, bArr, 0, bArr.length, zzmo.zza);
        zzg(zzi);
        return zzi;
    }

    protected static zzni zzy() {
        return zzne.zzf();
    }

    protected static zzni zzz(zzni zzni) {
        int size = zzni.size();
        return zzni.zzg(size + size);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return zzos.zza().zzb(getClass()).zzk(this, (zznd) obj);
    }

    public final int hashCode() {
        if (zzL()) {
            return zzn();
        }
        int i = this.zza;
        if (i != 0) {
            return i;
        }
        int zzn = zzn();
        this.zza = zzn;
        return zzn;
    }

    public final String toString() {
        return zzok.zza(this, super.toString());
    }

    public final zzoq zzD() {
        return (zzoq) zzh(7, (Object) null, (Object) null);
    }

    /* access modifiers changed from: protected */
    public final void zzG() {
        zzos.zza().zzb(getClass()).zzf(this);
        zzH();
    }

    /* access modifiers changed from: package-private */
    public final void zzH() {
        this.zzd &= Integer.MAX_VALUE;
    }

    /* access modifiers changed from: package-private */
    public final void zzJ(int i) {
        this.zzd = (this.zzd & Integer.MIN_VALUE) | Integer.MAX_VALUE;
    }

    /* access modifiers changed from: package-private */
    public final boolean zzL() {
        return (this.zzd & Integer.MIN_VALUE) != 0;
    }

    /* access modifiers changed from: package-private */
    public final int zza(zzow zzow) {
        if (zzL()) {
            int zza = zzow.zza(this);
            if (zza >= 0) {
                return zza;
            }
            throw new IllegalStateException("serialized size must be non-negative, was " + zza);
        }
        int i = this.zzd & Integer.MAX_VALUE;
        if (i != Integer.MAX_VALUE) {
            return i;
        }
        int zza2 = zzow.zza(this);
        if (zza2 >= 0) {
            this.zzd = (this.zzd & Integer.MIN_VALUE) | zza2;
            return zza2;
        }
        throw new IllegalStateException("serialized size must be non-negative, was " + zza2);
    }

    public final /* synthetic */ zzoh zzad() {
        return (zzmx) zzh(5, (Object) null, (Object) null);
    }

    public final /* synthetic */ zzoh zzae() {
        zzmx zzmx = (zzmx) zzh(5, (Object) null, (Object) null);
        zzmx.zzh(this);
        return zzmx;
    }

    public final void zze(zzln zzln) throws IOException {
        zzos.zza().zzb(getClass()).zzj(this, zzlo.zza(zzln));
    }

    /* access modifiers changed from: protected */
    public abstract Object zzh(int i, Object obj, Object obj2);

    public final /* synthetic */ zzoi zzm() {
        return (zznd) zzh(6, (Object) null, (Object) null);
    }

    /* access modifiers changed from: package-private */
    public final int zzn() {
        return zzos.zza().zzb(getClass()).zzb(this);
    }

    public final boolean zzp() {
        return zzK(this, true);
    }

    /* access modifiers changed from: protected */
    public final zzmx zzq() {
        return (zzmx) zzh(5, (Object) null, (Object) null);
    }

    public final zzmx zzr() {
        zzmx zzmx = (zzmx) zzh(5, (Object) null, (Object) null);
        zzmx.zzh(this);
        return zzmx;
    }

    /* access modifiers changed from: package-private */
    public final zznd zzv() {
        return (zznd) zzh(4, (Object) null, (Object) null);
    }

    public final int zzo() {
        if (zzL()) {
            int zzf = zzf((zzow) null);
            if (zzf >= 0) {
                return zzf;
            }
            throw new IllegalStateException("serialized size must be non-negative, was " + zzf);
        }
        int i = this.zzd & Integer.MAX_VALUE;
        if (i != Integer.MAX_VALUE) {
            return i;
        }
        int zzf2 = zzf((zzow) null);
        if (zzf2 >= 0) {
            this.zzd = (this.zzd & Integer.MIN_VALUE) | zzf2;
            return zzf2;
        }
        throw new IllegalStateException("serialized size must be non-negative, was " + zzf2);
    }
}
