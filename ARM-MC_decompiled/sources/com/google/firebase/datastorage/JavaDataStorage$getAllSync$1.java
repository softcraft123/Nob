package com.google.firebase.datastorage;

import androidx.datastore.preferences.core.Preferences;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0002\u0012\u0004\u0012\u00020\u00030\u0001*\u00020\u0004H\n"}, d2 = {"<anonymous>", "", "Landroidx/datastore/preferences/core/Preferences$Key;", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.google.firebase.datastorage.JavaDataStorage$getAllSync$1", f = "JavaDataStorage.kt", i = {}, l = {170}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: JavaDataStorage.kt */
final class JavaDataStorage$getAllSync$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Map<Preferences.Key<?>, ? extends Object>>, Object> {
    int label;
    final /* synthetic */ JavaDataStorage this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    JavaDataStorage$getAllSync$1(JavaDataStorage javaDataStorage, Continuation<? super JavaDataStorage$getAllSync$1> continuation) {
        super(2, continuation);
        this.this$0 = javaDataStorage;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new JavaDataStorage$getAllSync$1(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Map<Preferences.Key<?>, ? extends Object>> continuation) {
        return ((JavaDataStorage$getAllSync$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0034, code lost:
        r4 = r4.asMap();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r4) {
        /*
            r3 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r3.label
            r2 = 1
            if (r1 == 0) goto L_0x0017
            if (r1 != r2) goto L_0x000f
            kotlin.ResultKt.throwOnFailure(r4)
            goto L_0x0030
        L_0x000f:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r0)
            throw r4
        L_0x0017:
            kotlin.ResultKt.throwOnFailure(r4)
            com.google.firebase.datastorage.JavaDataStorage r4 = r3.this$0
            androidx.datastore.core.DataStore r4 = r4.dataStore
            kotlinx.coroutines.flow.Flow r4 = r4.getData()
            r1 = r3
            kotlin.coroutines.Continuation r1 = (kotlin.coroutines.Continuation) r1
            r3.label = r2
            java.lang.Object r4 = kotlinx.coroutines.flow.FlowKt.firstOrNull(r4, r1)
            if (r4 != r0) goto L_0x0030
            return r0
        L_0x0030:
            androidx.datastore.preferences.core.Preferences r4 = (androidx.datastore.preferences.core.Preferences) r4
            if (r4 == 0) goto L_0x003c
            java.util.Map r4 = r4.asMap()
            if (r4 != 0) goto L_0x003b
            goto L_0x003c
        L_0x003b:
            return r4
        L_0x003c:
            java.util.Map r4 = kotlin.collections.MapsKt.emptyMap()
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.datastorage.JavaDataStorage$getAllSync$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
