package androidx.datastore.preferences.protobuf;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.text.HtmlCompat;
import androidx.datastore.preferences.protobuf.ArrayDecoders;
import androidx.datastore.preferences.protobuf.ByteString;
import androidx.datastore.preferences.protobuf.Internal;
import androidx.datastore.preferences.protobuf.MapEntryLite;
import androidx.datastore.preferences.protobuf.WireFormat;
import androidx.datastore.preferences.protobuf.Writer;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;
import sun.misc.Unsafe;

@CheckReturnValue
final class MessageSchema<T> implements Schema<T> {
    private static final int CHECK_INITIALIZED_BIT = 1024;
    private static final int[] EMPTY_INT_ARRAY = new int[0];
    private static final int ENFORCE_UTF8_MASK = 536870912;
    private static final int FIELD_TYPE_MASK = 267386880;
    private static final int HAS_HAS_BIT = 4096;
    private static final int INTS_PER_FIELD = 3;
    private static final int LEGACY_ENUM_IS_CLOSED_BIT = 2048;
    private static final int LEGACY_ENUM_IS_CLOSED_MASK = Integer.MIN_VALUE;
    private static final int NO_PRESENCE_SENTINEL = 1048575;
    private static final int OFFSET_BITS = 20;
    private static final int OFFSET_MASK = 1048575;
    static final int ONEOF_TYPE_OFFSET = 51;
    private static final int REQUIRED_BIT = 256;
    private static final int REQUIRED_MASK = 268435456;
    private static final Unsafe UNSAFE = UnsafeUtil.getUnsafe();
    private static final int UTF8_CHECK_BIT = 512;
    private final int[] buffer;
    private final int checkInitializedCount;
    private final MessageLite defaultInstance;
    private final ExtensionSchema<?> extensionSchema;
    private final boolean hasExtensions;
    private final int[] intArray;
    private final ListFieldSchema listFieldSchema;
    private final boolean lite;
    private final MapFieldSchema mapFieldSchema;
    private final int maxFieldNumber;
    private final int minFieldNumber;
    private final NewInstanceSchema newInstanceSchema;
    private final Object[] objects;
    private final int repeatedFieldOffsetStart;
    private final ProtoSyntax syntax;
    private final UnknownFieldSchema<?, ?> unknownFieldSchema;
    private final boolean useCachedSizeField;

    private static boolean isEnforceUtf8(int i) {
        return (i & ENFORCE_UTF8_MASK) != 0;
    }

    private static boolean isLegacyEnumIsClosed(int i) {
        return (i & Integer.MIN_VALUE) != 0;
    }

    private static boolean isRequired(int i) {
        return (i & REQUIRED_MASK) != 0;
    }

    private static long offset(int i) {
        return (long) (i & 1048575);
    }

    private static int type(int i) {
        return (i & FIELD_TYPE_MASK) >>> 20;
    }

    private MessageSchema(int[] iArr, Object[] objArr, int i, int i2, MessageLite messageLite, ProtoSyntax protoSyntax, boolean z, int[] iArr2, int i3, int i4, NewInstanceSchema newInstanceSchema2, ListFieldSchema listFieldSchema2, UnknownFieldSchema<?, ?> unknownFieldSchema2, ExtensionSchema<?> extensionSchema2, MapFieldSchema mapFieldSchema2) {
        this.buffer = iArr;
        this.objects = objArr;
        this.minFieldNumber = i;
        this.maxFieldNumber = i2;
        this.lite = messageLite instanceof GeneratedMessageLite;
        this.syntax = protoSyntax;
        this.hasExtensions = extensionSchema2 != null && extensionSchema2.hasExtensions(messageLite);
        this.useCachedSizeField = z;
        this.intArray = iArr2;
        this.checkInitializedCount = i3;
        this.repeatedFieldOffsetStart = i4;
        this.newInstanceSchema = newInstanceSchema2;
        this.listFieldSchema = listFieldSchema2;
        this.unknownFieldSchema = unknownFieldSchema2;
        this.extensionSchema = extensionSchema2;
        this.defaultInstance = messageLite;
        this.mapFieldSchema = mapFieldSchema2;
    }

    static <T> MessageSchema<T> newSchema(Class<T> cls, MessageInfo messageInfo, NewInstanceSchema newInstanceSchema2, ListFieldSchema listFieldSchema2, UnknownFieldSchema<?, ?> unknownFieldSchema2, ExtensionSchema<?> extensionSchema2, MapFieldSchema mapFieldSchema2) {
        if (messageInfo instanceof RawMessageInfo) {
            return newSchemaForRawMessageInfo((RawMessageInfo) messageInfo, newInstanceSchema2, listFieldSchema2, unknownFieldSchema2, extensionSchema2, mapFieldSchema2);
        }
        return newSchemaForMessageInfo((StructuralMessageInfo) messageInfo, newInstanceSchema2, listFieldSchema2, unknownFieldSchema2, extensionSchema2, mapFieldSchema2);
    }

    /* JADX WARNING: Removed duplicated region for block: B:118:0x0250  */
    /* JADX WARNING: Removed duplicated region for block: B:119:0x0253  */
    /* JADX WARNING: Removed duplicated region for block: B:122:0x026a  */
    /* JADX WARNING: Removed duplicated region for block: B:123:0x026d  */
    /* JADX WARNING: Removed duplicated region for block: B:159:0x0329  */
    /* JADX WARNING: Removed duplicated region for block: B:172:0x0372  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static <T> androidx.datastore.preferences.protobuf.MessageSchema<T> newSchemaForRawMessageInfo(androidx.datastore.preferences.protobuf.RawMessageInfo r33, androidx.datastore.preferences.protobuf.NewInstanceSchema r34, androidx.datastore.preferences.protobuf.ListFieldSchema r35, androidx.datastore.preferences.protobuf.UnknownFieldSchema<?, ?> r36, androidx.datastore.preferences.protobuf.ExtensionSchema<?> r37, androidx.datastore.preferences.protobuf.MapFieldSchema r38) {
        /*
            java.lang.String r0 = r33.getStringInfo()
            int r1 = r0.length()
            r2 = 0
            char r3 = r0.charAt(r2)
            r5 = 55296(0xd800, float:7.7486E-41)
            if (r3 < r5) goto L_0x001d
            r3 = 1
        L_0x0013:
            int r6 = r3 + 1
            char r3 = r0.charAt(r3)
            if (r3 < r5) goto L_0x001e
            r3 = r6
            goto L_0x0013
        L_0x001d:
            r6 = 1
        L_0x001e:
            int r3 = r6 + 1
            char r6 = r0.charAt(r6)
            if (r6 < r5) goto L_0x003d
            r6 = r6 & 8191(0x1fff, float:1.1478E-41)
            r8 = 13
        L_0x002a:
            int r9 = r3 + 1
            char r3 = r0.charAt(r3)
            if (r3 < r5) goto L_0x003a
            r3 = r3 & 8191(0x1fff, float:1.1478E-41)
            int r3 = r3 << r8
            r6 = r6 | r3
            int r8 = r8 + 13
            r3 = r9
            goto L_0x002a
        L_0x003a:
            int r3 = r3 << r8
            r6 = r6 | r3
            r3 = r9
        L_0x003d:
            if (r6 != 0) goto L_0x004e
            int[] r6 = EMPTY_INT_ARRAY
            r8 = r2
            r10 = r8
            r11 = r10
            r12 = r11
            r15 = r12
            r17 = r15
            r16 = r6
            r6 = r17
            goto L_0x015a
        L_0x004e:
            int r6 = r3 + 1
            char r3 = r0.charAt(r3)
            if (r3 < r5) goto L_0x006d
            r3 = r3 & 8191(0x1fff, float:1.1478E-41)
            r8 = 13
        L_0x005a:
            int r9 = r6 + 1
            char r6 = r0.charAt(r6)
            if (r6 < r5) goto L_0x006a
            r6 = r6 & 8191(0x1fff, float:1.1478E-41)
            int r6 = r6 << r8
            r3 = r3 | r6
            int r8 = r8 + 13
            r6 = r9
            goto L_0x005a
        L_0x006a:
            int r6 = r6 << r8
            r3 = r3 | r6
            r6 = r9
        L_0x006d:
            int r8 = r6 + 1
            char r6 = r0.charAt(r6)
            if (r6 < r5) goto L_0x008c
            r6 = r6 & 8191(0x1fff, float:1.1478E-41)
            r9 = 13
        L_0x0079:
            int r10 = r8 + 1
            char r8 = r0.charAt(r8)
            if (r8 < r5) goto L_0x0089
            r8 = r8 & 8191(0x1fff, float:1.1478E-41)
            int r8 = r8 << r9
            r6 = r6 | r8
            int r9 = r9 + 13
            r8 = r10
            goto L_0x0079
        L_0x0089:
            int r8 = r8 << r9
            r6 = r6 | r8
            r8 = r10
        L_0x008c:
            int r9 = r8 + 1
            char r8 = r0.charAt(r8)
            if (r8 < r5) goto L_0x00ab
            r8 = r8 & 8191(0x1fff, float:1.1478E-41)
            r10 = 13
        L_0x0098:
            int r11 = r9 + 1
            char r9 = r0.charAt(r9)
            if (r9 < r5) goto L_0x00a8
            r9 = r9 & 8191(0x1fff, float:1.1478E-41)
            int r9 = r9 << r10
            r8 = r8 | r9
            int r10 = r10 + 13
            r9 = r11
            goto L_0x0098
        L_0x00a8:
            int r9 = r9 << r10
            r8 = r8 | r9
            r9 = r11
        L_0x00ab:
            int r10 = r9 + 1
            char r9 = r0.charAt(r9)
            if (r9 < r5) goto L_0x00ca
            r9 = r9 & 8191(0x1fff, float:1.1478E-41)
            r11 = 13
        L_0x00b7:
            int r12 = r10 + 1
            char r10 = r0.charAt(r10)
            if (r10 < r5) goto L_0x00c7
            r10 = r10 & 8191(0x1fff, float:1.1478E-41)
            int r10 = r10 << r11
            r9 = r9 | r10
            int r11 = r11 + 13
            r10 = r12
            goto L_0x00b7
        L_0x00c7:
            int r10 = r10 << r11
            r9 = r9 | r10
            r10 = r12
        L_0x00ca:
            int r11 = r10 + 1
            char r10 = r0.charAt(r10)
            if (r10 < r5) goto L_0x00e9
            r10 = r10 & 8191(0x1fff, float:1.1478E-41)
            r12 = 13
        L_0x00d6:
            int r13 = r11 + 1
            char r11 = r0.charAt(r11)
            if (r11 < r5) goto L_0x00e6
            r11 = r11 & 8191(0x1fff, float:1.1478E-41)
            int r11 = r11 << r12
            r10 = r10 | r11
            int r12 = r12 + 13
            r11 = r13
            goto L_0x00d6
        L_0x00e6:
            int r11 = r11 << r12
            r10 = r10 | r11
            r11 = r13
        L_0x00e9:
            int r12 = r11 + 1
            char r11 = r0.charAt(r11)
            if (r11 < r5) goto L_0x0108
            r11 = r11 & 8191(0x1fff, float:1.1478E-41)
            r13 = 13
        L_0x00f5:
            int r14 = r12 + 1
            char r12 = r0.charAt(r12)
            if (r12 < r5) goto L_0x0105
            r12 = r12 & 8191(0x1fff, float:1.1478E-41)
            int r12 = r12 << r13
            r11 = r11 | r12
            int r13 = r13 + 13
            r12 = r14
            goto L_0x00f5
        L_0x0105:
            int r12 = r12 << r13
            r11 = r11 | r12
            r12 = r14
        L_0x0108:
            int r13 = r12 + 1
            char r12 = r0.charAt(r12)
            if (r12 < r5) goto L_0x0127
            r12 = r12 & 8191(0x1fff, float:1.1478E-41)
            r14 = 13
        L_0x0114:
            int r15 = r13 + 1
            char r13 = r0.charAt(r13)
            if (r13 < r5) goto L_0x0124
            r13 = r13 & 8191(0x1fff, float:1.1478E-41)
            int r13 = r13 << r14
            r12 = r12 | r13
            int r14 = r14 + 13
            r13 = r15
            goto L_0x0114
        L_0x0124:
            int r13 = r13 << r14
            r12 = r12 | r13
            r13 = r15
        L_0x0127:
            int r14 = r13 + 1
            char r13 = r0.charAt(r13)
            if (r13 < r5) goto L_0x0148
            r13 = r13 & 8191(0x1fff, float:1.1478E-41)
            r15 = 13
        L_0x0133:
            int r16 = r14 + 1
            char r14 = r0.charAt(r14)
            if (r14 < r5) goto L_0x0144
            r14 = r14 & 8191(0x1fff, float:1.1478E-41)
            int r14 = r14 << r15
            r13 = r13 | r14
            int r15 = r15 + 13
            r14 = r16
            goto L_0x0133
        L_0x0144:
            int r14 = r14 << r15
            r13 = r13 | r14
            r14 = r16
        L_0x0148:
            int r15 = r13 + r11
            int r15 = r15 + r12
            int[] r12 = new int[r15]
            int r15 = r3 * 2
            int r15 = r15 + r6
            r6 = r11
            r11 = r8
            r8 = r6
            r6 = r3
            r16 = r12
            r17 = r13
            r3 = r14
            r12 = r9
        L_0x015a:
            sun.misc.Unsafe r9 = UNSAFE
            java.lang.Object[] r13 = r33.getObjects()
            androidx.datastore.preferences.protobuf.MessageLite r14 = r33.getDefaultInstance()
            java.lang.Class r14 = r14.getClass()
            int r2 = r10 * 3
            int[] r2 = new int[r2]
            int r10 = r10 * 2
            java.lang.Object[] r10 = new java.lang.Object[r10]
            int r8 = r17 + r8
            r22 = r8
            r21 = r17
            r19 = 0
            r20 = 0
        L_0x017a:
            if (r3 >= r1) goto L_0x03cd
            int r23 = r3 + 1
            char r3 = r0.charAt(r3)
            if (r3 < r5) goto L_0x01a4
            r3 = r3 & 8191(0x1fff, float:1.1478E-41)
            r4 = r23
            r23 = 13
            r24 = 1
        L_0x018c:
            int r25 = r4 + 1
            char r4 = r0.charAt(r4)
            if (r4 < r5) goto L_0x019e
            r4 = r4 & 8191(0x1fff, float:1.1478E-41)
            int r4 = r4 << r23
            r3 = r3 | r4
            int r23 = r23 + 13
            r4 = r25
            goto L_0x018c
        L_0x019e:
            int r4 = r4 << r23
            r3 = r3 | r4
            r4 = r25
            goto L_0x01a8
        L_0x01a4:
            r24 = 1
            r4 = r23
        L_0x01a8:
            int r23 = r4 + 1
            char r4 = r0.charAt(r4)
            if (r4 < r5) goto L_0x01ce
            r4 = r4 & 8191(0x1fff, float:1.1478E-41)
            r7 = r23
            r23 = 13
        L_0x01b6:
            int r26 = r7 + 1
            char r7 = r0.charAt(r7)
            if (r7 < r5) goto L_0x01c8
            r7 = r7 & 8191(0x1fff, float:1.1478E-41)
            int r7 = r7 << r23
            r4 = r4 | r7
            int r23 = r23 + 13
            r7 = r26
            goto L_0x01b6
        L_0x01c8:
            int r7 = r7 << r23
            r4 = r4 | r7
            r7 = r26
            goto L_0x01d0
        L_0x01ce:
            r7 = r23
        L_0x01d0:
            r5 = r4 & 255(0xff, float:3.57E-43)
            r26 = r1
            r1 = r4 & 1024(0x400, float:1.435E-42)
            if (r1 == 0) goto L_0x01de
            int r1 = r19 + 1
            r16[r19] = r20
            r19 = r1
        L_0x01de:
            r1 = 51
            r29 = r2
            if (r5 < r1) goto L_0x0286
            int r1 = r7 + 1
            char r7 = r0.charAt(r7)
            r2 = 55296(0xd800, float:7.7486E-41)
            if (r7 < r2) goto L_0x020d
            r7 = r7 & 8191(0x1fff, float:1.1478E-41)
            r31 = 13
        L_0x01f3:
            int r32 = r1 + 1
            char r1 = r0.charAt(r1)
            if (r1 < r2) goto L_0x0208
            r1 = r1 & 8191(0x1fff, float:1.1478E-41)
            int r1 = r1 << r31
            r7 = r7 | r1
            int r31 = r31 + 13
            r1 = r32
            r2 = 55296(0xd800, float:7.7486E-41)
            goto L_0x01f3
        L_0x0208:
            int r1 = r1 << r31
            r7 = r7 | r1
            r1 = r32
        L_0x020d:
            int r2 = r5 + -51
            r31 = r1
            r1 = 9
            if (r2 == r1) goto L_0x023b
            r1 = 17
            if (r2 != r1) goto L_0x021a
            goto L_0x023b
        L_0x021a:
            r1 = 12
            if (r2 != r1) goto L_0x0248
            androidx.datastore.preferences.protobuf.ProtoSyntax r1 = r33.getSyntax()
            androidx.datastore.preferences.protobuf.ProtoSyntax r2 = androidx.datastore.preferences.protobuf.ProtoSyntax.PROTO2
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x022e
            r1 = r4 & 2048(0x800, float:2.87E-42)
            if (r1 == 0) goto L_0x0248
        L_0x022e:
            int r1 = r20 / 3
            int r1 = r1 * 2
            int r1 = r1 + 1
            int r2 = r15 + 1
            r15 = r13[r15]
            r10[r1] = r15
            goto L_0x0247
        L_0x023b:
            int r1 = r20 / 3
            int r1 = r1 * 2
            int r1 = r1 + 1
            int r2 = r15 + 1
            r15 = r13[r15]
            r10[r1] = r15
        L_0x0247:
            r15 = r2
        L_0x0248:
            int r7 = r7 * 2
            r1 = r13[r7]
            boolean r2 = r1 instanceof java.lang.reflect.Field
            if (r2 == 0) goto L_0x0253
            java.lang.reflect.Field r1 = (java.lang.reflect.Field) r1
            goto L_0x025b
        L_0x0253:
            java.lang.String r1 = (java.lang.String) r1
            java.lang.reflect.Field r1 = reflectField(r14, r1)
            r13[r7] = r1
        L_0x025b:
            long r1 = r9.objectFieldOffset(r1)
            int r1 = (int) r1
            int r7 = r7 + 1
            r2 = r13[r7]
            r27 = r1
            boolean r1 = r2 instanceof java.lang.reflect.Field
            if (r1 == 0) goto L_0x026d
            java.lang.reflect.Field r2 = (java.lang.reflect.Field) r2
            goto L_0x0275
        L_0x026d:
            java.lang.String r2 = (java.lang.String) r2
            java.lang.reflect.Field r2 = reflectField(r14, r2)
            r13[r7] = r2
        L_0x0275:
            long r1 = r9.objectFieldOffset(r2)
            int r1 = (int) r1
            r30 = r0
            r0 = r1
            r1 = r27
            r7 = 0
            r27 = r3
            r3 = r31
            goto L_0x038f
        L_0x0286:
            int r1 = r15 + 1
            r2 = r13[r15]
            java.lang.String r2 = (java.lang.String) r2
            java.lang.reflect.Field r2 = reflectField(r14, r2)
            r31 = r1
            r1 = 9
            if (r5 == r1) goto L_0x030c
            r1 = 17
            if (r5 != r1) goto L_0x029c
            goto L_0x030c
        L_0x029c:
            r1 = 27
            if (r5 == r1) goto L_0x02fc
            r1 = 49
            if (r5 != r1) goto L_0x02a5
            goto L_0x02fc
        L_0x02a5:
            r1 = 12
            if (r5 == r1) goto L_0x02e1
            r1 = 30
            if (r5 == r1) goto L_0x02e1
            r1 = 44
            if (r5 != r1) goto L_0x02b2
            goto L_0x02e1
        L_0x02b2:
            r1 = 50
            if (r5 != r1) goto L_0x02de
            int r1 = r21 + 1
            r16[r21] = r20
            int r21 = r20 / 3
            int r21 = r21 * 2
            int r27 = r15 + 2
            r28 = r13[r31]
            r10[r21] = r28
            r28 = r1
            r1 = r4 & 2048(0x800, float:2.87E-42)
            if (r1 == 0) goto L_0x02d7
            int r21 = r21 + 1
            int r1 = r15 + 3
            r15 = r13[r27]
            r10[r21] = r15
            r27 = r3
            r21 = r28
            goto L_0x031c
        L_0x02d7:
            r1 = r27
            r21 = r28
            r27 = r3
            goto L_0x031c
        L_0x02de:
            r27 = r3
            goto L_0x031a
        L_0x02e1:
            androidx.datastore.preferences.protobuf.ProtoSyntax r1 = r33.getSyntax()
            r27 = r3
            androidx.datastore.preferences.protobuf.ProtoSyntax r3 = androidx.datastore.preferences.protobuf.ProtoSyntax.PROTO2
            if (r1 == r3) goto L_0x02ef
            r1 = r4 & 2048(0x800, float:2.87E-42)
            if (r1 == 0) goto L_0x031a
        L_0x02ef:
            int r1 = r20 / 3
            int r1 = r1 * 2
            int r1 = r1 + 1
            int r15 = r15 + 2
            r3 = r13[r31]
            r10[r1] = r3
            goto L_0x030a
        L_0x02fc:
            r27 = r3
            int r1 = r20 / 3
            int r1 = r1 * 2
            int r1 = r1 + 1
            int r15 = r15 + 2
            r3 = r13[r31]
            r10[r1] = r3
        L_0x030a:
            r1 = r15
            goto L_0x031c
        L_0x030c:
            r27 = r3
            int r1 = r20 / 3
            int r1 = r1 * 2
            int r1 = r1 + 1
            java.lang.Class r3 = r2.getType()
            r10[r1] = r3
        L_0x031a:
            r1 = r31
        L_0x031c:
            long r2 = r9.objectFieldOffset(r2)
            int r2 = (int) r2
            r3 = r4 & 4096(0x1000, float:5.74E-42)
            if (r3 == 0) goto L_0x0372
            r3 = 17
            if (r5 > r3) goto L_0x0372
            int r3 = r7 + 1
            char r7 = r0.charAt(r7)
            r15 = 55296(0xd800, float:7.7486E-41)
            if (r7 < r15) goto L_0x034e
            r7 = r7 & 8191(0x1fff, float:1.1478E-41)
            r23 = 13
        L_0x0338:
            int r28 = r3 + 1
            char r3 = r0.charAt(r3)
            if (r3 < r15) goto L_0x034a
            r3 = r3 & 8191(0x1fff, float:1.1478E-41)
            int r3 = r3 << r23
            r7 = r7 | r3
            int r23 = r23 + 13
            r3 = r28
            goto L_0x0338
        L_0x034a:
            int r3 = r3 << r23
            r7 = r7 | r3
            goto L_0x0350
        L_0x034e:
            r28 = r3
        L_0x0350:
            int r3 = r6 * 2
            int r23 = r7 / 32
            int r3 = r3 + r23
            r15 = r13[r3]
            r30 = r0
            boolean r0 = r15 instanceof java.lang.reflect.Field
            if (r0 == 0) goto L_0x0361
            java.lang.reflect.Field r15 = (java.lang.reflect.Field) r15
            goto L_0x0369
        L_0x0361:
            java.lang.String r15 = (java.lang.String) r15
            java.lang.reflect.Field r15 = reflectField(r14, r15)
            r13[r3] = r15
        L_0x0369:
            r3 = r1
            long r0 = r9.objectFieldOffset(r15)
            int r0 = (int) r0
            int r7 = r7 % 32
            goto L_0x037b
        L_0x0372:
            r30 = r0
            r3 = r1
            r0 = 1048575(0xfffff, float:1.469367E-39)
            r28 = r7
            r7 = 0
        L_0x037b:
            r1 = r0
            r0 = 18
            if (r5 < r0) goto L_0x038a
            r0 = 49
            if (r5 > r0) goto L_0x038a
            int r0 = r22 + 1
            r16[r22] = r2
            r22 = r0
        L_0x038a:
            r0 = r1
            r1 = r2
            r15 = r3
            r3 = r28
        L_0x038f:
            int r2 = r20 + 1
            r29[r20] = r27
            int r27 = r20 + 2
            r28 = r0
            r0 = r4 & 512(0x200, float:7.175E-43)
            if (r0 == 0) goto L_0x039e
            r0 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x039f
        L_0x039e:
            r0 = 0
        L_0x039f:
            r31 = r0
            r0 = r4 & 256(0x100, float:3.59E-43)
            if (r0 == 0) goto L_0x03a8
            r0 = 268435456(0x10000000, float:2.5243549E-29)
            goto L_0x03a9
        L_0x03a8:
            r0 = 0
        L_0x03a9:
            r0 = r31 | r0
            r4 = r4 & 2048(0x800, float:2.87E-42)
            if (r4 == 0) goto L_0x03b2
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            goto L_0x03b3
        L_0x03b2:
            r4 = 0
        L_0x03b3:
            r0 = r0 | r4
            int r4 = r5 << 20
            r0 = r0 | r4
            r0 = r0 | r1
            r29[r2] = r0
            int r20 = r20 + 3
            int r0 = r7 << 20
            r0 = r0 | r28
            r29[r27] = r0
            r1 = r26
            r2 = r29
            r0 = r30
            r5 = 55296(0xd800, float:7.7486E-41)
            goto L_0x017a
        L_0x03cd:
            r29 = r2
            androidx.datastore.preferences.protobuf.MessageSchema r0 = new androidx.datastore.preferences.protobuf.MessageSchema
            androidx.datastore.preferences.protobuf.MessageLite r13 = r33.getDefaultInstance()
            androidx.datastore.preferences.protobuf.ProtoSyntax r14 = r33.getSyntax()
            r15 = 0
            r19 = r34
            r20 = r35
            r21 = r36
            r22 = r37
            r23 = r38
            r18 = r8
            r9 = r29
            r8 = r0
            r8.<init>(r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.MessageSchema.newSchemaForRawMessageInfo(androidx.datastore.preferences.protobuf.RawMessageInfo, androidx.datastore.preferences.protobuf.NewInstanceSchema, androidx.datastore.preferences.protobuf.ListFieldSchema, androidx.datastore.preferences.protobuf.UnknownFieldSchema, androidx.datastore.preferences.protobuf.ExtensionSchema, androidx.datastore.preferences.protobuf.MapFieldSchema):androidx.datastore.preferences.protobuf.MessageSchema");
    }

    private static Field reflectField(Class<?> cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (NoSuchFieldException unused) {
            Field[] declaredFields = cls.getDeclaredFields();
            for (Field field : declaredFields) {
                if (str.equals(field.getName())) {
                    return field;
                }
            }
            throw new RuntimeException("Field " + str + " for " + cls.getName() + " not found. Known fields are " + Arrays.toString(declaredFields));
        }
    }

    static <T> MessageSchema<T> newSchemaForMessageInfo(StructuralMessageInfo structuralMessageInfo, NewInstanceSchema newInstanceSchema2, ListFieldSchema listFieldSchema2, UnknownFieldSchema<?, ?> unknownFieldSchema2, ExtensionSchema<?> extensionSchema2, MapFieldSchema mapFieldSchema2) {
        int i;
        int i2;
        int i3;
        FieldInfo[] fields = structuralMessageInfo.getFields();
        if (fields.length == 0) {
            i2 = 0;
            i = 0;
        } else {
            i2 = fields[0].getFieldNumber();
            i = fields[fields.length - 1].getFieldNumber();
        }
        int length = fields.length;
        int[] iArr = new int[(length * 3)];
        Object[] objArr = new Object[(length * 2)];
        int i4 = 0;
        int i5 = 0;
        for (FieldInfo fieldInfo : fields) {
            if (fieldInfo.getType() == FieldType.MAP) {
                i4++;
            } else if (fieldInfo.getType().id() >= 18 && fieldInfo.getType().id() <= 49) {
                i5++;
            }
        }
        int[] iArr2 = null;
        int[] iArr3 = i4 > 0 ? new int[i4] : null;
        if (i5 > 0) {
            iArr2 = new int[i5];
        }
        int[] checkInitialized = structuralMessageInfo.getCheckInitialized();
        if (checkInitialized == null) {
            checkInitialized = EMPTY_INT_ARRAY;
        }
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        int i10 = 0;
        while (i6 < fields.length) {
            FieldInfo fieldInfo2 = fields[i6];
            int fieldNumber = fieldInfo2.getFieldNumber();
            storeFieldData(fieldInfo2, iArr, i7, objArr);
            if (i8 < checkInitialized.length && checkInitialized[i8] == fieldNumber) {
                checkInitialized[i8] = i7;
                i8++;
            }
            if (fieldInfo2.getType() == FieldType.MAP) {
                iArr3[i9] = i7;
                i9++;
            } else if (fieldInfo2.getType().id() >= 18 && fieldInfo2.getType().id() <= 49) {
                i3 = i7;
                iArr2[i10] = (int) UnsafeUtil.objectFieldOffset(fieldInfo2.getField());
                i10++;
                i6++;
                i7 = i3 + 3;
            }
            i3 = i7;
            i6++;
            i7 = i3 + 3;
        }
        if (iArr3 == null) {
            iArr3 = EMPTY_INT_ARRAY;
        }
        if (iArr2 == null) {
            iArr2 = EMPTY_INT_ARRAY;
        }
        int[] iArr4 = new int[(checkInitialized.length + iArr3.length + iArr2.length)];
        System.arraycopy(checkInitialized, 0, iArr4, 0, checkInitialized.length);
        System.arraycopy(iArr3, 0, iArr4, checkInitialized.length, iArr3.length);
        System.arraycopy(iArr2, 0, iArr4, checkInitialized.length + iArr3.length, iArr2.length);
        return new MessageSchema<>(iArr, objArr, i2, i, structuralMessageInfo.getDefaultInstance(), structuralMessageInfo.getSyntax(), true, iArr4, checkInitialized.length, checkInitialized.length + iArr3.length, newInstanceSchema2, listFieldSchema2, unknownFieldSchema2, extensionSchema2, mapFieldSchema2);
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x007a  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x007d  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0084  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x009e  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00be  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void storeFieldData(androidx.datastore.preferences.protobuf.FieldInfo r8, int[] r9, int r10, java.lang.Object[] r11) {
        /*
            androidx.datastore.preferences.protobuf.OneofInfo r0 = r8.getOneof()
            r1 = 0
            if (r0 == 0) goto L_0x0025
            androidx.datastore.preferences.protobuf.FieldType r2 = r8.getType()
            int r2 = r2.id()
            int r2 = r2 + 51
            java.lang.reflect.Field r3 = r0.getValueField()
            long r3 = androidx.datastore.preferences.protobuf.UnsafeUtil.objectFieldOffset(r3)
            int r3 = (int) r3
            java.lang.reflect.Field r0 = r0.getCaseField()
            long r4 = androidx.datastore.preferences.protobuf.UnsafeUtil.objectFieldOffset(r0)
        L_0x0022:
            int r0 = (int) r4
            r4 = r1
            goto L_0x006c
        L_0x0025:
            androidx.datastore.preferences.protobuf.FieldType r0 = r8.getType()
            java.lang.reflect.Field r2 = r8.getField()
            long r2 = androidx.datastore.preferences.protobuf.UnsafeUtil.objectFieldOffset(r2)
            int r3 = (int) r2
            int r2 = r0.id()
            boolean r4 = r0.isList()
            if (r4 != 0) goto L_0x005a
            boolean r0 = r0.isMap()
            if (r0 != 0) goto L_0x005a
            java.lang.reflect.Field r0 = r8.getPresenceField()
            if (r0 != 0) goto L_0x004c
            r0 = 1048575(0xfffff, float:1.469367E-39)
            goto L_0x0051
        L_0x004c:
            long r4 = androidx.datastore.preferences.protobuf.UnsafeUtil.objectFieldOffset(r0)
            int r0 = (int) r4
        L_0x0051:
            int r4 = r8.getPresenceMask()
            int r4 = java.lang.Integer.numberOfTrailingZeros(r4)
            goto L_0x006c
        L_0x005a:
            java.lang.reflect.Field r0 = r8.getCachedSizeField()
            if (r0 != 0) goto L_0x0063
            r0 = r1
            r4 = r0
            goto L_0x006c
        L_0x0063:
            java.lang.reflect.Field r0 = r8.getCachedSizeField()
            long r4 = androidx.datastore.preferences.protobuf.UnsafeUtil.objectFieldOffset(r0)
            goto L_0x0022
        L_0x006c:
            int r5 = r8.getFieldNumber()
            r9[r10] = r5
            int r5 = r10 + 1
            boolean r6 = r8.isEnforceUtf8()
            if (r6 == 0) goto L_0x007d
            r6 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x007e
        L_0x007d:
            r6 = r1
        L_0x007e:
            boolean r7 = r8.isRequired()
            if (r7 == 0) goto L_0x0086
            r1 = 268435456(0x10000000, float:2.5243549E-29)
        L_0x0086:
            r1 = r1 | r6
            int r2 = r2 << 20
            r1 = r1 | r2
            r1 = r1 | r3
            r9[r5] = r1
            int r1 = r10 + 2
            int r2 = r4 << 20
            r0 = r0 | r2
            r9[r1] = r0
            java.lang.Class r9 = r8.getMessageFieldClass()
            java.lang.Object r0 = r8.getMapDefaultEntry()
            if (r0 == 0) goto L_0x00be
            int r10 = r10 / 3
            int r10 = r10 * 2
            java.lang.Object r0 = r8.getMapDefaultEntry()
            r11[r10] = r0
            if (r9 == 0) goto L_0x00af
            int r10 = r10 + 1
            r11[r10] = r9
            return
        L_0x00af:
            androidx.datastore.preferences.protobuf.Internal$EnumVerifier r9 = r8.getEnumVerifier()
            if (r9 == 0) goto L_0x00db
            int r10 = r10 + 1
            androidx.datastore.preferences.protobuf.Internal$EnumVerifier r8 = r8.getEnumVerifier()
            r11[r10] = r8
            return
        L_0x00be:
            if (r9 == 0) goto L_0x00c9
            int r10 = r10 / 3
            int r10 = r10 * 2
            int r10 = r10 + 1
            r11[r10] = r9
            return
        L_0x00c9:
            androidx.datastore.preferences.protobuf.Internal$EnumVerifier r9 = r8.getEnumVerifier()
            if (r9 == 0) goto L_0x00db
            int r10 = r10 / 3
            int r10 = r10 * 2
            int r10 = r10 + 1
            androidx.datastore.preferences.protobuf.Internal$EnumVerifier r8 = r8.getEnumVerifier()
            r11[r10] = r8
        L_0x00db:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.MessageSchema.storeFieldData(androidx.datastore.preferences.protobuf.FieldInfo, int[], int, java.lang.Object[]):void");
    }

    public T newInstance() {
        return this.newInstanceSchema.newInstance(this.defaultInstance);
    }

    public boolean equals(T t, T t2) {
        int length = this.buffer.length;
        for (int i = 0; i < length; i += 3) {
            if (!equals(t, t2, i)) {
                return false;
            }
        }
        if (!this.unknownFieldSchema.getFromMessage(t).equals(this.unknownFieldSchema.getFromMessage(t2))) {
            return false;
        }
        if (this.hasExtensions) {
            return this.extensionSchema.getExtensions(t).equals(this.extensionSchema.getExtensions(t2));
        }
        return true;
    }

    private boolean equals(T t, T t2, int i) {
        int typeAndOffsetAt = typeAndOffsetAt(i);
        long offset = offset(typeAndOffsetAt);
        switch (type(typeAndOffsetAt)) {
            case 0:
                return arePresentForEquals(t, t2, i) && Double.doubleToLongBits(UnsafeUtil.getDouble((Object) t, offset)) == Double.doubleToLongBits(UnsafeUtil.getDouble((Object) t2, offset));
            case 1:
                return arePresentForEquals(t, t2, i) && Float.floatToIntBits(UnsafeUtil.getFloat((Object) t, offset)) == Float.floatToIntBits(UnsafeUtil.getFloat((Object) t2, offset));
            case 2:
                return arePresentForEquals(t, t2, i) && UnsafeUtil.getLong((Object) t, offset) == UnsafeUtil.getLong((Object) t2, offset);
            case 3:
                return arePresentForEquals(t, t2, i) && UnsafeUtil.getLong((Object) t, offset) == UnsafeUtil.getLong((Object) t2, offset);
            case 4:
                return arePresentForEquals(t, t2, i) && UnsafeUtil.getInt((Object) t, offset) == UnsafeUtil.getInt((Object) t2, offset);
            case 5:
                return arePresentForEquals(t, t2, i) && UnsafeUtil.getLong((Object) t, offset) == UnsafeUtil.getLong((Object) t2, offset);
            case 6:
                return arePresentForEquals(t, t2, i) && UnsafeUtil.getInt((Object) t, offset) == UnsafeUtil.getInt((Object) t2, offset);
            case 7:
                return arePresentForEquals(t, t2, i) && UnsafeUtil.getBoolean((Object) t, offset) == UnsafeUtil.getBoolean((Object) t2, offset);
            case 8:
                return arePresentForEquals(t, t2, i) && SchemaUtil.safeEquals(UnsafeUtil.getObject((Object) t, offset), UnsafeUtil.getObject((Object) t2, offset));
            case 9:
                return arePresentForEquals(t, t2, i) && SchemaUtil.safeEquals(UnsafeUtil.getObject((Object) t, offset), UnsafeUtil.getObject((Object) t2, offset));
            case 10:
                return arePresentForEquals(t, t2, i) && SchemaUtil.safeEquals(UnsafeUtil.getObject((Object) t, offset), UnsafeUtil.getObject((Object) t2, offset));
            case 11:
                return arePresentForEquals(t, t2, i) && UnsafeUtil.getInt((Object) t, offset) == UnsafeUtil.getInt((Object) t2, offset);
            case 12:
                return arePresentForEquals(t, t2, i) && UnsafeUtil.getInt((Object) t, offset) == UnsafeUtil.getInt((Object) t2, offset);
            case 13:
                return arePresentForEquals(t, t2, i) && UnsafeUtil.getInt((Object) t, offset) == UnsafeUtil.getInt((Object) t2, offset);
            case 14:
                return arePresentForEquals(t, t2, i) && UnsafeUtil.getLong((Object) t, offset) == UnsafeUtil.getLong((Object) t2, offset);
            case 15:
                return arePresentForEquals(t, t2, i) && UnsafeUtil.getInt((Object) t, offset) == UnsafeUtil.getInt((Object) t2, offset);
            case 16:
                return arePresentForEquals(t, t2, i) && UnsafeUtil.getLong((Object) t, offset) == UnsafeUtil.getLong((Object) t2, offset);
            case 17:
                return arePresentForEquals(t, t2, i) && SchemaUtil.safeEquals(UnsafeUtil.getObject((Object) t, offset), UnsafeUtil.getObject((Object) t2, offset));
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
            case 28:
            case 29:
            case 30:
            case 31:
            case 32:
            case 33:
            case 34:
            case 35:
            case 36:
            case 37:
            case 38:
            case 39:
            case 40:
            case 41:
            case 42:
            case 43:
            case 44:
            case 45:
            case 46:
            case 47:
            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE:
            case ConstraintLayout.LayoutParams.Table.LAYOUT_EDITOR_ABSOLUTEX:
                return SchemaUtil.safeEquals(UnsafeUtil.getObject((Object) t, offset), UnsafeUtil.getObject((Object) t2, offset));
            case 50:
                return SchemaUtil.safeEquals(UnsafeUtil.getObject((Object) t, offset), UnsafeUtil.getObject((Object) t2, offset));
            case 51:
            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BASELINE_TO_TOP_OF:
            case 53:
            case ConstraintLayout.LayoutParams.Table.LAYOUT_MARGIN_BASELINE:
            case 55:
            case 56:
            case 57:
            case 58:
            case 59:
            case 60:
            case LockFreeTaskQueueCore.CLOSED_SHIFT /*61*/:
            case 62:
            case HtmlCompat.FROM_HTML_MODE_COMPACT:
            case 64:
            case 65:
            case ConstraintLayout.LayoutParams.Table.LAYOUT_WRAP_BEHAVIOR_IN_PARENT:
            case ConstraintLayout.LayoutParams.Table.GUIDELINE_USE_RTL:
            case 68:
                return isOneofCaseEqual(t, t2, i) && SchemaUtil.safeEquals(UnsafeUtil.getObject((Object) t, offset), UnsafeUtil.getObject((Object) t2, offset));
            default:
                return true;
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x01c1, code lost:
        r2 = (r2 * 53) + r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x0225, code lost:
        r2 = r2 + r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x0226, code lost:
        r1 = r1 + 3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int hashCode(T r9) {
        /*
            r8 = this;
            int[] r0 = r8.buffer
            int r0 = r0.length
            r1 = 0
            r2 = r1
        L_0x0005:
            if (r1 >= r0) goto L_0x022a
            int r3 = r8.typeAndOffsetAt(r1)
            int r4 = r8.numberAt(r1)
            long r5 = offset(r3)
            int r3 = type(r3)
            r7 = 37
            switch(r3) {
                case 0: goto L_0x0217;
                case 1: goto L_0x020c;
                case 2: goto L_0x0201;
                case 3: goto L_0x01f6;
                case 4: goto L_0x01ef;
                case 5: goto L_0x01e4;
                case 6: goto L_0x01dd;
                case 7: goto L_0x01d2;
                case 8: goto L_0x01c5;
                case 9: goto L_0x01b7;
                case 10: goto L_0x01ab;
                case 11: goto L_0x01a3;
                case 12: goto L_0x019b;
                case 13: goto L_0x0193;
                case 14: goto L_0x0187;
                case 15: goto L_0x017f;
                case 16: goto L_0x0173;
                case 17: goto L_0x0168;
                case 18: goto L_0x015c;
                case 19: goto L_0x015c;
                case 20: goto L_0x015c;
                case 21: goto L_0x015c;
                case 22: goto L_0x015c;
                case 23: goto L_0x015c;
                case 24: goto L_0x015c;
                case 25: goto L_0x015c;
                case 26: goto L_0x015c;
                case 27: goto L_0x015c;
                case 28: goto L_0x015c;
                case 29: goto L_0x015c;
                case 30: goto L_0x015c;
                case 31: goto L_0x015c;
                case 32: goto L_0x015c;
                case 33: goto L_0x015c;
                case 34: goto L_0x015c;
                case 35: goto L_0x015c;
                case 36: goto L_0x015c;
                case 37: goto L_0x015c;
                case 38: goto L_0x015c;
                case 39: goto L_0x015c;
                case 40: goto L_0x015c;
                case 41: goto L_0x015c;
                case 42: goto L_0x015c;
                case 43: goto L_0x015c;
                case 44: goto L_0x015c;
                case 45: goto L_0x015c;
                case 46: goto L_0x015c;
                case 47: goto L_0x015c;
                case 48: goto L_0x015c;
                case 49: goto L_0x015c;
                case 50: goto L_0x0150;
                case 51: goto L_0x013a;
                case 52: goto L_0x0128;
                case 53: goto L_0x0116;
                case 54: goto L_0x0104;
                case 55: goto L_0x00f6;
                case 56: goto L_0x00e4;
                case 57: goto L_0x00d6;
                case 58: goto L_0x00c4;
                case 59: goto L_0x00b0;
                case 60: goto L_0x009e;
                case 61: goto L_0x008c;
                case 62: goto L_0x007e;
                case 63: goto L_0x0070;
                case 64: goto L_0x0062;
                case 65: goto L_0x0050;
                case 66: goto L_0x0042;
                case 67: goto L_0x0030;
                case 68: goto L_0x001e;
                default: goto L_0x001c;
            }
        L_0x001c:
            goto L_0x0226
        L_0x001e:
            boolean r3 = r8.isOneofPresent(r9, r4, r1)
            if (r3 == 0) goto L_0x0226
            java.lang.Object r3 = androidx.datastore.preferences.protobuf.UnsafeUtil.getObject((java.lang.Object) r9, (long) r5)
            int r2 = r2 * 53
            int r3 = r3.hashCode()
            goto L_0x0225
        L_0x0030:
            boolean r3 = r8.isOneofPresent(r9, r4, r1)
            if (r3 == 0) goto L_0x0226
            int r2 = r2 * 53
            long r3 = oneofLongAt(r9, r5)
            int r3 = androidx.datastore.preferences.protobuf.Internal.hashLong(r3)
            goto L_0x0225
        L_0x0042:
            boolean r3 = r8.isOneofPresent(r9, r4, r1)
            if (r3 == 0) goto L_0x0226
            int r2 = r2 * 53
            int r3 = oneofIntAt(r9, r5)
            goto L_0x0225
        L_0x0050:
            boolean r3 = r8.isOneofPresent(r9, r4, r1)
            if (r3 == 0) goto L_0x0226
            int r2 = r2 * 53
            long r3 = oneofLongAt(r9, r5)
            int r3 = androidx.datastore.preferences.protobuf.Internal.hashLong(r3)
            goto L_0x0225
        L_0x0062:
            boolean r3 = r8.isOneofPresent(r9, r4, r1)
            if (r3 == 0) goto L_0x0226
            int r2 = r2 * 53
            int r3 = oneofIntAt(r9, r5)
            goto L_0x0225
        L_0x0070:
            boolean r3 = r8.isOneofPresent(r9, r4, r1)
            if (r3 == 0) goto L_0x0226
            int r2 = r2 * 53
            int r3 = oneofIntAt(r9, r5)
            goto L_0x0225
        L_0x007e:
            boolean r3 = r8.isOneofPresent(r9, r4, r1)
            if (r3 == 0) goto L_0x0226
            int r2 = r2 * 53
            int r3 = oneofIntAt(r9, r5)
            goto L_0x0225
        L_0x008c:
            boolean r3 = r8.isOneofPresent(r9, r4, r1)
            if (r3 == 0) goto L_0x0226
            int r2 = r2 * 53
            java.lang.Object r3 = androidx.datastore.preferences.protobuf.UnsafeUtil.getObject((java.lang.Object) r9, (long) r5)
            int r3 = r3.hashCode()
            goto L_0x0225
        L_0x009e:
            boolean r3 = r8.isOneofPresent(r9, r4, r1)
            if (r3 == 0) goto L_0x0226
            java.lang.Object r3 = androidx.datastore.preferences.protobuf.UnsafeUtil.getObject((java.lang.Object) r9, (long) r5)
            int r2 = r2 * 53
            int r3 = r3.hashCode()
            goto L_0x0225
        L_0x00b0:
            boolean r3 = r8.isOneofPresent(r9, r4, r1)
            if (r3 == 0) goto L_0x0226
            int r2 = r2 * 53
            java.lang.Object r3 = androidx.datastore.preferences.protobuf.UnsafeUtil.getObject((java.lang.Object) r9, (long) r5)
            java.lang.String r3 = (java.lang.String) r3
            int r3 = r3.hashCode()
            goto L_0x0225
        L_0x00c4:
            boolean r3 = r8.isOneofPresent(r9, r4, r1)
            if (r3 == 0) goto L_0x0226
            int r2 = r2 * 53
            boolean r3 = oneofBooleanAt(r9, r5)
            int r3 = androidx.datastore.preferences.protobuf.Internal.hashBoolean(r3)
            goto L_0x0225
        L_0x00d6:
            boolean r3 = r8.isOneofPresent(r9, r4, r1)
            if (r3 == 0) goto L_0x0226
            int r2 = r2 * 53
            int r3 = oneofIntAt(r9, r5)
            goto L_0x0225
        L_0x00e4:
            boolean r3 = r8.isOneofPresent(r9, r4, r1)
            if (r3 == 0) goto L_0x0226
            int r2 = r2 * 53
            long r3 = oneofLongAt(r9, r5)
            int r3 = androidx.datastore.preferences.protobuf.Internal.hashLong(r3)
            goto L_0x0225
        L_0x00f6:
            boolean r3 = r8.isOneofPresent(r9, r4, r1)
            if (r3 == 0) goto L_0x0226
            int r2 = r2 * 53
            int r3 = oneofIntAt(r9, r5)
            goto L_0x0225
        L_0x0104:
            boolean r3 = r8.isOneofPresent(r9, r4, r1)
            if (r3 == 0) goto L_0x0226
            int r2 = r2 * 53
            long r3 = oneofLongAt(r9, r5)
            int r3 = androidx.datastore.preferences.protobuf.Internal.hashLong(r3)
            goto L_0x0225
        L_0x0116:
            boolean r3 = r8.isOneofPresent(r9, r4, r1)
            if (r3 == 0) goto L_0x0226
            int r2 = r2 * 53
            long r3 = oneofLongAt(r9, r5)
            int r3 = androidx.datastore.preferences.protobuf.Internal.hashLong(r3)
            goto L_0x0225
        L_0x0128:
            boolean r3 = r8.isOneofPresent(r9, r4, r1)
            if (r3 == 0) goto L_0x0226
            int r2 = r2 * 53
            float r3 = oneofFloatAt(r9, r5)
            int r3 = java.lang.Float.floatToIntBits(r3)
            goto L_0x0225
        L_0x013a:
            boolean r3 = r8.isOneofPresent(r9, r4, r1)
            if (r3 == 0) goto L_0x0226
            int r2 = r2 * 53
            double r3 = oneofDoubleAt(r9, r5)
            long r3 = java.lang.Double.doubleToLongBits(r3)
            int r3 = androidx.datastore.preferences.protobuf.Internal.hashLong(r3)
            goto L_0x0225
        L_0x0150:
            int r2 = r2 * 53
            java.lang.Object r3 = androidx.datastore.preferences.protobuf.UnsafeUtil.getObject((java.lang.Object) r9, (long) r5)
            int r3 = r3.hashCode()
            goto L_0x0225
        L_0x015c:
            int r2 = r2 * 53
            java.lang.Object r3 = androidx.datastore.preferences.protobuf.UnsafeUtil.getObject((java.lang.Object) r9, (long) r5)
            int r3 = r3.hashCode()
            goto L_0x0225
        L_0x0168:
            java.lang.Object r3 = androidx.datastore.preferences.protobuf.UnsafeUtil.getObject((java.lang.Object) r9, (long) r5)
            if (r3 == 0) goto L_0x01c1
            int r7 = r3.hashCode()
            goto L_0x01c1
        L_0x0173:
            int r2 = r2 * 53
            long r3 = androidx.datastore.preferences.protobuf.UnsafeUtil.getLong((java.lang.Object) r9, (long) r5)
            int r3 = androidx.datastore.preferences.protobuf.Internal.hashLong(r3)
            goto L_0x0225
        L_0x017f:
            int r2 = r2 * 53
            int r3 = androidx.datastore.preferences.protobuf.UnsafeUtil.getInt((java.lang.Object) r9, (long) r5)
            goto L_0x0225
        L_0x0187:
            int r2 = r2 * 53
            long r3 = androidx.datastore.preferences.protobuf.UnsafeUtil.getLong((java.lang.Object) r9, (long) r5)
            int r3 = androidx.datastore.preferences.protobuf.Internal.hashLong(r3)
            goto L_0x0225
        L_0x0193:
            int r2 = r2 * 53
            int r3 = androidx.datastore.preferences.protobuf.UnsafeUtil.getInt((java.lang.Object) r9, (long) r5)
            goto L_0x0225
        L_0x019b:
            int r2 = r2 * 53
            int r3 = androidx.datastore.preferences.protobuf.UnsafeUtil.getInt((java.lang.Object) r9, (long) r5)
            goto L_0x0225
        L_0x01a3:
            int r2 = r2 * 53
            int r3 = androidx.datastore.preferences.protobuf.UnsafeUtil.getInt((java.lang.Object) r9, (long) r5)
            goto L_0x0225
        L_0x01ab:
            int r2 = r2 * 53
            java.lang.Object r3 = androidx.datastore.preferences.protobuf.UnsafeUtil.getObject((java.lang.Object) r9, (long) r5)
            int r3 = r3.hashCode()
            goto L_0x0225
        L_0x01b7:
            java.lang.Object r3 = androidx.datastore.preferences.protobuf.UnsafeUtil.getObject((java.lang.Object) r9, (long) r5)
            if (r3 == 0) goto L_0x01c1
            int r7 = r3.hashCode()
        L_0x01c1:
            int r2 = r2 * 53
            int r2 = r2 + r7
            goto L_0x0226
        L_0x01c5:
            int r2 = r2 * 53
            java.lang.Object r3 = androidx.datastore.preferences.protobuf.UnsafeUtil.getObject((java.lang.Object) r9, (long) r5)
            java.lang.String r3 = (java.lang.String) r3
            int r3 = r3.hashCode()
            goto L_0x0225
        L_0x01d2:
            int r2 = r2 * 53
            boolean r3 = androidx.datastore.preferences.protobuf.UnsafeUtil.getBoolean((java.lang.Object) r9, (long) r5)
            int r3 = androidx.datastore.preferences.protobuf.Internal.hashBoolean(r3)
            goto L_0x0225
        L_0x01dd:
            int r2 = r2 * 53
            int r3 = androidx.datastore.preferences.protobuf.UnsafeUtil.getInt((java.lang.Object) r9, (long) r5)
            goto L_0x0225
        L_0x01e4:
            int r2 = r2 * 53
            long r3 = androidx.datastore.preferences.protobuf.UnsafeUtil.getLong((java.lang.Object) r9, (long) r5)
            int r3 = androidx.datastore.preferences.protobuf.Internal.hashLong(r3)
            goto L_0x0225
        L_0x01ef:
            int r2 = r2 * 53
            int r3 = androidx.datastore.preferences.protobuf.UnsafeUtil.getInt((java.lang.Object) r9, (long) r5)
            goto L_0x0225
        L_0x01f6:
            int r2 = r2 * 53
            long r3 = androidx.datastore.preferences.protobuf.UnsafeUtil.getLong((java.lang.Object) r9, (long) r5)
            int r3 = androidx.datastore.preferences.protobuf.Internal.hashLong(r3)
            goto L_0x0225
        L_0x0201:
            int r2 = r2 * 53
            long r3 = androidx.datastore.preferences.protobuf.UnsafeUtil.getLong((java.lang.Object) r9, (long) r5)
            int r3 = androidx.datastore.preferences.protobuf.Internal.hashLong(r3)
            goto L_0x0225
        L_0x020c:
            int r2 = r2 * 53
            float r3 = androidx.datastore.preferences.protobuf.UnsafeUtil.getFloat((java.lang.Object) r9, (long) r5)
            int r3 = java.lang.Float.floatToIntBits(r3)
            goto L_0x0225
        L_0x0217:
            int r2 = r2 * 53
            double r3 = androidx.datastore.preferences.protobuf.UnsafeUtil.getDouble((java.lang.Object) r9, (long) r5)
            long r3 = java.lang.Double.doubleToLongBits(r3)
            int r3 = androidx.datastore.preferences.protobuf.Internal.hashLong(r3)
        L_0x0225:
            int r2 = r2 + r3
        L_0x0226:
            int r1 = r1 + 3
            goto L_0x0005
        L_0x022a:
            int r2 = r2 * 53
            androidx.datastore.preferences.protobuf.UnknownFieldSchema<?, ?> r0 = r8.unknownFieldSchema
            java.lang.Object r0 = r0.getFromMessage(r9)
            int r0 = r0.hashCode()
            int r2 = r2 + r0
            boolean r0 = r8.hasExtensions
            if (r0 == 0) goto L_0x0248
            int r2 = r2 * 53
            androidx.datastore.preferences.protobuf.ExtensionSchema<?> r0 = r8.extensionSchema
            androidx.datastore.preferences.protobuf.FieldSet r9 = r0.getExtensions(r9)
            int r9 = r9.hashCode()
            int r2 = r2 + r9
        L_0x0248:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.MessageSchema.hashCode(java.lang.Object):int");
    }

    public void mergeFrom(T t, T t2) {
        checkMutable(t);
        t2.getClass();
        for (int i = 0; i < this.buffer.length; i += 3) {
            mergeSingleField(t, t2, i);
        }
        SchemaUtil.mergeUnknownFields(this.unknownFieldSchema, t, t2);
        if (this.hasExtensions) {
            SchemaUtil.mergeExtensions(this.extensionSchema, t, t2);
        }
    }

    private void mergeSingleField(T t, T t2, int i) {
        int typeAndOffsetAt = typeAndOffsetAt(i);
        long offset = offset(typeAndOffsetAt);
        int numberAt = numberAt(i);
        switch (type(typeAndOffsetAt)) {
            case 0:
                if (isFieldPresent(t2, i)) {
                    UnsafeUtil.putDouble((Object) t, offset, UnsafeUtil.getDouble((Object) t2, offset));
                    setFieldPresent(t, i);
                    return;
                }
                return;
            case 1:
                if (isFieldPresent(t2, i)) {
                    UnsafeUtil.putFloat((Object) t, offset, UnsafeUtil.getFloat((Object) t2, offset));
                    setFieldPresent(t, i);
                    return;
                }
                return;
            case 2:
                if (isFieldPresent(t2, i)) {
                    UnsafeUtil.putLong((Object) t, offset, UnsafeUtil.getLong((Object) t2, offset));
                    setFieldPresent(t, i);
                    return;
                }
                return;
            case 3:
                if (isFieldPresent(t2, i)) {
                    UnsafeUtil.putLong((Object) t, offset, UnsafeUtil.getLong((Object) t2, offset));
                    setFieldPresent(t, i);
                    return;
                }
                return;
            case 4:
                if (isFieldPresent(t2, i)) {
                    UnsafeUtil.putInt((Object) t, offset, UnsafeUtil.getInt((Object) t2, offset));
                    setFieldPresent(t, i);
                    return;
                }
                return;
            case 5:
                if (isFieldPresent(t2, i)) {
                    UnsafeUtil.putLong((Object) t, offset, UnsafeUtil.getLong((Object) t2, offset));
                    setFieldPresent(t, i);
                    return;
                }
                return;
            case 6:
                if (isFieldPresent(t2, i)) {
                    UnsafeUtil.putInt((Object) t, offset, UnsafeUtil.getInt((Object) t2, offset));
                    setFieldPresent(t, i);
                    return;
                }
                return;
            case 7:
                if (isFieldPresent(t2, i)) {
                    UnsafeUtil.putBoolean((Object) t, offset, UnsafeUtil.getBoolean((Object) t2, offset));
                    setFieldPresent(t, i);
                    return;
                }
                return;
            case 8:
                if (isFieldPresent(t2, i)) {
                    UnsafeUtil.putObject((Object) t, offset, UnsafeUtil.getObject((Object) t2, offset));
                    setFieldPresent(t, i);
                    return;
                }
                return;
            case 9:
                mergeMessage(t, t2, i);
                return;
            case 10:
                if (isFieldPresent(t2, i)) {
                    UnsafeUtil.putObject((Object) t, offset, UnsafeUtil.getObject((Object) t2, offset));
                    setFieldPresent(t, i);
                    return;
                }
                return;
            case 11:
                if (isFieldPresent(t2, i)) {
                    UnsafeUtil.putInt((Object) t, offset, UnsafeUtil.getInt((Object) t2, offset));
                    setFieldPresent(t, i);
                    return;
                }
                return;
            case 12:
                if (isFieldPresent(t2, i)) {
                    UnsafeUtil.putInt((Object) t, offset, UnsafeUtil.getInt((Object) t2, offset));
                    setFieldPresent(t, i);
                    return;
                }
                return;
            case 13:
                if (isFieldPresent(t2, i)) {
                    UnsafeUtil.putInt((Object) t, offset, UnsafeUtil.getInt((Object) t2, offset));
                    setFieldPresent(t, i);
                    return;
                }
                return;
            case 14:
                if (isFieldPresent(t2, i)) {
                    UnsafeUtil.putLong((Object) t, offset, UnsafeUtil.getLong((Object) t2, offset));
                    setFieldPresent(t, i);
                    return;
                }
                return;
            case 15:
                if (isFieldPresent(t2, i)) {
                    UnsafeUtil.putInt((Object) t, offset, UnsafeUtil.getInt((Object) t2, offset));
                    setFieldPresent(t, i);
                    return;
                }
                return;
            case 16:
                if (isFieldPresent(t2, i)) {
                    UnsafeUtil.putLong((Object) t, offset, UnsafeUtil.getLong((Object) t2, offset));
                    setFieldPresent(t, i);
                    return;
                }
                return;
            case 17:
                mergeMessage(t, t2, i);
                return;
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
            case 28:
            case 29:
            case 30:
            case 31:
            case 32:
            case 33:
            case 34:
            case 35:
            case 36:
            case 37:
            case 38:
            case 39:
            case 40:
            case 41:
            case 42:
            case 43:
            case 44:
            case 45:
            case 46:
            case 47:
            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE:
            case ConstraintLayout.LayoutParams.Table.LAYOUT_EDITOR_ABSOLUTEX:
                this.listFieldSchema.mergeListsAt(t, t2, offset);
                return;
            case 50:
                SchemaUtil.mergeMap(this.mapFieldSchema, t, t2, offset);
                return;
            case 51:
            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BASELINE_TO_TOP_OF:
            case 53:
            case ConstraintLayout.LayoutParams.Table.LAYOUT_MARGIN_BASELINE:
            case 55:
            case 56:
            case 57:
            case 58:
            case 59:
                if (isOneofPresent(t2, numberAt, i)) {
                    UnsafeUtil.putObject((Object) t, offset, UnsafeUtil.getObject((Object) t2, offset));
                    setOneofPresent(t, numberAt, i);
                    return;
                }
                return;
            case 60:
                mergeOneofMessage(t, t2, i);
                return;
            case LockFreeTaskQueueCore.CLOSED_SHIFT /*61*/:
            case 62:
            case HtmlCompat.FROM_HTML_MODE_COMPACT:
            case 64:
            case 65:
            case ConstraintLayout.LayoutParams.Table.LAYOUT_WRAP_BEHAVIOR_IN_PARENT:
            case ConstraintLayout.LayoutParams.Table.GUIDELINE_USE_RTL:
                if (isOneofPresent(t2, numberAt, i)) {
                    UnsafeUtil.putObject((Object) t, offset, UnsafeUtil.getObject((Object) t2, offset));
                    setOneofPresent(t, numberAt, i);
                    return;
                }
                return;
            case 68:
                mergeOneofMessage(t, t2, i);
                return;
            default:
                return;
        }
    }

    private void mergeMessage(T t, T t2, int i) {
        if (isFieldPresent(t2, i)) {
            long offset = offset(typeAndOffsetAt(i));
            Unsafe unsafe = UNSAFE;
            Object object = unsafe.getObject(t2, offset);
            if (object != null) {
                Schema messageFieldSchema = getMessageFieldSchema(i);
                if (!isFieldPresent(t, i)) {
                    if (!isMutable(object)) {
                        unsafe.putObject(t, offset, object);
                    } else {
                        Object newInstance = messageFieldSchema.newInstance();
                        messageFieldSchema.mergeFrom(newInstance, object);
                        unsafe.putObject(t, offset, newInstance);
                    }
                    setFieldPresent(t, i);
                    return;
                }
                Object object2 = unsafe.getObject(t, offset);
                if (!isMutable(object2)) {
                    Object newInstance2 = messageFieldSchema.newInstance();
                    messageFieldSchema.mergeFrom(newInstance2, object2);
                    unsafe.putObject(t, offset, newInstance2);
                    object2 = newInstance2;
                }
                messageFieldSchema.mergeFrom(object2, object);
                return;
            }
            throw new IllegalStateException("Source subfield " + numberAt(i) + " is present but null: " + t2);
        }
    }

    private void mergeOneofMessage(T t, T t2, int i) {
        int numberAt = numberAt(i);
        if (isOneofPresent(t2, numberAt, i)) {
            long offset = offset(typeAndOffsetAt(i));
            Unsafe unsafe = UNSAFE;
            Object object = unsafe.getObject(t2, offset);
            if (object != null) {
                Schema messageFieldSchema = getMessageFieldSchema(i);
                if (!isOneofPresent(t, numberAt, i)) {
                    if (!isMutable(object)) {
                        unsafe.putObject(t, offset, object);
                    } else {
                        Object newInstance = messageFieldSchema.newInstance();
                        messageFieldSchema.mergeFrom(newInstance, object);
                        unsafe.putObject(t, offset, newInstance);
                    }
                    setOneofPresent(t, numberAt, i);
                    return;
                }
                Object object2 = unsafe.getObject(t, offset);
                if (!isMutable(object2)) {
                    Object newInstance2 = messageFieldSchema.newInstance();
                    messageFieldSchema.mergeFrom(newInstance2, object2);
                    unsafe.putObject(t, offset, newInstance2);
                    object2 = newInstance2;
                }
                messageFieldSchema.mergeFrom(object2, object);
                return;
            }
            throw new IllegalStateException("Source subfield " + numberAt(i) + " is present but null: " + t2);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:162:0x033f, code lost:
        r9 = r16 + ((r8 + r9) + r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:180:0x040a, code lost:
        r9 = r16 + r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:232:0x051c, code lost:
        r9 = r16 + r0;
        r0 = r17;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:233:0x0521, code lost:
        r0 = r17;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:237:0x0530, code lost:
        r9 = r16 + r0;
        r0 = r17;
        r1 = r18;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:238:0x0537, code lost:
        r0 = r17;
        r1 = r18;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:242:0x054b, code lost:
        r9 = r16;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:243:0x054d, code lost:
        r2 = r2 + 3;
        r8 = 1048575;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int getSerializedSize(T r18) {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            sun.misc.Unsafe r6 = UNSAFE
            r7 = 0
            r8 = 1048575(0xfffff, float:1.469367E-39)
            r2 = r7
            r4 = r2
            r9 = r4
            r3 = r8
        L_0x000e:
            int[] r5 = r0.buffer
            int r5 = r5.length
            if (r2 >= r5) goto L_0x0554
            int r5 = r0.typeAndOffsetAt(r2)
            int r10 = type(r5)
            int r11 = r0.numberAt(r2)
            int[] r12 = r0.buffer
            int r13 = r2 + 2
            r12 = r12[r13]
            r13 = r12 & r8
            r14 = 17
            r15 = 1
            if (r10 > r14) goto L_0x003e
            if (r13 == r3) goto L_0x0039
            if (r13 != r8) goto L_0x0032
            r3 = r7
            goto L_0x0037
        L_0x0032:
            long r3 = (long) r13
            int r3 = r6.getInt(r1, r3)
        L_0x0037:
            r4 = r3
            r3 = r13
        L_0x0039:
            int r12 = r12 >>> 20
            int r12 = r15 << r12
            goto L_0x003f
        L_0x003e:
            r12 = r7
        L_0x003f:
            r16 = r9
            long r8 = offset(r5)
            androidx.datastore.preferences.protobuf.FieldType r5 = androidx.datastore.preferences.protobuf.FieldType.DOUBLE_LIST_PACKED
            int r5 = r5.id()
            if (r10 < r5) goto L_0x0056
            androidx.datastore.preferences.protobuf.FieldType r5 = androidx.datastore.preferences.protobuf.FieldType.SINT64_LIST_PACKED
            int r5 = r5.id()
            if (r10 > r5) goto L_0x0056
            goto L_0x0057
        L_0x0056:
            r13 = r7
        L_0x0057:
            r5 = 0
            r14 = 0
            switch(r10) {
                case 0: goto L_0x053c;
                case 1: goto L_0x0524;
                case 2: goto L_0x050d;
                case 3: goto L_0x04fd;
                case 4: goto L_0x04ed;
                case 5: goto L_0x04e1;
                case 6: goto L_0x04d5;
                case 7: goto L_0x04c7;
                case 8: goto L_0x04aa;
                case 9: goto L_0x0495;
                case 10: goto L_0x0482;
                case 11: goto L_0x0471;
                case 12: goto L_0x0460;
                case 13: goto L_0x0453;
                case 14: goto L_0x0446;
                case 15: goto L_0x0435;
                case 16: goto L_0x0424;
                case 17: goto L_0x040e;
                case 18: goto L_0x0400;
                case 19: goto L_0x03f5;
                case 20: goto L_0x03ea;
                case 21: goto L_0x03df;
                case 22: goto L_0x03d4;
                case 23: goto L_0x03c9;
                case 24: goto L_0x03be;
                case 25: goto L_0x03b3;
                case 26: goto L_0x03a8;
                case 27: goto L_0x0399;
                case 28: goto L_0x038d;
                case 29: goto L_0x0381;
                case 30: goto L_0x0375;
                case 31: goto L_0x0369;
                case 32: goto L_0x035d;
                case 33: goto L_0x0351;
                case 34: goto L_0x0345;
                case 35: goto L_0x0323;
                case 36: goto L_0x0306;
                case 37: goto L_0x02e9;
                case 38: goto L_0x02cc;
                case 39: goto L_0x02ae;
                case 40: goto L_0x0290;
                case 41: goto L_0x0272;
                case 42: goto L_0x0254;
                case 43: goto L_0x0236;
                case 44: goto L_0x0218;
                case 45: goto L_0x01fa;
                case 46: goto L_0x01dc;
                case 47: goto L_0x01be;
                case 48: goto L_0x01a0;
                case 49: goto L_0x0190;
                case 50: goto L_0x0180;
                case 51: goto L_0x0172;
                case 52: goto L_0x0166;
                case 53: goto L_0x0156;
                case 54: goto L_0x0146;
                case 55: goto L_0x0136;
                case 56: goto L_0x012a;
                case 57: goto L_0x011e;
                case 58: goto L_0x0111;
                case 59: goto L_0x00f3;
                case 60: goto L_0x00df;
                case 61: goto L_0x00cd;
                case 62: goto L_0x00bd;
                case 63: goto L_0x00ad;
                case 64: goto L_0x00a1;
                case 65: goto L_0x0095;
                case 66: goto L_0x0085;
                case 67: goto L_0x0075;
                case 68: goto L_0x005f;
                default: goto L_0x005d;
            }
        L_0x005d:
            goto L_0x054b
        L_0x005f:
            boolean r5 = r0.isOneofPresent(r1, r11, r2)
            if (r5 == 0) goto L_0x054b
            java.lang.Object r5 = r6.getObject(r1, r8)
            androidx.datastore.preferences.protobuf.MessageLite r5 = (androidx.datastore.preferences.protobuf.MessageLite) r5
            androidx.datastore.preferences.protobuf.Schema r8 = r0.getMessageFieldSchema(r2)
            int r5 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeGroupSize(r11, r5, r8)
            goto L_0x040a
        L_0x0075:
            boolean r5 = r0.isOneofPresent(r1, r11, r2)
            if (r5 == 0) goto L_0x054b
            long r8 = oneofLongAt(r1, r8)
            int r5 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeSInt64Size(r11, r8)
            goto L_0x040a
        L_0x0085:
            boolean r5 = r0.isOneofPresent(r1, r11, r2)
            if (r5 == 0) goto L_0x054b
            int r5 = oneofIntAt(r1, r8)
            int r5 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeSInt32Size(r11, r5)
            goto L_0x040a
        L_0x0095:
            boolean r5 = r0.isOneofPresent(r1, r11, r2)
            if (r5 == 0) goto L_0x054b
            int r5 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeSFixed64Size(r11, r14)
            goto L_0x040a
        L_0x00a1:
            boolean r5 = r0.isOneofPresent(r1, r11, r2)
            if (r5 == 0) goto L_0x054b
            int r5 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeSFixed32Size(r11, r7)
            goto L_0x040a
        L_0x00ad:
            boolean r5 = r0.isOneofPresent(r1, r11, r2)
            if (r5 == 0) goto L_0x054b
            int r5 = oneofIntAt(r1, r8)
            int r5 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeEnumSize(r11, r5)
            goto L_0x040a
        L_0x00bd:
            boolean r5 = r0.isOneofPresent(r1, r11, r2)
            if (r5 == 0) goto L_0x054b
            int r5 = oneofIntAt(r1, r8)
            int r5 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeUInt32Size(r11, r5)
            goto L_0x040a
        L_0x00cd:
            boolean r5 = r0.isOneofPresent(r1, r11, r2)
            if (r5 == 0) goto L_0x054b
            java.lang.Object r5 = r6.getObject(r1, r8)
            androidx.datastore.preferences.protobuf.ByteString r5 = (androidx.datastore.preferences.protobuf.ByteString) r5
            int r5 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeBytesSize(r11, r5)
            goto L_0x040a
        L_0x00df:
            boolean r5 = r0.isOneofPresent(r1, r11, r2)
            if (r5 == 0) goto L_0x054b
            java.lang.Object r5 = r6.getObject(r1, r8)
            androidx.datastore.preferences.protobuf.Schema r8 = r0.getMessageFieldSchema(r2)
            int r5 = androidx.datastore.preferences.protobuf.SchemaUtil.computeSizeMessage(r11, r5, r8)
            goto L_0x040a
        L_0x00f3:
            boolean r5 = r0.isOneofPresent(r1, r11, r2)
            if (r5 == 0) goto L_0x054b
            java.lang.Object r5 = r6.getObject(r1, r8)
            boolean r8 = r5 instanceof androidx.datastore.preferences.protobuf.ByteString
            if (r8 == 0) goto L_0x0109
            androidx.datastore.preferences.protobuf.ByteString r5 = (androidx.datastore.preferences.protobuf.ByteString) r5
            int r5 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeBytesSize(r11, r5)
            goto L_0x040a
        L_0x0109:
            java.lang.String r5 = (java.lang.String) r5
            int r5 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeStringSize(r11, r5)
            goto L_0x040a
        L_0x0111:
            boolean r5 = r0.isOneofPresent(r1, r11, r2)
            if (r5 == 0) goto L_0x054b
            r5 = 1
            int r5 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeBoolSize(r11, r5)
            goto L_0x040a
        L_0x011e:
            boolean r5 = r0.isOneofPresent(r1, r11, r2)
            if (r5 == 0) goto L_0x054b
            int r5 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeFixed32Size(r11, r7)
            goto L_0x040a
        L_0x012a:
            boolean r5 = r0.isOneofPresent(r1, r11, r2)
            if (r5 == 0) goto L_0x054b
            int r5 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeFixed64Size(r11, r14)
            goto L_0x040a
        L_0x0136:
            boolean r5 = r0.isOneofPresent(r1, r11, r2)
            if (r5 == 0) goto L_0x054b
            int r5 = oneofIntAt(r1, r8)
            int r5 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeInt32Size(r11, r5)
            goto L_0x040a
        L_0x0146:
            boolean r5 = r0.isOneofPresent(r1, r11, r2)
            if (r5 == 0) goto L_0x054b
            long r8 = oneofLongAt(r1, r8)
            int r5 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeUInt64Size(r11, r8)
            goto L_0x040a
        L_0x0156:
            boolean r5 = r0.isOneofPresent(r1, r11, r2)
            if (r5 == 0) goto L_0x054b
            long r8 = oneofLongAt(r1, r8)
            int r5 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeInt64Size(r11, r8)
            goto L_0x040a
        L_0x0166:
            boolean r8 = r0.isOneofPresent(r1, r11, r2)
            if (r8 == 0) goto L_0x054b
            int r5 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeFloatSize(r11, r5)
            goto L_0x040a
        L_0x0172:
            boolean r5 = r0.isOneofPresent(r1, r11, r2)
            if (r5 == 0) goto L_0x054b
            r8 = 0
            int r5 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeDoubleSize(r11, r8)
            goto L_0x040a
        L_0x0180:
            androidx.datastore.preferences.protobuf.MapFieldSchema r5 = r0.mapFieldSchema
            java.lang.Object r8 = r6.getObject(r1, r8)
            java.lang.Object r9 = r0.getMapFieldDefaultEntry(r2)
            int r5 = r5.getSerializedSize(r11, r8, r9)
            goto L_0x040a
        L_0x0190:
            java.lang.Object r5 = r6.getObject(r1, r8)
            java.util.List r5 = (java.util.List) r5
            androidx.datastore.preferences.protobuf.Schema r8 = r0.getMessageFieldSchema(r2)
            int r5 = androidx.datastore.preferences.protobuf.SchemaUtil.computeSizeGroupList(r11, r5, r8)
            goto L_0x040a
        L_0x01a0:
            java.lang.Object r5 = r6.getObject(r1, r8)
            java.util.List r5 = (java.util.List) r5
            int r5 = androidx.datastore.preferences.protobuf.SchemaUtil.computeSizeSInt64ListNoTag(r5)
            if (r5 <= 0) goto L_0x054b
            boolean r8 = r0.useCachedSizeField
            if (r8 == 0) goto L_0x01b4
            long r8 = (long) r13
            r6.putInt(r1, r8, r5)
        L_0x01b4:
            int r8 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeTagSize(r11)
            int r9 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeUInt32SizeNoTag(r5)
            goto L_0x033f
        L_0x01be:
            java.lang.Object r5 = r6.getObject(r1, r8)
            java.util.List r5 = (java.util.List) r5
            int r5 = androidx.datastore.preferences.protobuf.SchemaUtil.computeSizeSInt32ListNoTag(r5)
            if (r5 <= 0) goto L_0x054b
            boolean r8 = r0.useCachedSizeField
            if (r8 == 0) goto L_0x01d2
            long r8 = (long) r13
            r6.putInt(r1, r8, r5)
        L_0x01d2:
            int r8 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeTagSize(r11)
            int r9 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeUInt32SizeNoTag(r5)
            goto L_0x033f
        L_0x01dc:
            java.lang.Object r5 = r6.getObject(r1, r8)
            java.util.List r5 = (java.util.List) r5
            int r5 = androidx.datastore.preferences.protobuf.SchemaUtil.computeSizeFixed64ListNoTag(r5)
            if (r5 <= 0) goto L_0x054b
            boolean r8 = r0.useCachedSizeField
            if (r8 == 0) goto L_0x01f0
            long r8 = (long) r13
            r6.putInt(r1, r8, r5)
        L_0x01f0:
            int r8 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeTagSize(r11)
            int r9 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeUInt32SizeNoTag(r5)
            goto L_0x033f
        L_0x01fa:
            java.lang.Object r5 = r6.getObject(r1, r8)
            java.util.List r5 = (java.util.List) r5
            int r5 = androidx.datastore.preferences.protobuf.SchemaUtil.computeSizeFixed32ListNoTag(r5)
            if (r5 <= 0) goto L_0x054b
            boolean r8 = r0.useCachedSizeField
            if (r8 == 0) goto L_0x020e
            long r8 = (long) r13
            r6.putInt(r1, r8, r5)
        L_0x020e:
            int r8 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeTagSize(r11)
            int r9 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeUInt32SizeNoTag(r5)
            goto L_0x033f
        L_0x0218:
            java.lang.Object r5 = r6.getObject(r1, r8)
            java.util.List r5 = (java.util.List) r5
            int r5 = androidx.datastore.preferences.protobuf.SchemaUtil.computeSizeEnumListNoTag(r5)
            if (r5 <= 0) goto L_0x054b
            boolean r8 = r0.useCachedSizeField
            if (r8 == 0) goto L_0x022c
            long r8 = (long) r13
            r6.putInt(r1, r8, r5)
        L_0x022c:
            int r8 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeTagSize(r11)
            int r9 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeUInt32SizeNoTag(r5)
            goto L_0x033f
        L_0x0236:
            java.lang.Object r5 = r6.getObject(r1, r8)
            java.util.List r5 = (java.util.List) r5
            int r5 = androidx.datastore.preferences.protobuf.SchemaUtil.computeSizeUInt32ListNoTag(r5)
            if (r5 <= 0) goto L_0x054b
            boolean r8 = r0.useCachedSizeField
            if (r8 == 0) goto L_0x024a
            long r8 = (long) r13
            r6.putInt(r1, r8, r5)
        L_0x024a:
            int r8 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeTagSize(r11)
            int r9 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeUInt32SizeNoTag(r5)
            goto L_0x033f
        L_0x0254:
            java.lang.Object r5 = r6.getObject(r1, r8)
            java.util.List r5 = (java.util.List) r5
            int r5 = androidx.datastore.preferences.protobuf.SchemaUtil.computeSizeBoolListNoTag(r5)
            if (r5 <= 0) goto L_0x054b
            boolean r8 = r0.useCachedSizeField
            if (r8 == 0) goto L_0x0268
            long r8 = (long) r13
            r6.putInt(r1, r8, r5)
        L_0x0268:
            int r8 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeTagSize(r11)
            int r9 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeUInt32SizeNoTag(r5)
            goto L_0x033f
        L_0x0272:
            java.lang.Object r5 = r6.getObject(r1, r8)
            java.util.List r5 = (java.util.List) r5
            int r5 = androidx.datastore.preferences.protobuf.SchemaUtil.computeSizeFixed32ListNoTag(r5)
            if (r5 <= 0) goto L_0x054b
            boolean r8 = r0.useCachedSizeField
            if (r8 == 0) goto L_0x0286
            long r8 = (long) r13
            r6.putInt(r1, r8, r5)
        L_0x0286:
            int r8 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeTagSize(r11)
            int r9 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeUInt32SizeNoTag(r5)
            goto L_0x033f
        L_0x0290:
            java.lang.Object r5 = r6.getObject(r1, r8)
            java.util.List r5 = (java.util.List) r5
            int r5 = androidx.datastore.preferences.protobuf.SchemaUtil.computeSizeFixed64ListNoTag(r5)
            if (r5 <= 0) goto L_0x054b
            boolean r8 = r0.useCachedSizeField
            if (r8 == 0) goto L_0x02a4
            long r8 = (long) r13
            r6.putInt(r1, r8, r5)
        L_0x02a4:
            int r8 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeTagSize(r11)
            int r9 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeUInt32SizeNoTag(r5)
            goto L_0x033f
        L_0x02ae:
            java.lang.Object r5 = r6.getObject(r1, r8)
            java.util.List r5 = (java.util.List) r5
            int r5 = androidx.datastore.preferences.protobuf.SchemaUtil.computeSizeInt32ListNoTag(r5)
            if (r5 <= 0) goto L_0x054b
            boolean r8 = r0.useCachedSizeField
            if (r8 == 0) goto L_0x02c2
            long r8 = (long) r13
            r6.putInt(r1, r8, r5)
        L_0x02c2:
            int r8 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeTagSize(r11)
            int r9 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeUInt32SizeNoTag(r5)
            goto L_0x033f
        L_0x02cc:
            java.lang.Object r5 = r6.getObject(r1, r8)
            java.util.List r5 = (java.util.List) r5
            int r5 = androidx.datastore.preferences.protobuf.SchemaUtil.computeSizeUInt64ListNoTag(r5)
            if (r5 <= 0) goto L_0x054b
            boolean r8 = r0.useCachedSizeField
            if (r8 == 0) goto L_0x02e0
            long r8 = (long) r13
            r6.putInt(r1, r8, r5)
        L_0x02e0:
            int r8 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeTagSize(r11)
            int r9 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeUInt32SizeNoTag(r5)
            goto L_0x033f
        L_0x02e9:
            java.lang.Object r5 = r6.getObject(r1, r8)
            java.util.List r5 = (java.util.List) r5
            int r5 = androidx.datastore.preferences.protobuf.SchemaUtil.computeSizeInt64ListNoTag(r5)
            if (r5 <= 0) goto L_0x054b
            boolean r8 = r0.useCachedSizeField
            if (r8 == 0) goto L_0x02fd
            long r8 = (long) r13
            r6.putInt(r1, r8, r5)
        L_0x02fd:
            int r8 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeTagSize(r11)
            int r9 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeUInt32SizeNoTag(r5)
            goto L_0x033f
        L_0x0306:
            java.lang.Object r5 = r6.getObject(r1, r8)
            java.util.List r5 = (java.util.List) r5
            int r5 = androidx.datastore.preferences.protobuf.SchemaUtil.computeSizeFixed32ListNoTag(r5)
            if (r5 <= 0) goto L_0x054b
            boolean r8 = r0.useCachedSizeField
            if (r8 == 0) goto L_0x031a
            long r8 = (long) r13
            r6.putInt(r1, r8, r5)
        L_0x031a:
            int r8 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeTagSize(r11)
            int r9 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeUInt32SizeNoTag(r5)
            goto L_0x033f
        L_0x0323:
            java.lang.Object r5 = r6.getObject(r1, r8)
            java.util.List r5 = (java.util.List) r5
            int r5 = androidx.datastore.preferences.protobuf.SchemaUtil.computeSizeFixed64ListNoTag(r5)
            if (r5 <= 0) goto L_0x054b
            boolean r8 = r0.useCachedSizeField
            if (r8 == 0) goto L_0x0337
            long r8 = (long) r13
            r6.putInt(r1, r8, r5)
        L_0x0337:
            int r8 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeTagSize(r11)
            int r9 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeUInt32SizeNoTag(r5)
        L_0x033f:
            int r8 = r8 + r9
            int r8 = r8 + r5
            int r9 = r16 + r8
            goto L_0x054d
        L_0x0345:
            java.lang.Object r5 = r6.getObject(r1, r8)
            java.util.List r5 = (java.util.List) r5
            int r5 = androidx.datastore.preferences.protobuf.SchemaUtil.computeSizeSInt64List(r11, r5, r7)
            goto L_0x040a
        L_0x0351:
            java.lang.Object r5 = r6.getObject(r1, r8)
            java.util.List r5 = (java.util.List) r5
            int r5 = androidx.datastore.preferences.protobuf.SchemaUtil.computeSizeSInt32List(r11, r5, r7)
            goto L_0x040a
        L_0x035d:
            java.lang.Object r5 = r6.getObject(r1, r8)
            java.util.List r5 = (java.util.List) r5
            int r5 = androidx.datastore.preferences.protobuf.SchemaUtil.computeSizeFixed64List(r11, r5, r7)
            goto L_0x040a
        L_0x0369:
            java.lang.Object r5 = r6.getObject(r1, r8)
            java.util.List r5 = (java.util.List) r5
            int r5 = androidx.datastore.preferences.protobuf.SchemaUtil.computeSizeFixed32List(r11, r5, r7)
            goto L_0x040a
        L_0x0375:
            java.lang.Object r5 = r6.getObject(r1, r8)
            java.util.List r5 = (java.util.List) r5
            int r5 = androidx.datastore.preferences.protobuf.SchemaUtil.computeSizeEnumList(r11, r5, r7)
            goto L_0x040a
        L_0x0381:
            java.lang.Object r5 = r6.getObject(r1, r8)
            java.util.List r5 = (java.util.List) r5
            int r5 = androidx.datastore.preferences.protobuf.SchemaUtil.computeSizeUInt32List(r11, r5, r7)
            goto L_0x040a
        L_0x038d:
            java.lang.Object r5 = r6.getObject(r1, r8)
            java.util.List r5 = (java.util.List) r5
            int r5 = androidx.datastore.preferences.protobuf.SchemaUtil.computeSizeByteStringList(r11, r5)
            goto L_0x040a
        L_0x0399:
            java.lang.Object r5 = r6.getObject(r1, r8)
            java.util.List r5 = (java.util.List) r5
            androidx.datastore.preferences.protobuf.Schema r8 = r0.getMessageFieldSchema(r2)
            int r5 = androidx.datastore.preferences.protobuf.SchemaUtil.computeSizeMessageList(r11, r5, r8)
            goto L_0x040a
        L_0x03a8:
            java.lang.Object r5 = r6.getObject(r1, r8)
            java.util.List r5 = (java.util.List) r5
            int r5 = androidx.datastore.preferences.protobuf.SchemaUtil.computeSizeStringList(r11, r5)
            goto L_0x040a
        L_0x03b3:
            java.lang.Object r5 = r6.getObject(r1, r8)
            java.util.List r5 = (java.util.List) r5
            int r5 = androidx.datastore.preferences.protobuf.SchemaUtil.computeSizeBoolList(r11, r5, r7)
            goto L_0x040a
        L_0x03be:
            java.lang.Object r5 = r6.getObject(r1, r8)
            java.util.List r5 = (java.util.List) r5
            int r5 = androidx.datastore.preferences.protobuf.SchemaUtil.computeSizeFixed32List(r11, r5, r7)
            goto L_0x040a
        L_0x03c9:
            java.lang.Object r5 = r6.getObject(r1, r8)
            java.util.List r5 = (java.util.List) r5
            int r5 = androidx.datastore.preferences.protobuf.SchemaUtil.computeSizeFixed64List(r11, r5, r7)
            goto L_0x040a
        L_0x03d4:
            java.lang.Object r5 = r6.getObject(r1, r8)
            java.util.List r5 = (java.util.List) r5
            int r5 = androidx.datastore.preferences.protobuf.SchemaUtil.computeSizeInt32List(r11, r5, r7)
            goto L_0x040a
        L_0x03df:
            java.lang.Object r5 = r6.getObject(r1, r8)
            java.util.List r5 = (java.util.List) r5
            int r5 = androidx.datastore.preferences.protobuf.SchemaUtil.computeSizeUInt64List(r11, r5, r7)
            goto L_0x040a
        L_0x03ea:
            java.lang.Object r5 = r6.getObject(r1, r8)
            java.util.List r5 = (java.util.List) r5
            int r5 = androidx.datastore.preferences.protobuf.SchemaUtil.computeSizeInt64List(r11, r5, r7)
            goto L_0x040a
        L_0x03f5:
            java.lang.Object r5 = r6.getObject(r1, r8)
            java.util.List r5 = (java.util.List) r5
            int r5 = androidx.datastore.preferences.protobuf.SchemaUtil.computeSizeFixed32List(r11, r5, r7)
            goto L_0x040a
        L_0x0400:
            java.lang.Object r5 = r6.getObject(r1, r8)
            java.util.List r5 = (java.util.List) r5
            int r5 = androidx.datastore.preferences.protobuf.SchemaUtil.computeSizeFixed64List(r11, r5, r7)
        L_0x040a:
            int r9 = r16 + r5
            goto L_0x054d
        L_0x040e:
            r5 = r12
            boolean r5 = r0.isFieldPresent(r1, r2, r3, r4, r5)
            if (r5 == 0) goto L_0x054b
            java.lang.Object r5 = r6.getObject(r1, r8)
            androidx.datastore.preferences.protobuf.MessageLite r5 = (androidx.datastore.preferences.protobuf.MessageLite) r5
            androidx.datastore.preferences.protobuf.Schema r8 = r0.getMessageFieldSchema(r2)
            int r5 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeGroupSize(r11, r5, r8)
            goto L_0x040a
        L_0x0424:
            r5 = r12
            boolean r5 = r0.isFieldPresent(r1, r2, r3, r4, r5)
            if (r5 == 0) goto L_0x0521
            long r8 = r6.getLong(r1, r8)
            int r0 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeSInt64Size(r11, r8)
            goto L_0x051c
        L_0x0435:
            r5 = r12
            boolean r5 = r0.isFieldPresent(r1, r2, r3, r4, r5)
            if (r5 == 0) goto L_0x0521
            int r0 = r6.getInt(r1, r8)
            int r0 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeSInt32Size(r11, r0)
            goto L_0x051c
        L_0x0446:
            r5 = r12
            boolean r5 = r0.isFieldPresent(r1, r2, r3, r4, r5)
            if (r5 == 0) goto L_0x0537
            int r0 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeSFixed64Size(r11, r14)
            goto L_0x0530
        L_0x0453:
            r5 = r12
            boolean r5 = r0.isFieldPresent(r1, r2, r3, r4, r5)
            if (r5 == 0) goto L_0x0537
            int r0 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeSFixed32Size(r11, r7)
            goto L_0x0530
        L_0x0460:
            r5 = r12
            boolean r5 = r0.isFieldPresent(r1, r2, r3, r4, r5)
            if (r5 == 0) goto L_0x0521
            int r0 = r6.getInt(r1, r8)
            int r0 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeEnumSize(r11, r0)
            goto L_0x051c
        L_0x0471:
            r5 = r12
            boolean r5 = r0.isFieldPresent(r1, r2, r3, r4, r5)
            if (r5 == 0) goto L_0x0521
            int r0 = r6.getInt(r1, r8)
            int r0 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeUInt32Size(r11, r0)
            goto L_0x051c
        L_0x0482:
            r5 = r12
            boolean r5 = r0.isFieldPresent(r1, r2, r3, r4, r5)
            if (r5 == 0) goto L_0x0521
            java.lang.Object r0 = r6.getObject(r1, r8)
            androidx.datastore.preferences.protobuf.ByteString r0 = (androidx.datastore.preferences.protobuf.ByteString) r0
            int r0 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeBytesSize(r11, r0)
            goto L_0x051c
        L_0x0495:
            r5 = r12
            boolean r5 = r0.isFieldPresent(r1, r2, r3, r4, r5)
            if (r5 == 0) goto L_0x054b
            java.lang.Object r5 = r6.getObject(r1, r8)
            androidx.datastore.preferences.protobuf.Schema r8 = r0.getMessageFieldSchema(r2)
            int r5 = androidx.datastore.preferences.protobuf.SchemaUtil.computeSizeMessage(r11, r5, r8)
            goto L_0x040a
        L_0x04aa:
            r5 = r12
            boolean r5 = r0.isFieldPresent(r1, r2, r3, r4, r5)
            if (r5 == 0) goto L_0x0521
            java.lang.Object r0 = r6.getObject(r1, r8)
            boolean r5 = r0 instanceof androidx.datastore.preferences.protobuf.ByteString
            if (r5 == 0) goto L_0x04c0
            androidx.datastore.preferences.protobuf.ByteString r0 = (androidx.datastore.preferences.protobuf.ByteString) r0
            int r0 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeBytesSize(r11, r0)
            goto L_0x051c
        L_0x04c0:
            java.lang.String r0 = (java.lang.String) r0
            int r0 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeStringSize(r11, r0)
            goto L_0x051c
        L_0x04c7:
            r5 = r12
            boolean r5 = r0.isFieldPresent(r1, r2, r3, r4, r5)
            if (r5 == 0) goto L_0x0537
            r5 = 1
            int r0 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeBoolSize(r11, r5)
            goto L_0x0530
        L_0x04d5:
            r5 = r12
            boolean r5 = r0.isFieldPresent(r1, r2, r3, r4, r5)
            if (r5 == 0) goto L_0x0537
            int r0 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeFixed32Size(r11, r7)
            goto L_0x0530
        L_0x04e1:
            r5 = r12
            boolean r5 = r0.isFieldPresent(r1, r2, r3, r4, r5)
            if (r5 == 0) goto L_0x0537
            int r0 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeFixed64Size(r11, r14)
            goto L_0x0530
        L_0x04ed:
            r5 = r12
            boolean r5 = r0.isFieldPresent(r1, r2, r3, r4, r5)
            if (r5 == 0) goto L_0x0521
            int r0 = r6.getInt(r1, r8)
            int r0 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeInt32Size(r11, r0)
            goto L_0x051c
        L_0x04fd:
            r5 = r12
            boolean r5 = r0.isFieldPresent(r1, r2, r3, r4, r5)
            if (r5 == 0) goto L_0x0521
            long r8 = r6.getLong(r1, r8)
            int r0 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeUInt64Size(r11, r8)
            goto L_0x051c
        L_0x050d:
            r5 = r12
            boolean r5 = r0.isFieldPresent(r1, r2, r3, r4, r5)
            if (r5 == 0) goto L_0x0521
            long r8 = r6.getLong(r1, r8)
            int r0 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeInt64Size(r11, r8)
        L_0x051c:
            int r9 = r16 + r0
            r0 = r17
            goto L_0x054d
        L_0x0521:
            r0 = r17
            goto L_0x054b
        L_0x0524:
            r8 = r5
            r5 = r12
            boolean r5 = r0.isFieldPresent(r1, r2, r3, r4, r5)
            if (r5 == 0) goto L_0x0537
            int r0 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeFloatSize(r11, r8)
        L_0x0530:
            int r9 = r16 + r0
            r0 = r17
            r1 = r18
            goto L_0x054d
        L_0x0537:
            r0 = r17
            r1 = r18
            goto L_0x054b
        L_0x053c:
            r5 = r12
            boolean r5 = r0.isFieldPresent(r1, r2, r3, r4, r5)
            if (r5 == 0) goto L_0x054b
            r8 = 0
            int r5 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeDoubleSize(r11, r8)
            goto L_0x040a
        L_0x054b:
            r9 = r16
        L_0x054d:
            int r2 = r2 + 3
            r8 = 1048575(0xfffff, float:1.469367E-39)
            goto L_0x000e
        L_0x0554:
            r16 = r9
            androidx.datastore.preferences.protobuf.UnknownFieldSchema<?, ?> r2 = r0.unknownFieldSchema
            int r2 = r0.getUnknownFieldsSerializedSize(r2, r1)
            int r9 = r16 + r2
            boolean r2 = r0.hasExtensions
            if (r2 == 0) goto L_0x056d
            androidx.datastore.preferences.protobuf.ExtensionSchema<?> r2 = r0.extensionSchema
            androidx.datastore.preferences.protobuf.FieldSet r1 = r2.getExtensions(r1)
            int r1 = r1.getSerializedSize()
            int r9 = r9 + r1
        L_0x056d:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.MessageSchema.getSerializedSize(java.lang.Object):int");
    }

    private <UT, UB> int getUnknownFieldsSerializedSize(UnknownFieldSchema<UT, UB> unknownFieldSchema2, T t) {
        return unknownFieldSchema2.getSerializedSize(unknownFieldSchema2.getFromMessage(t));
    }

    public void writeTo(T t, Writer writer) throws IOException {
        if (writer.fieldOrder() == Writer.FieldOrder.DESCENDING) {
            writeFieldsInDescendingOrder(t, writer);
        } else {
            writeFieldsInAscendingOrder(t, writer);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:104:0x0305, code lost:
        r15 = r14;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:167:0x04cb, code lost:
        r0 = r18;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:171:0x04dc, code lost:
        r2 = r2 + 3;
        r5 = r4;
        r4 = r3;
        r3 = r7;
     */
    /* JADX WARNING: Removed duplicated region for block: B:173:0x04e5  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0031  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void writeFieldsInAscendingOrder(T r19, androidx.datastore.preferences.protobuf.Writer r20) throws java.io.IOException {
        /*
            r18 = this;
            r0 = r18
            r1 = r19
            r6 = r20
            boolean r2 = r0.hasExtensions
            if (r2 == 0) goto L_0x0022
            androidx.datastore.preferences.protobuf.ExtensionSchema<?> r2 = r0.extensionSchema
            androidx.datastore.preferences.protobuf.FieldSet r2 = r2.getExtensions(r1)
            boolean r3 = r2.isEmpty()
            if (r3 != 0) goto L_0x0022
            java.util.Iterator r2 = r2.iterator()
            java.lang.Object r3 = r2.next()
            java.util.Map$Entry r3 = (java.util.Map.Entry) r3
            r8 = r2
            goto L_0x0024
        L_0x0022:
            r3 = 0
            r8 = 0
        L_0x0024:
            int[] r2 = r0.buffer
            int r9 = r2.length
            sun.misc.Unsafe r10 = UNSAFE
            r11 = 1048575(0xfffff, float:1.469367E-39)
            r4 = r11
            r2 = 0
            r5 = 0
        L_0x002f:
            if (r2 >= r9) goto L_0x04e3
            int r13 = r0.typeAndOffsetAt(r2)
            int r14 = r0.numberAt(r2)
            int r15 = type(r13)
            r7 = 17
            if (r15 > r7) goto L_0x0064
            int[] r7 = r0.buffer
            int r16 = r2 + 2
            r7 = r7[r16]
            r16 = 1
            r12 = r7 & r11
            if (r12 == r4) goto L_0x0058
            if (r12 != r11) goto L_0x0051
            r5 = 0
            goto L_0x0057
        L_0x0051:
            long r4 = (long) r12
            int r4 = r10.getInt(r1, r4)
            r5 = r4
        L_0x0057:
            r4 = r12
        L_0x0058:
            int r7 = r7 >>> 20
            int r7 = r16 << r7
            r17 = r7
            r7 = r3
            r3 = r4
            r4 = r5
            r5 = r17
            goto L_0x006a
        L_0x0064:
            r16 = 1
            r7 = r3
            r3 = r4
            r4 = r5
            r5 = 0
        L_0x006a:
            if (r7 == 0) goto L_0x0088
            androidx.datastore.preferences.protobuf.ExtensionSchema<?> r12 = r0.extensionSchema
            int r12 = r12.extensionNumber(r7)
            if (r12 > r14) goto L_0x0088
            androidx.datastore.preferences.protobuf.ExtensionSchema<?> r12 = r0.extensionSchema
            r12.serializeExtension(r6, r7)
            boolean r7 = r8.hasNext()
            if (r7 == 0) goto L_0x0086
            java.lang.Object r7 = r8.next()
            java.util.Map$Entry r7 = (java.util.Map.Entry) r7
            goto L_0x006a
        L_0x0086:
            r7 = 0
            goto L_0x006a
        L_0x0088:
            long r12 = offset(r13)
            switch(r15) {
                case 0: goto L_0x04ce;
                case 1: goto L_0x04bd;
                case 2: goto L_0x04ae;
                case 3: goto L_0x049f;
                case 4: goto L_0x0490;
                case 5: goto L_0x0481;
                case 6: goto L_0x0472;
                case 7: goto L_0x0463;
                case 8: goto L_0x0453;
                case 9: goto L_0x043f;
                case 10: goto L_0x042d;
                case 11: goto L_0x041d;
                case 12: goto L_0x040d;
                case 13: goto L_0x03fd;
                case 14: goto L_0x03ed;
                case 15: goto L_0x03dd;
                case 16: goto L_0x03cd;
                case 17: goto L_0x03b9;
                case 18: goto L_0x03a9;
                case 19: goto L_0x0399;
                case 20: goto L_0x0389;
                case 21: goto L_0x0379;
                case 22: goto L_0x0369;
                case 23: goto L_0x0359;
                case 24: goto L_0x0349;
                case 25: goto L_0x0339;
                case 26: goto L_0x032a;
                case 27: goto L_0x0317;
                case 28: goto L_0x0308;
                case 29: goto L_0x02f7;
                case 30: goto L_0x02e8;
                case 31: goto L_0x02d9;
                case 32: goto L_0x02ca;
                case 33: goto L_0x02bb;
                case 34: goto L_0x02ac;
                case 35: goto L_0x029b;
                case 36: goto L_0x028a;
                case 37: goto L_0x0279;
                case 38: goto L_0x0268;
                case 39: goto L_0x0257;
                case 40: goto L_0x0246;
                case 41: goto L_0x0235;
                case 42: goto L_0x0224;
                case 43: goto L_0x0213;
                case 44: goto L_0x0202;
                case 45: goto L_0x01f1;
                case 46: goto L_0x01e0;
                case 47: goto L_0x01cf;
                case 48: goto L_0x01be;
                case 49: goto L_0x01ab;
                case 50: goto L_0x01a2;
                case 51: goto L_0x0193;
                case 52: goto L_0x0184;
                case 53: goto L_0x0175;
                case 54: goto L_0x0166;
                case 55: goto L_0x0157;
                case 56: goto L_0x0148;
                case 57: goto L_0x0139;
                case 58: goto L_0x012a;
                case 59: goto L_0x011b;
                case 60: goto L_0x0108;
                case 61: goto L_0x00f8;
                case 62: goto L_0x00ea;
                case 63: goto L_0x00dc;
                case 64: goto L_0x00ce;
                case 65: goto L_0x00c0;
                case 66: goto L_0x00b2;
                case 67: goto L_0x00a4;
                case 68: goto L_0x0092;
                default: goto L_0x008f;
            }
        L_0x008f:
            r15 = 0
            goto L_0x04dc
        L_0x0092:
            boolean r5 = r0.isOneofPresent(r1, r14, r2)
            if (r5 == 0) goto L_0x008f
            java.lang.Object r5 = r10.getObject(r1, r12)
            androidx.datastore.preferences.protobuf.Schema r12 = r0.getMessageFieldSchema(r2)
            r6.writeGroup(r14, r5, r12)
            goto L_0x008f
        L_0x00a4:
            boolean r5 = r0.isOneofPresent(r1, r14, r2)
            if (r5 == 0) goto L_0x008f
            long r12 = oneofLongAt(r1, r12)
            r6.writeSInt64(r14, r12)
            goto L_0x008f
        L_0x00b2:
            boolean r5 = r0.isOneofPresent(r1, r14, r2)
            if (r5 == 0) goto L_0x008f
            int r5 = oneofIntAt(r1, r12)
            r6.writeSInt32(r14, r5)
            goto L_0x008f
        L_0x00c0:
            boolean r5 = r0.isOneofPresent(r1, r14, r2)
            if (r5 == 0) goto L_0x008f
            long r12 = oneofLongAt(r1, r12)
            r6.writeSFixed64(r14, r12)
            goto L_0x008f
        L_0x00ce:
            boolean r5 = r0.isOneofPresent(r1, r14, r2)
            if (r5 == 0) goto L_0x008f
            int r5 = oneofIntAt(r1, r12)
            r6.writeSFixed32(r14, r5)
            goto L_0x008f
        L_0x00dc:
            boolean r5 = r0.isOneofPresent(r1, r14, r2)
            if (r5 == 0) goto L_0x008f
            int r5 = oneofIntAt(r1, r12)
            r6.writeEnum(r14, r5)
            goto L_0x008f
        L_0x00ea:
            boolean r5 = r0.isOneofPresent(r1, r14, r2)
            if (r5 == 0) goto L_0x008f
            int r5 = oneofIntAt(r1, r12)
            r6.writeUInt32(r14, r5)
            goto L_0x008f
        L_0x00f8:
            boolean r5 = r0.isOneofPresent(r1, r14, r2)
            if (r5 == 0) goto L_0x008f
            java.lang.Object r5 = r10.getObject(r1, r12)
            androidx.datastore.preferences.protobuf.ByteString r5 = (androidx.datastore.preferences.protobuf.ByteString) r5
            r6.writeBytes(r14, r5)
            goto L_0x008f
        L_0x0108:
            boolean r5 = r0.isOneofPresent(r1, r14, r2)
            if (r5 == 0) goto L_0x008f
            java.lang.Object r5 = r10.getObject(r1, r12)
            androidx.datastore.preferences.protobuf.Schema r12 = r0.getMessageFieldSchema(r2)
            r6.writeMessage(r14, r5, r12)
            goto L_0x008f
        L_0x011b:
            boolean r5 = r0.isOneofPresent(r1, r14, r2)
            if (r5 == 0) goto L_0x008f
            java.lang.Object r5 = r10.getObject(r1, r12)
            r0.writeString(r14, r5, r6)
            goto L_0x008f
        L_0x012a:
            boolean r5 = r0.isOneofPresent(r1, r14, r2)
            if (r5 == 0) goto L_0x008f
            boolean r5 = oneofBooleanAt(r1, r12)
            r6.writeBool(r14, r5)
            goto L_0x008f
        L_0x0139:
            boolean r5 = r0.isOneofPresent(r1, r14, r2)
            if (r5 == 0) goto L_0x008f
            int r5 = oneofIntAt(r1, r12)
            r6.writeFixed32(r14, r5)
            goto L_0x008f
        L_0x0148:
            boolean r5 = r0.isOneofPresent(r1, r14, r2)
            if (r5 == 0) goto L_0x008f
            long r12 = oneofLongAt(r1, r12)
            r6.writeFixed64(r14, r12)
            goto L_0x008f
        L_0x0157:
            boolean r5 = r0.isOneofPresent(r1, r14, r2)
            if (r5 == 0) goto L_0x008f
            int r5 = oneofIntAt(r1, r12)
            r6.writeInt32(r14, r5)
            goto L_0x008f
        L_0x0166:
            boolean r5 = r0.isOneofPresent(r1, r14, r2)
            if (r5 == 0) goto L_0x008f
            long r12 = oneofLongAt(r1, r12)
            r6.writeUInt64(r14, r12)
            goto L_0x008f
        L_0x0175:
            boolean r5 = r0.isOneofPresent(r1, r14, r2)
            if (r5 == 0) goto L_0x008f
            long r12 = oneofLongAt(r1, r12)
            r6.writeInt64(r14, r12)
            goto L_0x008f
        L_0x0184:
            boolean r5 = r0.isOneofPresent(r1, r14, r2)
            if (r5 == 0) goto L_0x008f
            float r5 = oneofFloatAt(r1, r12)
            r6.writeFloat(r14, r5)
            goto L_0x008f
        L_0x0193:
            boolean r5 = r0.isOneofPresent(r1, r14, r2)
            if (r5 == 0) goto L_0x008f
            double r12 = oneofDoubleAt(r1, r12)
            r6.writeDouble(r14, r12)
            goto L_0x008f
        L_0x01a2:
            java.lang.Object r5 = r10.getObject(r1, r12)
            r0.writeMapHelper(r6, r14, r5, r2)
            goto L_0x008f
        L_0x01ab:
            int r5 = r0.numberAt(r2)
            java.lang.Object r12 = r10.getObject(r1, r12)
            java.util.List r12 = (java.util.List) r12
            androidx.datastore.preferences.protobuf.Schema r13 = r0.getMessageFieldSchema(r2)
            androidx.datastore.preferences.protobuf.SchemaUtil.writeGroupList(r5, r12, r6, r13)
            goto L_0x008f
        L_0x01be:
            int r5 = r0.numberAt(r2)
            java.lang.Object r12 = r10.getObject(r1, r12)
            java.util.List r12 = (java.util.List) r12
            r14 = r16
            androidx.datastore.preferences.protobuf.SchemaUtil.writeSInt64List(r5, r12, r6, r14)
            goto L_0x008f
        L_0x01cf:
            r14 = r16
            int r5 = r0.numberAt(r2)
            java.lang.Object r12 = r10.getObject(r1, r12)
            java.util.List r12 = (java.util.List) r12
            androidx.datastore.preferences.protobuf.SchemaUtil.writeSInt32List(r5, r12, r6, r14)
            goto L_0x008f
        L_0x01e0:
            r14 = r16
            int r5 = r0.numberAt(r2)
            java.lang.Object r12 = r10.getObject(r1, r12)
            java.util.List r12 = (java.util.List) r12
            androidx.datastore.preferences.protobuf.SchemaUtil.writeSFixed64List(r5, r12, r6, r14)
            goto L_0x008f
        L_0x01f1:
            r14 = r16
            int r5 = r0.numberAt(r2)
            java.lang.Object r12 = r10.getObject(r1, r12)
            java.util.List r12 = (java.util.List) r12
            androidx.datastore.preferences.protobuf.SchemaUtil.writeSFixed32List(r5, r12, r6, r14)
            goto L_0x008f
        L_0x0202:
            r14 = r16
            int r5 = r0.numberAt(r2)
            java.lang.Object r12 = r10.getObject(r1, r12)
            java.util.List r12 = (java.util.List) r12
            androidx.datastore.preferences.protobuf.SchemaUtil.writeEnumList(r5, r12, r6, r14)
            goto L_0x008f
        L_0x0213:
            r14 = r16
            int r5 = r0.numberAt(r2)
            java.lang.Object r12 = r10.getObject(r1, r12)
            java.util.List r12 = (java.util.List) r12
            androidx.datastore.preferences.protobuf.SchemaUtil.writeUInt32List(r5, r12, r6, r14)
            goto L_0x008f
        L_0x0224:
            r14 = r16
            int r5 = r0.numberAt(r2)
            java.lang.Object r12 = r10.getObject(r1, r12)
            java.util.List r12 = (java.util.List) r12
            androidx.datastore.preferences.protobuf.SchemaUtil.writeBoolList(r5, r12, r6, r14)
            goto L_0x008f
        L_0x0235:
            r14 = r16
            int r5 = r0.numberAt(r2)
            java.lang.Object r12 = r10.getObject(r1, r12)
            java.util.List r12 = (java.util.List) r12
            androidx.datastore.preferences.protobuf.SchemaUtil.writeFixed32List(r5, r12, r6, r14)
            goto L_0x008f
        L_0x0246:
            r14 = r16
            int r5 = r0.numberAt(r2)
            java.lang.Object r12 = r10.getObject(r1, r12)
            java.util.List r12 = (java.util.List) r12
            androidx.datastore.preferences.protobuf.SchemaUtil.writeFixed64List(r5, r12, r6, r14)
            goto L_0x008f
        L_0x0257:
            r14 = r16
            int r5 = r0.numberAt(r2)
            java.lang.Object r12 = r10.getObject(r1, r12)
            java.util.List r12 = (java.util.List) r12
            androidx.datastore.preferences.protobuf.SchemaUtil.writeInt32List(r5, r12, r6, r14)
            goto L_0x008f
        L_0x0268:
            r14 = r16
            int r5 = r0.numberAt(r2)
            java.lang.Object r12 = r10.getObject(r1, r12)
            java.util.List r12 = (java.util.List) r12
            androidx.datastore.preferences.protobuf.SchemaUtil.writeUInt64List(r5, r12, r6, r14)
            goto L_0x008f
        L_0x0279:
            r14 = r16
            int r5 = r0.numberAt(r2)
            java.lang.Object r12 = r10.getObject(r1, r12)
            java.util.List r12 = (java.util.List) r12
            androidx.datastore.preferences.protobuf.SchemaUtil.writeInt64List(r5, r12, r6, r14)
            goto L_0x008f
        L_0x028a:
            r14 = r16
            int r5 = r0.numberAt(r2)
            java.lang.Object r12 = r10.getObject(r1, r12)
            java.util.List r12 = (java.util.List) r12
            androidx.datastore.preferences.protobuf.SchemaUtil.writeFloatList(r5, r12, r6, r14)
            goto L_0x008f
        L_0x029b:
            r14 = r16
            int r5 = r0.numberAt(r2)
            java.lang.Object r12 = r10.getObject(r1, r12)
            java.util.List r12 = (java.util.List) r12
            androidx.datastore.preferences.protobuf.SchemaUtil.writeDoubleList(r5, r12, r6, r14)
            goto L_0x008f
        L_0x02ac:
            int r5 = r0.numberAt(r2)
            java.lang.Object r12 = r10.getObject(r1, r12)
            java.util.List r12 = (java.util.List) r12
            r14 = 0
            androidx.datastore.preferences.protobuf.SchemaUtil.writeSInt64List(r5, r12, r6, r14)
            goto L_0x0305
        L_0x02bb:
            r14 = 0
            int r5 = r0.numberAt(r2)
            java.lang.Object r12 = r10.getObject(r1, r12)
            java.util.List r12 = (java.util.List) r12
            androidx.datastore.preferences.protobuf.SchemaUtil.writeSInt32List(r5, r12, r6, r14)
            goto L_0x0305
        L_0x02ca:
            r14 = 0
            int r5 = r0.numberAt(r2)
            java.lang.Object r12 = r10.getObject(r1, r12)
            java.util.List r12 = (java.util.List) r12
            androidx.datastore.preferences.protobuf.SchemaUtil.writeSFixed64List(r5, r12, r6, r14)
            goto L_0x0305
        L_0x02d9:
            r14 = 0
            int r5 = r0.numberAt(r2)
            java.lang.Object r12 = r10.getObject(r1, r12)
            java.util.List r12 = (java.util.List) r12
            androidx.datastore.preferences.protobuf.SchemaUtil.writeSFixed32List(r5, r12, r6, r14)
            goto L_0x0305
        L_0x02e8:
            r14 = 0
            int r5 = r0.numberAt(r2)
            java.lang.Object r12 = r10.getObject(r1, r12)
            java.util.List r12 = (java.util.List) r12
            androidx.datastore.preferences.protobuf.SchemaUtil.writeEnumList(r5, r12, r6, r14)
            goto L_0x0305
        L_0x02f7:
            r14 = 0
            int r5 = r0.numberAt(r2)
            java.lang.Object r12 = r10.getObject(r1, r12)
            java.util.List r12 = (java.util.List) r12
            androidx.datastore.preferences.protobuf.SchemaUtil.writeUInt32List(r5, r12, r6, r14)
        L_0x0305:
            r15 = r14
            goto L_0x04dc
        L_0x0308:
            int r5 = r0.numberAt(r2)
            java.lang.Object r12 = r10.getObject(r1, r12)
            java.util.List r12 = (java.util.List) r12
            androidx.datastore.preferences.protobuf.SchemaUtil.writeBytesList(r5, r12, r6)
            goto L_0x008f
        L_0x0317:
            int r5 = r0.numberAt(r2)
            java.lang.Object r12 = r10.getObject(r1, r12)
            java.util.List r12 = (java.util.List) r12
            androidx.datastore.preferences.protobuf.Schema r13 = r0.getMessageFieldSchema(r2)
            androidx.datastore.preferences.protobuf.SchemaUtil.writeMessageList(r5, r12, r6, r13)
            goto L_0x008f
        L_0x032a:
            int r5 = r0.numberAt(r2)
            java.lang.Object r12 = r10.getObject(r1, r12)
            java.util.List r12 = (java.util.List) r12
            androidx.datastore.preferences.protobuf.SchemaUtil.writeStringList(r5, r12, r6)
            goto L_0x008f
        L_0x0339:
            int r5 = r0.numberAt(r2)
            java.lang.Object r12 = r10.getObject(r1, r12)
            java.util.List r12 = (java.util.List) r12
            r15 = 0
            androidx.datastore.preferences.protobuf.SchemaUtil.writeBoolList(r5, r12, r6, r15)
            goto L_0x04dc
        L_0x0349:
            r15 = 0
            int r5 = r0.numberAt(r2)
            java.lang.Object r12 = r10.getObject(r1, r12)
            java.util.List r12 = (java.util.List) r12
            androidx.datastore.preferences.protobuf.SchemaUtil.writeFixed32List(r5, r12, r6, r15)
            goto L_0x04dc
        L_0x0359:
            r15 = 0
            int r5 = r0.numberAt(r2)
            java.lang.Object r12 = r10.getObject(r1, r12)
            java.util.List r12 = (java.util.List) r12
            androidx.datastore.preferences.protobuf.SchemaUtil.writeFixed64List(r5, r12, r6, r15)
            goto L_0x04dc
        L_0x0369:
            r15 = 0
            int r5 = r0.numberAt(r2)
            java.lang.Object r12 = r10.getObject(r1, r12)
            java.util.List r12 = (java.util.List) r12
            androidx.datastore.preferences.protobuf.SchemaUtil.writeInt32List(r5, r12, r6, r15)
            goto L_0x04dc
        L_0x0379:
            r15 = 0
            int r5 = r0.numberAt(r2)
            java.lang.Object r12 = r10.getObject(r1, r12)
            java.util.List r12 = (java.util.List) r12
            androidx.datastore.preferences.protobuf.SchemaUtil.writeUInt64List(r5, r12, r6, r15)
            goto L_0x04dc
        L_0x0389:
            r15 = 0
            int r5 = r0.numberAt(r2)
            java.lang.Object r12 = r10.getObject(r1, r12)
            java.util.List r12 = (java.util.List) r12
            androidx.datastore.preferences.protobuf.SchemaUtil.writeInt64List(r5, r12, r6, r15)
            goto L_0x04dc
        L_0x0399:
            r15 = 0
            int r5 = r0.numberAt(r2)
            java.lang.Object r12 = r10.getObject(r1, r12)
            java.util.List r12 = (java.util.List) r12
            androidx.datastore.preferences.protobuf.SchemaUtil.writeFloatList(r5, r12, r6, r15)
            goto L_0x04dc
        L_0x03a9:
            r15 = 0
            int r5 = r0.numberAt(r2)
            java.lang.Object r12 = r10.getObject(r1, r12)
            java.util.List r12 = (java.util.List) r12
            androidx.datastore.preferences.protobuf.SchemaUtil.writeDoubleList(r5, r12, r6, r15)
            goto L_0x04dc
        L_0x03b9:
            r15 = 0
            boolean r5 = r0.isFieldPresent(r1, r2, r3, r4, r5)
            if (r5 == 0) goto L_0x04dc
            java.lang.Object r5 = r10.getObject(r1, r12)
            androidx.datastore.preferences.protobuf.Schema r12 = r0.getMessageFieldSchema(r2)
            r6.writeGroup(r14, r5, r12)
            goto L_0x04dc
        L_0x03cd:
            r15 = 0
            boolean r5 = r0.isFieldPresent(r1, r2, r3, r4, r5)
            if (r5 == 0) goto L_0x04cb
            long r12 = r10.getLong(r1, r12)
            r6.writeSInt64(r14, r12)
            goto L_0x04cb
        L_0x03dd:
            r15 = 0
            boolean r5 = r0.isFieldPresent(r1, r2, r3, r4, r5)
            if (r5 == 0) goto L_0x04cb
            int r0 = r10.getInt(r1, r12)
            r6.writeSInt32(r14, r0)
            goto L_0x04cb
        L_0x03ed:
            r15 = 0
            boolean r5 = r0.isFieldPresent(r1, r2, r3, r4, r5)
            if (r5 == 0) goto L_0x04cb
            long r12 = r10.getLong(r1, r12)
            r6.writeSFixed64(r14, r12)
            goto L_0x04cb
        L_0x03fd:
            r15 = 0
            boolean r5 = r0.isFieldPresent(r1, r2, r3, r4, r5)
            if (r5 == 0) goto L_0x04cb
            int r0 = r10.getInt(r1, r12)
            r6.writeSFixed32(r14, r0)
            goto L_0x04cb
        L_0x040d:
            r15 = 0
            boolean r5 = r0.isFieldPresent(r1, r2, r3, r4, r5)
            if (r5 == 0) goto L_0x04cb
            int r0 = r10.getInt(r1, r12)
            r6.writeEnum(r14, r0)
            goto L_0x04cb
        L_0x041d:
            r15 = 0
            boolean r5 = r0.isFieldPresent(r1, r2, r3, r4, r5)
            if (r5 == 0) goto L_0x04cb
            int r0 = r10.getInt(r1, r12)
            r6.writeUInt32(r14, r0)
            goto L_0x04cb
        L_0x042d:
            r15 = 0
            boolean r5 = r0.isFieldPresent(r1, r2, r3, r4, r5)
            if (r5 == 0) goto L_0x04cb
            java.lang.Object r0 = r10.getObject(r1, r12)
            androidx.datastore.preferences.protobuf.ByteString r0 = (androidx.datastore.preferences.protobuf.ByteString) r0
            r6.writeBytes(r14, r0)
            goto L_0x04cb
        L_0x043f:
            r15 = 0
            boolean r5 = r0.isFieldPresent(r1, r2, r3, r4, r5)
            if (r5 == 0) goto L_0x04dc
            java.lang.Object r5 = r10.getObject(r1, r12)
            androidx.datastore.preferences.protobuf.Schema r12 = r0.getMessageFieldSchema(r2)
            r6.writeMessage(r14, r5, r12)
            goto L_0x04dc
        L_0x0453:
            r15 = 0
            boolean r5 = r0.isFieldPresent(r1, r2, r3, r4, r5)
            if (r5 == 0) goto L_0x04dc
            java.lang.Object r5 = r10.getObject(r1, r12)
            r0.writeString(r14, r5, r6)
            goto L_0x04dc
        L_0x0463:
            r15 = 0
            boolean r5 = r0.isFieldPresent(r1, r2, r3, r4, r5)
            if (r5 == 0) goto L_0x04cb
            boolean r0 = booleanAt(r1, r12)
            r6.writeBool(r14, r0)
            goto L_0x04cb
        L_0x0472:
            r15 = 0
            boolean r5 = r0.isFieldPresent(r1, r2, r3, r4, r5)
            if (r5 == 0) goto L_0x04cb
            int r0 = r10.getInt(r1, r12)
            r6.writeFixed32(r14, r0)
            goto L_0x04cb
        L_0x0481:
            r15 = 0
            boolean r5 = r0.isFieldPresent(r1, r2, r3, r4, r5)
            if (r5 == 0) goto L_0x04cb
            long r12 = r10.getLong(r1, r12)
            r6.writeFixed64(r14, r12)
            goto L_0x04cb
        L_0x0490:
            r15 = 0
            boolean r5 = r0.isFieldPresent(r1, r2, r3, r4, r5)
            if (r5 == 0) goto L_0x04cb
            int r0 = r10.getInt(r1, r12)
            r6.writeInt32(r14, r0)
            goto L_0x04cb
        L_0x049f:
            r15 = 0
            boolean r5 = r0.isFieldPresent(r1, r2, r3, r4, r5)
            if (r5 == 0) goto L_0x04cb
            long r12 = r10.getLong(r1, r12)
            r6.writeUInt64(r14, r12)
            goto L_0x04cb
        L_0x04ae:
            r15 = 0
            boolean r5 = r0.isFieldPresent(r1, r2, r3, r4, r5)
            if (r5 == 0) goto L_0x04cb
            long r12 = r10.getLong(r1, r12)
            r6.writeInt64(r14, r12)
            goto L_0x04cb
        L_0x04bd:
            r15 = 0
            boolean r5 = r0.isFieldPresent(r1, r2, r3, r4, r5)
            if (r5 == 0) goto L_0x04cb
            float r0 = floatAt(r1, r12)
            r6.writeFloat(r14, r0)
        L_0x04cb:
            r0 = r18
            goto L_0x04dc
        L_0x04ce:
            r15 = 0
            boolean r5 = r0.isFieldPresent(r1, r2, r3, r4, r5)
            if (r5 == 0) goto L_0x04dc
            double r12 = doubleAt(r1, r12)
            r6.writeDouble(r14, r12)
        L_0x04dc:
            int r2 = r2 + 3
            r5 = r4
            r4 = r3
            r3 = r7
            goto L_0x002f
        L_0x04e3:
            if (r3 == 0) goto L_0x04fa
            androidx.datastore.preferences.protobuf.ExtensionSchema<?> r2 = r0.extensionSchema
            r2.serializeExtension(r6, r3)
            boolean r2 = r8.hasNext()
            if (r2 == 0) goto L_0x04f8
            java.lang.Object r2 = r8.next()
            java.util.Map$Entry r2 = (java.util.Map.Entry) r2
            r3 = r2
            goto L_0x04e3
        L_0x04f8:
            r3 = 0
            goto L_0x04e3
        L_0x04fa:
            androidx.datastore.preferences.protobuf.UnknownFieldSchema<?, ?> r2 = r0.unknownFieldSchema
            r0.writeUnknownInMessageTo(r2, r1, r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.MessageSchema.writeFieldsInAscendingOrder(java.lang.Object, androidx.datastore.preferences.protobuf.Writer):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:161:0x058e  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void writeFieldsInDescendingOrder(T r11, androidx.datastore.preferences.protobuf.Writer r12) throws java.io.IOException {
        /*
            r10 = this;
            androidx.datastore.preferences.protobuf.UnknownFieldSchema<?, ?> r0 = r10.unknownFieldSchema
            r10.writeUnknownInMessageTo(r0, r11, r12)
            boolean r0 = r10.hasExtensions
            r1 = 0
            if (r0 == 0) goto L_0x0021
            androidx.datastore.preferences.protobuf.ExtensionSchema<?> r0 = r10.extensionSchema
            androidx.datastore.preferences.protobuf.FieldSet r0 = r0.getExtensions(r11)
            boolean r2 = r0.isEmpty()
            if (r2 != 0) goto L_0x0021
            java.util.Iterator r0 = r0.descendingIterator()
            java.lang.Object r2 = r0.next()
            java.util.Map$Entry r2 = (java.util.Map.Entry) r2
            goto L_0x0023
        L_0x0021:
            r0 = r1
            r2 = r0
        L_0x0023:
            int[] r3 = r10.buffer
            int r3 = r3.length
            int r3 = r3 + -3
        L_0x0028:
            if (r3 < 0) goto L_0x058c
            int r4 = r10.typeAndOffsetAt(r3)
            int r5 = r10.numberAt(r3)
        L_0x0032:
            if (r2 == 0) goto L_0x0050
            androidx.datastore.preferences.protobuf.ExtensionSchema<?> r6 = r10.extensionSchema
            int r6 = r6.extensionNumber(r2)
            if (r6 <= r5) goto L_0x0050
            androidx.datastore.preferences.protobuf.ExtensionSchema<?> r6 = r10.extensionSchema
            r6.serializeExtension(r12, r2)
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x004e
            java.lang.Object r2 = r0.next()
            java.util.Map$Entry r2 = (java.util.Map.Entry) r2
            goto L_0x0032
        L_0x004e:
            r2 = r1
            goto L_0x0032
        L_0x0050:
            int r6 = type(r4)
            r7 = 1
            r8 = 0
            switch(r6) {
                case 0: goto L_0x0577;
                case 1: goto L_0x0565;
                case 2: goto L_0x0553;
                case 3: goto L_0x0541;
                case 4: goto L_0x052f;
                case 5: goto L_0x051d;
                case 6: goto L_0x050b;
                case 7: goto L_0x04f8;
                case 8: goto L_0x04e5;
                case 9: goto L_0x04ce;
                case 10: goto L_0x04b9;
                case 11: goto L_0x04a6;
                case 12: goto L_0x0493;
                case 13: goto L_0x0480;
                case 14: goto L_0x046d;
                case 15: goto L_0x045a;
                case 16: goto L_0x0447;
                case 17: goto L_0x0430;
                case 18: goto L_0x041d;
                case 19: goto L_0x040a;
                case 20: goto L_0x03f7;
                case 21: goto L_0x03e4;
                case 22: goto L_0x03d1;
                case 23: goto L_0x03be;
                case 24: goto L_0x03ab;
                case 25: goto L_0x0398;
                case 26: goto L_0x0385;
                case 27: goto L_0x036e;
                case 28: goto L_0x035b;
                case 29: goto L_0x0348;
                case 30: goto L_0x0335;
                case 31: goto L_0x0322;
                case 32: goto L_0x030f;
                case 33: goto L_0x02fc;
                case 34: goto L_0x02e9;
                case 35: goto L_0x02d6;
                case 36: goto L_0x02c3;
                case 37: goto L_0x02b0;
                case 38: goto L_0x029d;
                case 39: goto L_0x028a;
                case 40: goto L_0x0277;
                case 41: goto L_0x0264;
                case 42: goto L_0x0251;
                case 43: goto L_0x023e;
                case 44: goto L_0x022b;
                case 45: goto L_0x0218;
                case 46: goto L_0x0205;
                case 47: goto L_0x01f2;
                case 48: goto L_0x01df;
                case 49: goto L_0x01c8;
                case 50: goto L_0x01bb;
                case 51: goto L_0x01a8;
                case 52: goto L_0x0195;
                case 53: goto L_0x0182;
                case 54: goto L_0x016f;
                case 55: goto L_0x015c;
                case 56: goto L_0x0149;
                case 57: goto L_0x0136;
                case 58: goto L_0x0123;
                case 59: goto L_0x0110;
                case 60: goto L_0x00f9;
                case 61: goto L_0x00e4;
                case 62: goto L_0x00d1;
                case 63: goto L_0x00be;
                case 64: goto L_0x00ab;
                case 65: goto L_0x0098;
                case 66: goto L_0x0085;
                case 67: goto L_0x0072;
                case 68: goto L_0x005b;
                default: goto L_0x0059;
            }
        L_0x0059:
            goto L_0x0588
        L_0x005b:
            boolean r6 = r10.isOneofPresent(r11, r5, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = offset(r4)
            java.lang.Object r4 = androidx.datastore.preferences.protobuf.UnsafeUtil.getObject((java.lang.Object) r11, (long) r6)
            androidx.datastore.preferences.protobuf.Schema r6 = r10.getMessageFieldSchema(r3)
            r12.writeGroup(r5, r4, r6)
            goto L_0x0588
        L_0x0072:
            boolean r6 = r10.isOneofPresent(r11, r5, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = offset(r4)
            long r6 = oneofLongAt(r11, r6)
            r12.writeSInt64(r5, r6)
            goto L_0x0588
        L_0x0085:
            boolean r6 = r10.isOneofPresent(r11, r5, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = offset(r4)
            int r4 = oneofIntAt(r11, r6)
            r12.writeSInt32(r5, r4)
            goto L_0x0588
        L_0x0098:
            boolean r6 = r10.isOneofPresent(r11, r5, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = offset(r4)
            long r6 = oneofLongAt(r11, r6)
            r12.writeSFixed64(r5, r6)
            goto L_0x0588
        L_0x00ab:
            boolean r6 = r10.isOneofPresent(r11, r5, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = offset(r4)
            int r4 = oneofIntAt(r11, r6)
            r12.writeSFixed32(r5, r4)
            goto L_0x0588
        L_0x00be:
            boolean r6 = r10.isOneofPresent(r11, r5, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = offset(r4)
            int r4 = oneofIntAt(r11, r6)
            r12.writeEnum(r5, r4)
            goto L_0x0588
        L_0x00d1:
            boolean r6 = r10.isOneofPresent(r11, r5, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = offset(r4)
            int r4 = oneofIntAt(r11, r6)
            r12.writeUInt32(r5, r4)
            goto L_0x0588
        L_0x00e4:
            boolean r6 = r10.isOneofPresent(r11, r5, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = offset(r4)
            java.lang.Object r4 = androidx.datastore.preferences.protobuf.UnsafeUtil.getObject((java.lang.Object) r11, (long) r6)
            androidx.datastore.preferences.protobuf.ByteString r4 = (androidx.datastore.preferences.protobuf.ByteString) r4
            r12.writeBytes(r5, r4)
            goto L_0x0588
        L_0x00f9:
            boolean r6 = r10.isOneofPresent(r11, r5, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = offset(r4)
            java.lang.Object r4 = androidx.datastore.preferences.protobuf.UnsafeUtil.getObject((java.lang.Object) r11, (long) r6)
            androidx.datastore.preferences.protobuf.Schema r6 = r10.getMessageFieldSchema(r3)
            r12.writeMessage(r5, r4, r6)
            goto L_0x0588
        L_0x0110:
            boolean r6 = r10.isOneofPresent(r11, r5, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = offset(r4)
            java.lang.Object r4 = androidx.datastore.preferences.protobuf.UnsafeUtil.getObject((java.lang.Object) r11, (long) r6)
            r10.writeString(r5, r4, r12)
            goto L_0x0588
        L_0x0123:
            boolean r6 = r10.isOneofPresent(r11, r5, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = offset(r4)
            boolean r4 = oneofBooleanAt(r11, r6)
            r12.writeBool(r5, r4)
            goto L_0x0588
        L_0x0136:
            boolean r6 = r10.isOneofPresent(r11, r5, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = offset(r4)
            int r4 = oneofIntAt(r11, r6)
            r12.writeFixed32(r5, r4)
            goto L_0x0588
        L_0x0149:
            boolean r6 = r10.isOneofPresent(r11, r5, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = offset(r4)
            long r6 = oneofLongAt(r11, r6)
            r12.writeFixed64(r5, r6)
            goto L_0x0588
        L_0x015c:
            boolean r6 = r10.isOneofPresent(r11, r5, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = offset(r4)
            int r4 = oneofIntAt(r11, r6)
            r12.writeInt32(r5, r4)
            goto L_0x0588
        L_0x016f:
            boolean r6 = r10.isOneofPresent(r11, r5, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = offset(r4)
            long r6 = oneofLongAt(r11, r6)
            r12.writeUInt64(r5, r6)
            goto L_0x0588
        L_0x0182:
            boolean r6 = r10.isOneofPresent(r11, r5, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = offset(r4)
            long r6 = oneofLongAt(r11, r6)
            r12.writeInt64(r5, r6)
            goto L_0x0588
        L_0x0195:
            boolean r6 = r10.isOneofPresent(r11, r5, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = offset(r4)
            float r4 = oneofFloatAt(r11, r6)
            r12.writeFloat(r5, r4)
            goto L_0x0588
        L_0x01a8:
            boolean r6 = r10.isOneofPresent(r11, r5, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = offset(r4)
            double r6 = oneofDoubleAt(r11, r6)
            r12.writeDouble(r5, r6)
            goto L_0x0588
        L_0x01bb:
            long r6 = offset(r4)
            java.lang.Object r4 = androidx.datastore.preferences.protobuf.UnsafeUtil.getObject((java.lang.Object) r11, (long) r6)
            r10.writeMapHelper(r12, r5, r4, r3)
            goto L_0x0588
        L_0x01c8:
            int r5 = r10.numberAt(r3)
            long r6 = offset(r4)
            java.lang.Object r4 = androidx.datastore.preferences.protobuf.UnsafeUtil.getObject((java.lang.Object) r11, (long) r6)
            java.util.List r4 = (java.util.List) r4
            androidx.datastore.preferences.protobuf.Schema r6 = r10.getMessageFieldSchema(r3)
            androidx.datastore.preferences.protobuf.SchemaUtil.writeGroupList(r5, r4, r12, r6)
            goto L_0x0588
        L_0x01df:
            int r5 = r10.numberAt(r3)
            long r8 = offset(r4)
            java.lang.Object r4 = androidx.datastore.preferences.protobuf.UnsafeUtil.getObject((java.lang.Object) r11, (long) r8)
            java.util.List r4 = (java.util.List) r4
            androidx.datastore.preferences.protobuf.SchemaUtil.writeSInt64List(r5, r4, r12, r7)
            goto L_0x0588
        L_0x01f2:
            int r5 = r10.numberAt(r3)
            long r8 = offset(r4)
            java.lang.Object r4 = androidx.datastore.preferences.protobuf.UnsafeUtil.getObject((java.lang.Object) r11, (long) r8)
            java.util.List r4 = (java.util.List) r4
            androidx.datastore.preferences.protobuf.SchemaUtil.writeSInt32List(r5, r4, r12, r7)
            goto L_0x0588
        L_0x0205:
            int r5 = r10.numberAt(r3)
            long r8 = offset(r4)
            java.lang.Object r4 = androidx.datastore.preferences.protobuf.UnsafeUtil.getObject((java.lang.Object) r11, (long) r8)
            java.util.List r4 = (java.util.List) r4
            androidx.datastore.preferences.protobuf.SchemaUtil.writeSFixed64List(r5, r4, r12, r7)
            goto L_0x0588
        L_0x0218:
            int r5 = r10.numberAt(r3)
            long r8 = offset(r4)
            java.lang.Object r4 = androidx.datastore.preferences.protobuf.UnsafeUtil.getObject((java.lang.Object) r11, (long) r8)
            java.util.List r4 = (java.util.List) r4
            androidx.datastore.preferences.protobuf.SchemaUtil.writeSFixed32List(r5, r4, r12, r7)
            goto L_0x0588
        L_0x022b:
            int r5 = r10.numberAt(r3)
            long r8 = offset(r4)
            java.lang.Object r4 = androidx.datastore.preferences.protobuf.UnsafeUtil.getObject((java.lang.Object) r11, (long) r8)
            java.util.List r4 = (java.util.List) r4
            androidx.datastore.preferences.protobuf.SchemaUtil.writeEnumList(r5, r4, r12, r7)
            goto L_0x0588
        L_0x023e:
            int r5 = r10.numberAt(r3)
            long r8 = offset(r4)
            java.lang.Object r4 = androidx.datastore.preferences.protobuf.UnsafeUtil.getObject((java.lang.Object) r11, (long) r8)
            java.util.List r4 = (java.util.List) r4
            androidx.datastore.preferences.protobuf.SchemaUtil.writeUInt32List(r5, r4, r12, r7)
            goto L_0x0588
        L_0x0251:
            int r5 = r10.numberAt(r3)
            long r8 = offset(r4)
            java.lang.Object r4 = androidx.datastore.preferences.protobuf.UnsafeUtil.getObject((java.lang.Object) r11, (long) r8)
            java.util.List r4 = (java.util.List) r4
            androidx.datastore.preferences.protobuf.SchemaUtil.writeBoolList(r5, r4, r12, r7)
            goto L_0x0588
        L_0x0264:
            int r5 = r10.numberAt(r3)
            long r8 = offset(r4)
            java.lang.Object r4 = androidx.datastore.preferences.protobuf.UnsafeUtil.getObject((java.lang.Object) r11, (long) r8)
            java.util.List r4 = (java.util.List) r4
            androidx.datastore.preferences.protobuf.SchemaUtil.writeFixed32List(r5, r4, r12, r7)
            goto L_0x0588
        L_0x0277:
            int r5 = r10.numberAt(r3)
            long r8 = offset(r4)
            java.lang.Object r4 = androidx.datastore.preferences.protobuf.UnsafeUtil.getObject((java.lang.Object) r11, (long) r8)
            java.util.List r4 = (java.util.List) r4
            androidx.datastore.preferences.protobuf.SchemaUtil.writeFixed64List(r5, r4, r12, r7)
            goto L_0x0588
        L_0x028a:
            int r5 = r10.numberAt(r3)
            long r8 = offset(r4)
            java.lang.Object r4 = androidx.datastore.preferences.protobuf.UnsafeUtil.getObject((java.lang.Object) r11, (long) r8)
            java.util.List r4 = (java.util.List) r4
            androidx.datastore.preferences.protobuf.SchemaUtil.writeInt32List(r5, r4, r12, r7)
            goto L_0x0588
        L_0x029d:
            int r5 = r10.numberAt(r3)
            long r8 = offset(r4)
            java.lang.Object r4 = androidx.datastore.preferences.protobuf.UnsafeUtil.getObject((java.lang.Object) r11, (long) r8)
            java.util.List r4 = (java.util.List) r4
            androidx.datastore.preferences.protobuf.SchemaUtil.writeUInt64List(r5, r4, r12, r7)
            goto L_0x0588
        L_0x02b0:
            int r5 = r10.numberAt(r3)
            long r8 = offset(r4)
            java.lang.Object r4 = androidx.datastore.preferences.protobuf.UnsafeUtil.getObject((java.lang.Object) r11, (long) r8)
            java.util.List r4 = (java.util.List) r4
            androidx.datastore.preferences.protobuf.SchemaUtil.writeInt64List(r5, r4, r12, r7)
            goto L_0x0588
        L_0x02c3:
            int r5 = r10.numberAt(r3)
            long r8 = offset(r4)
            java.lang.Object r4 = androidx.datastore.preferences.protobuf.UnsafeUtil.getObject((java.lang.Object) r11, (long) r8)
            java.util.List r4 = (java.util.List) r4
            androidx.datastore.preferences.protobuf.SchemaUtil.writeFloatList(r5, r4, r12, r7)
            goto L_0x0588
        L_0x02d6:
            int r5 = r10.numberAt(r3)
            long r8 = offset(r4)
            java.lang.Object r4 = androidx.datastore.preferences.protobuf.UnsafeUtil.getObject((java.lang.Object) r11, (long) r8)
            java.util.List r4 = (java.util.List) r4
            androidx.datastore.preferences.protobuf.SchemaUtil.writeDoubleList(r5, r4, r12, r7)
            goto L_0x0588
        L_0x02e9:
            int r5 = r10.numberAt(r3)
            long r6 = offset(r4)
            java.lang.Object r4 = androidx.datastore.preferences.protobuf.UnsafeUtil.getObject((java.lang.Object) r11, (long) r6)
            java.util.List r4 = (java.util.List) r4
            androidx.datastore.preferences.protobuf.SchemaUtil.writeSInt64List(r5, r4, r12, r8)
            goto L_0x0588
        L_0x02fc:
            int r5 = r10.numberAt(r3)
            long r6 = offset(r4)
            java.lang.Object r4 = androidx.datastore.preferences.protobuf.UnsafeUtil.getObject((java.lang.Object) r11, (long) r6)
            java.util.List r4 = (java.util.List) r4
            androidx.datastore.preferences.protobuf.SchemaUtil.writeSInt32List(r5, r4, r12, r8)
            goto L_0x0588
        L_0x030f:
            int r5 = r10.numberAt(r3)
            long r6 = offset(r4)
            java.lang.Object r4 = androidx.datastore.preferences.protobuf.UnsafeUtil.getObject((java.lang.Object) r11, (long) r6)
            java.util.List r4 = (java.util.List) r4
            androidx.datastore.preferences.protobuf.SchemaUtil.writeSFixed64List(r5, r4, r12, r8)
            goto L_0x0588
        L_0x0322:
            int r5 = r10.numberAt(r3)
            long r6 = offset(r4)
            java.lang.Object r4 = androidx.datastore.preferences.protobuf.UnsafeUtil.getObject((java.lang.Object) r11, (long) r6)
            java.util.List r4 = (java.util.List) r4
            androidx.datastore.preferences.protobuf.SchemaUtil.writeSFixed32List(r5, r4, r12, r8)
            goto L_0x0588
        L_0x0335:
            int r5 = r10.numberAt(r3)
            long r6 = offset(r4)
            java.lang.Object r4 = androidx.datastore.preferences.protobuf.UnsafeUtil.getObject((java.lang.Object) r11, (long) r6)
            java.util.List r4 = (java.util.List) r4
            androidx.datastore.preferences.protobuf.SchemaUtil.writeEnumList(r5, r4, r12, r8)
            goto L_0x0588
        L_0x0348:
            int r5 = r10.numberAt(r3)
            long r6 = offset(r4)
            java.lang.Object r4 = androidx.datastore.preferences.protobuf.UnsafeUtil.getObject((java.lang.Object) r11, (long) r6)
            java.util.List r4 = (java.util.List) r4
            androidx.datastore.preferences.protobuf.SchemaUtil.writeUInt32List(r5, r4, r12, r8)
            goto L_0x0588
        L_0x035b:
            int r5 = r10.numberAt(r3)
            long r6 = offset(r4)
            java.lang.Object r4 = androidx.datastore.preferences.protobuf.UnsafeUtil.getObject((java.lang.Object) r11, (long) r6)
            java.util.List r4 = (java.util.List) r4
            androidx.datastore.preferences.protobuf.SchemaUtil.writeBytesList(r5, r4, r12)
            goto L_0x0588
        L_0x036e:
            int r5 = r10.numberAt(r3)
            long r6 = offset(r4)
            java.lang.Object r4 = androidx.datastore.preferences.protobuf.UnsafeUtil.getObject((java.lang.Object) r11, (long) r6)
            java.util.List r4 = (java.util.List) r4
            androidx.datastore.preferences.protobuf.Schema r6 = r10.getMessageFieldSchema(r3)
            androidx.datastore.preferences.protobuf.SchemaUtil.writeMessageList(r5, r4, r12, r6)
            goto L_0x0588
        L_0x0385:
            int r5 = r10.numberAt(r3)
            long r6 = offset(r4)
            java.lang.Object r4 = androidx.datastore.preferences.protobuf.UnsafeUtil.getObject((java.lang.Object) r11, (long) r6)
            java.util.List r4 = (java.util.List) r4
            androidx.datastore.preferences.protobuf.SchemaUtil.writeStringList(r5, r4, r12)
            goto L_0x0588
        L_0x0398:
            int r5 = r10.numberAt(r3)
            long r6 = offset(r4)
            java.lang.Object r4 = androidx.datastore.preferences.protobuf.UnsafeUtil.getObject((java.lang.Object) r11, (long) r6)
            java.util.List r4 = (java.util.List) r4
            androidx.datastore.preferences.protobuf.SchemaUtil.writeBoolList(r5, r4, r12, r8)
            goto L_0x0588
        L_0x03ab:
            int r5 = r10.numberAt(r3)
            long r6 = offset(r4)
            java.lang.Object r4 = androidx.datastore.preferences.protobuf.UnsafeUtil.getObject((java.lang.Object) r11, (long) r6)
            java.util.List r4 = (java.util.List) r4
            androidx.datastore.preferences.protobuf.SchemaUtil.writeFixed32List(r5, r4, r12, r8)
            goto L_0x0588
        L_0x03be:
            int r5 = r10.numberAt(r3)
            long r6 = offset(r4)
            java.lang.Object r4 = androidx.datastore.preferences.protobuf.UnsafeUtil.getObject((java.lang.Object) r11, (long) r6)
            java.util.List r4 = (java.util.List) r4
            androidx.datastore.preferences.protobuf.SchemaUtil.writeFixed64List(r5, r4, r12, r8)
            goto L_0x0588
        L_0x03d1:
            int r5 = r10.numberAt(r3)
            long r6 = offset(r4)
            java.lang.Object r4 = androidx.datastore.preferences.protobuf.UnsafeUtil.getObject((java.lang.Object) r11, (long) r6)
            java.util.List r4 = (java.util.List) r4
            androidx.datastore.preferences.protobuf.SchemaUtil.writeInt32List(r5, r4, r12, r8)
            goto L_0x0588
        L_0x03e4:
            int r5 = r10.numberAt(r3)
            long r6 = offset(r4)
            java.lang.Object r4 = androidx.datastore.preferences.protobuf.UnsafeUtil.getObject((java.lang.Object) r11, (long) r6)
            java.util.List r4 = (java.util.List) r4
            androidx.datastore.preferences.protobuf.SchemaUtil.writeUInt64List(r5, r4, r12, r8)
            goto L_0x0588
        L_0x03f7:
            int r5 = r10.numberAt(r3)
            long r6 = offset(r4)
            java.lang.Object r4 = androidx.datastore.preferences.protobuf.UnsafeUtil.getObject((java.lang.Object) r11, (long) r6)
            java.util.List r4 = (java.util.List) r4
            androidx.datastore.preferences.protobuf.SchemaUtil.writeInt64List(r5, r4, r12, r8)
            goto L_0x0588
        L_0x040a:
            int r5 = r10.numberAt(r3)
            long r6 = offset(r4)
            java.lang.Object r4 = androidx.datastore.preferences.protobuf.UnsafeUtil.getObject((java.lang.Object) r11, (long) r6)
            java.util.List r4 = (java.util.List) r4
            androidx.datastore.preferences.protobuf.SchemaUtil.writeFloatList(r5, r4, r12, r8)
            goto L_0x0588
        L_0x041d:
            int r5 = r10.numberAt(r3)
            long r6 = offset(r4)
            java.lang.Object r4 = androidx.datastore.preferences.protobuf.UnsafeUtil.getObject((java.lang.Object) r11, (long) r6)
            java.util.List r4 = (java.util.List) r4
            androidx.datastore.preferences.protobuf.SchemaUtil.writeDoubleList(r5, r4, r12, r8)
            goto L_0x0588
        L_0x0430:
            boolean r6 = r10.isFieldPresent(r11, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = offset(r4)
            java.lang.Object r4 = androidx.datastore.preferences.protobuf.UnsafeUtil.getObject((java.lang.Object) r11, (long) r6)
            androidx.datastore.preferences.protobuf.Schema r6 = r10.getMessageFieldSchema(r3)
            r12.writeGroup(r5, r4, r6)
            goto L_0x0588
        L_0x0447:
            boolean r6 = r10.isFieldPresent(r11, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = offset(r4)
            long r6 = longAt(r11, r6)
            r12.writeSInt64(r5, r6)
            goto L_0x0588
        L_0x045a:
            boolean r6 = r10.isFieldPresent(r11, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = offset(r4)
            int r4 = intAt(r11, r6)
            r12.writeSInt32(r5, r4)
            goto L_0x0588
        L_0x046d:
            boolean r6 = r10.isFieldPresent(r11, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = offset(r4)
            long r6 = longAt(r11, r6)
            r12.writeSFixed64(r5, r6)
            goto L_0x0588
        L_0x0480:
            boolean r6 = r10.isFieldPresent(r11, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = offset(r4)
            int r4 = intAt(r11, r6)
            r12.writeSFixed32(r5, r4)
            goto L_0x0588
        L_0x0493:
            boolean r6 = r10.isFieldPresent(r11, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = offset(r4)
            int r4 = intAt(r11, r6)
            r12.writeEnum(r5, r4)
            goto L_0x0588
        L_0x04a6:
            boolean r6 = r10.isFieldPresent(r11, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = offset(r4)
            int r4 = intAt(r11, r6)
            r12.writeUInt32(r5, r4)
            goto L_0x0588
        L_0x04b9:
            boolean r6 = r10.isFieldPresent(r11, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = offset(r4)
            java.lang.Object r4 = androidx.datastore.preferences.protobuf.UnsafeUtil.getObject((java.lang.Object) r11, (long) r6)
            androidx.datastore.preferences.protobuf.ByteString r4 = (androidx.datastore.preferences.protobuf.ByteString) r4
            r12.writeBytes(r5, r4)
            goto L_0x0588
        L_0x04ce:
            boolean r6 = r10.isFieldPresent(r11, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = offset(r4)
            java.lang.Object r4 = androidx.datastore.preferences.protobuf.UnsafeUtil.getObject((java.lang.Object) r11, (long) r6)
            androidx.datastore.preferences.protobuf.Schema r6 = r10.getMessageFieldSchema(r3)
            r12.writeMessage(r5, r4, r6)
            goto L_0x0588
        L_0x04e5:
            boolean r6 = r10.isFieldPresent(r11, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = offset(r4)
            java.lang.Object r4 = androidx.datastore.preferences.protobuf.UnsafeUtil.getObject((java.lang.Object) r11, (long) r6)
            r10.writeString(r5, r4, r12)
            goto L_0x0588
        L_0x04f8:
            boolean r6 = r10.isFieldPresent(r11, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = offset(r4)
            boolean r4 = booleanAt(r11, r6)
            r12.writeBool(r5, r4)
            goto L_0x0588
        L_0x050b:
            boolean r6 = r10.isFieldPresent(r11, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = offset(r4)
            int r4 = intAt(r11, r6)
            r12.writeFixed32(r5, r4)
            goto L_0x0588
        L_0x051d:
            boolean r6 = r10.isFieldPresent(r11, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = offset(r4)
            long r6 = longAt(r11, r6)
            r12.writeFixed64(r5, r6)
            goto L_0x0588
        L_0x052f:
            boolean r6 = r10.isFieldPresent(r11, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = offset(r4)
            int r4 = intAt(r11, r6)
            r12.writeInt32(r5, r4)
            goto L_0x0588
        L_0x0541:
            boolean r6 = r10.isFieldPresent(r11, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = offset(r4)
            long r6 = longAt(r11, r6)
            r12.writeUInt64(r5, r6)
            goto L_0x0588
        L_0x0553:
            boolean r6 = r10.isFieldPresent(r11, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = offset(r4)
            long r6 = longAt(r11, r6)
            r12.writeInt64(r5, r6)
            goto L_0x0588
        L_0x0565:
            boolean r6 = r10.isFieldPresent(r11, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = offset(r4)
            float r4 = floatAt(r11, r6)
            r12.writeFloat(r5, r4)
            goto L_0x0588
        L_0x0577:
            boolean r6 = r10.isFieldPresent(r11, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = offset(r4)
            double r6 = doubleAt(r11, r6)
            r12.writeDouble(r5, r6)
        L_0x0588:
            int r3 = r3 + -3
            goto L_0x0028
        L_0x058c:
            if (r2 == 0) goto L_0x05a3
            androidx.datastore.preferences.protobuf.ExtensionSchema<?> r11 = r10.extensionSchema
            r11.serializeExtension(r12, r2)
            boolean r11 = r0.hasNext()
            if (r11 == 0) goto L_0x05a1
            java.lang.Object r11 = r0.next()
            java.util.Map$Entry r11 = (java.util.Map.Entry) r11
            r2 = r11
            goto L_0x058c
        L_0x05a1:
            r2 = r1
            goto L_0x058c
        L_0x05a3:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.MessageSchema.writeFieldsInDescendingOrder(java.lang.Object, androidx.datastore.preferences.protobuf.Writer):void");
    }

    private <K, V> void writeMapHelper(Writer writer, int i, Object obj, int i2) throws IOException {
        if (obj != null) {
            writer.writeMap(i, this.mapFieldSchema.forMapMetadata(getMapFieldDefaultEntry(i2)), this.mapFieldSchema.forMapData(obj));
        }
    }

    private <UT, UB> void writeUnknownInMessageTo(UnknownFieldSchema<UT, UB> unknownFieldSchema2, T t, Writer writer) throws IOException {
        unknownFieldSchema2.writeTo(unknownFieldSchema2.getFromMessage(t), writer);
    }

    public void mergeFrom(T t, Reader reader, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        extensionRegistryLite.getClass();
        checkMutable(t);
        mergeFromHelper(this.unknownFieldSchema, this.extensionSchema, t, reader, extensionRegistryLite);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:109:0x0283, code lost:
        r6 = r22;
        r2 = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:110:0x0286, code lost:
        r1 = r12;
        r4 = r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:115:0x0294, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:116:0x0295, code lost:
        r12 = r1;
        r1 = r20;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:117:0x0299, code lost:
        r2 = r20;
        r4 = r21;
        r6 = r22;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:159:0x0411, code lost:
        r10 = r18;
        r6 = r22;
        r11 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:169:0x0440, code lost:
        r6 = r22;
        r1 = r12;
        r4 = r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:184:0x0480, code lost:
        r6 = r22;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:303:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:304:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x00a8, code lost:
        r0 = r10.checkInitializedCount;
        r4 = r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x00ad, code lost:
        if (r0 >= r10.repeatedFieldOffsetStart) goto L_0x00c1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x00af, code lost:
        r1 = r10;
        r4 = r1.filterMapUnknownEnumValues(r2, r10.intArray[r0], r4, r5, r20);
        r10 = r5;
        r5 = r2;
        r0 = r0 + 1;
        r5 = r10;
        r10 = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x00c1, code lost:
        r1 = r10;
        r10 = r5;
        r5 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x00c4, code lost:
        if (r4 == null) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x00c6, code lost:
        r10.setBuilderToMessage(r5, r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:89:0x01b9, code lost:
        r2 = r5;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:251:0x06b1 */
    /* JADX WARNING: Removed duplicated region for block: B:118:? A[ExcHandler: InvalidWireTypeException (unused androidx.datastore.preferences.protobuf.InvalidProtocolBufferException$InvalidWireTypeException), SYNTHETIC, Splitter:B:98:0x0256] */
    /* JADX WARNING: Removed duplicated region for block: B:254:0x06b7 A[Catch:{ all -> 0x06fe }] */
    /* JADX WARNING: Removed duplicated region for block: B:261:0x06d5  */
    /* JADX WARNING: Removed duplicated region for block: B:281:0x0712 A[LOOP:6: B:279:0x070e->B:281:0x0712, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:284:0x0725  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private <UT, UB, ET extends androidx.datastore.preferences.protobuf.FieldSet.FieldDescriptorLite<ET>> void mergeFromHelper(androidx.datastore.preferences.protobuf.UnknownFieldSchema<UT, UB> r18, androidx.datastore.preferences.protobuf.ExtensionSchema<ET> r19, T r20, androidx.datastore.preferences.protobuf.Reader r21, androidx.datastore.preferences.protobuf.ExtensionRegistryLite r22) throws java.io.IOException {
        /*
            r17 = this;
            r1 = r17
            r4 = r22
            r8 = 0
            r0 = r8
            r5 = r0
        L_0x0007:
            int r2 = r21.getFieldNumber()     // Catch:{ all -> 0x0704 }
            int r3 = r1.positionForFieldNumber(r2)     // Catch:{ all -> 0x0704 }
            r9 = 0
            if (r3 >= 0) goto L_0x00d8
            r3 = 2147483647(0x7fffffff, float:NaN)
            if (r2 != r3) goto L_0x0040
            int r0 = r1.checkInitializedCount
            r4 = r5
        L_0x001a:
            int r2 = r1.repeatedFieldOffsetStart
            if (r0 >= r2) goto L_0x0033
            int[] r2 = r1.intArray
            r3 = r2[r0]
            r6 = r20
            r5 = r18
            r2 = r20
            java.lang.Object r4 = r1.filterMapUnknownEnumValues(r2, r3, r4, r5, r6)
            r10 = r1
            r1 = r2
            r6 = r5
            int r0 = r0 + 1
            r1 = r10
            goto L_0x001a
        L_0x0033:
            r6 = r18
            r10 = r1
            r1 = r20
            if (r4 == 0) goto L_0x003d
            r6.setBuilderToMessage(r1, r4)
        L_0x003d:
            r1 = r10
            goto L_0x06fa
        L_0x0040:
            r6 = r18
            r10 = r1
            r1 = r20
            boolean r3 = r10.hasExtensions     // Catch:{ all -> 0x00d1 }
            if (r3 != 0) goto L_0x004d
            r7 = r19
            r3 = r8
            goto L_0x0056
        L_0x004d:
            androidx.datastore.preferences.protobuf.MessageLite r3 = r10.defaultInstance     // Catch:{ all -> 0x00d1 }
            r7 = r19
            java.lang.Object r2 = r7.findExtensionByNumber(r4, r3, r2)     // Catch:{ all -> 0x00d1 }
            r3 = r2
        L_0x0056:
            if (r3 == 0) goto L_0x0081
            if (r0 != 0) goto L_0x0065
            androidx.datastore.preferences.protobuf.FieldSet r0 = r19.getMutableExtensions(r20)     // Catch:{ all -> 0x005f }
            goto L_0x0065
        L_0x005f:
            r0 = move-exception
            r2 = r1
            r1 = r10
            r10 = r6
            goto L_0x070a
        L_0x0065:
            r2 = r5
            r5 = r0
            r0 = r7
            r7 = r6
            r6 = r2
            r2 = r21
            java.lang.Object r3 = r0.parseExtension(r1, r2, r3, r4, r5, r6, r7)     // Catch:{ all -> 0x0079 }
            r6 = r4
            r0 = r5
            r5 = r7
            r4 = r2
            r2 = r1
            r5 = r3
            r4 = r6
            r1 = r10
            goto L_0x0007
        L_0x0079:
            r0 = move-exception
            r2 = r1
            r11 = r6
            r5 = r7
        L_0x007d:
            r1 = r10
            r10 = r5
            goto L_0x0702
        L_0x0081:
            r2 = r1
            r11 = r5
            r5 = r6
            r6 = r4
            r4 = r21
            boolean r1 = r5.shouldDiscardUnknownFields(r4)     // Catch:{ all -> 0x00cb }
            if (r1 == 0) goto L_0x009a
            boolean r1 = r4.skipField()     // Catch:{ all -> 0x0098 }
            if (r1 == 0) goto L_0x00a8
        L_0x0093:
            r4 = r6
            r1 = r10
            r5 = r11
            goto L_0x0007
        L_0x0098:
            r0 = move-exception
            goto L_0x007d
        L_0x009a:
            if (r11 != 0) goto L_0x00a1
            java.lang.Object r1 = r5.getBuilderFromMessage(r2)     // Catch:{ all -> 0x0098 }
            r11 = r1
        L_0x00a1:
            boolean r1 = r5.mergeOneFieldFrom(r11, r4, r9)     // Catch:{ all -> 0x00cb }
            if (r1 == 0) goto L_0x00a8
            goto L_0x0093
        L_0x00a8:
            int r0 = r10.checkInitializedCount
            r4 = r11
        L_0x00ab:
            int r1 = r10.repeatedFieldOffsetStart
            if (r0 >= r1) goto L_0x00c1
            int[] r1 = r10.intArray
            r3 = r1[r0]
            r6 = r20
            r1 = r10
            java.lang.Object r4 = r1.filterMapUnknownEnumValues(r2, r3, r4, r5, r6)
            r10 = r5
            r5 = r2
            int r0 = r0 + 1
            r5 = r10
            r10 = r1
            goto L_0x00ab
        L_0x00c1:
            r1 = r10
            r10 = r5
            r5 = r2
            if (r4 == 0) goto L_0x06fa
            r10.setBuilderToMessage(r5, r4)
            goto L_0x06fa
        L_0x00cb:
            r0 = move-exception
            r1 = r10
            r10 = r5
            r5 = r2
            goto L_0x0702
        L_0x00d1:
            r0 = move-exception
            r11 = r5
            r5 = r1
            r1 = r10
            r10 = r6
            goto L_0x0701
        L_0x00d8:
            r10 = r18
            r6 = r4
            r11 = r5
            r5 = r20
            r4 = r21
            int r7 = r1.typeAndOffsetAt(r3)     // Catch:{ all -> 0x0700 }
            int r12 = type(r7)     // Catch:{ InvalidWireTypeException -> 0x06af }
            switch(r12) {
                case 0: goto L_0x0677;
                case 1: goto L_0x0666;
                case 2: goto L_0x0655;
                case 3: goto L_0x0644;
                case 4: goto L_0x0633;
                case 5: goto L_0x0622;
                case 6: goto L_0x0610;
                case 7: goto L_0x05fe;
                case 8: goto L_0x05f4;
                case 9: goto L_0x05e1;
                case 10: goto L_0x05cf;
                case 11: goto L_0x05bd;
                case 12: goto L_0x0594;
                case 13: goto L_0x0582;
                case 14: goto L_0x0570;
                case 15: goto L_0x055e;
                case 16: goto L_0x054c;
                case 17: goto L_0x0539;
                case 18: goto L_0x0528;
                case 19: goto L_0x0517;
                case 20: goto L_0x0506;
                case 21: goto L_0x04f5;
                case 22: goto L_0x04e4;
                case 23: goto L_0x04d3;
                case 24: goto L_0x04c2;
                case 25: goto L_0x04b1;
                case 26: goto L_0x04aa;
                case 27: goto L_0x0490;
                case 28: goto L_0x0470;
                case 29: goto L_0x045f;
                case 30: goto L_0x041d;
                case 31: goto L_0x0400;
                case 32: goto L_0x03ee;
                case 33: goto L_0x03dc;
                case 34: goto L_0x03ca;
                case 35: goto L_0x03b8;
                case 36: goto L_0x03a5;
                case 37: goto L_0x0392;
                case 38: goto L_0x037f;
                case 39: goto L_0x036c;
                case 40: goto L_0x0359;
                case 41: goto L_0x0346;
                case 42: goto L_0x0333;
                case 43: goto L_0x0320;
                case 44: goto L_0x02ee;
                case 45: goto L_0x02d4;
                case 46: goto L_0x02c3;
                case 47: goto L_0x02b2;
                case 48: goto L_0x02a1;
                case 49: goto L_0x026e;
                case 50: goto L_0x0256;
                case 51: goto L_0x0242;
                case 52: goto L_0x022e;
                case 53: goto L_0x021b;
                case 54: goto L_0x0208;
                case 55: goto L_0x01f5;
                case 56: goto L_0x01e2;
                case 57: goto L_0x01cf;
                case 58: goto L_0x01bc;
                case 59: goto L_0x01b3;
                case 60: goto L_0x01a2;
                case 61: goto L_0x0193;
                case 62: goto L_0x0180;
                case 63: goto L_0x0155;
                case 64: goto L_0x0142;
                case 65: goto L_0x012e;
                case 66: goto L_0x011a;
                case 67: goto L_0x0106;
                case 68: goto L_0x00f4;
                default: goto L_0x00eb;
            }
        L_0x00eb:
            r2 = r5
            if (r11 != 0) goto L_0x068d
            java.lang.Object r5 = r10.getBuilderFromMessage(r2)     // Catch:{ InvalidWireTypeException -> 0x06b0, all -> 0x068a }
            goto L_0x068e
        L_0x00f4:
            java.lang.Object r7 = r1.mutableOneofMessageFieldForMerge(r5, r2, r3)     // Catch:{ InvalidWireTypeException -> 0x06af }
            androidx.datastore.preferences.protobuf.MessageLite r7 = (androidx.datastore.preferences.protobuf.MessageLite) r7     // Catch:{ InvalidWireTypeException -> 0x06af }
            androidx.datastore.preferences.protobuf.Schema r12 = r1.getMessageFieldSchema(r3)     // Catch:{ InvalidWireTypeException -> 0x06af }
            r4.mergeGroupField(r7, r12, r6)     // Catch:{ InvalidWireTypeException -> 0x06af }
            r1.storeOneofMessageField(r5, r2, r3, r7)     // Catch:{ InvalidWireTypeException -> 0x06af }
            goto L_0x01b9
        L_0x0106:
            long r12 = offset(r7)     // Catch:{ InvalidWireTypeException -> 0x06af }
            long r14 = r4.readSInt64()     // Catch:{ InvalidWireTypeException -> 0x06af }
            java.lang.Long r7 = java.lang.Long.valueOf(r14)     // Catch:{ InvalidWireTypeException -> 0x06af }
            androidx.datastore.preferences.protobuf.UnsafeUtil.putObject((java.lang.Object) r5, (long) r12, (java.lang.Object) r7)     // Catch:{ InvalidWireTypeException -> 0x06af }
            r1.setOneofPresent(r5, r2, r3)     // Catch:{ InvalidWireTypeException -> 0x06af }
            goto L_0x01b9
        L_0x011a:
            long r12 = offset(r7)     // Catch:{ InvalidWireTypeException -> 0x06af }
            int r7 = r4.readSInt32()     // Catch:{ InvalidWireTypeException -> 0x06af }
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)     // Catch:{ InvalidWireTypeException -> 0x06af }
            androidx.datastore.preferences.protobuf.UnsafeUtil.putObject((java.lang.Object) r5, (long) r12, (java.lang.Object) r7)     // Catch:{ InvalidWireTypeException -> 0x06af }
            r1.setOneofPresent(r5, r2, r3)     // Catch:{ InvalidWireTypeException -> 0x06af }
            goto L_0x01b9
        L_0x012e:
            long r12 = offset(r7)     // Catch:{ InvalidWireTypeException -> 0x06af }
            long r14 = r4.readSFixed64()     // Catch:{ InvalidWireTypeException -> 0x06af }
            java.lang.Long r7 = java.lang.Long.valueOf(r14)     // Catch:{ InvalidWireTypeException -> 0x06af }
            androidx.datastore.preferences.protobuf.UnsafeUtil.putObject((java.lang.Object) r5, (long) r12, (java.lang.Object) r7)     // Catch:{ InvalidWireTypeException -> 0x06af }
            r1.setOneofPresent(r5, r2, r3)     // Catch:{ InvalidWireTypeException -> 0x06af }
            goto L_0x01b9
        L_0x0142:
            long r12 = offset(r7)     // Catch:{ InvalidWireTypeException -> 0x06af }
            int r7 = r4.readSFixed32()     // Catch:{ InvalidWireTypeException -> 0x06af }
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)     // Catch:{ InvalidWireTypeException -> 0x06af }
            androidx.datastore.preferences.protobuf.UnsafeUtil.putObject((java.lang.Object) r5, (long) r12, (java.lang.Object) r7)     // Catch:{ InvalidWireTypeException -> 0x06af }
            r1.setOneofPresent(r5, r2, r3)     // Catch:{ InvalidWireTypeException -> 0x06af }
            goto L_0x01b9
        L_0x0155:
            int r12 = r4.readEnum()     // Catch:{ InvalidWireTypeException -> 0x06af }
            androidx.datastore.preferences.protobuf.Internal$EnumVerifier r13 = r1.getEnumFieldVerifier(r3)     // Catch:{ InvalidWireTypeException -> 0x06af }
            if (r13 == 0) goto L_0x0171
            boolean r13 = r13.isInRange(r12)     // Catch:{ InvalidWireTypeException -> 0x06af }
            if (r13 == 0) goto L_0x0166
            goto L_0x0171
        L_0x0166:
            java.lang.Object r2 = androidx.datastore.preferences.protobuf.SchemaUtil.storeUnknownEnum(r5, r2, r12, r11, r10)     // Catch:{ InvalidWireTypeException -> 0x06af }
            r16 = r5
            r5 = r2
            r2 = r16
            goto L_0x06fb
        L_0x0171:
            long r13 = offset(r7)     // Catch:{ InvalidWireTypeException -> 0x06af }
            java.lang.Integer r7 = java.lang.Integer.valueOf(r12)     // Catch:{ InvalidWireTypeException -> 0x06af }
            androidx.datastore.preferences.protobuf.UnsafeUtil.putObject((java.lang.Object) r5, (long) r13, (java.lang.Object) r7)     // Catch:{ InvalidWireTypeException -> 0x06af }
            r1.setOneofPresent(r5, r2, r3)     // Catch:{ InvalidWireTypeException -> 0x06af }
            goto L_0x01b9
        L_0x0180:
            long r12 = offset(r7)     // Catch:{ InvalidWireTypeException -> 0x06af }
            int r7 = r4.readUInt32()     // Catch:{ InvalidWireTypeException -> 0x06af }
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)     // Catch:{ InvalidWireTypeException -> 0x06af }
            androidx.datastore.preferences.protobuf.UnsafeUtil.putObject((java.lang.Object) r5, (long) r12, (java.lang.Object) r7)     // Catch:{ InvalidWireTypeException -> 0x06af }
            r1.setOneofPresent(r5, r2, r3)     // Catch:{ InvalidWireTypeException -> 0x06af }
            goto L_0x01b9
        L_0x0193:
            long r12 = offset(r7)     // Catch:{ InvalidWireTypeException -> 0x06af }
            androidx.datastore.preferences.protobuf.ByteString r7 = r4.readBytes()     // Catch:{ InvalidWireTypeException -> 0x06af }
            androidx.datastore.preferences.protobuf.UnsafeUtil.putObject((java.lang.Object) r5, (long) r12, (java.lang.Object) r7)     // Catch:{ InvalidWireTypeException -> 0x06af }
            r1.setOneofPresent(r5, r2, r3)     // Catch:{ InvalidWireTypeException -> 0x06af }
            goto L_0x01b9
        L_0x01a2:
            java.lang.Object r7 = r1.mutableOneofMessageFieldForMerge(r5, r2, r3)     // Catch:{ InvalidWireTypeException -> 0x06af }
            androidx.datastore.preferences.protobuf.MessageLite r7 = (androidx.datastore.preferences.protobuf.MessageLite) r7     // Catch:{ InvalidWireTypeException -> 0x06af }
            androidx.datastore.preferences.protobuf.Schema r12 = r1.getMessageFieldSchema(r3)     // Catch:{ InvalidWireTypeException -> 0x06af }
            r4.mergeMessageField(r7, r12, r6)     // Catch:{ InvalidWireTypeException -> 0x06af }
            r1.storeOneofMessageField(r5, r2, r3, r7)     // Catch:{ InvalidWireTypeException -> 0x06af }
            goto L_0x01b9
        L_0x01b3:
            r1.readString(r5, r7, r4)     // Catch:{ InvalidWireTypeException -> 0x06af }
            r1.setOneofPresent(r5, r2, r3)     // Catch:{ InvalidWireTypeException -> 0x06af }
        L_0x01b9:
            r2 = r5
            goto L_0x0687
        L_0x01bc:
            long r12 = offset(r7)     // Catch:{ InvalidWireTypeException -> 0x06af }
            boolean r7 = r4.readBool()     // Catch:{ InvalidWireTypeException -> 0x06af }
            java.lang.Boolean r7 = java.lang.Boolean.valueOf(r7)     // Catch:{ InvalidWireTypeException -> 0x06af }
            androidx.datastore.preferences.protobuf.UnsafeUtil.putObject((java.lang.Object) r5, (long) r12, (java.lang.Object) r7)     // Catch:{ InvalidWireTypeException -> 0x06af }
            r1.setOneofPresent(r5, r2, r3)     // Catch:{ InvalidWireTypeException -> 0x06af }
            goto L_0x01b9
        L_0x01cf:
            long r12 = offset(r7)     // Catch:{ InvalidWireTypeException -> 0x06af }
            int r7 = r4.readFixed32()     // Catch:{ InvalidWireTypeException -> 0x06af }
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)     // Catch:{ InvalidWireTypeException -> 0x06af }
            androidx.datastore.preferences.protobuf.UnsafeUtil.putObject((java.lang.Object) r5, (long) r12, (java.lang.Object) r7)     // Catch:{ InvalidWireTypeException -> 0x06af }
            r1.setOneofPresent(r5, r2, r3)     // Catch:{ InvalidWireTypeException -> 0x06af }
            goto L_0x01b9
        L_0x01e2:
            long r12 = offset(r7)     // Catch:{ InvalidWireTypeException -> 0x06af }
            long r14 = r4.readFixed64()     // Catch:{ InvalidWireTypeException -> 0x06af }
            java.lang.Long r7 = java.lang.Long.valueOf(r14)     // Catch:{ InvalidWireTypeException -> 0x06af }
            androidx.datastore.preferences.protobuf.UnsafeUtil.putObject((java.lang.Object) r5, (long) r12, (java.lang.Object) r7)     // Catch:{ InvalidWireTypeException -> 0x06af }
            r1.setOneofPresent(r5, r2, r3)     // Catch:{ InvalidWireTypeException -> 0x06af }
            goto L_0x01b9
        L_0x01f5:
            long r12 = offset(r7)     // Catch:{ InvalidWireTypeException -> 0x06af }
            int r7 = r4.readInt32()     // Catch:{ InvalidWireTypeException -> 0x06af }
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)     // Catch:{ InvalidWireTypeException -> 0x06af }
            androidx.datastore.preferences.protobuf.UnsafeUtil.putObject((java.lang.Object) r5, (long) r12, (java.lang.Object) r7)     // Catch:{ InvalidWireTypeException -> 0x06af }
            r1.setOneofPresent(r5, r2, r3)     // Catch:{ InvalidWireTypeException -> 0x06af }
            goto L_0x01b9
        L_0x0208:
            long r12 = offset(r7)     // Catch:{ InvalidWireTypeException -> 0x06af }
            long r14 = r4.readUInt64()     // Catch:{ InvalidWireTypeException -> 0x06af }
            java.lang.Long r7 = java.lang.Long.valueOf(r14)     // Catch:{ InvalidWireTypeException -> 0x06af }
            androidx.datastore.preferences.protobuf.UnsafeUtil.putObject((java.lang.Object) r5, (long) r12, (java.lang.Object) r7)     // Catch:{ InvalidWireTypeException -> 0x06af }
            r1.setOneofPresent(r5, r2, r3)     // Catch:{ InvalidWireTypeException -> 0x06af }
            goto L_0x01b9
        L_0x021b:
            long r12 = offset(r7)     // Catch:{ InvalidWireTypeException -> 0x06af }
            long r14 = r4.readInt64()     // Catch:{ InvalidWireTypeException -> 0x06af }
            java.lang.Long r7 = java.lang.Long.valueOf(r14)     // Catch:{ InvalidWireTypeException -> 0x06af }
            androidx.datastore.preferences.protobuf.UnsafeUtil.putObject((java.lang.Object) r5, (long) r12, (java.lang.Object) r7)     // Catch:{ InvalidWireTypeException -> 0x06af }
            r1.setOneofPresent(r5, r2, r3)     // Catch:{ InvalidWireTypeException -> 0x06af }
            goto L_0x01b9
        L_0x022e:
            long r12 = offset(r7)     // Catch:{ InvalidWireTypeException -> 0x06af }
            float r7 = r4.readFloat()     // Catch:{ InvalidWireTypeException -> 0x06af }
            java.lang.Float r7 = java.lang.Float.valueOf(r7)     // Catch:{ InvalidWireTypeException -> 0x06af }
            androidx.datastore.preferences.protobuf.UnsafeUtil.putObject((java.lang.Object) r5, (long) r12, (java.lang.Object) r7)     // Catch:{ InvalidWireTypeException -> 0x06af }
            r1.setOneofPresent(r5, r2, r3)     // Catch:{ InvalidWireTypeException -> 0x06af }
            goto L_0x01b9
        L_0x0242:
            long r12 = offset(r7)     // Catch:{ InvalidWireTypeException -> 0x06af }
            double r14 = r4.readDouble()     // Catch:{ InvalidWireTypeException -> 0x06af }
            java.lang.Double r7 = java.lang.Double.valueOf(r14)     // Catch:{ InvalidWireTypeException -> 0x06af }
            androidx.datastore.preferences.protobuf.UnsafeUtil.putObject((java.lang.Object) r5, (long) r12, (java.lang.Object) r7)     // Catch:{ InvalidWireTypeException -> 0x06af }
            r1.setOneofPresent(r5, r2, r3)     // Catch:{ InvalidWireTypeException -> 0x06af }
            goto L_0x01b9
        L_0x0256:
            java.lang.Object r4 = r1.getMapFieldDefaultEntry(r3)     // Catch:{ InvalidWireTypeException -> 0x0299, all -> 0x0269 }
            r2 = r5
            r5 = r6
            r6 = r21
            r1.mergeMap(r2, r3, r4, r5, r6)     // Catch:{ InvalidWireTypeException -> 0x0299, all -> 0x0269 }
            r2 = r20
            r4 = r21
            r6 = r22
            goto L_0x0687
        L_0x0269:
            r0 = move-exception
            r2 = r20
            goto L_0x0702
        L_0x026e:
            long r4 = offset(r7)     // Catch:{ InvalidWireTypeException -> 0x0299, all -> 0x0294 }
            androidx.datastore.preferences.protobuf.Schema r6 = r1.getMessageFieldSchema(r3)     // Catch:{ InvalidWireTypeException -> 0x0299, all -> 0x0294 }
            r2 = r20
            r7 = r22
            r3 = r4
            r5 = r21
            r1.readGroupList(r2, r3, r5, r6, r7)     // Catch:{ InvalidWireTypeException -> 0x028f, all -> 0x028a }
            r12 = r1
            r1 = r2
            r13 = r5
        L_0x0283:
            r6 = r22
            r2 = r1
        L_0x0286:
            r1 = r12
            r4 = r13
            goto L_0x0687
        L_0x028a:
            r0 = move-exception
            r12 = r1
            r1 = r2
            goto L_0x0485
        L_0x028f:
            r6 = r22
            r4 = r5
            goto L_0x06b0
        L_0x0294:
            r0 = move-exception
            r12 = r1
            r1 = r20
            goto L_0x02e6
        L_0x0299:
            r2 = r20
            r4 = r21
            r6 = r22
            goto L_0x06b0
        L_0x02a1:
            r12 = r1
            r13 = r4
            r1 = r5
            androidx.datastore.preferences.protobuf.ListFieldSchema r2 = r12.listFieldSchema     // Catch:{ InvalidWireTypeException -> 0x02e9, all -> 0x02e5 }
            long r3 = offset(r7)     // Catch:{ InvalidWireTypeException -> 0x02e9, all -> 0x02e5 }
            java.util.List r2 = r2.mutableListAt(r1, r3)     // Catch:{ InvalidWireTypeException -> 0x02e9, all -> 0x02e5 }
            r13.readSInt64List(r2)     // Catch:{ InvalidWireTypeException -> 0x02e9, all -> 0x02e5 }
            goto L_0x0283
        L_0x02b2:
            r12 = r1
            r13 = r4
            r1 = r5
            androidx.datastore.preferences.protobuf.ListFieldSchema r2 = r12.listFieldSchema     // Catch:{ InvalidWireTypeException -> 0x02e9, all -> 0x02e5 }
            long r3 = offset(r7)     // Catch:{ InvalidWireTypeException -> 0x02e9, all -> 0x02e5 }
            java.util.List r2 = r2.mutableListAt(r1, r3)     // Catch:{ InvalidWireTypeException -> 0x02e9, all -> 0x02e5 }
            r13.readSInt32List(r2)     // Catch:{ InvalidWireTypeException -> 0x02e9, all -> 0x02e5 }
            goto L_0x0283
        L_0x02c3:
            r12 = r1
            r13 = r4
            r1 = r5
            androidx.datastore.preferences.protobuf.ListFieldSchema r2 = r12.listFieldSchema     // Catch:{ InvalidWireTypeException -> 0x02e9, all -> 0x02e5 }
            long r3 = offset(r7)     // Catch:{ InvalidWireTypeException -> 0x02e9, all -> 0x02e5 }
            java.util.List r2 = r2.mutableListAt(r1, r3)     // Catch:{ InvalidWireTypeException -> 0x02e9, all -> 0x02e5 }
            r13.readSFixed64List(r2)     // Catch:{ InvalidWireTypeException -> 0x02e9, all -> 0x02e5 }
            goto L_0x0283
        L_0x02d4:
            r12 = r1
            r13 = r4
            r1 = r5
            androidx.datastore.preferences.protobuf.ListFieldSchema r2 = r12.listFieldSchema     // Catch:{ InvalidWireTypeException -> 0x02e9, all -> 0x02e5 }
            long r3 = offset(r7)     // Catch:{ InvalidWireTypeException -> 0x02e9, all -> 0x02e5 }
            java.util.List r2 = r2.mutableListAt(r1, r3)     // Catch:{ InvalidWireTypeException -> 0x02e9, all -> 0x02e5 }
            r13.readSFixed32List(r2)     // Catch:{ InvalidWireTypeException -> 0x02e9, all -> 0x02e5 }
            goto L_0x0283
        L_0x02e5:
            r0 = move-exception
        L_0x02e6:
            r2 = r1
            goto L_0x0485
        L_0x02e9:
            r6 = r22
            r2 = r1
            goto L_0x048b
        L_0x02ee:
            r12 = r1
            r13 = r4
            r1 = r5
            androidx.datastore.preferences.protobuf.ListFieldSchema r4 = r12.listFieldSchema     // Catch:{ InvalidWireTypeException -> 0x0318, all -> 0x0313 }
            long r5 = offset(r7)     // Catch:{ InvalidWireTypeException -> 0x0318, all -> 0x0313 }
            java.util.List r4 = r4.mutableListAt(r1, r5)     // Catch:{ InvalidWireTypeException -> 0x0318, all -> 0x0313 }
            r13.readEnumList(r4)     // Catch:{ InvalidWireTypeException -> 0x0318, all -> 0x0313 }
            r5 = r4
            androidx.datastore.preferences.protobuf.Internal$EnumVerifier r4 = r12.getEnumFieldVerifier(r3)     // Catch:{ InvalidWireTypeException -> 0x0318, all -> 0x0313 }
            r3 = r5
            r6 = r10
            r5 = r11
            java.lang.Object r5 = androidx.datastore.preferences.protobuf.SchemaUtil.filterUnknownEnumList((java.lang.Object) r1, (int) r2, (java.util.List<java.lang.Integer>) r3, (androidx.datastore.preferences.protobuf.Internal.EnumVerifier) r4, r5, r6)     // Catch:{ InvalidWireTypeException -> 0x0319, all -> 0x030f }
            r2 = r1
            r10 = r18
            goto L_0x0440
        L_0x030f:
            r0 = move-exception
            r2 = r1
            goto L_0x0419
        L_0x0313:
            r0 = move-exception
            r2 = r1
            r5 = r11
            goto L_0x0419
        L_0x0318:
            r5 = r11
        L_0x0319:
            r10 = r18
            r6 = r22
            r2 = r1
            goto L_0x048c
        L_0x0320:
            r12 = r1
            r13 = r4
            r2 = r5
            r5 = r11
            androidx.datastore.preferences.protobuf.ListFieldSchema r1 = r12.listFieldSchema     // Catch:{ InvalidWireTypeException -> 0x045a, all -> 0x0418 }
            long r3 = offset(r7)     // Catch:{ InvalidWireTypeException -> 0x045a, all -> 0x0418 }
            java.util.List r1 = r1.mutableListAt(r2, r3)     // Catch:{ InvalidWireTypeException -> 0x045a, all -> 0x0418 }
            r13.readUInt32List(r1)     // Catch:{ InvalidWireTypeException -> 0x045a, all -> 0x0418 }
            goto L_0x0411
        L_0x0333:
            r12 = r1
            r13 = r4
            r2 = r5
            r5 = r11
            androidx.datastore.preferences.protobuf.ListFieldSchema r1 = r12.listFieldSchema     // Catch:{ InvalidWireTypeException -> 0x045a, all -> 0x0418 }
            long r3 = offset(r7)     // Catch:{ InvalidWireTypeException -> 0x045a, all -> 0x0418 }
            java.util.List r1 = r1.mutableListAt(r2, r3)     // Catch:{ InvalidWireTypeException -> 0x045a, all -> 0x0418 }
            r13.readBoolList(r1)     // Catch:{ InvalidWireTypeException -> 0x045a, all -> 0x0418 }
            goto L_0x0411
        L_0x0346:
            r12 = r1
            r13 = r4
            r2 = r5
            r5 = r11
            androidx.datastore.preferences.protobuf.ListFieldSchema r1 = r12.listFieldSchema     // Catch:{ InvalidWireTypeException -> 0x045a, all -> 0x0418 }
            long r3 = offset(r7)     // Catch:{ InvalidWireTypeException -> 0x045a, all -> 0x0418 }
            java.util.List r1 = r1.mutableListAt(r2, r3)     // Catch:{ InvalidWireTypeException -> 0x045a, all -> 0x0418 }
            r13.readFixed32List(r1)     // Catch:{ InvalidWireTypeException -> 0x045a, all -> 0x0418 }
            goto L_0x0411
        L_0x0359:
            r12 = r1
            r13 = r4
            r2 = r5
            r5 = r11
            androidx.datastore.preferences.protobuf.ListFieldSchema r1 = r12.listFieldSchema     // Catch:{ InvalidWireTypeException -> 0x045a, all -> 0x0418 }
            long r3 = offset(r7)     // Catch:{ InvalidWireTypeException -> 0x045a, all -> 0x0418 }
            java.util.List r1 = r1.mutableListAt(r2, r3)     // Catch:{ InvalidWireTypeException -> 0x045a, all -> 0x0418 }
            r13.readFixed64List(r1)     // Catch:{ InvalidWireTypeException -> 0x045a, all -> 0x0418 }
            goto L_0x0411
        L_0x036c:
            r12 = r1
            r13 = r4
            r2 = r5
            r5 = r11
            androidx.datastore.preferences.protobuf.ListFieldSchema r1 = r12.listFieldSchema     // Catch:{ InvalidWireTypeException -> 0x045a, all -> 0x0418 }
            long r3 = offset(r7)     // Catch:{ InvalidWireTypeException -> 0x045a, all -> 0x0418 }
            java.util.List r1 = r1.mutableListAt(r2, r3)     // Catch:{ InvalidWireTypeException -> 0x045a, all -> 0x0418 }
            r13.readInt32List(r1)     // Catch:{ InvalidWireTypeException -> 0x045a, all -> 0x0418 }
            goto L_0x0411
        L_0x037f:
            r12 = r1
            r13 = r4
            r2 = r5
            r5 = r11
            androidx.datastore.preferences.protobuf.ListFieldSchema r1 = r12.listFieldSchema     // Catch:{ InvalidWireTypeException -> 0x045a, all -> 0x0418 }
            long r3 = offset(r7)     // Catch:{ InvalidWireTypeException -> 0x045a, all -> 0x0418 }
            java.util.List r1 = r1.mutableListAt(r2, r3)     // Catch:{ InvalidWireTypeException -> 0x045a, all -> 0x0418 }
            r13.readUInt64List(r1)     // Catch:{ InvalidWireTypeException -> 0x045a, all -> 0x0418 }
            goto L_0x0411
        L_0x0392:
            r12 = r1
            r13 = r4
            r2 = r5
            r5 = r11
            androidx.datastore.preferences.protobuf.ListFieldSchema r1 = r12.listFieldSchema     // Catch:{ InvalidWireTypeException -> 0x045a, all -> 0x0418 }
            long r3 = offset(r7)     // Catch:{ InvalidWireTypeException -> 0x045a, all -> 0x0418 }
            java.util.List r1 = r1.mutableListAt(r2, r3)     // Catch:{ InvalidWireTypeException -> 0x045a, all -> 0x0418 }
            r13.readInt64List(r1)     // Catch:{ InvalidWireTypeException -> 0x045a, all -> 0x0418 }
            goto L_0x0411
        L_0x03a5:
            r12 = r1
            r13 = r4
            r2 = r5
            r5 = r11
            androidx.datastore.preferences.protobuf.ListFieldSchema r1 = r12.listFieldSchema     // Catch:{ InvalidWireTypeException -> 0x045a, all -> 0x0418 }
            long r3 = offset(r7)     // Catch:{ InvalidWireTypeException -> 0x045a, all -> 0x0418 }
            java.util.List r1 = r1.mutableListAt(r2, r3)     // Catch:{ InvalidWireTypeException -> 0x045a, all -> 0x0418 }
            r13.readFloatList(r1)     // Catch:{ InvalidWireTypeException -> 0x045a, all -> 0x0418 }
            goto L_0x0411
        L_0x03b8:
            r12 = r1
            r13 = r4
            r2 = r5
            r5 = r11
            androidx.datastore.preferences.protobuf.ListFieldSchema r1 = r12.listFieldSchema     // Catch:{ InvalidWireTypeException -> 0x045a, all -> 0x0418 }
            long r3 = offset(r7)     // Catch:{ InvalidWireTypeException -> 0x045a, all -> 0x0418 }
            java.util.List r1 = r1.mutableListAt(r2, r3)     // Catch:{ InvalidWireTypeException -> 0x045a, all -> 0x0418 }
            r13.readDoubleList(r1)     // Catch:{ InvalidWireTypeException -> 0x045a, all -> 0x0418 }
            goto L_0x0411
        L_0x03ca:
            r12 = r1
            r13 = r4
            r2 = r5
            r5 = r11
            androidx.datastore.preferences.protobuf.ListFieldSchema r1 = r12.listFieldSchema     // Catch:{ InvalidWireTypeException -> 0x045a, all -> 0x0418 }
            long r3 = offset(r7)     // Catch:{ InvalidWireTypeException -> 0x045a, all -> 0x0418 }
            java.util.List r1 = r1.mutableListAt(r2, r3)     // Catch:{ InvalidWireTypeException -> 0x045a, all -> 0x0418 }
            r13.readSInt64List(r1)     // Catch:{ InvalidWireTypeException -> 0x045a, all -> 0x0418 }
            goto L_0x0411
        L_0x03dc:
            r12 = r1
            r13 = r4
            r2 = r5
            r5 = r11
            androidx.datastore.preferences.protobuf.ListFieldSchema r1 = r12.listFieldSchema     // Catch:{ InvalidWireTypeException -> 0x045a, all -> 0x0418 }
            long r3 = offset(r7)     // Catch:{ InvalidWireTypeException -> 0x045a, all -> 0x0418 }
            java.util.List r1 = r1.mutableListAt(r2, r3)     // Catch:{ InvalidWireTypeException -> 0x045a, all -> 0x0418 }
            r13.readSInt32List(r1)     // Catch:{ InvalidWireTypeException -> 0x045a, all -> 0x0418 }
            goto L_0x0411
        L_0x03ee:
            r12 = r1
            r13 = r4
            r2 = r5
            r5 = r11
            androidx.datastore.preferences.protobuf.ListFieldSchema r1 = r12.listFieldSchema     // Catch:{ InvalidWireTypeException -> 0x045a, all -> 0x0418 }
            long r3 = offset(r7)     // Catch:{ InvalidWireTypeException -> 0x045a, all -> 0x0418 }
            java.util.List r1 = r1.mutableListAt(r2, r3)     // Catch:{ InvalidWireTypeException -> 0x045a, all -> 0x0418 }
            r13.readSFixed64List(r1)     // Catch:{ InvalidWireTypeException -> 0x045a, all -> 0x0418 }
            goto L_0x0411
        L_0x0400:
            r12 = r1
            r13 = r4
            r2 = r5
            r5 = r11
            androidx.datastore.preferences.protobuf.ListFieldSchema r1 = r12.listFieldSchema     // Catch:{ InvalidWireTypeException -> 0x045a, all -> 0x0418 }
            long r3 = offset(r7)     // Catch:{ InvalidWireTypeException -> 0x045a, all -> 0x0418 }
            java.util.List r1 = r1.mutableListAt(r2, r3)     // Catch:{ InvalidWireTypeException -> 0x045a, all -> 0x0418 }
            r13.readSFixed32List(r1)     // Catch:{ InvalidWireTypeException -> 0x045a, all -> 0x0418 }
        L_0x0411:
            r10 = r18
            r6 = r22
            r11 = r5
            goto L_0x0286
        L_0x0418:
            r0 = move-exception
        L_0x0419:
            r10 = r18
            goto L_0x0486
        L_0x041d:
            r12 = r1
            r1 = r2
            r13 = r4
            r2 = r5
            r5 = r11
            androidx.datastore.preferences.protobuf.ListFieldSchema r4 = r12.listFieldSchema     // Catch:{ InvalidWireTypeException -> 0x0459, all -> 0x0454 }
            long r6 = offset(r7)     // Catch:{ InvalidWireTypeException -> 0x0459, all -> 0x0454 }
            java.util.List r4 = r4.mutableListAt(r2, r6)     // Catch:{ InvalidWireTypeException -> 0x0459, all -> 0x0454 }
            r13.readEnumList(r4)     // Catch:{ InvalidWireTypeException -> 0x0459, all -> 0x0454 }
            r6 = r4
            androidx.datastore.preferences.protobuf.Internal$EnumVerifier r4 = r12.getEnumFieldVerifier(r3)     // Catch:{ InvalidWireTypeException -> 0x0459, all -> 0x0454 }
            r3 = r2
            r2 = r1
            r1 = r3
            r3 = r6
            r6 = r18
            java.lang.Object r5 = androidx.datastore.preferences.protobuf.SchemaUtil.filterUnknownEnumList((java.lang.Object) r1, (int) r2, (java.util.List<java.lang.Integer>) r3, (androidx.datastore.preferences.protobuf.Internal.EnumVerifier) r4, r5, r6)     // Catch:{ InvalidWireTypeException -> 0x044b, all -> 0x0446 }
            r2 = r1
            r10 = r6
        L_0x0440:
            r6 = r22
            r1 = r12
            r4 = r13
            goto L_0x06fb
        L_0x0446:
            r0 = move-exception
            r2 = r1
            r11 = r5
            r10 = r6
            goto L_0x0486
        L_0x044b:
            r11 = r5
            r2 = r1
            r10 = r6
            r1 = r12
            r4 = r13
            r6 = r22
            goto L_0x06b1
        L_0x0454:
            r0 = move-exception
            r10 = r18
            r11 = r5
            goto L_0x0486
        L_0x0459:
            r11 = r5
        L_0x045a:
            r10 = r18
            r6 = r22
            goto L_0x048c
        L_0x045f:
            r12 = r1
            r13 = r4
            r2 = r5
            androidx.datastore.preferences.protobuf.ListFieldSchema r1 = r12.listFieldSchema     // Catch:{ InvalidWireTypeException -> 0x0489, all -> 0x0484 }
            long r3 = offset(r7)     // Catch:{ InvalidWireTypeException -> 0x0489, all -> 0x0484 }
            java.util.List r1 = r1.mutableListAt(r2, r3)     // Catch:{ InvalidWireTypeException -> 0x0489, all -> 0x0484 }
            r13.readUInt32List(r1)     // Catch:{ InvalidWireTypeException -> 0x0489, all -> 0x0484 }
            goto L_0x0480
        L_0x0470:
            r12 = r1
            r13 = r4
            r2 = r5
            androidx.datastore.preferences.protobuf.ListFieldSchema r1 = r12.listFieldSchema     // Catch:{ InvalidWireTypeException -> 0x0489, all -> 0x0484 }
            long r3 = offset(r7)     // Catch:{ InvalidWireTypeException -> 0x0489, all -> 0x0484 }
            java.util.List r1 = r1.mutableListAt(r2, r3)     // Catch:{ InvalidWireTypeException -> 0x0489, all -> 0x0484 }
            r13.readBytesList(r1)     // Catch:{ InvalidWireTypeException -> 0x0489, all -> 0x0484 }
        L_0x0480:
            r6 = r22
            goto L_0x0286
        L_0x0484:
            r0 = move-exception
        L_0x0485:
            r5 = r11
        L_0x0486:
            r1 = r12
            goto L_0x070a
        L_0x0489:
            r6 = r22
        L_0x048b:
            r5 = r11
        L_0x048c:
            r1 = r12
            r4 = r13
            goto L_0x06b1
        L_0x0490:
            r12 = r1
            r13 = r4
            r2 = r5
            androidx.datastore.preferences.protobuf.Schema r5 = r12.getMessageFieldSchema(r3)     // Catch:{ InvalidWireTypeException -> 0x04a3, all -> 0x049f }
            r6 = r22
            r3 = r7
            r1.readMessageList(r2, r3, r4, r5, r6)     // Catch:{ InvalidWireTypeException -> 0x06b0, all -> 0x068a }
            goto L_0x0687
        L_0x049f:
            r0 = move-exception
            r1 = r12
            goto L_0x0702
        L_0x04a3:
            r6 = r22
            r4 = r13
            r5 = r11
            r1 = r12
            goto L_0x06b1
        L_0x04aa:
            r2 = r5
            r5 = r7
            r1.readStringList(r2, r5, r4)     // Catch:{ InvalidWireTypeException -> 0x06b0, all -> 0x068a }
            goto L_0x0687
        L_0x04b1:
            r2 = r5
            r5 = r7
            androidx.datastore.preferences.protobuf.ListFieldSchema r3 = r1.listFieldSchema     // Catch:{ InvalidWireTypeException -> 0x06b0, all -> 0x068a }
            long r12 = offset(r5)     // Catch:{ InvalidWireTypeException -> 0x06b0, all -> 0x068a }
            java.util.List r3 = r3.mutableListAt(r2, r12)     // Catch:{ InvalidWireTypeException -> 0x06b0, all -> 0x068a }
            r4.readBoolList(r3)     // Catch:{ InvalidWireTypeException -> 0x06b0, all -> 0x068a }
            goto L_0x0687
        L_0x04c2:
            r2 = r5
            r5 = r7
            androidx.datastore.preferences.protobuf.ListFieldSchema r3 = r1.listFieldSchema     // Catch:{ InvalidWireTypeException -> 0x06b0, all -> 0x068a }
            long r12 = offset(r5)     // Catch:{ InvalidWireTypeException -> 0x06b0, all -> 0x068a }
            java.util.List r3 = r3.mutableListAt(r2, r12)     // Catch:{ InvalidWireTypeException -> 0x06b0, all -> 0x068a }
            r4.readFixed32List(r3)     // Catch:{ InvalidWireTypeException -> 0x06b0, all -> 0x068a }
            goto L_0x0687
        L_0x04d3:
            r2 = r5
            r5 = r7
            androidx.datastore.preferences.protobuf.ListFieldSchema r3 = r1.listFieldSchema     // Catch:{ InvalidWireTypeException -> 0x06b0, all -> 0x068a }
            long r12 = offset(r5)     // Catch:{ InvalidWireTypeException -> 0x06b0, all -> 0x068a }
            java.util.List r3 = r3.mutableListAt(r2, r12)     // Catch:{ InvalidWireTypeException -> 0x06b0, all -> 0x068a }
            r4.readFixed64List(r3)     // Catch:{ InvalidWireTypeException -> 0x06b0, all -> 0x068a }
            goto L_0x0687
        L_0x04e4:
            r2 = r5
            r5 = r7
            androidx.datastore.preferences.protobuf.ListFieldSchema r3 = r1.listFieldSchema     // Catch:{ InvalidWireTypeException -> 0x06b0, all -> 0x068a }
            long r12 = offset(r5)     // Catch:{ InvalidWireTypeException -> 0x06b0, all -> 0x068a }
            java.util.List r3 = r3.mutableListAt(r2, r12)     // Catch:{ InvalidWireTypeException -> 0x06b0, all -> 0x068a }
            r4.readInt32List(r3)     // Catch:{ InvalidWireTypeException -> 0x06b0, all -> 0x068a }
            goto L_0x0687
        L_0x04f5:
            r2 = r5
            r5 = r7
            androidx.datastore.preferences.protobuf.ListFieldSchema r3 = r1.listFieldSchema     // Catch:{ InvalidWireTypeException -> 0x06b0, all -> 0x068a }
            long r12 = offset(r5)     // Catch:{ InvalidWireTypeException -> 0x06b0, all -> 0x068a }
            java.util.List r3 = r3.mutableListAt(r2, r12)     // Catch:{ InvalidWireTypeException -> 0x06b0, all -> 0x068a }
            r4.readUInt64List(r3)     // Catch:{ InvalidWireTypeException -> 0x06b0, all -> 0x068a }
            goto L_0x0687
        L_0x0506:
            r2 = r5
            r5 = r7
            androidx.datastore.preferences.protobuf.ListFieldSchema r3 = r1.listFieldSchema     // Catch:{ InvalidWireTypeException -> 0x06b0, all -> 0x068a }
            long r12 = offset(r5)     // Catch:{ InvalidWireTypeException -> 0x06b0, all -> 0x068a }
            java.util.List r3 = r3.mutableListAt(r2, r12)     // Catch:{ InvalidWireTypeException -> 0x06b0, all -> 0x068a }
            r4.readInt64List(r3)     // Catch:{ InvalidWireTypeException -> 0x06b0, all -> 0x068a }
            goto L_0x0687
        L_0x0517:
            r2 = r5
            r5 = r7
            androidx.datastore.preferences.protobuf.ListFieldSchema r3 = r1.listFieldSchema     // Catch:{ InvalidWireTypeException -> 0x06b0, all -> 0x068a }
            long r12 = offset(r5)     // Catch:{ InvalidWireTypeException -> 0x06b0, all -> 0x068a }
            java.util.List r3 = r3.mutableListAt(r2, r12)     // Catch:{ InvalidWireTypeException -> 0x06b0, all -> 0x068a }
            r4.readFloatList(r3)     // Catch:{ InvalidWireTypeException -> 0x06b0, all -> 0x068a }
            goto L_0x0687
        L_0x0528:
            r2 = r5
            r5 = r7
            androidx.datastore.preferences.protobuf.ListFieldSchema r3 = r1.listFieldSchema     // Catch:{ InvalidWireTypeException -> 0x06b0, all -> 0x068a }
            long r12 = offset(r5)     // Catch:{ InvalidWireTypeException -> 0x06b0, all -> 0x068a }
            java.util.List r3 = r3.mutableListAt(r2, r12)     // Catch:{ InvalidWireTypeException -> 0x06b0, all -> 0x068a }
            r4.readDoubleList(r3)     // Catch:{ InvalidWireTypeException -> 0x06b0, all -> 0x068a }
            goto L_0x0687
        L_0x0539:
            r2 = r5
            java.lang.Object r5 = r1.mutableMessageFieldForMerge(r2, r3)     // Catch:{ InvalidWireTypeException -> 0x06b0, all -> 0x068a }
            androidx.datastore.preferences.protobuf.MessageLite r5 = (androidx.datastore.preferences.protobuf.MessageLite) r5     // Catch:{ InvalidWireTypeException -> 0x06b0, all -> 0x068a }
            androidx.datastore.preferences.protobuf.Schema r7 = r1.getMessageFieldSchema(r3)     // Catch:{ InvalidWireTypeException -> 0x06b0, all -> 0x068a }
            r4.mergeGroupField(r5, r7, r6)     // Catch:{ InvalidWireTypeException -> 0x06b0, all -> 0x068a }
            r1.storeMessageField(r2, r3, r5)     // Catch:{ InvalidWireTypeException -> 0x06b0, all -> 0x068a }
            goto L_0x0687
        L_0x054c:
            r2 = r5
            r5 = r7
            long r12 = offset(r5)     // Catch:{ InvalidWireTypeException -> 0x06b0, all -> 0x068a }
            long r14 = r4.readSInt64()     // Catch:{ InvalidWireTypeException -> 0x06b0, all -> 0x068a }
            androidx.datastore.preferences.protobuf.UnsafeUtil.putLong((java.lang.Object) r2, (long) r12, (long) r14)     // Catch:{ InvalidWireTypeException -> 0x06b0, all -> 0x068a }
            r1.setFieldPresent(r2, r3)     // Catch:{ InvalidWireTypeException -> 0x06b0, all -> 0x068a }
            goto L_0x0687
        L_0x055e:
            r2 = r5
            r5 = r7
            long r12 = offset(r5)     // Catch:{ InvalidWireTypeException -> 0x06b0, all -> 0x068a }
            int r5 = r4.readSInt32()     // Catch:{ InvalidWireTypeException -> 0x06b0, all -> 0x068a }
            androidx.datastore.preferences.protobuf.UnsafeUtil.putInt((java.lang.Object) r2, (long) r12, (int) r5)     // Catch:{ InvalidWireTypeException -> 0x06b0, all -> 0x068a }
            r1.setFieldPresent(r2, r3)     // Catch:{ InvalidWireTypeException -> 0x06b0, all -> 0x068a }
            goto L_0x0687
        L_0x0570:
            r2 = r5
            r5 = r7
            long r12 = offset(r5)     // Catch:{ InvalidWireTypeException -> 0x06b0, all -> 0x068a }
            long r14 = r4.readSFixed64()     // Catch:{ InvalidWireTypeException -> 0x06b0, all -> 0x068a }
            androidx.datastore.preferences.protobuf.UnsafeUtil.putLong((java.lang.Object) r2, (long) r12, (long) r14)     // Catch:{ InvalidWireTypeException -> 0x06b0, all -> 0x068a }
            r1.setFieldPresent(r2, r3)     // Catch:{ InvalidWireTypeException -> 0x06b0, all -> 0x068a }
            goto L_0x0687
        L_0x0582:
            r2 = r5
            r5 = r7
            long r12 = offset(r5)     // Catch:{ InvalidWireTypeException -> 0x06b0, all -> 0x068a }
            int r5 = r4.readSFixed32()     // Catch:{ InvalidWireTypeException -> 0x06b0, all -> 0x068a }
            androidx.datastore.preferences.protobuf.UnsafeUtil.putInt((java.lang.Object) r2, (long) r12, (int) r5)     // Catch:{ InvalidWireTypeException -> 0x06b0, all -> 0x068a }
            r1.setFieldPresent(r2, r3)     // Catch:{ InvalidWireTypeException -> 0x06b0, all -> 0x068a }
            goto L_0x0687
        L_0x0594:
            r16 = r7
            r7 = r2
            r2 = r5
            r5 = r16
            int r12 = r4.readEnum()     // Catch:{ InvalidWireTypeException -> 0x06b0, all -> 0x068a }
            androidx.datastore.preferences.protobuf.Internal$EnumVerifier r13 = r1.getEnumFieldVerifier(r3)     // Catch:{ InvalidWireTypeException -> 0x06b0, all -> 0x068a }
            if (r13 == 0) goto L_0x05b1
            boolean r13 = r13.isInRange(r12)     // Catch:{ InvalidWireTypeException -> 0x06b0, all -> 0x068a }
            if (r13 == 0) goto L_0x05ab
            goto L_0x05b1
        L_0x05ab:
            java.lang.Object r5 = androidx.datastore.preferences.protobuf.SchemaUtil.storeUnknownEnum(r2, r7, r12, r11, r10)     // Catch:{ InvalidWireTypeException -> 0x06b0, all -> 0x068a }
            goto L_0x06fb
        L_0x05b1:
            long r13 = offset(r5)     // Catch:{ InvalidWireTypeException -> 0x06b0, all -> 0x068a }
            androidx.datastore.preferences.protobuf.UnsafeUtil.putInt((java.lang.Object) r2, (long) r13, (int) r12)     // Catch:{ InvalidWireTypeException -> 0x06b0, all -> 0x068a }
            r1.setFieldPresent(r2, r3)     // Catch:{ InvalidWireTypeException -> 0x06b0, all -> 0x068a }
            goto L_0x0687
        L_0x05bd:
            r2 = r5
            r5 = r7
            long r12 = offset(r5)     // Catch:{ InvalidWireTypeException -> 0x06b0, all -> 0x068a }
            int r5 = r4.readUInt32()     // Catch:{ InvalidWireTypeException -> 0x06b0, all -> 0x068a }
            androidx.datastore.preferences.protobuf.UnsafeUtil.putInt((java.lang.Object) r2, (long) r12, (int) r5)     // Catch:{ InvalidWireTypeException -> 0x06b0, all -> 0x068a }
            r1.setFieldPresent(r2, r3)     // Catch:{ InvalidWireTypeException -> 0x06b0, all -> 0x068a }
            goto L_0x0687
        L_0x05cf:
            r2 = r5
            r5 = r7
            long r12 = offset(r5)     // Catch:{ InvalidWireTypeException -> 0x06b0, all -> 0x068a }
            androidx.datastore.preferences.protobuf.ByteString r5 = r4.readBytes()     // Catch:{ InvalidWireTypeException -> 0x06b0, all -> 0x068a }
            androidx.datastore.preferences.protobuf.UnsafeUtil.putObject((java.lang.Object) r2, (long) r12, (java.lang.Object) r5)     // Catch:{ InvalidWireTypeException -> 0x06b0, all -> 0x068a }
            r1.setFieldPresent(r2, r3)     // Catch:{ InvalidWireTypeException -> 0x06b0, all -> 0x068a }
            goto L_0x0687
        L_0x05e1:
            r2 = r5
            java.lang.Object r5 = r1.mutableMessageFieldForMerge(r2, r3)     // Catch:{ InvalidWireTypeException -> 0x06b0, all -> 0x068a }
            androidx.datastore.preferences.protobuf.MessageLite r5 = (androidx.datastore.preferences.protobuf.MessageLite) r5     // Catch:{ InvalidWireTypeException -> 0x06b0, all -> 0x068a }
            androidx.datastore.preferences.protobuf.Schema r7 = r1.getMessageFieldSchema(r3)     // Catch:{ InvalidWireTypeException -> 0x06b0, all -> 0x068a }
            r4.mergeMessageField(r5, r7, r6)     // Catch:{ InvalidWireTypeException -> 0x06b0, all -> 0x068a }
            r1.storeMessageField(r2, r3, r5)     // Catch:{ InvalidWireTypeException -> 0x06b0, all -> 0x068a }
            goto L_0x0687
        L_0x05f4:
            r2 = r5
            r5 = r7
            r1.readString(r2, r5, r4)     // Catch:{ InvalidWireTypeException -> 0x06b0, all -> 0x068a }
            r1.setFieldPresent(r2, r3)     // Catch:{ InvalidWireTypeException -> 0x06b0, all -> 0x068a }
            goto L_0x0687
        L_0x05fe:
            r2 = r5
            r5 = r7
            long r12 = offset(r5)     // Catch:{ InvalidWireTypeException -> 0x06b0, all -> 0x068a }
            boolean r5 = r4.readBool()     // Catch:{ InvalidWireTypeException -> 0x06b0, all -> 0x068a }
            androidx.datastore.preferences.protobuf.UnsafeUtil.putBoolean((java.lang.Object) r2, (long) r12, (boolean) r5)     // Catch:{ InvalidWireTypeException -> 0x06b0, all -> 0x068a }
            r1.setFieldPresent(r2, r3)     // Catch:{ InvalidWireTypeException -> 0x06b0, all -> 0x068a }
            goto L_0x0687
        L_0x0610:
            r2 = r5
            r5 = r7
            long r12 = offset(r5)     // Catch:{ InvalidWireTypeException -> 0x06b0, all -> 0x068a }
            int r5 = r4.readFixed32()     // Catch:{ InvalidWireTypeException -> 0x06b0, all -> 0x068a }
            androidx.datastore.preferences.protobuf.UnsafeUtil.putInt((java.lang.Object) r2, (long) r12, (int) r5)     // Catch:{ InvalidWireTypeException -> 0x06b0, all -> 0x068a }
            r1.setFieldPresent(r2, r3)     // Catch:{ InvalidWireTypeException -> 0x06b0, all -> 0x068a }
            goto L_0x0687
        L_0x0622:
            r2 = r5
            r5 = r7
            long r12 = offset(r5)     // Catch:{ InvalidWireTypeException -> 0x06b0, all -> 0x068a }
            long r14 = r4.readFixed64()     // Catch:{ InvalidWireTypeException -> 0x06b0, all -> 0x068a }
            androidx.datastore.preferences.protobuf.UnsafeUtil.putLong((java.lang.Object) r2, (long) r12, (long) r14)     // Catch:{ InvalidWireTypeException -> 0x06b0, all -> 0x068a }
            r1.setFieldPresent(r2, r3)     // Catch:{ InvalidWireTypeException -> 0x06b0, all -> 0x068a }
            goto L_0x0687
        L_0x0633:
            r2 = r5
            r5 = r7
            long r12 = offset(r5)     // Catch:{ InvalidWireTypeException -> 0x06b0, all -> 0x068a }
            int r5 = r4.readInt32()     // Catch:{ InvalidWireTypeException -> 0x06b0, all -> 0x068a }
            androidx.datastore.preferences.protobuf.UnsafeUtil.putInt((java.lang.Object) r2, (long) r12, (int) r5)     // Catch:{ InvalidWireTypeException -> 0x06b0, all -> 0x068a }
            r1.setFieldPresent(r2, r3)     // Catch:{ InvalidWireTypeException -> 0x06b0, all -> 0x068a }
            goto L_0x0687
        L_0x0644:
            r2 = r5
            r5 = r7
            long r12 = offset(r5)     // Catch:{ InvalidWireTypeException -> 0x06b0, all -> 0x068a }
            long r14 = r4.readUInt64()     // Catch:{ InvalidWireTypeException -> 0x06b0, all -> 0x068a }
            androidx.datastore.preferences.protobuf.UnsafeUtil.putLong((java.lang.Object) r2, (long) r12, (long) r14)     // Catch:{ InvalidWireTypeException -> 0x06b0, all -> 0x068a }
            r1.setFieldPresent(r2, r3)     // Catch:{ InvalidWireTypeException -> 0x06b0, all -> 0x068a }
            goto L_0x0687
        L_0x0655:
            r2 = r5
            r5 = r7
            long r12 = offset(r5)     // Catch:{ InvalidWireTypeException -> 0x06b0, all -> 0x068a }
            long r14 = r4.readInt64()     // Catch:{ InvalidWireTypeException -> 0x06b0, all -> 0x068a }
            androidx.datastore.preferences.protobuf.UnsafeUtil.putLong((java.lang.Object) r2, (long) r12, (long) r14)     // Catch:{ InvalidWireTypeException -> 0x06b0, all -> 0x068a }
            r1.setFieldPresent(r2, r3)     // Catch:{ InvalidWireTypeException -> 0x06b0, all -> 0x068a }
            goto L_0x0687
        L_0x0666:
            r2 = r5
            r5 = r7
            long r12 = offset(r5)     // Catch:{ InvalidWireTypeException -> 0x06b0, all -> 0x068a }
            float r5 = r4.readFloat()     // Catch:{ InvalidWireTypeException -> 0x06b0, all -> 0x068a }
            androidx.datastore.preferences.protobuf.UnsafeUtil.putFloat((java.lang.Object) r2, (long) r12, (float) r5)     // Catch:{ InvalidWireTypeException -> 0x06b0, all -> 0x068a }
            r1.setFieldPresent(r2, r3)     // Catch:{ InvalidWireTypeException -> 0x06b0, all -> 0x068a }
            goto L_0x0687
        L_0x0677:
            r2 = r5
            r5 = r7
            long r12 = offset(r5)     // Catch:{ InvalidWireTypeException -> 0x06b0, all -> 0x068a }
            double r14 = r4.readDouble()     // Catch:{ InvalidWireTypeException -> 0x06b0, all -> 0x068a }
            androidx.datastore.preferences.protobuf.UnsafeUtil.putDouble((java.lang.Object) r2, (long) r12, (double) r14)     // Catch:{ InvalidWireTypeException -> 0x06b0, all -> 0x068a }
            r1.setFieldPresent(r2, r3)     // Catch:{ InvalidWireTypeException -> 0x06b0, all -> 0x068a }
        L_0x0687:
            r5 = r11
            goto L_0x06fb
        L_0x068a:
            r0 = move-exception
            goto L_0x0702
        L_0x068d:
            r5 = r11
        L_0x068e:
            boolean r3 = r10.mergeOneFieldFrom(r5, r4, r9)     // Catch:{ InvalidWireTypeException -> 0x06b1 }
            if (r3 != 0) goto L_0x06fb
            int r0 = r1.checkInitializedCount
            r4 = r5
        L_0x0697:
            int r3 = r1.repeatedFieldOffsetStart
            if (r0 >= r3) goto L_0x06a9
            int[] r3 = r1.intArray
            r3 = r3[r0]
            r6 = r20
            r5 = r10
            java.lang.Object r4 = r1.filterMapUnknownEnumValues(r2, r3, r4, r5, r6)
            int r0 = r0 + 1
            goto L_0x0697
        L_0x06a9:
            if (r4 == 0) goto L_0x06fa
        L_0x06ab:
            r10.setBuilderToMessage(r2, r4)
            goto L_0x06fa
        L_0x06af:
            r2 = r5
        L_0x06b0:
            r5 = r11
        L_0x06b1:
            boolean r3 = r10.shouldDiscardUnknownFields(r4)     // Catch:{ all -> 0x06fe }
            if (r3 == 0) goto L_0x06d5
            boolean r3 = r4.skipField()     // Catch:{ all -> 0x06fe }
            if (r3 != 0) goto L_0x06fb
            int r0 = r1.checkInitializedCount
            r4 = r5
        L_0x06c0:
            int r3 = r1.repeatedFieldOffsetStart
            if (r0 >= r3) goto L_0x06d2
            int[] r3 = r1.intArray
            r3 = r3[r0]
            r6 = r20
            r5 = r10
            java.lang.Object r4 = r1.filterMapUnknownEnumValues(r2, r3, r4, r5, r6)
            int r0 = r0 + 1
            goto L_0x06c0
        L_0x06d2:
            if (r4 == 0) goto L_0x06fa
            goto L_0x06ab
        L_0x06d5:
            if (r5 != 0) goto L_0x06dc
            java.lang.Object r3 = r10.getBuilderFromMessage(r2)     // Catch:{ all -> 0x06fe }
            r5 = r3
        L_0x06dc:
            boolean r3 = r10.mergeOneFieldFrom(r5, r4, r9)     // Catch:{ all -> 0x06fe }
            if (r3 != 0) goto L_0x06fb
            int r0 = r1.checkInitializedCount
            r4 = r5
        L_0x06e5:
            int r3 = r1.repeatedFieldOffsetStart
            if (r0 >= r3) goto L_0x06f7
            int[] r3 = r1.intArray
            r3 = r3[r0]
            r6 = r20
            r5 = r10
            java.lang.Object r4 = r1.filterMapUnknownEnumValues(r2, r3, r4, r5, r6)
            int r0 = r0 + 1
            goto L_0x06e5
        L_0x06f7:
            if (r4 == 0) goto L_0x06fa
            goto L_0x06ab
        L_0x06fa:
            return
        L_0x06fb:
            r4 = r6
            goto L_0x0007
        L_0x06fe:
            r0 = move-exception
            goto L_0x070a
        L_0x0700:
            r0 = move-exception
        L_0x0701:
            r2 = r5
        L_0x0702:
            r5 = r11
            goto L_0x070a
        L_0x0704:
            r0 = move-exception
            r10 = r18
            r2 = r20
            r11 = r5
        L_0x070a:
            int r3 = r1.checkInitializedCount
            r7 = r3
            r4 = r5
        L_0x070e:
            int r3 = r1.repeatedFieldOffsetStart
            if (r7 >= r3) goto L_0x0722
            int[] r3 = r1.intArray
            r3 = r3[r7]
            r6 = r20
            r5 = r10
            java.lang.Object r4 = r1.filterMapUnknownEnumValues(r2, r3, r4, r5, r6)
            int r7 = r7 + 1
            r1 = r17
            goto L_0x070e
        L_0x0722:
            r5 = r10
            if (r4 == 0) goto L_0x0728
            r5.setBuilderToMessage(r2, r4)
        L_0x0728:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.MessageSchema.mergeFromHelper(androidx.datastore.preferences.protobuf.UnknownFieldSchema, androidx.datastore.preferences.protobuf.ExtensionSchema, java.lang.Object, androidx.datastore.preferences.protobuf.Reader, androidx.datastore.preferences.protobuf.ExtensionRegistryLite):void");
    }

    static UnknownFieldSetLite getMutableUnknownFields(Object obj) {
        GeneratedMessageLite generatedMessageLite = (GeneratedMessageLite) obj;
        UnknownFieldSetLite unknownFieldSetLite = generatedMessageLite.unknownFields;
        if (unknownFieldSetLite != UnknownFieldSetLite.getDefaultInstance()) {
            return unknownFieldSetLite;
        }
        UnknownFieldSetLite newInstance = UnknownFieldSetLite.newInstance();
        generatedMessageLite.unknownFields = newInstance;
        return newInstance;
    }

    /* renamed from: androidx.datastore.preferences.protobuf.MessageSchema$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$WireFormat$FieldType;

        /* JADX WARNING: Can't wrap try/catch for region: R(36:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|36) */
        /* JADX WARNING: Code restructure failed: missing block: B:37:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0054 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0060 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x006c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0078 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0084 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0090 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x009c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x00a8 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x00b4 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:33:0x00c0 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                androidx.datastore.preferences.protobuf.WireFormat$FieldType[] r0 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$google$protobuf$WireFormat$FieldType = r0
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.BOOL     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$google$protobuf$WireFormat$FieldType     // Catch:{ NoSuchFieldError -> 0x001d }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.BYTES     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$google$protobuf$WireFormat$FieldType     // Catch:{ NoSuchFieldError -> 0x0028 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.DOUBLE     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$com$google$protobuf$WireFormat$FieldType     // Catch:{ NoSuchFieldError -> 0x0033 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.FIXED32     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = $SwitchMap$com$google$protobuf$WireFormat$FieldType     // Catch:{ NoSuchFieldError -> 0x003e }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.SFIXED32     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = $SwitchMap$com$google$protobuf$WireFormat$FieldType     // Catch:{ NoSuchFieldError -> 0x0049 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.FIXED64     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = $SwitchMap$com$google$protobuf$WireFormat$FieldType     // Catch:{ NoSuchFieldError -> 0x0054 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.SFIXED64     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r0 = $SwitchMap$com$google$protobuf$WireFormat$FieldType     // Catch:{ NoSuchFieldError -> 0x0060 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.FLOAT     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                int[] r0 = $SwitchMap$com$google$protobuf$WireFormat$FieldType     // Catch:{ NoSuchFieldError -> 0x006c }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.ENUM     // Catch:{ NoSuchFieldError -> 0x006c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006c }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006c }
            L_0x006c:
                int[] r0 = $SwitchMap$com$google$protobuf$WireFormat$FieldType     // Catch:{ NoSuchFieldError -> 0x0078 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.INT32     // Catch:{ NoSuchFieldError -> 0x0078 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0078 }
                r2 = 10
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0078 }
            L_0x0078:
                int[] r0 = $SwitchMap$com$google$protobuf$WireFormat$FieldType     // Catch:{ NoSuchFieldError -> 0x0084 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.UINT32     // Catch:{ NoSuchFieldError -> 0x0084 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0084 }
                r2 = 11
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0084 }
            L_0x0084:
                int[] r0 = $SwitchMap$com$google$protobuf$WireFormat$FieldType     // Catch:{ NoSuchFieldError -> 0x0090 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.INT64     // Catch:{ NoSuchFieldError -> 0x0090 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0090 }
                r2 = 12
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0090 }
            L_0x0090:
                int[] r0 = $SwitchMap$com$google$protobuf$WireFormat$FieldType     // Catch:{ NoSuchFieldError -> 0x009c }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.UINT64     // Catch:{ NoSuchFieldError -> 0x009c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x009c }
                r2 = 13
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x009c }
            L_0x009c:
                int[] r0 = $SwitchMap$com$google$protobuf$WireFormat$FieldType     // Catch:{ NoSuchFieldError -> 0x00a8 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.MESSAGE     // Catch:{ NoSuchFieldError -> 0x00a8 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00a8 }
                r2 = 14
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00a8 }
            L_0x00a8:
                int[] r0 = $SwitchMap$com$google$protobuf$WireFormat$FieldType     // Catch:{ NoSuchFieldError -> 0x00b4 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.SINT32     // Catch:{ NoSuchFieldError -> 0x00b4 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00b4 }
                r2 = 15
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00b4 }
            L_0x00b4:
                int[] r0 = $SwitchMap$com$google$protobuf$WireFormat$FieldType     // Catch:{ NoSuchFieldError -> 0x00c0 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.SINT64     // Catch:{ NoSuchFieldError -> 0x00c0 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00c0 }
                r2 = 16
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00c0 }
            L_0x00c0:
                int[] r0 = $SwitchMap$com$google$protobuf$WireFormat$FieldType     // Catch:{ NoSuchFieldError -> 0x00cc }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.STRING     // Catch:{ NoSuchFieldError -> 0x00cc }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00cc }
                r2 = 17
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00cc }
            L_0x00cc:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.MessageSchema.AnonymousClass1.<clinit>():void");
        }
    }

    private int decodeMapEntryValue(byte[] bArr, int i, int i2, WireFormat.FieldType fieldType, Class<?> cls, ArrayDecoders.Registers registers) throws IOException {
        switch (AnonymousClass1.$SwitchMap$com$google$protobuf$WireFormat$FieldType[fieldType.ordinal()]) {
            case 1:
                int decodeVarint64 = ArrayDecoders.decodeVarint64(bArr, i, registers);
                registers.object1 = Boolean.valueOf(registers.long1 != 0);
                return decodeVarint64;
            case 2:
                return ArrayDecoders.decodeBytes(bArr, i, registers);
            case 3:
                registers.object1 = Double.valueOf(ArrayDecoders.decodeDouble(bArr, i));
                return i + 8;
            case 4:
            case 5:
                registers.object1 = Integer.valueOf(ArrayDecoders.decodeFixed32(bArr, i));
                return i + 4;
            case 6:
            case 7:
                registers.object1 = Long.valueOf(ArrayDecoders.decodeFixed64(bArr, i));
                return i + 8;
            case 8:
                registers.object1 = Float.valueOf(ArrayDecoders.decodeFloat(bArr, i));
                return i + 4;
            case 9:
            case 10:
            case 11:
                int decodeVarint32 = ArrayDecoders.decodeVarint32(bArr, i, registers);
                registers.object1 = Integer.valueOf(registers.int1);
                return decodeVarint32;
            case 12:
            case 13:
                int decodeVarint642 = ArrayDecoders.decodeVarint64(bArr, i, registers);
                registers.object1 = Long.valueOf(registers.long1);
                return decodeVarint642;
            case 14:
                return ArrayDecoders.decodeMessageField(Protobuf.getInstance().schemaFor(cls), bArr, i, i2, registers);
            case 15:
                int decodeVarint322 = ArrayDecoders.decodeVarint32(bArr, i, registers);
                registers.object1 = Integer.valueOf(CodedInputStream.decodeZigZag32(registers.int1));
                return decodeVarint322;
            case 16:
                int decodeVarint643 = ArrayDecoders.decodeVarint64(bArr, i, registers);
                registers.object1 = Long.valueOf(CodedInputStream.decodeZigZag64(registers.long1));
                return decodeVarint643;
            case 17:
                return ArrayDecoders.decodeStringRequireUtf8(bArr, i, registers);
            default:
                throw new RuntimeException("unsupported field type.");
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v4, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v11, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v12, resolved type: byte} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private <K, V> int decodeMapEntry(byte[] r11, int r12, int r13, androidx.datastore.preferences.protobuf.MapEntryLite.Metadata<K, V> r14, java.util.Map<K, V> r15, androidx.datastore.preferences.protobuf.ArrayDecoders.Registers r16) throws java.io.IOException {
        /*
            r10 = this;
            r6 = r16
            int r12 = androidx.datastore.preferences.protobuf.ArrayDecoders.decodeVarint32(r11, r12, r6)
            int r0 = r6.int1
            if (r0 < 0) goto L_0x006f
            int r1 = r13 - r12
            if (r0 > r1) goto L_0x006f
            int r7 = r12 + r0
            K r0 = r14.defaultKey
            V r1 = r14.defaultValue
            r8 = r0
            r9 = r1
        L_0x0016:
            if (r12 >= r7) goto L_0x0064
            int r0 = r12 + 1
            byte r12 = r11[r12]
            if (r12 >= 0) goto L_0x0024
            int r0 = androidx.datastore.preferences.protobuf.ArrayDecoders.decodeVarint32(r12, r11, r0, r6)
            int r12 = r6.int1
        L_0x0024:
            r2 = r0
            int r0 = r12 >>> 3
            r1 = r12 & 7
            r3 = 1
            if (r0 == r3) goto L_0x004a
            r3 = 2
            if (r0 == r3) goto L_0x0030
            goto L_0x005f
        L_0x0030:
            androidx.datastore.preferences.protobuf.WireFormat$FieldType r0 = r14.valueType
            int r0 = r0.getWireType()
            if (r1 != r0) goto L_0x005f
            androidx.datastore.preferences.protobuf.WireFormat$FieldType r4 = r14.valueType
            V r12 = r14.defaultValue
            java.lang.Class r5 = r12.getClass()
            r0 = r10
            r1 = r11
            r3 = r13
            int r12 = r0.decodeMapEntryValue(r1, r2, r3, r4, r5, r6)
            java.lang.Object r9 = r6.object1
            goto L_0x0016
        L_0x004a:
            androidx.datastore.preferences.protobuf.WireFormat$FieldType r0 = r14.keyType
            int r0 = r0.getWireType()
            if (r1 != r0) goto L_0x005f
            androidx.datastore.preferences.protobuf.WireFormat$FieldType r4 = r14.keyType
            r5 = 0
            r0 = r10
            r1 = r11
            r3 = r13
            int r12 = r0.decodeMapEntryValue(r1, r2, r3, r4, r5, r6)
            java.lang.Object r8 = r6.object1
            goto L_0x0016
        L_0x005f:
            int r12 = androidx.datastore.preferences.protobuf.ArrayDecoders.skipField(r12, r11, r2, r13, r6)
            goto L_0x0016
        L_0x0064:
            if (r12 != r7) goto L_0x006a
            r15.put(r8, r9)
            return r7
        L_0x006a:
            androidx.datastore.preferences.protobuf.InvalidProtocolBufferException r11 = androidx.datastore.preferences.protobuf.InvalidProtocolBufferException.parseFailure()
            throw r11
        L_0x006f:
            androidx.datastore.preferences.protobuf.InvalidProtocolBufferException r11 = androidx.datastore.preferences.protobuf.InvalidProtocolBufferException.truncatedMessage()
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.MessageSchema.decodeMapEntry(byte[], int, int, androidx.datastore.preferences.protobuf.MapEntryLite$Metadata, java.util.Map, androidx.datastore.preferences.protobuf.ArrayDecoders$Registers):int");
    }

    private int parseRepeatedField(T t, byte[] bArr, int i, int i2, int i3, int i4, int i5, int i6, long j, int i7, long j2, ArrayDecoders.Registers registers) throws IOException {
        int i8;
        int i9 = i6;
        long j3 = j2;
        Unsafe unsafe = UNSAFE;
        Internal.ProtobufList protobufList = (Internal.ProtobufList) unsafe.getObject(t, j3);
        if (!protobufList.isModifiable()) {
            int size = protobufList.size();
            protobufList = protobufList.mutableCopyWithCapacity(size == 0 ? 10 : size * 2);
            unsafe.putObject(t, j3, protobufList);
        }
        Internal.ProtobufList protobufList2 = protobufList;
        switch (i7) {
            case 18:
            case 35:
                ArrayDecoders.Registers registers2 = registers;
                if (i5 == 2) {
                    return ArrayDecoders.decodePackedDoubleList(bArr, i, protobufList2, registers2);
                }
                if (i5 == 1) {
                    return ArrayDecoders.decodeDoubleList(i3, bArr, i, i2, protobufList2, registers2);
                }
                break;
            case 19:
            case 36:
                ArrayDecoders.Registers registers3 = registers;
                if (i5 == 2) {
                    return ArrayDecoders.decodePackedFloatList(bArr, i, protobufList2, registers3);
                }
                if (i5 == 5) {
                    return ArrayDecoders.decodeFloatList(i3, bArr, i, i2, protobufList2, registers3);
                }
                break;
            case 20:
            case 21:
            case 37:
            case 38:
                ArrayDecoders.Registers registers4 = registers;
                if (i5 == 2) {
                    return ArrayDecoders.decodePackedVarint64List(bArr, i, protobufList2, registers4);
                }
                if (i5 == 0) {
                    return ArrayDecoders.decodeVarint64List(i3, bArr, i, i2, protobufList2, registers4);
                }
                break;
            case 22:
            case 29:
            case 39:
            case 43:
                ArrayDecoders.Registers registers5 = registers;
                if (i5 == 2) {
                    return ArrayDecoders.decodePackedVarint32List(bArr, i, protobufList2, registers5);
                }
                if (i5 == 0) {
                    return ArrayDecoders.decodeVarint32List(i3, bArr, i, i2, protobufList2, registers5);
                }
                break;
            case 23:
            case 32:
            case 40:
            case 46:
                ArrayDecoders.Registers registers6 = registers;
                if (i5 == 2) {
                    return ArrayDecoders.decodePackedFixed64List(bArr, i, protobufList2, registers6);
                }
                if (i5 == 1) {
                    return ArrayDecoders.decodeFixed64List(i3, bArr, i, i2, protobufList2, registers6);
                }
                break;
            case 24:
            case 31:
            case 41:
            case 45:
                ArrayDecoders.Registers registers7 = registers;
                if (i5 == 2) {
                    return ArrayDecoders.decodePackedFixed32List(bArr, i, protobufList2, registers7);
                }
                if (i5 == 5) {
                    return ArrayDecoders.decodeFixed32List(i3, bArr, i, i2, protobufList2, registers7);
                }
                break;
            case 25:
            case 42:
                ArrayDecoders.Registers registers8 = registers;
                if (i5 == 2) {
                    return ArrayDecoders.decodePackedBoolList(bArr, i, protobufList2, registers8);
                }
                if (i5 == 0) {
                    return ArrayDecoders.decodeBoolList(i3, bArr, i, i2, protobufList2, registers8);
                }
                break;
            case 26:
                if (i5 == 2) {
                    if ((j & 536870912) == 0) {
                        return ArrayDecoders.decodeStringList(i3, bArr, i, i2, protobufList2, registers);
                    }
                    return ArrayDecoders.decodeStringListRequireUtf8(i3, bArr, i, i2, protobufList2, registers);
                }
                break;
            case 27:
                if (i5 == 2) {
                    return ArrayDecoders.decodeMessageList(getMessageFieldSchema(i9), i3, bArr, i, i2, protobufList2, registers);
                }
                break;
            case 28:
                if (i5 == 2) {
                    return ArrayDecoders.decodeBytesList(i3, bArr, i, i2, protobufList2, registers);
                }
                break;
            case 30:
            case 44:
                ArrayDecoders.Registers registers9 = registers;
                if (i5 == 2) {
                    i8 = ArrayDecoders.decodePackedVarint32List(bArr, i, protobufList2, registers9);
                } else if (i5 == 0) {
                    i8 = ArrayDecoders.decodeVarint32List(i3, bArr, i, i2, protobufList2, registers9);
                }
                SchemaUtil.filterUnknownEnumList((Object) t, i4, (List<Integer>) protobufList2, getEnumFieldVerifier(i9), null, this.unknownFieldSchema);
                return i8;
            case 33:
            case 47:
                ArrayDecoders.Registers registers10 = registers;
                if (i5 == 2) {
                    return ArrayDecoders.decodePackedSInt32List(bArr, i, protobufList2, registers10);
                }
                if (i5 == 0) {
                    return ArrayDecoders.decodeSInt32List(i3, bArr, i, i2, protobufList2, registers10);
                }
                break;
            case 34:
            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE:
                ArrayDecoders.Registers registers11 = registers;
                if (i5 == 2) {
                    return ArrayDecoders.decodePackedSInt64List(bArr, i, protobufList2, registers11);
                }
                if (i5 == 0) {
                    return ArrayDecoders.decodeSInt64List(i3, bArr, i, i2, protobufList2, registers11);
                }
                break;
            case ConstraintLayout.LayoutParams.Table.LAYOUT_EDITOR_ABSOLUTEX:
                if (i5 == 3) {
                    return ArrayDecoders.decodeGroupList(getMessageFieldSchema(i9), i3, bArr, i, i2, protobufList2, registers);
                }
                break;
        }
        return i;
    }

    private <K, V> int parseMapField(T t, byte[] bArr, int i, int i2, int i3, long j, ArrayDecoders.Registers registers) throws IOException {
        long j2 = j;
        Unsafe unsafe = UNSAFE;
        Object mapFieldDefaultEntry = getMapFieldDefaultEntry(i3);
        Object object = unsafe.getObject(t, j2);
        if (this.mapFieldSchema.isImmutable(object)) {
            Object newMapField = this.mapFieldSchema.newMapField(mapFieldDefaultEntry);
            this.mapFieldSchema.mergeFrom(newMapField, object);
            unsafe.putObject(t, j2, newMapField);
            object = newMapField;
        }
        return decodeMapEntry(bArr, i, i2, this.mapFieldSchema.forMapMetadata(mapFieldDefaultEntry), this.mapFieldSchema.forMutableMapData(object), registers);
    }

    private int parseOneofField(T t, byte[] bArr, int i, int i2, int i3, int i4, int i5, int i6, int i7, long j, int i8, ArrayDecoders.Registers registers) throws IOException {
        int i9 = i4;
        int i10 = i5;
        long j2 = j;
        int i11 = i8;
        Unsafe unsafe = UNSAFE;
        long j3 = (long) (this.buffer[i11 + 2] & 1048575);
        boolean z = true;
        switch (i7) {
            case 51:
                int i12 = i;
                if (i10 != 1) {
                    return i12;
                }
                unsafe.putObject(t, j2, Double.valueOf(ArrayDecoders.decodeDouble(bArr, i)));
                int i13 = i12 + 8;
                unsafe.putInt(t, j3, i9);
                return i13;
            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BASELINE_TO_TOP_OF:
                int i14 = i;
                if (i10 != 5) {
                    return i14;
                }
                unsafe.putObject(t, j2, Float.valueOf(ArrayDecoders.decodeFloat(bArr, i)));
                int i15 = i14 + 4;
                unsafe.putInt(t, j3, i9);
                return i15;
            case 53:
            case ConstraintLayout.LayoutParams.Table.LAYOUT_MARGIN_BASELINE:
                int i16 = i;
                ArrayDecoders.Registers registers2 = registers;
                if (i10 != 0) {
                    return i16;
                }
                int decodeVarint64 = ArrayDecoders.decodeVarint64(bArr, i16, registers2);
                unsafe.putObject(t, j2, Long.valueOf(registers2.long1));
                unsafe.putInt(t, j3, i9);
                return decodeVarint64;
            case 55:
            case 62:
                int i17 = i;
                ArrayDecoders.Registers registers3 = registers;
                if (i10 != 0) {
                    return i17;
                }
                int decodeVarint32 = ArrayDecoders.decodeVarint32(bArr, i17, registers3);
                unsafe.putObject(t, j2, Integer.valueOf(registers3.int1));
                unsafe.putInt(t, j3, i9);
                return decodeVarint32;
            case 56:
            case 65:
                int i18 = i;
                if (i10 != 1) {
                    return i18;
                }
                unsafe.putObject(t, j2, Long.valueOf(ArrayDecoders.decodeFixed64(bArr, i)));
                int i19 = i18 + 8;
                unsafe.putInt(t, j3, i9);
                return i19;
            case 57:
            case 64:
                int i20 = i;
                if (i10 != 5) {
                    return i20;
                }
                unsafe.putObject(t, j2, Integer.valueOf(ArrayDecoders.decodeFixed32(bArr, i)));
                int i21 = i20 + 4;
                unsafe.putInt(t, j3, i9);
                return i21;
            case 58:
                int i22 = i;
                ArrayDecoders.Registers registers4 = registers;
                if (i10 != 0) {
                    return i22;
                }
                int decodeVarint642 = ArrayDecoders.decodeVarint64(bArr, i22, registers4);
                if (registers4.long1 == 0) {
                    z = false;
                }
                unsafe.putObject(t, j2, Boolean.valueOf(z));
                unsafe.putInt(t, j3, i9);
                return decodeVarint642;
            case 59:
                int i23 = i;
                ArrayDecoders.Registers registers5 = registers;
                if (i10 != 2) {
                    return i23;
                }
                int decodeVarint322 = ArrayDecoders.decodeVarint32(bArr, i23, registers5);
                int i24 = registers5.int1;
                if (i24 == 0) {
                    unsafe.putObject(t, j2, "");
                } else if ((i6 & ENFORCE_UTF8_MASK) == 0 || Utf8.isValidUtf8(bArr, decodeVarint322, decodeVarint322 + i24)) {
                    unsafe.putObject(t, j2, new String(bArr, decodeVarint322, i24, Internal.UTF_8));
                    decodeVarint322 += i24;
                } else {
                    throw InvalidProtocolBufferException.invalidUtf8();
                }
                unsafe.putInt(t, j3, i9);
                return decodeVarint322;
            case 60:
                int i25 = i;
                ArrayDecoders.Registers registers6 = registers;
                if (i10 != 2) {
                    return i25;
                }
                Object mutableOneofMessageFieldForMerge = mutableOneofMessageFieldForMerge(t, i9, i11);
                int mergeMessageField = ArrayDecoders.mergeMessageField(mutableOneofMessageFieldForMerge, getMessageFieldSchema(i11), bArr, i, i2, registers6);
                storeOneofMessageField(t, i9, i11, mutableOneofMessageFieldForMerge);
                return mergeMessageField;
            case LockFreeTaskQueueCore.CLOSED_SHIFT /*61*/:
                int i26 = i;
                ArrayDecoders.Registers registers7 = registers;
                if (i10 != 2) {
                    return i26;
                }
                int decodeBytes = ArrayDecoders.decodeBytes(bArr, i26, registers7);
                unsafe.putObject(t, j2, registers7.object1);
                unsafe.putInt(t, j3, i9);
                return decodeBytes;
            case HtmlCompat.FROM_HTML_MODE_COMPACT:
                int i27 = i;
                int i28 = i3;
                ArrayDecoders.Registers registers8 = registers;
                if (i10 != 0) {
                    return i27;
                }
                int decodeVarint323 = ArrayDecoders.decodeVarint32(bArr, i27, registers8);
                int i29 = registers8.int1;
                Internal.EnumVerifier enumFieldVerifier = getEnumFieldVerifier(i11);
                if (enumFieldVerifier == null || enumFieldVerifier.isInRange(i29)) {
                    unsafe.putObject(t, j2, Integer.valueOf(i29));
                    unsafe.putInt(t, j3, i9);
                    return decodeVarint323;
                }
                getMutableUnknownFields(t).storeField(i28, Long.valueOf((long) i29));
                return decodeVarint323;
            case ConstraintLayout.LayoutParams.Table.LAYOUT_WRAP_BEHAVIOR_IN_PARENT:
                int i30 = i;
                ArrayDecoders.Registers registers9 = registers;
                if (i10 != 0) {
                    return i30;
                }
                int decodeVarint324 = ArrayDecoders.decodeVarint32(bArr, i30, registers9);
                unsafe.putObject(t, j2, Integer.valueOf(CodedInputStream.decodeZigZag32(registers9.int1)));
                unsafe.putInt(t, j3, i9);
                return decodeVarint324;
            case ConstraintLayout.LayoutParams.Table.GUIDELINE_USE_RTL:
                int i31 = i;
                ArrayDecoders.Registers registers10 = registers;
                if (i10 != 0) {
                    return i31;
                }
                int decodeVarint643 = ArrayDecoders.decodeVarint64(bArr, i31, registers10);
                unsafe.putObject(t, j2, Long.valueOf(CodedInputStream.decodeZigZag64(registers10.long1)));
                unsafe.putInt(t, j3, i9);
                return decodeVarint643;
            case 68:
                if (i10 == 3) {
                    Object mutableOneofMessageFieldForMerge2 = mutableOneofMessageFieldForMerge(t, i9, i11);
                    int mergeGroupField = ArrayDecoders.mergeGroupField(mutableOneofMessageFieldForMerge2, getMessageFieldSchema(i11), bArr, i, i2, (i3 & -8) | 4, registers);
                    storeOneofMessageField(t, i9, i11, mutableOneofMessageFieldForMerge2);
                    return mergeGroupField;
                }
                break;
        }
        return i;
    }

    private Schema getMessageFieldSchema(int i) {
        int i2 = (i / 3) * 2;
        Schema schema = (Schema) this.objects[i2];
        if (schema != null) {
            return schema;
        }
        Schema schemaFor = Protobuf.getInstance().schemaFor((Class) this.objects[i2 + 1]);
        this.objects[i2] = schemaFor;
        return schemaFor;
    }

    private Object getMapFieldDefaultEntry(int i) {
        return this.objects[(i / 3) * 2];
    }

    private Internal.EnumVerifier getEnumFieldVerifier(int i) {
        return (Internal.EnumVerifier) this.objects[((i / 3) * 2) + 1];
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v0, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v0, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v1, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v2, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v4, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v4, resolved type: androidx.datastore.preferences.protobuf.UnknownFieldSetLite} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v7, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v5, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v10, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v8, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v9, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v10, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v11, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v13, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v12, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v16, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v13, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v14, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v9, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v17, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v16, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v13, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v18, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v32, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v22, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v23, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v24, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v78, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v79, resolved type: byte} */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:100:0x02ef, code lost:
        r9 = r0;
        r24 = r3;
        r17 = r10;
        r0 = r13;
        r2 = r14;
        r19 = r18;
        r13 = r8;
        r8 = r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:169:0x001e, code lost:
        r2 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:170:0x001e, code lost:
        r2 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x00a3, code lost:
        r3 = r9;
        r14 = r19;
        r9 = r28;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x0170, code lost:
        r12 = r12 | r20;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x0172, code lost:
        r4 = r30;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x0174, code lost:
        r7 = r9;
        r6 = r11;
        r11 = r18;
        r5 = r21;
        r9 = r2;
        r2 = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x017e, code lost:
        r14 = r9;
        r9 = r8;
        r8 = r14;
        r14 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x01ff, code lost:
        r14 = r9;
        r9 = r1;
        r1 = r8;
        r8 = r3;
        r3 = r14;
        r14 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x021c, code lost:
        r12 = r12 | r20;
        r4 = r30;
        r7 = r3;
        r6 = r11;
        r11 = r18;
        r5 = r21;
        r3 = r2;
        r2 = r1;
        r1 = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:0x02ad, code lost:
        r8 = r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:89:0x02b0, code lost:
        r3 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:96:0x02de, code lost:
        r12 = r12 | r20;
        r4 = r3;
        r3 = r2;
        r2 = r9;
        r9 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:97:0x02e4, code lost:
        r4 = r30;
        r2 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:98:0x02e6, code lost:
        r7 = r8;
        r2 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:99:0x02e7, code lost:
        r8 = r10;
        r6 = r11;
        r11 = r18;
        r5 = r21;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:143:0x042c  */
    /* JADX WARNING: Removed duplicated region for block: B:144:0x043f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int parseMessage(T r27, byte[] r28, int r29, int r30, int r31, androidx.datastore.preferences.protobuf.ArrayDecoders.Registers r32) throws java.io.IOException {
        /*
            r26 = this;
            r0 = r26
            r1 = r27
            r2 = r28
            r4 = r30
            r15 = r31
            r7 = r32
            checkMutable(r1)
            sun.misc.Unsafe r9 = UNSAFE
            r16 = 0
            r11 = -1
            r3 = r29
            r5 = r11
            r6 = r16
            r12 = r6
            r13 = r12
            r8 = 1048575(0xfffff, float:1.469367E-39)
        L_0x001e:
            if (r3 >= r4) goto L_0x045c
            int r13 = r3 + 1
            byte r3 = r2[r3]
            if (r3 >= 0) goto L_0x002c
            int r13 = androidx.datastore.preferences.protobuf.ArrayDecoders.decodeVarint32(r3, r2, r13, r7)
            int r3 = r7.int1
        L_0x002c:
            r25 = r13
            r13 = r3
            r3 = r25
            int r14 = r13 >>> 3
            r7 = r13 & 7
            r17 = 1048575(0xfffff, float:1.469367E-39)
            r10 = 3
            if (r14 <= r5) goto L_0x0041
            int r6 = r6 / r10
            int r5 = r0.positionForFieldNumber(r14, r6)
            goto L_0x0045
        L_0x0041:
            int r5 = r0.positionForFieldNumber(r14)
        L_0x0045:
            if (r5 != r11) goto L_0x0058
            r2 = r3
            r17 = r8
            r24 = r9
            r19 = r11
            r21 = r14
            r8 = r16
            r9 = r0
            r0 = r13
        L_0x0054:
            r13 = r32
            goto L_0x0415
        L_0x0058:
            int[] r6 = r0.buffer
            int r18 = r5 + 1
            r6 = r6[r18]
            r18 = r11
            int r11 = type(r6)
            r19 = r3
            long r3 = offset(r6)
            r10 = 17
            if (r11 > r10) goto L_0x02fc
            int[] r10 = r0.buffer
            int r20 = r5 + 2
            r10 = r10[r20]
            int r20 = r10 >>> 20
            r2 = 1
            int r20 = r2 << r20
            r10 = r10 & r17
            if (r10 == r8) goto L_0x0095
            r21 = r14
            r14 = r17
            r22 = r3
            if (r8 == r14) goto L_0x0089
            long r2 = (long) r8
            r9.putInt(r1, r2, r12)
        L_0x0089:
            if (r10 != r14) goto L_0x008e
            r12 = r16
            goto L_0x009c
        L_0x008e:
            long r2 = (long) r10
            int r2 = r9.getInt(r1, r2)
            r12 = r2
            goto L_0x009c
        L_0x0095:
            r22 = r3
            r21 = r14
            r14 = r17
            r10 = r8
        L_0x009c:
            r2 = 5
            switch(r11) {
                case 0: goto L_0x02c8;
                case 1: goto L_0x02b2;
                case 2: goto L_0x0284;
                case 3: goto L_0x0284;
                case 4: goto L_0x0265;
                case 5: goto L_0x0234;
                case 6: goto L_0x0207;
                case 7: goto L_0x01db;
                case 8: goto L_0x01b9;
                case 9: goto L_0x0184;
                case 10: goto L_0x015a;
                case 11: goto L_0x0265;
                case 12: goto L_0x0124;
                case 13: goto L_0x0207;
                case 14: goto L_0x0234;
                case 15: goto L_0x010a;
                case 16: goto L_0x00db;
                case 17: goto L_0x00aa;
                default: goto L_0x00a0;
            }
        L_0x00a0:
            r8 = r32
            r11 = r5
        L_0x00a3:
            r3 = r9
            r14 = r19
            r9 = r28
            goto L_0x02ef
        L_0x00aa:
            r3 = 3
            if (r7 != r3) goto L_0x00d7
            java.lang.Object r2 = r0.mutableMessageFieldForMerge(r1, r5)
            int r3 = r21 << 3
            r7 = r3 | 4
            androidx.datastore.preferences.protobuf.Schema r3 = r0.getMessageFieldSchema(r5)
            r4 = r28
            r6 = r30
            r8 = r32
            r11 = r5
            r5 = r19
            int r3 = androidx.datastore.preferences.protobuf.ArrayDecoders.mergeGroupField(r2, r3, r4, r5, r6, r7, r8)
            r25 = r4
            r4 = r2
            r2 = r8
            r8 = r25
            r0.storeMessageField(r1, r11, r4)
            r12 = r12 | r20
            r4 = r30
            r7 = r2
            r2 = r8
            goto L_0x02e7
        L_0x00d7:
            r11 = r5
            r8 = r32
            goto L_0x00a3
        L_0x00db:
            r8 = r28
            r2 = r32
            r11 = r5
            r3 = r19
            if (r7 != 0) goto L_0x0103
            int r7 = androidx.datastore.preferences.protobuf.ArrayDecoders.decodeVarint64(r8, r3, r2)
            long r3 = r2.long1
            long r5 = androidx.datastore.preferences.protobuf.CodedInputStream.decodeZigZag64(r3)
            r3 = r2
            r2 = r1
            r1 = r9
            r9 = r3
            r3 = r22
            r1.putLong(r2, r3, r5)
            r25 = r2
            r2 = r1
            r1 = r25
            r12 = r12 | r20
            r4 = r30
            r3 = r7
            goto L_0x0174
        L_0x0103:
            r25 = r9
            r9 = r2
            r2 = r25
            goto L_0x017e
        L_0x010a:
            r8 = r28
            r11 = r5
            r2 = r9
            r3 = r19
            r4 = r22
            r9 = r32
            if (r7 != 0) goto L_0x017e
            int r3 = androidx.datastore.preferences.protobuf.ArrayDecoders.decodeVarint32(r8, r3, r9)
            int r6 = r9.int1
            int r6 = androidx.datastore.preferences.protobuf.CodedInputStream.decodeZigZag32(r6)
            r2.putInt(r1, r4, r6)
            goto L_0x0170
        L_0x0124:
            r8 = r28
            r11 = r5
            r2 = r9
            r3 = r19
            r4 = r22
            r9 = r32
            if (r7 != 0) goto L_0x017e
            int r3 = androidx.datastore.preferences.protobuf.ArrayDecoders.decodeVarint32(r8, r3, r9)
            int r7 = r9.int1
            androidx.datastore.preferences.protobuf.Internal$EnumVerifier r14 = r0.getEnumFieldVerifier(r11)
            boolean r6 = isLegacyEnumIsClosed(r6)
            if (r6 == 0) goto L_0x0156
            if (r14 == 0) goto L_0x0156
            boolean r6 = r14.isInRange(r7)
            if (r6 == 0) goto L_0x0149
            goto L_0x0156
        L_0x0149:
            androidx.datastore.preferences.protobuf.UnknownFieldSetLite r4 = getMutableUnknownFields(r1)
            long r5 = (long) r7
            java.lang.Long r5 = java.lang.Long.valueOf(r5)
            r4.storeField(r13, r5)
            goto L_0x0172
        L_0x0156:
            r2.putInt(r1, r4, r7)
            goto L_0x0170
        L_0x015a:
            r8 = r28
            r11 = r5
            r2 = r9
            r3 = r19
            r4 = r22
            r14 = 2
            r9 = r32
            if (r7 != r14) goto L_0x017e
            int r3 = androidx.datastore.preferences.protobuf.ArrayDecoders.decodeBytes(r8, r3, r9)
            java.lang.Object r6 = r9.object1
            r2.putObject(r1, r4, r6)
        L_0x0170:
            r12 = r12 | r20
        L_0x0172:
            r4 = r30
        L_0x0174:
            r7 = r9
            r6 = r11
            r11 = r18
            r5 = r21
            r9 = r2
            r2 = r8
            goto L_0x02ad
        L_0x017e:
            r14 = r9
            r9 = r8
            r8 = r14
            r14 = r3
            goto L_0x02b0
        L_0x0184:
            r8 = r28
            r11 = r5
            r2 = r9
            r3 = r19
            r14 = 2
            r9 = r32
            if (r7 != r14) goto L_0x01ad
            r4 = r1
            java.lang.Object r1 = r0.mutableMessageFieldForMerge(r4, r11)
            r5 = r2
            androidx.datastore.preferences.protobuf.Schema r2 = r0.getMessageFieldSchema(r11)
            r6 = r4
            r4 = r3
            r3 = r8
            r8 = r6
            r6 = r9
            r9 = r5
            r5 = r30
            int r2 = androidx.datastore.preferences.protobuf.ArrayDecoders.mergeMessageField(r1, r2, r3, r4, r5, r6)
            r4 = r1
            r1 = r3
            r3 = r6
            r0.storeMessageField(r8, r11, r4)
            goto L_0x021c
        L_0x01ad:
            r25 = r8
            r8 = r1
            r1 = r25
            r25 = r9
            r9 = r2
            r2 = r3
            r3 = r25
            goto L_0x01ff
        L_0x01b9:
            r3 = r32
            r8 = r1
            r11 = r5
            r2 = r19
            r4 = r22
            r14 = 2
            r1 = r28
            if (r7 != r14) goto L_0x01ff
            boolean r6 = isEnforceUtf8(r6)
            if (r6 == 0) goto L_0x01d1
            int r2 = androidx.datastore.preferences.protobuf.ArrayDecoders.decodeStringRequireUtf8(r1, r2, r3)
            goto L_0x01d5
        L_0x01d1:
            int r2 = androidx.datastore.preferences.protobuf.ArrayDecoders.decodeString(r1, r2, r3)
        L_0x01d5:
            java.lang.Object r6 = r3.object1
            r9.putObject(r8, r4, r6)
            goto L_0x021c
        L_0x01db:
            r3 = r32
            r8 = r1
            r11 = r5
            r2 = r19
            r5 = r22
            r1 = r28
            if (r7 != 0) goto L_0x01ff
            int r2 = androidx.datastore.preferences.protobuf.ArrayDecoders.decodeVarint64(r1, r2, r3)
            r22 = r5
            long r4 = r3.long1
            r6 = 0
            int r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r4 == 0) goto L_0x01f7
            r4 = 1
            goto L_0x01f9
        L_0x01f7:
            r4 = r16
        L_0x01f9:
            r5 = r22
            androidx.datastore.preferences.protobuf.UnsafeUtil.putBoolean((java.lang.Object) r8, (long) r5, (boolean) r4)
            goto L_0x021c
        L_0x01ff:
            r14 = r9
            r9 = r1
            r1 = r8
            r8 = r3
            r3 = r14
            r14 = r2
            goto L_0x02ef
        L_0x0207:
            r3 = r32
            r8 = r1
            r11 = r5
            r14 = r19
            r5 = r22
            r1 = r28
            if (r7 != r2) goto L_0x022b
            int r2 = androidx.datastore.preferences.protobuf.ArrayDecoders.decodeFixed32(r1, r14)
            r9.putInt(r8, r5, r2)
            int r2 = r14 + 4
        L_0x021c:
            r12 = r12 | r20
            r4 = r30
            r7 = r3
            r6 = r11
            r11 = r18
            r5 = r21
            r3 = r2
            r2 = r1
            r1 = r8
            goto L_0x02ad
        L_0x022b:
            r25 = r9
            r9 = r1
            r1 = r8
            r8 = r3
            r3 = r25
            goto L_0x02ef
        L_0x0234:
            r3 = r32
            r8 = r1
            r11 = r5
            r14 = r19
            r5 = r22
            r4 = 1
            r1 = r28
            if (r7 != r4) goto L_0x025f
            r22 = r5
            long r5 = androidx.datastore.preferences.protobuf.ArrayDecoders.decodeFixed64(r1, r14)
            r2 = r9
            r9 = r1
            r1 = r2
            r2 = r8
            r8 = r3
            r3 = r22
            r1.putLong(r2, r3, r5)
            r25 = r2
            r2 = r1
            r1 = r25
            int r3 = r14 + 8
            r12 = r12 | r20
            r4 = r9
            r9 = r2
            r2 = r4
            goto L_0x02e4
        L_0x025f:
            r2 = r9
            r9 = r1
            r1 = r8
            r8 = r3
            goto L_0x02b0
        L_0x0265:
            r8 = r32
            r11 = r5
            r2 = r9
            r14 = r19
            r3 = r22
            r9 = r28
            if (r7 != 0) goto L_0x02b0
            int r5 = androidx.datastore.preferences.protobuf.ArrayDecoders.decodeVarint32(r9, r14, r8)
            int r6 = r8.int1
            r2.putInt(r1, r3, r6)
            r12 = r12 | r20
            r3 = r9
            r9 = r2
            r2 = r3
            r4 = r30
            r3 = r5
            goto L_0x02e6
        L_0x0284:
            r8 = r32
            r11 = r5
            r2 = r9
            r14 = r19
            r3 = r22
            r9 = r28
            if (r7 != 0) goto L_0x02b0
            int r7 = androidx.datastore.preferences.protobuf.ArrayDecoders.decodeVarint64(r9, r14, r8)
            long r5 = r8.long1
            r25 = r2
            r2 = r1
            r1 = r25
            r1.putLong(r2, r3, r5)
            r3 = r1
            r1 = r2
            r12 = r12 | r20
            r4 = r30
            r2 = r9
            r6 = r11
            r11 = r18
            r5 = r21
            r9 = r3
            r3 = r7
            r7 = r8
        L_0x02ad:
            r8 = r10
            goto L_0x001e
        L_0x02b0:
            r3 = r2
            goto L_0x02ef
        L_0x02b2:
            r8 = r32
            r11 = r5
            r3 = r9
            r14 = r19
            r4 = r22
            r9 = r28
            if (r7 != r2) goto L_0x02ef
            float r2 = androidx.datastore.preferences.protobuf.ArrayDecoders.decodeFloat(r9, r14)
            androidx.datastore.preferences.protobuf.UnsafeUtil.putFloat((java.lang.Object) r1, (long) r4, (float) r2)
            int r2 = r14 + 4
            goto L_0x02de
        L_0x02c8:
            r8 = r32
            r11 = r5
            r3 = r9
            r14 = r19
            r4 = r22
            r2 = 1
            r9 = r28
            if (r7 != r2) goto L_0x02ef
            double r6 = androidx.datastore.preferences.protobuf.ArrayDecoders.decodeDouble(r9, r14)
            androidx.datastore.preferences.protobuf.UnsafeUtil.putDouble((java.lang.Object) r1, (long) r4, (double) r6)
            int r2 = r14 + 8
        L_0x02de:
            r12 = r12 | r20
            r4 = r3
            r3 = r2
            r2 = r9
            r9 = r4
        L_0x02e4:
            r4 = r30
        L_0x02e6:
            r7 = r8
        L_0x02e7:
            r8 = r10
            r6 = r11
            r11 = r18
            r5 = r21
            goto L_0x001e
        L_0x02ef:
            r9 = r0
            r24 = r3
            r17 = r10
            r0 = r13
            r2 = r14
            r19 = r18
            r13 = r8
            r8 = r11
            goto L_0x0415
        L_0x02fc:
            r10 = r8
            r21 = r14
            r14 = r19
            r8 = r5
            r4 = r3
            r3 = r9
            r9 = r28
            r2 = 27
            if (r11 != r2) goto L_0x0358
            r2 = 2
            if (r7 != r2) goto L_0x034c
            java.lang.Object r2 = r3.getObject(r1, r4)
            androidx.datastore.preferences.protobuf.Internal$ProtobufList r2 = (androidx.datastore.preferences.protobuf.Internal.ProtobufList) r2
            boolean r6 = r2.isModifiable()
            if (r6 != 0) goto L_0x032b
            int r6 = r2.size()
            if (r6 != 0) goto L_0x0322
            r6 = 10
            goto L_0x0324
        L_0x0322:
            int r6 = r6 * 2
        L_0x0324:
            androidx.datastore.preferences.protobuf.Internal$ProtobufList r2 = r2.mutableCopyWithCapacity(r6)
            r3.putObject(r1, r4, r2)
        L_0x032b:
            r6 = r2
            androidx.datastore.preferences.protobuf.Schema r1 = r0.getMessageFieldSchema(r8)
            r2 = r9
            r9 = r3
            r3 = r2
            r5 = r30
            r7 = r32
            r2 = r13
            r4 = r14
            int r1 = androidx.datastore.preferences.protobuf.ArrayDecoders.decodeMessageList(r1, r2, r3, r4, r5, r6, r7)
            r4 = r30
            r3 = r1
            r6 = r8
            r8 = r10
            r11 = r18
            r5 = r21
            r1 = r27
            r2 = r28
            goto L_0x001e
        L_0x034c:
            r9 = r3
            r24 = r9
            r17 = r10
            r3 = r14
            r19 = r18
            r18 = r12
            goto L_0x03d9
        L_0x0358:
            r9 = r3
            r2 = r13
            r3 = r14
            r1 = 49
            if (r11 > r1) goto L_0x0399
            r1 = r9
            r13 = r10
            long r9 = (long) r6
            r14 = r32
            r24 = r1
            r17 = r13
            r19 = r18
            r6 = r21
            r1 = r27
            r18 = r12
            r12 = r4
            r4 = r30
            r5 = r2
            r2 = r28
            int r7 = r0.parseRepeatedField(r1, r2, r3, r4, r5, r6, r7, r8, r9, r11, r12, r14)
            r13 = r5
            if (r7 == r3) goto L_0x0395
            r0 = r26
            r1 = r27
            r2 = r28
            r4 = r30
            r3 = r7
            r6 = r8
            r8 = r17
            r12 = r18
        L_0x038b:
            r11 = r19
            r5 = r21
            r9 = r24
            r7 = r32
            goto L_0x001e
        L_0x0395:
            r9 = r26
            r2 = r7
            goto L_0x03dc
        L_0x0399:
            r13 = r2
            r22 = r4
            r24 = r9
            r17 = r10
            r9 = r11
            r19 = r18
            r18 = r12
            r0 = 50
            if (r9 != r0) goto L_0x03e1
            r14 = 2
            if (r7 != r14) goto L_0x03d9
            r0 = r26
            r1 = r27
            r2 = r28
            r4 = r30
            r5 = r8
            r6 = r22
            r8 = r32
            int r6 = r0.parseMapField(r1, r2, r3, r4, r5, r6, r8)
            r8 = r5
            if (r6 == r3) goto L_0x03d5
            r0 = r26
            r1 = r27
            r2 = r28
            r4 = r30
            r7 = r32
            r3 = r6
            r6 = r8
            r8 = r17
            r12 = r18
            r11 = r19
            r5 = r21
            goto L_0x040e
        L_0x03d5:
            r9 = r26
            r2 = r6
            goto L_0x03dc
        L_0x03d9:
            r9 = r26
            r2 = r3
        L_0x03dc:
            r0 = r13
            r12 = r18
            goto L_0x0054
        L_0x03e1:
            r0 = r26
            r1 = r27
            r2 = r28
            r4 = r30
            r12 = r8
            r5 = r13
            r10 = r22
            r13 = r32
            r8 = r6
            r6 = r21
            int r7 = r0.parseOneofField(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r12, r13)
            r9 = r0
            r0 = r5
            r8 = r12
            if (r7 == r3) goto L_0x0412
            r1 = r27
            r2 = r28
            r4 = r30
            r3 = r7
            r6 = r8
            r7 = r13
            r8 = r17
            r12 = r18
            r11 = r19
            r5 = r21
            r13 = r0
            r0 = r9
        L_0x040e:
            r9 = r24
            goto L_0x001e
        L_0x0412:
            r2 = r7
            r12 = r18
        L_0x0415:
            if (r0 != r15) goto L_0x0420
            if (r15 == 0) goto L_0x0420
            r6 = r27
            r7 = r30
            r13 = r0
            r8 = r2
            goto L_0x0466
        L_0x0420:
            boolean r1 = r9.hasExtensions
            if (r1 == 0) goto L_0x043f
            androidx.datastore.preferences.protobuf.ExtensionRegistryLite r1 = r13.extensionRegistry
            androidx.datastore.preferences.protobuf.ExtensionRegistryLite r3 = androidx.datastore.preferences.protobuf.ExtensionRegistryLite.getEmptyRegistry()
            if (r1 == r3) goto L_0x043f
            androidx.datastore.preferences.protobuf.MessageLite r5 = r9.defaultInstance
            androidx.datastore.preferences.protobuf.UnknownFieldSchema<?, ?> r6 = r9.unknownFieldSchema
            r4 = r27
            r1 = r28
            r3 = r30
            r7 = r13
            int r2 = androidx.datastore.preferences.protobuf.ArrayDecoders.decodeExtensionOrUnknownField(r0, r1, r2, r3, r4, r5, r6, r7)
            r6 = r4
            r7 = r30
            goto L_0x0450
        L_0x043f:
            r6 = r27
            androidx.datastore.preferences.protobuf.UnknownFieldSetLite r4 = getMutableUnknownFields(r6)
            r1 = r28
            r3 = r30
            r5 = r32
            int r2 = androidx.datastore.preferences.protobuf.ArrayDecoders.decodeUnknownField(r0, r1, r2, r3, r4, r5)
            r7 = r3
        L_0x0450:
            r3 = r2
            r2 = r28
            r13 = r0
            r1 = r6
            r4 = r7
            r6 = r8
            r0 = r9
            r8 = r17
            goto L_0x038b
        L_0x045c:
            r6 = r1
            r7 = r4
            r17 = r8
            r24 = r9
            r18 = r12
            r9 = r0
            r8 = r3
        L_0x0466:
            r0 = r17
            r14 = 1048575(0xfffff, float:1.469367E-39)
            if (r0 == r14) goto L_0x0473
            long r0 = (long) r0
            r2 = r24
            r2.putInt(r6, r0, r12)
        L_0x0473:
            int r0 = r9.checkInitializedCount
            r1 = 0
            r10 = r0
            r3 = r1
        L_0x0478:
            int r0 = r9.repeatedFieldOffsetStart
            if (r10 >= r0) goto L_0x0490
            int[] r0 = r9.intArray
            r2 = r0[r10]
            androidx.datastore.preferences.protobuf.UnknownFieldSchema<?, ?> r4 = r9.unknownFieldSchema
            r5 = r27
            r1 = r6
            r0 = r9
            java.lang.Object r2 = r0.filterMapUnknownEnumValues(r1, r2, r3, r4, r5)
            r3 = r2
            androidx.datastore.preferences.protobuf.UnknownFieldSetLite r3 = (androidx.datastore.preferences.protobuf.UnknownFieldSetLite) r3
            int r10 = r10 + 1
            goto L_0x0478
        L_0x0490:
            r1 = r6
            r0 = r9
            if (r3 == 0) goto L_0x0499
            androidx.datastore.preferences.protobuf.UnknownFieldSchema<?, ?> r2 = r0.unknownFieldSchema
            r2.setBuilderToMessage(r1, r3)
        L_0x0499:
            if (r15 != 0) goto L_0x04a3
            if (r8 != r7) goto L_0x049e
            goto L_0x04a7
        L_0x049e:
            androidx.datastore.preferences.protobuf.InvalidProtocolBufferException r1 = androidx.datastore.preferences.protobuf.InvalidProtocolBufferException.parseFailure()
            throw r1
        L_0x04a3:
            if (r8 > r7) goto L_0x04a8
            if (r13 != r15) goto L_0x04a8
        L_0x04a7:
            return r8
        L_0x04a8:
            androidx.datastore.preferences.protobuf.InvalidProtocolBufferException r1 = androidx.datastore.preferences.protobuf.InvalidProtocolBufferException.parseFailure()
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.MessageSchema.parseMessage(java.lang.Object, byte[], int, int, int, androidx.datastore.preferences.protobuf.ArrayDecoders$Registers):int");
    }

    private Object mutableMessageFieldForMerge(T t, int i) {
        Schema messageFieldSchema = getMessageFieldSchema(i);
        long offset = offset(typeAndOffsetAt(i));
        if (!isFieldPresent(t, i)) {
            return messageFieldSchema.newInstance();
        }
        Object object = UNSAFE.getObject(t, offset);
        if (isMutable(object)) {
            return object;
        }
        Object newInstance = messageFieldSchema.newInstance();
        if (object != null) {
            messageFieldSchema.mergeFrom(newInstance, object);
        }
        return newInstance;
    }

    private void storeMessageField(T t, int i, Object obj) {
        UNSAFE.putObject(t, offset(typeAndOffsetAt(i)), obj);
        setFieldPresent(t, i);
    }

    private Object mutableOneofMessageFieldForMerge(T t, int i, int i2) {
        Schema messageFieldSchema = getMessageFieldSchema(i2);
        if (!isOneofPresent(t, i, i2)) {
            return messageFieldSchema.newInstance();
        }
        Object object = UNSAFE.getObject(t, offset(typeAndOffsetAt(i2)));
        if (isMutable(object)) {
            return object;
        }
        Object newInstance = messageFieldSchema.newInstance();
        if (object != null) {
            messageFieldSchema.mergeFrom(newInstance, object);
        }
        return newInstance;
    }

    private void storeOneofMessageField(T t, int i, int i2, Object obj) {
        UNSAFE.putObject(t, offset(typeAndOffsetAt(i2)), obj);
        setOneofPresent(t, i, i2);
    }

    public void mergeFrom(T t, byte[] bArr, int i, int i2, ArrayDecoders.Registers registers) throws IOException {
        parseMessage(t, bArr, i, i2, 0, registers);
    }

    public void makeImmutable(T t) {
        if (isMutable(t)) {
            if (t instanceof GeneratedMessageLite) {
                GeneratedMessageLite generatedMessageLite = (GeneratedMessageLite) t;
                generatedMessageLite.clearMemoizedSerializedSize();
                generatedMessageLite.clearMemoizedHashCode();
                generatedMessageLite.markImmutable();
            }
            int length = this.buffer.length;
            for (int i = 0; i < length; i += 3) {
                int typeAndOffsetAt = typeAndOffsetAt(i);
                long offset = offset(typeAndOffsetAt);
                int type = type(typeAndOffsetAt);
                if (type != 9) {
                    if (type == 60 || type == 68) {
                        if (isOneofPresent(t, numberAt(i), i)) {
                            getMessageFieldSchema(i).makeImmutable(UNSAFE.getObject(t, offset));
                        }
                    } else {
                        switch (type) {
                            case 17:
                                break;
                            case 18:
                            case 19:
                            case 20:
                            case 21:
                            case 22:
                            case 23:
                            case 24:
                            case 25:
                            case 26:
                            case 27:
                            case 28:
                            case 29:
                            case 30:
                            case 31:
                            case 32:
                            case 33:
                            case 34:
                            case 35:
                            case 36:
                            case 37:
                            case 38:
                            case 39:
                            case 40:
                            case 41:
                            case 42:
                            case 43:
                            case 44:
                            case 45:
                            case 46:
                            case 47:
                            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE:
                            case ConstraintLayout.LayoutParams.Table.LAYOUT_EDITOR_ABSOLUTEX:
                                this.listFieldSchema.makeImmutableListAt(t, offset);
                                continue;
                            case 50:
                                Unsafe unsafe = UNSAFE;
                                Object object = unsafe.getObject(t, offset);
                                if (object != null) {
                                    unsafe.putObject(t, offset, this.mapFieldSchema.toImmutable(object));
                                    break;
                                } else {
                                    continue;
                                }
                        }
                    }
                }
                if (isFieldPresent(t, i)) {
                    getMessageFieldSchema(i).makeImmutable(UNSAFE.getObject(t, offset));
                }
            }
            this.unknownFieldSchema.makeImmutable(t);
            if (this.hasExtensions) {
                this.extensionSchema.makeImmutable(t);
            }
        }
    }

    private final <K, V> void mergeMap(Object obj, int i, Object obj2, ExtensionRegistryLite extensionRegistryLite, Reader reader) throws IOException {
        long offset = offset(typeAndOffsetAt(i));
        Object object = UnsafeUtil.getObject(obj, offset);
        if (object == null) {
            object = this.mapFieldSchema.newMapField(obj2);
            UnsafeUtil.putObject(obj, offset, object);
        } else if (this.mapFieldSchema.isImmutable(object)) {
            Object newMapField = this.mapFieldSchema.newMapField(obj2);
            this.mapFieldSchema.mergeFrom(newMapField, object);
            UnsafeUtil.putObject(obj, offset, newMapField);
            object = newMapField;
        }
        reader.readMap(this.mapFieldSchema.forMutableMapData(object), this.mapFieldSchema.forMapMetadata(obj2), extensionRegistryLite);
    }

    private <UT, UB> UB filterMapUnknownEnumValues(Object obj, int i, UB ub, UnknownFieldSchema<UT, UB> unknownFieldSchema2, Object obj2) {
        Internal.EnumVerifier enumFieldVerifier;
        int numberAt = numberAt(i);
        Object object = UnsafeUtil.getObject(obj, offset(typeAndOffsetAt(i)));
        if (object == null || (enumFieldVerifier = getEnumFieldVerifier(i)) == null) {
            return ub;
        }
        return filterUnknownEnumMap(i, numberAt, this.mapFieldSchema.forMutableMapData(object), enumFieldVerifier, ub, unknownFieldSchema2, obj2);
    }

    private <K, V, UT, UB> UB filterUnknownEnumMap(int i, int i2, Map<K, V> map, Internal.EnumVerifier enumVerifier, UB ub, UnknownFieldSchema<UT, UB> unknownFieldSchema2, Object obj) {
        MapEntryLite.Metadata<?, ?> forMapMetadata = this.mapFieldSchema.forMapMetadata(getMapFieldDefaultEntry(i));
        Iterator<Map.Entry<K, V>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry next = it.next();
            if (!enumVerifier.isInRange(((Integer) next.getValue()).intValue())) {
                if (ub == null) {
                    ub = unknownFieldSchema2.getBuilderFromMessage(obj);
                }
                ByteString.CodedBuilder newCodedBuilder = ByteString.newCodedBuilder(MapEntryLite.computeSerializedSize(forMapMetadata, next.getKey(), next.getValue()));
                try {
                    MapEntryLite.writeTo(newCodedBuilder.getCodedOutput(), forMapMetadata, next.getKey(), next.getValue());
                    unknownFieldSchema2.addLengthDelimited(ub, i2, newCodedBuilder.build());
                    it.remove();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return ub;
    }

    public final boolean isInitialized(T t) {
        int i;
        int i2;
        int i3 = 1048575;
        int i4 = 0;
        int i5 = 0;
        while (i4 < this.checkInitializedCount) {
            int i6 = this.intArray[i4];
            int numberAt = numberAt(i6);
            int typeAndOffsetAt = typeAndOffsetAt(i6);
            int i7 = this.buffer[i6 + 2];
            int i8 = i7 & 1048575;
            int i9 = 1 << (i7 >>> 20);
            if (i8 != i3) {
                if (i8 != 1048575) {
                    i5 = UNSAFE.getInt(t, (long) i8);
                }
                i = i5;
                i2 = i8;
            } else {
                i2 = i3;
                i = i5;
            }
            T t2 = t;
            if (isRequired(typeAndOffsetAt) && !isFieldPresent(t2, i6, i2, i, i9)) {
                return false;
            }
            int type = type(typeAndOffsetAt);
            if (type != 9 && type != 17) {
                if (type != 27) {
                    if (type == 60 || type == 68) {
                        if (isOneofPresent(t2, numberAt, i6) && !isInitialized(t2, typeAndOffsetAt, getMessageFieldSchema(i6))) {
                            return false;
                        }
                    } else if (type != 49) {
                        if (type == 50 && !isMapInitialized(t2, typeAndOffsetAt, i6)) {
                            return false;
                        }
                    }
                }
                if (!isListInitialized(t2, typeAndOffsetAt, i6)) {
                    return false;
                }
            } else if (isFieldPresent(t2, i6, i2, i, i9) && !isInitialized(t2, typeAndOffsetAt, getMessageFieldSchema(i6))) {
                return false;
            }
            i4++;
            t = t2;
            i3 = i2;
            i5 = i;
        }
        return !this.hasExtensions || this.extensionSchema.getExtensions(t).isInitialized();
    }

    private static boolean isInitialized(Object obj, int i, Schema schema) {
        return schema.isInitialized(UnsafeUtil.getObject(obj, offset(i)));
    }

    private <N> boolean isListInitialized(Object obj, int i, int i2) {
        List list = (List) UnsafeUtil.getObject(obj, offset(i));
        if (list.isEmpty()) {
            return true;
        }
        Schema messageFieldSchema = getMessageFieldSchema(i2);
        for (int i3 = 0; i3 < list.size(); i3++) {
            if (!messageFieldSchema.isInitialized(list.get(i3))) {
                return false;
            }
        }
        return true;
    }

    private boolean isMapInitialized(T t, int i, int i2) {
        Map<?, ?> forMapData = this.mapFieldSchema.forMapData(UnsafeUtil.getObject((Object) t, offset(i)));
        if (forMapData.isEmpty()) {
            return true;
        }
        if (this.mapFieldSchema.forMapMetadata(getMapFieldDefaultEntry(i2)).valueType.getJavaType() != WireFormat.JavaType.MESSAGE) {
            return true;
        }
        Schema<?> schema = null;
        for (Object next : forMapData.values()) {
            if (schema == null) {
                schema = Protobuf.getInstance().schemaFor(next.getClass());
            }
            if (!schema.isInitialized(next)) {
                return false;
            }
        }
        return true;
    }

    private void writeString(int i, Object obj, Writer writer) throws IOException {
        if (obj instanceof String) {
            writer.writeString(i, (String) obj);
        } else {
            writer.writeBytes(i, (ByteString) obj);
        }
    }

    private void readString(Object obj, int i, Reader reader) throws IOException {
        if (isEnforceUtf8(i)) {
            UnsafeUtil.putObject(obj, offset(i), (Object) reader.readStringRequireUtf8());
        } else if (this.lite) {
            UnsafeUtil.putObject(obj, offset(i), (Object) reader.readString());
        } else {
            UnsafeUtil.putObject(obj, offset(i), (Object) reader.readBytes());
        }
    }

    private void readStringList(Object obj, int i, Reader reader) throws IOException {
        if (isEnforceUtf8(i)) {
            reader.readStringListRequireUtf8(this.listFieldSchema.mutableListAt(obj, offset(i)));
        } else {
            reader.readStringList(this.listFieldSchema.mutableListAt(obj, offset(i)));
        }
    }

    private <E> void readMessageList(Object obj, int i, Reader reader, Schema<E> schema, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        reader.readMessageList(this.listFieldSchema.mutableListAt(obj, offset(i)), schema, extensionRegistryLite);
    }

    private <E> void readGroupList(Object obj, long j, Reader reader, Schema<E> schema, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        reader.readGroupList(this.listFieldSchema.mutableListAt(obj, j), schema, extensionRegistryLite);
    }

    private int numberAt(int i) {
        return this.buffer[i];
    }

    private int typeAndOffsetAt(int i) {
        return this.buffer[i + 1];
    }

    private int presenceMaskAndOffsetAt(int i) {
        return this.buffer[i + 2];
    }

    private static boolean isMutable(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof GeneratedMessageLite) {
            return ((GeneratedMessageLite) obj).isMutable();
        }
        return true;
    }

    private static void checkMutable(Object obj) {
        if (!isMutable(obj)) {
            throw new IllegalArgumentException("Mutating immutable message: " + obj);
        }
    }

    private static <T> double doubleAt(T t, long j) {
        return UnsafeUtil.getDouble((Object) t, j);
    }

    private static <T> float floatAt(T t, long j) {
        return UnsafeUtil.getFloat((Object) t, j);
    }

    private static <T> int intAt(T t, long j) {
        return UnsafeUtil.getInt((Object) t, j);
    }

    private static <T> long longAt(T t, long j) {
        return UnsafeUtil.getLong((Object) t, j);
    }

    private static <T> boolean booleanAt(T t, long j) {
        return UnsafeUtil.getBoolean((Object) t, j);
    }

    private static <T> double oneofDoubleAt(T t, long j) {
        return ((Double) UnsafeUtil.getObject((Object) t, j)).doubleValue();
    }

    private static <T> float oneofFloatAt(T t, long j) {
        return ((Float) UnsafeUtil.getObject((Object) t, j)).floatValue();
    }

    private static <T> int oneofIntAt(T t, long j) {
        return ((Integer) UnsafeUtil.getObject((Object) t, j)).intValue();
    }

    private static <T> long oneofLongAt(T t, long j) {
        return ((Long) UnsafeUtil.getObject((Object) t, j)).longValue();
    }

    private static <T> boolean oneofBooleanAt(T t, long j) {
        return ((Boolean) UnsafeUtil.getObject((Object) t, j)).booleanValue();
    }

    private boolean arePresentForEquals(T t, T t2, int i) {
        return isFieldPresent(t, i) == isFieldPresent(t2, i);
    }

    private boolean isFieldPresent(T t, int i, int i2, int i3, int i4) {
        if (i2 == 1048575) {
            return isFieldPresent(t, i);
        }
        return (i3 & i4) != 0;
    }

    private boolean isFieldPresent(T t, int i) {
        int presenceMaskAndOffsetAt = presenceMaskAndOffsetAt(i);
        long j = (long) (1048575 & presenceMaskAndOffsetAt);
        if (j == 1048575) {
            int typeAndOffsetAt = typeAndOffsetAt(i);
            long offset = offset(typeAndOffsetAt);
            switch (type(typeAndOffsetAt)) {
                case 0:
                    return Double.doubleToRawLongBits(UnsafeUtil.getDouble((Object) t, offset)) != 0;
                case 1:
                    return Float.floatToRawIntBits(UnsafeUtil.getFloat((Object) t, offset)) != 0;
                case 2:
                    return UnsafeUtil.getLong((Object) t, offset) != 0;
                case 3:
                    return UnsafeUtil.getLong((Object) t, offset) != 0;
                case 4:
                    return UnsafeUtil.getInt((Object) t, offset) != 0;
                case 5:
                    return UnsafeUtil.getLong((Object) t, offset) != 0;
                case 6:
                    return UnsafeUtil.getInt((Object) t, offset) != 0;
                case 7:
                    return UnsafeUtil.getBoolean((Object) t, offset);
                case 8:
                    Object object = UnsafeUtil.getObject((Object) t, offset);
                    if (object instanceof String) {
                        return !((String) object).isEmpty();
                    }
                    if (object instanceof ByteString) {
                        return !ByteString.EMPTY.equals(object);
                    }
                    throw new IllegalArgumentException();
                case 9:
                    return UnsafeUtil.getObject((Object) t, offset) != null;
                case 10:
                    return !ByteString.EMPTY.equals(UnsafeUtil.getObject((Object) t, offset));
                case 11:
                    return UnsafeUtil.getInt((Object) t, offset) != 0;
                case 12:
                    return UnsafeUtil.getInt((Object) t, offset) != 0;
                case 13:
                    return UnsafeUtil.getInt((Object) t, offset) != 0;
                case 14:
                    return UnsafeUtil.getLong((Object) t, offset) != 0;
                case 15:
                    return UnsafeUtil.getInt((Object) t, offset) != 0;
                case 16:
                    return UnsafeUtil.getLong((Object) t, offset) != 0;
                case 17:
                    return UnsafeUtil.getObject((Object) t, offset) != null;
                default:
                    throw new IllegalArgumentException();
            }
        } else {
            return (UnsafeUtil.getInt((Object) t, j) & (1 << (presenceMaskAndOffsetAt >>> 20))) != 0;
        }
    }

    private void setFieldPresent(T t, int i) {
        int presenceMaskAndOffsetAt = presenceMaskAndOffsetAt(i);
        long j = (long) (1048575 & presenceMaskAndOffsetAt);
        if (j != 1048575) {
            UnsafeUtil.putInt((Object) t, j, (1 << (presenceMaskAndOffsetAt >>> 20)) | UnsafeUtil.getInt((Object) t, j));
        }
    }

    private boolean isOneofPresent(T t, int i, int i2) {
        return UnsafeUtil.getInt((Object) t, (long) (presenceMaskAndOffsetAt(i2) & 1048575)) == i;
    }

    private boolean isOneofCaseEqual(T t, T t2, int i) {
        long presenceMaskAndOffsetAt = (long) (presenceMaskAndOffsetAt(i) & 1048575);
        return UnsafeUtil.getInt((Object) t, presenceMaskAndOffsetAt) == UnsafeUtil.getInt((Object) t2, presenceMaskAndOffsetAt);
    }

    private void setOneofPresent(T t, int i, int i2) {
        UnsafeUtil.putInt((Object) t, (long) (presenceMaskAndOffsetAt(i2) & 1048575), i);
    }

    private int positionForFieldNumber(int i) {
        if (i < this.minFieldNumber || i > this.maxFieldNumber) {
            return -1;
        }
        return slowPositionForFieldNumber(i, 0);
    }

    private int positionForFieldNumber(int i, int i2) {
        if (i < this.minFieldNumber || i > this.maxFieldNumber) {
            return -1;
        }
        return slowPositionForFieldNumber(i, i2);
    }

    private int slowPositionForFieldNumber(int i, int i2) {
        int length = (this.buffer.length / 3) - 1;
        while (i2 <= length) {
            int i3 = (length + i2) >>> 1;
            int i4 = i3 * 3;
            int numberAt = numberAt(i4);
            if (i == numberAt) {
                return i4;
            }
            if (i < numberAt) {
                length = i3 - 1;
            } else {
                i2 = i3 + 1;
            }
        }
        return -1;
    }

    /* access modifiers changed from: package-private */
    public int getSchemaSize() {
        return this.buffer.length * 3;
    }
}
