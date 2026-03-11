package com.google.android.play.core.integrity;

import com.google.android.play.core.integrity.StandardIntegrityManager;

/* compiled from: com.google.android.play:integrity@@1.3.0 */
final class f extends StandardIntegrityManager.StandardIntegrityTokenRequest.Builder {
    private String a;

    f() {
    }

    public final StandardIntegrityManager.StandardIntegrityTokenRequest build() {
        return new h(this.a, (g) null);
    }

    public final StandardIntegrityManager.StandardIntegrityTokenRequest.Builder setRequestHash(String str) {
        this.a = str;
        return this;
    }
}
