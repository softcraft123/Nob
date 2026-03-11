package com.armmc.app.ui.files;

import android.view.MenuItem;
import android.widget.PopupMenu;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class FileAdapter$$ExternalSyntheticLambda0 implements PopupMenu.OnMenuItemClickListener {
    public final /* synthetic */ FileAdapter f$0;
    public final /* synthetic */ FileItem f$1;

    public /* synthetic */ FileAdapter$$ExternalSyntheticLambda0(FileAdapter fileAdapter, FileItem fileItem) {
        this.f$0 = fileAdapter;
        this.f$1 = fileItem;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        return FileAdapter.onBindViewHolder$lambda$2$lambda$1(this.f$0, this.f$1, menuItem);
    }
}
