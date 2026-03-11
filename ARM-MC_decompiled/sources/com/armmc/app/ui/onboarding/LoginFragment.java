package com.armmc.app.ui.onboarding;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.Editable;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
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
import com.google.firebase.auth.FirebaseAuthInvalidUserException;
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

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 D2\u00020\u0001:\u0001DB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J&\u0010!\u001a\u0004\u0018\u00010\"2\u0006\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010&2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\u001a\u0010'\u001a\u00020\u001e2\u0006\u0010(\u001a\u00020\"2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\u0010\u0010)\u001a\u00020\u001e2\u0006\u0010(\u001a\u00020\"H\u0002J\b\u0010*\u001a\u00020\u001eH\u0002J\b\u0010+\u001a\u00020\u001eH\u0002J\b\u0010,\u001a\u00020\u001eH\u0002J\b\u0010-\u001a\u00020\u001eH\u0002J\b\u0010.\u001a\u00020\u001eH\u0002J\b\u0010/\u001a\u00020\u001eH\u0002J\u0018\u00100\u001a\u00020\u001c2\u0006\u00101\u001a\u0002022\u0006\u00103\u001a\u000202H\u0002J\u0018\u00104\u001a\u00020\u001e2\u000e\u00105\u001a\n\u0018\u000106j\u0004\u0018\u0001`7H\u0002J\b\u00108\u001a\u00020\u001eH\u0002J\u0010\u00109\u001a\u00020\u001e2\u0006\u0010:\u001a\u000202H\u0002J\b\u0010;\u001a\u00020\u001eH\u0002J\u0010\u0010<\u001a\u00020\u001e2\u0006\u0010=\u001a\u00020\u001cH\u0002J\b\u0010>\u001a\u00020\u001eH\u0002J\u0010\u0010?\u001a\u00020\u001e2\u0006\u0010@\u001a\u00020AH\u0002J\u0010\u0010B\u001a\u00020\u001e2\u0006\u0010C\u001a\u000202H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X.¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX.¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX.¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX.¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX.¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000bX.¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0011X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0013X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X.¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0011X.¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u000e¢\u0006\u0002\n\u0000¨\u0006E"}, d2 = {"Lcom/armmc/app/ui/onboarding/LoginFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "auth", "Lcom/google/firebase/auth/FirebaseAuth;", "credentialManager", "Landroidx/credentials/CredentialManager;", "rootLayout", "Landroidx/constraintlayout/widget/ConstraintLayout;", "backButton", "Landroid/widget/ImageView;", "emailInput", "Landroid/widget/EditText;", "passwordInput", "passwordToggle", "forgotPasswordLink", "Landroid/widget/TextView;", "loginButton", "Lcom/google/android/material/button/MaterialButton;", "loadingProgress", "Landroid/widget/ProgressBar;", "errorText", "continueGoogleButton", "signUpContainer", "Landroid/widget/LinearLayout;", "signUpLink", "isPasswordVisible", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "initViews", "setupClickListeners", "setupFocusListeners", "setupKeyboardDismissal", "togglePasswordVisibility", "hideKeyboard", "attemptLogin", "validateInputs", "email", "", "password", "handleLoginError", "exception", "Ljava/lang/Exception;", "Lkotlin/Exception;", "handleForgotPassword", "showError", "message", "hideError", "setLoading", "loading", "signInWithGoogle", "handleSignInResult", "result", "Landroidx/credentials/GetCredentialResponse;", "firebaseAuthWithGoogle", "idToken", "Companion", "app_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* compiled from: LoginFragment.kt */
public final class LoginFragment extends Fragment {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String TAG = "LoginFragment";
    public static final String WEB_CLIENT_ID = "276292879066-q1tk5a9hbe7u15kksd941pbufkh4d8bb.apps.googleusercontent.com";
    private FirebaseAuth auth;
    private ImageView backButton;
    private MaterialButton continueGoogleButton;
    /* access modifiers changed from: private */
    public CredentialManager credentialManager;
    private EditText emailInput;
    private TextView errorText;
    private TextView forgotPasswordLink;
    private boolean isPasswordVisible;
    private ProgressBar loadingProgress;
    private MaterialButton loginButton;
    private EditText passwordInput;
    private ImageView passwordToggle;
    private ConstraintLayout rootLayout;
    private LinearLayout signUpContainer;
    private TextView signUpLink;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/armmc/app/ui/onboarding/LoginFragment$Companion;", "", "<init>", "()V", "TAG", "", "WEB_CLIENT_ID", "app_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* compiled from: LoginFragment.kt */
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
        return layoutInflater.inflate(R.layout.fragment_login, viewGroup, false);
    }

    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        ViewCompat.setOnApplyWindowInsetsListener(view, new LoginFragment$$ExternalSyntheticLambda3(this));
        initViews(view);
        setupClickListeners();
        setupFocusListeners();
        setupKeyboardDismissal();
    }

    /* access modifiers changed from: private */
    public static final WindowInsetsCompat onViewCreated$lambda$0(LoginFragment loginFragment, View view, WindowInsetsCompat windowInsetsCompat) {
        Insets insets = windowInsetsCompat.getInsets(WindowInsetsCompat.Type.systemBars());
        int i = (int) (((float) 24) * loginFragment.getResources().getDisplayMetrics().density);
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
        this.forgotPasswordLink = (TextView) view.findViewById(R.id.forgotPasswordLink);
        this.loginButton = (MaterialButton) view.findViewById(R.id.loginButton);
        this.loadingProgress = (ProgressBar) view.findViewById(R.id.loadingProgress);
        this.errorText = (TextView) view.findViewById(R.id.errorText);
        this.continueGoogleButton = (MaterialButton) view.findViewById(R.id.continueGoogleButton);
        this.signUpContainer = (LinearLayout) view.findViewById(R.id.signUpContainer);
        this.signUpLink = (TextView) view.findViewById(R.id.signUpLink);
    }

    private final void setupClickListeners() {
        ImageView imageView = this.backButton;
        ImageView imageView2 = null;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("backButton");
            imageView = null;
        }
        imageView.setOnClickListener(new LoginFragment$$ExternalSyntheticLambda4(this));
        MaterialButton materialButton = this.loginButton;
        if (materialButton == null) {
            Intrinsics.throwUninitializedPropertyAccessException("loginButton");
            materialButton = null;
        }
        materialButton.setOnClickListener(new LoginFragment$$ExternalSyntheticLambda5(this));
        TextView textView = this.signUpLink;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("signUpLink");
            textView = null;
        }
        textView.setOnClickListener(new LoginFragment$$ExternalSyntheticLambda6(this));
        TextView textView2 = this.forgotPasswordLink;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("forgotPasswordLink");
            textView2 = null;
        }
        textView2.setOnClickListener(new LoginFragment$$ExternalSyntheticLambda7(this));
        MaterialButton materialButton2 = this.continueGoogleButton;
        if (materialButton2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("continueGoogleButton");
            materialButton2 = null;
        }
        materialButton2.setOnClickListener(new LoginFragment$$ExternalSyntheticLambda8(this));
        ImageView imageView3 = this.passwordToggle;
        if (imageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("passwordToggle");
        } else {
            imageView2 = imageView3;
        }
        imageView2.setOnClickListener(new LoginFragment$$ExternalSyntheticLambda9(this));
    }

    /* access modifiers changed from: private */
    public static final void setupClickListeners$lambda$1(LoginFragment loginFragment, View view) {
        loginFragment.hideKeyboard();
        FragmentKt.findNavController(loginFragment).navigateUp();
    }

    /* access modifiers changed from: private */
    public static final void setupClickListeners$lambda$2(LoginFragment loginFragment, View view) {
        loginFragment.hideKeyboard();
        loginFragment.attemptLogin();
    }

    /* access modifiers changed from: private */
    public static final void setupClickListeners$lambda$3(LoginFragment loginFragment, View view) {
        loginFragment.hideKeyboard();
        FragmentKt.findNavController(loginFragment).navigate(R.id.action_login_to_signUp);
    }

    /* access modifiers changed from: private */
    public static final void setupClickListeners$lambda$4(LoginFragment loginFragment, View view) {
        loginFragment.hideKeyboard();
        loginFragment.handleForgotPassword();
    }

    /* access modifiers changed from: private */
    public static final void setupClickListeners$lambda$5(LoginFragment loginFragment, View view) {
        loginFragment.signInWithGoogle();
    }

    /* access modifiers changed from: private */
    public static final void setupClickListeners$lambda$6(LoginFragment loginFragment, View view) {
        loginFragment.togglePasswordVisibility();
    }

    private final void setupFocusListeners() {
        LoginFragment$$ExternalSyntheticLambda10 loginFragment$$ExternalSyntheticLambda10 = new LoginFragment$$ExternalSyntheticLambda10(this);
        EditText editText = this.emailInput;
        EditText editText2 = null;
        if (editText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("emailInput");
            editText = null;
        }
        editText.setOnFocusChangeListener(loginFragment$$ExternalSyntheticLambda10);
        EditText editText3 = this.passwordInput;
        if (editText3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("passwordInput");
        } else {
            editText2 = editText3;
        }
        editText2.setOnFocusChangeListener(loginFragment$$ExternalSyntheticLambda10);
    }

    /* access modifiers changed from: private */
    public static final void setupFocusListeners$lambda$7(LoginFragment loginFragment, View view, boolean z) {
        LinearLayout linearLayout = loginFragment.signUpContainer;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("signUpContainer");
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
        constraintLayout.setOnTouchListener(new LoginFragment$$ExternalSyntheticLambda2(this));
    }

    /* access modifiers changed from: private */
    public static final boolean setupKeyboardDismissal$lambda$8(LoginFragment loginFragment, View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() != 0) {
            return false;
        }
        loginFragment.hideKeyboard();
        EditText editText = loginFragment.emailInput;
        ConstraintLayout constraintLayout = null;
        if (editText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("emailInput");
            editText = null;
        }
        editText.clearFocus();
        EditText editText2 = loginFragment.passwordInput;
        if (editText2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("passwordInput");
            editText2 = null;
        }
        editText2.clearFocus();
        ConstraintLayout constraintLayout2 = loginFragment.rootLayout;
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

    private final void attemptLogin() {
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
            firebaseAuth.signInWithEmailAndPassword(str, str2).addOnCompleteListener((Activity) requireActivity(), new LoginFragment$$ExternalSyntheticLambda0(this));
        }
    }

    /* access modifiers changed from: private */
    public static final void attemptLogin$lambda$10(LoginFragment loginFragment, Task task) {
        Intrinsics.checkNotNullParameter(task, "task");
        loginFragment.setLoading(false);
        if (task.isSuccessful()) {
            FirebaseAuth firebaseAuth = loginFragment.auth;
            if (firebaseAuth == null) {
                Intrinsics.throwUninitializedPropertyAccessException("auth");
                firebaseAuth = null;
            }
            FirebaseUser currentUser = firebaseAuth.getCurrentUser();
            if (currentUser != null) {
                UserSubscriptionManager.initializeUserDocument$default(UserSubscriptionManager.INSTANCE, currentUser, (Function1) null, 2, (Object) null);
            }
            OnboardingFragment.Companion companion = OnboardingFragment.Companion;
            Context requireContext = loginFragment.requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
            companion.setOnboardingCompleted(requireContext, true);
            OnboardingFragment.Companion companion2 = OnboardingFragment.Companion;
            Context requireContext2 = loginFragment.requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext2, "requireContext(...)");
            companion2.setHasLoggedInBefore(requireContext2, true);
            FragmentKt.findNavController(loginFragment).navigate(R.id.action_login_to_servers);
            return;
        }
        loginFragment.handleLoginError(task.getException());
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x002b  */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0031 A[RETURN] */
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
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            int r4 = r4.length()
            if (r4 != 0) goto L_0x0031
            java.lang.String r3 = "Please enter your password"
            r2.showError(r3)
            return r1
        L_0x0031:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.armmc.app.ui.onboarding.LoginFragment.validateInputs(java.lang.String, java.lang.String):boolean");
    }

    private final void handleLoginError(Exception exc) {
        String str;
        if (exc instanceof FirebaseAuthInvalidUserException) {
            str = "No account found with this email address";
        } else if (exc instanceof FirebaseAuthInvalidCredentialsException) {
            str = "Invalid email or password";
        } else if (exc == null || (str = exc.getMessage()) == null) {
            str = "Login failed. Please try again";
        }
        showError(str);
    }

    private final void handleForgotPassword() {
        String str;
        String obj;
        EditText editText = this.emailInput;
        FirebaseAuth firebaseAuth = null;
        if (editText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("emailInput");
            editText = null;
        }
        Editable text = editText.getText();
        if (text == null || (obj = text.toString()) == null || (str = StringsKt.trim((CharSequence) obj).toString()) == null) {
            str = "";
        }
        CharSequence charSequence = str;
        if (charSequence.length() == 0) {
            showError("Please enter your email address first");
        } else if (!Patterns.EMAIL_ADDRESS.matcher(charSequence).matches()) {
            showError("Please enter a valid email address");
        } else {
            setLoading(true);
            FirebaseAuth firebaseAuth2 = this.auth;
            if (firebaseAuth2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("auth");
            } else {
                firebaseAuth = firebaseAuth2;
            }
            firebaseAuth.sendPasswordResetEmail(str).addOnCompleteListener((Activity) requireActivity(), new LoginFragment$$ExternalSyntheticLambda11(this));
        }
    }

    /* access modifiers changed from: private */
    public static final void handleForgotPassword$lambda$11(LoginFragment loginFragment, Task task) {
        String str;
        Intrinsics.checkNotNullParameter(task, "task");
        loginFragment.setLoading(false);
        if (task.isSuccessful()) {
            loginFragment.hideError();
            TextView textView = loginFragment.errorText;
            TextView textView2 = null;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("errorText");
                textView = null;
            }
            textView.setTextColor(loginFragment.getResources().getColor(17170452, (Resources.Theme) null));
            TextView textView3 = loginFragment.errorText;
            if (textView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("errorText");
                textView3 = null;
            }
            textView3.setText("Password reset email sent. Check your inbox and spam.");
            TextView textView4 = loginFragment.errorText;
            if (textView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("errorText");
            } else {
                textView2 = textView4;
            }
            textView2.setVisibility(0);
            return;
        }
        Exception exception = task.getException();
        if (exception == null || (str = exception.getMessage()) == null) {
            str = "Failed to send reset email";
        }
        loginFragment.showError(str);
    }

    /* access modifiers changed from: private */
    public final void showError(String str) {
        TextView textView = this.errorText;
        TextView textView2 = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("errorText");
            textView = null;
        }
        textView.setTextColor(getResources().getColor(17170454, (Resources.Theme) null));
        TextView textView3 = this.errorText;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("errorText");
            textView3 = null;
        }
        textView3.setText(str);
        TextView textView4 = this.errorText;
        if (textView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("errorText");
        } else {
            textView2 = textView4;
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
            MaterialButton materialButton = this.loginButton;
            if (materialButton == null) {
                Intrinsics.throwUninitializedPropertyAccessException("loginButton");
                materialButton = null;
            }
            materialButton.setText("");
            MaterialButton materialButton2 = this.loginButton;
            if (materialButton2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("loginButton");
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
        MaterialButton materialButton3 = this.loginButton;
        if (materialButton3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("loginButton");
            materialButton3 = null;
        }
        materialButton3.setText("Login");
        MaterialButton materialButton4 = this.loginButton;
        if (materialButton4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("loginButton");
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
        GetCredentialRequest build = new GetCredentialRequest.Builder().addCredentialOption(new GetGoogleIdOption.Builder().setFilterByAuthorizedAccounts(false).setServerClientId(WEB_CLIENT_ID).build()).build();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        Job unused = BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner), (CoroutineContext) null, (CoroutineStart) null, new LoginFragment$signInWithGoogle$1(this, build, (Continuation<? super LoginFragment$signInWithGoogle$1>) null), 3, (Object) null);
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
        firebaseAuth.signInWithCredential(credential).addOnCompleteListener((Activity) requireActivity(), new LoginFragment$$ExternalSyntheticLambda1(this));
    }

    /* access modifiers changed from: private */
    public static final void firebaseAuthWithGoogle$lambda$13(LoginFragment loginFragment, Task task) {
        Intrinsics.checkNotNullParameter(task, "task");
        if (!loginFragment.isAdded()) {
            Log.w(TAG, "Fragment not attached, ignoring auth result");
            return;
        }
        loginFragment.setLoading(false);
        String str = null;
        if (task.isSuccessful()) {
            Log.d(TAG, "signInWithCredential:success");
            FirebaseAuth firebaseAuth = loginFragment.auth;
            if (firebaseAuth == null) {
                Intrinsics.throwUninitializedPropertyAccessException("auth");
                firebaseAuth = null;
            }
            FirebaseUser currentUser = firebaseAuth.getCurrentUser();
            if (currentUser != null) {
                UserSubscriptionManager.initializeUserDocument$default(UserSubscriptionManager.INSTANCE, currentUser, (Function1) null, 2, (Object) null);
            }
            OnboardingFragment.Companion companion = OnboardingFragment.Companion;
            Context requireContext = loginFragment.requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
            companion.setOnboardingCompleted(requireContext, true);
            OnboardingFragment.Companion companion2 = OnboardingFragment.Companion;
            Context requireContext2 = loginFragment.requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext2, "requireContext(...)");
            companion2.setHasLoggedInBefore(requireContext2, true);
            FragmentKt.findNavController(loginFragment).navigate(R.id.action_login_to_servers);
            return;
        }
        Log.w(TAG, "signInWithCredential:failure", task.getException());
        Exception exception = task.getException();
        if (exception != null) {
            str = exception.getMessage();
        }
        loginFragment.showError("Authentication failed: " + str);
    }
}
