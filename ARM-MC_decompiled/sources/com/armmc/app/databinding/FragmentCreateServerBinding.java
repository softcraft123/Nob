package com.armmc.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.armmc.app.R;
import com.google.android.material.card.MaterialCardView;
import com.google.android.material.switchmaterial.SwitchMaterial;

public final class FragmentCreateServerBinding implements ViewBinding {
    public final Button addWhitelistPlayerButton;
    public final Button createServerButton;
    public final MaterialCardView createServerContainer;
    public final LinearLayout customSetupContent;
    public final TextView customSetupTab;
    public final Spinner difficultySpinner;
    public final Button dismissTemplateBannerButton;
    public final SwitchMaterial eulaSwitch;
    public final ImageView faviconPreview;
    public final TextView faviconStatusText;
    public final Spinner gamemodeSpinner;
    public final SwitchMaterial hardcoreSwitch;
    public final FrameLayout loadingOverlay;
    public final ProgressBar loadingProgressBar;
    public final TextView loadingText;
    public final SeekBar maxPlayersSeekBar;
    public final TextView maxPlayersText;
    public final MaterialCardView memoryAllocationSection;
    public final TextView memoryMaxText;
    public final TextView memoryMidText;
    public final TextView memoryMinText;
    public final SeekBar memorySeekBar;
    public final TextView memoryValueText;
    public final LinearLayout motdButton;
    public final TextView motdPreviewText;
    public final SwitchMaterial onlineModeSwitch;
    public final EditText portInput;
    public final ImageButton removeFaviconButton;
    private final ConstraintLayout rootView;
    public final ScrollView scrollView;
    public final EditText seedInput;
    public final LinearLayout segmentedControlLayout;
    public final Button selectFaviconButton;
    public final EditText serverNameInput;
    public final SeekBar simulationDistanceSeekBar;
    public final TextView simulationDistanceText;
    public final Spinner softwareSpinner;
    public final MaterialCardView templateAppliedBanner;
    public final TextView templateAppliedTitle;
    public final LinearLayout templatesCardsContainer;
    public final LinearLayout templatesContent;
    public final TextView templatesTab;
    public final View topDivider;
    public final Spinner versionSpinner;
    public final SeekBar viewDistanceSeekBar;
    public final TextView viewDistanceText;
    public final LinearLayout whitelistContainer;
    public final TextView whitelistEmptyText;
    public final LinearLayout whitelistPlayersContainer;
    public final SwitchMaterial whitelistSwitch;

    private FragmentCreateServerBinding(ConstraintLayout constraintLayout, Button button, Button button2, MaterialCardView materialCardView, LinearLayout linearLayout, TextView textView, Spinner spinner, Button button3, SwitchMaterial switchMaterial, ImageView imageView, TextView textView2, Spinner spinner2, SwitchMaterial switchMaterial2, FrameLayout frameLayout, ProgressBar progressBar, TextView textView3, SeekBar seekBar, TextView textView4, MaterialCardView materialCardView2, TextView textView5, TextView textView6, TextView textView7, SeekBar seekBar2, TextView textView8, LinearLayout linearLayout2, TextView textView9, SwitchMaterial switchMaterial3, EditText editText, ImageButton imageButton, ScrollView scrollView2, EditText editText2, LinearLayout linearLayout3, Button button4, EditText editText3, SeekBar seekBar3, TextView textView10, Spinner spinner3, MaterialCardView materialCardView3, TextView textView11, LinearLayout linearLayout4, LinearLayout linearLayout5, TextView textView12, View view, Spinner spinner4, SeekBar seekBar4, TextView textView13, LinearLayout linearLayout6, TextView textView14, LinearLayout linearLayout7, SwitchMaterial switchMaterial4) {
        this.rootView = constraintLayout;
        this.addWhitelistPlayerButton = button;
        this.createServerButton = button2;
        this.createServerContainer = materialCardView;
        this.customSetupContent = linearLayout;
        this.customSetupTab = textView;
        this.difficultySpinner = spinner;
        this.dismissTemplateBannerButton = button3;
        this.eulaSwitch = switchMaterial;
        this.faviconPreview = imageView;
        this.faviconStatusText = textView2;
        this.gamemodeSpinner = spinner2;
        this.hardcoreSwitch = switchMaterial2;
        this.loadingOverlay = frameLayout;
        this.loadingProgressBar = progressBar;
        this.loadingText = textView3;
        this.maxPlayersSeekBar = seekBar;
        this.maxPlayersText = textView4;
        this.memoryAllocationSection = materialCardView2;
        this.memoryMaxText = textView5;
        this.memoryMidText = textView6;
        this.memoryMinText = textView7;
        this.memorySeekBar = seekBar2;
        this.memoryValueText = textView8;
        this.motdButton = linearLayout2;
        this.motdPreviewText = textView9;
        this.onlineModeSwitch = switchMaterial3;
        this.portInput = editText;
        this.removeFaviconButton = imageButton;
        this.scrollView = scrollView2;
        this.seedInput = editText2;
        this.segmentedControlLayout = linearLayout3;
        this.selectFaviconButton = button4;
        this.serverNameInput = editText3;
        this.simulationDistanceSeekBar = seekBar3;
        this.simulationDistanceText = textView10;
        this.softwareSpinner = spinner3;
        this.templateAppliedBanner = materialCardView3;
        this.templateAppliedTitle = textView11;
        this.templatesCardsContainer = linearLayout4;
        this.templatesContent = linearLayout5;
        this.templatesTab = textView12;
        this.topDivider = view;
        this.versionSpinner = spinner4;
        this.viewDistanceSeekBar = seekBar4;
        this.viewDistanceText = textView13;
        this.whitelistContainer = linearLayout6;
        this.whitelistEmptyText = textView14;
        this.whitelistPlayersContainer = linearLayout7;
        this.whitelistSwitch = switchMaterial4;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static FragmentCreateServerBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static FragmentCreateServerBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_create_server, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:82:0x01e3, code lost:
        r1 = com.armmc.app.R.id.topDivider;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.armmc.app.databinding.FragmentCreateServerBinding bind(android.view.View r54) {
        /*
            r0 = r54
            int r1 = com.armmc.app.R.id.addWhitelistPlayerButton
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r5 = r2
            android.widget.Button r5 = (android.widget.Button) r5
            if (r5 == 0) goto L_0x0248
            int r1 = com.armmc.app.R.id.createServerButton
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r6 = r2
            android.widget.Button r6 = (android.widget.Button) r6
            if (r6 == 0) goto L_0x0248
            int r1 = com.armmc.app.R.id.createServerContainer
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r7 = r2
            com.google.android.material.card.MaterialCardView r7 = (com.google.android.material.card.MaterialCardView) r7
            if (r7 == 0) goto L_0x0248
            int r1 = com.armmc.app.R.id.customSetupContent
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r8 = r2
            android.widget.LinearLayout r8 = (android.widget.LinearLayout) r8
            if (r8 == 0) goto L_0x0248
            int r1 = com.armmc.app.R.id.customSetupTab
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r9 = r2
            android.widget.TextView r9 = (android.widget.TextView) r9
            if (r9 == 0) goto L_0x0248
            int r1 = com.armmc.app.R.id.difficultySpinner
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r10 = r2
            android.widget.Spinner r10 = (android.widget.Spinner) r10
            if (r10 == 0) goto L_0x0248
            int r1 = com.armmc.app.R.id.dismissTemplateBannerButton
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r11 = r2
            android.widget.Button r11 = (android.widget.Button) r11
            if (r11 == 0) goto L_0x0248
            int r1 = com.armmc.app.R.id.eulaSwitch
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r12 = r2
            com.google.android.material.switchmaterial.SwitchMaterial r12 = (com.google.android.material.switchmaterial.SwitchMaterial) r12
            if (r12 == 0) goto L_0x0248
            int r1 = com.armmc.app.R.id.faviconPreview
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r13 = r2
            android.widget.ImageView r13 = (android.widget.ImageView) r13
            if (r13 == 0) goto L_0x0248
            int r1 = com.armmc.app.R.id.faviconStatusText
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r14 = r2
            android.widget.TextView r14 = (android.widget.TextView) r14
            if (r14 == 0) goto L_0x0248
            int r1 = com.armmc.app.R.id.gamemodeSpinner
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r15 = r2
            android.widget.Spinner r15 = (android.widget.Spinner) r15
            if (r15 == 0) goto L_0x0248
            int r1 = com.armmc.app.R.id.hardcoreSwitch
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r16 = r2
            com.google.android.material.switchmaterial.SwitchMaterial r16 = (com.google.android.material.switchmaterial.SwitchMaterial) r16
            if (r16 == 0) goto L_0x0248
            int r1 = com.armmc.app.R.id.loadingOverlay
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r17 = r2
            android.widget.FrameLayout r17 = (android.widget.FrameLayout) r17
            if (r17 == 0) goto L_0x0248
            int r1 = com.armmc.app.R.id.loadingProgressBar
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r18 = r2
            android.widget.ProgressBar r18 = (android.widget.ProgressBar) r18
            if (r18 == 0) goto L_0x0248
            int r1 = com.armmc.app.R.id.loadingText
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r19 = r2
            android.widget.TextView r19 = (android.widget.TextView) r19
            if (r19 == 0) goto L_0x0248
            int r1 = com.armmc.app.R.id.maxPlayersSeekBar
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r20 = r2
            android.widget.SeekBar r20 = (android.widget.SeekBar) r20
            if (r20 == 0) goto L_0x0248
            int r1 = com.armmc.app.R.id.maxPlayersText
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r21 = r2
            android.widget.TextView r21 = (android.widget.TextView) r21
            if (r21 == 0) goto L_0x0248
            int r1 = com.armmc.app.R.id.memoryAllocationSection
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r22 = r2
            com.google.android.material.card.MaterialCardView r22 = (com.google.android.material.card.MaterialCardView) r22
            if (r22 == 0) goto L_0x0248
            int r1 = com.armmc.app.R.id.memoryMaxText
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r23 = r2
            android.widget.TextView r23 = (android.widget.TextView) r23
            if (r23 == 0) goto L_0x0248
            int r1 = com.armmc.app.R.id.memoryMidText
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r24 = r2
            android.widget.TextView r24 = (android.widget.TextView) r24
            if (r24 == 0) goto L_0x0248
            int r1 = com.armmc.app.R.id.memoryMinText
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r25 = r2
            android.widget.TextView r25 = (android.widget.TextView) r25
            if (r25 == 0) goto L_0x0248
            int r1 = com.armmc.app.R.id.memorySeekBar
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r26 = r2
            android.widget.SeekBar r26 = (android.widget.SeekBar) r26
            if (r26 == 0) goto L_0x0248
            int r1 = com.armmc.app.R.id.memoryValueText
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r27 = r2
            android.widget.TextView r27 = (android.widget.TextView) r27
            if (r27 == 0) goto L_0x0248
            int r1 = com.armmc.app.R.id.motdButton
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r28 = r2
            android.widget.LinearLayout r28 = (android.widget.LinearLayout) r28
            if (r28 == 0) goto L_0x0248
            int r1 = com.armmc.app.R.id.motdPreviewText
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r29 = r2
            android.widget.TextView r29 = (android.widget.TextView) r29
            if (r29 == 0) goto L_0x0248
            int r1 = com.armmc.app.R.id.onlineModeSwitch
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r30 = r2
            com.google.android.material.switchmaterial.SwitchMaterial r30 = (com.google.android.material.switchmaterial.SwitchMaterial) r30
            if (r30 == 0) goto L_0x0248
            int r1 = com.armmc.app.R.id.portInput
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r31 = r2
            android.widget.EditText r31 = (android.widget.EditText) r31
            if (r31 == 0) goto L_0x0248
            int r1 = com.armmc.app.R.id.removeFaviconButton
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r32 = r2
            android.widget.ImageButton r32 = (android.widget.ImageButton) r32
            if (r32 == 0) goto L_0x0248
            int r1 = com.armmc.app.R.id.scrollView
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r33 = r2
            android.widget.ScrollView r33 = (android.widget.ScrollView) r33
            if (r33 == 0) goto L_0x0248
            int r1 = com.armmc.app.R.id.seedInput
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r34 = r2
            android.widget.EditText r34 = (android.widget.EditText) r34
            if (r34 == 0) goto L_0x0248
            int r1 = com.armmc.app.R.id.segmentedControlLayout
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r35 = r2
            android.widget.LinearLayout r35 = (android.widget.LinearLayout) r35
            if (r35 == 0) goto L_0x0248
            int r1 = com.armmc.app.R.id.selectFaviconButton
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r36 = r2
            android.widget.Button r36 = (android.widget.Button) r36
            if (r36 == 0) goto L_0x0248
            int r1 = com.armmc.app.R.id.serverNameInput
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r37 = r2
            android.widget.EditText r37 = (android.widget.EditText) r37
            if (r37 == 0) goto L_0x0248
            int r1 = com.armmc.app.R.id.simulationDistanceSeekBar
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r38 = r2
            android.widget.SeekBar r38 = (android.widget.SeekBar) r38
            if (r38 == 0) goto L_0x0248
            int r1 = com.armmc.app.R.id.simulationDistanceText
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r39 = r2
            android.widget.TextView r39 = (android.widget.TextView) r39
            if (r39 == 0) goto L_0x0248
            int r1 = com.armmc.app.R.id.softwareSpinner
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r40 = r2
            android.widget.Spinner r40 = (android.widget.Spinner) r40
            if (r40 == 0) goto L_0x0248
            int r1 = com.armmc.app.R.id.templateAppliedBanner
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r41 = r2
            com.google.android.material.card.MaterialCardView r41 = (com.google.android.material.card.MaterialCardView) r41
            if (r41 == 0) goto L_0x0248
            int r1 = com.armmc.app.R.id.templateAppliedTitle
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r42 = r2
            android.widget.TextView r42 = (android.widget.TextView) r42
            if (r42 == 0) goto L_0x0248
            int r1 = com.armmc.app.R.id.templatesCardsContainer
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r43 = r2
            android.widget.LinearLayout r43 = (android.widget.LinearLayout) r43
            if (r43 == 0) goto L_0x0248
            int r1 = com.armmc.app.R.id.templatesContent
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r44 = r2
            android.widget.LinearLayout r44 = (android.widget.LinearLayout) r44
            if (r44 == 0) goto L_0x0248
            int r1 = com.armmc.app.R.id.templatesTab
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r45 = r2
            android.widget.TextView r45 = (android.widget.TextView) r45
            if (r45 == 0) goto L_0x0248
            int r1 = com.armmc.app.R.id.topDivider
            android.view.View r46 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            if (r46 == 0) goto L_0x0248
            int r1 = com.armmc.app.R.id.versionSpinner
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r47 = r2
            android.widget.Spinner r47 = (android.widget.Spinner) r47
            if (r47 == 0) goto L_0x0248
            int r1 = com.armmc.app.R.id.viewDistanceSeekBar
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r48 = r2
            android.widget.SeekBar r48 = (android.widget.SeekBar) r48
            if (r48 == 0) goto L_0x0248
            int r1 = com.armmc.app.R.id.viewDistanceText
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r49 = r2
            android.widget.TextView r49 = (android.widget.TextView) r49
            if (r49 == 0) goto L_0x0248
            int r1 = com.armmc.app.R.id.whitelistContainer
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r50 = r2
            android.widget.LinearLayout r50 = (android.widget.LinearLayout) r50
            if (r50 == 0) goto L_0x0248
            int r1 = com.armmc.app.R.id.whitelistEmptyText
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r51 = r2
            android.widget.TextView r51 = (android.widget.TextView) r51
            if (r51 == 0) goto L_0x0248
            int r1 = com.armmc.app.R.id.whitelistPlayersContainer
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r52 = r2
            android.widget.LinearLayout r52 = (android.widget.LinearLayout) r52
            if (r52 == 0) goto L_0x0248
            int r1 = com.armmc.app.R.id.whitelistSwitch
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r53 = r2
            com.google.android.material.switchmaterial.SwitchMaterial r53 = (com.google.android.material.switchmaterial.SwitchMaterial) r53
            if (r53 == 0) goto L_0x0248
            com.armmc.app.databinding.FragmentCreateServerBinding r3 = new com.armmc.app.databinding.FragmentCreateServerBinding
            r4 = r0
            androidx.constraintlayout.widget.ConstraintLayout r4 = (androidx.constraintlayout.widget.ConstraintLayout) r4
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r42, r43, r44, r45, r46, r47, r48, r49, r50, r51, r52, r53)
            return r3
        L_0x0248:
            android.content.res.Resources r0 = r0.getResources()
            java.lang.String r0 = r0.getResourceName(r1)
            java.lang.NullPointerException r1 = new java.lang.NullPointerException
            java.lang.String r2 = "Missing required view with ID: "
            java.lang.String r0 = r2.concat(r0)
            r1.<init>(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.armmc.app.databinding.FragmentCreateServerBinding.bind(android.view.View):com.armmc.app.databinding.FragmentCreateServerBinding");
    }
}
