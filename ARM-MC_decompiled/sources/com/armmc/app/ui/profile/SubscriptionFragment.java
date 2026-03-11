package com.armmc.app.ui.profile;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import androidx.core.view.ViewCompat;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.navigation.fragment.FragmentKt;
import com.armmc.app.billing.BillingManager;
import com.armmc.app.databinding.FragmentSubscriptionBinding;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u001dB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\u001a\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\b\u0010\u0016\u001a\u00020\u0014H\u0002J\u0010\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\b\u0010\u001a\u001a\u00020\u0014H\u0002J\b\u0010\u001b\u001a\u00020\u0014H\u0002J\b\u0010\u001c\u001a\u00020\u0014H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u00058BX\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/armmc/app/ui/profile/SubscriptionFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "_binding", "Lcom/armmc/app/databinding/FragmentSubscriptionBinding;", "binding", "getBinding", "()Lcom/armmc/app/databinding/FragmentSubscriptionBinding;", "billingManager", "Lcom/armmc/app/billing/BillingManager;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "setupUI", "openUrl", "url", "", "launchSubscription", "observeBillingState", "onDestroyView", "BillingManagerProvider", "app_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* compiled from: SubscriptionFragment.kt */
public final class SubscriptionFragment extends Fragment {
    private FragmentSubscriptionBinding _binding;
    private BillingManager billingManager;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\n\u0010\u0002\u001a\u0004\u0018\u00010\u0003H&¨\u0006\u0004"}, d2 = {"Lcom/armmc/app/ui/profile/SubscriptionFragment$BillingManagerProvider;", "", "getBillingManager", "Lcom/armmc/app/billing/BillingManager;", "app_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* compiled from: SubscriptionFragment.kt */
    public interface BillingManagerProvider {
        BillingManager getBillingManager();
    }

    /* access modifiers changed from: private */
    public final FragmentSubscriptionBinding getBinding() {
        FragmentSubscriptionBinding fragmentSubscriptionBinding = this._binding;
        Intrinsics.checkNotNull(fragmentSubscriptionBinding);
        return fragmentSubscriptionBinding;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        this._binding = FragmentSubscriptionBinding.inflate(layoutInflater, viewGroup, false);
        NestedScrollView root = getBinding().getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        return root;
    }

    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        ViewCompat.setOnApplyWindowInsetsListener(view, new SubscriptionFragment$$ExternalSyntheticLambda6(this));
        FragmentActivity activity = getActivity();
        BillingManager billingManager2 = null;
        BillingManagerProvider billingManagerProvider = activity instanceof BillingManagerProvider ? (BillingManagerProvider) activity : null;
        if (billingManagerProvider != null) {
            billingManager2 = billingManagerProvider.getBillingManager();
        }
        this.billingManager = billingManager2;
        setupUI();
        observeBillingState();
    }

    /* JADX WARNING: type inference failed for: r1v9, types: [android.view.ViewGroup$LayoutParams] */
    /* access modifiers changed from: private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final androidx.core.view.WindowInsetsCompat onViewCreated$lambda$2(com.armmc.app.ui.profile.SubscriptionFragment r4, android.view.View r5, androidx.core.view.WindowInsetsCompat r6) {
        /*
            int r0 = androidx.core.view.WindowInsetsCompat.Type.systemBars()
            androidx.core.graphics.Insets r6 = r6.getInsets(r0)
            r0 = 16
            float r0 = (float) r0
            android.content.res.Resources r1 = r4.getResources()
            android.util.DisplayMetrics r1 = r1.getDisplayMetrics()
            float r1 = r1.density
            float r0 = r0 * r1
            int r0 = (int) r0
            com.armmc.app.databinding.FragmentSubscriptionBinding r1 = r4.getBinding()
            android.widget.ImageView r1 = r1.closeButton
            android.view.ViewGroup$LayoutParams r1 = r1.getLayoutParams()
            boolean r2 = r1 instanceof android.view.ViewGroup.MarginLayoutParams
            r3 = 0
            if (r2 == 0) goto L_0x0029
            android.view.ViewGroup$MarginLayoutParams r1 = (android.view.ViewGroup.MarginLayoutParams) r1
            goto L_0x002a
        L_0x0029:
            r1 = r3
        L_0x002a:
            if (r1 == 0) goto L_0x003c
            int r2 = r6.top
            int r2 = r2 + r0
            r1.topMargin = r2
            com.armmc.app.databinding.FragmentSubscriptionBinding r2 = r4.getBinding()
            android.widget.ImageView r2 = r2.closeButton
            android.view.ViewGroup$LayoutParams r1 = (android.view.ViewGroup.LayoutParams) r1
            r2.setLayoutParams(r1)
        L_0x003c:
            com.armmc.app.databinding.FragmentSubscriptionBinding r1 = r4.getBinding()
            android.widget.TextView r1 = r1.helpButton
            android.view.ViewGroup$LayoutParams r1 = r1.getLayoutParams()
            boolean r2 = r1 instanceof android.view.ViewGroup.MarginLayoutParams
            if (r2 == 0) goto L_0x004d
            r3 = r1
            android.view.ViewGroup$MarginLayoutParams r3 = (android.view.ViewGroup.MarginLayoutParams) r3
        L_0x004d:
            if (r3 == 0) goto L_0x005f
            int r1 = r6.top
            int r1 = r1 + r0
            r3.topMargin = r1
            com.armmc.app.databinding.FragmentSubscriptionBinding r4 = r4.getBinding()
            android.widget.TextView r4 = r4.helpButton
            android.view.ViewGroup$LayoutParams r3 = (android.view.ViewGroup.LayoutParams) r3
            r4.setLayoutParams(r3)
        L_0x005f:
            kotlin.jvm.internal.Intrinsics.checkNotNull(r5)
            int r4 = r6.bottom
            int r6 = r5.getPaddingLeft()
            int r0 = r5.getPaddingTop()
            int r1 = r5.getPaddingRight()
            r5.setPadding(r6, r0, r1, r4)
            androidx.core.view.WindowInsetsCompat r4 = androidx.core.view.WindowInsetsCompat.CONSUMED
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.armmc.app.ui.profile.SubscriptionFragment.onViewCreated$lambda$2(com.armmc.app.ui.profile.SubscriptionFragment, android.view.View, androidx.core.view.WindowInsetsCompat):androidx.core.view.WindowInsetsCompat");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0041, code lost:
        if (kotlinx.coroutines.BuildersKt__Builders_commonKt.launch$default(androidx.lifecycle.LifecycleOwnerKt.getLifecycleScope(r1), (kotlin.coroutines.CoroutineContext) null, (kotlinx.coroutines.CoroutineStart) null, new com.armmc.app.ui.profile.SubscriptionFragment$setupUI$1$2(r0, r10, (kotlin.coroutines.Continuation<? super com.armmc.app.ui.profile.SubscriptionFragment$setupUI$1$2>) null), 3, (java.lang.Object) null) == null) goto L_0x0043;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void setupUI() {
        /*
            r10 = this;
            com.armmc.app.billing.BillingManager r0 = r10.billingManager
            if (r0 == 0) goto L_0x0043
            androidx.lifecycle.LifecycleOwner r1 = r10.getViewLifecycleOwner()
            java.lang.String r2 = "getViewLifecycleOwner(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            androidx.lifecycle.LifecycleCoroutineScope r1 = androidx.lifecycle.LifecycleOwnerKt.getLifecycleScope(r1)
            r3 = r1
            kotlinx.coroutines.CoroutineScope r3 = (kotlinx.coroutines.CoroutineScope) r3
            com.armmc.app.ui.profile.SubscriptionFragment$setupUI$1$1 r1 = new com.armmc.app.ui.profile.SubscriptionFragment$setupUI$1$1
            r9 = 0
            r1.<init>(r0, r10, r9)
            r6 = r1
            kotlin.jvm.functions.Function2 r6 = (kotlin.jvm.functions.Function2) r6
            r7 = 3
            r8 = 0
            r4 = 0
            r5 = 0
            kotlinx.coroutines.Job unused = kotlinx.coroutines.BuildersKt__Builders_commonKt.launch$default(r3, r4, r5, r6, r7, r8)
            androidx.lifecycle.LifecycleOwner r1 = r10.getViewLifecycleOwner()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            androidx.lifecycle.LifecycleCoroutineScope r1 = androidx.lifecycle.LifecycleOwnerKt.getLifecycleScope(r1)
            r2 = r1
            kotlinx.coroutines.CoroutineScope r2 = (kotlinx.coroutines.CoroutineScope) r2
            com.armmc.app.ui.profile.SubscriptionFragment$setupUI$1$2 r1 = new com.armmc.app.ui.profile.SubscriptionFragment$setupUI$1$2
            r1.<init>(r0, r10, r9)
            r5 = r1
            kotlin.jvm.functions.Function2 r5 = (kotlin.jvm.functions.Function2) r5
            r6 = 3
            r7 = 0
            r3 = 0
            kotlinx.coroutines.Job r0 = kotlinx.coroutines.BuildersKt__Builders_commonKt.launch$default(r2, r3, r4, r5, r6, r7)
            if (r0 != 0) goto L_0x0062
        L_0x0043:
            r0 = r10
            com.armmc.app.ui.profile.SubscriptionFragment r0 = (com.armmc.app.ui.profile.SubscriptionFragment) r0
            com.armmc.app.databinding.FragmentSubscriptionBinding r0 = r10.getBinding()
            android.widget.TextView r0 = r0.subscriptionPrice
            java.lang.String r1 = "--"
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r0.setText(r1)
            com.armmc.app.databinding.FragmentSubscriptionBinding r0 = r10.getBinding()
            android.widget.TextView r0 = r0.billingInfo
            java.lang.String r1 = "Billing unavailable"
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r0.setText(r1)
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
        L_0x0062:
            com.armmc.app.databinding.FragmentSubscriptionBinding r0 = r10.getBinding()
            com.google.android.material.button.MaterialButton r0 = r0.subscribeButton
            com.armmc.app.ui.profile.SubscriptionFragment$$ExternalSyntheticLambda0 r1 = new com.armmc.app.ui.profile.SubscriptionFragment$$ExternalSyntheticLambda0
            r1.<init>(r10)
            r0.setOnClickListener(r1)
            com.armmc.app.databinding.FragmentSubscriptionBinding r0 = r10.getBinding()
            android.widget.ImageView r0 = r0.closeButton
            com.armmc.app.ui.profile.SubscriptionFragment$$ExternalSyntheticLambda1 r1 = new com.armmc.app.ui.profile.SubscriptionFragment$$ExternalSyntheticLambda1
            r1.<init>(r10)
            r0.setOnClickListener(r1)
            com.armmc.app.databinding.FragmentSubscriptionBinding r0 = r10.getBinding()
            android.widget.TextView r0 = r0.helpButton
            com.armmc.app.ui.profile.SubscriptionFragment$$ExternalSyntheticLambda2 r1 = new com.armmc.app.ui.profile.SubscriptionFragment$$ExternalSyntheticLambda2
            r1.<init>(r10)
            r0.setOnClickListener(r1)
            com.armmc.app.databinding.FragmentSubscriptionBinding r0 = r10.getBinding()
            android.widget.TextView r0 = r0.restorePurchasesButton
            com.armmc.app.ui.profile.SubscriptionFragment$$ExternalSyntheticLambda3 r1 = new com.armmc.app.ui.profile.SubscriptionFragment$$ExternalSyntheticLambda3
            r1.<init>(r10)
            r0.setOnClickListener(r1)
            com.armmc.app.databinding.FragmentSubscriptionBinding r0 = r10.getBinding()
            android.widget.TextView r0 = r0.termsOfServiceButton
            com.armmc.app.ui.profile.SubscriptionFragment$$ExternalSyntheticLambda4 r1 = new com.armmc.app.ui.profile.SubscriptionFragment$$ExternalSyntheticLambda4
            r1.<init>(r10)
            r0.setOnClickListener(r1)
            com.armmc.app.databinding.FragmentSubscriptionBinding r0 = r10.getBinding()
            android.widget.TextView r0 = r0.privacyPolicyButton
            com.armmc.app.ui.profile.SubscriptionFragment$$ExternalSyntheticLambda5 r1 = new com.armmc.app.ui.profile.SubscriptionFragment$$ExternalSyntheticLambda5
            r1.<init>(r10)
            r0.setOnClickListener(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.armmc.app.ui.profile.SubscriptionFragment.setupUI():void");
    }

    /* access modifiers changed from: private */
    public static final void setupUI$lambda$5(SubscriptionFragment subscriptionFragment, View view) {
        subscriptionFragment.launchSubscription();
    }

    /* access modifiers changed from: private */
    public static final void setupUI$lambda$6(SubscriptionFragment subscriptionFragment, View view) {
        FragmentKt.findNavController(subscriptionFragment).navigateUp();
    }

    /* access modifiers changed from: private */
    public static final void setupUI$lambda$7(SubscriptionFragment subscriptionFragment, View view) {
        Toast.makeText(subscriptionFragment.getContext(), "Help coming soon", 0).show();
    }

    /* access modifiers changed from: private */
    public static final void setupUI$lambda$8(SubscriptionFragment subscriptionFragment, View view) {
        Toast.makeText(subscriptionFragment.getContext(), "Checking for previous purchases...", 0).show();
        BillingManager billingManager2 = subscriptionFragment.billingManager;
        if (billingManager2 != null) {
            billingManager2.connect();
        }
    }

    /* access modifiers changed from: private */
    public static final void setupUI$lambda$9(SubscriptionFragment subscriptionFragment, View view) {
        subscriptionFragment.openUrl("https://witherhost.com/terms-of-service/");
    }

    /* access modifiers changed from: private */
    public static final void setupUI$lambda$10(SubscriptionFragment subscriptionFragment, View view) {
        subscriptionFragment.openUrl("https://witherhost.com/privacy-policy/");
    }

    private final void openUrl(String str) {
        try {
            startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
        } catch (Exception unused) {
            Toast.makeText(getContext(), "Unable to open link", 0).show();
        }
    }

    private final void launchSubscription() {
        BillingManager billingManager2 = this.billingManager;
        FragmentActivity activity = getActivity();
        if (billingManager2 == null) {
            Toast.makeText(getContext(), "Billing not initialized", 0).show();
        } else if (activity == null) {
            Toast.makeText(getContext(), "Unable to start purchase", 0).show();
        } else {
            getBinding().subscribeButton.setEnabled(false);
            getBinding().subscribeButton.setText("Processing...");
            billingManager2.launchSubscriptionFlow(activity);
        }
    }

    private final void observeBillingState() {
        BillingManager billingManager2 = this.billingManager;
        if (billingManager2 != null) {
            LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
            Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
            Job unused = BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner), (CoroutineContext) null, (CoroutineStart) null, new SubscriptionFragment$observeBillingState$1$1(this, billingManager2, (Continuation<? super SubscriptionFragment$observeBillingState$1$1>) null), 3, (Object) null);
        }
    }

    public void onDestroyView() {
        super.onDestroyView();
        this._binding = null;
    }
}
