package com.google.firebase.firestore.core;

import java.util.Comparator;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class View$$ExternalSyntheticLambda0 implements Comparator {
    public final /* synthetic */ Comparator f$0;

    public /* synthetic */ View$$ExternalSyntheticLambda0(Comparator comparator) {
        this.f$0 = comparator;
    }

    public final int compare(Object obj, Object obj2) {
        return View.lambda$applyChanges$0(this.f$0, (DocumentViewChange) obj, (DocumentViewChange) obj2);
    }
}
