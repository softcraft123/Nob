package com.armmc.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import com.armmc.app.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public final class ActivityMainBinding implements ViewBinding {
    public final AppBarMainBinding appBarMain;
    public final BottomNavigationView bottomNavigationView;
    public final FloatingActionButton fabCreateServer;
    public final View fabGlow;
    private final RelativeLayout rootView;

    private ActivityMainBinding(RelativeLayout relativeLayout, AppBarMainBinding appBarMainBinding, BottomNavigationView bottomNavigationView2, FloatingActionButton floatingActionButton, View view) {
        this.rootView = relativeLayout;
        this.appBarMain = appBarMainBinding;
        this.bottomNavigationView = bottomNavigationView2;
        this.fabCreateServer = floatingActionButton;
        this.fabGlow = view;
    }

    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static ActivityMainBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static ActivityMainBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.activity_main, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0022, code lost:
        r0 = com.armmc.app.R.id.fabGlow;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.armmc.app.databinding.ActivityMainBinding bind(android.view.View r8) {
        /*
            int r0 = com.armmc.app.R.id.app_bar_main
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r8, r0)
            if (r1 == 0) goto L_0x0033
            com.armmc.app.databinding.AppBarMainBinding r4 = com.armmc.app.databinding.AppBarMainBinding.bind(r1)
            int r0 = com.armmc.app.R.id.bottomNavigationView
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r8, r0)
            r5 = r1
            com.google.android.material.bottomnavigation.BottomNavigationView r5 = (com.google.android.material.bottomnavigation.BottomNavigationView) r5
            if (r5 == 0) goto L_0x0033
            int r0 = com.armmc.app.R.id.fabCreateServer
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r8, r0)
            r6 = r1
            com.google.android.material.floatingactionbutton.FloatingActionButton r6 = (com.google.android.material.floatingactionbutton.FloatingActionButton) r6
            if (r6 == 0) goto L_0x0033
            int r0 = com.armmc.app.R.id.fabGlow
            android.view.View r7 = androidx.viewbinding.ViewBindings.findChildViewById(r8, r0)
            if (r7 == 0) goto L_0x0033
            com.armmc.app.databinding.ActivityMainBinding r2 = new com.armmc.app.databinding.ActivityMainBinding
            r3 = r8
            android.widget.RelativeLayout r3 = (android.widget.RelativeLayout) r3
            r2.<init>(r3, r4, r5, r6, r7)
            return r2
        L_0x0033:
            android.content.res.Resources r8 = r8.getResources()
            java.lang.String r8 = r8.getResourceName(r0)
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.String r1 = "Missing required view with ID: "
            java.lang.String r8 = r1.concat(r8)
            r0.<init>(r8)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.armmc.app.databinding.ActivityMainBinding.bind(android.view.View):com.armmc.app.databinding.ActivityMainBinding");
    }
}
