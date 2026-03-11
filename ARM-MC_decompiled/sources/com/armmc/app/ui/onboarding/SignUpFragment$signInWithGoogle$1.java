package com.armmc.app.ui.onboarding;

import android.content.Context;
import android.util.Log;
import androidx.credentials.CredentialManager;
import androidx.credentials.GetCredentialRequest;
import androidx.credentials.GetCredentialResponse;
import androidx.credentials.exceptions.GetCredentialException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.armmc.app.ui.onboarding.SignUpFragment$signInWithGoogle$1", f = "SignUpFragment.kt", i = {}, l = {333}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: SignUpFragment.kt */
final class SignUpFragment$signInWithGoogle$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ GetCredentialRequest $request;
    int label;
    final /* synthetic */ SignUpFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SignUpFragment$signInWithGoogle$1(SignUpFragment signUpFragment, GetCredentialRequest getCredentialRequest, Continuation<? super SignUpFragment$signInWithGoogle$1> continuation) {
        super(2, continuation);
        this.this$0 = signUpFragment;
        this.$request = getCredentialRequest;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SignUpFragment$signInWithGoogle$1(this.this$0, this.$request, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((SignUpFragment$signInWithGoogle$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            CredentialManager access$getCredentialManager$p = this.this$0.credentialManager;
            if (access$getCredentialManager$p == null) {
                Intrinsics.throwUninitializedPropertyAccessException("credentialManager");
                access$getCredentialManager$p = null;
            }
            Context requireContext = this.this$0.requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
            this.label = 1;
            obj = access$getCredentialManager$p.getCredential(requireContext, this.$request, (Continuation<? super GetCredentialResponse>) this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            try {
                ResultKt.throwOnFailure(obj);
            } catch (GetCredentialException e) {
                Log.e("SignUpFragment", "Google Sign-In failed", e);
                if (this.this$0.isAdded()) {
                    this.this$0.setLoading(false);
                    this.this$0.showError("Google Sign-In failed: " + e.getMessage());
                }
            }
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        this.this$0.handleSignInResult((GetCredentialResponse) obj);
        return Unit.INSTANCE;
    }
}
