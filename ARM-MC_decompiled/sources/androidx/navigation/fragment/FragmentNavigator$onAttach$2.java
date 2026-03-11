package androidx.navigation.fragment;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.navigation.NavBackStackEntry;
import androidx.navigation.NavigatorState;
import java.util.List;
import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\t\u001a\u00020\u0003H\u0016¨\u0006\n"}, d2 = {"androidx/navigation/fragment/FragmentNavigator$onAttach$2", "Landroidx/fragment/app/FragmentManager$OnBackStackChangedListener;", "onBackStackChangeCommitted", "", "fragment", "Landroidx/fragment/app/Fragment;", "pop", "", "onBackStackChangeStarted", "onBackStackChanged", "navigation-fragment_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: FragmentNavigator.kt */
public final class FragmentNavigator$onAttach$2 implements FragmentManager.OnBackStackChangedListener {
    final /* synthetic */ NavigatorState $state;
    final /* synthetic */ FragmentNavigator this$0;

    public void onBackStackChanged() {
    }

    FragmentNavigator$onAttach$2(NavigatorState navigatorState, FragmentNavigator fragmentNavigator) {
        this.$state = navigatorState;
        this.this$0 = fragmentNavigator;
    }

    public void onBackStackChangeStarted(Fragment fragment, boolean z) {
        Object obj;
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        if (z) {
            List value = this.$state.getBackStack().getValue();
            ListIterator listIterator = value.listIterator(value.size());
            while (true) {
                if (!listIterator.hasPrevious()) {
                    obj = null;
                    break;
                }
                obj = listIterator.previous();
                if (Intrinsics.areEqual((Object) ((NavBackStackEntry) obj).getId(), (Object) fragment.getTag())) {
                    break;
                }
            }
            NavBackStackEntry navBackStackEntry = (NavBackStackEntry) obj;
            if (navBackStackEntry != null) {
                this.$state.prepareForTransition(navBackStackEntry);
            }
        }
    }

    public void onBackStackChangeCommitted(Fragment fragment, boolean z) {
        Object obj;
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        List plus = CollectionsKt.plus(this.$state.getBackStack().getValue(), this.$state.getTransitionsInProgress().getValue());
        ListIterator listIterator = plus.listIterator(plus.size());
        while (true) {
            if (!listIterator.hasPrevious()) {
                obj = null;
                break;
            }
            obj = listIterator.previous();
            if (Intrinsics.areEqual((Object) ((NavBackStackEntry) obj).getId(), (Object) fragment.getTag())) {
                break;
            }
        }
        NavBackStackEntry navBackStackEntry = (NavBackStackEntry) obj;
        if (!z && navBackStackEntry == null) {
            throw new IllegalArgumentException(("The fragment " + fragment + " is unknown to the FragmentNavigator. Please use the navigate() function to add fragments to the FragmentNavigator managed FragmentManager.").toString());
        } else if (navBackStackEntry != null) {
            this.this$0.attachClearViewModel$navigation_fragment_release(fragment, navBackStackEntry, this.$state);
            if (z && this.this$0.getEntriesToPop$navigation_fragment_release().isEmpty() && fragment.isRemoving()) {
                this.$state.popWithTransition(navBackStackEntry, false);
            }
        }
    }
}
