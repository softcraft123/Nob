package androidx.window.embedding;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\u0016\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016J\u0016\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u0014J\b\u0010\u0019\u001a\u00020\u0006H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u001a"}, d2 = {"Landroidx/window/embedding/SplitPairFilter;", "", "primaryActivityName", "Landroid/content/ComponentName;", "secondaryActivityName", "secondaryActivityIntentAction", "", "(Landroid/content/ComponentName;Landroid/content/ComponentName;Ljava/lang/String;)V", "getPrimaryActivityName", "()Landroid/content/ComponentName;", "getSecondaryActivityIntentAction", "()Ljava/lang/String;", "getSecondaryActivityName", "equals", "", "other", "hashCode", "", "matchesActivityIntentPair", "primaryActivity", "Landroid/app/Activity;", "secondaryActivityIntent", "Landroid/content/Intent;", "matchesActivityPair", "secondaryActivity", "toString", "window_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SplitPairFilter.kt */
public final class SplitPairFilter {
    private final ComponentName primaryActivityName;
    private final String secondaryActivityIntentAction;
    private final ComponentName secondaryActivityName;

    public SplitPairFilter(ComponentName componentName, ComponentName componentName2, String str) {
        Object obj;
        ComponentName componentName3 = componentName;
        ComponentName componentName4 = componentName2;
        Intrinsics.checkNotNullParameter(componentName3, "primaryActivityName");
        Intrinsics.checkNotNullParameter(componentName4, "secondaryActivityName");
        this.primaryActivityName = componentName3;
        this.secondaryActivityName = componentName4;
        this.secondaryActivityIntentAction = str;
        String packageName = componentName3.getPackageName();
        Intrinsics.checkNotNullExpressionValue(packageName, "primaryActivityName.packageName");
        String className = componentName3.getClassName();
        Intrinsics.checkNotNullExpressionValue(className, "primaryActivityName.className");
        String packageName2 = componentName4.getPackageName();
        Intrinsics.checkNotNullExpressionValue(packageName2, "secondaryActivityName.packageName");
        String className2 = componentName4.getClassName();
        Intrinsics.checkNotNullExpressionValue(className2, "secondaryActivityName.className");
        CharSequence charSequence = packageName;
        if (charSequence.length() == 0 || packageName2.length() == 0) {
            throw new IllegalArgumentException("Package name must not be empty".toString());
        }
        CharSequence charSequence2 = className;
        if (charSequence2.length() == 0 || className2.length() == 0) {
            throw new IllegalArgumentException("Activity class name must not be empty.".toString());
        } else if (!StringsKt.contains$default(charSequence, (CharSequence) "*", false, 2, (Object) null) || StringsKt.indexOf$default(charSequence, "*", 0, false, 6, (Object) null) == packageName.length() - 1) {
            if (StringsKt.contains$default(charSequence2, (CharSequence) "*", false, 2, (Object) null)) {
                obj = null;
                if (StringsKt.indexOf$default(charSequence2, "*", 0, false, 6, (Object) null) != className.length() - 1) {
                    throw new IllegalArgumentException("Wildcard in class name is only allowed at the end.".toString());
                }
            } else {
                obj = null;
            }
            CharSequence charSequence3 = packageName2;
            if (!StringsKt.contains$default(charSequence3, (CharSequence) "*", false, 2, obj) || StringsKt.indexOf$default(charSequence3, "*", 0, false, 6, (Object) null) == packageName2.length() - 1) {
                CharSequence charSequence4 = className2;
                if (StringsKt.contains$default(charSequence4, (CharSequence) "*", false, 2, obj) && StringsKt.indexOf$default(charSequence4, "*", 0, false, 6, (Object) null) != className2.length() - 1) {
                    throw new IllegalArgumentException("Wildcard in class name is only allowed at the end.".toString());
                }
                return;
            }
            throw new IllegalArgumentException("Wildcard in package name is only allowed at the end.".toString());
        } else {
            throw new IllegalArgumentException("Wildcard in package name is only allowed at the end.".toString());
        }
    }

    public final ComponentName getPrimaryActivityName() {
        return this.primaryActivityName;
    }

    public final ComponentName getSecondaryActivityName() {
        return this.secondaryActivityName;
    }

    public final String getSecondaryActivityIntentAction() {
        return this.secondaryActivityIntentAction;
    }

    public final boolean matchesActivityPair(Activity activity, Activity activity2) {
        Intrinsics.checkNotNullParameter(activity, "primaryActivity");
        Intrinsics.checkNotNullParameter(activity2, "secondaryActivity");
        boolean z = MatcherUtils.INSTANCE.areComponentsMatching$window_release(activity.getComponentName(), this.primaryActivityName) && MatcherUtils.INSTANCE.areComponentsMatching$window_release(activity2.getComponentName(), this.secondaryActivityName);
        if (activity2.getIntent() == null) {
            return z;
        }
        if (z) {
            Intent intent = activity2.getIntent();
            Intrinsics.checkNotNullExpressionValue(intent, "secondaryActivity.intent");
            if (matchesActivityIntentPair(activity, intent)) {
                return true;
            }
        }
        return false;
    }

    public final boolean matchesActivityIntentPair(Activity activity, Intent intent) {
        Intrinsics.checkNotNullParameter(activity, "primaryActivity");
        Intrinsics.checkNotNullParameter(intent, "secondaryActivityIntent");
        if (!MatcherUtils.INSTANCE.areComponentsMatching$window_release(activity.getComponentName(), this.primaryActivityName) || !MatcherUtils.INSTANCE.areComponentsMatching$window_release(intent.getComponent(), this.secondaryActivityName)) {
            return false;
        }
        String str = this.secondaryActivityIntentAction;
        if (str == null || Intrinsics.areEqual((Object) str, (Object) intent.getAction())) {
            return true;
        }
        return false;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SplitPairFilter)) {
            return false;
        }
        SplitPairFilter splitPairFilter = (SplitPairFilter) obj;
        return Intrinsics.areEqual((Object) this.primaryActivityName, (Object) splitPairFilter.primaryActivityName) && Intrinsics.areEqual((Object) this.secondaryActivityName, (Object) splitPairFilter.secondaryActivityName) && Intrinsics.areEqual((Object) this.secondaryActivityIntentAction, (Object) splitPairFilter.secondaryActivityIntentAction);
    }

    public int hashCode() {
        int hashCode = ((this.primaryActivityName.hashCode() * 31) + this.secondaryActivityName.hashCode()) * 31;
        String str = this.secondaryActivityIntentAction;
        return hashCode + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "SplitPairFilter{primaryActivityName=" + this.primaryActivityName + ", secondaryActivityName=" + this.secondaryActivityName + ", secondaryActivityAction=" + this.secondaryActivityIntentAction + '}';
    }
}
