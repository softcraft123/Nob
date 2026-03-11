package com.armmc.app.ui.onboarding;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.credentials.Credential;
import androidx.credentials.CredentialManager;
import androidx.credentials.CustomCredential;
import androidx.credentials.GetCredentialRequest;
import androidx.credentials.GetCredentialResponse;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.navigation.fragment.FragmentKt;
import com.armmc.app.R;
import com.armmc.app.billing.UserSubscriptionManager;
import com.armmc.app.ui.onboarding.OnboardingFragment;
import com.google.android.gms.tasks.Task;
import com.google.android.libraries.identity.googleid.GetGoogleIdOption;
import com.google.android.libraries.identity.googleid.GoogleIdTokenCredential;
import com.google.android.libraries.identity.googleid.GoogleIdTokenParsingException;
import com.google.android.material.button.MaterialButton;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseAuthWeakPasswordException;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 H2\u00020\u0001:\u0001HB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J&\u0010$\u001a\u0004\u0018\u00010%2\u0006\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010)2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J\u001a\u0010*\u001a\u00020!2\u0006\u0010+\u001a\u00020%2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J\u0010\u0010,\u001a\u00020!2\u0006\u0010+\u001a\u00020%H\u0002J\b\u0010-\u001a\u00020!H\u0002J\u0010\u0010.\u001a\u00020!2\u0006\u0010/\u001a\u000200H\u0002J\b\u00101\u001a\u00020!H\u0002J\b\u00102\u001a\u00020!H\u0002J\b\u00103\u001a\u00020!H\u0002J\b\u00104\u001a\u00020!H\u0002J\b\u00105\u001a\u00020!H\u0002J\u0018\u00106\u001a\u00020\u001f2\u0006\u00107\u001a\u0002002\u0006\u00108\u001a\u000200H\u0002J\u0018\u00109\u001a\u00020!2\u000e\u0010:\u001a\n\u0018\u00010;j\u0004\u0018\u0001`<H\u0002J\u0010\u0010=\u001a\u00020!2\u0006\u0010>\u001a\u000200H\u0002J\b\u0010?\u001a\u00020!H\u0002J\u0010\u0010@\u001a\u00020!2\u0006\u0010A\u001a\u00020\u001fH\u0002J\b\u0010B\u001a\u00020!H\u0002J\u0010\u0010C\u001a\u00020!2\u0006\u0010D\u001a\u00020EH\u0002J\u0010\u0010F\u001a\u00020!2\u0006\u0010G\u001a\u000200H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X.¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX.¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX.¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX.¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX.¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000bX.¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X.¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0015X.¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0015X.¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0015X.¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0011X.¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u000e¢\u0006\u0002\n\u0000¨\u0006I"}, d2 = {"Lcom/armmc/app/ui/onboarding/SignUpFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "auth", "Lcom/google/firebase/auth/FirebaseAuth;", "credentialManager", "Landroidx/credentials/CredentialManager;", "rootLayout", "Landroidx/constraintlayout/widget/ConstraintLayout;", "backButton", "Landroid/widget/ImageView;", "emailInput", "Landroid/widget/EditText;", "passwordInput", "passwordToggle", "signUpButton", "Lcom/google/android/material/button/MaterialButton;", "loadingProgress", "Landroid/widget/ProgressBar;", "errorText", "Landroid/widget/TextView;", "tosCheckbox", "Landroid/widget/CheckBox;", "loginContainer", "Landroid/widget/LinearLayout;", "logInLink", "termsLink", "privacyLink", "continueGoogleButton", "isPasswordVisible", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "initViews", "setupClickListeners", "openUrl", "url", "", "setupFocusListeners", "setupKeyboardDismissal", "togglePasswordVisibility", "hideKeyboard", "attemptSignUp", "validateInputs", "email", "password", "handleSignUpError", "exception", "Ljava/lang/Exception;", "Lkotlin/Exception;", "showError", "message", "hideError", "setLoading", "loading", "signInWithGoogle", "handleSignInResult", "result", "Landroidx/credentials/GetCredentialResponse;", "firebaseAuthWithGoogle", "idToken", "Companion", "app_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* compiled from: SignUpFragment.kt */
public final class SignUpFragment extends Fragment {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String TAG = "SignUpFragment";
    private FirebaseAuth auth;
    private ImageView backButton;
    private MaterialButton continueGoogleButton;
    /* access modifiers changed from: private */
    public CredentialManager credentialManager;
    private EditText emailInput;
    private TextView errorText;
    private boolean isPasswordVisible;
    private ProgressBar loadingProgress;
    private TextView logInLink;
    private LinearLayout loginContainer;
    private EditText passwordInput;
    private ImageView passwordToggle;
    private TextView privacyLink;
    private ConstraintLayout rootLayout;
    private MaterialButton signUpButton;
    private TextView termsLink;
    private CheckBox tosCheckbox;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/armmc/app/ui/onboarding/SignUpFragment$Companion;", "", "<init>", "()V", "TAG", "", "app_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* compiled from: SignUpFragment.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.auth = FirebaseAuth.getInstance();
        CredentialManager.Companion companion = CredentialManager.Companion;
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
        this.credentialManager = companion.create(requireContext);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.fragment_sign_up, viewGroup, false);
    }

    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        ViewCompat.setOnApplyWindowInsetsListener(view, new SignUpFragment$$ExternalSyntheticLambda0(this));
        initViews(view);
        setupClickListeners();
        setupFocusListeners();
        setupKeyboardDismissal();
    }

    /* access modifiers changed from: private */
    public static final WindowInsetsCompat onViewCreated$lambda$0(SignUpFragment signUpFragment, View view, WindowInsetsCompat windowInsetsCompat) {
        Insets insets = windowInsetsCompat.getInsets(WindowInsetsCompat.Type.systemBars());
        int i = (int) (((float) 24) * signUpFragment.getResources().getDisplayMetrics().density);
        Intrinsics.checkNotNull(view);
        view.setPadding(i, insets.top + i, i, insets.bottom + i);
        return WindowInsetsCompat.CONSUMED;
    }

    private final void initViews(View view) {
        this.rootLayout = (ConstraintLayout) view.findViewById(R.id.rootLayout);
        this.backButton = (ImageView) view.findViewById(R.id.backButton);
        this.emailInput = (EditText) view.findViewById(R.id.emailInput);
        this.passwordInput = (EditText) view.findViewById(R.id.passwordInput);
        this.passwordToggle = (ImageView) view.findViewById(R.id.passwordToggle);
        this.signUpButton = (MaterialButton) view.findViewById(R.id.signUpButton);
        this.loadingProgress = (ProgressBar) view.findViewById(R.id.loadingProgress);
        this.errorText = (TextView) view.findViewById(R.id.errorText);
        this.tosCheckbox = (CheckBox) view.findViewById(R.id.tosCheckbox);
        this.loginContainer = (LinearLayout) view.findViewById(R.id.loginContainer);
        this.logInLink = (TextView) view.findViewById(R.id.logInLink);
        this.termsLink = (TextView) view.findViewById(R.id.termsLink);
        this.privacyLink = (TextView) view.findViewById(R.id.privacyLink);
        this.continueGoogleButton = (MaterialButton) view.findViewById(R.id.continueGoogleButton);
    }

    private final void setupClickListeners() {
        ImageView imageView = this.backButton;
        MaterialButton materialButton = null;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("backButton");
            imageView = null;
        }
        imageView.setOnClickListener(new SignUpFragment$$ExternalSyntheticLambda3(this));
        MaterialButton materialButton2 = this.signUpButton;
        if (materialButton2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("signUpButton");
            materialButton2 = null;
        }
        materialButton2.setOnClickListener(new SignUpFragment$$ExternalSyntheticLambda4(this));
        TextView textView = this.logInLink;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("logInLink");
            textView = null;
        }
        textView.setOnClickListener(new SignUpFragment$$ExternalSyntheticLambda5(this));
        TextView textView2 = this.termsLink;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("termsLink");
            textView2 = null;
        }
        textView2.setOnClickListener(new SignUpFragment$$ExternalSyntheticLambda6(this));
        TextView textView3 = this.privacyLink;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("privacyLink");
            textView3 = null;
        }
        textView3.setOnClickListener(new SignUpFragment$$ExternalSyntheticLambda7(this));
        ImageView imageView2 = this.passwordToggle;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("passwordToggle");
            imageView2 = null;
        }
        imageView2.setOnClickListener(new SignUpFragment$$ExternalSyntheticLambda8(this));
        MaterialButton materialButton3 = this.continueGoogleButton;
        if (materialButton3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("continueGoogleButton");
        } else {
            materialButton = materialButton3;
        }
        materialButton.setOnClickListener(new SignUpFragment$$ExternalSyntheticLambda9(this));
    }

    /* access modifiers changed from: private */
    public static final void setupClickListeners$lambda$1(SignUpFragment signUpFragment, View view) {
        signUpFragment.hideKeyboard();
        FragmentKt.findNavController(signUpFragment).navigateUp();
    }

    /* access modifiers changed from: private */
    public static final void setupClickListeners$lambda$2(SignUpFragment signUpFragment, View view) {
        signUpFragment.hideKeyboard();
        signUpFragment.attemptSignUp();
    }

    /* access modifiers changed from: private */
    public static final void setupClickListeners$lambda$3(SignUpFragment signUpFragment, View view) {
        signUpFragment.hideKeyboard();
        FragmentKt.findNavController(signUpFragment).navigate(R.id.action_signUp_to_login);
    }

    /* access modifiers changed from: private */
    public static final void setupClickListeners$lambda$4(SignUpFragment signUpFragment, View view) {
        signUpFragment.openUrl("https://witherhost.com/terms-of-service/");
    }

    /* access modifiers changed from: private */
    public static final void setupClickListeners$lambda$5(SignUpFragment signUpFragment, View view) {
        signUpFragment.openUrl("https://witherhost.com/privacy-policy/");
    }

    /* access modifiers changed from: private */
    public static final void setupClickListeners$lambda$6(SignUpFragment signUpFragment, View view) {
        signUpFragment.togglePasswordVisibility();
    }

    /* access modifiers changed from: private */
    public static final void setupClickListeners$lambda$7(SignUpFragment signUpFragment, View view) {
        signUpFragment.signInWithGoogle();
    }

    private final void openUrl(String str) {
        try {
            startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
        } catch (Exception unused) {
            Toast.makeText(getContext(), "Unable to open link", 0).show();
        }
    }

    private final void setupFocusListeners() {
        SignUpFragment$$ExternalSyntheticLambda1 signUpFragment$$ExternalSyntheticLambda1 = new SignUpFragment$$ExternalSyntheticLambda1(this);
        EditText editText = this.emailInput;
        EditText editText2 = null;
        if (editText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("emailInput");
            editText = null;
        }
        editText.setOnFocusChangeListener(signUpFragment$$ExternalSyntheticLambda1);
        EditText editText3 = this.passwordInput;
        if (editText3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("passwordInput");
        } else {
            editText2 = editText3;
        }
        editText2.setOnFocusChangeListener(signUpFragment$$ExternalSyntheticLambda1);
    }

    /* access modifiers changed from: private */
    public static final void setupFocusListeners$lambda$8(SignUpFragment signUpFragment, View view, boolean z) {
        LinearLayout linearLayout = signUpFragment.loginContainer;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("loginContainer");
            linearLayout = null;
        }
        linearLayout.setVisibility(z ? 8 : 0);
    }

    private final void setupKeyboardDismissal() {
        ConstraintLayout constraintLayout = this.rootLayout;
        if (constraintLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rootLayout");
            constraintLayout = null;
        }
        constraintLayout.setOnTouchListener(new SignUpFragment$$ExternalSyntheticLambda2(this));
    }

    /* access modifiers changed from: private */
    public static final boolean setupKeyboardDismissal$lambda$9(SignUpFragment signUpFragment, View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() != 0) {
            return false;
        }
        signUpFragment.hideKeyboard();
        EditText editText = signUpFragment.emailInput;
        ConstraintLayout constraintLayout = null;
        if (editText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("emailInput");
            editText = null;
        }
        editText.clearFocus();
        EditText editText2 = signUpFragment.passwordInput;
        if (editText2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("passwordInput");
            editText2 = null;
        }
        editText2.clearFocus();
        ConstraintLayout constraintLayout2 = signUpFragment.rootLayout;
        if (constraintLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rootLayout");
        } else {
            constraintLayout = constraintLayout2;
        }
        constraintLayout.requestFocus();
        return false;
    }

    private final void togglePasswordVisibility() {
        boolean z = this.isPasswordVisible;
        this.isPasswordVisible = !z;
        EditText editText = null;
        if (!z) {
            EditText editText2 = this.passwordInput;
            if (editText2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("passwordInput");
                editText2 = null;
            }
            editText2.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
            ImageView imageView = this.passwordToggle;
            if (imageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("passwordToggle");
                imageView = null;
            }
            imageView.setImageResource(R.drawable.ic_visibility_off);
        } else {
            EditText editText3 = this.passwordInput;
            if (editText3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("passwordInput");
                editText3 = null;
            }
            editText3.setTransformationMethod(PasswordTransformationMethod.getInstance());
            ImageView imageView2 = this.passwordToggle;
            if (imageView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("passwordToggle");
                imageView2 = null;
            }
            imageView2.setImageResource(R.drawable.ic_visibility);
        }
        EditText editText4 = this.passwordInput;
        if (editText4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("passwordInput");
            editText4 = null;
        }
        EditText editText5 = this.passwordInput;
        if (editText5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("passwordInput");
        } else {
            editText = editText5;
        }
        Editable text = editText.getText();
        editText4.setSelection(text != null ? text.length() : 0);
    }

    private final void hideKeyboard() {
        Object systemService = requireContext().getSystemService("input_method");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        InputMethodManager inputMethodManager = (InputMethodManager) systemService;
        View view = getView();
        inputMethodManager.hideSoftInputFromWindow(view != null ? view.getWindowToken() : null, 0);
    }

    private final void attemptSignUp() {
        String str;
        String obj;
        String obj2;
        EditText editText = this.emailInput;
        FirebaseAuth firebaseAuth = null;
        if (editText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("emailInput");
            editText = null;
        }
        Editable text = editText.getText();
        String str2 = "";
        if (text == null || (obj2 = text.toString()) == null || (str = StringsKt.trim((CharSequence) obj2).toString()) == null) {
            str = str2;
        }
        EditText editText2 = this.passwordInput;
        if (editText2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("passwordInput");
            editText2 = null;
        }
        Editable text2 = editText2.getText();
        if (!(text2 == null || (obj = text2.toString()) == null)) {
            str2 = obj;
        }
        hideError();
        if (validateInputs(str, str2)) {
            setLoading(true);
            FirebaseAuth firebaseAuth2 = this.auth;
            if (firebaseAuth2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("auth");
            } else {
                firebaseAuth = firebaseAuth2;
            }
            firebaseAuth.createUserWithEmailAndPassword(str, str2).addOnCompleteListener((Activity) requireActivity(), new SignUpFragment$$ExternalSyntheticLambda11(this));
        }
    }

    /* access modifiers changed from: private */
    public static final void attemptSignUp$lambda$11(SignUpFragment signUpFragment, Task task) {
        Intrinsics.checkNotNullParameter(task, "task");
        if (!signUpFragment.isAdded()) {
            Log.w(TAG, "Fragment not attached, ignoring sign-up result");
            return;
        }
        signUpFragment.setLoading(false);
        if (task.isSuccessful()) {
            FirebaseAuth firebaseAuth = signUpFragment.auth;
            if (firebaseAuth == null) {
                Intrinsics.throwUninitializedPropertyAccessException("auth");
                firebaseAuth = null;
            }
            FirebaseUser currentUser = firebaseAuth.getCurrentUser();
            if (currentUser != null) {
                UserSubscriptionManager.initializeUserDocument$default(UserSubscriptionManager.INSTANCE, currentUser, (Function1) null, 2, (Object) null);
            }
            OnboardingFragment.Companion companion = OnboardingFragment.Companion;
            Context requireContext = signUpFragment.requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
            companion.setOnboardingCompleted(requireContext, true);
            OnboardingFragment.Companion companion2 = OnboardingFragment.Companion;
            Context requireContext2 = signUpFragment.requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext2, "requireContext(...)");
            companion2.setHasLoggedInBefore(requireContext2, true);
            FragmentKt.findNavController(signUpFragment).navigate(R.id.action_signUp_to_servers);
            return;
        }
        signUpFragment.handleSignUpError(task.getException());
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x002c  */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0033  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0045  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0051  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0057 A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean validateInputs(java.lang.String r3, java.lang.String r4) {
        /*
            r2 = this;
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            int r0 = r3.length()
            r1 = 0
            if (r0 != 0) goto L_0x0010
            java.lang.String r3 = "Please enter your email address"
            r2.showError(r3)
        L_0x000e:
            r3 = r1
            goto L_0x0023
        L_0x0010:
            java.util.regex.Pattern r0 = android.util.Patterns.EMAIL_ADDRESS
            java.util.regex.Matcher r3 = r0.matcher(r3)
            boolean r3 = r3.matches()
            if (r3 != 0) goto L_0x0022
            java.lang.String r3 = "Please enter a valid email address"
            r2.showError(r3)
            goto L_0x000e
        L_0x0022:
            r3 = 1
        L_0x0023:
            r0 = r4
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            int r0 = r0.length()
            if (r0 != 0) goto L_0x0033
            java.lang.String r3 = "Please enter a password"
            r2.showError(r3)
        L_0x0031:
            r3 = r1
            goto L_0x0041
        L_0x0033:
            int r4 = r4.length()
            r0 = 8
            if (r4 >= r0) goto L_0x0041
            java.lang.String r3 = "Password must be at least 8 characters"
            r2.showError(r3)
            goto L_0x0031
        L_0x0041:
            android.widget.CheckBox r4 = r2.tosCheckbox
            if (r4 != 0) goto L_0x004b
            java.lang.String r4 = "tosCheckbox"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r4)
            r4 = 0
        L_0x004b:
            boolean r4 = r4.isChecked()
            if (r4 != 0) goto L_0x0057
            java.lang.String r3 = "Please agree to the Terms of Service"
            r2.showError(r3)
            return r1
        L_0x0057:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.armmc.app.ui.onboarding.SignUpFragment.validateInputs(java.lang.String, java.lang.String):boolean");
    }

    private final void handleSignUpError(Exception exc) {
        String str;
        if (exc instanceof FirebaseAuthUserCollisionException) {
            str = "An account with this email already exists";
        } else if (exc instanceof FirebaseAuthWeakPasswordException) {
            str = "Password is too weak. Please use a stronger password";
        } else if (exc instanceof FirebaseAuthInvalidCredentialsException) {
            str = "Invalid email format";
        } else if (exc == null || (str = exc.getMessage()) == null) {
            str = "Sign up failed. Please try again";
        }
        showError(str);
    }

    /* access modifiers changed from: private */
    public final void showError(String str) {
        TextView textView = this.errorText;
        TextView textView2 = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("errorText");
            textView = null;
        }
        textView.setText(str);
        TextView textView3 = this.errorText;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("errorText");
        } else {
            textView2 = textView3;
        }
        textView2.setVisibility(0);
    }

    private final void hideError() {
        TextView textView = this.errorText;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("errorText");
            textView = null;
        }
        textView.setVisibility(8);
    }

    /* access modifiers changed from: private */
    public final void setLoading(boolean z) {
        ProgressBar progressBar = null;
        if (z) {
            MaterialButton materialButton = this.signUpButton;
            if (materialButton == null) {
                Intrinsics.throwUninitializedPropertyAccessException("signUpButton");
                materialButton = null;
            }
            materialButton.setText("");
            MaterialButton materialButton2 = this.signUpButton;
            if (materialButton2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("signUpButton");
                materialButton2 = null;
            }
            materialButton2.setEnabled(false);
            ProgressBar progressBar2 = this.loadingProgress;
            if (progressBar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("loadingProgress");
            } else {
                progressBar = progressBar2;
            }
            progressBar.setVisibility(0);
            return;
        }
        MaterialButton materialButton3 = this.signUpButton;
        if (materialButton3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("signUpButton");
            materialButton3 = null;
        }
        materialButton3.setText("Sign Up");
        MaterialButton materialButton4 = this.signUpButton;
        if (materialButton4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("signUpButton");
            materialButton4 = null;
        }
        materialButton4.setEnabled(true);
        ProgressBar progressBar3 = this.loadingProgress;
        if (progressBar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("loadingProgress");
        } else {
            progressBar = progressBar3;
        }
        progressBar.setVisibility(8);
    }

    private final void signInWithGoogle() {
        hideKeyboard();
        setLoading(true);
        GetCredentialRequest build = new GetCredentialRequest.Builder().addCredentialOption(new GetGoogleIdOption.Builder().setFilterByAuthorizedAccounts(false).setServerClientId(LoginFragment.WEB_CLIENT_ID).build()).build();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        Job unused = BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner), (CoroutineContext) null, (CoroutineStart) null, new SignUpFragment$signInWithGoogle$1(this, build, (Continuation<? super SignUpFragment$signInWithGoogle$1>) null), 3, (Object) null);
    }

    /* access modifiers changed from: private */
    public final void handleSignInResult(GetCredentialResponse getCredentialResponse) {
        if (isAdded()) {
            Credential credential = getCredentialResponse.getCredential();
            if (!(credential instanceof CustomCredential)) {
                Log.e(TAG, "Unexpected credential type");
                if (isAdded()) {
                    setLoading(false);
                    showError("Unexpected credential type");
                }
            } else if (Intrinsics.areEqual((Object) credential.getType(), (Object) GoogleIdTokenCredential.TYPE_GOOGLE_ID_TOKEN_CREDENTIAL)) {
                try {
                    firebaseAuthWithGoogle(GoogleIdTokenCredential.Companion.createFrom(credential.getData()).getIdToken());
                } catch (GoogleIdTokenParsingException e) {
                    Log.e(TAG, "Failed to parse Google ID token", e);
                    if (isAdded()) {
                        setLoading(false);
                        showError("Failed to process Google Sign-In");
                    }
                }
            } else {
                Log.e(TAG, "Unexpected credential type: " + credential.getType());
                if (isAdded()) {
                    setLoading(false);
                    showError("Unexpected credential type");
                }
            }
        }
    }

    private final void firebaseAuthWithGoogle(String str) {
        FirebaseAuth firebaseAuth = null;
        AuthCredential credential = GoogleAuthProvider.getCredential(str, (String) null);
        Intrinsics.checkNotNullExpressionValue(credential, "getCredential(...)");
        FirebaseAuth firebaseAuth2 = this.auth;
        if (firebaseAuth2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("auth");
        } else {
            firebaseAuth = firebaseAuth2;
        }
        firebaseAuth.signInWithCredential(credential).addOnCompleteListener((Activity) requireActivity(), new SignUpFragment$$ExternalSyntheticLambda10(this));
    }

    /* access modifiers changed from: private */
    public static final void firebaseAuthWithGoogle$lambda$13(SignUpFragment signUpFragment, Task task) {
        Intrinsics.checkNotNullParameter(task, "task");
        if (!signUpFragment.isAdded()) {
            Log.w(TAG, "Fragment not attached, ignoring auth result");
            return;
        }
        signUpFragment.setLoading(false);
        String str = null;
        if (task.isSuccessful()) {
            Log.d(TAG, "signInWithCredential:success");
            FirebaseAuth firebaseAuth = signUpFragment.auth;
            if (firebaseAuth == null) {
                Intrinsics.throwUninitializedPropertyAccessException("auth");
                firebaseAuth = null;
            }
            FirebaseUser currentUser = firebaseAuth.getCurrentUser();
            if (currentUser != null) {
                UserSubscriptionManager.initializeUserDocument$default(UserSubscriptionManager.INSTANCE, currentUser, (Function1) null, 2, (Object) null);
            }
            OnboardingFragment.Companion companion = OnboardingFragment.Companion;
            Context requireContext = signUpFragment.requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
            companion.setOnboardingCompleted(requireContext, true);
            OnboardingFragment.Companion companion2 = OnboardingFragment.Companion;
            Context requireContext2 = signUpFragment.requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext2, "requireContext(...)");
            companion2.setHasLoggedInBefore(requireContext2, true);
            FragmentKt.findNavController(signUpFragment).navigate(R.id.action_signUp_to_servers);
            return;
        }
        Log.w(TAG, "signInWithCredential:failure", task.getException());
        Exception exception = task.getException();
        if (exception != null) {
            str = exception.getMessage();
        }
        signUpFragment.showError("Authentication failed: " + str);
    }
}
