package androidx.navigation.fragment;

import androidx.lifecycle.LifecycleEventObserver;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"androidx/navigation/fragment/DialogFragmentNavigator$observer$1", "Landroidx/lifecycle/LifecycleEventObserver;", "onStateChanged", "", "source", "Landroidx/lifecycle/LifecycleOwner;", "event", "Landroidx/lifecycle/Lifecycle$Event;", "navigation-fragment_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: DialogFragmentNavigator.kt */
public final class DialogFragmentNavigator$observer$1 implements LifecycleEventObserver {
    final /* synthetic */ DialogFragmentNavigator this$0;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* compiled from: DialogFragmentNavigator.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        /* JADX WARNING: Can't wrap try/catch for region: R(11:0|1|2|3|4|5|6|7|8|9|11) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0022 */
        static {
            /*
                androidx.lifecycle.Lifecycle$Event[] r0 = androidx.lifecycle.Lifecycle.Event.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                androidx.lifecycle.Lifecycle$Event r1 = androidx.lifecycle.Lifecycle.Event.ON_CREATE     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                androidx.lifecycle.Lifecycle$Event r1 = androidx.lifecycle.Lifecycle.Event.ON_RESUME     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                androidx.lifecycle.Lifecycle$Event r1 = androidx.lifecycle.Lifecycle.Event.ON_STOP     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                androidx.lifecycle.Lifecycle$Event r1 = androidx.lifecycle.Lifecycle.Event.ON_DESTROY     // Catch:{ NoSuchFieldError -> 0x002b }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002b }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002b }
            L_0x002b:
                $EnumSwitchMapping$0 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.navigation.fragment.DialogFragmentNavigator$observer$1.WhenMappings.<clinit>():void");
        }
    }

    DialogFragmentNavigator$observer$1(DialogFragmentNavigator dialogFragmentNavigator) {
        this.this$0 = dialogFragmentNavigator;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: androidx.navigation.NavBackStackEntry} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: androidx.navigation.NavBackStackEntry} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v15, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v0, resolved type: androidx.navigation.NavBackStackEntry} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v4, resolved type: androidx.navigation.NavBackStackEntry} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v5, resolved type: androidx.navigation.NavBackStackEntry} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v6, resolved type: androidx.navigation.NavBackStackEntry} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v5, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: androidx.navigation.NavBackStackEntry} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v8, resolved type: androidx.navigation.NavBackStackEntry} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v9, resolved type: androidx.navigation.NavBackStackEntry} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v22, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v6, resolved type: androidx.navigation.NavBackStackEntry} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v11, resolved type: androidx.navigation.NavBackStackEntry} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v12, resolved type: androidx.navigation.NavBackStackEntry} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onStateChanged(androidx.lifecycle.LifecycleOwner r6, androidx.lifecycle.Lifecycle.Event r7) {
        /*
            r5 = this;
            java.lang.String r0 = "source"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            java.lang.String r0 = "event"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            int[] r0 = androidx.navigation.fragment.DialogFragmentNavigator$observer$1.WhenMappings.$EnumSwitchMapping$0
            int r7 = r7.ordinal()
            r7 = r0[r7]
            r0 = 1
            if (r7 == r0) goto L_0x0120
            r0 = 2
            r1 = 0
            if (r7 == r0) goto L_0x00df
            r0 = 3
            if (r7 == r0) goto L_0x006c
            r0 = 4
            if (r7 == r0) goto L_0x0021
            goto L_0x011f
        L_0x0021:
            androidx.fragment.app.DialogFragment r6 = (androidx.fragment.app.DialogFragment) r6
            androidx.navigation.fragment.DialogFragmentNavigator r7 = r5.this$0
            androidx.navigation.NavigatorState r7 = r7.getState()
            kotlinx.coroutines.flow.StateFlow r7 = r7.getTransitionsInProgress()
            java.lang.Object r7 = r7.getValue()
            java.lang.Iterable r7 = (java.lang.Iterable) r7
            java.util.Iterator r7 = r7.iterator()
        L_0x0037:
            boolean r0 = r7.hasNext()
            if (r0 == 0) goto L_0x0054
            java.lang.Object r0 = r7.next()
            r2 = r0
            androidx.navigation.NavBackStackEntry r2 = (androidx.navigation.NavBackStackEntry) r2
            java.lang.String r2 = r2.getId()
            java.lang.String r3 = r6.getTag()
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2, (java.lang.Object) r3)
            if (r2 == 0) goto L_0x0037
            r1 = r0
            goto L_0x0037
        L_0x0054:
            androidx.navigation.NavBackStackEntry r1 = (androidx.navigation.NavBackStackEntry) r1
            if (r1 == 0) goto L_0x0061
            androidx.navigation.fragment.DialogFragmentNavigator r7 = r5.this$0
            androidx.navigation.NavigatorState r7 = r7.getState()
            r7.markTransitionComplete(r1)
        L_0x0061:
            androidx.lifecycle.Lifecycle r6 = r6.getLifecycle()
            r7 = r5
            androidx.lifecycle.LifecycleObserver r7 = (androidx.lifecycle.LifecycleObserver) r7
            r6.removeObserver(r7)
            return
        L_0x006c:
            androidx.fragment.app.DialogFragment r6 = (androidx.fragment.app.DialogFragment) r6
            android.app.Dialog r7 = r6.requireDialog()
            boolean r7 = r7.isShowing()
            if (r7 != 0) goto L_0x011f
            androidx.navigation.fragment.DialogFragmentNavigator r7 = r5.this$0
            androidx.navigation.NavigatorState r7 = r7.getState()
            kotlinx.coroutines.flow.StateFlow r7 = r7.getBackStack()
            java.lang.Object r7 = r7.getValue()
            java.util.List r7 = (java.util.List) r7
            int r0 = r7.size()
            java.util.ListIterator r0 = r7.listIterator(r0)
        L_0x0090:
            boolean r2 = r0.hasPrevious()
            if (r2 == 0) goto L_0x00ac
            java.lang.Object r2 = r0.previous()
            r3 = r2
            androidx.navigation.NavBackStackEntry r3 = (androidx.navigation.NavBackStackEntry) r3
            java.lang.String r3 = r3.getId()
            java.lang.String r4 = r6.getTag()
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) r4)
            if (r3 == 0) goto L_0x0090
            r1 = r2
        L_0x00ac:
            androidx.navigation.NavBackStackEntry r1 = (androidx.navigation.NavBackStackEntry) r1
            java.lang.Object r7 = kotlin.collections.CollectionsKt.lastOrNull(r7)
            boolean r7 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r7, (java.lang.Object) r1)
            if (r7 != 0) goto L_0x00d2
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            java.lang.String r0 = "Dialog "
            r7.<init>(r0)
            java.lang.StringBuilder r6 = r7.append(r6)
            java.lang.String r7 = " was dismissed while it was not the top of the back stack, popping all dialogs above this dismissed dialog"
            java.lang.StringBuilder r6 = r6.append(r7)
            java.lang.String r6 = r6.toString()
            java.lang.String r7 = "DialogFragmentNavigator"
            android.util.Log.i(r7, r6)
        L_0x00d2:
            if (r1 == 0) goto L_0x011f
            androidx.navigation.fragment.DialogFragmentNavigator r6 = r5.this$0
            androidx.navigation.NavigatorState r6 = r6.getState()
            r7 = 0
            r6.popWithTransition(r1, r7)
            return
        L_0x00df:
            androidx.fragment.app.DialogFragment r6 = (androidx.fragment.app.DialogFragment) r6
            androidx.navigation.fragment.DialogFragmentNavigator r7 = r5.this$0
            androidx.navigation.NavigatorState r7 = r7.getState()
            kotlinx.coroutines.flow.StateFlow r7 = r7.getTransitionsInProgress()
            java.lang.Object r7 = r7.getValue()
            java.lang.Iterable r7 = (java.lang.Iterable) r7
            java.util.Iterator r7 = r7.iterator()
        L_0x00f5:
            boolean r0 = r7.hasNext()
            if (r0 == 0) goto L_0x0112
            java.lang.Object r0 = r7.next()
            r2 = r0
            androidx.navigation.NavBackStackEntry r2 = (androidx.navigation.NavBackStackEntry) r2
            java.lang.String r2 = r2.getId()
            java.lang.String r3 = r6.getTag()
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2, (java.lang.Object) r3)
            if (r2 == 0) goto L_0x00f5
            r1 = r0
            goto L_0x00f5
        L_0x0112:
            androidx.navigation.NavBackStackEntry r1 = (androidx.navigation.NavBackStackEntry) r1
            if (r1 == 0) goto L_0x011f
            androidx.navigation.fragment.DialogFragmentNavigator r6 = r5.this$0
            androidx.navigation.NavigatorState r6 = r6.getState()
            r6.markTransitionComplete(r1)
        L_0x011f:
            return
        L_0x0120:
            androidx.fragment.app.DialogFragment r6 = (androidx.fragment.app.DialogFragment) r6
            androidx.navigation.fragment.DialogFragmentNavigator r7 = r5.this$0
            androidx.navigation.NavigatorState r7 = r7.getState()
            kotlinx.coroutines.flow.StateFlow r7 = r7.getBackStack()
            java.lang.Object r7 = r7.getValue()
            java.lang.Iterable r7 = (java.lang.Iterable) r7
            boolean r0 = r7 instanceof java.util.Collection
            if (r0 == 0) goto L_0x0140
            r0 = r7
            java.util.Collection r0 = (java.util.Collection) r0
            boolean r0 = r0.isEmpty()
            if (r0 == 0) goto L_0x0140
            goto L_0x015f
        L_0x0140:
            java.util.Iterator r7 = r7.iterator()
        L_0x0144:
            boolean r0 = r7.hasNext()
            if (r0 == 0) goto L_0x015f
            java.lang.Object r0 = r7.next()
            androidx.navigation.NavBackStackEntry r0 = (androidx.navigation.NavBackStackEntry) r0
            java.lang.String r0 = r0.getId()
            java.lang.String r1 = r6.getTag()
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r1)
            if (r0 == 0) goto L_0x0144
            return
        L_0x015f:
            r6.dismiss()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.navigation.fragment.DialogFragmentNavigator$observer$1.onStateChanged(androidx.lifecycle.LifecycleOwner, androidx.lifecycle.Lifecycle$Event):void");
    }
}
