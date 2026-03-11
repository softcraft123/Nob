package com.armmc.app.ui.files;

import androidx.activity.OnBackPressedCallback;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"com/armmc/app/ui/files/FilesFragment$backCallback$1", "Landroidx/activity/OnBackPressedCallback;", "handleOnBackPressed", "", "app_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* compiled from: FilesFragment.kt */
public final class FilesFragment$backCallback$1 extends OnBackPressedCallback {
    final /* synthetic */ FilesFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FilesFragment$backCallback$1(FilesFragment filesFragment) {
        super(false);
        this.this$0 = filesFragment;
    }

    public void handleOnBackPressed() {
        FilesViewModel access$getViewModel$p = this.this$0.viewModel;
        if (access$getViewModel$p == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            access$getViewModel$p = null;
        }
        if (!access$getViewModel$p.navigateUp()) {
            setEnabled(false);
            this.this$0.requireActivity().getOnBackPressedDispatcher().onBackPressed();
        }
    }
}
