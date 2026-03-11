package com.armmc.app.ui.servers;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Debug;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import java.io.RandomAccessFile;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000k\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0010 \n\u0002\b\u0007*\u0001\"\bÆ\u0002\u0018\u00002\u00020\u0001:\u00016B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010$\u001a\u00020%H\u0002J\b\u0010&\u001a\u00020%H\u0002J\u0016\u0010'\u001a\u00020%2\u0006\u0010(\u001a\u00020\u00132\u0006\u0010)\u001a\u00020\u0007J\u000e\u0010*\u001a\u00020%2\u0006\u0010)\u001a\u00020\u0007J\u000e\u0010+\u001a\u00020%2\u0006\u0010(\u001a\u00020\u0013J\u0006\u0010,\u001a\u00020%J\u0006\u0010-\u001a\u00020%J\u0006\u0010.\u001a\u00020%J\f\u0010/\u001a\b\u0012\u0004\u0012\u00020\u001600J\u000e\u00101\u001a\u00020\u000e2\u0006\u0010)\u001a\u00020\u0007J\b\u00102\u001a\u00020%H\u0002J\u001c\u00103\u001a\u00020%2\u0006\u0010)\u001a\u00020\u00072\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u0013H\u0002J\b\u00104\u001a\u00020\u0007H\u0002J\b\u00105\u001a\u00020\u0007H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0004\n\u0002\u0010\u0010R\u0016\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0012X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018X\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00190\u001b¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u000e\u0010\u001e\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u00020\"X\u0004¢\u0006\u0004\n\u0002\u0010#¨\u00067"}, d2 = {"Lcom/armmc/app/ui/servers/ResourceMonitor;", "", "<init>", "()V", "UPDATE_INTERVAL_MS", "", "MAX_HISTORY_SIZE", "", "handlerThread", "Landroid/os/HandlerThread;", "backgroundHandler", "Landroid/os/Handler;", "mainHandler", "isMonitoring", "", "activeServerId", "Ljava/lang/Integer;", "contextRef", "Ljava/lang/ref/WeakReference;", "Landroid/content/Context;", "ramHistory", "", "", "_resourceData", "Landroidx/lifecycle/MutableLiveData;", "Lcom/armmc/app/ui/servers/ResourceMonitor$ResourceData;", "resourceData", "Landroidx/lifecycle/LiveData;", "getResourceData", "()Landroidx/lifecycle/LiveData;", "previousCpuTotal", "previousCpuIdle", "isAppInForeground", "updateRunnable", "com/armmc/app/ui/servers/ResourceMonitor$updateRunnable$1", "Lcom/armmc/app/ui/servers/ResourceMonitor$updateRunnable$1;", "ensureBackgroundThread", "", "stopBackgroundThread", "startMonitoring", "context", "serverId", "stopMonitoring", "resumeMonitoring", "pauseMonitoring", "onAppBackgrounded", "onAppForegrounded", "getRamHistory", "", "isMonitoringServer", "clearHistory", "updateResourceData", "getCpuUsage", "getSystemCpuUsageFallback", "ResourceData", "app_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* compiled from: ResourceMonitor.kt */
public final class ResourceMonitor {
    public static final ResourceMonitor INSTANCE = new ResourceMonitor();
    private static final int MAX_HISTORY_SIZE = 60;
    private static final long UPDATE_INTERVAL_MS = 300;
    private static final MutableLiveData<ResourceData> _resourceData;
    /* access modifiers changed from: private */
    public static Integer activeServerId;
    /* access modifiers changed from: private */
    public static Handler backgroundHandler;
    /* access modifiers changed from: private */
    public static WeakReference<Context> contextRef;
    private static HandlerThread handlerThread;
    /* access modifiers changed from: private */
    public static boolean isAppInForeground = true;
    /* access modifiers changed from: private */
    public static boolean isMonitoring;
    private static final Handler mainHandler = new Handler(Looper.getMainLooper());
    private static long previousCpuIdle;
    private static long previousCpuTotal;
    private static final List<Float> ramHistory = new ArrayList();
    private static final LiveData<ResourceData> resourceData;
    private static final ResourceMonitor$updateRunnable$1 updateRunnable = new ResourceMonitor$updateRunnable$1();

    private ResourceMonitor() {
    }

    static {
        MutableLiveData<ResourceData> mutableLiveData = new MutableLiveData<>();
        _resourceData = mutableLiveData;
        resourceData = mutableLiveData;
    }

    public final LiveData<ResourceData> getResourceData() {
        return resourceData;
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u0007\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\n0\tHÆ\u0003JA\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00032\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tHÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001f\u001a\u00020 HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000eR\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006!"}, d2 = {"Lcom/armmc/app/ui/servers/ResourceMonitor$ResourceData;", "", "serverId", "", "ramUsedMb", "", "ramTotalMb", "cpuUsagePercent", "ramHistory", "", "", "<init>", "(IJJILjava/util/List;)V", "getServerId", "()I", "getRamUsedMb", "()J", "getRamTotalMb", "getCpuUsagePercent", "getRamHistory", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "", "app_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* compiled from: ResourceMonitor.kt */
    public static final class ResourceData {
        private final int cpuUsagePercent;
        private final List<Float> ramHistory;
        private final long ramTotalMb;
        private final long ramUsedMb;
        private final int serverId;

        public static /* synthetic */ ResourceData copy$default(ResourceData resourceData, int i, long j, long j2, int i2, List<Float> list, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                i = resourceData.serverId;
            }
            if ((i3 & 2) != 0) {
                j = resourceData.ramUsedMb;
            }
            if ((i3 & 4) != 0) {
                j2 = resourceData.ramTotalMb;
            }
            if ((i3 & 8) != 0) {
                i2 = resourceData.cpuUsagePercent;
            }
            if ((i3 & 16) != 0) {
                list = resourceData.ramHistory;
            }
            long j3 = j2;
            long j4 = j;
            return resourceData.copy(i, j4, j3, i2, list);
        }

        public final int component1() {
            return this.serverId;
        }

        public final long component2() {
            return this.ramUsedMb;
        }

        public final long component3() {
            return this.ramTotalMb;
        }

        public final int component4() {
            return this.cpuUsagePercent;
        }

        public final List<Float> component5() {
            return this.ramHistory;
        }

        public final ResourceData copy(int i, long j, long j2, int i2, List<Float> list) {
            List<Float> list2 = list;
            Intrinsics.checkNotNullParameter(list2, "ramHistory");
            return new ResourceData(i, j, j2, i2, list2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ResourceData)) {
                return false;
            }
            ResourceData resourceData = (ResourceData) obj;
            return this.serverId == resourceData.serverId && this.ramUsedMb == resourceData.ramUsedMb && this.ramTotalMb == resourceData.ramTotalMb && this.cpuUsagePercent == resourceData.cpuUsagePercent && Intrinsics.areEqual((Object) this.ramHistory, (Object) resourceData.ramHistory);
        }

        public int hashCode() {
            return (((((((Integer.hashCode(this.serverId) * 31) + Long.hashCode(this.ramUsedMb)) * 31) + Long.hashCode(this.ramTotalMb)) * 31) + Integer.hashCode(this.cpuUsagePercent)) * 31) + this.ramHistory.hashCode();
        }

        public String toString() {
            int i = this.serverId;
            long j = this.ramUsedMb;
            long j2 = this.ramTotalMb;
            int i2 = this.cpuUsagePercent;
            return "ResourceData(serverId=" + i + ", ramUsedMb=" + j + ", ramTotalMb=" + j2 + ", cpuUsagePercent=" + i2 + ", ramHistory=" + this.ramHistory + ")";
        }

        public ResourceData(int i, long j, long j2, int i2, List<Float> list) {
            Intrinsics.checkNotNullParameter(list, "ramHistory");
            this.serverId = i;
            this.ramUsedMb = j;
            this.ramTotalMb = j2;
            this.cpuUsagePercent = i2;
            this.ramHistory = list;
        }

        public final int getServerId() {
            return this.serverId;
        }

        public final long getRamUsedMb() {
            return this.ramUsedMb;
        }

        public final long getRamTotalMb() {
            return this.ramTotalMb;
        }

        public final int getCpuUsagePercent() {
            return this.cpuUsagePercent;
        }

        public final List<Float> getRamHistory() {
            return this.ramHistory;
        }
    }

    private final void ensureBackgroundThread() {
        HandlerThread handlerThread2 = handlerThread;
        if (handlerThread2 == null || handlerThread2 == null || !handlerThread2.isAlive()) {
            HandlerThread handlerThread3 = new HandlerThread("ResourceMonitorThread");
            handlerThread3.start();
            handlerThread = handlerThread3;
            HandlerThread handlerThread4 = handlerThread;
            Intrinsics.checkNotNull(handlerThread4);
            backgroundHandler = new Handler(handlerThread4.getLooper());
        }
    }

    private final void stopBackgroundThread() {
        HandlerThread handlerThread2 = handlerThread;
        if (handlerThread2 != null) {
            handlerThread2.quitSafely();
        }
        handlerThread = null;
        backgroundHandler = null;
    }

    public final void startMonitoring(Context context, int i) {
        Intrinsics.checkNotNullParameter(context, "context");
        activeServerId = Integer.valueOf(i);
        contextRef = new WeakReference<>(context.getApplicationContext());
        isAppInForeground = true;
        if (!isMonitoring) {
            isMonitoring = true;
            ensureBackgroundThread();
            Handler handler = backgroundHandler;
            if (handler != null) {
                handler.post(new ResourceMonitor$$ExternalSyntheticLambda0(i, context));
            }
            Handler handler2 = backgroundHandler;
            if (handler2 != null) {
                handler2.postDelayed(updateRunnable, UPDATE_INTERVAL_MS);
            }
        }
    }

    /* access modifiers changed from: private */
    public static final void startMonitoring$lambda$1(int i, Context context) {
        INSTANCE.updateResourceData(i, context.getApplicationContext());
    }

    public final void stopMonitoring(int i) {
        Integer num = activeServerId;
        if (num != null && num.intValue() == i) {
            isMonitoring = false;
            activeServerId = null;
            Handler handler = backgroundHandler;
            if (handler != null) {
                handler.removeCallbacks(updateRunnable);
            }
            clearHistory();
            stopBackgroundThread();
        }
    }

    public final void resumeMonitoring(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        contextRef = new WeakReference<>(context.getApplicationContext());
        isAppInForeground = true;
        Integer num = activeServerId;
        if (num != null) {
            int intValue = num.intValue();
            if (!isMonitoring) {
                ResourceMonitor resourceMonitor = INSTANCE;
                isMonitoring = true;
                resourceMonitor.ensureBackgroundThread();
                Handler handler = backgroundHandler;
                if (handler != null) {
                    handler.post(new ResourceMonitor$$ExternalSyntheticLambda1(intValue, context));
                }
                Handler handler2 = backgroundHandler;
                if (handler2 != null) {
                    handler2.postDelayed(updateRunnable, UPDATE_INTERVAL_MS);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public static final void resumeMonitoring$lambda$3$lambda$2(int i, Context context) {
        INSTANCE.updateResourceData(i, context.getApplicationContext());
    }

    public final void pauseMonitoring() {
        isMonitoring = false;
        isAppInForeground = false;
        Handler handler = backgroundHandler;
        if (handler != null) {
            handler.removeCallbacks(updateRunnable);
        }
    }

    public final void onAppBackgrounded() {
        isAppInForeground = false;
    }

    public final void onAppForegrounded() {
        isAppInForeground = true;
    }

    public final List<Float> getRamHistory() {
        return CollectionsKt.toList(ramHistory);
    }

    public final boolean isMonitoringServer(int i) {
        Integer num = activeServerId;
        return num != null && num.intValue() == i && isMonitoring;
    }

    private final void clearHistory() {
        ramHistory.clear();
        previousCpuTotal = 0;
        previousCpuIdle = 0;
    }

    static /* synthetic */ void updateResourceData$default(ResourceMonitor resourceMonitor, int i, Context context, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            context = null;
        }
        resourceMonitor.updateResourceData(i, context);
    }

    /* access modifiers changed from: private */
    public final void updateResourceData(int i, Context context) {
        if (context != null) {
            Object systemService = context.getSystemService("activity");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.ActivityManager");
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            ((ActivityManager) systemService).getMemoryInfo(memoryInfo);
            long j = (long) 1048576;
            long j2 = memoryInfo.totalMem / j;
            long j3 = j2 - (memoryInfo.availMem / j);
            List<Float> list = ramHistory;
            list.add(Float.valueOf((float) j3));
            if (list.size() > 60) {
                list.remove(0);
            }
            int i2 = i;
            _resourceData.postValue(new ResourceData(i2, j3, j2, getCpuUsage(), CollectionsKt.toList(list)));
        }
    }

    private final int getCpuUsage() {
        try {
            long threadCpuTimeNanos = Debug.threadCpuTimeNanos();
            long nanoTime = System.nanoTime();
            long j = previousCpuTotal;
            if (j == 0) {
                previousCpuTotal = threadCpuTimeNanos;
                previousCpuIdle = nanoTime;
                return 0;
            }
            long j2 = threadCpuTimeNanos - j;
            long j3 = nanoTime - previousCpuIdle;
            previousCpuTotal = threadCpuTimeNanos;
            previousCpuIdle = nanoTime;
            if (j3 <= 0) {
                return 0;
            }
            return RangesKt.coerceIn((int) ((((double) j2) / ((double) j3)) * ((double) 100) * ((double) Runtime.getRuntime().availableProcessors())), 0, 100);
        } catch (Exception e) {
            e.printStackTrace();
            return getSystemCpuUsageFallback();
        }
    }

    private final int getSystemCpuUsageFallback() {
        Long longOrNull;
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile("/proc/stat", "r");
            String readLine = randomAccessFile.readLine();
            randomAccessFile.close();
            if (readLine == null) {
                return 0;
            }
            if (!StringsKt.startsWith$default(readLine, "cpu", false, 2, (Object) null)) {
                return 0;
            }
            List<String> split = new Regex("\\s+").split(readLine, 0);
            if (split.size() < 5) {
                return 0;
            }
            Long longOrNull2 = StringsKt.toLongOrNull(split.get(1));
            long longValue = longOrNull2 != null ? longOrNull2.longValue() : 0;
            Long longOrNull3 = StringsKt.toLongOrNull(split.get(2));
            long longValue2 = longOrNull3 != null ? longOrNull3.longValue() : 0;
            Long longOrNull4 = StringsKt.toLongOrNull(split.get(3));
            long longValue3 = longOrNull4 != null ? longOrNull4.longValue() : 0;
            Long longOrNull5 = StringsKt.toLongOrNull(split.get(4));
            long j = longValue + longValue2 + longValue3;
            long longValue4 = (longOrNull5 != null ? longOrNull5.longValue() : 0) + j + ((split.size() <= 5 || (longOrNull = StringsKt.toLongOrNull(split.get(5))) == null) ? 0 : longOrNull.longValue());
            if (longValue4 == 0) {
                return 0;
            }
            return RangesKt.coerceIn((int) ((j * ((long) 100)) / longValue4), 0, 100);
        } catch (Exception unused) {
            return 0;
        }
    }
}
