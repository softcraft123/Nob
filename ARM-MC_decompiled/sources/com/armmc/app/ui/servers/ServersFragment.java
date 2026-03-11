package com.armmc.app.ui.servers;

import android.app.ActivityManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.PowerManager;
import android.os.Process;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AlertDialog;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.fragment.FragmentKt;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.armmc.app.LibraryManager;
import com.armmc.app.LogManager;
import com.armmc.app.PumpkinService;
import com.armmc.app.R;
import com.armmc.app.ReviewHelper;
import com.armmc.app.SplitInstallHelper;
import com.armmc.app.api.TunnelApiService;
import com.armmc.app.databinding.FragmentServersBinding;
import com.armmc.app.frp.FRPClient;
import com.armmc.app.tunnel.TunnelRegionManager;
import com.armmc.app.ui.servers.ResourceMonitor;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.button.MaterialButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GetTokenResult;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.concurrent.ThreadsKt;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000Ù\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010#\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b/*\u00039<?\u0018\u0000 }2\u00020\u0001:\u0002}~B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010&\u001a\u00020\u00152\f\u0010'\u001a\b\u0012\u0004\u0012\u00020)0(H\u0002J&\u0010I\u001a\u0004\u0018\u00010J2\u0006\u0010K\u001a\u00020L2\b\u0010M\u001a\u0004\u0018\u00010N2\b\u0010O\u001a\u0004\u0018\u00010PH\u0016J\u001a\u0010Q\u001a\u00020)2\u0006\u0010R\u001a\u00020J2\b\u0010O\u001a\u0004\u0018\u00010PH\u0016J\b\u0010S\u001a\u00020)H\u0016J\b\u0010T\u001a\u00020)H\u0002J\b\u0010U\u001a\u00020\u0015H\u0002J\b\u0010V\u001a\u00020)H\u0016J\b\u0010W\u001a\u00020)H\u0016J\b\u0010X\u001a\u00020)H\u0002J\u0010\u0010Y\u001a\u00020)2\u0006\u0010Z\u001a\u00020-H\u0002J\u0010\u0010[\u001a\u00020)2\u0006\u0010Z\u001a\u00020-H\u0002J\b\u0010\\\u001a\u00020)H\u0002J\b\u0010]\u001a\u00020\u0015H\u0002J\"\u0010^\u001a\u00020)2\u0006\u0010_\u001a\u00020\u00152\u0006\u0010`\u001a\u00020\u00152\b\b\u0002\u0010a\u001a\u00020\u0015H\u0002J\b\u0010b\u001a\u00020)H\u0002J\b\u0010c\u001a\u00020)H\u0002J\b\u0010d\u001a\u00020)H\u0002J\u0010\u0010e\u001a\u00020)2\u0006\u0010Z\u001a\u00020-H\u0002J\u0010\u0010f\u001a\u00020)2\u0006\u0010Z\u001a\u00020-H\u0002J\u0018\u0010g\u001a\u00020)2\u0006\u0010Z\u001a\u00020-2\u0006\u0010h\u001a\u00020\u0010H\u0002JH\u0010i\u001a\u00020)2\u0006\u0010j\u001a\u00020\u00102\u0006\u0010h\u001a\u00020\u00102\u0006\u0010k\u001a\u00020+2\u0006\u0010l\u001a\u00020\u00102\u0006\u0010m\u001a\u00020+2\u0006\u0010n\u001a\u00020\u00102\u0006\u0010o\u001a\u00020+2\u0006\u0010p\u001a\u00020\u0010H\u0002J\u0018\u0010q\u001a\u00020)2\u0006\u0010j\u001a\u00020\u00102\u0006\u0010r\u001a\u00020+H\u0002J\b\u0010s\u001a\u00020)H\u0002J\b\u0010t\u001a\u00020)H\u0002J\u0010\u0010u\u001a\u00020)2\u0006\u0010v\u001a\u00020+H\u0002J\u0010\u0010w\u001a\u00020)2\u0006\u0010Z\u001a\u00020-H\u0002J\b\u0010x\u001a\u00020)H\u0002J\u0010\u0010y\u001a\u00020)2\u0006\u0010Z\u001a\u00020-H\u0002J\u0014\u0010z\u001a\u0004\u0018\u00010+2\b\u0010{\u001a\u0004\u0018\u00010+H\u0002J\b\u0010|\u001a\u00020)H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u00058BX\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX.¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX.¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX.¢\u0006\u0002\n\u0000R\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0004\n\u0002\u0010\u0011R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00100\u0013X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020 X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X.¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020%X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010*\u001a\u0004\u0018\u00010+X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010,\u001a\u0004\u0018\u00010-X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010.\u001a\u0004\u0018\u00010/X\u000e¢\u0006\u0002\n\u0000R\u0010\u00100\u001a\u0004\u0018\u000101X\u000e¢\u0006\u0002\n\u0000R\u001c\u00102\u001a\u0010\u0012\f\u0012\n 4*\u0004\u0018\u00010+0+03X\u0004¢\u0006\u0002\n\u0000R\u001c\u00105\u001a\u0010\u0012\f\u0012\n 4*\u0004\u0018\u0001060603X\u0004¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u0010\u00108\u001a\u000209X\u0004¢\u0006\u0004\n\u0002\u0010:R\u0010\u0010;\u001a\u00020<X\u0004¢\u0006\u0004\n\u0002\u0010=R\u0010\u0010>\u001a\u00020?X\u0004¢\u0006\u0004\n\u0002\u0010@R\u000e\u0010A\u001a\u00020BX.¢\u0006\u0002\n\u0000R\u000e\u0010C\u001a\u00020DX.¢\u0006\u0002\n\u0000R\u000e\u0010E\u001a\u00020FX.¢\u0006\u0002\n\u0000R\u000e\u0010G\u001a\u00020HX.¢\u0006\u0002\n\u0000¨\u0006"}, d2 = {"Lcom/armmc/app/ui/servers/ServersFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "_binding", "Lcom/armmc/app/databinding/FragmentServersBinding;", "binding", "getBinding", "()Lcom/armmc/app/databinding/FragmentServersBinding;", "libraryManager", "Lcom/armmc/app/LibraryManager;", "splitInstallHelper", "Lcom/armmc/app/SplitInstallHelper;", "reviewHelper", "Lcom/armmc/app/ReviewHelper;", "currentlyRunningServerId", "", "Ljava/lang/Integer;", "stoppingServers", "", "stoppedViaNotification", "", "frpClient", "Lcom/armmc/app/frp/FRPClient;", "currentFrpParams", "Lcom/armmc/app/ui/servers/ServersFragment$FrpConnectionParams;", "frpLock", "Ljava/lang/Object;", "isReconnecting", "currentRetryAttempt", "isIntentionallyStopping", "lastRetryTimestamp", "", "connectionEstablishedTimestamp", "auth", "Lcom/google/firebase/auth/FirebaseAuth;", "tunnelApiService", "Lcom/armmc/app/api/TunnelApiService;", "runOnUiThreadSafe", "block", "Lkotlin/Function0;", "", "currentTunnelAddress", "", "pendingServerStart", "Lcom/armmc/app/ui/servers/ServerData;", "setupDialog", "Lcom/google/android/material/bottomsheet/BottomSheetDialog;", "setupFlipper", "Landroid/widget/ViewFlipper;", "notificationPermissionLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "kotlin.jvm.PlatformType", "batteryOptimizationLauncher", "Landroid/content/Intent;", "isBoundToService", "serviceConnection", "com/armmc/app/ui/servers/ServersFragment$serviceConnection$1", "Lcom/armmc/app/ui/servers/ServersFragment$serviceConnection$1;", "crashReceiver", "com/armmc/app/ui/servers/ServersFragment$crashReceiver$1", "Lcom/armmc/app/ui/servers/ServersFragment$crashReceiver$1;", "serverStoppedReceiver", "com/armmc/app/ui/servers/ServersFragment$serverStoppedReceiver$1", "Lcom/armmc/app/ui/servers/ServersFragment$serverStoppedReceiver$1;", "serversRecyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "createInstanceButton", "Lcom/google/android/material/button/MaterialButton;", "serverAdapter", "Lcom/armmc/app/ui/servers/ServerAdapter;", "serverRepository", "Lcom/armmc/app/ui/servers/ServerRepository;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "onResume", "syncLocalStateWithRepository", "isServerProcessRunning", "onPause", "onDestroyView", "loadServers", "toggleServerStatus", "serverData", "showAlphaWarningDialog", "showServerBusyDialog", "isIgnoringBatteryOptimizations", "showSetupPermissionsDialog", "needsNotificationPermission", "needsBatteryOptimization", "startAtBatteryStep", "advanceSetupToBatteryStep", "requestIgnoreBatteryOptimizations", "finishPermissionSetup", "startServer", "proceedWithStartServer", "requestTunnelAndStartFRP", "localPort", "startFRPClientWithRetry", "serverId", "serverAddr", "serverPort", "authToken", "remotePort", "tunnelAddress", "attempt", "handleFrpDisconnection", "errorMessage", "stopFRPClient", "terminateTunnelOnServer", "handleServerProcessCrash", "reason", "stopServer", "killServerProcess", "deleteServer", "extractVersionFromLibraryKey", "libraryKey", "setupRecyclerView", "Companion", "FrpConnectionParams", "app_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* compiled from: ServersFragment.kt */
public final class ServersFragment extends Fragment {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String FRP_LOCAL_IP = "127.0.0.1";
    private static final int MAX_RETRY_ATTEMPTS = 3;
    private static final long MIN_RETRY_INTERVAL_MS = 5000;
    private static final long RETRY_DELAY_MS = 10000;
    private static final long STABLE_CONNECTION_THRESHOLD_MS = 5000;
    private static final String TAG = "ServersFragment";
    private FragmentServersBinding _binding;
    private FirebaseAuth auth;
    private final ActivityResultLauncher<Intent> batteryOptimizationLauncher;
    private long connectionEstablishedTimestamp;
    private final ServersFragment$crashReceiver$1 crashReceiver;
    private MaterialButton createInstanceButton;
    /* access modifiers changed from: private */
    public FrpConnectionParams currentFrpParams;
    /* access modifiers changed from: private */
    public int currentRetryAttempt;
    private String currentTunnelAddress;
    /* access modifiers changed from: private */
    public Integer currentlyRunningServerId;
    private FRPClient frpClient;
    /* access modifiers changed from: private */
    public final Object frpLock = new Object();
    /* access modifiers changed from: private */
    public boolean isBoundToService;
    private boolean isIntentionallyStopping;
    /* access modifiers changed from: private */
    public boolean isReconnecting;
    private long lastRetryTimestamp;
    private LibraryManager libraryManager;
    private final ActivityResultLauncher<String> notificationPermissionLauncher;
    private ServerData pendingServerStart;
    private ReviewHelper reviewHelper;
    private ServerAdapter serverAdapter;
    /* access modifiers changed from: private */
    public ServerRepository serverRepository;
    private final ServersFragment$serverStoppedReceiver$1 serverStoppedReceiver;
    private RecyclerView serversRecyclerView;
    /* access modifiers changed from: private */
    public final ServersFragment$serviceConnection$1 serviceConnection;
    private BottomSheetDialog setupDialog;
    private ViewFlipper setupFlipper;
    private SplitInstallHelper splitInstallHelper;
    /* access modifiers changed from: private */
    public volatile boolean stoppedViaNotification;
    /* access modifiers changed from: private */
    public final Set<Integer> stoppingServers = new LinkedHashSet();
    private final TunnelApiService tunnelApiService = new TunnelApiService();

    public ServersFragment() {
        ActivityResultLauncher<String> registerForActivityResult = registerForActivityResult(new ActivityResultContracts.RequestPermission(), new ServersFragment$$ExternalSyntheticLambda0(this));
        Intrinsics.checkNotNullExpressionValue(registerForActivityResult, "registerForActivityResult(...)");
        this.notificationPermissionLauncher = registerForActivityResult;
        ActivityResultLauncher<Intent> registerForActivityResult2 = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ServersFragment$$ExternalSyntheticLambda11(this));
        Intrinsics.checkNotNullExpressionValue(registerForActivityResult2, "registerForActivityResult(...)");
        this.batteryOptimizationLauncher = registerForActivityResult2;
        this.serviceConnection = new ServersFragment$serviceConnection$1(this);
        this.crashReceiver = new ServersFragment$crashReceiver$1();
        this.serverStoppedReceiver = new ServersFragment$serverStoppedReceiver$1(this);
    }

    private final FragmentServersBinding getBinding() {
        FragmentServersBinding fragmentServersBinding = this._binding;
        Intrinsics.checkNotNull(fragmentServersBinding);
        return fragmentServersBinding;
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bXT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nXT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nXT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\nXT¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/armmc/app/ui/servers/ServersFragment$Companion;", "", "<init>", "()V", "TAG", "", "FRP_LOCAL_IP", "MAX_RETRY_ATTEMPTS", "", "RETRY_DELAY_MS", "", "MIN_RETRY_INTERVAL_MS", "STABLE_CONNECTION_THRESHOLD_MS", "app_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* compiled from: ServersFragment.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0006¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0006HÆ\u0003JO\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010!\u001a\u00020\u0003HÖ\u0001J\t\u0010\"\u001a\u00020\u0006HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000eR\u0011\u0010\b\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000eR\u0011\u0010\n\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0011¨\u0006#"}, d2 = {"Lcom/armmc/app/ui/servers/ServersFragment$FrpConnectionParams;", "", "serverId", "", "localPort", "serverAddr", "", "serverPort", "authToken", "remotePort", "tunnelAddress", "<init>", "(IILjava/lang/String;ILjava/lang/String;ILjava/lang/String;)V", "getServerId", "()I", "getLocalPort", "getServerAddr", "()Ljava/lang/String;", "getServerPort", "getAuthToken", "getRemotePort", "getTunnelAddress", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "toString", "app_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* compiled from: ServersFragment.kt */
    private static final class FrpConnectionParams {
        private final String authToken;
        private final int localPort;
        private final int remotePort;
        private final String serverAddr;
        private final int serverId;
        private final int serverPort;
        private final String tunnelAddress;

        public static /* synthetic */ FrpConnectionParams copy$default(FrpConnectionParams frpConnectionParams, int i, int i2, String str, int i3, String str2, int i4, String str3, int i5, Object obj) {
            if ((i5 & 1) != 0) {
                i = frpConnectionParams.serverId;
            }
            if ((i5 & 2) != 0) {
                i2 = frpConnectionParams.localPort;
            }
            if ((i5 & 4) != 0) {
                str = frpConnectionParams.serverAddr;
            }
            if ((i5 & 8) != 0) {
                i3 = frpConnectionParams.serverPort;
            }
            if ((i5 & 16) != 0) {
                str2 = frpConnectionParams.authToken;
            }
            if ((i5 & 32) != 0) {
                i4 = frpConnectionParams.remotePort;
            }
            if ((i5 & 64) != 0) {
                str3 = frpConnectionParams.tunnelAddress;
            }
            int i6 = i4;
            String str4 = str3;
            int i7 = i3;
            String str5 = str2;
            return frpConnectionParams.copy(i, i2, str, i7, str5, i6, str4);
        }

        public final int component1() {
            return this.serverId;
        }

        public final int component2() {
            return this.localPort;
        }

        public final String component3() {
            return this.serverAddr;
        }

        public final int component4() {
            return this.serverPort;
        }

        public final String component5() {
            return this.authToken;
        }

        public final int component6() {
            return this.remotePort;
        }

        public final String component7() {
            return this.tunnelAddress;
        }

        public final FrpConnectionParams copy(int i, int i2, String str, int i3, String str2, int i4, String str3) {
            Intrinsics.checkNotNullParameter(str, "serverAddr");
            Intrinsics.checkNotNullParameter(str2, "authToken");
            String str4 = str3;
            Intrinsics.checkNotNullParameter(str4, "tunnelAddress");
            return new FrpConnectionParams(i, i2, str, i3, str2, i4, str4);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof FrpConnectionParams)) {
                return false;
            }
            FrpConnectionParams frpConnectionParams = (FrpConnectionParams) obj;
            return this.serverId == frpConnectionParams.serverId && this.localPort == frpConnectionParams.localPort && Intrinsics.areEqual((Object) this.serverAddr, (Object) frpConnectionParams.serverAddr) && this.serverPort == frpConnectionParams.serverPort && Intrinsics.areEqual((Object) this.authToken, (Object) frpConnectionParams.authToken) && this.remotePort == frpConnectionParams.remotePort && Intrinsics.areEqual((Object) this.tunnelAddress, (Object) frpConnectionParams.tunnelAddress);
        }

        public int hashCode() {
            return (((((((((((Integer.hashCode(this.serverId) * 31) + Integer.hashCode(this.localPort)) * 31) + this.serverAddr.hashCode()) * 31) + Integer.hashCode(this.serverPort)) * 31) + this.authToken.hashCode()) * 31) + Integer.hashCode(this.remotePort)) * 31) + this.tunnelAddress.hashCode();
        }

        public String toString() {
            int i = this.serverId;
            int i2 = this.localPort;
            String str = this.serverAddr;
            int i3 = this.serverPort;
            String str2 = this.authToken;
            int i4 = this.remotePort;
            return "FrpConnectionParams(serverId=" + i + ", localPort=" + i2 + ", serverAddr=" + str + ", serverPort=" + i3 + ", authToken=" + str2 + ", remotePort=" + i4 + ", tunnelAddress=" + this.tunnelAddress + ")";
        }

        public FrpConnectionParams(int i, int i2, String str, int i3, String str2, int i4, String str3) {
            Intrinsics.checkNotNullParameter(str, "serverAddr");
            Intrinsics.checkNotNullParameter(str2, "authToken");
            Intrinsics.checkNotNullParameter(str3, "tunnelAddress");
            this.serverId = i;
            this.localPort = i2;
            this.serverAddr = str;
            this.serverPort = i3;
            this.authToken = str2;
            this.remotePort = i4;
            this.tunnelAddress = str3;
        }

        public final int getServerId() {
            return this.serverId;
        }

        public final int getLocalPort() {
            return this.localPort;
        }

        public final String getServerAddr() {
            return this.serverAddr;
        }

        public final int getServerPort() {
            return this.serverPort;
        }

        public final String getAuthToken() {
            return this.authToken;
        }

        public final int getRemotePort() {
            return this.remotePort;
        }

        public final String getTunnelAddress() {
            return this.tunnelAddress;
        }
    }

    /* access modifiers changed from: private */
    public final boolean runOnUiThreadSafe(Function0<Unit> function0) {
        FragmentActivity activity = getActivity();
        if (activity == null || !isAdded()) {
            return false;
        }
        activity.runOnUiThread(new ServersFragment$$ExternalSyntheticLambda38(this, function0));
        return true;
    }

    /* access modifiers changed from: private */
    public static final void runOnUiThreadSafe$lambda$0(ServersFragment serversFragment, Function0 function0) {
        if (serversFragment.isAdded()) {
            try {
                function0.invoke();
            } catch (IllegalStateException e) {
                Log.w(TAG, "UI update skipped - fragment no longer attached", e);
            }
        }
    }

    /* access modifiers changed from: private */
    public static final void notificationPermissionLauncher$lambda$1(ServersFragment serversFragment, Boolean bool) {
        Intrinsics.checkNotNullParameter(bool, "<unused var>");
        serversFragment.advanceSetupToBatteryStep();
    }

    /* access modifiers changed from: private */
    public static final void batteryOptimizationLauncher$lambda$2(ServersFragment serversFragment, ActivityResult activityResult) {
        Intrinsics.checkNotNullParameter(activityResult, "<unused var>");
        serversFragment.finishPermissionSetup();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.fragment_servers, viewGroup, false);
    }

    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
        this.serverRepository = new ServerRepository(requireContext);
        Context requireContext2 = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext2, "requireContext(...)");
        this.libraryManager = new LibraryManager(requireContext2);
        Context requireContext3 = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext3, "requireContext(...)");
        this.splitInstallHelper = new SplitInstallHelper(requireContext3);
        Context requireContext4 = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext4, "requireContext(...)");
        this.reviewHelper = new ReviewHelper(requireContext4);
        this.auth = FirebaseAuth.getInstance();
        this.serversRecyclerView = (RecyclerView) view.findViewById(R.id.serversRecyclerView);
        this.createInstanceButton = (MaterialButton) view.findViewById(R.id.createInstanceButton);
        setupRecyclerView();
        MaterialButton materialButton = this.createInstanceButton;
        if (materialButton == null) {
            Intrinsics.throwUninitializedPropertyAccessException("createInstanceButton");
            materialButton = null;
        }
        materialButton.setOnClickListener(new ServersFragment$$ExternalSyntheticLambda8(this));
        IntentFilter intentFilter = new IntentFilter(PumpkinService.ACTION_SERVER_CRASHED);
        if (Build.VERSION.SDK_INT >= 33) {
            requireContext().registerReceiver(this.crashReceiver, intentFilter, 4);
        } else {
            requireContext().registerReceiver(this.crashReceiver, intentFilter);
        }
        IntentFilter intentFilter2 = new IntentFilter(PumpkinService.ACTION_SERVER_STOPPED);
        if (Build.VERSION.SDK_INT >= 33) {
            requireContext().registerReceiver(this.serverStoppedReceiver, intentFilter2, 4);
        } else {
            requireContext().registerReceiver(this.serverStoppedReceiver, intentFilter2);
        }
        ResourceMonitor.INSTANCE.getResourceData().observe(getViewLifecycleOwner(), new ServersFragment$sam$androidx_lifecycle_Observer$0(new ServersFragment$$ExternalSyntheticLambda9(this)));
    }

    /* access modifiers changed from: private */
    public static final void onViewCreated$lambda$3(ServersFragment serversFragment, View view) {
        NavController findNavController = FragmentKt.findNavController(serversFragment);
        NavDestination currentDestination = findNavController.getCurrentDestination();
        if (currentDestination != null && currentDestination.getId() == R.id.nav_servers) {
            findNavController.navigate(R.id.action_servers_to_create_server);
        }
    }

    /* access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$5(ServersFragment serversFragment, ResourceMonitor.ResourceData resourceData) {
        ServerAdapter serverAdapter2;
        ServerAdapter serverAdapter3 = serversFragment.serverAdapter;
        if (serverAdapter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("serverAdapter");
            serverAdapter3 = null;
        }
        List currentList = serverAdapter3.getCurrentList();
        Intrinsics.checkNotNullExpressionValue(currentList, "getCurrentList(...)");
        Iterator it = currentList.iterator();
        int i = 0;
        while (true) {
            if (!it.hasNext()) {
                i = -1;
                break;
            } else if (((ServerListItem) it.next()).getServerData().getId() == resourceData.getServerId()) {
                break;
            } else {
                i++;
            }
        }
        int i2 = i;
        if (i2 >= 0) {
            ServerAdapter serverAdapter4 = serversFragment.serverAdapter;
            if (serverAdapter4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("serverAdapter");
                serverAdapter2 = null;
            } else {
                serverAdapter2 = serverAdapter4;
            }
            serverAdapter2.updateServerResources(i2, resourceData.getRamUsedMb(), resourceData.getRamTotalMb(), resourceData.getCpuUsagePercent(), resourceData.getRamHistory());
        }
        return Unit.INSTANCE;
    }

    public void onResume() {
        super.onResume();
        syncLocalStateWithRepository();
        if (this.currentlyRunningServerId != null && !this.isBoundToService && isServerProcessRunning()) {
            try {
                requireContext().bindService(new Intent(requireContext(), PumpkinService.class), this.serviceConnection, 1);
            } catch (Exception e) {
                Log.e(TAG, "Failed to rebind to PumpkinService", e);
            }
        }
        loadServers();
        ResourceMonitor resourceMonitor = ResourceMonitor.INSTANCE;
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
        resourceMonitor.resumeMonitoring(requireContext);
    }

    private final void syncLocalStateWithRepository() {
        Object obj;
        ServerRepository serverRepository2 = this.serverRepository;
        if (serverRepository2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("serverRepository");
            serverRepository2 = null;
        }
        Iterator it = serverRepository2.getAllServers().iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (((ServerData) obj).isOnline()) {
                break;
            }
        }
        ServerData serverData = (ServerData) obj;
        if (serverData != null) {
            Integer num = this.currentlyRunningServerId;
            int id = serverData.getId();
            if (num == null || num.intValue() != id) {
                if (!isServerProcessRunning()) {
                    Log.d(TAG, "Server " + serverData.getId() + " marked as online but process not running, cleaning up");
                    ServerRepository serverRepository3 = this.serverRepository;
                    if (serverRepository3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("serverRepository");
                        serverRepository3 = null;
                    }
                    serverRepository3.updateServerStatus(serverData.getId(), false);
                    ServerRepository serverRepository4 = this.serverRepository;
                    if (serverRepository4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("serverRepository");
                        serverRepository4 = null;
                    }
                    serverRepository4.resetTunnelState(serverData.getId());
                    this.currentlyRunningServerId = null;
                    return;
                }
                this.currentlyRunningServerId = Integer.valueOf(serverData.getId());
                return;
            }
            return;
        }
        this.currentlyRunningServerId = null;
    }

    private final boolean isServerProcessRunning() {
        try {
            Object systemService = requireContext().getSystemService("activity");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.ActivityManager");
            List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) systemService).getRunningAppProcesses();
            if (runningAppProcesses == null) {
                return false;
            }
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                String str = runningAppProcessInfo.processName;
                Intrinsics.checkNotNullExpressionValue(str, "processName");
                if (StringsKt.endsWith$default(str, ":pumpkin_server", false, 2, (Object) null)) {
                    return true;
                }
            }
            return false;
        } catch (Exception e) {
            Log.w(TAG, "Error checking if server process is running", e);
        }
    }

    public void onPause() {
        super.onPause();
        ResourceMonitor.INSTANCE.pauseMonitoring();
    }

    public void onDestroyView() {
        if (this.isBoundToService) {
            try {
                requireContext().unbindService(this.serviceConnection);
            } catch (Exception e) {
                Log.w(TAG, "Error unbinding from PumpkinService", e);
            }
            this.isBoundToService = false;
        }
        try {
            requireContext().unregisterReceiver(this.crashReceiver);
        } catch (Exception e2) {
            Log.w(TAG, "Error unregistering crash receiver", e2);
        }
        try {
            requireContext().unregisterReceiver(this.serverStoppedReceiver);
        } catch (Exception e3) {
            Log.w(TAG, "Error unregistering server stopped receiver", e3);
        }
        super.onDestroyView();
    }

    /* access modifiers changed from: private */
    public final void loadServers() {
        long j;
        int i;
        ServerRepository serverRepository2 = this.serverRepository;
        ServerAdapter serverAdapter2 = null;
        if (serverRepository2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("serverRepository");
            serverRepository2 = null;
        }
        List<ServerData> allServers = serverRepository2.getAllServers();
        MaterialButton materialButton = this.createInstanceButton;
        if (materialButton == null) {
            Intrinsics.throwUninitializedPropertyAccessException("createInstanceButton");
            materialButton = null;
        }
        materialButton.setVisibility(allServers.isEmpty() ? 0 : 8);
        ResourceMonitor.ResourceData value = ResourceMonitor.INSTANCE.getResourceData().getValue();
        Iterable<ServerData> iterable = allServers;
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
        for (ServerData serverData : iterable) {
            String extractVersionFromLibraryKey = extractVersionFromLibraryKey(serverData.getLibraryKey());
            if (extractVersionFromLibraryKey == null) {
                extractVersionFromLibraryKey = serverData.getSoftware();
            }
            boolean z = value != null && value.getServerId() == serverData.getId() && serverData.isOnline();
            String name = serverData.getName();
            String str = extractVersionFromLibraryKey + " • " + serverData.getMaxPlayers() + " players";
            boolean isOnline = serverData.isOnline();
            int iconResId = serverData.getIconResId();
            TunnelStatus tunnelStatus = serverData.getTunnelStatus();
            if (tunnelStatus == null) {
                tunnelStatus = TunnelStatus.DISCONNECTED;
            }
            TunnelStatus tunnelStatus2 = tunnelStatus;
            String tunnelAddress = serverData.getTunnelAddress();
            Integer reconnectAttempts = serverData.getReconnectAttempts();
            int intValue = reconnectAttempts != null ? reconnectAttempts.intValue() : 0;
            long j2 = 0;
            if (z) {
                Intrinsics.checkNotNull(value);
                j = value.getRamUsedMb();
            } else {
                j = 0;
            }
            if (z) {
                Intrinsics.checkNotNull(value);
                j2 = value.getRamTotalMb();
            }
            long j3 = j2;
            if (z) {
                Intrinsics.checkNotNull(value);
                i = value.getCpuUsagePercent();
            } else {
                i = 0;
            }
            arrayList.add(new Server(name, str, isOnline, iconResId, tunnelStatus2, tunnelAddress, intValue, j, j3, i, 0, 0, 3072, (DefaultConstructorMarker) null));
        }
        List list = (List) arrayList;
        RecyclerView recyclerView = this.serversRecyclerView;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("serversRecyclerView");
            recyclerView = null;
        }
        if (recyclerView.getAdapter() == null) {
            this.serverAdapter = new ServerAdapter(new ServersFragment$$ExternalSyntheticLambda5(this), new ServersFragment$$ExternalSyntheticLambda6(this), new ServersFragment$$ExternalSyntheticLambda7(this));
            RecyclerView recyclerView2 = this.serversRecyclerView;
            if (recyclerView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("serversRecyclerView");
                recyclerView2 = null;
            }
            ServerAdapter serverAdapter3 = this.serverAdapter;
            if (serverAdapter3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("serverAdapter");
                serverAdapter3 = null;
            }
            recyclerView2.setAdapter(serverAdapter3);
        }
        Iterable<Pair> zip = CollectionsKt.zip(list, iterable);
        Collection arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(zip, 10));
        for (Pair pair : zip) {
            arrayList2.add(new ServerListItem((Server) pair.component1(), (ServerData) pair.component2()));
        }
        List list2 = (List) arrayList2;
        ServerAdapter serverAdapter4 = this.serverAdapter;
        if (serverAdapter4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("serverAdapter");
        } else {
            serverAdapter2 = serverAdapter4;
        }
        serverAdapter2.submitList(list2);
    }

    /* access modifiers changed from: private */
    public static final Unit loadServers$lambda$8(ServersFragment serversFragment, ServerData serverData) {
        Intrinsics.checkNotNullParameter(serverData, "serverData");
        serversFragment.toggleServerStatus(serverData);
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit loadServers$lambda$10(ServersFragment serversFragment, ServerData serverData) {
        Intrinsics.checkNotNullParameter(serverData, "serverData");
        NavController findNavController = FragmentKt.findNavController(serversFragment);
        NavDestination currentDestination = findNavController.getCurrentDestination();
        if (currentDestination != null && currentDestination.getId() == R.id.nav_servers) {
            Bundle bundle = new Bundle();
            bundle.putInt(PumpkinService.EXTRA_SERVER_ID, serverData.getId());
            findNavController.navigate(R.id.action_servers_to_create_server, bundle);
        }
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit loadServers$lambda$11(ServersFragment serversFragment, ServerData serverData) {
        Intrinsics.checkNotNullParameter(serverData, "serverData");
        serversFragment.deleteServer(serverData);
        return Unit.INSTANCE;
    }

    private final void toggleServerStatus(ServerData serverData) {
        ServerRepository serverRepository2 = null;
        if (!serverData.isOnline()) {
            Integer num = this.currentlyRunningServerId;
            if (num != null) {
                int id = serverData.getId();
                if (num == null || num.intValue() != id) {
                    Toast.makeText(getContext(), "Another server is running. Stop it first.", 0).show();
                    return;
                }
            }
            if (this.stoppingServers.contains(Integer.valueOf(serverData.getId()))) {
                Toast.makeText(getContext(), serverData.getName() + " is still stopping, please wait", 0).show();
                return;
            }
            ServerRepository serverRepository3 = this.serverRepository;
            if (serverRepository3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("serverRepository");
                serverRepository3 = null;
            }
            if (!serverRepository3.hasAcceptedAlphaWarning()) {
                showAlphaWarningDialog(serverData);
                return;
            }
            ServerRepository serverRepository4 = this.serverRepository;
            if (serverRepository4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("serverRepository");
            } else {
                serverRepository2 = serverRepository4;
            }
            serverRepository2.updateServerStatus(serverData.getId(), true);
            startServer(serverData);
        } else {
            ServerRepository serverRepository5 = this.serverRepository;
            if (serverRepository5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("serverRepository");
            } else {
                serverRepository2 = serverRepository5;
            }
            serverRepository2.updateServerStatus(serverData.getId(), false);
            stopServer(serverData);
        }
        loadServers();
    }

    private final void showAlphaWarningDialog(ServerData serverData) {
        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(requireContext(), R.style.Theme_WitherHost_BottomSheet);
        View inflate = getLayoutInflater().inflate(R.layout.dialog_alpha_warning, (ViewGroup) null);
        bottomSheetDialog.setContentView(inflate);
        CheckBox checkBox = (CheckBox) inflate.findViewById(R.id.understandCheckbox);
        MaterialButton materialButton = (MaterialButton) inflate.findViewById(R.id.understandButton);
        ((TextView) inflate.findViewById(R.id.buildVersionText)).setText("BUILD: 1.3.0-ALPHA");
        checkBox.setOnCheckedChangeListener(new ServersFragment$$ExternalSyntheticLambda31(materialButton));
        materialButton.setAlpha(0.5f);
        materialButton.setOnClickListener(new ServersFragment$$ExternalSyntheticLambda32(checkBox, this, bottomSheetDialog, serverData));
        bottomSheetDialog.setOnShowListener(new ServersFragment$$ExternalSyntheticLambda34(bottomSheetDialog));
        bottomSheetDialog.show();
    }

    /* access modifiers changed from: private */
    public static final void showAlphaWarningDialog$lambda$13(MaterialButton materialButton, CompoundButton compoundButton, boolean z) {
        Intrinsics.checkNotNullParameter(compoundButton, "<unused var>");
        materialButton.setEnabled(z);
        materialButton.setAlpha(z ? 1.0f : 0.5f);
    }

    /* access modifiers changed from: private */
    public static final void showAlphaWarningDialog$lambda$14(CheckBox checkBox, ServersFragment serversFragment, BottomSheetDialog bottomSheetDialog, ServerData serverData, View view) {
        if (checkBox.isChecked()) {
            ServerRepository serverRepository2 = serversFragment.serverRepository;
            ServerRepository serverRepository3 = null;
            if (serverRepository2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("serverRepository");
                serverRepository2 = null;
            }
            serverRepository2.setAlphaWarningAccepted(true);
            bottomSheetDialog.dismiss();
            ServerRepository serverRepository4 = serversFragment.serverRepository;
            if (serverRepository4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("serverRepository");
            } else {
                serverRepository3 = serverRepository4;
            }
            serverRepository3.updateServerStatus(serverData.getId(), true);
            serversFragment.startServer(serverData);
            serversFragment.loadServers();
        }
    }

    /* access modifiers changed from: private */
    public static final void showAlphaWarningDialog$lambda$16(BottomSheetDialog bottomSheetDialog, DialogInterface dialogInterface) {
        View findViewById = bottomSheetDialog.findViewById(com.google.android.material.R.id.design_bottom_sheet);
        if (findViewById != null) {
            BottomSheetBehavior from = BottomSheetBehavior.from(findViewById);
            Intrinsics.checkNotNullExpressionValue(from, "from(...)");
            from.setState(3);
            from.setSkipCollapsed(true);
        }
    }

    private final void showServerBusyDialog() {
        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(requireContext(), R.style.Theme_WitherHost_BottomSheet);
        View inflate = getLayoutInflater().inflate(R.layout.dialog_server_busy, (ViewGroup) null);
        bottomSheetDialog.setContentView(inflate);
        ((MaterialButton) inflate.findViewById(R.id.upgradeButton)).setOnClickListener(new ServersFragment$$ExternalSyntheticLambda18(bottomSheetDialog, this));
        ((MaterialButton) inflate.findViewById(R.id.dismissButton)).setOnClickListener(new ServersFragment$$ExternalSyntheticLambda19(bottomSheetDialog));
        bottomSheetDialog.setOnShowListener(new ServersFragment$$ExternalSyntheticLambda20(bottomSheetDialog));
        bottomSheetDialog.show();
    }

    /* access modifiers changed from: private */
    public static final void showServerBusyDialog$lambda$17(BottomSheetDialog bottomSheetDialog, ServersFragment serversFragment, View view) {
        bottomSheetDialog.dismiss();
        NavController findNavController = FragmentKt.findNavController(serversFragment);
        NavDestination currentDestination = findNavController.getCurrentDestination();
        if (currentDestination != null && currentDestination.getId() == R.id.nav_servers) {
            findNavController.navigate(R.id.action_servers_to_subscription);
        }
    }

    /* access modifiers changed from: private */
    public static final void showServerBusyDialog$lambda$18(BottomSheetDialog bottomSheetDialog, View view) {
        bottomSheetDialog.dismiss();
    }

    /* access modifiers changed from: private */
    public static final void showServerBusyDialog$lambda$20(BottomSheetDialog bottomSheetDialog, DialogInterface dialogInterface) {
        View findViewById = bottomSheetDialog.findViewById(com.google.android.material.R.id.design_bottom_sheet);
        if (findViewById != null) {
            BottomSheetBehavior from = BottomSheetBehavior.from(findViewById);
            Intrinsics.checkNotNullExpressionValue(from, "from(...)");
            from.setState(3);
            from.setSkipCollapsed(true);
        }
    }

    private final boolean isIgnoringBatteryOptimizations() {
        Object systemService = requireContext().getSystemService("power");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.os.PowerManager");
        return ((PowerManager) systemService).isIgnoringBatteryOptimizations(requireContext().getPackageName());
    }

    static /* synthetic */ void showSetupPermissionsDialog$default(ServersFragment serversFragment, boolean z, boolean z2, boolean z3, int i, Object obj) {
        if ((i & 4) != 0) {
            z3 = false;
        }
        serversFragment.showSetupPermissionsDialog(z, z2, z3);
    }

    private final void showSetupPermissionsDialog(boolean z, boolean z2, boolean z3) {
        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(requireContext(), R.style.Theme_WitherHost_BottomSheet);
        View inflate = getLayoutInflater().inflate(R.layout.dialog_setup_permissions, (ViewGroup) null);
        bottomSheetDialog.setContentView(inflate);
        bottomSheetDialog.setCancelable(false);
        ViewFlipper viewFlipper = (ViewFlipper) inflate.findViewById(R.id.setupFlipper);
        MaterialButton materialButton = (MaterialButton) inflate.findViewById(R.id.setupContinueButton);
        MaterialButton materialButton2 = (MaterialButton) inflate.findViewById(R.id.setupNotificationButton);
        MaterialButton materialButton3 = (MaterialButton) inflate.findViewById(R.id.setupBatteryButton);
        this.setupDialog = bottomSheetDialog;
        this.setupFlipper = viewFlipper;
        if (z3) {
            viewFlipper.setDisplayedChild(2);
        }
        materialButton.setOnClickListener(new ServersFragment$$ExternalSyntheticLambda26(z, viewFlipper, z2, this));
        materialButton2.setOnClickListener(new ServersFragment$$ExternalSyntheticLambda27(this));
        materialButton3.setOnClickListener(new ServersFragment$$ExternalSyntheticLambda28(this));
        bottomSheetDialog.setOnShowListener(new ServersFragment$$ExternalSyntheticLambda29(bottomSheetDialog));
        bottomSheetDialog.show();
    }

    /* access modifiers changed from: private */
    public static final void showSetupPermissionsDialog$lambda$21(boolean z, ViewFlipper viewFlipper, boolean z2, ServersFragment serversFragment, View view) {
        if (z) {
            viewFlipper.setDisplayedChild(1);
        } else if (z2) {
            viewFlipper.setDisplayedChild(2);
        } else {
            serversFragment.finishPermissionSetup();
        }
    }

    /* access modifiers changed from: private */
    public static final void showSetupPermissionsDialog$lambda$22(ServersFragment serversFragment, View view) {
        if (Build.VERSION.SDK_INT >= 33) {
            serversFragment.notificationPermissionLauncher.launch("android.permission.POST_NOTIFICATIONS");
        } else {
            serversFragment.advanceSetupToBatteryStep();
        }
    }

    /* access modifiers changed from: private */
    public static final void showSetupPermissionsDialog$lambda$23(ServersFragment serversFragment, View view) {
        serversFragment.requestIgnoreBatteryOptimizations();
    }

    /* access modifiers changed from: private */
    public static final void showSetupPermissionsDialog$lambda$25(BottomSheetDialog bottomSheetDialog, DialogInterface dialogInterface) {
        View findViewById = bottomSheetDialog.findViewById(com.google.android.material.R.id.design_bottom_sheet);
        if (findViewById != null) {
            BottomSheetBehavior from = BottomSheetBehavior.from(findViewById);
            Intrinsics.checkNotNullExpressionValue(from, "from(...)");
            from.setState(3);
            from.setSkipCollapsed(true);
            from.setDraggable(false);
        }
    }

    private final void advanceSetupToBatteryStep() {
        ViewFlipper viewFlipper = this.setupFlipper;
        if (viewFlipper != null) {
            if (!isIgnoringBatteryOptimizations()) {
                viewFlipper.setDisplayedChild(2);
            } else {
                finishPermissionSetup();
            }
        }
    }

    private final void requestIgnoreBatteryOptimizations() {
        Intent intent = new Intent("android.settings.REQUEST_IGNORE_BATTERY_OPTIMIZATIONS");
        intent.setData(Uri.parse("package:" + requireContext().getPackageName()));
        this.batteryOptimizationLauncher.launch(intent);
    }

    private final void finishPermissionSetup() {
        ServerRepository serverRepository2 = this.serverRepository;
        ServerRepository serverRepository3 = null;
        if (serverRepository2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("serverRepository");
            serverRepository2 = null;
        }
        serverRepository2.setPermissionSetupCompleted(true);
        BottomSheetDialog bottomSheetDialog = this.setupDialog;
        if (bottomSheetDialog != null) {
            bottomSheetDialog.dismiss();
        }
        this.setupDialog = null;
        this.setupFlipper = null;
        ServerData serverData = this.pendingServerStart;
        if (serverData != null) {
            this.pendingServerStart = null;
            ServerRepository serverRepository4 = this.serverRepository;
            if (serverRepository4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("serverRepository");
            } else {
                serverRepository3 = serverRepository4;
            }
            serverRepository3.updateServerStatus(serverData.getId(), true);
            loadServers();
            Toast.makeText(getContext(), "Starting " + serverData.getName(), 0).show();
            proceedWithStartServer(serverData);
        }
    }

    private final void startServer(ServerData serverData) {
        String libraryKey = serverData.getLibraryKey();
        CharSequence charSequence = libraryKey;
        if (charSequence == null || charSequence.length() == 0) {
            Toast.makeText(getContext(), "Server version not configured. Please edit and save the server.", 1).show();
            return;
        }
        SplitInstallHelper splitInstallHelper2 = this.splitInstallHelper;
        ServerRepository serverRepository2 = null;
        if (splitInstallHelper2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("splitInstallHelper");
            splitInstallHelper2 = null;
        }
        if (!splitInstallHelper2.isModuleInstalled(libraryKey)) {
            Toast.makeText(getContext(), "Server module not installed. Please edit and save the server to install it.", 1).show();
            return;
        }
        boolean z = Build.VERSION.SDK_INT >= 33 && ContextCompat.checkSelfPermission(requireContext(), "android.permission.POST_NOTIFICATIONS") != 0;
        boolean isIgnoringBatteryOptimizations = isIgnoringBatteryOptimizations();
        boolean z2 = !isIgnoringBatteryOptimizations;
        ServerRepository serverRepository3 = this.serverRepository;
        if (serverRepository3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("serverRepository");
            serverRepository3 = null;
        }
        if (serverRepository3.hasCompletedPermissionSetup() || (!z && isIgnoringBatteryOptimizations)) {
            if (!isIgnoringBatteryOptimizations) {
                ServerRepository serverRepository4 = this.serverRepository;
                if (serverRepository4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("serverRepository");
                } else {
                    serverRepository2 = serverRepository4;
                }
                serverRepository2.updateServerStatus(serverData.getId(), false);
                loadServers();
                this.pendingServerStart = serverData;
                showSetupPermissionsDialog(false, true, true);
                return;
            }
            proceedWithStartServer(serverData);
            return;
        }
        ServerRepository serverRepository5 = this.serverRepository;
        if (serverRepository5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("serverRepository");
        } else {
            serverRepository2 = serverRepository5;
        }
        serverRepository2.updateServerStatus(serverData.getId(), false);
        loadServers();
        this.pendingServerStart = serverData;
        showSetupPermissionsDialog$default(this, z, z2, false, 4, (Object) null);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x007a, code lost:
        r3 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:?, code lost:
        kotlin.io.CloseableKt.closeFinally(r7, r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x007e, code lost:
        throw r3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void proceedWithStartServer(com.armmc.app.ui.servers.ServerData r10) {
        /*
            r9 = this;
            java.lang.String r0 = r10.getLibraryKey()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            android.content.Context r1 = r9.requireContext()
            java.io.File r1 = r1.getFilesDir()
            java.lang.String r1 = r1.getAbsolutePath()
            int r2 = r10.getId()
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.StringBuilder r1 = r3.append(r1)
            java.lang.String r3 = "/server_"
            java.lang.StringBuilder r1 = r1.append(r3)
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.String r1 = r1.toString()
            java.io.File r2 = new java.io.File
            r2.<init>(r1)
            boolean r3 = r2.exists()
            if (r3 != 0) goto L_0x003c
            r2.mkdirs()
        L_0x003c:
            java.io.File r3 = new java.io.File
            java.lang.String r4 = "icon.png"
            r3.<init>(r2, r4)
            boolean r2 = r3.exists()
            r4 = 0
            java.lang.String r5 = "ServersFragment"
            r6 = 0
            if (r2 != 0) goto L_0x0087
            android.content.res.Resources r2 = r9.getResources()     // Catch:{ Exception -> 0x007f }
            int r7 = com.armmc.app.R.drawable.favicon     // Catch:{ Exception -> 0x007f }
            java.io.InputStream r2 = r2.openRawResource(r7)     // Catch:{ Exception -> 0x007f }
            java.lang.String r7 = "openRawResource(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r7)     // Catch:{ Exception -> 0x007f }
            java.io.FileOutputStream r7 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x007f }
            r7.<init>(r3)     // Catch:{ Exception -> 0x007f }
            java.io.Closeable r7 = (java.io.Closeable) r7     // Catch:{ Exception -> 0x007f }
            r3 = r7
            java.io.FileOutputStream r3 = (java.io.FileOutputStream) r3     // Catch:{ all -> 0x0078 }
            java.io.OutputStream r3 = (java.io.OutputStream) r3     // Catch:{ all -> 0x0078 }
            r8 = 2
            kotlin.io.ByteStreamsKt.copyTo$default(r2, r3, r6, r8, r4)     // Catch:{ all -> 0x0078 }
            kotlin.io.CloseableKt.closeFinally(r7, r4)     // Catch:{ Exception -> 0x007f }
            r2.close()     // Catch:{ Exception -> 0x007f }
            java.lang.String r2 = "Copied favicon.png to server directory"
            android.util.Log.d(r5, r2)     // Catch:{ Exception -> 0x007f }
            goto L_0x0087
        L_0x0078:
            r2 = move-exception
            throw r2     // Catch:{ all -> 0x007a }
        L_0x007a:
            r3 = move-exception
            kotlin.io.CloseableKt.closeFinally(r7, r2)     // Catch:{ Exception -> 0x007f }
            throw r3     // Catch:{ Exception -> 0x007f }
        L_0x007f:
            r2 = move-exception
            java.lang.String r3 = "Failed to copy favicon.png"
            java.lang.Throwable r2 = (java.lang.Throwable) r2
            android.util.Log.e(r5, r3, r2)
        L_0x0087:
            int r2 = r10.getId()
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r9.currentlyRunningServerId = r2
            r9.stoppedViaNotification = r6
            com.armmc.app.ui.servers.ResourceMonitor r2 = com.armmc.app.ui.servers.ResourceMonitor.INSTANCE
            android.content.Context r3 = r9.requireContext()
            java.lang.String r7 = "requireContext(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r7)
            int r7 = r10.getId()
            r2.startMonitoring(r3, r7)
            java.lang.String r2 = r10.getPort()
            java.lang.Integer r2 = kotlin.text.StringsKt.toIntOrNull(r2)
            if (r2 == 0) goto L_0x00b4
            int r2 = r2.intValue()
            goto L_0x00b6
        L_0x00b4:
            r2 = 25565(0x63dd, float:3.5824E-41)
        L_0x00b6:
            android.content.Intent r3 = new android.content.Intent
            android.content.Context r7 = r9.requireContext()
            java.lang.Class<com.armmc.app.PumpkinService> r8 = com.armmc.app.PumpkinService.class
            r3.<init>(r7, r8)
            java.lang.String r7 = "moduleName"
            r3.putExtra(r7, r0)
            java.lang.String r0 = "serverId"
            int r7 = r10.getId()
            r3.putExtra(r0, r7)
            java.lang.String r0 = "serverPath"
            r3.putExtra(r0, r1)
            java.lang.String r0 = "ip"
            java.lang.String r1 = "0.0.0.0"
            r3.putExtra(r0, r1)
            java.lang.String r0 = "port"
            r3.putExtra(r0, r2)
            java.lang.String r0 = "viewDistance"
            int r1 = r10.getViewDistance()
            r3.putExtra(r0, r1)
            java.lang.String r0 = "simulationDistance"
            int r1 = r10.getSimulationDistance()
            r3.putExtra(r0, r1)
            java.lang.String r0 = "maxPlayers"
            int r1 = r10.getMaxPlayers()
            r3.putExtra(r0, r1)
            java.lang.String r0 = "seed"
            java.lang.String r1 = r10.getSeed()
            r3.putExtra(r0, r1)
            java.lang.String r0 = "motd"
            java.lang.String r1 = r10.getMotd()
            r3.putExtra(r0, r1)
            java.lang.String r0 = "defaultDifficulty"
            java.lang.String r1 = r10.getDifficulty()
            r3.putExtra(r0, r1)
            java.lang.String r0 = "defaultGamemode"
            java.lang.String r1 = r10.getGamemode()
            r3.putExtra(r0, r1)
            java.lang.String r0 = "onlineMode"
            boolean r1 = r10.getOnlineMode()
            r3.putExtra(r0, r1)
            java.lang.String r0 = "hardcore"
            boolean r1 = r10.getHardcore()
            r3.putExtra(r0, r1)
            java.lang.Boolean r0 = r10.getWhitelistEnabled()
            if (r0 == 0) goto L_0x013c
            boolean r0 = r0.booleanValue()
            goto L_0x013d
        L_0x013c:
            r0 = r6
        L_0x013d:
            java.lang.String r1 = "whiteList"
            r3.putExtra(r1, r0)
            java.lang.Boolean r0 = r10.getWhitelistEnabled()
            if (r0 == 0) goto L_0x014d
            boolean r0 = r0.booleanValue()
            goto L_0x014e
        L_0x014d:
            r0 = r6
        L_0x014e:
            java.lang.String r1 = "enforceWhitelist"
            r3.putExtra(r1, r0)
            java.lang.Boolean r0 = r10.getWhitelistEnabled()
            if (r0 == 0) goto L_0x015e
            boolean r0 = r0.booleanValue()
            goto L_0x015f
        L_0x015e:
            r0 = r6
        L_0x015f:
            if (r0 == 0) goto L_0x016a
            java.lang.String r0 = "whitelistEntries"
            java.lang.String r1 = r10.getWhitelistEntries()
            r3.putExtra(r0, r1)
        L_0x016a:
            r0 = 1
            android.content.Context r1 = r9.requireContext()     // Catch:{ SecurityException -> 0x0195 }
            r1.startForegroundService(r3)     // Catch:{ SecurityException -> 0x0195 }
            android.content.Intent r1 = new android.content.Intent     // Catch:{ Exception -> 0x0189 }
            android.content.Context r3 = r9.requireContext()     // Catch:{ Exception -> 0x0189 }
            java.lang.Class<com.armmc.app.PumpkinService> r4 = com.armmc.app.PumpkinService.class
            r1.<init>(r3, r4)     // Catch:{ Exception -> 0x0189 }
            android.content.Context r3 = r9.requireContext()     // Catch:{ Exception -> 0x0189 }
            com.armmc.app.ui.servers.ServersFragment$serviceConnection$1 r4 = r9.serviceConnection     // Catch:{ Exception -> 0x0189 }
            android.content.ServiceConnection r4 = (android.content.ServiceConnection) r4     // Catch:{ Exception -> 0x0189 }
            r3.bindService(r1, r4, r0)     // Catch:{ Exception -> 0x0189 }
            goto L_0x0191
        L_0x0189:
            r0 = move-exception
            java.lang.String r1 = "Failed to bind to PumpkinService"
            java.lang.Throwable r0 = (java.lang.Throwable) r0
            android.util.Log.e(r5, r1, r0)
        L_0x0191:
            r9.requestTunnelAndStartFRP(r10, r2)
            return
        L_0x0195:
            r1 = move-exception
            java.lang.String r2 = "SecurityException starting foreground service"
            java.lang.Throwable r1 = (java.lang.Throwable) r1
            android.util.Log.e(r5, r2, r1)
            r9.currentlyRunningServerId = r4
            com.armmc.app.ui.servers.ResourceMonitor r1 = com.armmc.app.ui.servers.ResourceMonitor.INSTANCE
            int r2 = r10.getId()
            r1.stopMonitoring(r2)
            com.armmc.app.ui.servers.ServerRepository r1 = r9.serverRepository
            if (r1 != 0) goto L_0x01b2
            java.lang.String r1 = "serverRepository"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
            goto L_0x01b3
        L_0x01b2:
            r4 = r1
        L_0x01b3:
            int r10 = r10.getId()
            r4.updateServerStatus(r10, r6)
            r9.loadServers()
            android.content.Context r10 = r9.getContext()
            java.lang.String r1 = "Unable to start server: system blocked the foreground service. Please try again."
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            android.widget.Toast r10 = android.widget.Toast.makeText(r10, r1, r0)
            r10.show()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.armmc.app.ui.servers.ServersFragment.proceedWithStartServer(com.armmc.app.ui.servers.ServerData):void");
    }

    private final void requestTunnelAndStartFRP(ServerData serverData, int i) {
        ServerRepository serverRepository2;
        ServerRepository serverRepository3;
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
        if (!new TunnelRegionManager(requireContext).isTunnelingEnabled()) {
            ServerRepository serverRepository4 = this.serverRepository;
            if (serverRepository4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("serverRepository");
                serverRepository3 = null;
            } else {
                serverRepository3 = serverRepository4;
            }
            ServerRepository.updateTunnelStatus$default(serverRepository3, serverData.getId(), TunnelStatus.DISCONNECTED, 0, 4, (Object) null);
            runOnUiThreadSafe(new ServersFragment$$ExternalSyntheticLambda22(this));
            return;
        }
        ServerRepository serverRepository5 = this.serverRepository;
        if (serverRepository5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("serverRepository");
            serverRepository2 = null;
        } else {
            serverRepository2 = serverRepository5;
        }
        ServerRepository.updateTunnelStatus$default(serverRepository2, serverData.getId(), TunnelStatus.CONNECTING, 0, 4, (Object) null);
        runOnUiThreadSafe(new ServersFragment$$ExternalSyntheticLambda33(this));
        ThreadsKt.thread$default(false, false, (ClassLoader) null, (String) null, 0, new ServersFragment$$ExternalSyntheticLambda35(this, serverData, i), 31, (Object) null);
    }

    /* access modifiers changed from: private */
    public static final Unit requestTunnelAndStartFRP$lambda$30(ServersFragment serversFragment) {
        serversFragment.loadServers();
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit requestTunnelAndStartFRP$lambda$31(ServersFragment serversFragment) {
        serversFragment.loadServers();
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x01a4  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x01a9  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final kotlin.Unit requestTunnelAndStartFRP$lambda$39(com.armmc.app.ui.servers.ServersFragment r22, com.armmc.app.ui.servers.ServerData r23, int r24) {
        /*
            r1 = r22
            java.lang.String r10 = "serverRepository"
            java.lang.String r11 = "ServersFragment"
            java.lang.String r0 = "Tunnel response: subdomain="
            java.lang.String r2 = "Failed to request tunnel: "
            r12 = 0
            com.google.firebase.auth.FirebaseAuth r3 = r1.auth     // Catch:{ Exception -> 0x0195 }
            if (r3 != 0) goto L_0x0015
            java.lang.String r3 = "auth"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r3)     // Catch:{ Exception -> 0x0195 }
            r3 = r12
        L_0x0015:
            com.google.firebase.auth.FirebaseUser r3 = r3.getCurrentUser()     // Catch:{ Exception -> 0x0195 }
            if (r3 != 0) goto L_0x003c
            com.armmc.app.ui.servers.ServerRepository r0 = r1.serverRepository     // Catch:{ Exception -> 0x0195 }
            if (r0 != 0) goto L_0x0024
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r10)     // Catch:{ Exception -> 0x0195 }
            r2 = r12
            goto L_0x0025
        L_0x0024:
            r2 = r0
        L_0x0025:
            int r3 = r23.getId()     // Catch:{ Exception -> 0x0195 }
            com.armmc.app.ui.servers.TunnelStatus r4 = com.armmc.app.ui.servers.TunnelStatus.DISCONNECTED     // Catch:{ Exception -> 0x0195 }
            r6 = 4
            r7 = 0
            r5 = 0
            com.armmc.app.ui.servers.ServerRepository.updateTunnelStatus$default(r2, r3, r4, r5, r6, r7)     // Catch:{ Exception -> 0x0195 }
            com.armmc.app.ui.servers.ServersFragment$$ExternalSyntheticLambda12 r0 = new com.armmc.app.ui.servers.ServersFragment$$ExternalSyntheticLambda12     // Catch:{ Exception -> 0x0195 }
            r0.<init>(r1)     // Catch:{ Exception -> 0x0195 }
            r1.runOnUiThreadSafe(r0)     // Catch:{ Exception -> 0x0195 }
            kotlin.Unit r0 = kotlin.Unit.INSTANCE     // Catch:{ Exception -> 0x0195 }
            return r0
        L_0x003c:
            r4 = 0
            com.google.android.gms.tasks.Task r3 = r3.getIdToken(r4)     // Catch:{ Exception -> 0x0195 }
            java.lang.String r4 = "getIdToken(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r4)     // Catch:{ Exception -> 0x0195 }
            java.lang.Object r3 = com.google.android.gms.tasks.Tasks.await(r3)     // Catch:{ Exception -> 0x0168 }
            com.google.firebase.auth.GetTokenResult r3 = (com.google.firebase.auth.GetTokenResult) r3     // Catch:{ Exception -> 0x0168 }
            java.lang.String r3 = r3.getToken()     // Catch:{ Exception -> 0x0168 }
            if (r3 != 0) goto L_0x0078
            java.lang.String r0 = "Firebase ID token is null"
            android.util.Log.e(r11, r0)     // Catch:{ Exception -> 0x0195 }
            com.armmc.app.ui.servers.ServerRepository r0 = r1.serverRepository     // Catch:{ Exception -> 0x0195 }
            if (r0 != 0) goto L_0x0060
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r10)     // Catch:{ Exception -> 0x0195 }
            r2 = r12
            goto L_0x0061
        L_0x0060:
            r2 = r0
        L_0x0061:
            int r3 = r23.getId()     // Catch:{ Exception -> 0x0195 }
            com.armmc.app.ui.servers.TunnelStatus r4 = com.armmc.app.ui.servers.TunnelStatus.FAILED     // Catch:{ Exception -> 0x0195 }
            r6 = 4
            r7 = 0
            r5 = 0
            com.armmc.app.ui.servers.ServerRepository.updateTunnelStatus$default(r2, r3, r4, r5, r6, r7)     // Catch:{ Exception -> 0x0195 }
            com.armmc.app.ui.servers.ServersFragment$$ExternalSyntheticLambda14 r0 = new com.armmc.app.ui.servers.ServersFragment$$ExternalSyntheticLambda14     // Catch:{ Exception -> 0x0195 }
            r0.<init>(r1)     // Catch:{ Exception -> 0x0195 }
            r1.runOnUiThreadSafe(r0)     // Catch:{ Exception -> 0x0195 }
            kotlin.Unit r0 = kotlin.Unit.INSTANCE     // Catch:{ Exception -> 0x0195 }
            return r0
        L_0x0078:
            java.lang.String r4 = "Requesting tunnel from API..."
            android.util.Log.d(r11, r4)     // Catch:{ Exception -> 0x0195 }
            com.armmc.app.api.TunnelApiService r4 = r1.tunnelApiService     // Catch:{ Exception -> 0x0195 }
            com.armmc.app.api.TunnelApiService$TunnelRequestResponse r3 = r4.requestTunnel(r3)     // Catch:{ Exception -> 0x0195 }
            boolean r4 = r3.getSuccess()     // Catch:{ Exception -> 0x0195 }
            if (r4 != 0) goto L_0x00be
            java.lang.String r0 = r3.getError()     // Catch:{ Exception -> 0x0195 }
            int r4 = r3.getStatusCode()     // Catch:{ Exception -> 0x0195 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0195 }
            r5.<init>(r2)     // Catch:{ Exception -> 0x0195 }
            java.lang.StringBuilder r0 = r5.append(r0)     // Catch:{ Exception -> 0x0195 }
            java.lang.String r2 = " (status: "
            java.lang.StringBuilder r0 = r0.append(r2)     // Catch:{ Exception -> 0x0195 }
            java.lang.StringBuilder r0 = r0.append(r4)     // Catch:{ Exception -> 0x0195 }
            java.lang.String r2 = ")"
            java.lang.StringBuilder r0 = r0.append(r2)     // Catch:{ Exception -> 0x0195 }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x0195 }
            android.util.Log.e(r11, r0)     // Catch:{ Exception -> 0x0195 }
            com.armmc.app.ui.servers.ServersFragment$$ExternalSyntheticLambda15 r0 = new com.armmc.app.ui.servers.ServersFragment$$ExternalSyntheticLambda15     // Catch:{ Exception -> 0x0195 }
            r13 = r23
            r0.<init>(r3, r1, r13)     // Catch:{ Exception -> 0x0193 }
            r1.runOnUiThreadSafe(r0)     // Catch:{ Exception -> 0x0193 }
            kotlin.Unit r0 = kotlin.Unit.INSTANCE     // Catch:{ Exception -> 0x0193 }
            return r0
        L_0x00be:
            r13 = r23
            java.lang.String r2 = r3.getSubdomain()     // Catch:{ Exception -> 0x0193 }
            java.lang.String r4 = r3.getServerAddress()     // Catch:{ Exception -> 0x0193 }
            int r5 = r3.getServerPort()     // Catch:{ Exception -> 0x0193 }
            int r6 = r3.getRemotePort()     // Catch:{ Exception -> 0x0193 }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0193 }
            r7.<init>(r0)     // Catch:{ Exception -> 0x0193 }
            java.lang.StringBuilder r0 = r7.append(r2)     // Catch:{ Exception -> 0x0193 }
            java.lang.String r2 = ", serverAddress="
            java.lang.StringBuilder r0 = r0.append(r2)     // Catch:{ Exception -> 0x0193 }
            java.lang.StringBuilder r0 = r0.append(r4)     // Catch:{ Exception -> 0x0193 }
            java.lang.String r2 = ", serverPort="
            java.lang.StringBuilder r0 = r0.append(r2)     // Catch:{ Exception -> 0x0193 }
            java.lang.StringBuilder r0 = r0.append(r5)     // Catch:{ Exception -> 0x0193 }
            java.lang.String r2 = ", remotePort="
            java.lang.StringBuilder r0 = r0.append(r2)     // Catch:{ Exception -> 0x0193 }
            java.lang.StringBuilder r0 = r0.append(r6)     // Catch:{ Exception -> 0x0193 }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x0193 }
            android.util.Log.i(r11, r0)     // Catch:{ Exception -> 0x0193 }
            boolean r0 = r3.getExisting()     // Catch:{ Exception -> 0x0193 }
            if (r0 == 0) goto L_0x0109
            java.lang.String r0 = "Using existing tunnel"
            android.util.Log.i(r11, r0)     // Catch:{ Exception -> 0x0193 }
        L_0x0109:
            java.lang.String r8 = r3.getFullAddress()     // Catch:{ Exception -> 0x0193 }
            r1.currentTunnelAddress = r8     // Catch:{ Exception -> 0x0193 }
            com.armmc.app.ui.servers.ServerRepository r0 = r1.serverRepository     // Catch:{ Exception -> 0x0193 }
            if (r0 != 0) goto L_0x0117
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r10)     // Catch:{ Exception -> 0x0193 }
            r0 = r12
        L_0x0117:
            int r2 = r13.getId()     // Catch:{ Exception -> 0x0193 }
            r0.updateServerTunnelAddress(r2, r8)     // Catch:{ Exception -> 0x0193 }
            com.armmc.app.ui.servers.ServersFragment$$ExternalSyntheticLambda16 r0 = new com.armmc.app.ui.servers.ServersFragment$$ExternalSyntheticLambda16     // Catch:{ Exception -> 0x0193 }
            r0.<init>(r1)     // Catch:{ Exception -> 0x0193 }
            r1.runOnUiThreadSafe(r0)     // Catch:{ Exception -> 0x0193 }
            java.lang.String r0 = "Waiting 2 seconds for FRP server to initialize..."
            android.util.Log.d(r11, r0)     // Catch:{ Exception -> 0x0193 }
            r4 = 2000(0x7d0, double:9.88E-321)
            java.lang.Thread.sleep(r4)     // Catch:{ Exception -> 0x0193 }
            com.armmc.app.ui.servers.ServersFragment$FrpConnectionParams r14 = new com.armmc.app.ui.servers.ServersFragment$FrpConnectionParams     // Catch:{ Exception -> 0x0193 }
            int r15 = r13.getId()     // Catch:{ Exception -> 0x0193 }
            java.lang.String r17 = "vps.witherhost.com"
            int r18 = r3.getServerPort()     // Catch:{ Exception -> 0x0193 }
            java.lang.String r19 = r3.getToken()     // Catch:{ Exception -> 0x0193 }
            int r20 = r3.getRemotePort()     // Catch:{ Exception -> 0x0193 }
            r16 = r24
            r21 = r8
            r14.<init>(r15, r16, r17, r18, r19, r20, r21)     // Catch:{ Exception -> 0x0193 }
            r1.currentFrpParams = r14     // Catch:{ Exception -> 0x0193 }
            int r2 = r13.getId()     // Catch:{ Exception -> 0x0193 }
            java.lang.String r4 = "vps.witherhost.com"
            int r5 = r3.getServerPort()     // Catch:{ Exception -> 0x0193 }
            java.lang.String r6 = r3.getToken()     // Catch:{ Exception -> 0x0193 }
            int r7 = r3.getRemotePort()     // Catch:{ Exception -> 0x0193 }
            r9 = 1
            r3 = r24
            r8 = r21
            r1.startFRPClientWithRetry(r2, r3, r4, r5, r6, r7, r8, r9)     // Catch:{ Exception -> 0x0193 }
            goto L_0x01be
        L_0x0168:
            r0 = move-exception
            r13 = r23
            java.lang.String r2 = "Failed to get Firebase ID token"
            java.lang.Throwable r0 = (java.lang.Throwable) r0     // Catch:{ Exception -> 0x0193 }
            android.util.Log.e(r11, r2, r0)     // Catch:{ Exception -> 0x0193 }
            com.armmc.app.ui.servers.ServerRepository r0 = r1.serverRepository     // Catch:{ Exception -> 0x0193 }
            if (r0 != 0) goto L_0x017b
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r10)     // Catch:{ Exception -> 0x0193 }
            r2 = r12
            goto L_0x017c
        L_0x017b:
            r2 = r0
        L_0x017c:
            int r3 = r13.getId()     // Catch:{ Exception -> 0x0193 }
            com.armmc.app.ui.servers.TunnelStatus r4 = com.armmc.app.ui.servers.TunnelStatus.FAILED     // Catch:{ Exception -> 0x0193 }
            r6 = 4
            r7 = 0
            r5 = 0
            com.armmc.app.ui.servers.ServerRepository.updateTunnelStatus$default(r2, r3, r4, r5, r6, r7)     // Catch:{ Exception -> 0x0193 }
            com.armmc.app.ui.servers.ServersFragment$$ExternalSyntheticLambda13 r0 = new com.armmc.app.ui.servers.ServersFragment$$ExternalSyntheticLambda13     // Catch:{ Exception -> 0x0193 }
            r0.<init>(r1)     // Catch:{ Exception -> 0x0193 }
            r1.runOnUiThreadSafe(r0)     // Catch:{ Exception -> 0x0193 }
            kotlin.Unit r0 = kotlin.Unit.INSTANCE     // Catch:{ Exception -> 0x0193 }
            return r0
        L_0x0193:
            r0 = move-exception
            goto L_0x0198
        L_0x0195:
            r0 = move-exception
            r13 = r23
        L_0x0198:
            java.lang.String r2 = "Error requesting tunnel"
            r3 = r0
            java.lang.Throwable r3 = (java.lang.Throwable) r3
            android.util.Log.e(r11, r2, r3)
            com.armmc.app.ui.servers.ServerRepository r2 = r1.serverRepository
            if (r2 != 0) goto L_0x01a9
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r10)
            r3 = r12
            goto L_0x01aa
        L_0x01a9:
            r3 = r2
        L_0x01aa:
            int r4 = r13.getId()
            com.armmc.app.ui.servers.TunnelStatus r5 = com.armmc.app.ui.servers.TunnelStatus.FAILED
            r7 = 4
            r8 = 0
            r6 = 0
            com.armmc.app.ui.servers.ServerRepository.updateTunnelStatus$default(r3, r4, r5, r6, r7, r8)
            com.armmc.app.ui.servers.ServersFragment$$ExternalSyntheticLambda17 r2 = new com.armmc.app.ui.servers.ServersFragment$$ExternalSyntheticLambda17
            r2.<init>(r1, r0)
            r1.runOnUiThreadSafe(r2)
        L_0x01be:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.armmc.app.ui.servers.ServersFragment.requestTunnelAndStartFRP$lambda$39(com.armmc.app.ui.servers.ServersFragment, com.armmc.app.ui.servers.ServerData, int):kotlin.Unit");
    }

    /* access modifiers changed from: private */
    public static final Unit requestTunnelAndStartFRP$lambda$39$lambda$32(ServersFragment serversFragment) {
        serversFragment.loadServers();
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit requestTunnelAndStartFRP$lambda$39$lambda$33(ServersFragment serversFragment) {
        Toast.makeText(serversFragment.getContext(), "Failed to authenticate for tunnel", 0).show();
        serversFragment.loadServers();
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit requestTunnelAndStartFRP$lambda$39$lambda$34(ServersFragment serversFragment) {
        Toast.makeText(serversFragment.getContext(), "Authentication failed", 0).show();
        serversFragment.loadServers();
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit requestTunnelAndStartFRP$lambda$39$lambda$36(TunnelApiService.TunnelRequestResponse tunnelRequestResponse, ServersFragment serversFragment, ServerData serverData) {
        if (tunnelRequestResponse.getStatusCode() == 503) {
            serversFragment.showServerBusyDialog();
            new Handler(Looper.getMainLooper()).postDelayed(new ServersFragment$$ExternalSyntheticLambda37(serversFragment, serverData), 2000);
        } else {
            Context context = serversFragment.getContext();
            String error = tunnelRequestResponse.getError();
            if (error == null) {
                error = "Unknown error";
            }
            Toast.makeText(context, "Tunnel error: " + error, 0).show();
            ServerRepository serverRepository2 = serversFragment.serverRepository;
            if (serverRepository2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("serverRepository");
                serverRepository2 = null;
            }
            ServerRepository.updateTunnelStatus$default(serverRepository2, serverData.getId(), TunnelStatus.FAILED, 0, 4, (Object) null);
            serversFragment.loadServers();
        }
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final void requestTunnelAndStartFRP$lambda$39$lambda$36$lambda$35(ServersFragment serversFragment, ServerData serverData) {
        ServerRepository serverRepository2 = serversFragment.serverRepository;
        if (serverRepository2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("serverRepository");
            serverRepository2 = null;
        }
        ServerRepository.updateTunnelStatus$default(serverRepository2, serverData.getId(), TunnelStatus.DISCONNECTED, 0, 4, (Object) null);
        if (serversFragment.isAdded()) {
            serversFragment.loadServers();
        }
    }

    /* access modifiers changed from: private */
    public static final Unit requestTunnelAndStartFRP$lambda$39$lambda$37(ServersFragment serversFragment) {
        serversFragment.loadServers();
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit requestTunnelAndStartFRP$lambda$39$lambda$38(ServersFragment serversFragment, Exception exc) {
        Toast.makeText(serversFragment.getContext(), "Tunnel error: " + exc.getMessage(), 0).show();
        serversFragment.loadServers();
        return Unit.INSTANCE;
    }

    /* JADX INFO: finally extract failed */
    /* JADX WARNING: Code restructure failed: missing block: B:102:0x01b9, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:103:0x01ba, code lost:
        android.util.Log.e(TAG, "Error starting FRP client (attempt " + r2 + ")", r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:104:0x01d8, code lost:
        monitor-enter(r13.frpLock);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:106:?, code lost:
        r13.isReconnecting = false;
        r0 = kotlin.Unit.INSTANCE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:108:0x01de, code lost:
        r0 = r13.serverRepository;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:109:0x01e0, code lost:
        if (r0 == null) goto L_0x01e2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:110:0x01e2, code lost:
        kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("serverRepository");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:111:0x01e8, code lost:
        r3 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:112:0x01e9, code lost:
        r3.updateTunnelInfo(r14, r1, com.armmc.app.ui.servers.TunnelStatus.FAILED, r2);
        runOnUiThreadSafe(new com.armmc.app.ui.servers.ServersFragment$$ExternalSyntheticLambda3(r13));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:113:0x01f6, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:114:0x01f7, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:117:0x01fa, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:118:0x01fb, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:121:0x01fe, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x002c, code lost:
        r3 = r13.frpLock;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x002e, code lost:
        monitor-enter(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0031, code lost:
        if (r13.isIntentionallyStopping == false) goto L_0x003e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0033, code lost:
        android.util.Log.d(TAG, "Retry cancelled - intentionally stopping");
        r13.isReconnecting = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x003c, code lost:
        monitor-exit(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x003d, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:?, code lost:
        r0 = kotlin.Unit.INSTANCE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0040, code lost:
        monitor-exit(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0041, code lost:
        r3 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:?, code lost:
        r5 = r13.frpLock;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0044, code lost:
        monitor-enter(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:?, code lost:
        r13.frpClient = com.armmc.app.frp.FRPClient.Companion.getInstance();
        r0 = kotlin.Unit.INSTANCE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:?, code lost:
        monitor-exit(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0050, code lost:
        r0 = r13.frpClient;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0052, code lost:
        if (r0 == null) goto L_0x0098;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0058, code lost:
        if (r0.isRunning() == false) goto L_0x0098;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x005a, code lost:
        android.util.Log.w(TAG, "FRP client still running from previous session, stopping before reconfigure");
        r0.setStatusListener((kotlin.jvm.functions.Function2<? super java.lang.Integer, ? super java.lang.String, kotlin.Unit>) null);
        r0.stop();
        r5 = java.lang.System.currentTimeMillis() + ((long) 3000);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x0073, code lost:
        if (r0.isRunning() == false) goto L_0x0083;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x007b, code lost:
        if (java.lang.System.currentTimeMillis() >= r5) goto L_0x0083;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x007d, code lost:
        java.lang.Thread.sleep(100);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x0087, code lost:
        if (r0.isRunning() == false) goto L_0x0091;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x0089, code lost:
        android.util.Log.e(TAG, "FRP client did not stop within 3 s, proceeding anyway");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x0091, code lost:
        android.util.Log.d(TAG, "Previous FRP client stopped, ready to reconfigure");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x0098, code lost:
        r0 = r13.frpClient;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x009a, code lost:
        if (r0 == null) goto L_0x00a4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x009c, code lost:
        r0.setStatusListener(new com.armmc.app.ui.servers.ServersFragment$$ExternalSyntheticLambda40(r13, r14, r1));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x00a4, code lost:
        r7 = r16;
        r8 = r17;
        r12 = r19;
        android.util.Log.d(TAG, "Configuring FRP client (attempt " + r2 + "): " + r7 + ":" + r8 + " -> 127.0.0.1:" + r15 + " (remote: " + r12 + ")");
        r6 = r13.frpClient;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x00f2, code lost:
        if (r6 == null) goto L_0x00fe;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x00f4, code lost:
        r0 = r6.configureSimple(r7, r8, r18, FRP_LOCAL_IP, r15, r12);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x00fe, code lost:
        r0 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x00ff, code lost:
        if (r0 != false) goto L_0x0146;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x0101, code lost:
        r5 = r13.frpClient;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x0105, code lost:
        if (r5 == null) goto L_0x010c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x0107, code lost:
        r5 = r5.getLastError();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x010c, code lost:
        r5 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x010d, code lost:
        android.util.Log.e(TAG, "Failed to configure FRP client: " + r5);
        r5 = r13.frpLock;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x0125, code lost:
        monitor-enter(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:?, code lost:
        r13.isReconnecting = false;
        r0 = kotlin.Unit.INSTANCE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:?, code lost:
        monitor-exit(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x012b, code lost:
        r0 = r13.serverRepository;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x012d, code lost:
        if (r0 != null) goto L_0x0135;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x012f, code lost:
        kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("serverRepository");
        r0 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x0135, code lost:
        r0.updateTunnelInfo(r14, r1, com.armmc.app.ui.servers.TunnelStatus.FAILED, r2);
        runOnUiThreadSafe(new com.armmc.app.ui.servers.ServersFragment$$ExternalSyntheticLambda1(r13));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x0142, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x0146, code lost:
        r0 = r13.frpClient;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x0148, code lost:
        if (r0 == null) goto L_0x014f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x014a, code lost:
        r0 = r0.start();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x014f, code lost:
        r0 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x0150, code lost:
        if (r0 != false) goto L_0x0197;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x0152, code lost:
        r5 = r13.frpClient;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x0156, code lost:
        if (r5 == null) goto L_0x015d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x0158, code lost:
        r5 = r5.getLastError();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x015d, code lost:
        r5 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x015e, code lost:
        android.util.Log.e(TAG, "Failed to start FRP client: " + r5);
        r5 = r13.frpLock;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x0176, code lost:
        monitor-enter(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:?, code lost:
        r13.isReconnecting = false;
        r0 = kotlin.Unit.INSTANCE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:?, code lost:
        monitor-exit(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:89:0x017c, code lost:
        r0 = r13.serverRepository;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:90:0x017e, code lost:
        if (r0 != null) goto L_0x0186;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:91:0x0180, code lost:
        kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("serverRepository");
        r0 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:92:0x0186, code lost:
        r0.updateTunnelInfo(r14, r1, com.armmc.app.ui.servers.TunnelStatus.FAILED, r2);
        runOnUiThreadSafe(new com.armmc.app.ui.servers.ServersFragment$$ExternalSyntheticLambda2(r13));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:93:0x0193, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:97:0x0197, code lost:
        android.util.Log.i(TAG, "FRP client started successfully (attempt " + r2 + ")");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:98:0x01b5, code lost:
        return;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void startFRPClientWithRetry(int r14, int r15, java.lang.String r16, int r17, java.lang.String r18, int r19, java.lang.String r20, int r21) {
        /*
            r13 = this;
            r1 = r20
            r2 = r21
            java.lang.Object r3 = r13.frpLock
            monitor-enter(r3)
            r4 = 0
            r13.isIntentionallyStopping = r4     // Catch:{ all -> 0x01ff }
            r0 = 3
            if (r2 <= r0) goto L_0x0022
            java.lang.String r0 = "ServersFragment"
            java.lang.String r2 = "FRP connection failed after 3 attempts"
            android.util.Log.e(r0, r2)     // Catch:{ all -> 0x01ff }
            r13.isReconnecting = r4     // Catch:{ all -> 0x01ff }
            r13.currentRetryAttempt = r4     // Catch:{ all -> 0x01ff }
            com.armmc.app.ui.servers.ServersFragment$$ExternalSyntheticLambda39 r0 = new com.armmc.app.ui.servers.ServersFragment$$ExternalSyntheticLambda39     // Catch:{ all -> 0x01ff }
            r0.<init>(r13, r14, r1)     // Catch:{ all -> 0x01ff }
            r13.runOnUiThreadSafe(r0)     // Catch:{ all -> 0x01ff }
            monitor-exit(r3)
            return
        L_0x0022:
            r0 = 1
            if (r2 != r0) goto L_0x0027
            r13.isReconnecting = r0     // Catch:{ all -> 0x01ff }
        L_0x0027:
            r13.currentRetryAttempt = r2     // Catch:{ all -> 0x01ff }
            kotlin.Unit r0 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x01ff }
            monitor-exit(r3)
            java.lang.Object r3 = r13.frpLock
            monitor-enter(r3)
            boolean r0 = r13.isIntentionallyStopping     // Catch:{ all -> 0x01fb }
            if (r0 == 0) goto L_0x003e
            java.lang.String r14 = "ServersFragment"
            java.lang.String r0 = "Retry cancelled - intentionally stopping"
            android.util.Log.d(r14, r0)     // Catch:{ all -> 0x01fb }
            r13.isReconnecting = r4     // Catch:{ all -> 0x01fb }
            monitor-exit(r3)
            return
        L_0x003e:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x01fb }
            monitor-exit(r3)
            r3 = 0
            java.lang.Object r5 = r13.frpLock     // Catch:{ Exception -> 0x01b9 }
            monitor-enter(r5)     // Catch:{ Exception -> 0x01b9 }
            com.armmc.app.frp.FRPClient$Companion r0 = com.armmc.app.frp.FRPClient.Companion     // Catch:{ all -> 0x01b6 }
            com.armmc.app.frp.FRPClient r0 = r0.getInstance()     // Catch:{ all -> 0x01b6 }
            r13.frpClient = r0     // Catch:{ all -> 0x01b6 }
            kotlin.Unit r0 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x01b6 }
            monitor-exit(r5)     // Catch:{ Exception -> 0x01b9 }
            com.armmc.app.frp.FRPClient r0 = r13.frpClient     // Catch:{ Exception -> 0x01b9 }
            if (r0 == 0) goto L_0x0098
            boolean r5 = r0.isRunning()     // Catch:{ Exception -> 0x01b9 }
            if (r5 == 0) goto L_0x0098
            java.lang.String r5 = "ServersFragment"
            java.lang.String r6 = "FRP client still running from previous session, stopping before reconfigure"
            android.util.Log.w(r5, r6)     // Catch:{ Exception -> 0x01b9 }
            r0.setStatusListener(r3)     // Catch:{ Exception -> 0x01b9 }
            r0.stop()     // Catch:{ Exception -> 0x01b9 }
            long r5 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x01b9 }
            r7 = 3000(0xbb8, float:4.204E-42)
            long r7 = (long) r7     // Catch:{ Exception -> 0x01b9 }
            long r5 = r5 + r7
        L_0x006f:
            boolean r7 = r0.isRunning()     // Catch:{ Exception -> 0x01b9 }
            if (r7 == 0) goto L_0x0083
            long r7 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x01b9 }
            int r7 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
            if (r7 >= 0) goto L_0x0083
            r7 = 100
            java.lang.Thread.sleep(r7)     // Catch:{ Exception -> 0x01b9 }
            goto L_0x006f
        L_0x0083:
            boolean r0 = r0.isRunning()     // Catch:{ Exception -> 0x01b9 }
            if (r0 == 0) goto L_0x0091
            java.lang.String r0 = "ServersFragment"
            java.lang.String r5 = "FRP client did not stop within 3 s, proceeding anyway"
            android.util.Log.e(r0, r5)     // Catch:{ Exception -> 0x01b9 }
            goto L_0x0098
        L_0x0091:
            java.lang.String r0 = "ServersFragment"
            java.lang.String r5 = "Previous FRP client stopped, ready to reconfigure"
            android.util.Log.d(r0, r5)     // Catch:{ Exception -> 0x01b9 }
        L_0x0098:
            com.armmc.app.frp.FRPClient r0 = r13.frpClient     // Catch:{ Exception -> 0x01b9 }
            if (r0 == 0) goto L_0x00a4
            com.armmc.app.ui.servers.ServersFragment$$ExternalSyntheticLambda40 r5 = new com.armmc.app.ui.servers.ServersFragment$$ExternalSyntheticLambda40     // Catch:{ Exception -> 0x01b9 }
            r5.<init>(r13, r14, r1)     // Catch:{ Exception -> 0x01b9 }
            r0.setStatusListener(r5)     // Catch:{ Exception -> 0x01b9 }
        L_0x00a4:
            java.lang.String r0 = "ServersFragment"
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x01b9 }
            r5.<init>()     // Catch:{ Exception -> 0x01b9 }
            java.lang.String r6 = "Configuring FRP client (attempt "
            java.lang.StringBuilder r5 = r5.append(r6)     // Catch:{ Exception -> 0x01b9 }
            java.lang.StringBuilder r5 = r5.append(r2)     // Catch:{ Exception -> 0x01b9 }
            java.lang.String r6 = "): "
            java.lang.StringBuilder r5 = r5.append(r6)     // Catch:{ Exception -> 0x01b9 }
            r7 = r16
            java.lang.StringBuilder r5 = r5.append(r7)     // Catch:{ Exception -> 0x01b9 }
            java.lang.String r6 = ":"
            java.lang.StringBuilder r5 = r5.append(r6)     // Catch:{ Exception -> 0x01b9 }
            r8 = r17
            java.lang.StringBuilder r5 = r5.append(r8)     // Catch:{ Exception -> 0x01b9 }
            java.lang.String r6 = " -> 127.0.0.1:"
            java.lang.StringBuilder r5 = r5.append(r6)     // Catch:{ Exception -> 0x01b9 }
            java.lang.StringBuilder r5 = r5.append(r15)     // Catch:{ Exception -> 0x01b9 }
            java.lang.String r6 = " (remote: "
            java.lang.StringBuilder r5 = r5.append(r6)     // Catch:{ Exception -> 0x01b9 }
            r12 = r19
            java.lang.StringBuilder r5 = r5.append(r12)     // Catch:{ Exception -> 0x01b9 }
            java.lang.String r6 = ")"
            java.lang.StringBuilder r5 = r5.append(r6)     // Catch:{ Exception -> 0x01b9 }
            java.lang.String r5 = r5.toString()     // Catch:{ Exception -> 0x01b9 }
            android.util.Log.d(r0, r5)     // Catch:{ Exception -> 0x01b9 }
            com.armmc.app.frp.FRPClient r6 = r13.frpClient     // Catch:{ Exception -> 0x01b9 }
            if (r6 == 0) goto L_0x00fe
            java.lang.String r10 = "127.0.0.1"
            r11 = r15
            r9 = r18
            boolean r0 = r6.configureSimple(r7, r8, r9, r10, r11, r12)     // Catch:{ Exception -> 0x01b9 }
            goto L_0x00ff
        L_0x00fe:
            r0 = r4
        L_0x00ff:
            if (r0 != 0) goto L_0x0146
            java.lang.String r0 = "ServersFragment"
            com.armmc.app.frp.FRPClient r5 = r13.frpClient     // Catch:{ Exception -> 0x01b9 }
            if (r5 == 0) goto L_0x010c
            java.lang.String r5 = r5.getLastError()     // Catch:{ Exception -> 0x01b9 }
            goto L_0x010d
        L_0x010c:
            r5 = r3
        L_0x010d:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x01b9 }
            r6.<init>()     // Catch:{ Exception -> 0x01b9 }
            java.lang.String r7 = "Failed to configure FRP client: "
            java.lang.StringBuilder r6 = r6.append(r7)     // Catch:{ Exception -> 0x01b9 }
            java.lang.StringBuilder r5 = r6.append(r5)     // Catch:{ Exception -> 0x01b9 }
            java.lang.String r5 = r5.toString()     // Catch:{ Exception -> 0x01b9 }
            android.util.Log.e(r0, r5)     // Catch:{ Exception -> 0x01b9 }
            java.lang.Object r5 = r13.frpLock     // Catch:{ Exception -> 0x01b9 }
            monitor-enter(r5)     // Catch:{ Exception -> 0x01b9 }
            r13.isReconnecting = r4     // Catch:{ all -> 0x0143 }
            kotlin.Unit r0 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0143 }
            monitor-exit(r5)     // Catch:{ Exception -> 0x01b9 }
            com.armmc.app.ui.servers.ServerRepository r0 = r13.serverRepository     // Catch:{ Exception -> 0x01b9 }
            if (r0 != 0) goto L_0x0135
            java.lang.String r0 = "serverRepository"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r0)     // Catch:{ Exception -> 0x01b9 }
            r0 = r3
        L_0x0135:
            com.armmc.app.ui.servers.TunnelStatus r5 = com.armmc.app.ui.servers.TunnelStatus.FAILED     // Catch:{ Exception -> 0x01b9 }
            r0.updateTunnelInfo(r14, r1, r5, r2)     // Catch:{ Exception -> 0x01b9 }
            com.armmc.app.ui.servers.ServersFragment$$ExternalSyntheticLambda1 r0 = new com.armmc.app.ui.servers.ServersFragment$$ExternalSyntheticLambda1     // Catch:{ Exception -> 0x01b9 }
            r0.<init>(r13)     // Catch:{ Exception -> 0x01b9 }
            r13.runOnUiThreadSafe(r0)     // Catch:{ Exception -> 0x01b9 }
            return
        L_0x0143:
            r0 = move-exception
            monitor-exit(r5)     // Catch:{ Exception -> 0x01b9 }
            throw r0     // Catch:{ Exception -> 0x01b9 }
        L_0x0146:
            com.armmc.app.frp.FRPClient r0 = r13.frpClient     // Catch:{ Exception -> 0x01b9 }
            if (r0 == 0) goto L_0x014f
            boolean r0 = r0.start()     // Catch:{ Exception -> 0x01b9 }
            goto L_0x0150
        L_0x014f:
            r0 = r4
        L_0x0150:
            if (r0 != 0) goto L_0x0197
            java.lang.String r0 = "ServersFragment"
            com.armmc.app.frp.FRPClient r5 = r13.frpClient     // Catch:{ Exception -> 0x01b9 }
            if (r5 == 0) goto L_0x015d
            java.lang.String r5 = r5.getLastError()     // Catch:{ Exception -> 0x01b9 }
            goto L_0x015e
        L_0x015d:
            r5 = r3
        L_0x015e:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x01b9 }
            r6.<init>()     // Catch:{ Exception -> 0x01b9 }
            java.lang.String r7 = "Failed to start FRP client: "
            java.lang.StringBuilder r6 = r6.append(r7)     // Catch:{ Exception -> 0x01b9 }
            java.lang.StringBuilder r5 = r6.append(r5)     // Catch:{ Exception -> 0x01b9 }
            java.lang.String r5 = r5.toString()     // Catch:{ Exception -> 0x01b9 }
            android.util.Log.e(r0, r5)     // Catch:{ Exception -> 0x01b9 }
            java.lang.Object r5 = r13.frpLock     // Catch:{ Exception -> 0x01b9 }
            monitor-enter(r5)     // Catch:{ Exception -> 0x01b9 }
            r13.isReconnecting = r4     // Catch:{ all -> 0x0194 }
            kotlin.Unit r0 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0194 }
            monitor-exit(r5)     // Catch:{ Exception -> 0x01b9 }
            com.armmc.app.ui.servers.ServerRepository r0 = r13.serverRepository     // Catch:{ Exception -> 0x01b9 }
            if (r0 != 0) goto L_0x0186
            java.lang.String r0 = "serverRepository"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r0)     // Catch:{ Exception -> 0x01b9 }
            r0 = r3
        L_0x0186:
            com.armmc.app.ui.servers.TunnelStatus r5 = com.armmc.app.ui.servers.TunnelStatus.FAILED     // Catch:{ Exception -> 0x01b9 }
            r0.updateTunnelInfo(r14, r1, r5, r2)     // Catch:{ Exception -> 0x01b9 }
            com.armmc.app.ui.servers.ServersFragment$$ExternalSyntheticLambda2 r0 = new com.armmc.app.ui.servers.ServersFragment$$ExternalSyntheticLambda2     // Catch:{ Exception -> 0x01b9 }
            r0.<init>(r13)     // Catch:{ Exception -> 0x01b9 }
            r13.runOnUiThreadSafe(r0)     // Catch:{ Exception -> 0x01b9 }
            return
        L_0x0194:
            r0 = move-exception
            monitor-exit(r5)     // Catch:{ Exception -> 0x01b9 }
            throw r0     // Catch:{ Exception -> 0x01b9 }
        L_0x0197:
            java.lang.String r0 = "ServersFragment"
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x01b9 }
            r5.<init>()     // Catch:{ Exception -> 0x01b9 }
            java.lang.String r6 = "FRP client started successfully (attempt "
            java.lang.StringBuilder r5 = r5.append(r6)     // Catch:{ Exception -> 0x01b9 }
            java.lang.StringBuilder r5 = r5.append(r2)     // Catch:{ Exception -> 0x01b9 }
            java.lang.String r6 = ")"
            java.lang.StringBuilder r5 = r5.append(r6)     // Catch:{ Exception -> 0x01b9 }
            java.lang.String r5 = r5.toString()     // Catch:{ Exception -> 0x01b9 }
            android.util.Log.i(r0, r5)     // Catch:{ Exception -> 0x01b9 }
            return
        L_0x01b6:
            r0 = move-exception
            monitor-exit(r5)     // Catch:{ Exception -> 0x01b9 }
            throw r0     // Catch:{ Exception -> 0x01b9 }
        L_0x01b9:
            r0 = move-exception
            java.lang.String r5 = "ServersFragment"
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            java.lang.String r7 = "Error starting FRP client (attempt "
            r6.<init>(r7)
            java.lang.StringBuilder r6 = r6.append(r2)
            java.lang.String r7 = ")"
            java.lang.StringBuilder r6 = r6.append(r7)
            java.lang.String r6 = r6.toString()
            java.lang.Throwable r0 = (java.lang.Throwable) r0
            android.util.Log.e(r5, r6, r0)
            java.lang.Object r5 = r13.frpLock
            monitor-enter(r5)
            r13.isReconnecting = r4     // Catch:{ all -> 0x01f7 }
            kotlin.Unit r0 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x01f7 }
            monitor-exit(r5)
            com.armmc.app.ui.servers.ServerRepository r0 = r13.serverRepository
            if (r0 != 0) goto L_0x01e8
            java.lang.String r0 = "serverRepository"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r0)
            goto L_0x01e9
        L_0x01e8:
            r3 = r0
        L_0x01e9:
            com.armmc.app.ui.servers.TunnelStatus r0 = com.armmc.app.ui.servers.TunnelStatus.FAILED
            r3.updateTunnelInfo(r14, r1, r0, r2)
            com.armmc.app.ui.servers.ServersFragment$$ExternalSyntheticLambda3 r14 = new com.armmc.app.ui.servers.ServersFragment$$ExternalSyntheticLambda3
            r14.<init>(r13)
            r13.runOnUiThreadSafe(r14)
            return
        L_0x01f7:
            r0 = move-exception
            r14 = r0
            monitor-exit(r5)
            throw r14
        L_0x01fb:
            r0 = move-exception
            r14 = r0
            monitor-exit(r3)
            throw r14
        L_0x01ff:
            r0 = move-exception
            r14 = r0
            monitor-exit(r3)
            throw r14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.armmc.app.ui.servers.ServersFragment.startFRPClientWithRetry(int, int, java.lang.String, int, java.lang.String, int, java.lang.String, int):void");
    }

    /* access modifiers changed from: private */
    public static final Unit startFRPClientWithRetry$lambda$41$lambda$40(ServersFragment serversFragment, int i, String str) {
        ServerRepository serverRepository2 = serversFragment.serverRepository;
        if (serverRepository2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("serverRepository");
            serverRepository2 = null;
        }
        serverRepository2.updateTunnelInfo(i, str, TunnelStatus.FAILED, 3);
        serversFragment.loadServers();
        Toast.makeText(serversFragment.getContext(), "Tunnel connection failed after 3 attempts", 1).show();
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0038, code lost:
        r0 = r3.currentlyRunningServerId;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x003a, code lost:
        if (r0 != null) goto L_0x003d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0041, code lost:
        if (r0.intValue() == r4) goto L_0x0060;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0043, code lost:
        android.util.Log.d(TAG, "Ignoring status callback - server " + r4 + " is no longer running");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x005f, code lost:
        return kotlin.Unit.INSTANCE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0060, code lost:
        if (r6 == 0) goto L_0x00eb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0063, code lost:
        if (r6 == 2) goto L_0x00c1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0066, code lost:
        if (r6 == 4) goto L_0x0081;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0069, code lost:
        if (r6 == 5) goto L_0x0079;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x006c, code lost:
        if (r6 == 6) goto L_0x0070;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0070, code lost:
        android.util.Log.d(TAG, "FRP native reconnecting...");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0079, code lost:
        android.util.Log.d(TAG, "FRP connecting...");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0081, code lost:
        r5 = r3.currentlyRunningServerId;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0083, code lost:
        if (r5 != null) goto L_0x0086;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x008a, code lost:
        if (r5.intValue() == r4) goto L_0x00a9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x008c, code lost:
        android.util.Log.d(TAG, "Ignoring FRP error - server " + r4 + " was stopped");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00a8, code lost:
        return kotlin.Unit.INSTANCE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00a9, code lost:
        android.util.Log.e(TAG, "FRP error detected: " + r7);
        r3.handleFrpDisconnection(r4, r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00c1, code lost:
        r6 = java.lang.System.currentTimeMillis();
        r0 = r3.frpLock;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00c7, code lost:
        monitor-enter(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:?, code lost:
        r3.connectionEstablishedTimestamp = r6;
        r3.isReconnecting = false;
        r7 = kotlin.Unit.INSTANCE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00cf, code lost:
        monitor-exit(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00d0, code lost:
        r7 = r3.serverRepository;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00d2, code lost:
        if (r7 != null) goto L_0x00da;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00d4, code lost:
        kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("serverRepository");
        r7 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00da, code lost:
        r7.updateTunnelInfo(r4, r5, com.armmc.app.ui.servers.TunnelStatus.CONNECTED, 0);
        r3.runOnUiThreadSafe(new com.armmc.app.ui.servers.ServersFragment$$ExternalSyntheticLambda30(r3));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00eb, code lost:
        android.util.Log.d(TAG, "FRP stopped (ignoring - handled elsewhere)");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00f4, code lost:
        return kotlin.Unit.INSTANCE;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final kotlin.Unit startFRPClientWithRetry$lambda$48(com.armmc.app.ui.servers.ServersFragment r3, int r4, java.lang.String r5, int r6, java.lang.String r7) {
        /*
            java.lang.String r0 = "message"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            java.lang.String r0 = "ServersFragment"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "FRP Status: "
            r1.<init>(r2)
            java.lang.StringBuilder r1 = r1.append(r6)
            java.lang.String r2 = " - "
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.StringBuilder r1 = r1.append(r7)
            java.lang.String r1 = r1.toString()
            android.util.Log.d(r0, r1)
            java.lang.Object r0 = r3.frpLock
            monitor-enter(r0)
            boolean r1 = r3.isIntentionallyStopping     // Catch:{ all -> 0x00f5 }
            if (r1 == 0) goto L_0x0035
            java.lang.String r3 = "ServersFragment"
            java.lang.String r4 = "Ignoring status callback - intentionally stopping"
            android.util.Log.d(r3, r4)     // Catch:{ all -> 0x00f5 }
            kotlin.Unit r3 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x00f5 }
            monitor-exit(r0)
            return r3
        L_0x0035:
            kotlin.Unit r1 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x00f5 }
            monitor-exit(r0)
            java.lang.Integer r0 = r3.currentlyRunningServerId
            if (r0 != 0) goto L_0x003d
            goto L_0x0043
        L_0x003d:
            int r0 = r0.intValue()
            if (r0 == r4) goto L_0x0060
        L_0x0043:
            java.lang.String r3 = "ServersFragment"
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            java.lang.String r6 = "Ignoring status callback - server "
            r5.<init>(r6)
            java.lang.StringBuilder r4 = r5.append(r4)
            java.lang.String r5 = " is no longer running"
            java.lang.StringBuilder r4 = r4.append(r5)
            java.lang.String r4 = r4.toString()
            android.util.Log.d(r3, r4)
            kotlin.Unit r3 = kotlin.Unit.INSTANCE
            return r3
        L_0x0060:
            if (r6 == 0) goto L_0x00eb
            r0 = 2
            if (r6 == r0) goto L_0x00c1
            r5 = 4
            if (r6 == r5) goto L_0x0081
            r3 = 5
            if (r6 == r3) goto L_0x0079
            r3 = 6
            if (r6 == r3) goto L_0x0070
            goto L_0x00f2
        L_0x0070:
            java.lang.String r3 = "ServersFragment"
            java.lang.String r4 = "FRP native reconnecting..."
            android.util.Log.d(r3, r4)
            goto L_0x00f2
        L_0x0079:
            java.lang.String r3 = "ServersFragment"
            java.lang.String r4 = "FRP connecting..."
            android.util.Log.d(r3, r4)
            goto L_0x00f2
        L_0x0081:
            java.lang.Integer r5 = r3.currentlyRunningServerId
            if (r5 != 0) goto L_0x0086
            goto L_0x008c
        L_0x0086:
            int r5 = r5.intValue()
            if (r5 == r4) goto L_0x00a9
        L_0x008c:
            java.lang.String r3 = "ServersFragment"
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            java.lang.String r6 = "Ignoring FRP error - server "
            r5.<init>(r6)
            java.lang.StringBuilder r4 = r5.append(r4)
            java.lang.String r5 = " was stopped"
            java.lang.StringBuilder r4 = r4.append(r5)
            java.lang.String r4 = r4.toString()
            android.util.Log.d(r3, r4)
            kotlin.Unit r3 = kotlin.Unit.INSTANCE
            return r3
        L_0x00a9:
            java.lang.String r5 = "ServersFragment"
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            java.lang.String r0 = "FRP error detected: "
            r6.<init>(r0)
            java.lang.StringBuilder r6 = r6.append(r7)
            java.lang.String r6 = r6.toString()
            android.util.Log.e(r5, r6)
            r3.handleFrpDisconnection(r4, r7)
            goto L_0x00f2
        L_0x00c1:
            long r6 = java.lang.System.currentTimeMillis()
            java.lang.Object r0 = r3.frpLock
            monitor-enter(r0)
            r3.connectionEstablishedTimestamp = r6     // Catch:{ all -> 0x00e8 }
            r6 = 0
            r3.isReconnecting = r6     // Catch:{ all -> 0x00e8 }
            kotlin.Unit r7 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x00e8 }
            monitor-exit(r0)
            com.armmc.app.ui.servers.ServerRepository r7 = r3.serverRepository
            if (r7 != 0) goto L_0x00da
            java.lang.String r7 = "serverRepository"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r7)
            r7 = 0
        L_0x00da:
            com.armmc.app.ui.servers.TunnelStatus r0 = com.armmc.app.ui.servers.TunnelStatus.CONNECTED
            r7.updateTunnelInfo(r4, r5, r0, r6)
            com.armmc.app.ui.servers.ServersFragment$$ExternalSyntheticLambda30 r4 = new com.armmc.app.ui.servers.ServersFragment$$ExternalSyntheticLambda30
            r4.<init>(r3)
            r3.runOnUiThreadSafe(r4)
            goto L_0x00f2
        L_0x00e8:
            r3 = move-exception
            monitor-exit(r0)
            throw r3
        L_0x00eb:
            java.lang.String r3 = "ServersFragment"
            java.lang.String r4 = "FRP stopped (ignoring - handled elsewhere)"
            android.util.Log.d(r3, r4)
        L_0x00f2:
            kotlin.Unit r3 = kotlin.Unit.INSTANCE
            return r3
        L_0x00f5:
            r3 = move-exception
            monitor-exit(r0)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.armmc.app.ui.servers.ServersFragment.startFRPClientWithRetry$lambda$48(com.armmc.app.ui.servers.ServersFragment, int, java.lang.String, int, java.lang.String):kotlin.Unit");
    }

    /* access modifiers changed from: private */
    public static final Unit startFRPClientWithRetry$lambda$48$lambda$47(ServersFragment serversFragment) {
        serversFragment.loadServers();
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit startFRPClientWithRetry$lambda$50(ServersFragment serversFragment) {
        serversFragment.loadServers();
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit startFRPClientWithRetry$lambda$52(ServersFragment serversFragment) {
        serversFragment.loadServers();
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit startFRPClientWithRetry$lambda$54(ServersFragment serversFragment) {
        serversFragment.loadServers();
        return Unit.INSTANCE;
    }

    /* JADX INFO: finally extract failed */
    /* JADX WARNING: Code restructure failed: missing block: B:101:0x0185, code lost:
        throw r14;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:102:0x0186, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:103:0x0187, code lost:
        r14 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:105:0x0189, code lost:
        throw r14;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:106:0x018a, code lost:
        android.util.Log.w(TAG, "No FRP params available for retry or server mismatch");
        r15 = r13.frpLock;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:107:0x0193, code lost:
        monitor-enter(r15);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:109:?, code lost:
        r13.isReconnecting = false;
        r0 = kotlin.Unit.INSTANCE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:110:0x0198, code lost:
        monitor-exit(r15);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:111:0x0199, code lost:
        r15 = r13.serverRepository;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:112:0x019b, code lost:
        if (r15 != null) goto L_0x01a4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:113:0x019d, code lost:
        kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("serverRepository");
        r3 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:114:0x01a4, code lost:
        r3 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:115:0x01a5, code lost:
        com.armmc.app.ui.servers.ServerRepository.updateTunnelStatus$default(r3, r14, com.armmc.app.ui.servers.TunnelStatus.FAILED, 0, 4, (java.lang.Object) null);
        runOnUiThreadSafe(new com.armmc.app.ui.servers.ServersFragment$$ExternalSyntheticLambda21(r13));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:116:0x01b6, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:117:0x01b7, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:120:0x01ba, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x007e, code lost:
        r1 = r13.currentFrpParams;
        r2 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0081, code lost:
        if (r1 == null) goto L_0x018a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0087, code lost:
        if (r1.getServerId() == r14) goto L_0x008b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x008b, code lost:
        r0 = r13.currentlyRunningServerId;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x008d, code lost:
        if (r0 != null) goto L_0x0090;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0094, code lost:
        if (r0.intValue() == r14) goto L_0x00bd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x0096, code lost:
        android.util.Log.d(TAG, "Server " + r14 + " is no longer running, not retrying FRP");
        r14 = r13.frpLock;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00b2, code lost:
        monitor-enter(r14);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:?, code lost:
        r13.isReconnecting = false;
        r15 = kotlin.Unit.INSTANCE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00b7, code lost:
        monitor-exit(r14);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00b8, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00b9, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00bc, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00bd, code lost:
        r3 = new kotlin.jvm.internal.Ref.IntRef();
        r5 = r13.frpLock;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00c4, code lost:
        monitor-enter(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:?, code lost:
        r3.element = r13.currentRetryAttempt + 1;
        r13.currentRetryAttempt = r3.element;
        r0 = kotlin.Unit.INSTANCE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x00d0, code lost:
        monitor-exit(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x00d4, code lost:
        if (r3.element <= 3) goto L_0x0108;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x00d6, code lost:
        android.util.Log.e(TAG, "FRP reconnection failed after 3 attempts");
        r15 = r13.frpLock;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x00df, code lost:
        monitor-enter(r15);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:?, code lost:
        r13.isReconnecting = false;
        r13.currentRetryAttempt = 0;
        r0 = kotlin.Unit.INSTANCE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x00e6, code lost:
        monitor-exit(r15);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x00e7, code lost:
        r15 = r13.serverRepository;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x00e9, code lost:
        if (r15 != null) goto L_0x00f1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x00eb, code lost:
        kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("serverRepository");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x00f1, code lost:
        r2 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x00f2, code lost:
        r2.updateTunnelInfo(r14, r1.getTunnelAddress(), com.armmc.app.ui.servers.TunnelStatus.FAILED, 3);
        runOnUiThreadSafe(new com.armmc.app.ui.servers.ServersFragment$$ExternalSyntheticLambda23(r13));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x0103, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x0104, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x0107, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x0108, code lost:
        android.util.Log.i(TAG, "FRP disconnected, attempting reconnection (" + r3.element + "/3)");
        r0 = r13.serverRepository;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x0126, code lost:
        if (r0 != null) goto L_0x012e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x0128, code lost:
        kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("serverRepository");
        r0 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x012e, code lost:
        r0.updateTunnelInfo(r14, r1.getTunnelAddress(), com.armmc.app.ui.servers.TunnelStatus.RECONNECTING, r3.element);
        runOnUiThreadSafe(new com.armmc.app.ui.servers.ServersFragment$$ExternalSyntheticLambda24(r13, r3));
        r5 = r13.frpLock;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x0143, code lost:
        monitor-enter(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:?, code lost:
        r13.isIntentionallyStopping = true;
        r15 = kotlin.Unit.INSTANCE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x0148, code lost:
        monitor-exit(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:?, code lost:
        r15 = r13.frpClient;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x014b, code lost:
        if (r15 == null) goto L_0x0150;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x014d, code lost:
        r15.setStatusListener((kotlin.jvm.functions.Function2<? super java.lang.Integer, ? super java.lang.String, kotlin.Unit>) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x0150, code lost:
        r15 = r13.frpClient;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x0152, code lost:
        if (r15 == null) goto L_0x0163;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x0154, code lost:
        r15.stop();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x0158, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:0x0159, code lost:
        android.util.Log.e(TAG, "Error stopping FRP client during retry", r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:98:0x0182, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:99:0x0183, code lost:
        r14 = r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void handleFrpDisconnection(int r14, java.lang.String r15) {
        /*
            r13 = this;
            java.lang.String r15 = "Connection was stable for "
            java.lang.String r0 = "Ignoring retry request - too soon ("
            long r1 = java.lang.System.currentTimeMillis()
            java.lang.Object r3 = r13.frpLock
            monitor-enter(r3)
            boolean r4 = r13.isIntentionallyStopping     // Catch:{ all -> 0x01bb }
            if (r4 == 0) goto L_0x0018
            java.lang.String r14 = "ServersFragment"
            java.lang.String r15 = "Intentionally stopping, not retrying"
            android.util.Log.d(r14, r15)     // Catch:{ all -> 0x01bb }
            monitor-exit(r3)
            return
        L_0x0018:
            boolean r4 = r13.isReconnecting     // Catch:{ all -> 0x01bb }
            if (r4 == 0) goto L_0x0025
            java.lang.String r14 = "ServersFragment"
            java.lang.String r15 = "Already handling disconnection, ignoring duplicate"
            android.util.Log.d(r14, r15)     // Catch:{ all -> 0x01bb }
            monitor-exit(r3)
            return
        L_0x0025:
            long r4 = r13.lastRetryTimestamp     // Catch:{ all -> 0x01bb }
            long r6 = r1 - r4
            r8 = 5000(0x1388, double:2.4703E-320)
            int r10 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            r11 = 0
            if (r10 >= 0) goto L_0x004f
            int r4 = (r4 > r11 ? 1 : (r4 == r11 ? 0 : -1))
            if (r4 <= 0) goto L_0x004f
            java.lang.String r14 = "ServersFragment"
            java.lang.StringBuilder r15 = new java.lang.StringBuilder     // Catch:{ all -> 0x01bb }
            r15.<init>(r0)     // Catch:{ all -> 0x01bb }
            java.lang.StringBuilder r15 = r15.append(r6)     // Catch:{ all -> 0x01bb }
            java.lang.String r0 = "ms since last retry)"
            java.lang.StringBuilder r15 = r15.append(r0)     // Catch:{ all -> 0x01bb }
            java.lang.String r15 = r15.toString()     // Catch:{ all -> 0x01bb }
            android.util.Log.d(r14, r15)     // Catch:{ all -> 0x01bb }
            monitor-exit(r3)
            return
        L_0x004f:
            long r4 = r13.connectionEstablishedTimestamp     // Catch:{ all -> 0x01bb }
            long r6 = r1 - r4
            int r0 = (r4 > r11 ? 1 : (r4 == r11 ? 0 : -1))
            r4 = 0
            if (r0 <= 0) goto L_0x0076
            int r0 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r0 < 0) goto L_0x0076
            java.lang.String r0 = "ServersFragment"
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x01bb }
            r5.<init>(r15)     // Catch:{ all -> 0x01bb }
            java.lang.StringBuilder r15 = r5.append(r6)     // Catch:{ all -> 0x01bb }
            java.lang.String r5 = "ms, resetting retry counter"
            java.lang.StringBuilder r15 = r15.append(r5)     // Catch:{ all -> 0x01bb }
            java.lang.String r15 = r15.toString()     // Catch:{ all -> 0x01bb }
            android.util.Log.d(r0, r15)     // Catch:{ all -> 0x01bb }
            r13.currentRetryAttempt = r4     // Catch:{ all -> 0x01bb }
        L_0x0076:
            r15 = 1
            r13.isReconnecting = r15     // Catch:{ all -> 0x01bb }
            r13.lastRetryTimestamp = r1     // Catch:{ all -> 0x01bb }
            kotlin.Unit r0 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x01bb }
            monitor-exit(r3)
            com.armmc.app.ui.servers.ServersFragment$FrpConnectionParams r1 = r13.currentFrpParams
            r2 = 0
            if (r1 == 0) goto L_0x018a
            int r0 = r1.getServerId()
            if (r0 == r14) goto L_0x008b
            goto L_0x018a
        L_0x008b:
            java.lang.Integer r0 = r13.currentlyRunningServerId
            if (r0 != 0) goto L_0x0090
            goto L_0x0096
        L_0x0090:
            int r0 = r0.intValue()
            if (r0 == r14) goto L_0x00bd
        L_0x0096:
            java.lang.String r15 = "ServersFragment"
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "Server "
            r0.<init>(r1)
            java.lang.StringBuilder r14 = r0.append(r14)
            java.lang.String r0 = " is no longer running, not retrying FRP"
            java.lang.StringBuilder r14 = r14.append(r0)
            java.lang.String r14 = r14.toString()
            android.util.Log.d(r15, r14)
            java.lang.Object r14 = r13.frpLock
            monitor-enter(r14)
            r13.isReconnecting = r4     // Catch:{ all -> 0x00b9 }
            kotlin.Unit r15 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x00b9 }
            monitor-exit(r14)
            return
        L_0x00b9:
            r0 = move-exception
            r15 = r0
            monitor-exit(r14)
            throw r15
        L_0x00bd:
            kotlin.jvm.internal.Ref$IntRef r3 = new kotlin.jvm.internal.Ref$IntRef
            r3.<init>()
            java.lang.Object r5 = r13.frpLock
            monitor-enter(r5)
            int r0 = r13.currentRetryAttempt     // Catch:{ all -> 0x0186 }
            int r0 = r0 + r15
            r3.element = r0     // Catch:{ all -> 0x0186 }
            int r0 = r3.element     // Catch:{ all -> 0x0186 }
            r13.currentRetryAttempt = r0     // Catch:{ all -> 0x0186 }
            kotlin.Unit r0 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0186 }
            monitor-exit(r5)
            int r0 = r3.element
            r5 = 3
            if (r0 <= r5) goto L_0x0108
            java.lang.String r15 = "ServersFragment"
            java.lang.String r0 = "FRP reconnection failed after 3 attempts"
            android.util.Log.e(r15, r0)
            java.lang.Object r15 = r13.frpLock
            monitor-enter(r15)
            r13.isReconnecting = r4     // Catch:{ all -> 0x0104 }
            r13.currentRetryAttempt = r4     // Catch:{ all -> 0x0104 }
            kotlin.Unit r0 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0104 }
            monitor-exit(r15)
            com.armmc.app.ui.servers.ServerRepository r15 = r13.serverRepository
            if (r15 != 0) goto L_0x00f1
            java.lang.String r15 = "serverRepository"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r15)
            goto L_0x00f2
        L_0x00f1:
            r2 = r15
        L_0x00f2:
            java.lang.String r15 = r1.getTunnelAddress()
            com.armmc.app.ui.servers.TunnelStatus r0 = com.armmc.app.ui.servers.TunnelStatus.FAILED
            r2.updateTunnelInfo(r14, r15, r0, r5)
            com.armmc.app.ui.servers.ServersFragment$$ExternalSyntheticLambda23 r14 = new com.armmc.app.ui.servers.ServersFragment$$ExternalSyntheticLambda23
            r14.<init>(r13)
            r13.runOnUiThreadSafe(r14)
            return
        L_0x0104:
            r0 = move-exception
            r14 = r0
            monitor-exit(r15)
            throw r14
        L_0x0108:
            java.lang.String r0 = "ServersFragment"
            int r5 = r3.element
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            java.lang.String r7 = "FRP disconnected, attempting reconnection ("
            r6.<init>(r7)
            java.lang.StringBuilder r5 = r6.append(r5)
            java.lang.String r6 = "/3)"
            java.lang.StringBuilder r5 = r5.append(r6)
            java.lang.String r5 = r5.toString()
            android.util.Log.i(r0, r5)
            com.armmc.app.ui.servers.ServerRepository r0 = r13.serverRepository
            if (r0 != 0) goto L_0x012e
            java.lang.String r0 = "serverRepository"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r0)
            r0 = r2
        L_0x012e:
            java.lang.String r5 = r1.getTunnelAddress()
            com.armmc.app.ui.servers.TunnelStatus r6 = com.armmc.app.ui.servers.TunnelStatus.RECONNECTING
            int r7 = r3.element
            r0.updateTunnelInfo(r14, r5, r6, r7)
            com.armmc.app.ui.servers.ServersFragment$$ExternalSyntheticLambda24 r0 = new com.armmc.app.ui.servers.ServersFragment$$ExternalSyntheticLambda24
            r0.<init>(r13, r3)
            r13.runOnUiThreadSafe(r0)
            java.lang.Object r5 = r13.frpLock
            monitor-enter(r5)
            r13.isIntentionallyStopping = r15     // Catch:{ all -> 0x0182 }
            kotlin.Unit r15 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0182 }
            monitor-exit(r5)
            com.armmc.app.frp.FRPClient r15 = r13.frpClient     // Catch:{ Exception -> 0x0158 }
            if (r15 == 0) goto L_0x0150
            r15.setStatusListener(r2)     // Catch:{ Exception -> 0x0158 }
        L_0x0150:
            com.armmc.app.frp.FRPClient r15 = r13.frpClient     // Catch:{ Exception -> 0x0158 }
            if (r15 == 0) goto L_0x0163
            r15.stop()     // Catch:{ Exception -> 0x0158 }
            goto L_0x0163
        L_0x0158:
            r0 = move-exception
            r15 = r0
            java.lang.String r0 = "ServersFragment"
            java.lang.String r5 = "Error stopping FRP client during retry"
            java.lang.Throwable r15 = (java.lang.Throwable) r15
            android.util.Log.e(r0, r5, r15)
        L_0x0163:
            java.lang.Object r15 = r13.frpLock
            monitor-enter(r15)
            r13.frpClient = r2     // Catch:{ all -> 0x017e }
            r13.isIntentionallyStopping = r4     // Catch:{ all -> 0x017e }
            kotlin.Unit r0 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x017e }
            monitor-exit(r15)
            com.armmc.app.ui.servers.ServersFragment$$ExternalSyntheticLambda25 r9 = new com.armmc.app.ui.servers.ServersFragment$$ExternalSyntheticLambda25
            r9.<init>(r3, r13, r14, r1)
            r10 = 31
            r11 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            kotlin.concurrent.ThreadsKt.thread$default(r4, r5, r6, r7, r8, r9, r10, r11)
            return
        L_0x017e:
            r0 = move-exception
            r14 = r0
            monitor-exit(r15)
            throw r14
        L_0x0182:
            r0 = move-exception
            r14 = r0
            monitor-exit(r5)
            throw r14
        L_0x0186:
            r0 = move-exception
            r14 = r0
            monitor-exit(r5)
            throw r14
        L_0x018a:
            java.lang.String r15 = "ServersFragment"
            java.lang.String r0 = "No FRP params available for retry or server mismatch"
            android.util.Log.w(r15, r0)
            java.lang.Object r15 = r13.frpLock
            monitor-enter(r15)
            r13.isReconnecting = r4     // Catch:{ all -> 0x01b7 }
            kotlin.Unit r0 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x01b7 }
            monitor-exit(r15)
            com.armmc.app.ui.servers.ServerRepository r15 = r13.serverRepository
            if (r15 != 0) goto L_0x01a4
            java.lang.String r15 = "serverRepository"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r15)
            r3 = r2
            goto L_0x01a5
        L_0x01a4:
            r3 = r15
        L_0x01a5:
            com.armmc.app.ui.servers.TunnelStatus r5 = com.armmc.app.ui.servers.TunnelStatus.FAILED
            r7 = 4
            r8 = 0
            r6 = 0
            r4 = r14
            com.armmc.app.ui.servers.ServerRepository.updateTunnelStatus$default(r3, r4, r5, r6, r7, r8)
            com.armmc.app.ui.servers.ServersFragment$$ExternalSyntheticLambda21 r14 = new com.armmc.app.ui.servers.ServersFragment$$ExternalSyntheticLambda21
            r14.<init>(r13)
            r13.runOnUiThreadSafe(r14)
            return
        L_0x01b7:
            r0 = move-exception
            r14 = r0
            monitor-exit(r15)
            throw r14
        L_0x01bb:
            r0 = move-exception
            r14 = r0
            monitor-exit(r3)
            throw r14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.armmc.app.ui.servers.ServersFragment.handleFrpDisconnection(int, java.lang.String):void");
    }

    /* access modifiers changed from: private */
    public static final Unit handleFrpDisconnection$lambda$57(ServersFragment serversFragment) {
        serversFragment.loadServers();
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit handleFrpDisconnection$lambda$61(ServersFragment serversFragment) {
        serversFragment.loadServers();
        Toast.makeText(serversFragment.getContext(), "Tunnel connection lost. Failed to reconnect after 3 attempts.", 1).show();
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit handleFrpDisconnection$lambda$62(ServersFragment serversFragment, Ref.IntRef intRef) {
        serversFragment.loadServers();
        Toast.makeText(serversFragment.getContext(), "Tunnel lost. Reconnecting (" + intRef.element + "/3)...", 0).show();
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0033, code lost:
        r0 = r10.currentlyRunningServerId;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0035, code lost:
        if (r0 != null) goto L_0x0038;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x003c, code lost:
        if (r0.intValue() == r11) goto L_0x0067;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x003e, code lost:
        android.util.Log.d(TAG, "Server " + r11 + " is no longer running after delay, cancelling retry");
        r9 = r10.frpLock;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x005a, code lost:
        monitor-enter(r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:?, code lost:
        r10.isReconnecting = false;
        r10 = kotlin.Unit.INSTANCE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x005f, code lost:
        monitor-exit(r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0062, code lost:
        return kotlin.Unit.INSTANCE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0063, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0066, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0067, code lost:
        r10.startFRPClientWithRetry(r12.getServerId(), r12.getLocalPort(), r12.getServerAddr(), r12.getServerPort(), r12.getAuthToken(), r12.getRemotePort(), r12.getTunnelAddress(), r9.element);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x008b, code lost:
        return kotlin.Unit.INSTANCE;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final kotlin.Unit handleFrpDisconnection$lambda$67(kotlin.jvm.internal.Ref.IntRef r9, com.armmc.app.ui.servers.ServersFragment r10, int r11, com.armmc.app.ui.servers.ServersFragment.FrpConnectionParams r12) {
        /*
            java.lang.String r0 = "ServersFragment"
            int r1 = r9.element
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "Waiting 10s before retry attempt "
            r2.<init>(r3)
            java.lang.StringBuilder r1 = r2.append(r1)
            java.lang.String r1 = r1.toString()
            android.util.Log.i(r0, r1)
            r0 = 10000(0x2710, double:4.9407E-320)
            java.lang.Thread.sleep(r0)
            java.lang.Object r1 = r10.frpLock
            monitor-enter(r1)
            boolean r0 = r10.isIntentionallyStopping     // Catch:{ all -> 0x008c }
            r2 = 0
            if (r0 == 0) goto L_0x0030
            java.lang.String r9 = "ServersFragment"
            java.lang.String r11 = "Retry cancelled during wait - intentionally stopping"
            android.util.Log.d(r9, r11)     // Catch:{ all -> 0x008c }
            r10.isReconnecting = r2     // Catch:{ all -> 0x008c }
            kotlin.Unit r9 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x008c }
            monitor-exit(r1)
            return r9
        L_0x0030:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x008c }
            monitor-exit(r1)
            java.lang.Integer r0 = r10.currentlyRunningServerId
            if (r0 != 0) goto L_0x0038
            goto L_0x003e
        L_0x0038:
            int r0 = r0.intValue()
            if (r0 == r11) goto L_0x0067
        L_0x003e:
            java.lang.String r9 = "ServersFragment"
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            java.lang.String r0 = "Server "
            r12.<init>(r0)
            java.lang.StringBuilder r11 = r12.append(r11)
            java.lang.String r12 = " is no longer running after delay, cancelling retry"
            java.lang.StringBuilder r11 = r11.append(r12)
            java.lang.String r11 = r11.toString()
            android.util.Log.d(r9, r11)
            java.lang.Object r9 = r10.frpLock
            monitor-enter(r9)
            r10.isReconnecting = r2     // Catch:{ all -> 0x0063 }
            kotlin.Unit r10 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0063 }
            monitor-exit(r9)
            kotlin.Unit r9 = kotlin.Unit.INSTANCE
            return r9
        L_0x0063:
            r0 = move-exception
            r10 = r0
            monitor-exit(r9)
            throw r10
        L_0x0067:
            int r1 = r12.getServerId()
            int r2 = r12.getLocalPort()
            java.lang.String r3 = r12.getServerAddr()
            int r4 = r12.getServerPort()
            java.lang.String r5 = r12.getAuthToken()
            int r6 = r12.getRemotePort()
            java.lang.String r7 = r12.getTunnelAddress()
            int r8 = r9.element
            r0 = r10
            r0.startFRPClientWithRetry(r1, r2, r3, r4, r5, r6, r7, r8)
            kotlin.Unit r9 = kotlin.Unit.INSTANCE
            return r9
        L_0x008c:
            r0 = move-exception
            r9 = r0
            monitor-exit(r1)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.armmc.app.ui.servers.ServersFragment.handleFrpDisconnection$lambda$67(kotlin.jvm.internal.Ref$IntRef, com.armmc.app.ui.servers.ServersFragment, int, com.armmc.app.ui.servers.ServersFragment$FrpConnectionParams):kotlin.Unit");
    }

    private final void stopFRPClient() {
        synchronized (this.frpLock) {
            this.isIntentionallyStopping = true;
            this.isReconnecting = false;
            this.currentRetryAttempt = 0;
            this.lastRetryTimestamp = 0;
            this.connectionEstablishedTimestamp = 0;
            Unit unit = Unit.INSTANCE;
        }
        try {
            FRPClient fRPClient = this.frpClient;
            if (fRPClient != null) {
                fRPClient.setStatusListener((Function2<? super Integer, ? super String, Unit>) null);
                if (fRPClient.isRunning()) {
                    if (fRPClient.stop()) {
                        Log.i(TAG, "FRP client stopped successfully");
                    } else {
                        Log.e(TAG, "Failed to stop FRP client: " + fRPClient.getLastError());
                    }
                }
            }
            synchronized (this.frpLock) {
                this.frpClient = null;
                Unit unit2 = Unit.INSTANCE;
            }
            this.currentTunnelAddress = null;
        } catch (Exception e) {
            try {
                Log.e(TAG, "Error stopping FRP client", e);
                synchronized (this.frpLock) {
                    this.frpClient = null;
                    Unit unit3 = Unit.INSTANCE;
                    this.currentTunnelAddress = null;
                }
            } catch (Throwable th) {
                synchronized (this.frpLock) {
                    this.frpClient = null;
                    Unit unit4 = Unit.INSTANCE;
                    this.currentTunnelAddress = null;
                    throw th;
                }
            }
        }
    }

    private final void terminateTunnelOnServer() {
        ThreadsKt.thread$default(false, false, (ClassLoader) null, (String) null, 0, new ServersFragment$$ExternalSyntheticLambda36(this), 31, (Object) null);
    }

    /* access modifiers changed from: private */
    public static final Unit terminateTunnelOnServer$lambda$71(ServersFragment serversFragment) {
        try {
            FirebaseAuth firebaseAuth = serversFragment.auth;
            if (firebaseAuth == null) {
                Intrinsics.throwUninitializedPropertyAccessException("auth");
                firebaseAuth = null;
            }
            FirebaseUser currentUser = firebaseAuth.getCurrentUser();
            if (currentUser == null) {
                Log.d(TAG, "No user logged in, skipping tunnel termination");
                return Unit.INSTANCE;
            }
            Task idToken = currentUser.getIdToken(false);
            Intrinsics.checkNotNullExpressionValue(idToken, "getIdToken(...)");
            String token = ((GetTokenResult) Tasks.await(idToken)).getToken();
            if (token != null) {
                Log.d(TAG, "Terminating tunnel on server...");
                TunnelApiService.TunnelTerminateResponse terminateTunnel = serversFragment.tunnelApiService.terminateTunnel(token);
                if (terminateTunnel.getSuccess()) {
                    Log.i(TAG, "Tunnel terminated successfully: " + terminateTunnel.getMessage());
                } else {
                    Log.e(TAG, "Failed to terminate tunnel: " + terminateTunnel.getError());
                }
            }
            return Unit.INSTANCE;
        } catch (Exception e) {
            Log.e(TAG, "Error terminating tunnel", e);
        }
    }

    /* access modifiers changed from: private */
    public final void handleServerProcessCrash(String str) {
        if (this.stoppedViaNotification) {
            Log.d(TAG, "Ignoring process death - server was stopped intentionally via notification");
            this.stoppedViaNotification = false;
            return;
        }
        Integer num = this.currentlyRunningServerId;
        if (num != null) {
            int intValue = num.intValue();
            ServerRepository serverRepository2 = this.serverRepository;
            if (serverRepository2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("serverRepository");
                serverRepository2 = null;
            }
            ServerData serverById = serverRepository2.getServerById(intValue);
            if (serverById == null || serverById.isOnline()) {
                Log.e(TAG, "Handling server process crash for server " + intValue + ": " + str);
                LogManager.INSTANCE.addCrashLog(str);
                ResourceMonitor.INSTANCE.stopMonitoring(intValue);
                synchronized (this.frpLock) {
                    this.currentFrpParams = null;
                    this.isReconnecting = false;
                    this.currentRetryAttempt = 0;
                    Unit unit = Unit.INSTANCE;
                }
                stopFRPClient();
                terminateTunnelOnServer();
                ServerRepository serverRepository3 = this.serverRepository;
                if (serverRepository3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("serverRepository");
                    serverRepository3 = null;
                }
                serverRepository3.resetTunnelState(intValue);
                ServerRepository serverRepository4 = this.serverRepository;
                if (serverRepository4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("serverRepository");
                    serverRepository4 = null;
                }
                serverRepository4.updateServerStatus(intValue, false);
                this.currentlyRunningServerId = null;
                this.stoppingServers.remove(Integer.valueOf(intValue));
                if (this.isBoundToService) {
                    try {
                        Context context = getContext();
                        if (context != null) {
                            context.unbindService(this.serviceConnection);
                        }
                    } catch (Exception unused) {
                    }
                    this.isBoundToService = false;
                }
                runOnUiThreadSafe(new ServersFragment$$ExternalSyntheticLambda4(this));
                return;
            }
            Log.d(TAG, "Ignoring process death - server " + intValue + " already marked offline (intentional stop)");
            this.currentlyRunningServerId = null;
            this.stoppingServers.remove(Integer.valueOf(intValue));
            if (isAdded()) {
                loadServers();
            }
        }
    }

    /* access modifiers changed from: private */
    public static final Unit handleServerProcessCrash$lambda$73(ServersFragment serversFragment) {
        serversFragment.loadServers();
        Toast.makeText(serversFragment.getContext(), "Server crashed and was stopped. Check Logs for details.", 1).show();
        return Unit.INSTANCE;
    }

    private final void stopServer(ServerData serverData) {
        ReviewHelper reviewHelper2;
        this.stoppingServers.add(Integer.valueOf(serverData.getId()));
        ResourceMonitor.INSTANCE.stopMonitoring(serverData.getId());
        synchronized (this.frpLock) {
            reviewHelper2 = null;
            this.currentFrpParams = null;
            this.isReconnecting = false;
            this.currentRetryAttempt = 0;
            Unit unit = Unit.INSTANCE;
        }
        stopFRPClient();
        terminateTunnelOnServer();
        ServerRepository serverRepository2 = this.serverRepository;
        if (serverRepository2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("serverRepository");
            serverRepository2 = null;
        }
        serverRepository2.resetTunnelState(serverData.getId());
        this.stoppedViaNotification = true;
        if (this.isBoundToService) {
            try {
                requireContext().unbindService(this.serviceConnection);
            } catch (Exception e) {
                Log.w(TAG, "Error unbinding from PumpkinService", e);
            }
            this.isBoundToService = false;
        }
        try {
            Intent intent = new Intent(requireContext(), PumpkinService.class);
            intent.setAction(PumpkinService.ACTION_STOP_SERVER);
            Comparable startService = requireContext().startService(intent);
        } catch (Exception e2) {
            Log.w(TAG, "Failed to send stop action to service, falling back to stopService", e2);
            requireContext().stopService(new Intent(requireContext(), PumpkinService.class));
        }
        this.currentlyRunningServerId = null;
        this.stoppingServers.remove(Integer.valueOf(serverData.getId()));
        FragmentActivity activity = getActivity();
        if (activity != null) {
            ReviewHelper reviewHelper3 = this.reviewHelper;
            if (reviewHelper3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("reviewHelper");
            } else {
                reviewHelper2 = reviewHelper3;
            }
            reviewHelper2.recordServerStop(activity);
        }
    }

    private final void killServerProcess() {
        try {
            Context context = getContext();
            if (context != null) {
                Object systemService = context.getSystemService("activity");
                Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.ActivityManager");
                List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) systemService).getRunningAppProcesses();
                if (runningAppProcesses != null) {
                    for (ActivityManager.RunningAppProcessInfo next : runningAppProcesses) {
                        String str = next.processName;
                        Intrinsics.checkNotNullExpressionValue(str, "processName");
                        if (StringsKt.endsWith$default(str, ":pumpkin_server", false, 2, (Object) null)) {
                            Process.killProcess(next.pid);
                            return;
                        }
                    }
                }
            }
        } catch (Exception unused) {
        }
    }

    private final void deleteServer(ServerData serverData) {
        new AlertDialog.Builder(requireContext()).setTitle((CharSequence) "Delete Server").setMessage((CharSequence) "Are you sure you want to delete " + serverData.getName() + "? This will permanently delete all server data.").setPositiveButton((CharSequence) "Delete", (DialogInterface.OnClickListener) new ServersFragment$$ExternalSyntheticLambda10(serverData, this)).setNegativeButton((CharSequence) "Cancel", (DialogInterface.OnClickListener) null).show();
    }

    /* access modifiers changed from: private */
    public static final void deleteServer$lambda$77(ServerData serverData, ServersFragment serversFragment, DialogInterface dialogInterface, int i) {
        if (serverData.isOnline()) {
            serversFragment.stopServer(serverData);
        }
        String absolutePath = serversFragment.requireContext().getFilesDir().getAbsolutePath();
        File file = new File(absolutePath + "/server_" + serverData.getId());
        if (file.exists()) {
            FilesKt.deleteRecursively(file);
        }
        ServerRepository serverRepository2 = serversFragment.serverRepository;
        if (serverRepository2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("serverRepository");
            serverRepository2 = null;
        }
        serverRepository2.deleteServer(serverData.getId());
        Toast.makeText(serversFragment.getContext(), "Deleted " + serverData.getName(), 0).show();
        serversFragment.loadServers();
    }

    private final String extractVersionFromLibraryKey(String str) {
        CharSequence charSequence = str;
        if (!(charSequence == null || charSequence.length() == 0)) {
            try {
                return "Pumpkin " + StringsKt.replace$default(StringsKt.removePrefix(str, (CharSequence) "pumpkin_"), "_", ".", false, 4, (Object) null);
            } catch (Exception unused) {
            }
        }
        return null;
    }

    private final void setupRecyclerView() {
        RecyclerView recyclerView = this.serversRecyclerView;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("serversRecyclerView");
            recyclerView = null;
        }
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        loadServers();
    }
}
