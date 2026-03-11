package com.armmc.app;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.armmc.app.ui.logs.LogEntry;
import com.armmc.app.ui.logs.LogLevel;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.RegexOption;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0018J\u0010\u0010\u001c\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u0015H\u0007J\u000e\u0010\u001e\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u0015J\u000e\u0010\u001f\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u0015J\u0010\u0010 \u001a\u00020!2\u0006\u0010\u001d\u001a\u00020\u0015H\u0002J\u0010\u0010\"\u001a\u00020\u00152\u0006\u0010\u001d\u001a\u00020\u0015H\u0002R\u001a\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0005X\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\t8F¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR4\u0010\f\u001a&\u0012\f\u0012\n \u000e*\u0004\u0018\u00010\u00070\u0007 \u000e*\u0012\u0012\f\u0012\n \u000e*\u0004\u0018\u00010\u00070\u0007\u0018\u00010\u00060\rX\u0004¢\u0006\u0004\n\u0002\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0011XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0015XT¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u000e¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/armmc/app/LogManager;", "", "<init>", "()V", "_logs", "Landroidx/lifecycle/MutableLiveData;", "", "Lcom/armmc/app/ui/logs/LogEntry;", "logs", "Landroidx/lifecycle/LiveData;", "getLogs", "()Landroidx/lifecycle/LiveData;", "logEntries", "", "kotlin.jvm.PlatformType", "Ljava/util/List;", "MAX_LOG_LINES", "", "dateFormat", "Ljava/text/SimpleDateFormat;", "ACTION_LOG_MESSAGE", "", "EXTRA_MESSAGE", "appContext", "Landroid/content/Context;", "init", "", "context", "receiveNativeLog", "message", "receiveLogFromBroadcast", "addCrashLog", "detectLogLevel", "Lcom/armmc/app/ui/logs/LogLevel;", "stripLogLevel", "app_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* compiled from: LogManager.kt */
public final class LogManager {
    public static final String ACTION_LOG_MESSAGE = "com.armmc.app.LOG_MESSAGE";
    public static final String EXTRA_MESSAGE = "message";
    public static final LogManager INSTANCE = new LogManager();
    private static final int MAX_LOG_LINES = 100;
    private static final MutableLiveData<List<LogEntry>> _logs = new MutableLiveData<>(CollectionsKt.emptyList());
    private static Context appContext;
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss", Locale.getDefault());
    private static final List<LogEntry> logEntries = Collections.synchronizedList(new ArrayList());

    private LogManager() {
    }

    public final LiveData<List<LogEntry>> getLogs() {
        return _logs;
    }

    public final void init(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        appContext = context.getApplicationContext();
    }

    @JvmStatic
    public static final void receiveNativeLog(String str) {
        int i;
        Intrinsics.checkNotNullParameter(str, EXTRA_MESSAGE);
        List<LogEntry> list = logEntries;
        Intrinsics.checkNotNullExpressionValue(list, "logEntries");
        synchronized (list) {
            String format = dateFormat.format(new Date());
            LogManager logManager = INSTANCE;
            LogLevel detectLogLevel = logManager.detectLogLevel(str);
            String stripLogLevel = logManager.stripLogLevel(str);
            Intrinsics.checkNotNull(format);
            list.add(new LogEntry(format, detectLogLevel, stripLogLevel));
            if (list.size() > 100) {
                list.remove(0);
            }
            MutableLiveData<List<LogEntry>> mutableLiveData = _logs;
            Intrinsics.checkNotNullExpressionValue(list, "logEntries");
            mutableLiveData.postValue(CollectionsKt.toList(list));
            Context context = appContext;
            if (context != null) {
                try {
                    Intent intent = new Intent(ACTION_LOG_MESSAGE);
                    intent.putExtra(EXTRA_MESSAGE, str);
                    intent.setPackage(context.getPackageName());
                    context.sendBroadcast(intent);
                    i = Log.d("LogManager", "Sent broadcast: " + str);
                } catch (Exception e) {
                    i = Log.e("LogManager", "Failed to send broadcast", e);
                }
                Integer.valueOf(i);
            }
        }
    }

    public final void receiveLogFromBroadcast(String str) {
        Intrinsics.checkNotNullParameter(str, EXTRA_MESSAGE);
        List<LogEntry> list = logEntries;
        Intrinsics.checkNotNullExpressionValue(list, "logEntries");
        synchronized (list) {
            Log.d("LogManager", "Received broadcast: " + str);
            String format = dateFormat.format(new Date());
            LogManager logManager = INSTANCE;
            LogLevel detectLogLevel = logManager.detectLogLevel(str);
            String stripLogLevel = logManager.stripLogLevel(str);
            Intrinsics.checkNotNull(format);
            list.add(new LogEntry(format, detectLogLevel, stripLogLevel));
            if (list.size() > 100) {
                list.remove(0);
            }
            MutableLiveData<List<LogEntry>> mutableLiveData = _logs;
            Intrinsics.checkNotNullExpressionValue(list, "logEntries");
            mutableLiveData.postValue(CollectionsKt.toList(list));
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void addCrashLog(String str) {
        Intrinsics.checkNotNullParameter(str, EXTRA_MESSAGE);
        List<LogEntry> list = logEntries;
        Intrinsics.checkNotNullExpressionValue(list, "logEntries");
        synchronized (list) {
            String format = dateFormat.format(new Date());
            Intrinsics.checkNotNull(format);
            list.add(new LogEntry(format, LogLevel.ERROR, "💥 CRASH: " + str));
            if (list.size() > 100) {
                list.remove(0);
            }
            MutableLiveData<List<LogEntry>> mutableLiveData = _logs;
            Intrinsics.checkNotNullExpressionValue(list, "logEntries");
            mutableLiveData.postValue(CollectionsKt.toList(list));
            Unit unit = Unit.INSTANCE;
        }
    }

    private final LogLevel detectLogLevel(String str) {
        CharSequence charSequence = str;
        if (StringsKt.contains(charSequence, (CharSequence) "ERROR", true)) {
            return LogLevel.ERROR;
        }
        if (StringsKt.contains(charSequence, (CharSequence) "WARN", true)) {
            return LogLevel.WARN;
        }
        if (StringsKt.contains(charSequence, (CharSequence) "DEBUG", true)) {
            return LogLevel.DEBUG;
        }
        if (StringsKt.contains(charSequence, (CharSequence) "INFO", true)) {
            return LogLevel.INFO;
        }
        return LogLevel.INFO;
    }

    private final String stripLogLevel(String str) {
        return StringsKt.trim((CharSequence) new Regex("\\[?(ERROR|WARN|INFO|DEBUG)\\]?[:\\s-]*", RegexOption.IGNORE_CASE).replace((CharSequence) str, "")).toString();
    }
}
