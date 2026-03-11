package com.armmc.app.ui.profile;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.navigation.fragment.FragmentKt;
import com.armmc.app.R;
import com.armmc.app.api.SubdomainApiService;
import com.armmc.app.billing.BillingManager;
import com.armmc.app.databinding.FragmentProfileBinding;
import com.armmc.app.ui.onboarding.OnboardingFragment;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.FirebaseUserMetadata;
import com.google.firebase.auth.UserInfo;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u001aH\u0002J\b\u0010\u001b\u001a\u00020\u001aH\u0002J\b\u0010\u001c\u001a\u00020\u001aH\u0002J\b\u0010\u001d\u001a\u00020\u001aH\u0002J\b\u0010\u001e\u001a\u00020\u001aH\u0002J\b\u0010\u001f\u001a\u00020\u001aH\u0002J\b\u0010 \u001a\u00020\u001aH\u0002J\b\u0010!\u001a\u00020\u001aH\u0002J\b\u0010\"\u001a\u00020\u001aH\u0002J\u0010\u0010#\u001a\u00020\u001a2\u0006\u0010$\u001a\u00020\u0010H\u0002J\b\u0010%\u001a\u00020\u001aH\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u00058BX\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX.¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lcom/armmc/app/ui/profile/ProfileFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "_binding", "Lcom/armmc/app/databinding/FragmentProfileBinding;", "binding", "getBinding", "()Lcom/armmc/app/databinding/FragmentProfileBinding;", "auth", "Lcom/google/firebase/auth/FirebaseAuth;", "billingManager", "Lcom/armmc/app/billing/BillingManager;", "subdomainApi", "Lcom/armmc/app/api/SubdomainApiService;", "currentSupporterStatus", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "setupUserInfo", "", "setupLogoutButton", "setupVersionInfo", "setupUpgradeButton", "navigateToSubscription", "setupSubdomainCard", "setupFaqButton", "checkSubdomainStatus", "observeSubscriptionStatus", "updateSubscriptionUI", "isSupporter", "onDestroyView", "app_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* compiled from: ProfileFragment.kt */
public final class ProfileFragment extends Fragment {
    /* access modifiers changed from: private */
    public FragmentProfileBinding _binding;
    private FirebaseAuth auth;
    private BillingManager billingManager;
    private boolean currentSupporterStatus;
    /* access modifiers changed from: private */
    public final SubdomainApiService subdomainApi = new SubdomainApiService();

    /* access modifiers changed from: private */
    public final FragmentProfileBinding getBinding() {
        FragmentProfileBinding fragmentProfileBinding = this._binding;
        Intrinsics.checkNotNull(fragmentProfileBinding);
        return fragmentProfileBinding;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        this._binding = FragmentProfileBinding.inflate(layoutInflater, viewGroup, false);
        this.auth = FirebaseAuth.getInstance();
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        /* MODIFIED: BillingManager stubbed */ this.billingManager = new BillingManager(requireContext, LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner));
        setupUserInfo();
        setupLogoutButton();
        setupVersionInfo();
        setupUpgradeButton();
        setupSubdomainCard();
        setupFaqButton();
        observeSubscriptionStatus();
        ScrollView root = getBinding().getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        return root;
    }

    private final void setupUserInfo() {
        String str;
        FirebaseAuth firebaseAuth = this.auth;
        if (firebaseAuth == null) {
            Intrinsics.throwUninitializedPropertyAccessException("auth");
            firebaseAuth = null;
        }
        FirebaseUser currentUser = firebaseAuth.getCurrentUser();
        if (currentUser != null) {
            TextView textView = getBinding().userEmail;
            String email = currentUser.getEmail();
            if (email == null) {
                email = "No email";
            }
            textView.setText(email);
            FirebaseUserMetadata metadata = currentUser.getMetadata();
            Long valueOf = metadata != null ? Long.valueOf(metadata.getCreationTimestamp()) : null;
            if (valueOf != null) {
                str = new SimpleDateFormat("yyyy", Locale.getDefault()).format(valueOf);
            } else {
                str = "Unknown";
            }
            getBinding().userRole.setText("User • Since " + str);
            Uri photoUrl = currentUser.getPhotoUrl();
            if (photoUrl != null) {
                ((RequestBuilder) ((RequestBuilder) Glide.with((Fragment) this).load(photoUrl).circleCrop()).placeholder(R.drawable.ic_person)).into((ImageView) getBinding().profileAvatar);
            }
            List<? extends UserInfo> providerData = currentUser.getProviderData();
            Intrinsics.checkNotNullExpressionValue(providerData, "getProviderData(...)");
            Iterable iterable = providerData;
            if (!(iterable instanceof Collection) || !((Collection) iterable).isEmpty()) {
                Iterator it = iterable.iterator();
                while (true) {
                    if (it.hasNext()) {
                        if (Intrinsics.areEqual((Object) ((UserInfo) it.next()).getProviderId(), (Object) "google.com")) {
                            getBinding().authProviderIcon.setImageResource(R.drawable.ic_google);
                            getBinding().authProviderIcon.setImageTintList((ColorStateList) null);
                            getBinding().authProviderText.setText("Google Account");
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }
            getBinding().authProviderIcon.setImageResource(R.drawable.ic_email);
            getBinding().authProviderText.setText("Email & Password");
            getBinding().tierBadge.setText("FREE");
            getBinding().logoutButton.setText("Log Out");
            getBinding().logoutButton.setIconResource(R.drawable.ic_logout);
            return;
        }
        getBinding().userEmail.setText("Not logged in");
        getBinding().userRole.setText("Please sign in to view profile");
        getBinding().authProviderText.setText("Not authenticated");
        getBinding().logoutButton.setText("Sign In");
        getBinding().logoutButton.setIcon((Drawable) null);
        getBinding().logoutButton.setTextColor(getResources().getColor(R.color.background_dark, (Resources.Theme) null));
        getBinding().logoutButton.setStrokeWidth(0);
        getBinding().logoutButton.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.primary_accent, (Resources.Theme) null)));
        getBinding().publicDomainBenefitCard.setVisibility(0);
        getBinding().signUpBenefitButton.setOnClickListener(new ProfileFragment$$ExternalSyntheticLambda1(this));
        getBinding().accountStatusCard.setVisibility(8);
        getBinding().authMethodCard.setVisibility(8);
        getBinding().sessionLimitCard.setVisibility(8);
    }

    /* access modifiers changed from: private */
    public static final void setupUserInfo$lambda$2(ProfileFragment profileFragment, View view) {
        FragmentKt.findNavController(profileFragment).navigate(R.id.nav_sign_up);
    }

    private final void setupLogoutButton() {
        getBinding().logoutButton.setOnClickListener(new ProfileFragment$$ExternalSyntheticLambda4(this));
    }

    /* access modifiers changed from: private */
    public static final void setupLogoutButton$lambda$3(ProfileFragment profileFragment, View view) {
        FirebaseAuth firebaseAuth = profileFragment.auth;
        FirebaseAuth firebaseAuth2 = null;
        if (firebaseAuth == null) {
            Intrinsics.throwUninitializedPropertyAccessException("auth");
            firebaseAuth = null;
        }
        if (firebaseAuth.getCurrentUser() != null) {
            FirebaseAuth firebaseAuth3 = profileFragment.auth;
            if (firebaseAuth3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("auth");
            } else {
                firebaseAuth2 = firebaseAuth3;
            }
            firebaseAuth2.signOut();
            BillingManager.Companion.clearSupporterCache();
            OnboardingFragment.Companion companion = OnboardingFragment.Companion;
            Context requireContext = profileFragment.requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
            companion.setHasLoggedInBefore(requireContext, true);
        }
        FragmentKt.findNavController(profileFragment).navigate(R.id.nav_login);
    }

    private final void setupVersionInfo() {
        getBinding().versionText.setText("witherhost.com v1.3.0");
    }

    private final void setupUpgradeButton() {
        getBinding().upgradeButton.setOnClickListener(new ProfileFragment$$ExternalSyntheticLambda5(this));
    }

    /* access modifiers changed from: private */
    public static final void setupUpgradeButton$lambda$4(ProfileFragment profileFragment, View view) {
        profileFragment.navigateToSubscription();
    }

    private final void navigateToSubscription() {
        FragmentKt.findNavController(this).navigate(R.id.action_profile_to_subscription);
    }

    private final void setupSubdomainCard() {
        getBinding().claimSubdomainButton.setOnClickListener(new ProfileFragment$$ExternalSyntheticLambda0(this));
    }

    /* access modifiers changed from: private */
    public static final void setupSubdomainCard$lambda$5(ProfileFragment profileFragment, View view) {
        FragmentKt.findNavController(profileFragment).navigate(R.id.action_profile_to_claim_subdomain);
    }

    private final void setupFaqButton() {
        getBinding().faqButton.setOnClickListener(new ProfileFragment$$ExternalSyntheticLambda3(this));
    }

    /* access modifiers changed from: private */
    public static final void setupFaqButton$lambda$6(ProfileFragment profileFragment, View view) {
        FragmentKt.findNavController(profileFragment).navigate(R.id.action_profile_to_faq);
    }

    private final void checkSubdomainStatus() {
        FirebaseAuth firebaseAuth = this.auth;
        if (firebaseAuth == null) {
            Intrinsics.throwUninitializedPropertyAccessException("auth");
            firebaseAuth = null;
        }
        FirebaseUser currentUser = firebaseAuth.getCurrentUser();
        if (currentUser != null) {
            getBinding().subdomainLoading.setVisibility(0);
            getBinding().claimedSubdomainContainer.setVisibility(8);
            getBinding().unclaimedSubdomainContainer.setVisibility(8);
            LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
            Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
            Job unused = BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner), (CoroutineContext) null, (CoroutineStart) null, new ProfileFragment$checkSubdomainStatus$1(this, currentUser, (Continuation<? super ProfileFragment$checkSubdomainStatus$1>) null), 3, (Object) null);
        }
    }

    private final void observeSubscriptionStatus() {
        BillingManager billingManager2 = this.billingManager;
        if (billingManager2 != null) {
            /* MODIFIED: Always supporter */ updateSubscriptionUI(true);
        }
        BillingManager billingManager3 = this.billingManager;
        if (billingManager3 != null) {
            LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
            Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
            Job unused = BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner), (CoroutineContext) null, (CoroutineStart) null, new ProfileFragment$observeSubscriptionStatus$2$1(this, billingManager3, (Continuation<? super ProfileFragment$observeSubscriptionStatus$2$1>) null), 3, (Object) null);
        }
    }

    /* access modifiers changed from: private */
    public static final Unit observeSubscriptionStatus$lambda$7(ProfileFragment profileFragment, boolean z) {
        if (profileFragment._binding != null) {
            profileFragment.updateSubscriptionUI(z);
        }
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public final void updateSubscriptionUI(boolean z) {
        boolean z2 = this.currentSupporterStatus != z;
        this.currentSupporterStatus = z;
        if (z) {
            getBinding().tierBadge.setText("SUPPORTER");
            getBinding().tierBadge.setBackgroundResource(R.drawable.bg_supporter_badge);
            getBinding().tierBadge.setTextColor(getResources().getColor(R.color.gold, (Resources.Theme) null));
            getBinding().upgradeButton.setVisibility(8);
            getBinding().sessionLimitTitle.setText("Unlimited Sessions");
            getBinding().sessionLimitDescription.setText("Enjoy unlimited session length as a Supporter!");
            getBinding().sessionProgressBar.setProgress(100);
            getBinding().subdomainCard.setVisibility(0);
            if (z2 || (getBinding().claimedSubdomainContainer.getVisibility() == 8 && getBinding().unclaimedSubdomainContainer.getVisibility() == 8)) {
                checkSubdomainStatus();
                return;
            }
            return;
        }
        getBinding().tierBadge.setText("FREE");
        getBinding().tierBadge.setBackgroundResource(R.drawable.bg_tier_badge);
        getBinding().tierBadge.setTextColor(getResources().getColor(R.color.white, (Resources.Theme) null));
        getBinding().upgradeButton.setVisibility(0);
        getBinding().sessionLimitTitle.setText("Domain Session Limit");
        getBinding().sessionLimitDescription.setText("2hr limit per session for free users");
        getBinding().subdomainCard.setVisibility(8);
    }

    public void onDestroyView() {
        super.onDestroyView();
        BillingManager billingManager2 = this.billingManager;
        if (billingManager2 != null) {
            billingManager2.destroy();
        }
        this.billingManager = null;
        this._binding = null;
    }
}
