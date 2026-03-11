package com.armmc.app;

import com.armmc.app.announcements.Announcement;
import kotlin.jvm.functions.Function1;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class MainActivity$$ExternalSyntheticLambda2 implements Function1 {
    public final /* synthetic */ MainActivity f$0;

    public /* synthetic */ MainActivity$$ExternalSyntheticLambda2(MainActivity mainActivity) {
        this.f$0 = mainActivity;
    }

    public final Object invoke(Object obj) {
        return MainActivity.showNextAnnouncement$lambda$12(this.f$0, (Announcement) obj);
    }
}
