package com.bumptech.glide.request;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.Log;
import com.bumptech.glide.GlideBuilder;
import com.bumptech.glide.GlideContext;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.Engine;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.resource.drawable.DrawableDecoderCompat;
import com.bumptech.glide.request.target.SizeReadyCallback;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.request.transition.TransitionFactory;
import com.bumptech.glide.util.LogTime;
import com.bumptech.glide.util.Util;
import com.bumptech.glide.util.pool.GlideTrace;
import com.bumptech.glide.util.pool.StateVerifier;
import java.util.List;
import java.util.concurrent.Executor;

public final class SingleRequest<R> implements Request, SizeReadyCallback, ResourceCallback {
    private static final String GLIDE_TAG = "Glide";
    private static final boolean IS_VERBOSE_LOGGABLE = Log.isLoggable(TAG, 2);
    private static final String TAG = "GlideRequest";
    private final TransitionFactory<? super R> animationFactory;
    private final Executor callbackExecutor;
    private final Context context;
    private int cookie;
    private volatile Engine engine;
    private Drawable errorDrawable;
    private Drawable fallbackDrawable;
    private final GlideContext glideContext;
    private int height;
    private boolean isCallingCallbacks;
    private Engine.LoadStatus loadStatus;
    private final Object model;
    private final int overrideHeight;
    private final int overrideWidth;
    private Drawable placeholderDrawable;
    private final Priority priority;
    private final RequestCoordinator requestCoordinator;
    private final List<RequestListener<R>> requestListeners;
    private final Object requestLock;
    private final BaseRequestOptions<?> requestOptions;
    private RuntimeException requestOrigin;
    private Resource<R> resource;
    private long startTime;
    private final StateVerifier stateVerifier;
    private Status status;
    private final String tag;
    private final Target<R> target;
    private final RequestListener<R> targetListener;
    private final Class<R> transcodeClass;
    private int width;

    private enum Status {
        PENDING,
        RUNNING,
        WAITING_FOR_SIZE,
        COMPLETE,
        FAILED,
        CLEARED
    }

    public static <R> SingleRequest<R> obtain(Context context2, GlideContext glideContext2, Object obj, Object obj2, Class<R> cls, BaseRequestOptions<?> baseRequestOptions, int i, int i2, Priority priority2, Target<R> target2, RequestListener<R> requestListener, List<RequestListener<R>> list, RequestCoordinator requestCoordinator2, Engine engine2, TransitionFactory<? super R> transitionFactory, Executor executor) {
        return new SingleRequest<>(context2, glideContext2, obj, obj2, cls, baseRequestOptions, i, i2, priority2, target2, requestListener, list, requestCoordinator2, engine2, transitionFactory, executor);
    }

    private SingleRequest(Context context2, GlideContext glideContext2, Object obj, Object obj2, Class<R> cls, BaseRequestOptions<?> baseRequestOptions, int i, int i2, Priority priority2, Target<R> target2, RequestListener<R> requestListener, List<RequestListener<R>> list, RequestCoordinator requestCoordinator2, Engine engine2, TransitionFactory<? super R> transitionFactory, Executor executor) {
        this.tag = IS_VERBOSE_LOGGABLE ? String.valueOf(super.hashCode()) : null;
        this.stateVerifier = StateVerifier.newInstance();
        this.requestLock = obj;
        this.context = context2;
        this.glideContext = glideContext2;
        this.model = obj2;
        this.transcodeClass = cls;
        this.requestOptions = baseRequestOptions;
        this.overrideWidth = i;
        this.overrideHeight = i2;
        this.priority = priority2;
        this.target = target2;
        this.targetListener = requestListener;
        this.requestListeners = list;
        this.requestCoordinator = requestCoordinator2;
        this.engine = engine2;
        this.animationFactory = transitionFactory;
        this.callbackExecutor = executor;
        this.status = Status.PENDING;
        if (this.requestOrigin == null && glideContext2.getExperiments().isEnabled(GlideBuilder.LogRequestOrigins.class)) {
            this.requestOrigin = new RuntimeException("Glide request origin trace");
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00b2, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void begin() {
        /*
            r5 = this;
            java.lang.String r0 = "finished run method in "
            java.lang.Object r1 = r5.requestLock
            monitor-enter(r1)
            r5.assertNotCallingCallbacks()     // Catch:{ all -> 0x00bb }
            com.bumptech.glide.util.pool.StateVerifier r2 = r5.stateVerifier     // Catch:{ all -> 0x00bb }
            r2.throwIfRecycled()     // Catch:{ all -> 0x00bb }
            long r2 = com.bumptech.glide.util.LogTime.getLogTime()     // Catch:{ all -> 0x00bb }
            r5.startTime = r2     // Catch:{ all -> 0x00bb }
            java.lang.Object r2 = r5.model     // Catch:{ all -> 0x00bb }
            if (r2 != 0) goto L_0x003e
            int r0 = r5.overrideWidth     // Catch:{ all -> 0x00bb }
            int r2 = r5.overrideHeight     // Catch:{ all -> 0x00bb }
            boolean r0 = com.bumptech.glide.util.Util.isValidDimensions(r0, r2)     // Catch:{ all -> 0x00bb }
            if (r0 == 0) goto L_0x0029
            int r0 = r5.overrideWidth     // Catch:{ all -> 0x00bb }
            r5.width = r0     // Catch:{ all -> 0x00bb }
            int r0 = r5.overrideHeight     // Catch:{ all -> 0x00bb }
            r5.height = r0     // Catch:{ all -> 0x00bb }
        L_0x0029:
            android.graphics.drawable.Drawable r0 = r5.getFallbackDrawable()     // Catch:{ all -> 0x00bb }
            if (r0 != 0) goto L_0x0031
            r0 = 5
            goto L_0x0032
        L_0x0031:
            r0 = 3
        L_0x0032:
            com.bumptech.glide.load.engine.GlideException r2 = new com.bumptech.glide.load.engine.GlideException     // Catch:{ all -> 0x00bb }
            java.lang.String r3 = "Received null model"
            r2.<init>(r3)     // Catch:{ all -> 0x00bb }
            r5.onLoadFailed(r2, r0)     // Catch:{ all -> 0x00bb }
            monitor-exit(r1)     // Catch:{ all -> 0x00bb }
            return
        L_0x003e:
            com.bumptech.glide.request.SingleRequest$Status r2 = r5.status     // Catch:{ all -> 0x00bb }
            com.bumptech.glide.request.SingleRequest$Status r3 = com.bumptech.glide.request.SingleRequest.Status.RUNNING     // Catch:{ all -> 0x00bb }
            if (r2 == r3) goto L_0x00b3
            com.bumptech.glide.request.SingleRequest$Status r2 = r5.status     // Catch:{ all -> 0x00bb }
            com.bumptech.glide.request.SingleRequest$Status r3 = com.bumptech.glide.request.SingleRequest.Status.COMPLETE     // Catch:{ all -> 0x00bb }
            if (r2 != r3) goto L_0x0054
            com.bumptech.glide.load.engine.Resource<R> r0 = r5.resource     // Catch:{ all -> 0x00bb }
            com.bumptech.glide.load.DataSource r2 = com.bumptech.glide.load.DataSource.MEMORY_CACHE     // Catch:{ all -> 0x00bb }
            r3 = 0
            r5.onResourceReady(r0, r2, r3)     // Catch:{ all -> 0x00bb }
            monitor-exit(r1)     // Catch:{ all -> 0x00bb }
            return
        L_0x0054:
            java.lang.Object r2 = r5.model     // Catch:{ all -> 0x00bb }
            r5.experimentalNotifyRequestStarted(r2)     // Catch:{ all -> 0x00bb }
            java.lang.String r2 = "GlideRequest"
            int r2 = com.bumptech.glide.util.pool.GlideTrace.beginSectionAsync(r2)     // Catch:{ all -> 0x00bb }
            r5.cookie = r2     // Catch:{ all -> 0x00bb }
            com.bumptech.glide.request.SingleRequest$Status r2 = com.bumptech.glide.request.SingleRequest.Status.WAITING_FOR_SIZE     // Catch:{ all -> 0x00bb }
            r5.status = r2     // Catch:{ all -> 0x00bb }
            int r2 = r5.overrideWidth     // Catch:{ all -> 0x00bb }
            int r3 = r5.overrideHeight     // Catch:{ all -> 0x00bb }
            boolean r2 = com.bumptech.glide.util.Util.isValidDimensions(r2, r3)     // Catch:{ all -> 0x00bb }
            if (r2 == 0) goto L_0x0077
            int r2 = r5.overrideWidth     // Catch:{ all -> 0x00bb }
            int r3 = r5.overrideHeight     // Catch:{ all -> 0x00bb }
            r5.onSizeReady(r2, r3)     // Catch:{ all -> 0x00bb }
            goto L_0x007c
        L_0x0077:
            com.bumptech.glide.request.target.Target<R> r2 = r5.target     // Catch:{ all -> 0x00bb }
            r2.getSize(r5)     // Catch:{ all -> 0x00bb }
        L_0x007c:
            com.bumptech.glide.request.SingleRequest$Status r2 = r5.status     // Catch:{ all -> 0x00bb }
            com.bumptech.glide.request.SingleRequest$Status r3 = com.bumptech.glide.request.SingleRequest.Status.RUNNING     // Catch:{ all -> 0x00bb }
            if (r2 == r3) goto L_0x0088
            com.bumptech.glide.request.SingleRequest$Status r2 = r5.status     // Catch:{ all -> 0x00bb }
            com.bumptech.glide.request.SingleRequest$Status r3 = com.bumptech.glide.request.SingleRequest.Status.WAITING_FOR_SIZE     // Catch:{ all -> 0x00bb }
            if (r2 != r3) goto L_0x0097
        L_0x0088:
            boolean r2 = r5.canNotifyStatusChanged()     // Catch:{ all -> 0x00bb }
            if (r2 == 0) goto L_0x0097
            com.bumptech.glide.request.target.Target<R> r2 = r5.target     // Catch:{ all -> 0x00bb }
            android.graphics.drawable.Drawable r3 = r5.getPlaceholderDrawable()     // Catch:{ all -> 0x00bb }
            r2.onLoadStarted(r3)     // Catch:{ all -> 0x00bb }
        L_0x0097:
            boolean r2 = IS_VERBOSE_LOGGABLE     // Catch:{ all -> 0x00bb }
            if (r2 == 0) goto L_0x00b1
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x00bb }
            r2.<init>(r0)     // Catch:{ all -> 0x00bb }
            long r3 = r5.startTime     // Catch:{ all -> 0x00bb }
            double r3 = com.bumptech.glide.util.LogTime.getElapsedMillis(r3)     // Catch:{ all -> 0x00bb }
            java.lang.StringBuilder r0 = r2.append(r3)     // Catch:{ all -> 0x00bb }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x00bb }
            r5.logV(r0)     // Catch:{ all -> 0x00bb }
        L_0x00b1:
            monitor-exit(r1)     // Catch:{ all -> 0x00bb }
            return
        L_0x00b3:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException     // Catch:{ all -> 0x00bb }
            java.lang.String r2 = "Cannot restart a running request"
            r0.<init>(r2)     // Catch:{ all -> 0x00bb }
            throw r0     // Catch:{ all -> 0x00bb }
        L_0x00bb:
            r0 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x00bb }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.request.SingleRequest.begin():void");
    }

    private void experimentalNotifyRequestStarted(Object obj) {
        List<RequestListener<R>> list = this.requestListeners;
        if (list != null) {
            for (RequestListener next : list) {
                if (next instanceof ExperimentalRequestListener) {
                    ((ExperimentalRequestListener) next).onRequestStarted(obj);
                }
            }
        }
    }

    private void cancel() {
        assertNotCallingCallbacks();
        this.stateVerifier.throwIfRecycled();
        this.target.removeCallback(this);
        Engine.LoadStatus loadStatus2 = this.loadStatus;
        if (loadStatus2 != null) {
            loadStatus2.cancel();
            this.loadStatus = null;
        }
    }

    private void assertNotCallingCallbacks() {
        if (this.isCallingCallbacks) {
            throw new IllegalStateException("You can't start or clear loads in RequestListener or Target callbacks. If you're trying to start a fallback request when a load fails, use RequestBuilder#error(RequestBuilder). Otherwise consider posting your into() or clear() calls to the main thread using a Handler instead.");
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x003a, code lost:
        if (r1 == null) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x003c, code lost:
        r4.engine.release(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void clear() {
        /*
            r4 = this;
            java.lang.Object r0 = r4.requestLock
            monitor-enter(r0)
            r4.assertNotCallingCallbacks()     // Catch:{ all -> 0x0042 }
            com.bumptech.glide.util.pool.StateVerifier r1 = r4.stateVerifier     // Catch:{ all -> 0x0042 }
            r1.throwIfRecycled()     // Catch:{ all -> 0x0042 }
            com.bumptech.glide.request.SingleRequest$Status r1 = r4.status     // Catch:{ all -> 0x0042 }
            com.bumptech.glide.request.SingleRequest$Status r2 = com.bumptech.glide.request.SingleRequest.Status.CLEARED     // Catch:{ all -> 0x0042 }
            if (r1 != r2) goto L_0x0013
            monitor-exit(r0)     // Catch:{ all -> 0x0042 }
            return
        L_0x0013:
            r4.cancel()     // Catch:{ all -> 0x0042 }
            com.bumptech.glide.load.engine.Resource<R> r1 = r4.resource     // Catch:{ all -> 0x0042 }
            r2 = 0
            if (r1 == 0) goto L_0x001e
            r4.resource = r2     // Catch:{ all -> 0x0042 }
            goto L_0x001f
        L_0x001e:
            r1 = r2
        L_0x001f:
            boolean r2 = r4.canNotifyCleared()     // Catch:{ all -> 0x0042 }
            if (r2 == 0) goto L_0x002e
            com.bumptech.glide.request.target.Target<R> r2 = r4.target     // Catch:{ all -> 0x0042 }
            android.graphics.drawable.Drawable r3 = r4.getPlaceholderDrawable()     // Catch:{ all -> 0x0042 }
            r2.onLoadCleared(r3)     // Catch:{ all -> 0x0042 }
        L_0x002e:
            java.lang.String r2 = "GlideRequest"
            int r3 = r4.cookie     // Catch:{ all -> 0x0042 }
            com.bumptech.glide.util.pool.GlideTrace.endSectionAsync(r2, r3)     // Catch:{ all -> 0x0042 }
            com.bumptech.glide.request.SingleRequest$Status r2 = com.bumptech.glide.request.SingleRequest.Status.CLEARED     // Catch:{ all -> 0x0042 }
            r4.status = r2     // Catch:{ all -> 0x0042 }
            monitor-exit(r0)     // Catch:{ all -> 0x0042 }
            if (r1 == 0) goto L_0x0041
            com.bumptech.glide.load.engine.Engine r0 = r4.engine
            r0.release(r1)
        L_0x0041:
            return
        L_0x0042:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0042 }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.request.SingleRequest.clear():void");
    }

    public void pause() {
        synchronized (this.requestLock) {
            if (isRunning()) {
                clear();
            }
        }
    }

    public boolean isRunning() {
        boolean z;
        synchronized (this.requestLock) {
            if (this.status != Status.RUNNING) {
                if (this.status != Status.WAITING_FOR_SIZE) {
                    z = false;
                }
            }
            z = true;
        }
        return z;
    }

    public boolean isComplete() {
        boolean z;
        synchronized (this.requestLock) {
            z = this.status == Status.COMPLETE;
        }
        return z;
    }

    public boolean isCleared() {
        boolean z;
        synchronized (this.requestLock) {
            z = this.status == Status.CLEARED;
        }
        return z;
    }

    public boolean isAnyResourceSet() {
        boolean z;
        synchronized (this.requestLock) {
            z = this.status == Status.COMPLETE;
        }
        return z;
    }

    private Drawable getErrorDrawable() {
        if (this.errorDrawable == null) {
            Drawable errorPlaceholder = this.requestOptions.getErrorPlaceholder();
            this.errorDrawable = errorPlaceholder;
            if (errorPlaceholder == null && this.requestOptions.getErrorId() > 0) {
                this.errorDrawable = loadDrawable(this.requestOptions.getErrorId());
            }
        }
        return this.errorDrawable;
    }

    private Drawable getPlaceholderDrawable() {
        if (this.placeholderDrawable == null) {
            Drawable placeholderDrawable2 = this.requestOptions.getPlaceholderDrawable();
            this.placeholderDrawable = placeholderDrawable2;
            if (placeholderDrawable2 == null && this.requestOptions.getPlaceholderId() > 0) {
                this.placeholderDrawable = loadDrawable(this.requestOptions.getPlaceholderId());
            }
        }
        return this.placeholderDrawable;
    }

    private Drawable getFallbackDrawable() {
        if (this.fallbackDrawable == null) {
            Drawable fallbackDrawable2 = this.requestOptions.getFallbackDrawable();
            this.fallbackDrawable = fallbackDrawable2;
            if (fallbackDrawable2 == null && this.requestOptions.getFallbackId() > 0) {
                this.fallbackDrawable = loadDrawable(this.requestOptions.getFallbackId());
            }
        }
        return this.fallbackDrawable;
    }

    private Drawable loadDrawable(int i) {
        return DrawableDecoderCompat.getDrawable(this.context, i, this.requestOptions.getTheme() != null ? this.requestOptions.getTheme() : this.context.getTheme());
    }

    private void setErrorPlaceholder() {
        if (canNotifyStatusChanged()) {
            Drawable fallbackDrawable2 = this.model == null ? getFallbackDrawable() : null;
            if (fallbackDrawable2 == null) {
                fallbackDrawable2 = getErrorDrawable();
            }
            if (fallbackDrawable2 == null) {
                fallbackDrawable2 = getPlaceholderDrawable();
            }
            this.target.onLoadFailed(fallbackDrawable2);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v0, resolved type: com.bumptech.glide.request.SingleRequest} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v1, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: com.bumptech.glide.request.SingleRequest} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: com.bumptech.glide.request.SingleRequest} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v3, resolved type: com.bumptech.glide.request.SingleRequest} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v4, resolved type: com.bumptech.glide.request.SingleRequest} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v4, resolved type: com.bumptech.glide.request.SingleRequest} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v5, resolved type: com.bumptech.glide.request.SingleRequest} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v6, resolved type: com.bumptech.glide.request.SingleRequest} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v7, resolved type: com.bumptech.glide.request.SingleRequest} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v8, resolved type: com.bumptech.glide.request.SingleRequest} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onSizeReady(int r24, int r25) {
        /*
            r23 = this;
            r1 = r23
            java.lang.String r0 = "finished onSizeReady in "
            java.lang.String r2 = "finished setup for calling load in "
            java.lang.String r3 = "Got onSizeReady in "
            com.bumptech.glide.util.pool.StateVerifier r4 = r1.stateVerifier
            r4.throwIfRecycled()
            java.lang.Object r4 = r1.requestLock
            monitor-enter(r4)
            boolean r22 = IS_VERBOSE_LOGGABLE     // Catch:{ all -> 0x0115 }
            if (r22 == 0) goto L_0x002a
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x0115 }
            r5.<init>(r3)     // Catch:{ all -> 0x0115 }
            long r6 = r1.startTime     // Catch:{ all -> 0x0115 }
            double r6 = com.bumptech.glide.util.LogTime.getElapsedMillis(r6)     // Catch:{ all -> 0x0115 }
            java.lang.StringBuilder r3 = r5.append(r6)     // Catch:{ all -> 0x0115 }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x0115 }
            r1.logV(r3)     // Catch:{ all -> 0x0115 }
        L_0x002a:
            com.bumptech.glide.request.SingleRequest$Status r3 = r1.status     // Catch:{ all -> 0x0115 }
            com.bumptech.glide.request.SingleRequest$Status r5 = com.bumptech.glide.request.SingleRequest.Status.WAITING_FOR_SIZE     // Catch:{ all -> 0x0115 }
            if (r3 == r5) goto L_0x0032
            monitor-exit(r4)     // Catch:{ all -> 0x0115 }
            return
        L_0x0032:
            com.bumptech.glide.request.SingleRequest$Status r3 = com.bumptech.glide.request.SingleRequest.Status.RUNNING     // Catch:{ all -> 0x0115 }
            r1.status = r3     // Catch:{ all -> 0x0115 }
            com.bumptech.glide.request.BaseRequestOptions<?> r3 = r1.requestOptions     // Catch:{ all -> 0x0115 }
            float r3 = r3.getSizeMultiplier()     // Catch:{ all -> 0x0115 }
            r5 = r24
            int r5 = maybeApplySizeMultiplier(r5, r3)     // Catch:{ all -> 0x0115 }
            r1.width = r5     // Catch:{ all -> 0x0115 }
            r5 = r25
            int r3 = maybeApplySizeMultiplier(r5, r3)     // Catch:{ all -> 0x0115 }
            r1.height = r3     // Catch:{ all -> 0x0115 }
            if (r22 == 0) goto L_0x0064
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0115 }
            r3.<init>(r2)     // Catch:{ all -> 0x0115 }
            long r5 = r1.startTime     // Catch:{ all -> 0x0115 }
            double r5 = com.bumptech.glide.util.LogTime.getElapsedMillis(r5)     // Catch:{ all -> 0x0115 }
            java.lang.StringBuilder r2 = r3.append(r5)     // Catch:{ all -> 0x0115 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0115 }
            r1.logV(r2)     // Catch:{ all -> 0x0115 }
        L_0x0064:
            com.bumptech.glide.load.engine.Engine r2 = r1.engine     // Catch:{ all -> 0x0115 }
            com.bumptech.glide.GlideContext r3 = r1.glideContext     // Catch:{ all -> 0x0115 }
            r5 = r4
            java.lang.Object r4 = r1.model     // Catch:{ all -> 0x0111 }
            com.bumptech.glide.request.BaseRequestOptions<?> r6 = r1.requestOptions     // Catch:{ all -> 0x0111 }
            com.bumptech.glide.load.Key r6 = r6.getSignature()     // Catch:{ all -> 0x0111 }
            r7 = r5
            r5 = r6
            int r6 = r1.width     // Catch:{ all -> 0x010d }
            r8 = r7
            int r7 = r1.height     // Catch:{ all -> 0x0109 }
            com.bumptech.glide.request.BaseRequestOptions<?> r9 = r1.requestOptions     // Catch:{ all -> 0x0109 }
            java.lang.Class r9 = r9.getResourceClass()     // Catch:{ all -> 0x0109 }
            r10 = r8
            r8 = r9
            java.lang.Class<R> r9 = r1.transcodeClass     // Catch:{ all -> 0x0105 }
            r11 = r10
            com.bumptech.glide.Priority r10 = r1.priority     // Catch:{ all -> 0x0101 }
            com.bumptech.glide.request.BaseRequestOptions<?> r12 = r1.requestOptions     // Catch:{ all -> 0x0101 }
            com.bumptech.glide.load.engine.DiskCacheStrategy r12 = r12.getDiskCacheStrategy()     // Catch:{ all -> 0x0101 }
            com.bumptech.glide.request.BaseRequestOptions<?> r13 = r1.requestOptions     // Catch:{ all -> 0x0101 }
            java.util.Map r13 = r13.getTransformations()     // Catch:{ all -> 0x0101 }
            com.bumptech.glide.request.BaseRequestOptions<?> r14 = r1.requestOptions     // Catch:{ all -> 0x0101 }
            boolean r14 = r14.isTransformationRequired()     // Catch:{ all -> 0x0101 }
            com.bumptech.glide.request.BaseRequestOptions<?> r15 = r1.requestOptions     // Catch:{ all -> 0x0101 }
            boolean r15 = r15.isScaleOnlyOrNoTransform()     // Catch:{ all -> 0x0101 }
            r16 = r2
            com.bumptech.glide.request.BaseRequestOptions<?> r2 = r1.requestOptions     // Catch:{ all -> 0x0101 }
            com.bumptech.glide.load.Options r2 = r2.getOptions()     // Catch:{ all -> 0x0101 }
            r24 = r2
            com.bumptech.glide.request.BaseRequestOptions<?> r2 = r1.requestOptions     // Catch:{ all -> 0x0101 }
            boolean r2 = r2.isMemoryCacheable()     // Catch:{ all -> 0x0101 }
            r25 = r2
            com.bumptech.glide.request.BaseRequestOptions<?> r2 = r1.requestOptions     // Catch:{ all -> 0x0101 }
            boolean r17 = r2.getUseUnlimitedSourceGeneratorsPool()     // Catch:{ all -> 0x0101 }
            com.bumptech.glide.request.BaseRequestOptions<?> r2 = r1.requestOptions     // Catch:{ all -> 0x0101 }
            boolean r18 = r2.getUseAnimationPool()     // Catch:{ all -> 0x0101 }
            com.bumptech.glide.request.BaseRequestOptions<?> r2 = r1.requestOptions     // Catch:{ all -> 0x0101 }
            boolean r19 = r2.getOnlyRetrieveFromCache()     // Catch:{ all -> 0x0101 }
            java.util.concurrent.Executor r2 = r1.callbackExecutor     // Catch:{ all -> 0x0101 }
            r20 = r1
            r21 = r2
            r1 = r11
            r11 = r12
            r12 = r13
            r13 = r14
            r14 = r15
            r2 = r16
            r15 = r24
            r16 = r25
            com.bumptech.glide.load.engine.Engine$LoadStatus r2 = r2.load(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21)     // Catch:{ all -> 0x00fd }
            r3 = r20
            r3.loadStatus = r2     // Catch:{ all -> 0x011a }
            com.bumptech.glide.request.SingleRequest$Status r2 = r3.status     // Catch:{ all -> 0x011a }
            com.bumptech.glide.request.SingleRequest$Status r4 = com.bumptech.glide.request.SingleRequest.Status.RUNNING     // Catch:{ all -> 0x011a }
            if (r2 == r4) goto L_0x00e3
            r2 = 0
            r3.loadStatus = r2     // Catch:{ all -> 0x011a }
        L_0x00e3:
            if (r22 == 0) goto L_0x00fb
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x011a }
            r2.<init>(r0)     // Catch:{ all -> 0x011a }
            long r4 = r3.startTime     // Catch:{ all -> 0x011a }
            double r4 = com.bumptech.glide.util.LogTime.getElapsedMillis(r4)     // Catch:{ all -> 0x011a }
            java.lang.StringBuilder r0 = r2.append(r4)     // Catch:{ all -> 0x011a }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x011a }
            r3.logV(r0)     // Catch:{ all -> 0x011a }
        L_0x00fb:
            monitor-exit(r1)     // Catch:{ all -> 0x011a }
            return
        L_0x00fd:
            r0 = move-exception
            r3 = r20
            goto L_0x0118
        L_0x0101:
            r0 = move-exception
            r3 = r1
            r1 = r11
            goto L_0x0118
        L_0x0105:
            r0 = move-exception
            r3 = r1
            r1 = r10
            goto L_0x0118
        L_0x0109:
            r0 = move-exception
            r3 = r1
            r1 = r8
            goto L_0x0118
        L_0x010d:
            r0 = move-exception
            r3 = r1
            r1 = r7
            goto L_0x0118
        L_0x0111:
            r0 = move-exception
            r3 = r1
            r1 = r5
            goto L_0x0118
        L_0x0115:
            r0 = move-exception
            r3 = r1
            r1 = r4
        L_0x0118:
            monitor-exit(r1)     // Catch:{ all -> 0x011a }
            throw r0
        L_0x011a:
            r0 = move-exception
            goto L_0x0118
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.request.SingleRequest.onSizeReady(int, int):void");
    }

    private static int maybeApplySizeMultiplier(int i, float f) {
        return i == Integer.MIN_VALUE ? i : Math.round(f * ((float) i));
    }

    private boolean canSetResource() {
        RequestCoordinator requestCoordinator2 = this.requestCoordinator;
        return requestCoordinator2 == null || requestCoordinator2.canSetImage(this);
    }

    private boolean canNotifyCleared() {
        RequestCoordinator requestCoordinator2 = this.requestCoordinator;
        return requestCoordinator2 == null || requestCoordinator2.canNotifyCleared(this);
    }

    private boolean canNotifyStatusChanged() {
        RequestCoordinator requestCoordinator2 = this.requestCoordinator;
        return requestCoordinator2 == null || requestCoordinator2.canNotifyStatusChanged(this);
    }

    private boolean isFirstReadyResource() {
        RequestCoordinator requestCoordinator2 = this.requestCoordinator;
        return requestCoordinator2 == null || !requestCoordinator2.getRoot().isAnyResourceSet();
    }

    private void notifyRequestCoordinatorLoadSucceeded() {
        RequestCoordinator requestCoordinator2 = this.requestCoordinator;
        if (requestCoordinator2 != null) {
            requestCoordinator2.onRequestSuccess(this);
        }
    }

    private void notifyRequestCoordinatorLoadFailed() {
        RequestCoordinator requestCoordinator2 = this.requestCoordinator;
        if (requestCoordinator2 != null) {
            requestCoordinator2.onRequestFailed(this);
        }
    }

    /* JADX WARNING: type inference failed for: r2v1, types: [com.bumptech.glide.load.engine.Engine$LoadStatus, com.bumptech.glide.load.engine.Resource<R>] */
    /* JADX WARNING: type inference failed for: r2v2, types: [com.bumptech.glide.load.engine.Resource] */
    /* JADX WARNING: type inference failed for: r2v4 */
    /* JADX WARNING: type inference failed for: r2v6 */
    /* JADX WARNING: type inference failed for: r2v7 */
    /* JADX WARNING: type inference failed for: r2v8 */
    /* JADX WARNING: type inference failed for: r2v9 */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0057, code lost:
        if (r7 == null) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x005e, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:?, code lost:
        return;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onResourceReady(com.bumptech.glide.load.engine.Resource<?> r7, com.bumptech.glide.load.DataSource r8, boolean r9) {
        /*
            r6 = this;
            java.lang.String r0 = "Expected to receive an object of "
            java.lang.String r1 = "Expected to receive a Resource<R> with an object of "
            com.bumptech.glide.util.pool.StateVerifier r2 = r6.stateVerifier
            r2.throwIfRecycled()
            r2 = 0
            java.lang.Object r3 = r6.requestLock     // Catch:{ all -> 0x00c1 }
            monitor-enter(r3)     // Catch:{ all -> 0x00c1 }
            r6.loadStatus = r2     // Catch:{ all -> 0x00be }
            if (r7 != 0) goto L_0x0030
            com.bumptech.glide.load.engine.GlideException r7 = new com.bumptech.glide.load.engine.GlideException     // Catch:{ all -> 0x00be }
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ all -> 0x00be }
            r8.<init>(r1)     // Catch:{ all -> 0x00be }
            java.lang.Class<R> r9 = r6.transcodeClass     // Catch:{ all -> 0x00be }
            java.lang.StringBuilder r8 = r8.append(r9)     // Catch:{ all -> 0x00be }
            java.lang.String r9 = " inside, but instead got null."
            java.lang.StringBuilder r8 = r8.append(r9)     // Catch:{ all -> 0x00be }
            java.lang.String r8 = r8.toString()     // Catch:{ all -> 0x00be }
            r7.<init>(r8)     // Catch:{ all -> 0x00be }
            r6.onLoadFailed(r7)     // Catch:{ all -> 0x00be }
            monitor-exit(r3)     // Catch:{ all -> 0x00be }
            return
        L_0x0030:
            java.lang.Object r1 = r7.get()     // Catch:{ all -> 0x00be }
            if (r1 == 0) goto L_0x0064
            java.lang.Class<R> r4 = r6.transcodeClass     // Catch:{ all -> 0x00be }
            java.lang.Class r5 = r1.getClass()     // Catch:{ all -> 0x00be }
            boolean r4 = r4.isAssignableFrom(r5)     // Catch:{ all -> 0x00be }
            if (r4 != 0) goto L_0x0043
            goto L_0x0064
        L_0x0043:
            boolean r0 = r6.canSetResource()     // Catch:{ all -> 0x00be }
            if (r0 != 0) goto L_0x005f
            r6.resource = r2     // Catch:{ all -> 0x00ba }
            com.bumptech.glide.request.SingleRequest$Status r8 = com.bumptech.glide.request.SingleRequest.Status.COMPLETE     // Catch:{ all -> 0x00ba }
            r6.status = r8     // Catch:{ all -> 0x00ba }
            java.lang.String r8 = "GlideRequest"
            int r9 = r6.cookie     // Catch:{ all -> 0x00ba }
            com.bumptech.glide.util.pool.GlideTrace.endSectionAsync(r8, r9)     // Catch:{ all -> 0x00ba }
            monitor-exit(r3)     // Catch:{ all -> 0x00ba }
            if (r7 == 0) goto L_0x00b9
        L_0x0059:
            com.bumptech.glide.load.engine.Engine r8 = r6.engine
            r8.release(r7)
            return
        L_0x005f:
            r6.onResourceReady(r7, r1, r8, r9)     // Catch:{ all -> 0x00be }
            monitor-exit(r3)     // Catch:{ all -> 0x00be }
            return
        L_0x0064:
            r6.resource = r2     // Catch:{ all -> 0x00ba }
            com.bumptech.glide.load.engine.GlideException r8 = new com.bumptech.glide.load.engine.GlideException     // Catch:{ all -> 0x00ba }
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ all -> 0x00ba }
            r9.<init>(r0)     // Catch:{ all -> 0x00ba }
            java.lang.Class<R> r0 = r6.transcodeClass     // Catch:{ all -> 0x00ba }
            java.lang.StringBuilder r9 = r9.append(r0)     // Catch:{ all -> 0x00ba }
            java.lang.String r0 = " but instead got "
            java.lang.StringBuilder r9 = r9.append(r0)     // Catch:{ all -> 0x00ba }
            if (r1 == 0) goto L_0x0080
            java.lang.Class r0 = r1.getClass()     // Catch:{ all -> 0x00ba }
            goto L_0x0082
        L_0x0080:
            java.lang.String r0 = ""
        L_0x0082:
            java.lang.StringBuilder r9 = r9.append(r0)     // Catch:{ all -> 0x00ba }
            java.lang.String r0 = "{"
            java.lang.StringBuilder r9 = r9.append(r0)     // Catch:{ all -> 0x00ba }
            java.lang.StringBuilder r9 = r9.append(r1)     // Catch:{ all -> 0x00ba }
            java.lang.String r0 = "} inside Resource{"
            java.lang.StringBuilder r9 = r9.append(r0)     // Catch:{ all -> 0x00ba }
            java.lang.StringBuilder r9 = r9.append(r7)     // Catch:{ all -> 0x00ba }
            java.lang.String r0 = "}."
            java.lang.StringBuilder r9 = r9.append(r0)     // Catch:{ all -> 0x00ba }
            if (r1 == 0) goto L_0x00a5
            java.lang.String r0 = ""
            goto L_0x00a7
        L_0x00a5:
            java.lang.String r0 = " To indicate failure return a null Resource object, rather than a Resource object containing null data."
        L_0x00a7:
            java.lang.StringBuilder r9 = r9.append(r0)     // Catch:{ all -> 0x00ba }
            java.lang.String r9 = r9.toString()     // Catch:{ all -> 0x00ba }
            r8.<init>(r9)     // Catch:{ all -> 0x00ba }
            r6.onLoadFailed(r8)     // Catch:{ all -> 0x00ba }
            monitor-exit(r3)     // Catch:{ all -> 0x00ba }
            if (r7 == 0) goto L_0x00b9
            goto L_0x0059
        L_0x00b9:
            return
        L_0x00ba:
            r8 = move-exception
            r2 = r7
            r7 = r8
            goto L_0x00bf
        L_0x00be:
            r7 = move-exception
        L_0x00bf:
            monitor-exit(r3)     // Catch:{ all -> 0x00be }
            throw r7     // Catch:{ all -> 0x00c1 }
        L_0x00c1:
            r7 = move-exception
            if (r2 == 0) goto L_0x00c9
            com.bumptech.glide.load.engine.Engine r8 = r6.engine
            r8.release(r2)
        L_0x00c9:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.request.SingleRequest.onResourceReady(com.bumptech.glide.load.engine.Resource, com.bumptech.glide.load.DataSource, boolean):void");
    }

    private void onResourceReady(Resource<R> resource2, R r, DataSource dataSource, boolean z) {
        boolean z2;
        boolean z3;
        boolean isFirstReadyResource = isFirstReadyResource();
        this.status = Status.COMPLETE;
        this.resource = resource2;
        if (this.glideContext.getLogLevel() <= 3) {
            Log.d(GLIDE_TAG, "Finished loading " + r.getClass().getSimpleName() + " from " + dataSource + " for " + this.model + " with size [" + this.width + "x" + this.height + "] in " + LogTime.getElapsedMillis(this.startTime) + " ms");
        }
        notifyRequestCoordinatorLoadSucceeded();
        boolean z4 = true;
        this.isCallingCallbacks = true;
        try {
            List<RequestListener<R>> list = this.requestListeners;
            if (list != null) {
                z2 = false;
                for (RequestListener next : list) {
                    R r2 = r;
                    DataSource dataSource2 = dataSource;
                    boolean onResourceReady = next.onResourceReady(r2, this.model, this.target, dataSource2, isFirstReadyResource) | z2;
                    if (next instanceof ExperimentalRequestListener) {
                        z3 = z;
                        onResourceReady |= ((ExperimentalRequestListener) next).onResourceReady(r2, this.model, this.target, dataSource2, isFirstReadyResource, z3);
                    } else {
                        z3 = z;
                    }
                    dataSource = dataSource2;
                    z = z3;
                    z2 = onResourceReady;
                    r = r2;
                }
            } else {
                z2 = false;
            }
            R r3 = r;
            DataSource dataSource3 = dataSource;
            RequestListener<R> requestListener = this.targetListener;
            if (requestListener == null || !requestListener.onResourceReady(r3, this.model, this.target, dataSource3, isFirstReadyResource)) {
                z4 = false;
            }
            if (!z4 && !z2) {
                this.target.onResourceReady(r3, this.animationFactory.build(dataSource3, isFirstReadyResource));
            }
            this.isCallingCallbacks = false;
            GlideTrace.endSectionAsync(TAG, this.cookie);
        } catch (Throwable th) {
            Throwable th2 = th;
            this.isCallingCallbacks = false;
            throw th2;
        }
    }

    public void onLoadFailed(GlideException glideException) {
        onLoadFailed(glideException, 5);
    }

    public Object getLock() {
        this.stateVerifier.throwIfRecycled();
        return this.requestLock;
    }

    /* JADX INFO: finally extract failed */
    private void onLoadFailed(GlideException glideException, int i) {
        boolean z;
        this.stateVerifier.throwIfRecycled();
        synchronized (this.requestLock) {
            glideException.setOrigin(this.requestOrigin);
            int logLevel = this.glideContext.getLogLevel();
            if (logLevel <= i) {
                Log.w(GLIDE_TAG, "Load failed for [" + this.model + "] with dimensions [" + this.width + "x" + this.height + "]", glideException);
                if (logLevel <= 4) {
                    glideException.logRootCauses(GLIDE_TAG);
                }
            }
            this.loadStatus = null;
            this.status = Status.FAILED;
            notifyRequestCoordinatorLoadFailed();
            boolean z2 = true;
            this.isCallingCallbacks = true;
            try {
                List<RequestListener<R>> list = this.requestListeners;
                if (list != null) {
                    z = false;
                    for (RequestListener<R> onLoadFailed : list) {
                        z |= onLoadFailed.onLoadFailed(glideException, this.model, this.target, isFirstReadyResource());
                    }
                } else {
                    z = false;
                }
                RequestListener<R> requestListener = this.targetListener;
                if (requestListener == null || !requestListener.onLoadFailed(glideException, this.model, this.target, isFirstReadyResource())) {
                    z2 = false;
                }
                if (!z && !z2) {
                    setErrorPlaceholder();
                }
                this.isCallingCallbacks = false;
                GlideTrace.endSectionAsync(TAG, this.cookie);
            } catch (Throwable th) {
                this.isCallingCallbacks = false;
                throw th;
            }
        }
    }

    public boolean isEquivalentTo(Request request) {
        int i;
        int i2;
        Object obj;
        Class<R> cls;
        BaseRequestOptions<?> baseRequestOptions;
        Priority priority2;
        int size;
        int i3;
        int i4;
        Object obj2;
        Class<R> cls2;
        BaseRequestOptions<?> baseRequestOptions2;
        Priority priority3;
        int size2;
        Request request2 = request;
        if (!(request2 instanceof SingleRequest)) {
            return false;
        }
        synchronized (this.requestLock) {
            i = this.overrideWidth;
            i2 = this.overrideHeight;
            obj = this.model;
            cls = this.transcodeClass;
            baseRequestOptions = this.requestOptions;
            priority2 = this.priority;
            List<RequestListener<R>> list = this.requestListeners;
            size = list != null ? list.size() : 0;
        }
        SingleRequest singleRequest = (SingleRequest) request2;
        synchronized (singleRequest.requestLock) {
            i3 = singleRequest.overrideWidth;
            i4 = singleRequest.overrideHeight;
            obj2 = singleRequest.model;
            cls2 = singleRequest.transcodeClass;
            baseRequestOptions2 = singleRequest.requestOptions;
            priority3 = singleRequest.priority;
            List<RequestListener<R>> list2 = singleRequest.requestListeners;
            size2 = list2 != null ? list2.size() : 0;
        }
        if (i == i3 && i2 == i4 && Util.bothModelsNullEquivalentOrEquals(obj, obj2) && cls.equals(cls2) && Util.bothBaseRequestOptionsNullEquivalentOrEquals(baseRequestOptions, baseRequestOptions2) && priority2 == priority3 && size == size2) {
            return true;
        }
        return false;
    }

    private void logV(String str) {
        Log.v(TAG, str + " this: " + this.tag);
    }

    public String toString() {
        Object obj;
        Class<R> cls;
        synchronized (this.requestLock) {
            obj = this.model;
            cls = this.transcodeClass;
        }
        return super.toString() + "[model=" + obj + ", transcodeClass=" + cls + "]";
    }
}
