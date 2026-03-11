package com.armmc.app.ui.files;

import android.content.DialogInterface;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class FilesFragment$$ExternalSyntheticLambda0 implements DialogInterface.OnClickListener {
    public final /* synthetic */ FilesFragment f$0;
    public final /* synthetic */ FileItem f$1;

    public /* synthetic */ FilesFragment$$ExternalSyntheticLambda0(FilesFragment filesFragment, FileItem fileItem) {
        this.f$0 = filesFragment;
        this.f$1 = fileItem;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        FilesFragment.setupRecyclerView$lambda$2$lambda$1(this.f$0, this.f$1, dialogInterface, i);
    }
}
