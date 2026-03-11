package com.armmc.app.ui.profile;

import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.SpannableStringBuilder;
import android.text.style.StyleSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.navigation.fragment.FragmentKt;
import com.armmc.app.R;
import com.armmc.app.api.SubdomainApiService;
import com.armmc.app.databinding.FragmentClaimSubdomainBinding;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0011\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\b\u0010 \u001a\u00020!H\u0002J\u0010\u0010\"\u001a\u00020!2\u0006\u0010#\u001a\u00020\u0017H\u0002J\b\u0010$\u001a\u00020!H\u0002J\b\u0010%\u001a\u00020!H\u0002J\b\u0010&\u001a\u00020!H\u0002J\u0010\u0010'\u001a\u00020!2\u0006\u0010#\u001a\u00020\u0017H\u0002J\u0010\u0010(\u001a\u00020!2\u0006\u0010)\u001a\u00020\u0017H\u0002J\b\u0010*\u001a\u00020!H\u0002J\b\u0010+\u001a\u00020!H\u0002J\b\u0010,\u001a\u00020!H\u0002J\u0010\u0010-\u001a\u00020!2\u0006\u0010)\u001a\u00020\u0017H\u0002J\u0010\u0010.\u001a\u00020!2\u0006\u0010)\u001a\u00020\u0017H\u0002J\u0010\u0010/\u001a\u00020!2\u0006\u0010)\u001a\u00020\u0017H\u0002J\b\u00100\u001a\u00020!H\u0002J\b\u00101\u001a\u00020!H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u00058BX\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u000e¢\u0006\u0002\n\u0000¨\u00062"}, d2 = {"Lcom/armmc/app/ui/profile/ClaimSubdomainFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "_binding", "Lcom/armmc/app/databinding/FragmentClaimSubdomainBinding;", "binding", "getBinding", "()Lcom/armmc/app/databinding/FragmentClaimSubdomainBinding;", "auth", "Lcom/google/firebase/auth/FirebaseAuth;", "subdomainApi", "Lcom/armmc/app/api/SubdomainApiService;", "availabilityCheckHandler", "Landroid/os/Handler;", "availabilityCheckRunnable", "Ljava/lang/Runnable;", "AVAILABILITY_CHECK_DELAY", "", "isSubdomainValid", "", "isSubdomainAvailable", "currentSubdomain", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "setupSubdomainInput", "", "checkSubdomainAvailability", "subdomain", "setupButtons", "showConfirmationDialog", "claimSubdomain", "showSuccessDialog", "showError", "message", "resetLoadingState", "hideAvailabilityStatus", "showAvailabilityLoading", "showValidationError", "showValidationHint", "showAvailabilitySuccess", "updateClaimButtonState", "onDestroyView", "app_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* compiled from: ClaimSubdomainFragment.kt */
public final class ClaimSubdomainFragment extends Fragment {
    /* access modifiers changed from: private */
    public final long AVAILABILITY_CHECK_DELAY = 500;
    private FragmentClaimSubdomainBinding _binding;
    private final FirebaseAuth auth;
    /* access modifiers changed from: private */
    public final Handler availabilityCheckHandler = new Handler(Looper.getMainLooper());
    /* access modifiers changed from: private */
    public Runnable availabilityCheckRunnable;
    /* access modifiers changed from: private */
    public String currentSubdomain = "";
    /* access modifiers changed from: private */
    public boolean isSubdomainAvailable;
    /* access modifiers changed from: private */
    public boolean isSubdomainValid;
    /* access modifiers changed from: private */
    public final SubdomainApiService subdomainApi = new SubdomainApiService();

    public ClaimSubdomainFragment() {
        FirebaseAuth instance = FirebaseAuth.getInstance();
        Intrinsics.checkNotNullExpressionValue(instance, "getInstance(...)");
        this.auth = instance;
    }

    private final FragmentClaimSubdomainBinding getBinding() {
        FragmentClaimSubdomainBinding fragmentClaimSubdomainBinding = this._binding;
        Intrinsics.checkNotNull(fragmentClaimSubdomainBinding);
        return fragmentClaimSubdomainBinding;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        this._binding = FragmentClaimSubdomainBinding.inflate(layoutInflater, viewGroup, false);
        setupSubdomainInput();
        setupButtons();
        ScrollView root = getBinding().getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        return root;
    }

    private final void setupSubdomainInput() {
        getBinding().subdomainInput.addTextChangedListener(new ClaimSubdomainFragment$setupSubdomainInput$1(this));
    }

    /* access modifiers changed from: private */
    public final void checkSubdomainAvailability(String str) {
        FirebaseUser currentUser = this.auth.getCurrentUser();
        if (currentUser != null) {
            LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
            Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
            Job unused = BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner), (CoroutineContext) null, (CoroutineStart) null, new ClaimSubdomainFragment$checkSubdomainAvailability$1(this, str, currentUser, (Continuation<? super ClaimSubdomainFragment$checkSubdomainAvailability$1>) null), 3, (Object) null);
        }
    }

    private final void setupButtons() {
        getBinding().claimButton.setOnClickListener(new ClaimSubdomainFragment$$ExternalSyntheticLambda1(this));
        getBinding().cancelButton.setOnClickListener(new ClaimSubdomainFragment$$ExternalSyntheticLambda2(this));
    }

    /* access modifiers changed from: private */
    public static final void setupButtons$lambda$0(ClaimSubdomainFragment claimSubdomainFragment, View view) {
        if (claimSubdomainFragment.isSubdomainValid && claimSubdomainFragment.isSubdomainAvailable) {
            claimSubdomainFragment.showConfirmationDialog();
        }
    }

    /* access modifiers changed from: private */
    public static final void setupButtons$lambda$1(ClaimSubdomainFragment claimSubdomainFragment, View view) {
        FragmentKt.findNavController(claimSubdomainFragment).navigateUp();
    }

    private final void showConfirmationDialog() {
        String str = this.currentSubdomain + ".witherhost.com";
        CharSequence charSequence = "You are about to claim:\n\n" + this.currentSubdomain + ".witherhost.com\n\nThis cannot be changed later. Are you sure?";
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(charSequence);
        int indexOf$default = StringsKt.indexOf$default(charSequence, str, 0, false, 6, (Object) null);
        int length = str.length() + indexOf$default;
        if (indexOf$default != -1) {
            spannableStringBuilder.setSpan(new StyleSpan(1), indexOf$default, length, 33);
        }
        new MaterialAlertDialogBuilder(requireContext(), R.style.AlertDialogTheme).setTitle((CharSequence) "Confirm Your Subdomain").setMessage((CharSequence) spannableStringBuilder).setPositiveButton((CharSequence) "Claim It", (DialogInterface.OnClickListener) new ClaimSubdomainFragment$$ExternalSyntheticLambda0(this)).setNegativeButton((CharSequence) "Cancel", (DialogInterface.OnClickListener) null).show();
    }

    /* access modifiers changed from: private */
    public static final void showConfirmationDialog$lambda$2(ClaimSubdomainFragment claimSubdomainFragment, DialogInterface dialogInterface, int i) {
        claimSubdomainFragment.claimSubdomain();
    }

    private final void claimSubdomain() {
        FirebaseUser currentUser = this.auth.getCurrentUser();
        if (currentUser != null) {
            getBinding().claimButton.setVisibility(4);
            getBinding().loadingIndicator.setVisibility(0);
            getBinding().subdomainInput.setEnabled(false);
            getBinding().cancelButton.setEnabled(false);
            LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
            Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
            Job unused = BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner), (CoroutineContext) null, (CoroutineStart) null, new ClaimSubdomainFragment$claimSubdomain$1(this, currentUser, (Continuation<? super ClaimSubdomainFragment$claimSubdomain$1>) null), 3, (Object) null);
        }
    }

    /* access modifiers changed from: private */
    public final void showSuccessDialog(String str) {
        new MaterialAlertDialogBuilder(requireContext(), R.style.AlertDialogTheme).setTitle((CharSequence) "🎉 Subdomain Claimed!").setMessage((CharSequence) "Congratulations! You now own:\n\n" + str + ".witherhost.com\n\nDue to DNS propagation, it may take up to 24 hours for your subdomain to become fully active worldwide.").setPositiveButton((CharSequence) "Got It", (DialogInterface.OnClickListener) new ClaimSubdomainFragment$$ExternalSyntheticLambda3(this)).setCancelable(false).show();
    }

    /* access modifiers changed from: private */
    public static final void showSuccessDialog$lambda$3(ClaimSubdomainFragment claimSubdomainFragment, DialogInterface dialogInterface, int i) {
        FragmentKt.findNavController(claimSubdomainFragment).navigateUp();
    }

    /* access modifiers changed from: private */
    public final void showError(String str) {
        new MaterialAlertDialogBuilder(requireContext(), R.style.AlertDialogTheme).setTitle((CharSequence) "Error").setMessage((CharSequence) str).setPositiveButton((CharSequence) "OK", (DialogInterface.OnClickListener) null).show();
    }

    /* access modifiers changed from: private */
    public final void resetLoadingState() {
        getBinding().claimButton.setVisibility(0);
        getBinding().loadingIndicator.setVisibility(8);
        getBinding().subdomainInput.setEnabled(true);
        getBinding().cancelButton.setEnabled(true);
    }

    /* access modifiers changed from: private */
    public final void hideAvailabilityStatus() {
        getBinding().availabilityStatus.setVisibility(8);
        getBinding().availabilityLoading.setVisibility(8);
    }

    /* access modifiers changed from: private */
    public final void showAvailabilityLoading() {
        getBinding().availabilityStatus.setVisibility(8);
        getBinding().availabilityLoading.setVisibility(0);
    }

    /* access modifiers changed from: private */
    public final void showValidationError(String str) {
        getBinding().availabilityLoading.setVisibility(8);
        getBinding().availabilityStatus.setVisibility(0);
        getBinding().availabilityIcon.setImageResource(R.drawable.ic_close);
        getBinding().availabilityIcon.setImageTintList(ContextCompat.getColorStateList(requireContext(), R.color.danger_light));
        getBinding().availabilityText.setText(str);
        getBinding().availabilityText.setTextColor(ContextCompat.getColor(requireContext(), R.color.danger_light));
    }

    /* access modifiers changed from: private */
    public final void showValidationHint(String str) {
        getBinding().availabilityLoading.setVisibility(8);
        getBinding().availabilityStatus.setVisibility(0);
        getBinding().availabilityIcon.setImageResource(R.drawable.ic_info);
        getBinding().availabilityIcon.setImageTintList(ContextCompat.getColorStateList(requireContext(), R.color.text_tint));
        getBinding().availabilityText.setText(str);
        getBinding().availabilityText.setTextColor(ContextCompat.getColor(requireContext(), R.color.text_tint));
    }

    /* access modifiers changed from: private */
    public final void showAvailabilitySuccess(String str) {
        getBinding().availabilityLoading.setVisibility(8);
        getBinding().availabilityStatus.setVisibility(0);
        getBinding().availabilityIcon.setImageResource(R.drawable.ic_check_circle);
        getBinding().availabilityIcon.setImageTintList(ContextCompat.getColorStateList(requireContext(), R.color.primary_accent));
        getBinding().availabilityText.setText(str);
        getBinding().availabilityText.setTextColor(ContextCompat.getColor(requireContext(), R.color.primary_accent));
    }

    /* access modifiers changed from: private */
    public final void updateClaimButtonState() {
        getBinding().claimButton.setEnabled(this.isSubdomainValid && this.isSubdomainAvailable);
    }

    public void onDestroyView() {
        super.onDestroyView();
        Runnable runnable = this.availabilityCheckRunnable;
        if (runnable != null) {
            this.availabilityCheckHandler.removeCallbacks(runnable);
        }
        this._binding = null;
    }
}
