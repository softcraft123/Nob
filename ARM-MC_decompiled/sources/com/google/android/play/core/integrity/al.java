package com.google.android.play.core.integrity;

import android.content.Context;
import com.google.android.play.integrity.internal.ak;
import com.google.android.play.integrity.internal.an;
import com.google.android.play.integrity.internal.s;

/* compiled from: com.google.android.play:integrity@@1.3.0 */
public final class al implements ak {
    private final an a;
    private final an b;
    private final an c;
    private final an d;

    public al(an anVar, an anVar2, an anVar3, an anVar4) {
        this.a = anVar;
        this.b = anVar2;
        this.c = anVar3;
        this.d = anVar4;
    }

    public final /* bridge */ /* synthetic */ Object a() {
        return new aj((Context) this.a.a(), (s) this.b.a(), ((au) this.c).a(), new i());
    }
}
