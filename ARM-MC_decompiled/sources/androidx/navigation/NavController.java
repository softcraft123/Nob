package androidx.navigation;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import androidx.activity.OnBackPressedCallback;
import androidx.activity.OnBackPressedDispatcher;
import androidx.core.app.NotificationCompat;
import androidx.core.os.BundleKt;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.navigation.NavBackStackEntry;
import androidx.navigation.NavDeepLinkRequest;
import androidx.navigation.NavDestination;
import androidx.navigation.Navigator;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArrayDeque;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.sequences.SequencesKt;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

@Metadata(d1 = {"\u0000È\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0010%\n\u0002\u0010\b\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\r\b\u0016\u0018\u0000 Ê\u00012\u00020\u0001:\u0006Ê\u0001Ë\u0001Ì\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J2\u0010q\u001a\u00020\u00172\u0006\u0010r\u001a\u0002052\b\u0010s\u001a\u0004\u0018\u00010_2\u0006\u0010\u0016\u001a\u00020\b2\u000e\b\u0002\u0010t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0002J\u0010\u0010u\u001a\u00020\u00172\u0006\u0010v\u001a\u00020fH\u0016J\u0012\u0010w\u001a\u0002092\b\b\u0001\u0010x\u001a\u00020\u001eH\u0007J\u0010\u0010w\u001a\u0002092\u0006\u0010y\u001a\u00020\u001fH\u0007J\u0012\u0010z\u001a\u0002092\b\b\u0001\u0010x\u001a\u00020\u001eH\u0003J\u0010\u0010z\u001a\u0002092\u0006\u0010y\u001a\u00020\u001fH\u0003J\b\u0010{\u001a\u00020|H\u0016J\b\u0010}\u001a\u000209H\u0002J\u0010\u0010~\u001a\u00020\u00172\u0006\u0010\u001a\u000209H\u0017J7\u0010\u0001\u001a\u0002092\u0011\u0010\u0001\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\\0\u00072\u0007\u0010\u0001\u001a\u0002052\u0007\u0010\u0001\u001a\u0002092\u0007\u0010\u0001\u001a\u000209H\u0002J;\u0010\u0001\u001a\u0002092\r\u0010\u0001\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\t\u0010\u0001\u001a\u0004\u0018\u00010_2\n\u0010\u0001\u001a\u0005\u0018\u00010\u00012\n\u0010\u0001\u001a\u0005\u0018\u00010\u0001H\u0002J\u0015\u0010\u0001\u001a\u0004\u0018\u0001052\b\b\u0001\u0010x\u001a\u00020\u001eH\u0007J\u0013\u0010\u0001\u001a\u0004\u0018\u0001052\u0006\u0010y\u001a\u00020\u001fH\u0007J\u0015\u0010\u0001\u001a\u0004\u0018\u00010\u001f2\b\u0010\u0001\u001a\u00030\u0001H\u0002J\u0013\u0010\u0001\u001a\u00020\b2\b\b\u0001\u0010x\u001a\u00020\u001eH\u0016J\u000f\u0010\u0001\u001a\u00020\b2\u0006\u0010y\u001a\u00020\u001fJ\u0015\u0010\u0001\u001a\u00030\u00012\t\b\u0001\u0010\u0001\u001a\u00020\u001eH\u0016J\u0015\u0010\u0001\u001a\u0002092\n\u0010\u0001\u001a\u0005\u0018\u00010\u0001H\u0017J \u0010\u0001\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u000f\u0010\u0001\u001a\n\u0012\u0004\u0012\u00020!\u0018\u00010\u0019H\u0002J\u001c\u0010\u0001\u001a\u0002092\u0006\u0010r\u001a\u0002052\t\u0010\u0001\u001a\u0004\u0018\u00010_H\u0002J\u001b\u0010\u0001\u001a\u00020\u00172\u0007\u0010\u0001\u001a\u00020\b2\u0007\u0010\u0001\u001a\u00020\bH\u0002J\u0013\u0010\u0001\u001a\u00020\u00172\b\u0010\u0001\u001a\u00030\u0001H\u0017J\u001f\u0010\u0001\u001a\u00020\u00172\b\u0010\u0001\u001a\u00030\u00012\n\u0010\u0001\u001a\u0005\u0018\u00010\u0001H\u0017J+\u0010\u0001\u001a\u00020\u00172\b\u0010\u0001\u001a\u00030\u00012\n\u0010\u0001\u001a\u0005\u0018\u00010\u00012\n\u0010\u0001\u001a\u0005\u0018\u00010\u0001H\u0017J\u0013\u0010\u0001\u001a\u00020\u00172\b\u0010\u0001\u001a\u00030 \u0001H\u0017J\u001f\u0010\u0001\u001a\u00020\u00172\b\u0010\u0001\u001a\u00030 \u00012\n\u0010\u0001\u001a\u0005\u0018\u00010\u0001H\u0017J+\u0010\u0001\u001a\u00020\u00172\b\u0010\u0001\u001a\u00030 \u00012\n\u0010\u0001\u001a\u0005\u0018\u00010\u00012\n\u0010\u0001\u001a\u0005\u0018\u00010\u0001H\u0017J4\u0010\u0001\u001a\u00020\u00172\u0006\u0010r\u001a\u0002052\t\u0010\u0001\u001a\u0004\u0018\u00010_2\n\u0010\u0001\u001a\u0005\u0018\u00010\u00012\n\u0010\u0001\u001a\u0005\u0018\u00010\u0001H\u0003J\u0013\u0010\u0001\u001a\u00020\u00172\b\u0010¡\u0001\u001a\u00030¢\u0001H\u0017J\u001f\u0010\u0001\u001a\u00020\u00172\b\u0010¡\u0001\u001a\u00030¢\u00012\n\u0010\u0001\u001a\u0005\u0018\u00010\u0001H\u0017J\u001d\u0010\u0001\u001a\u00020\u00172\b\u0010¡\u0001\u001a\u00030¢\u00012\b\u0010\u0001\u001a\u00030\u0001H\u0017J\u0014\u0010\u0001\u001a\u00020\u00172\t\b\u0001\u0010£\u0001\u001a\u00020\u001eH\u0017J\u001f\u0010\u0001\u001a\u00020\u00172\t\b\u0001\u0010£\u0001\u001a\u00020\u001e2\t\u0010\u0001\u001a\u0004\u0018\u00010_H\u0017J+\u0010\u0001\u001a\u00020\u00172\t\b\u0001\u0010£\u0001\u001a\u00020\u001e2\t\u0010\u0001\u001a\u0004\u0018\u00010_2\n\u0010\u0001\u001a\u0005\u0018\u00010\u0001H\u0017J7\u0010\u0001\u001a\u00020\u00172\t\b\u0001\u0010£\u0001\u001a\u00020\u001e2\t\u0010\u0001\u001a\u0004\u0018\u00010_2\n\u0010\u0001\u001a\u0005\u0018\u00010\u00012\n\u0010\u0001\u001a\u0005\u0018\u00010\u0001H\u0017J-\u0010\u0001\u001a\u00020\u00172\u0006\u0010y\u001a\u00020\u001f2\f\b\u0002\u0010\u0001\u001a\u0005\u0018\u00010\u00012\f\b\u0002\u0010\u0001\u001a\u0005\u0018\u00010\u0001H\u0007J-\u0010\u0001\u001a\u00020\u00172\u0006\u0010y\u001a\u00020\u001f2\u001a\u0010¤\u0001\u001a\u0015\u0012\u0005\u0012\u00030¥\u0001\u0012\u0004\u0012\u00020\u00170\u0013¢\u0006\u0003\b¦\u0001H\u0007J\t\u0010§\u0001\u001a\u000209H\u0017J\u0014\u0010¨\u0001\u001a\u00020\u00172\t\u0010©\u0001\u001a\u0004\u0018\u00010_H\u0003J\t\u0010ª\u0001\u001a\u000209H\u0017J\u001c\u0010ª\u0001\u001a\u0002092\b\b\u0001\u0010x\u001a\u00020\u001e2\u0007\u0010\u0001\u001a\u000209H\u0017J%\u0010ª\u0001\u001a\u0002092\b\b\u0001\u0010x\u001a\u00020\u001e2\u0007\u0010\u0001\u001a\u0002092\u0007\u0010\u0001\u001a\u000209H\u0017J%\u0010ª\u0001\u001a\u0002092\u0006\u0010y\u001a\u00020\u001f2\u0007\u0010\u0001\u001a\u0002092\t\b\u0002\u0010\u0001\u001a\u000209H\u0007J'\u0010«\u0001\u001a\u00020\u00172\u0006\u0010j\u001a\u00020\b2\u000e\u0010¬\u0001\u001a\t\u0012\u0004\u0012\u00020\u00170­\u0001H\u0000¢\u0006\u0003\b®\u0001J'\u0010¯\u0001\u001a\u0002092\b\b\u0001\u0010x\u001a\u00020\u001e2\u0007\u0010\u0001\u001a\u0002092\t\b\u0002\u0010\u0001\u001a\u000209H\u0003J#\u0010¯\u0001\u001a\u0002092\u0006\u0010y\u001a\u00020\u001f2\u0007\u0010\u0001\u001a\u0002092\u0007\u0010\u0001\u001a\u000209H\u0002J-\u0010°\u0001\u001a\u00020\u00172\u0006\u0010j\u001a\u00020\b2\t\b\u0002\u0010\u0001\u001a\u0002092\u000f\b\u0002\u0010±\u0001\u001a\b\u0012\u0004\u0012\u00020!0\u0019H\u0002J\u0015\u0010²\u0001\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0000¢\u0006\u0003\b³\u0001J\u0011\u0010´\u0001\u001a\u00020\u00172\u0006\u0010v\u001a\u00020fH\u0016J\u0014\u0010µ\u0001\u001a\u00020\u00172\t\u0010¶\u0001\u001a\u0004\u0018\u00010_H\u0017J5\u0010·\u0001\u001a\u0002092\u0007\u0010¸\u0001\u001a\u00020\u001e2\t\u0010\u0001\u001a\u0004\u0018\u00010_2\n\u0010\u0001\u001a\u0005\u0018\u00010\u00012\n\u0010\u0001\u001a\u0005\u0018\u00010\u0001H\u0002J\u0011\u0010·\u0001\u001a\u0002092\u0006\u0010y\u001a\u00020\u001fH\u0002J\u000b\u0010\u0001\u001a\u0004\u0018\u00010_H\u0017J\u001b\u0010C\u001a\u00020\u00172\u0006\u0010@\u001a\u00020\f2\t\u0010©\u0001\u001a\u0004\u0018\u00010_H\u0017J\u0013\u0010C\u001a\u00020\u00172\t\b\u0001\u0010¹\u0001\u001a\u00020\u001eH\u0017J\u001e\u0010C\u001a\u00020\u00172\t\b\u0001\u0010¹\u0001\u001a\u00020\u001e2\t\u0010©\u0001\u001a\u0004\u0018\u00010_H\u0017J\u0012\u0010º\u0001\u001a\u00020\u00172\u0007\u0010»\u0001\u001a\u00020PH\u0017J\u0012\u0010¼\u0001\u001a\u00020\u00172\u0007\u0010½\u0001\u001a\u00020cH\u0017J\u0013\u0010¾\u0001\u001a\u00020\u00172\b\u0010¿\u0001\u001a\u00030À\u0001H\u0017J\t\u0010Á\u0001\u001a\u000209H\u0002J\t\u0010Â\u0001\u001a\u000209H\u0002J\u001a\u0010Ã\u0001\u001a\u0004\u0018\u00010\b2\u0007\u0010\u0001\u001a\u00020\bH\u0000¢\u0006\u0003\bÄ\u0001J\u000f\u0010Å\u0001\u001a\u00020\u0017H\u0000¢\u0006\u0003\bÆ\u0001J\t\u0010Ç\u0001\u001a\u00020\u0017H\u0002J\u0019\u0010\u0001\u001a\u0004\u0018\u000105*\u0002052\b\b\u0001\u0010x\u001a\u00020\u001eH\u0002Jb\u0010È\u0001\u001a\u00020\u0017*\n\u0012\u0006\b\u0001\u0012\u0002050\\2\r\u0010\u0001\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\n\u0010\u0001\u001a\u0005\u0018\u00010\u00012\n\u0010\u0001\u001a\u0005\u0018\u00010\u00012$\b\u0002\u0010É\u0001\u001a\u001d\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u00170\u0013H\u0002JL\u0010¯\u0001\u001a\u00020\u0017*\n\u0012\u0006\b\u0001\u0012\u0002050\\2\u0006\u0010j\u001a\u00020\b2\u0007\u0010\u0001\u001a\u0002092$\b\u0002\u0010É\u0001\u001a\u001d\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(j\u0012\u0004\u0012\u00020\u00170\u0013H\u0002R\u001a\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\nX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u0002\n\u0000R+\u0010\u0012\u001a\u001f\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0013X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\b0\u0019X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\b0\u001bX\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u001c\u001a\u0010\u0012\u0004\u0012\u00020\u001e\u0012\u0006\u0012\u0004\u0018\u00010\u001f0\u001dX\u0004¢\u0006\u0002\n\u0000R \u0010 \u001a\u0014\u0012\u0004\u0012\u00020\u001f\u0012\n\u0012\b\u0012\u0004\u0012\u00020!0\u00190\u001dX\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\"\u001a\n\u0012\u0004\u0012\u00020$\u0018\u00010#X\u000e¢\u0006\u0004\n\u0002\u0010%R\u001a\u0010&\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u001dX\u0004¢\u0006\u0002\n\u0000R\u0013\u0010\u0002\u001a\u00020\u00038\u0007¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\"\u0010)\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070*8GX\u0004¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,R\u0016\u0010-\u001a\u0004\u0018\u00010\b8VX\u0004¢\u0006\u0006\u001a\u0004\b.\u0010/R\u0017\u00100\u001a\b\u0012\u0004\u0012\u00020\b01¢\u0006\b\n\u0000\u001a\u0004\b2\u00103R\u0016\u00104\u001a\u0004\u0018\u0001058VX\u0004¢\u0006\u0006\u001a\u0004\b6\u00107R\u000e\u00108\u001a\u000209X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010:\u001a\u00020\u001e8BX\u0004¢\u0006\u0006\u001a\u0004\b;\u0010<R\u000e\u0010=\u001a\u00020\u001eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010>\u001a\u000209X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010?\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u0002090\u001dX\u0004¢\u0006\u0002\n\u0000R$\u0010@\u001a\u00020\f2\u0006\u0010@\u001a\u00020\f8W@WX\u000e¢\u0006\f\u001a\u0004\bA\u0010B\"\u0004\bC\u0010DR\u001c\u0010E\u001a\u00020F8@X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bG\u0010H\"\u0004\bI\u0010JR\u0010\u0010K\u001a\u0004\u0018\u00010LX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010M\u001a\u00020NX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010O\u001a\u0004\u0018\u00010PX\u000e¢\u0006\u0002\n\u0000R\u001b\u0010Q\u001a\u00020L8VX\u0002¢\u0006\f\n\u0004\bT\u0010U\u001a\u0004\bR\u0010SR$\u0010V\u001a\u00020\u000e2\u0006\u0010V\u001a\u00020\u000e8V@WX\u000e¢\u0006\f\u001a\u0004\bW\u0010X\"\u0004\bY\u0010ZR&\u0010[\u001a\u001a\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u0002050\\\u0012\b\u0012\u00060]R\u00020\u00000\u001dX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010^\u001a\u0004\u0018\u00010_X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010`\u001a\u00020aX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010b\u001a\u0004\u0018\u00010cX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010d\u001a\b\u0012\u0004\u0012\u00020f0eX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010g\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020h0\u001dX\u0004¢\u0006\u0002\n\u0000R+\u0010i\u001a\u001f\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(j\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0013X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010k\u001a\u0004\u0018\u00010\b8VX\u0004¢\u0006\u0006\u001a\u0004\bl\u0010/R\u0010\u0010m\u001a\u0004\u0018\u00010nX\u000e¢\u0006\u0002\n\u0000R\u001d\u0010o\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070*¢\u0006\b\n\u0000\u001a\u0004\bp\u0010,¨\u0006Í\u0001"}, d2 = {"Landroidx/navigation/NavController;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "_currentBackStack", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "Landroidx/navigation/NavBackStackEntry;", "_currentBackStackEntryFlow", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "_graph", "Landroidx/navigation/NavGraph;", "_navigatorProvider", "Landroidx/navigation/NavigatorProvider;", "_visibleEntries", "activity", "Landroid/app/Activity;", "addToBackStackHandler", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "backStackEntry", "", "backQueue", "Lkotlin/collections/ArrayDeque;", "backStackEntriesToDispatch", "", "backStackMap", "", "", "", "backStackStates", "Landroidx/navigation/NavBackStackEntryState;", "backStackToRestore", "", "Landroid/os/Parcelable;", "[Landroid/os/Parcelable;", "childToParentEntries", "getContext", "()Landroid/content/Context;", "currentBackStack", "Lkotlinx/coroutines/flow/StateFlow;", "getCurrentBackStack", "()Lkotlinx/coroutines/flow/StateFlow;", "currentBackStackEntry", "getCurrentBackStackEntry", "()Landroidx/navigation/NavBackStackEntry;", "currentBackStackEntryFlow", "Lkotlinx/coroutines/flow/Flow;", "getCurrentBackStackEntryFlow", "()Lkotlinx/coroutines/flow/Flow;", "currentDestination", "Landroidx/navigation/NavDestination;", "getCurrentDestination", "()Landroidx/navigation/NavDestination;", "deepLinkHandled", "", "destinationCountOnBackStack", "getDestinationCountOnBackStack", "()I", "dispatchReentrantCount", "enableOnBackPressedCallback", "entrySavedState", "graph", "getGraph", "()Landroidx/navigation/NavGraph;", "setGraph", "(Landroidx/navigation/NavGraph;)V", "hostLifecycleState", "Landroidx/lifecycle/Lifecycle$State;", "getHostLifecycleState$navigation_runtime_release", "()Landroidx/lifecycle/Lifecycle$State;", "setHostLifecycleState$navigation_runtime_release", "(Landroidx/lifecycle/Lifecycle$State;)V", "inflater", "Landroidx/navigation/NavInflater;", "lifecycleObserver", "Landroidx/lifecycle/LifecycleObserver;", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "navInflater", "getNavInflater", "()Landroidx/navigation/NavInflater;", "navInflater$delegate", "Lkotlin/Lazy;", "navigatorProvider", "getNavigatorProvider", "()Landroidx/navigation/NavigatorProvider;", "setNavigatorProvider", "(Landroidx/navigation/NavigatorProvider;)V", "navigatorState", "Landroidx/navigation/Navigator;", "Landroidx/navigation/NavController$NavControllerNavigatorState;", "navigatorStateToRestore", "Landroid/os/Bundle;", "onBackPressedCallback", "Landroidx/activity/OnBackPressedCallback;", "onBackPressedDispatcher", "Landroidx/activity/OnBackPressedDispatcher;", "onDestinationChangedListeners", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Landroidx/navigation/NavController$OnDestinationChangedListener;", "parentToChildCount", "Ljava/util/concurrent/atomic/AtomicInteger;", "popFromBackStackHandler", "popUpTo", "previousBackStackEntry", "getPreviousBackStackEntry", "viewModel", "Landroidx/navigation/NavControllerViewModel;", "visibleEntries", "getVisibleEntries", "addEntryToBackStack", "node", "finalArgs", "restoredEntries", "addOnDestinationChangedListener", "listener", "clearBackStack", "destinationId", "route", "clearBackStackInternal", "createDeepLink", "Landroidx/navigation/NavDeepLinkBuilder;", "dispatchOnDestinationChanged", "enableOnBackPressed", "enabled", "executePopOperations", "popOperations", "foundDestination", "inclusive", "saveState", "executeRestoreState", "entries", "args", "navOptions", "Landroidx/navigation/NavOptions;", "navigatorExtras", "Landroidx/navigation/Navigator$Extras;", "findDestination", "findInvalidDestinationDisplayNameInDeepLink", "deepLink", "", "getBackStackEntry", "getViewModelStoreOwner", "Landroidx/lifecycle/ViewModelStoreOwner;", "navGraphId", "handleDeepLink", "intent", "Landroid/content/Intent;", "instantiateBackStack", "backStackState", "launchSingleTopInternal", "linkChildToParent", "child", "parent", "navigate", "Landroid/net/Uri;", "request", "Landroidx/navigation/NavDeepLinkRequest;", "directions", "Landroidx/navigation/NavDirections;", "resId", "builder", "Landroidx/navigation/NavOptionsBuilder;", "Lkotlin/ExtensionFunctionType;", "navigateUp", "onGraphCreated", "startDestinationArgs", "popBackStack", "popBackStackFromNavigator", "onComplete", "Lkotlin/Function0;", "popBackStackFromNavigator$navigation_runtime_release", "popBackStackInternal", "popEntryFromBackStack", "savedState", "populateVisibleEntries", "populateVisibleEntries$navigation_runtime_release", "removeOnDestinationChangedListener", "restoreState", "navState", "restoreStateInternal", "id", "graphResId", "setLifecycleOwner", "owner", "setOnBackPressedDispatcher", "dispatcher", "setViewModelStore", "viewModelStore", "Landroidx/lifecycle/ViewModelStore;", "tryRelaunchUpToExplicitStack", "tryRelaunchUpToGeneratedStack", "unlinkChildFromParent", "unlinkChildFromParent$navigation_runtime_release", "updateBackStackLifecycle", "updateBackStackLifecycle$navigation_runtime_release", "updateOnBackPressedCallbackEnabled", "navigateInternal", "handler", "Companion", "NavControllerNavigatorState", "OnDestinationChangedListener", "navigation-runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: NavController.kt */
public class NavController {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String KEY_BACK_STACK = "android-support-nav:controller:backStack";
    private static final String KEY_BACK_STACK_DEST_IDS = "android-support-nav:controller:backStackDestIds";
    private static final String KEY_BACK_STACK_IDS = "android-support-nav:controller:backStackIds";
    private static final String KEY_BACK_STACK_STATES_IDS = "android-support-nav:controller:backStackStates";
    private static final String KEY_BACK_STACK_STATES_PREFIX = "android-support-nav:controller:backStackStates:";
    public static final String KEY_DEEP_LINK_ARGS = "android-support-nav:controller:deepLinkArgs";
    public static final String KEY_DEEP_LINK_EXTRAS = "android-support-nav:controller:deepLinkExtras";
    public static final String KEY_DEEP_LINK_HANDLED = "android-support-nav:controller:deepLinkHandled";
    public static final String KEY_DEEP_LINK_IDS = "android-support-nav:controller:deepLinkIds";
    public static final String KEY_DEEP_LINK_INTENT = "android-support-nav:controller:deepLinkIntent";
    private static final String KEY_NAVIGATOR_STATE = "android-support-nav:controller:navigatorState";
    private static final String KEY_NAVIGATOR_STATE_NAMES = "android-support-nav:controller:navigatorState:names";
    private static final String TAG = "NavController";
    /* access modifiers changed from: private */
    public static boolean deepLinkSaveState = true;
    /* access modifiers changed from: private */
    public final MutableStateFlow<List<NavBackStackEntry>> _currentBackStack;
    private final MutableSharedFlow<NavBackStackEntry> _currentBackStackEntryFlow;
    private NavGraph _graph;
    /* access modifiers changed from: private */
    public NavigatorProvider _navigatorProvider;
    /* access modifiers changed from: private */
    public final MutableStateFlow<List<NavBackStackEntry>> _visibleEntries;
    private Activity activity;
    /* access modifiers changed from: private */
    public Function1<? super NavBackStackEntry, Unit> addToBackStackHandler;
    /* access modifiers changed from: private */
    public final ArrayDeque<NavBackStackEntry> backQueue;
    private final List<NavBackStackEntry> backStackEntriesToDispatch;
    /* access modifiers changed from: private */
    public final Map<Integer, String> backStackMap;
    private final Map<String, ArrayDeque<NavBackStackEntryState>> backStackStates;
    private Parcelable[] backStackToRestore;
    private final Map<NavBackStackEntry, NavBackStackEntry> childToParentEntries;
    private final Context context;
    private final StateFlow<List<NavBackStackEntry>> currentBackStack;
    private final Flow<NavBackStackEntry> currentBackStackEntryFlow;
    private boolean deepLinkHandled;
    private int dispatchReentrantCount;
    private boolean enableOnBackPressedCallback;
    /* access modifiers changed from: private */
    public final Map<NavBackStackEntry, Boolean> entrySavedState;
    private Lifecycle.State hostLifecycleState;
    /* access modifiers changed from: private */
    public NavInflater inflater;
    private final LifecycleObserver lifecycleObserver;
    private LifecycleOwner lifecycleOwner;
    private final Lazy navInflater$delegate;
    /* access modifiers changed from: private */
    public final Map<Navigator<? extends NavDestination>, NavControllerNavigatorState> navigatorState;
    private Bundle navigatorStateToRestore;
    private final OnBackPressedCallback onBackPressedCallback;
    private OnBackPressedDispatcher onBackPressedDispatcher;
    private final CopyOnWriteArrayList<OnDestinationChangedListener> onDestinationChangedListeners;
    private final Map<NavBackStackEntry, AtomicInteger> parentToChildCount;
    /* access modifiers changed from: private */
    public Function1<? super NavBackStackEntry, Unit> popFromBackStackHandler;
    /* access modifiers changed from: private */
    public NavControllerViewModel viewModel;
    private final StateFlow<List<NavBackStackEntry>> visibleEntries;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bæ\u0001\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH&ø\u0001\u0000\u0002\u0006\n\u0004\b!0\u0001¨\u0006\nÀ\u0006\u0001"}, d2 = {"Landroidx/navigation/NavController$OnDestinationChangedListener;", "", "onDestinationChanged", "", "controller", "Landroidx/navigation/NavController;", "destination", "Landroidx/navigation/NavDestination;", "arguments", "Landroid/os/Bundle;", "navigation-runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: NavController.kt */
    public interface OnDestinationChangedListener {
        void onDestinationChanged(NavController navController, NavDestination navDestination, Bundle bundle);
    }

    @JvmStatic
    @NavDeepLinkSaveStateControl
    public static final void enableDeepLinkSaveState(boolean z) {
        Companion.enableDeepLinkSaveState(z);
    }

    public final void navigate(String str) {
        Intrinsics.checkNotNullParameter(str, "route");
        navigate$default(this, str, (NavOptions) null, (Navigator.Extras) null, 6, (Object) null);
    }

    public final void navigate(String str, NavOptions navOptions) {
        Intrinsics.checkNotNullParameter(str, "route");
        navigate$default(this, str, navOptions, (Navigator.Extras) null, 4, (Object) null);
    }

    public final boolean popBackStack(String str, boolean z) {
        Intrinsics.checkNotNullParameter(str, "route");
        return popBackStack$default(this, str, z, false, 4, (Object) null);
    }

    public NavController(Context context2) {
        Object obj;
        Intrinsics.checkNotNullParameter(context2, "context");
        this.context = context2;
        Iterator it = SequencesKt.generateSequence(context2, NavController$activity$1.INSTANCE).iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (((Context) obj) instanceof Activity) {
                break;
            }
        }
        this.activity = (Activity) obj;
        this.backQueue = new ArrayDeque<>();
        MutableStateFlow<List<NavBackStackEntry>> MutableStateFlow = StateFlowKt.MutableStateFlow(CollectionsKt.emptyList());
        this._currentBackStack = MutableStateFlow;
        this.currentBackStack = FlowKt.asStateFlow(MutableStateFlow);
        MutableStateFlow<List<NavBackStackEntry>> MutableStateFlow2 = StateFlowKt.MutableStateFlow(CollectionsKt.emptyList());
        this._visibleEntries = MutableStateFlow2;
        this.visibleEntries = FlowKt.asStateFlow(MutableStateFlow2);
        this.childToParentEntries = new LinkedHashMap();
        this.parentToChildCount = new LinkedHashMap();
        this.backStackMap = new LinkedHashMap();
        this.backStackStates = new LinkedHashMap();
        this.onDestinationChangedListeners = new CopyOnWriteArrayList<>();
        this.hostLifecycleState = Lifecycle.State.INITIALIZED;
        this.lifecycleObserver = new NavController$$ExternalSyntheticLambda0(this);
        this.onBackPressedCallback = new NavController$onBackPressedCallback$1(this);
        this.enableOnBackPressedCallback = true;
        this._navigatorProvider = new NavigatorProvider();
        this.navigatorState = new LinkedHashMap();
        this.entrySavedState = new LinkedHashMap();
        this._navigatorProvider.addNavigator(new NavGraphNavigator(this._navigatorProvider));
        this._navigatorProvider.addNavigator(new ActivityNavigator(this.context));
        this.backStackEntriesToDispatch = new ArrayList();
        this.navInflater$delegate = LazyKt.lazy(new NavController$navInflater$2(this));
        MutableSharedFlow<NavBackStackEntry> MutableSharedFlow$default = SharedFlowKt.MutableSharedFlow$default(1, 0, BufferOverflow.DROP_OLDEST, 2, (Object) null);
        this._currentBackStackEntryFlow = MutableSharedFlow$default;
        this.currentBackStackEntryFlow = FlowKt.asSharedFlow(MutableSharedFlow$default);
    }

    public final Context getContext() {
        return this.context;
    }

    public NavGraph getGraph() {
        NavGraph navGraph = this._graph;
        if (navGraph != null) {
            Intrinsics.checkNotNull(navGraph, "null cannot be cast to non-null type androidx.navigation.NavGraph");
            return navGraph;
        }
        throw new IllegalStateException("You must call setGraph() before calling getGraph()".toString());
    }

    public void setGraph(NavGraph navGraph) {
        Intrinsics.checkNotNullParameter(navGraph, "graph");
        setGraph(navGraph, (Bundle) null);
    }

    public final StateFlow<List<NavBackStackEntry>> getCurrentBackStack() {
        return this.currentBackStack;
    }

    public final StateFlow<List<NavBackStackEntry>> getVisibleEntries() {
        return this.visibleEntries;
    }

    private final void linkChildToParent(NavBackStackEntry navBackStackEntry, NavBackStackEntry navBackStackEntry2) {
        this.childToParentEntries.put(navBackStackEntry, navBackStackEntry2);
        if (this.parentToChildCount.get(navBackStackEntry2) == null) {
            this.parentToChildCount.put(navBackStackEntry2, new AtomicInteger(0));
        }
        AtomicInteger atomicInteger = this.parentToChildCount.get(navBackStackEntry2);
        Intrinsics.checkNotNull(atomicInteger);
        atomicInteger.incrementAndGet();
    }

    public final NavBackStackEntry unlinkChildFromParent$navigation_runtime_release(NavBackStackEntry navBackStackEntry) {
        Intrinsics.checkNotNullParameter(navBackStackEntry, "child");
        NavBackStackEntry remove = this.childToParentEntries.remove(navBackStackEntry);
        Integer num = null;
        if (remove == null) {
            return null;
        }
        AtomicInteger atomicInteger = this.parentToChildCount.get(remove);
        if (atomicInteger != null) {
            num = Integer.valueOf(atomicInteger.decrementAndGet());
        }
        if (num != null && num.intValue() == 0) {
            NavControllerNavigatorState navControllerNavigatorState = this.navigatorState.get(this._navigatorProvider.getNavigator(remove.getDestination().getNavigatorName()));
            if (navControllerNavigatorState != null) {
                navControllerNavigatorState.markTransitionComplete(remove);
            }
            this.parentToChildCount.remove(remove);
        }
        return remove;
    }

    public final void setHostLifecycleState$navigation_runtime_release(Lifecycle.State state) {
        Intrinsics.checkNotNullParameter(state, "<set-?>");
        this.hostLifecycleState = state;
    }

    public final Lifecycle.State getHostLifecycleState$navigation_runtime_release() {
        if (this.lifecycleOwner == null) {
            return Lifecycle.State.CREATED;
        }
        return this.hostLifecycleState;
    }

    /* access modifiers changed from: private */
    public static final void lifecycleObserver$lambda$2(NavController navController, LifecycleOwner lifecycleOwner2, Lifecycle.Event event) {
        Intrinsics.checkNotNullParameter(navController, "this$0");
        Intrinsics.checkNotNullParameter(lifecycleOwner2, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(event, NotificationCompat.CATEGORY_EVENT);
        navController.hostLifecycleState = event.getTargetState();
        if (navController._graph != null) {
            Iterator it = navController.backQueue.iterator();
            while (it.hasNext()) {
                ((NavBackStackEntry) it.next()).handleLifecycleEvent(event);
            }
        }
    }

    public NavigatorProvider getNavigatorProvider() {
        return this._navigatorProvider;
    }

    public void setNavigatorProvider(NavigatorProvider navigatorProvider) {
        Intrinsics.checkNotNullParameter(navigatorProvider, "navigatorProvider");
        if (this.backQueue.isEmpty()) {
            this._navigatorProvider = navigatorProvider;
            return;
        }
        throw new IllegalStateException("NavigatorProvider must be set before setGraph call".toString());
    }

    static /* synthetic */ void navigateInternal$default(NavController navController, Navigator navigator, List list, NavOptions navOptions, Navigator.Extras extras, Function1 function1, int i, Object obj) {
        if (obj == null) {
            if ((i & 8) != 0) {
                function1 = NavController$navigateInternal$1.INSTANCE;
            }
            navController.navigateInternal(navigator, list, navOptions, extras, function1);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: navigateInternal");
    }

    private final void navigateInternal(Navigator<? extends NavDestination> navigator, List<NavBackStackEntry> list, NavOptions navOptions, Navigator.Extras extras, Function1<? super NavBackStackEntry, Unit> function1) {
        this.addToBackStackHandler = function1;
        navigator.navigate(list, navOptions, extras);
        this.addToBackStackHandler = null;
    }

    static /* synthetic */ void popBackStackInternal$default(NavController navController, Navigator navigator, NavBackStackEntry navBackStackEntry, boolean z, Function1 function1, int i, Object obj) {
        if (obj == null) {
            if ((i & 4) != 0) {
                function1 = NavController$popBackStackInternal$1.INSTANCE;
            }
            navController.popBackStackInternal(navigator, navBackStackEntry, z, function1);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: popBackStackInternal");
    }

    private final void popBackStackInternal(Navigator<? extends NavDestination> navigator, NavBackStackEntry navBackStackEntry, boolean z, Function1<? super NavBackStackEntry, Unit> function1) {
        this.popFromBackStackHandler = function1;
        navigator.popBackStack(navBackStackEntry, z);
        this.popFromBackStackHandler = null;
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0004\u0018\u00002\u00020\u0001B\u0015\u0012\u000e\u0010\u0002\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bJ\u001a\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u000bH\u0016J\u0018\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0018\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0010\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u000bH\u0016J\u0010\u0010\u0018\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016R\u0019\u0010\u0002\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0019"}, d2 = {"Landroidx/navigation/NavController$NavControllerNavigatorState;", "Landroidx/navigation/NavigatorState;", "navigator", "Landroidx/navigation/Navigator;", "Landroidx/navigation/NavDestination;", "(Landroidx/navigation/NavController;Landroidx/navigation/Navigator;)V", "getNavigator", "()Landroidx/navigation/Navigator;", "addInternal", "", "backStackEntry", "Landroidx/navigation/NavBackStackEntry;", "createBackStackEntry", "destination", "arguments", "Landroid/os/Bundle;", "markTransitionComplete", "entry", "pop", "popUpTo", "saveState", "", "popWithTransition", "prepareForTransition", "push", "navigation-runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: NavController.kt */
    private final class NavControllerNavigatorState extends NavigatorState {
        private final Navigator<? extends NavDestination> navigator;
        final /* synthetic */ NavController this$0;

        public NavControllerNavigatorState(NavController navController, Navigator<? extends NavDestination> navigator2) {
            Intrinsics.checkNotNullParameter(navigator2, "navigator");
            this.this$0 = navController;
            this.navigator = navigator2;
        }

        public final Navigator<? extends NavDestination> getNavigator() {
            return this.navigator;
        }

        public void push(NavBackStackEntry navBackStackEntry) {
            Intrinsics.checkNotNullParameter(navBackStackEntry, "backStackEntry");
            Navigator navigator2 = this.this$0._navigatorProvider.getNavigator(navBackStackEntry.getDestination().getNavigatorName());
            if (Intrinsics.areEqual((Object) navigator2, (Object) this.navigator)) {
                Function1 access$getAddToBackStackHandler$p = this.this$0.addToBackStackHandler;
                if (access$getAddToBackStackHandler$p != null) {
                    access$getAddToBackStackHandler$p.invoke(navBackStackEntry);
                    addInternal(navBackStackEntry);
                    return;
                }
                Log.i(NavController.TAG, "Ignoring add of destination " + navBackStackEntry.getDestination() + " outside of the call to navigate(). ");
                return;
            }
            Object obj = this.this$0.navigatorState.get(navigator2);
            if (obj != null) {
                ((NavControllerNavigatorState) obj).push(navBackStackEntry);
                return;
            }
            throw new IllegalStateException(("NavigatorBackStack for " + navBackStackEntry.getDestination().getNavigatorName() + " should already be created").toString());
        }

        public final void addInternal(NavBackStackEntry navBackStackEntry) {
            Intrinsics.checkNotNullParameter(navBackStackEntry, "backStackEntry");
            super.push(navBackStackEntry);
        }

        public NavBackStackEntry createBackStackEntry(NavDestination navDestination, Bundle bundle) {
            Intrinsics.checkNotNullParameter(navDestination, "destination");
            return NavBackStackEntry.Companion.create$default(NavBackStackEntry.Companion, this.this$0.getContext(), navDestination, bundle, this.this$0.getHostLifecycleState$navigation_runtime_release(), this.this$0.viewModel, (String) null, (Bundle) null, 96, (Object) null);
        }

        public void pop(NavBackStackEntry navBackStackEntry, boolean z) {
            Intrinsics.checkNotNullParameter(navBackStackEntry, "popUpTo");
            Navigator navigator2 = this.this$0._navigatorProvider.getNavigator(navBackStackEntry.getDestination().getNavigatorName());
            if (Intrinsics.areEqual((Object) navigator2, (Object) this.navigator)) {
                Function1 access$getPopFromBackStackHandler$p = this.this$0.popFromBackStackHandler;
                if (access$getPopFromBackStackHandler$p != null) {
                    access$getPopFromBackStackHandler$p.invoke(navBackStackEntry);
                    super.pop(navBackStackEntry, z);
                    return;
                }
                this.this$0.popBackStackFromNavigator$navigation_runtime_release(navBackStackEntry, new NavController$NavControllerNavigatorState$pop$1(this, navBackStackEntry, z));
                return;
            }
            Object obj = this.this$0.navigatorState.get(navigator2);
            Intrinsics.checkNotNull(obj);
            ((NavControllerNavigatorState) obj).pop(navBackStackEntry, z);
        }

        public void popWithTransition(NavBackStackEntry navBackStackEntry, boolean z) {
            Intrinsics.checkNotNullParameter(navBackStackEntry, "popUpTo");
            super.popWithTransition(navBackStackEntry, z);
            this.this$0.entrySavedState.put(navBackStackEntry, Boolean.valueOf(z));
        }

        public void markTransitionComplete(NavBackStackEntry navBackStackEntry) {
            NavControllerViewModel access$getViewModel$p;
            Intrinsics.checkNotNullParameter(navBackStackEntry, "entry");
            boolean areEqual = Intrinsics.areEqual(this.this$0.entrySavedState.get(navBackStackEntry), (Object) true);
            super.markTransitionComplete(navBackStackEntry);
            this.this$0.entrySavedState.remove(navBackStackEntry);
            if (!this.this$0.backQueue.contains(navBackStackEntry)) {
                this.this$0.unlinkChildFromParent$navigation_runtime_release(navBackStackEntry);
                if (navBackStackEntry.getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.CREATED)) {
                    navBackStackEntry.setMaxLifecycle(Lifecycle.State.DESTROYED);
                }
                Iterable access$getBackQueue$p = this.this$0.backQueue;
                if (!(access$getBackQueue$p instanceof Collection) || !((Collection) access$getBackQueue$p).isEmpty()) {
                    Iterator it = access$getBackQueue$p.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            if (Intrinsics.areEqual((Object) ((NavBackStackEntry) it.next()).getId(), (Object) navBackStackEntry.getId())) {
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                    this.this$0.updateBackStackLifecycle$navigation_runtime_release();
                    this.this$0._visibleEntries.tryEmit(this.this$0.populateVisibleEntries$navigation_runtime_release());
                }
                if (!areEqual && (access$getViewModel$p = this.this$0.viewModel) != null) {
                    access$getViewModel$p.clear(navBackStackEntry.getId());
                }
                this.this$0.updateBackStackLifecycle$navigation_runtime_release();
                this.this$0._visibleEntries.tryEmit(this.this$0.populateVisibleEntries$navigation_runtime_release());
            } else if (!isNavigating()) {
                this.this$0.updateBackStackLifecycle$navigation_runtime_release();
                this.this$0._currentBackStack.tryEmit(CollectionsKt.toMutableList(this.this$0.backQueue));
                this.this$0._visibleEntries.tryEmit(this.this$0.populateVisibleEntries$navigation_runtime_release());
            }
        }

        public void prepareForTransition(NavBackStackEntry navBackStackEntry) {
            Intrinsics.checkNotNullParameter(navBackStackEntry, "entry");
            super.prepareForTransition(navBackStackEntry);
            if (this.this$0.backQueue.contains(navBackStackEntry)) {
                navBackStackEntry.setMaxLifecycle(Lifecycle.State.STARTED);
                return;
            }
            throw new IllegalStateException("Cannot transition entry that is not in the back stack");
        }
    }

    public void addOnDestinationChangedListener(OnDestinationChangedListener onDestinationChangedListener) {
        Intrinsics.checkNotNullParameter(onDestinationChangedListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.onDestinationChangedListeners.add(onDestinationChangedListener);
        if (!this.backQueue.isEmpty()) {
            NavBackStackEntry last = this.backQueue.last();
            onDestinationChangedListener.onDestinationChanged(this, last.getDestination(), last.getArguments());
        }
    }

    public void removeOnDestinationChangedListener(OnDestinationChangedListener onDestinationChangedListener) {
        Intrinsics.checkNotNullParameter(onDestinationChangedListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.onDestinationChangedListeners.remove(onDestinationChangedListener);
    }

    public boolean popBackStack() {
        if (this.backQueue.isEmpty()) {
            return false;
        }
        NavDestination currentDestination = getCurrentDestination();
        Intrinsics.checkNotNull(currentDestination);
        return popBackStack(currentDestination.getId(), true);
    }

    public boolean popBackStack(int i, boolean z) {
        return popBackStack(i, z, false);
    }

    public boolean popBackStack(int i, boolean z, boolean z2) {
        return popBackStackInternal(i, z, z2) && dispatchOnDestinationChanged();
    }

    public static /* synthetic */ boolean popBackStack$default(NavController navController, String str, boolean z, boolean z2, int i, Object obj) {
        if (obj == null) {
            if ((i & 4) != 0) {
                z2 = false;
            }
            return navController.popBackStack(str, z, z2);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: popBackStack");
    }

    public final boolean popBackStack(String str, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(str, "route");
        return popBackStackInternal(str, z, z2) && dispatchOnDestinationChanged();
    }

    static /* synthetic */ boolean popBackStackInternal$default(NavController navController, int i, boolean z, boolean z2, int i2, Object obj) {
        if (obj == null) {
            if ((i2 & 4) != 0) {
                z2 = false;
            }
            return navController.popBackStackInternal(i, z, z2);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: popBackStackInternal");
    }

    private final boolean popBackStackInternal(int i, boolean z, boolean z2) {
        NavDestination navDestination;
        if (this.backQueue.isEmpty()) {
            return false;
        }
        List arrayList = new ArrayList();
        Iterator it = CollectionsKt.reversed(this.backQueue).iterator();
        while (true) {
            if (!it.hasNext()) {
                navDestination = null;
                break;
            }
            navDestination = ((NavBackStackEntry) it.next()).getDestination();
            Navigator navigator = this._navigatorProvider.getNavigator(navDestination.getNavigatorName());
            if (z || navDestination.getId() != i) {
                arrayList.add(navigator);
            }
            if (navDestination.getId() == i) {
                break;
            }
        }
        if (navDestination != null) {
            return executePopOperations(arrayList, navDestination, z, z2);
        }
        Log.i(TAG, "Ignoring popBackStack to destination " + NavDestination.Companion.getDisplayName(this.context, i) + " as it was not found on the current back stack");
        return false;
    }

    private final boolean popBackStackInternal(String str, boolean z, boolean z2) {
        NavDestination navDestination;
        Object obj;
        if (this.backQueue.isEmpty()) {
            return false;
        }
        List arrayList = new ArrayList();
        List list = this.backQueue;
        ListIterator listIterator = list.listIterator(list.size());
        while (true) {
            navDestination = null;
            if (!listIterator.hasPrevious()) {
                obj = null;
                break;
            }
            obj = listIterator.previous();
            NavBackStackEntry navBackStackEntry = (NavBackStackEntry) obj;
            boolean hasRoute = navBackStackEntry.getDestination().hasRoute(str, navBackStackEntry.getArguments());
            if (z || !hasRoute) {
                arrayList.add(this._navigatorProvider.getNavigator(navBackStackEntry.getDestination().getNavigatorName()));
                continue;
            }
            if (hasRoute) {
                break;
            }
        }
        NavBackStackEntry navBackStackEntry2 = (NavBackStackEntry) obj;
        if (navBackStackEntry2 != null) {
            navDestination = navBackStackEntry2.getDestination();
        }
        if (navDestination != null) {
            return executePopOperations(arrayList, navDestination, z, z2);
        }
        Log.i(TAG, "Ignoring popBackStack to route " + str + " as it was not found on the current back stack");
        return false;
    }

    private final boolean executePopOperations(List<? extends Navigator<?>> list, NavDestination navDestination, boolean z, boolean z2) {
        NavController navController;
        boolean z3;
        Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        ArrayDeque arrayDeque = new ArrayDeque();
        Iterator<? extends Navigator<?>> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                navController = this;
                z3 = z2;
                break;
            }
            Ref.BooleanRef booleanRef2 = new Ref.BooleanRef();
            navController = this;
            z3 = z2;
            popBackStackInternal((Navigator) it.next(), this.backQueue.last(), z3, new NavController$executePopOperations$1(booleanRef2, booleanRef, navController, z3, arrayDeque));
            if (!booleanRef2.element) {
                break;
            }
            z2 = z3;
        }
        if (z3) {
            if (!z) {
                for (NavDestination id : SequencesKt.takeWhile(SequencesKt.generateSequence(navDestination, NavController$executePopOperations$2.INSTANCE), new NavController$executePopOperations$3(this))) {
                    Map<Integer, String> map = navController.backStackMap;
                    Integer valueOf = Integer.valueOf(id.getId());
                    NavBackStackEntryState navBackStackEntryState = (NavBackStackEntryState) arrayDeque.firstOrNull();
                    map.put(valueOf, navBackStackEntryState != null ? navBackStackEntryState.getId() : null);
                }
            }
            if (!arrayDeque.isEmpty()) {
                NavBackStackEntryState navBackStackEntryState2 = (NavBackStackEntryState) arrayDeque.first();
                for (NavDestination id2 : SequencesKt.takeWhile(SequencesKt.generateSequence(findDestination(navBackStackEntryState2.getDestinationId()), NavController$executePopOperations$5.INSTANCE), new NavController$executePopOperations$6(this))) {
                    navController.backStackMap.put(Integer.valueOf(id2.getId()), navBackStackEntryState2.getId());
                }
                navController.backStackStates.put(navBackStackEntryState2.getId(), arrayDeque);
            }
        }
        updateOnBackPressedCallbackEnabled();
        return booleanRef.element;
    }

    public final void popBackStackFromNavigator$navigation_runtime_release(NavBackStackEntry navBackStackEntry, Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(navBackStackEntry, "popUpTo");
        Intrinsics.checkNotNullParameter(function0, "onComplete");
        int indexOf = this.backQueue.indexOf(navBackStackEntry);
        if (indexOf < 0) {
            Log.i(TAG, "Ignoring pop of " + navBackStackEntry + " as it was not found on the current back stack");
            return;
        }
        int i = indexOf + 1;
        if (i != this.backQueue.size()) {
            popBackStackInternal(this.backQueue.get(i).getDestination().getId(), true, false);
        }
        popEntryFromBackStack$default(this, navBackStackEntry, false, (ArrayDeque) null, 6, (Object) null);
        function0.invoke();
        updateOnBackPressedCallbackEnabled();
        dispatchOnDestinationChanged();
    }

    static /* synthetic */ void popEntryFromBackStack$default(NavController navController, NavBackStackEntry navBackStackEntry, boolean z, ArrayDeque arrayDeque, int i, Object obj) {
        if (obj == null) {
            if ((i & 2) != 0) {
                z = false;
            }
            if ((i & 4) != 0) {
                arrayDeque = new ArrayDeque();
            }
            navController.popEntryFromBackStack(navBackStackEntry, z, arrayDeque);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: popEntryFromBackStack");
    }

    /* access modifiers changed from: private */
    public final void popEntryFromBackStack(NavBackStackEntry navBackStackEntry, boolean z, ArrayDeque<NavBackStackEntryState> arrayDeque) {
        NavControllerViewModel navControllerViewModel;
        StateFlow<Set<NavBackStackEntry>> transitionsInProgress;
        Set value;
        NavBackStackEntry last = this.backQueue.last();
        if (Intrinsics.areEqual((Object) last, (Object) navBackStackEntry)) {
            this.backQueue.removeLast();
            NavControllerNavigatorState navControllerNavigatorState = this.navigatorState.get(getNavigatorProvider().getNavigator(last.getDestination().getNavigatorName()));
            boolean z2 = true;
            if ((navControllerNavigatorState == null || (transitionsInProgress = navControllerNavigatorState.getTransitionsInProgress()) == null || (value = transitionsInProgress.getValue()) == null || !value.contains(last)) && !this.parentToChildCount.containsKey(last)) {
                z2 = false;
            }
            if (last.getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.CREATED)) {
                if (z) {
                    last.setMaxLifecycle(Lifecycle.State.CREATED);
                    arrayDeque.addFirst(new NavBackStackEntryState(last));
                }
                if (!z2) {
                    last.setMaxLifecycle(Lifecycle.State.DESTROYED);
                    unlinkChildFromParent$navigation_runtime_release(last);
                } else {
                    last.setMaxLifecycle(Lifecycle.State.CREATED);
                }
            }
            if (!z && !z2 && (navControllerViewModel = this.viewModel) != null) {
                navControllerViewModel.clear(last.getId());
                return;
            }
            return;
        }
        throw new IllegalStateException(("Attempted to pop " + navBackStackEntry.getDestination() + ", which is not the top of the back stack (" + last.getDestination() + ')').toString());
    }

    public final boolean clearBackStack(String str) {
        Intrinsics.checkNotNullParameter(str, "route");
        return clearBackStackInternal(str) && dispatchOnDestinationChanged();
    }

    public final boolean clearBackStack(int i) {
        return clearBackStackInternal(i) && dispatchOnDestinationChanged();
    }

    private final boolean clearBackStackInternal(int i) {
        for (NavControllerNavigatorState navigating : this.navigatorState.values()) {
            navigating.setNavigating(true);
        }
        boolean restoreStateInternal = restoreStateInternal(i, (Bundle) null, NavOptionsBuilderKt.navOptions(NavController$clearBackStackInternal$restored$1.INSTANCE), (Navigator.Extras) null);
        for (NavControllerNavigatorState navigating2 : this.navigatorState.values()) {
            navigating2.setNavigating(false);
        }
        if (!restoreStateInternal || !popBackStackInternal(i, true, false)) {
            return false;
        }
        return true;
    }

    private final boolean clearBackStackInternal(String str) {
        for (NavControllerNavigatorState navigating : this.navigatorState.values()) {
            navigating.setNavigating(true);
        }
        boolean restoreStateInternal = restoreStateInternal(str);
        for (NavControllerNavigatorState navigating2 : this.navigatorState.values()) {
            navigating2.setNavigating(false);
        }
        if (!restoreStateInternal || !popBackStackInternal(str, true, false)) {
            return false;
        }
        return true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000c, code lost:
        r0 = r0.getIntent();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean navigateUp() {
        /*
            r2 = this;
            int r0 = r2.getDestinationCountOnBackStack()
            r1 = 1
            if (r0 != r1) goto L_0x002c
            android.app.Activity r0 = r2.activity
            r1 = 0
            if (r0 == 0) goto L_0x0017
            android.content.Intent r0 = r0.getIntent()
            if (r0 == 0) goto L_0x0017
            android.os.Bundle r0 = r0.getExtras()
            goto L_0x0018
        L_0x0017:
            r0 = r1
        L_0x0018:
            if (r0 == 0) goto L_0x0020
            java.lang.String r1 = "android-support-nav:controller:deepLinkIds"
            int[] r1 = r0.getIntArray(r1)
        L_0x0020:
            if (r1 == 0) goto L_0x0027
            boolean r0 = r2.tryRelaunchUpToExplicitStack()
            return r0
        L_0x0027:
            boolean r0 = r2.tryRelaunchUpToGeneratedStack()
            return r0
        L_0x002c:
            boolean r0 = r2.popBackStack()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.navigation.NavController.navigateUp():boolean");
    }

    private final boolean tryRelaunchUpToExplicitStack() {
        int i = 0;
        if (!this.deepLinkHandled) {
            return false;
        }
        Activity activity2 = this.activity;
        Intrinsics.checkNotNull(activity2);
        Intent intent = activity2.getIntent();
        Bundle extras = intent.getExtras();
        Intrinsics.checkNotNull(extras);
        int[] intArray = extras.getIntArray(KEY_DEEP_LINK_IDS);
        Intrinsics.checkNotNull(intArray);
        List<Integer> mutableList = ArraysKt.toMutableList(intArray);
        ArrayList parcelableArrayList = extras.getParcelableArrayList(KEY_DEEP_LINK_ARGS);
        int intValue = ((Number) CollectionsKt.removeLast(mutableList)).intValue();
        if (parcelableArrayList != null) {
            Bundle bundle = (Bundle) CollectionsKt.removeLast(parcelableArrayList);
        }
        if (mutableList.isEmpty()) {
            return false;
        }
        NavDestination findDestination = findDestination(getGraph(), intValue);
        if (findDestination instanceof NavGraph) {
            intValue = NavGraph.Companion.findStartDestination((NavGraph) findDestination).getId();
        }
        NavDestination currentDestination = getCurrentDestination();
        if (currentDestination == null || intValue != currentDestination.getId()) {
            return false;
        }
        NavDeepLinkBuilder createDeepLink = createDeepLink();
        Bundle bundleOf = BundleKt.bundleOf(TuplesKt.to(KEY_DEEP_LINK_INTENT, intent));
        Bundle bundle2 = extras.getBundle(KEY_DEEP_LINK_EXTRAS);
        if (bundle2 != null) {
            bundleOf.putAll(bundle2);
        }
        createDeepLink.setArguments(bundleOf);
        for (Object next : mutableList) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            createDeepLink.addDestination(((Number) next).intValue(), parcelableArrayList != null ? (Bundle) parcelableArrayList.get(i) : null);
            i = i2;
        }
        createDeepLink.createTaskStackBuilder().startActivities();
        Activity activity3 = this.activity;
        if (activity3 != null) {
            activity3.finish();
        }
        return true;
    }

    private final boolean tryRelaunchUpToGeneratedStack() {
        NavDestination currentDestination = getCurrentDestination();
        Intrinsics.checkNotNull(currentDestination);
        int id = currentDestination.getId();
        for (NavGraph parent = currentDestination.getParent(); parent != null; parent = parent.getParent()) {
            if (parent.getStartDestinationId() != id) {
                Bundle bundle = new Bundle();
                Activity activity2 = this.activity;
                if (activity2 != null) {
                    Intrinsics.checkNotNull(activity2);
                    if (activity2.getIntent() != null) {
                        Activity activity3 = this.activity;
                        Intrinsics.checkNotNull(activity3);
                        if (activity3.getIntent().getData() != null) {
                            Activity activity4 = this.activity;
                            Intrinsics.checkNotNull(activity4);
                            bundle.putParcelable(KEY_DEEP_LINK_INTENT, activity4.getIntent());
                            NavGraph navGraph = this._graph;
                            Intrinsics.checkNotNull(navGraph);
                            Activity activity5 = this.activity;
                            Intrinsics.checkNotNull(activity5);
                            Intent intent = activity5.getIntent();
                            Intrinsics.checkNotNullExpressionValue(intent, "activity!!.intent");
                            NavDestination.DeepLinkMatch matchDeepLink = navGraph.matchDeepLink(new NavDeepLinkRequest(intent));
                            if ((matchDeepLink != null ? matchDeepLink.getMatchingArgs() : null) != null) {
                                bundle.putAll(matchDeepLink.getDestination().addInDefaultArgs(matchDeepLink.getMatchingArgs()));
                            }
                        }
                    }
                }
                NavDeepLinkBuilder.setDestination$default(new NavDeepLinkBuilder(this), parent.getId(), (Bundle) null, 2, (Object) null).setArguments(bundle).createTaskStackBuilder().startActivities();
                Activity activity6 = this.activity;
                if (activity6 == null) {
                    return true;
                }
                activity6.finish();
                return true;
            }
            id = parent.getId();
        }
        return false;
    }

    private final int getDestinationCountOnBackStack() {
        Iterable<NavBackStackEntry> iterable = this.backQueue;
        int i = 0;
        if ((iterable instanceof Collection) && ((Collection) iterable).isEmpty()) {
            return 0;
        }
        for (NavBackStackEntry destination : iterable) {
            if (!(destination.getDestination() instanceof NavGraph) && (i = i + 1) < 0) {
                CollectionsKt.throwCountOverflow();
            }
        }
        return i;
    }

    private final boolean dispatchOnDestinationChanged() {
        while (!this.backQueue.isEmpty() && (this.backQueue.last().getDestination() instanceof NavGraph)) {
            popEntryFromBackStack$default(this, this.backQueue.last(), false, (ArrayDeque) null, 6, (Object) null);
        }
        NavBackStackEntry lastOrNull = this.backQueue.lastOrNull();
        if (lastOrNull != null) {
            this.backStackEntriesToDispatch.add(lastOrNull);
        }
        this.dispatchReentrantCount++;
        updateBackStackLifecycle$navigation_runtime_release();
        int i = this.dispatchReentrantCount - 1;
        this.dispatchReentrantCount = i;
        if (i == 0) {
            List<NavBackStackEntry> mutableList = CollectionsKt.toMutableList(this.backStackEntriesToDispatch);
            this.backStackEntriesToDispatch.clear();
            for (NavBackStackEntry navBackStackEntry : mutableList) {
                Iterator<OnDestinationChangedListener> it = this.onDestinationChangedListeners.iterator();
                while (it.hasNext()) {
                    it.next().onDestinationChanged(this, navBackStackEntry.getDestination(), navBackStackEntry.getArguments());
                }
                this._currentBackStackEntryFlow.tryEmit(navBackStackEntry);
            }
            this._currentBackStack.tryEmit(CollectionsKt.toMutableList(this.backQueue));
            this._visibleEntries.tryEmit(populateVisibleEntries$navigation_runtime_release());
        }
        if (lastOrNull != null) {
            return true;
        }
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0098, code lost:
        r7 = (r7 = r7.getTransitionsInProgress()).getValue();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void updateBackStackLifecycle$navigation_runtime_release() {
        /*
            r11 = this;
            kotlin.collections.ArrayDeque<androidx.navigation.NavBackStackEntry> r0 = r11.backQueue
            java.util.Collection r0 = (java.util.Collection) r0
            java.util.List r0 = kotlin.collections.CollectionsKt.toMutableList(r0)
            boolean r1 = r0.isEmpty()
            if (r1 == 0) goto L_0x0010
            goto L_0x0130
        L_0x0010:
            java.lang.Object r1 = kotlin.collections.CollectionsKt.last(r0)
            androidx.navigation.NavBackStackEntry r1 = (androidx.navigation.NavBackStackEntry) r1
            androidx.navigation.NavDestination r1 = r1.getDestination()
            boolean r2 = r1 instanceof androidx.navigation.FloatingWindow
            r3 = 0
            if (r2 == 0) goto L_0x0043
            r2 = r0
            java.lang.Iterable r2 = (java.lang.Iterable) r2
            java.util.List r2 = kotlin.collections.CollectionsKt.reversed(r2)
            java.util.Iterator r2 = r2.iterator()
        L_0x002a:
            boolean r4 = r2.hasNext()
            if (r4 == 0) goto L_0x0043
            java.lang.Object r4 = r2.next()
            androidx.navigation.NavBackStackEntry r4 = (androidx.navigation.NavBackStackEntry) r4
            androidx.navigation.NavDestination r4 = r4.getDestination()
            boolean r5 = r4 instanceof androidx.navigation.NavGraph
            if (r5 != 0) goto L_0x002a
            boolean r5 = r4 instanceof androidx.navigation.FloatingWindow
            if (r5 != 0) goto L_0x002a
            goto L_0x0044
        L_0x0043:
            r4 = r3
        L_0x0044:
            java.util.HashMap r2 = new java.util.HashMap
            r2.<init>()
            r5 = r0
            java.lang.Iterable r5 = (java.lang.Iterable) r5
            java.util.List r5 = kotlin.collections.CollectionsKt.reversed(r5)
            java.util.Iterator r5 = r5.iterator()
        L_0x0054:
            boolean r6 = r5.hasNext()
            if (r6 == 0) goto L_0x0110
            java.lang.Object r6 = r5.next()
            androidx.navigation.NavBackStackEntry r6 = (androidx.navigation.NavBackStackEntry) r6
            androidx.lifecycle.Lifecycle$State r7 = r6.getMaxLifecycle()
            androidx.navigation.NavDestination r8 = r6.getDestination()
            if (r1 == 0) goto L_0x00df
            int r9 = r8.getId()
            int r10 = r1.getId()
            if (r9 != r10) goto L_0x00df
            androidx.lifecycle.Lifecycle$State r8 = androidx.lifecycle.Lifecycle.State.RESUMED
            if (r7 == r8) goto L_0x00d7
            androidx.navigation.NavigatorProvider r7 = r11.getNavigatorProvider()
            androidx.navigation.NavDestination r8 = r6.getDestination()
            java.lang.String r8 = r8.getNavigatorName()
            androidx.navigation.Navigator r7 = r7.getNavigator((java.lang.String) r8)
            java.util.Map<androidx.navigation.Navigator<? extends androidx.navigation.NavDestination>, androidx.navigation.NavController$NavControllerNavigatorState> r8 = r11.navigatorState
            java.lang.Object r7 = r8.get(r7)
            androidx.navigation.NavController$NavControllerNavigatorState r7 = (androidx.navigation.NavController.NavControllerNavigatorState) r7
            if (r7 == 0) goto L_0x00a9
            kotlinx.coroutines.flow.StateFlow r7 = r7.getTransitionsInProgress()
            if (r7 == 0) goto L_0x00a9
            java.lang.Object r7 = r7.getValue()
            java.util.Set r7 = (java.util.Set) r7
            if (r7 == 0) goto L_0x00a9
            boolean r7 = r7.contains(r6)
            java.lang.Boolean r7 = java.lang.Boolean.valueOf(r7)
            goto L_0x00aa
        L_0x00a9:
            r7 = r3
        L_0x00aa:
            r8 = 1
            java.lang.Boolean r8 = java.lang.Boolean.valueOf(r8)
            boolean r7 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r7, (java.lang.Object) r8)
            if (r7 != 0) goto L_0x00cf
            java.util.Map<androidx.navigation.NavBackStackEntry, java.util.concurrent.atomic.AtomicInteger> r7 = r11.parentToChildCount
            java.lang.Object r7 = r7.get(r6)
            java.util.concurrent.atomic.AtomicInteger r7 = (java.util.concurrent.atomic.AtomicInteger) r7
            if (r7 == 0) goto L_0x00c6
            int r7 = r7.get()
            if (r7 != 0) goto L_0x00c6
            goto L_0x00cf
        L_0x00c6:
            r7 = r2
            java.util.Map r7 = (java.util.Map) r7
            androidx.lifecycle.Lifecycle$State r8 = androidx.lifecycle.Lifecycle.State.RESUMED
            r7.put(r6, r8)
            goto L_0x00d7
        L_0x00cf:
            r7 = r2
            java.util.Map r7 = (java.util.Map) r7
            androidx.lifecycle.Lifecycle$State r8 = androidx.lifecycle.Lifecycle.State.STARTED
            r7.put(r6, r8)
        L_0x00d7:
            androidx.navigation.NavGraph r1 = r1.getParent()
            androidx.navigation.NavDestination r1 = (androidx.navigation.NavDestination) r1
            goto L_0x0054
        L_0x00df:
            if (r4 == 0) goto L_0x0109
            int r8 = r8.getId()
            int r9 = r4.getId()
            if (r8 != r9) goto L_0x0109
            androidx.lifecycle.Lifecycle$State r8 = androidx.lifecycle.Lifecycle.State.RESUMED
            if (r7 != r8) goto L_0x00f5
            androidx.lifecycle.Lifecycle$State r7 = androidx.lifecycle.Lifecycle.State.STARTED
            r6.setMaxLifecycle(r7)
            goto L_0x0101
        L_0x00f5:
            androidx.lifecycle.Lifecycle$State r8 = androidx.lifecycle.Lifecycle.State.STARTED
            if (r7 == r8) goto L_0x0101
            r7 = r2
            java.util.Map r7 = (java.util.Map) r7
            androidx.lifecycle.Lifecycle$State r8 = androidx.lifecycle.Lifecycle.State.STARTED
            r7.put(r6, r8)
        L_0x0101:
            androidx.navigation.NavGraph r4 = r4.getParent()
            androidx.navigation.NavDestination r4 = (androidx.navigation.NavDestination) r4
            goto L_0x0054
        L_0x0109:
            androidx.lifecycle.Lifecycle$State r7 = androidx.lifecycle.Lifecycle.State.CREATED
            r6.setMaxLifecycle(r7)
            goto L_0x0054
        L_0x0110:
            java.util.Iterator r0 = r0.iterator()
        L_0x0114:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0130
            java.lang.Object r1 = r0.next()
            androidx.navigation.NavBackStackEntry r1 = (androidx.navigation.NavBackStackEntry) r1
            java.lang.Object r3 = r2.get(r1)
            androidx.lifecycle.Lifecycle$State r3 = (androidx.lifecycle.Lifecycle.State) r3
            if (r3 == 0) goto L_0x012c
            r1.setMaxLifecycle(r3)
            goto L_0x0114
        L_0x012c:
            r1.updateState()
            goto L_0x0114
        L_0x0130:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.navigation.NavController.updateBackStackLifecycle$navigation_runtime_release():void");
    }

    public final List<NavBackStackEntry> populateVisibleEntries$navigation_runtime_release() {
        List arrayList = new ArrayList();
        for (NavControllerNavigatorState transitionsInProgress : this.navigatorState.values()) {
            Collection collection = arrayList;
            Collection arrayList2 = new ArrayList();
            for (Object next : transitionsInProgress.getTransitionsInProgress().getValue()) {
                NavBackStackEntry navBackStackEntry = (NavBackStackEntry) next;
                if (!arrayList.contains(navBackStackEntry) && !navBackStackEntry.getMaxLifecycle().isAtLeast(Lifecycle.State.STARTED)) {
                    arrayList2.add(next);
                }
            }
            CollectionsKt.addAll(collection, (List) arrayList2);
        }
        Collection collection2 = arrayList;
        Collection arrayList3 = new ArrayList();
        for (Object next2 : this.backQueue) {
            NavBackStackEntry navBackStackEntry2 = (NavBackStackEntry) next2;
            if (!arrayList.contains(navBackStackEntry2) && navBackStackEntry2.getMaxLifecycle().isAtLeast(Lifecycle.State.STARTED)) {
                arrayList3.add(next2);
            }
        }
        CollectionsKt.addAll(collection2, (List) arrayList3);
        Collection arrayList4 = new ArrayList();
        for (Object next3 : arrayList) {
            if (!(((NavBackStackEntry) next3).getDestination() instanceof NavGraph)) {
                arrayList4.add(next3);
            }
        }
        return (List) arrayList4;
    }

    public NavInflater getNavInflater() {
        return (NavInflater) this.navInflater$delegate.getValue();
    }

    public void setGraph(int i) {
        setGraph(getNavInflater().inflate(i), (Bundle) null);
    }

    public void setGraph(int i, Bundle bundle) {
        setGraph(getNavInflater().inflate(i), bundle);
    }

    public void setGraph(NavGraph navGraph, Bundle bundle) {
        NavController navController;
        Intrinsics.checkNotNullParameter(navGraph, "graph");
        if (!Intrinsics.areEqual((Object) this._graph, (Object) navGraph)) {
            NavGraph navGraph2 = this._graph;
            if (navGraph2 != null) {
                for (Integer num : new ArrayList(this.backStackMap.keySet())) {
                    Intrinsics.checkNotNullExpressionValue(num, "id");
                    clearBackStackInternal(num.intValue());
                }
                navController = this;
                popBackStackInternal$default(navController, navGraph2.getId(), true, false, 4, (Object) null);
            } else {
                navController = this;
            }
            navController._graph = navGraph;
            onGraphCreated(bundle);
            return;
        }
        int size = navGraph.getNodes().size();
        for (int i = 0; i < size; i++) {
            NavGraph navGraph3 = this._graph;
            Intrinsics.checkNotNull(navGraph3);
            int keyAt = navGraph3.getNodes().keyAt(i);
            NavGraph navGraph4 = this._graph;
            Intrinsics.checkNotNull(navGraph4);
            navGraph4.getNodes().replace(keyAt, navGraph.getNodes().valueAt(i));
        }
        for (NavBackStackEntry navBackStackEntry : this.backQueue) {
            NavDestination navDestination = this._graph;
            Intrinsics.checkNotNull(navDestination);
            for (T t : CollectionsKt.asReversed(SequencesKt.toList(NavDestination.Companion.getHierarchy(navBackStackEntry.getDestination())))) {
                navDestination = navDestination;
                if ((!Intrinsics.areEqual((Object) t, (Object) this._graph) || !Intrinsics.areEqual((Object) navDestination, (Object) navGraph)) && (navDestination instanceof NavGraph)) {
                    navDestination = ((NavGraph) navDestination).findNode(t.getId());
                    Intrinsics.checkNotNull(navDestination);
                }
            }
            navBackStackEntry.setDestination(navDestination);
        }
    }

    private final void onGraphCreated(Bundle bundle) {
        Activity activity2;
        ArrayList<String> stringArrayList;
        Bundle bundle2 = this.navigatorStateToRestore;
        if (!(bundle2 == null || (stringArrayList = bundle2.getStringArrayList(KEY_NAVIGATOR_STATE_NAMES)) == null)) {
            Iterator<String> it = stringArrayList.iterator();
            while (it.hasNext()) {
                String next = it.next();
                NavigatorProvider navigatorProvider = this._navigatorProvider;
                Intrinsics.checkNotNullExpressionValue(next, "name");
                Navigator navigator = navigatorProvider.getNavigator(next);
                Bundle bundle3 = bundle2.getBundle(next);
                if (bundle3 != null) {
                    navigator.onRestoreState(bundle3);
                }
            }
        }
        Parcelable[] parcelableArr = this.backStackToRestore;
        if (parcelableArr != null) {
            int length = parcelableArr.length;
            int i = 0;
            while (i < length) {
                Parcelable parcelable = parcelableArr[i];
                Intrinsics.checkNotNull(parcelable, "null cannot be cast to non-null type androidx.navigation.NavBackStackEntryState");
                NavBackStackEntryState navBackStackEntryState = (NavBackStackEntryState) parcelable;
                NavDestination findDestination = findDestination(navBackStackEntryState.getDestinationId());
                if (findDestination != null) {
                    NavBackStackEntry instantiate = navBackStackEntryState.instantiate(this.context, findDestination, getHostLifecycleState$navigation_runtime_release(), this.viewModel);
                    Navigator navigator2 = this._navigatorProvider.getNavigator(findDestination.getNavigatorName());
                    Map<Navigator<? extends NavDestination>, NavControllerNavigatorState> map = this.navigatorState;
                    NavControllerNavigatorState navControllerNavigatorState = map.get(navigator2);
                    if (navControllerNavigatorState == null) {
                        navControllerNavigatorState = new NavControllerNavigatorState(this, navigator2);
                        map.put(navigator2, navControllerNavigatorState);
                    }
                    this.backQueue.add(instantiate);
                    navControllerNavigatorState.addInternal(instantiate);
                    NavGraph parent = instantiate.getDestination().getParent();
                    if (parent != null) {
                        linkChildToParent(instantiate, getBackStackEntry(parent.getId()));
                    }
                    i++;
                } else {
                    throw new IllegalStateException("Restoring the Navigation back stack failed: destination " + NavDestination.Companion.getDisplayName(this.context, navBackStackEntryState.getDestinationId()) + " cannot be found from the current destination " + getCurrentDestination());
                }
            }
            updateOnBackPressedCallbackEnabled();
            this.backStackToRestore = null;
        }
        Collection arrayList = new ArrayList();
        for (Object next2 : this._navigatorProvider.getNavigators().values()) {
            if (!((Navigator) next2).isAttached()) {
                arrayList.add(next2);
            }
        }
        for (Navigator navigator3 : (List) arrayList) {
            Map<Navigator<? extends NavDestination>, NavControllerNavigatorState> map2 = this.navigatorState;
            NavControllerNavigatorState navControllerNavigatorState2 = map2.get(navigator3);
            if (navControllerNavigatorState2 == null) {
                navControllerNavigatorState2 = new NavControllerNavigatorState(this, navigator3);
                map2.put(navigator3, navControllerNavigatorState2);
            }
            navigator3.onAttach(navControllerNavigatorState2);
        }
        if (this._graph == null || !this.backQueue.isEmpty()) {
            dispatchOnDestinationChanged();
            return;
        }
        if (!this.deepLinkHandled && (activity2 = this.activity) != null) {
            Intrinsics.checkNotNull(activity2);
            if (handleDeepLink(activity2.getIntent())) {
                return;
            }
        }
        NavGraph navGraph = this._graph;
        Intrinsics.checkNotNull(navGraph);
        navigate((NavDestination) navGraph, bundle, (NavOptions) null, (Navigator.Extras) null);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0030  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x003f  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0046  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0049  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0062  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0080  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x01f3 A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean handleDeepLink(android.content.Intent r20) {
        /*
            r19 = this;
            r1 = r19
            r2 = r20
            r7 = 0
            if (r2 != 0) goto L_0x0008
            return r7
        L_0x0008:
            android.os.Bundle r3 = r2.getExtras()
            java.lang.String r4 = "NavController"
            r8 = 0
            if (r3 == 0) goto L_0x002d
            java.lang.String r0 = "android-support-nav:controller:deepLinkIds"
            int[] r0 = r3.getIntArray(r0)     // Catch:{ Exception -> 0x0018 }
            goto L_0x002e
        L_0x0018:
            r0 = move-exception
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            java.lang.String r6 = "handleDeepLink() could not extract deepLink from "
            r5.<init>(r6)
            java.lang.StringBuilder r5 = r5.append(r2)
            java.lang.String r5 = r5.toString()
            java.lang.Throwable r0 = (java.lang.Throwable) r0
            android.util.Log.e(r4, r5, r0)
        L_0x002d:
            r0 = r8
        L_0x002e:
            if (r3 == 0) goto L_0x0037
            java.lang.String r5 = "android-support-nav:controller:deepLinkArgs"
            java.util.ArrayList r5 = r3.getParcelableArrayList(r5)
            goto L_0x0038
        L_0x0037:
            r5 = r8
        L_0x0038:
            android.os.Bundle r6 = new android.os.Bundle
            r6.<init>()
            if (r3 == 0) goto L_0x0046
            java.lang.String r9 = "android-support-nav:controller:deepLinkExtras"
            android.os.Bundle r3 = r3.getBundle(r9)
            goto L_0x0047
        L_0x0046:
            r3 = r8
        L_0x0047:
            if (r3 == 0) goto L_0x004c
            r6.putAll(r3)
        L_0x004c:
            r9 = 1
            if (r0 == 0) goto L_0x0052
            int r3 = r0.length
            if (r3 != 0) goto L_0x0079
        L_0x0052:
            androidx.navigation.NavGraph r3 = r1._graph
            kotlin.jvm.internal.Intrinsics.checkNotNull(r3)
            androidx.navigation.NavDeepLinkRequest r10 = new androidx.navigation.NavDeepLinkRequest
            r10.<init>(r2)
            androidx.navigation.NavDestination$DeepLinkMatch r3 = r3.matchDeepLink(r10)
            if (r3 == 0) goto L_0x0079
            androidx.navigation.NavDestination r0 = r3.getDestination()
            int[] r5 = androidx.navigation.NavDestination.buildDeepLinkIds$default(r0, r8, r9, r8)
            android.os.Bundle r3 = r3.getMatchingArgs()
            android.os.Bundle r0 = r0.addInDefaultArgs(r3)
            if (r0 == 0) goto L_0x0077
            r6.putAll(r0)
        L_0x0077:
            r0 = r5
            r5 = r8
        L_0x0079:
            if (r0 == 0) goto L_0x01f3
            int r3 = r0.length
            if (r3 != 0) goto L_0x0080
            goto L_0x01f3
        L_0x0080:
            java.lang.String r3 = r1.findInvalidDestinationDisplayNameInDeepLink(r0)
            if (r3 == 0) goto L_0x00a3
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r5 = "Could not find destination "
            r0.<init>(r5)
            java.lang.StringBuilder r0 = r0.append(r3)
            java.lang.String r3 = " in the navigation graph, ignoring the deep link from "
            java.lang.StringBuilder r0 = r0.append(r3)
            java.lang.StringBuilder r0 = r0.append(r2)
            java.lang.String r0 = r0.toString()
            android.util.Log.i(r4, r0)
            return r7
        L_0x00a3:
            java.lang.String r3 = "android-support-nav:controller:deepLinkIntent"
            r4 = r2
            android.os.Parcelable r4 = (android.os.Parcelable) r4
            r6.putParcelable(r3, r4)
            int r3 = r0.length
            android.os.Bundle[] r10 = new android.os.Bundle[r3]
            r4 = r7
        L_0x00af:
            if (r4 >= r3) goto L_0x00cb
            android.os.Bundle r11 = new android.os.Bundle
            r11.<init>()
            r11.putAll(r6)
            if (r5 == 0) goto L_0x00c6
            java.lang.Object r12 = r5.get(r4)
            android.os.Bundle r12 = (android.os.Bundle) r12
            if (r12 == 0) goto L_0x00c6
            r11.putAll(r12)
        L_0x00c6:
            r10[r4] = r11
            int r4 = r4 + 1
            goto L_0x00af
        L_0x00cb:
            int r3 = r2.getFlags()
            r4 = 268435456(0x10000000, float:2.5243549E-29)
            r4 = r4 & r3
            if (r4 == 0) goto L_0x00fa
            r5 = 32768(0x8000, float:4.5918E-41)
            r3 = r3 & r5
            if (r3 != 0) goto L_0x00fa
            r2.addFlags(r5)
            android.content.Context r0 = r1.context
            androidx.core.app.TaskStackBuilder r0 = androidx.core.app.TaskStackBuilder.create(r0)
            androidx.core.app.TaskStackBuilder r0 = r0.addNextIntentWithParentStack(r2)
            java.lang.String r2 = "create(context)\n        …ntWithParentStack(intent)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r2)
            r0.startActivities()
            android.app.Activity r0 = r1.activity
            if (r0 == 0) goto L_0x00f9
            r0.finish()
            r0.overridePendingTransition(r7, r7)
        L_0x00f9:
            return r9
        L_0x00fa:
            java.lang.String r11 = "Deep Linking failed: destination "
            if (r4 == 0) goto L_0x015f
            kotlin.collections.ArrayDeque<androidx.navigation.NavBackStackEntry> r2 = r1.backQueue
            boolean r2 = r2.isEmpty()
            if (r2 != 0) goto L_0x0116
            androidx.navigation.NavGraph r2 = r1._graph
            kotlin.jvm.internal.Intrinsics.checkNotNull(r2)
            int r2 = r2.getId()
            r5 = 4
            r6 = 0
            r3 = 1
            r4 = 0
            popBackStackInternal$default(r1, r2, r3, r4, r5, r6)
        L_0x0116:
            int r2 = r0.length
            if (r7 >= r2) goto L_0x015e
            r2 = r0[r7]
            int r3 = r7 + 1
            r4 = r10[r7]
            androidx.navigation.NavDestination r5 = r1.findDestination((int) r2)
            if (r5 == 0) goto L_0x0135
            androidx.navigation.NavController$handleDeepLink$2 r2 = new androidx.navigation.NavController$handleDeepLink$2
            r2.<init>(r5, r1)
            kotlin.jvm.functions.Function1 r2 = (kotlin.jvm.functions.Function1) r2
            androidx.navigation.NavOptions r2 = androidx.navigation.NavOptionsBuilderKt.navOptions(r2)
            r1.navigate((androidx.navigation.NavDestination) r5, (android.os.Bundle) r4, (androidx.navigation.NavOptions) r2, (androidx.navigation.Navigator.Extras) r8)
            r7 = r3
            goto L_0x0116
        L_0x0135:
            androidx.navigation.NavDestination$Companion r0 = androidx.navigation.NavDestination.Companion
            android.content.Context r3 = r1.context
            java.lang.String r0 = r0.getDisplayName(r3, r2)
            java.lang.IllegalStateException r2 = new java.lang.IllegalStateException
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r11)
            java.lang.StringBuilder r0 = r3.append(r0)
            java.lang.String r3 = " cannot be found from the current destination "
            java.lang.StringBuilder r0 = r0.append(r3)
            androidx.navigation.NavDestination r3 = r1.getCurrentDestination()
            java.lang.StringBuilder r0 = r0.append(r3)
            java.lang.String r0 = r0.toString()
            r2.<init>(r0)
            throw r2
        L_0x015e:
            return r9
        L_0x015f:
            androidx.navigation.NavGraph r2 = r1._graph
            int r3 = r0.length
            r4 = r7
        L_0x0163:
            if (r4 >= r3) goto L_0x01f0
            r5 = r0[r4]
            r6 = r10[r4]
            if (r4 != 0) goto L_0x0170
            androidx.navigation.NavGraph r12 = r1._graph
            androidx.navigation.NavDestination r12 = (androidx.navigation.NavDestination) r12
            goto L_0x0177
        L_0x0170:
            kotlin.jvm.internal.Intrinsics.checkNotNull(r2)
            androidx.navigation.NavDestination r12 = r2.findNode((int) r5)
        L_0x0177:
            if (r12 == 0) goto L_0x01cb
            int r5 = r0.length
            int r5 = r5 - r9
            if (r4 == r5) goto L_0x01a0
            boolean r5 = r12 instanceof androidx.navigation.NavGraph
            if (r5 == 0) goto L_0x01c8
            androidx.navigation.NavGraph r12 = (androidx.navigation.NavGraph) r12
        L_0x0183:
            kotlin.jvm.internal.Intrinsics.checkNotNull(r12)
            int r2 = r12.getStartDestinationId()
            androidx.navigation.NavDestination r2 = r12.findNode((int) r2)
            boolean r2 = r2 instanceof androidx.navigation.NavGraph
            if (r2 == 0) goto L_0x019e
            int r2 = r12.getStartDestinationId()
            androidx.navigation.NavDestination r2 = r12.findNode((int) r2)
            r12 = r2
            androidx.navigation.NavGraph r12 = (androidx.navigation.NavGraph) r12
            goto L_0x0183
        L_0x019e:
            r2 = r12
            goto L_0x01c8
        L_0x01a0:
            androidx.navigation.NavOptions$Builder r13 = new androidx.navigation.NavOptions$Builder
            r13.<init>()
            androidx.navigation.NavGraph r5 = r1._graph
            kotlin.jvm.internal.Intrinsics.checkNotNull(r5)
            int r14 = r5.getId()
            r17 = 4
            r18 = 0
            r15 = 1
            r16 = 0
            androidx.navigation.NavOptions$Builder r5 = androidx.navigation.NavOptions.Builder.setPopUpTo$default((androidx.navigation.NavOptions.Builder) r13, (int) r14, (boolean) r15, (boolean) r16, (int) r17, (java.lang.Object) r18)
            androidx.navigation.NavOptions$Builder r5 = r5.setEnterAnim(r7)
            androidx.navigation.NavOptions$Builder r5 = r5.setExitAnim(r7)
            androidx.navigation.NavOptions r5 = r5.build()
            r1.navigate((androidx.navigation.NavDestination) r12, (android.os.Bundle) r6, (androidx.navigation.NavOptions) r5, (androidx.navigation.Navigator.Extras) r8)
        L_0x01c8:
            int r4 = r4 + 1
            goto L_0x0163
        L_0x01cb:
            androidx.navigation.NavDestination$Companion r0 = androidx.navigation.NavDestination.Companion
            android.content.Context r3 = r1.context
            java.lang.String r0 = r0.getDisplayName(r3, r5)
            java.lang.IllegalStateException r3 = new java.lang.IllegalStateException
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>(r11)
            java.lang.StringBuilder r0 = r4.append(r0)
            java.lang.String r4 = " cannot be found in graph "
            java.lang.StringBuilder r0 = r0.append(r4)
            java.lang.StringBuilder r0 = r0.append(r2)
            java.lang.String r0 = r0.toString()
            r3.<init>(r0)
            throw r3
        L_0x01f0:
            r1.deepLinkHandled = r9
            return r9
        L_0x01f3:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.navigation.NavController.handleDeepLink(android.content.Intent):boolean");
    }

    private final String findInvalidDestinationDisplayNameInDeepLink(int[] iArr) {
        NavDestination navDestination;
        NavGraph navGraph;
        NavGraph navGraph2 = this._graph;
        int length = iArr.length;
        int i = 0;
        while (true) {
            NavGraph navGraph3 = null;
            if (i >= length) {
                return null;
            }
            int i2 = iArr[i];
            if (i == 0) {
                NavGraph navGraph4 = this._graph;
                Intrinsics.checkNotNull(navGraph4);
                if (navGraph4.getId() == i2) {
                    navGraph3 = this._graph;
                }
                navDestination = navGraph3;
            } else {
                Intrinsics.checkNotNull(navGraph2);
                navDestination = navGraph2.findNode(i2);
            }
            if (navDestination == null) {
                return NavDestination.Companion.getDisplayName(this.context, i2);
            }
            if (i != iArr.length - 1 && (navDestination instanceof NavGraph)) {
                while (true) {
                    navGraph = (NavGraph) navDestination;
                    Intrinsics.checkNotNull(navGraph);
                    if (!(navGraph.findNode(navGraph.getStartDestinationId()) instanceof NavGraph)) {
                        break;
                    }
                    navDestination = navGraph.findNode(navGraph.getStartDestinationId());
                }
                navGraph2 = navGraph;
            }
            i++;
        }
    }

    public NavDestination getCurrentDestination() {
        NavBackStackEntry currentBackStackEntry = getCurrentBackStackEntry();
        if (currentBackStackEntry != null) {
            return currentBackStackEntry.getDestination();
        }
        return null;
    }

    public final NavDestination findDestination(int i) {
        NavDestination navDestination;
        NavGraph navGraph = this._graph;
        if (navGraph == null) {
            return null;
        }
        Intrinsics.checkNotNull(navGraph);
        if (navGraph.getId() == i) {
            return this._graph;
        }
        NavBackStackEntry lastOrNull = this.backQueue.lastOrNull();
        if (lastOrNull == null || (navDestination = lastOrNull.getDestination()) == null) {
            NavGraph navGraph2 = this._graph;
            Intrinsics.checkNotNull(navGraph2);
            navDestination = navGraph2;
        }
        return findDestination(navDestination, i);
    }

    private final NavDestination findDestination(NavDestination navDestination, int i) {
        NavGraph navGraph;
        if (navDestination.getId() == i) {
            return navDestination;
        }
        if (navDestination instanceof NavGraph) {
            navGraph = (NavGraph) navDestination;
        } else {
            navGraph = navDestination.getParent();
            Intrinsics.checkNotNull(navGraph);
        }
        return navGraph.findNode(i);
    }

    public final NavDestination findDestination(String str) {
        NavDestination navDestination;
        NavGraph navGraph;
        Intrinsics.checkNotNullParameter(str, "route");
        NavGraph navGraph2 = this._graph;
        if (navGraph2 == null) {
            return null;
        }
        Intrinsics.checkNotNull(navGraph2);
        if (!Intrinsics.areEqual((Object) navGraph2.getRoute(), (Object) str)) {
            NavGraph navGraph3 = this._graph;
            Intrinsics.checkNotNull(navGraph3);
            if (navGraph3.matchDeepLink(str) == null) {
                NavBackStackEntry lastOrNull = this.backQueue.lastOrNull();
                if (lastOrNull == null || (navDestination = lastOrNull.getDestination()) == null) {
                    NavGraph navGraph4 = this._graph;
                    Intrinsics.checkNotNull(navGraph4);
                    navDestination = navGraph4;
                }
                if (navDestination instanceof NavGraph) {
                    navGraph = (NavGraph) navDestination;
                } else {
                    navGraph = navDestination.getParent();
                    Intrinsics.checkNotNull(navGraph);
                }
                return navGraph.findNode(str);
            }
        }
        return this._graph;
    }

    public void navigate(int i) {
        navigate(i, (Bundle) null);
    }

    public void navigate(int i, Bundle bundle) {
        navigate(i, bundle, (NavOptions) null);
    }

    public void navigate(int i, Bundle bundle, NavOptions navOptions) {
        navigate(i, bundle, navOptions, (Navigator.Extras) null);
    }

    public void navigate(int i, Bundle bundle, NavOptions navOptions, Navigator.Extras extras) {
        NavDestination navDestination;
        int i2;
        if (this.backQueue.isEmpty()) {
            navDestination = this._graph;
        } else {
            navDestination = this.backQueue.last().getDestination();
        }
        if (navDestination != null) {
            NavAction action = navDestination.getAction(i);
            Bundle bundle2 = null;
            if (action != null) {
                if (navOptions == null) {
                    navOptions = action.getNavOptions();
                }
                i2 = action.getDestinationId();
                Bundle defaultArguments = action.getDefaultArguments();
                if (defaultArguments != null) {
                    bundle2 = new Bundle();
                    bundle2.putAll(defaultArguments);
                }
            } else {
                i2 = i;
            }
            if (bundle != null) {
                if (bundle2 == null) {
                    bundle2 = new Bundle();
                }
                bundle2.putAll(bundle);
            }
            if (i2 == 0 && navOptions != null && navOptions.getPopUpToId() != -1) {
                popBackStack(navOptions.getPopUpToId(), navOptions.isPopUpToInclusive());
            } else if (i2 != 0) {
                NavDestination findDestination = findDestination(i2);
                if (findDestination == null) {
                    String displayName = NavDestination.Companion.getDisplayName(this.context, i2);
                    if (action == null) {
                        throw new IllegalArgumentException("Navigation action/destination " + displayName + " cannot be found from the current destination " + navDestination);
                    }
                    throw new IllegalArgumentException(("Navigation destination " + displayName + " referenced from action " + NavDestination.Companion.getDisplayName(this.context, i) + " cannot be found from the current destination " + navDestination).toString());
                }
                navigate(findDestination, bundle2, navOptions, extras);
            } else {
                throw new IllegalArgumentException("Destination id == 0 can only be used in conjunction with a valid navOptions.popUpTo".toString());
            }
        } else {
            throw new IllegalStateException("no current navigation node");
        }
    }

    public void navigate(Uri uri) {
        Intrinsics.checkNotNullParameter(uri, "deepLink");
        navigate(new NavDeepLinkRequest(uri, (String) null, (String) null));
    }

    public void navigate(Uri uri, NavOptions navOptions) {
        Intrinsics.checkNotNullParameter(uri, "deepLink");
        navigate(new NavDeepLinkRequest(uri, (String) null, (String) null), navOptions, (Navigator.Extras) null);
    }

    public void navigate(Uri uri, NavOptions navOptions, Navigator.Extras extras) {
        Intrinsics.checkNotNullParameter(uri, "deepLink");
        navigate(new NavDeepLinkRequest(uri, (String) null, (String) null), navOptions, extras);
    }

    public void navigate(NavDeepLinkRequest navDeepLinkRequest) {
        Intrinsics.checkNotNullParameter(navDeepLinkRequest, "request");
        navigate(navDeepLinkRequest, (NavOptions) null);
    }

    public void navigate(NavDeepLinkRequest navDeepLinkRequest, NavOptions navOptions) {
        Intrinsics.checkNotNullParameter(navDeepLinkRequest, "request");
        navigate(navDeepLinkRequest, navOptions, (Navigator.Extras) null);
    }

    public void navigate(NavDeepLinkRequest navDeepLinkRequest, NavOptions navOptions, Navigator.Extras extras) {
        Intrinsics.checkNotNullParameter(navDeepLinkRequest, "request");
        NavGraph navGraph = this._graph;
        Intrinsics.checkNotNull(navGraph);
        NavDestination.DeepLinkMatch matchDeepLink = navGraph.matchDeepLink(navDeepLinkRequest);
        if (matchDeepLink != null) {
            Bundle addInDefaultArgs = matchDeepLink.getDestination().addInDefaultArgs(matchDeepLink.getMatchingArgs());
            if (addInDefaultArgs == null) {
                addInDefaultArgs = new Bundle();
            }
            NavDestination destination = matchDeepLink.getDestination();
            Intent intent = new Intent();
            intent.setDataAndType(navDeepLinkRequest.getUri(), navDeepLinkRequest.getMimeType());
            intent.setAction(navDeepLinkRequest.getAction());
            addInDefaultArgs.putParcelable(KEY_DEEP_LINK_INTENT, intent);
            navigate(destination, addInDefaultArgs, navOptions, extras);
            return;
        }
        throw new IllegalArgumentException("Navigation destination that matches request " + navDeepLinkRequest + " cannot be found in the navigation graph " + this._graph);
    }

    private final void navigate(NavDestination navDestination, Bundle bundle, NavOptions navOptions, Navigator.Extras extras) {
        boolean z;
        NavOptions navOptions2 = navOptions;
        for (NavControllerNavigatorState navigating : this.navigatorState.values()) {
            navigating.setNavigating(true);
        }
        Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        boolean popBackStackInternal = (navOptions2 == null || navOptions2.getPopUpToId() == -1) ? false : popBackStackInternal(navOptions2.getPopUpToId(), navOptions2.isPopUpToInclusive(), navOptions2.shouldPopUpToSaveState());
        Bundle addInDefaultArgs = navDestination.addInDefaultArgs(bundle);
        if (navOptions2 == null || !navOptions2.shouldRestoreState() || !this.backStackMap.containsKey(Integer.valueOf(navDestination.getId()))) {
            Navigator.Extras extras2 = extras;
            z = navOptions2 != null && navOptions2.shouldLaunchSingleTop() && launchSingleTopInternal(navDestination, bundle);
            if (!z) {
                NavDestination navDestination2 = navDestination;
                navigateInternal(this._navigatorProvider.getNavigator(navDestination.getNavigatorName()), CollectionsKt.listOf(NavBackStackEntry.Companion.create$default(NavBackStackEntry.Companion, this.context, navDestination2, addInDefaultArgs, getHostLifecycleState$navigation_runtime_release(), this.viewModel, (String) null, (Bundle) null, 96, (Object) null)), navOptions2, extras2, new NavController$navigate$4(booleanRef, this, navDestination2, addInDefaultArgs));
            }
        } else {
            booleanRef.element = restoreStateInternal(navDestination.getId(), addInDefaultArgs, navOptions2, extras);
            z = false;
        }
        updateOnBackPressedCallbackEnabled();
        for (NavControllerNavigatorState navigating2 : this.navigatorState.values()) {
            navigating2.setNavigating(false);
        }
        if (popBackStackInternal || booleanRef.element || z) {
            dispatchOnDestinationChanged();
        } else {
            updateBackStackLifecycle$navigation_runtime_release();
        }
    }

    private final boolean launchSingleTopInternal(NavDestination navDestination, Bundle bundle) {
        NavDestination destination;
        int i;
        NavBackStackEntry currentBackStackEntry = getCurrentBackStackEntry();
        int id = navDestination instanceof NavGraph ? NavGraph.Companion.findStartDestination((NavGraph) navDestination).getId() : navDestination.getId();
        if (currentBackStackEntry == null || (destination = currentBackStackEntry.getDestination()) == null || id != destination.getId()) {
            return false;
        }
        ArrayDeque arrayDeque = new ArrayDeque();
        List list = this.backQueue;
        ListIterator listIterator = list.listIterator(list.size());
        while (true) {
            if (listIterator.hasPrevious()) {
                if (((NavBackStackEntry) listIterator.previous()).getDestination() == navDestination) {
                    i = listIterator.nextIndex();
                    break;
                }
            } else {
                i = -1;
                break;
            }
        }
        while (CollectionsKt.getLastIndex(this.backQueue) >= i) {
            NavBackStackEntry removeLast = this.backQueue.removeLast();
            unlinkChildFromParent$navigation_runtime_release(removeLast);
            arrayDeque.addFirst(new NavBackStackEntry(removeLast, removeLast.getDestination().addInDefaultArgs(bundle)));
        }
        Iterable<NavBackStackEntry> iterable = arrayDeque;
        for (NavBackStackEntry navBackStackEntry : iterable) {
            NavGraph parent = navBackStackEntry.getDestination().getParent();
            if (parent != null) {
                linkChildToParent(navBackStackEntry, getBackStackEntry(parent.getId()));
            }
            this.backQueue.add(navBackStackEntry);
        }
        for (NavBackStackEntry navBackStackEntry2 : iterable) {
            this._navigatorProvider.getNavigator(navBackStackEntry2.getDestination().getNavigatorName()).onLaunchSingleTop(navBackStackEntry2);
        }
        return true;
    }

    private final boolean restoreStateInternal(int i, Bundle bundle, NavOptions navOptions, Navigator.Extras extras) {
        if (!this.backStackMap.containsKey(Integer.valueOf(i))) {
            return false;
        }
        String str = this.backStackMap.get(Integer.valueOf(i));
        CollectionsKt.removeAll(this.backStackMap.values(), new NavController$restoreStateInternal$1(str));
        return executeRestoreState(instantiateBackStack((ArrayDeque) TypeIntrinsics.asMutableMap(this.backStackStates).remove(str)), bundle, navOptions, extras);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0059, code lost:
        r0 = (androidx.navigation.NavBackStackEntryState) r1.firstOrNull();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean restoreStateInternal(java.lang.String r6) {
        /*
            r5 = this;
            androidx.navigation.NavDestination$Companion r0 = androidx.navigation.NavDestination.Companion
            java.lang.String r0 = r0.createRoute(r6)
            int r0 = r0.hashCode()
            java.util.Map<java.lang.Integer, java.lang.String> r1 = r5.backStackMap
            java.lang.Integer r2 = java.lang.Integer.valueOf(r0)
            boolean r1 = r1.containsKey(r2)
            r2 = 0
            if (r1 == 0) goto L_0x001c
            boolean r6 = r5.restoreStateInternal(r0, r2, r2, r2)
            return r6
        L_0x001c:
            androidx.navigation.NavDestination r0 = r5.findDestination((java.lang.String) r6)
            if (r0 == 0) goto L_0x0078
            int r1 = r0.getId()
            java.util.Map<java.lang.Integer, java.lang.String> r3 = r5.backStackMap
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            java.lang.Object r1 = r3.get(r1)
            java.lang.String r1 = (java.lang.String) r1
            java.util.Map<java.lang.Integer, java.lang.String> r3 = r5.backStackMap
            java.util.Collection r3 = r3.values()
            java.lang.Iterable r3 = (java.lang.Iterable) r3
            androidx.navigation.NavController$restoreStateInternal$3 r4 = new androidx.navigation.NavController$restoreStateInternal$3
            r4.<init>(r1)
            kotlin.jvm.functions.Function1 r4 = (kotlin.jvm.functions.Function1) r4
            kotlin.collections.CollectionsKt.removeAll(r3, r4)
            java.util.Map<java.lang.String, kotlin.collections.ArrayDeque<androidx.navigation.NavBackStackEntryState>> r3 = r5.backStackStates
            java.util.Map r3 = kotlin.jvm.internal.TypeIntrinsics.asMutableMap(r3)
            java.lang.Object r1 = r3.remove(r1)
            kotlin.collections.ArrayDeque r1 = (kotlin.collections.ArrayDeque) r1
            androidx.navigation.NavDestination$DeepLinkMatch r6 = r0.matchDeepLink((java.lang.String) r6)
            kotlin.jvm.internal.Intrinsics.checkNotNull(r6)
            if (r1 == 0) goto L_0x0066
            java.lang.Object r0 = r1.firstOrNull()
            androidx.navigation.NavBackStackEntryState r0 = (androidx.navigation.NavBackStackEntryState) r0
            if (r0 == 0) goto L_0x0066
            android.os.Bundle r0 = r0.getArgs()
            goto L_0x0067
        L_0x0066:
            r0 = r2
        L_0x0067:
            boolean r6 = r6.hasMatchingArgs(r0)
            if (r6 != 0) goto L_0x006f
            r6 = 0
            return r6
        L_0x006f:
            java.util.List r6 = r5.instantiateBackStack(r1)
            boolean r6 = r5.executeRestoreState(r6, r2, r2, r2)
            return r6
        L_0x0078:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "Restore State failed: route "
            r0.<init>(r1)
            java.lang.StringBuilder r6 = r0.append(r6)
            java.lang.String r0 = " cannot be found from the current destination "
            java.lang.StringBuilder r6 = r6.append(r0)
            androidx.navigation.NavDestination r0 = r5.getCurrentDestination()
            java.lang.StringBuilder r6 = r6.append(r0)
            java.lang.String r6 = r6.toString()
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r6 = r6.toString()
            r0.<init>(r6)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.navigation.NavController.restoreStateInternal(java.lang.String):boolean");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0052, code lost:
        r4 = (r4 = (androidx.navigation.NavBackStackEntry) kotlin.collections.CollectionsKt.last(r3)).getDestination();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean executeRestoreState(java.util.List<androidx.navigation.NavBackStackEntry> r13, android.os.Bundle r14, androidx.navigation.NavOptions r15, androidx.navigation.Navigator.Extras r16) {
        /*
            r12 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.util.List r0 = (java.util.List) r0
            r1 = r13
            java.lang.Iterable r1 = (java.lang.Iterable) r1
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            java.util.Collection r2 = (java.util.Collection) r2
            java.util.Iterator r1 = r1.iterator()
        L_0x0015:
            boolean r3 = r1.hasNext()
            if (r3 == 0) goto L_0x002e
            java.lang.Object r3 = r1.next()
            r4 = r3
            androidx.navigation.NavBackStackEntry r4 = (androidx.navigation.NavBackStackEntry) r4
            androidx.navigation.NavDestination r4 = r4.getDestination()
            boolean r4 = r4 instanceof androidx.navigation.NavGraph
            if (r4 != 0) goto L_0x0015
            r2.add(r3)
            goto L_0x0015
        L_0x002e:
            java.util.List r2 = (java.util.List) r2
            java.lang.Iterable r2 = (java.lang.Iterable) r2
            java.util.Iterator r1 = r2.iterator()
        L_0x0036:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x0083
            java.lang.Object r2 = r1.next()
            androidx.navigation.NavBackStackEntry r2 = (androidx.navigation.NavBackStackEntry) r2
            java.lang.Object r3 = kotlin.collections.CollectionsKt.lastOrNull(r0)
            java.util.List r3 = (java.util.List) r3
            if (r3 == 0) goto L_0x005d
            java.lang.Object r4 = kotlin.collections.CollectionsKt.last(r3)
            androidx.navigation.NavBackStackEntry r4 = (androidx.navigation.NavBackStackEntry) r4
            if (r4 == 0) goto L_0x005d
            androidx.navigation.NavDestination r4 = r4.getDestination()
            if (r4 == 0) goto L_0x005d
            java.lang.String r4 = r4.getNavigatorName()
            goto L_0x005e
        L_0x005d:
            r4 = 0
        L_0x005e:
            androidx.navigation.NavDestination r5 = r2.getDestination()
            java.lang.String r5 = r5.getNavigatorName()
            boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r4, (java.lang.Object) r5)
            if (r4 == 0) goto L_0x0072
            java.util.Collection r3 = (java.util.Collection) r3
            r3.add(r2)
            goto L_0x0036
        L_0x0072:
            r3 = r0
            java.util.Collection r3 = (java.util.Collection) r3
            r4 = 1
            androidx.navigation.NavBackStackEntry[] r4 = new androidx.navigation.NavBackStackEntry[r4]
            r5 = 0
            r4[r5] = r2
            java.util.List r2 = kotlin.collections.CollectionsKt.mutableListOf(r4)
            r3.add(r2)
            goto L_0x0036
        L_0x0083:
            kotlin.jvm.internal.Ref$BooleanRef r5 = new kotlin.jvm.internal.Ref$BooleanRef
            r5.<init>()
            java.util.Iterator r0 = r0.iterator()
        L_0x008c:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x00c6
            java.lang.Object r1 = r0.next()
            java.util.List r1 = (java.util.List) r1
            androidx.navigation.NavigatorProvider r2 = r12._navigatorProvider
            java.lang.Object r3 = kotlin.collections.CollectionsKt.first(r1)
            androidx.navigation.NavBackStackEntry r3 = (androidx.navigation.NavBackStackEntry) r3
            androidx.navigation.NavDestination r3 = r3.getDestination()
            java.lang.String r3 = r3.getNavigatorName()
            androidx.navigation.Navigator r2 = r2.getNavigator((java.lang.String) r3)
            kotlin.jvm.internal.Ref$IntRef r7 = new kotlin.jvm.internal.Ref$IntRef
            r7.<init>()
            androidx.navigation.NavController$executeRestoreState$3 r4 = new androidx.navigation.NavController$executeRestoreState$3
            r8 = r12
            r6 = r13
            r9 = r14
            r4.<init>(r5, r6, r7, r8, r9)
            r11 = r4
            kotlin.jvm.functions.Function1 r11 = (kotlin.jvm.functions.Function1) r11
            r6 = r12
            r9 = r15
            r10 = r16
            r8 = r1
            r7 = r2
            r6.navigateInternal(r7, r8, r9, r10, r11)
            goto L_0x008c
        L_0x00c6:
            boolean r13 = r5.element
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.navigation.NavController.executeRestoreState(java.util.List, android.os.Bundle, androidx.navigation.NavOptions, androidx.navigation.Navigator$Extras):boolean");
    }

    private final List<NavBackStackEntry> instantiateBackStack(ArrayDeque<NavBackStackEntryState> arrayDeque) {
        NavDestination navDestination;
        List<NavBackStackEntry> arrayList = new ArrayList<>();
        NavBackStackEntry lastOrNull = this.backQueue.lastOrNull();
        if (lastOrNull == null || (navDestination = lastOrNull.getDestination()) == null) {
            navDestination = getGraph();
        }
        if (arrayDeque != null) {
            for (NavBackStackEntryState navBackStackEntryState : arrayDeque) {
                NavDestination findDestination = findDestination(navDestination, navBackStackEntryState.getDestinationId());
                if (findDestination != null) {
                    arrayList.add(navBackStackEntryState.instantiate(this.context, findDestination, getHostLifecycleState$navigation_runtime_release(), this.viewModel));
                    navDestination = findDestination;
                } else {
                    throw new IllegalStateException(("Restore State failed: destination " + NavDestination.Companion.getDisplayName(this.context, navBackStackEntryState.getDestinationId()) + " cannot be found from the current destination " + navDestination).toString());
                }
            }
        }
        return arrayList;
    }

    static /* synthetic */ void addEntryToBackStack$default(NavController navController, NavDestination navDestination, Bundle bundle, NavBackStackEntry navBackStackEntry, List list, int i, Object obj) {
        if (obj == null) {
            if ((i & 8) != 0) {
                list = CollectionsKt.emptyList();
            }
            navController.addEntryToBackStack(navDestination, bundle, navBackStackEntry, list);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addEntryToBackStack");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:2:0x000e A[LOOP:0: B:2:0x000e->B:7:0x003e, LOOP_START] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void addEntryToBackStack(androidx.navigation.NavDestination r30, android.os.Bundle r31, androidx.navigation.NavBackStackEntry r32, java.util.List<androidx.navigation.NavBackStackEntry> r33) {
        /*
            r29 = this;
            r0 = r29
            r6 = r30
            r7 = r33
            androidx.navigation.NavDestination r8 = r32.getDestination()
            boolean r1 = r8 instanceof androidx.navigation.FloatingWindow
            if (r1 != 0) goto L_0x0040
        L_0x000e:
            kotlin.collections.ArrayDeque<androidx.navigation.NavBackStackEntry> r1 = r0.backQueue
            boolean r1 = r1.isEmpty()
            if (r1 != 0) goto L_0x0040
            kotlin.collections.ArrayDeque<androidx.navigation.NavBackStackEntry> r1 = r0.backQueue
            java.lang.Object r1 = r1.last()
            androidx.navigation.NavBackStackEntry r1 = (androidx.navigation.NavBackStackEntry) r1
            androidx.navigation.NavDestination r1 = r1.getDestination()
            boolean r1 = r1 instanceof androidx.navigation.FloatingWindow
            if (r1 == 0) goto L_0x0040
            kotlin.collections.ArrayDeque<androidx.navigation.NavBackStackEntry> r1 = r0.backQueue
            java.lang.Object r1 = r1.last()
            androidx.navigation.NavBackStackEntry r1 = (androidx.navigation.NavBackStackEntry) r1
            androidx.navigation.NavDestination r1 = r1.getDestination()
            int r1 = r1.getId()
            r4 = 4
            r5 = 0
            r2 = 1
            r3 = 0
            boolean r1 = popBackStackInternal$default(r0, r1, r2, r3, r4, r5)
            if (r1 != 0) goto L_0x000e
        L_0x0040:
            kotlin.collections.ArrayDeque r1 = new kotlin.collections.ArrayDeque
            r1.<init>()
            boolean r2 = r6 instanceof androidx.navigation.NavGraph
            r17 = 0
            if (r2 == 0) goto L_0x00f1
            r2 = r8
        L_0x004c:
            kotlin.jvm.internal.Intrinsics.checkNotNull(r2)
            androidx.navigation.NavGraph r2 = r2.getParent()
            if (r2 == 0) goto L_0x00da
            int r3 = r7.size()
            java.util.ListIterator r3 = r7.listIterator(r3)
        L_0x005d:
            boolean r4 = r3.hasPrevious()
            if (r4 == 0) goto L_0x0075
            java.lang.Object r4 = r3.previous()
            r5 = r4
            androidx.navigation.NavBackStackEntry r5 = (androidx.navigation.NavBackStackEntry) r5
            androidx.navigation.NavDestination r5 = r5.getDestination()
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r5, (java.lang.Object) r2)
            if (r5 == 0) goto L_0x005d
            goto L_0x0077
        L_0x0075:
            r4 = r17
        L_0x0077:
            androidx.navigation.NavBackStackEntry r4 = (androidx.navigation.NavBackStackEntry) r4
            if (r4 != 0) goto L_0x009b
            androidx.navigation.NavBackStackEntry$Companion r7 = androidx.navigation.NavBackStackEntry.Companion
            r3 = r8
            android.content.Context r8 = r0.context
            r9 = r2
            androidx.navigation.NavDestination r9 = (androidx.navigation.NavDestination) r9
            androidx.lifecycle.Lifecycle$State r11 = r0.getHostLifecycleState$navigation_runtime_release()
            androidx.navigation.NavControllerViewModel r4 = r0.viewModel
            r12 = r4
            androidx.navigation.NavViewModelStoreProvider r12 = (androidx.navigation.NavViewModelStoreProvider) r12
            r15 = 96
            r16 = 0
            r13 = 0
            r14 = 0
            r10 = r31
            r18 = r3
            androidx.navigation.NavBackStackEntry r4 = androidx.navigation.NavBackStackEntry.Companion.create$default(r7, r8, r9, r10, r11, r12, r13, r14, r15, r16)
            goto L_0x009f
        L_0x009b:
            r10 = r31
            r18 = r8
        L_0x009f:
            r1.addFirst(r4)
            kotlin.collections.ArrayDeque<androidx.navigation.NavBackStackEntry> r3 = r0.backQueue
            java.util.Collection r3 = (java.util.Collection) r3
            boolean r3 = r3.isEmpty()
            if (r3 != 0) goto L_0x00d3
            kotlin.collections.ArrayDeque<androidx.navigation.NavBackStackEntry> r3 = r0.backQueue
            java.lang.Object r3 = r3.last()
            androidx.navigation.NavBackStackEntry r3 = (androidx.navigation.NavBackStackEntry) r3
            androidx.navigation.NavDestination r3 = r3.getDestination()
            if (r3 != r2) goto L_0x00d3
            kotlin.collections.ArrayDeque<androidx.navigation.NavBackStackEntry> r3 = r0.backQueue
            java.lang.Object r3 = r3.last()
            androidx.navigation.NavBackStackEntry r3 = (androidx.navigation.NavBackStackEntry) r3
            r4 = 6
            r5 = 0
            r7 = r2
            r2 = 0
            r8 = r1
            r1 = r3
            r3 = 0
            r11 = r7
            r9 = r8
            r7 = r32
            r8 = r33
            popEntryFromBackStack$default(r0, r1, r2, r3, r4, r5)
            goto L_0x00e3
        L_0x00d3:
            r7 = r32
            r8 = r33
            r9 = r1
            r11 = r2
            goto L_0x00e3
        L_0x00da:
            r10 = r31
            r9 = r1
            r11 = r2
            r18 = r8
            r8 = r7
            r7 = r32
        L_0x00e3:
            r2 = r11
            androidx.navigation.NavDestination r2 = (androidx.navigation.NavDestination) r2
            if (r2 == 0) goto L_0x00f9
            if (r2 != r6) goto L_0x00eb
            goto L_0x00f9
        L_0x00eb:
            r7 = r8
            r1 = r9
            r8 = r18
            goto L_0x004c
        L_0x00f1:
            r10 = r31
            r9 = r1
            r18 = r8
            r8 = r7
            r7 = r32
        L_0x00f9:
            boolean r1 = r9.isEmpty()
            if (r1 == 0) goto L_0x0102
            r1 = r18
            goto L_0x010c
        L_0x0102:
            java.lang.Object r1 = r9.first()
            androidx.navigation.NavBackStackEntry r1 = (androidx.navigation.NavBackStackEntry) r1
            androidx.navigation.NavDestination r1 = r1.getDestination()
        L_0x010c:
            if (r1 == 0) goto L_0x017b
            int r2 = r1.getId()
            androidx.navigation.NavDestination r2 = r0.findDestination((int) r2)
            if (r2 == r1) goto L_0x017b
            androidx.navigation.NavGraph r1 = r1.getParent()
            if (r1 == 0) goto L_0x0178
            if (r10 == 0) goto L_0x012a
            boolean r2 = r10.isEmpty()
            r3 = 1
            if (r2 != r3) goto L_0x012a
            r2 = r17
            goto L_0x012b
        L_0x012a:
            r2 = r10
        L_0x012b:
            int r3 = r8.size()
            java.util.ListIterator r3 = r8.listIterator(r3)
        L_0x0133:
            boolean r4 = r3.hasPrevious()
            if (r4 == 0) goto L_0x014b
            java.lang.Object r4 = r3.previous()
            r5 = r4
            androidx.navigation.NavBackStackEntry r5 = (androidx.navigation.NavBackStackEntry) r5
            androidx.navigation.NavDestination r5 = r5.getDestination()
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r5, (java.lang.Object) r1)
            if (r5 == 0) goto L_0x0133
            goto L_0x014d
        L_0x014b:
            r4 = r17
        L_0x014d:
            androidx.navigation.NavBackStackEntry r4 = (androidx.navigation.NavBackStackEntry) r4
            if (r4 != 0) goto L_0x0175
            androidx.navigation.NavBackStackEntry$Companion r19 = androidx.navigation.NavBackStackEntry.Companion
            android.content.Context r3 = r0.context
            r21 = r1
            androidx.navigation.NavDestination r21 = (androidx.navigation.NavDestination) r21
            android.os.Bundle r22 = r1.addInDefaultArgs(r2)
            androidx.lifecycle.Lifecycle$State r23 = r0.getHostLifecycleState$navigation_runtime_release()
            androidx.navigation.NavControllerViewModel r2 = r0.viewModel
            r24 = r2
            androidx.navigation.NavViewModelStoreProvider r24 = (androidx.navigation.NavViewModelStoreProvider) r24
            r27 = 96
            r28 = 0
            r25 = 0
            r26 = 0
            r20 = r3
            androidx.navigation.NavBackStackEntry r4 = androidx.navigation.NavBackStackEntry.Companion.create$default(r19, r20, r21, r22, r23, r24, r25, r26, r27, r28)
        L_0x0175:
            r9.addFirst(r4)
        L_0x0178:
            androidx.navigation.NavDestination r1 = (androidx.navigation.NavDestination) r1
            goto L_0x010c
        L_0x017b:
            boolean r1 = r9.isEmpty()
            if (r1 == 0) goto L_0x0182
            goto L_0x018e
        L_0x0182:
            java.lang.Object r1 = r9.first()
            androidx.navigation.NavBackStackEntry r1 = (androidx.navigation.NavBackStackEntry) r1
            androidx.navigation.NavDestination r1 = r1.getDestination()
            r18 = r1
        L_0x018e:
            kotlin.collections.ArrayDeque<androidx.navigation.NavBackStackEntry> r1 = r0.backQueue
            boolean r1 = r1.isEmpty()
            if (r1 != 0) goto L_0x01d4
            kotlin.collections.ArrayDeque<androidx.navigation.NavBackStackEntry> r1 = r0.backQueue
            java.lang.Object r1 = r1.last()
            androidx.navigation.NavBackStackEntry r1 = (androidx.navigation.NavBackStackEntry) r1
            androidx.navigation.NavDestination r1 = r1.getDestination()
            boolean r1 = r1 instanceof androidx.navigation.NavGraph
            if (r1 == 0) goto L_0x01d4
            kotlin.collections.ArrayDeque<androidx.navigation.NavBackStackEntry> r1 = r0.backQueue
            java.lang.Object r1 = r1.last()
            androidx.navigation.NavBackStackEntry r1 = (androidx.navigation.NavBackStackEntry) r1
            androidx.navigation.NavDestination r1 = r1.getDestination()
            java.lang.String r2 = "null cannot be cast to non-null type androidx.navigation.NavGraph"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1, r2)
            androidx.navigation.NavGraph r1 = (androidx.navigation.NavGraph) r1
            int r2 = r18.getId()
            r3 = 0
            androidx.navigation.NavDestination r1 = r1.findNode((int) r2, (boolean) r3)
            if (r1 != 0) goto L_0x01d4
            kotlin.collections.ArrayDeque<androidx.navigation.NavBackStackEntry> r1 = r0.backQueue
            java.lang.Object r1 = r1.last()
            androidx.navigation.NavBackStackEntry r1 = (androidx.navigation.NavBackStackEntry) r1
            r4 = 6
            r5 = 0
            r2 = 0
            r3 = 0
            popEntryFromBackStack$default(r0, r1, r2, r3, r4, r5)
            goto L_0x018e
        L_0x01d4:
            kotlin.collections.ArrayDeque<androidx.navigation.NavBackStackEntry> r1 = r0.backQueue
            java.lang.Object r1 = r1.firstOrNull()
            androidx.navigation.NavBackStackEntry r1 = (androidx.navigation.NavBackStackEntry) r1
            if (r1 != 0) goto L_0x01e4
            java.lang.Object r1 = r9.firstOrNull()
            androidx.navigation.NavBackStackEntry r1 = (androidx.navigation.NavBackStackEntry) r1
        L_0x01e4:
            if (r1 == 0) goto L_0x01eb
            androidx.navigation.NavDestination r1 = r1.getDestination()
            goto L_0x01ed
        L_0x01eb:
            r1 = r17
        L_0x01ed:
            androidx.navigation.NavGraph r2 = r0._graph
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1, (java.lang.Object) r2)
            if (r1 != 0) goto L_0x0252
            int r1 = r8.size()
            java.util.ListIterator r1 = r8.listIterator(r1)
        L_0x01fd:
            boolean r2 = r1.hasPrevious()
            if (r2 == 0) goto L_0x021b
            java.lang.Object r2 = r1.previous()
            r3 = r2
            androidx.navigation.NavBackStackEntry r3 = (androidx.navigation.NavBackStackEntry) r3
            androidx.navigation.NavDestination r3 = r3.getDestination()
            androidx.navigation.NavGraph r4 = r0._graph
            kotlin.jvm.internal.Intrinsics.checkNotNull(r4)
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) r4)
            if (r3 == 0) goto L_0x01fd
            r17 = r2
        L_0x021b:
            androidx.navigation.NavBackStackEntry r17 = (androidx.navigation.NavBackStackEntry) r17
            if (r17 != 0) goto L_0x024d
            androidx.navigation.NavBackStackEntry$Companion r18 = androidx.navigation.NavBackStackEntry.Companion
            android.content.Context r1 = r0.context
            androidx.navigation.NavGraph r2 = r0._graph
            kotlin.jvm.internal.Intrinsics.checkNotNull(r2)
            r20 = r2
            androidx.navigation.NavDestination r20 = (androidx.navigation.NavDestination) r20
            androidx.navigation.NavGraph r2 = r0._graph
            kotlin.jvm.internal.Intrinsics.checkNotNull(r2)
            android.os.Bundle r21 = r2.addInDefaultArgs(r10)
            androidx.lifecycle.Lifecycle$State r22 = r0.getHostLifecycleState$navigation_runtime_release()
            androidx.navigation.NavControllerViewModel r2 = r0.viewModel
            r23 = r2
            androidx.navigation.NavViewModelStoreProvider r23 = (androidx.navigation.NavViewModelStoreProvider) r23
            r26 = 96
            r27 = 0
            r24 = 0
            r25 = 0
            r19 = r1
            androidx.navigation.NavBackStackEntry r17 = androidx.navigation.NavBackStackEntry.Companion.create$default(r18, r19, r20, r21, r22, r23, r24, r25, r26, r27)
        L_0x024d:
            r1 = r17
            r9.addFirst(r1)
        L_0x0252:
            r1 = r9
            java.lang.Iterable r1 = (java.lang.Iterable) r1
            java.util.Iterator r1 = r1.iterator()
        L_0x0259:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x02a4
            java.lang.Object r2 = r1.next()
            androidx.navigation.NavBackStackEntry r2 = (androidx.navigation.NavBackStackEntry) r2
            androidx.navigation.NavigatorProvider r3 = r0._navigatorProvider
            androidx.navigation.NavDestination r4 = r2.getDestination()
            java.lang.String r4 = r4.getNavigatorName()
            androidx.navigation.Navigator r3 = r3.getNavigator((java.lang.String) r4)
            java.util.Map<androidx.navigation.Navigator<? extends androidx.navigation.NavDestination>, androidx.navigation.NavController$NavControllerNavigatorState> r4 = r0.navigatorState
            java.lang.Object r3 = r4.get(r3)
            if (r3 == 0) goto L_0x0281
            androidx.navigation.NavController$NavControllerNavigatorState r3 = (androidx.navigation.NavController.NavControllerNavigatorState) r3
            r3.addInternal(r2)
            goto L_0x0259
        L_0x0281:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "NavigatorBackStack for "
            r1.<init>(r2)
            java.lang.String r2 = r6.getNavigatorName()
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.String r2 = " should already be created"
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.String r1 = r1.toString()
            java.lang.IllegalStateException r2 = new java.lang.IllegalStateException
            java.lang.String r1 = r1.toString()
            r2.<init>(r1)
            throw r2
        L_0x02a4:
            kotlin.collections.ArrayDeque<androidx.navigation.NavBackStackEntry> r1 = r0.backQueue
            r2 = r9
            java.util.Collection r2 = (java.util.Collection) r2
            r1.addAll(r2)
            kotlin.collections.ArrayDeque<androidx.navigation.NavBackStackEntry> r1 = r0.backQueue
            r1.add(r7)
            java.util.List r1 = kotlin.collections.CollectionsKt.plus(r2, r7)
            java.lang.Iterable r1 = (java.lang.Iterable) r1
            java.util.Iterator r1 = r1.iterator()
        L_0x02bb:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x02dd
            java.lang.Object r2 = r1.next()
            androidx.navigation.NavBackStackEntry r2 = (androidx.navigation.NavBackStackEntry) r2
            androidx.navigation.NavDestination r3 = r2.getDestination()
            androidx.navigation.NavGraph r3 = r3.getParent()
            if (r3 == 0) goto L_0x02bb
            int r3 = r3.getId()
            androidx.navigation.NavBackStackEntry r3 = r0.getBackStackEntry((int) r3)
            r0.linkChildToParent(r2, r3)
            goto L_0x02bb
        L_0x02dd:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.navigation.NavController.addEntryToBackStack(androidx.navigation.NavDestination, android.os.Bundle, androidx.navigation.NavBackStackEntry, java.util.List):void");
    }

    public void navigate(NavDirections navDirections) {
        Intrinsics.checkNotNullParameter(navDirections, "directions");
        navigate(navDirections.getActionId(), navDirections.getArguments(), (NavOptions) null);
    }

    public void navigate(NavDirections navDirections, NavOptions navOptions) {
        Intrinsics.checkNotNullParameter(navDirections, "directions");
        navigate(navDirections.getActionId(), navDirections.getArguments(), navOptions);
    }

    public void navigate(NavDirections navDirections, Navigator.Extras extras) {
        Intrinsics.checkNotNullParameter(navDirections, "directions");
        Intrinsics.checkNotNullParameter(extras, "navigatorExtras");
        navigate(navDirections.getActionId(), navDirections.getArguments(), (NavOptions) null, extras);
    }

    public final void navigate(String str, Function1<? super NavOptionsBuilder, Unit> function1) {
        Intrinsics.checkNotNullParameter(str, "route");
        Intrinsics.checkNotNullParameter(function1, "builder");
        navigate$default(this, str, NavOptionsBuilderKt.navOptions(function1), (Navigator.Extras) null, 4, (Object) null);
    }

    public static /* synthetic */ void navigate$default(NavController navController, String str, NavOptions navOptions, Navigator.Extras extras, int i, Object obj) {
        if (obj == null) {
            if ((i & 2) != 0) {
                navOptions = null;
            }
            if ((i & 4) != 0) {
                extras = null;
            }
            navController.navigate(str, navOptions, extras);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: navigate");
    }

    public final void navigate(String str, NavOptions navOptions, Navigator.Extras extras) {
        Intrinsics.checkNotNullParameter(str, "route");
        NavDeepLinkRequest.Builder.Companion companion = NavDeepLinkRequest.Builder.Companion;
        Uri parse = Uri.parse(NavDestination.Companion.createRoute(str));
        Intrinsics.checkExpressionValueIsNotNull(parse, "Uri.parse(this)");
        navigate(companion.fromUri(parse).build(), navOptions, extras);
    }

    public NavDeepLinkBuilder createDeepLink() {
        return new NavDeepLinkBuilder(this);
    }

    public Bundle saveState() {
        Bundle bundle;
        ArrayList arrayList = new ArrayList();
        Bundle bundle2 = new Bundle();
        for (Map.Entry next : this._navigatorProvider.getNavigators().entrySet()) {
            String str = (String) next.getKey();
            Bundle onSaveState = ((Navigator) next.getValue()).onSaveState();
            if (onSaveState != null) {
                arrayList.add(str);
                bundle2.putBundle(str, onSaveState);
            }
        }
        if (!arrayList.isEmpty()) {
            bundle = new Bundle();
            bundle2.putStringArrayList(KEY_NAVIGATOR_STATE_NAMES, arrayList);
            bundle.putBundle(KEY_NAVIGATOR_STATE, bundle2);
        } else {
            bundle = null;
        }
        if (!this.backQueue.isEmpty()) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            Parcelable[] parcelableArr = new Parcelable[this.backQueue.size()];
            Iterator it = this.backQueue.iterator();
            int i = 0;
            while (it.hasNext()) {
                parcelableArr[i] = new NavBackStackEntryState((NavBackStackEntry) it.next());
                i++;
            }
            bundle.putParcelableArray(KEY_BACK_STACK, parcelableArr);
        }
        if (!this.backStackMap.isEmpty()) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            int[] iArr = new int[this.backStackMap.size()];
            ArrayList arrayList2 = new ArrayList();
            int i2 = 0;
            for (Map.Entry next2 : this.backStackMap.entrySet()) {
                iArr[i2] = ((Number) next2.getKey()).intValue();
                arrayList2.add((String) next2.getValue());
                i2++;
            }
            bundle.putIntArray(KEY_BACK_STACK_DEST_IDS, iArr);
            bundle.putStringArrayList(KEY_BACK_STACK_IDS, arrayList2);
        }
        if (!this.backStackStates.isEmpty()) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            ArrayList arrayList3 = new ArrayList();
            for (Map.Entry next3 : this.backStackStates.entrySet()) {
                String str2 = (String) next3.getKey();
                ArrayDeque arrayDeque = (ArrayDeque) next3.getValue();
                arrayList3.add(str2);
                Parcelable[] parcelableArr2 = new Parcelable[arrayDeque.size()];
                int i3 = 0;
                for (Object next4 : arrayDeque) {
                    int i4 = i3 + 1;
                    if (i3 < 0) {
                        CollectionsKt.throwIndexOverflow();
                    }
                    parcelableArr2[i3] = (NavBackStackEntryState) next4;
                    i3 = i4;
                }
                bundle.putParcelableArray(KEY_BACK_STACK_STATES_PREFIX + str2, parcelableArr2);
            }
            bundle.putStringArrayList(KEY_BACK_STACK_STATES_IDS, arrayList3);
        }
        if (this.deepLinkHandled) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putBoolean(KEY_DEEP_LINK_HANDLED, this.deepLinkHandled);
        }
        return bundle;
    }

    public void restoreState(Bundle bundle) {
        if (bundle != null) {
            bundle.setClassLoader(this.context.getClassLoader());
            this.navigatorStateToRestore = bundle.getBundle(KEY_NAVIGATOR_STATE);
            this.backStackToRestore = bundle.getParcelableArray(KEY_BACK_STACK);
            this.backStackStates.clear();
            int[] intArray = bundle.getIntArray(KEY_BACK_STACK_DEST_IDS);
            ArrayList<String> stringArrayList = bundle.getStringArrayList(KEY_BACK_STACK_IDS);
            if (!(intArray == null || stringArrayList == null)) {
                int length = intArray.length;
                int i = 0;
                int i2 = 0;
                while (i < length) {
                    this.backStackMap.put(Integer.valueOf(intArray[i]), stringArrayList.get(i2));
                    i++;
                    i2++;
                }
            }
            ArrayList<String> stringArrayList2 = bundle.getStringArrayList(KEY_BACK_STACK_STATES_IDS);
            if (stringArrayList2 != null) {
                for (String str : stringArrayList2) {
                    Parcelable[] parcelableArray = bundle.getParcelableArray(KEY_BACK_STACK_STATES_PREFIX + str);
                    if (parcelableArray != null) {
                        Map<String, ArrayDeque<NavBackStackEntryState>> map = this.backStackStates;
                        Intrinsics.checkNotNullExpressionValue(str, "id");
                        ArrayDeque arrayDeque = new ArrayDeque(parcelableArray.length);
                        Iterator it = ArrayIteratorKt.iterator(parcelableArray);
                        while (it.hasNext()) {
                            Parcelable parcelable = (Parcelable) it.next();
                            Intrinsics.checkNotNull(parcelable, "null cannot be cast to non-null type androidx.navigation.NavBackStackEntryState");
                            arrayDeque.add((NavBackStackEntryState) parcelable);
                        }
                        map.put(str, arrayDeque);
                    }
                }
            }
            this.deepLinkHandled = bundle.getBoolean(KEY_DEEP_LINK_HANDLED);
        }
    }

    public void setLifecycleOwner(LifecycleOwner lifecycleOwner2) {
        Lifecycle lifecycle;
        Intrinsics.checkNotNullParameter(lifecycleOwner2, "owner");
        if (!Intrinsics.areEqual((Object) lifecycleOwner2, (Object) this.lifecycleOwner)) {
            LifecycleOwner lifecycleOwner3 = this.lifecycleOwner;
            if (!(lifecycleOwner3 == null || (lifecycle = lifecycleOwner3.getLifecycle()) == null)) {
                lifecycle.removeObserver(this.lifecycleObserver);
            }
            this.lifecycleOwner = lifecycleOwner2;
            lifecycleOwner2.getLifecycle().addObserver(this.lifecycleObserver);
        }
    }

    public void setOnBackPressedDispatcher(OnBackPressedDispatcher onBackPressedDispatcher2) {
        Intrinsics.checkNotNullParameter(onBackPressedDispatcher2, "dispatcher");
        if (!Intrinsics.areEqual((Object) onBackPressedDispatcher2, (Object) this.onBackPressedDispatcher)) {
            LifecycleOwner lifecycleOwner2 = this.lifecycleOwner;
            if (lifecycleOwner2 != null) {
                this.onBackPressedCallback.remove();
                this.onBackPressedDispatcher = onBackPressedDispatcher2;
                onBackPressedDispatcher2.addCallback(lifecycleOwner2, this.onBackPressedCallback);
                Lifecycle lifecycle = lifecycleOwner2.getLifecycle();
                lifecycle.removeObserver(this.lifecycleObserver);
                lifecycle.addObserver(this.lifecycleObserver);
                return;
            }
            throw new IllegalStateException("You must call setLifecycleOwner() before calling setOnBackPressedDispatcher()".toString());
        }
    }

    public void enableOnBackPressed(boolean z) {
        this.enableOnBackPressedCallback = z;
        updateOnBackPressedCallbackEnabled();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x000b, code lost:
        if (getDestinationCountOnBackStack() > 1) goto L_0x000f;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void updateOnBackPressedCallbackEnabled() {
        /*
            r3 = this;
            androidx.activity.OnBackPressedCallback r0 = r3.onBackPressedCallback
            boolean r1 = r3.enableOnBackPressedCallback
            if (r1 == 0) goto L_0x000e
            int r1 = r3.getDestinationCountOnBackStack()
            r2 = 1
            if (r1 <= r2) goto L_0x000e
            goto L_0x000f
        L_0x000e:
            r2 = 0
        L_0x000f:
            r0.setEnabled(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.navigation.NavController.updateOnBackPressedCallbackEnabled():void");
    }

    public void setViewModelStore(ViewModelStore viewModelStore) {
        Intrinsics.checkNotNullParameter(viewModelStore, "viewModelStore");
        if (!Intrinsics.areEqual((Object) this.viewModel, (Object) NavControllerViewModel.Companion.getInstance(viewModelStore))) {
            if (this.backQueue.isEmpty()) {
                this.viewModel = NavControllerViewModel.Companion.getInstance(viewModelStore);
                return;
            }
            throw new IllegalStateException("ViewModelStore should be set before setGraph call".toString());
        }
    }

    public ViewModelStoreOwner getViewModelStoreOwner(int i) {
        if (this.viewModel != null) {
            NavBackStackEntry backStackEntry = getBackStackEntry(i);
            if (backStackEntry.getDestination() instanceof NavGraph) {
                return backStackEntry;
            }
            throw new IllegalArgumentException(("No NavGraph with ID " + i + " is on the NavController's back stack").toString());
        }
        throw new IllegalStateException("You must call setViewModelStore() before calling getViewModelStoreOwner().".toString());
    }

    public NavBackStackEntry getBackStackEntry(int i) {
        Object obj;
        List list = this.backQueue;
        ListIterator listIterator = list.listIterator(list.size());
        while (true) {
            if (!listIterator.hasPrevious()) {
                obj = null;
                break;
            }
            obj = listIterator.previous();
            if (((NavBackStackEntry) obj).getDestination().getId() == i) {
                break;
            }
        }
        NavBackStackEntry navBackStackEntry = (NavBackStackEntry) obj;
        if (navBackStackEntry != null) {
            return navBackStackEntry;
        }
        throw new IllegalArgumentException(("No destination with ID " + i + " is on the NavController's back stack. The current destination is " + getCurrentDestination()).toString());
    }

    public final NavBackStackEntry getBackStackEntry(String str) {
        Object obj;
        Intrinsics.checkNotNullParameter(str, "route");
        List list = this.backQueue;
        ListIterator listIterator = list.listIterator(list.size());
        while (true) {
            if (!listIterator.hasPrevious()) {
                obj = null;
                break;
            }
            obj = listIterator.previous();
            NavBackStackEntry navBackStackEntry = (NavBackStackEntry) obj;
            if (navBackStackEntry.getDestination().hasRoute(str, navBackStackEntry.getArguments())) {
                break;
            }
        }
        NavBackStackEntry navBackStackEntry2 = (NavBackStackEntry) obj;
        if (navBackStackEntry2 != null) {
            return navBackStackEntry2;
        }
        throw new IllegalArgumentException(("No destination with route " + str + " is on the NavController's back stack. The current destination is " + getCurrentDestination()).toString());
    }

    public NavBackStackEntry getCurrentBackStackEntry() {
        return this.backQueue.lastOrNull();
    }

    public final Flow<NavBackStackEntry> getCurrentBackStackEntryFlow() {
        return this.currentBackStackEntryFlow;
    }

    public NavBackStackEntry getPreviousBackStackEntry() {
        Object obj;
        Iterator it = CollectionsKt.reversed(this.backQueue).iterator();
        if (it.hasNext()) {
            it.next();
        }
        Iterator it2 = SequencesKt.asSequence(it).iterator();
        while (true) {
            if (!it2.hasNext()) {
                obj = null;
                break;
            }
            obj = it2.next();
            if (!(((NavBackStackEntry) obj).getDestination() instanceof NavGraph)) {
                break;
            }
        }
        return (NavBackStackEntry) obj;
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0013H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u00020\u00048\u0006XT¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\u00020\u00048\u0006XT¢\u0006\b\n\u0000\u0012\u0004\b\u000b\u0010\u0002R\u0010\u0010\f\u001a\u00020\u00048\u0006XT¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u00020\u00048\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Landroidx/navigation/NavController$Companion;", "", "()V", "KEY_BACK_STACK", "", "KEY_BACK_STACK_DEST_IDS", "KEY_BACK_STACK_IDS", "KEY_BACK_STACK_STATES_IDS", "KEY_BACK_STACK_STATES_PREFIX", "KEY_DEEP_LINK_ARGS", "KEY_DEEP_LINK_EXTRAS", "getKEY_DEEP_LINK_EXTRAS$annotations", "KEY_DEEP_LINK_HANDLED", "KEY_DEEP_LINK_IDS", "KEY_DEEP_LINK_INTENT", "KEY_NAVIGATOR_STATE", "KEY_NAVIGATOR_STATE_NAMES", "TAG", "deepLinkSaveState", "", "enableDeepLinkSaveState", "", "saveState", "navigation-runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: NavController.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ void getKEY_DEEP_LINK_EXTRAS$annotations() {
        }

        private Companion() {
        }

        @JvmStatic
        @NavDeepLinkSaveStateControl
        public final void enableDeepLinkSaveState(boolean z) {
            NavController.deepLinkSaveState = z;
        }
    }
}
