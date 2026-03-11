package com.armmc.app;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.activity.EdgeToEdge;
import androidx.activity.SystemBarStyle;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.customview.widget.Openable;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.navigation.ActivityKt;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.NavOptions;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.BottomNavigationViewKt;
import androidx.navigation.ui.NavControllerKt;
import com.armmc.app.announcements.Announcement;
import com.armmc.app.announcements.AnnouncementDialog;
import com.armmc.app.announcements.AnnouncementManager;
import com.armmc.app.billing.BillingManager;
import com.armmc.app.databinding.ActivityMainBinding;
import com.armmc.app.tunnel.TunnelRegion;
import com.armmc.app.tunnel.TunnelRegionManager;
import com.armmc.app.ui.onboarding.OnboardingFragment;
import com.armmc.app.ui.profile.SubscriptionFragment;
import com.google.android.material.R;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.card.MaterialCardView;
import com.google.android.play.core.splitcompat.SplitCompat;
import com.google.firebase.auth.FirebaseAuth;
import io.grpc.internal.GrpcUtil;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.concurrent.ThreadsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0014J\u0012\u0010\u001b\u001a\u00020\u00182\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0014J\b\u0010\u001e\u001a\u00020\u0018H\u0002J\b\u0010!\u001a\u00020\u0018H\u0014J\b\u0010\"\u001a\u00020\u0018H\u0014J)\u0010#\u001a\u0004\u0018\u00010$2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u00152\b\b\u0002\u0010(\u001a\u00020\u0015H\u0002¢\u0006\u0002\u0010)J\b\u0010*\u001a\u00020\u0018H\u0002J\b\u0010+\u001a\u00020\u0018H\u0002J\b\u0010,\u001a\u00020\u0018H\u0002J\b\u0010-\u001a\u00020.H\u0016J\n\u0010/\u001a\u0004\u0018\u00010\u0010H\u0016J\b\u00100\u001a\u00020\u0018H\u0014R\u000e\u0010\u0005\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX.¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX.¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX.¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX.¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u0004¢\u0006\u0002\n\u0000¨\u00061"}, d2 = {"Lcom/armmc/app/MainActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "Lcom/armmc/app/ui/profile/SubscriptionFragment$BillingManagerProvider;", "<init>", "()V", "appBarConfiguration", "Landroidx/navigation/ui/AppBarConfiguration;", "binding", "Lcom/armmc/app/databinding/ActivityMainBinding;", "auth", "Lcom/google/firebase/auth/FirebaseAuth;", "announcementManager", "Lcom/armmc/app/announcements/AnnouncementManager;", "tunnelRegionManager", "Lcom/armmc/app/tunnel/TunnelRegionManager;", "billingManager", "Lcom/armmc/app/billing/BillingManager;", "pendingAnnouncements", "", "Lcom/armmc/app/announcements/Announcement;", "systemBottomInset", "", "systemTopInset", "attachBaseContext", "", "newBase", "Landroid/content/Context;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "updateTunnelRegionButtonLabel", "authStateListener", "Lcom/google/firebase/auth/FirebaseAuth$AuthStateListener;", "onStart", "onStop", "measureTcpPingMs", "", "host", "", "port", "timeout", "(Ljava/lang/String;II)Ljava/lang/Long;", "showTunnelRegionDialog", "checkForAnnouncements", "showNextAnnouncement", "onSupportNavigateUp", "", "getBillingManager", "onDestroy", "app_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* compiled from: MainActivity.kt */
public final class MainActivity extends AppCompatActivity implements SubscriptionFragment.BillingManagerProvider {
    /* access modifiers changed from: private */
    public AnnouncementManager announcementManager;
    private AppBarConfiguration appBarConfiguration;
    private FirebaseAuth auth;
    private final FirebaseAuth.AuthStateListener authStateListener = new MainActivity$$ExternalSyntheticLambda0(this);
    private BillingManager billingManager;
    private ActivityMainBinding binding;
    /* access modifiers changed from: private */
    public List<Announcement> pendingAnnouncements = new ArrayList();
    private int systemBottomInset;
    private int systemTopInset;
    private TunnelRegionManager tunnelRegionManager;

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    /* compiled from: MainActivity.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        /* JADX WARNING: Can't wrap try/catch for region: R(11:0|1|2|3|4|5|6|7|8|9|11) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0022 */
        static {
            /*
                com.armmc.app.tunnel.TunnelRegion[] r0 = com.armmc.app.tunnel.TunnelRegion.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.armmc.app.tunnel.TunnelRegion r1 = com.armmc.app.tunnel.TunnelRegion.EUROPE     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                com.armmc.app.tunnel.TunnelRegion r1 = com.armmc.app.tunnel.TunnelRegion.LOCAL     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                com.armmc.app.tunnel.TunnelRegion r1 = com.armmc.app.tunnel.TunnelRegion.AMERICA     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                com.armmc.app.tunnel.TunnelRegion r1 = com.armmc.app.tunnel.TunnelRegion.ASIA     // Catch:{ NoSuchFieldError -> 0x002b }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002b }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002b }
            L_0x002b:
                $EnumSwitchMapping$0 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.armmc.app.MainActivity.WhenMappings.<clinit>():void");
        }
    }

    /* access modifiers changed from: protected */
    public void attachBaseContext(Context context) {
        super.attachBaseContext(context);
        SplitCompat.installActivity(this);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        ActivityMainBinding activityMainBinding = null;
        EdgeToEdge.enable$default(this, (SystemBarStyle) null, (SystemBarStyle) null, 3, (Object) null);
        super.onCreate(bundle);
        ActivityMainBinding inflate = ActivityMainBinding.inflate(getLayoutInflater());
        this.binding = inflate;
        if (inflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            inflate = null;
        }
        setContentView((View) inflate.getRoot());
        ActivityMainBinding activityMainBinding2 = this.binding;
        if (activityMainBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityMainBinding2 = null;
        }
        ViewCompat.setOnApplyWindowInsetsListener(activityMainBinding2.getRoot(), new MainActivity$$ExternalSyntheticLambda8(this));
        this.auth = FirebaseAuth.getInstance();
        Context context = this;
        this.announcementManager = new AnnouncementManager(context);
        this.tunnelRegionManager = new TunnelRegionManager(context);
        this.billingManager = new BillingManager(context, LifecycleOwnerKt.getLifecycleScope(this));
        ActivityMainBinding activityMainBinding3 = this.binding;
        if (activityMainBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityMainBinding3 = null;
        }
        setSupportActionBar(activityMainBinding3.appBarMain.toolbar);
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setDisplayShowTitleEnabled(false);
        }
        NavController findNavController = ActivityKt.findNavController(this, R.id.nav_host_fragment_content_main);
        if (OnboardingFragment.Companion.isOnboardingCompleted(context)) {
            findNavController.navigate(R.id.nav_servers);
        }
        AppBarConfiguration build = new AppBarConfiguration.Builder((Set<Integer>) SetsKt.setOf(Integer.valueOf(R.id.nav_servers), Integer.valueOf(R.id.nav_logs), Integer.valueOf(R.id.nav_files), Integer.valueOf(R.id.nav_profile), Integer.valueOf(R.id.nav_onboarding))).setOpenableLayout((Openable) null).setFallbackOnNavigateUpListener(new MainActivity$inlined$sam$i$androidx_navigation_ui_AppBarConfiguration_OnNavigateUpListener$0(MainActivity$onCreate$$inlined$AppBarConfiguration$default$1.INSTANCE)).build();
        this.appBarConfiguration = build;
        AppCompatActivity appCompatActivity = this;
        if (build == null) {
            Intrinsics.throwUninitializedPropertyAccessException("appBarConfiguration");
            build = null;
        }
        androidx.navigation.ui.ActivityKt.setupActionBarWithNavController(appCompatActivity, findNavController, build);
        ActivityMainBinding activityMainBinding4 = this.binding;
        if (activityMainBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityMainBinding4 = null;
        }
        BottomNavigationView bottomNavigationView = activityMainBinding4.bottomNavigationView;
        Intrinsics.checkNotNullExpressionValue(bottomNavigationView, "bottomNavigationView");
        BottomNavigationViewKt.setupWithNavController(bottomNavigationView, findNavController);
        ActivityMainBinding activityMainBinding5 = this.binding;
        if (activityMainBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityMainBinding5 = null;
        }
        activityMainBinding5.fabCreateServer.setOnClickListener(new MainActivity$$ExternalSyntheticLambda9(findNavController));
        ActivityMainBinding activityMainBinding6 = this.binding;
        if (activityMainBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityMainBinding6 = null;
        }
        activityMainBinding6.appBarMain.discordButton.setOnClickListener(new MainActivity$$ExternalSyntheticLambda10(this));
        updateTunnelRegionButtonLabel();
        ActivityMainBinding activityMainBinding7 = this.binding;
        if (activityMainBinding7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            activityMainBinding = activityMainBinding7;
        }
        activityMainBinding.appBarMain.tunnelRegionButton.setOnClickListener(new MainActivity$$ExternalSyntheticLambda11(this));
        findNavController.addOnDestinationChangedListener(new MainActivity$$ExternalSyntheticLambda1(this));
        checkForAnnouncements();
    }

    /* access modifiers changed from: private */
    public static final WindowInsetsCompat onCreate$lambda$0(MainActivity mainActivity, View view, WindowInsetsCompat windowInsetsCompat) {
        Insets insets = windowInsetsCompat.getInsets(WindowInsetsCompat.Type.systemBars());
        mainActivity.systemBottomInset = insets.bottom;
        mainActivity.systemTopInset = insets.top;
        ActivityMainBinding activityMainBinding = mainActivity.binding;
        ActivityMainBinding activityMainBinding2 = null;
        if (activityMainBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityMainBinding = null;
        }
        AppBarLayout appBarLayout = activityMainBinding.appBarMain.appBarLayout;
        Intrinsics.checkNotNullExpressionValue(appBarLayout, "appBarLayout");
        View view2 = appBarLayout;
        view2.setPadding(view2.getPaddingLeft(), insets.top, view2.getPaddingRight(), view2.getPaddingBottom());
        ActivityMainBinding activityMainBinding3 = mainActivity.binding;
        if (activityMainBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            activityMainBinding2 = activityMainBinding3;
        }
        BottomNavigationView bottomNavigationView = activityMainBinding2.bottomNavigationView;
        Intrinsics.checkNotNullExpressionValue(bottomNavigationView, "bottomNavigationView");
        View view3 = bottomNavigationView;
        view3.setPadding(view3.getPaddingLeft(), view3.getPaddingTop(), view3.getPaddingRight(), insets.bottom);
        return windowInsetsCompat;
    }

    /* access modifiers changed from: private */
    public static final void onCreate$lambda$1(NavController navController, View view) {
        navController.navigate(R.id.nav_create_server, (Bundle) null, new NavOptions.Builder().setEnterAnim(R.anim.slide_in_right).setExitAnim(R.anim.slide_out_left).setPopEnterAnim(R.anim.slide_in_left).setPopExitAnim(R.anim.slide_out_right).build());
    }

    /* access modifiers changed from: private */
    public static final void onCreate$lambda$2(MainActivity mainActivity, View view) {
        mainActivity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://discord.com/invite/3gQW23CXkM")));
    }

    /* access modifiers changed from: private */
    public static final void onCreate$lambda$3(MainActivity mainActivity, View view) {
        mainActivity.showTunnelRegionDialog();
    }

    /* access modifiers changed from: private */
    public static final void onCreate$lambda$4(MainActivity mainActivity, NavController navController, NavDestination navDestination, Bundle bundle) {
        int i;
        Intrinsics.checkNotNullParameter(navController, "<unused var>");
        Intrinsics.checkNotNullParameter(navDestination, "destination");
        boolean z = true;
        int i2 = 0;
        boolean z2 = navDestination.getId() == R.id.nav_servers;
        ActivityMainBinding activityMainBinding = mainActivity.binding;
        ActivityMainBinding activityMainBinding2 = null;
        if (activityMainBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityMainBinding = null;
        }
        activityMainBinding.appBarMain.toolbarLogo.setVisibility(z2 ? 0 : 8);
        ActivityMainBinding activityMainBinding3 = mainActivity.binding;
        if (activityMainBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityMainBinding3 = null;
        }
        activityMainBinding3.appBarMain.toolbarTitle.setVisibility(z2 ? 8 : 0);
        ActivityMainBinding activityMainBinding4 = mainActivity.binding;
        if (activityMainBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityMainBinding4 = null;
        }
        activityMainBinding4.appBarMain.toolbarTitle.setText(navDestination.getLabel());
        boolean z3 = navDestination.getId() == R.id.nav_onboarding || navDestination.getId() == R.id.nav_sign_up || navDestination.getId() == R.id.nav_login || navDestination.getId() == R.id.nav_subscription;
        boolean z4 = z3 || navDestination.getId() == R.id.nav_create_server;
        ActivityMainBinding activityMainBinding5 = mainActivity.binding;
        if (activityMainBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityMainBinding5 = null;
        }
        activityMainBinding5.bottomNavigationView.setVisibility(z4 ? 8 : 0);
        if (z4) {
            ActivityMainBinding activityMainBinding6 = mainActivity.binding;
            if (activityMainBinding6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                activityMainBinding6 = null;
            }
            activityMainBinding6.fabCreateServer.setVisibility(8);
            ActivityMainBinding activityMainBinding7 = mainActivity.binding;
            if (activityMainBinding7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                activityMainBinding7 = null;
            }
            activityMainBinding7.fabGlow.setVisibility(8);
        } else {
            ActivityMainBinding activityMainBinding8 = mainActivity.binding;
            if (activityMainBinding8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                activityMainBinding8 = null;
            }
            activityMainBinding8.fabCreateServer.setVisibility(0);
            ActivityMainBinding activityMainBinding9 = mainActivity.binding;
            if (activityMainBinding9 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                activityMainBinding9 = null;
            }
            activityMainBinding9.fabGlow.setVisibility(0);
            ActivityMainBinding activityMainBinding10 = mainActivity.binding;
            if (activityMainBinding10 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                activityMainBinding10 = null;
            }
            activityMainBinding10.fabCreateServer.setClickable(z2);
            ActivityMainBinding activityMainBinding11 = mainActivity.binding;
            if (activityMainBinding11 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                activityMainBinding11 = null;
            }
            float f = 1.0f;
            activityMainBinding11.fabCreateServer.setAlpha(z2 ? 1.0f : 0.35f);
            ActivityMainBinding activityMainBinding12 = mainActivity.binding;
            if (activityMainBinding12 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                activityMainBinding12 = null;
            }
            View view = activityMainBinding12.fabGlow;
            if (!z2) {
                f = 0.35f;
            }
            view.setAlpha(f);
        }
        ActivityMainBinding activityMainBinding13 = mainActivity.binding;
        if (activityMainBinding13 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityMainBinding13 = null;
        }
        activityMainBinding13.appBarMain.toolbar.setVisibility(z3 ? 8 : 0);
        ActivityMainBinding activityMainBinding14 = mainActivity.binding;
        if (activityMainBinding14 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityMainBinding14 = null;
        }
        AppBarLayout appBarLayout = activityMainBinding14.appBarMain.appBarLayout;
        Intrinsics.checkNotNullExpressionValue(appBarLayout, "appBarLayout");
        View view2 = appBarLayout;
        view2.setPadding(view2.getPaddingLeft(), z3 ? 0 : mainActivity.systemTopInset, view2.getPaddingRight(), view2.getPaddingBottom());
        View findViewById = mainActivity.findViewById(R.id.nav_host_fragment_content_main);
        boolean z5 = z4 && !z3;
        if (findViewById != null) {
            if (z5) {
                i = mainActivity.systemBottomInset;
            } else {
                i = 0;
            }
            findViewById.setPadding(findViewById.getPaddingLeft(), findViewById.getPaddingTop(), findViewById.getPaddingRight(), i);
        }
        if (navDestination.getId() != R.id.nav_servers) {
            z = false;
        }
        ActivityMainBinding activityMainBinding15 = mainActivity.binding;
        if (activityMainBinding15 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityMainBinding15 = null;
        }
        activityMainBinding15.appBarMain.discordButton.setVisibility(z ? 0 : 8);
        ActivityMainBinding activityMainBinding16 = mainActivity.binding;
        if (activityMainBinding16 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            activityMainBinding2 = activityMainBinding16;
        }
        LinearLayout linearLayout = activityMainBinding2.appBarMain.tunnelRegionButton;
        if (!z) {
            i2 = 8;
        }
        linearLayout.setVisibility(i2);
    }

    private final void updateTunnelRegionButtonLabel() {
        FirebaseAuth firebaseAuth = this.auth;
        ActivityMainBinding activityMainBinding = null;
        if (firebaseAuth == null) {
            Intrinsics.throwUninitializedPropertyAccessException("auth");
            firebaseAuth = null;
        }
        String str = "Tunnel: Local";
        if (firebaseAuth.getCurrentUser() != null) {
            TunnelRegionManager tunnelRegionManager2 = this.tunnelRegionManager;
            if (tunnelRegionManager2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tunnelRegionManager");
                tunnelRegionManager2 = null;
            }
            int i = WhenMappings.$EnumSwitchMapping$0[tunnelRegionManager2.getSelectedRegion().ordinal()];
            if (i == 1) {
                str = "Tunnel: EU";
            } else if (i != 2) {
                if (i == 3) {
                    str = "Tunnel: US";
                } else if (i == 4) {
                    str = "Tunnel: AS";
                } else {
                    throw new NoWhenBranchMatchedException();
                }
            }
        }
        ActivityMainBinding activityMainBinding2 = this.binding;
        if (activityMainBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            activityMainBinding = activityMainBinding2;
        }
        activityMainBinding.appBarMain.tunnelRegionText.setText(str);
    }

    /* access modifiers changed from: private */
    public static final void authStateListener$lambda$5(MainActivity mainActivity, FirebaseAuth firebaseAuth) {
        Intrinsics.checkNotNullParameter(firebaseAuth, "it");
        mainActivity.updateTunnelRegionButtonLabel();
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
        FirebaseAuth firebaseAuth = this.auth;
        if (firebaseAuth == null) {
            Intrinsics.throwUninitializedPropertyAccessException("auth");
            firebaseAuth = null;
        }
        firebaseAuth.addAuthStateListener(this.authStateListener);
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        super.onStop();
        FirebaseAuth firebaseAuth = this.auth;
        if (firebaseAuth == null) {
            Intrinsics.throwUninitializedPropertyAccessException("auth");
            firebaseAuth = null;
        }
        firebaseAuth.removeAuthStateListener(this.authStateListener);
    }

    static /* synthetic */ Long measureTcpPingMs$default(MainActivity mainActivity, String str, int i, int i2, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            i2 = 3000;
        }
        return mainActivity.measureTcpPingMs(str, i, i2);
    }

    private final Long measureTcpPingMs(String str, int i, int i2) {
        try {
            long currentTimeMillis = System.currentTimeMillis();
            Socket socket = new Socket();
            socket.connect(new InetSocketAddress(str, i), i2);
            socket.close();
            return Long.valueOf(System.currentTimeMillis() - currentTimeMillis);
        } catch (Exception unused) {
            return null;
        }
    }

    private final void showTunnelRegionDialog() {
        BottomSheetDialog bottomSheetDialog;
        BottomSheetDialog bottomSheetDialog2 = new BottomSheetDialog(this, R.style.Theme_WitherHost_BottomSheet);
        TunnelRegionManager tunnelRegionManager2 = null;
        View inflate = getLayoutInflater().inflate(R.layout.dialog_tunnel_region, (ViewGroup) null);
        bottomSheetDialog2.setContentView(inflate);
        bottomSheetDialog2.setOnShowListener(new MainActivity$$ExternalSyntheticLambda3(bottomSheetDialog2));
        FirebaseAuth firebaseAuth = this.auth;
        if (firebaseAuth == null) {
            Intrinsics.throwUninitializedPropertyAccessException("auth");
            firebaseAuth = null;
        }
        boolean z = firebaseAuth.getCurrentUser() != null;
        MaterialCardView materialCardView = (MaterialCardView) inflate.findViewById(R.id.regionEuropeCard);
        MaterialCardView materialCardView2 = (MaterialCardView) inflate.findViewById(R.id.regionLocalCard);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.regionEuropeCheck);
        ImageView imageView2 = (ImageView) inflate.findViewById(R.id.regionLocalCheck);
        TextView textView = (TextView) inflate.findViewById(R.id.regionEuropePing);
        MaterialCardView materialCardView3 = (MaterialCardView) inflate.findViewById(R.id.tunnelInfoCard);
        TextView textView2 = (TextView) inflate.findViewById(R.id.tunnelInfoText);
        ImageView imageView3 = (ImageView) inflate.findViewById(R.id.tunnelInfoIcon);
        if (!z) {
            materialCardView3.setCardBackgroundColor(857341952);
            materialCardView3.setStrokeColor(getColor(R.color.status_red));
            imageView3.setImageTintList(ColorStateList.valueOf(getColor(R.color.status_red)));
            textView2.setText("Sign in to enable tunneling. Players will only be able to connect using your local network IP address.");
            materialCardView.setAlpha(0.35f);
            materialCardView.setClickable(false);
            materialCardView.setFocusable(false);
            textView.setText("—");
            MaterialCardView materialCardView4 = materialCardView2;
            ImageView imageView4 = imageView2;
            showTunnelRegionDialog$refreshSelection(this, materialCardView, materialCardView4, imageView, imageView4, TunnelRegion.LOCAL);
            imageView4.setVisibility(0);
            materialCardView4.setOnClickListener((View.OnClickListener) null);
            bottomSheetDialog = bottomSheetDialog2;
        } else {
            MaterialCardView materialCardView5 = materialCardView;
            MaterialCardView materialCardView6 = materialCardView2;
            ImageView imageView5 = imageView;
            ImageView imageView6 = imageView2;
            TunnelRegionManager tunnelRegionManager3 = this.tunnelRegionManager;
            if (tunnelRegionManager3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tunnelRegionManager");
            } else {
                tunnelRegionManager2 = tunnelRegionManager3;
            }
            showTunnelRegionDialog$refreshSelection(this, materialCardView5, materialCardView6, imageView5, imageView6, tunnelRegionManager2.getSelectedRegion());
            ThreadsKt.thread$default(false, false, (ClassLoader) null, (String) null, 0, new MainActivity$$ExternalSyntheticLambda4(this, bottomSheetDialog2, textView), 31, (Object) null);
            ImageView imageView7 = imageView6;
            MaterialCardView materialCardView7 = materialCardView6;
            bottomSheetDialog = bottomSheetDialog2;
            ImageView imageView8 = imageView7;
            ImageView imageView9 = imageView5;
            MaterialCardView materialCardView8 = materialCardView5;
            MainActivity$$ExternalSyntheticLambda5 mainActivity$$ExternalSyntheticLambda5 = new MainActivity$$ExternalSyntheticLambda5(this, bottomSheetDialog, materialCardView8, materialCardView7, imageView9, imageView8);
            MaterialCardView materialCardView9 = materialCardView8;
            ImageView imageView10 = imageView9;
            materialCardView9.setOnClickListener(mainActivity$$ExternalSyntheticLambda5);
            materialCardView7.setOnClickListener(new MainActivity$$ExternalSyntheticLambda6(this, bottomSheetDialog, materialCardView9, materialCardView7, imageView9, imageView8));
        }
        bottomSheetDialog.show();
    }

    /* access modifiers changed from: private */
    public static final void showTunnelRegionDialog$lambda$7(BottomSheetDialog bottomSheetDialog, DialogInterface dialogInterface) {
        View findViewById = bottomSheetDialog.findViewById(R.id.design_bottom_sheet);
        if (findViewById != null) {
            BottomSheetBehavior from = BottomSheetBehavior.from(findViewById);
            Intrinsics.checkNotNullExpressionValue(from, "from(...)");
            from.setState(3);
            from.setSkipCollapsed(true);
        }
    }

    private static final void showTunnelRegionDialog$refreshSelection(MainActivity mainActivity, MaterialCardView materialCardView, MaterialCardView materialCardView2, ImageView imageView, ImageView imageView2, TunnelRegion tunnelRegion) {
        int color = mainActivity.getColor(R.color.primary);
        int color2 = mainActivity.getResources().getColor(R.color.secondary_tint, mainActivity.getTheme());
        materialCardView.setStrokeColor(tunnelRegion == TunnelRegion.EUROPE ? color : color2);
        if (tunnelRegion != TunnelRegion.LOCAL) {
            color = color2;
        }
        materialCardView2.setStrokeColor(color);
        int i = 0;
        imageView.setVisibility(tunnelRegion == TunnelRegion.EUROPE ? 0 : 8);
        if (tunnelRegion != TunnelRegion.LOCAL) {
            i = 8;
        }
        imageView2.setVisibility(i);
    }

    /* access modifiers changed from: private */
    public static final Unit showTunnelRegionDialog$lambda$9(MainActivity mainActivity, BottomSheetDialog bottomSheetDialog, TextView textView) {
        MainActivity mainActivity2 = mainActivity;
        mainActivity2.runOnUiThread(new MainActivity$$ExternalSyntheticLambda7(bottomSheetDialog, measureTcpPingMs$default(mainActivity2, "api.witherhost.com", GrpcUtil.DEFAULT_PORT_SSL, 0, 4, (Object) null), textView, mainActivity2));
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final void showTunnelRegionDialog$lambda$9$lambda$8(BottomSheetDialog bottomSheetDialog, Long l, TextView textView, MainActivity mainActivity) {
        int i;
        if (bottomSheetDialog.isShowing()) {
            if (l != null) {
                textView.setText(l + " ms");
                if (l.longValue() < 80) {
                    i = mainActivity.getColor(R.color.primary);
                } else if (l.longValue() < 180) {
                    i = mainActivity.getColor(R.color.status_yellow);
                } else {
                    i = mainActivity.getColor(R.color.status_red);
                }
                textView.setTextColor(i);
                return;
            }
            textView.setText("—");
            textView.setTextColor(-2130706433);
        }
    }

    /* access modifiers changed from: private */
    public static final void showTunnelRegionDialog$lambda$10(MainActivity mainActivity, BottomSheetDialog bottomSheetDialog, MaterialCardView materialCardView, MaterialCardView materialCardView2, ImageView imageView, ImageView imageView2, View view) {
        TunnelRegionManager tunnelRegionManager2 = mainActivity.tunnelRegionManager;
        if (tunnelRegionManager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tunnelRegionManager");
            tunnelRegionManager2 = null;
        }
        tunnelRegionManager2.setSelectedRegion(TunnelRegion.EUROPE);
        MainActivity mainActivity2 = mainActivity;
        showTunnelRegionDialog$refreshSelection(mainActivity2, materialCardView, materialCardView2, imageView, imageView2, TunnelRegion.EUROPE);
        mainActivity2.updateTunnelRegionButtonLabel();
        bottomSheetDialog.dismiss();
    }

    /* access modifiers changed from: private */
    public static final void showTunnelRegionDialog$lambda$11(MainActivity mainActivity, BottomSheetDialog bottomSheetDialog, MaterialCardView materialCardView, MaterialCardView materialCardView2, ImageView imageView, ImageView imageView2, View view) {
        TunnelRegionManager tunnelRegionManager2 = mainActivity.tunnelRegionManager;
        if (tunnelRegionManager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tunnelRegionManager");
            tunnelRegionManager2 = null;
        }
        tunnelRegionManager2.setSelectedRegion(TunnelRegion.LOCAL);
        MainActivity mainActivity2 = mainActivity;
        showTunnelRegionDialog$refreshSelection(mainActivity2, materialCardView, materialCardView2, imageView, imageView2, TunnelRegion.LOCAL);
        mainActivity2.updateTunnelRegionButtonLabel();
        bottomSheetDialog.dismiss();
    }

    private final void checkForAnnouncements() {
        Job unused = BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), (CoroutineContext) null, (CoroutineStart) null, new MainActivity$checkForAnnouncements$1(this, (Continuation<? super MainActivity$checkForAnnouncements$1>) null), 3, (Object) null);
    }

    /* access modifiers changed from: private */
    public final void showNextAnnouncement() {
        if (!this.pendingAnnouncements.isEmpty()) {
            new AnnouncementDialog(this, this.pendingAnnouncements.remove(0), new MainActivity$$ExternalSyntheticLambda2(this)).show();
        }
    }

    /* access modifiers changed from: private */
    public static final Unit showNextAnnouncement$lambda$12(MainActivity mainActivity, Announcement announcement) {
        Intrinsics.checkNotNullParameter(announcement, "dismissed");
        AnnouncementManager announcementManager2 = mainActivity.announcementManager;
        if (announcementManager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("announcementManager");
            announcementManager2 = null;
        }
        announcementManager2.markAsSeen(announcement.getId());
        mainActivity.showNextAnnouncement();
        return Unit.INSTANCE;
    }

    public boolean onSupportNavigateUp() {
        NavController findNavController = ActivityKt.findNavController(this, R.id.nav_host_fragment_content_main);
        AppBarConfiguration appBarConfiguration2 = this.appBarConfiguration;
        if (appBarConfiguration2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("appBarConfiguration");
            appBarConfiguration2 = null;
        }
        return NavControllerKt.navigateUp(findNavController, appBarConfiguration2) || super.onSupportNavigateUp();
    }

    public BillingManager getBillingManager() {
        return this.billingManager;
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        BillingManager billingManager2 = this.billingManager;
        if (billingManager2 != null) {
            billingManager2.destroy();
        }
    }
}
