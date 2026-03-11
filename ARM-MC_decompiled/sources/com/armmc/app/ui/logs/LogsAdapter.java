package com.armmc.app.ui.logs;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.armmc.app.R;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\u000f\u0010B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\nH\u0016¨\u0006\u0011"}, d2 = {"Lcom/armmc/app/ui/logs/LogsAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/armmc/app/ui/logs/LogEntry;", "Lcom/armmc/app/ui/logs/LogsAdapter$LogViewHolder;", "<init>", "()V", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "", "holder", "position", "LogViewHolder", "LogDiffCallback", "app_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* compiled from: LogsAdapter.kt */
public final class LogsAdapter extends ListAdapter<LogEntry, LogViewHolder> {
    public LogsAdapter() {
        super(new LogDiffCallback());
    }

    public LogViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.log_item, viewGroup, false);
        Intrinsics.checkNotNull(inflate);
        return new LogViewHolder(inflate);
    }

    public void onBindViewHolder(LogViewHolder logViewHolder, int i) {
        Intrinsics.checkNotNullParameter(logViewHolder, "holder");
        Object item = getItem(i);
        Intrinsics.checkNotNullExpressionValue(item, "getItem(...)");
        logViewHolder.bind((LogEntry) item);
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/armmc/app/ui/logs/LogsAdapter$LogViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "container", "Landroid/widget/LinearLayout;", "logIcon", "Landroid/widget/ImageView;", "logTimestamp", "Landroid/widget/TextView;", "logLevel", "logMessage", "bind", "", "logEntry", "Lcom/armmc/app/ui/logs/LogEntry;", "app_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* compiled from: LogsAdapter.kt */
    public static final class LogViewHolder extends RecyclerView.ViewHolder {
        private final LinearLayout container;
        private final ImageView logIcon;
        private final TextView logLevel;
        private final TextView logMessage;
        private final TextView logTimestamp;

        @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
        /* compiled from: LogsAdapter.kt */
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            /* JADX WARNING: Can't wrap try/catch for region: R(11:0|1|2|3|4|5|6|7|8|9|11) */
            /* JADX WARNING: Failed to process nested try/catch */
            /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
            /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
            /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0022 */
            static {
                /*
                    com.armmc.app.ui.logs.LogLevel[] r0 = com.armmc.app.ui.logs.LogLevel.values()
                    int r0 = r0.length
                    int[] r0 = new int[r0]
                    com.armmc.app.ui.logs.LogLevel r1 = com.armmc.app.ui.logs.LogLevel.INFO     // Catch:{ NoSuchFieldError -> 0x0010 }
                    int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                    r2 = 1
                    r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
                L_0x0010:
                    com.armmc.app.ui.logs.LogLevel r1 = com.armmc.app.ui.logs.LogLevel.WARN     // Catch:{ NoSuchFieldError -> 0x0019 }
                    int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                    r2 = 2
                    r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
                L_0x0019:
                    com.armmc.app.ui.logs.LogLevel r1 = com.armmc.app.ui.logs.LogLevel.ERROR     // Catch:{ NoSuchFieldError -> 0x0022 }
                    int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                    r2 = 3
                    r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
                L_0x0022:
                    com.armmc.app.ui.logs.LogLevel r1 = com.armmc.app.ui.logs.LogLevel.DEBUG     // Catch:{ NoSuchFieldError -> 0x002b }
                    int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002b }
                    r2 = 4
                    r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002b }
                L_0x002b:
                    $EnumSwitchMapping$0 = r0
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.armmc.app.ui.logs.LogsAdapter.LogViewHolder.WhenMappings.<clinit>():void");
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public LogViewHolder(View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "itemView");
            this.container = (LinearLayout) view;
            View findViewById = view.findViewById(R.id.logIcon);
            Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(...)");
            this.logIcon = (ImageView) findViewById;
            View findViewById2 = view.findViewById(R.id.logTimestamp);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(...)");
            this.logTimestamp = (TextView) findViewById2;
            View findViewById3 = view.findViewById(R.id.logLevel);
            Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(...)");
            this.logLevel = (TextView) findViewById3;
            View findViewById4 = view.findViewById(R.id.logMessage);
            Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(...)");
            this.logMessage = (TextView) findViewById4;
        }

        public final void bind(LogEntry logEntry) {
            Intrinsics.checkNotNullParameter(logEntry, "logEntry");
            this.logTimestamp.setText(logEntry.getTimestamp());
            this.logMessage.setText(logEntry.getMessage());
            int i = WhenMappings.$EnumSwitchMapping$0[logEntry.getLevel().ordinal()];
            if (i == 1) {
                this.logIcon.setImageResource(R.drawable.ic_chat);
                this.logIcon.setColorFilter(-9735552);
                this.logLevel.setText("INFO");
                this.logLevel.setTextColor(-9735552);
                this.logTimestamp.setTextColor(-9735552);
                this.container.setBackgroundResource(0);
            } else if (i == 2) {
                this.logIcon.setImageResource(17301659);
                this.logIcon.setColorFilter(-18611);
                this.logLevel.setText("WARN");
                this.logLevel.setTextColor(-18611);
                this.logTimestamp.setTextColor(-18611);
                this.container.setBackgroundResource(R.drawable.log_item_border_warn);
            } else if (i == 3) {
                this.logIcon.setImageResource(17301543);
                this.logIcon.setColorFilter(-1739917);
                this.logLevel.setText("ERROR");
                this.logLevel.setTextColor(-1739917);
                this.logTimestamp.setTextColor(-1739917);
                this.container.setBackgroundResource(R.drawable.log_item_border_error);
            } else if (i == 4) {
                this.logIcon.setImageResource(17301569);
                this.logIcon.setColorFilter(-8271996);
                this.logLevel.setText("DEBUG");
                this.logLevel.setTextColor(-8271996);
                this.logTimestamp.setTextColor(-8271996);
                this.container.setBackgroundResource(R.drawable.log_item_border_debug);
            } else {
                throw new NoWhenBranchMatchedException();
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002H\u0016J\u0018\u0010\t\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002H\u0016¨\u0006\n"}, d2 = {"Lcom/armmc/app/ui/logs/LogsAdapter$LogDiffCallback;", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lcom/armmc/app/ui/logs/LogEntry;", "<init>", "()V", "areItemsTheSame", "", "oldItem", "newItem", "areContentsTheSame", "app_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* compiled from: LogsAdapter.kt */
    public static final class LogDiffCallback extends DiffUtil.ItemCallback<LogEntry> {
        public boolean areItemsTheSame(LogEntry logEntry, LogEntry logEntry2) {
            Intrinsics.checkNotNullParameter(logEntry, "oldItem");
            Intrinsics.checkNotNullParameter(logEntry2, "newItem");
            return Intrinsics.areEqual((Object) logEntry.getTimestamp(), (Object) logEntry2.getTimestamp()) && Intrinsics.areEqual((Object) logEntry.getMessage(), (Object) logEntry2.getMessage());
        }

        public boolean areContentsTheSame(LogEntry logEntry, LogEntry logEntry2) {
            Intrinsics.checkNotNullParameter(logEntry, "oldItem");
            Intrinsics.checkNotNullParameter(logEntry2, "newItem");
            return Intrinsics.areEqual((Object) logEntry, (Object) logEntry2);
        }
    }
}
