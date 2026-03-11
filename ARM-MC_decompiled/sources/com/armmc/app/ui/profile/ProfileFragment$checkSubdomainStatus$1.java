package com.armmc.app.ui.profile;

import com.google.firebase.auth.FirebaseUser;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.armmc.app.ui.profile.ProfileFragment$checkSubdomainStatus$1", f = "ProfileFragment.kt", i = {}, l = {192, 203}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: ProfileFragment.kt */
final class ProfileFragment$checkSubdomainStatus$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ FirebaseUser $user;
    int label;
    final /* synthetic */ ProfileFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ProfileFragment$checkSubdomainStatus$1(ProfileFragment profileFragment, FirebaseUser firebaseUser, Continuation<? super ProfileFragment$checkSubdomainStatus$1> continuation) {
        super(2, continuation);
        this.this$0 = profileFragment;
        this.$user = firebaseUser;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ProfileFragment$checkSubdomainStatus$1(this.this$0, this.$user, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ProfileFragment$checkSubdomainStatus$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0075, code lost:
        if (r9 == r0) goto L_0x0077;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r9) {
        /*
            r8 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r8.label
            r2 = 0
            r3 = 2
            r4 = 1
            r5 = 0
            r6 = 8
            if (r1 == 0) goto L_0x0022
            if (r1 == r4) goto L_0x001e
            if (r1 != r3) goto L_0x0016
            kotlin.ResultKt.throwOnFailure(r9)     // Catch:{ Exception -> 0x00fa }
            goto L_0x0078
        L_0x0016:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r0)
            throw r9
        L_0x001e:
            kotlin.ResultKt.throwOnFailure(r9)     // Catch:{ Exception -> 0x00fa }
            goto L_0x0040
        L_0x0022:
            kotlin.ResultKt.throwOnFailure(r9)
            kotlinx.coroutines.CoroutineDispatcher r9 = kotlinx.coroutines.Dispatchers.getIO()     // Catch:{ Exception -> 0x00fa }
            kotlin.coroutines.CoroutineContext r9 = (kotlin.coroutines.CoroutineContext) r9     // Catch:{ Exception -> 0x00fa }
            com.armmc.app.ui.profile.ProfileFragment$checkSubdomainStatus$1$idToken$1 r1 = new com.armmc.app.ui.profile.ProfileFragment$checkSubdomainStatus$1$idToken$1     // Catch:{ Exception -> 0x00fa }
            com.google.firebase.auth.FirebaseUser r7 = r8.$user     // Catch:{ Exception -> 0x00fa }
            r1.<init>(r7, r2)     // Catch:{ Exception -> 0x00fa }
            kotlin.jvm.functions.Function2 r1 = (kotlin.jvm.functions.Function2) r1     // Catch:{ Exception -> 0x00fa }
            r7 = r8
            kotlin.coroutines.Continuation r7 = (kotlin.coroutines.Continuation) r7     // Catch:{ Exception -> 0x00fa }
            r8.label = r4     // Catch:{ Exception -> 0x00fa }
            java.lang.Object r9 = kotlinx.coroutines.BuildersKt.withContext(r9, r1, r7)     // Catch:{ Exception -> 0x00fa }
            if (r9 != r0) goto L_0x0040
            goto L_0x0077
        L_0x0040:
            java.lang.String r9 = (java.lang.String) r9     // Catch:{ Exception -> 0x00fa }
            com.armmc.app.ui.profile.ProfileFragment r1 = r8.this$0     // Catch:{ Exception -> 0x00fa }
            com.armmc.app.databinding.FragmentProfileBinding r1 = r1._binding     // Catch:{ Exception -> 0x00fa }
            if (r1 != 0) goto L_0x004d
            kotlin.Unit r9 = kotlin.Unit.INSTANCE     // Catch:{ Exception -> 0x00fa }
            return r9
        L_0x004d:
            if (r9 != 0) goto L_0x005d
            com.armmc.app.ui.profile.ProfileFragment r9 = r8.this$0     // Catch:{ Exception -> 0x00fa }
            com.armmc.app.databinding.FragmentProfileBinding r9 = r9.getBinding()     // Catch:{ Exception -> 0x00fa }
            android.widget.ProgressBar r9 = r9.subdomainLoading     // Catch:{ Exception -> 0x00fa }
            r9.setVisibility(r6)     // Catch:{ Exception -> 0x00fa }
            kotlin.Unit r9 = kotlin.Unit.INSTANCE     // Catch:{ Exception -> 0x00fa }
            return r9
        L_0x005d:
            kotlinx.coroutines.CoroutineDispatcher r1 = kotlinx.coroutines.Dispatchers.getIO()     // Catch:{ Exception -> 0x00fa }
            kotlin.coroutines.CoroutineContext r1 = (kotlin.coroutines.CoroutineContext) r1     // Catch:{ Exception -> 0x00fa }
            com.armmc.app.ui.profile.ProfileFragment$checkSubdomainStatus$1$result$1 r4 = new com.armmc.app.ui.profile.ProfileFragment$checkSubdomainStatus$1$result$1     // Catch:{ Exception -> 0x00fa }
            com.armmc.app.ui.profile.ProfileFragment r7 = r8.this$0     // Catch:{ Exception -> 0x00fa }
            r4.<init>(r7, r9, r2)     // Catch:{ Exception -> 0x00fa }
            kotlin.jvm.functions.Function2 r4 = (kotlin.jvm.functions.Function2) r4     // Catch:{ Exception -> 0x00fa }
            r9 = r8
            kotlin.coroutines.Continuation r9 = (kotlin.coroutines.Continuation) r9     // Catch:{ Exception -> 0x00fa }
            r8.label = r3     // Catch:{ Exception -> 0x00fa }
            java.lang.Object r9 = kotlinx.coroutines.BuildersKt.withContext(r1, r4, r9)     // Catch:{ Exception -> 0x00fa }
            if (r9 != r0) goto L_0x0078
        L_0x0077:
            return r0
        L_0x0078:
            com.armmc.app.api.SubdomainApiService$SubdomainStatusResponse r9 = (com.armmc.app.api.SubdomainApiService.SubdomainStatusResponse) r9     // Catch:{ Exception -> 0x00fa }
            com.armmc.app.ui.profile.ProfileFragment r0 = r8.this$0     // Catch:{ Exception -> 0x00fa }
            com.armmc.app.databinding.FragmentProfileBinding r0 = r0._binding     // Catch:{ Exception -> 0x00fa }
            if (r0 != 0) goto L_0x0085
            kotlin.Unit r9 = kotlin.Unit.INSTANCE     // Catch:{ Exception -> 0x00fa }
            return r9
        L_0x0085:
            com.armmc.app.ui.profile.ProfileFragment r0 = r8.this$0     // Catch:{ Exception -> 0x00fa }
            com.armmc.app.databinding.FragmentProfileBinding r0 = r0.getBinding()     // Catch:{ Exception -> 0x00fa }
            android.widget.ProgressBar r0 = r0.subdomainLoading     // Catch:{ Exception -> 0x00fa }
            r0.setVisibility(r6)     // Catch:{ Exception -> 0x00fa }
            boolean r0 = r9.getSuccess()     // Catch:{ Exception -> 0x00fa }
            if (r0 == 0) goto L_0x011b
            boolean r0 = r9.isSupporter()     // Catch:{ Exception -> 0x00fa }
            if (r0 == 0) goto L_0x011b
            boolean r0 = r9.getHasClaimed()     // Catch:{ Exception -> 0x00fa }
            if (r0 == 0) goto L_0x00e3
            java.lang.String r0 = r9.getSubdomain()     // Catch:{ Exception -> 0x00fa }
            if (r0 == 0) goto L_0x00e3
            com.armmc.app.ui.profile.ProfileFragment r0 = r8.this$0     // Catch:{ Exception -> 0x00fa }
            com.armmc.app.databinding.FragmentProfileBinding r0 = r0.getBinding()     // Catch:{ Exception -> 0x00fa }
            android.widget.LinearLayout r0 = r0.claimedSubdomainContainer     // Catch:{ Exception -> 0x00fa }
            r0.setVisibility(r5)     // Catch:{ Exception -> 0x00fa }
            com.armmc.app.ui.profile.ProfileFragment r0 = r8.this$0     // Catch:{ Exception -> 0x00fa }
            com.armmc.app.databinding.FragmentProfileBinding r0 = r0.getBinding()     // Catch:{ Exception -> 0x00fa }
            android.widget.LinearLayout r0 = r0.unclaimedSubdomainContainer     // Catch:{ Exception -> 0x00fa }
            r0.setVisibility(r6)     // Catch:{ Exception -> 0x00fa }
            com.armmc.app.ui.profile.ProfileFragment r0 = r8.this$0     // Catch:{ Exception -> 0x00fa }
            com.armmc.app.databinding.FragmentProfileBinding r0 = r0.getBinding()     // Catch:{ Exception -> 0x00fa }
            android.widget.TextView r0 = r0.claimedSubdomainText     // Catch:{ Exception -> 0x00fa }
            java.lang.String r9 = r9.getSubdomain()     // Catch:{ Exception -> 0x00fa }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00fa }
            r1.<init>()     // Catch:{ Exception -> 0x00fa }
            java.lang.StringBuilder r9 = r1.append(r9)     // Catch:{ Exception -> 0x00fa }
            java.lang.String r1 = ".witherhost.com"
            java.lang.StringBuilder r9 = r9.append(r1)     // Catch:{ Exception -> 0x00fa }
            java.lang.String r9 = r9.toString()     // Catch:{ Exception -> 0x00fa }
            java.lang.CharSequence r9 = (java.lang.CharSequence) r9     // Catch:{ Exception -> 0x00fa }
            r0.setText(r9)     // Catch:{ Exception -> 0x00fa }
            goto L_0x011b
        L_0x00e3:
            com.armmc.app.ui.profile.ProfileFragment r9 = r8.this$0     // Catch:{ Exception -> 0x00fa }
            com.armmc.app.databinding.FragmentProfileBinding r9 = r9.getBinding()     // Catch:{ Exception -> 0x00fa }
            android.widget.LinearLayout r9 = r9.claimedSubdomainContainer     // Catch:{ Exception -> 0x00fa }
            r9.setVisibility(r6)     // Catch:{ Exception -> 0x00fa }
            com.armmc.app.ui.profile.ProfileFragment r9 = r8.this$0     // Catch:{ Exception -> 0x00fa }
            com.armmc.app.databinding.FragmentProfileBinding r9 = r9.getBinding()     // Catch:{ Exception -> 0x00fa }
            android.widget.LinearLayout r9 = r9.unclaimedSubdomainContainer     // Catch:{ Exception -> 0x00fa }
            r9.setVisibility(r5)     // Catch:{ Exception -> 0x00fa }
            goto L_0x011b
        L_0x00fa:
            com.armmc.app.ui.profile.ProfileFragment r9 = r8.this$0
            com.armmc.app.databinding.FragmentProfileBinding r9 = r9._binding
            if (r9 != 0) goto L_0x0105
            kotlin.Unit r9 = kotlin.Unit.INSTANCE
            return r9
        L_0x0105:
            com.armmc.app.ui.profile.ProfileFragment r9 = r8.this$0
            com.armmc.app.databinding.FragmentProfileBinding r9 = r9.getBinding()
            android.widget.ProgressBar r9 = r9.subdomainLoading
            r9.setVisibility(r6)
            com.armmc.app.ui.profile.ProfileFragment r9 = r8.this$0
            com.armmc.app.databinding.FragmentProfileBinding r9 = r9.getBinding()
            android.widget.LinearLayout r9 = r9.unclaimedSubdomainContainer
            r9.setVisibility(r5)
        L_0x011b:
            kotlin.Unit r9 = kotlin.Unit.INSTANCE
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.armmc.app.ui.profile.ProfileFragment$checkSubdomainStatus$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
