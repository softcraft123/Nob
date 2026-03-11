package com.google.android.play.core.integrity;

/* compiled from: com.google.android.play:integrity@@1.3.0 */
final class a extends ap {
    private String a;
    private y b;

    a() {
    }

    /* access modifiers changed from: package-private */
    public final ap a(y yVar) {
        this.b = yVar;
        return this;
    }

    /* access modifiers changed from: package-private */
    public final ap b(String str) {
        this.a = str;
        return this;
    }

    /* access modifiers changed from: package-private */
    public final aq c() {
        y yVar;
        String str = this.a;
        if (str != null && (yVar = this.b) != null) {
            return new aq(str, yVar);
        }
        StringBuilder sb = new StringBuilder();
        if (this.a == null) {
            sb.append(" token");
        }
        if (this.b == null) {
            sb.append(" integrityDialogWrapper");
        }
        throw new IllegalStateException("Missing required properties:".concat(sb.toString()));
    }
}
