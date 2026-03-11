package com.armmc.app.ui.files;

import android.content.res.ColorStateList;
import android.text.format.DateUtils;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.armmc.app.R;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001!B=\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u001c\u0010\f\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u001c\u0010\u0011\u001a\u00020\b2\n\u0010\u0012\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u0010H\u0016J\b\u0010\u0014\u001a\u00020\u0010H\u0016J\u0014\u0010\u0015\u001a\u00020\b2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0005H\u0002J\u0010\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J\u0010\u0010\u001d\u001a\u00020\u00182\u0006\u0010\u001e\u001a\u00020\u0018H\u0002J\"\u0010\u001f\u001a\u0014\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00100 2\u0006\u0010\u0019\u001a\u00020\u0005H\u0002R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b0\u0007X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b0\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/armmc/app/ui/files/FileAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/armmc/app/ui/files/FileAdapter$FileViewHolder;", "items", "", "Lcom/armmc/app/ui/files/FileItem;", "onItemClick", "Lkotlin/Function1;", "", "onDeleteClick", "<init>", "(Ljava/util/List;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "holder", "position", "getItemCount", "updateItems", "newItems", "buildSubtitle", "", "item", "formatSize", "bytes", "", "fileTypeLabel", "name", "resolveIconAndColor", "Lkotlin/Triple;", "FileViewHolder", "app_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* compiled from: FileAdapter.kt */
public final class FileAdapter extends RecyclerView.Adapter<FileViewHolder> {
    private List<FileItem> items;
    private final Function1<FileItem, Unit> onDeleteClick;
    private final Function1<FileItem, Unit> onItemClick;

    public FileAdapter(List<FileItem> list, Function1<? super FileItem, Unit> function1, Function1<? super FileItem, Unit> function12) {
        Intrinsics.checkNotNullParameter(list, "items");
        Intrinsics.checkNotNullParameter(function1, "onItemClick");
        Intrinsics.checkNotNullParameter(function12, "onDeleteClick");
        this.items = list;
        this.onItemClick = function1;
        this.onDeleteClick = function12;
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0012\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R\u0011\u0010\u0014\u001a\u00020\u0015¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"Lcom/armmc/app/ui/files/FileAdapter$FileViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Lcom/armmc/app/ui/files/FileAdapter;Landroid/view/View;)V", "iconContainer", "Landroid/widget/FrameLayout;", "getIconContainer", "()Landroid/widget/FrameLayout;", "fileIcon", "Landroid/widget/ImageView;", "getFileIcon", "()Landroid/widget/ImageView;", "fileName", "Landroid/widget/TextView;", "getFileName", "()Landroid/widget/TextView;", "fileSubtitle", "getFileSubtitle", "overflowButton", "Landroid/widget/ImageButton;", "getOverflowButton", "()Landroid/widget/ImageButton;", "app_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* compiled from: FileAdapter.kt */
    public final class FileViewHolder extends RecyclerView.ViewHolder {
        private final ImageView fileIcon;
        private final TextView fileName;
        private final TextView fileSubtitle;
        private final FrameLayout iconContainer;
        private final ImageButton overflowButton;
        final /* synthetic */ FileAdapter this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public FileViewHolder(FileAdapter fileAdapter, View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "itemView");
            this.this$0 = fileAdapter;
            View findViewById = view.findViewById(R.id.iconContainer);
            Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(...)");
            this.iconContainer = (FrameLayout) findViewById;
            View findViewById2 = view.findViewById(R.id.fileIcon);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(...)");
            this.fileIcon = (ImageView) findViewById2;
            View findViewById3 = view.findViewById(R.id.fileName);
            Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(...)");
            this.fileName = (TextView) findViewById3;
            View findViewById4 = view.findViewById(R.id.fileSubtitle);
            Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(...)");
            this.fileSubtitle = (TextView) findViewById4;
            View findViewById5 = view.findViewById(R.id.overflowButton);
            Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(...)");
            this.overflowButton = (ImageButton) findViewById5;
        }

        public final FrameLayout getIconContainer() {
            return this.iconContainer;
        }

        public final ImageView getFileIcon() {
            return this.fileIcon;
        }

        public final TextView getFileName() {
            return this.fileName;
        }

        public final TextView getFileSubtitle() {
            return this.fileSubtitle;
        }

        public final ImageButton getOverflowButton() {
            return this.overflowButton;
        }
    }

    public FileViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_file, viewGroup, false);
        Intrinsics.checkNotNull(inflate);
        return new FileViewHolder(this, inflate);
    }

    public void onBindViewHolder(FileViewHolder fileViewHolder, int i) {
        Intrinsics.checkNotNullParameter(fileViewHolder, "holder");
        FileItem fileItem = this.items.get(i);
        fileViewHolder.getFileName().setText(fileItem.getName());
        fileViewHolder.getFileSubtitle().setText(buildSubtitle(fileItem));
        Triple<Integer, Integer, Integer> resolveIconAndColor = resolveIconAndColor(fileItem);
        int intValue = resolveIconAndColor.component1().intValue();
        int intValue2 = resolveIconAndColor.component2().intValue();
        int intValue3 = resolveIconAndColor.component3().intValue();
        fileViewHolder.getFileIcon().setImageResource(intValue);
        fileViewHolder.getFileIcon().setColorFilter(intValue2);
        fileViewHolder.getIconContainer().setBackgroundTintList(ColorStateList.valueOf(intValue3));
        fileViewHolder.itemView.setOnClickListener(new FileAdapter$$ExternalSyntheticLambda1(this, fileItem));
        fileViewHolder.getOverflowButton().setOnClickListener(new FileAdapter$$ExternalSyntheticLambda2(this, fileItem));
    }

    /* access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$0(FileAdapter fileAdapter, FileItem fileItem, View view) {
        fileAdapter.onItemClick.invoke(fileItem);
    }

    /* access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$2(FileAdapter fileAdapter, FileItem fileItem, View view) {
        PopupMenu popupMenu = new PopupMenu(view.getContext(), view);
        popupMenu.getMenu().add(0, 1, 0, "Delete");
        popupMenu.setOnMenuItemClickListener(new FileAdapter$$ExternalSyntheticLambda0(fileAdapter, fileItem));
        popupMenu.show();
    }

    /* access modifiers changed from: private */
    public static final boolean onBindViewHolder$lambda$2$lambda$1(FileAdapter fileAdapter, FileItem fileItem, MenuItem menuItem) {
        if (menuItem.getItemId() != 1) {
            return false;
        }
        fileAdapter.onDeleteClick.invoke(fileItem);
        return true;
    }

    public int getItemCount() {
        return this.items.size();
    }

    public final void updateItems(List<FileItem> list) {
        Intrinsics.checkNotNullParameter(list, "newItems");
        this.items = list;
        notifyDataSetChanged();
    }

    private final String buildSubtitle(FileItem fileItem) {
        String obj = DateUtils.getRelativeTimeSpanString(fileItem.getLastModified(), System.currentTimeMillis(), ExponentialBackoff.DEFAULT_BACKOFF_MAX_DELAY_MS, 262144).toString();
        if (fileItem.isDirectory()) {
            int childCount = fileItem.getChildCount();
            return (childCount == 1 ? "1 item" : childCount + " items") + " • " + obj;
        }
        return formatSize(fileItem.getSize()) + " • " + fileTypeLabel(fileItem.getName());
    }

    private final String formatSize(long j) {
        if (j < 1024) {
            return j + " B";
        }
        if (j < 1048576) {
            return (j / ((long) 1024)) + " KB";
        } else if (j < 1073741824) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String format = String.format("%.1f MB", Arrays.copyOf(new Object[]{Float.valueOf(((float) j) / 1048576.0f)}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(...)");
            return format;
        } else {
            StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
            String format2 = String.format("%.1f GB", Arrays.copyOf(new Object[]{Float.valueOf(((float) j) / 1.07374182E9f)}, 1));
            Intrinsics.checkNotNullExpressionValue(format2, "format(...)");
            return format2;
        }
    }

    private final String fileTypeLabel(String str) {
        String lowerCase = StringsKt.substringAfterLast(str, '.', "").toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        switch (lowerCase.hashCode()) {
            case -926053069:
                if (!lowerCase.equals("properties")) {
                    return "File";
                }
                return "Config File";
            case 3676:
                if (!lowerCase.equals("so")) {
                    return "File";
                }
                return "Library";
            case 104987:
                if (!lowerCase.equals("jar")) {
                    return "File";
                }
                return "Executable";
            case 105441:
                if (!lowerCase.equals("jpg")) {
                    return "File";
                }
                return "Image";
            case 107332:
                if (!lowerCase.equals("log")) {
                    return "File";
                }
                return "Log File";
            case 111145:
                if (!lowerCase.equals("png")) {
                    return "File";
                }
                return "Image";
            case 115312:
                if (!lowerCase.equals("txt")) {
                    return "File";
                }
                return "Text File";
            case 119768:
                if (!lowerCase.equals("yml")) {
                    return "File";
                }
                break;
            case 3268712:
                if (!lowerCase.equals("jpeg")) {
                    return "File";
                }
                return "Image";
            case 3271912:
                if (!lowerCase.equals("json")) {
                    return "File";
                }
                return "JSON";
            case 3565914:
                if (!lowerCase.equals("toml")) {
                    return "File";
                }
                return "Config File";
            case 3645340:
                if (!lowerCase.equals("webp")) {
                    return "File";
                }
                return "Image";
            case 3701415:
                if (!lowerCase.equals("yaml")) {
                    return "File";
                }
                break;
            default:
                return "File";
        }
        return "Config File";
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0070, code lost:
        if (r4.equals("yaml") != false) goto L_0x016e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x007a, code lost:
        if (r4.equals("webp") == false) goto L_0x018e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0084, code lost:
        if (r4.equals("toml") == false) goto L_0x018e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x008e, code lost:
        if (r4.equals("lock") == false) goto L_0x018e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0098, code lost:
        if (r4.equals("json") == false) goto L_0x018e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x00a2, code lost:
        if (r4.equals("jpeg") == false) goto L_0x018e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x00ac, code lost:
        if (r4.equals("yml") == false) goto L_0x018e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x00b6, code lost:
        if (r4.equals("txt") == false) goto L_0x018e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x00c0, code lost:
        if (r4.equals("png") == false) goto L_0x018e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x00ca, code lost:
        if (r4.equals("pid") == false) goto L_0x018e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00d4, code lost:
        if (r4.equals("log") == false) goto L_0x018e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00f5, code lost:
        return new kotlin.Triple<>(java.lang.Integer.valueOf(com.armmc.app.R.drawable.ic_document), java.lang.Integer.valueOf(android.graphics.Color.parseColor("#8A9A8A")), java.lang.Integer.valueOf(android.graphics.Color.parseColor("#2A2A2A")));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00fc, code lost:
        if (r4.equals("lck") == false) goto L_0x018e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0106, code lost:
        if (r4.equals("jpg") == false) goto L_0x018e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0129, code lost:
        return new kotlin.Triple<>(java.lang.Integer.valueOf(com.armmc.app.R.drawable.ic_document), java.lang.Integer.valueOf(android.graphics.Color.parseColor("#FB923C")), java.lang.Integer.valueOf(android.graphics.Color.parseColor("#3D2200")));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x0130, code lost:
        if (r4.equals("jar") == false) goto L_0x018e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x0139, code lost:
        if (r4.equals("dat") == false) goto L_0x018e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x0142, code lost:
        if (r4.equals("so") == false) goto L_0x018e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x0164, code lost:
        return new kotlin.Triple<>(java.lang.Integer.valueOf(com.armmc.app.R.drawable.ic_stack), java.lang.Integer.valueOf(android.graphics.Color.parseColor("#F87171")), java.lang.Integer.valueOf(android.graphics.Color.parseColor("#3D1A1A")));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x016b, code lost:
        if (r4.equals("properties") == false) goto L_0x018e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x018d, code lost:
        return new kotlin.Triple<>(java.lang.Integer.valueOf(com.armmc.app.R.drawable.ic_cog), java.lang.Integer.valueOf(android.graphics.Color.parseColor("#60A5FA")), java.lang.Integer.valueOf(android.graphics.Color.parseColor("#0E1E35")));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x01ab, code lost:
        return new kotlin.Triple<>(java.lang.Integer.valueOf(com.armmc.app.R.drawable.ic_document), java.lang.Integer.valueOf(android.graphics.Color.parseColor("#8A9A8A")), java.lang.Integer.valueOf(android.graphics.Color.parseColor("#1E2E1E")));
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final kotlin.Triple<java.lang.Integer, java.lang.Integer, java.lang.Integer> resolveIconAndColor(com.armmc.app.ui.files.FileItem r4) {
        /*
            r3 = this;
            boolean r0 = r4.isServer()
            java.lang.String r1 = "#1A3D1A"
            java.lang.String r2 = "#13EC13"
            if (r0 == 0) goto L_0x0026
            kotlin.Triple r4 = new kotlin.Triple
            int r0 = com.armmc.app.R.drawable.ic_server
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            int r2 = android.graphics.Color.parseColor(r2)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            int r1 = android.graphics.Color.parseColor(r1)
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r4.<init>(r0, r2, r1)
            return r4
        L_0x0026:
            boolean r0 = r4.isDirectory()
            if (r0 == 0) goto L_0x0048
            kotlin.Triple r4 = new kotlin.Triple
            int r0 = com.armmc.app.R.drawable.ic_folder
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            int r2 = android.graphics.Color.parseColor(r2)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            int r1 = android.graphics.Color.parseColor(r1)
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r4.<init>(r0, r2, r1)
            return r4
        L_0x0048:
            java.lang.String r4 = r4.getName()
            r0 = 46
            java.lang.String r1 = ""
            java.lang.String r4 = kotlin.text.StringsKt.substringAfterLast((java.lang.String) r4, (char) r0, (java.lang.String) r1)
            java.util.Locale r0 = java.util.Locale.ROOT
            java.lang.String r4 = r4.toLowerCase(r0)
            java.lang.String r0 = "toLowerCase(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r0)
            int r0 = r4.hashCode()
            java.lang.String r1 = "#8A9A8A"
            switch(r0) {
                case -926053069: goto L_0x0165;
                case 3676: goto L_0x013c;
                case 99223: goto L_0x0133;
                case 104987: goto L_0x012a;
                case 105441: goto L_0x0100;
                case 106964: goto L_0x00f6;
                case 107332: goto L_0x00ce;
                case 110987: goto L_0x00c4;
                case 111145: goto L_0x00ba;
                case 115312: goto L_0x00b0;
                case 119768: goto L_0x00a6;
                case 3268712: goto L_0x009c;
                case 3271912: goto L_0x0092;
                case 3327275: goto L_0x0088;
                case 3565914: goto L_0x007e;
                case 3645340: goto L_0x0074;
                case 3701415: goto L_0x006a;
                default: goto L_0x0068;
            }
        L_0x0068:
            goto L_0x018e
        L_0x006a:
            java.lang.String r0 = "yaml"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x018e
            goto L_0x016e
        L_0x0074:
            java.lang.String r0 = "webp"
            boolean r4 = r4.equals(r0)
            if (r4 != 0) goto L_0x010a
            goto L_0x018e
        L_0x007e:
            java.lang.String r0 = "toml"
            boolean r4 = r4.equals(r0)
            if (r4 != 0) goto L_0x016e
            goto L_0x018e
        L_0x0088:
            java.lang.String r0 = "lock"
            boolean r4 = r4.equals(r0)
            if (r4 != 0) goto L_0x0145
            goto L_0x018e
        L_0x0092:
            java.lang.String r0 = "json"
            boolean r4 = r4.equals(r0)
            if (r4 != 0) goto L_0x016e
            goto L_0x018e
        L_0x009c:
            java.lang.String r0 = "jpeg"
            boolean r4 = r4.equals(r0)
            if (r4 != 0) goto L_0x010a
            goto L_0x018e
        L_0x00a6:
            java.lang.String r0 = "yml"
            boolean r4 = r4.equals(r0)
            if (r4 != 0) goto L_0x016e
            goto L_0x018e
        L_0x00b0:
            java.lang.String r0 = "txt"
            boolean r4 = r4.equals(r0)
            if (r4 != 0) goto L_0x00d8
            goto L_0x018e
        L_0x00ba:
            java.lang.String r0 = "png"
            boolean r4 = r4.equals(r0)
            if (r4 != 0) goto L_0x010a
            goto L_0x018e
        L_0x00c4:
            java.lang.String r0 = "pid"
            boolean r4 = r4.equals(r0)
            if (r4 != 0) goto L_0x0145
            goto L_0x018e
        L_0x00ce:
            java.lang.String r0 = "log"
            boolean r4 = r4.equals(r0)
            if (r4 != 0) goto L_0x00d8
            goto L_0x018e
        L_0x00d8:
            kotlin.Triple r4 = new kotlin.Triple
            int r0 = com.armmc.app.R.drawable.ic_document
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            int r1 = android.graphics.Color.parseColor(r1)
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            java.lang.String r2 = "#2A2A2A"
            int r2 = android.graphics.Color.parseColor(r2)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r4.<init>(r0, r1, r2)
            return r4
        L_0x00f6:
            java.lang.String r0 = "lck"
            boolean r4 = r4.equals(r0)
            if (r4 != 0) goto L_0x0145
            goto L_0x018e
        L_0x0100:
            java.lang.String r0 = "jpg"
            boolean r4 = r4.equals(r0)
            if (r4 != 0) goto L_0x010a
            goto L_0x018e
        L_0x010a:
            kotlin.Triple r4 = new kotlin.Triple
            int r0 = com.armmc.app.R.drawable.ic_document
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            java.lang.String r1 = "#FB923C"
            int r1 = android.graphics.Color.parseColor(r1)
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            java.lang.String r2 = "#3D2200"
            int r2 = android.graphics.Color.parseColor(r2)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r4.<init>(r0, r1, r2)
            return r4
        L_0x012a:
            java.lang.String r0 = "jar"
            boolean r4 = r4.equals(r0)
            if (r4 != 0) goto L_0x0145
            goto L_0x018e
        L_0x0133:
            java.lang.String r0 = "dat"
            boolean r4 = r4.equals(r0)
            if (r4 != 0) goto L_0x0145
            goto L_0x018e
        L_0x013c:
            java.lang.String r0 = "so"
            boolean r4 = r4.equals(r0)
            if (r4 != 0) goto L_0x0145
            goto L_0x018e
        L_0x0145:
            kotlin.Triple r4 = new kotlin.Triple
            int r0 = com.armmc.app.R.drawable.ic_stack
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            java.lang.String r1 = "#F87171"
            int r1 = android.graphics.Color.parseColor(r1)
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            java.lang.String r2 = "#3D1A1A"
            int r2 = android.graphics.Color.parseColor(r2)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r4.<init>(r0, r1, r2)
            return r4
        L_0x0165:
            java.lang.String r0 = "properties"
            boolean r4 = r4.equals(r0)
            if (r4 != 0) goto L_0x016e
            goto L_0x018e
        L_0x016e:
            kotlin.Triple r4 = new kotlin.Triple
            int r0 = com.armmc.app.R.drawable.ic_cog
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            java.lang.String r1 = "#60A5FA"
            int r1 = android.graphics.Color.parseColor(r1)
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            java.lang.String r2 = "#0E1E35"
            int r2 = android.graphics.Color.parseColor(r2)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r4.<init>(r0, r1, r2)
            return r4
        L_0x018e:
            kotlin.Triple r4 = new kotlin.Triple
            int r0 = com.armmc.app.R.drawable.ic_document
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            int r1 = android.graphics.Color.parseColor(r1)
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            java.lang.String r2 = "#1E2E1E"
            int r2 = android.graphics.Color.parseColor(r2)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r4.<init>(r0, r1, r2)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.armmc.app.ui.files.FileAdapter.resolveIconAndColor(com.armmc.app.ui.files.FileItem):kotlin.Triple");
    }
}
