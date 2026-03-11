package com.armmc.app.ui.servers;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J*\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0016J*\u0010\n\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0012\u0010\f\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\rH\u0016¨\u0006\u000e"}, d2 = {"com/armmc/app/ui/servers/WhitelistPlayerLookupDialog$setupListeners$1", "Landroid/text/TextWatcher;", "beforeTextChanged", "", "s", "", "start", "", "count", "after", "onTextChanged", "before", "afterTextChanged", "Landroid/text/Editable;", "app_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* compiled from: WhitelistPlayerLookupDialog.kt */
public final class WhitelistPlayerLookupDialog$setupListeners$1 implements TextWatcher {
    final /* synthetic */ WhitelistPlayerLookupDialog this$0;

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    WhitelistPlayerLookupDialog$setupListeners$1(WhitelistPlayerLookupDialog whitelistPlayerLookupDialog) {
        this.this$0 = whitelistPlayerLookupDialog;
    }

    public void afterTextChanged(Editable editable) {
        Runnable access$getSearchRunnable$p = this.this$0.searchRunnable;
        if (access$getSearchRunnable$p != null) {
            this.this$0.handler.removeCallbacks(access$getSearchRunnable$p);
        }
        TextView textView = null;
        this.this$0.foundEntry = null;
        View access$getResultContainer$p = this.this$0.resultContainer;
        if (access$getResultContainer$p == null) {
            Intrinsics.throwUninitializedPropertyAccessException("resultContainer");
            access$getResultContainer$p = null;
        }
        access$getResultContainer$p.setVisibility(8);
        Button access$getAddButton$p = this.this$0.addButton;
        if (access$getAddButton$p == null) {
            Intrinsics.throwUninitializedPropertyAccessException("addButton");
            access$getAddButton$p = null;
        }
        access$getAddButton$p.setVisibility(8);
        TextView access$getStatusText$p = this.this$0.statusText;
        if (access$getStatusText$p == null) {
            Intrinsics.throwUninitializedPropertyAccessException("statusText");
        } else {
            textView = access$getStatusText$p;
        }
        textView.setVisibility(8);
    }
}
