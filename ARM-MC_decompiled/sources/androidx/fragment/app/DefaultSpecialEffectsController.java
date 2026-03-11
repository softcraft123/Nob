package androidx.fragment.app;

import android.animation.Animator;
import android.content.Context;
import android.graphics.Rect;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import androidx.collection.ArrayMap;
import androidx.core.app.SharedElementCallback;
import androidx.core.os.CancellationSignal;
import androidx.core.view.OneShotPreDrawListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewGroupCompat;
import androidx.fragment.app.FragmentAnim;
import androidx.fragment.app.SpecialEffectsController;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001e\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001:\u0003*+,B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002J(\u0010\t\u001a\u00020\u00062\u0016\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\f0\u000bj\b\u0012\u0004\u0012\u00020\f`\r2\u0006\u0010\u000e\u001a\u00020\fH\u0002J\u001e\u0010\u000f\u001a\u00020\u00062\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\b0\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J$\u0010\u0014\u001a\u00020\u00062\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\f0\u00162\u0006\u0010\u000e\u001a\u00020\fH\u0002J@\u0010\u0018\u001a\u00020\u00062\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00112\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\b0\u001c2\u0006\u0010\u001d\u001a\u00020\u00132\u0012\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00130\u001fH\u0002JL\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00130\u001f2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\"0\u00112\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\b0\u001c2\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010#\u001a\u0004\u0018\u00010\b2\b\u0010$\u001a\u0004\u0018\u00010\bH\u0002J\u0016\u0010%\u001a\u00020\u00062\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\b0\u0011H\u0002J&\u0010&\u001a\u00020\u0006*\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\f0'2\f\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00170)H\u0002¨\u0006-"}, d2 = {"Landroidx/fragment/app/DefaultSpecialEffectsController;", "Landroidx/fragment/app/SpecialEffectsController;", "container", "Landroid/view/ViewGroup;", "(Landroid/view/ViewGroup;)V", "applyContainerChanges", "", "operation", "Landroidx/fragment/app/SpecialEffectsController$Operation;", "captureTransitioningViews", "transitioningViews", "Ljava/util/ArrayList;", "Landroid/view/View;", "Lkotlin/collections/ArrayList;", "view", "executeOperations", "operations", "", "isPop", "", "findNamedViews", "namedViews", "", "", "startAnimations", "animationInfos", "Landroidx/fragment/app/DefaultSpecialEffectsController$AnimationInfo;", "awaitingContainerChanges", "", "startedAnyTransition", "startedTransitions", "", "startTransitions", "transitionInfos", "Landroidx/fragment/app/DefaultSpecialEffectsController$TransitionInfo;", "firstOut", "lastIn", "syncAnimations", "retainMatchingViews", "Landroidx/collection/ArrayMap;", "names", "", "AnimationInfo", "SpecialEffectsInfo", "TransitionInfo", "fragment_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: DefaultSpecialEffectsController.kt */
public final class DefaultSpecialEffectsController extends SpecialEffectsController {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DefaultSpecialEffectsController(ViewGroup viewGroup) {
        super(viewGroup);
        Intrinsics.checkNotNullParameter(viewGroup, "container");
    }

    public void executeOperations(List<? extends SpecialEffectsController.Operation> list, boolean z) {
        SpecialEffectsController.Operation operation;
        Object obj;
        Intrinsics.checkNotNullParameter(list, "operations");
        Iterator it = list.iterator();
        while (true) {
            operation = null;
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            SpecialEffectsController.Operation operation2 = (SpecialEffectsController.Operation) obj;
            SpecialEffectsController.Operation.State.Companion companion = SpecialEffectsController.Operation.State.Companion;
            View view = operation2.getFragment().mView;
            Intrinsics.checkNotNullExpressionValue(view, "operation.fragment.mView");
            if (companion.asOperationState(view) == SpecialEffectsController.Operation.State.VISIBLE && operation2.getFinalState() != SpecialEffectsController.Operation.State.VISIBLE) {
                break;
            }
        }
        SpecialEffectsController.Operation operation3 = (SpecialEffectsController.Operation) obj;
        ListIterator<? extends SpecialEffectsController.Operation> listIterator = list.listIterator(list.size());
        while (true) {
            if (!listIterator.hasPrevious()) {
                break;
            }
            Object previous = listIterator.previous();
            SpecialEffectsController.Operation operation4 = (SpecialEffectsController.Operation) previous;
            SpecialEffectsController.Operation.State.Companion companion2 = SpecialEffectsController.Operation.State.Companion;
            View view2 = operation4.getFragment().mView;
            Intrinsics.checkNotNullExpressionValue(view2, "operation.fragment.mView");
            if (companion2.asOperationState(view2) != SpecialEffectsController.Operation.State.VISIBLE && operation4.getFinalState() == SpecialEffectsController.Operation.State.VISIBLE) {
                operation = previous;
                break;
            }
        }
        SpecialEffectsController.Operation operation5 = operation;
        if (FragmentManager.isLoggingEnabled(2)) {
            Log.v(FragmentManager.TAG, "Executing operations from " + operation3 + " to " + operation5);
        }
        List arrayList = new ArrayList();
        List arrayList2 = new ArrayList();
        List<SpecialEffectsController.Operation> mutableList = CollectionsKt.toMutableList(list);
        syncAnimations(list);
        Iterator<? extends SpecialEffectsController.Operation> it2 = list.iterator();
        while (true) {
            boolean z2 = true;
            if (!it2.hasNext()) {
                break;
            }
            SpecialEffectsController.Operation operation6 = (SpecialEffectsController.Operation) it2.next();
            CancellationSignal cancellationSignal = new CancellationSignal();
            operation6.markStartedSpecialEffect(cancellationSignal);
            arrayList.add(new AnimationInfo(operation6, cancellationSignal, z));
            CancellationSignal cancellationSignal2 = new CancellationSignal();
            operation6.markStartedSpecialEffect(cancellationSignal2);
            if (z) {
                if (operation6 == operation3) {
                    arrayList2.add(new TransitionInfo(operation6, cancellationSignal2, z, z2));
                    operation6.addCompletionListener(new DefaultSpecialEffectsController$$ExternalSyntheticLambda2(mutableList, operation6, this));
                }
            } else if (operation6 == operation5) {
                arrayList2.add(new TransitionInfo(operation6, cancellationSignal2, z, z2));
                operation6.addCompletionListener(new DefaultSpecialEffectsController$$ExternalSyntheticLambda2(mutableList, operation6, this));
            }
            z2 = false;
            arrayList2.add(new TransitionInfo(operation6, cancellationSignal2, z, z2));
            operation6.addCompletionListener(new DefaultSpecialEffectsController$$ExternalSyntheticLambda2(mutableList, operation6, this));
        }
        Map<SpecialEffectsController.Operation, Boolean> startTransitions = startTransitions(arrayList2, mutableList, z, operation3, operation5);
        startAnimations(arrayList, mutableList, startTransitions.containsValue(true), startTransitions);
        for (SpecialEffectsController.Operation applyContainerChanges : mutableList) {
            applyContainerChanges(applyContainerChanges);
        }
        mutableList.clear();
        if (FragmentManager.isLoggingEnabled(2)) {
            Log.v(FragmentManager.TAG, "Completed executing operations from " + operation3 + " to " + operation5);
        }
    }

    /* access modifiers changed from: private */
    public static final void executeOperations$lambda$2(List list, SpecialEffectsController.Operation operation, DefaultSpecialEffectsController defaultSpecialEffectsController) {
        Intrinsics.checkNotNullParameter(list, "$awaitingContainerChanges");
        Intrinsics.checkNotNullParameter(operation, "$operation");
        Intrinsics.checkNotNullParameter(defaultSpecialEffectsController, "this$0");
        if (list.contains(operation)) {
            list.remove(operation);
            defaultSpecialEffectsController.applyContainerChanges(operation);
        }
    }

    private final void syncAnimations(List<? extends SpecialEffectsController.Operation> list) {
        Fragment fragment = ((SpecialEffectsController.Operation) CollectionsKt.last(list)).getFragment();
        for (SpecialEffectsController.Operation operation : list) {
            operation.getFragment().mAnimationInfo.mEnterAnim = fragment.mAnimationInfo.mEnterAnim;
            operation.getFragment().mAnimationInfo.mExitAnim = fragment.mAnimationInfo.mExitAnim;
            operation.getFragment().mAnimationInfo.mPopEnterAnim = fragment.mAnimationInfo.mPopEnterAnim;
            operation.getFragment().mAnimationInfo.mPopExitAnim = fragment.mAnimationInfo.mPopExitAnim;
        }
    }

    private final void startAnimations(List<AnimationInfo> list, List<SpecialEffectsController.Operation> list2, boolean z, Map<SpecialEffectsController.Operation, Boolean> map) {
        Context context = getContainer().getContext();
        List<AnimationInfo> arrayList = new ArrayList<>();
        boolean z2 = false;
        for (AnimationInfo next : list) {
            if (next.isVisibilityUnchanged()) {
                next.completeSpecialEffect();
            } else {
                Intrinsics.checkNotNullExpressionValue(context, "context");
                FragmentAnim.AnimationOrAnimator animation = next.getAnimation(context);
                if (animation == null) {
                    next.completeSpecialEffect();
                } else {
                    Animator animator = animation.animator;
                    if (animator == null) {
                        arrayList.add(next);
                    } else {
                        SpecialEffectsController.Operation operation = next.getOperation();
                        Fragment fragment = operation.getFragment();
                        if (Intrinsics.areEqual((Object) map.get(operation), (Object) true)) {
                            if (FragmentManager.isLoggingEnabled(2)) {
                                Log.v(FragmentManager.TAG, "Ignoring Animator set on " + fragment + " as this Fragment was involved in a Transition.");
                            }
                            next.completeSpecialEffect();
                        } else {
                            boolean z3 = operation.getFinalState() == SpecialEffectsController.Operation.State.GONE;
                            List<SpecialEffectsController.Operation> list3 = list2;
                            if (z3) {
                                list3.remove(operation);
                            }
                            View view = fragment.mView;
                            getContainer().startViewTransition(view);
                            animator.addListener(new DefaultSpecialEffectsController$startAnimations$1(this, view, z3, operation, next));
                            animator.setTarget(view);
                            animator.start();
                            if (FragmentManager.isLoggingEnabled(2)) {
                                Log.v(FragmentManager.TAG, "Animator from operation " + operation + " has started.");
                            }
                            next.getSignal().setOnCancelListener(new DefaultSpecialEffectsController$$ExternalSyntheticLambda0(animator, operation));
                            z2 = true;
                        }
                    }
                }
            }
            Map<SpecialEffectsController.Operation, Boolean> map2 = map;
        }
        for (AnimationInfo animationInfo : arrayList) {
            SpecialEffectsController.Operation operation2 = animationInfo.getOperation();
            Fragment fragment2 = operation2.getFragment();
            if (z) {
                if (FragmentManager.isLoggingEnabled(2)) {
                    Log.v(FragmentManager.TAG, "Ignoring Animation set on " + fragment2 + " as Animations cannot run alongside Transitions.");
                }
                animationInfo.completeSpecialEffect();
            } else if (z2) {
                if (FragmentManager.isLoggingEnabled(2)) {
                    Log.v(FragmentManager.TAG, "Ignoring Animation set on " + fragment2 + " as Animations cannot run alongside Animators.");
                }
                animationInfo.completeSpecialEffect();
            } else {
                View view2 = fragment2.mView;
                Intrinsics.checkNotNullExpressionValue(context, "context");
                FragmentAnim.AnimationOrAnimator animation2 = animationInfo.getAnimation(context);
                if (animation2 != null) {
                    Animation animation3 = animation2.animation;
                    if (animation3 != null) {
                        if (operation2.getFinalState() != SpecialEffectsController.Operation.State.REMOVED) {
                            view2.startAnimation(animation3);
                            animationInfo.completeSpecialEffect();
                        } else {
                            getContainer().startViewTransition(view2);
                            Animation endViewTransitionAnimation = new FragmentAnim.EndViewTransitionAnimation(animation3, getContainer(), view2);
                            endViewTransitionAnimation.setAnimationListener(new DefaultSpecialEffectsController$startAnimations$3(operation2, this, view2, animationInfo));
                            view2.startAnimation(endViewTransitionAnimation);
                            if (FragmentManager.isLoggingEnabled(2)) {
                                Log.v(FragmentManager.TAG, "Animation from operation " + operation2 + " has started.");
                            }
                        }
                        animationInfo.getSignal().setOnCancelListener(new DefaultSpecialEffectsController$$ExternalSyntheticLambda1(view2, this, animationInfo, operation2));
                    } else {
                        throw new IllegalStateException("Required value was null.".toString());
                    }
                } else {
                    throw new IllegalStateException("Required value was null.".toString());
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public static final void startAnimations$lambda$3(Animator animator, SpecialEffectsController.Operation operation) {
        Intrinsics.checkNotNullParameter(operation, "$operation");
        animator.end();
        if (FragmentManager.isLoggingEnabled(2)) {
            Log.v(FragmentManager.TAG, "Animator from operation " + operation + " has been canceled.");
        }
    }

    /* access modifiers changed from: private */
    public static final void startAnimations$lambda$4(View view, DefaultSpecialEffectsController defaultSpecialEffectsController, AnimationInfo animationInfo, SpecialEffectsController.Operation operation) {
        Intrinsics.checkNotNullParameter(defaultSpecialEffectsController, "this$0");
        Intrinsics.checkNotNullParameter(animationInfo, "$animationInfo");
        Intrinsics.checkNotNullParameter(operation, "$operation");
        view.clearAnimation();
        defaultSpecialEffectsController.getContainer().endViewTransition(view);
        animationInfo.completeSpecialEffect();
        if (FragmentManager.isLoggingEnabled(2)) {
            Log.v(FragmentManager.TAG, "Animation from operation " + operation + " has been cancelled.");
        }
    }

    private final Map<SpecialEffectsController.Operation, Boolean> startTransitions(List<TransitionInfo> list, List<SpecialEffectsController.Operation> list2, boolean z, SpecialEffectsController.Operation operation, SpecialEffectsController.Operation operation2) {
        Object obj;
        String str;
        String str2;
        String str3;
        ArrayList arrayList;
        View view;
        SpecialEffectsController.Operation operation3;
        Object obj2;
        Object obj3;
        Object obj4;
        Object obj5;
        View view2;
        Map<SpecialEffectsController.Operation, Boolean> map;
        ArrayList arrayList2;
        Pair pair;
        Collection collection;
        Collection collection2;
        Object obj6;
        View view3;
        Rect rect;
        View view4;
        DefaultSpecialEffectsController defaultSpecialEffectsController = this;
        boolean z2 = z;
        SpecialEffectsController.Operation operation4 = operation;
        SpecialEffectsController.Operation operation5 = operation2;
        Map<SpecialEffectsController.Operation, Boolean> linkedHashMap = new LinkedHashMap<>();
        Iterable iterable = list;
        Collection arrayList3 = new ArrayList();
        for (Object next : iterable) {
            if (!((TransitionInfo) next).isVisibilityUnchanged()) {
                arrayList3.add(next);
            }
        }
        Collection arrayList4 = new ArrayList();
        for (Object next2 : (List) arrayList3) {
            if (((TransitionInfo) next2).getHandlingImpl() != null) {
                arrayList4.add(next2);
            }
        }
        FragmentTransitionImpl fragmentTransitionImpl = null;
        for (TransitionInfo transitionInfo : (List) arrayList4) {
            FragmentTransitionImpl handlingImpl = transitionInfo.getHandlingImpl();
            if (fragmentTransitionImpl == null || handlingImpl == fragmentTransitionImpl) {
                fragmentTransitionImpl = handlingImpl;
            } else {
                throw new IllegalArgumentException(("Mixing framework transitions and AndroidX transitions is not allowed. Fragment " + transitionInfo.getOperation().getFragment() + " returned Transition " + transitionInfo.getTransition() + " which uses a different Transition type than other Fragments.").toString());
            }
        }
        if (fragmentTransitionImpl == null) {
            for (TransitionInfo next3 : list) {
                linkedHashMap.put(next3.getOperation(), false);
                next3.completeSpecialEffect();
            }
            return linkedHashMap;
        }
        View view5 = new View(defaultSpecialEffectsController.getContainer().getContext());
        Rect rect2 = new Rect();
        ArrayList arrayList5 = new ArrayList();
        ArrayList arrayList6 = new ArrayList();
        ArrayMap arrayMap = new ArrayMap();
        Iterator<TransitionInfo> it = list.iterator();
        boolean z3 = false;
        Object obj7 = null;
        View view6 = null;
        while (true) {
            boolean hasNext = it.hasNext();
            obj = obj7;
            str = FragmentManager.TAG;
            if (!hasNext) {
                break;
            }
            TransitionInfo next4 = it.next();
            if (!next4.hasSharedElementTransition() || operation4 == null || operation5 == null) {
                arrayList2 = arrayList5;
                view5 = view5;
                rect2 = rect2;
                linkedHashMap = linkedHashMap;
                iterable = iterable;
                obj7 = obj;
                view6 = view6;
                arrayMap = arrayMap;
            } else {
                Object wrapTransitionInSet = fragmentTransitionImpl.wrapTransitionInSet(fragmentTransitionImpl.cloneTransition(next4.getSharedElementTransition()));
                ArrayList<String> sharedElementSourceNames = operation5.getFragment().getSharedElementSourceNames();
                Iterable iterable2 = iterable;
                Intrinsics.checkNotNullExpressionValue(sharedElementSourceNames, "lastIn.fragment.sharedElementSourceNames");
                ArrayList<String> sharedElementSourceNames2 = operation4.getFragment().getSharedElementSourceNames();
                View view7 = view6;
                Intrinsics.checkNotNullExpressionValue(sharedElementSourceNames2, "firstOut.fragment.sharedElementSourceNames");
                ArrayList<String> sharedElementTargetNames = operation4.getFragment().getSharedElementTargetNames();
                Map<SpecialEffectsController.Operation, Boolean> map2 = linkedHashMap;
                Intrinsics.checkNotNullExpressionValue(sharedElementTargetNames, "firstOut.fragment.sharedElementTargetNames");
                int size = sharedElementTargetNames.size();
                View view8 = view5;
                Rect rect3 = rect2;
                int i = 0;
                while (i < size) {
                    int i2 = size;
                    int indexOf = sharedElementSourceNames.indexOf(sharedElementTargetNames.get(i));
                    if (indexOf != -1) {
                        sharedElementSourceNames.set(indexOf, sharedElementSourceNames2.get(i));
                    }
                    i++;
                    size = i2;
                }
                ArrayList<String> sharedElementTargetNames2 = operation5.getFragment().getSharedElementTargetNames();
                Intrinsics.checkNotNullExpressionValue(sharedElementTargetNames2, "lastIn.fragment.sharedElementTargetNames");
                if (!z2) {
                    pair = TuplesKt.to(operation4.getFragment().getExitTransitionCallback(), operation5.getFragment().getEnterTransitionCallback());
                } else {
                    pair = TuplesKt.to(operation4.getFragment().getEnterTransitionCallback(), operation5.getFragment().getExitTransitionCallback());
                }
                SharedElementCallback sharedElementCallback = (SharedElementCallback) pair.component1();
                SharedElementCallback sharedElementCallback2 = (SharedElementCallback) pair.component2();
                int i3 = 0;
                for (int size2 = sharedElementSourceNames.size(); i3 < size2; size2 = size2) {
                    arrayMap.put(sharedElementSourceNames.get(i3), sharedElementTargetNames2.get(i3));
                    i3++;
                    arrayList6 = arrayList6;
                }
                ArrayList arrayList7 = arrayList6;
                if (FragmentManager.isLoggingEnabled(2)) {
                    Log.v(str, ">>> entering view names <<<");
                    for (Iterator<String> it2 = sharedElementTargetNames2.iterator(); it2.hasNext(); it2 = it2) {
                        Log.v(str, "Name: " + it2.next());
                    }
                    Log.v(str, ">>> exiting view names <<<");
                    for (Iterator<String> it3 = sharedElementSourceNames.iterator(); it3.hasNext(); it3 = it3) {
                        Log.v(str, "Name: " + it3.next());
                    }
                }
                ArrayMap arrayMap2 = new ArrayMap();
                Map map3 = arrayMap2;
                View view9 = operation4.getFragment().mView;
                Object obj8 = wrapTransitionInSet;
                Intrinsics.checkNotNullExpressionValue(view9, "firstOut.fragment.mView");
                defaultSpecialEffectsController.findNamedViews(map3, view9);
                Collection collection3 = sharedElementSourceNames;
                arrayMap2.retainAll(collection3);
                if (sharedElementCallback != null) {
                    if (FragmentManager.isLoggingEnabled(2)) {
                        collection = collection3;
                        Log.v(str, "Executing exit callback for operation " + operation4);
                    } else {
                        collection = collection3;
                    }
                    sharedElementCallback.onMapSharedElements(sharedElementSourceNames, map3);
                    int size3 = sharedElementSourceNames.size() - 1;
                    if (size3 >= 0) {
                        while (true) {
                            int i4 = size3 - 1;
                            String str4 = sharedElementSourceNames.get(size3);
                            View view10 = (View) arrayMap2.get(str4);
                            if (view10 == null) {
                                arrayMap.remove(str4);
                            } else if (!Intrinsics.areEqual((Object) str4, (Object) ViewCompat.getTransitionName(view10))) {
                                arrayMap.put(ViewCompat.getTransitionName(view10), (String) arrayMap.remove(str4));
                            }
                            if (i4 < 0) {
                                break;
                            }
                            size3 = i4;
                        }
                    }
                } else {
                    collection = collection3;
                    arrayMap.retainAll(arrayMap2.keySet());
                }
                ArrayMap arrayMap3 = new ArrayMap();
                Map map4 = arrayMap3;
                View view11 = operation5.getFragment().mView;
                Intrinsics.checkNotNullExpressionValue(view11, "lastIn.fragment.mView");
                defaultSpecialEffectsController.findNamedViews(map4, view11);
                Collection collection4 = sharedElementTargetNames2;
                arrayMap3.retainAll(collection4);
                arrayMap3.retainAll(arrayMap.values());
                if (sharedElementCallback2 != null) {
                    if (FragmentManager.isLoggingEnabled(2)) {
                        collection2 = collection4;
                        Log.v(str, "Executing enter callback for operation " + operation5);
                    } else {
                        collection2 = collection4;
                    }
                    sharedElementCallback2.onMapSharedElements(sharedElementTargetNames2, map4);
                    int size4 = sharedElementTargetNames2.size() - 1;
                    if (size4 >= 0) {
                        while (true) {
                            int i5 = size4 - 1;
                            String str5 = sharedElementTargetNames2.get(size4);
                            View view12 = (View) arrayMap3.get(str5);
                            if (view12 == null) {
                                Intrinsics.checkNotNullExpressionValue(str5, "name");
                                String findKeyForValue = FragmentTransition.findKeyForValue(arrayMap, str5);
                                if (findKeyForValue != null) {
                                    arrayMap.remove(findKeyForValue);
                                }
                            } else if (!Intrinsics.areEqual((Object) str5, (Object) ViewCompat.getTransitionName(view12))) {
                                Intrinsics.checkNotNullExpressionValue(str5, "name");
                                String findKeyForValue2 = FragmentTransition.findKeyForValue(arrayMap, str5);
                                if (findKeyForValue2 != null) {
                                    arrayMap.put(findKeyForValue2, ViewCompat.getTransitionName(view12));
                                }
                            }
                            if (i5 < 0) {
                                break;
                            }
                            size4 = i5;
                        }
                    }
                } else {
                    collection2 = collection4;
                    FragmentTransition.retainValues(arrayMap, arrayMap3);
                }
                Set keySet = arrayMap.keySet();
                Intrinsics.checkNotNullExpressionValue(keySet, "sharedElementNameMapping.keys");
                defaultSpecialEffectsController.retainMatchingViews(arrayMap2, keySet);
                Collection values = arrayMap.values();
                Intrinsics.checkNotNullExpressionValue(values, "sharedElementNameMapping.values");
                defaultSpecialEffectsController.retainMatchingViews(arrayMap3, values);
                if (arrayMap.isEmpty()) {
                    arrayList5.clear();
                    arrayList7.clear();
                    iterable = iterable2;
                    view6 = view7;
                    linkedHashMap = map2;
                    view5 = view8;
                    rect2 = rect3;
                    arrayList6 = arrayList7;
                    obj7 = null;
                } else {
                    FragmentTransition.callSharedElementStartEnd(operation5.getFragment(), operation4.getFragment(), z2, arrayMap2, true);
                    OneShotPreDrawListener.add(defaultSpecialEffectsController.getContainer(), new DefaultSpecialEffectsController$$ExternalSyntheticLambda3(operation5, operation4, z2, arrayMap3));
                    arrayList5.addAll(arrayMap2.values());
                    if (!collection.isEmpty()) {
                        view3 = (View) arrayMap2.get(sharedElementSourceNames.get(0));
                        obj6 = obj8;
                        fragmentTransitionImpl.setEpicenter(obj6, view3);
                    } else {
                        obj6 = obj8;
                        view3 = view7;
                    }
                    arrayList6 = arrayList7;
                    arrayList6.addAll(arrayMap3.values());
                    if (collection2.isEmpty() || (view4 = (View) arrayMap3.get(sharedElementTargetNames2.get(0))) == null) {
                        rect = rect3;
                    } else {
                        rect = rect3;
                        OneShotPreDrawListener.add(defaultSpecialEffectsController.getContainer(), new DefaultSpecialEffectsController$$ExternalSyntheticLambda4(fragmentTransitionImpl, view4, rect));
                        z3 = true;
                    }
                    View view13 = view8;
                    fragmentTransitionImpl.setSharedElementTargets(obj6, view13, arrayList5);
                    arrayList2 = arrayList5;
                    fragmentTransitionImpl.scheduleRemoveTargets(obj6, (Object) null, (ArrayList<View>) null, (Object) null, (ArrayList<View>) null, obj6, arrayList6);
                    Map<SpecialEffectsController.Operation, Boolean> map5 = map2;
                    map5.put(operation4, true);
                    map5.put(operation5, true);
                    view6 = view3;
                    rect2 = rect;
                    obj7 = obj6;
                    iterable = iterable2;
                    arrayMap = arrayMap;
                    view5 = view13;
                    linkedHashMap = map5;
                }
            }
            arrayList5 = arrayList2;
        }
        Iterable iterable3 = iterable;
        Rect rect4 = rect2;
        ArrayList arrayList8 = arrayList5;
        ArrayMap arrayMap4 = arrayMap;
        View view14 = view6;
        Map<SpecialEffectsController.Operation, Boolean> map6 = linkedHashMap;
        View view15 = view5;
        ArrayList arrayList9 = new ArrayList();
        Iterator<TransitionInfo> it4 = list.iterator();
        Object obj9 = null;
        Object obj10 = null;
        while (it4.hasNext()) {
            TransitionInfo next5 = it4.next();
            if (next5.isVisibilityUnchanged()) {
                map6.put(next5.getOperation(), false);
                next5.completeSpecialEffect();
            } else {
                Object cloneTransition = fragmentTransitionImpl.cloneTransition(next5.getTransition());
                SpecialEffectsController.Operation operation6 = next5.getOperation();
                boolean z4 = obj != null && (operation6 == operation4 || operation6 == operation5);
                if (cloneTransition != null) {
                    Map<SpecialEffectsController.Operation, Boolean> map7 = map6;
                    ArrayList arrayList10 = new ArrayList();
                    Iterator<TransitionInfo> it5 = it4;
                    View view16 = operation6.getFragment().mView;
                    ArrayList arrayList11 = arrayList8;
                    Intrinsics.checkNotNullExpressionValue(view16, "operation.fragment.mView");
                    defaultSpecialEffectsController.captureTransitioningViews(arrayList10, view16);
                    if (z4) {
                        if (operation6 == operation4) {
                            arrayList10.removeAll(CollectionsKt.toSet(arrayList11));
                        } else {
                            arrayList10.removeAll(CollectionsKt.toSet(arrayList6));
                        }
                    }
                    if (arrayList10.isEmpty()) {
                        fragmentTransitionImpl.addTarget(cloneTransition, view15);
                        Object obj11 = obj;
                        view = view15;
                        obj5 = obj11;
                        obj4 = obj9;
                        obj3 = obj10;
                        obj2 = cloneTransition;
                        str3 = str;
                        operation3 = operation6;
                        view2 = view14;
                        map = map7;
                        List<SpecialEffectsController.Operation> list3 = list2;
                        arrayList = arrayList6;
                    } else {
                        fragmentTransitionImpl.addTargets(cloneTransition, arrayList10);
                        Object obj12 = obj9;
                        obj2 = cloneTransition;
                        Object obj13 = obj;
                        view = view15;
                        obj5 = obj13;
                        SpecialEffectsController.Operation operation7 = operation6;
                        view2 = view14;
                        obj4 = obj12;
                        map = map7;
                        str3 = str;
                        arrayList = arrayList6;
                        obj3 = obj10;
                        fragmentTransitionImpl.scheduleRemoveTargets(obj2, obj2, arrayList10, (Object) null, (ArrayList<View>) null, (Object) null, (ArrayList<View>) null);
                        if (operation7.getFinalState() == SpecialEffectsController.Operation.State.GONE) {
                            operation3 = operation7;
                            list2.remove(operation3);
                            ArrayList arrayList12 = new ArrayList(arrayList10);
                            arrayList12.remove(operation3.getFragment().mView);
                            fragmentTransitionImpl.scheduleHideFragmentView(obj2, operation3.getFragment().mView, arrayList12);
                            OneShotPreDrawListener.add(getContainer(), new DefaultSpecialEffectsController$$ExternalSyntheticLambda5(arrayList10));
                        } else {
                            List<SpecialEffectsController.Operation> list4 = list2;
                            operation3 = operation7;
                        }
                    }
                    if (operation3.getFinalState() == SpecialEffectsController.Operation.State.VISIBLE) {
                        arrayList9.addAll(arrayList10);
                        if (z3) {
                            fragmentTransitionImpl.setEpicenter(obj2, rect4);
                        }
                    } else {
                        fragmentTransitionImpl.setEpicenter(obj2, view2);
                    }
                    map.put(operation3, true);
                    if (next5.isOverlapAllowed()) {
                        obj9 = fragmentTransitionImpl.mergeTransitionsTogether(obj4, obj2, (Object) null);
                        View view17 = view;
                        obj = obj5;
                        view15 = view17;
                        it4 = it5;
                        map6 = map;
                        obj10 = obj3;
                        arrayList6 = arrayList;
                        arrayList8 = arrayList11;
                        str = str3;
                        defaultSpecialEffectsController = this;
                    } else {
                        Object mergeTransitionsTogether = fragmentTransitionImpl.mergeTransitionsTogether(obj3, obj2, (Object) null);
                        View view18 = view;
                        obj = obj5;
                        view15 = view18;
                        map6 = map;
                        obj9 = obj4;
                        obj10 = mergeTransitionsTogether;
                        arrayList6 = arrayList;
                        arrayList8 = arrayList11;
                        str = str3;
                        defaultSpecialEffectsController = this;
                        it4 = it5;
                    }
                    view14 = view2;
                    operation5 = operation2;
                } else if (!z4) {
                    map6.put(operation6, false);
                    next5.completeSpecialEffect();
                }
            }
        }
        ArrayList arrayList13 = arrayList8;
        Map<SpecialEffectsController.Operation, Boolean> map8 = map6;
        String str6 = str;
        ArrayList arrayList14 = arrayList6;
        Object obj14 = obj;
        Object mergeTransitionsInSequence = fragmentTransitionImpl.mergeTransitionsInSequence(obj9, obj10, obj14);
        if (mergeTransitionsInSequence == null) {
            return map8;
        }
        Collection arrayList15 = new ArrayList();
        for (Object next6 : iterable3) {
            if (!((TransitionInfo) next6).isVisibilityUnchanged()) {
                arrayList15.add(next6);
            }
        }
        for (TransitionInfo transitionInfo2 : (List) arrayList15) {
            Object transition = transitionInfo2.getTransition();
            SpecialEffectsController.Operation operation8 = transitionInfo2.getOperation();
            boolean z5 = obj14 != null && (operation8 == operation4 || operation8 == operation2);
            if (transition == null && !z5) {
                str2 = str6;
            } else if (!ViewCompat.isLaidOut(getContainer())) {
                if (FragmentManager.isLoggingEnabled(2)) {
                    str2 = str6;
                    Log.v(str2, "SpecialEffectsController: Container " + getContainer() + " has not been laid out. Completing operation " + operation8);
                } else {
                    str2 = str6;
                }
                transitionInfo2.completeSpecialEffect();
            } else {
                str2 = str6;
                fragmentTransitionImpl.setListenerForTransitionEnd(transitionInfo2.getOperation().getFragment(), mergeTransitionsInSequence, transitionInfo2.getSignal(), new DefaultSpecialEffectsController$$ExternalSyntheticLambda6(transitionInfo2, operation8));
            }
            str6 = str2;
        }
        String str7 = str6;
        if (!ViewCompat.isLaidOut(getContainer())) {
            return map8;
        }
        List list5 = arrayList9;
        FragmentTransition.setViewVisibility(list5, 4);
        ArrayList arrayList16 = arrayList14;
        ArrayList<String> prepareSetNameOverridesReordered = fragmentTransitionImpl.prepareSetNameOverridesReordered(arrayList16);
        if (FragmentManager.isLoggingEnabled(2)) {
            Log.v(str7, ">>>>> Beginning transition <<<<<");
            Log.v(str7, ">>>>> SharedElementFirstOutViews <<<<<");
            Iterator it6 = arrayList13.iterator();
            while (it6.hasNext()) {
                Object next7 = it6.next();
                Intrinsics.checkNotNullExpressionValue(next7, "sharedElementFirstOutViews");
                View view19 = (View) next7;
                Log.v(str7, "View: " + view19 + " Name: " + ViewCompat.getTransitionName(view19));
            }
            Log.v(str7, ">>>>> SharedElementLastInViews <<<<<");
            Iterator it7 = arrayList16.iterator();
            while (it7.hasNext()) {
                Object next8 = it7.next();
                Intrinsics.checkNotNullExpressionValue(next8, "sharedElementLastInViews");
                View view20 = (View) next8;
                Log.v(str7, "View: " + view20 + " Name: " + ViewCompat.getTransitionName(view20));
            }
        }
        fragmentTransitionImpl.beginDelayedTransition(getContainer(), mergeTransitionsInSequence);
        ArrayList arrayList17 = arrayList13;
        fragmentTransitionImpl.setNameOverridesReordered(getContainer(), arrayList17, arrayList16, prepareSetNameOverridesReordered, arrayMap4);
        FragmentTransition.setViewVisibility(list5, 0);
        fragmentTransitionImpl.swapSharedElementTargets(obj14, arrayList17, arrayList16);
        return map8;
    }

    /* access modifiers changed from: private */
    public static final void startTransitions$lambda$9(SpecialEffectsController.Operation operation, SpecialEffectsController.Operation operation2, boolean z, ArrayMap arrayMap) {
        Intrinsics.checkNotNullParameter(arrayMap, "$lastInViews");
        FragmentTransition.callSharedElementStartEnd(operation.getFragment(), operation2.getFragment(), z, arrayMap, false);
    }

    /* access modifiers changed from: private */
    public static final void startTransitions$lambda$10(FragmentTransitionImpl fragmentTransitionImpl, View view, Rect rect) {
        Intrinsics.checkNotNullParameter(fragmentTransitionImpl, "$impl");
        Intrinsics.checkNotNullParameter(rect, "$lastInEpicenterRect");
        fragmentTransitionImpl.getBoundsOnScreen(view, rect);
    }

    /* access modifiers changed from: private */
    public static final void startTransitions$lambda$11(ArrayList arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "$transitioningViews");
        FragmentTransition.setViewVisibility(arrayList, 4);
    }

    /* access modifiers changed from: private */
    public static final void startTransitions$lambda$14$lambda$13(TransitionInfo transitionInfo, SpecialEffectsController.Operation operation) {
        Intrinsics.checkNotNullParameter(transitionInfo, "$transitionInfo");
        Intrinsics.checkNotNullParameter(operation, "$operation");
        transitionInfo.completeSpecialEffect();
        if (FragmentManager.isLoggingEnabled(2)) {
            Log.v(FragmentManager.TAG, "Transition for operation " + operation + " has completed");
        }
    }

    private final void retainMatchingViews(ArrayMap<String, View> arrayMap, Collection<String> collection) {
        Set<Map.Entry<String, View>> entrySet = arrayMap.entrySet();
        Intrinsics.checkNotNullExpressionValue(entrySet, "entries");
        CollectionsKt.retainAll(entrySet, new DefaultSpecialEffectsController$retainMatchingViews$1(collection));
    }

    private final void captureTransitioningViews(ArrayList<View> arrayList, View view) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            if (!ViewGroupCompat.isTransitionGroup(viewGroup)) {
                int childCount = viewGroup.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    View childAt = viewGroup.getChildAt(i);
                    if (childAt.getVisibility() == 0) {
                        Intrinsics.checkNotNullExpressionValue(childAt, "child");
                        captureTransitioningViews(arrayList, childAt);
                    }
                }
            } else if (!arrayList.contains(view)) {
                arrayList.add(view);
            }
        } else if (!arrayList.contains(view)) {
            arrayList.add(view);
        }
    }

    private final void findNamedViews(Map<String, View> map, View view) {
        String transitionName = ViewCompat.getTransitionName(view);
        if (transitionName != null) {
            map.put(transitionName, view);
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = viewGroup.getChildAt(i);
                if (childAt.getVisibility() == 0) {
                    Intrinsics.checkNotNullExpressionValue(childAt, "child");
                    findNamedViews(map, childAt);
                }
            }
        }
    }

    private final void applyContainerChanges(SpecialEffectsController.Operation operation) {
        View view = operation.getFragment().mView;
        SpecialEffectsController.Operation.State finalState = operation.getFinalState();
        Intrinsics.checkNotNullExpressionValue(view, "view");
        finalState.applyState(view);
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\b\u0012\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\u000e\u001a\u00020\u000fR\u0011\u0010\u0007\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0010"}, d2 = {"Landroidx/fragment/app/DefaultSpecialEffectsController$SpecialEffectsInfo;", "", "operation", "Landroidx/fragment/app/SpecialEffectsController$Operation;", "signal", "Landroidx/core/os/CancellationSignal;", "(Landroidx/fragment/app/SpecialEffectsController$Operation;Landroidx/core/os/CancellationSignal;)V", "isVisibilityUnchanged", "", "()Z", "getOperation", "()Landroidx/fragment/app/SpecialEffectsController$Operation;", "getSignal", "()Landroidx/core/os/CancellationSignal;", "completeSpecialEffect", "", "fragment_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: DefaultSpecialEffectsController.kt */
    private static class SpecialEffectsInfo {
        private final SpecialEffectsController.Operation operation;
        private final CancellationSignal signal;

        public SpecialEffectsInfo(SpecialEffectsController.Operation operation2, CancellationSignal cancellationSignal) {
            Intrinsics.checkNotNullParameter(operation2, "operation");
            Intrinsics.checkNotNullParameter(cancellationSignal, "signal");
            this.operation = operation2;
            this.signal = cancellationSignal;
        }

        public final SpecialEffectsController.Operation getOperation() {
            return this.operation;
        }

        public final CancellationSignal getSignal() {
            return this.signal;
        }

        public final boolean isVisibilityUnchanged() {
            SpecialEffectsController.Operation.State.Companion companion = SpecialEffectsController.Operation.State.Companion;
            View view = this.operation.getFragment().mView;
            Intrinsics.checkNotNullExpressionValue(view, "operation.fragment.mView");
            SpecialEffectsController.Operation.State asOperationState = companion.asOperationState(view);
            SpecialEffectsController.Operation.State finalState = this.operation.getFinalState();
            if (asOperationState != finalState) {
                return (asOperationState == SpecialEffectsController.Operation.State.VISIBLE || finalState == SpecialEffectsController.Operation.State.VISIBLE) ? false : true;
            }
            return true;
        }

        public final void completeSpecialEffect() {
            this.operation.completeSpecialEffect(this.signal);
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\f\u001a\u0004\u0018\u00010\n2\u0006\u0010\r\u001a\u00020\u000eR\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Landroidx/fragment/app/DefaultSpecialEffectsController$AnimationInfo;", "Landroidx/fragment/app/DefaultSpecialEffectsController$SpecialEffectsInfo;", "operation", "Landroidx/fragment/app/SpecialEffectsController$Operation;", "signal", "Landroidx/core/os/CancellationSignal;", "isPop", "", "(Landroidx/fragment/app/SpecialEffectsController$Operation;Landroidx/core/os/CancellationSignal;Z)V", "animation", "Landroidx/fragment/app/FragmentAnim$AnimationOrAnimator;", "isAnimLoaded", "getAnimation", "context", "Landroid/content/Context;", "fragment_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: DefaultSpecialEffectsController.kt */
    private static final class AnimationInfo extends SpecialEffectsInfo {
        private FragmentAnim.AnimationOrAnimator animation;
        private boolean isAnimLoaded;
        private final boolean isPop;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public AnimationInfo(SpecialEffectsController.Operation operation, CancellationSignal cancellationSignal, boolean z) {
            super(operation, cancellationSignal);
            Intrinsics.checkNotNullParameter(operation, "operation");
            Intrinsics.checkNotNullParameter(cancellationSignal, "signal");
            this.isPop = z;
        }

        public final FragmentAnim.AnimationOrAnimator getAnimation(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            if (this.isAnimLoaded) {
                return this.animation;
            }
            FragmentAnim.AnimationOrAnimator loadAnimation = FragmentAnim.loadAnimation(context, getOperation().getFragment(), getOperation().getFinalState() == SpecialEffectsController.Operation.State.VISIBLE, this.isPop);
            this.animation = loadAnimation;
            this.isAnimLoaded = true;
            return loadAnimation;
        }
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0002\u0010\tJ\u0014\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0011H\u0002J\u0006\u0010\u0016\u001a\u00020\u0007R\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b8F¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013¨\u0006\u0017"}, d2 = {"Landroidx/fragment/app/DefaultSpecialEffectsController$TransitionInfo;", "Landroidx/fragment/app/DefaultSpecialEffectsController$SpecialEffectsInfo;", "operation", "Landroidx/fragment/app/SpecialEffectsController$Operation;", "signal", "Landroidx/core/os/CancellationSignal;", "isPop", "", "providesSharedElementTransition", "(Landroidx/fragment/app/SpecialEffectsController$Operation;Landroidx/core/os/CancellationSignal;ZZ)V", "handlingImpl", "Landroidx/fragment/app/FragmentTransitionImpl;", "getHandlingImpl", "()Landroidx/fragment/app/FragmentTransitionImpl;", "isOverlapAllowed", "()Z", "sharedElementTransition", "", "getSharedElementTransition", "()Ljava/lang/Object;", "transition", "getTransition", "hasSharedElementTransition", "fragment_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: DefaultSpecialEffectsController.kt */
    private static final class TransitionInfo extends SpecialEffectsInfo {
        private final boolean isOverlapAllowed;
        private final Object sharedElementTransition;
        private final Object transition;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public TransitionInfo(SpecialEffectsController.Operation operation, CancellationSignal cancellationSignal, boolean z, boolean z2) {
            super(operation, cancellationSignal);
            Object obj;
            boolean z3;
            Object obj2;
            Intrinsics.checkNotNullParameter(operation, "operation");
            Intrinsics.checkNotNullParameter(cancellationSignal, "signal");
            if (operation.getFinalState() == SpecialEffectsController.Operation.State.VISIBLE) {
                Fragment fragment = operation.getFragment();
                obj = z ? fragment.getReenterTransition() : fragment.getEnterTransition();
            } else {
                Fragment fragment2 = operation.getFragment();
                obj = z ? fragment2.getReturnTransition() : fragment2.getExitTransition();
            }
            this.transition = obj;
            if (operation.getFinalState() == SpecialEffectsController.Operation.State.VISIBLE) {
                z3 = z ? operation.getFragment().getAllowReturnTransitionOverlap() : operation.getFragment().getAllowEnterTransitionOverlap();
            } else {
                z3 = true;
            }
            this.isOverlapAllowed = z3;
            if (z2) {
                obj2 = z ? operation.getFragment().getSharedElementReturnTransition() : operation.getFragment().getSharedElementEnterTransition();
            } else {
                obj2 = null;
            }
            this.sharedElementTransition = obj2;
        }

        public final Object getTransition() {
            return this.transition;
        }

        public final boolean isOverlapAllowed() {
            return this.isOverlapAllowed;
        }

        public final Object getSharedElementTransition() {
            return this.sharedElementTransition;
        }

        public final boolean hasSharedElementTransition() {
            return this.sharedElementTransition != null;
        }

        public final FragmentTransitionImpl getHandlingImpl() {
            FragmentTransitionImpl handlingImpl = getHandlingImpl(this.transition);
            FragmentTransitionImpl handlingImpl2 = getHandlingImpl(this.sharedElementTransition);
            if (handlingImpl == null || handlingImpl2 == null || handlingImpl == handlingImpl2) {
                return handlingImpl == null ? handlingImpl2 : handlingImpl;
            }
            throw new IllegalArgumentException(("Mixing framework transitions and AndroidX transitions is not allowed. Fragment " + getOperation().getFragment() + " returned Transition " + this.transition + " which uses a different Transition  type than its shared element transition " + this.sharedElementTransition).toString());
        }

        private final FragmentTransitionImpl getHandlingImpl(Object obj) {
            if (obj == null) {
                return null;
            }
            if (FragmentTransition.PLATFORM_IMPL != null && FragmentTransition.PLATFORM_IMPL.canHandle(obj)) {
                return FragmentTransition.PLATFORM_IMPL;
            }
            if (FragmentTransition.SUPPORT_IMPL != null && FragmentTransition.SUPPORT_IMPL.canHandle(obj)) {
                return FragmentTransition.SUPPORT_IMPL;
            }
            throw new IllegalArgumentException("Transition " + obj + " for fragment " + getOperation().getFragment() + " is not a valid framework Transition or AndroidX Transition");
        }
    }
}
