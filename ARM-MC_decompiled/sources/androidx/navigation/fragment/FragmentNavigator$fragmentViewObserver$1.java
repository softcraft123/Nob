package androidx.navigation.fragment;

import androidx.core.app.NotificationCompat;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.navigation.NavBackStackEntry;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Landroidx/lifecycle/LifecycleEventObserver;", "entry", "Landroidx/navigation/NavBackStackEntry;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: FragmentNavigator.kt */
final class FragmentNavigator$fragmentViewObserver$1 extends Lambda implements Function1<NavBackStackEntry, LifecycleEventObserver> {
    final /* synthetic */ FragmentNavigator this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FragmentNavigator$fragmentViewObserver$1(FragmentNavigator fragmentNavigator) {
        super(1);
        this.this$0 = fragmentNavigator;
    }

    public final LifecycleEventObserver invoke(NavBackStackEntry navBackStackEntry) {
        Intrinsics.checkNotNullParameter(navBackStackEntry, "entry");
        return new FragmentNavigator$fragmentViewObserver$1$$ExternalSyntheticLambda0(this.this$0, navBackStackEntry);
    }

    /* access modifiers changed from: private */
    public static final void invoke$lambda$0(FragmentNavigator fragmentNavigator, NavBackStackEntry navBackStackEntry, LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        Intrinsics.checkNotNullParameter(fragmentNavigator, "this$0");
        Intrinsics.checkNotNullParameter(navBackStackEntry, "$entry");
        Intrinsics.checkNotNullParameter(lifecycleOwner, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(event, NotificationCompat.CATEGORY_EVENT);
        if (event == Lifecycle.Event.ON_RESUME && fragmentNavigator.getState().getBackStack().getValue().contains(navBackStackEntry)) {
            fragmentNavigator.getState().markTransitionComplete(navBackStackEntry);
        }
        if (event == Lifecycle.Event.ON_DESTROY && !fragmentNavigator.getState().getBackStack().getValue().contains(navBackStackEntry)) {
            fragmentNavigator.getState().markTransitionComplete(navBackStackEntry);
        }
    }
}
