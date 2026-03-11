package com.armmc.app.ui.onboarding;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.content.ContextCompat;
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
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.fragment.FragmentKt;
import androidx.viewpager2.widget.ViewPager2;
import com.armmc.app.R;
import com.google.android.gms.tasks.Task;
import com.google.android.libraries.identity.googleid.GetGoogleIdOption;
import com.google.android.libraries.identity.googleid.GoogleIdTokenCredential;
import com.google.android.libraries.identity.googleid.GoogleIdTokenParsingException;
import com.google.android.material.button.MaterialButton;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.GoogleAuthProvider;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 .2\u00020\u0001:\u0001.B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0015\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\u001a\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u00102\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\b\u0010\u001f\u001a\u00020\u001dH\u0002J\b\u0010 \u001a\u00020\u001dH\u0002J\u0010\u0010!\u001a\u00020\u001d2\u0006\u0010\"\u001a\u00020#H\u0002J\u0010\u0010$\u001a\u00020\u001d2\u0006\u0010\"\u001a\u00020#H\u0002J\b\u0010%\u001a\u00020\u001dH\u0002J\b\u0010&\u001a\u00020\u001dH\u0002J\b\u0010'\u001a\u00020\u001dH\u0002J\u0010\u0010(\u001a\u00020\u001d2\u0006\u0010)\u001a\u00020*H\u0002J\u0010\u0010+\u001a\u00020\u001d2\u0006\u0010,\u001a\u00020-H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X.¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX.¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX.¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX.¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X.¢\u0006\u0002\n\u0000¨\u0006/"}, d2 = {"Lcom/armmc/app/ui/onboarding/OnboardingFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "viewPager", "Landroidx/viewpager2/widget/ViewPager2;", "pageIndicatorContainer", "Landroid/widget/LinearLayout;", "nextButton", "Lcom/google/android/material/button/MaterialButton;", "skipButton", "Landroid/widget/TextView;", "backButton", "Landroid/widget/ImageView;", "indicators", "", "Landroid/view/View;", "auth", "Lcom/google/firebase/auth/FirebaseAuth;", "credentialManager", "Landroidx/credentials/CredentialManager;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "setupViewPager", "setupPageIndicators", "updatePageIndicators", "position", "", "updateUIForPage", "setupClickListeners", "completeOnboarding", "signInWithGoogle", "handleSignInResult", "result", "Landroidx/credentials/GetCredentialResponse;", "firebaseAuthWithGoogle", "idToken", "", "Companion", "app_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* compiled from: OnboardingFragment.kt */
public final class OnboardingFragment extends Fragment {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String KEY_HAS_LOGGED_IN_BEFORE = "has_logged_in_before";
    private static final String KEY_ONBOARDING_COMPLETED = "onboarding_completed";
    private static final String PREFS_NAME = "onboarding_prefs";
    private static final String TAG = "OnboardingFragment";
    private FirebaseAuth auth;
    private ImageView backButton;
    /* access modifiers changed from: private */
    public CredentialManager credentialManager;
    private final List<View> indicators = new ArrayList();
    private MaterialButton nextButton;
    private LinearLayout pageIndicatorContainer;
    private TextView skipButton;
    private ViewPager2 viewPager;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fJ\u0016\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\nJ\u000e\u0010\u0010\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fJ\u0016\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\nR\u000e\u0010\u0004\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/armmc/app/ui/onboarding/OnboardingFragment$Companion;", "", "<init>", "()V", "TAG", "", "PREFS_NAME", "KEY_ONBOARDING_COMPLETED", "KEY_HAS_LOGGED_IN_BEFORE", "isOnboardingCompleted", "", "context", "Landroid/content/Context;", "setOnboardingCompleted", "", "completed", "hasLoggedInBefore", "setHasLoggedInBefore", "hasLoggedIn", "app_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* compiled from: OnboardingFragment.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final boolean isOnboardingCompleted(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            return context.getSharedPreferences(OnboardingFragment.PREFS_NAME, 0).getBoolean(OnboardingFragment.KEY_ONBOARDING_COMPLETED, false);
        }

        public final void setOnboardingCompleted(Context context, boolean z) {
            Intrinsics.checkNotNullParameter(context, "context");
            context.getSharedPreferences(OnboardingFragment.PREFS_NAME, 0).edit().putBoolean(OnboardingFragment.KEY_ONBOARDING_COMPLETED, z).apply();
        }

        public final boolean hasLoggedInBefore(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            return context.getSharedPreferences(OnboardingFragment.PREFS_NAME, 0).getBoolean(OnboardingFragment.KEY_HAS_LOGGED_IN_BEFORE, false);
        }

        public final void setHasLoggedInBefore(Context context, boolean z) {
            Intrinsics.checkNotNullParameter(context, "context");
            context.getSharedPreferences(OnboardingFragment.PREFS_NAME, 0).edit().putBoolean(OnboardingFragment.KEY_HAS_LOGGED_IN_BEFORE, z).apply();
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.fragment_onboarding, viewGroup, false);
    }

    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        this.auth = FirebaseAuth.getInstance();
        CredentialManager.Companion companion = CredentialManager.Companion;
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
        this.credentialManager = companion.create(requireContext);
        this.viewPager = (ViewPager2) view.findViewById(R.id.onboardingViewPager);
        this.pageIndicatorContainer = (LinearLayout) view.findViewById(R.id.pageIndicatorContainer);
        this.nextButton = (MaterialButton) view.findViewById(R.id.nextButton);
        this.skipButton = (TextView) view.findViewById(R.id.skipButton);
        this.backButton = (ImageView) view.findViewById(R.id.backButton);
        ViewCompat.setOnApplyWindowInsetsListener(view, new OnboardingFragment$$ExternalSyntheticLambda7(this));
        setupViewPager();
        setupPageIndicators();
        setupClickListeners();
    }

    /* access modifiers changed from: private */
    public static final WindowInsetsCompat onViewCreated$lambda$3(OnboardingFragment onboardingFragment, View view, WindowInsetsCompat windowInsetsCompat) {
        Insets insets = windowInsetsCompat.getInsets(WindowInsetsCompat.Type.systemBars());
        float f = onboardingFragment.getResources().getDisplayMetrics().density;
        int i = (int) (((float) 16) * f);
        int i2 = (int) (((float) 8) * f);
        TextView textView = onboardingFragment.skipButton;
        MaterialButton materialButton = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("skipButton");
            textView = null;
        }
        View view2 = textView;
        ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
        if (layoutParams != null) {
            ViewGroup.LayoutParams layoutParams2 = (ViewGroup.MarginLayoutParams) layoutParams;
            ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin = insets.top + i;
            view2.setLayoutParams(layoutParams2);
            ImageView imageView = onboardingFragment.backButton;
            if (imageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("backButton");
                imageView = null;
            }
            View view3 = imageView;
            ViewGroup.LayoutParams layoutParams3 = view3.getLayoutParams();
            if (layoutParams3 != null) {
                ViewGroup.LayoutParams layoutParams4 = (ViewGroup.MarginLayoutParams) layoutParams3;
                ((ViewGroup.MarginLayoutParams) layoutParams4).topMargin = insets.top + i2;
                view3.setLayoutParams(layoutParams4);
                MaterialButton materialButton2 = onboardingFragment.nextButton;
                if (materialButton2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("nextButton");
                } else {
                    materialButton = materialButton2;
                }
                View view4 = materialButton;
                ViewGroup.LayoutParams layoutParams5 = view4.getLayoutParams();
                if (layoutParams5 != null) {
                    ViewGroup.LayoutParams layoutParams6 = (ViewGroup.MarginLayoutParams) layoutParams5;
                    ((ViewGroup.MarginLayoutParams) layoutParams6).bottomMargin = insets.bottom + ((int) (((float) 32) * f));
                    view4.setLayoutParams(layoutParams6);
                    return WindowInsetsCompat.CONSUMED;
                }
                throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            }
            throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        }
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    }

    private final void setupViewPager() {
        OnboardingPagerAdapter onboardingPagerAdapter = new OnboardingPagerAdapter(new OnboardingFragment$$ExternalSyntheticLambda3(this), new OnboardingFragment$$ExternalSyntheticLambda4(this), new OnboardingFragment$$ExternalSyntheticLambda5(this));
        ViewPager2 viewPager2 = this.viewPager;
        ViewPager2 viewPager22 = null;
        if (viewPager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewPager");
            viewPager2 = null;
        }
        viewPager2.setAdapter(onboardingPagerAdapter);
        ViewPager2 viewPager23 = this.viewPager;
        if (viewPager23 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewPager");
        } else {
            viewPager22 = viewPager23;
        }
        viewPager22.registerOnPageChangeCallback(new OnboardingFragment$setupViewPager$1(this));
    }

    /* access modifiers changed from: private */
    public static final Unit setupViewPager$lambda$4(OnboardingFragment onboardingFragment) {
        FragmentKt.findNavController(onboardingFragment).navigate(R.id.action_onboarding_to_signUp);
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit setupViewPager$lambda$5(OnboardingFragment onboardingFragment) {
        onboardingFragment.signInWithGoogle();
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit setupViewPager$lambda$6(OnboardingFragment onboardingFragment) {
        onboardingFragment.completeOnboarding();
        return Unit.INSTANCE;
    }

    private final void setupPageIndicators() {
        LinearLayout linearLayout = this.pageIndicatorContainer;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pageIndicatorContainer");
            linearLayout = null;
        }
        linearLayout.removeAllViews();
        this.indicators.clear();
        float f = getResources().getDisplayMetrics().density;
        int i = (int) (((float) 8) * f);
        int i2 = (int) (((float) 6) * f);
        int i3 = 0;
        while (i3 < 3) {
            View view = new View(requireContext());
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i, i);
            layoutParams.setMarginStart(i3 == 0 ? 0 : i2);
            layoutParams.setMarginEnd(i2);
            view.setLayoutParams(layoutParams);
            view.setBackground(ContextCompat.getDrawable(requireContext(), i3 == 0 ? R.drawable.indicator_active : R.drawable.indicator_inactive));
            this.indicators.add(view);
            LinearLayout linearLayout2 = this.pageIndicatorContainer;
            if (linearLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("pageIndicatorContainer");
                linearLayout2 = null;
            }
            linearLayout2.addView(view);
            i3++;
        }
    }

    /* access modifiers changed from: private */
    public final void updatePageIndicators(int i) {
        int i2 = 0;
        for (Object next : this.indicators) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            ((View) next).setBackground(ContextCompat.getDrawable(requireContext(), i2 == i ? R.drawable.indicator_active : R.drawable.indicator_inactive));
            i2 = i3;
        }
    }

    /* access modifiers changed from: private */
    public final void updateUIForPage(int i) {
        boolean z = true;
        int i2 = 0;
        boolean z2 = i == 2;
        if (i != 0) {
            z = false;
        }
        MaterialButton materialButton = this.nextButton;
        ImageView imageView = null;
        if (materialButton == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nextButton");
            materialButton = null;
        }
        materialButton.setVisibility(z2 ? 8 : 0);
        LinearLayout linearLayout = this.pageIndicatorContainer;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pageIndicatorContainer");
            linearLayout = null;
        }
        linearLayout.setVisibility(z2 ? 8 : 0);
        ImageView imageView2 = this.backButton;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("backButton");
        } else {
            imageView = imageView2;
        }
        if (z) {
            i2 = 8;
        }
        imageView.setVisibility(i2);
    }

    private final void setupClickListeners() {
        MaterialButton materialButton = this.nextButton;
        ImageView imageView = null;
        if (materialButton == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nextButton");
            materialButton = null;
        }
        materialButton.setOnClickListener(new OnboardingFragment$$ExternalSyntheticLambda0(this));
        TextView textView = this.skipButton;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("skipButton");
            textView = null;
        }
        textView.setOnClickListener(new OnboardingFragment$$ExternalSyntheticLambda1(this));
        ImageView imageView2 = this.backButton;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("backButton");
        } else {
            imageView = imageView2;
        }
        imageView.setOnClickListener(new OnboardingFragment$$ExternalSyntheticLambda2(this));
    }

    /* access modifiers changed from: private */
    public static final void setupClickListeners$lambda$10(OnboardingFragment onboardingFragment, View view) {
        ViewPager2 viewPager2 = onboardingFragment.viewPager;
        ViewPager2 viewPager22 = null;
        if (viewPager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewPager");
            viewPager2 = null;
        }
        int currentItem = viewPager2.getCurrentItem();
        if (currentItem < 2) {
            ViewPager2 viewPager23 = onboardingFragment.viewPager;
            if (viewPager23 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewPager");
            } else {
                viewPager22 = viewPager23;
            }
            viewPager22.setCurrentItem(currentItem + 1);
        }
    }

    /* access modifiers changed from: private */
    public static final void setupClickListeners$lambda$11(OnboardingFragment onboardingFragment, View view) {
        onboardingFragment.completeOnboarding();
    }

    /* access modifiers changed from: private */
    public static final void setupClickListeners$lambda$12(OnboardingFragment onboardingFragment, View view) {
        ViewPager2 viewPager2 = onboardingFragment.viewPager;
        ViewPager2 viewPager22 = null;
        if (viewPager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewPager");
            viewPager2 = null;
        }
        int currentItem = viewPager2.getCurrentItem();
        if (currentItem > 0) {
            ViewPager2 viewPager23 = onboardingFragment.viewPager;
            if (viewPager23 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewPager");
            } else {
                viewPager22 = viewPager23;
            }
            viewPager22.setCurrentItem(currentItem - 1);
        }
    }

    private final void completeOnboarding() {
        Companion companion = Companion;
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
        companion.setOnboardingCompleted(requireContext, true);
        NavController findNavController = FragmentKt.findNavController(this);
        NavDestination currentDestination = findNavController.getCurrentDestination();
        if (currentDestination != null && currentDestination.getId() == R.id.nav_onboarding) {
            findNavController.navigate(R.id.action_onboarding_to_servers);
        }
    }

    private final void signInWithGoogle() {
        GetCredentialRequest build = new GetCredentialRequest.Builder().addCredentialOption(new GetGoogleIdOption.Builder().setFilterByAuthorizedAccounts(false).setServerClientId(LoginFragment.WEB_CLIENT_ID).build()).build();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        Job unused = BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner), (CoroutineContext) null, (CoroutineStart) null, new OnboardingFragment$signInWithGoogle$1(this, build, (Continuation<? super OnboardingFragment$signInWithGoogle$1>) null), 3, (Object) null);
    }

    /* access modifiers changed from: private */
    public final void handleSignInResult(GetCredentialResponse getCredentialResponse) {
        if (isAdded()) {
            Credential credential = getCredentialResponse.getCredential();
            if (!(credential instanceof CustomCredential)) {
                Log.e(TAG, "Unexpected credential type");
                if (isAdded()) {
                    Toast.makeText(requireContext(), "Unexpected credential type", 0).show();
                }
            } else if (Intrinsics.areEqual((Object) credential.getType(), (Object) GoogleIdTokenCredential.TYPE_GOOGLE_ID_TOKEN_CREDENTIAL)) {
                try {
                    firebaseAuthWithGoogle(GoogleIdTokenCredential.Companion.createFrom(credential.getData()).getIdToken());
                } catch (GoogleIdTokenParsingException e) {
                    Log.e(TAG, "Failed to parse Google ID token", e);
                    if (isAdded()) {
                        Toast.makeText(requireContext(), "Failed to process Google Sign-In", 0).show();
                    }
                }
            } else {
                Log.e(TAG, "Unexpected credential type: " + credential.getType());
                if (isAdded()) {
                    Toast.makeText(requireContext(), "Unexpected credential type", 0).show();
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
        firebaseAuth.signInWithCredential(credential).addOnCompleteListener((Activity) requireActivity(), new OnboardingFragment$$ExternalSyntheticLambda6(this));
    }

    /* access modifiers changed from: private */
    public static final void firebaseAuthWithGoogle$lambda$13(OnboardingFragment onboardingFragment, Task task) {
        Intrinsics.checkNotNullParameter(task, "task");
        if (!onboardingFragment.isAdded()) {
            Log.w(TAG, "Fragment not attached, ignoring auth result");
        } else if (task.isSuccessful()) {
            Log.d(TAG, "signInWithCredential:success");
            Companion companion = Companion;
            Context requireContext = onboardingFragment.requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
            companion.setOnboardingCompleted(requireContext, true);
            Context requireContext2 = onboardingFragment.requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext2, "requireContext(...)");
            companion.setHasLoggedInBefore(requireContext2, true);
            NavController findNavController = FragmentKt.findNavController(onboardingFragment);
            NavDestination currentDestination = findNavController.getCurrentDestination();
            if (currentDestination != null && currentDestination.getId() == R.id.nav_onboarding) {
                findNavController.navigate(R.id.action_onboarding_to_servers);
            }
        } else {
            Log.w(TAG, "signInWithCredential:failure", task.getException());
            Context requireContext3 = onboardingFragment.requireContext();
            Exception exception = task.getException();
            Toast.makeText(requireContext3, "Authentication failed: " + (exception != null ? exception.getMessage() : null), 0).show();
        }
    }
}
