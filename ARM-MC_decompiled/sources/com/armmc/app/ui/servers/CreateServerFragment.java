package com.armmc.app.ui.servers;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.fragment.app.Fragment;
import com.armmc.app.AvailableVersions;
import com.armmc.app.LibraryManager;
import com.armmc.app.PumpkinService;
import com.armmc.app.R;
import com.armmc.app.SplitInstallHelper;
import com.google.android.material.switchmaterial.SwitchMaterial;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000à\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b!\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00012\u00020\u0001:\u0002\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010S\u001a\u0004\u0018\u00010!2\u0006\u0010T\u001a\u00020U2\b\u0010V\u001a\u0004\u0018\u00010W2\b\u0010X\u001a\u0004\u0018\u00010YH\u0016J\u001a\u0010Z\u001a\u00020[2\u0006\u0010\\\u001a\u00020!2\b\u0010X\u001a\u0004\u0018\u00010YH\u0016J\b\u0010]\u001a\u00020[H\u0016J\u0010\u0010^\u001a\u00020[2\u0006\u0010\\\u001a\u00020!H\u0002J\b\u0010_\u001a\u00020[H\u0002J\u0010\u0010`\u001a\u00020[2\u0006\u0010a\u001a\u00020\u0005H\u0002J\b\u0010b\u001a\u00020[H\u0002J\u0010\u0010c\u001a\u00020[2\u0006\u0010d\u001a\u00020eH\u0002J\b\u0010f\u001a\u00020[H\u0002J\b\u0010g\u001a\u00020[H\u0002J\b\u0010h\u001a\u00020[H\u0002J\b\u0010i\u001a\u00020[H\u0002J\u0010\u0010j\u001a\u00020[2\u0006\u0010k\u001a\u00020$H\u0002J\u0018\u0010l\u001a\u00020[2\u0006\u0010m\u001a\u00020n2\u0006\u0010o\u001a\u00020nH\u0002J\b\u0010p\u001a\u00020[H\u0002J\b\u0010q\u001a\u00020[H\u0002J\b\u0010r\u001a\u00020[H\u0002J\b\u0010s\u001a\u00020[H\u0002J\u0010\u0010t\u001a\u00020[2\u0006\u0010u\u001a\u00020DH\u0002J\u0010\u0010v\u001a\u00020[2\u0006\u0010u\u001a\u00020DH\u0002J\b\u0010w\u001a\u00020[H\u0002J\u0010\u0010x\u001a\u00020[2\u0006\u0010y\u001a\u00020zH\u0002J\u0010\u0010{\u001a\u00020[2\u0006\u0010|\u001a\u000209H\u0002J\b\u0010}\u001a\u00020[H\u0002J\u0012\u0010~\u001a\u0004\u0018\u00010$2\u0006\u0010\u001a\u00020\u0005H\u0002J\u001c\u0010\u0001\u001a\u00020[2\u0006\u0010\u001a\u00020\u00052\t\u0010\u0001\u001a\u0004\u0018\u00010$H\u0002J\t\u0010\u0001\u001a\u00020[H\u0002J\t\u0010\u0001\u001a\u00020[H\u0002J\u0011\u0010\u0001\u001a\u00020[2\u0006\u0010\u001a\u00020\u0005H\u0002J\t\u0010\u0001\u001a\u00020[H\u0002J¤\u0001\u0010\u0001\u001a\u00020[2\u0007\u0010\u0001\u001a\u00020$2\u0007\u0010\u0001\u001a\u00020$2\u0007\u0010\u0001\u001a\u00020$2\u0007\u0010\u0001\u001a\u00020\u00052\u0007\u0010\u0001\u001a\u00020$2\u0007\u0010\u0001\u001a\u00020\u00052\u0007\u0010\u0001\u001a\u00020\u00052\u0007\u0010\u0001\u001a\u00020\u00052\u0007\u0010\u0001\u001a\u00020$2\u0007\u0010\u0001\u001a\u00020$2\u0007\u0010\u0001\u001a\u00020$2\u0007\u0010\u0001\u001a\u00020$2\u0007\u0010\u0001\u001a\u00020;2\u0007\u0010\u0001\u001a\u00020;2\u0007\u0010\u0001\u001a\u00020$2\u0007\u0010\u0001\u001a\u00020;2\t\u0010\u0001\u001a\u0004\u0018\u00010$H\u0002J'\u0010\u0001\u001a\u00020[2\u0007\u0010\u0001\u001a\u00020\u00052\u0007\u0010\u0001\u001a\u00020\u00052\n\u0010\u0001\u001a\u0005\u0018\u00010\u0001H\u0017J¤\u0001\u0010\u0001\u001a\u00020[2\u0007\u0010\u0001\u001a\u00020$2\u0007\u0010\u0001\u001a\u00020$2\u0007\u0010\u0001\u001a\u00020$2\u0007\u0010\u0001\u001a\u00020\u00052\u0007\u0010\u0001\u001a\u00020$2\u0007\u0010\u0001\u001a\u00020\u00052\u0007\u0010\u0001\u001a\u00020\u00052\u0007\u0010\u0001\u001a\u00020\u00052\u0007\u0010\u0001\u001a\u00020$2\u0007\u0010\u0001\u001a\u00020$2\u0007\u0010\u0001\u001a\u00020$2\u0007\u0010\u0001\u001a\u00020$2\u0007\u0010\u0001\u001a\u00020;2\u0007\u0010\u0001\u001a\u00020;2\u0007\u0010\u0001\u001a\u00020$2\u0007\u0010\u0001\u001a\u00020;2\t\u0010\u0001\u001a\u0004\u0018\u00010$H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X.¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX.¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX.¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX.¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX.¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX.¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0014X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0014X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0014X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\rX.¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0012X.¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0014X.¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0012X.¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0014X.¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0012X.¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0014X.¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\rX.¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X.¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0014X.¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020$X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u000fX.¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u000fX.¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020(X.¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020(X.¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020(X.¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020,X.¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020!X.¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020!X.¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u000200X.¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u00020\u0014X.¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u000203X.¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u00020\u0014X.¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u00020,X.¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u000207X.¢\u0006\u0002\n\u0000R\u0010\u00108\u001a\u0004\u0018\u000109X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010:\u001a\u00020;X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010<\u001a\u00020(X.¢\u0006\u0002\n\u0000R\u000e\u0010=\u001a\u00020!X.¢\u0006\u0002\n\u0000R\u000e\u0010>\u001a\u00020?X.¢\u0006\u0002\n\u0000R\u000e\u0010@\u001a\u00020,X.¢\u0006\u0002\n\u0000R\u000e\u0010A\u001a\u00020\u0014X.¢\u0006\u0002\n\u0000R\u0014\u0010B\u001a\b\u0012\u0004\u0012\u00020D0CX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010E\u001a\u00020!X.¢\u0006\u0002\n\u0000R\u000e\u0010F\u001a\u00020\u0014X.¢\u0006\u0002\n\u0000R\u000e\u0010G\u001a\u00020\u0014X.¢\u0006\u0002\n\u0000R\u000e\u0010H\u001a\u00020!X.¢\u0006\u0002\n\u0000R\u000e\u0010I\u001a\u00020!X.¢\u0006\u0002\n\u0000R\u000e\u0010J\u001a\u00020?X.¢\u0006\u0002\n\u0000R\u000e\u0010K\u001a\u00020!X.¢\u0006\u0002\n\u0000R\u000e\u0010L\u001a\u00020\u0014X.¢\u0006\u0002\n\u0000R\u000e\u0010M\u001a\u00020,X.¢\u0006\u0002\n\u0000R\u0010\u0010N\u001a\u0004\u0018\u00010OX\u000e¢\u0006\u0002\n\u0000R\u001c\u0010P\u001a\u0010\u0012\f\u0012\n R*\u0004\u0018\u00010$0$0QX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0001"}, d2 = {"Lcom/armmc/app/ui/servers/CreateServerFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "editingServerId", "", "serverRepository", "Lcom/armmc/app/ui/servers/ServerRepository;", "libraryManager", "Lcom/armmc/app/LibraryManager;", "splitInstallHelper", "Lcom/armmc/app/SplitInstallHelper;", "serverNameInput", "Landroid/widget/EditText;", "softwareSpinner", "Landroid/widget/Spinner;", "versionSpinner", "memorySeekBar", "Landroid/widget/SeekBar;", "memoryValueText", "Landroid/widget/TextView;", "memoryMinText", "memoryMidText", "memoryMaxText", "portInput", "viewDistanceSeekBar", "viewDistanceText", "simulationDistanceSeekBar", "simulationDistanceText", "maxPlayersSeekBar", "maxPlayersText", "seedInput", "motdButton", "Landroid/view/View;", "motdPreviewText", "currentMotd", "", "difficultySpinner", "gamemodeSpinner", "onlineModeSwitch", "Lcom/google/android/material/switchmaterial/SwitchMaterial;", "hardcoreSwitch", "eulaSwitch", "createServerButton", "Landroid/widget/Button;", "createServerContainer", "loadingOverlay", "loadingProgressBar", "Landroid/widget/ProgressBar;", "loadingText", "faviconPreview", "Landroid/widget/ImageView;", "faviconStatusText", "selectFaviconButton", "removeFaviconButton", "Landroid/widget/ImageButton;", "customFaviconBitmap", "Landroid/graphics/Bitmap;", "hasCustomFavicon", "", "whitelistSwitch", "whitelistContainer", "whitelistPlayersContainer", "Landroid/widget/LinearLayout;", "addWhitelistPlayerButton", "whitelistEmptyText", "whitelistEntries", "", "Lcom/armmc/app/ui/servers/WhitelistEntry;", "segmentedControlLayout", "customSetupTab", "templatesTab", "customSetupContent", "templatesContent", "templatesCardsContainer", "templateAppliedBanner", "templateAppliedTitle", "dismissTemplateBannerButton", "selectedVersion", "Lcom/armmc/app/AvailableVersions$PumpkinVersion;", "imagePickerLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "kotlin.jvm.PlatformType", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "onDestroyView", "initializeViews", "setupSegmentedControl", "selectTab", "tab", "setupTemplates", "applyTemplate", "template", "Lcom/armmc/app/ui/servers/ServerTemplate;", "setupDeviceMemoryLimit", "setupSpinners", "setupVersionSpinners", "setupFallbackSpinners", "showLoading", "message", "showInstallProgress", "bytesDownloaded", "", "totalBytes", "hideLoading", "initializeDefaultValues", "setupListeners", "openWhitelistPlayerLookup", "addWhitelistEntry", "entry", "removeWhitelistEntry", "updateWhitelistUI", "handleImageSelected", "uri", "Landroid/net/Uri;", "setCustomFavicon", "bitmap", "removeCustomFavicon", "saveFaviconToServer", "serverId", "loadExistingFavicon", "iconPath", "openMotdBuilder", "updateMotdPreview", "loadServerData", "createServer", "installModuleAndSave", "serverName", "software", "version", "memory", "port", "viewDistance", "simulationDistance", "maxPlayers", "seed", "motd", "difficulty", "gamemode", "onlineMode", "hardcore", "moduleName", "whitelistEnabled", "whitelistEntriesJson", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "saveServer", "Companion", "app_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* compiled from: CreateServerFragment.kt */
public final class CreateServerFragment extends Fragment {
    private static final int CONFIRMATION_REQUEST_CODE = 1001;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final int TAB_CUSTOM_SETUP = 0;
    private static final int TAB_TEMPLATES = 1;
    private Button addWhitelistPlayerButton;
    private Button createServerButton;
    private View createServerContainer;
    private String currentMotd = "";
    private Bitmap customFaviconBitmap;
    private View customSetupContent;
    private TextView customSetupTab;
    private Spinner difficultySpinner;
    private Button dismissTemplateBannerButton;
    private int editingServerId = -1;
    private SwitchMaterial eulaSwitch;
    private ImageView faviconPreview;
    private TextView faviconStatusText;
    private Spinner gamemodeSpinner;
    private SwitchMaterial hardcoreSwitch;
    private boolean hasCustomFavicon;
    private final ActivityResultLauncher<String> imagePickerLauncher;
    private LibraryManager libraryManager;
    private View loadingOverlay;
    private ProgressBar loadingProgressBar;
    private TextView loadingText;
    private SeekBar maxPlayersSeekBar;
    /* access modifiers changed from: private */
    public TextView maxPlayersText;
    private TextView memoryMaxText;
    private TextView memoryMidText;
    private TextView memoryMinText;
    private SeekBar memorySeekBar;
    /* access modifiers changed from: private */
    public TextView memoryValueText;
    private View motdButton;
    private TextView motdPreviewText;
    private SwitchMaterial onlineModeSwitch;
    private EditText portInput;
    private ImageButton removeFaviconButton;
    private EditText seedInput;
    private View segmentedControlLayout;
    private Button selectFaviconButton;
    /* access modifiers changed from: private */
    public AvailableVersions.PumpkinVersion selectedVersion;
    private EditText serverNameInput;
    private ServerRepository serverRepository;
    private SeekBar simulationDistanceSeekBar;
    /* access modifiers changed from: private */
    public TextView simulationDistanceText;
    private Spinner softwareSpinner;
    /* access modifiers changed from: private */
    public SplitInstallHelper splitInstallHelper;
    private View templateAppliedBanner;
    private TextView templateAppliedTitle;
    private LinearLayout templatesCardsContainer;
    private View templatesContent;
    private TextView templatesTab;
    private Spinner versionSpinner;
    private SeekBar viewDistanceSeekBar;
    /* access modifiers changed from: private */
    public TextView viewDistanceText;
    private View whitelistContainer;
    private TextView whitelistEmptyText;
    private List<WhitelistEntry> whitelistEntries = new ArrayList();
    private LinearLayout whitelistPlayersContainer;
    private SwitchMaterial whitelistSwitch;

    public CreateServerFragment() {
        ActivityResultLauncher<String> registerForActivityResult = registerForActivityResult(new ActivityResultContracts.GetContent(), new CreateServerFragment$$ExternalSyntheticLambda0(this));
        Intrinsics.checkNotNullExpressionValue(registerForActivityResult, "registerForActivityResult(...)");
        this.imagePickerLauncher = registerForActivityResult;
    }

    /* access modifiers changed from: private */
    public static final void imagePickerLauncher$lambda$1(CreateServerFragment createServerFragment, Uri uri) {
        if (uri != null) {
            createServerFragment.handleImageSelected(uri);
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/armmc/app/ui/servers/CreateServerFragment$Companion;", "", "<init>", "()V", "CONFIRMATION_REQUEST_CODE", "", "TAB_CUSTOM_SETUP", "TAB_TEMPLATES", "app_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* compiled from: CreateServerFragment.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.fragment_create_server, viewGroup, false);
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
        Bundle arguments = getArguments();
        this.editingServerId = arguments != null ? arguments.getInt(PumpkinService.EXTRA_SERVER_ID, -1) : -1;
        initializeViews(view);
        setupDeviceMemoryLimit();
        setupListeners();
        setupVersionSpinners();
        if (this.editingServerId == -1) {
            setupSegmentedControl();
            setupTemplates();
        } else {
            View view2 = this.segmentedControlLayout;
            if (view2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("segmentedControlLayout");
                view2 = null;
            }
            view2.setVisibility(8);
        }
        int i = this.editingServerId;
        if (i != -1) {
            loadServerData(i);
            return;
        }
        initializeDefaultValues();
        Toast.makeText(requireContext(), "Note: Bedrock is currently unsupported in the latest Pumpkin version. Java Edition only.", 1).show();
    }

    public void onDestroyView() {
        super.onDestroyView();
        SplitInstallHelper splitInstallHelper2 = this.splitInstallHelper;
        if (splitInstallHelper2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("splitInstallHelper");
            splitInstallHelper2 = null;
        }
        splitInstallHelper2.cleanup();
        Bitmap bitmap = this.customFaviconBitmap;
        if (bitmap != null) {
            bitmap.recycle();
        }
        this.customFaviconBitmap = null;
    }

    private final void initializeViews(View view) {
        this.serverNameInput = (EditText) view.findViewById(R.id.serverNameInput);
        this.softwareSpinner = (Spinner) view.findViewById(R.id.softwareSpinner);
        this.versionSpinner = (Spinner) view.findViewById(R.id.versionSpinner);
        this.memorySeekBar = (SeekBar) view.findViewById(R.id.memorySeekBar);
        this.memoryValueText = (TextView) view.findViewById(R.id.memoryValueText);
        this.memoryMinText = (TextView) view.findViewById(R.id.memoryMinText);
        this.memoryMidText = (TextView) view.findViewById(R.id.memoryMidText);
        this.memoryMaxText = (TextView) view.findViewById(R.id.memoryMaxText);
        this.portInput = (EditText) view.findViewById(R.id.portInput);
        this.viewDistanceSeekBar = (SeekBar) view.findViewById(R.id.viewDistanceSeekBar);
        this.viewDistanceText = (TextView) view.findViewById(R.id.viewDistanceText);
        this.simulationDistanceSeekBar = (SeekBar) view.findViewById(R.id.simulationDistanceSeekBar);
        this.simulationDistanceText = (TextView) view.findViewById(R.id.simulationDistanceText);
        this.maxPlayersSeekBar = (SeekBar) view.findViewById(R.id.maxPlayersSeekBar);
        this.maxPlayersText = (TextView) view.findViewById(R.id.maxPlayersText);
        this.seedInput = (EditText) view.findViewById(R.id.seedInput);
        this.motdButton = view.findViewById(R.id.motdButton);
        this.motdPreviewText = (TextView) view.findViewById(R.id.motdPreviewText);
        this.difficultySpinner = (Spinner) view.findViewById(R.id.difficultySpinner);
        this.gamemodeSpinner = (Spinner) view.findViewById(R.id.gamemodeSpinner);
        this.onlineModeSwitch = (SwitchMaterial) view.findViewById(R.id.onlineModeSwitch);
        this.hardcoreSwitch = (SwitchMaterial) view.findViewById(R.id.hardcoreSwitch);
        this.eulaSwitch = (SwitchMaterial) view.findViewById(R.id.eulaSwitch);
        this.createServerButton = (Button) view.findViewById(R.id.createServerButton);
        this.createServerContainer = view.findViewById(R.id.createServerContainer);
        this.loadingOverlay = view.findViewById(R.id.loadingOverlay);
        this.loadingProgressBar = (ProgressBar) view.findViewById(R.id.loadingProgressBar);
        this.loadingText = (TextView) view.findViewById(R.id.loadingText);
        this.faviconPreview = (ImageView) view.findViewById(R.id.faviconPreview);
        this.faviconStatusText = (TextView) view.findViewById(R.id.faviconStatusText);
        this.selectFaviconButton = (Button) view.findViewById(R.id.selectFaviconButton);
        this.removeFaviconButton = (ImageButton) view.findViewById(R.id.removeFaviconButton);
        this.whitelistSwitch = (SwitchMaterial) view.findViewById(R.id.whitelistSwitch);
        this.whitelistContainer = view.findViewById(R.id.whitelistContainer);
        this.whitelistPlayersContainer = (LinearLayout) view.findViewById(R.id.whitelistPlayersContainer);
        this.addWhitelistPlayerButton = (Button) view.findViewById(R.id.addWhitelistPlayerButton);
        this.whitelistEmptyText = (TextView) view.findViewById(R.id.whitelistEmptyText);
        this.segmentedControlLayout = view.findViewById(R.id.segmentedControlLayout);
        this.customSetupTab = (TextView) view.findViewById(R.id.customSetupTab);
        this.templatesTab = (TextView) view.findViewById(R.id.templatesTab);
        this.customSetupContent = view.findViewById(R.id.customSetupContent);
        this.templatesContent = view.findViewById(R.id.templatesContent);
        this.templatesCardsContainer = (LinearLayout) view.findViewById(R.id.templatesCardsContainer);
        this.templateAppliedBanner = view.findViewById(R.id.templateAppliedBanner);
        this.templateAppliedTitle = (TextView) view.findViewById(R.id.templateAppliedTitle);
        Button button = (Button) view.findViewById(R.id.dismissTemplateBannerButton);
        this.dismissTemplateBannerButton = button;
        if (button == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dismissTemplateBannerButton");
            button = null;
        }
        button.setOnClickListener(new CreateServerFragment$$ExternalSyntheticLambda9(this));
    }

    /* access modifiers changed from: private */
    public static final void initializeViews$lambda$2(CreateServerFragment createServerFragment, View view) {
        View view2 = createServerFragment.templateAppliedBanner;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("templateAppliedBanner");
            view2 = null;
        }
        view2.setVisibility(8);
    }

    private final void setupSegmentedControl() {
        TextView textView = this.customSetupTab;
        TextView textView2 = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("customSetupTab");
            textView = null;
        }
        textView.setOnClickListener(new CreateServerFragment$$ExternalSyntheticLambda4(this));
        TextView textView3 = this.templatesTab;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("templatesTab");
        } else {
            textView2 = textView3;
        }
        textView2.setOnClickListener(new CreateServerFragment$$ExternalSyntheticLambda5(this));
    }

    /* access modifiers changed from: private */
    public static final void setupSegmentedControl$lambda$3(CreateServerFragment createServerFragment, View view) {
        createServerFragment.selectTab(0);
    }

    /* access modifiers changed from: private */
    public static final void setupSegmentedControl$lambda$4(CreateServerFragment createServerFragment, View view) {
        createServerFragment.selectTab(1);
    }

    private final void selectTab(int i) {
        View view = null;
        if (i == 0) {
            TextView textView = this.customSetupTab;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("customSetupTab");
                textView = null;
            }
            textView.setBackground(requireContext().getDrawable(R.drawable.bg_segmented_tab_selected));
            TextView textView2 = this.customSetupTab;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("customSetupTab");
                textView2 = null;
            }
            textView2.setTextColor(getResources().getColor(R.color.primary_accent, (Resources.Theme) null));
            TextView textView3 = this.templatesTab;
            if (textView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("templatesTab");
                textView3 = null;
            }
            textView3.setBackground((Drawable) null);
            TextView textView4 = this.templatesTab;
            if (textView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("templatesTab");
                textView4 = null;
            }
            textView4.setTextColor(getResources().getColor(R.color.tertiary_tint, (Resources.Theme) null));
            View view2 = this.customSetupContent;
            if (view2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("customSetupContent");
                view2 = null;
            }
            view2.setVisibility(0);
            View view3 = this.templatesContent;
            if (view3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("templatesContent");
                view3 = null;
            }
            view3.setVisibility(8);
            View view4 = this.createServerContainer;
            if (view4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("createServerContainer");
            } else {
                view = view4;
            }
            view.setVisibility(0);
            return;
        }
        TextView textView5 = this.templatesTab;
        if (textView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("templatesTab");
            textView5 = null;
        }
        textView5.setBackground(requireContext().getDrawable(R.drawable.bg_segmented_tab_selected));
        TextView textView6 = this.templatesTab;
        if (textView6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("templatesTab");
            textView6 = null;
        }
        textView6.setTextColor(getResources().getColor(R.color.primary_accent, (Resources.Theme) null));
        TextView textView7 = this.customSetupTab;
        if (textView7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("customSetupTab");
            textView7 = null;
        }
        textView7.setBackground((Drawable) null);
        TextView textView8 = this.customSetupTab;
        if (textView8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("customSetupTab");
            textView8 = null;
        }
        textView8.setTextColor(getResources().getColor(R.color.tertiary_tint, (Resources.Theme) null));
        View view5 = this.customSetupContent;
        if (view5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("customSetupContent");
            view5 = null;
        }
        view5.setVisibility(8);
        View view6 = this.templatesContent;
        if (view6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("templatesContent");
            view6 = null;
        }
        view6.setVisibility(0);
        View view7 = this.createServerContainer;
        if (view7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("createServerContainer");
        } else {
            view = view7;
        }
        view.setVisibility(8);
    }

    private final void setupTemplates() {
        LinearLayout linearLayout = this.templatesCardsContainer;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("templatesCardsContainer");
            linearLayout = null;
        }
        linearLayout.removeAllViews();
        for (ServerTemplate next : ServerTemplates.INSTANCE.getTEMPLATES()) {
            LayoutInflater layoutInflater = getLayoutInflater();
            int i = R.layout.item_server_template;
            LinearLayout linearLayout2 = this.templatesCardsContainer;
            if (linearLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("templatesCardsContainer");
                linearLayout2 = null;
            }
            View inflate = layoutInflater.inflate(i, linearLayout2, false);
            ((ImageView) inflate.findViewById(R.id.templateImage)).setImageResource(next.getImageResId());
            ((TextView) inflate.findViewById(R.id.templateName)).setText(next.getName());
            ((TextView) inflate.findViewById(R.id.templateDescription)).setText(next.getDescription());
            ((Button) inflate.findViewById(R.id.selectTemplateButton)).setOnClickListener(new CreateServerFragment$$ExternalSyntheticLambda11(this, next));
            LinearLayout linearLayout3 = this.templatesCardsContainer;
            if (linearLayout3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("templatesCardsContainer");
                linearLayout3 = null;
            }
            linearLayout3.addView(inflate);
        }
    }

    /* access modifiers changed from: private */
    public static final void setupTemplates$lambda$5(CreateServerFragment createServerFragment, ServerTemplate serverTemplate, View view) {
        createServerFragment.applyTemplate(serverTemplate);
    }

    private final void applyTemplate(ServerTemplate serverTemplate) {
        Bitmap decodeResource;
        EditText editText = this.serverNameInput;
        View view = null;
        if (editText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("serverNameInput");
            editText = null;
        }
        editText.setText(serverTemplate.getName());
        EditText editText2 = this.seedInput;
        if (editText2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("seedInput");
            editText2 = null;
        }
        editText2.setText(serverTemplate.getSeed());
        String[] stringArray = getResources().getStringArray(R.array.difficulty_options);
        Intrinsics.checkNotNullExpressionValue(stringArray, "getStringArray(...)");
        int indexOf = ArraysKt.indexOf((T[]) stringArray, serverTemplate.getDifficulty());
        if (indexOf >= 0) {
            Spinner spinner = this.difficultySpinner;
            if (spinner == null) {
                Intrinsics.throwUninitializedPropertyAccessException("difficultySpinner");
                spinner = null;
            }
            spinner.setSelection(indexOf);
        }
        String[] stringArray2 = getResources().getStringArray(R.array.gamemode_options);
        Intrinsics.checkNotNullExpressionValue(stringArray2, "getStringArray(...)");
        int indexOf2 = ArraysKt.indexOf((T[]) stringArray2, serverTemplate.getGamemode());
        if (indexOf2 >= 0) {
            Spinner spinner2 = this.gamemodeSpinner;
            if (spinner2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("gamemodeSpinner");
                spinner2 = null;
            }
            spinner2.setSelection(indexOf2);
        }
        SeekBar seekBar = this.viewDistanceSeekBar;
        if (seekBar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewDistanceSeekBar");
            seekBar = null;
        }
        seekBar.setProgress(serverTemplate.getViewDistance());
        SeekBar seekBar2 = this.simulationDistanceSeekBar;
        if (seekBar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("simulationDistanceSeekBar");
            seekBar2 = null;
        }
        seekBar2.setProgress(serverTemplate.getSimulationDistance());
        SeekBar seekBar3 = this.maxPlayersSeekBar;
        if (seekBar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("maxPlayersSeekBar");
            seekBar3 = null;
        }
        seekBar3.setProgress(serverTemplate.getMaxPlayers());
        SwitchMaterial switchMaterial = this.onlineModeSwitch;
        if (switchMaterial == null) {
            Intrinsics.throwUninitializedPropertyAccessException("onlineModeSwitch");
            switchMaterial = null;
        }
        switchMaterial.setChecked(serverTemplate.getOnlineMode());
        SwitchMaterial switchMaterial2 = this.hardcoreSwitch;
        if (switchMaterial2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("hardcoreSwitch");
            switchMaterial2 = null;
        }
        switchMaterial2.setChecked(serverTemplate.getHardcore());
        Integer faviconResId = serverTemplate.getFaviconResId();
        if (!(faviconResId == null || (decodeResource = BitmapFactory.decodeResource(getResources(), faviconResId.intValue())) == null)) {
            Bitmap createScaledBitmap = Bitmap.createScaledBitmap(decodeResource, 64, 64, true);
            Intrinsics.checkNotNullExpressionValue(createScaledBitmap, "createScaledBitmap(...)");
            if (createScaledBitmap != decodeResource) {
                decodeResource.recycle();
            }
            setCustomFavicon(createScaledBitmap);
        }
        selectTab(0);
        TextView textView = this.templateAppliedTitle;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("templateAppliedTitle");
            textView = null;
        }
        textView.setText(serverTemplate.getName() + " Template Applied!");
        View view2 = this.templateAppliedBanner;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("templateAppliedBanner");
        } else {
            view = view2;
        }
        view.setVisibility(0);
    }

    private final void setupDeviceMemoryLimit() {
        Object systemService = requireContext().getSystemService("activity");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.ActivityManager");
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        ((ActivityManager) systemService).getMemoryInfo(memoryInfo);
        int roundToInt = MathKt.roundToInt(Math.max((((double) memoryInfo.totalMem) / 1.073741824E9d) * 0.7d, 1.0d) * ((double) 2));
        SeekBar seekBar = this.memorySeekBar;
        SeekBar seekBar2 = null;
        if (seekBar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("memorySeekBar");
            seekBar = null;
        }
        seekBar.setMin(1);
        SeekBar seekBar3 = this.memorySeekBar;
        if (seekBar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("memorySeekBar");
            seekBar3 = null;
        }
        seekBar3.setMax(roundToInt);
        SeekBar seekBar4 = this.memorySeekBar;
        if (seekBar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("memorySeekBar");
            seekBar4 = null;
        }
        double min = ((double) seekBar4.getMin()) * 0.5d;
        SeekBar seekBar5 = this.memorySeekBar;
        if (seekBar5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("memorySeekBar");
            seekBar5 = null;
        }
        double max = ((double) seekBar5.getMax()) * 0.5d;
        SeekBar seekBar6 = this.memorySeekBar;
        if (seekBar6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("memorySeekBar");
            seekBar6 = null;
        }
        int min2 = seekBar6.getMin();
        SeekBar seekBar7 = this.memorySeekBar;
        if (seekBar7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("memorySeekBar");
            seekBar7 = null;
        }
        double max2 = ((double) ((min2 + seekBar7.getMax()) / 2)) * 0.5d;
        TextView textView = this.memoryMinText;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("memoryMinText");
            textView = null;
        }
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format("%.1f GB", Arrays.copyOf(new Object[]{Double.valueOf(min)}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(...)");
        textView.setText(format);
        TextView textView2 = this.memoryMidText;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("memoryMidText");
            textView2 = null;
        }
        StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
        String format2 = String.format("%.1f GB", Arrays.copyOf(new Object[]{Double.valueOf(max2)}, 1));
        Intrinsics.checkNotNullExpressionValue(format2, "format(...)");
        textView2.setText(format2);
        TextView textView3 = this.memoryMaxText;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("memoryMaxText");
            textView3 = null;
        }
        StringCompanionObject stringCompanionObject3 = StringCompanionObject.INSTANCE;
        String format3 = String.format("%.1f GB", Arrays.copyOf(new Object[]{Double.valueOf(max)}, 1));
        Intrinsics.checkNotNullExpressionValue(format3, "format(...)");
        textView3.setText(format3);
        SeekBar seekBar8 = this.memorySeekBar;
        if (seekBar8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("memorySeekBar");
            seekBar8 = null;
        }
        if (seekBar8.getProgress() <= roundToInt) {
            SeekBar seekBar9 = this.memorySeekBar;
            if (seekBar9 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("memorySeekBar");
                seekBar9 = null;
            }
            if (seekBar9.getProgress() != 0) {
                return;
            }
        }
        SeekBar seekBar10 = this.memorySeekBar;
        if (seekBar10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("memorySeekBar");
        } else {
            seekBar2 = seekBar10;
        }
        seekBar2.setProgress(Math.min(2, roundToInt));
    }

    private final void setupSpinners() {
        ArrayAdapter<CharSequence> createFromResource = ArrayAdapter.createFromResource(requireContext(), R.array.difficulty_options, R.layout.spinner_item);
        Intrinsics.checkNotNullExpressionValue(createFromResource, "createFromResource(...)");
        createFromResource.setDropDownViewResource(R.layout.spinner_dropdown_item);
        Spinner spinner = this.difficultySpinner;
        Spinner spinner2 = null;
        if (spinner == null) {
            Intrinsics.throwUninitializedPropertyAccessException("difficultySpinner");
            spinner = null;
        }
        spinner.setAdapter(createFromResource);
        ArrayAdapter<CharSequence> createFromResource2 = ArrayAdapter.createFromResource(requireContext(), R.array.gamemode_options, R.layout.spinner_item);
        Intrinsics.checkNotNullExpressionValue(createFromResource2, "createFromResource(...)");
        createFromResource2.setDropDownViewResource(R.layout.spinner_dropdown_item);
        Spinner spinner3 = this.gamemodeSpinner;
        if (spinner3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("gamemodeSpinner");
        } else {
            spinner2 = spinner3;
        }
        spinner2.setAdapter(createFromResource2);
    }

    /* access modifiers changed from: private */
    public final void setupVersionSpinners() {
        List<AvailableVersions.PumpkinVersion> available_versions = AvailableVersions.INSTANCE.getAVAILABLE_VERSIONS();
        if (available_versions.isEmpty()) {
            setupFallbackSpinners();
            return;
        }
        ArrayAdapter arrayAdapter = new ArrayAdapter(requireContext(), R.layout.spinner_item, new String[]{"Pumpkin"});
        arrayAdapter.setDropDownViewResource(R.layout.spinner_dropdown_item);
        Spinner spinner = this.softwareSpinner;
        Spinner spinner2 = null;
        if (spinner == null) {
            Intrinsics.throwUninitializedPropertyAccessException("softwareSpinner");
            spinner = null;
        }
        spinner.setAdapter(arrayAdapter);
        Iterable<AvailableVersions.PumpkinVersion> iterable = available_versions;
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
        for (AvailableVersions.PumpkinVersion pumpkinVersion : iterable) {
            SplitInstallHelper splitInstallHelper2 = this.splitInstallHelper;
            if (splitInstallHelper2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("splitInstallHelper");
                splitInstallHelper2 = null;
            }
            String str = "";
            String str2 = splitInstallHelper2.isModuleInstalled(pumpkinVersion.getModuleName()) ? " ✓" : str;
            if (pumpkinVersion.isRecommended()) {
                str = " (Recommended)";
            }
            arrayList.add(pumpkinVersion.getVersion() + str + str2);
        }
        ArrayAdapter arrayAdapter2 = new ArrayAdapter(requireContext(), R.layout.spinner_item, (String[]) ((List) arrayList).toArray(new String[0]));
        arrayAdapter2.setDropDownViewResource(R.layout.spinner_dropdown_item);
        Spinner spinner3 = this.versionSpinner;
        if (spinner3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("versionSpinner");
            spinner3 = null;
        }
        spinner3.setAdapter(arrayAdapter2);
        Spinner spinner4 = this.versionSpinner;
        if (spinner4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("versionSpinner");
            spinner4 = null;
        }
        spinner4.setOnItemSelectedListener(new CreateServerFragment$setupVersionSpinners$1(this, available_versions));
        setupSpinners();
        if (!available_versions.isEmpty()) {
            Spinner spinner5 = this.versionSpinner;
            if (spinner5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("versionSpinner");
            } else {
                spinner2 = spinner5;
            }
            spinner2.setSelection(0);
        }
    }

    private final void setupFallbackSpinners() {
        ArrayAdapter arrayAdapter = new ArrayAdapter(requireContext(), R.layout.spinner_item, new String[]{"Pumpkin"});
        arrayAdapter.setDropDownViewResource(R.layout.spinner_dropdown_item);
        Spinner spinner = this.softwareSpinner;
        Spinner spinner2 = null;
        if (spinner == null) {
            Intrinsics.throwUninitializedPropertyAccessException("softwareSpinner");
            spinner = null;
        }
        spinner.setAdapter(arrayAdapter);
        ArrayAdapter arrayAdapter2 = new ArrayAdapter(requireContext(), R.layout.spinner_item, new String[]{"No versions available"});
        arrayAdapter2.setDropDownViewResource(R.layout.spinner_dropdown_item);
        Spinner spinner3 = this.versionSpinner;
        if (spinner3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("versionSpinner");
        } else {
            spinner2 = spinner3;
        }
        spinner2.setAdapter(arrayAdapter2);
        setupSpinners();
    }

    private final void showLoading(String str) {
        View view = this.loadingOverlay;
        View view2 = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("loadingOverlay");
            view = null;
        }
        view.setVisibility(0);
        TextView textView = this.loadingText;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("loadingText");
            textView = null;
        }
        textView.setText(str);
        ProgressBar progressBar = this.loadingProgressBar;
        if (progressBar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("loadingProgressBar");
            progressBar = null;
        }
        progressBar.setIndeterminate(true);
        View view3 = this.createServerContainer;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("createServerContainer");
        } else {
            view2 = view3;
        }
        view2.setVisibility(8);
    }

    /* access modifiers changed from: private */
    public final void showInstallProgress(long j, long j2) {
        if (j2 > 0) {
            int i = (int) ((((float) j) / ((float) j2)) * ((float) 100));
            ProgressBar progressBar = this.loadingProgressBar;
            View view = null;
            if (progressBar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("loadingProgressBar");
                progressBar = null;
            }
            progressBar.setIndeterminate(false);
            ProgressBar progressBar2 = this.loadingProgressBar;
            if (progressBar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("loadingProgressBar");
                progressBar2 = null;
            }
            progressBar2.setProgress(i);
            long j3 = (long) 1048576;
            long j4 = j / j3;
            long j5 = j2 / j3;
            TextView textView = this.loadingText;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("loadingText");
                textView = null;
            }
            textView.setText("Installing module... " + j4 + "MB / " + j5 + "MB (" + i + "%)");
            View view2 = this.createServerContainer;
            if (view2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("createServerContainer");
            } else {
                view = view2;
            }
            view.setVisibility(8);
        }
    }

    /* access modifiers changed from: private */
    public final void hideLoading() {
        View view = this.loadingOverlay;
        View view2 = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("loadingOverlay");
            view = null;
        }
        view.setVisibility(8);
        View view3 = this.createServerContainer;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("createServerContainer");
        } else {
            view2 = view3;
        }
        view2.setVisibility(0);
    }

    private final void initializeDefaultValues() {
        SeekBar seekBar = this.memorySeekBar;
        EditText editText = null;
        if (seekBar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("memorySeekBar");
            seekBar = null;
        }
        double progress = ((double) seekBar.getProgress()) * 0.5d;
        TextView textView = this.memoryValueText;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("memoryValueText");
            textView = null;
        }
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format("%.1f GB", Arrays.copyOf(new Object[]{Double.valueOf(progress)}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(...)");
        textView.setText(format);
        TextView textView2 = this.viewDistanceText;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewDistanceText");
            textView2 = null;
        }
        SeekBar seekBar2 = this.viewDistanceSeekBar;
        if (seekBar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewDistanceSeekBar");
            seekBar2 = null;
        }
        textView2.setText(seekBar2.getProgress() + " chunks");
        TextView textView3 = this.simulationDistanceText;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("simulationDistanceText");
            textView3 = null;
        }
        SeekBar seekBar3 = this.simulationDistanceSeekBar;
        if (seekBar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("simulationDistanceSeekBar");
            seekBar3 = null;
        }
        textView3.setText(seekBar3.getProgress() + " chunks");
        TextView textView4 = this.maxPlayersText;
        if (textView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("maxPlayersText");
            textView4 = null;
        }
        SeekBar seekBar4 = this.maxPlayersSeekBar;
        if (seekBar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("maxPlayersSeekBar");
            seekBar4 = null;
        }
        textView4.setText(seekBar4.getProgress() + " players");
        EditText editText2 = this.portInput;
        if (editText2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("portInput");
        } else {
            editText = editText2;
        }
        editText.setText("25565");
    }

    private final void setupListeners() {
        SeekBar seekBar = this.memorySeekBar;
        Button button = null;
        if (seekBar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("memorySeekBar");
            seekBar = null;
        }
        seekBar.setOnSeekBarChangeListener(new CreateServerFragment$setupListeners$1(this));
        SeekBar seekBar2 = this.viewDistanceSeekBar;
        if (seekBar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewDistanceSeekBar");
            seekBar2 = null;
        }
        seekBar2.setOnSeekBarChangeListener(new CreateServerFragment$setupListeners$2(this));
        SeekBar seekBar3 = this.simulationDistanceSeekBar;
        if (seekBar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("simulationDistanceSeekBar");
            seekBar3 = null;
        }
        seekBar3.setOnSeekBarChangeListener(new CreateServerFragment$setupListeners$3(this));
        SeekBar seekBar4 = this.maxPlayersSeekBar;
        if (seekBar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("maxPlayersSeekBar");
            seekBar4 = null;
        }
        seekBar4.setOnSeekBarChangeListener(new CreateServerFragment$setupListeners$4(this));
        View view = this.motdButton;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("motdButton");
            view = null;
        }
        view.setOnClickListener(new CreateServerFragment$$ExternalSyntheticLambda12(this));
        Button button2 = this.selectFaviconButton;
        if (button2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("selectFaviconButton");
            button2 = null;
        }
        button2.setOnClickListener(new CreateServerFragment$$ExternalSyntheticLambda13(this));
        ImageButton imageButton = this.removeFaviconButton;
        if (imageButton == null) {
            Intrinsics.throwUninitializedPropertyAccessException("removeFaviconButton");
            imageButton = null;
        }
        imageButton.setOnClickListener(new CreateServerFragment$$ExternalSyntheticLambda14(this));
        SwitchMaterial switchMaterial = this.whitelistSwitch;
        if (switchMaterial == null) {
            Intrinsics.throwUninitializedPropertyAccessException("whitelistSwitch");
            switchMaterial = null;
        }
        switchMaterial.setOnCheckedChangeListener(new CreateServerFragment$$ExternalSyntheticLambda1(this));
        Button button3 = this.addWhitelistPlayerButton;
        if (button3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("addWhitelistPlayerButton");
            button3 = null;
        }
        button3.setOnClickListener(new CreateServerFragment$$ExternalSyntheticLambda2(this));
        Button button4 = this.createServerButton;
        if (button4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("createServerButton");
        } else {
            button = button4;
        }
        button.setOnClickListener(new CreateServerFragment$$ExternalSyntheticLambda3(this));
    }

    /* access modifiers changed from: private */
    public static final void setupListeners$lambda$8(CreateServerFragment createServerFragment, View view) {
        createServerFragment.openMotdBuilder();
    }

    /* access modifiers changed from: private */
    public static final void setupListeners$lambda$9(CreateServerFragment createServerFragment, View view) {
        createServerFragment.imagePickerLauncher.launch("image/*");
    }

    /* access modifiers changed from: private */
    public static final void setupListeners$lambda$10(CreateServerFragment createServerFragment, View view) {
        createServerFragment.removeCustomFavicon();
    }

    /* access modifiers changed from: private */
    public static final void setupListeners$lambda$11(CreateServerFragment createServerFragment, CompoundButton compoundButton, boolean z) {
        Intrinsics.checkNotNullParameter(compoundButton, "<unused var>");
        View view = createServerFragment.whitelistContainer;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("whitelistContainer");
            view = null;
        }
        view.setVisibility(z ? 0 : 8);
    }

    /* access modifiers changed from: private */
    public static final void setupListeners$lambda$12(CreateServerFragment createServerFragment, View view) {
        createServerFragment.openWhitelistPlayerLookup();
    }

    /* access modifiers changed from: private */
    public static final void setupListeners$lambda$13(CreateServerFragment createServerFragment, View view) {
        createServerFragment.createServer();
    }

    private final void openWhitelistPlayerLookup() {
        WhitelistPlayerLookupDialog newInstance = WhitelistPlayerLookupDialog.Companion.newInstance(WhitelistEntry.Companion.toJson(this.whitelistEntries));
        newInstance.setOnPlayerAddedListener(new CreateServerFragment$$ExternalSyntheticLambda10(this));
        newInstance.show(getParentFragmentManager(), "whitelist_lookup");
    }

    /* access modifiers changed from: private */
    public static final Unit openWhitelistPlayerLookup$lambda$14(CreateServerFragment createServerFragment, WhitelistEntry whitelistEntry) {
        Intrinsics.checkNotNullParameter(whitelistEntry, "entry");
        createServerFragment.addWhitelistEntry(whitelistEntry);
        return Unit.INSTANCE;
    }

    private final void addWhitelistEntry(WhitelistEntry whitelistEntry) {
        this.whitelistEntries.add(whitelistEntry);
        updateWhitelistUI();
    }

    private final void removeWhitelistEntry(WhitelistEntry whitelistEntry) {
        this.whitelistEntries.remove(whitelistEntry);
        updateWhitelistUI();
    }

    private final void updateWhitelistUI() {
        LinearLayout linearLayout = this.whitelistPlayersContainer;
        TextView textView = null;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("whitelistPlayersContainer");
            linearLayout = null;
        }
        linearLayout.removeAllViews();
        if (this.whitelistEntries.isEmpty()) {
            TextView textView2 = this.whitelistEmptyText;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("whitelistEmptyText");
            } else {
                textView = textView2;
            }
            textView.setVisibility(0);
            return;
        }
        TextView textView3 = this.whitelistEmptyText;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("whitelistEmptyText");
            textView3 = null;
        }
        textView3.setVisibility(8);
        for (WhitelistEntry next : this.whitelistEntries) {
            LayoutInflater layoutInflater = getLayoutInflater();
            int i = R.layout.item_whitelist_player;
            LinearLayout linearLayout2 = this.whitelistPlayersContainer;
            if (linearLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("whitelistPlayersContainer");
                linearLayout2 = null;
            }
            View inflate = layoutInflater.inflate(i, linearLayout2, false);
            ((TextView) inflate.findViewById(R.id.playerName)).setText(next.getName());
            ((ImageButton) inflate.findViewById(R.id.removeButton)).setOnClickListener(new CreateServerFragment$$ExternalSyntheticLambda7(this, next));
            LinearLayout linearLayout3 = this.whitelistPlayersContainer;
            if (linearLayout3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("whitelistPlayersContainer");
                linearLayout3 = null;
            }
            linearLayout3.addView(inflate);
        }
    }

    /* access modifiers changed from: private */
    public static final void updateWhitelistUI$lambda$15(CreateServerFragment createServerFragment, WhitelistEntry whitelistEntry, View view) {
        createServerFragment.removeWhitelistEntry(whitelistEntry);
    }

    private final void handleImageSelected(Uri uri) {
        ImageCropDialog newInstance = ImageCropDialog.Companion.newInstance(uri);
        newInstance.setOnImageCroppedListener(new CreateServerFragment$$ExternalSyntheticLambda8(this));
        newInstance.show(getParentFragmentManager(), "image_crop");
    }

    /* access modifiers changed from: private */
    public static final Unit handleImageSelected$lambda$16(CreateServerFragment createServerFragment, Bitmap bitmap) {
        Intrinsics.checkNotNullParameter(bitmap, "croppedBitmap");
        createServerFragment.setCustomFavicon(bitmap);
        return Unit.INSTANCE;
    }

    private final void setCustomFavicon(Bitmap bitmap) {
        Bitmap bitmap2 = this.customFaviconBitmap;
        if (bitmap2 != null) {
            bitmap2.recycle();
        }
        this.customFaviconBitmap = bitmap;
        this.hasCustomFavicon = true;
        ImageView imageView = this.faviconPreview;
        ImageButton imageButton = null;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("faviconPreview");
            imageView = null;
        }
        imageView.setImageBitmap(bitmap);
        TextView textView = this.faviconStatusText;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("faviconStatusText");
            textView = null;
        }
        textView.setText("Custom icon selected");
        TextView textView2 = this.faviconStatusText;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("faviconStatusText");
            textView2 = null;
        }
        textView2.setTextColor(getResources().getColor(R.color.primary_accent, (Resources.Theme) null));
        ImageButton imageButton2 = this.removeFaviconButton;
        if (imageButton2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("removeFaviconButton");
        } else {
            imageButton = imageButton2;
        }
        imageButton.setVisibility(0);
    }

    private final void removeCustomFavicon() {
        Bitmap bitmap = this.customFaviconBitmap;
        if (bitmap != null) {
            bitmap.recycle();
        }
        ImageButton imageButton = null;
        this.customFaviconBitmap = null;
        this.hasCustomFavicon = false;
        ImageView imageView = this.faviconPreview;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("faviconPreview");
            imageView = null;
        }
        imageView.setImageResource(R.drawable.favicon);
        TextView textView = this.faviconStatusText;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("faviconStatusText");
            textView = null;
        }
        textView.setText("Using default icon");
        TextView textView2 = this.faviconStatusText;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("faviconStatusText");
            textView2 = null;
        }
        textView2.setTextColor(getResources().getColor(R.color.gray, (Resources.Theme) null));
        ImageButton imageButton2 = this.removeFaviconButton;
        if (imageButton2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("removeFaviconButton");
        } else {
            imageButton = imageButton2;
        }
        imageButton.setVisibility(8);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x004b, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:?, code lost:
        kotlin.io.CloseableKt.closeFinally(r2, r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x004f, code lost:
        throw r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.lang.String saveFaviconToServer(int r7) {
        /*
            r6 = this;
            android.graphics.Bitmap r0 = r6.customFaviconBitmap
            r1 = 0
            if (r0 != 0) goto L_0x0006
            return r1
        L_0x0006:
            java.io.File r2 = new java.io.File
            android.content.Context r3 = r6.requireContext()
            java.io.File r3 = r3.getFilesDir()
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            java.lang.String r5 = "server_"
            r4.<init>(r5)
            java.lang.StringBuilder r7 = r4.append(r7)
            java.lang.String r7 = r7.toString()
            r2.<init>(r3, r7)
            boolean r7 = r2.exists()
            if (r7 != 0) goto L_0x002b
            r2.mkdirs()
        L_0x002b:
            java.io.File r7 = new java.io.File
            java.lang.String r3 = "icon.png"
            r7.<init>(r2, r3)
            java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x0050 }
            r2.<init>(r7)     // Catch:{ Exception -> 0x0050 }
            java.io.Closeable r2 = (java.io.Closeable) r2     // Catch:{ Exception -> 0x0050 }
            r7 = r2
            java.io.FileOutputStream r7 = (java.io.FileOutputStream) r7     // Catch:{ all -> 0x0049 }
            android.graphics.Bitmap$CompressFormat r4 = android.graphics.Bitmap.CompressFormat.PNG     // Catch:{ all -> 0x0049 }
            java.io.OutputStream r7 = (java.io.OutputStream) r7     // Catch:{ all -> 0x0049 }
            r5 = 100
            r0.compress(r4, r5, r7)     // Catch:{ all -> 0x0049 }
            kotlin.io.CloseableKt.closeFinally(r2, r1)     // Catch:{ Exception -> 0x0050 }
            return r3
        L_0x0049:
            r7 = move-exception
            throw r7     // Catch:{ all -> 0x004b }
        L_0x004b:
            r0 = move-exception
            kotlin.io.CloseableKt.closeFinally(r2, r7)     // Catch:{ Exception -> 0x0050 }
            throw r0     // Catch:{ Exception -> 0x0050 }
        L_0x0050:
            r7 = move-exception
            r7.printStackTrace()
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.armmc.app.ui.servers.CreateServerFragment.saveFaviconToServer(int):java.lang.String");
    }

    private final void loadExistingFavicon(int i, String str) {
        if (str != null) {
            File file = new File(new File(requireContext().getFilesDir(), "server_" + i), str);
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
                        setCustomFavicon(decodeFile);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private final void openMotdBuilder() {
        MotdBuilderDialog newInstance = MotdBuilderDialog.Companion.newInstance(this.currentMotd);
        newInstance.setOnMotdAppliedListener(new CreateServerFragment$$ExternalSyntheticLambda6(this));
        newInstance.show(getParentFragmentManager(), "motd_builder");
    }

    /* access modifiers changed from: private */
    public static final Unit openMotdBuilder$lambda$19(CreateServerFragment createServerFragment, String str) {
        Intrinsics.checkNotNullParameter(str, "motd");
        createServerFragment.currentMotd = str;
        createServerFragment.updateMotdPreview();
        return Unit.INSTANCE;
    }

    private final void updateMotdPreview() {
        if (this.currentMotd.length() == 0) {
            TextView textView = this.motdPreviewText;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("motdPreviewText");
                textView = null;
            }
            textView.setText("Server description");
            TextView textView2 = this.motdPreviewText;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("motdPreviewText");
                textView2 = null;
            }
            textView2.setTextColor(getResources().getColor(R.color.tertiary_tint, (Resources.Theme) null));
            return;
        }
        TextView textView3 = this.motdPreviewText;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("motdPreviewText");
            textView3 = null;
        }
        textView3.setText(MinecraftTextFormatter.format$default(MinecraftTextFormatter.INSTANCE, this.currentMotd, false, 2, (Object) null));
    }

    private final void loadServerData(int i) {
        ServerRepository serverRepository2 = this.serverRepository;
        Button button = null;
        if (serverRepository2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("serverRepository");
            serverRepository2 = null;
        }
        ServerData serverById = serverRepository2.getServerById(i);
        if (serverById != null) {
            EditText editText = this.serverNameInput;
            if (editText == null) {
                Intrinsics.throwUninitializedPropertyAccessException("serverNameInput");
                editText = null;
            }
            editText.setText(serverById.getName());
            EditText editText2 = this.portInput;
            if (editText2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("portInput");
                editText2 = null;
            }
            editText2.setText(serverById.getPort());
            EditText editText3 = this.seedInput;
            if (editText3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("seedInput");
                editText3 = null;
            }
            editText3.setText(serverById.getSeed());
            this.currentMotd = serverById.getMotd();
            updateMotdPreview();
            SeekBar seekBar = this.memorySeekBar;
            if (seekBar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("memorySeekBar");
                seekBar = null;
            }
            int memory = serverById.getMemory();
            SeekBar seekBar2 = this.memorySeekBar;
            if (seekBar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("memorySeekBar");
                seekBar2 = null;
            }
            seekBar.setProgress(RangesKt.coerceAtMost(memory, seekBar2.getMax()));
            SeekBar seekBar3 = this.viewDistanceSeekBar;
            if (seekBar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewDistanceSeekBar");
                seekBar3 = null;
            }
            seekBar3.setProgress(serverById.getViewDistance());
            SeekBar seekBar4 = this.simulationDistanceSeekBar;
            if (seekBar4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("simulationDistanceSeekBar");
                seekBar4 = null;
            }
            seekBar4.setProgress(serverById.getSimulationDistance());
            SeekBar seekBar5 = this.maxPlayersSeekBar;
            if (seekBar5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("maxPlayersSeekBar");
                seekBar5 = null;
            }
            seekBar5.setProgress(serverById.getMaxPlayers());
            Spinner spinner = this.softwareSpinner;
            if (spinner == null) {
                Intrinsics.throwUninitializedPropertyAccessException("softwareSpinner");
                spinner = null;
            }
            int i2 = 0;
            spinner.setSelection(0);
            Spinner spinner2 = this.versionSpinner;
            if (spinner2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("versionSpinner");
                spinner2 = null;
            }
            spinner2.setSelection(0);
            String[] stringArray = getResources().getStringArray(R.array.difficulty_options);
            Intrinsics.checkNotNullExpressionValue(stringArray, "getStringArray(...)");
            int indexOf = ArraysKt.indexOf((T[]) stringArray, serverById.getDifficulty());
            if (indexOf >= 0) {
                Spinner spinner3 = this.difficultySpinner;
                if (spinner3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("difficultySpinner");
                    spinner3 = null;
                }
                spinner3.setSelection(indexOf);
            }
            String[] stringArray2 = getResources().getStringArray(R.array.gamemode_options);
            Intrinsics.checkNotNullExpressionValue(stringArray2, "getStringArray(...)");
            int indexOf2 = ArraysKt.indexOf((T[]) stringArray2, serverById.getGamemode());
            if (indexOf2 >= 0) {
                Spinner spinner4 = this.gamemodeSpinner;
                if (spinner4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("gamemodeSpinner");
                    spinner4 = null;
                }
                spinner4.setSelection(indexOf2);
            }
            SwitchMaterial switchMaterial = this.onlineModeSwitch;
            if (switchMaterial == null) {
                Intrinsics.throwUninitializedPropertyAccessException("onlineModeSwitch");
                switchMaterial = null;
            }
            switchMaterial.setChecked(serverById.getOnlineMode());
            SwitchMaterial switchMaterial2 = this.hardcoreSwitch;
            if (switchMaterial2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("hardcoreSwitch");
                switchMaterial2 = null;
            }
            switchMaterial2.setChecked(serverById.getHardcore());
            SwitchMaterial switchMaterial3 = this.eulaSwitch;
            if (switchMaterial3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("eulaSwitch");
                switchMaterial3 = null;
            }
            switchMaterial3.setChecked(true);
            SwitchMaterial switchMaterial4 = this.whitelistSwitch;
            if (switchMaterial4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("whitelistSwitch");
                switchMaterial4 = null;
            }
            Boolean whitelistEnabled = serverById.getWhitelistEnabled();
            switchMaterial4.setChecked(whitelistEnabled != null ? whitelistEnabled.booleanValue() : false);
            View view = this.whitelistContainer;
            if (view == null) {
                Intrinsics.throwUninitializedPropertyAccessException("whitelistContainer");
                view = null;
            }
            Boolean whitelistEnabled2 = serverById.getWhitelistEnabled();
            if (!(whitelistEnabled2 != null ? whitelistEnabled2.booleanValue() : false)) {
                i2 = 8;
            }
            view.setVisibility(i2);
            this.whitelistEntries = CollectionsKt.toMutableList(WhitelistEntry.Companion.fromJson(serverById.getWhitelistEntries()));
            updateWhitelistUI();
            loadExistingFavicon(i, serverById.getIconPath());
            Button button2 = this.createServerButton;
            if (button2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("createServerButton");
            } else {
                button = button2;
            }
            button.setText("Update Server");
            TextView textView = (TextView) requireActivity().findViewById(R.id.toolbar_title);
            if (textView != null) {
                textView.setText(serverById.getName());
            }
            initializeDefaultValues();
        }
    }

    private final void createServer() {
        boolean z;
        String str;
        EditText editText = this.serverNameInput;
        if (editText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("serverNameInput");
            editText = null;
        }
        String obj = editText.getText().toString();
        if (StringsKt.isBlank(obj)) {
            Toast.makeText(getContext(), "Please enter a server name", 0).show();
        } else if (this.selectedVersion == null) {
            Toast.makeText(getContext(), "Please select a version", 0).show();
        } else {
            Spinner spinner = this.softwareSpinner;
            if (spinner == null) {
                Intrinsics.throwUninitializedPropertyAccessException("softwareSpinner");
                spinner = null;
            }
            String obj2 = spinner.getSelectedItem().toString();
            AvailableVersions.PumpkinVersion pumpkinVersion = this.selectedVersion;
            Intrinsics.checkNotNull(pumpkinVersion);
            String version = pumpkinVersion.getVersion();
            AvailableVersions.PumpkinVersion pumpkinVersion2 = this.selectedVersion;
            Intrinsics.checkNotNull(pumpkinVersion2);
            String moduleName = pumpkinVersion2.getModuleName();
            SeekBar seekBar = this.memorySeekBar;
            if (seekBar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("memorySeekBar");
                seekBar = null;
            }
            int progress = seekBar.getProgress();
            EditText editText2 = this.portInput;
            if (editText2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("portInput");
                editText2 = null;
            }
            CharSequence obj3 = editText2.getText().toString();
            if (obj3.length() == 0) {
                obj3 = "25565";
            }
            String str2 = (String) obj3;
            SeekBar seekBar2 = this.viewDistanceSeekBar;
            if (seekBar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewDistanceSeekBar");
                seekBar2 = null;
            }
            int progress2 = seekBar2.getProgress();
            SeekBar seekBar3 = this.simulationDistanceSeekBar;
            if (seekBar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("simulationDistanceSeekBar");
                seekBar3 = null;
            }
            int progress3 = seekBar3.getProgress();
            SeekBar seekBar4 = this.maxPlayersSeekBar;
            if (seekBar4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("maxPlayersSeekBar");
                seekBar4 = null;
            }
            int progress4 = seekBar4.getProgress();
            EditText editText3 = this.seedInput;
            if (editText3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("seedInput");
                editText3 = null;
            }
            String obj4 = editText3.getText().toString();
            CharSequence charSequence = this.currentMotd;
            if (charSequence.length() == 0) {
                charSequence = "§rPowered with §f♥ §rby §a§lWitherHost.com\n";
            }
            String str3 = (String) charSequence;
            Spinner spinner2 = this.difficultySpinner;
            if (spinner2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("difficultySpinner");
                spinner2 = null;
            }
            String obj5 = spinner2.getSelectedItem().toString();
            Spinner spinner3 = this.gamemodeSpinner;
            if (spinner3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("gamemodeSpinner");
                spinner3 = null;
            }
            String obj6 = spinner3.getSelectedItem().toString();
            SwitchMaterial switchMaterial = this.onlineModeSwitch;
            if (switchMaterial == null) {
                Intrinsics.throwUninitializedPropertyAccessException("onlineModeSwitch");
                switchMaterial = null;
            }
            boolean isChecked = switchMaterial.isChecked();
            SwitchMaterial switchMaterial2 = this.hardcoreSwitch;
            if (switchMaterial2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("hardcoreSwitch");
                switchMaterial2 = null;
            }
            boolean isChecked2 = switchMaterial2.isChecked();
            String str4 = obj;
            SwitchMaterial switchMaterial3 = this.whitelistSwitch;
            if (switchMaterial3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("whitelistSwitch");
                switchMaterial3 = null;
            }
            boolean isChecked3 = switchMaterial3.isChecked();
            boolean z2 = isChecked3;
            if (isChecked3) {
                z = isChecked;
                str = WhitelistEntry.Companion.toJson(this.whitelistEntries);
            } else {
                z = isChecked;
                str = null;
            }
            SwitchMaterial switchMaterial4 = this.eulaSwitch;
            if (switchMaterial4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("eulaSwitch");
                switchMaterial4 = null;
            }
            if (!switchMaterial4.isChecked()) {
                Toast.makeText(getContext(), "You must agree to the EULA to create a server", 0).show();
                return;
            }
            SplitInstallHelper splitInstallHelper2 = this.splitInstallHelper;
            if (splitInstallHelper2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("splitInstallHelper");
                splitInstallHelper2 = null;
            }
            if (splitInstallHelper2.isModuleInstalled(moduleName)) {
                String str5 = obj6;
                boolean z3 = isChecked2;
                String str6 = str;
                String str7 = str4;
                saveServer(str7, obj2, version, progress, str2, progress2, progress3, progress4, obj4, str3, obj5, str5, z, z3, moduleName, z2, str6);
                return;
            }
            String str8 = obj6;
            boolean z4 = isChecked2;
            String str9 = str;
            String str10 = str4;
            installModuleAndSave(str10, obj2, version, progress, str2, progress2, progress3, progress4, obj4, str3, obj5, str8, z, z4, moduleName, z2, str9);
        }
    }

    private final void installModuleAndSave(String str, String str2, String str3, int i, String str4, int i2, int i3, int i4, String str5, String str6, String str7, String str8, boolean z, boolean z2, String str9, boolean z3, String str10) {
        String str11 = str3;
        showLoading("Preparing to install Pumpkin " + str11 + "...");
        SplitInstallHelper splitInstallHelper2 = this.splitInstallHelper;
        if (splitInstallHelper2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("splitInstallHelper");
            splitInstallHelper2 = null;
        }
        SplitInstallHelper splitInstallHelper3 = splitInstallHelper2;
        String str12 = str9;
        SplitInstallHelper splitInstallHelper4 = splitInstallHelper3;
        splitInstallHelper4.installModule(str12, new CreateServerFragment$installModuleAndSave$1(this, str, str2, str11, i, str4, i2, i3, i4, str5, str6, str7, str8, z, z2, str9, z3, str10));
    }

    @Deprecated(message = "Deprecated in Java")
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i != 1001) {
            return;
        }
        if (i2 == -1) {
            showLoading("Installing module...");
        } else {
            Toast.makeText(getContext(), "Module installation was canceled", 0).show();
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x003f  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0093  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00b4  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00c4  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void saveServer(java.lang.String r32, java.lang.String r33, java.lang.String r34, int r35, java.lang.String r36, int r37, int r38, int r39, java.lang.String r40, java.lang.String r41, java.lang.String r42, java.lang.String r43, boolean r44, boolean r45, java.lang.String r46, boolean r47, java.lang.String r48) {
        /*
            r31 = this;
            r0 = r31
            int r1 = r0.editingServerId
            r2 = -1
            if (r1 == r2) goto L_0x0009
            r3 = r1
            goto L_0x000a
        L_0x0009:
            r3 = r2
        L_0x000a:
            boolean r4 = r0.hasCustomFavicon
            java.lang.String r29 = "serverRepository"
            r30 = 0
            if (r4 == 0) goto L_0x001e
            if (r3 == r2) goto L_0x0019
            java.lang.String r1 = r0.saveFaviconToServer(r3)
            goto L_0x001b
        L_0x0019:
            java.lang.String r1 = "icon.png"
        L_0x001b:
            r24 = r1
            goto L_0x0038
        L_0x001e:
            if (r1 == r2) goto L_0x0036
            com.armmc.app.ui.servers.ServerRepository r1 = r0.serverRepository
            if (r1 != 0) goto L_0x0029
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r29)
            r1 = r30
        L_0x0029:
            int r3 = r0.editingServerId
            com.armmc.app.ui.servers.ServerData r1 = r1.getServerById(r3)
            if (r1 == 0) goto L_0x0036
            java.lang.String r1 = r1.getIconPath()
            goto L_0x001b
        L_0x0036:
            r24 = r30
        L_0x0038:
            com.armmc.app.ui.servers.ServerData r1 = new com.armmc.app.ui.servers.ServerData
            int r3 = r0.editingServerId
            r4 = 0
            if (r3 == r2) goto L_0x0057
            com.armmc.app.ui.servers.ServerRepository r5 = r0.serverRepository
            if (r5 != 0) goto L_0x0048
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r29)
            r5 = r30
        L_0x0048:
            int r6 = r0.editingServerId
            com.armmc.app.ui.servers.ServerData r5 = r5.getServerById(r6)
            if (r5 == 0) goto L_0x0057
            boolean r5 = r5.isOnline()
            r18 = r5
            goto L_0x0059
        L_0x0057:
            r18 = r4
        L_0x0059:
            int r19 = com.armmc.app.R.drawable.ic_launcher_foreground
            java.lang.Boolean r25 = java.lang.Boolean.valueOf(r47)
            r27 = 1835008(0x1c0000, float:2.571394E-39)
            r28 = 0
            r17 = 0
            r20 = 0
            r21 = 0
            r22 = 0
            r4 = r33
            r5 = r34
            r6 = r35
            r7 = r36
            r8 = r37
            r9 = r38
            r10 = r39
            r11 = r40
            r12 = r41
            r13 = r42
            r14 = r43
            r15 = r44
            r16 = r45
            r23 = r46
            r26 = r48
            r2 = r3
            r3 = r32
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28)
            com.armmc.app.ui.servers.ServerRepository r2 = r0.serverRepository
            if (r2 != 0) goto L_0x0098
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r29)
            r2 = r30
        L_0x0098:
            com.armmc.app.ui.servers.ServerData r1 = r2.saveServer(r1)
            int r2 = r0.editingServerId
            r4 = -1
            if (r2 != r4) goto L_0x00b0
            boolean r2 = r0.hasCustomFavicon
            if (r2 == 0) goto L_0x00b0
            android.graphics.Bitmap r2 = r0.customFaviconBitmap
            if (r2 == 0) goto L_0x00b0
            int r1 = r1.getId()
            r0.saveFaviconToServer(r1)
        L_0x00b0:
            int r1 = r0.editingServerId
            if (r1 == r4) goto L_0x00c4
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "Server updated: "
            r1.<init>(r2)
            java.lang.StringBuilder r1 = r1.append(r3)
            java.lang.String r1 = r1.toString()
            goto L_0x00d3
        L_0x00c4:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "Server created: "
            r1.<init>(r2)
            java.lang.StringBuilder r1 = r1.append(r3)
            java.lang.String r1 = r1.toString()
        L_0x00d3:
            android.content.Context r2 = r0.getContext()
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r3 = 0
            android.widget.Toast r1 = android.widget.Toast.makeText(r2, r1, r3)
            r1.show()
            r1 = r0
            androidx.fragment.app.Fragment r1 = (androidx.fragment.app.Fragment) r1
            androidx.navigation.NavController r1 = androidx.navigation.fragment.FragmentKt.findNavController(r1)
            r1.navigateUp()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.armmc.app.ui.servers.CreateServerFragment.saveServer(java.lang.String, java.lang.String, java.lang.String, int, java.lang.String, int, int, int, java.lang.String, java.lang.String, java.lang.String, java.lang.String, boolean, boolean, java.lang.String, boolean, java.lang.String):void");
    }
}
