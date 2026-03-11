package com.armmc.app.ui.onboarding;

import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.content.res.ColorStateList;
import android.os.Handler;
import android.os.Looper;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.armmc.app.R;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.switchmaterial.SwitchMaterial;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\u0018\u0000 \u00142\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0002\u0014\u0015B1\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\b\u0010\tJ\u001c\u0010\n\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u001c\u0010\u000f\u001a\u00020\u00052\n\u0010\u0010\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u000eH\u0016J\b\u0010\u0012\u001a\u00020\u000eH\u0016J\u0010\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u000eH\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/armmc/app/ui/onboarding/OnboardingPagerAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/armmc/app/ui/onboarding/OnboardingPagerAdapter$OnboardingViewHolder;", "onEmailSignUpClick", "Lkotlin/Function0;", "", "onGoogleSignInClick", "onSkipForNowClick", "<init>", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "holder", "position", "getItemCount", "getItemViewType", "Companion", "OnboardingViewHolder", "app_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* compiled from: OnboardingPagerAdapter.kt */
public final class OnboardingPagerAdapter extends RecyclerView.Adapter<OnboardingViewHolder> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final int PAGE_COUNT = 3;
    /* access modifiers changed from: private */
    public final Function0<Unit> onEmailSignUpClick;
    /* access modifiers changed from: private */
    public final Function0<Unit> onGoogleSignInClick;
    /* access modifiers changed from: private */
    public final Function0<Unit> onSkipForNowClick;

    public int getItemCount() {
        return 3;
    }

    public int getItemViewType(int i) {
        return i;
    }

    public OnboardingPagerAdapter(Function0<Unit> function0, Function0<Unit> function02, Function0<Unit> function03) {
        Intrinsics.checkNotNullParameter(function0, "onEmailSignUpClick");
        Intrinsics.checkNotNullParameter(function02, "onGoogleSignInClick");
        Intrinsics.checkNotNullParameter(function03, "onSkipForNowClick");
        this.onEmailSignUpClick = function0;
        this.onGoogleSignInClick = function02;
        this.onSkipForNowClick = function03;
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/armmc/app/ui/onboarding/OnboardingPagerAdapter$Companion;", "", "<init>", "()V", "PAGE_COUNT", "", "app_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* compiled from: OnboardingPagerAdapter.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public OnboardingViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        int i2;
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        if (i == 0) {
            i2 = R.layout.item_onboarding_page1;
        } else if (i != 1) {
            i2 = R.layout.item_onboarding_page3;
        } else {
            i2 = R.layout.item_onboarding_page2;
        }
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(i2, viewGroup, false);
        Intrinsics.checkNotNull(inflate);
        return new OnboardingViewHolder(this, inflate, i);
    }

    public void onBindViewHolder(OnboardingViewHolder onboardingViewHolder, int i) {
        Intrinsics.checkNotNullParameter(onboardingViewHolder, "holder");
        onboardingViewHolder.bind(i);
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/armmc/app/ui/onboarding/OnboardingPagerAdapter$OnboardingViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "pageType", "", "<init>", "(Lcom/armmc/app/ui/onboarding/OnboardingPagerAdapter;Landroid/view/View;I)V", "bind", "", "position", "app_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* compiled from: OnboardingPagerAdapter.kt */
    public final class OnboardingViewHolder extends RecyclerView.ViewHolder {
        private final int pageType;
        final /* synthetic */ OnboardingPagerAdapter this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public OnboardingViewHolder(OnboardingPagerAdapter onboardingPagerAdapter, View view, int i) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "itemView");
            this.this$0 = onboardingPagerAdapter;
            this.pageType = i;
        }

        public final void bind(int i) {
            if (this.pageType == 2) {
                MaterialButton materialButton = (MaterialButton) this.itemView.findViewById(R.id.signUpEmailButton);
                if (materialButton != null) {
                    materialButton.setOnClickListener(new OnboardingPagerAdapter$OnboardingViewHolder$$ExternalSyntheticLambda3(this.this$0));
                }
                MaterialButton materialButton2 = (MaterialButton) this.itemView.findViewById(R.id.continueGoogleButton);
                if (materialButton2 != null) {
                    materialButton2.setOnClickListener(new OnboardingPagerAdapter$OnboardingViewHolder$$ExternalSyntheticLambda4(this.this$0));
                }
                TextView textView = (TextView) this.itemView.findViewById(R.id.skipForNowText);
                if (textView != null) {
                    textView.setOnClickListener(new OnboardingPagerAdapter$OnboardingViewHolder$$ExternalSyntheticLambda5(this.this$0));
                }
                SwitchMaterial switchMaterial = (SwitchMaterial) this.itemView.findViewById(R.id.publicAccessToggle);
                TextView textView2 = (TextView) this.itemView.findViewById(R.id.urlText);
                ImageView imageView = (ImageView) this.itemView.findViewById(R.id.urlIcon);
                int color = ContextCompat.getColor(this.itemView.getContext(), R.color.text_tint);
                int color2 = ContextCompat.getColor(this.itemView.getContext(), R.color.primary_accent);
                if (switchMaterial != null) {
                    switchMaterial.setOnCheckedChangeListener(new OnboardingPagerAdapter$OnboardingViewHolder$$ExternalSyntheticLambda6(color, color2, switchMaterial, textView2, imageView));
                }
                new Handler(Looper.getMainLooper()).postDelayed(new OnboardingPagerAdapter$OnboardingViewHolder$$ExternalSyntheticLambda7(switchMaterial), 2000);
                TextView textView3 = (TextView) this.itemView.findViewById(R.id.descriptionText);
                if (textView3 != null) {
                    CharSequence charSequence = "Register now, start a server, and get a free public temporary URL to play together with your friends.";
                    SpannableString spannableString = new SpannableString(charSequence);
                    int indexOf$default = StringsKt.indexOf$default(charSequence, "public domain", 0, false, 6, (Object) null);
                    if (indexOf$default >= 0) {
                        spannableString.setSpan(new ForegroundColorSpan(ContextCompat.getColor(this.itemView.getContext(), R.color.primary_accent)), indexOf$default, indexOf$default + 13, 33);
                    }
                    textView3.setText(spannableString);
                }
            }
        }

        /* access modifiers changed from: private */
        public static final void bind$lambda$0(OnboardingPagerAdapter onboardingPagerAdapter, View view) {
            onboardingPagerAdapter.onEmailSignUpClick.invoke();
        }

        /* access modifiers changed from: private */
        public static final void bind$lambda$1(OnboardingPagerAdapter onboardingPagerAdapter, View view) {
            onboardingPagerAdapter.onGoogleSignInClick.invoke();
        }

        /* access modifiers changed from: private */
        public static final void bind$lambda$2(OnboardingPagerAdapter onboardingPagerAdapter, View view) {
            onboardingPagerAdapter.onSkipForNowClick.invoke();
        }

        private static final void bind$animateToggleState(int i, int i2, SwitchMaterial switchMaterial, TextView textView, ImageView imageView, boolean z) {
            int i3 = z ? i : i2;
            if (z) {
                i = i2;
            }
            if (switchMaterial != null) {
                ValueAnimator ofObject = ValueAnimator.ofObject(new ArgbEvaluator(), new Object[]{Integer.valueOf(i3), Integer.valueOf(i)});
                ofObject.setDuration(300);
                ofObject.addUpdateListener(new OnboardingPagerAdapter$OnboardingViewHolder$$ExternalSyntheticLambda0(switchMaterial));
                ofObject.start();
            }
            if (textView != null) {
                ValueAnimator ofObject2 = ValueAnimator.ofObject(new ArgbEvaluator(), new Object[]{Integer.valueOf(i3), Integer.valueOf(i)});
                ofObject2.setDuration(300);
                ofObject2.addUpdateListener(new OnboardingPagerAdapter$OnboardingViewHolder$$ExternalSyntheticLambda1(textView));
                ofObject2.start();
                textView.setText(z ? "sleepy-dragon-52.witherhost.com" : "192.168.178.1:25565");
            }
            if (imageView != null) {
                ValueAnimator ofObject3 = ValueAnimator.ofObject(new ArgbEvaluator(), new Object[]{Integer.valueOf(i3), Integer.valueOf(i)});
                ofObject3.setDuration(300);
                ofObject3.addUpdateListener(new OnboardingPagerAdapter$OnboardingViewHolder$$ExternalSyntheticLambda2(imageView));
                ofObject3.start();
            }
        }

        /* access modifiers changed from: private */
        public static final void bind$animateToggleState$lambda$4$lambda$3(SwitchMaterial switchMaterial, ValueAnimator valueAnimator) {
            Intrinsics.checkNotNullParameter(valueAnimator, "animator");
            Object animatedValue = valueAnimator.getAnimatedValue();
            Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Int");
            switchMaterial.setThumbTintList(ColorStateList.valueOf(((Integer) animatedValue).intValue()));
        }

        /* access modifiers changed from: private */
        public static final void bind$animateToggleState$lambda$6$lambda$5(TextView textView, ValueAnimator valueAnimator) {
            Intrinsics.checkNotNullParameter(valueAnimator, "animator");
            Object animatedValue = valueAnimator.getAnimatedValue();
            Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Int");
            textView.setTextColor(((Integer) animatedValue).intValue());
        }

        /* access modifiers changed from: private */
        public static final void bind$animateToggleState$lambda$8$lambda$7(ImageView imageView, ValueAnimator valueAnimator) {
            Intrinsics.checkNotNullParameter(valueAnimator, "animator");
            Object animatedValue = valueAnimator.getAnimatedValue();
            Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Int");
            imageView.setImageTintList(ColorStateList.valueOf(((Integer) animatedValue).intValue()));
        }

        /* access modifiers changed from: private */
        public static final void bind$lambda$9(int i, int i2, SwitchMaterial switchMaterial, TextView textView, ImageView imageView, CompoundButton compoundButton, boolean z) {
            Intrinsics.checkNotNullParameter(compoundButton, "<unused var>");
            bind$animateToggleState(i, i2, switchMaterial, textView, imageView, z);
        }

        /* access modifiers changed from: private */
        public static final void bind$lambda$10(SwitchMaterial switchMaterial) {
            if (switchMaterial != null) {
                switchMaterial.setChecked(true);
            }
        }
    }
}
