package com.armmc.app.ui.servers;

import android.animation.ObjectAnimator;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.armmc.app.R;
import com.armmc.app.ui.components.SparklineView;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.card.MaterialCardView;
import java.io.File;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u0012\u0012\u0004\u0012\u00020\u0002\u0012\b\u0012\u00060\u0003R\u00020\u00000\u0001:\u0003)*+BC\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005\u0012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005\u0012\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0004\b\n\u0010\u000bJ\u001c\u0010\f\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J4\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u00102\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018J*\u0010\u001a\u001a\u00020\u00072\n\u0010\u001b\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u00102\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001dH\u0016J\u001c\u0010\u001a\u001a\u00020\u00072\n\u0010\u001b\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u0010H\u0016J:\u0010\u001f\u001a\u00020\u00072\n\u0010\u001b\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u00102\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018H\u0002J\u0018\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u0006H\u0002J\u0010\u0010%\u001a\u00020!2\u0006\u0010\"\u001a\u00020#H\u0002J \u0010&\u001a\u00020\u00072\u0006\u0010\"\u001a\u00020#2\u0006\u0010'\u001a\u00020(2\u0006\u0010$\u001a\u00020\u0006H\u0002R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006,"}, d2 = {"Lcom/armmc/app/ui/servers/ServerAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/armmc/app/ui/servers/ServerListItem;", "Lcom/armmc/app/ui/servers/ServerAdapter$ServerViewHolder;", "onStartClick", "Lkotlin/Function1;", "Lcom/armmc/app/ui/servers/ServerData;", "", "onSettingsClick", "onDeleteClick", "<init>", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "updateServerResources", "position", "ramUsedMb", "", "ramTotalMb", "cpuPercent", "ramHistory", "", "", "onBindViewHolder", "holder", "payloads", "", "", "updateResourceViews", "getLocalAddress", "", "context", "Landroid/content/Context;", "serverData", "getLocalIpAddress", "loadServerIcon", "imageView", "Landroid/widget/ImageView;", "DiffCallback", "ServerViewHolder", "ResourceUpdatePayload", "app_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* compiled from: ServerAdapter.kt */
public final class ServerAdapter extends ListAdapter<ServerListItem, ServerViewHolder> {
    private final Function1<ServerData, Unit> onDeleteClick;
    private final Function1<ServerData, Unit> onSettingsClick;
    private final Function1<ServerData, Unit> onStartClick;

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    /* compiled from: ServerAdapter.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        /* JADX WARNING: Can't wrap try/catch for region: R(13:0|1|2|3|4|5|6|7|8|9|10|11|13) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0022 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x002b */
        static {
            /*
                com.armmc.app.ui.servers.TunnelStatus[] r0 = com.armmc.app.ui.servers.TunnelStatus.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.armmc.app.ui.servers.TunnelStatus r1 = com.armmc.app.ui.servers.TunnelStatus.CONNECTED     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                com.armmc.app.ui.servers.TunnelStatus r1 = com.armmc.app.ui.servers.TunnelStatus.CONNECTING     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                com.armmc.app.ui.servers.TunnelStatus r1 = com.armmc.app.ui.servers.TunnelStatus.RECONNECTING     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                com.armmc.app.ui.servers.TunnelStatus r1 = com.armmc.app.ui.servers.TunnelStatus.FAILED     // Catch:{ NoSuchFieldError -> 0x002b }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002b }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002b }
            L_0x002b:
                com.armmc.app.ui.servers.TunnelStatus r1 = com.armmc.app.ui.servers.TunnelStatus.DISCONNECTED     // Catch:{ NoSuchFieldError -> 0x0034 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0034 }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0034 }
            L_0x0034:
                $EnumSwitchMapping$0 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.armmc.app.ui.servers.ServerAdapter.WhenMappings.<clinit>():void");
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ServerAdapter(Function1<? super ServerData, Unit> function1, Function1<? super ServerData, Unit> function12, Function1<? super ServerData, Unit> function13) {
        super(new DiffCallback());
        Intrinsics.checkNotNullParameter(function1, "onStartClick");
        Intrinsics.checkNotNullParameter(function12, "onSettingsClick");
        Intrinsics.checkNotNullParameter(function13, "onDeleteClick");
        this.onStartClick = function1;
        this.onSettingsClick = function12;
        this.onDeleteClick = function13;
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002H\u0016J\u0018\u0010\t\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002H\u0016¨\u0006\n"}, d2 = {"Lcom/armmc/app/ui/servers/ServerAdapter$DiffCallback;", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lcom/armmc/app/ui/servers/ServerListItem;", "<init>", "()V", "areItemsTheSame", "", "oldItem", "newItem", "areContentsTheSame", "app_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* compiled from: ServerAdapter.kt */
    public static final class DiffCallback extends DiffUtil.ItemCallback<ServerListItem> {
        public boolean areItemsTheSame(ServerListItem serverListItem, ServerListItem serverListItem2) {
            Intrinsics.checkNotNullParameter(serverListItem, "oldItem");
            Intrinsics.checkNotNullParameter(serverListItem2, "newItem");
            return serverListItem.getServerData().getId() == serverListItem2.getServerData().getId();
        }

        public boolean areContentsTheSame(ServerListItem serverListItem, ServerListItem serverListItem2) {
            Intrinsics.checkNotNullParameter(serverListItem, "oldItem");
            Intrinsics.checkNotNullParameter(serverListItem2, "newItem");
            return Intrinsics.areEqual((Object) serverListItem, (Object) serverListItem2);
        }
    }

    @Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0011\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\fR\u0011\u0010\u0013\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\fR\u0011\u0010\u0015\u001a\u00020\u0016¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0019\u001a\u00020\u0016¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0018R\u0011\u0010\u001b\u001a\u00020\u0016¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0018R\u0011\u0010\u001d\u001a\u00020\u0016¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0018R\u0011\u0010\u001f\u001a\u00020 ¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0011\u0010#\u001a\u00020$¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0011\u0010'\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\fR\u0011\u0010)\u001a\u00020*¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,R\u0011\u0010-\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b.\u0010\u0010R\u0011\u0010/\u001a\u000200¢\u0006\b\n\u0000\u001a\u0004\b1\u00102R\u0011\u00103\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b4\u0010\f¨\u00065"}, d2 = {"Lcom/armmc/app/ui/servers/ServerAdapter$ServerViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Lcom/armmc/app/ui/servers/ServerAdapter;Landroid/view/View;)V", "statusIndicator", "getStatusIndicator", "()Landroid/view/View;", "statusText", "Landroid/widget/TextView;", "getStatusText", "()Landroid/widget/TextView;", "serverIcon", "Landroid/widget/ImageView;", "getServerIcon", "()Landroid/widget/ImageView;", "serverName", "getServerName", "serverInfo", "getServerInfo", "startButton", "Lcom/google/android/material/button/MaterialButton;", "getStartButton", "()Lcom/google/android/material/button/MaterialButton;", "settingsButton", "getSettingsButton", "deleteButton", "getDeleteButton", "ipAddressButton", "getIpAddressButton", "resourceUsageContainer", "Landroidx/constraintlayout/widget/ConstraintLayout;", "getResourceUsageContainer", "()Landroidx/constraintlayout/widget/ConstraintLayout;", "ramUsageSection", "Lcom/google/android/material/card/MaterialCardView;", "getRamUsageSection", "()Lcom/google/android/material/card/MaterialCardView;", "ramUsageValue", "getRamUsageValue", "ramSparkline", "Lcom/armmc/app/ui/components/SparklineView;", "getRamSparkline", "()Lcom/armmc/app/ui/components/SparklineView;", "ramWarningIcon", "getRamWarningIcon", "cpuProgress", "Landroid/widget/ProgressBar;", "getCpuProgress", "()Landroid/widget/ProgressBar;", "cpuPercentage", "getCpuPercentage", "app_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* compiled from: ServerAdapter.kt */
    public final class ServerViewHolder extends RecyclerView.ViewHolder {
        private final TextView cpuPercentage;
        private final ProgressBar cpuProgress;
        private final MaterialButton deleteButton;
        private final MaterialButton ipAddressButton;
        private final SparklineView ramSparkline;
        private final MaterialCardView ramUsageSection;
        private final TextView ramUsageValue;
        private final ImageView ramWarningIcon;
        private final ConstraintLayout resourceUsageContainer;
        private final ImageView serverIcon;
        private final TextView serverInfo;
        private final TextView serverName;
        private final MaterialButton settingsButton;
        private final MaterialButton startButton;
        private final View statusIndicator;
        private final TextView statusText;
        final /* synthetic */ ServerAdapter this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ServerViewHolder(ServerAdapter serverAdapter, View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "itemView");
            this.this$0 = serverAdapter;
            View findViewById = view.findViewById(R.id.statusIndicator);
            Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(...)");
            this.statusIndicator = findViewById;
            View findViewById2 = view.findViewById(R.id.statusText);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(...)");
            this.statusText = (TextView) findViewById2;
            View findViewById3 = view.findViewById(R.id.serverIcon);
            Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(...)");
            this.serverIcon = (ImageView) findViewById3;
            View findViewById4 = view.findViewById(R.id.serverName);
            Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(...)");
            this.serverName = (TextView) findViewById4;
            View findViewById5 = view.findViewById(R.id.serverInfo);
            Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(...)");
            this.serverInfo = (TextView) findViewById5;
            View findViewById6 = view.findViewById(R.id.startButton);
            Intrinsics.checkNotNullExpressionValue(findViewById6, "findViewById(...)");
            this.startButton = (MaterialButton) findViewById6;
            View findViewById7 = view.findViewById(R.id.settingsButton);
            Intrinsics.checkNotNullExpressionValue(findViewById7, "findViewById(...)");
            this.settingsButton = (MaterialButton) findViewById7;
            View findViewById8 = view.findViewById(R.id.deleteButton);
            Intrinsics.checkNotNullExpressionValue(findViewById8, "findViewById(...)");
            this.deleteButton = (MaterialButton) findViewById8;
            View findViewById9 = view.findViewById(R.id.ipAddressButton);
            Intrinsics.checkNotNullExpressionValue(findViewById9, "findViewById(...)");
            this.ipAddressButton = (MaterialButton) findViewById9;
            View findViewById10 = view.findViewById(R.id.resourceUsageContainer);
            Intrinsics.checkNotNullExpressionValue(findViewById10, "findViewById(...)");
            this.resourceUsageContainer = (ConstraintLayout) findViewById10;
            View findViewById11 = view.findViewById(R.id.ramUsageSection);
            Intrinsics.checkNotNullExpressionValue(findViewById11, "findViewById(...)");
            this.ramUsageSection = (MaterialCardView) findViewById11;
            View findViewById12 = view.findViewById(R.id.ramUsageValue);
            Intrinsics.checkNotNullExpressionValue(findViewById12, "findViewById(...)");
            this.ramUsageValue = (TextView) findViewById12;
            View findViewById13 = view.findViewById(R.id.ramSparkline);
            Intrinsics.checkNotNullExpressionValue(findViewById13, "findViewById(...)");
            this.ramSparkline = (SparklineView) findViewById13;
            View findViewById14 = view.findViewById(R.id.ramWarningIcon);
            Intrinsics.checkNotNullExpressionValue(findViewById14, "findViewById(...)");
            this.ramWarningIcon = (ImageView) findViewById14;
            View findViewById15 = view.findViewById(R.id.cpuProgress);
            Intrinsics.checkNotNullExpressionValue(findViewById15, "findViewById(...)");
            this.cpuProgress = (ProgressBar) findViewById15;
            View findViewById16 = view.findViewById(R.id.cpuPercentage);
            Intrinsics.checkNotNullExpressionValue(findViewById16, "findViewById(...)");
            this.cpuPercentage = (TextView) findViewById16;
        }

        public final View getStatusIndicator() {
            return this.statusIndicator;
        }

        public final TextView getStatusText() {
            return this.statusText;
        }

        public final ImageView getServerIcon() {
            return this.serverIcon;
        }

        public final TextView getServerName() {
            return this.serverName;
        }

        public final TextView getServerInfo() {
            return this.serverInfo;
        }

        public final MaterialButton getStartButton() {
            return this.startButton;
        }

        public final MaterialButton getSettingsButton() {
            return this.settingsButton;
        }

        public final MaterialButton getDeleteButton() {
            return this.deleteButton;
        }

        public final MaterialButton getIpAddressButton() {
            return this.ipAddressButton;
        }

        public final ConstraintLayout getResourceUsageContainer() {
            return this.resourceUsageContainer;
        }

        public final MaterialCardView getRamUsageSection() {
            return this.ramUsageSection;
        }

        public final TextView getRamUsageValue() {
            return this.ramUsageValue;
        }

        public final SparklineView getRamSparkline() {
            return this.ramSparkline;
        }

        public final ImageView getRamWarningIcon() {
            return this.ramWarningIcon;
        }

        public final ProgressBar getCpuProgress() {
            return this.cpuProgress;
        }

        public final TextView getCpuPercentage() {
            return this.cpuPercentage;
        }
    }

    public ServerViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_server_card, viewGroup, false);
        Intrinsics.checkNotNull(inflate);
        return new ServerViewHolder(this, inflate);
    }

    public final void updateServerResources(int i, long j, long j2, int i2, List<Float> list) {
        Intrinsics.checkNotNullParameter(list, "ramHistory");
        if (i >= 0 && i < getCurrentList().size()) {
            notifyItemChanged(i, new ResourceUpdatePayload(j, j2, i2, list));
        }
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u0007\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0006HÆ\u0003J\u000f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0003J7\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u0006HÖ\u0001J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001e"}, d2 = {"Lcom/armmc/app/ui/servers/ServerAdapter$ResourceUpdatePayload;", "", "ramUsedMb", "", "ramTotalMb", "cpuPercent", "", "ramHistory", "", "", "<init>", "(JJILjava/util/List;)V", "getRamUsedMb", "()J", "getRamTotalMb", "getCpuPercent", "()I", "getRamHistory", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "", "app_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* compiled from: ServerAdapter.kt */
    public static final class ResourceUpdatePayload {
        private final int cpuPercent;
        private final List<Float> ramHistory;
        private final long ramTotalMb;
        private final long ramUsedMb;

        public static /* synthetic */ ResourceUpdatePayload copy$default(ResourceUpdatePayload resourceUpdatePayload, long j, long j2, int i, List<Float> list, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                j = resourceUpdatePayload.ramUsedMb;
            }
            long j3 = j;
            if ((i2 & 2) != 0) {
                j2 = resourceUpdatePayload.ramTotalMb;
            }
            long j4 = j2;
            if ((i2 & 4) != 0) {
                i = resourceUpdatePayload.cpuPercent;
            }
            int i3 = i;
            if ((i2 & 8) != 0) {
                list = resourceUpdatePayload.ramHistory;
            }
            return resourceUpdatePayload.copy(j3, j4, i3, list);
        }

        public final long component1() {
            return this.ramUsedMb;
        }

        public final long component2() {
            return this.ramTotalMb;
        }

        public final int component3() {
            return this.cpuPercent;
        }

        public final List<Float> component4() {
            return this.ramHistory;
        }

        public final ResourceUpdatePayload copy(long j, long j2, int i, List<Float> list) {
            Intrinsics.checkNotNullParameter(list, "ramHistory");
            return new ResourceUpdatePayload(j, j2, i, list);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ResourceUpdatePayload)) {
                return false;
            }
            ResourceUpdatePayload resourceUpdatePayload = (ResourceUpdatePayload) obj;
            return this.ramUsedMb == resourceUpdatePayload.ramUsedMb && this.ramTotalMb == resourceUpdatePayload.ramTotalMb && this.cpuPercent == resourceUpdatePayload.cpuPercent && Intrinsics.areEqual((Object) this.ramHistory, (Object) resourceUpdatePayload.ramHistory);
        }

        public int hashCode() {
            return (((((Long.hashCode(this.ramUsedMb) * 31) + Long.hashCode(this.ramTotalMb)) * 31) + Integer.hashCode(this.cpuPercent)) * 31) + this.ramHistory.hashCode();
        }

        public String toString() {
            long j = this.ramUsedMb;
            long j2 = this.ramTotalMb;
            int i = this.cpuPercent;
            return "ResourceUpdatePayload(ramUsedMb=" + j + ", ramTotalMb=" + j2 + ", cpuPercent=" + i + ", ramHistory=" + this.ramHistory + ")";
        }

        public ResourceUpdatePayload(long j, long j2, int i, List<Float> list) {
            Intrinsics.checkNotNullParameter(list, "ramHistory");
            this.ramUsedMb = j;
            this.ramTotalMb = j2;
            this.cpuPercent = i;
            this.ramHistory = list;
        }

        public final long getRamUsedMb() {
            return this.ramUsedMb;
        }

        public final long getRamTotalMb() {
            return this.ramTotalMb;
        }

        public final int getCpuPercent() {
            return this.cpuPercent;
        }

        public final List<Float> getRamHistory() {
            return this.ramHistory;
        }
    }

    public void onBindViewHolder(ServerViewHolder serverViewHolder, int i, List<Object> list) {
        Intrinsics.checkNotNullParameter(serverViewHolder, "holder");
        Intrinsics.checkNotNullParameter(list, "payloads");
        if (!list.isEmpty()) {
            Object obj = list.get(0);
            if (obj instanceof ResourceUpdatePayload) {
                ResourceUpdatePayload resourceUpdatePayload = (ResourceUpdatePayload) obj;
                updateResourceViews(serverViewHolder, resourceUpdatePayload.getRamUsedMb(), resourceUpdatePayload.getRamTotalMb(), resourceUpdatePayload.getCpuPercent(), resourceUpdatePayload.getRamHistory());
                return;
            }
        }
        super.onBindViewHolder(serverViewHolder, i, list);
    }

    public void onBindViewHolder(ServerViewHolder serverViewHolder, int i) {
        ServerViewHolder serverViewHolder2;
        Intrinsics.checkNotNullParameter(serverViewHolder, "holder");
        ServerListItem serverListItem = (ServerListItem) getItem(i);
        Server server = serverListItem.getServer();
        ServerData serverData = serverListItem.getServerData();
        serverViewHolder.getServerName().setText(server.getName());
        serverViewHolder.getServerInfo().setText(server.getInfo());
        if (server.isOnline()) {
            serverViewHolder.getStartButton().setText("Stop");
            serverViewHolder.getStartButton().setIcon(serverViewHolder.itemView.getContext().getDrawable(17301539));
            serverViewHolder.getIpAddressButton().setVisibility(0);
            serverViewHolder.getResourceUsageContainer().setVisibility(0);
            serverViewHolder2 = serverViewHolder;
            updateResourceViews(serverViewHolder2, server.getRamUsedMb(), server.getRamTotalMb(), server.getCpuUsagePercent(), ResourceMonitor.INSTANCE.getRamHistory());
            int i2 = WhenMappings.$EnumSwitchMapping$0[server.getTunnelStatus().ordinal()];
            if (i2 == 1) {
                serverViewHolder2.getStatusText().setText("ONLINE");
                serverViewHolder2.getStatusIndicator().setBackgroundResource(R.drawable.status_indicator_online);
                MaterialButton ipAddressButton = serverViewHolder2.getIpAddressButton();
                String tunnelAddress = serverData.getTunnelAddress();
                if (tunnelAddress == null) {
                    Context context = serverViewHolder2.itemView.getContext();
                    Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
                    tunnelAddress = getLocalAddress(context, serverData);
                }
                ipAddressButton.setText(tunnelAddress);
            } else if (i2 == 2) {
                serverViewHolder2.getStatusText().setText("CONNECTING TUNNEL...");
                serverViewHolder2.getStatusIndicator().setBackgroundResource(R.drawable.status_indicator_connecting);
                serverViewHolder2.getIpAddressButton().setText("Connecting...");
            } else if (i2 == 3) {
                serverViewHolder2.getStatusText().setText("RECONNECTING (" + server.getReconnectAttempts() + "/3)...");
                serverViewHolder2.getStatusIndicator().setBackgroundResource(R.drawable.status_indicator_warning);
                serverViewHolder2.getIpAddressButton().setText("Reconnecting...");
            } else if (i2 == 4) {
                serverViewHolder2.getStatusText().setText("TUNNEL FAILED");
                serverViewHolder2.getStatusIndicator().setBackgroundResource(R.drawable.status_indicator_error);
                MaterialButton ipAddressButton2 = serverViewHolder2.getIpAddressButton();
                Context context2 = serverViewHolder2.itemView.getContext();
                Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
                ipAddressButton2.setText(getLocalAddress(context2, serverData));
            } else if (i2 == 5) {
                serverViewHolder2.getStatusText().setText("ONLINE (LOCAL)");
                serverViewHolder2.getStatusIndicator().setBackgroundResource(R.drawable.status_indicator_online);
                MaterialButton ipAddressButton3 = serverViewHolder2.getIpAddressButton();
                Context context3 = serverViewHolder2.itemView.getContext();
                Intrinsics.checkNotNullExpressionValue(context3, "getContext(...)");
                ipAddressButton3.setText(getLocalAddress(context3, serverData));
            } else {
                throw new NoWhenBranchMatchedException();
            }
            serverViewHolder2.getIpAddressButton().setOnClickListener(new ServerAdapter$$ExternalSyntheticLambda0(serverViewHolder2));
        } else {
            serverViewHolder2 = serverViewHolder;
            serverViewHolder2.getStatusText().setText("OFFLINE");
            serverViewHolder2.getStatusIndicator().setBackgroundResource(R.drawable.status_indicator);
            serverViewHolder2.getStartButton().setText("Start");
            serverViewHolder2.getStartButton().setIcon(serverViewHolder2.itemView.getContext().getDrawable(17301540));
            serverViewHolder2.getIpAddressButton().setVisibility(8);
            serverViewHolder2.getRamWarningIcon().setVisibility(8);
            serverViewHolder2.getResourceUsageContainer().setVisibility(8);
            serverViewHolder2.getRamSparkline().clearData();
            serverViewHolder2.getRamSparkline().setLineColor(ContextCompat.getColor(serverViewHolder2.itemView.getContext(), R.color.primary_accent));
            serverViewHolder2.getRamUsageSection().setStrokeWidth(0);
        }
        Context context4 = serverViewHolder2.itemView.getContext();
        Intrinsics.checkNotNullExpressionValue(context4, "getContext(...)");
        loadServerIcon(context4, serverViewHolder2.getServerIcon(), serverData);
        serverViewHolder2.getStartButton().setOnClickListener(new ServerAdapter$$ExternalSyntheticLambda1(this, serverData));
        serverViewHolder2.getSettingsButton().setOnClickListener(new ServerAdapter$$ExternalSyntheticLambda2(this, serverData));
        serverViewHolder2.getDeleteButton().setOnClickListener(new ServerAdapter$$ExternalSyntheticLambda3(this, serverData));
    }

    /* access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$0(ServerViewHolder serverViewHolder, View view) {
        String obj = serverViewHolder.getIpAddressButton().getText().toString();
        if (!Intrinsics.areEqual((Object) obj, (Object) "Connecting...") && !Intrinsics.areEqual((Object) obj, (Object) "Reconnecting...")) {
            Object systemService = serverViewHolder.itemView.getContext().getSystemService("clipboard");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.content.ClipboardManager");
            ((ClipboardManager) systemService).setPrimaryClip(ClipData.newPlainText("Server Address", obj));
            Toast.makeText(serverViewHolder.itemView.getContext(), "Address copied to clipboard", 0).show();
        }
    }

    /* access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$1(ServerAdapter serverAdapter, ServerData serverData, View view) {
        serverAdapter.onStartClick.invoke(serverData);
    }

    /* access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$2(ServerAdapter serverAdapter, ServerData serverData, View view) {
        serverAdapter.onSettingsClick.invoke(serverData);
    }

    /* access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$3(ServerAdapter serverAdapter, ServerData serverData, View view) {
        serverAdapter.onDeleteClick.invoke(serverData);
    }

    private final void updateResourceViews(ServerViewHolder serverViewHolder, long j, long j2, int i, List<Float> list) {
        String str;
        if (j2 >= 1024) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            str = String.format("%.1fGB / %.1fGB", Arrays.copyOf(new Object[]{Float.valueOf(((float) j) / 1024.0f), Float.valueOf(((float) j2) / 1024.0f)}, 2));
            Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        } else {
            str = j + "MB / " + j2 + "MB";
        }
        serverViewHolder.getRamUsageValue().setText(str);
        boolean z = j2 > 0 && j2 - j < j2 / ((long) 5);
        Context context = serverViewHolder.itemView.getContext();
        if (z) {
            int color = ContextCompat.getColor(context, R.color.danger_light);
            serverViewHolder.getRamSparkline().setLineColor(color);
            serverViewHolder.getRamWarningIcon().setVisibility(0);
            serverViewHolder.getRamUsageSection().setStrokeWidth((int) (((float) 2) * context.getResources().getDisplayMetrics().density));
            serverViewHolder.getRamUsageSection().setStrokeColor(ColorStateList.valueOf(color));
        } else {
            serverViewHolder.getRamSparkline().setLineColor(ContextCompat.getColor(context, R.color.primary_accent));
            serverViewHolder.getRamWarningIcon().setVisibility(8);
            serverViewHolder.getRamUsageSection().setStrokeWidth(0);
        }
        if (!list.isEmpty()) {
            serverViewHolder.getRamSparkline().setValueRange(0.0f, RangesKt.coerceAtLeast((float) j2, 1.0f));
            serverViewHolder.getRamSparkline().setData(list);
        }
        int progress = serverViewHolder.getCpuProgress().getProgress();
        if (progress != i) {
            ObjectAnimator ofInt = ObjectAnimator.ofInt(serverViewHolder.getCpuProgress(), "progress", new int[]{progress, i});
            ofInt.setDuration(500);
            ofInt.setInterpolator(new DecelerateInterpolator());
            ofInt.start();
        }
        serverViewHolder.getCpuPercentage().setText(i + "%");
    }

    private final String getLocalAddress(Context context, ServerData serverData) {
        String localIpAddress = getLocalIpAddress(context);
        return localIpAddress + ":" + serverData.getPort();
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v4, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v2, resolved type: android.net.wifi.WifiManager} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.lang.String getLocalIpAddress(android.content.Context r12) {
        /*
            r11 = this;
            java.lang.String r0 = "iterator(...)"
            java.util.Enumeration r1 = java.net.NetworkInterface.getNetworkInterfaces()     // Catch:{ Exception -> 0x0145 }
            java.util.ArrayList r1 = java.util.Collections.list(r1)     // Catch:{ Exception -> 0x0145 }
            java.util.Iterator r2 = r1.iterator()     // Catch:{ Exception -> 0x0145 }
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r0)     // Catch:{ Exception -> 0x0145 }
        L_0x0011:
            boolean r3 = r2.hasNext()     // Catch:{ Exception -> 0x0145 }
            java.lang.String r4 = "127."
            r5 = 2
            r6 = 0
            r7 = 0
            if (r3 == 0) goto L_0x009d
            java.lang.Object r3 = r2.next()     // Catch:{ Exception -> 0x0145 }
            java.net.NetworkInterface r3 = (java.net.NetworkInterface) r3     // Catch:{ Exception -> 0x0145 }
            boolean r8 = r3.isLoopback()     // Catch:{ Exception -> 0x0145 }
            if (r8 != 0) goto L_0x0011
            boolean r8 = r3.isUp()     // Catch:{ Exception -> 0x0145 }
            if (r8 != 0) goto L_0x002f
            goto L_0x0011
        L_0x002f:
            java.lang.String r8 = r3.getName()     // Catch:{ Exception -> 0x0145 }
            java.lang.String r9 = "getName(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, r9)     // Catch:{ Exception -> 0x0145 }
            java.util.Locale r9 = java.util.Locale.ROOT     // Catch:{ Exception -> 0x0145 }
            java.lang.String r8 = r8.toLowerCase(r9)     // Catch:{ Exception -> 0x0145 }
            java.lang.String r9 = "toLowerCase(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, r9)     // Catch:{ Exception -> 0x0145 }
            r9 = r8
            java.lang.CharSequence r9 = (java.lang.CharSequence) r9     // Catch:{ Exception -> 0x0145 }
            java.lang.String r10 = "wlan"
            java.lang.CharSequence r10 = (java.lang.CharSequence) r10     // Catch:{ Exception -> 0x0145 }
            boolean r9 = kotlin.text.StringsKt.contains$default((java.lang.CharSequence) r9, (java.lang.CharSequence) r10, (boolean) r6, (int) r5, (java.lang.Object) r7)     // Catch:{ Exception -> 0x0145 }
            if (r9 != 0) goto L_0x0069
            r9 = r8
            java.lang.CharSequence r9 = (java.lang.CharSequence) r9     // Catch:{ Exception -> 0x0145 }
            java.lang.String r10 = "eth"
            java.lang.CharSequence r10 = (java.lang.CharSequence) r10     // Catch:{ Exception -> 0x0145 }
            boolean r9 = kotlin.text.StringsKt.contains$default((java.lang.CharSequence) r9, (java.lang.CharSequence) r10, (boolean) r6, (int) r5, (java.lang.Object) r7)     // Catch:{ Exception -> 0x0145 }
            if (r9 != 0) goto L_0x0069
            java.lang.CharSequence r8 = (java.lang.CharSequence) r8     // Catch:{ Exception -> 0x0145 }
            java.lang.String r9 = "rmnet"
            java.lang.CharSequence r9 = (java.lang.CharSequence) r9     // Catch:{ Exception -> 0x0145 }
            boolean r8 = kotlin.text.StringsKt.contains$default((java.lang.CharSequence) r8, (java.lang.CharSequence) r9, (boolean) r6, (int) r5, (java.lang.Object) r7)     // Catch:{ Exception -> 0x0145 }
            if (r8 == 0) goto L_0x0011
        L_0x0069:
            java.util.Enumeration r3 = r3.getInetAddresses()     // Catch:{ Exception -> 0x0145 }
            java.util.ArrayList r3 = java.util.Collections.list(r3)     // Catch:{ Exception -> 0x0145 }
            java.util.Iterator r3 = r3.iterator()     // Catch:{ Exception -> 0x0145 }
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r0)     // Catch:{ Exception -> 0x0145 }
        L_0x0078:
            boolean r8 = r3.hasNext()     // Catch:{ Exception -> 0x0145 }
            if (r8 == 0) goto L_0x0011
            java.lang.Object r8 = r3.next()     // Catch:{ Exception -> 0x0145 }
            java.net.InetAddress r8 = (java.net.InetAddress) r8     // Catch:{ Exception -> 0x0145 }
            boolean r9 = r8.isLoopbackAddress()     // Catch:{ Exception -> 0x0145 }
            if (r9 != 0) goto L_0x0078
            boolean r9 = r8 instanceof java.net.Inet4Address     // Catch:{ Exception -> 0x0145 }
            if (r9 == 0) goto L_0x0078
            java.net.Inet4Address r8 = (java.net.Inet4Address) r8     // Catch:{ Exception -> 0x0145 }
            java.lang.String r8 = r8.getHostAddress()     // Catch:{ Exception -> 0x0145 }
            if (r8 == 0) goto L_0x0078
            boolean r9 = kotlin.text.StringsKt.startsWith$default(r8, r4, r6, r5, r7)     // Catch:{ Exception -> 0x0145 }
            if (r9 != 0) goto L_0x0078
            return r8
        L_0x009d:
            java.util.Iterator r1 = r1.iterator()     // Catch:{ Exception -> 0x0145 }
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r0)     // Catch:{ Exception -> 0x0145 }
        L_0x00a4:
            boolean r2 = r1.hasNext()     // Catch:{ Exception -> 0x0145 }
            if (r2 == 0) goto L_0x00f1
            java.lang.Object r2 = r1.next()     // Catch:{ Exception -> 0x0145 }
            java.net.NetworkInterface r2 = (java.net.NetworkInterface) r2     // Catch:{ Exception -> 0x0145 }
            boolean r3 = r2.isLoopback()     // Catch:{ Exception -> 0x0145 }
            if (r3 != 0) goto L_0x00a4
            boolean r3 = r2.isUp()     // Catch:{ Exception -> 0x0145 }
            if (r3 != 0) goto L_0x00bd
            goto L_0x00a4
        L_0x00bd:
            java.util.Enumeration r2 = r2.getInetAddresses()     // Catch:{ Exception -> 0x0145 }
            java.util.ArrayList r2 = java.util.Collections.list(r2)     // Catch:{ Exception -> 0x0145 }
            java.util.Iterator r2 = r2.iterator()     // Catch:{ Exception -> 0x0145 }
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r0)     // Catch:{ Exception -> 0x0145 }
        L_0x00cc:
            boolean r3 = r2.hasNext()     // Catch:{ Exception -> 0x0145 }
            if (r3 == 0) goto L_0x00a4
            java.lang.Object r3 = r2.next()     // Catch:{ Exception -> 0x0145 }
            java.net.InetAddress r3 = (java.net.InetAddress) r3     // Catch:{ Exception -> 0x0145 }
            boolean r8 = r3.isLoopbackAddress()     // Catch:{ Exception -> 0x0145 }
            if (r8 != 0) goto L_0x00cc
            boolean r8 = r3 instanceof java.net.Inet4Address     // Catch:{ Exception -> 0x0145 }
            if (r8 == 0) goto L_0x00cc
            java.net.Inet4Address r3 = (java.net.Inet4Address) r3     // Catch:{ Exception -> 0x0145 }
            java.lang.String r3 = r3.getHostAddress()     // Catch:{ Exception -> 0x0145 }
            if (r3 == 0) goto L_0x00cc
            boolean r8 = kotlin.text.StringsKt.startsWith$default(r3, r4, r6, r5, r7)     // Catch:{ Exception -> 0x0145 }
            if (r8 != 0) goto L_0x00cc
            return r3
        L_0x00f1:
            android.content.Context r12 = r12.getApplicationContext()     // Catch:{ Exception -> 0x0145 }
            java.lang.String r0 = "wifi"
            java.lang.Object r12 = r12.getSystemService(r0)     // Catch:{ Exception -> 0x0145 }
            boolean r0 = r12 instanceof android.net.wifi.WifiManager     // Catch:{ Exception -> 0x0145 }
            if (r0 == 0) goto L_0x0102
            r7 = r12
            android.net.wifi.WifiManager r7 = (android.net.wifi.WifiManager) r7     // Catch:{ Exception -> 0x0145 }
        L_0x0102:
            if (r7 == 0) goto L_0x0149
            android.net.wifi.WifiInfo r12 = r7.getConnectionInfo()     // Catch:{ Exception -> 0x0145 }
            if (r12 == 0) goto L_0x010e
            int r6 = r12.getIpAddress()     // Catch:{ Exception -> 0x0145 }
        L_0x010e:
            if (r6 == 0) goto L_0x0149
            kotlin.jvm.internal.StringCompanionObject r12 = kotlin.jvm.internal.StringCompanionObject.INSTANCE     // Catch:{ Exception -> 0x0145 }
            java.lang.String r12 = "%d.%d.%d.%d"
            r0 = r6 & 255(0xff, float:3.57E-43)
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch:{ Exception -> 0x0145 }
            int r1 = r6 >> 8
            r1 = r1 & 255(0xff, float:3.57E-43)
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch:{ Exception -> 0x0145 }
            int r2 = r6 >> 16
            r2 = r2 & 255(0xff, float:3.57E-43)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ Exception -> 0x0145 }
            int r3 = r6 >> 24
            r3 = r3 & 255(0xff, float:3.57E-43)
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ Exception -> 0x0145 }
            java.lang.Object[] r0 = new java.lang.Object[]{r0, r1, r2, r3}     // Catch:{ Exception -> 0x0145 }
            r1 = 4
            java.lang.Object[] r0 = java.util.Arrays.copyOf(r0, r1)     // Catch:{ Exception -> 0x0145 }
            java.lang.String r12 = java.lang.String.format(r12, r0)     // Catch:{ Exception -> 0x0145 }
            java.lang.String r0 = "format(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r12, r0)     // Catch:{ Exception -> 0x0145 }
            return r12
        L_0x0145:
            r12 = move-exception
            r12.printStackTrace()
        L_0x0149:
            java.lang.String r12 = "0.0.0.0"
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.armmc.app.ui.servers.ServerAdapter.getLocalIpAddress(android.content.Context):java.lang.String");
    }

    private final void loadServerIcon(Context context, ImageView imageView, ServerData serverData) {
        String iconPath = serverData.getIconPath();
        if (iconPath != null) {
            File file = new File(new File(context.getFilesDir(), "server_" + serverData.getId()), iconPath);
            if (file.exists()) {
                try {
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    options.inJustDecodeBounds = true;
                    BitmapFactory.decodeFile(file.getAbsolutePath(), options);
                    options.inSampleSize = 1;
                    while (true) {
                        if (options.outWidth / (options.inSampleSize * 2) < 128) {
                            if (options.outHeight / (options.inSampleSize * 2) < 128) {
                                break;
                            }
                        }
                        options.inSampleSize *= 2;
                    }
                    options.inJustDecodeBounds = false;
                    Bitmap decodeFile = BitmapFactory.decodeFile(file.getAbsolutePath(), options);
                    if (decodeFile != null) {
                        imageView.setImageBitmap(decodeFile);
                        return;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        imageView.setImageResource(R.drawable.favicon);
    }
}
