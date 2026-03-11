package com.armmc.app;

import android.app.Application;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Build;
import android.util.Log;
import com.google.android.play.core.splitcompat.SplitCompat;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0014J\b\u0010\u000b\u001a\u00020\bH\u0016R\u0010\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0004\n\u0002\u0010\u0006¨\u0006\f"}, d2 = {"Lcom/armmc/app/WitherHostApplication;", "Landroid/app/Application;", "<init>", "()V", "logReceiver", "com/armmc/app/WitherHostApplication$logReceiver$1", "Lcom/armmc/app/WitherHostApplication$logReceiver$1;", "attachBaseContext", "", "base", "Landroid/content/Context;", "onCreate", "app_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* compiled from: WitherHostApplication.kt */
public final class WitherHostApplication extends Application {
    private final WitherHostApplication$logReceiver$1 logReceiver = new WitherHostApplication$logReceiver$1();

    /* access modifiers changed from: protected */
    public void attachBaseContext(Context context) {
        super.attachBaseContext(context);
        SplitCompat.install(this);
    }

    public void onCreate() {
        super.onCreate();
        LogManager.INSTANCE.init(this);
        IntentFilter intentFilter = new IntentFilter(LogManager.ACTION_LOG_MESSAGE);
        if (Build.VERSION.SDK_INT >= 33) {
            registerReceiver(this.logReceiver, intentFilter, 4);
        } else {
            registerReceiver(this.logReceiver, intentFilter);
        }
        Log.d("WitherHostApplication", "Log receiver registered");
    }
}
