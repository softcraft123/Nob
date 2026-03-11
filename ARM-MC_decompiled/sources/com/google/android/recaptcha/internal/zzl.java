package com.google.android.recaptcha.internal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.CoroutineScopeKt;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.6.1 */
public final class zzl {
    private final List zza;
    /* access modifiers changed from: private */
    public zzek zzb;

    public zzl() {
        this((List) null, 1, (DefaultConstructorMarker) null);
    }

    public /* synthetic */ zzl(List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        List emptyList = CollectionsKt.emptyList();
        this.zza = new ArrayList();
        zze[] zzeArr = (zze[]) emptyList.toArray(new zze[0]);
        zzh((zze[]) Arrays.copyOf(zzeArr, zzeArr.length));
    }

    private final void zzh(zze... zzeArr) {
        CollectionsKt.addAll(this.zza, (T[]) zzeArr);
    }

    public final Object zzb(String str, long j, Continuation continuation) {
        return CoroutineScopeKt.coroutineScope(new zzh(this, str, j, (Continuation) null), continuation);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0033  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object zzc(long r12, com.google.android.recaptcha.internal.zzsc r14, com.google.android.recaptcha.internal.zzek r15, kotlin.coroutines.Continuation r16) {
        /*
            r11 = this;
            r0 = r16
            boolean r1 = r0 instanceof com.google.android.recaptcha.internal.zzi
            if (r1 == 0) goto L_0x0015
            r1 = r0
            com.google.android.recaptcha.internal.zzi r1 = (com.google.android.recaptcha.internal.zzi) r1
            int r2 = r1.zzc
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r2 & r3
            if (r4 == 0) goto L_0x0015
            int r2 = r2 - r3
            r1.zzc = r2
            goto L_0x001a
        L_0x0015:
            com.google.android.recaptcha.internal.zzi r1 = new com.google.android.recaptcha.internal.zzi
            r1.<init>(r11, r0)
        L_0x001a:
            java.lang.Object r0 = r1.zza
            java.lang.Object r9 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r1.zzc
            r10 = 1
            if (r2 == 0) goto L_0x0033
            if (r2 != r10) goto L_0x002b
            kotlin.ResultKt.throwOnFailure(r0)
            goto L_0x004b
        L_0x002b:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x0033:
            kotlin.ResultKt.throwOnFailure(r0)
            com.google.android.recaptcha.internal.zzk r2 = new com.google.android.recaptcha.internal.zzk
            r8 = 0
            r3 = r11
            r5 = r12
            r7 = r14
            r4 = r15
            r2.<init>(r3, r4, r5, r7, r8)
            kotlin.jvm.functions.Function2 r2 = (kotlin.jvm.functions.Function2) r2
            r1.zzc = r10
            java.lang.Object r0 = kotlinx.coroutines.CoroutineScopeKt.coroutineScope(r2, r1)
            if (r0 != r9) goto L_0x004b
            return r9
        L_0x004b:
            kotlin.Result r0 = (kotlin.Result) r0
            java.lang.Object r0 = r0.m525unboximpl()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.recaptcha.internal.zzl.zzc(long, com.google.android.recaptcha.internal.zzsc, com.google.android.recaptcha.internal.zzek, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final List zzd() {
        return this.zza;
    }

    public final void zzf(zze... zzeArr) {
        zzh((zze[]) Arrays.copyOf(zzeArr, 1));
    }

    public final void zzg(zzsr zzsr) {
        for (zze zzk : this.zza) {
            zzk.zzk(zzsr);
        }
    }
}
