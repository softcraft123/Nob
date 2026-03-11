package com.armmc.app.ui.servers;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.armmc.app.MinecraftApiService;
import com.armmc.app.R;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.concurrent.ThreadsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u0000 <2\u00020\u0001:\u0001<B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010 \u001a\u00020!H\u0016J&\u0010\"\u001a\u0004\u0018\u00010\u000b2\u0006\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010&2\b\u0010'\u001a\u0004\u0018\u00010(H\u0016J\u001a\u0010)\u001a\u00020\u001d2\u0006\u0010*\u001a\u00020\u000b2\b\u0010'\u001a\u0004\u0018\u00010(H\u0016J\u0010\u0010+\u001a\u00020\u001d2\u0006\u0010*\u001a\u00020\u000bH\u0002J\b\u0010,\u001a\u00020\u001dH\u0002J\b\u0010-\u001a\u00020\u001dH\u0002J\u0010\u0010.\u001a\u00020\u001d2\u0006\u0010/\u001a\u000200H\u0002J\u0010\u00101\u001a\u00020\u001d2\u0006\u00102\u001a\u00020\u001aH\u0002J\u001a\u00103\u001a\u00020\u001d2\u0006\u00104\u001a\u0002052\b\b\u0002\u00106\u001a\u000207H\u0002J\b\u00108\u001a\u00020\u001dH\u0002J\u001a\u00109\u001a\u00020\u001d2\u0012\u0010:\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u001d0\u001cJ\b\u0010;\u001a\u00020\u001dH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X.¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX.¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX.¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX.¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX.¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\rX.¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0011X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u001b\u001a\u0010\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u001cX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001a0\u001fX\u000e¢\u0006\u0002\n\u0000¨\u0006="}, d2 = {"Lcom/armmc/app/ui/servers/WhitelistPlayerLookupDialog;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "<init>", "()V", "usernameInput", "Landroid/widget/EditText;", "searchButton", "Landroid/widget/ImageButton;", "loadingIndicator", "Landroid/widget/ProgressBar;", "resultContainer", "Landroid/view/View;", "playerNameText", "Landroid/widget/TextView;", "playerUuidText", "statusText", "addButton", "Landroid/widget/Button;", "cancelButton", "minecraftApiService", "Lcom/armmc/app/MinecraftApiService;", "handler", "Landroid/os/Handler;", "searchRunnable", "Ljava/lang/Runnable;", "foundEntry", "Lcom/armmc/app/ui/servers/WhitelistEntry;", "onPlayerAdded", "Lkotlin/Function1;", "", "existingEntries", "", "getTheme", "", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "initializeViews", "setupListeners", "performSearch", "handleSearchResult", "result", "Lcom/armmc/app/MinecraftApiService$LookupResult;", "showPlayerResult", "entry", "showStatus", "message", "", "isError", "", "hideKeyboard", "setOnPlayerAddedListener", "listener", "onDestroyView", "Companion", "app_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* compiled from: WhitelistPlayerLookupDialog.kt */
public final class WhitelistPlayerLookupDialog extends BottomSheetDialogFragment {
    private static final String ARG_EXISTING_ENTRIES = "existing_entries";
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final long DEBOUNCE_DELAY_MS = 500;
    /* access modifiers changed from: private */
    public Button addButton;
    private Button cancelButton;
    private List<WhitelistEntry> existingEntries = CollectionsKt.emptyList();
    /* access modifiers changed from: private */
    public WhitelistEntry foundEntry;
    /* access modifiers changed from: private */
    public final Handler handler = new Handler(Looper.getMainLooper());
    private ProgressBar loadingIndicator;
    private final MinecraftApiService minecraftApiService = new MinecraftApiService();
    private Function1<? super WhitelistEntry, Unit> onPlayerAdded;
    private TextView playerNameText;
    private TextView playerUuidText;
    /* access modifiers changed from: private */
    public View resultContainer;
    private ImageButton searchButton;
    /* access modifiers changed from: private */
    public Runnable searchRunnable;
    /* access modifiers changed from: private */
    public TextView statusText;
    private EditText usernameInput;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0007R\u000e\u0010\u0004\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/armmc/app/ui/servers/WhitelistPlayerLookupDialog$Companion;", "", "<init>", "()V", "DEBOUNCE_DELAY_MS", "", "ARG_EXISTING_ENTRIES", "", "newInstance", "Lcom/armmc/app/ui/servers/WhitelistPlayerLookupDialog;", "existingEntriesJson", "app_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* compiled from: WhitelistPlayerLookupDialog.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static /* synthetic */ WhitelistPlayerLookupDialog newInstance$default(Companion companion, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = null;
            }
            return companion.newInstance(str);
        }

        public final WhitelistPlayerLookupDialog newInstance(String str) {
            WhitelistPlayerLookupDialog whitelistPlayerLookupDialog = new WhitelistPlayerLookupDialog();
            Bundle bundle = new Bundle();
            bundle.putString(WhitelistPlayerLookupDialog.ARG_EXISTING_ENTRIES, str);
            whitelistPlayerLookupDialog.setArguments(bundle);
            return whitelistPlayerLookupDialog;
        }
    }

    public int getTheme() {
        return R.style.BottomSheetDialogTheme;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.dialog_whitelist_player_lookup, viewGroup, false);
    }

    public void onViewCreated(View view, Bundle bundle) {
        String string;
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        Bundle arguments = getArguments();
        if (!(arguments == null || (string = arguments.getString(ARG_EXISTING_ENTRIES)) == null)) {
            this.existingEntries = WhitelistEntry.Companion.fromJson(string);
        }
        initializeViews(view);
        setupListeners();
    }

    private final void initializeViews(View view) {
        this.usernameInput = (EditText) view.findViewById(R.id.usernameInput);
        this.searchButton = (ImageButton) view.findViewById(R.id.searchButton);
        this.loadingIndicator = (ProgressBar) view.findViewById(R.id.loadingIndicator);
        this.resultContainer = view.findViewById(R.id.resultContainer);
        this.playerNameText = (TextView) view.findViewById(R.id.playerNameText);
        this.playerUuidText = (TextView) view.findViewById(R.id.playerUuidText);
        this.statusText = (TextView) view.findViewById(R.id.statusText);
        this.addButton = (Button) view.findViewById(R.id.addButton);
        this.cancelButton = (Button) view.findViewById(R.id.cancelButton);
        View view2 = this.resultContainer;
        TextView textView = null;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("resultContainer");
            view2 = null;
        }
        view2.setVisibility(8);
        Button button = this.addButton;
        if (button == null) {
            Intrinsics.throwUninitializedPropertyAccessException("addButton");
            button = null;
        }
        button.setVisibility(8);
        TextView textView2 = this.statusText;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("statusText");
        } else {
            textView = textView2;
        }
        textView.setVisibility(8);
    }

    private final void setupListeners() {
        EditText editText = this.usernameInput;
        Button button = null;
        if (editText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("usernameInput");
            editText = null;
        }
        editText.addTextChangedListener(new WhitelistPlayerLookupDialog$setupListeners$1(this));
        ImageButton imageButton = this.searchButton;
        if (imageButton == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchButton");
            imageButton = null;
        }
        imageButton.setOnClickListener(new WhitelistPlayerLookupDialog$$ExternalSyntheticLambda2(this));
        EditText editText2 = this.usernameInput;
        if (editText2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("usernameInput");
            editText2 = null;
        }
        editText2.setOnEditorActionListener(new WhitelistPlayerLookupDialog$$ExternalSyntheticLambda3(this));
        Button button2 = this.addButton;
        if (button2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("addButton");
            button2 = null;
        }
        button2.setOnClickListener(new WhitelistPlayerLookupDialog$$ExternalSyntheticLambda4(this));
        Button button3 = this.cancelButton;
        if (button3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cancelButton");
        } else {
            button = button3;
        }
        button.setOnClickListener(new WhitelistPlayerLookupDialog$$ExternalSyntheticLambda5(this));
    }

    /* access modifiers changed from: private */
    public static final void setupListeners$lambda$1(WhitelistPlayerLookupDialog whitelistPlayerLookupDialog, View view) {
        whitelistPlayerLookupDialog.performSearch();
    }

    /* access modifiers changed from: private */
    public static final boolean setupListeners$lambda$2(WhitelistPlayerLookupDialog whitelistPlayerLookupDialog, TextView textView, int i, KeyEvent keyEvent) {
        whitelistPlayerLookupDialog.performSearch();
        return true;
    }

    /* access modifiers changed from: private */
    public static final void setupListeners$lambda$4(WhitelistPlayerLookupDialog whitelistPlayerLookupDialog, View view) {
        WhitelistEntry whitelistEntry = whitelistPlayerLookupDialog.foundEntry;
        if (whitelistEntry != null) {
            Function1<? super WhitelistEntry, Unit> function1 = whitelistPlayerLookupDialog.onPlayerAdded;
            if (function1 != null) {
                function1.invoke(whitelistEntry);
            }
            whitelistPlayerLookupDialog.dismiss();
        }
    }

    /* access modifiers changed from: private */
    public static final void setupListeners$lambda$5(WhitelistPlayerLookupDialog whitelistPlayerLookupDialog, View view) {
        whitelistPlayerLookupDialog.dismiss();
    }

    private final void performSearch() {
        EditText editText = this.usernameInput;
        ImageButton imageButton = null;
        if (editText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("usernameInput");
            editText = null;
        }
        String obj = StringsKt.trim((CharSequence) editText.getText().toString()).toString();
        CharSequence charSequence = obj;
        if (charSequence.length() == 0) {
            showStatus("Please enter a username", true);
        } else if (!new Regex("^[a-zA-Z0-9_]{3,16}$").matches(charSequence)) {
            showStatus("Invalid username format", true);
        } else {
            hideKeyboard();
            ProgressBar progressBar = this.loadingIndicator;
            if (progressBar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("loadingIndicator");
                progressBar = null;
            }
            progressBar.setVisibility(0);
            View view = this.resultContainer;
            if (view == null) {
                Intrinsics.throwUninitializedPropertyAccessException("resultContainer");
                view = null;
            }
            view.setVisibility(8);
            Button button = this.addButton;
            if (button == null) {
                Intrinsics.throwUninitializedPropertyAccessException("addButton");
                button = null;
            }
            button.setVisibility(8);
            TextView textView = this.statusText;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("statusText");
                textView = null;
            }
            textView.setVisibility(8);
            ImageButton imageButton2 = this.searchButton;
            if (imageButton2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("searchButton");
            } else {
                imageButton = imageButton2;
            }
            imageButton.setEnabled(false);
            ThreadsKt.thread$default(false, false, (ClassLoader) null, (String) null, 0, new WhitelistPlayerLookupDialog$$ExternalSyntheticLambda0(this, obj), 31, (Object) null);
        }
    }

    /* access modifiers changed from: private */
    public static final Unit performSearch$lambda$7(WhitelistPlayerLookupDialog whitelistPlayerLookupDialog, String str) {
        whitelistPlayerLookupDialog.handler.post(new WhitelistPlayerLookupDialog$$ExternalSyntheticLambda1(whitelistPlayerLookupDialog, whitelistPlayerLookupDialog.minecraftApiService.lookupPlayer(str)));
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final void performSearch$lambda$7$lambda$6(WhitelistPlayerLookupDialog whitelistPlayerLookupDialog, MinecraftApiService.LookupResult lookupResult) {
        ProgressBar progressBar = whitelistPlayerLookupDialog.loadingIndicator;
        ImageButton imageButton = null;
        if (progressBar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("loadingIndicator");
            progressBar = null;
        }
        progressBar.setVisibility(8);
        ImageButton imageButton2 = whitelistPlayerLookupDialog.searchButton;
        if (imageButton2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchButton");
        } else {
            imageButton = imageButton2;
        }
        imageButton.setEnabled(true);
        whitelistPlayerLookupDialog.handleSearchResult(lookupResult);
    }

    private final void handleSearchResult(MinecraftApiService.LookupResult lookupResult) {
        if (lookupResult instanceof MinecraftApiService.LookupResult.Success) {
            WhitelistEntry entry = ((MinecraftApiService.LookupResult.Success) lookupResult).getEntry();
            Iterable<WhitelistEntry> iterable = this.existingEntries;
            if (!(iterable instanceof Collection) || !((Collection) iterable).isEmpty()) {
                for (WhitelistEntry uuid : iterable) {
                    if (StringsKt.equals(uuid.getUuid(), entry.getUuid(), true)) {
                        showStatus(entry.getName() + " is already in the whitelist", true);
                        return;
                    }
                }
            }
            this.foundEntry = entry;
            showPlayerResult(entry);
        } else if (lookupResult instanceof MinecraftApiService.LookupResult.NotFound) {
            showStatus("Player '" + ((MinecraftApiService.LookupResult.NotFound) lookupResult).getUsername() + "' not found", true);
        } else if (lookupResult instanceof MinecraftApiService.LookupResult.RateLimited) {
            showStatus("Too many requests. Please wait a moment.", true);
        } else if (lookupResult instanceof MinecraftApiService.LookupResult.Error) {
            showStatus(((MinecraftApiService.LookupResult.Error) lookupResult).getMessage(), true);
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }

    private final void showPlayerResult(WhitelistEntry whitelistEntry) {
        View view = this.resultContainer;
        TextView textView = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("resultContainer");
            view = null;
        }
        view.setVisibility(0);
        Button button = this.addButton;
        if (button == null) {
            Intrinsics.throwUninitializedPropertyAccessException("addButton");
            button = null;
        }
        button.setVisibility(0);
        TextView textView2 = this.statusText;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("statusText");
            textView2 = null;
        }
        textView2.setVisibility(8);
        TextView textView3 = this.playerNameText;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("playerNameText");
            textView3 = null;
        }
        textView3.setText(whitelistEntry.getName());
        TextView textView4 = this.playerUuidText;
        if (textView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("playerUuidText");
        } else {
            textView = textView4;
        }
        textView.setText(whitelistEntry.getUuid());
    }

    static /* synthetic */ void showStatus$default(WhitelistPlayerLookupDialog whitelistPlayerLookupDialog, String str, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        whitelistPlayerLookupDialog.showStatus(str, z);
    }

    private final void showStatus(String str, boolean z) {
        int i;
        TextView textView = this.statusText;
        Button button = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("statusText");
            textView = null;
        }
        textView.setVisibility(0);
        TextView textView2 = this.statusText;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("statusText");
            textView2 = null;
        }
        textView2.setText(str);
        TextView textView3 = this.statusText;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("statusText");
            textView3 = null;
        }
        if (z) {
            i = Color.parseColor("#FF6B6B");
        } else {
            i = Color.parseColor("#39FF14");
        }
        textView3.setTextColor(i);
        View view = this.resultContainer;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("resultContainer");
            view = null;
        }
        view.setVisibility(8);
        Button button2 = this.addButton;
        if (button2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("addButton");
        } else {
            button = button2;
        }
        button.setVisibility(8);
    }

    private final void hideKeyboard() {
        Object systemService = requireContext().getSystemService("input_method");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        InputMethodManager inputMethodManager = (InputMethodManager) systemService;
        EditText editText = this.usernameInput;
        if (editText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("usernameInput");
            editText = null;
        }
        inputMethodManager.hideSoftInputFromWindow(editText.getWindowToken(), 0);
    }

    public final void setOnPlayerAddedListener(Function1<? super WhitelistEntry, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.onPlayerAdded = function1;
    }

    public void onDestroyView() {
        super.onDestroyView();
        Runnable runnable = this.searchRunnable;
        if (runnable != null) {
            this.handler.removeCallbacks(runnable);
        }
    }
}
