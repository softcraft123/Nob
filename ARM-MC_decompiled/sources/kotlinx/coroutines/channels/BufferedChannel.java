package kotlinx.coroutines.channels;

import androidx.concurrent.futures.AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0;
import com.google.common.primitives.Longs;
import java.util.ArrayList;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.reflect.KFunction;
import kotlin.time.DurationKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.Waiter;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelIterator;
import kotlinx.coroutines.internal.ConcurrentLinkedListKt;
import kotlinx.coroutines.internal.ConcurrentLinkedListNode;
import kotlinx.coroutines.internal.InlineList;
import kotlinx.coroutines.internal.OnUndeliveredElementKt;
import kotlinx.coroutines.internal.Segment;
import kotlinx.coroutines.internal.SegmentOrClosed;
import kotlinx.coroutines.internal.StackTraceRecoveryKt;
import kotlinx.coroutines.internal.Symbol;
import kotlinx.coroutines.internal.UndeliveredElementException;
import kotlinx.coroutines.selects.SelectClause1;
import kotlinx.coroutines.selects.SelectClause1Impl;
import kotlinx.coroutines.selects.SelectClause2;
import kotlinx.coroutines.selects.SelectClause2Impl;
import kotlinx.coroutines.selects.SelectImplementation;
import kotlinx.coroutines.selects.SelectInstance;
import kotlinx.coroutines.selects.TrySelectDetailedResult;

@Metadata(d1 = {"\u0000Ö\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b%\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b1\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0010\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002:\u0004ï\u0001ð\u0001B3\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\"\b\u0002\u0010\u0005\u001a\u001c\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007j\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`\u0006¢\u0006\u0004\b\t\u0010\nJ\u0016\u0010!\u001a\u00020\b2\u0006\u0010\"\u001a\u00028\u0000H@¢\u0006\u0002\u0010#J\u0016\u0010$\u001a\u00020\b2\u0006\u0010\"\u001a\u00028\u0000H@¢\u0006\u0002\u0010#J4\u0010%\u001a\u00020\b2\f\u0010&\u001a\b\u0012\u0004\u0012\u00028\u00000\u001e2\u0006\u0010'\u001a\u00020\u00042\u0006\u0010\"\u001a\u00028\u00002\u0006\u0010(\u001a\u00020\u0011H@¢\u0006\u0002\u0010)J\"\u0010*\u001a\u00020\b*\u00020+2\f\u0010&\u001a\b\u0012\u0004\u0012\u00028\u00000\u001e2\u0006\u0010'\u001a\u00020\u0004H\u0002J#\u0010,\u001a\u00020\b2\u0006\u0010\"\u001a\u00028\u00002\f\u0010-\u001a\b\u0012\u0004\u0012\u00020\b0.H\u0002¢\u0006\u0002\u0010/J\u001d\u00100\u001a\b\u0012\u0004\u0012\u00020\b012\u0006\u0010\"\u001a\u00028\u0000H\u0016¢\u0006\u0004\b2\u00103J\u0018\u00104\u001a\u00020\u001a2\u0006\u0010\"\u001a\u00028\u0000H@¢\u0006\u0004\b5\u0010#Jê\u0001\u00106\u001a\u0002H7\"\u0004\b\u0001\u001072\u0006\u0010\"\u001a\u00028\u00002\b\u00108\u001a\u0004\u0018\u0001092\f\u0010:\u001a\b\u0012\u0004\u0012\u0002H70;2<\u0010<\u001a8\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00028\u00000\u001e¢\u0006\f\b>\u0012\b\b?\u0012\u0004\b\b(@\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b>\u0012\b\b?\u0012\u0004\b\b(A\u0012\u0004\u0012\u0002H70=2\f\u0010B\u001a\b\u0012\u0004\u0012\u0002H70;2h\b\u0002\u0010C\u001ab\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00028\u00000\u001e¢\u0006\f\b>\u0012\b\b?\u0012\u0004\b\b(@\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b>\u0012\b\b?\u0012\u0004\b\b(A\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b>\u0012\b\b?\u0012\u0004\b\b(\"\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b>\u0012\b\b?\u0012\u0004\b\b((\u0012\u0004\u0012\u0002H70DH\b¢\u0006\u0002\u0010EJ\u001d\u0010F\u001a\b\u0012\u0004\u0012\u00020\b012\u0006\u0010\"\u001a\u00028\u0000H\u0004¢\u0006\u0004\bG\u00103JX\u0010H\u001a\u00020\b2\f\u0010&\u001a\b\u0012\u0004\u0012\u00028\u00000\u001e2\u0006\u0010'\u001a\u00020\u00042\u0006\u0010\"\u001a\u00028\u00002\u0006\u0010(\u001a\u00020\u00112\u0006\u00108\u001a\u00020+2\f\u0010:\u001a\b\u0012\u0004\u0012\u00020\b0;2\f\u0010B\u001a\b\u0012\u0004\u0012\u00020\b0;H\b¢\u0006\u0002\u0010IJE\u0010J\u001a\u00020\u00042\f\u0010&\u001a\b\u0012\u0004\u0012\u00028\u00000\u001e2\u0006\u0010'\u001a\u00020\u00042\u0006\u0010\"\u001a\u00028\u00002\u0006\u0010(\u001a\u00020\u00112\b\u00108\u001a\u0004\u0018\u0001092\u0006\u0010K\u001a\u00020\u001aH\u0002¢\u0006\u0002\u0010LJE\u0010M\u001a\u00020\u00042\f\u0010&\u001a\b\u0012\u0004\u0012\u00028\u00000\u001e2\u0006\u0010'\u001a\u00020\u00042\u0006\u0010\"\u001a\u00028\u00002\u0006\u0010(\u001a\u00020\u00112\b\u00108\u001a\u0004\u0018\u0001092\u0006\u0010K\u001a\u00020\u001aH\u0002¢\u0006\u0002\u0010LJ\u0010\u0010N\u001a\u00020\u001a2\u0006\u0010O\u001a\u00020\u0011H\u0003J\u0010\u0010P\u001a\u00020\u001a2\u0006\u0010Q\u001a\u00020\u0011H\u0002J\r\u0010N\u001a\u00020\u001aH\u0010¢\u0006\u0002\bRJ\u0019\u0010S\u001a\u00020\u001a*\u0002092\u0006\u0010\"\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010TJ\b\u0010U\u001a\u00020\bH\u0014J\b\u0010V\u001a\u00020\bH\u0014J\u000e\u0010W\u001a\u00028\u0000H@¢\u0006\u0002\u0010XJ;\u0010Y\u001a\u00118\u0000¢\u0006\f\b>\u0012\b\b?\u0012\u0004\b\b(\"2\f\u0010&\u001a\b\u0012\u0004\u0012\u00028\u00000\u001e2\u0006\u0010'\u001a\u00020\u00042\u0006\u0010Z\u001a\u00020\u0011H@¢\u0006\u0002\u0010[J\"\u0010\\\u001a\u00020\b*\u00020+2\f\u0010&\u001a\b\u0012\u0004\u0012\u00028\u00000\u001e2\u0006\u0010'\u001a\u00020\u0004H\u0002J\u0016\u0010]\u001a\u00020\b2\f\u0010-\u001a\b\u0012\u0004\u0012\u00028\u00000.H\u0002J\u0016\u0010^\u001a\b\u0012\u0004\u0012\u00028\u000001H@¢\u0006\u0004\b_\u0010XJ4\u0010`\u001a\b\u0012\u0004\u0012\u00028\u0000012\f\u0010&\u001a\b\u0012\u0004\u0012\u00028\u00000\u001e2\u0006\u0010'\u001a\u00020\u00042\u0006\u0010Z\u001a\u00020\u0011H@¢\u0006\u0004\ba\u0010[J\u001c\u0010b\u001a\u00020\b2\u0012\u0010-\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u0000010.H\u0002J\u0015\u0010c\u001a\b\u0012\u0004\u0012\u00028\u000001H\u0016¢\u0006\u0004\bd\u0010eJ\u0010\u0010f\u001a\u00020\b2\u0006\u0010g\u001a\u00020\u0011H\u0004J÷\u0001\u0010h\u001a\u0002H7\"\u0004\b\u0001\u001072\b\u00108\u001a\u0004\u0018\u0001092!\u0010i\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b>\u0012\b\b?\u0012\u0004\b\b(\"\u0012\u0004\u0012\u0002H70\u00072Q\u0010<\u001aM\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00028\u00000\u001e¢\u0006\f\b>\u0012\b\b?\u0012\u0004\b\b(@\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b>\u0012\b\b?\u0012\u0004\b\b(A\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b>\u0012\b\b?\u0012\u0004\b\b(Z\u0012\u0004\u0012\u0002H70j2\f\u0010B\u001a\b\u0012\u0004\u0012\u0002H70;2S\b\u0002\u0010C\u001aM\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00028\u00000\u001e¢\u0006\f\b>\u0012\b\b?\u0012\u0004\b\b(@\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b>\u0012\b\b?\u0012\u0004\b\b(A\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b>\u0012\b\b?\u0012\u0004\b\b(Z\u0012\u0004\u0012\u0002H70jH\b¢\u0006\u0002\u0010kJ`\u0010l\u001a\u00020\b2\f\u0010&\u001a\b\u0012\u0004\u0012\u00028\u00000\u001e2\u0006\u0010'\u001a\u00020\u00042\u0006\u0010Z\u001a\u00020\u00112\u0006\u00108\u001a\u00020+2!\u0010i\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b>\u0012\b\b?\u0012\u0004\b\b(\"\u0012\u0004\u0012\u00020\b0\u00072\f\u0010B\u001a\b\u0012\u0004\u0012\u00020\b0;H\bJ2\u0010m\u001a\u0004\u0018\u0001092\f\u0010&\u001a\b\u0012\u0004\u0012\u00028\u00000\u001e2\u0006\u0010'\u001a\u00020\u00042\u0006\u0010Z\u001a\u00020\u00112\b\u00108\u001a\u0004\u0018\u000109H\u0002J2\u0010n\u001a\u0004\u0018\u0001092\f\u0010&\u001a\b\u0012\u0004\u0012\u00028\u00000\u001e2\u0006\u0010'\u001a\u00020\u00042\u0006\u0010Z\u001a\u00020\u00112\b\u00108\u001a\u0004\u0018\u000109H\u0002J\"\u0010o\u001a\u00020\u001a*\u0002092\f\u0010&\u001a\b\u0012\u0004\u0012\u00028\u00000\u001e2\u0006\u0010'\u001a\u00020\u0004H\u0002J\b\u0010p\u001a\u00020\bH\u0002J&\u0010q\u001a\u00020\u001a2\f\u0010&\u001a\b\u0012\u0004\u0012\u00028\u00000\u001e2\u0006\u0010'\u001a\u00020\u00042\u0006\u0010r\u001a\u00020\u0011H\u0002J&\u0010s\u001a\u00020\u001a2\f\u0010&\u001a\b\u0012\u0004\u0012\u00028\u00000\u001e2\u0006\u0010'\u001a\u00020\u00042\u0006\u0010r\u001a\u00020\u0011H\u0002J\u0012\u0010t\u001a\u00020\b2\b\b\u0002\u0010u\u001a\u00020\u0011H\u0002J\u0015\u0010v\u001a\u00020\b2\u0006\u0010w\u001a\u00020\u0011H\u0000¢\u0006\u0002\bxJ \u0010\u001a\u00020\b2\f\u0010\u0001\u001a\u0007\u0012\u0002\b\u00030\u00012\b\u0010\"\u001a\u0004\u0018\u000109H\u0014J%\u0010\u0001\u001a\u00020\b2\u0006\u0010\"\u001a\u00028\u00002\f\u0010\u0001\u001a\u0007\u0012\u0002\b\u00030\u0001H\u0002¢\u0006\u0003\u0010\u0001J!\u0010\u0001\u001a\u0004\u0018\u0001092\t\u0010\u0001\u001a\u0004\u0018\u0001092\t\u0010\u0001\u001a\u0004\u0018\u000109H\u0002J\"\u0010\u0001\u001a\u00020\b2\f\u0010\u0001\u001a\u0007\u0012\u0002\b\u00030\u00012\t\u0010\u0001\u001a\u0004\u0018\u000109H\u0002J\u0017\u0010\u0001\u001a\u00020\b2\f\u0010\u0001\u001a\u0007\u0012\u0002\b\u00030\u0001H\u0002J!\u0010\u0001\u001a\u0004\u0018\u0001092\t\u0010\u0001\u001a\u0004\u0018\u0001092\t\u0010\u0001\u001a\u0004\u0018\u000109H\u0002J!\u0010\u0001\u001a\u0004\u0018\u0001092\t\u0010\u0001\u001a\u0004\u0018\u0001092\t\u0010\u0001\u001a\u0004\u0018\u000109H\u0002J!\u0010\u0001\u001a\u0004\u0018\u0001092\t\u0010\u0001\u001a\u0004\u0018\u0001092\t\u0010\u0001\u001a\u0004\u0018\u000109H\u0002J\u0011\u0010\u0001\u001a\t\u0012\u0004\u0012\u00028\u00000 \u0001H\u0002J\t\u0010ª\u0001\u001a\u00020\bH\u0014J\u0015\u0010«\u0001\u001a\u00020\u001a2\n\u0010¬\u0001\u001a\u0005\u0018\u00010\u0001H\u0016J\u0013\u0010­\u0001\u001a\u00020\u001a2\n\u0010¬\u0001\u001a\u0005\u0018\u00010\u0001J\u0007\u0010­\u0001\u001a\u00020\bJ \u0010­\u0001\u001a\u00020\b2\u0011\u0010¬\u0001\u001a\f\u0018\u00010¯\u0001j\u0005\u0018\u0001`®\u0001¢\u0006\u0003\u0010°\u0001J\u001b\u0010±\u0001\u001a\u00020\u001a2\n\u0010¬\u0001\u001a\u0005\u0018\u00010\u0001H\u0010¢\u0006\u0003\b²\u0001J\u001e\u0010³\u0001\u001a\u00020\u001a2\n\u0010¬\u0001\u001a\u0005\u0018\u00010\u00012\u0007\u0010­\u0001\u001a\u00020\u001aH\u0014J\t\u0010´\u0001\u001a\u00020\bH\u0002J1\u0010µ\u0001\u001a\u00020\b2&\u0010¶\u0001\u001a!\u0012\u0017\u0012\u0015\u0018\u00010\u0001¢\u0006\r\b>\u0012\t\b?\u0012\u0005\b\b(¬\u0001\u0012\u0004\u0012\u00020\b0\u0007H\u0016J\t\u0010·\u0001\u001a\u00020\bH\u0002J\t\u0010¸\u0001\u001a\u00020\bH\u0002J\t\u0010¹\u0001\u001a\u00020\bH\u0002J\t\u0010º\u0001\u001a\u00020\bH\u0002J\u0018\u0010¼\u0001\u001a\b\u0012\u0004\u0012\u00028\u00000\u001e2\u0007\u0010½\u0001\u001a\u00020\u0011H\u0002J\u0012\u0010¾\u0001\u001a\u00020\b2\u0007\u0010½\u0001\u001a\u00020\u0011H\u0002J\u000f\u0010¿\u0001\u001a\b\u0012\u0004\u0012\u00028\u00000\u001eH\u0002J\u0018\u0010À\u0001\u001a\u00020\u00112\r\u0010Á\u0001\u001a\b\u0012\u0004\u0012\u00028\u00000\u001eH\u0002J\u0018\u0010Â\u0001\u001a\u00020\b2\r\u0010Á\u0001\u001a\b\u0012\u0004\u0012\u00028\u00000\u001eH\u0002J \u0010Ã\u0001\u001a\u00020\b2\r\u0010Á\u0001\u001a\b\u0012\u0004\u0012\u00028\u00000\u001e2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\r\u0010Ä\u0001\u001a\u00020\b*\u00020+H\u0002J\r\u0010Å\u0001\u001a\u00020\b*\u00020+H\u0002J\u0016\u0010Æ\u0001\u001a\u00020\b*\u00020+2\u0007\u0010Ç\u0001\u001a\u00020\u001aH\u0002J\u001b\u0010Ï\u0001\u001a\u00020\u001a2\u0007\u0010Ð\u0001\u001a\u00020\u00112\u0007\u0010Ì\u0001\u001a\u00020\u001aH\u0002J\u000f\u0010Ó\u0001\u001a\u00020\u001aH\u0000¢\u0006\u0003\bÔ\u0001J'\u0010Õ\u0001\u001a\u00020\u001a2\f\u0010&\u001a\b\u0012\u0004\u0012\u00028\u00000\u001e2\u0006\u0010'\u001a\u00020\u00042\u0006\u0010w\u001a\u00020\u0011H\u0002J)\u0010Ö\u0001\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u001e2\u0007\u0010×\u0001\u001a\u00020\u00112\r\u0010Ø\u0001\u001a\b\u0012\u0004\u0012\u00028\u00000\u001eH\u0002J)\u0010Ù\u0001\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u001e2\u0007\u0010×\u0001\u001a\u00020\u00112\r\u0010Ø\u0001\u001a\b\u0012\u0004\u0012\u00028\u00000\u001eH\u0002J2\u0010Ú\u0001\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u001e2\u0007\u0010×\u0001\u001a\u00020\u00112\r\u0010Ø\u0001\u001a\b\u0012\u0004\u0012\u00028\u00000\u001e2\u0007\u0010Û\u0001\u001a\u00020\u0011H\u0002J!\u0010Ü\u0001\u001a\u00020\b2\u0007\u0010×\u0001\u001a\u00020\u00112\r\u0010Ø\u0001\u001a\b\u0012\u0004\u0012\u00028\u00000\u001eH\u0002J\u0012\u0010Ý\u0001\u001a\u00020\b2\u0007\u0010Þ\u0001\u001a\u00020\u0011H\u0002J\u0012\u0010ß\u0001\u001a\u00020\b2\u0007\u0010Þ\u0001\u001a\u00020\u0011H\u0002J\n\u0010à\u0001\u001a\u00030á\u0001H\u0016J\u0010\u0010â\u0001\u001a\u00030á\u0001H\u0000¢\u0006\u0003\bã\u0001J\u0007\u0010ä\u0001\u001a\u00020\bJJ\u0010å\u0001\u001a#\u0012\u0005\u0012\u00030\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u000001\u0012\u0005\u0012\u00030\u0001\u0012\u0004\u0012\u00020\b0æ\u0001*\u0018\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00028\u0000`\u0006H\u0002¢\u0006\u0003\u0010ç\u0001J4\u0010è\u0001\u001a\u00020\b2\b\u0010¬\u0001\u001a\u00030\u00012\f\u0010\"\u001a\b\u0012\u0004\u0012\u00028\u0000012\b\u0010é\u0001\u001a\u00030\u0001H\u0002¢\u0006\u0006\bê\u0001\u0010ë\u0001JM\u0010ì\u0001\u001a\u001e\u0012\u0005\u0012\u00030\u0001\u0012\u0006\u0012\u0004\u0018\u000109\u0012\u0005\u0012\u00030\u0001\u0012\u0004\u0012\u00020\b0j*\u0018\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00028\u0000`\u00062\u0006\u0010\"\u001a\u00028\u0000H\u0002¢\u0006\u0003\u0010í\u0001JD\u0010ì\u0001\u001a\u001d\u0012\u0005\u0012\u00030\u0001\u0012\u0004\u0012\u00028\u0000\u0012\u0005\u0012\u00030\u0001\u0012\u0004\u0012\u00020\b0æ\u0001*\u0018\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00028\u0000`\u0006H\u0002¢\u0006\u0003\u0010ç\u0001J+\u0010î\u0001\u001a\u00020\b2\b\u0010¬\u0001\u001a\u00030\u00012\u0006\u0010\"\u001a\u00028\u00002\b\u0010é\u0001\u001a\u00030\u0001H\u0002¢\u0006\u0003\u0010ë\u0001R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R,\u0010\u0005\u001a\u001c\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007j\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`\u00068\u0000X\u0004¢\u0006\u0004\n\u0002\u0010\u000bR\t\u0010\f\u001a\u00020\rX\u0004R\t\u0010\u000e\u001a\u00020\rX\u0004R\t\u0010\u000f\u001a\u00020\rX\u0004R\u0014\u0010\u0010\u001a\u00020\u00118@X\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\u00020\u00118@X\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0013R\u0014\u0010\u0016\u001a\u00020\u00118BX\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0013R\t\u0010\u0018\u001a\u00020\rX\u0004R\u0014\u0010\u0019\u001a\u00020\u001a8BX\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001bR\u0015\u0010\u001c\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u001e0\u001dX\u0004R\u0015\u0010\u001f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u001e0\u001dX\u0004R\u0015\u0010 \u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u001e0\u001dX\u0004R,\u0010y\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00000z8VX\u0004¢\u0006\f\u0012\u0004\b{\u0010|\u001a\u0004\b}\u0010~R%\u0010\u0001\u001a\t\u0012\u0004\u0012\u00028\u00000\u00018VX\u0004¢\u0006\u000f\u0012\u0005\b\u0001\u0010|\u001a\u0006\b\u0001\u0010\u0001R+\u0010\u0001\u001a\u000f\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u0000010\u00018VX\u0004¢\u0006\u000f\u0012\u0005\b\u0001\u0010|\u001a\u0006\b\u0001\u0010\u0001R'\u0010\u0001\u001a\u000b\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u00018VX\u0004¢\u0006\u000f\u0012\u0005\b\u0001\u0010|\u001a\u0006\b\u0001\u0010\u0001R\u0001\u0010\u0001\u001ax\u0012\u0019\u0012\u0017\u0012\u0002\b\u00030\u0001¢\u0006\r\b>\u0012\t\b?\u0012\u0005\b\b(\u0001\u0012\u0016\u0012\u0014\u0018\u000109¢\u0006\r\b>\u0012\t\b?\u0012\u0005\b\b(\u0001\u0012\u0016\u0012\u0014\u0018\u000109¢\u0006\r\b>\u0012\t\b?\u0012\u0005\b\b(\u0001\u0012 \u0012\u001e\u0012\u0005\u0012\u00030\u0001\u0012\u0006\u0012\u0004\u0018\u000109\u0012\u0005\u0012\u00030\u0001\u0012\u0004\u0012\u00020\b0j\u0018\u00010jj\u0005\u0018\u0001`\u0001X\u0004¢\u0006\f\n\u0003\u0010\u0001\u0012\u0005\b\u0001\u0010|R\u0012\u0010¡\u0001\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001090\u001dX\u0004R\u001a\u0010¢\u0001\u001a\u0005\u0018\u00010\u00018DX\u0004¢\u0006\b\u001a\u0006\b£\u0001\u0010¤\u0001R\u0018\u0010¥\u0001\u001a\u00030\u00018DX\u0004¢\u0006\b\u001a\u0006\b¦\u0001\u0010¤\u0001R\u0018\u0010§\u0001\u001a\u00030\u00018BX\u0004¢\u0006\b\u001a\u0006\b¨\u0001\u0010¤\u0001R\u0012\u0010©\u0001\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001090\u001dX\u0004R\u0016\u0010»\u0001\u001a\u00020\u001a8TX\u0004¢\u0006\u0007\u001a\u0005\b»\u0001\u0010\u001bR\u001d\u0010È\u0001\u001a\u00020\u001a8VX\u0004¢\u0006\u000e\u0012\u0005\bÉ\u0001\u0010|\u001a\u0005\bÈ\u0001\u0010\u001bR\u001b\u0010Ê\u0001\u001a\u00020\u001a*\u00020\u00118BX\u0004¢\u0006\b\u001a\u0006\bÊ\u0001\u0010Ë\u0001R\u001d\u0010Ì\u0001\u001a\u00020\u001a8VX\u0004¢\u0006\u000e\u0012\u0005\bÍ\u0001\u0010|\u001a\u0005\bÌ\u0001\u0010\u001bR\u001b\u0010Î\u0001\u001a\u00020\u001a*\u00020\u00118BX\u0004¢\u0006\b\u001a\u0006\bÎ\u0001\u0010Ë\u0001R\u001d\u0010Ñ\u0001\u001a\u00020\u001a8VX\u0004¢\u0006\u000e\u0012\u0005\bÒ\u0001\u0010|\u001a\u0005\bÑ\u0001\u0010\u001b¨\u0006ñ\u0001"}, d2 = {"Lkotlinx/coroutines/channels/BufferedChannel;", "E", "Lkotlinx/coroutines/channels/Channel;", "capacity", "", "onUndeliveredElement", "Lkotlinx/coroutines/internal/OnUndeliveredElement;", "Lkotlin/Function1;", "", "<init>", "(ILkotlin/jvm/functions/Function1;)V", "Lkotlin/jvm/functions/Function1;", "sendersAndCloseStatus", "Lkotlinx/atomicfu/AtomicLong;", "receivers", "bufferEnd", "sendersCounter", "", "getSendersCounter$kotlinx_coroutines_core", "()J", "receiversCounter", "getReceiversCounter$kotlinx_coroutines_core", "bufferEndCounter", "getBufferEndCounter", "completedExpandBuffersAndPauseFlag", "isRendezvousOrUnlimited", "", "()Z", "sendSegment", "Lkotlinx/atomicfu/AtomicRef;", "Lkotlinx/coroutines/channels/ChannelSegment;", "receiveSegment", "bufferEndSegment", "send", "element", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onClosedSend", "sendOnNoWaiterSuspend", "segment", "index", "s", "(Lkotlinx/coroutines/channels/ChannelSegment;ILjava/lang/Object;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "prepareSenderForSuspension", "Lkotlinx/coroutines/Waiter;", "onClosedSendOnNoWaiterSuspend", "cont", "Lkotlinx/coroutines/CancellableContinuation;", "(Ljava/lang/Object;Lkotlinx/coroutines/CancellableContinuation;)V", "trySend", "Lkotlinx/coroutines/channels/ChannelResult;", "trySend-JP2dKIU", "(Ljava/lang/Object;)Ljava/lang/Object;", "sendBroadcast", "sendBroadcast$kotlinx_coroutines_core", "sendImpl", "R", "waiter", "", "onRendezvousOrBuffered", "Lkotlin/Function0;", "onSuspend", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "segm", "i", "onClosed", "onNoWaiterSuspend", "Lkotlin/Function4;", "(Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function4;)Ljava/lang/Object;", "trySendDropOldest", "trySendDropOldest-JP2dKIU", "sendImplOnNoWaiter", "(Lkotlinx/coroutines/channels/ChannelSegment;ILjava/lang/Object;JLkotlinx/coroutines/Waiter;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "updateCellSend", "closed", "(Lkotlinx/coroutines/channels/ChannelSegment;ILjava/lang/Object;JLjava/lang/Object;Z)I", "updateCellSendSlow", "shouldSendSuspend", "curSendersAndCloseStatus", "bufferOrRendezvousSend", "curSenders", "shouldSendSuspend$kotlinx_coroutines_core", "tryResumeReceiver", "(Ljava/lang/Object;Ljava/lang/Object;)Z", "onReceiveEnqueued", "onReceiveDequeued", "receive", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "receiveOnNoWaiterSuspend", "r", "(Lkotlinx/coroutines/channels/ChannelSegment;IJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "prepareReceiverForSuspension", "onClosedReceiveOnNoWaiterSuspend", "receiveCatching", "receiveCatching-JP2dKIU", "receiveCatchingOnNoWaiterSuspend", "receiveCatchingOnNoWaiterSuspend-GKJJFZk", "onClosedReceiveCatchingOnNoWaiterSuspend", "tryReceive", "tryReceive-PtdJZtk", "()Ljava/lang/Object;", "dropFirstElementUntilTheSpecifiedCellIsInTheBuffer", "globalCellIndex", "receiveImpl", "onElementRetrieved", "Lkotlin/Function3;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function3;)Ljava/lang/Object;", "receiveImplOnNoWaiter", "updateCellReceive", "updateCellReceiveSlow", "tryResumeSender", "expandBuffer", "updateCellExpandBuffer", "b", "updateCellExpandBufferSlow", "incCompletedExpandBufferAttempts", "nAttempts", "waitExpandBufferCompletion", "globalIndex", "waitExpandBufferCompletion$kotlinx_coroutines_core", "onSend", "Lkotlinx/coroutines/selects/SelectClause2;", "getOnSend$annotations", "()V", "getOnSend", "()Lkotlinx/coroutines/selects/SelectClause2;", "registerSelectForSend", "select", "Lkotlinx/coroutines/selects/SelectInstance;", "onClosedSelectOnSend", "(Ljava/lang/Object;Lkotlinx/coroutines/selects/SelectInstance;)V", "processResultSelectSend", "ignoredParam", "selectResult", "onReceive", "Lkotlinx/coroutines/selects/SelectClause1;", "getOnReceive$annotations", "getOnReceive", "()Lkotlinx/coroutines/selects/SelectClause1;", "onReceiveCatching", "getOnReceiveCatching$annotations", "getOnReceiveCatching", "onReceiveOrNull", "getOnReceiveOrNull$annotations", "getOnReceiveOrNull", "registerSelectForReceive", "onClosedSelectOnReceive", "processResultSelectReceive", "processResultSelectReceiveOrNull", "processResultSelectReceiveCatching", "onUndeliveredElementReceiveCancellationConstructor", "Lkotlinx/coroutines/selects/OnCancellationConstructor;", "param", "internalResult", "", "Lkotlin/coroutines/CoroutineContext;", "getOnUndeliveredElementReceiveCancellationConstructor$annotations", "Lkotlin/jvm/functions/Function3;", "iterator", "Lkotlinx/coroutines/channels/ChannelIterator;", "_closeCause", "closeCause", "getCloseCause", "()Ljava/lang/Throwable;", "sendException", "getSendException", "receiveException", "getReceiveException", "closeHandler", "onClosedIdempotent", "close", "cause", "cancel", "Lkotlinx/coroutines/CancellationException;", "Ljava/util/concurrent/CancellationException;", "(Ljava/util/concurrent/CancellationException;)V", "cancelImpl", "cancelImpl$kotlinx_coroutines_core", "closeOrCancelImpl", "invokeCloseHandler", "invokeOnClose", "handler", "markClosed", "markCancelled", "markCancellationStarted", "completeCloseOrCancel", "isConflatedDropOldest", "completeClose", "sendersCur", "completeCancel", "closeLinkedList", "markAllEmptyCellsAsClosed", "lastSegment", "removeUnprocessedElements", "cancelSuspendedReceiveRequests", "resumeReceiverOnClosedChannel", "resumeSenderOnCancelledChannel", "resumeWaiterOnClosedChannel", "receiver", "isClosedForSend", "isClosedForSend$annotations", "isClosedForSend0", "(J)Z", "isClosedForReceive", "isClosedForReceive$annotations", "isClosedForReceive0", "isClosed", "sendersAndCloseStatusCur", "isEmpty", "isEmpty$annotations", "hasElements", "hasElements$kotlinx_coroutines_core", "isCellNonEmpty", "findSegmentSend", "id", "startFrom", "findSegmentReceive", "findSegmentBufferEnd", "currentBufferEndCounter", "moveSegmentBufferEndToSpecifiedOrLast", "updateSendersCounterIfLower", "value", "updateReceiversCounterIfLower", "toString", "", "toStringDebug", "toStringDebug$kotlinx_coroutines_core", "checkSegmentStructureInvariants", "bindCancellationFunResult", "Lkotlin/reflect/KFunction3;", "(Lkotlin/jvm/functions/Function1;)Lkotlin/reflect/KFunction;", "onCancellationChannelResultImplDoNotCall", "context", "onCancellationChannelResultImplDoNotCall-5_sEAP8", "(Ljava/lang/Throwable;Ljava/lang/Object;Lkotlin/coroutines/CoroutineContext;)V", "bindCancellationFun", "(Lkotlin/jvm/functions/Function1;Ljava/lang/Object;)Lkotlin/jvm/functions/Function3;", "onCancellationImplDoNotCall", "SendBroadcast", "BufferedChannelIterator", "kotlinx-coroutines-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* compiled from: BufferedChannel.kt */
public class BufferedChannel<E> implements Channel<E> {
    /* access modifiers changed from: private */
    public static final /* synthetic */ AtomicReferenceFieldUpdater _closeCause$volatile$FU;
    /* access modifiers changed from: private */
    public static final /* synthetic */ AtomicLongFieldUpdater bufferEnd$volatile$FU;
    /* access modifiers changed from: private */
    public static final /* synthetic */ AtomicReferenceFieldUpdater bufferEndSegment$volatile$FU;
    /* access modifiers changed from: private */
    public static final /* synthetic */ AtomicReferenceFieldUpdater closeHandler$volatile$FU;
    /* access modifiers changed from: private */
    public static final /* synthetic */ AtomicLongFieldUpdater completedExpandBuffersAndPauseFlag$volatile$FU;
    /* access modifiers changed from: private */
    public static final /* synthetic */ AtomicReferenceFieldUpdater receiveSegment$volatile$FU;
    /* access modifiers changed from: private */
    public static final /* synthetic */ AtomicLongFieldUpdater receivers$volatile$FU;
    /* access modifiers changed from: private */
    public static final /* synthetic */ AtomicReferenceFieldUpdater sendSegment$volatile$FU;
    /* access modifiers changed from: private */
    public static final /* synthetic */ AtomicLongFieldUpdater sendersAndCloseStatus$volatile$FU;
    private volatile /* synthetic */ Object _closeCause$volatile;
    private volatile /* synthetic */ long bufferEnd$volatile;
    private volatile /* synthetic */ Object bufferEndSegment$volatile;
    private final int capacity;
    private volatile /* synthetic */ Object closeHandler$volatile;
    private volatile /* synthetic */ long completedExpandBuffersAndPauseFlag$volatile;
    public final Function1<E, Unit> onUndeliveredElement;
    private final Function3<SelectInstance<?>, Object, Object, Function3<Throwable, Object, CoroutineContext, Unit>> onUndeliveredElementReceiveCancellationConstructor;
    private volatile /* synthetic */ Object receiveSegment$volatile;
    private volatile /* synthetic */ long receivers$volatile;
    private volatile /* synthetic */ Object sendSegment$volatile;
    private volatile /* synthetic */ long sendersAndCloseStatus$volatile;

    static {
        Class<BufferedChannel> cls = BufferedChannel.class;
        sendersAndCloseStatus$volatile$FU = AtomicLongFieldUpdater.newUpdater(cls, "sendersAndCloseStatus$volatile");
        receivers$volatile$FU = AtomicLongFieldUpdater.newUpdater(cls, "receivers$volatile");
        bufferEnd$volatile$FU = AtomicLongFieldUpdater.newUpdater(cls, "bufferEnd$volatile");
        completedExpandBuffersAndPauseFlag$volatile$FU = AtomicLongFieldUpdater.newUpdater(cls, "completedExpandBuffersAndPauseFlag$volatile");
        sendSegment$volatile$FU = AtomicReferenceFieldUpdater.newUpdater(cls, Object.class, "sendSegment$volatile");
        receiveSegment$volatile$FU = AtomicReferenceFieldUpdater.newUpdater(cls, Object.class, "receiveSegment$volatile");
        bufferEndSegment$volatile$FU = AtomicReferenceFieldUpdater.newUpdater(cls, Object.class, "bufferEndSegment$volatile");
        _closeCause$volatile$FU = AtomicReferenceFieldUpdater.newUpdater(cls, Object.class, "_closeCause$volatile");
        closeHandler$volatile$FU = AtomicReferenceFieldUpdater.newUpdater(cls, Object.class, "closeHandler$volatile");
    }

    private final /* synthetic */ Object getAndUpdate$atomicfu(Object obj, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, Function1<Object, ? extends Object> function1) {
        Object obj2;
        do {
            obj2 = atomicReferenceFieldUpdater.get(obj);
        } while (!AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(atomicReferenceFieldUpdater, obj, obj2, function1.invoke(obj2)));
        return obj2;
    }

    private final /* synthetic */ long getBufferEnd$volatile() {
        return this.bufferEnd$volatile;
    }

    private final /* synthetic */ Object getBufferEndSegment$volatile() {
        return this.bufferEndSegment$volatile;
    }

    private final /* synthetic */ Object getCloseHandler$volatile() {
        return this.closeHandler$volatile;
    }

    private final /* synthetic */ long getCompletedExpandBuffersAndPauseFlag$volatile() {
        return this.completedExpandBuffersAndPauseFlag$volatile;
    }

    public static /* synthetic */ void getOnReceive$annotations() {
    }

    public static /* synthetic */ void getOnReceiveCatching$annotations() {
    }

    public static /* synthetic */ void getOnReceiveOrNull$annotations() {
    }

    public static /* synthetic */ void getOnSend$annotations() {
    }

    private static /* synthetic */ void getOnUndeliveredElementReceiveCancellationConstructor$annotations() {
    }

    private final /* synthetic */ Object getReceiveSegment$volatile() {
        return this.receiveSegment$volatile;
    }

    private final /* synthetic */ long getReceivers$volatile() {
        return this.receivers$volatile;
    }

    private final /* synthetic */ Object getSendSegment$volatile() {
        return this.sendSegment$volatile;
    }

    private final /* synthetic */ long getSendersAndCloseStatus$volatile() {
        return this.sendersAndCloseStatus$volatile;
    }

    private final /* synthetic */ Object get_closeCause$volatile() {
        return this._closeCause$volatile;
    }

    public static /* synthetic */ void isClosedForReceive$annotations() {
    }

    public static /* synthetic */ void isClosedForSend$annotations() {
    }

    public static /* synthetic */ void isEmpty$annotations() {
    }

    private final /* synthetic */ void loop$atomicfu(Object obj, AtomicLongFieldUpdater atomicLongFieldUpdater, Function1<? super Long, Unit> function1) {
        while (true) {
            function1.invoke(Long.valueOf(atomicLongFieldUpdater.get(obj)));
        }
    }

    private final /* synthetic */ void loop$atomicfu(Object obj, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, Function1<Object, Unit> function1) {
        while (true) {
            function1.invoke(atomicReferenceFieldUpdater.get(obj));
        }
    }

    private final /* synthetic */ void setBufferEnd$volatile(long j) {
        this.bufferEnd$volatile = j;
    }

    private final /* synthetic */ void setBufferEndSegment$volatile(Object obj) {
        this.bufferEndSegment$volatile = obj;
    }

    private final /* synthetic */ void setCloseHandler$volatile(Object obj) {
        this.closeHandler$volatile = obj;
    }

    private final /* synthetic */ void setCompletedExpandBuffersAndPauseFlag$volatile(long j) {
        this.completedExpandBuffersAndPauseFlag$volatile = j;
    }

    private final /* synthetic */ void setReceiveSegment$volatile(Object obj) {
        this.receiveSegment$volatile = obj;
    }

    private final /* synthetic */ void setReceivers$volatile(long j) {
        this.receivers$volatile = j;
    }

    private final /* synthetic */ void setSendSegment$volatile(Object obj) {
        this.sendSegment$volatile = obj;
    }

    private final /* synthetic */ void setSendersAndCloseStatus$volatile(long j) {
        this.sendersAndCloseStatus$volatile = j;
    }

    private final /* synthetic */ void set_closeCause$volatile(Object obj) {
        this._closeCause$volatile = obj;
    }

    private final /* synthetic */ void update$atomicfu(Object obj, AtomicLongFieldUpdater atomicLongFieldUpdater, Function1<? super Long, Long> function1) {
        while (true) {
            long j = atomicLongFieldUpdater.get(obj);
            Object obj2 = obj;
            AtomicLongFieldUpdater atomicLongFieldUpdater2 = atomicLongFieldUpdater;
            if (!atomicLongFieldUpdater2.compareAndSet(obj2, j, function1.invoke(Long.valueOf(j)).longValue())) {
                atomicLongFieldUpdater = atomicLongFieldUpdater2;
                obj = obj2;
            } else {
                return;
            }
        }
    }

    /* access modifiers changed from: protected */
    public boolean isConflatedDropOldest() {
        return false;
    }

    /* access modifiers changed from: protected */
    public void onClosedIdempotent() {
    }

    /* access modifiers changed from: protected */
    public void onReceiveDequeued() {
    }

    /* access modifiers changed from: protected */
    public void onReceiveEnqueued() {
    }

    public Object receive(Continuation<? super E> continuation) {
        return receive$suspendImpl(this, continuation);
    }

    /* renamed from: receiveCatching-JP2dKIU  reason: not valid java name */
    public Object m2038receiveCatchingJP2dKIU(Continuation<? super ChannelResult<? extends E>> continuation) {
        return m2036receiveCatchingJP2dKIU$suspendImpl(this, continuation);
    }

    public Object send(E e, Continuation<? super Unit> continuation) {
        return send$suspendImpl(this, e, continuation);
    }

    public Object sendBroadcast$kotlinx_coroutines_core(E e, Continuation<? super Boolean> continuation) {
        return sendBroadcast$suspendImpl(this, e, continuation);
    }

    public BufferedChannel(int i, Function1<? super E, Unit> function1) {
        this.capacity = i;
        this.onUndeliveredElement = function1;
        if (i >= 0) {
            this.bufferEnd$volatile = BufferedChannelKt.initialBufferEnd(i);
            this.completedExpandBuffersAndPauseFlag$volatile = getBufferEndCounter();
            ChannelSegment channelSegment = new ChannelSegment(0, (ChannelSegment) null, this, 3);
            this.sendSegment$volatile = channelSegment;
            this.receiveSegment$volatile = channelSegment;
            if (isRendezvousOrUnlimited()) {
                channelSegment = BufferedChannelKt.NULL_SEGMENT;
                Intrinsics.checkNotNull(channelSegment, "null cannot be cast to non-null type kotlinx.coroutines.channels.ChannelSegment<E of kotlinx.coroutines.channels.BufferedChannel>");
            }
            this.bufferEndSegment$volatile = channelSegment;
            this.onUndeliveredElementReceiveCancellationConstructor = function1 != null ? new BufferedChannel$$ExternalSyntheticLambda1(this) : null;
            this._closeCause$volatile = BufferedChannelKt.NO_CLOSE_CAUSE;
            return;
        }
        throw new IllegalArgumentException(("Invalid channel capacity: " + i + ", should be >=0").toString());
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ BufferedChannel(int i, Function1 function1, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, (i2 & 2) != 0 ? null : function1);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Deprecated in the favour of 'trySend' method", replaceWith = @ReplaceWith(expression = "trySend(element).isSuccess", imports = {}))
    public boolean offer(E e) {
        return Channel.DefaultImpls.offer(this, e);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Deprecated in the favour of 'tryReceive'. Please note that the provided replacement does not rethrow channel's close cause as 'poll' did, for the precise replacement please refer to the 'poll' documentation", replaceWith = @ReplaceWith(expression = "tryReceive().getOrNull()", imports = {}))
    public E poll() {
        return Channel.DefaultImpls.poll(this);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Deprecated in favor of 'receiveCatching'. Please note that the provided replacement does not rethrow channel's close cause as 'receiveOrNull' did, for the detailed replacement please refer to the 'receiveOrNull' documentation", replaceWith = @ReplaceWith(expression = "receiveCatching().getOrNull()", imports = {}))
    public Object receiveOrNull(Continuation<? super E> continuation) {
        return Channel.DefaultImpls.receiveOrNull(this, continuation);
    }

    public final long getSendersCounter$kotlinx_coroutines_core() {
        return sendersAndCloseStatus$volatile$FU.get(this) & 1152921504606846975L;
    }

    public final long getReceiversCounter$kotlinx_coroutines_core() {
        return receivers$volatile$FU.get(this);
    }

    private final long getBufferEndCounter() {
        return bufferEnd$volatile$FU.get(this);
    }

    private final boolean isRendezvousOrUnlimited() {
        long bufferEndCounter = getBufferEndCounter();
        return bufferEndCounter == 0 || bufferEndCounter == Long.MAX_VALUE;
    }

    static /* synthetic */ <E> Object send$suspendImpl(BufferedChannel<E> bufferedChannel, E e, Continuation<? super Unit> continuation) {
        ChannelSegment channelSegment;
        ChannelSegment channelSegment2 = (ChannelSegment) sendSegment$volatile$FU.get(bufferedChannel);
        while (true) {
            long andIncrement = sendersAndCloseStatus$volatile$FU.getAndIncrement(bufferedChannel);
            long j = andIncrement & 1152921504606846975L;
            boolean access$isClosedForSend0 = bufferedChannel.isClosedForSend0(andIncrement);
            long j2 = j / ((long) BufferedChannelKt.SEGMENT_SIZE);
            int i = (int) (j % ((long) BufferedChannelKt.SEGMENT_SIZE));
            if (channelSegment2.id != j2) {
                ChannelSegment access$findSegmentSend = bufferedChannel.findSegmentSend(j2, channelSegment2);
                if (access$findSegmentSend != null) {
                    channelSegment = access$findSegmentSend;
                } else if (access$isClosedForSend0) {
                    Object onClosedSend = bufferedChannel.onClosedSend(e, continuation);
                    if (onClosedSend == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                        return onClosedSend;
                    }
                }
            } else {
                channelSegment = channelSegment2;
            }
            BufferedChannel<E> bufferedChannel2 = bufferedChannel;
            E e2 = e;
            int access$updateCellSend = bufferedChannel2.updateCellSend(channelSegment, i, e2, j, (Object) null, access$isClosedForSend0);
            if (access$updateCellSend == 0) {
                channelSegment.cleanPrev();
                break;
            } else if (access$updateCellSend == 1) {
                break;
            } else if (access$updateCellSend == 2) {
                Continuation<? super Unit> continuation2 = continuation;
                if (access$isClosedForSend0) {
                    channelSegment.onSlotCleaned();
                    Object onClosedSend2 = bufferedChannel2.onClosedSend(e2, continuation2);
                    if (onClosedSend2 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                        return onClosedSend2;
                    }
                } else if (DebugKt.getASSERTIONS_ENABLED()) {
                    throw new AssertionError();
                }
            } else if (access$updateCellSend == 3) {
                Object sendOnNoWaiterSuspend = bufferedChannel2.sendOnNoWaiterSuspend(channelSegment, i, e2, j, continuation);
                if (sendOnNoWaiterSuspend == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                    return sendOnNoWaiterSuspend;
                }
            } else if (access$updateCellSend != 4) {
                if (access$updateCellSend == 5) {
                    channelSegment.cleanPrev();
                }
                bufferedChannel = bufferedChannel2;
                channelSegment2 = channelSegment;
                e = e2;
            } else {
                if (j < bufferedChannel2.getReceiversCounter$kotlinx_coroutines_core()) {
                    channelSegment.cleanPrev();
                }
                Object onClosedSend3 = bufferedChannel2.onClosedSend(e2, continuation);
                if (onClosedSend3 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                    return onClosedSend3;
                }
            }
        }
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public final void prepareSenderForSuspension(Waiter waiter, ChannelSegment<E> channelSegment, int i) {
        waiter.invokeOnCancellation(channelSegment, i + BufferedChannelKt.SEGMENT_SIZE);
    }

    /* access modifiers changed from: private */
    public final void onClosedSendOnNoWaiterSuspend(E e, CancellableContinuation<? super Unit> cancellableContinuation) {
        Function1<E, Unit> function1 = this.onUndeliveredElement;
        if (function1 != null) {
            OnUndeliveredElementKt.callUndeliveredElement(function1, e, cancellableContinuation.getContext());
        }
        Continuation continuation = cancellableContinuation;
        Throwable sendException = getSendException();
        if (DebugKt.getRECOVER_STACK_TRACES() && (continuation instanceof CoroutineStackFrame)) {
            sendException = StackTraceRecoveryKt.recoverFromStackFrame(sendException, (CoroutineStackFrame) continuation);
        }
        Result.Companion companion = Result.Companion;
        continuation.resumeWith(Result.m516constructorimpl(ResultKt.createFailure(sendException)));
    }

    /* renamed from: trySend-JP2dKIU  reason: not valid java name */
    public Object m2040trySendJP2dKIU(E e) {
        int i;
        ChannelSegment channelSegment;
        BufferedChannel bufferedChannel;
        if (shouldSendSuspend(sendersAndCloseStatus$volatile$FU.get(this))) {
            return ChannelResult.Companion.m2064failurePtdJZtk();
        }
        Symbol access$getINTERRUPTED_SEND$p = BufferedChannelKt.INTERRUPTED_SEND;
        ChannelSegment channelSegment2 = (ChannelSegment) sendSegment$volatile$FU.get(this);
        while (true) {
            long andIncrement = sendersAndCloseStatus$volatile$FU.getAndIncrement(this);
            long j = andIncrement & 1152921504606846975L;
            boolean access$isClosedForSend0 = isClosedForSend0(andIncrement);
            long j2 = j / ((long) BufferedChannelKt.SEGMENT_SIZE);
            int i2 = (int) (j % ((long) BufferedChannelKt.SEGMENT_SIZE));
            if (channelSegment2.id != j2) {
                channelSegment = findSegmentSend(j2, channelSegment2);
                if (channelSegment != null) {
                    bufferedChannel = this;
                    i = i2;
                } else if (access$isClosedForSend0) {
                    return ChannelResult.Companion.m2063closedJP2dKIU(getSendException());
                }
            } else {
                channelSegment = channelSegment2;
                i = i2;
                bufferedChannel = this;
            }
            E e2 = e;
            int access$updateCellSend = bufferedChannel.updateCellSend(channelSegment, i, e2, j, access$getINTERRUPTED_SEND$p, access$isClosedForSend0);
            ChannelSegment channelSegment3 = channelSegment;
            BufferedChannel bufferedChannel2 = bufferedChannel;
            channelSegment2 = channelSegment3;
            if (access$updateCellSend == 0) {
                channelSegment2.cleanPrev();
                return ChannelResult.Companion.m2065successJP2dKIU(Unit.INSTANCE);
            } else if (access$updateCellSend == 1) {
                return ChannelResult.Companion.m2065successJP2dKIU(Unit.INSTANCE);
            } else {
                if (access$updateCellSend != 2) {
                    if (access$updateCellSend == 3) {
                        throw new IllegalStateException("unexpected".toString());
                    } else if (access$updateCellSend != 4) {
                        if (access$updateCellSend == 5) {
                            channelSegment2.cleanPrev();
                        }
                        e = e2;
                    } else {
                        if (j < getReceiversCounter$kotlinx_coroutines_core()) {
                            channelSegment2.cleanPrev();
                        }
                        return ChannelResult.Companion.m2063closedJP2dKIU(getSendException());
                    }
                } else if (access$isClosedForSend0) {
                    channelSegment2.onSlotCleaned();
                    return ChannelResult.Companion.m2063closedJP2dKIU(getSendException());
                } else {
                    Waiter waiter = access$getINTERRUPTED_SEND$p instanceof Waiter ? (Waiter) access$getINTERRUPTED_SEND$p : null;
                    if (waiter != null) {
                        prepareSenderForSuspension(waiter, channelSegment2, i);
                    }
                    channelSegment2.onSlotCleaned();
                    return ChannelResult.Companion.m2064failurePtdJZtk();
                }
            }
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u001d\u0010\t\u001a\u00020\n2\n\u0010\u000b\u001a\u0006\u0012\u0002\b\u00030\f2\u0006\u0010\r\u001a\u00020\u000eH\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u000f"}, d2 = {"Lkotlinx/coroutines/channels/BufferedChannel$SendBroadcast;", "Lkotlinx/coroutines/Waiter;", "cont", "Lkotlinx/coroutines/CancellableContinuation;", "", "<init>", "(Lkotlinx/coroutines/CancellableContinuation;)V", "getCont", "()Lkotlinx/coroutines/CancellableContinuation;", "invokeOnCancellation", "", "segment", "Lkotlinx/coroutines/internal/Segment;", "index", "", "kotlinx-coroutines-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* compiled from: BufferedChannel.kt */
    private static final class SendBroadcast implements Waiter {
        private final /* synthetic */ CancellableContinuationImpl<Boolean> $$delegate_0;
        private final CancellableContinuation<Boolean> cont;

        public void invokeOnCancellation(Segment<?> segment, int i) {
            this.$$delegate_0.invokeOnCancellation(segment, i);
        }

        public SendBroadcast(CancellableContinuation<? super Boolean> cancellableContinuation) {
            Intrinsics.checkNotNull(cancellableContinuation, "null cannot be cast to non-null type kotlinx.coroutines.CancellableContinuationImpl<kotlin.Boolean>");
            this.$$delegate_0 = (CancellableContinuationImpl) cancellableContinuation;
            this.cont = cancellableContinuation;
        }

        public final CancellableContinuation<Boolean> getCont() {
            return this.cont;
        }
    }

    static /* synthetic */ Object sendImpl$default(BufferedChannel bufferedChannel, Object obj, Object obj2, Function0 function0, Function2 function2, Function0 function02, Function4 function4, int i, Object obj3) {
        Function4 function42;
        if (obj3 == null) {
            if ((i & 32) != 0) {
                function42 = BufferedChannel$sendImpl$1.INSTANCE;
            } else {
                function42 = function4;
            }
            ChannelSegment channelSegment = (ChannelSegment) sendSegment$volatile$FU.get(bufferedChannel);
            while (true) {
                long andIncrement = sendersAndCloseStatus$volatile$FU.getAndIncrement(bufferedChannel);
                long j = 1152921504606846975L & andIncrement;
                boolean access$isClosedForSend0 = bufferedChannel.isClosedForSend0(andIncrement);
                long j2 = j / ((long) BufferedChannelKt.SEGMENT_SIZE);
                int i2 = (int) (j % ((long) BufferedChannelKt.SEGMENT_SIZE));
                if (channelSegment.id != j2) {
                    ChannelSegment access$findSegmentSend = bufferedChannel.findSegmentSend(j2, channelSegment);
                    if (access$findSegmentSend != null) {
                        channelSegment = access$findSegmentSend;
                    } else if (access$isClosedForSend0) {
                        return function02.invoke();
                    }
                }
                int i3 = i2;
                int access$updateCellSend = bufferedChannel.updateCellSend(channelSegment, i3, obj, j, obj2, access$isClosedForSend0);
                if (access$updateCellSend == 0) {
                    channelSegment.cleanPrev();
                    return function0.invoke();
                } else if (access$updateCellSend == 1) {
                    return function0.invoke();
                } else {
                    if (access$updateCellSend != 2) {
                        if (access$updateCellSend == 3) {
                            return function42.invoke(channelSegment, Integer.valueOf(i3), obj, Long.valueOf(j));
                        }
                        if (access$updateCellSend == 4) {
                            if (j < bufferedChannel.getReceiversCounter$kotlinx_coroutines_core()) {
                                channelSegment.cleanPrev();
                            }
                            return function02.invoke();
                        } else if (access$updateCellSend == 5) {
                            channelSegment.cleanPrev();
                        }
                    } else if (access$isClosedForSend0) {
                        channelSegment.onSlotCleaned();
                        return function02.invoke();
                    } else {
                        Waiter waiter = obj2 instanceof Waiter ? (Waiter) obj2 : null;
                        if (waiter != null) {
                            bufferedChannel.prepareSenderForSuspension(waiter, channelSegment, i3);
                        }
                        return function2.invoke(channelSegment, Integer.valueOf(i3));
                    }
                }
            }
        } else {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: sendImpl");
        }
    }

    private final <R> R sendImpl(E e, Object obj, Function0<? extends R> function0, Function2<? super ChannelSegment<E>, ? super Integer, ? extends R> function2, Function0<? extends R> function02, Function4<? super ChannelSegment<E>, ? super Integer, ? super E, ? super Long, ? extends R> function4) {
        ChannelSegment channelSegment = (ChannelSegment) sendSegment$volatile$FU.get(this);
        while (true) {
            long andIncrement = sendersAndCloseStatus$volatile$FU.getAndIncrement(this);
            long j = 1152921504606846975L & andIncrement;
            boolean access$isClosedForSend0 = isClosedForSend0(andIncrement);
            long j2 = j / ((long) BufferedChannelKt.SEGMENT_SIZE);
            int i = (int) (j % ((long) BufferedChannelKt.SEGMENT_SIZE));
            if (channelSegment.id != j2) {
                ChannelSegment access$findSegmentSend = findSegmentSend(j2, channelSegment);
                if (access$findSegmentSend != null) {
                    channelSegment = access$findSegmentSend;
                } else if (access$isClosedForSend0) {
                    return function02.invoke();
                }
            }
            int i2 = i;
            int access$updateCellSend = updateCellSend(channelSegment, i2, e, j, obj, access$isClosedForSend0);
            if (access$updateCellSend == 0) {
                channelSegment.cleanPrev();
                return function0.invoke();
            } else if (access$updateCellSend == 1) {
                return function0.invoke();
            } else {
                if (access$updateCellSend != 2) {
                    if (access$updateCellSend == 3) {
                        return function4.invoke(channelSegment, Integer.valueOf(i2), e, Long.valueOf(j));
                    } else if (access$updateCellSend == 4) {
                        if (j < getReceiversCounter$kotlinx_coroutines_core()) {
                            channelSegment.cleanPrev();
                        }
                        return function02.invoke();
                    } else if (access$updateCellSend == 5) {
                        channelSegment.cleanPrev();
                    }
                } else if (access$isClosedForSend0) {
                    channelSegment.onSlotCleaned();
                    return function02.invoke();
                } else {
                    Waiter waiter = obj instanceof Waiter ? (Waiter) obj : null;
                    if (waiter != null) {
                        prepareSenderForSuspension(waiter, channelSegment, i2);
                    }
                    return function2.invoke(channelSegment, Integer.valueOf(i2));
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: trySendDropOldest-JP2dKIU  reason: not valid java name */
    public final Object m2041trySendDropOldestJP2dKIU(E e) {
        int i;
        ChannelSegment channelSegment;
        BufferedChannel bufferedChannel;
        Symbol symbol = BufferedChannelKt.BUFFERED;
        ChannelSegment channelSegment2 = (ChannelSegment) sendSegment$volatile$FU.get(this);
        while (true) {
            long andIncrement = sendersAndCloseStatus$volatile$FU.getAndIncrement(this);
            long j = andIncrement & 1152921504606846975L;
            boolean access$isClosedForSend0 = isClosedForSend0(andIncrement);
            long j2 = j / ((long) BufferedChannelKt.SEGMENT_SIZE);
            int i2 = (int) (j % ((long) BufferedChannelKt.SEGMENT_SIZE));
            if (channelSegment2.id != j2) {
                channelSegment = findSegmentSend(j2, channelSegment2);
                if (channelSegment != null) {
                    bufferedChannel = this;
                    i = i2;
                } else if (access$isClosedForSend0) {
                    return ChannelResult.Companion.m2063closedJP2dKIU(getSendException());
                }
            } else {
                channelSegment = channelSegment2;
                i = i2;
                bufferedChannel = this;
            }
            E e2 = e;
            int access$updateCellSend = bufferedChannel.updateCellSend(channelSegment, i, e2, j, symbol, access$isClosedForSend0);
            ChannelSegment channelSegment3 = channelSegment;
            BufferedChannel bufferedChannel2 = bufferedChannel;
            channelSegment2 = channelSegment3;
            if (access$updateCellSend == 0) {
                channelSegment2.cleanPrev();
                return ChannelResult.Companion.m2065successJP2dKIU(Unit.INSTANCE);
            } else if (access$updateCellSend == 1) {
                return ChannelResult.Companion.m2065successJP2dKIU(Unit.INSTANCE);
            } else {
                if (access$updateCellSend != 2) {
                    if (access$updateCellSend == 3) {
                        throw new IllegalStateException("unexpected".toString());
                    } else if (access$updateCellSend != 4) {
                        if (access$updateCellSend == 5) {
                            channelSegment2.cleanPrev();
                        }
                        e = e2;
                    } else {
                        if (j < getReceiversCounter$kotlinx_coroutines_core()) {
                            channelSegment2.cleanPrev();
                        }
                        return ChannelResult.Companion.m2063closedJP2dKIU(getSendException());
                    }
                } else if (access$isClosedForSend0) {
                    channelSegment2.onSlotCleaned();
                    return ChannelResult.Companion.m2063closedJP2dKIU(getSendException());
                } else {
                    Waiter waiter = symbol instanceof Waiter ? (Waiter) symbol : null;
                    if (waiter != null) {
                        prepareSenderForSuspension(waiter, channelSegment2, i);
                    }
                    dropFirstElementUntilTheSpecifiedCellIsInTheBuffer((channelSegment2.id * ((long) BufferedChannelKt.SEGMENT_SIZE)) + ((long) i));
                    return ChannelResult.Companion.m2065successJP2dKIU(Unit.INSTANCE);
                }
            }
        }
    }

    /* JADX WARNING: type inference failed for: r22v0, types: [kotlin.jvm.functions.Function0<kotlin.Unit>, kotlin.jvm.functions.Function0] */
    /* JADX WARNING: type inference failed for: r23v0, types: [kotlin.jvm.functions.Function0<kotlin.Unit>, kotlin.jvm.functions.Function0] */
    /* JADX WARNING: Unknown variable types count: 2 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void sendImplOnNoWaiter(kotlinx.coroutines.channels.ChannelSegment<E> r16, int r17, E r18, long r19, kotlinx.coroutines.Waiter r21, kotlin.jvm.functions.Function0<kotlin.Unit> r22, kotlin.jvm.functions.Function0<kotlin.Unit> r23) {
        /*
            r15 = this;
            r7 = 0
            r0 = r15
            r1 = r16
            r2 = r17
            r3 = r18
            r4 = r19
            r6 = r21
            int r7 = r0.updateCellSend(r1, r2, r3, r4, r6, r7)
            if (r7 == 0) goto L_0x00e4
            r8 = 1
            if (r7 == r8) goto L_0x00e0
            r9 = 2
            if (r7 == r9) goto L_0x00d6
            r10 = 4
            if (r7 == r10) goto L_0x00c7
            java.lang.String r11 = "unexpected"
            r12 = 5
            if (r7 != r12) goto L_0x00bd
            r16.cleanPrev()
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r1 = sendSegment$volatile$FU
            java.lang.Object r1 = r1.get(r15)
            kotlinx.coroutines.channels.ChannelSegment r1 = (kotlinx.coroutines.channels.ChannelSegment) r1
        L_0x002d:
            java.util.concurrent.atomic.AtomicLongFieldUpdater r2 = sendersAndCloseStatus$volatile$FU
            long r2 = r2.getAndIncrement(r15)
            r4 = 1152921504606846975(0xfffffffffffffff, double:1.2882297539194265E-231)
            long r4 = r4 & r2
            boolean r7 = r15.isClosedForSend0(r2)
            int r2 = kotlinx.coroutines.channels.BufferedChannelKt.SEGMENT_SIZE
            long r2 = (long) r2
            long r2 = r4 / r2
            int r6 = kotlinx.coroutines.channels.BufferedChannelKt.SEGMENT_SIZE
            long r13 = (long) r6
            long r13 = r4 % r13
            int r6 = (int) r13
            long r13 = r1.id
            int r13 = (r13 > r2 ? 1 : (r13 == r2 ? 0 : -1))
            if (r13 == 0) goto L_0x005f
            kotlinx.coroutines.channels.ChannelSegment r2 = r15.findSegmentSend(r2, r1)
            if (r2 != 0) goto L_0x005e
            if (r7 == 0) goto L_0x002d
            java.lang.Object r1 = r23.invoke()
            goto L_0x00ba
        L_0x005e:
            r1 = r2
        L_0x005f:
            r0 = r15
            r3 = r18
            r2 = r6
            r6 = r21
            int r13 = r0.updateCellSend(r1, r2, r3, r4, r6, r7)
            if (r13 == 0) goto L_0x00b3
            if (r13 == r8) goto L_0x00ae
            if (r13 == r9) goto L_0x0095
            r2 = 3
            if (r13 == r2) goto L_0x008b
            if (r13 == r10) goto L_0x007b
            if (r13 == r12) goto L_0x0077
            goto L_0x002d
        L_0x0077:
            r1.cleanPrev()
            goto L_0x002d
        L_0x007b:
            long r2 = r15.getReceiversCounter$kotlinx_coroutines_core()
            int r2 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r2 >= 0) goto L_0x0086
            r1.cleanPrev()
        L_0x0086:
            java.lang.Object r1 = r23.invoke()
            goto L_0x00ba
        L_0x008b:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = r11.toString()
            r1.<init>(r2)
            throw r1
        L_0x0095:
            if (r7 == 0) goto L_0x009f
            r1.onSlotCleaned()
            java.lang.Object r1 = r23.invoke()
            goto L_0x00ba
        L_0x009f:
            boolean r3 = r6 instanceof kotlinx.coroutines.Waiter
            if (r3 == 0) goto L_0x00a5
            r3 = r6
            goto L_0x00a6
        L_0x00a5:
            r3 = 0
        L_0x00a6:
            if (r3 == 0) goto L_0x00ab
            r15.prepareSenderForSuspension(r3, r1, r2)
        L_0x00ab:
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
            goto L_0x00ba
        L_0x00ae:
            java.lang.Object r1 = r22.invoke()
            goto L_0x00ba
        L_0x00b3:
            r1.cleanPrev()
            java.lang.Object r1 = r22.invoke()
        L_0x00ba:
            kotlin.Unit r1 = (kotlin.Unit) r1
            return
        L_0x00bd:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = r11.toString()
            r1.<init>(r2)
            throw r1
        L_0x00c7:
            long r1 = r15.getReceiversCounter$kotlinx_coroutines_core()
            int r1 = (r19 > r1 ? 1 : (r19 == r1 ? 0 : -1))
            if (r1 >= 0) goto L_0x00d2
            r16.cleanPrev()
        L_0x00d2:
            r23.invoke()
            return
        L_0x00d6:
            r1 = r16
            r2 = r17
            r6 = r21
            r15.prepareSenderForSuspension(r6, r1, r2)
            return
        L_0x00e0:
            r22.invoke()
            return
        L_0x00e4:
            r1 = r16
            r1.cleanPrev()
            r22.invoke()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.BufferedChannel.sendImplOnNoWaiter(kotlinx.coroutines.channels.ChannelSegment, int, java.lang.Object, long, kotlinx.coroutines.Waiter, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function0):void");
    }

    /* access modifiers changed from: private */
    public final int updateCellSend(ChannelSegment<E> channelSegment, int i, E e, long j, Object obj, boolean z) {
        channelSegment.storeElement$kotlinx_coroutines_core(i, e);
        if (z) {
            int updateCellSendSlow = updateCellSendSlow(channelSegment, i, e, j, obj, z);
            return updateCellSendSlow;
        }
        boolean z2 = z;
        Object obj2 = obj;
        long j2 = j;
        E e2 = e;
        Object state$kotlinx_coroutines_core = channelSegment.getState$kotlinx_coroutines_core(i);
        if (state$kotlinx_coroutines_core == null) {
            if (bufferOrRendezvousSend(j2)) {
                if (channelSegment.casState$kotlinx_coroutines_core(i, (Object) null, BufferedChannelKt.BUFFERED)) {
                    return 1;
                }
            } else if (obj2 == null) {
                return 3;
            } else {
                if (channelSegment.casState$kotlinx_coroutines_core(i, (Object) null, obj2)) {
                    return 2;
                }
            }
        } else if (state$kotlinx_coroutines_core instanceof Waiter) {
            channelSegment.cleanElement$kotlinx_coroutines_core(i);
            if (tryResumeReceiver(state$kotlinx_coroutines_core, e2)) {
                channelSegment.setState$kotlinx_coroutines_core(i, BufferedChannelKt.DONE_RCV);
                onReceiveDequeued();
                return 0;
            } else if (channelSegment.getAndSetState$kotlinx_coroutines_core(i, BufferedChannelKt.INTERRUPTED_RCV) == BufferedChannelKt.INTERRUPTED_RCV) {
                return 5;
            } else {
                channelSegment.onCancelledRequest(i, true);
                return 5;
            }
        }
        return updateCellSendSlow(channelSegment, i, e2, j2, obj2, z2);
    }

    private final int updateCellSendSlow(ChannelSegment<E> channelSegment, int i, E e, long j, Object obj, boolean z) {
        while (true) {
            Object state$kotlinx_coroutines_core = channelSegment.getState$kotlinx_coroutines_core(i);
            if (state$kotlinx_coroutines_core == null) {
                if (!bufferOrRendezvousSend(j) || z) {
                    if (z) {
                        if (channelSegment.casState$kotlinx_coroutines_core(i, (Object) null, BufferedChannelKt.INTERRUPTED_SEND)) {
                            channelSegment.onCancelledRequest(i, false);
                            return 4;
                        }
                    } else if (obj == null) {
                        return 3;
                    } else {
                        if (channelSegment.casState$kotlinx_coroutines_core(i, (Object) null, obj)) {
                            return 2;
                        }
                    }
                } else if (channelSegment.casState$kotlinx_coroutines_core(i, (Object) null, BufferedChannelKt.BUFFERED)) {
                    return 1;
                }
            } else if (state$kotlinx_coroutines_core == BufferedChannelKt.IN_BUFFER) {
                if (channelSegment.casState$kotlinx_coroutines_core(i, state$kotlinx_coroutines_core, BufferedChannelKt.BUFFERED)) {
                    return 1;
                }
            } else if (state$kotlinx_coroutines_core == BufferedChannelKt.INTERRUPTED_RCV) {
                channelSegment.cleanElement$kotlinx_coroutines_core(i);
                return 5;
            } else if (state$kotlinx_coroutines_core == BufferedChannelKt.POISONED) {
                channelSegment.cleanElement$kotlinx_coroutines_core(i);
                return 5;
            } else if (state$kotlinx_coroutines_core == BufferedChannelKt.getCHANNEL_CLOSED()) {
                channelSegment.cleanElement$kotlinx_coroutines_core(i);
                completeCloseOrCancel();
                return 4;
            } else if (!DebugKt.getASSERTIONS_ENABLED() || (state$kotlinx_coroutines_core instanceof Waiter) || (state$kotlinx_coroutines_core instanceof WaiterEB)) {
                channelSegment.cleanElement$kotlinx_coroutines_core(i);
                if (state$kotlinx_coroutines_core instanceof WaiterEB) {
                    state$kotlinx_coroutines_core = ((WaiterEB) state$kotlinx_coroutines_core).waiter;
                }
                if (tryResumeReceiver(state$kotlinx_coroutines_core, e)) {
                    channelSegment.setState$kotlinx_coroutines_core(i, BufferedChannelKt.DONE_RCV);
                    onReceiveDequeued();
                    return 0;
                }
                if (channelSegment.getAndSetState$kotlinx_coroutines_core(i, BufferedChannelKt.INTERRUPTED_RCV) != BufferedChannelKt.INTERRUPTED_RCV) {
                    channelSegment.onCancelledRequest(i, true);
                }
                return 5;
            } else {
                throw new AssertionError();
            }
        }
    }

    private final boolean shouldSendSuspend(long j) {
        if (isClosedForSend0(j)) {
            return false;
        }
        return !bufferOrRendezvousSend(j & 1152921504606846975L);
    }

    private final boolean bufferOrRendezvousSend(long j) {
        return j < getBufferEndCounter() || j < getReceiversCounter$kotlinx_coroutines_core() + ((long) this.capacity);
    }

    public boolean shouldSendSuspend$kotlinx_coroutines_core() {
        return shouldSendSuspend(sendersAndCloseStatus$volatile$FU.get(this));
    }

    private final boolean tryResumeReceiver(Object obj, E e) {
        if (obj instanceof SelectInstance) {
            return ((SelectInstance) obj).trySelect(this, e);
        }
        KFunction<Unit> kFunction = null;
        if (obj instanceof ReceiveCatching) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlinx.coroutines.channels.ReceiveCatching<E of kotlinx.coroutines.channels.BufferedChannel>");
            CancellableContinuation cancellableContinuation = ((ReceiveCatching) obj).cont;
            ChannelResult r4 = ChannelResult.m2050boximpl(ChannelResult.Companion.m2065successJP2dKIU(e));
            Function1<E, Unit> function1 = this.onUndeliveredElement;
            if (function1 != null) {
                kFunction = bindCancellationFunResult(function1);
            }
            return BufferedChannelKt.tryResume0(cancellableContinuation, r4, (Function3) kFunction);
        } else if (obj instanceof BufferedChannelIterator) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlinx.coroutines.channels.BufferedChannel.BufferedChannelIterator<E of kotlinx.coroutines.channels.BufferedChannel>");
            return ((BufferedChannelIterator) obj).tryResumeHasNext(e);
        } else if (obj instanceof CancellableContinuation) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlinx.coroutines.CancellableContinuation<E of kotlinx.coroutines.channels.BufferedChannel>");
            CancellableContinuation cancellableContinuation2 = (CancellableContinuation) obj;
            Function1<E, Unit> function12 = this.onUndeliveredElement;
            if (function12 != null) {
                kFunction = bindCancellationFun(function12);
            }
            return BufferedChannelKt.tryResume0(cancellableContinuation2, e, (Function3) kFunction);
        } else {
            throw new IllegalStateException(("Unexpected receiver type: " + obj).toString());
        }
    }

    static /* synthetic */ <E> Object receive$suspendImpl(BufferedChannel<E> bufferedChannel, Continuation<? super E> continuation) {
        ChannelSegment channelSegment;
        ChannelSegment channelSegment2 = (ChannelSegment) receiveSegment$volatile$FU.get(bufferedChannel);
        while (!bufferedChannel.isClosedForReceive()) {
            long andIncrement = receivers$volatile$FU.getAndIncrement(bufferedChannel);
            long j = andIncrement / ((long) BufferedChannelKt.SEGMENT_SIZE);
            int i = (int) (andIncrement % ((long) BufferedChannelKt.SEGMENT_SIZE));
            if (channelSegment2.id != j) {
                ChannelSegment access$findSegmentReceive = bufferedChannel.findSegmentReceive(j, channelSegment2);
                if (access$findSegmentReceive == null) {
                    continue;
                } else {
                    channelSegment = access$findSegmentReceive;
                }
            } else {
                channelSegment = channelSegment2;
            }
            BufferedChannel<E> bufferedChannel2 = bufferedChannel;
            Object access$updateCellReceive = bufferedChannel2.updateCellReceive(channelSegment, i, andIncrement, (Object) null);
            if (access$updateCellReceive == BufferedChannelKt.SUSPEND) {
                throw new IllegalStateException("unexpected".toString());
            } else if (access$updateCellReceive == BufferedChannelKt.FAILED) {
                if (andIncrement < bufferedChannel2.getSendersCounter$kotlinx_coroutines_core()) {
                    channelSegment.cleanPrev();
                }
                bufferedChannel = bufferedChannel2;
                channelSegment2 = channelSegment;
            } else if (access$updateCellReceive == BufferedChannelKt.SUSPEND_NO_WAITER) {
                return bufferedChannel2.receiveOnNoWaiterSuspend(channelSegment, i, andIncrement, continuation);
            } else {
                channelSegment.cleanPrev();
                return access$updateCellReceive;
            }
        }
        throw StackTraceRecoveryKt.recoverStackTrace(bufferedChannel.getReceiveException());
    }

    /* access modifiers changed from: private */
    public final void prepareReceiverForSuspension(Waiter waiter, ChannelSegment<E> channelSegment, int i) {
        onReceiveEnqueued();
        waiter.invokeOnCancellation(channelSegment, i);
    }

    /* access modifiers changed from: private */
    public final void onClosedReceiveOnNoWaiterSuspend(CancellableContinuation<? super E> cancellableContinuation) {
        Result.Companion companion = Result.Companion;
        cancellableContinuation.resumeWith(Result.m516constructorimpl(ResultKt.createFailure(getReceiveException())));
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0039  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* renamed from: receiveCatching-JP2dKIU$suspendImpl  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ <E> java.lang.Object m2036receiveCatchingJP2dKIU$suspendImpl(kotlinx.coroutines.channels.BufferedChannel<E> r13, kotlin.coroutines.Continuation<? super kotlinx.coroutines.channels.ChannelResult<? extends E>> r14) {
        /*
            boolean r0 = r14 instanceof kotlinx.coroutines.channels.BufferedChannel$receiveCatching$1
            if (r0 == 0) goto L_0x0014
            r0 = r14
            kotlinx.coroutines.channels.BufferedChannel$receiveCatching$1 r0 = (kotlinx.coroutines.channels.BufferedChannel$receiveCatching$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r14 = r0.label
            int r14 = r14 - r2
            r0.label = r14
            goto L_0x0019
        L_0x0014:
            kotlinx.coroutines.channels.BufferedChannel$receiveCatching$1 r0 = new kotlinx.coroutines.channels.BufferedChannel$receiveCatching$1
            r0.<init>(r13, r14)
        L_0x0019:
            r6 = r0
            java.lang.Object r14 = r6.result
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r6.label
            r2 = 1
            if (r1 == 0) goto L_0x0039
            if (r1 != r2) goto L_0x0031
            kotlin.ResultKt.throwOnFailure(r14)
            kotlinx.coroutines.channels.ChannelResult r14 = (kotlinx.coroutines.channels.ChannelResult) r14
            java.lang.Object r13 = r14.m2062unboximpl()
            return r13
        L_0x0031:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r14 = "call to 'resume' before 'invoke' with coroutine"
            r13.<init>(r14)
            throw r13
        L_0x0039:
            kotlin.ResultKt.throwOnFailure(r14)
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r14 = receiveSegment$volatile$FU
            java.lang.Object r14 = r14.get(r13)
            kotlinx.coroutines.channels.ChannelSegment r14 = (kotlinx.coroutines.channels.ChannelSegment) r14
        L_0x0046:
            boolean r1 = r13.isClosedForReceive()
            if (r1 == 0) goto L_0x0057
            kotlinx.coroutines.channels.ChannelResult$Companion r14 = kotlinx.coroutines.channels.ChannelResult.Companion
            java.lang.Throwable r13 = r13.getCloseCause()
            java.lang.Object r13 = r14.m2063closedJP2dKIU(r13)
            return r13
        L_0x0057:
            java.util.concurrent.atomic.AtomicLongFieldUpdater r1 = receivers$volatile$FU
            long r4 = r1.getAndIncrement(r13)
            int r1 = kotlinx.coroutines.channels.BufferedChannelKt.SEGMENT_SIZE
            long r7 = (long) r1
            long r7 = r4 / r7
            int r1 = kotlinx.coroutines.channels.BufferedChannelKt.SEGMENT_SIZE
            long r9 = (long) r1
            long r9 = r4 % r9
            int r3 = (int) r9
            long r9 = r14.id
            int r1 = (r9 > r7 ? 1 : (r9 == r7 ? 0 : -1))
            if (r1 == 0) goto L_0x0079
            kotlinx.coroutines.channels.ChannelSegment r1 = r13.findSegmentReceive(r7, r14)
            if (r1 != 0) goto L_0x0077
            goto L_0x0046
        L_0x0077:
            r8 = r1
            goto L_0x007a
        L_0x0079:
            r8 = r14
        L_0x007a:
            r12 = 0
            r7 = r13
            r9 = r3
            r10 = r4
            java.lang.Object r13 = r7.updateCellReceive(r8, r9, r10, r12)
            r1 = r7
            kotlinx.coroutines.internal.Symbol r14 = kotlinx.coroutines.channels.BufferedChannelKt.SUSPEND
            if (r13 == r14) goto L_0x00b8
            kotlinx.coroutines.internal.Symbol r14 = kotlinx.coroutines.channels.BufferedChannelKt.FAILED
            if (r13 != r14) goto L_0x009d
            long r13 = r1.getSendersCounter$kotlinx_coroutines_core()
            int r13 = (r4 > r13 ? 1 : (r4 == r13 ? 0 : -1))
            if (r13 >= 0) goto L_0x009a
            r8.cleanPrev()
        L_0x009a:
            r13 = r1
            r14 = r8
            goto L_0x0046
        L_0x009d:
            kotlinx.coroutines.internal.Symbol r14 = kotlinx.coroutines.channels.BufferedChannelKt.SUSPEND_NO_WAITER
            if (r13 != r14) goto L_0x00ae
            r6.label = r2
            r2 = r8
            java.lang.Object r13 = r1.m2037receiveCatchingOnNoWaiterSuspendGKJJFZk(r2, r3, r4, r6)
            if (r13 != r0) goto L_0x00ad
            return r0
        L_0x00ad:
            return r13
        L_0x00ae:
            r8.cleanPrev()
            kotlinx.coroutines.channels.ChannelResult$Companion r14 = kotlinx.coroutines.channels.ChannelResult.Companion
            java.lang.Object r13 = r14.m2065successJP2dKIU(r13)
            return r13
        L_0x00b8:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r14 = "unexpected"
            java.lang.String r14 = r14.toString()
            r13.<init>(r14)
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.BufferedChannel.m2036receiveCatchingJP2dKIU$suspendImpl(kotlinx.coroutines.channels.BufferedChannel, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: type inference failed for: r13v4, types: [kotlin.reflect.KFunction] */
    /* JADX WARNING: type inference failed for: r13v11, types: [kotlin.reflect.KFunction] */
    /* access modifiers changed from: private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0040  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* renamed from: receiveCatchingOnNoWaiterSuspend-GKJJFZk  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object m2037receiveCatchingOnNoWaiterSuspendGKJJFZk(kotlinx.coroutines.channels.ChannelSegment<E> r11, int r12, long r13, kotlin.coroutines.Continuation<? super kotlinx.coroutines.channels.ChannelResult<? extends E>> r15) {
        /*
            r10 = this;
            boolean r0 = r15 instanceof kotlinx.coroutines.channels.BufferedChannel$receiveCatchingOnNoWaiterSuspend$1
            if (r0 == 0) goto L_0x0014
            r0 = r15
            kotlinx.coroutines.channels.BufferedChannel$receiveCatchingOnNoWaiterSuspend$1 r0 = (kotlinx.coroutines.channels.BufferedChannel$receiveCatchingOnNoWaiterSuspend$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r15 = r0.label
            int r15 = r15 - r2
            r0.label = r15
            goto L_0x0019
        L_0x0014:
            kotlinx.coroutines.channels.BufferedChannel$receiveCatchingOnNoWaiterSuspend$1 r0 = new kotlinx.coroutines.channels.BufferedChannel$receiveCatchingOnNoWaiterSuspend$1
            r0.<init>(r10, r15)
        L_0x0019:
            java.lang.Object r15 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0040
            if (r2 != r3) goto L_0x0038
            long r11 = r0.J$0
            int r11 = r0.I$0
            java.lang.Object r11 = r0.L$1
            kotlinx.coroutines.channels.ChannelSegment r11 = (kotlinx.coroutines.channels.ChannelSegment) r11
            java.lang.Object r11 = r0.L$0
            kotlinx.coroutines.channels.BufferedChannel r11 = (kotlinx.coroutines.channels.BufferedChannel) r11
            kotlin.ResultKt.throwOnFailure(r15)
            r3 = r10
            goto L_0x014d
        L_0x0038:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L_0x0040:
            kotlin.ResultKt.throwOnFailure(r15)
            r0.L$0 = r10
            r0.L$1 = r11
            r0.I$0 = r12
            r0.J$0 = r13
            r0.label = r3
            kotlin.coroutines.Continuation r0 = (kotlin.coroutines.Continuation) r0
            kotlin.coroutines.Continuation r15 = kotlin.coroutines.intrinsics.IntrinsicsKt.intercepted(r0)
            kotlinx.coroutines.CancellableContinuationImpl r15 = kotlinx.coroutines.CancellableContinuationKt.getOrCreateCancellableContinuation(r15)
            kotlinx.coroutines.channels.ReceiveCatching r2 = new kotlinx.coroutines.channels.ReceiveCatching     // Catch:{ all -> 0x0159 }
            java.lang.String r3 = "null cannot be cast to non-null type kotlinx.coroutines.CancellableContinuationImpl<kotlinx.coroutines.channels.ChannelResult<E of kotlinx.coroutines.channels.BufferedChannel.receiveCatchingOnNoWaiterSuspend_GKJJFZk$lambda$38>>"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r15, r3)     // Catch:{ all -> 0x0159 }
            r2.<init>(r15)     // Catch:{ all -> 0x0159 }
            r9 = r2
            kotlinx.coroutines.Waiter r9 = (kotlinx.coroutines.Waiter) r9     // Catch:{ all -> 0x0159 }
            r4 = r10
            r5 = r11
            r6 = r12
            r7 = r13
            java.lang.Object r11 = r4.updateCellReceive(r5, r6, r7, r9)     // Catch:{ all -> 0x0156 }
            r3 = r4
            kotlinx.coroutines.internal.Symbol r12 = kotlinx.coroutines.channels.BufferedChannelKt.SUSPEND     // Catch:{ all -> 0x0154 }
            if (r11 != r12) goto L_0x007a
            kotlinx.coroutines.Waiter r2 = (kotlinx.coroutines.Waiter) r2     // Catch:{ all -> 0x0154 }
            r10.prepareReceiverForSuspension(r2, r5, r6)     // Catch:{ all -> 0x0154 }
            goto L_0x013d
        L_0x007a:
            kotlinx.coroutines.internal.Symbol r12 = kotlinx.coroutines.channels.BufferedChannelKt.FAILED     // Catch:{ all -> 0x0154 }
            r13 = 0
            if (r11 != r12) goto L_0x0125
            long r11 = r10.getSendersCounter$kotlinx_coroutines_core()     // Catch:{ all -> 0x0154 }
            int r11 = (r7 > r11 ? 1 : (r7 == r11 ? 0 : -1))
            if (r11 >= 0) goto L_0x008c
            r5.cleanPrev()     // Catch:{ all -> 0x0154 }
        L_0x008c:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r11 = receiveSegment$volatile$FU     // Catch:{ all -> 0x0154 }
            java.lang.Object r11 = r11.get(r10)     // Catch:{ all -> 0x0154 }
            kotlinx.coroutines.channels.ChannelSegment r11 = (kotlinx.coroutines.channels.ChannelSegment) r11     // Catch:{ all -> 0x0154 }
        L_0x0096:
            boolean r12 = r10.isClosedForReceive()     // Catch:{ all -> 0x0154 }
            if (r12 == 0) goto L_0x00a4
            r11 = r15
            kotlinx.coroutines.CancellableContinuation r11 = (kotlinx.coroutines.CancellableContinuation) r11     // Catch:{ all -> 0x0154 }
            r10.onClosedReceiveCatchingOnNoWaiterSuspend(r11)     // Catch:{ all -> 0x0154 }
            goto L_0x013d
        L_0x00a4:
            java.util.concurrent.atomic.AtomicLongFieldUpdater r12 = receivers$volatile$FU     // Catch:{ all -> 0x0154 }
            long r6 = r12.getAndIncrement(r10)     // Catch:{ all -> 0x0154 }
            int r12 = kotlinx.coroutines.channels.BufferedChannelKt.SEGMENT_SIZE     // Catch:{ all -> 0x0154 }
            long r4 = (long) r12     // Catch:{ all -> 0x0154 }
            long r4 = r6 / r4
            int r12 = kotlinx.coroutines.channels.BufferedChannelKt.SEGMENT_SIZE     // Catch:{ all -> 0x0154 }
            long r8 = (long) r12     // Catch:{ all -> 0x0154 }
            long r8 = r6 % r8
            int r12 = (int) r8     // Catch:{ all -> 0x0154 }
            long r8 = r11.id     // Catch:{ all -> 0x0154 }
            int r14 = (r8 > r4 ? 1 : (r8 == r4 ? 0 : -1))
            if (r14 == 0) goto L_0x00c6
            kotlinx.coroutines.channels.ChannelSegment r14 = r10.findSegmentReceive(r4, r11)     // Catch:{ all -> 0x0154 }
            if (r14 != 0) goto L_0x00c4
            goto L_0x0096
        L_0x00c4:
            r4 = r14
            goto L_0x00c7
        L_0x00c6:
            r4 = r11
        L_0x00c7:
            r8 = r2
            kotlinx.coroutines.Waiter r8 = (kotlinx.coroutines.Waiter) r8     // Catch:{ all -> 0x0154 }
            r5 = r12
            java.lang.Object r11 = r3.updateCellReceive(r4, r5, r6, r8)     // Catch:{ all -> 0x0154 }
            kotlinx.coroutines.internal.Symbol r12 = kotlinx.coroutines.channels.BufferedChannelKt.SUSPEND     // Catch:{ all -> 0x0154 }
            if (r11 != r12) goto L_0x00e5
            r11 = r2
            kotlinx.coroutines.Waiter r11 = (kotlinx.coroutines.Waiter) r11     // Catch:{ all -> 0x0154 }
            boolean r11 = r11 instanceof kotlinx.coroutines.Waiter     // Catch:{ all -> 0x0154 }
            if (r11 == 0) goto L_0x00df
            r13 = r2
            kotlinx.coroutines.Waiter r13 = (kotlinx.coroutines.Waiter) r13     // Catch:{ all -> 0x0154 }
        L_0x00df:
            if (r13 == 0) goto L_0x013d
            r10.prepareReceiverForSuspension(r13, r4, r5)     // Catch:{ all -> 0x0154 }
            goto L_0x013d
        L_0x00e5:
            kotlinx.coroutines.internal.Symbol r12 = kotlinx.coroutines.channels.BufferedChannelKt.FAILED     // Catch:{ all -> 0x0154 }
            if (r11 != r12) goto L_0x00f8
            long r11 = r10.getSendersCounter$kotlinx_coroutines_core()     // Catch:{ all -> 0x0154 }
            int r11 = (r6 > r11 ? 1 : (r6 == r11 ? 0 : -1))
            if (r11 >= 0) goto L_0x00f6
            r4.cleanPrev()     // Catch:{ all -> 0x0154 }
        L_0x00f6:
            r11 = r4
            goto L_0x0096
        L_0x00f8:
            kotlinx.coroutines.internal.Symbol r12 = kotlinx.coroutines.channels.BufferedChannelKt.SUSPEND_NO_WAITER     // Catch:{ all -> 0x0154 }
            if (r11 == r12) goto L_0x0119
            r4.cleanPrev()     // Catch:{ all -> 0x0154 }
            kotlinx.coroutines.channels.ChannelResult$Companion r12 = kotlinx.coroutines.channels.ChannelResult.Companion     // Catch:{ all -> 0x0154 }
            java.lang.Object r11 = r12.m2065successJP2dKIU(r11)     // Catch:{ all -> 0x0154 }
            kotlinx.coroutines.channels.ChannelResult r11 = kotlinx.coroutines.channels.ChannelResult.m2050boximpl(r11)     // Catch:{ all -> 0x0154 }
            kotlin.jvm.functions.Function1<E, kotlin.Unit> r12 = r3.onUndeliveredElement     // Catch:{ all -> 0x0154 }
            if (r12 == 0) goto L_0x0113
            kotlin.reflect.KFunction r13 = r10.bindCancellationFunResult(r12)     // Catch:{ all -> 0x0154 }
        L_0x0113:
            kotlin.jvm.functions.Function3 r13 = (kotlin.jvm.functions.Function3) r13     // Catch:{ all -> 0x0154 }
        L_0x0115:
            r15.resume(r11, r13)     // Catch:{ all -> 0x0154 }
            goto L_0x013d
        L_0x0119:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException     // Catch:{ all -> 0x0154 }
            java.lang.String r12 = "unexpected"
            java.lang.String r12 = r12.toString()     // Catch:{ all -> 0x0154 }
            r11.<init>(r12)     // Catch:{ all -> 0x0154 }
            throw r11     // Catch:{ all -> 0x0154 }
        L_0x0125:
            r5.cleanPrev()     // Catch:{ all -> 0x0154 }
            kotlinx.coroutines.channels.ChannelResult$Companion r12 = kotlinx.coroutines.channels.ChannelResult.Companion     // Catch:{ all -> 0x0154 }
            java.lang.Object r11 = r12.m2065successJP2dKIU(r11)     // Catch:{ all -> 0x0154 }
            kotlinx.coroutines.channels.ChannelResult r11 = kotlinx.coroutines.channels.ChannelResult.m2050boximpl(r11)     // Catch:{ all -> 0x0154 }
            kotlin.jvm.functions.Function1<E, kotlin.Unit> r12 = r3.onUndeliveredElement     // Catch:{ all -> 0x0154 }
            if (r12 == 0) goto L_0x013a
            kotlin.reflect.KFunction r13 = r10.bindCancellationFunResult(r12)     // Catch:{ all -> 0x0154 }
        L_0x013a:
            kotlin.jvm.functions.Function3 r13 = (kotlin.jvm.functions.Function3) r13     // Catch:{ all -> 0x0154 }
            goto L_0x0115
        L_0x013d:
            java.lang.Object r15 = r15.getResult()
            java.lang.Object r11 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            if (r15 != r11) goto L_0x014a
            kotlin.coroutines.jvm.internal.DebugProbesKt.probeCoroutineSuspended(r0)
        L_0x014a:
            if (r15 != r1) goto L_0x014d
            return r1
        L_0x014d:
            kotlinx.coroutines.channels.ChannelResult r15 = (kotlinx.coroutines.channels.ChannelResult) r15
            java.lang.Object r11 = r15.m2062unboximpl()
            return r11
        L_0x0154:
            r0 = move-exception
            goto L_0x015b
        L_0x0156:
            r0 = move-exception
            r3 = r4
            goto L_0x015b
        L_0x0159:
            r0 = move-exception
            r3 = r10
        L_0x015b:
            r11 = r0
            r15.releaseClaimedReusableContinuation$kotlinx_coroutines_core()
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.BufferedChannel.m2037receiveCatchingOnNoWaiterSuspendGKJJFZk(kotlinx.coroutines.channels.ChannelSegment, int, long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    public final void onClosedReceiveCatchingOnNoWaiterSuspend(CancellableContinuation<? super ChannelResult<? extends E>> cancellableContinuation) {
        Result.Companion companion = Result.Companion;
        cancellableContinuation.resumeWith(Result.m516constructorimpl(ChannelResult.m2050boximpl(ChannelResult.Companion.m2063closedJP2dKIU(getCloseCause()))));
    }

    /* renamed from: tryReceive-PtdJZtk  reason: not valid java name */
    public Object m2039tryReceivePtdJZtk() {
        ChannelSegment channelSegment;
        long j = receivers$volatile$FU.get(this);
        long j2 = sendersAndCloseStatus$volatile$FU.get(this);
        if (isClosedForReceive0(j2)) {
            return ChannelResult.Companion.m2063closedJP2dKIU(getCloseCause());
        }
        if (j >= (j2 & 1152921504606846975L)) {
            return ChannelResult.Companion.m2064failurePtdJZtk();
        }
        Symbol access$getINTERRUPTED_RCV$p = BufferedChannelKt.INTERRUPTED_RCV;
        ChannelSegment channelSegment2 = (ChannelSegment) receiveSegment$volatile$FU.get(this);
        while (!isClosedForReceive()) {
            long andIncrement = receivers$volatile$FU.getAndIncrement(this);
            long j3 = andIncrement / ((long) BufferedChannelKt.SEGMENT_SIZE);
            int i = (int) (andIncrement % ((long) BufferedChannelKt.SEGMENT_SIZE));
            if (channelSegment2.id != j3) {
                ChannelSegment access$findSegmentReceive = findSegmentReceive(j3, channelSegment2);
                if (access$findSegmentReceive == null) {
                    continue;
                } else {
                    channelSegment = access$findSegmentReceive;
                }
            } else {
                channelSegment = channelSegment2;
            }
            Object access$updateCellReceive = updateCellReceive(channelSegment, i, andIncrement, access$getINTERRUPTED_RCV$p);
            ChannelSegment channelSegment3 = channelSegment;
            ChannelSegment channelSegment4 = channelSegment3;
            if (access$updateCellReceive == BufferedChannelKt.SUSPEND) {
                Waiter waiter = access$getINTERRUPTED_RCV$p instanceof Waiter ? (Waiter) access$getINTERRUPTED_RCV$p : null;
                if (waiter != null) {
                    prepareReceiverForSuspension(waiter, channelSegment4, i);
                }
                waitExpandBufferCompletion$kotlinx_coroutines_core(andIncrement);
                channelSegment4.onSlotCleaned();
                return ChannelResult.Companion.m2064failurePtdJZtk();
            } else if (access$updateCellReceive == BufferedChannelKt.FAILED) {
                if (andIncrement < getSendersCounter$kotlinx_coroutines_core()) {
                    channelSegment4.cleanPrev();
                }
                channelSegment2 = channelSegment4;
            } else if (access$updateCellReceive != BufferedChannelKt.SUSPEND_NO_WAITER) {
                channelSegment4.cleanPrev();
                return ChannelResult.Companion.m2065successJP2dKIU(access$updateCellReceive);
            } else {
                throw new IllegalStateException("unexpected".toString());
            }
        }
        return ChannelResult.Companion.m2063closedJP2dKIU(getCloseCause());
    }

    /* access modifiers changed from: protected */
    public final void dropFirstElementUntilTheSpecifiedCellIsInTheBuffer(long j) {
        ChannelSegment channelSegment;
        UndeliveredElementException callUndeliveredElementCatchingException$default;
        if (!DebugKt.getASSERTIONS_ENABLED() || isConflatedDropOldest()) {
            ChannelSegment channelSegment2 = (ChannelSegment) receiveSegment$volatile$FU.get(this);
            while (true) {
                long j2 = receivers$volatile$FU.get(this);
                if (j >= Math.max(((long) this.capacity) + j2, getBufferEndCounter())) {
                    if (receivers$volatile$FU.compareAndSet(this, j2, 1 + j2)) {
                        long j3 = j2 / ((long) BufferedChannelKt.SEGMENT_SIZE);
                        int i = (int) (j2 % ((long) BufferedChannelKt.SEGMENT_SIZE));
                        if (channelSegment2.id != j3) {
                            channelSegment = findSegmentReceive(j3, channelSegment2);
                            if (channelSegment == null) {
                                continue;
                            }
                        } else {
                            channelSegment = channelSegment2;
                        }
                        long j4 = j2;
                        Object updateCellReceive = updateCellReceive(channelSegment, i, j4, (Object) null);
                        long j5 = j4;
                        if (updateCellReceive != BufferedChannelKt.FAILED) {
                            channelSegment.cleanPrev();
                            Function1<E, Unit> function1 = this.onUndeliveredElement;
                            if (!(function1 == null || (callUndeliveredElementCatchingException$default = OnUndeliveredElementKt.callUndeliveredElementCatchingException$default(function1, updateCellReceive, (UndeliveredElementException) null, 2, (Object) null)) == null)) {
                                throw callUndeliveredElementCatchingException$default;
                            }
                        } else if (j5 < getSendersCounter$kotlinx_coroutines_core()) {
                            channelSegment.cleanPrev();
                        }
                        channelSegment2 = channelSegment;
                    }
                } else {
                    return;
                }
            }
        } else {
            throw new AssertionError();
        }
    }

    static /* synthetic */ Object receiveImpl$default(BufferedChannel bufferedChannel, Object obj, Function1 function1, Function3 function3, Function0 function0, Function3 function32, int i, Object obj2) {
        ChannelSegment channelSegment;
        if (obj2 == null) {
            if ((i & 16) != 0) {
                function32 = BufferedChannel$receiveImpl$1.INSTANCE;
            }
            ChannelSegment channelSegment2 = (ChannelSegment) receiveSegment$volatile$FU.get(bufferedChannel);
            while (!bufferedChannel.isClosedForReceive()) {
                long andIncrement = receivers$volatile$FU.getAndIncrement(bufferedChannel);
                long j = andIncrement / ((long) BufferedChannelKt.SEGMENT_SIZE);
                int i2 = (int) (andIncrement % ((long) BufferedChannelKt.SEGMENT_SIZE));
                if (channelSegment2.id != j) {
                    ChannelSegment access$findSegmentReceive = bufferedChannel.findSegmentReceive(j, channelSegment2);
                    if (access$findSegmentReceive == null) {
                        continue;
                    } else {
                        channelSegment = access$findSegmentReceive;
                    }
                } else {
                    channelSegment = channelSegment2;
                }
                BufferedChannel bufferedChannel2 = bufferedChannel;
                Object obj3 = obj;
                Object access$updateCellReceive = bufferedChannel2.updateCellReceive(channelSegment, i2, andIncrement, obj3);
                channelSegment2 = channelSegment;
                if (access$updateCellReceive == BufferedChannelKt.SUSPEND) {
                    Waiter waiter = obj3 instanceof Waiter ? (Waiter) obj3 : null;
                    if (waiter != null) {
                        bufferedChannel2.prepareReceiverForSuspension(waiter, channelSegment2, i2);
                    }
                    return function3.invoke(channelSegment2, Integer.valueOf(i2), Long.valueOf(andIncrement));
                } else if (access$updateCellReceive == BufferedChannelKt.FAILED) {
                    if (andIncrement < bufferedChannel2.getSendersCounter$kotlinx_coroutines_core()) {
                        channelSegment2.cleanPrev();
                    }
                    bufferedChannel = bufferedChannel2;
                    obj = obj3;
                } else if (access$updateCellReceive == BufferedChannelKt.SUSPEND_NO_WAITER) {
                    return function32.invoke(channelSegment2, Integer.valueOf(i2), Long.valueOf(andIncrement));
                } else {
                    channelSegment2.cleanPrev();
                    return function1.invoke(access$updateCellReceive);
                }
            }
            return function0.invoke();
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: receiveImpl");
    }

    private final <R> R receiveImpl(Object obj, Function1<? super E, ? extends R> function1, Function3<? super ChannelSegment<E>, ? super Integer, ? super Long, ? extends R> function3, Function0<? extends R> function0, Function3<? super ChannelSegment<E>, ? super Integer, ? super Long, ? extends R> function32) {
        ChannelSegment channelSegment;
        ChannelSegment channelSegment2 = (ChannelSegment) receiveSegment$volatile$FU.get(this);
        while (!isClosedForReceive()) {
            long andIncrement = receivers$volatile$FU.getAndIncrement(this);
            long j = andIncrement / ((long) BufferedChannelKt.SEGMENT_SIZE);
            int i = (int) (andIncrement % ((long) BufferedChannelKt.SEGMENT_SIZE));
            if (channelSegment2.id != j) {
                ChannelSegment access$findSegmentReceive = findSegmentReceive(j, channelSegment2);
                if (access$findSegmentReceive == null) {
                    continue;
                } else {
                    channelSegment = access$findSegmentReceive;
                }
            } else {
                channelSegment = channelSegment2;
            }
            Object obj2 = obj;
            Object access$updateCellReceive = updateCellReceive(channelSegment, i, andIncrement, obj2);
            channelSegment2 = channelSegment;
            if (access$updateCellReceive == BufferedChannelKt.SUSPEND) {
                Waiter waiter = obj2 instanceof Waiter ? (Waiter) obj2 : null;
                if (waiter != null) {
                    prepareReceiverForSuspension(waiter, channelSegment2, i);
                }
                return function3.invoke(channelSegment2, Integer.valueOf(i), Long.valueOf(andIncrement));
            } else if (access$updateCellReceive == BufferedChannelKt.FAILED) {
                if (andIncrement < getSendersCounter$kotlinx_coroutines_core()) {
                    channelSegment2.cleanPrev();
                }
                obj = obj2;
            } else if (access$updateCellReceive == BufferedChannelKt.SUSPEND_NO_WAITER) {
                return function32.invoke(channelSegment2, Integer.valueOf(i), Long.valueOf(andIncrement));
            } else {
                channelSegment2.cleanPrev();
                return function1.invoke(access$updateCellReceive);
            }
        }
        return function0.invoke();
    }

    private final void receiveImplOnNoWaiter(ChannelSegment<E> channelSegment, int i, long j, Waiter waiter, Function1<? super E, Unit> function1, Function0<Unit> function0) {
        ChannelSegment channelSegment2;
        Object access$updateCellReceive = updateCellReceive(channelSegment, i, j, waiter);
        Waiter waiter2 = waiter;
        long j2 = j;
        int i2 = i;
        ChannelSegment<E> channelSegment3 = channelSegment;
        BufferedChannel bufferedChannel = this;
        if (access$updateCellReceive == BufferedChannelKt.SUSPEND) {
            prepareReceiverForSuspension(waiter2, channelSegment3, i2);
        } else if (access$updateCellReceive == BufferedChannelKt.FAILED) {
            if (j2 < getSendersCounter$kotlinx_coroutines_core()) {
                channelSegment3.cleanPrev();
            }
            ChannelSegment channelSegment4 = (ChannelSegment) receiveSegment$volatile$FU.get(this);
            while (!isClosedForReceive()) {
                long andIncrement = receivers$volatile$FU.getAndIncrement(this);
                long j3 = andIncrement / ((long) BufferedChannelKt.SEGMENT_SIZE);
                int i3 = (int) (andIncrement % ((long) BufferedChannelKt.SEGMENT_SIZE));
                if (channelSegment4.id != j3) {
                    ChannelSegment access$findSegmentReceive = findSegmentReceive(j3, channelSegment4);
                    if (access$findSegmentReceive == null) {
                        continue;
                    } else {
                        channelSegment2 = access$findSegmentReceive;
                    }
                } else {
                    channelSegment2 = channelSegment4;
                }
                BufferedChannel bufferedChannel2 = bufferedChannel;
                Object access$updateCellReceive2 = bufferedChannel2.updateCellReceive(channelSegment2, i3, andIncrement, waiter2);
                BufferedChannel bufferedChannel3 = bufferedChannel2;
                channelSegment4 = channelSegment2;
                if (access$updateCellReceive2 == BufferedChannelKt.SUSPEND) {
                    Waiter waiter3 = waiter2 instanceof Waiter ? waiter2 : null;
                    if (waiter3 != null) {
                        prepareReceiverForSuspension(waiter3, channelSegment4, i3);
                    }
                    Unit unit = Unit.INSTANCE;
                    return;
                } else if (access$updateCellReceive2 == BufferedChannelKt.FAILED) {
                    if (andIncrement < getSendersCounter$kotlinx_coroutines_core()) {
                        channelSegment4.cleanPrev();
                    }
                    bufferedChannel = bufferedChannel3;
                } else if (access$updateCellReceive2 != BufferedChannelKt.SUSPEND_NO_WAITER) {
                    channelSegment4.cleanPrev();
                    function1.invoke(access$updateCellReceive2);
                    return;
                } else {
                    throw new IllegalStateException("unexpected".toString());
                }
            }
            function0.invoke();
        } else {
            BufferedChannel bufferedChannel4 = bufferedChannel;
            channelSegment3.cleanPrev();
            function1.invoke(access$updateCellReceive);
        }
    }

    /* access modifiers changed from: private */
    public final Object updateCellReceive(ChannelSegment<E> channelSegment, int i, long j, Object obj) {
        Object state$kotlinx_coroutines_core = channelSegment.getState$kotlinx_coroutines_core(i);
        if (state$kotlinx_coroutines_core == null) {
            if (j >= (sendersAndCloseStatus$volatile$FU.get(this) & 1152921504606846975L)) {
                if (obj == null) {
                    return BufferedChannelKt.SUSPEND_NO_WAITER;
                }
                if (channelSegment.casState$kotlinx_coroutines_core(i, state$kotlinx_coroutines_core, obj)) {
                    expandBuffer();
                    return BufferedChannelKt.SUSPEND;
                }
            }
        } else if (state$kotlinx_coroutines_core == BufferedChannelKt.BUFFERED && channelSegment.casState$kotlinx_coroutines_core(i, state$kotlinx_coroutines_core, BufferedChannelKt.DONE_RCV)) {
            expandBuffer();
            return channelSegment.retrieveElement$kotlinx_coroutines_core(i);
        }
        return updateCellReceiveSlow(channelSegment, i, j, obj);
    }

    private final Object updateCellReceiveSlow(ChannelSegment<E> channelSegment, int i, long j, Object obj) {
        while (true) {
            Object state$kotlinx_coroutines_core = channelSegment.getState$kotlinx_coroutines_core(i);
            if (state$kotlinx_coroutines_core == null || state$kotlinx_coroutines_core == BufferedChannelKt.IN_BUFFER) {
                if (j < (sendersAndCloseStatus$volatile$FU.get(this) & 1152921504606846975L)) {
                    if (channelSegment.casState$kotlinx_coroutines_core(i, state$kotlinx_coroutines_core, BufferedChannelKt.POISONED)) {
                        expandBuffer();
                        return BufferedChannelKt.FAILED;
                    }
                } else if (obj == null) {
                    return BufferedChannelKt.SUSPEND_NO_WAITER;
                } else {
                    if (channelSegment.casState$kotlinx_coroutines_core(i, state$kotlinx_coroutines_core, obj)) {
                        expandBuffer();
                        return BufferedChannelKt.SUSPEND;
                    }
                }
            } else if (state$kotlinx_coroutines_core == BufferedChannelKt.BUFFERED) {
                if (channelSegment.casState$kotlinx_coroutines_core(i, state$kotlinx_coroutines_core, BufferedChannelKt.DONE_RCV)) {
                    expandBuffer();
                    return channelSegment.retrieveElement$kotlinx_coroutines_core(i);
                }
            } else if (state$kotlinx_coroutines_core == BufferedChannelKt.INTERRUPTED_SEND) {
                return BufferedChannelKt.FAILED;
            } else {
                if (state$kotlinx_coroutines_core == BufferedChannelKt.POISONED) {
                    return BufferedChannelKt.FAILED;
                }
                if (state$kotlinx_coroutines_core == BufferedChannelKt.getCHANNEL_CLOSED()) {
                    expandBuffer();
                    return BufferedChannelKt.FAILED;
                } else if (state$kotlinx_coroutines_core != BufferedChannelKt.RESUMING_BY_EB && channelSegment.casState$kotlinx_coroutines_core(i, state$kotlinx_coroutines_core, BufferedChannelKt.RESUMING_BY_RCV)) {
                    boolean z = state$kotlinx_coroutines_core instanceof WaiterEB;
                    if (z) {
                        state$kotlinx_coroutines_core = ((WaiterEB) state$kotlinx_coroutines_core).waiter;
                    }
                    if (tryResumeSender(state$kotlinx_coroutines_core, channelSegment, i)) {
                        channelSegment.setState$kotlinx_coroutines_core(i, BufferedChannelKt.DONE_RCV);
                        expandBuffer();
                        return channelSegment.retrieveElement$kotlinx_coroutines_core(i);
                    }
                    channelSegment.setState$kotlinx_coroutines_core(i, BufferedChannelKt.INTERRUPTED_SEND);
                    channelSegment.onCancelledRequest(i, false);
                    if (z) {
                        expandBuffer();
                    }
                    return BufferedChannelKt.FAILED;
                }
            }
        }
    }

    private final boolean tryResumeSender(Object obj, ChannelSegment<E> channelSegment, int i) {
        if (obj instanceof CancellableContinuation) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlinx.coroutines.CancellableContinuation<kotlin.Unit>");
            return BufferedChannelKt.tryResume0$default((CancellableContinuation) obj, Unit.INSTANCE, (Function3) null, 2, (Object) null);
        } else if (obj instanceof SelectInstance) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlinx.coroutines.selects.SelectImplementation<*>");
            TrySelectDetailedResult trySelectDetailed = ((SelectImplementation) obj).trySelectDetailed(this, Unit.INSTANCE);
            if (trySelectDetailed == TrySelectDetailedResult.REREGISTER) {
                channelSegment.cleanElement$kotlinx_coroutines_core(i);
            }
            if (trySelectDetailed == TrySelectDetailedResult.SUCCESSFUL) {
                return true;
            }
            return false;
        } else if (obj instanceof SendBroadcast) {
            return BufferedChannelKt.tryResume0$default(((SendBroadcast) obj).getCont(), true, (Function3) null, 2, (Object) null);
        } else {
            throw new IllegalStateException(("Unexpected waiter: " + obj).toString());
        }
    }

    private final void expandBuffer() {
        if (!isRendezvousOrUnlimited()) {
            ChannelSegment channelSegment = (ChannelSegment) bufferEndSegment$volatile$FU.get(this);
            while (true) {
                long andIncrement = bufferEnd$volatile$FU.getAndIncrement(this);
                long j = andIncrement / ((long) BufferedChannelKt.SEGMENT_SIZE);
                if (getSendersCounter$kotlinx_coroutines_core() <= andIncrement) {
                    if (channelSegment.id < j && channelSegment.getNext() != null) {
                        moveSegmentBufferEndToSpecifiedOrLast(j, channelSegment);
                    }
                    incCompletedExpandBufferAttempts$default(this, 0, 1, (Object) null);
                    return;
                }
                if (channelSegment.id != j) {
                    ChannelSegment findSegmentBufferEnd = findSegmentBufferEnd(j, channelSegment, andIncrement);
                    if (findSegmentBufferEnd == null) {
                        continue;
                    } else {
                        channelSegment = findSegmentBufferEnd;
                    }
                }
                if (updateCellExpandBuffer(channelSegment, (int) (andIncrement % ((long) BufferedChannelKt.SEGMENT_SIZE)), andIncrement)) {
                    incCompletedExpandBufferAttempts$default(this, 0, 1, (Object) null);
                    return;
                }
                incCompletedExpandBufferAttempts$default(this, 0, 1, (Object) null);
            }
        }
    }

    private final boolean updateCellExpandBuffer(ChannelSegment<E> channelSegment, int i, long j) {
        Object state$kotlinx_coroutines_core = channelSegment.getState$kotlinx_coroutines_core(i);
        if (!(state$kotlinx_coroutines_core instanceof Waiter) || j < receivers$volatile$FU.get(this) || !channelSegment.casState$kotlinx_coroutines_core(i, state$kotlinx_coroutines_core, BufferedChannelKt.RESUMING_BY_EB)) {
            return updateCellExpandBufferSlow(channelSegment, i, j);
        }
        if (tryResumeSender(state$kotlinx_coroutines_core, channelSegment, i)) {
            channelSegment.setState$kotlinx_coroutines_core(i, BufferedChannelKt.BUFFERED);
            return true;
        }
        channelSegment.setState$kotlinx_coroutines_core(i, BufferedChannelKt.INTERRUPTED_SEND);
        channelSegment.onCancelledRequest(i, false);
        return false;
    }

    private final boolean updateCellExpandBufferSlow(ChannelSegment<E> channelSegment, int i, long j) {
        while (true) {
            Object state$kotlinx_coroutines_core = channelSegment.getState$kotlinx_coroutines_core(i);
            if (state$kotlinx_coroutines_core instanceof Waiter) {
                if (j < receivers$volatile$FU.get(this)) {
                    if (channelSegment.casState$kotlinx_coroutines_core(i, state$kotlinx_coroutines_core, new WaiterEB((Waiter) state$kotlinx_coroutines_core))) {
                        return true;
                    }
                } else if (channelSegment.casState$kotlinx_coroutines_core(i, state$kotlinx_coroutines_core, BufferedChannelKt.RESUMING_BY_EB)) {
                    if (tryResumeSender(state$kotlinx_coroutines_core, channelSegment, i)) {
                        channelSegment.setState$kotlinx_coroutines_core(i, BufferedChannelKt.BUFFERED);
                        return true;
                    }
                    channelSegment.setState$kotlinx_coroutines_core(i, BufferedChannelKt.INTERRUPTED_SEND);
                    channelSegment.onCancelledRequest(i, false);
                    return false;
                }
            } else if (state$kotlinx_coroutines_core == BufferedChannelKt.INTERRUPTED_SEND) {
                return false;
            } else {
                if (state$kotlinx_coroutines_core == null) {
                    if (channelSegment.casState$kotlinx_coroutines_core(i, state$kotlinx_coroutines_core, BufferedChannelKt.IN_BUFFER)) {
                        return true;
                    }
                } else if (state$kotlinx_coroutines_core == BufferedChannelKt.BUFFERED || state$kotlinx_coroutines_core == BufferedChannelKt.POISONED || state$kotlinx_coroutines_core == BufferedChannelKt.DONE_RCV || state$kotlinx_coroutines_core == BufferedChannelKt.INTERRUPTED_RCV || state$kotlinx_coroutines_core == BufferedChannelKt.getCHANNEL_CLOSED()) {
                    return true;
                } else {
                    if (state$kotlinx_coroutines_core != BufferedChannelKt.RESUMING_BY_RCV) {
                        throw new IllegalStateException(("Unexpected cell state: " + state$kotlinx_coroutines_core).toString());
                    }
                }
            }
        }
        return true;
    }

    static /* synthetic */ void incCompletedExpandBufferAttempts$default(BufferedChannel bufferedChannel, long j, int i, Object obj) {
        if (obj == null) {
            if ((i & 1) != 0) {
                j = 1;
            }
            bufferedChannel.incCompletedExpandBufferAttempts(j);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: incCompletedExpandBufferAttempts");
    }

    private final void incCompletedExpandBufferAttempts(long j) {
        if ((completedExpandBuffersAndPauseFlag$volatile$FU.addAndGet(this, j) & Longs.MAX_POWER_OF_TWO) != 0) {
            do {
            } while ((completedExpandBuffersAndPauseFlag$volatile$FU.get(this) & Longs.MAX_POWER_OF_TWO) != 0);
        }
    }

    public final void waitExpandBufferCompletion$kotlinx_coroutines_core(long j) {
        BufferedChannel bufferedChannel;
        BufferedChannel bufferedChannel2 = this;
        if (!bufferedChannel2.isRendezvousOrUnlimited()) {
            while (bufferedChannel2.getBufferEndCounter() <= j) {
                bufferedChannel2 = this;
            }
            int access$getEXPAND_BUFFER_COMPLETION_WAIT_ITERATIONS$p = BufferedChannelKt.EXPAND_BUFFER_COMPLETION_WAIT_ITERATIONS;
            int i = 0;
            while (i < access$getEXPAND_BUFFER_COMPLETION_WAIT_ITERATIONS$p) {
                long bufferEndCounter = bufferedChannel2.getBufferEndCounter();
                if (bufferEndCounter != (DurationKt.MAX_MILLIS & completedExpandBuffersAndPauseFlag$volatile$FU.get(bufferedChannel2)) || bufferEndCounter != bufferedChannel2.getBufferEndCounter()) {
                    i++;
                } else {
                    return;
                }
            }
            AtomicLongFieldUpdater completedExpandBuffersAndPauseFlag$volatile$FU2 = completedExpandBuffersAndPauseFlag$volatile$FU;
            while (true) {
                long j2 = completedExpandBuffersAndPauseFlag$volatile$FU2.get(bufferedChannel);
                if (completedExpandBuffersAndPauseFlag$volatile$FU2.compareAndSet(bufferedChannel, j2, BufferedChannelKt.constructEBCompletedAndPauseFlag(j2 & DurationKt.MAX_MILLIS, true))) {
                    break;
                }
                bufferedChannel2 = this;
            }
            while (true) {
                long bufferEndCounter2 = bufferedChannel.getBufferEndCounter();
                long j3 = completedExpandBuffersAndPauseFlag$volatile$FU.get(bufferedChannel);
                long j4 = j3 & DurationKt.MAX_MILLIS;
                boolean z = (Longs.MAX_POWER_OF_TWO & j3) != 0;
                if (bufferEndCounter2 == j4 && bufferEndCounter2 == bufferedChannel.getBufferEndCounter()) {
                    break;
                } else if (!z) {
                    bufferedChannel = this;
                    completedExpandBuffersAndPauseFlag$volatile$FU.compareAndSet(bufferedChannel, j3, BufferedChannelKt.constructEBCompletedAndPauseFlag(j4, true));
                } else {
                    bufferedChannel = this;
                }
            }
            AtomicLongFieldUpdater completedExpandBuffersAndPauseFlag$volatile$FU3 = completedExpandBuffersAndPauseFlag$volatile$FU;
            while (true) {
                long j5 = completedExpandBuffersAndPauseFlag$volatile$FU3.get(bufferedChannel);
                boolean compareAndSet = completedExpandBuffersAndPauseFlag$volatile$FU3.compareAndSet(bufferedChannel, j5, BufferedChannelKt.constructEBCompletedAndPauseFlag(j5 & DurationKt.MAX_MILLIS, false));
                AtomicLongFieldUpdater atomicLongFieldUpdater = completedExpandBuffersAndPauseFlag$volatile$FU3;
                if (!compareAndSet) {
                    completedExpandBuffersAndPauseFlag$volatile$FU3 = atomicLongFieldUpdater;
                    bufferedChannel = this;
                } else {
                    return;
                }
            }
        }
    }

    public SelectClause2<E, BufferedChannel<E>> getOnSend() {
        BufferedChannel$onSend$1 bufferedChannel$onSend$1 = BufferedChannel$onSend$1.INSTANCE;
        Intrinsics.checkNotNull(bufferedChannel$onSend$1, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = \"clauseObject\")] kotlin.Any, @[ParameterName(name = \"select\")] kotlinx.coroutines.selects.SelectInstance<*>, @[ParameterName(name = \"param\")] kotlin.Any?, kotlin.Unit>");
        BufferedChannel$onSend$2 bufferedChannel$onSend$2 = BufferedChannel$onSend$2.INSTANCE;
        Intrinsics.checkNotNull(bufferedChannel$onSend$2, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = \"clauseObject\")] kotlin.Any, @[ParameterName(name = \"param\")] kotlin.Any?, @[ParameterName(name = \"clauseResult\")] kotlin.Any?, kotlin.Any?>");
        Function3 function3 = (Function3) TypeIntrinsics.beforeCheckcastToFunctionOfArity(bufferedChannel$onSend$1, 3);
        return new SelectClause2Impl<>(this, function3, (Function3) TypeIntrinsics.beforeCheckcastToFunctionOfArity(bufferedChannel$onSend$2, 3), (Function3) null, 8, (DefaultConstructorMarker) null);
    }

    private final void onClosedSelectOnSend(E e, SelectInstance<?> selectInstance) {
        Function1<E, Unit> function1 = this.onUndeliveredElement;
        if (function1 != null) {
            OnUndeliveredElementKt.callUndeliveredElement(function1, e, selectInstance.getContext());
        }
        selectInstance.selectInRegistrationPhase(BufferedChannelKt.getCHANNEL_CLOSED());
    }

    /* access modifiers changed from: private */
    public final Object processResultSelectSend(Object obj, Object obj2) {
        if (obj2 != BufferedChannelKt.getCHANNEL_CLOSED()) {
            return this;
        }
        throw getSendException();
    }

    public SelectClause1<E> getOnReceive() {
        BufferedChannel$onReceive$1 bufferedChannel$onReceive$1 = BufferedChannel$onReceive$1.INSTANCE;
        Intrinsics.checkNotNull(bufferedChannel$onReceive$1, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = \"clauseObject\")] kotlin.Any, @[ParameterName(name = \"select\")] kotlinx.coroutines.selects.SelectInstance<*>, @[ParameterName(name = \"param\")] kotlin.Any?, kotlin.Unit>");
        BufferedChannel$onReceive$2 bufferedChannel$onReceive$2 = BufferedChannel$onReceive$2.INSTANCE;
        Intrinsics.checkNotNull(bufferedChannel$onReceive$2, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = \"clauseObject\")] kotlin.Any, @[ParameterName(name = \"param\")] kotlin.Any?, @[ParameterName(name = \"clauseResult\")] kotlin.Any?, kotlin.Any?>");
        return new SelectClause1Impl<>(this, (Function3) TypeIntrinsics.beforeCheckcastToFunctionOfArity(bufferedChannel$onReceive$1, 3), (Function3) TypeIntrinsics.beforeCheckcastToFunctionOfArity(bufferedChannel$onReceive$2, 3), this.onUndeliveredElementReceiveCancellationConstructor);
    }

    public SelectClause1<ChannelResult<E>> getOnReceiveCatching() {
        BufferedChannel$onReceiveCatching$1 bufferedChannel$onReceiveCatching$1 = BufferedChannel$onReceiveCatching$1.INSTANCE;
        Intrinsics.checkNotNull(bufferedChannel$onReceiveCatching$1, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = \"clauseObject\")] kotlin.Any, @[ParameterName(name = \"select\")] kotlinx.coroutines.selects.SelectInstance<*>, @[ParameterName(name = \"param\")] kotlin.Any?, kotlin.Unit>");
        BufferedChannel$onReceiveCatching$2 bufferedChannel$onReceiveCatching$2 = BufferedChannel$onReceiveCatching$2.INSTANCE;
        Intrinsics.checkNotNull(bufferedChannel$onReceiveCatching$2, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = \"clauseObject\")] kotlin.Any, @[ParameterName(name = \"param\")] kotlin.Any?, @[ParameterName(name = \"clauseResult\")] kotlin.Any?, kotlin.Any?>");
        return new SelectClause1Impl<>(this, (Function3) TypeIntrinsics.beforeCheckcastToFunctionOfArity(bufferedChannel$onReceiveCatching$1, 3), (Function3) TypeIntrinsics.beforeCheckcastToFunctionOfArity(bufferedChannel$onReceiveCatching$2, 3), this.onUndeliveredElementReceiveCancellationConstructor);
    }

    public SelectClause1<E> getOnReceiveOrNull() {
        BufferedChannel$onReceiveOrNull$1 bufferedChannel$onReceiveOrNull$1 = BufferedChannel$onReceiveOrNull$1.INSTANCE;
        Intrinsics.checkNotNull(bufferedChannel$onReceiveOrNull$1, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = \"clauseObject\")] kotlin.Any, @[ParameterName(name = \"select\")] kotlinx.coroutines.selects.SelectInstance<*>, @[ParameterName(name = \"param\")] kotlin.Any?, kotlin.Unit>");
        BufferedChannel$onReceiveOrNull$2 bufferedChannel$onReceiveOrNull$2 = BufferedChannel$onReceiveOrNull$2.INSTANCE;
        Intrinsics.checkNotNull(bufferedChannel$onReceiveOrNull$2, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = \"clauseObject\")] kotlin.Any, @[ParameterName(name = \"param\")] kotlin.Any?, @[ParameterName(name = \"clauseResult\")] kotlin.Any?, kotlin.Any?>");
        return new SelectClause1Impl<>(this, (Function3) TypeIntrinsics.beforeCheckcastToFunctionOfArity(bufferedChannel$onReceiveOrNull$1, 3), (Function3) TypeIntrinsics.beforeCheckcastToFunctionOfArity(bufferedChannel$onReceiveOrNull$2, 3), this.onUndeliveredElementReceiveCancellationConstructor);
    }

    private final void onClosedSelectOnReceive(SelectInstance<?> selectInstance) {
        selectInstance.selectInRegistrationPhase(BufferedChannelKt.getCHANNEL_CLOSED());
    }

    /* access modifiers changed from: private */
    public final Object processResultSelectReceive(Object obj, Object obj2) {
        if (obj2 != BufferedChannelKt.getCHANNEL_CLOSED()) {
            return obj2;
        }
        throw getReceiveException();
    }

    /* access modifiers changed from: private */
    public final Object processResultSelectReceiveOrNull(Object obj, Object obj2) {
        if (obj2 != BufferedChannelKt.getCHANNEL_CLOSED()) {
            return obj2;
        }
        if (getCloseCause() == null) {
            return null;
        }
        throw getReceiveException();
    }

    /* access modifiers changed from: private */
    public final Object processResultSelectReceiveCatching(Object obj, Object obj2) {
        Object obj3;
        if (obj2 == BufferedChannelKt.getCHANNEL_CLOSED()) {
            obj3 = ChannelResult.Companion.m2063closedJP2dKIU(getCloseCause());
        } else {
            obj3 = ChannelResult.Companion.m2065successJP2dKIU(obj2);
        }
        return ChannelResult.m2050boximpl(obj3);
    }

    /* access modifiers changed from: private */
    public static final Function3 onUndeliveredElementReceiveCancellationConstructor$lambda$57$lambda$56(BufferedChannel bufferedChannel, SelectInstance selectInstance, Object obj, Object obj2) {
        return new BufferedChannel$$ExternalSyntheticLambda0(obj2, bufferedChannel, selectInstance);
    }

    /* access modifiers changed from: private */
    public static final Unit onUndeliveredElementReceiveCancellationConstructor$lambda$57$lambda$56$lambda$55(Object obj, BufferedChannel bufferedChannel, SelectInstance selectInstance, Throwable th, Object obj2, CoroutineContext coroutineContext) {
        if (obj != BufferedChannelKt.getCHANNEL_CLOSED()) {
            OnUndeliveredElementKt.callUndeliveredElement(bufferedChannel.onUndeliveredElement, obj, selectInstance.getContext());
        }
        return Unit.INSTANCE;
    }

    public ChannelIterator<E> iterator() {
        return new BufferedChannelIterator();
    }

    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000e\u0010\n\u001a\u00020\tHB¢\u0006\u0002\u0010\u000bJ\b\u0010\f\u001a\u00020\tH\u0002J,\u0010\r\u001a\u00020\t2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H@¢\u0006\u0002\u0010\u0014J\u001c\u0010\u0015\u001a\u00020\u00162\n\u0010\u000e\u001a\u0006\u0012\u0002\b\u00030\u00172\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0018\u001a\u00020\u0016H\u0002J\u000e\u0010\u0019\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010\u001aJ\u0013\u0010\u001b\u001a\u00020\t2\u0006\u0010\u001c\u001a\u00028\u0000¢\u0006\u0002\u0010\u001dJ\u0006\u0010\u001e\u001a\u00020\u0016R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lkotlinx/coroutines/channels/BufferedChannel$BufferedChannelIterator;", "Lkotlinx/coroutines/channels/ChannelIterator;", "Lkotlinx/coroutines/Waiter;", "<init>", "(Lkotlinx/coroutines/channels/BufferedChannel;)V", "receiveResult", "", "continuation", "Lkotlinx/coroutines/CancellableContinuationImpl;", "", "hasNext", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onClosedHasNext", "hasNextOnNoWaiterSuspend", "segment", "Lkotlinx/coroutines/channels/ChannelSegment;", "index", "", "r", "", "(Lkotlinx/coroutines/channels/ChannelSegment;IJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "invokeOnCancellation", "", "Lkotlinx/coroutines/internal/Segment;", "onClosedHasNextNoWaiterSuspend", "next", "()Ljava/lang/Object;", "tryResumeHasNext", "element", "(Ljava/lang/Object;)Z", "tryResumeHasNextOnClosedChannel", "kotlinx-coroutines-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* compiled from: BufferedChannel.kt */
    private final class BufferedChannelIterator implements ChannelIterator<E>, Waiter {
        /* access modifiers changed from: private */
        public CancellableContinuationImpl<? super Boolean> continuation;
        /* access modifiers changed from: private */
        public Object receiveResult = BufferedChannelKt.NO_RECEIVE_RESULT;

        public BufferedChannelIterator() {
        }

        @Deprecated(level = DeprecationLevel.HIDDEN, message = "Since 1.3.0, binary compatibility with versions <= 1.2.x")
        public /* synthetic */ Object next(Continuation continuation2) {
            return ChannelIterator.DefaultImpls.next(this, continuation2);
        }

        public Object hasNext(Continuation<? super Boolean> continuation2) {
            ChannelSegment channelSegment;
            boolean z = true;
            if (this.receiveResult == BufferedChannelKt.NO_RECEIVE_RESULT || this.receiveResult == BufferedChannelKt.getCHANNEL_CLOSED()) {
                BufferedChannel<E> bufferedChannel = BufferedChannel.this;
                ChannelSegment channelSegment2 = (ChannelSegment) BufferedChannel.receiveSegment$volatile$FU.get(bufferedChannel);
                while (!bufferedChannel.isClosedForReceive()) {
                    long andIncrement = BufferedChannel.receivers$volatile$FU.getAndIncrement(bufferedChannel);
                    long j = andIncrement / ((long) BufferedChannelKt.SEGMENT_SIZE);
                    int i = (int) (andIncrement % ((long) BufferedChannelKt.SEGMENT_SIZE));
                    if (channelSegment2.id != j) {
                        channelSegment = bufferedChannel.findSegmentReceive(j, channelSegment2);
                        if (channelSegment == null) {
                            continue;
                        }
                    } else {
                        channelSegment = channelSegment2;
                    }
                    int i2 = i;
                    Object access$updateCellReceive = bufferedChannel.updateCellReceive(channelSegment, i2, andIncrement, (Object) null);
                    if (access$updateCellReceive == BufferedChannelKt.SUSPEND) {
                        throw new IllegalStateException("unreachable".toString());
                    } else if (access$updateCellReceive == BufferedChannelKt.FAILED) {
                        if (andIncrement < bufferedChannel.getSendersCounter$kotlinx_coroutines_core()) {
                            channelSegment.cleanPrev();
                        }
                        channelSegment2 = channelSegment;
                    } else if (access$updateCellReceive == BufferedChannelKt.SUSPEND_NO_WAITER) {
                        long j2 = andIncrement;
                        int i3 = i2;
                        ChannelSegment channelSegment3 = channelSegment;
                        return hasNextOnNoWaiterSuspend(channelSegment3, i3, j2, continuation2);
                    } else {
                        channelSegment.cleanPrev();
                        this.receiveResult = access$updateCellReceive;
                        return Boxing.boxBoolean(z);
                    }
                }
                z = onClosedHasNext();
            }
            return Boxing.boxBoolean(z);
        }

        private final boolean onClosedHasNext() {
            this.receiveResult = BufferedChannelKt.getCHANNEL_CLOSED();
            Throwable closeCause = BufferedChannel.this.getCloseCause();
            if (closeCause == null) {
                return false;
            }
            throw StackTraceRecoveryKt.recoverStackTrace(closeCause);
        }

        /* JADX WARNING: type inference failed for: r13v0 */
        /* JADX WARNING: type inference failed for: r13v2, types: [kotlin.jvm.functions.Function3] */
        /* JADX WARNING: type inference failed for: r13v3, types: [kotlinx.coroutines.Waiter] */
        /* JADX WARNING: type inference failed for: r13v7 */
        /* JADX WARNING: type inference failed for: r13v8 */
        /* JADX WARNING: type inference failed for: r13v9 */
        /* access modifiers changed from: private */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object hasNextOnNoWaiterSuspend(kotlinx.coroutines.channels.ChannelSegment<E> r10, int r11, long r12, kotlin.coroutines.Continuation<? super java.lang.Boolean> r14) {
            /*
                r9 = this;
                kotlinx.coroutines.channels.BufferedChannel<E> r0 = kotlinx.coroutines.channels.BufferedChannel.this
                kotlin.coroutines.Continuation r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.intercepted(r14)
                kotlinx.coroutines.CancellableContinuationImpl r6 = kotlinx.coroutines.CancellableContinuationKt.getOrCreateCancellableContinuation(r1)
                r9.continuation = r6     // Catch:{ all -> 0x00ee }
                r5 = r9
                kotlinx.coroutines.Waiter r5 = (kotlinx.coroutines.Waiter) r5     // Catch:{ all -> 0x00ee }
                r1 = r10
                r2 = r11
                r3 = r12
                java.lang.Object r10 = r0.updateCellReceive(r1, r2, r3, r5)     // Catch:{ all -> 0x00ee }
                kotlinx.coroutines.internal.Symbol r11 = kotlinx.coroutines.channels.BufferedChannelKt.SUSPEND     // Catch:{ all -> 0x00ee }
                if (r10 != r11) goto L_0x0025
                r10 = r9
                kotlinx.coroutines.Waiter r10 = (kotlinx.coroutines.Waiter) r10     // Catch:{ all -> 0x00ee }
                r0.prepareReceiverForSuspension(r10, r1, r2)     // Catch:{ all -> 0x00ee }
                goto L_0x00e0
            L_0x0025:
                kotlinx.coroutines.internal.Symbol r11 = kotlinx.coroutines.channels.BufferedChannelKt.FAILED     // Catch:{ all -> 0x00ee }
                r12 = 1
                r13 = 0
                if (r10 != r11) goto L_0x00ca
                long r10 = r0.getSendersCounter$kotlinx_coroutines_core()     // Catch:{ all -> 0x00ee }
                int r10 = (r3 > r10 ? 1 : (r3 == r10 ? 0 : -1))
                if (r10 >= 0) goto L_0x0038
                r1.cleanPrev()     // Catch:{ all -> 0x00ee }
            L_0x0038:
                java.util.concurrent.atomic.AtomicReferenceFieldUpdater r10 = kotlinx.coroutines.channels.BufferedChannel.receiveSegment$volatile$FU     // Catch:{ all -> 0x00ee }
                java.lang.Object r10 = r10.get(r0)     // Catch:{ all -> 0x00ee }
                kotlinx.coroutines.channels.ChannelSegment r10 = (kotlinx.coroutines.channels.ChannelSegment) r10     // Catch:{ all -> 0x00ee }
            L_0x0042:
                boolean r11 = r0.isClosedForReceive()     // Catch:{ all -> 0x00ee }
                if (r11 == 0) goto L_0x004d
                r9.onClosedHasNextNoWaiterSuspend()     // Catch:{ all -> 0x00ee }
                goto L_0x00e0
            L_0x004d:
                java.util.concurrent.atomic.AtomicLongFieldUpdater r11 = kotlinx.coroutines.channels.BufferedChannel.receivers$volatile$FU     // Catch:{ all -> 0x00ee }
                long r3 = r11.getAndIncrement(r0)     // Catch:{ all -> 0x00ee }
                int r11 = kotlinx.coroutines.channels.BufferedChannelKt.SEGMENT_SIZE     // Catch:{ all -> 0x00ee }
                long r1 = (long) r11     // Catch:{ all -> 0x00ee }
                long r1 = r3 / r1
                int r11 = kotlinx.coroutines.channels.BufferedChannelKt.SEGMENT_SIZE     // Catch:{ all -> 0x00ee }
                long r7 = (long) r11     // Catch:{ all -> 0x00ee }
                long r7 = r3 % r7
                int r11 = (int) r7     // Catch:{ all -> 0x00ee }
                long r7 = r10.id     // Catch:{ all -> 0x00ee }
                int r5 = (r7 > r1 ? 1 : (r7 == r1 ? 0 : -1))
                if (r5 == 0) goto L_0x006d
                kotlinx.coroutines.channels.ChannelSegment r1 = r0.findSegmentReceive(r1, r10)     // Catch:{ all -> 0x00ee }
                if (r1 != 0) goto L_0x006e
                goto L_0x0042
            L_0x006d:
                r1 = r10
            L_0x006e:
                r5 = r9
                kotlinx.coroutines.Waiter r5 = (kotlinx.coroutines.Waiter) r5     // Catch:{ all -> 0x00ee }
                r2 = r11
                java.lang.Object r10 = r0.updateCellReceive(r1, r2, r3, r5)     // Catch:{ all -> 0x00ee }
                kotlinx.coroutines.internal.Symbol r11 = kotlinx.coroutines.channels.BufferedChannelKt.SUSPEND     // Catch:{ all -> 0x00ee }
                if (r10 != r11) goto L_0x008c
                r10 = r9
                kotlinx.coroutines.Waiter r10 = (kotlinx.coroutines.Waiter) r10     // Catch:{ all -> 0x00ee }
                boolean r10 = r10 instanceof kotlinx.coroutines.Waiter     // Catch:{ all -> 0x00ee }
                if (r10 == 0) goto L_0x0086
                r13 = r9
                kotlinx.coroutines.Waiter r13 = (kotlinx.coroutines.Waiter) r13     // Catch:{ all -> 0x00ee }
            L_0x0086:
                if (r13 == 0) goto L_0x00e0
                r0.prepareReceiverForSuspension(r13, r1, r2)     // Catch:{ all -> 0x00ee }
                goto L_0x00e0
            L_0x008c:
                kotlinx.coroutines.internal.Symbol r11 = kotlinx.coroutines.channels.BufferedChannelKt.FAILED     // Catch:{ all -> 0x00ee }
                if (r10 != r11) goto L_0x009f
                long r10 = r0.getSendersCounter$kotlinx_coroutines_core()     // Catch:{ all -> 0x00ee }
                int r10 = (r3 > r10 ? 1 : (r3 == r10 ? 0 : -1))
                if (r10 >= 0) goto L_0x009d
                r1.cleanPrev()     // Catch:{ all -> 0x00ee }
            L_0x009d:
                r10 = r1
                goto L_0x0042
            L_0x009f:
                kotlinx.coroutines.internal.Symbol r11 = kotlinx.coroutines.channels.BufferedChannelKt.SUSPEND_NO_WAITER     // Catch:{ all -> 0x00ee }
                if (r10 == r11) goto L_0x00be
                r1.cleanPrev()     // Catch:{ all -> 0x00ee }
                r9.receiveResult = r10     // Catch:{ all -> 0x00ee }
                r9.continuation = r13     // Catch:{ all -> 0x00ee }
                java.lang.Boolean r11 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r12)     // Catch:{ all -> 0x00ee }
                kotlin.jvm.functions.Function1<E, kotlin.Unit> r12 = r0.onUndeliveredElement     // Catch:{ all -> 0x00ee }
                if (r12 == 0) goto L_0x00ba
                kotlin.jvm.functions.Function3 r13 = r0.bindCancellationFun(r12, r10)     // Catch:{ all -> 0x00ee }
            L_0x00ba:
                r6.resume(r11, r13)     // Catch:{ all -> 0x00ee }
                goto L_0x00e0
            L_0x00be:
                java.lang.IllegalStateException r10 = new java.lang.IllegalStateException     // Catch:{ all -> 0x00ee }
                java.lang.String r11 = "unexpected"
                java.lang.String r11 = r11.toString()     // Catch:{ all -> 0x00ee }
                r10.<init>(r11)     // Catch:{ all -> 0x00ee }
                throw r10     // Catch:{ all -> 0x00ee }
            L_0x00ca:
                r1.cleanPrev()     // Catch:{ all -> 0x00ee }
                r9.receiveResult = r10     // Catch:{ all -> 0x00ee }
                r9.continuation = r13     // Catch:{ all -> 0x00ee }
                java.lang.Boolean r11 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r12)     // Catch:{ all -> 0x00ee }
                kotlin.jvm.functions.Function1<E, kotlin.Unit> r12 = r0.onUndeliveredElement     // Catch:{ all -> 0x00ee }
                if (r12 == 0) goto L_0x00ba
                kotlin.jvm.functions.Function3 r13 = r0.bindCancellationFun(r12, r10)     // Catch:{ all -> 0x00ee }
                goto L_0x00ba
            L_0x00e0:
                java.lang.Object r10 = r6.getResult()
                java.lang.Object r11 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                if (r10 != r11) goto L_0x00ed
                kotlin.coroutines.jvm.internal.DebugProbesKt.probeCoroutineSuspended(r14)
            L_0x00ed:
                return r10
            L_0x00ee:
                r0 = move-exception
                r10 = r0
                r6.releaseClaimedReusableContinuation$kotlinx_coroutines_core()
                throw r10
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.BufferedChannel.BufferedChannelIterator.hasNextOnNoWaiterSuspend(kotlinx.coroutines.channels.ChannelSegment, int, long, kotlin.coroutines.Continuation):java.lang.Object");
        }

        public void invokeOnCancellation(Segment<?> segment, int i) {
            CancellableContinuationImpl<? super Boolean> cancellableContinuationImpl = this.continuation;
            if (cancellableContinuationImpl != null) {
                cancellableContinuationImpl.invokeOnCancellation(segment, i);
            }
        }

        /* access modifiers changed from: private */
        public final void onClosedHasNextNoWaiterSuspend() {
            CancellableContinuationImpl<? super Boolean> cancellableContinuationImpl = this.continuation;
            Intrinsics.checkNotNull(cancellableContinuationImpl);
            this.continuation = null;
            this.receiveResult = BufferedChannelKt.getCHANNEL_CLOSED();
            Throwable closeCause = BufferedChannel.this.getCloseCause();
            if (closeCause == null) {
                Result.Companion companion = Result.Companion;
                cancellableContinuationImpl.resumeWith(Result.m516constructorimpl(false));
                return;
            }
            Continuation continuation2 = cancellableContinuationImpl;
            if (DebugKt.getRECOVER_STACK_TRACES() && (continuation2 instanceof CoroutineStackFrame)) {
                closeCause = StackTraceRecoveryKt.recoverFromStackFrame(closeCause, (CoroutineStackFrame) continuation2);
            }
            Result.Companion companion2 = Result.Companion;
            continuation2.resumeWith(Result.m516constructorimpl(ResultKt.createFailure(closeCause)));
        }

        public E next() {
            E e = this.receiveResult;
            if (e != BufferedChannelKt.NO_RECEIVE_RESULT) {
                this.receiveResult = BufferedChannelKt.NO_RECEIVE_RESULT;
                if (e != BufferedChannelKt.getCHANNEL_CLOSED()) {
                    return e;
                }
                throw StackTraceRecoveryKt.recoverStackTrace(BufferedChannel.this.getReceiveException());
            }
            throw new IllegalStateException("`hasNext()` has not been invoked".toString());
        }

        public final boolean tryResumeHasNext(E e) {
            CancellableContinuationImpl<? super Boolean> cancellableContinuationImpl = this.continuation;
            Intrinsics.checkNotNull(cancellableContinuationImpl);
            Function3 function3 = null;
            this.continuation = null;
            this.receiveResult = e;
            CancellableContinuation cancellableContinuation = cancellableContinuationImpl;
            Function1<E, Unit> function1 = BufferedChannel.this.onUndeliveredElement;
            if (function1 != null) {
                function3 = BufferedChannel.this.bindCancellationFun(function1, e);
            }
            return BufferedChannelKt.tryResume0(cancellableContinuation, true, function3);
        }

        public final void tryResumeHasNextOnClosedChannel() {
            CancellableContinuationImpl<? super Boolean> cancellableContinuationImpl = this.continuation;
            Intrinsics.checkNotNull(cancellableContinuationImpl);
            this.continuation = null;
            this.receiveResult = BufferedChannelKt.getCHANNEL_CLOSED();
            Throwable closeCause = BufferedChannel.this.getCloseCause();
            if (closeCause == null) {
                Result.Companion companion = Result.Companion;
                cancellableContinuationImpl.resumeWith(Result.m516constructorimpl(false));
                return;
            }
            Continuation continuation2 = cancellableContinuationImpl;
            if (DebugKt.getRECOVER_STACK_TRACES() && (continuation2 instanceof CoroutineStackFrame)) {
                closeCause = StackTraceRecoveryKt.recoverFromStackFrame(closeCause, (CoroutineStackFrame) continuation2);
            }
            Result.Companion companion2 = Result.Companion;
            continuation2.resumeWith(Result.m516constructorimpl(ResultKt.createFailure(closeCause)));
        }
    }

    /* access modifiers changed from: protected */
    public final Throwable getCloseCause() {
        return (Throwable) _closeCause$volatile$FU.get(this);
    }

    /* access modifiers changed from: protected */
    public final Throwable getSendException() {
        Throwable closeCause = getCloseCause();
        return closeCause == null ? new ClosedSendChannelException(ChannelsKt.DEFAULT_CLOSE_MESSAGE) : closeCause;
    }

    /* access modifiers changed from: private */
    public final Throwable getReceiveException() {
        Throwable closeCause = getCloseCause();
        return closeCause == null ? new ClosedReceiveChannelException(ChannelsKt.DEFAULT_CLOSE_MESSAGE) : closeCause;
    }

    public boolean close(Throwable th) {
        return closeOrCancelImpl(th, false);
    }

    public final boolean cancel(Throwable th) {
        return cancelImpl$kotlinx_coroutines_core(th);
    }

    public final void cancel() {
        cancelImpl$kotlinx_coroutines_core((Throwable) null);
    }

    public final void cancel(CancellationException cancellationException) {
        cancelImpl$kotlinx_coroutines_core(cancellationException);
    }

    public boolean cancelImpl$kotlinx_coroutines_core(Throwable th) {
        if (th == null) {
            th = new CancellationException("Channel was cancelled");
        }
        return closeOrCancelImpl(th, true);
    }

    /* access modifiers changed from: protected */
    public boolean closeOrCancelImpl(Throwable th, boolean z) {
        if (z) {
            markCancellationStarted();
        }
        boolean m = AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(_closeCause$volatile$FU, this, BufferedChannelKt.NO_CLOSE_CAUSE, th);
        if (z) {
            markCancelled();
        } else {
            markClosed();
        }
        completeCloseOrCancel();
        onClosedIdempotent();
        if (m) {
            invokeCloseHandler();
        }
        return m;
    }

    private final void invokeCloseHandler() {
        Object obj;
        Symbol symbol;
        AtomicReferenceFieldUpdater closeHandler$volatile$FU2 = closeHandler$volatile$FU;
        do {
            obj = closeHandler$volatile$FU2.get(this);
            if (obj == null) {
                symbol = BufferedChannelKt.CLOSE_HANDLER_CLOSED;
            } else {
                symbol = BufferedChannelKt.CLOSE_HANDLER_INVOKED;
            }
        } while (!AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(closeHandler$volatile$FU2, this, obj, symbol));
        if (obj != null) {
            Function1 function1 = (Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(obj, 1);
            ((Function1) obj).invoke(getCloseCause());
        }
    }

    public void invokeOnClose(Function1<? super Throwable, Unit> function1) {
        if (!AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(closeHandler$volatile$FU, this, (Object) null, function1)) {
            AtomicReferenceFieldUpdater closeHandler$volatile$FU2 = closeHandler$volatile$FU;
            do {
                Object obj = closeHandler$volatile$FU2.get(this);
                if (obj != BufferedChannelKt.CLOSE_HANDLER_CLOSED) {
                    if (obj == BufferedChannelKt.CLOSE_HANDLER_INVOKED) {
                        throw new IllegalStateException("Another handler was already registered and successfully invoked".toString());
                    }
                    throw new IllegalStateException(("Another handler is already registered: " + obj).toString());
                }
            } while (!AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(closeHandler$volatile$FU, this, BufferedChannelKt.CLOSE_HANDLER_CLOSED, BufferedChannelKt.CLOSE_HANDLER_INVOKED));
            function1.invoke(getCloseCause());
        }
    }

    private final void markClosed() {
        long j;
        long j2;
        AtomicLongFieldUpdater sendersAndCloseStatus$volatile$FU2 = sendersAndCloseStatus$volatile$FU;
        do {
            j = sendersAndCloseStatus$volatile$FU2.get(this);
            int i = (int) (j >> 60);
            if (i == 0) {
                j2 = BufferedChannelKt.constructSendersAndCloseStatus(1152921504606846975L & j, 2);
            } else if (i == 1) {
                j2 = BufferedChannelKt.constructSendersAndCloseStatus(1152921504606846975L & j, 3);
            } else {
                return;
            }
        } while (!sendersAndCloseStatus$volatile$FU2.compareAndSet(this, j, j2));
    }

    private final void markCancelled() {
        long j;
        AtomicLongFieldUpdater sendersAndCloseStatus$volatile$FU2 = sendersAndCloseStatus$volatile$FU;
        do {
            j = sendersAndCloseStatus$volatile$FU2.get(this);
        } while (!sendersAndCloseStatus$volatile$FU2.compareAndSet(this, j, BufferedChannelKt.constructSendersAndCloseStatus(1152921504606846975L & j, 3)));
    }

    private final void markCancellationStarted() {
        long j;
        AtomicLongFieldUpdater sendersAndCloseStatus$volatile$FU2 = sendersAndCloseStatus$volatile$FU;
        do {
            j = sendersAndCloseStatus$volatile$FU2.get(this);
            if (((int) (j >> 60)) != 0) {
                return;
            }
        } while (!sendersAndCloseStatus$volatile$FU2.compareAndSet(this, j, BufferedChannelKt.constructSendersAndCloseStatus(1152921504606846975L & j, 1)));
    }

    private final void completeCloseOrCancel() {
        isClosedForSend();
    }

    private final ChannelSegment<E> completeClose(long j) {
        ChannelSegment<E> closeLinkedList = closeLinkedList();
        if (isConflatedDropOldest()) {
            long markAllEmptyCellsAsClosed = markAllEmptyCellsAsClosed(closeLinkedList);
            if (markAllEmptyCellsAsClosed != -1) {
                dropFirstElementUntilTheSpecifiedCellIsInTheBuffer(markAllEmptyCellsAsClosed);
            }
        }
        cancelSuspendedReceiveRequests(closeLinkedList, j);
        return closeLinkedList;
    }

    private final void completeCancel(long j) {
        removeUnprocessedElements(completeClose(j));
    }

    private final ChannelSegment<E> closeLinkedList() {
        ChannelSegment channelSegment = bufferEndSegment$volatile$FU.get(this);
        ChannelSegment channelSegment2 = (ChannelSegment) sendSegment$volatile$FU.get(this);
        if (channelSegment2.id > ((ChannelSegment) channelSegment).id) {
            channelSegment = channelSegment2;
        }
        ChannelSegment channelSegment3 = (ChannelSegment) receiveSegment$volatile$FU.get(this);
        if (channelSegment3.id > ((ChannelSegment) channelSegment).id) {
            channelSegment = channelSegment3;
        }
        return (ChannelSegment) ConcurrentLinkedListKt.close((ConcurrentLinkedListNode) channelSegment);
    }

    private final long markAllEmptyCellsAsClosed(ChannelSegment<E> channelSegment) {
        do {
            int i = BufferedChannelKt.SEGMENT_SIZE;
            while (true) {
                i--;
                if (-1 < i) {
                    long j = (channelSegment.id * ((long) BufferedChannelKt.SEGMENT_SIZE)) + ((long) i);
                    if (j < getReceiversCounter$kotlinx_coroutines_core()) {
                        return -1;
                    }
                    while (true) {
                        Object state$kotlinx_coroutines_core = channelSegment.getState$kotlinx_coroutines_core(i);
                        if (state$kotlinx_coroutines_core == null || state$kotlinx_coroutines_core == BufferedChannelKt.IN_BUFFER) {
                            if (channelSegment.casState$kotlinx_coroutines_core(i, state$kotlinx_coroutines_core, BufferedChannelKt.getCHANNEL_CLOSED())) {
                                channelSegment.onSlotCleaned();
                                break;
                            }
                        } else if (state$kotlinx_coroutines_core == BufferedChannelKt.BUFFERED) {
                            return j;
                        }
                    }
                } else {
                    channelSegment = (ChannelSegment) channelSegment.getPrev();
                }
            }
        } while (channelSegment != null);
        return -1;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00b3, code lost:
        r12 = (kotlinx.coroutines.channels.ChannelSegment) r12.getPrev();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void removeUnprocessedElements(kotlinx.coroutines.channels.ChannelSegment<E> r12) {
        /*
            r11 = this;
            kotlin.jvm.functions.Function1<E, kotlin.Unit> r0 = r11.onUndeliveredElement
            r1 = 0
            r2 = 1
            java.lang.Object r3 = kotlinx.coroutines.internal.InlineList.m2098constructorimpl$default(r1, r2, r1)
        L_0x0008:
            int r4 = kotlinx.coroutines.channels.BufferedChannelKt.SEGMENT_SIZE
            int r4 = r4 - r2
        L_0x000b:
            r5 = -1
            if (r5 >= r4) goto L_0x00b3
            long r6 = r12.id
            int r8 = kotlinx.coroutines.channels.BufferedChannelKt.SEGMENT_SIZE
            long r8 = (long) r8
            long r6 = r6 * r8
            long r8 = (long) r4
            long r6 = r6 + r8
        L_0x0016:
            java.lang.Object r8 = r12.getState$kotlinx_coroutines_core(r4)
            kotlinx.coroutines.internal.Symbol r9 = kotlinx.coroutines.channels.BufferedChannelKt.DONE_RCV
            if (r8 == r9) goto L_0x00bb
            kotlinx.coroutines.internal.Symbol r9 = kotlinx.coroutines.channels.BufferedChannelKt.BUFFERED
            if (r8 != r9) goto L_0x0048
            long r9 = r11.getReceiversCounter$kotlinx_coroutines_core()
            int r9 = (r6 > r9 ? 1 : (r6 == r9 ? 0 : -1))
            if (r9 < 0) goto L_0x00bb
            kotlinx.coroutines.internal.Symbol r9 = kotlinx.coroutines.channels.BufferedChannelKt.getCHANNEL_CLOSED()
            boolean r8 = r12.casState$kotlinx_coroutines_core(r4, r8, r9)
            if (r8 == 0) goto L_0x0016
            if (r0 == 0) goto L_0x0040
            java.lang.Object r5 = r12.getElement$kotlinx_coroutines_core(r4)
            kotlinx.coroutines.internal.UndeliveredElementException r1 = kotlinx.coroutines.internal.OnUndeliveredElementKt.callUndeliveredElementCatchingException(r0, r5, r1)
        L_0x0040:
            r12.cleanElement$kotlinx_coroutines_core(r4)
            r12.onSlotCleaned()
            goto L_0x00af
        L_0x0048:
            kotlinx.coroutines.internal.Symbol r9 = kotlinx.coroutines.channels.BufferedChannelKt.IN_BUFFER
            if (r8 == r9) goto L_0x00a2
            if (r8 != 0) goto L_0x0051
            goto L_0x00a2
        L_0x0051:
            boolean r9 = r8 instanceof kotlinx.coroutines.Waiter
            if (r9 != 0) goto L_0x006e
            boolean r9 = r8 instanceof kotlinx.coroutines.channels.WaiterEB
            if (r9 == 0) goto L_0x005a
            goto L_0x006e
        L_0x005a:
            kotlinx.coroutines.internal.Symbol r9 = kotlinx.coroutines.channels.BufferedChannelKt.RESUMING_BY_EB
            if (r8 == r9) goto L_0x00bb
            kotlinx.coroutines.internal.Symbol r9 = kotlinx.coroutines.channels.BufferedChannelKt.RESUMING_BY_RCV
            if (r8 != r9) goto L_0x0067
            goto L_0x00bb
        L_0x0067:
            kotlinx.coroutines.internal.Symbol r9 = kotlinx.coroutines.channels.BufferedChannelKt.RESUMING_BY_EB
            if (r8 == r9) goto L_0x0016
            goto L_0x00af
        L_0x006e:
            long r9 = r11.getReceiversCounter$kotlinx_coroutines_core()
            int r9 = (r6 > r9 ? 1 : (r6 == r9 ? 0 : -1))
            if (r9 < 0) goto L_0x00bb
            boolean r9 = r8 instanceof kotlinx.coroutines.channels.WaiterEB
            if (r9 == 0) goto L_0x0080
            r9 = r8
            kotlinx.coroutines.channels.WaiterEB r9 = (kotlinx.coroutines.channels.WaiterEB) r9
            kotlinx.coroutines.Waiter r9 = r9.waiter
            goto L_0x0083
        L_0x0080:
            r9 = r8
            kotlinx.coroutines.Waiter r9 = (kotlinx.coroutines.Waiter) r9
        L_0x0083:
            kotlinx.coroutines.internal.Symbol r10 = kotlinx.coroutines.channels.BufferedChannelKt.getCHANNEL_CLOSED()
            boolean r8 = r12.casState$kotlinx_coroutines_core(r4, r8, r10)
            if (r8 == 0) goto L_0x0016
            if (r0 == 0) goto L_0x0097
            java.lang.Object r5 = r12.getElement$kotlinx_coroutines_core(r4)
            kotlinx.coroutines.internal.UndeliveredElementException r1 = kotlinx.coroutines.internal.OnUndeliveredElementKt.callUndeliveredElementCatchingException(r0, r5, r1)
        L_0x0097:
            java.lang.Object r3 = kotlinx.coroutines.internal.InlineList.m2103plusFjFbRPM(r3, r9)
            r12.cleanElement$kotlinx_coroutines_core(r4)
            r12.onSlotCleaned()
            goto L_0x00af
        L_0x00a2:
            kotlinx.coroutines.internal.Symbol r9 = kotlinx.coroutines.channels.BufferedChannelKt.getCHANNEL_CLOSED()
            boolean r8 = r12.casState$kotlinx_coroutines_core(r4, r8, r9)
            if (r8 == 0) goto L_0x0016
            r12.onSlotCleaned()
        L_0x00af:
            int r4 = r4 + -1
            goto L_0x000b
        L_0x00b3:
            kotlinx.coroutines.internal.ConcurrentLinkedListNode r12 = r12.getPrev()
            kotlinx.coroutines.channels.ChannelSegment r12 = (kotlinx.coroutines.channels.ChannelSegment) r12
            if (r12 != 0) goto L_0x0008
        L_0x00bb:
            if (r3 == 0) goto L_0x00e1
            boolean r12 = r3 instanceof java.util.ArrayList
            if (r12 != 0) goto L_0x00c7
            kotlinx.coroutines.Waiter r3 = (kotlinx.coroutines.Waiter) r3
            r11.resumeSenderOnCancelledChannel(r3)
            goto L_0x00e1
        L_0x00c7:
            java.lang.String r12 = "null cannot be cast to non-null type java.util.ArrayList<E of kotlinx.coroutines.internal.InlineList>"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r3, r12)
            java.util.ArrayList r3 = (java.util.ArrayList) r3
            int r12 = r3.size()
            int r12 = r12 - r2
        L_0x00d3:
            if (r5 >= r12) goto L_0x00e1
            java.lang.Object r0 = r3.get(r12)
            kotlinx.coroutines.Waiter r0 = (kotlinx.coroutines.Waiter) r0
            r11.resumeSenderOnCancelledChannel(r0)
            int r12 = r12 + -1
            goto L_0x00d3
        L_0x00e1:
            if (r1 != 0) goto L_0x00e4
            return
        L_0x00e4:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.BufferedChannel.removeUnprocessedElements(kotlinx.coroutines.channels.ChannelSegment):void");
    }

    private final void cancelSuspendedReceiveRequests(ChannelSegment<E> channelSegment, long j) {
        Object r0 = InlineList.m2098constructorimpl$default((Object) null, 1, (DefaultConstructorMarker) null);
        loop0:
        while (channelSegment != null) {
            for (int i = BufferedChannelKt.SEGMENT_SIZE - 1; -1 < i; i--) {
                if ((channelSegment.id * ((long) BufferedChannelKt.SEGMENT_SIZE)) + ((long) i) < j) {
                    break loop0;
                }
                while (true) {
                    Object state$kotlinx_coroutines_core = channelSegment.getState$kotlinx_coroutines_core(i);
                    if (state$kotlinx_coroutines_core == null || state$kotlinx_coroutines_core == BufferedChannelKt.IN_BUFFER) {
                        if (channelSegment.casState$kotlinx_coroutines_core(i, state$kotlinx_coroutines_core, BufferedChannelKt.getCHANNEL_CLOSED())) {
                            channelSegment.onSlotCleaned();
                            break;
                        }
                    } else if (state$kotlinx_coroutines_core instanceof WaiterEB) {
                        if (channelSegment.casState$kotlinx_coroutines_core(i, state$kotlinx_coroutines_core, BufferedChannelKt.getCHANNEL_CLOSED())) {
                            r0 = InlineList.m2103plusFjFbRPM(r0, ((WaiterEB) state$kotlinx_coroutines_core).waiter);
                            channelSegment.onCancelledRequest(i, true);
                            break;
                        }
                    } else if (!(state$kotlinx_coroutines_core instanceof Waiter)) {
                        break;
                    } else if (channelSegment.casState$kotlinx_coroutines_core(i, state$kotlinx_coroutines_core, BufferedChannelKt.getCHANNEL_CLOSED())) {
                        r0 = InlineList.m2103plusFjFbRPM(r0, state$kotlinx_coroutines_core);
                        channelSegment.onCancelledRequest(i, true);
                        break;
                    }
                }
            }
            channelSegment = (ChannelSegment) channelSegment.getPrev();
        }
        if (r0 == null) {
            return;
        }
        if (!(r0 instanceof ArrayList)) {
            resumeReceiverOnClosedChannel((Waiter) r0);
            return;
        }
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type java.util.ArrayList<E of kotlinx.coroutines.internal.InlineList>");
        ArrayList arrayList = (ArrayList) r0;
        for (int size = arrayList.size() - 1; -1 < size; size--) {
            resumeReceiverOnClosedChannel((Waiter) arrayList.get(size));
        }
    }

    private final void resumeReceiverOnClosedChannel(Waiter waiter) {
        resumeWaiterOnClosedChannel(waiter, true);
    }

    private final void resumeSenderOnCancelledChannel(Waiter waiter) {
        resumeWaiterOnClosedChannel(waiter, false);
    }

    private final void resumeWaiterOnClosedChannel(Waiter waiter, boolean z) {
        if (waiter instanceof SendBroadcast) {
            Result.Companion companion = Result.Companion;
            ((SendBroadcast) waiter).getCont().resumeWith(Result.m516constructorimpl(false));
        } else if (waiter instanceof CancellableContinuation) {
            Continuation continuation = (Continuation) waiter;
            Result.Companion companion2 = Result.Companion;
            continuation.resumeWith(Result.m516constructorimpl(ResultKt.createFailure(z ? getReceiveException() : getSendException())));
        } else if (waiter instanceof ReceiveCatching) {
            Result.Companion companion3 = Result.Companion;
            ((ReceiveCatching) waiter).cont.resumeWith(Result.m516constructorimpl(ChannelResult.m2050boximpl(ChannelResult.Companion.m2063closedJP2dKIU(getCloseCause()))));
        } else if (waiter instanceof BufferedChannelIterator) {
            ((BufferedChannelIterator) waiter).tryResumeHasNextOnClosedChannel();
        } else if (waiter instanceof SelectInstance) {
            ((SelectInstance) waiter).trySelect(this, BufferedChannelKt.getCHANNEL_CLOSED());
        } else {
            throw new IllegalStateException(("Unexpected waiter: " + waiter).toString());
        }
    }

    public boolean isClosedForSend() {
        return isClosedForSend0(sendersAndCloseStatus$volatile$FU.get(this));
    }

    /* access modifiers changed from: private */
    public final boolean isClosedForSend0(long j) {
        return isClosed(j, false);
    }

    public boolean isClosedForReceive() {
        return isClosedForReceive0(sendersAndCloseStatus$volatile$FU.get(this));
    }

    private final boolean isClosedForReceive0(long j) {
        return isClosed(j, true);
    }

    private final boolean isClosed(long j, boolean z) {
        int i = (int) (j >> 60);
        if (i == 0 || i == 1) {
            return false;
        }
        if (i == 2) {
            completeClose(j & 1152921504606846975L);
            return !z || !hasElements$kotlinx_coroutines_core();
        } else if (i == 3) {
            completeCancel(j & 1152921504606846975L);
            return true;
        } else {
            throw new IllegalStateException(("unexpected close status: " + i).toString());
        }
    }

    public boolean isEmpty() {
        if (!isClosedForReceive() && !hasElements$kotlinx_coroutines_core()) {
            return !isClosedForReceive();
        }
        return false;
    }

    public final boolean hasElements$kotlinx_coroutines_core() {
        while (true) {
            ChannelSegment channelSegment = (ChannelSegment) receiveSegment$volatile$FU.get(this);
            long receiversCounter$kotlinx_coroutines_core = getReceiversCounter$kotlinx_coroutines_core();
            if (getSendersCounter$kotlinx_coroutines_core() <= receiversCounter$kotlinx_coroutines_core) {
                return false;
            }
            long j = receiversCounter$kotlinx_coroutines_core / ((long) BufferedChannelKt.SEGMENT_SIZE);
            if (channelSegment.id == j || (channelSegment = findSegmentReceive(j, channelSegment)) != null) {
                channelSegment.cleanPrev();
                if (isCellNonEmpty(channelSegment, (int) (receiversCounter$kotlinx_coroutines_core % ((long) BufferedChannelKt.SEGMENT_SIZE)), receiversCounter$kotlinx_coroutines_core)) {
                    return true;
                }
                receivers$volatile$FU.compareAndSet(this, receiversCounter$kotlinx_coroutines_core, 1 + receiversCounter$kotlinx_coroutines_core);
            } else if (((ChannelSegment) receiveSegment$volatile$FU.get(this)).id < j) {
                return false;
            }
        }
    }

    private final boolean isCellNonEmpty(ChannelSegment<E> channelSegment, int i, long j) {
        Object state$kotlinx_coroutines_core;
        do {
            state$kotlinx_coroutines_core = channelSegment.getState$kotlinx_coroutines_core(i);
            if (state$kotlinx_coroutines_core != null && state$kotlinx_coroutines_core != BufferedChannelKt.IN_BUFFER) {
                if (state$kotlinx_coroutines_core == BufferedChannelKt.BUFFERED) {
                    return true;
                }
                if (state$kotlinx_coroutines_core == BufferedChannelKt.INTERRUPTED_SEND || state$kotlinx_coroutines_core == BufferedChannelKt.getCHANNEL_CLOSED() || state$kotlinx_coroutines_core == BufferedChannelKt.DONE_RCV || state$kotlinx_coroutines_core == BufferedChannelKt.POISONED) {
                    return false;
                }
                if (state$kotlinx_coroutines_core == BufferedChannelKt.RESUMING_BY_EB) {
                    return true;
                }
                if (state$kotlinx_coroutines_core != BufferedChannelKt.RESUMING_BY_RCV && j == getReceiversCounter$kotlinx_coroutines_core()) {
                    return true;
                }
                return false;
            }
        } while (!channelSegment.casState$kotlinx_coroutines_core(i, state$kotlinx_coroutines_core, BufferedChannelKt.POISONED));
        expandBuffer();
        return false;
    }

    /* access modifiers changed from: private */
    public final ChannelSegment<E> findSegmentSend(long j, ChannelSegment<E> channelSegment) {
        Object findSegmentInternal;
        AtomicReferenceFieldUpdater sendSegment$volatile$FU2 = sendSegment$volatile$FU;
        Function2 function2 = (Function2) BufferedChannelKt.createSegmentFunction();
        loop0:
        while (true) {
            findSegmentInternal = ConcurrentLinkedListKt.findSegmentInternal(channelSegment, j, function2);
            if (SegmentOrClosed.m2112isClosedimpl(findSegmentInternal)) {
                break;
            }
            Segment r3 = SegmentOrClosed.m2110getSegmentimpl(findSegmentInternal);
            while (true) {
                Segment segment = (Segment) sendSegment$volatile$FU2.get(this);
                if (segment.id >= r3.id) {
                    break loop0;
                } else if (r3.tryIncPointers$kotlinx_coroutines_core()) {
                    if (AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(sendSegment$volatile$FU2, this, segment, r3)) {
                        if (segment.decPointers$kotlinx_coroutines_core()) {
                            segment.remove();
                        }
                    } else if (r3.decPointers$kotlinx_coroutines_core()) {
                        r3.remove();
                    }
                }
            }
        }
        if (SegmentOrClosed.m2112isClosedimpl(findSegmentInternal)) {
            completeCloseOrCancel();
            if (channelSegment.id * ((long) BufferedChannelKt.SEGMENT_SIZE) < getReceiversCounter$kotlinx_coroutines_core()) {
                channelSegment.cleanPrev();
            }
            return null;
        }
        ChannelSegment<E> channelSegment2 = (ChannelSegment) SegmentOrClosed.m2110getSegmentimpl(findSegmentInternal);
        if (channelSegment2.id > j) {
            updateSendersCounterIfLower(channelSegment2.id * ((long) BufferedChannelKt.SEGMENT_SIZE));
            if (channelSegment2.id * ((long) BufferedChannelKt.SEGMENT_SIZE) < getReceiversCounter$kotlinx_coroutines_core()) {
                channelSegment2.cleanPrev();
            }
            return null;
        } else if (!DebugKt.getASSERTIONS_ENABLED() || channelSegment2.id == j) {
            return channelSegment2;
        } else {
            throw new AssertionError();
        }
    }

    /* access modifiers changed from: private */
    public final ChannelSegment<E> findSegmentReceive(long j, ChannelSegment<E> channelSegment) {
        Object findSegmentInternal;
        AtomicReferenceFieldUpdater receiveSegment$volatile$FU2 = receiveSegment$volatile$FU;
        Function2 function2 = (Function2) BufferedChannelKt.createSegmentFunction();
        loop0:
        while (true) {
            findSegmentInternal = ConcurrentLinkedListKt.findSegmentInternal(channelSegment, j, function2);
            if (SegmentOrClosed.m2112isClosedimpl(findSegmentInternal)) {
                break;
            }
            Segment r3 = SegmentOrClosed.m2110getSegmentimpl(findSegmentInternal);
            while (true) {
                Segment segment = (Segment) receiveSegment$volatile$FU2.get(this);
                if (segment.id >= r3.id) {
                    break loop0;
                } else if (r3.tryIncPointers$kotlinx_coroutines_core()) {
                    if (AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(receiveSegment$volatile$FU2, this, segment, r3)) {
                        if (segment.decPointers$kotlinx_coroutines_core()) {
                            segment.remove();
                        }
                    } else if (r3.decPointers$kotlinx_coroutines_core()) {
                        r3.remove();
                    }
                }
            }
        }
        if (SegmentOrClosed.m2112isClosedimpl(findSegmentInternal)) {
            completeCloseOrCancel();
            if (channelSegment.id * ((long) BufferedChannelKt.SEGMENT_SIZE) < getSendersCounter$kotlinx_coroutines_core()) {
                channelSegment.cleanPrev();
            }
            return null;
        }
        ChannelSegment<E> channelSegment2 = (ChannelSegment) SegmentOrClosed.m2110getSegmentimpl(findSegmentInternal);
        if (!isRendezvousOrUnlimited() && j <= getBufferEndCounter() / ((long) BufferedChannelKt.SEGMENT_SIZE)) {
            AtomicReferenceFieldUpdater bufferEndSegment$volatile$FU2 = bufferEndSegment$volatile$FU;
            while (true) {
                Segment segment2 = (Segment) bufferEndSegment$volatile$FU2.get(this);
                Segment segment3 = channelSegment2;
                if (segment2.id >= segment3.id || !segment3.tryIncPointers$kotlinx_coroutines_core()) {
                    break;
                } else if (AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(bufferEndSegment$volatile$FU2, this, segment2, segment3)) {
                    if (segment2.decPointers$kotlinx_coroutines_core()) {
                        segment2.remove();
                    }
                } else if (segment3.decPointers$kotlinx_coroutines_core()) {
                    segment3.remove();
                }
            }
        }
        if (channelSegment2.id > j) {
            updateReceiversCounterIfLower(channelSegment2.id * ((long) BufferedChannelKt.SEGMENT_SIZE));
            if (channelSegment2.id * ((long) BufferedChannelKt.SEGMENT_SIZE) < getSendersCounter$kotlinx_coroutines_core()) {
                channelSegment2.cleanPrev();
            }
            return null;
        } else if (!DebugKt.getASSERTIONS_ENABLED() || channelSegment2.id == j) {
            return channelSegment2;
        } else {
            throw new AssertionError();
        }
    }

    private final ChannelSegment<E> findSegmentBufferEnd(long j, ChannelSegment<E> channelSegment, long j2) {
        Object findSegmentInternal;
        AtomicReferenceFieldUpdater bufferEndSegment$volatile$FU2 = bufferEndSegment$volatile$FU;
        Function2 function2 = (Function2) BufferedChannelKt.createSegmentFunction();
        loop0:
        while (true) {
            findSegmentInternal = ConcurrentLinkedListKt.findSegmentInternal(channelSegment, j, function2);
            if (SegmentOrClosed.m2112isClosedimpl(findSegmentInternal)) {
                break;
            }
            Segment r3 = SegmentOrClosed.m2110getSegmentimpl(findSegmentInternal);
            while (true) {
                Segment segment = (Segment) bufferEndSegment$volatile$FU2.get(this);
                if (segment.id >= r3.id) {
                    break loop0;
                } else if (r3.tryIncPointers$kotlinx_coroutines_core()) {
                    if (AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(bufferEndSegment$volatile$FU2, this, segment, r3)) {
                        if (segment.decPointers$kotlinx_coroutines_core()) {
                            segment.remove();
                        }
                    } else if (r3.decPointers$kotlinx_coroutines_core()) {
                        r3.remove();
                    }
                }
            }
        }
        if (SegmentOrClosed.m2112isClosedimpl(findSegmentInternal)) {
            completeCloseOrCancel();
            moveSegmentBufferEndToSpecifiedOrLast(j, channelSegment);
            incCompletedExpandBufferAttempts$default(this, 0, 1, (Object) null);
            return null;
        }
        ChannelSegment<E> channelSegment2 = (ChannelSegment) SegmentOrClosed.m2110getSegmentimpl(findSegmentInternal);
        if (channelSegment2.id > j) {
            if (bufferEnd$volatile$FU.compareAndSet(this, j2 + 1, ((long) BufferedChannelKt.SEGMENT_SIZE) * channelSegment2.id)) {
                incCompletedExpandBufferAttempts((channelSegment2.id * ((long) BufferedChannelKt.SEGMENT_SIZE)) - j2);
            } else {
                incCompletedExpandBufferAttempts$default(this, 0, 1, (Object) null);
            }
            return null;
        } else if (!DebugKt.getASSERTIONS_ENABLED() || channelSegment2.id == j) {
            return channelSegment2;
        } else {
            throw new AssertionError();
        }
    }

    private final void moveSegmentBufferEndToSpecifiedOrLast(long j, ChannelSegment<E> channelSegment) {
        ChannelSegment<E> channelSegment2;
        ChannelSegment<E> channelSegment3;
        while (channelSegment.id < j && (channelSegment3 = (ChannelSegment) channelSegment.getNext()) != null) {
            channelSegment = channelSegment3;
        }
        while (true) {
            if (!channelSegment.isRemoved() || (channelSegment2 = (ChannelSegment) channelSegment.getNext()) == null) {
                AtomicReferenceFieldUpdater bufferEndSegment$volatile$FU2 = bufferEndSegment$volatile$FU;
                while (true) {
                    Segment segment = (Segment) bufferEndSegment$volatile$FU2.get(this);
                    Segment segment2 = channelSegment;
                    if (segment.id < segment2.id) {
                        if (!segment2.tryIncPointers$kotlinx_coroutines_core()) {
                            continue;
                            break;
                        } else if (AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(bufferEndSegment$volatile$FU2, this, segment, segment2)) {
                            if (segment.decPointers$kotlinx_coroutines_core()) {
                                segment.remove();
                                return;
                            }
                            return;
                        } else if (segment2.decPointers$kotlinx_coroutines_core()) {
                            segment2.remove();
                        }
                    } else {
                        return;
                    }
                }
            } else {
                channelSegment = channelSegment2;
            }
        }
    }

    private final void updateSendersCounterIfLower(long j) {
        long j2;
        long j3;
        AtomicLongFieldUpdater sendersAndCloseStatus$volatile$FU2 = sendersAndCloseStatus$volatile$FU;
        do {
            j2 = sendersAndCloseStatus$volatile$FU2.get(this);
            j3 = 1152921504606846975L & j2;
            if (j3 < j) {
            } else {
                return;
            }
        } while (!sendersAndCloseStatus$volatile$FU.compareAndSet(this, j2, BufferedChannelKt.constructSendersAndCloseStatus(j3, (int) (j2 >> 60))));
    }

    private final void updateReceiversCounterIfLower(long j) {
        AtomicLongFieldUpdater receivers$volatile$FU2 = receivers$volatile$FU;
        while (true) {
            long j2 = receivers$volatile$FU2.get(this);
            if (j2 < j) {
                long j3 = j;
                if (!receivers$volatile$FU.compareAndSet(this, j2, j3)) {
                    j = j3;
                } else {
                    return;
                }
            } else {
                return;
            }
        }
    }

    /* JADX WARNING: type inference failed for: r2v15, types: [kotlinx.coroutines.internal.ConcurrentLinkedListNode] */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x01e6, code lost:
        r16 = r7;
        r3 = r3.getNext();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x01ef, code lost:
        if (r3 != null) goto L_0x0213;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String toString() {
        /*
            r17 = this;
            r0 = r17
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.util.concurrent.atomic.AtomicLongFieldUpdater r2 = sendersAndCloseStatus$volatile$FU
            long r2 = r2.get(r0)
            r4 = 60
            long r2 = r2 >> r4
            int r2 = (int) r2
            r3 = 3
            r4 = 2
            if (r2 == r4) goto L_0x0020
            if (r2 == r3) goto L_0x001a
            goto L_0x0025
        L_0x001a:
            java.lang.String r2 = "cancelled,"
            r1.append(r2)
            goto L_0x0025
        L_0x0020:
            java.lang.String r2 = "closed,"
            r1.append(r2)
        L_0x0025:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r5 = "capacity="
            r2.<init>(r5)
            int r5 = r0.capacity
            java.lang.StringBuilder r2 = r2.append(r5)
            r5 = 44
            java.lang.StringBuilder r2 = r2.append(r5)
            java.lang.String r2 = r2.toString()
            r1.append(r2)
            java.lang.String r2 = "data=["
            r1.append(r2)
            kotlinx.coroutines.channels.ChannelSegment[] r2 = new kotlinx.coroutines.channels.ChannelSegment[r3]
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r3 = receiveSegment$volatile$FU
            java.lang.Object r3 = r3.get(r0)
            r6 = 0
            r2[r6] = r3
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r3 = sendSegment$volatile$FU
            java.lang.Object r3 = r3.get(r0)
            r7 = 1
            r2[r7] = r3
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r3 = bufferEndSegment$volatile$FU
            java.lang.Object r3 = r3.get(r0)
            r2[r4] = r3
            java.util.List r2 = kotlin.collections.CollectionsKt.listOf(r2)
            java.lang.Iterable r2 = (java.lang.Iterable) r2
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            java.util.Collection r3 = (java.util.Collection) r3
            java.util.Iterator r2 = r2.iterator()
        L_0x0077:
            boolean r4 = r2.hasNext()
            if (r4 == 0) goto L_0x008e
            java.lang.Object r4 = r2.next()
            r8 = r4
            kotlinx.coroutines.channels.ChannelSegment r8 = (kotlinx.coroutines.channels.ChannelSegment) r8
            kotlinx.coroutines.channels.ChannelSegment r9 = kotlinx.coroutines.channels.BufferedChannelKt.NULL_SEGMENT
            if (r8 == r9) goto L_0x0077
            r3.add(r4)
            goto L_0x0077
        L_0x008e:
            java.util.List r3 = (java.util.List) r3
            java.lang.Iterable r3 = (java.lang.Iterable) r3
            java.util.Iterator r2 = r3.iterator()
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x0218
            java.lang.Object r3 = r2.next()
            boolean r4 = r2.hasNext()
            if (r4 != 0) goto L_0x00a7
            goto L_0x00c1
        L_0x00a7:
            r4 = r3
            kotlinx.coroutines.channels.ChannelSegment r4 = (kotlinx.coroutines.channels.ChannelSegment) r4
            long r8 = r4.id
        L_0x00ac:
            java.lang.Object r4 = r2.next()
            r10 = r4
            kotlinx.coroutines.channels.ChannelSegment r10 = (kotlinx.coroutines.channels.ChannelSegment) r10
            long r10 = r10.id
            int r12 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r12 <= 0) goto L_0x00bb
            r3 = r4
            r8 = r10
        L_0x00bb:
            boolean r4 = r2.hasNext()
            if (r4 != 0) goto L_0x00ac
        L_0x00c1:
            kotlinx.coroutines.channels.ChannelSegment r3 = (kotlinx.coroutines.channels.ChannelSegment) r3
            long r10 = r0.getReceiversCounter$kotlinx_coroutines_core()
            long r12 = r0.getSendersCounter$kotlinx_coroutines_core()
        L_0x00cb:
            int r2 = kotlinx.coroutines.channels.BufferedChannelKt.SEGMENT_SIZE
            r4 = r6
        L_0x00ce:
            if (r4 >= r2) goto L_0x01e6
            long r8 = r3.id
            int r14 = kotlinx.coroutines.channels.BufferedChannelKt.SEGMENT_SIZE
            long r14 = (long) r14
            long r8 = r8 * r14
            long r14 = (long) r4
            long r8 = r8 + r14
            int r14 = (r8 > r12 ? 1 : (r8 == r12 ? 0 : -1))
            if (r14 < 0) goto L_0x00e5
            int r15 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r15 >= 0) goto L_0x00e1
            goto L_0x00e5
        L_0x00e1:
            r16 = r7
            goto L_0x01f1
        L_0x00e5:
            java.lang.Object r15 = r3.getState$kotlinx_coroutines_core(r4)
            java.lang.Object r6 = r3.getElement$kotlinx_coroutines_core(r4)
            r16 = r7
            boolean r7 = r15 instanceof kotlinx.coroutines.CancellableContinuation
            if (r7 == 0) goto L_0x0109
            int r7 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r7 >= 0) goto L_0x00fd
            if (r14 < 0) goto L_0x00fd
            java.lang.String r7 = "receive"
            goto L_0x01a8
        L_0x00fd:
            if (r14 >= 0) goto L_0x0105
            if (r7 < 0) goto L_0x0105
            java.lang.String r7 = "send"
            goto L_0x01a8
        L_0x0105:
            java.lang.String r7 = "cont"
            goto L_0x01a8
        L_0x0109:
            boolean r7 = r15 instanceof kotlinx.coroutines.selects.SelectInstance
            if (r7 == 0) goto L_0x0123
            int r7 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r7 >= 0) goto L_0x0117
            if (r14 < 0) goto L_0x0117
            java.lang.String r7 = "onReceive"
            goto L_0x01a8
        L_0x0117:
            if (r14 >= 0) goto L_0x011f
            if (r7 < 0) goto L_0x011f
            java.lang.String r7 = "onSend"
            goto L_0x01a8
        L_0x011f:
            java.lang.String r7 = "select"
            goto L_0x01a8
        L_0x0123:
            boolean r7 = r15 instanceof kotlinx.coroutines.channels.ReceiveCatching
            if (r7 == 0) goto L_0x012b
            java.lang.String r7 = "receiveCatching"
            goto L_0x01a8
        L_0x012b:
            boolean r7 = r15 instanceof kotlinx.coroutines.channels.BufferedChannel.SendBroadcast
            if (r7 == 0) goto L_0x0133
            java.lang.String r7 = "sendBroadcast"
            goto L_0x01a8
        L_0x0133:
            boolean r7 = r15 instanceof kotlinx.coroutines.channels.WaiterEB
            if (r7 == 0) goto L_0x014d
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            java.lang.String r8 = "EB("
            r7.<init>(r8)
            java.lang.StringBuilder r7 = r7.append(r15)
            r8 = 41
            java.lang.StringBuilder r7 = r7.append(r8)
            java.lang.String r7 = r7.toString()
            goto L_0x01a8
        L_0x014d:
            kotlinx.coroutines.internal.Symbol r7 = kotlinx.coroutines.channels.BufferedChannelKt.RESUMING_BY_RCV
            boolean r7 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r15, (java.lang.Object) r7)
            if (r7 != 0) goto L_0x01a6
            kotlinx.coroutines.internal.Symbol r7 = kotlinx.coroutines.channels.BufferedChannelKt.RESUMING_BY_EB
            boolean r7 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r15, (java.lang.Object) r7)
            if (r7 == 0) goto L_0x0162
            goto L_0x01a6
        L_0x0162:
            if (r15 == 0) goto L_0x01df
            kotlinx.coroutines.internal.Symbol r7 = kotlinx.coroutines.channels.BufferedChannelKt.IN_BUFFER
            boolean r7 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r15, (java.lang.Object) r7)
            if (r7 != 0) goto L_0x01df
            kotlinx.coroutines.internal.Symbol r7 = kotlinx.coroutines.channels.BufferedChannelKt.DONE_RCV
            boolean r7 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r15, (java.lang.Object) r7)
            if (r7 != 0) goto L_0x01df
            kotlinx.coroutines.internal.Symbol r7 = kotlinx.coroutines.channels.BufferedChannelKt.POISONED
            boolean r7 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r15, (java.lang.Object) r7)
            if (r7 != 0) goto L_0x01df
            kotlinx.coroutines.internal.Symbol r7 = kotlinx.coroutines.channels.BufferedChannelKt.INTERRUPTED_RCV
            boolean r7 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r15, (java.lang.Object) r7)
            if (r7 != 0) goto L_0x01df
            kotlinx.coroutines.internal.Symbol r7 = kotlinx.coroutines.channels.BufferedChannelKt.INTERRUPTED_SEND
            boolean r7 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r15, (java.lang.Object) r7)
            if (r7 != 0) goto L_0x01df
            kotlinx.coroutines.internal.Symbol r7 = kotlinx.coroutines.channels.BufferedChannelKt.getCHANNEL_CLOSED()
            boolean r7 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r15, (java.lang.Object) r7)
            if (r7 == 0) goto L_0x01a1
            goto L_0x01df
        L_0x01a1:
            java.lang.String r7 = r15.toString()
            goto L_0x01a8
        L_0x01a6:
            java.lang.String r7 = "resuming_sender"
        L_0x01a8:
            if (r6 == 0) goto L_0x01cb
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            java.lang.String r9 = "("
            r8.<init>(r9)
            java.lang.StringBuilder r7 = r8.append(r7)
            java.lang.StringBuilder r7 = r7.append(r5)
            java.lang.StringBuilder r6 = r7.append(r6)
            java.lang.String r7 = "),"
            java.lang.StringBuilder r6 = r6.append(r7)
            java.lang.String r6 = r6.toString()
            r1.append(r6)
            goto L_0x01df
        L_0x01cb:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.StringBuilder r6 = r6.append(r7)
            java.lang.StringBuilder r6 = r6.append(r5)
            java.lang.String r6 = r6.toString()
            r1.append(r6)
        L_0x01df:
            int r4 = r4 + 1
            r7 = r16
            r6 = 0
            goto L_0x00ce
        L_0x01e6:
            r16 = r7
            kotlinx.coroutines.internal.ConcurrentLinkedListNode r2 = r3.getNext()
            r3 = r2
            kotlinx.coroutines.channels.ChannelSegment r3 = (kotlinx.coroutines.channels.ChannelSegment) r3
            if (r3 != 0) goto L_0x0213
        L_0x01f1:
            r2 = r1
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            char r2 = kotlin.text.StringsKt.last(r2)
            if (r2 != r5) goto L_0x0209
            int r2 = r1.length()
            int r2 = r2 + -1
            java.lang.StringBuilder r2 = r1.deleteCharAt(r2)
            java.lang.String r3 = "deleteCharAt(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r3)
        L_0x0209:
            java.lang.String r2 = "]"
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            return r1
        L_0x0213:
            r7 = r16
            r6 = 0
            goto L_0x00cb
        L_0x0218:
            java.util.NoSuchElementException r1 = new java.util.NoSuchElementException
            r1.<init>()
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.BufferedChannel.toString():java.lang.String");
    }

    /* JADX WARNING: type inference failed for: r1v40, types: [kotlinx.coroutines.internal.ConcurrentLinkedListNode] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String toStringDebug$kotlinx_coroutines_core() {
        /*
            r11 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "S="
            r1.<init>(r2)
            long r2 = r11.getSendersCounter$kotlinx_coroutines_core()
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.String r2 = ",R="
            java.lang.StringBuilder r1 = r1.append(r2)
            long r2 = r11.getReceiversCounter$kotlinx_coroutines_core()
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.String r2 = ",B="
            java.lang.StringBuilder r1 = r1.append(r2)
            long r2 = r11.getBufferEndCounter()
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.String r2 = ",B'="
            java.lang.StringBuilder r1 = r1.append(r2)
            java.util.concurrent.atomic.AtomicLongFieldUpdater r2 = completedExpandBuffersAndPauseFlag$volatile$FU
            long r2 = r2.get(r11)
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.String r2 = ",C="
            java.lang.StringBuilder r1 = r1.append(r2)
            java.util.concurrent.atomic.AtomicLongFieldUpdater r2 = sendersAndCloseStatus$volatile$FU
            long r2 = r2.get(r11)
            r4 = 60
            long r2 = r2 >> r4
            int r2 = (int) r2
            java.lang.StringBuilder r1 = r1.append(r2)
            r2 = 44
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.append(r1)
            java.util.concurrent.atomic.AtomicLongFieldUpdater r1 = sendersAndCloseStatus$volatile$FU
            long r5 = r1.get(r11)
            long r3 = r5 >> r4
            int r1 = (int) r3
            r3 = 3
            r4 = 2
            r5 = 1
            if (r1 == r5) goto L_0x0086
            if (r1 == r4) goto L_0x0080
            if (r1 == r3) goto L_0x007a
            goto L_0x008b
        L_0x007a:
            java.lang.String r1 = "CANCELLED,"
            r0.append(r1)
            goto L_0x008b
        L_0x0080:
            java.lang.String r1 = "CLOSED,"
            r0.append(r1)
            goto L_0x008b
        L_0x0086:
            java.lang.String r1 = "CANCELLATION_STARTED,"
            r0.append(r1)
        L_0x008b:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r6 = "SEND_SEGM="
            r1.<init>(r6)
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r6 = sendSegment$volatile$FU
            java.lang.Object r6 = r6.get(r11)
            java.lang.String r6 = kotlinx.coroutines.DebugStringsKt.getHexAddress(r6)
            java.lang.StringBuilder r1 = r1.append(r6)
            java.lang.String r6 = ",RCV_SEGM="
            java.lang.StringBuilder r1 = r1.append(r6)
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r6 = receiveSegment$volatile$FU
            java.lang.Object r6 = r6.get(r11)
            java.lang.String r6 = kotlinx.coroutines.DebugStringsKt.getHexAddress(r6)
            java.lang.StringBuilder r1 = r1.append(r6)
            java.lang.String r1 = r1.toString()
            r0.append(r1)
            boolean r1 = r11.isRendezvousOrUnlimited()
            if (r1 != 0) goto L_0x00e3
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r6 = ",EB_SEGM="
            r1.<init>(r6)
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r6 = bufferEndSegment$volatile$FU
            java.lang.Object r6 = r6.get(r11)
            java.lang.String r6 = kotlinx.coroutines.DebugStringsKt.getHexAddress(r6)
            java.lang.StringBuilder r1 = r1.append(r6)
            java.lang.String r1 = r1.toString()
            r0.append(r1)
        L_0x00e3:
            java.lang.String r1 = "  "
            r0.append(r1)
            kotlinx.coroutines.channels.ChannelSegment[] r1 = new kotlinx.coroutines.channels.ChannelSegment[r3]
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r3 = receiveSegment$volatile$FU
            java.lang.Object r3 = r3.get(r11)
            r6 = 0
            r1[r6] = r3
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r3 = sendSegment$volatile$FU
            java.lang.Object r3 = r3.get(r11)
            r1[r5] = r3
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r3 = bufferEndSegment$volatile$FU
            java.lang.Object r3 = r3.get(r11)
            r1[r4] = r3
            java.util.List r1 = kotlin.collections.CollectionsKt.listOf(r1)
            java.lang.Iterable r1 = (java.lang.Iterable) r1
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            java.util.Collection r3 = (java.util.Collection) r3
            java.util.Iterator r1 = r1.iterator()
        L_0x011a:
            boolean r4 = r1.hasNext()
            if (r4 == 0) goto L_0x0131
            java.lang.Object r4 = r1.next()
            r5 = r4
            kotlinx.coroutines.channels.ChannelSegment r5 = (kotlinx.coroutines.channels.ChannelSegment) r5
            kotlinx.coroutines.channels.ChannelSegment r7 = kotlinx.coroutines.channels.BufferedChannelKt.NULL_SEGMENT
            if (r5 == r7) goto L_0x011a
            r3.add(r4)
            goto L_0x011a
        L_0x0131:
            java.util.List r3 = (java.util.List) r3
            java.lang.Iterable r3 = (java.lang.Iterable) r3
            java.util.Iterator r1 = r3.iterator()
            boolean r3 = r1.hasNext()
            if (r3 == 0) goto L_0x0258
            java.lang.Object r3 = r1.next()
            boolean r4 = r1.hasNext()
            if (r4 != 0) goto L_0x014a
            goto L_0x0164
        L_0x014a:
            r4 = r3
            kotlinx.coroutines.channels.ChannelSegment r4 = (kotlinx.coroutines.channels.ChannelSegment) r4
            long r4 = r4.id
        L_0x014f:
            java.lang.Object r7 = r1.next()
            r8 = r7
            kotlinx.coroutines.channels.ChannelSegment r8 = (kotlinx.coroutines.channels.ChannelSegment) r8
            long r8 = r8.id
            int r10 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1))
            if (r10 <= 0) goto L_0x015e
            r3 = r7
            r4 = r8
        L_0x015e:
            boolean r7 = r1.hasNext()
            if (r7 != 0) goto L_0x014f
        L_0x0164:
            kotlinx.coroutines.channels.ChannelSegment r3 = (kotlinx.coroutines.channels.ChannelSegment) r3
        L_0x0166:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r4 = kotlinx.coroutines.DebugStringsKt.getHexAddress(r3)
            java.lang.StringBuilder r1 = r1.append(r4)
            java.lang.String r4 = "=["
            java.lang.StringBuilder r1 = r1.append(r4)
            boolean r4 = r3.isRemoved()
            if (r4 == 0) goto L_0x0182
            java.lang.String r4 = "*"
            goto L_0x0184
        L_0x0182:
            java.lang.String r4 = ""
        L_0x0184:
            java.lang.StringBuilder r1 = r1.append(r4)
            long r4 = r3.id
            java.lang.StringBuilder r1 = r1.append(r4)
            java.lang.String r4 = ",prev="
            java.lang.StringBuilder r1 = r1.append(r4)
            kotlinx.coroutines.internal.ConcurrentLinkedListNode r4 = r3.getPrev()
            kotlinx.coroutines.channels.ChannelSegment r4 = (kotlinx.coroutines.channels.ChannelSegment) r4
            r5 = 0
            if (r4 == 0) goto L_0x01a2
            java.lang.String r4 = kotlinx.coroutines.DebugStringsKt.getHexAddress(r4)
            goto L_0x01a3
        L_0x01a2:
            r4 = r5
        L_0x01a3:
            java.lang.StringBuilder r1 = r1.append(r4)
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.append(r1)
            int r1 = kotlinx.coroutines.channels.BufferedChannelKt.SEGMENT_SIZE
            r4 = r6
        L_0x01b5:
            if (r4 >= r1) goto L_0x0226
            java.lang.Object r7 = r3.getState$kotlinx_coroutines_core(r4)
            java.lang.Object r8 = r3.getElement$kotlinx_coroutines_core(r4)
            boolean r9 = r7 instanceof kotlinx.coroutines.CancellableContinuation
            if (r9 == 0) goto L_0x01c6
            java.lang.String r7 = "cont"
            goto L_0x01f9
        L_0x01c6:
            boolean r9 = r7 instanceof kotlinx.coroutines.selects.SelectInstance
            if (r9 == 0) goto L_0x01cd
            java.lang.String r7 = "select"
            goto L_0x01f9
        L_0x01cd:
            boolean r9 = r7 instanceof kotlinx.coroutines.channels.ReceiveCatching
            if (r9 == 0) goto L_0x01d4
            java.lang.String r7 = "receiveCatching"
            goto L_0x01f9
        L_0x01d4:
            boolean r9 = r7 instanceof kotlinx.coroutines.channels.BufferedChannel.SendBroadcast
            if (r9 == 0) goto L_0x01db
            java.lang.String r7 = "send(broadcast)"
            goto L_0x01f9
        L_0x01db:
            boolean r9 = r7 instanceof kotlinx.coroutines.channels.WaiterEB
            if (r9 == 0) goto L_0x01f5
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            java.lang.String r10 = "EB("
            r9.<init>(r10)
            java.lang.StringBuilder r7 = r9.append(r7)
            r9 = 41
            java.lang.StringBuilder r7 = r7.append(r9)
            java.lang.String r7 = r7.toString()
            goto L_0x01f9
        L_0x01f5:
            java.lang.String r7 = java.lang.String.valueOf(r7)
        L_0x01f9:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            java.lang.String r10 = "["
            r9.<init>(r10)
            java.lang.StringBuilder r9 = r9.append(r4)
            java.lang.String r10 = "]=("
            java.lang.StringBuilder r9 = r9.append(r10)
            java.lang.StringBuilder r7 = r9.append(r7)
            java.lang.StringBuilder r7 = r7.append(r2)
            java.lang.StringBuilder r7 = r7.append(r8)
            java.lang.String r8 = "),"
            java.lang.StringBuilder r7 = r7.append(r8)
            java.lang.String r7 = r7.toString()
            r0.append(r7)
            int r4 = r4 + 1
            goto L_0x01b5
        L_0x0226:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r4 = "next="
            r1.<init>(r4)
            kotlinx.coroutines.internal.ConcurrentLinkedListNode r4 = r3.getNext()
            kotlinx.coroutines.channels.ChannelSegment r4 = (kotlinx.coroutines.channels.ChannelSegment) r4
            if (r4 == 0) goto L_0x0239
            java.lang.String r5 = kotlinx.coroutines.DebugStringsKt.getHexAddress(r4)
        L_0x0239:
            java.lang.StringBuilder r1 = r1.append(r5)
            java.lang.String r4 = "]  "
            java.lang.StringBuilder r1 = r1.append(r4)
            java.lang.String r1 = r1.toString()
            r0.append(r1)
            kotlinx.coroutines.internal.ConcurrentLinkedListNode r1 = r3.getNext()
            r3 = r1
            kotlinx.coroutines.channels.ChannelSegment r3 = (kotlinx.coroutines.channels.ChannelSegment) r3
            if (r3 != 0) goto L_0x0166
            java.lang.String r0 = r0.toString()
            return r0
        L_0x0258:
            java.util.NoSuchElementException r0 = new java.util.NoSuchElementException
            r0.<init>()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.BufferedChannel.toStringDebug$kotlinx_coroutines_core():java.lang.String");
    }

    /* JADX WARNING: type inference failed for: r0v19, types: [kotlinx.coroutines.internal.ConcurrentLinkedListNode, java.lang.Object] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void checkSegmentStructureInvariants() {
        /*
            r9 = this;
            boolean r0 = r9.isRendezvousOrUnlimited()
            if (r0 == 0) goto L_0x002e
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r0 = bufferEndSegment$volatile$FU
            java.lang.Object r0 = r0.get(r9)
            kotlinx.coroutines.channels.ChannelSegment r1 = kotlinx.coroutines.channels.BufferedChannelKt.NULL_SEGMENT
            if (r0 != r1) goto L_0x0015
            goto L_0x004a
        L_0x0015:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "bufferEndSegment must be NULL_SEGMENT for rendezvous and unlimited channels; they do not manipulate it.\nChannel state: "
            r0.<init>(r1)
            java.lang.StringBuilder r0 = r0.append(r9)
            java.lang.String r0 = r0.toString()
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r0 = r0.toString()
            r1.<init>(r0)
            throw r1
        L_0x002e:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r0 = receiveSegment$volatile$FU
            java.lang.Object r0 = r0.get(r9)
            kotlinx.coroutines.channels.ChannelSegment r0 = (kotlinx.coroutines.channels.ChannelSegment) r0
            long r0 = r0.id
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r2 = bufferEndSegment$volatile$FU
            java.lang.Object r2 = r2.get(r9)
            kotlinx.coroutines.channels.ChannelSegment r2 = (kotlinx.coroutines.channels.ChannelSegment) r2
            long r2 = r2.id
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 > 0) goto L_0x020e
        L_0x004a:
            r0 = 3
            kotlinx.coroutines.channels.ChannelSegment[] r0 = new kotlinx.coroutines.channels.ChannelSegment[r0]
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r1 = receiveSegment$volatile$FU
            java.lang.Object r1 = r1.get(r9)
            r2 = 0
            r0[r2] = r1
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r1 = sendSegment$volatile$FU
            java.lang.Object r1 = r1.get(r9)
            r3 = 1
            r0[r3] = r1
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r1 = bufferEndSegment$volatile$FU
            java.lang.Object r1 = r1.get(r9)
            r3 = 2
            r0[r3] = r1
            java.util.List r0 = kotlin.collections.CollectionsKt.listOf(r0)
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            java.util.Collection r1 = (java.util.Collection) r1
            java.util.Iterator r0 = r0.iterator()
        L_0x007f:
            boolean r3 = r0.hasNext()
            if (r3 == 0) goto L_0x0096
            java.lang.Object r3 = r0.next()
            r4 = r3
            kotlinx.coroutines.channels.ChannelSegment r4 = (kotlinx.coroutines.channels.ChannelSegment) r4
            kotlinx.coroutines.channels.ChannelSegment r5 = kotlinx.coroutines.channels.BufferedChannelKt.NULL_SEGMENT
            if (r4 == r5) goto L_0x007f
            r1.add(r3)
            goto L_0x007f
        L_0x0096:
            java.util.List r1 = (java.util.List) r1
            java.lang.Iterable r1 = (java.lang.Iterable) r1
            java.util.Iterator r0 = r1.iterator()
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0208
            java.lang.Object r1 = r0.next()
            boolean r3 = r0.hasNext()
            if (r3 != 0) goto L_0x00af
            goto L_0x00c9
        L_0x00af:
            r3 = r1
            kotlinx.coroutines.channels.ChannelSegment r3 = (kotlinx.coroutines.channels.ChannelSegment) r3
            long r3 = r3.id
        L_0x00b4:
            java.lang.Object r5 = r0.next()
            r6 = r5
            kotlinx.coroutines.channels.ChannelSegment r6 = (kotlinx.coroutines.channels.ChannelSegment) r6
            long r6 = r6.id
            int r8 = (r3 > r6 ? 1 : (r3 == r6 ? 0 : -1))
            if (r8 <= 0) goto L_0x00c3
            r1 = r5
            r3 = r6
        L_0x00c3:
            boolean r5 = r0.hasNext()
            if (r5 != 0) goto L_0x00b4
        L_0x00c9:
            kotlinx.coroutines.channels.ChannelSegment r1 = (kotlinx.coroutines.channels.ChannelSegment) r1
            kotlinx.coroutines.internal.ConcurrentLinkedListNode r0 = r1.getPrev()
            if (r0 != 0) goto L_0x01ef
        L_0x00d1:
            kotlinx.coroutines.internal.ConcurrentLinkedListNode r0 = r1.getNext()
            if (r0 == 0) goto L_0x01ee
            kotlinx.coroutines.internal.ConcurrentLinkedListNode r0 = r1.getNext()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            kotlinx.coroutines.channels.ChannelSegment r0 = (kotlinx.coroutines.channels.ChannelSegment) r0
            kotlinx.coroutines.internal.ConcurrentLinkedListNode r0 = r0.getPrev()
            if (r0 == 0) goto L_0x010f
            kotlinx.coroutines.internal.ConcurrentLinkedListNode r0 = r1.getNext()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            kotlinx.coroutines.channels.ChannelSegment r0 = (kotlinx.coroutines.channels.ChannelSegment) r0
            kotlinx.coroutines.internal.ConcurrentLinkedListNode r0 = r0.getPrev()
            if (r0 != r1) goto L_0x00f6
            goto L_0x010f
        L_0x00f6:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "The `segment.next.prev === segment` invariant is violated.\nChannel state: "
            r0.<init>(r1)
            java.lang.StringBuilder r0 = r0.append(r9)
            java.lang.String r0 = r0.toString()
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r0 = r0.toString()
            r1.<init>(r0)
            throw r1
        L_0x010f:
            int r0 = kotlinx.coroutines.channels.BufferedChannelKt.SEGMENT_SIZE
            r3 = r2
            r4 = r3
        L_0x0113:
            if (r3 >= r0) goto L_0x01a6
            java.lang.Object r5 = r1.getState$kotlinx_coroutines_core(r3)
            kotlinx.coroutines.internal.Symbol r6 = kotlinx.coroutines.channels.BufferedChannelKt.BUFFERED
            boolean r6 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r5, (java.lang.Object) r6)
            if (r6 != 0) goto L_0x01a2
            boolean r6 = r5 instanceof kotlinx.coroutines.Waiter
            if (r6 != 0) goto L_0x01a2
            kotlinx.coroutines.internal.Symbol r6 = kotlinx.coroutines.channels.BufferedChannelKt.INTERRUPTED_RCV
            boolean r6 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r5, (java.lang.Object) r6)
            java.lang.String r7 = "Check failed."
            if (r6 != 0) goto L_0x018f
            kotlinx.coroutines.internal.Symbol r6 = kotlinx.coroutines.channels.BufferedChannelKt.INTERRUPTED_SEND
            boolean r6 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r5, (java.lang.Object) r6)
            if (r6 != 0) goto L_0x018f
            kotlinx.coroutines.internal.Symbol r6 = kotlinx.coroutines.channels.BufferedChannelKt.getCHANNEL_CLOSED()
            boolean r6 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r5, (java.lang.Object) r6)
            if (r6 == 0) goto L_0x0146
            goto L_0x018f
        L_0x0146:
            kotlinx.coroutines.internal.Symbol r6 = kotlinx.coroutines.channels.BufferedChannelKt.POISONED
            boolean r6 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r5, (java.lang.Object) r6)
            if (r6 != 0) goto L_0x017e
            kotlinx.coroutines.internal.Symbol r6 = kotlinx.coroutines.channels.BufferedChannelKt.DONE_RCV
            boolean r6 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r5, (java.lang.Object) r6)
            if (r6 == 0) goto L_0x015b
            goto L_0x017e
        L_0x015b:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "Unexpected segment cell state: "
            r1.<init>(r2)
            java.lang.StringBuilder r1 = r1.append(r5)
            java.lang.String r2 = ".\nChannel state: "
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.StringBuilder r1 = r1.append(r9)
            java.lang.String r1 = r1.toString()
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x017e:
            java.lang.Object r5 = r1.getElement$kotlinx_coroutines_core(r3)
            if (r5 != 0) goto L_0x0185
            goto L_0x01a2
        L_0x0185:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = r7.toString()
            r0.<init>(r1)
            throw r0
        L_0x018f:
            java.lang.Object r5 = r1.getElement$kotlinx_coroutines_core(r3)
            if (r5 != 0) goto L_0x0198
            int r4 = r4 + 1
            goto L_0x01a2
        L_0x0198:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = r7.toString()
            r0.<init>(r1)
            throw r0
        L_0x01a2:
            int r3 = r3 + 1
            goto L_0x0113
        L_0x01a6:
            int r0 = kotlinx.coroutines.channels.BufferedChannelKt.SEGMENT_SIZE
            if (r4 != r0) goto L_0x01e2
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r0 = receiveSegment$volatile$FU
            java.lang.Object r0 = r0.get(r9)
            if (r1 == r0) goto L_0x01e2
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r0 = sendSegment$volatile$FU
            java.lang.Object r0 = r0.get(r9)
            if (r1 == r0) goto L_0x01e2
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r0 = bufferEndSegment$volatile$FU
            java.lang.Object r0 = r0.get(r9)
            if (r1 != r0) goto L_0x01c9
            goto L_0x01e2
        L_0x01c9:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "Logically removed segment is reachable.\nChannel state: "
            r0.<init>(r1)
            java.lang.StringBuilder r0 = r0.append(r9)
            java.lang.String r0 = r0.toString()
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r0 = r0.toString()
            r1.<init>(r0)
            throw r1
        L_0x01e2:
            kotlinx.coroutines.internal.ConcurrentLinkedListNode r0 = r1.getNext()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            r1 = r0
            kotlinx.coroutines.channels.ChannelSegment r1 = (kotlinx.coroutines.channels.ChannelSegment) r1
            goto L_0x00d1
        L_0x01ee:
            return
        L_0x01ef:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "All processed segments should be unreachable from the data structure, but the `prev` link of the leftmost segment is non-null.\nChannel state: "
            r0.<init>(r1)
            java.lang.StringBuilder r0 = r0.append(r9)
            java.lang.String r0 = r0.toString()
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r0 = r0.toString()
            r1.<init>(r0)
            throw r1
        L_0x0208:
            java.util.NoSuchElementException r0 = new java.util.NoSuchElementException
            r0.<init>()
            throw r0
        L_0x020e:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "bufferEndSegment should not have lower id than receiveSegment.\nChannel state: "
            r0.<init>(r1)
            java.lang.StringBuilder r0 = r0.append(r9)
            java.lang.String r0 = r0.toString()
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r0 = r0.toString()
            r1.<init>(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.BufferedChannel.checkSegmentStructureInvariants():void");
    }

    /* access modifiers changed from: private */
    public final KFunction<Unit> bindCancellationFunResult(Function1<? super E, Unit> function1) {
        return new BufferedChannel$bindCancellationFunResult$1(this);
    }

    /* access modifiers changed from: private */
    /* renamed from: onCancellationChannelResultImplDoNotCall-5_sEAP8  reason: not valid java name */
    public final void m2035onCancellationChannelResultImplDoNotCall5_sEAP8(Throwable th, Object obj, CoroutineContext coroutineContext) {
        Function1<E, Unit> function1 = this.onUndeliveredElement;
        Intrinsics.checkNotNull(function1);
        Object r2 = ChannelResult.m2055getOrNullimpl(obj);
        Intrinsics.checkNotNull(r2);
        OnUndeliveredElementKt.callUndeliveredElement(function1, r2, coroutineContext);
    }

    /* access modifiers changed from: private */
    public final Function3<Throwable, Object, CoroutineContext, Unit> bindCancellationFun(Function1<? super E, Unit> function1, E e) {
        return new BufferedChannel$$ExternalSyntheticLambda2(function1, e);
    }

    /* access modifiers changed from: private */
    public static final Unit bindCancellationFun$lambda$89(Function1 function1, Object obj, Throwable th, Object obj2, CoroutineContext coroutineContext) {
        OnUndeliveredElementKt.callUndeliveredElement(function1, obj, coroutineContext);
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public final KFunction<Unit> bindCancellationFun(Function1<? super E, Unit> function1) {
        return new BufferedChannel$bindCancellationFun$2(this);
    }

    /* access modifiers changed from: private */
    public final void onCancellationImplDoNotCall(Throwable th, E e, CoroutineContext coroutineContext) {
        Function1<E, Unit> function1 = this.onUndeliveredElement;
        Intrinsics.checkNotNull(function1);
        OnUndeliveredElementKt.callUndeliveredElement(function1, e, coroutineContext);
    }

    /* access modifiers changed from: private */
    public final Object onClosedSend(E e, Continuation<? super Unit> continuation) {
        UndeliveredElementException callUndeliveredElementCatchingException$default;
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        CancellableContinuation cancellableContinuation = cancellableContinuationImpl;
        Function1<E, Unit> function1 = this.onUndeliveredElement;
        if (function1 == null || (callUndeliveredElementCatchingException$default = OnUndeliveredElementKt.callUndeliveredElementCatchingException$default(function1, e, (UndeliveredElementException) null, 2, (Object) null)) == null) {
            Continuation continuation2 = cancellableContinuation;
            Throwable sendException = getSendException();
            Result.Companion companion = Result.Companion;
            if (DebugKt.getRECOVER_STACK_TRACES() && (continuation2 instanceof CoroutineStackFrame)) {
                sendException = StackTraceRecoveryKt.recoverFromStackFrame(sendException, (CoroutineStackFrame) continuation2);
            }
            continuation2.resumeWith(Result.m516constructorimpl(ResultKt.createFailure(sendException)));
        } else {
            Throwable th = callUndeliveredElementCatchingException$default;
            ExceptionsKt.addSuppressed(th, getSendException());
            Continuation continuation3 = cancellableContinuation;
            Result.Companion companion2 = Result.Companion;
            if (DebugKt.getRECOVER_STACK_TRACES() && (continuation3 instanceof CoroutineStackFrame)) {
                th = StackTraceRecoveryKt.recoverFromStackFrame(th, (CoroutineStackFrame) continuation3);
            }
            continuation3.resumeWith(Result.m516constructorimpl(ResultKt.createFailure(th)));
        }
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? result : Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x0128  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x0131 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x0132  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object sendOnNoWaiterSuspend(kotlinx.coroutines.channels.ChannelSegment<E> r17, int r18, E r19, long r20, kotlin.coroutines.Continuation<? super kotlin.Unit> r22) {
        /*
            r16 = this;
            kotlin.coroutines.Continuation r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.intercepted(r22)
            kotlinx.coroutines.CancellableContinuationImpl r9 = kotlinx.coroutines.CancellableContinuationKt.getOrCreateCancellableContinuation(r0)
            r7 = r9
            kotlinx.coroutines.Waiter r7 = (kotlinx.coroutines.Waiter) r7     // Catch:{ all -> 0x0137 }
            r8 = 0
            r1 = r16
            r2 = r17
            r3 = r18
            r4 = r19
            r5 = r20
            int r0 = r1.updateCellSend(r2, r3, r4, r5, r7, r8)     // Catch:{ all -> 0x0135 }
            if (r0 == 0) goto L_0x010d
            r10 = 1
            if (r0 == r10) goto L_0x0101
            r11 = 2
            if (r0 == r11) goto L_0x00f6
            r12 = 4
            if (r0 == r12) goto L_0x00e6
            java.lang.String r13 = "unexpected"
            r14 = 5
            if (r0 != r14) goto L_0x00dc
            r17.cleanPrev()     // Catch:{ all -> 0x0135 }
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r0 = sendSegment$volatile$FU     // Catch:{ all -> 0x0135 }
            java.lang.Object r0 = r0.get(r1)     // Catch:{ all -> 0x0135 }
            kotlinx.coroutines.channels.ChannelSegment r0 = (kotlinx.coroutines.channels.ChannelSegment) r0     // Catch:{ all -> 0x0135 }
        L_0x0037:
            java.util.concurrent.atomic.AtomicLongFieldUpdater r2 = sendersAndCloseStatus$volatile$FU     // Catch:{ all -> 0x0135 }
            long r2 = r2.getAndIncrement(r1)     // Catch:{ all -> 0x0135 }
            r5 = 1152921504606846975(0xfffffffffffffff, double:1.2882297539194265E-231)
            long r5 = r5 & r2
            boolean r8 = r1.isClosedForSend0(r2)     // Catch:{ all -> 0x0135 }
            int r2 = kotlinx.coroutines.channels.BufferedChannelKt.SEGMENT_SIZE     // Catch:{ all -> 0x0135 }
            long r2 = (long) r2     // Catch:{ all -> 0x0135 }
            long r2 = r5 / r2
            int r7 = kotlinx.coroutines.channels.BufferedChannelKt.SEGMENT_SIZE     // Catch:{ all -> 0x0135 }
            long r14 = (long) r7     // Catch:{ all -> 0x0135 }
            long r14 = r5 % r14
            int r7 = (int) r14     // Catch:{ all -> 0x0135 }
            long r14 = r0.id     // Catch:{ all -> 0x0135 }
            int r14 = (r14 > r2 ? 1 : (r14 == r2 ? 0 : -1))
            if (r14 == 0) goto L_0x006c
            kotlinx.coroutines.channels.ChannelSegment r2 = r1.findSegmentSend(r2, r0)     // Catch:{ all -> 0x0135 }
            if (r2 != 0) goto L_0x006d
            if (r8 == 0) goto L_0x006a
            r0 = r9
            kotlinx.coroutines.CancellableContinuation r0 = (kotlinx.coroutines.CancellableContinuation) r0     // Catch:{ all -> 0x0135 }
        L_0x0065:
            r1.onClosedSendOnNoWaiterSuspend(r4, r0)     // Catch:{ all -> 0x0135 }
            goto L_0x011e
        L_0x006a:
            r14 = 5
            goto L_0x0037
        L_0x006c:
            r2 = r0
        L_0x006d:
            r3 = r7
            r7 = r9
            kotlinx.coroutines.Waiter r7 = (kotlinx.coroutines.Waiter) r7     // Catch:{ all -> 0x0135 }
            int r0 = r1.updateCellSend(r2, r3, r4, r5, r7, r8)     // Catch:{ all -> 0x0135 }
            if (r0 == 0) goto L_0x00cd
            if (r0 == r10) goto L_0x00be
            if (r0 == r11) goto L_0x00a3
            r3 = 3
            if (r0 == r3) goto L_0x0099
            if (r0 == r12) goto L_0x008a
            r3 = 5
            if (r0 == r3) goto L_0x0084
            goto L_0x0087
        L_0x0084:
            r2.cleanPrev()     // Catch:{ all -> 0x0135 }
        L_0x0087:
            r0 = r2
            r14 = r3
            goto L_0x0037
        L_0x008a:
            long r7 = r1.getReceiversCounter$kotlinx_coroutines_core()     // Catch:{ all -> 0x0135 }
            int r0 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r0 >= 0) goto L_0x0095
            r2.cleanPrev()     // Catch:{ all -> 0x0135 }
        L_0x0095:
            r0 = r9
            kotlinx.coroutines.CancellableContinuation r0 = (kotlinx.coroutines.CancellableContinuation) r0     // Catch:{ all -> 0x0135 }
            goto L_0x0065
        L_0x0099:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException     // Catch:{ all -> 0x0135 }
            java.lang.String r2 = r13.toString()     // Catch:{ all -> 0x0135 }
            r0.<init>(r2)     // Catch:{ all -> 0x0135 }
            throw r0     // Catch:{ all -> 0x0135 }
        L_0x00a3:
            if (r8 == 0) goto L_0x00ac
            r2.onSlotCleaned()     // Catch:{ all -> 0x0135 }
            r0 = r9
            kotlinx.coroutines.CancellableContinuation r0 = (kotlinx.coroutines.CancellableContinuation) r0     // Catch:{ all -> 0x0135 }
            goto L_0x0065
        L_0x00ac:
            r0 = r9
            kotlinx.coroutines.Waiter r0 = (kotlinx.coroutines.Waiter) r0     // Catch:{ all -> 0x0135 }
            boolean r0 = r0 instanceof kotlinx.coroutines.Waiter     // Catch:{ all -> 0x0135 }
            if (r0 == 0) goto L_0x00b7
            r0 = r9
            kotlinx.coroutines.Waiter r0 = (kotlinx.coroutines.Waiter) r0     // Catch:{ all -> 0x0135 }
            goto L_0x00b8
        L_0x00b7:
            r0 = 0
        L_0x00b8:
            if (r0 == 0) goto L_0x011e
            r1.prepareSenderForSuspension(r0, r2, r3)     // Catch:{ all -> 0x0135 }
            goto L_0x011e
        L_0x00be:
            r0 = r9
            kotlin.coroutines.Continuation r0 = (kotlin.coroutines.Continuation) r0     // Catch:{ all -> 0x0135 }
            kotlin.Result$Companion r2 = kotlin.Result.Companion     // Catch:{ all -> 0x0135 }
            kotlin.Unit r2 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0135 }
            java.lang.Object r2 = kotlin.Result.m516constructorimpl(r2)     // Catch:{ all -> 0x0135 }
        L_0x00c9:
            r0.resumeWith(r2)     // Catch:{ all -> 0x0135 }
            goto L_0x011e
        L_0x00cd:
            r2.cleanPrev()     // Catch:{ all -> 0x0135 }
            r0 = r9
            kotlin.coroutines.Continuation r0 = (kotlin.coroutines.Continuation) r0     // Catch:{ all -> 0x0135 }
            kotlin.Result$Companion r2 = kotlin.Result.Companion     // Catch:{ all -> 0x0135 }
            kotlin.Unit r2 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0135 }
            java.lang.Object r2 = kotlin.Result.m516constructorimpl(r2)     // Catch:{ all -> 0x0135 }
            goto L_0x00c9
        L_0x00dc:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException     // Catch:{ all -> 0x0135 }
            java.lang.String r2 = r13.toString()     // Catch:{ all -> 0x0135 }
            r0.<init>(r2)     // Catch:{ all -> 0x0135 }
            throw r0     // Catch:{ all -> 0x0135 }
        L_0x00e6:
            long r2 = r1.getReceiversCounter$kotlinx_coroutines_core()     // Catch:{ all -> 0x0135 }
            int r0 = (r20 > r2 ? 1 : (r20 == r2 ? 0 : -1))
            if (r0 >= 0) goto L_0x00f1
            r17.cleanPrev()     // Catch:{ all -> 0x0135 }
        L_0x00f1:
            r0 = r9
            kotlinx.coroutines.CancellableContinuation r0 = (kotlinx.coroutines.CancellableContinuation) r0     // Catch:{ all -> 0x0135 }
            goto L_0x0065
        L_0x00f6:
            r0 = r9
            kotlinx.coroutines.Waiter r0 = (kotlinx.coroutines.Waiter) r0     // Catch:{ all -> 0x0135 }
            r2 = r17
            r3 = r18
            r1.prepareSenderForSuspension(r0, r2, r3)     // Catch:{ all -> 0x0135 }
            goto L_0x011e
        L_0x0101:
            r0 = r9
            kotlin.coroutines.Continuation r0 = (kotlin.coroutines.Continuation) r0     // Catch:{ all -> 0x0135 }
            kotlin.Result$Companion r2 = kotlin.Result.Companion     // Catch:{ all -> 0x0135 }
            kotlin.Unit r2 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0135 }
            java.lang.Object r2 = kotlin.Result.m516constructorimpl(r2)     // Catch:{ all -> 0x0135 }
            goto L_0x00c9
        L_0x010d:
            r2 = r17
            r2.cleanPrev()     // Catch:{ all -> 0x0135 }
            r0 = r9
            kotlin.coroutines.Continuation r0 = (kotlin.coroutines.Continuation) r0     // Catch:{ all -> 0x0135 }
            kotlin.Result$Companion r2 = kotlin.Result.Companion     // Catch:{ all -> 0x0135 }
            kotlin.Unit r2 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0135 }
            java.lang.Object r2 = kotlin.Result.m516constructorimpl(r2)     // Catch:{ all -> 0x0135 }
            goto L_0x00c9
        L_0x011e:
            java.lang.Object r0 = r9.getResult()
            java.lang.Object r2 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            if (r0 != r2) goto L_0x012b
            kotlin.coroutines.jvm.internal.DebugProbesKt.probeCoroutineSuspended(r22)
        L_0x012b:
            java.lang.Object r2 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            if (r0 != r2) goto L_0x0132
            return r0
        L_0x0132:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        L_0x0135:
            r0 = move-exception
            goto L_0x013a
        L_0x0137:
            r0 = move-exception
            r1 = r16
        L_0x013a:
            r9.releaseClaimedReusableContinuation$kotlinx_coroutines_core()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.BufferedChannel.sendOnNoWaiterSuspend(kotlinx.coroutines.channels.ChannelSegment, int, java.lang.Object, long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0090, code lost:
        r14 = kotlin.Result.Companion;
        r1.resumeWith(kotlin.Result.m516constructorimpl(kotlin.coroutines.jvm.internal.Boxing.boxBoolean(false)));
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ <E> java.lang.Object sendBroadcast$suspendImpl(kotlinx.coroutines.channels.BufferedChannel<E> r14, E r15, kotlin.coroutines.Continuation<? super java.lang.Boolean> r16) {
        /*
            kotlinx.coroutines.CancellableContinuationImpl r0 = new kotlinx.coroutines.CancellableContinuationImpl
            kotlin.coroutines.Continuation r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.intercepted(r16)
            r2 = 1
            r0.<init>(r1, r2)
            r0.initCancellability()
            r1 = r0
            kotlinx.coroutines.CancellableContinuation r1 = (kotlinx.coroutines.CancellableContinuation) r1
            kotlin.jvm.functions.Function1<E, kotlin.Unit> r3 = r14.onUndeliveredElement
            if (r3 != 0) goto L_0x00ce
            kotlinx.coroutines.channels.BufferedChannel$SendBroadcast r10 = new kotlinx.coroutines.channels.BufferedChannel$SendBroadcast
            r10.<init>(r1)
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r3 = sendSegment$volatile$FU
            java.lang.Object r3 = r3.get(r14)
            kotlinx.coroutines.channels.ChannelSegment r3 = (kotlinx.coroutines.channels.ChannelSegment) r3
        L_0x0023:
            java.util.concurrent.atomic.AtomicLongFieldUpdater r4 = sendersAndCloseStatus$volatile$FU
            long r4 = r4.getAndIncrement(r14)
            r6 = 1152921504606846975(0xfffffffffffffff, double:1.2882297539194265E-231)
            long r8 = r4 & r6
            boolean r11 = r14.isClosedForSend0(r4)
            int r4 = kotlinx.coroutines.channels.BufferedChannelKt.SEGMENT_SIZE
            long r4 = (long) r4
            long r4 = r8 / r4
            int r6 = kotlinx.coroutines.channels.BufferedChannelKt.SEGMENT_SIZE
            long r6 = (long) r6
            long r6 = r8 % r6
            int r6 = (int) r6
            long r12 = r3.id
            int r7 = (r12 > r4 ? 1 : (r12 == r4 ? 0 : -1))
            r12 = 0
            if (r7 == 0) goto L_0x0055
            kotlinx.coroutines.channels.ChannelSegment r4 = r14.findSegmentSend(r4, r3)
            if (r4 != 0) goto L_0x0051
            if (r11 == 0) goto L_0x0023
            goto L_0x0090
        L_0x0051:
            r5 = r4
            r7 = r15
            r4 = r14
            goto L_0x0058
        L_0x0055:
            r5 = r3
            r4 = r14
            r7 = r15
        L_0x0058:
            int r3 = r4.updateCellSend(r5, r6, r7, r8, r10, r11)
            r4 = r5
            if (r3 == 0) goto L_0x00ae
            if (r3 == r2) goto L_0x00b1
            r7 = 2
            if (r3 == r7) goto L_0x008b
            r6 = 3
            if (r3 == r6) goto L_0x007f
            r6 = 4
            if (r3 == r6) goto L_0x0073
            r6 = 5
            if (r3 == r6) goto L_0x006e
            goto L_0x0071
        L_0x006e:
            r4.cleanPrev()
        L_0x0071:
            r3 = r4
            goto L_0x0023
        L_0x0073:
            long r14 = r14.getReceiversCounter$kotlinx_coroutines_core()
            int r14 = (r8 > r14 ? 1 : (r8 == r14 ? 0 : -1))
            if (r14 >= 0) goto L_0x0090
            r4.cleanPrev()
            goto L_0x0090
        L_0x007f:
            java.lang.IllegalStateException r14 = new java.lang.IllegalStateException
            java.lang.String r15 = "unexpected"
            java.lang.String r15 = r15.toString()
            r14.<init>(r15)
            throw r14
        L_0x008b:
            if (r11 == 0) goto L_0x00a0
            r4.onSlotCleaned()
        L_0x0090:
            kotlin.coroutines.Continuation r1 = (kotlin.coroutines.Continuation) r1
            kotlin.Result$Companion r14 = kotlin.Result.Companion
            java.lang.Boolean r14 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r12)
            java.lang.Object r14 = kotlin.Result.m516constructorimpl(r14)
            r1.resumeWith(r14)
            goto L_0x00c0
        L_0x00a0:
            boolean r15 = r10 instanceof kotlinx.coroutines.Waiter
            if (r15 == 0) goto L_0x00a7
            kotlinx.coroutines.Waiter r10 = (kotlinx.coroutines.Waiter) r10
            goto L_0x00a8
        L_0x00a7:
            r10 = 0
        L_0x00a8:
            if (r10 == 0) goto L_0x00c0
            r14.prepareSenderForSuspension(r10, r4, r6)
            goto L_0x00c0
        L_0x00ae:
            r4.cleanPrev()
        L_0x00b1:
            kotlin.coroutines.Continuation r1 = (kotlin.coroutines.Continuation) r1
            kotlin.Result$Companion r14 = kotlin.Result.Companion
            java.lang.Boolean r14 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r2)
            java.lang.Object r14 = kotlin.Result.m516constructorimpl(r14)
            r1.resumeWith(r14)
        L_0x00c0:
            java.lang.Object r14 = r0.getResult()
            java.lang.Object r15 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            if (r14 != r15) goto L_0x00cd
            kotlin.coroutines.jvm.internal.DebugProbesKt.probeCoroutineSuspended(r16)
        L_0x00cd:
            return r14
        L_0x00ce:
            java.lang.IllegalStateException r14 = new java.lang.IllegalStateException
            java.lang.String r15 = "the `onUndeliveredElement` feature is unsupported for `sendBroadcast(e)`"
            java.lang.String r15 = r15.toString()
            r14.<init>(r15)
            throw r14
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.BufferedChannel.sendBroadcast$suspendImpl(kotlinx.coroutines.channels.BufferedChannel, java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: type inference failed for: r12v4, types: [kotlin.reflect.KFunction] */
    /* JADX WARNING: type inference failed for: r12v11, types: [kotlin.reflect.KFunction] */
    /* access modifiers changed from: private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object receiveOnNoWaiterSuspend(kotlinx.coroutines.channels.ChannelSegment<E> r10, int r11, long r12, kotlin.coroutines.Continuation<? super E> r14) {
        /*
            r9 = this;
            kotlin.coroutines.Continuation r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.intercepted(r14)
            kotlinx.coroutines.CancellableContinuationImpl r1 = kotlinx.coroutines.CancellableContinuationKt.getOrCreateCancellableContinuation(r0)
            r7 = r1
            kotlinx.coroutines.Waiter r7 = (kotlinx.coroutines.Waiter) r7     // Catch:{ all -> 0x00e0 }
            r2 = r9
            r3 = r10
            r4 = r11
            r5 = r12
            java.lang.Object r10 = r2.updateCellReceive(r3, r4, r5, r7)     // Catch:{ all -> 0x00de }
            kotlinx.coroutines.internal.Symbol r11 = kotlinx.coroutines.channels.BufferedChannelKt.SUSPEND     // Catch:{ all -> 0x00de }
            if (r10 != r11) goto L_0x0021
            r10 = r1
            kotlinx.coroutines.Waiter r10 = (kotlinx.coroutines.Waiter) r10     // Catch:{ all -> 0x00de }
            r9.prepareReceiverForSuspension(r10, r3, r4)     // Catch:{ all -> 0x00de }
            goto L_0x00d0
        L_0x0021:
            kotlinx.coroutines.internal.Symbol r11 = kotlinx.coroutines.channels.BufferedChannelKt.FAILED     // Catch:{ all -> 0x00de }
            r12 = 0
            if (r10 != r11) goto L_0x00c2
            long r10 = r9.getSendersCounter$kotlinx_coroutines_core()     // Catch:{ all -> 0x00de }
            int r10 = (r5 > r10 ? 1 : (r5 == r10 ? 0 : -1))
            if (r10 >= 0) goto L_0x0033
            r3.cleanPrev()     // Catch:{ all -> 0x00de }
        L_0x0033:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r10 = receiveSegment$volatile$FU     // Catch:{ all -> 0x00de }
            java.lang.Object r10 = r10.get(r9)     // Catch:{ all -> 0x00de }
            kotlinx.coroutines.channels.ChannelSegment r10 = (kotlinx.coroutines.channels.ChannelSegment) r10     // Catch:{ all -> 0x00de }
        L_0x003d:
            boolean r11 = r9.isClosedForReceive()     // Catch:{ all -> 0x00de }
            if (r11 == 0) goto L_0x004b
            r10 = r1
            kotlinx.coroutines.CancellableContinuation r10 = (kotlinx.coroutines.CancellableContinuation) r10     // Catch:{ all -> 0x00de }
            r9.onClosedReceiveOnNoWaiterSuspend(r10)     // Catch:{ all -> 0x00de }
            goto L_0x00d0
        L_0x004b:
            java.util.concurrent.atomic.AtomicLongFieldUpdater r11 = receivers$volatile$FU     // Catch:{ all -> 0x00de }
            long r5 = r11.getAndIncrement(r9)     // Catch:{ all -> 0x00de }
            int r11 = kotlinx.coroutines.channels.BufferedChannelKt.SEGMENT_SIZE     // Catch:{ all -> 0x00de }
            long r3 = (long) r11     // Catch:{ all -> 0x00de }
            long r3 = r5 / r3
            int r11 = kotlinx.coroutines.channels.BufferedChannelKt.SEGMENT_SIZE     // Catch:{ all -> 0x00de }
            long r7 = (long) r11     // Catch:{ all -> 0x00de }
            long r7 = r5 % r7
            int r11 = (int) r7     // Catch:{ all -> 0x00de }
            long r7 = r10.id     // Catch:{ all -> 0x00de }
            int r13 = (r7 > r3 ? 1 : (r7 == r3 ? 0 : -1))
            if (r13 == 0) goto L_0x006d
            kotlinx.coroutines.channels.ChannelSegment r13 = r9.findSegmentReceive(r3, r10)     // Catch:{ all -> 0x00de }
            if (r13 != 0) goto L_0x006b
            goto L_0x003d
        L_0x006b:
            r3 = r13
            goto L_0x006e
        L_0x006d:
            r3 = r10
        L_0x006e:
            r7 = r1
            kotlinx.coroutines.Waiter r7 = (kotlinx.coroutines.Waiter) r7     // Catch:{ all -> 0x00de }
            r4 = r11
            java.lang.Object r10 = r2.updateCellReceive(r3, r4, r5, r7)     // Catch:{ all -> 0x00de }
            kotlinx.coroutines.internal.Symbol r11 = kotlinx.coroutines.channels.BufferedChannelKt.SUSPEND     // Catch:{ all -> 0x00de }
            if (r10 != r11) goto L_0x008c
            r10 = r1
            kotlinx.coroutines.Waiter r10 = (kotlinx.coroutines.Waiter) r10     // Catch:{ all -> 0x00de }
            boolean r10 = r10 instanceof kotlinx.coroutines.Waiter     // Catch:{ all -> 0x00de }
            if (r10 == 0) goto L_0x0086
            r12 = r1
            kotlinx.coroutines.Waiter r12 = (kotlinx.coroutines.Waiter) r12     // Catch:{ all -> 0x00de }
        L_0x0086:
            if (r12 == 0) goto L_0x00d0
            r9.prepareReceiverForSuspension(r12, r3, r4)     // Catch:{ all -> 0x00de }
            goto L_0x00d0
        L_0x008c:
            kotlinx.coroutines.internal.Symbol r11 = kotlinx.coroutines.channels.BufferedChannelKt.FAILED     // Catch:{ all -> 0x00de }
            if (r10 != r11) goto L_0x009f
            long r10 = r9.getSendersCounter$kotlinx_coroutines_core()     // Catch:{ all -> 0x00de }
            int r10 = (r5 > r10 ? 1 : (r5 == r10 ? 0 : -1))
            if (r10 >= 0) goto L_0x009d
            r3.cleanPrev()     // Catch:{ all -> 0x00de }
        L_0x009d:
            r10 = r3
            goto L_0x003d
        L_0x009f:
            kotlinx.coroutines.internal.Symbol r11 = kotlinx.coroutines.channels.BufferedChannelKt.SUSPEND_NO_WAITER     // Catch:{ all -> 0x00de }
            if (r10 == r11) goto L_0x00b6
            r3.cleanPrev()     // Catch:{ all -> 0x00de }
            kotlin.jvm.functions.Function1<E, kotlin.Unit> r11 = r2.onUndeliveredElement     // Catch:{ all -> 0x00de }
            if (r11 == 0) goto L_0x00b0
            kotlin.reflect.KFunction r12 = r9.bindCancellationFun(r11)     // Catch:{ all -> 0x00de }
        L_0x00b0:
            kotlin.jvm.functions.Function3 r12 = (kotlin.jvm.functions.Function3) r12     // Catch:{ all -> 0x00de }
        L_0x00b2:
            r1.resume(r10, r12)     // Catch:{ all -> 0x00de }
            goto L_0x00d0
        L_0x00b6:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException     // Catch:{ all -> 0x00de }
            java.lang.String r11 = "unexpected"
            java.lang.String r11 = r11.toString()     // Catch:{ all -> 0x00de }
            r10.<init>(r11)     // Catch:{ all -> 0x00de }
            throw r10     // Catch:{ all -> 0x00de }
        L_0x00c2:
            r3.cleanPrev()     // Catch:{ all -> 0x00de }
            kotlin.jvm.functions.Function1<E, kotlin.Unit> r11 = r2.onUndeliveredElement     // Catch:{ all -> 0x00de }
            if (r11 == 0) goto L_0x00cd
            kotlin.reflect.KFunction r12 = r9.bindCancellationFun(r11)     // Catch:{ all -> 0x00de }
        L_0x00cd:
            kotlin.jvm.functions.Function3 r12 = (kotlin.jvm.functions.Function3) r12     // Catch:{ all -> 0x00de }
            goto L_0x00b2
        L_0x00d0:
            java.lang.Object r10 = r1.getResult()
            java.lang.Object r11 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            if (r10 != r11) goto L_0x00dd
            kotlin.coroutines.jvm.internal.DebugProbesKt.probeCoroutineSuspended(r14)
        L_0x00dd:
            return r10
        L_0x00de:
            r0 = move-exception
            goto L_0x00e2
        L_0x00e0:
            r0 = move-exception
            r2 = r9
        L_0x00e2:
            r10 = r0
            r1.releaseClaimedReusableContinuation$kotlinx_coroutines_core()
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.BufferedChannel.receiveOnNoWaiterSuspend(kotlinx.coroutines.channels.ChannelSegment, int, long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: protected */
    public void registerSelectForSend(SelectInstance<?> selectInstance, Object obj) {
        ChannelSegment channelSegment;
        ChannelSegment channelSegment2 = (ChannelSegment) sendSegment$volatile$FU.get(this);
        while (true) {
            long andIncrement = sendersAndCloseStatus$volatile$FU.getAndIncrement(this);
            long j = andIncrement & 1152921504606846975L;
            boolean access$isClosedForSend0 = isClosedForSend0(andIncrement);
            long j2 = j / ((long) BufferedChannelKt.SEGMENT_SIZE);
            int i = (int) (j % ((long) BufferedChannelKt.SEGMENT_SIZE));
            if (channelSegment2.id != j2) {
                ChannelSegment access$findSegmentSend = findSegmentSend(j2, channelSegment2);
                if (access$findSegmentSend != null) {
                    channelSegment = access$findSegmentSend;
                } else if (access$isClosedForSend0) {
                    onClosedSelectOnSend(obj, selectInstance);
                    return;
                }
            } else {
                channelSegment = channelSegment2;
            }
            SelectInstance<?> selectInstance2 = selectInstance;
            Object obj2 = obj;
            int access$updateCellSend = updateCellSend(channelSegment, i, obj2, j, selectInstance2, access$isClosedForSend0);
            channelSegment2 = channelSegment;
            if (access$updateCellSend == 0) {
                channelSegment2.cleanPrev();
                selectInstance2.selectInRegistrationPhase(Unit.INSTANCE);
                return;
            } else if (access$updateCellSend == 1) {
                selectInstance2.selectInRegistrationPhase(Unit.INSTANCE);
                return;
            } else if (access$updateCellSend != 2) {
                if (access$updateCellSend == 3) {
                    throw new IllegalStateException("unexpected".toString());
                } else if (access$updateCellSend != 4) {
                    if (access$updateCellSend == 5) {
                        channelSegment2.cleanPrev();
                    }
                    obj = obj2;
                    selectInstance = selectInstance2;
                } else {
                    if (j < getReceiversCounter$kotlinx_coroutines_core()) {
                        channelSegment2.cleanPrev();
                    }
                    onClosedSelectOnSend(obj2, selectInstance2);
                    return;
                }
            } else if (access$isClosedForSend0) {
                channelSegment2.onSlotCleaned();
                onClosedSelectOnSend(obj2, selectInstance2);
                return;
            } else {
                Waiter waiter = selectInstance2 instanceof Waiter ? (Waiter) selectInstance2 : null;
                if (waiter != null) {
                    prepareSenderForSuspension(waiter, channelSegment2, i);
                    return;
                }
                return;
            }
        }
    }

    /* access modifiers changed from: private */
    public final void registerSelectForReceive(SelectInstance<?> selectInstance, Object obj) {
        ChannelSegment channelSegment;
        ChannelSegment channelSegment2 = (ChannelSegment) receiveSegment$volatile$FU.get(this);
        while (!isClosedForReceive()) {
            long andIncrement = receivers$volatile$FU.getAndIncrement(this);
            long j = andIncrement / ((long) BufferedChannelKt.SEGMENT_SIZE);
            int i = (int) (andIncrement % ((long) BufferedChannelKt.SEGMENT_SIZE));
            if (channelSegment2.id != j) {
                ChannelSegment access$findSegmentReceive = findSegmentReceive(j, channelSegment2);
                if (access$findSegmentReceive == null) {
                    continue;
                } else {
                    channelSegment = access$findSegmentReceive;
                }
            } else {
                channelSegment = channelSegment2;
            }
            SelectInstance<?> selectInstance2 = selectInstance;
            Object access$updateCellReceive = updateCellReceive(channelSegment, i, andIncrement, selectInstance2);
            channelSegment2 = channelSegment;
            if (access$updateCellReceive == BufferedChannelKt.SUSPEND) {
                Waiter waiter = selectInstance2 instanceof Waiter ? (Waiter) selectInstance2 : null;
                if (waiter != null) {
                    prepareReceiverForSuspension(waiter, channelSegment2, i);
                    return;
                }
                return;
            } else if (access$updateCellReceive == BufferedChannelKt.FAILED) {
                if (andIncrement < getSendersCounter$kotlinx_coroutines_core()) {
                    channelSegment2.cleanPrev();
                }
                selectInstance = selectInstance2;
            } else if (access$updateCellReceive != BufferedChannelKt.SUSPEND_NO_WAITER) {
                channelSegment2.cleanPrev();
                selectInstance2.selectInRegistrationPhase(access$updateCellReceive);
                return;
            } else {
                throw new IllegalStateException("unexpected".toString());
            }
        }
        onClosedSelectOnReceive(selectInstance);
    }
}
