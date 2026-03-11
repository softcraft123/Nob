package com.armmc.app.ui.logs;

import android.content.Context;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.text.Editable;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.armmc.app.LogManager;
import com.armmc.app.PumpkinService;
import com.armmc.app.R;
import com.armmc.app.databinding.FragmentLogsBinding;
import com.armmc.app.ui.servers.ServerRepository;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u001dB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u0019H\u0002J\b\u0010\u001a\u001a\u00020\u0019H\u0002J\b\u0010\u001b\u001a\u00020\u0019H\u0002J\b\u0010\u001c\u001a\u00020\u0019H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u00058BX\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX.¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX.¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/armmc/app/ui/logs/LogsFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "_binding", "Lcom/armmc/app/databinding/FragmentLogsBinding;", "binding", "getBinding", "()Lcom/armmc/app/databinding/FragmentLogsBinding;", "logsAdapter", "Lcom/armmc/app/ui/logs/LogsAdapter;", "serverRepository", "Lcom/armmc/app/ui/servers/ServerRepository;", "quickCommands", "", "Lcom/armmc/app/ui/logs/LogsFragment$QuickCommand;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "setupCommandChips", "", "setupCommandInput", "sendCommand", "onDestroyView", "QuickCommand", "app_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* compiled from: LogsFragment.kt */
public final class LogsFragment extends Fragment {
    private FragmentLogsBinding _binding;
    private LogsAdapter logsAdapter;
    private final List<QuickCommand> quickCommands = CollectionsKt.listOf(new QuickCommand("/stop", "stop", R.drawable.ic_close, true), new QuickCommand("/help", "help", R.drawable.ic_document, false, 8, (DefaultConstructorMarker) null), new QuickCommand("/list", "list", R.drawable.ic_logs, false, 8, (DefaultConstructorMarker) null), new QuickCommand("/op", "op ", R.drawable.ic_shield, false, 8, (DefaultConstructorMarker) null), new QuickCommand("/kick", "kick ", R.drawable.ic_logout, false, 8, (DefaultConstructorMarker) null), new QuickCommand("/ban", "ban ", R.drawable.ic_skull, false, 8, (DefaultConstructorMarker) null), new QuickCommand("/say", "say ", R.drawable.ic_chat, false, 8, (DefaultConstructorMarker) null), new QuickCommand("/time day", "time set day", R.drawable.ic_clock, false, 8, (DefaultConstructorMarker) null), new QuickCommand("/time night", "time set night", R.drawable.ic_clock, false, 8, (DefaultConstructorMarker) null), new QuickCommand("/weather clear", "weather clear", R.drawable.ic_bolt, false, 8, (DefaultConstructorMarker) null), new QuickCommand("/tp", "tp ", R.drawable.ic_arrow_forward, false, 8, (DefaultConstructorMarker) null));
    private ServerRepository serverRepository;

    private final FragmentLogsBinding getBinding() {
        FragmentLogsBinding fragmentLogsBinding = this._binding;
        Intrinsics.checkNotNull(fragmentLogsBinding);
        return fragmentLogsBinding;
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0013\b\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0015\u001a\u00020\bHÆ\u0003J1\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0003\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0017\u001a\u00020\b2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0006HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001b"}, d2 = {"Lcom/armmc/app/ui/logs/LogsFragment$QuickCommand;", "", "label", "", "command", "iconRes", "", "danger", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;IZ)V", "getLabel", "()Ljava/lang/String;", "getCommand", "getIconRes", "()I", "getDanger", "()Z", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "toString", "app_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* compiled from: LogsFragment.kt */
    private static final class QuickCommand {
        private final String command;
        private final boolean danger;
        private final int iconRes;
        private final String label;

        public static /* synthetic */ QuickCommand copy$default(QuickCommand quickCommand, String str, String str2, int i, boolean z, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                str = quickCommand.label;
            }
            if ((i2 & 2) != 0) {
                str2 = quickCommand.command;
            }
            if ((i2 & 4) != 0) {
                i = quickCommand.iconRes;
            }
            if ((i2 & 8) != 0) {
                z = quickCommand.danger;
            }
            return quickCommand.copy(str, str2, i, z);
        }

        public final String component1() {
            return this.label;
        }

        public final String component2() {
            return this.command;
        }

        public final int component3() {
            return this.iconRes;
        }

        public final boolean component4() {
            return this.danger;
        }

        public final QuickCommand copy(String str, String str2, int i, boolean z) {
            Intrinsics.checkNotNullParameter(str, "label");
            Intrinsics.checkNotNullParameter(str2, PumpkinService.EXTRA_COMMAND);
            return new QuickCommand(str, str2, i, z);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof QuickCommand)) {
                return false;
            }
            QuickCommand quickCommand = (QuickCommand) obj;
            return Intrinsics.areEqual((Object) this.label, (Object) quickCommand.label) && Intrinsics.areEqual((Object) this.command, (Object) quickCommand.command) && this.iconRes == quickCommand.iconRes && this.danger == quickCommand.danger;
        }

        public int hashCode() {
            return (((((this.label.hashCode() * 31) + this.command.hashCode()) * 31) + Integer.hashCode(this.iconRes)) * 31) + Boolean.hashCode(this.danger);
        }

        public String toString() {
            String str = this.label;
            String str2 = this.command;
            int i = this.iconRes;
            return "QuickCommand(label=" + str + ", command=" + str2 + ", iconRes=" + i + ", danger=" + this.danger + ")";
        }

        public QuickCommand(String str, String str2, int i, boolean z) {
            Intrinsics.checkNotNullParameter(str, "label");
            Intrinsics.checkNotNullParameter(str2, PumpkinService.EXTRA_COMMAND);
            this.label = str;
            this.command = str2;
            this.iconRes = i;
            this.danger = z;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ QuickCommand(String str, String str2, int i, boolean z, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, str2, i, (i2 & 8) != 0 ? false : z);
        }

        public final String getLabel() {
            return this.label;
        }

        public final String getCommand() {
            return this.command;
        }

        public final int getIconRes() {
            return this.iconRes;
        }

        public final boolean getDanger() {
            return this.danger;
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        this._binding = FragmentLogsBinding.inflate(layoutInflater, viewGroup, false);
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
        this.serverRepository = new ServerRepository(requireContext);
        this.logsAdapter = new LogsAdapter();
        RecyclerView recyclerView = getBinding().logsRecyclerView;
        LogsAdapter logsAdapter2 = this.logsAdapter;
        if (logsAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("logsAdapter");
            logsAdapter2 = null;
        }
        recyclerView.setAdapter(logsAdapter2);
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        LogManager.INSTANCE.getLogs().observe(getViewLifecycleOwner(), new LogsFragment$sam$androidx_lifecycle_Observer$0(new LogsFragment$$ExternalSyntheticLambda4(this)));
        setupCommandChips();
        setupCommandInput();
        ConstraintLayout root = getBinding().getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        return root;
    }

    /* access modifiers changed from: private */
    public static final Unit onCreateView$lambda$3(LogsFragment logsFragment, List list) {
        LogsAdapter logsAdapter2 = logsFragment.logsAdapter;
        if (logsAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("logsAdapter");
            logsAdapter2 = null;
        }
        logsAdapter2.submitList(list, new LogsFragment$$ExternalSyntheticLambda5(logsFragment, list));
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final void onCreateView$lambda$3$lambda$2(LogsFragment logsFragment, List list) {
        logsFragment.getBinding().logsRecyclerView.post(new LogsFragment$$ExternalSyntheticLambda1(list, logsFragment));
    }

    /* access modifiers changed from: private */
    public static final void onCreateView$lambda$3$lambda$2$lambda$1(List list, LogsFragment logsFragment) {
        Intrinsics.checkNotNull(list);
        if (!list.isEmpty()) {
            logsFragment.getBinding().logsRecyclerView.smoothScrollToPosition(list.size() - 1);
        }
    }

    private final void setupCommandChips() {
        LayoutInflater from = LayoutInflater.from(requireContext());
        LinearLayout linearLayout = getBinding().commandChipsContainer;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "commandChipsContainer");
        for (QuickCommand next : this.quickCommands) {
            View inflate = from.inflate(R.layout.item_command_chip, linearLayout, false);
            inflate.setBackground(ContextCompat.getDrawable(requireContext(), next.getDanger() ? R.drawable.bg_command_chip_danger : R.drawable.bg_command_chip));
            int i = -41130;
            int i2 = next.getDanger() ? -41130 : -3418655;
            ImageView imageView = (ImageView) inflate.findViewById(R.id.chipIcon);
            imageView.setImageResource(next.getIconRes());
            imageView.setImageTintList(ColorStateList.valueOf(i2));
            TextView textView = (TextView) inflate.findViewById(R.id.chipLabel);
            textView.setText(next.getLabel());
            if (!next.getDanger()) {
                i = -6378848;
            }
            textView.setTextColor(i);
            inflate.setOnClickListener(new LogsFragment$$ExternalSyntheticLambda0(this, next));
            linearLayout.addView(inflate);
        }
    }

    /* access modifiers changed from: private */
    public static final void setupCommandChips$lambda$6(LogsFragment logsFragment, QuickCommand quickCommand, View view) {
        logsFragment.getBinding().commandInput.setText(quickCommand.getCommand());
        EditText editText = logsFragment.getBinding().commandInput;
        Editable text = logsFragment.getBinding().commandInput.getText();
        editText.setSelection(text != null ? text.length() : 0);
        logsFragment.getBinding().commandInput.requestFocus();
    }

    private final void setupCommandInput() {
        getBinding().sendCommandButton.setOnClickListener(new LogsFragment$$ExternalSyntheticLambda2(this));
        getBinding().commandInput.setOnEditorActionListener(new LogsFragment$$ExternalSyntheticLambda3(this));
    }

    /* access modifiers changed from: private */
    public static final void setupCommandInput$lambda$7(LogsFragment logsFragment, View view) {
        logsFragment.sendCommand();
    }

    /* access modifiers changed from: private */
    public static final boolean setupCommandInput$lambda$8(LogsFragment logsFragment, TextView textView, int i, KeyEvent keyEvent) {
        if (i != 4) {
            return false;
        }
        logsFragment.sendCommand();
        return true;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v0, resolved type: com.armmc.app.ui.servers.ServerData} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v1, resolved type: com.armmc.app.ui.servers.ServerData} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v5, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v2, resolved type: com.armmc.app.ui.servers.ServerData} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v7, resolved type: com.armmc.app.ui.servers.ServerData} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void sendCommand() {
        /*
            r5 = this;
            com.armmc.app.databinding.FragmentLogsBinding r0 = r5.getBinding()
            android.widget.EditText r0 = r0.commandInput
            android.text.Editable r0 = r0.getText()
            java.lang.String r0 = r0.toString()
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            java.lang.CharSequence r0 = kotlin.text.StringsKt.trim((java.lang.CharSequence) r0)
            java.lang.String r0 = r0.toString()
            r1 = r0
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            int r1 = r1.length()
            if (r1 != 0) goto L_0x0022
            return
        L_0x0022:
            com.armmc.app.ui.servers.ServerRepository r1 = r5.serverRepository
            r2 = 0
            if (r1 != 0) goto L_0x002d
            java.lang.String r1 = "serverRepository"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
            r1 = r2
        L_0x002d:
            java.util.List r1 = r1.getAllServers()
            java.lang.Iterable r1 = (java.lang.Iterable) r1
            java.util.Iterator r1 = r1.iterator()
        L_0x0037:
            boolean r3 = r1.hasNext()
            if (r3 == 0) goto L_0x004b
            java.lang.Object r3 = r1.next()
            r4 = r3
            com.armmc.app.ui.servers.ServerData r4 = (com.armmc.app.ui.servers.ServerData) r4
            boolean r4 = r4.isOnline()
            if (r4 == 0) goto L_0x0037
            r2 = r3
        L_0x004b:
            com.armmc.app.ui.servers.ServerData r2 = (com.armmc.app.ui.servers.ServerData) r2
            r1 = 0
            if (r2 != 0) goto L_0x0060
            android.content.Context r0 = r5.requireContext()
            java.lang.String r2 = "Server not running"
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            android.widget.Toast r0 = android.widget.Toast.makeText(r0, r2, r1)
            r0.show()
            return
        L_0x0060:
            android.content.Intent r2 = new android.content.Intent     // Catch:{ Exception -> 0x008c }
            android.content.Context r3 = r5.requireContext()     // Catch:{ Exception -> 0x008c }
            java.lang.Class<com.armmc.app.PumpkinService> r4 = com.armmc.app.PumpkinService.class
            r2.<init>(r3, r4)     // Catch:{ Exception -> 0x008c }
            java.lang.String r3 = "com.armmc.app.ACTION_EXECUTE_COMMAND"
            r2.setAction(r3)     // Catch:{ Exception -> 0x008c }
            java.lang.String r3 = "command"
            r2.putExtra(r3, r0)     // Catch:{ Exception -> 0x008c }
            android.content.Context r0 = r5.requireContext()     // Catch:{ Exception -> 0x008c }
            r0.startService(r2)     // Catch:{ Exception -> 0x008c }
            com.armmc.app.databinding.FragmentLogsBinding r0 = r5.getBinding()     // Catch:{ Exception -> 0x008c }
            android.widget.EditText r0 = r0.commandInput     // Catch:{ Exception -> 0x008c }
            android.text.Editable r0 = r0.getText()     // Catch:{ Exception -> 0x008c }
            if (r0 == 0) goto L_0x00ad
            r0.clear()     // Catch:{ Exception -> 0x008c }
            return
        L_0x008c:
            r0 = move-exception
            android.content.Context r2 = r5.requireContext()
            java.lang.String r0 = r0.getMessage()
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r4 = "Error: "
            r3.<init>(r4)
            java.lang.StringBuilder r0 = r3.append(r0)
            java.lang.String r0 = r0.toString()
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            android.widget.Toast r0 = android.widget.Toast.makeText(r2, r0, r1)
            r0.show()
        L_0x00ad:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.armmc.app.ui.logs.LogsFragment.sendCommand():void");
    }

    public void onDestroyView() {
        super.onDestroyView();
        this._binding = null;
    }
}
