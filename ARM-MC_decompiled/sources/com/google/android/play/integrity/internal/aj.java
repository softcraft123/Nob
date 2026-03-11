package com.google.android.play.integrity.internal;

/* compiled from: com.google.android.play:integrity@@1.3.0 */
public final class aj implements an {
    private static final Object a = new Object();
    private volatile an b;
    private volatile Object c = a;

    private aj(an anVar) {
        this.b = anVar;
    }

    public static an b(an anVar) {
        return anVar instanceof aj ? anVar : new aj(anVar);
    }

    public final Object a() {
        Object obj;
        Object obj2 = this.c;
        Object obj3 = a;
        if (obj2 != obj3) {
            return obj2;
        }
        synchronized (this) {
            obj = this.c;
            if (obj == obj3) {
                obj = this.b.a();
                Object obj4 = this.c;
                if (obj4 != obj3) {
                    if (obj4 != obj) {
                        throw new IllegalStateException("Scoped provider was invoked recursively returning different results: " + obj4 + " & " + obj + ". This is likely due to a circular dependency.");
                    }
                }
                this.c = obj;
                this.b = null;
            }
        }
        return obj;
    }
}
