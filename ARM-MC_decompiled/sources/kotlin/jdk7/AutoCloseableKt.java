package kotlin.jdk7;

import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a \u0010\u0000\u001a\u00060\u0001j\u0002`\u00022\u000e\b\u0004\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\bø\u0001\u0000\u001a\u0018\u0010\u0006\u001a\u00020\u0005*\u0004\u0018\u00010\u00012\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0001\u001aH\u0010\t\u001a\u0002H\n\"\n\b\u0000\u0010\u000b*\u0004\u0018\u00010\u0001\"\u0004\b\u0001\u0010\n*\u0002H\u000b2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u0002H\u000b\u0012\u0004\u0012\u0002H\n0\rH\bø\u0001\u0000\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0002\u0010\u000e*\u001a\b\u0007\u0010\u0000\"\u00020\u00012\u00020\u0001B\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0002\u0007\n\u0005\b20\u0001¨\u0006\u0012"}, d2 = {"AutoCloseable", "Ljava/lang/AutoCloseable;", "Lkotlin/AutoCloseable;", "closeAction", "Lkotlin/Function0;", "", "closeFinally", "cause", "", "use", "R", "T", "block", "Lkotlin/Function1;", "(Ljava/lang/AutoCloseable;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "Lkotlin/SinceKotlin;", "version", "2.0", "kotlin-stdlib-jdk7"}, k = 2, mv = {1, 9, 0}, pn = "kotlin", xi = 48)
/* compiled from: AutoCloseableJVM.kt */
public final class AutoCloseableKt {
    public static /* synthetic */ void AutoCloseable$annotations() {
    }

    private static final AutoCloseable AutoCloseable(Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "closeAction");
        return new AutoCloseableKt$AutoCloseable$1(function0);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0014, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0010, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0011, code lost:
        closeFinally(r1, r2);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static final <T extends java.lang.AutoCloseable, R> R use(T r1, kotlin.jvm.functions.Function1<? super T, ? extends R> r2) {
        /*
            java.lang.String r0 = "block"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            java.lang.Object r2 = r2.invoke(r1)     // Catch:{ all -> 0x000e }
            r0 = 0
            closeFinally(r1, r0)
            return r2
        L_0x000e:
            r2 = move-exception
            throw r2     // Catch:{ all -> 0x0010 }
        L_0x0010:
            r0 = move-exception
            closeFinally(r1, r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.jdk7.AutoCloseableKt.use(java.lang.AutoCloseable, kotlin.jvm.functions.Function1):java.lang.Object");
    }

    public static final void closeFinally(AutoCloseable autoCloseable, Throwable th) {
        if (autoCloseable == null) {
            return;
        }
        if (th == null) {
            autoCloseable.close();
            return;
        }
        try {
            autoCloseable.close();
        } catch (Throwable th2) {
            ExceptionsKt.addSuppressed(th, th2);
        }
    }
}
