package com.armmc.app.ui.servers;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.InputFilter;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatDelegate;
import com.armmc.app.R;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\f\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0011\u0018\u0000 >2\u00020\u0001:\u0001>B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0018\u001a\u00020\u0019H\u0016J&\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J\u001a\u0010\"\u001a\u00020\u00132\u0006\u0010#\u001a\u00020\u001b2\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J\u0010\u0010$\u001a\u00020\u00132\u0006\u0010#\u001a\u00020\u001bH\u0002J\b\u0010%\u001a\u00020\u0013H\u0002J(\u0010&\u001a\u00020\u001b2\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\u00192\u0006\u0010,\u001a\u00020\u0010H\u0002J\u0010\u0010-\u001a\u00020.2\u0006\u0010+\u001a\u00020\u0019H\u0002J\b\u0010/\u001a\u00020\u0013H\u0002J \u00100\u001a\u00020\r2\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*2\u0006\u0010,\u001a\u00020\u0010H\u0002J\b\u00101\u001a\u00020.H\u0002J\b\u00102\u001a\u00020\u0013H\u0002J\u0010\u00103\u001a\u00020\u00132\u0006\u0010)\u001a\u00020*H\u0002J\b\u00104\u001a\u00020\u0013H\u0002J\b\u00105\u001a\u00020\u0013H\u0002J\u0010\u00106\u001a\u00020\u00132\u0006\u00107\u001a\u00020\u0010H\u0002J\b\u00108\u001a\u00020\u0013H\u0016J\u001a\u00109\u001a\u00020\u00132\u0012\u0010:\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00130\u0012J\b\u0010;\u001a\u00020\u0013H\u0002J\u0010\u0010<\u001a\u00020\u00192\u0006\u0010=\u001a\u00020\u0019H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X.¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X.¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX.¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX.¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX.¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX.¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u000e¢\u0006\u0002\n\u0000¨\u0006?"}, d2 = {"Lcom/armmc/app/ui/servers/MotdBuilderDialog;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "<init>", "()V", "motdPreview", "Landroid/widget/TextView;", "motdEditText", "Landroid/widget/EditText;", "charCountText", "colorsContainer", "Landroid/widget/LinearLayout;", "stylesContainer", "cancelButton", "Landroid/widget/Button;", "applyButton", "currentMotd", "", "onMotdApplied", "Lkotlin/Function1;", "", "obfuscateHandler", "Landroid/os/Handler;", "obfuscateRunnable", "Ljava/lang/Runnable;", "getTheme", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "initializeViews", "setupColorButtons", "createColorButton", "context", "Landroid/content/Context;", "code", "", "color", "name", "createColorCircleDrawable", "Landroid/graphics/drawable/GradientDrawable;", "setupStyleButtons", "createStyleButton", "createStyleButtonBackground", "setupListeners", "insertCodeAtCursor", "updatePreview", "updateCharCount", "startObfuscatedAnimation", "text", "onDestroyView", "setOnMotdAppliedListener", "listener", "hideKeyboard", "dpToPx", "dp", "Companion", "app_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* compiled from: MotdBuilderDialog.kt */
public final class MotdBuilderDialog extends BottomSheetDialogFragment {
    private static final String ARG_INITIAL_MOTD = "initial_motd";
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final int MAX_CHARACTERS = 59;
    private Button applyButton;
    private Button cancelButton;
    private TextView charCountText;
    private LinearLayout colorsContainer;
    /* access modifiers changed from: private */
    public String currentMotd = "";
    /* access modifiers changed from: private */
    public EditText motdEditText;
    /* access modifiers changed from: private */
    public TextView motdPreview;
    /* access modifiers changed from: private */
    public final Handler obfuscateHandler = new Handler(Looper.getMainLooper());
    private Runnable obfuscateRunnable;
    private Function1<? super String, Unit> onMotdApplied;
    private LinearLayout stylesContainer;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u0005R\u000e\u0010\u0004\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/armmc/app/ui/servers/MotdBuilderDialog$Companion;", "", "<init>", "()V", "ARG_INITIAL_MOTD", "", "MAX_CHARACTERS", "", "newInstance", "Lcom/armmc/app/ui/servers/MotdBuilderDialog;", "initialMotd", "app_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* compiled from: MotdBuilderDialog.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static /* synthetic */ MotdBuilderDialog newInstance$default(Companion companion, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = "";
            }
            return companion.newInstance(str);
        }

        public final MotdBuilderDialog newInstance(String str) {
            Intrinsics.checkNotNullParameter(str, "initialMotd");
            MotdBuilderDialog motdBuilderDialog = new MotdBuilderDialog();
            Bundle bundle = new Bundle();
            bundle.putString(MotdBuilderDialog.ARG_INITIAL_MOTD, str);
            motdBuilderDialog.setArguments(bundle);
            return motdBuilderDialog;
        }
    }

    public int getTheme() {
        return R.style.BottomSheetDialogTheme;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.dialog_motd_builder, viewGroup, false);
    }

    public void onViewCreated(View view, Bundle bundle) {
        String str;
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        initializeViews(view);
        setupColorButtons();
        setupStyleButtons();
        setupListeners();
        Bundle arguments = getArguments();
        if (arguments == null || (str = arguments.getString(ARG_INITIAL_MOTD)) == null) {
            str = "";
        }
        this.currentMotd = str;
        EditText editText = this.motdEditText;
        if (editText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("motdEditText");
            editText = null;
        }
        editText.setText(this.currentMotd);
        updatePreview();
        updateCharCount();
    }

    private final void initializeViews(View view) {
        this.motdPreview = (TextView) view.findViewById(R.id.motdPreview);
        this.motdEditText = (EditText) view.findViewById(R.id.motdEditText);
        this.charCountText = (TextView) view.findViewById(R.id.charCountText);
        this.colorsContainer = (LinearLayout) view.findViewById(R.id.colorsContainer);
        this.stylesContainer = (LinearLayout) view.findViewById(R.id.stylesContainer);
        this.cancelButton = (Button) view.findViewById(R.id.cancelButton);
        this.applyButton = (Button) view.findViewById(R.id.applyButton);
    }

    private final void setupColorButtons() {
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
        for (Character charValue : MinecraftTextFormatter.INSTANCE.getColorCodes()) {
            char charValue2 = charValue.charValue();
            Integer colorForCode = MinecraftTextFormatter.INSTANCE.getColorForCode(charValue2);
            int intValue = colorForCode != null ? colorForCode.intValue() : -1;
            String str = MinecraftTextFormatter.INSTANCE.getColorNames().get(Character.valueOf(charValue2));
            if (str == null) {
                str = "Unknown";
            }
            View createColorButton = createColorButton(requireContext, charValue2, intValue, str);
            LinearLayout linearLayout = this.colorsContainer;
            if (linearLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("colorsContainer");
                linearLayout = null;
            }
            linearLayout.addView(createColorButton);
        }
    }

    private final View createColorButton(Context context, char c, int i, String str) {
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(1);
        linearLayout.setPadding(dpToPx(8), dpToPx(8), dpToPx(8), dpToPx(8));
        View view = new View(context);
        view.setLayoutParams(new LinearLayout.LayoutParams(dpToPx(36), dpToPx(36)));
        view.setBackground(createColorCircleDrawable(i));
        TextView textView = new TextView(context);
        textView.setText("§" + c);
        textView.setTextColor(Color.parseColor("#8A9A8A"));
        textView.setTextSize(10.0f);
        textView.setTypeface(Typeface.MONOSPACE);
        textView.setGravity(17);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = dpToPx(4);
        textView.setLayoutParams(layoutParams);
        linearLayout.addView(view);
        linearLayout.addView(textView);
        linearLayout.setOnClickListener(new MotdBuilderDialog$$ExternalSyntheticLambda0(this, c));
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.setMarginEnd(dpToPx(4));
        linearLayout.setLayoutParams(layoutParams2);
        return linearLayout;
    }

    /* access modifiers changed from: private */
    public static final void createColorButton$lambda$5$lambda$4(MotdBuilderDialog motdBuilderDialog, char c, View view) {
        motdBuilderDialog.insertCodeAtCursor(c);
    }

    private final GradientDrawable createColorCircleDrawable(int i) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(1);
        gradientDrawable.setColor(i);
        gradientDrawable.setStroke(dpToPx(2), Color.parseColor("#3d563d"));
        return gradientDrawable;
    }

    private final void setupStyleButtons() {
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
        for (Character charValue : MinecraftTextFormatter.INSTANCE.getStyleCodes()) {
            char charValue2 = charValue.charValue();
            String str = MinecraftTextFormatter.INSTANCE.getStyleNames().get(Character.valueOf(charValue2));
            if (str == null) {
                str = "Unknown";
            }
            Button createStyleButton = createStyleButton(requireContext, charValue2, str);
            LinearLayout linearLayout = this.stylesContainer;
            if (linearLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("stylesContainer");
                linearLayout = null;
            }
            linearLayout.addView(createStyleButton);
        }
    }

    private final Button createStyleButton(Context context, char c, String str) {
        Button button = new Button(context);
        button.setText(str);
        button.setTextSize(12.0f);
        button.setTextColor(-1);
        button.setAllCaps(false);
        switch (c) {
            case AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR:
                button.setTypeface(button.getTypeface(), 1);
                break;
            case AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY:
                button.setPaintFlags(button.getPaintFlags() | 16);
                break;
            case 'n':
                button.setPaintFlags(button.getPaintFlags() | 8);
                break;
            case 'o':
                button.setTypeface(button.getTypeface(), 2);
                break;
        }
        button.setBackground(createStyleButtonBackground());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, dpToPx(40));
        layoutParams.setMarginEnd(dpToPx(8));
        button.setLayoutParams(layoutParams);
        button.setPadding(dpToPx(16), 0, dpToPx(16), 0);
        button.setOnClickListener(new MotdBuilderDialog$$ExternalSyntheticLambda5(this, c));
        return button;
    }

    /* access modifiers changed from: private */
    public static final void createStyleButton$lambda$11$lambda$10(MotdBuilderDialog motdBuilderDialog, char c, View view) {
        motdBuilderDialog.insertCodeAtCursor(c);
    }

    private final GradientDrawable createStyleButtonBackground() {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadius((float) dpToPx(8));
        gradientDrawable.setColor(Color.parseColor("#2A4A2A"));
        gradientDrawable.setStroke(dpToPx(1), Color.parseColor("#3d563d"));
        return gradientDrawable;
    }

    private final void setupListeners() {
        EditText editText = this.motdEditText;
        Button button = null;
        if (editText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("motdEditText");
            editText = null;
        }
        editText.setFilters((InputFilter[]) new InputFilter.LengthFilter[]{new InputFilter.LengthFilter(MAX_CHARACTERS)});
        EditText editText2 = this.motdEditText;
        if (editText2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("motdEditText");
            editText2 = null;
        }
        editText2.addTextChangedListener(new MotdBuilderDialog$setupListeners$1(this));
        EditText editText3 = this.motdEditText;
        if (editText3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("motdEditText");
            editText3 = null;
        }
        editText3.setOnEditorActionListener(new MotdBuilderDialog$$ExternalSyntheticLambda1(this));
        View view = getView();
        if (view != null) {
            view.setOnTouchListener(new MotdBuilderDialog$$ExternalSyntheticLambda2(this));
        }
        Button button2 = this.cancelButton;
        if (button2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cancelButton");
            button2 = null;
        }
        button2.setOnClickListener(new MotdBuilderDialog$$ExternalSyntheticLambda3(this));
        Button button3 = this.applyButton;
        if (button3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("applyButton");
        } else {
            button = button3;
        }
        button.setOnClickListener(new MotdBuilderDialog$$ExternalSyntheticLambda4(this));
    }

    /* access modifiers changed from: private */
    public static final boolean setupListeners$lambda$13(MotdBuilderDialog motdBuilderDialog, TextView textView, int i, KeyEvent keyEvent) {
        if (i != 6 && (keyEvent == null || keyEvent.getKeyCode() != 66 || keyEvent.getAction() != 0)) {
            return false;
        }
        motdBuilderDialog.hideKeyboard();
        return true;
    }

    /* access modifiers changed from: private */
    public static final boolean setupListeners$lambda$14(MotdBuilderDialog motdBuilderDialog, View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() != 0) {
            return false;
        }
        motdBuilderDialog.hideKeyboard();
        EditText editText = motdBuilderDialog.motdEditText;
        if (editText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("motdEditText");
            editText = null;
        }
        editText.clearFocus();
        return false;
    }

    /* access modifiers changed from: private */
    public static final void setupListeners$lambda$15(MotdBuilderDialog motdBuilderDialog, View view) {
        motdBuilderDialog.dismiss();
    }

    /* access modifiers changed from: private */
    public static final void setupListeners$lambda$16(MotdBuilderDialog motdBuilderDialog, View view) {
        Function1<? super String, Unit> function1 = motdBuilderDialog.onMotdApplied;
        if (function1 != null) {
            function1.invoke(motdBuilderDialog.currentMotd);
        }
        motdBuilderDialog.dismiss();
    }

    private final void insertCodeAtCursor(char c) {
        EditText editText = this.motdEditText;
        EditText editText2 = null;
        if (editText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("motdEditText");
            editText = null;
        }
        int selectionStart = editText.getSelectionStart();
        EditText editText3 = this.motdEditText;
        if (editText3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("motdEditText");
            editText3 = null;
        }
        String obj = editText3.getText().toString();
        String substring = obj.substring(0, selectionStart);
        Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
        String substring2 = obj.substring(selectionStart);
        Intrinsics.checkNotNullExpressionValue(substring2, "substring(...)");
        String str = substring + ("§" + c) + substring2;
        if (str.length() <= MAX_CHARACTERS) {
            EditText editText4 = this.motdEditText;
            if (editText4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("motdEditText");
                editText4 = null;
            }
            editText4.setText(str);
            EditText editText5 = this.motdEditText;
            if (editText5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("motdEditText");
            } else {
                editText2 = editText5;
            }
            editText2.setSelection(selectionStart + 2);
        }
    }

    /* access modifiers changed from: private */
    public final void updatePreview() {
        String str;
        Runnable runnable = this.obfuscateRunnable;
        if (runnable != null) {
            this.obfuscateHandler.removeCallbacks(runnable);
        }
        if (this.currentMotd.length() == 0) {
            str = "A Minecraft Server";
        } else {
            str = this.currentMotd;
        }
        CharSequence charSequence = str;
        if (StringsKt.contains$default(charSequence, (CharSequence) "§k", false, 2, (Object) null) || StringsKt.contains$default(charSequence, (CharSequence) "&k", false, 2, (Object) null)) {
            startObfuscatedAnimation(str);
            return;
        }
        TextView textView = this.motdPreview;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("motdPreview");
            textView = null;
        }
        textView.setText(MinecraftTextFormatter.format$default(MinecraftTextFormatter.INSTANCE, str, false, 2, (Object) null));
    }

    /* access modifiers changed from: private */
    public final void updateCharCount() {
        int length = this.currentMotd.length();
        TextView textView = this.charCountText;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("charCountText");
            textView = null;
        }
        textView.setText(length + "/59");
    }

    private final void startObfuscatedAnimation(String str) {
        Runnable motdBuilderDialog$startObfuscatedAnimation$1 = new MotdBuilderDialog$startObfuscatedAnimation$1(this, str);
        this.obfuscateRunnable = motdBuilderDialog$startObfuscatedAnimation$1;
        Handler handler = this.obfuscateHandler;
        Intrinsics.checkNotNull(motdBuilderDialog$startObfuscatedAnimation$1);
        handler.post(motdBuilderDialog$startObfuscatedAnimation$1);
    }

    public void onDestroyView() {
        super.onDestroyView();
        Runnable runnable = this.obfuscateRunnable;
        if (runnable != null) {
            this.obfuscateHandler.removeCallbacks(runnable);
        }
    }

    public final void setOnMotdAppliedListener(Function1<? super String, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.onMotdApplied = function1;
    }

    private final void hideKeyboard() {
        Object systemService = requireContext().getSystemService("input_method");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        InputMethodManager inputMethodManager = (InputMethodManager) systemService;
        EditText editText = this.motdEditText;
        if (editText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("motdEditText");
            editText = null;
        }
        inputMethodManager.hideSoftInputFromWindow(editText.getWindowToken(), 0);
    }

    private final int dpToPx(int i) {
        return (int) (((float) i) * getResources().getDisplayMetrics().density);
    }
}
