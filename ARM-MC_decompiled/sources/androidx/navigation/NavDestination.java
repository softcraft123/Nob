package androidx.navigation;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.net.Uri;
import android.os.Bundle;
import android.util.AttributeSet;
import androidx.collection.SparseArrayCompat;
import androidx.collection.SparseArrayKt;
import androidx.navigation.NavDeepLink;
import androidx.navigation.NavDeepLinkRequest;
import androidx.navigation.common.R;
import java.lang.annotation.ElementType;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.AnnotationTarget;
import kotlin.annotation.Retention;
import kotlin.annotation.Target;
import kotlin.collections.ArrayDeque;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000 \u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\r\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\b\u0016\u0018\u0000 ]2\u00020\u0001:\u0003\\]^B\u0017\b\u0016\u0012\u000e\u0010\u0002\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00000\u0003¢\u0006\u0002\u0010\u0004B\r\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0016\u00100\u001a\u0002012\u0006\u00102\u001a\u00020\u00062\u0006\u00103\u001a\u00020\nJ\u000e\u00104\u001a\u0002012\u0006\u00105\u001a\u00020\u0014J\u000e\u00104\u001a\u0002012\u0006\u00106\u001a\u00020\u0006J\u0014\u00107\u001a\u0004\u0018\u0001082\b\u00109\u001a\u0004\u0018\u000108H\u0007J\u0014\u0010:\u001a\u00020;2\n\b\u0002\u0010<\u001a\u0004\u0018\u00010\u0000H\u0007J\u0013\u0010=\u001a\u00020>2\b\u0010?\u001a\u0004\u0018\u00010\u0001H\u0002J\u001a\u0010@\u001a\u0004\u0018\u00010\u00062\u0006\u0010A\u001a\u00020B2\b\u0010C\u001a\u0004\u0018\u000108J\u0012\u0010D\u001a\u0004\u0018\u00010\r2\b\b\u0001\u0010\u0018\u001a\u00020\u0019J\u0010\u0010E\u001a\u00020>2\u0006\u0010F\u001a\u00020GH\u0016J\u0010\u0010E\u001a\u00020>2\u0006\u0010H\u001a\u00020IH\u0016J.\u0010J\u001a\u00020>2\u0006\u0010F\u001a\u00020\u00142\b\u0010K\u001a\u0004\u0018\u00010G2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\n0\u000fH\u0002J\u001a\u0010L\u001a\u00020>2\u0006\u0010-\u001a\u00020\u00062\b\u0010\u000e\u001a\u0004\u0018\u000108H\u0007J\b\u0010M\u001a\u00020\u0019H\u0016J\u0012\u0010N\u001a\u0004\u0018\u00010O2\u0006\u0010P\u001a\u00020IH\u0017J\u0012\u0010N\u001a\u0004\u0018\u00010O2\u0006\u0010-\u001a\u00020\u0006H\u0007J\u0018\u0010Q\u001a\u0002012\u0006\u0010A\u001a\u00020B2\u0006\u0010R\u001a\u00020SH\u0017J\u0018\u0010T\u001a\u0002012\b\b\u0001\u0010U\u001a\u00020\u00192\u0006\u0010V\u001a\u00020\rJ\u001a\u0010T\u001a\u0002012\b\b\u0001\u0010U\u001a\u00020\u00192\b\b\u0001\u0010W\u001a\u00020\u0019J\u0010\u0010X\u001a\u0002012\b\b\u0001\u0010U\u001a\u00020\u0019J\u000e\u0010Y\u001a\u0002012\u0006\u00102\u001a\u00020\u0006J\b\u0010Z\u001a\u00020>H\u0017J\b\u0010[\u001a\u00020\u0006H\u0016R\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\n0\tX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\n0\u000f8F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\u00020\u00068WX\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R(\u0010\u0018\u001a\u00020\u00192\b\b\u0001\u0010\u0018\u001a\u00020\u00198G@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u001f\u001a\u0004\u0018\u00010 X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0017R(\u0010(\u001a\u0004\u0018\u00010'2\b\u0010&\u001a\u0004\u0018\u00010'@GX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R(\u0010-\u001a\u0004\u0018\u00010\u00062\b\u0010-\u001a\u0004\u0018\u00010\u0006@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\u0017\"\u0004\b/\u0010\u0007¨\u0006_"}, d2 = {"Landroidx/navigation/NavDestination;", "", "navigator", "Landroidx/navigation/Navigator;", "(Landroidx/navigation/Navigator;)V", "navigatorName", "", "(Ljava/lang/String;)V", "_arguments", "", "Landroidx/navigation/NavArgument;", "actions", "Landroidx/collection/SparseArrayCompat;", "Landroidx/navigation/NavAction;", "arguments", "", "getArguments", "()Ljava/util/Map;", "deepLinks", "", "Landroidx/navigation/NavDeepLink;", "displayName", "getDisplayName", "()Ljava/lang/String;", "id", "", "getId", "()I", "setId", "(I)V", "idName", "label", "", "getLabel", "()Ljava/lang/CharSequence;", "setLabel", "(Ljava/lang/CharSequence;)V", "getNavigatorName", "<set-?>", "Landroidx/navigation/NavGraph;", "parent", "getParent", "()Landroidx/navigation/NavGraph;", "setParent", "(Landroidx/navigation/NavGraph;)V", "route", "getRoute", "setRoute", "addArgument", "", "argumentName", "argument", "addDeepLink", "navDeepLink", "uriPattern", "addInDefaultArgs", "Landroid/os/Bundle;", "args", "buildDeepLinkIds", "", "previousDestination", "equals", "", "other", "fillInLabel", "context", "Landroid/content/Context;", "bundle", "getAction", "hasDeepLink", "deepLink", "Landroid/net/Uri;", "deepLinkRequest", "Landroidx/navigation/NavDeepLinkRequest;", "hasRequiredArguments", "uri", "hasRoute", "hashCode", "matchDeepLink", "Landroidx/navigation/NavDestination$DeepLinkMatch;", "navDeepLinkRequest", "onInflate", "attrs", "Landroid/util/AttributeSet;", "putAction", "actionId", "action", "destId", "removeAction", "removeArgument", "supportsActions", "toString", "ClassType", "Companion", "DeepLinkMatch", "navigation-common_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: NavDestination.kt */
public class NavDestination {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final Map<String, Class<?>> classes = new LinkedHashMap();
    private Map<String, NavArgument> _arguments;
    private final SparseArrayCompat<NavAction> actions;
    private final List<NavDeepLink> deepLinks;
    private int id;
    private String idName;
    private CharSequence label;
    private final String navigatorName;
    private NavGraph parent;
    private String route;

    @Target(allowedTargets = {AnnotationTarget.ANNOTATION_CLASS, AnnotationTarget.CLASS})
    @Retention(AnnotationRetention.BINARY)
    @java.lang.annotation.Target({ElementType.TYPE, ElementType.ANNOTATION_TYPE})
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\f\u0012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003R\u0013\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"Landroidx/navigation/NavDestination$ClassType;", "", "value", "Lkotlin/reflect/KClass;", "()Ljava/lang/Class;", "navigation-common_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    @java.lang.annotation.Retention(RetentionPolicy.CLASS)
    /* compiled from: NavDestination.kt */
    public @interface ClassType {
        Class<?> value();
    }

    @JvmStatic
    public static final String getDisplayName(Context context, int i) {
        return Companion.getDisplayName(context, i);
    }

    public static final Sequence<NavDestination> getHierarchy(NavDestination navDestination) {
        return Companion.getHierarchy(navDestination);
    }

    @JvmStatic
    protected static final <C> Class<? extends C> parseClassFromName(Context context, String str, Class<? extends C> cls) {
        return Companion.parseClassFromName(context, str, cls);
    }

    @JvmStatic
    public static final <C> Class<? extends C> parseClassFromNameInternal(Context context, String str, Class<? extends C> cls) {
        return Companion.parseClassFromNameInternal(context, str, cls);
    }

    public final int[] buildDeepLinkIds() {
        return buildDeepLinkIds$default(this, (NavDestination) null, 1, (Object) null);
    }

    public boolean supportsActions() {
        return true;
    }

    public NavDestination(String str) {
        Intrinsics.checkNotNullParameter(str, "navigatorName");
        this.navigatorName = str;
        this.deepLinks = new ArrayList();
        this.actions = new SparseArrayCompat<>();
        this._arguments = new LinkedHashMap();
    }

    public final String getNavigatorName() {
        return this.navigatorName;
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\f\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u0007\u0012\u0006\u0010\u000b\u001a\u00020\t¢\u0006\u0002\u0010\fJ\u0011\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u0000H\u0002J\u0010\u0010\u0013\u001a\u00020\u00072\b\u0010\u0014\u001a\u0004\u0018\u00010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\n\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Landroidx/navigation/NavDestination$DeepLinkMatch;", "", "destination", "Landroidx/navigation/NavDestination;", "matchingArgs", "Landroid/os/Bundle;", "isExactDeepLink", "", "matchingPathSegments", "", "hasMatchingAction", "mimeTypeMatchLevel", "(Landroidx/navigation/NavDestination;Landroid/os/Bundle;ZIZI)V", "getDestination", "()Landroidx/navigation/NavDestination;", "getMatchingArgs", "()Landroid/os/Bundle;", "compareTo", "other", "hasMatchingArgs", "arguments", "navigation-common_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: NavDestination.kt */
    public static final class DeepLinkMatch implements Comparable<DeepLinkMatch> {
        private final NavDestination destination;
        private final boolean hasMatchingAction;
        private final boolean isExactDeepLink;
        private final Bundle matchingArgs;
        private final int matchingPathSegments;
        private final int mimeTypeMatchLevel;

        public DeepLinkMatch(NavDestination navDestination, Bundle bundle, boolean z, int i, boolean z2, int i2) {
            Intrinsics.checkNotNullParameter(navDestination, "destination");
            this.destination = navDestination;
            this.matchingArgs = bundle;
            this.isExactDeepLink = z;
            this.matchingPathSegments = i;
            this.hasMatchingAction = z2;
            this.mimeTypeMatchLevel = i2;
        }

        public final NavDestination getDestination() {
            return this.destination;
        }

        public final Bundle getMatchingArgs() {
            return this.matchingArgs;
        }

        public int compareTo(DeepLinkMatch deepLinkMatch) {
            Intrinsics.checkNotNullParameter(deepLinkMatch, "other");
            boolean z = this.isExactDeepLink;
            if (z && !deepLinkMatch.isExactDeepLink) {
                return 1;
            }
            if (!z && deepLinkMatch.isExactDeepLink) {
                return -1;
            }
            int i = this.matchingPathSegments - deepLinkMatch.matchingPathSegments;
            if (i > 0) {
                return 1;
            }
            if (i < 0) {
                return -1;
            }
            Bundle bundle = this.matchingArgs;
            if (bundle != null && deepLinkMatch.matchingArgs == null) {
                return 1;
            }
            if (bundle == null && deepLinkMatch.matchingArgs != null) {
                return -1;
            }
            if (bundle != null) {
                int size = bundle.size();
                Bundle bundle2 = deepLinkMatch.matchingArgs;
                Intrinsics.checkNotNull(bundle2);
                int size2 = size - bundle2.size();
                if (size2 > 0) {
                    return 1;
                }
                if (size2 < 0) {
                    return -1;
                }
            }
            boolean z2 = this.hasMatchingAction;
            if (z2 && !deepLinkMatch.hasMatchingAction) {
                return 1;
            }
            if (z2 || !deepLinkMatch.hasMatchingAction) {
                return this.mimeTypeMatchLevel - deepLinkMatch.mimeTypeMatchLevel;
            }
            return -1;
        }

        public final boolean hasMatchingArgs(Bundle bundle) {
            Bundle bundle2;
            Object obj;
            if (bundle == null || (bundle2 = this.matchingArgs) == null) {
                return false;
            }
            Set<String> keySet = bundle2.keySet();
            Intrinsics.checkNotNullExpressionValue(keySet, "matchingArgs.keySet()");
            for (String str : keySet) {
                if (!bundle.containsKey(str)) {
                    return false;
                }
                NavArgument navArgument = this.destination.getArguments().get(str);
                Object obj2 = null;
                NavType<Object> type = navArgument != null ? navArgument.getType() : null;
                if (type != null) {
                    Bundle bundle3 = this.matchingArgs;
                    Intrinsics.checkNotNullExpressionValue(str, "key");
                    obj = type.get(bundle3, str);
                } else {
                    obj = null;
                }
                if (type != null) {
                    Intrinsics.checkNotNullExpressionValue(str, "key");
                    obj2 = type.get(bundle, str);
                }
                if (!Intrinsics.areEqual(obj, obj2)) {
                    return false;
                }
            }
            return true;
        }
    }

    public final NavGraph getParent() {
        return this.parent;
    }

    public final void setParent(NavGraph navGraph) {
        this.parent = navGraph;
    }

    public final CharSequence getLabel() {
        return this.label;
    }

    public final void setLabel(CharSequence charSequence) {
        this.label = charSequence;
    }

    public final Map<String, NavArgument> getArguments() {
        return MapsKt.toMap(this._arguments);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public NavDestination(Navigator<? extends NavDestination> navigator) {
        this(NavigatorProvider.Companion.getNameForNavigator$navigation_common_release(navigator.getClass()));
        Intrinsics.checkNotNullParameter(navigator, "navigator");
    }

    public void onInflate(Context context, AttributeSet attributeSet) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attributeSet, "attrs");
        TypedArray obtainAttributes = context.getResources().obtainAttributes(attributeSet, R.styleable.Navigator);
        Intrinsics.checkNotNullExpressionValue(obtainAttributes, "context.resources.obtain…s, R.styleable.Navigator)");
        setRoute(obtainAttributes.getString(R.styleable.Navigator_route));
        if (obtainAttributes.hasValue(R.styleable.Navigator_android_id)) {
            setId(obtainAttributes.getResourceId(R.styleable.Navigator_android_id, 0));
            this.idName = Companion.getDisplayName(context, this.id);
        }
        this.label = obtainAttributes.getText(R.styleable.Navigator_android_label);
        Unit unit = Unit.INSTANCE;
        obtainAttributes.recycle();
    }

    public final int getId() {
        return this.id;
    }

    public final void setId(int i) {
        this.id = i;
        this.idName = null;
    }

    public final String getRoute() {
        return this.route;
    }

    public final void setRoute(String str) {
        Object obj;
        if (str == null) {
            setId(0);
        } else if (!StringsKt.isBlank(str)) {
            String createRoute = Companion.createRoute(str);
            setId(createRoute.hashCode());
            addDeepLink(createRoute);
        } else {
            throw new IllegalArgumentException("Cannot have an empty route".toString());
        }
        List<NavDeepLink> list = this.deepLinks;
        Collection collection = list;
        Iterator it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (Intrinsics.areEqual((Object) ((NavDeepLink) obj).getUriPattern(), (Object) Companion.createRoute(this.route))) {
                break;
            }
        }
        TypeIntrinsics.asMutableCollection(collection).remove(obj);
        this.route = str;
    }

    public String getDisplayName() {
        String str = this.idName;
        return str == null ? String.valueOf(this.id) : str;
    }

    public boolean hasDeepLink(Uri uri) {
        Intrinsics.checkNotNullParameter(uri, "deepLink");
        return hasDeepLink(new NavDeepLinkRequest(uri, (String) null, (String) null));
    }

    public boolean hasDeepLink(NavDeepLinkRequest navDeepLinkRequest) {
        Intrinsics.checkNotNullParameter(navDeepLinkRequest, "deepLinkRequest");
        return matchDeepLink(navDeepLinkRequest) != null;
    }

    public final void addDeepLink(String str) {
        Intrinsics.checkNotNullParameter(str, "uriPattern");
        addDeepLink(new NavDeepLink.Builder().setUriPattern(str).build());
    }

    public final void addDeepLink(NavDeepLink navDeepLink) {
        Intrinsics.checkNotNullParameter(navDeepLink, "navDeepLink");
        List<String> missingRequiredArguments = NavArgumentKt.missingRequiredArguments(getArguments(), new NavDestination$addDeepLink$missingRequiredArguments$1(navDeepLink));
        if (missingRequiredArguments.isEmpty()) {
            this.deepLinks.add(navDeepLink);
            return;
        }
        throw new IllegalArgumentException(("Deep link " + navDeepLink.getUriPattern() + " can't be used to open destination " + this + ".\nFollowing required arguments are missing: " + missingRequiredArguments).toString());
    }

    public final DeepLinkMatch matchDeepLink(String str) {
        Intrinsics.checkNotNullParameter(str, "route");
        NavDeepLinkRequest.Builder.Companion companion = NavDeepLinkRequest.Builder.Companion;
        Uri parse = Uri.parse(Companion.createRoute(str));
        Intrinsics.checkExpressionValueIsNotNull(parse, "Uri.parse(this)");
        NavDeepLinkRequest build = companion.fromUri(parse).build();
        if (this instanceof NavGraph) {
            return ((NavGraph) this).matchDeepLinkExcludingChildren(build);
        }
        return matchDeepLink(build);
    }

    public DeepLinkMatch matchDeepLink(NavDeepLinkRequest navDeepLinkRequest) {
        Intrinsics.checkNotNullParameter(navDeepLinkRequest, "navDeepLinkRequest");
        if (this.deepLinks.isEmpty()) {
            return null;
        }
        DeepLinkMatch deepLinkMatch = null;
        for (NavDeepLink next : this.deepLinks) {
            Uri uri = navDeepLinkRequest.getUri();
            Bundle matchingArguments = uri != null ? next.getMatchingArguments(uri, getArguments()) : null;
            int calculateMatchingPathSegments$navigation_common_release = next.calculateMatchingPathSegments$navigation_common_release(uri);
            String action = navDeepLinkRequest.getAction();
            boolean z = action != null && Intrinsics.areEqual((Object) action, (Object) next.getAction());
            String mimeType = navDeepLinkRequest.getMimeType();
            int mimeTypeMatchRating = mimeType != null ? next.getMimeTypeMatchRating(mimeType) : -1;
            if (matchingArguments != null || ((z || mimeTypeMatchRating > -1) && hasRequiredArguments(next, uri, getArguments()))) {
                DeepLinkMatch deepLinkMatch2 = new DeepLinkMatch(this, matchingArguments, next.isExactDeepLink(), calculateMatchingPathSegments$navigation_common_release, z, mimeTypeMatchRating);
                if (deepLinkMatch == null || deepLinkMatch2.compareTo(deepLinkMatch) > 0) {
                    deepLinkMatch = deepLinkMatch2;
                }
            }
        }
        return deepLinkMatch;
    }

    private final boolean hasRequiredArguments(NavDeepLink navDeepLink, Uri uri, Map<String, NavArgument> map) {
        return NavArgumentKt.missingRequiredArguments(map, new NavDestination$hasRequiredArguments$missingRequiredArguments$1(navDeepLink.getMatchingPathAndQueryArgs$navigation_common_release(uri, map))).isEmpty();
    }

    public static /* synthetic */ int[] buildDeepLinkIds$default(NavDestination navDestination, NavDestination navDestination2, int i, Object obj) {
        if (obj == null) {
            if ((i & 1) != 0) {
                navDestination2 = null;
            }
            return navDestination.buildDeepLinkIds(navDestination2);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: buildDeepLinkIds");
    }

    public final int[] buildDeepLinkIds(NavDestination navDestination) {
        ArrayDeque arrayDeque = new ArrayDeque();
        NavDestination navDestination2 = this;
        while (true) {
            Intrinsics.checkNotNull(navDestination2);
            NavGraph navGraph = navDestination2.parent;
            if ((navDestination != null ? navDestination.parent : null) != null) {
                NavGraph navGraph2 = navDestination.parent;
                Intrinsics.checkNotNull(navGraph2);
                if (navGraph2.findNode(navDestination2.id) == navDestination2) {
                    arrayDeque.addFirst(navDestination2);
                    break;
                }
            }
            if (navGraph == null || navGraph.getStartDestinationId() != navDestination2.id) {
                arrayDeque.addFirst(navDestination2);
            }
            if (Intrinsics.areEqual((Object) navGraph, (Object) navDestination)) {
                break;
            }
            navDestination2 = navGraph;
            if (navDestination2 == null) {
                break;
            }
        }
        Iterable<NavDestination> list = CollectionsKt.toList(arrayDeque);
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        for (NavDestination navDestination3 : list) {
            arrayList.add(Integer.valueOf(navDestination3.id));
        }
        return CollectionsKt.toIntArray((List) arrayList);
    }

    public final boolean hasRoute(String str, Bundle bundle) {
        Intrinsics.checkNotNullParameter(str, "route");
        if (Intrinsics.areEqual((Object) this.route, (Object) str)) {
            return true;
        }
        DeepLinkMatch matchDeepLink = matchDeepLink(str);
        if (!Intrinsics.areEqual((Object) this, (Object) matchDeepLink != null ? matchDeepLink.getDestination() : null)) {
            return false;
        }
        return matchDeepLink.hasMatchingArgs(bundle);
    }

    public final NavAction getAction(int i) {
        NavAction navAction = this.actions.isEmpty() ? null : this.actions.get(i);
        if (navAction != null) {
            return navAction;
        }
        NavGraph navGraph = this.parent;
        if (navGraph != null) {
            return navGraph.getAction(i);
        }
        return null;
    }

    public final void putAction(int i, int i2) {
        putAction(i, new NavAction(i2, (NavOptions) null, (Bundle) null, 6, (DefaultConstructorMarker) null));
    }

    public final void putAction(int i, NavAction navAction) {
        Intrinsics.checkNotNullParameter(navAction, "action");
        if (!supportsActions()) {
            throw new UnsupportedOperationException("Cannot add action " + i + " to " + this + " as it does not support actions, indicating that it is a terminal destination in your navigation graph and will never trigger actions.");
        } else if (i != 0) {
            this.actions.put(i, navAction);
        } else {
            throw new IllegalArgumentException("Cannot have an action with actionId 0".toString());
        }
    }

    public final void removeAction(int i) {
        this.actions.remove(i);
    }

    public final void addArgument(String str, NavArgument navArgument) {
        Intrinsics.checkNotNullParameter(str, "argumentName");
        Intrinsics.checkNotNullParameter(navArgument, "argument");
        this._arguments.put(str, navArgument);
    }

    public final void removeArgument(String str) {
        Intrinsics.checkNotNullParameter(str, "argumentName");
        this._arguments.remove(str);
    }

    public final Bundle addInDefaultArgs(Bundle bundle) {
        Map<String, NavArgument> map;
        if (bundle == null && ((map = this._arguments) == null || map.isEmpty())) {
            return null;
        }
        Bundle bundle2 = new Bundle();
        for (Map.Entry next : this._arguments.entrySet()) {
            ((NavArgument) next.getValue()).putDefaultValue((String) next.getKey(), bundle2);
        }
        if (bundle != null) {
            bundle2.putAll(bundle);
            for (Map.Entry next2 : this._arguments.entrySet()) {
                String str = (String) next2.getKey();
                NavArgument navArgument = (NavArgument) next2.getValue();
                if (!navArgument.verify(str, bundle2)) {
                    throw new IllegalArgumentException(("Wrong argument type for '" + str + "' in argument bundle. " + navArgument.getType().getName() + " expected.").toString());
                }
            }
        }
        return bundle2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0034, code lost:
        r5 = getArguments().get(r4);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String fillInLabel(android.content.Context r8, android.os.Bundle r9) {
        /*
            r7 = this;
            java.lang.String r0 = "context"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            java.lang.CharSequence r0 = r7.label
            r1 = 0
            if (r0 != 0) goto L_0x000b
            return r1
        L_0x000b:
            java.lang.String r2 = "\\{(.+?)\\}"
            java.util.regex.Pattern r2 = java.util.regex.Pattern.compile(r2)
            java.util.regex.Matcher r2 = r2.matcher(r0)
            java.lang.StringBuffer r3 = new java.lang.StringBuffer
            r3.<init>()
        L_0x001a:
            boolean r4 = r2.find()
            if (r4 == 0) goto L_0x0096
            r4 = 1
            java.lang.String r4 = r2.group(r4)
            if (r9 == 0) goto L_0x0067
            boolean r5 = r9.containsKey(r4)
            if (r5 == 0) goto L_0x0067
            java.lang.String r5 = ""
            r2.appendReplacement(r3, r5)
            if (r4 == 0) goto L_0x0045
            java.util.Map r5 = r7.getArguments()
            java.lang.Object r5 = r5.get(r4)
            androidx.navigation.NavArgument r5 = (androidx.navigation.NavArgument) r5
            if (r5 == 0) goto L_0x0045
            androidx.navigation.NavType r5 = r5.getType()
            goto L_0x0046
        L_0x0045:
            r5 = r1
        L_0x0046:
            androidx.navigation.NavType<java.lang.Integer> r6 = androidx.navigation.NavType.ReferenceType
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r5, (java.lang.Object) r6)
            if (r5 == 0) goto L_0x005f
            int r4 = r9.getInt(r4)
            java.lang.String r4 = r8.getString(r4)
            java.lang.String r5 = "context.getString(bundle.getInt(argName))"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r5)
            r3.append(r4)
            goto L_0x001a
        L_0x005f:
            java.lang.String r4 = r9.getString(r4)
            r3.append(r4)
            goto L_0x001a
        L_0x0067:
            java.lang.IllegalArgumentException r8 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "Could not find \""
            r1.<init>(r2)
            java.lang.StringBuilder r1 = r1.append(r4)
            java.lang.String r2 = "\" in "
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.StringBuilder r9 = r1.append(r9)
            java.lang.String r1 = " to fill label \""
            java.lang.StringBuilder r9 = r9.append(r1)
            java.lang.StringBuilder r9 = r9.append(r0)
            r0 = 34
            java.lang.StringBuilder r9 = r9.append(r0)
            java.lang.String r9 = r9.toString()
            r8.<init>(r9)
            throw r8
        L_0x0096:
            r2.appendTail(r3)
            java.lang.String r8 = r3.toString()
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.navigation.NavDestination.fillInLabel(android.content.Context, android.os.Bundle):java.lang.String");
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("(");
        String str = this.idName;
        if (str == null) {
            sb.append("0x");
            sb.append(Integer.toHexString(this.id));
        } else {
            sb.append(str);
        }
        sb.append(")");
        CharSequence charSequence = this.route;
        if (charSequence != null && !StringsKt.isBlank(charSequence)) {
            sb.append(" route=");
            sb.append(this.route);
        }
        if (this.label != null) {
            sb.append(" label=");
            sb.append(this.label);
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "sb.toString()");
        return sb2;
    }

    public boolean equals(Object obj) {
        boolean z;
        boolean z2;
        if (obj != null && (obj instanceof NavDestination)) {
            NavDestination navDestination = (NavDestination) obj;
            boolean z3 = CollectionsKt.intersect(this.deepLinks, navDestination.deepLinks).size() == this.deepLinks.size();
            if (this.actions.size() == navDestination.actions.size()) {
                Iterator<T> it = SequencesKt.asSequence(SparseArrayKt.valueIterator(this.actions)).iterator();
                while (true) {
                    if (!it.hasNext()) {
                        Iterator<T> it2 = SequencesKt.asSequence(SparseArrayKt.valueIterator(navDestination.actions)).iterator();
                        while (true) {
                            if (!it2.hasNext()) {
                                z = true;
                                break;
                            }
                            if (!this.actions.containsValue((NavAction) it2.next())) {
                                break;
                            }
                        }
                    } else {
                        if (!navDestination.actions.containsValue((NavAction) it.next())) {
                            break;
                        }
                    }
                }
            } else {
                z = false;
            }
            if (getArguments().size() == navDestination.getArguments().size()) {
                Iterator<Map.Entry<String, NavArgument>> it3 = MapsKt.asSequence(getArguments()).iterator();
                while (true) {
                    if (!it3.hasNext()) {
                        Iterator<Map.Entry<String, NavArgument>> it4 = MapsKt.asSequence(navDestination.getArguments()).iterator();
                        while (true) {
                            if (!it4.hasNext()) {
                                z2 = true;
                                break;
                            }
                            Map.Entry next = it4.next();
                            if (getArguments().containsKey(next.getKey())) {
                                if (!Intrinsics.areEqual((Object) getArguments().get(next.getKey()), next.getValue())) {
                                    break;
                                }
                            } else {
                                break;
                            }
                        }
                    } else {
                        Map.Entry next2 = it3.next();
                        if (navDestination.getArguments().containsKey(next2.getKey())) {
                            if (!Intrinsics.areEqual((Object) navDestination.getArguments().get(next2.getKey()), next2.getValue())) {
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                }
            }
            z2 = false;
            if (this.id != navDestination.id || !Intrinsics.areEqual((Object) this.route, (Object) navDestination.route) || !z3 || !z || !z2) {
                return false;
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i;
        Set<String> keySet;
        int i2 = this.id * 31;
        String str = this.route;
        int hashCode = i2 + (str != null ? str.hashCode() : 0);
        for (NavDeepLink navDeepLink : this.deepLinks) {
            int i3 = i * 31;
            String uriPattern = navDeepLink.getUriPattern();
            int hashCode2 = (i3 + (uriPattern != null ? uriPattern.hashCode() : 0)) * 31;
            String action = navDeepLink.getAction();
            int hashCode3 = (hashCode2 + (action != null ? action.hashCode() : 0)) * 31;
            String mimeType = navDeepLink.getMimeType();
            hashCode = hashCode3 + (mimeType != null ? mimeType.hashCode() : 0);
        }
        Iterator<T> valueIterator = SparseArrayKt.valueIterator(this.actions);
        while (valueIterator.hasNext()) {
            NavAction navAction = (NavAction) valueIterator.next();
            int destinationId = ((i * 31) + navAction.getDestinationId()) * 31;
            NavOptions navOptions = navAction.getNavOptions();
            i = destinationId + (navOptions != null ? navOptions.hashCode() : 0);
            Bundle defaultArguments = navAction.getDefaultArguments();
            if (!(defaultArguments == null || (keySet = defaultArguments.keySet()) == null)) {
                Intrinsics.checkNotNullExpressionValue(keySet, "keySet()");
                for (String str2 : keySet) {
                    int i4 = i * 31;
                    Bundle defaultArguments2 = navAction.getDefaultArguments();
                    Intrinsics.checkNotNull(defaultArguments2);
                    Object obj = defaultArguments2.get(str2);
                    i = i4 + (obj != null ? obj.hashCode() : 0);
                }
            }
        }
        for (String str3 : getArguments().keySet()) {
            int hashCode4 = ((i * 31) + str3.hashCode()) * 31;
            NavArgument navArgument = getArguments().get(str3);
            i = hashCode4 + (navArgument != null ? navArgument.hashCode() : 0);
        }
        return i;
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u000e\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u0005H\u0007J\u0018\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0007J:\u0010\u0015\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u0001H\u00160\u0006\"\u0004\b\u0000\u0010\u00162\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u00052\u0010\u0010\u0018\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u0001H\u00160\u0006H\u0005J:\u0010\u0019\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u0001H\u00160\u0006\"\u0004\b\u0000\u0010\u00162\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u00052\u0010\u0010\u0018\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u0001H\u00160\u0006H\u0007R\u001e\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u0004X\u0004¢\u0006\u0002\n\u0000R$\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b*\u00020\t8FX\u0004¢\u0006\f\u0012\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r¨\u0006\u001a"}, d2 = {"Landroidx/navigation/NavDestination$Companion;", "", "()V", "classes", "", "", "Ljava/lang/Class;", "hierarchy", "Lkotlin/sequences/Sequence;", "Landroidx/navigation/NavDestination;", "getHierarchy$annotations", "(Landroidx/navigation/NavDestination;)V", "getHierarchy", "(Landroidx/navigation/NavDestination;)Lkotlin/sequences/Sequence;", "createRoute", "route", "getDisplayName", "context", "Landroid/content/Context;", "id", "", "parseClassFromName", "C", "name", "expectedClassType", "parseClassFromNameInternal", "navigation-common_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: NavDestination.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public static /* synthetic */ void getHierarchy$annotations(NavDestination navDestination) {
        }

        private Companion() {
        }

        /* access modifiers changed from: protected */
        @JvmStatic
        public final <C> Class<? extends C> parseClassFromName(Context context, String str, Class<? extends C> cls) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(str, "name");
            Intrinsics.checkNotNullParameter(cls, "expectedClassType");
            String str2 = str.charAt(0) == '.' ? context.getPackageName() + str : str;
            Class<?> cls2 = (Class) NavDestination.classes.get(str2);
            if (cls2 == null) {
                try {
                    cls2 = Class.forName(str2, true, context.getClassLoader());
                    NavDestination.classes.put(str, cls2);
                } catch (ClassNotFoundException e) {
                    throw new IllegalArgumentException(e);
                }
            }
            Intrinsics.checkNotNull(cls2);
            if (cls.isAssignableFrom(cls2)) {
                return cls2;
            }
            throw new IllegalArgumentException((str2 + " must be a subclass of " + cls).toString());
        }

        @JvmStatic
        public final <C> Class<? extends C> parseClassFromNameInternal(Context context, String str, Class<? extends C> cls) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(str, "name");
            Intrinsics.checkNotNullParameter(cls, "expectedClassType");
            return NavDestination.parseClassFromName(context, str, cls);
        }

        @JvmStatic
        public final String getDisplayName(Context context, int i) {
            String str;
            Intrinsics.checkNotNullParameter(context, "context");
            if (i <= 16777215) {
                return String.valueOf(i);
            }
            try {
                str = context.getResources().getResourceName(i);
            } catch (Resources.NotFoundException unused) {
                str = String.valueOf(i);
            }
            Intrinsics.checkNotNullExpressionValue(str, "try {\n                co….toString()\n            }");
            return str;
        }

        public final String createRoute(String str) {
            return str != null ? "android-app://androidx.navigation/" + str : "";
        }

        public final Sequence<NavDestination> getHierarchy(NavDestination navDestination) {
            Intrinsics.checkNotNullParameter(navDestination, "<this>");
            return SequencesKt.generateSequence(navDestination, NavDestination$Companion$hierarchy$1.INSTANCE);
        }
    }
}
