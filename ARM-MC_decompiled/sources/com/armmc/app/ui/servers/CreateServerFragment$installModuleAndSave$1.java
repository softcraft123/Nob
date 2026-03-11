package com.armmc.app.ui.servers;

import android.widget.Toast;
import androidx.fragment.app.FragmentActivity;
import com.armmc.app.LogManager;
import com.armmc.app.SplitInstallHelper;
import com.google.android.play.core.splitinstall.SplitInstallSessionState;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\u0007\u001a\u00020\u0003H\u0016J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000fH\u0016¨\u0006\u0010"}, d2 = {"com/armmc/app/ui/servers/CreateServerFragment$installModuleAndSave$1", "Lcom/armmc/app/SplitInstallHelper$InstallCallback;", "onProgress", "", "bytesDownloaded", "", "totalBytes", "onComplete", "onError", "errorCode", "", "message", "", "onRequiresUserConfirmation", "state", "Lcom/google/android/play/core/splitinstall/SplitInstallSessionState;", "app_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* compiled from: CreateServerFragment.kt */
public final class CreateServerFragment$installModuleAndSave$1 implements SplitInstallHelper.InstallCallback {
    final /* synthetic */ String $difficulty;
    final /* synthetic */ String $gamemode;
    final /* synthetic */ boolean $hardcore;
    final /* synthetic */ int $maxPlayers;
    final /* synthetic */ int $memory;
    final /* synthetic */ String $moduleName;
    final /* synthetic */ String $motd;
    final /* synthetic */ boolean $onlineMode;
    final /* synthetic */ String $port;
    final /* synthetic */ String $seed;
    final /* synthetic */ String $serverName;
    final /* synthetic */ int $simulationDistance;
    final /* synthetic */ String $software;
    final /* synthetic */ String $version;
    final /* synthetic */ int $viewDistance;
    final /* synthetic */ boolean $whitelistEnabled;
    final /* synthetic */ String $whitelistEntriesJson;
    final /* synthetic */ CreateServerFragment this$0;

    CreateServerFragment$installModuleAndSave$1(CreateServerFragment createServerFragment, String str, String str2, String str3, int i, String str4, int i2, int i3, int i4, String str5, String str6, String str7, String str8, boolean z, boolean z2, String str9, boolean z3, String str10) {
        this.this$0 = createServerFragment;
        this.$serverName = str;
        this.$software = str2;
        this.$version = str3;
        this.$memory = i;
        this.$port = str4;
        this.$viewDistance = i2;
        this.$simulationDistance = i3;
        this.$maxPlayers = i4;
        this.$seed = str5;
        this.$motd = str6;
        this.$difficulty = str7;
        this.$gamemode = str8;
        this.$onlineMode = z;
        this.$hardcore = z2;
        this.$moduleName = str9;
        this.$whitelistEnabled = z3;
        this.$whitelistEntriesJson = str10;
    }

    public void onProgress(long j, long j2) {
        FragmentActivity activity = this.this$0.getActivity();
        if (activity != null) {
            activity.runOnUiThread(new CreateServerFragment$installModuleAndSave$1$$ExternalSyntheticLambda2(this.this$0, j, j2));
        }
    }

    /* access modifiers changed from: private */
    public static final void onProgress$lambda$0(CreateServerFragment createServerFragment, long j, long j2) {
        createServerFragment.showInstallProgress(j, j2);
    }

    public void onComplete() {
        FragmentActivity activity = this.this$0.getActivity();
        if (activity != null) {
            activity.runOnUiThread(new CreateServerFragment$installModuleAndSave$1$$ExternalSyntheticLambda1(this.this$0, this.$serverName, this.$software, this.$version, this.$memory, this.$port, this.$viewDistance, this.$simulationDistance, this.$maxPlayers, this.$seed, this.$motd, this.$difficulty, this.$gamemode, this.$onlineMode, this.$hardcore, this.$moduleName, this.$whitelistEnabled, this.$whitelistEntriesJson));
        }
    }

    /* access modifiers changed from: private */
    public static final void onComplete$lambda$1(CreateServerFragment createServerFragment, String str, String str2, String str3, int i, String str4, int i2, int i3, int i4, String str5, String str6, String str7, String str8, boolean z, boolean z2, String str9, boolean z3, String str10) {
        createServerFragment.hideLoading();
        createServerFragment.setupVersionSpinners();
        createServerFragment.saveServer(str, str2, str3, i, str4, i2, i3, i4, str5, str6, str7, str8, z, z2, str9, z3, str10);
    }

    public void onError(int i, String str) {
        Intrinsics.checkNotNullParameter(str, LogManager.EXTRA_MESSAGE);
        FragmentActivity activity = this.this$0.getActivity();
        if (activity != null) {
            activity.runOnUiThread(new CreateServerFragment$installModuleAndSave$1$$ExternalSyntheticLambda3(this.this$0, str));
        }
    }

    /* access modifiers changed from: private */
    public static final void onError$lambda$2(CreateServerFragment createServerFragment, String str) {
        createServerFragment.hideLoading();
        Toast.makeText(createServerFragment.getContext(), "Failed to install module: " + str, 1).show();
    }

    public void onRequiresUserConfirmation(SplitInstallSessionState splitInstallSessionState) {
        Intrinsics.checkNotNullParameter(splitInstallSessionState, "state");
        FragmentActivity activity = this.this$0.getActivity();
        if (activity != null) {
            activity.runOnUiThread(new CreateServerFragment$installModuleAndSave$1$$ExternalSyntheticLambda0(this.this$0, splitInstallSessionState));
        }
    }

    /* access modifiers changed from: private */
    public static final void onRequiresUserConfirmation$lambda$4(CreateServerFragment createServerFragment, SplitInstallSessionState splitInstallSessionState) {
        createServerFragment.hideLoading();
        FragmentActivity activity = createServerFragment.getActivity();
        if (activity != null) {
            SplitInstallHelper access$getSplitInstallHelper$p = createServerFragment.splitInstallHelper;
            if (access$getSplitInstallHelper$p == null) {
                Intrinsics.throwUninitializedPropertyAccessException("splitInstallHelper");
                access$getSplitInstallHelper$p = null;
            }
            access$getSplitInstallHelper$p.startUserConfirmation(activity, splitInstallSessionState, 1001);
        }
    }
}
