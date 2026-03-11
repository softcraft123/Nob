package androidx.navigation;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.sequences.Sequence;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Landroidx/navigation/NavOptionsBuilder;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: NavController.kt */
final class NavController$handleDeepLink$2 extends Lambda implements Function1<NavOptionsBuilder, Unit> {
    final /* synthetic */ NavDestination $node;
    final /* synthetic */ NavController this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    NavController$handleDeepLink$2(NavDestination navDestination, NavController navController) {
        super(1);
        this.$node = navDestination;
        this.this$0 = navController;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((NavOptionsBuilder) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(NavOptionsBuilder navOptionsBuilder) {
        Intrinsics.checkNotNullParameter(navOptionsBuilder, "$this$navOptions");
        navOptionsBuilder.anim(AnonymousClass1.INSTANCE);
        if (this.$node instanceof NavGraph) {
            Sequence<NavDestination> hierarchy = NavDestination.Companion.getHierarchy(this.$node);
            NavController navController = this.this$0;
            for (NavDestination next : hierarchy) {
                NavDestination currentDestination = navController.getCurrentDestination();
                if (Intrinsics.areEqual((Object) next, (Object) currentDestination != null ? currentDestination.getParent() : null)) {
                    return;
                }
            }
            if (NavController.deepLinkSaveState) {
                navOptionsBuilder.popUpTo(NavGraph.Companion.findStartDestination(this.this$0.getGraph()).getId(), (Function1<? super PopUpToBuilder, Unit>) AnonymousClass2.INSTANCE);
            }
        }
    }
}
