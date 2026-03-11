package com.armmc.app.ui.profile;

import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import com.armmc.app.util.SubdomainValidator;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J*\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0016J*\u0010\n\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0012\u0010\f\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\rH\u0016¨\u0006\u000e"}, d2 = {"com/armmc/app/ui/profile/ClaimSubdomainFragment$setupSubdomainInput$1", "Landroid/text/TextWatcher;", "beforeTextChanged", "", "s", "", "start", "", "count", "after", "onTextChanged", "before", "afterTextChanged", "Landroid/text/Editable;", "app_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* compiled from: ClaimSubdomainFragment.kt */
public final class ClaimSubdomainFragment$setupSubdomainInput$1 implements TextWatcher {
    final /* synthetic */ ClaimSubdomainFragment this$0;

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    ClaimSubdomainFragment$setupSubdomainInput$1(ClaimSubdomainFragment claimSubdomainFragment) {
        this.this$0 = claimSubdomainFragment;
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        Runnable access$getAvailabilityCheckRunnable$p = this.this$0.availabilityCheckRunnable;
        if (access$getAvailabilityCheckRunnable$p != null) {
            this.this$0.availabilityCheckHandler.removeCallbacks(access$getAvailabilityCheckRunnable$p);
        }
    }

    public void afterTextChanged(Editable editable) {
        String str;
        if (editable == null || (str = editable.toString()) == null) {
            str = "";
        }
        ClaimSubdomainFragment claimSubdomainFragment = this.this$0;
        String lowerCase = str.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        claimSubdomainFragment.currentSubdomain = StringsKt.trim((CharSequence) lowerCase).toString();
        this.this$0.isSubdomainAvailable = false;
        this.this$0.updateClaimButtonState();
        Pair<Boolean, String> realtimeHint = SubdomainValidator.INSTANCE.getRealtimeHint(this.this$0.currentSubdomain);
        boolean booleanValue = realtimeHint.component1().booleanValue();
        String component2 = realtimeHint.component2();
        if (this.this$0.currentSubdomain.length() == 0) {
            this.this$0.hideAvailabilityStatus();
            return;
        }
        String str2 = "Invalid subdomain";
        if (!booleanValue) {
            ClaimSubdomainFragment claimSubdomainFragment2 = this.this$0;
            if (component2 == null) {
                component2 = str2;
            }
            claimSubdomainFragment2.showValidationError(component2);
            this.this$0.isSubdomainValid = false;
        } else if (component2 != null) {
            this.this$0.showValidationHint(component2);
            this.this$0.isSubdomainValid = false;
        } else {
            SubdomainValidator.ValidationResult validate = SubdomainValidator.INSTANCE.validate(this.this$0.currentSubdomain);
            if (!validate.isValid()) {
                ClaimSubdomainFragment claimSubdomainFragment3 = this.this$0;
                String errorMessage = validate.getErrorMessage();
                if (errorMessage != null) {
                    str2 = errorMessage;
                }
                claimSubdomainFragment3.showValidationError(str2);
                this.this$0.isSubdomainValid = false;
                return;
            }
            this.this$0.isSubdomainValid = true;
            this.this$0.showAvailabilityLoading();
            ClaimSubdomainFragment claimSubdomainFragment4 = this.this$0;
            claimSubdomainFragment4.availabilityCheckRunnable = new ClaimSubdomainFragment$setupSubdomainInput$1$$ExternalSyntheticLambda0(claimSubdomainFragment4);
            Handler access$getAvailabilityCheckHandler$p = this.this$0.availabilityCheckHandler;
            Runnable access$getAvailabilityCheckRunnable$p = this.this$0.availabilityCheckRunnable;
            Intrinsics.checkNotNull(access$getAvailabilityCheckRunnable$p);
            access$getAvailabilityCheckHandler$p.postDelayed(access$getAvailabilityCheckRunnable$p, this.this$0.AVAILABILITY_CHECK_DELAY);
        }
    }

    /* access modifiers changed from: private */
    public static final void afterTextChanged$lambda$1(ClaimSubdomainFragment claimSubdomainFragment) {
        claimSubdomainFragment.checkSubdomainAvailability(claimSubdomainFragment.currentSubdomain);
    }
}
