package com.armmc.app.ui.servers;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J*\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0016J*\u0010\f\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0016J\u0012\u0010\u000e\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u000fH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"com/armmc/app/ui/servers/MotdBuilderDialog$setupListeners$1", "Landroid/text/TextWatcher;", "isProcessing", "", "beforeTextChanged", "", "s", "", "start", "", "count", "after", "onTextChanged", "before", "afterTextChanged", "Landroid/text/Editable;", "app_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* compiled from: MotdBuilderDialog.kt */
public final class MotdBuilderDialog$setupListeners$1 implements TextWatcher {
    private boolean isProcessing;
    final /* synthetic */ MotdBuilderDialog this$0;

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    MotdBuilderDialog$setupListeners$1(MotdBuilderDialog motdBuilderDialog) {
        this.this$0 = motdBuilderDialog;
    }

    public void afterTextChanged(Editable editable) {
        String str;
        if (!this.isProcessing) {
            if (editable == null || (str = editable.toString()) == null) {
                str = "";
            }
            CharSequence charSequence = str;
            int i = 0;
            for (int i2 = 0; i2 < charSequence.length(); i2++) {
                if (charSequence.charAt(i2) == 10) {
                    i++;
                }
            }
            EditText editText = null;
            if (i > 1) {
                this.isProcessing = true;
                int indexOf$default = StringsKt.indexOf$default(charSequence, 10, 0, false, 6, (Object) null) + 1;
                String substring = str.substring(0, indexOf$default);
                Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
                String substring2 = str.substring(indexOf$default);
                Intrinsics.checkNotNullExpressionValue(substring2, "substring(...)");
                String str2 = substring + StringsKt.replace$default(substring2, "\n", "", false, 4, (Object) null);
                EditText access$getMotdEditText$p = this.this$0.motdEditText;
                if (access$getMotdEditText$p == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("motdEditText");
                    access$getMotdEditText$p = null;
                }
                access$getMotdEditText$p.setText(str2);
                EditText access$getMotdEditText$p2 = this.this$0.motdEditText;
                if (access$getMotdEditText$p2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("motdEditText");
                    access$getMotdEditText$p2 = null;
                }
                int length = str2.length();
                EditText access$getMotdEditText$p3 = this.this$0.motdEditText;
                if (access$getMotdEditText$p3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("motdEditText");
                    access$getMotdEditText$p3 = null;
                }
                access$getMotdEditText$p2.setSelection(RangesKt.coerceAtMost(length, access$getMotdEditText$p3.getText().length()));
                this.isProcessing = false;
            }
            MotdBuilderDialog motdBuilderDialog = this.this$0;
            EditText access$getMotdEditText$p4 = motdBuilderDialog.motdEditText;
            if (access$getMotdEditText$p4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("motdEditText");
            } else {
                editText = access$getMotdEditText$p4;
            }
            motdBuilderDialog.currentMotd = editText.getText().toString();
            this.this$0.updatePreview();
            this.this$0.updateCharCount();
        }
    }
}
