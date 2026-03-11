package kotlin.uuid;

import java.io.Serializable;
import java.util.Comparator;
import kotlin.Metadata;
import kotlin.ULong;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.HexExtensionsKt;
import kotlin.text.HexFormat;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 !2\u00060\u0001j\u0002`\u0002:\u0001!B\u0017\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0002\u0010\u0006J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0002J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\u0006\u0010\u0013\u001a\u00020\u0014J\u0006\u0010\u0015\u001a\u00020\u0016J\\\u0010\u0017\u001a\u0002H\u0018\"\u0004\b\u0000\u0010\u001826\u0010\u0019\u001a2\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(\u0003\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u0002H\u00180\u001aH\bø\u0001\u0000\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0002\u0010\u001dJ\b\u0010\u001e\u001a\u00020\u0016H\u0016J\\\u0010\u001f\u001a\u0002H\u0018\"\u0004\b\u0000\u0010\u001826\u0010\u0019\u001a2\u0012\u0013\u0012\u00110 ¢\u0006\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(\u0003\u0012\u0013\u0012\u00110 ¢\u0006\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u0002H\u00180\u001aH\bø\u0001\u0000\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0002\u0010\u001dR\u001c\u0010\u0005\u001a\u00020\u00048\u0000X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR\u001c\u0010\u0003\u001a\u00020\u00048\u0000X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000b\u0010\b\u001a\u0004\b\f\u0010\n\u0002\u0007\n\u0005\b20\u0001¨\u0006\""}, d2 = {"Lkotlin/uuid/Uuid;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "mostSignificantBits", "", "leastSignificantBits", "(JJ)V", "getLeastSignificantBits$annotations", "()V", "getLeastSignificantBits", "()J", "getMostSignificantBits$annotations", "getMostSignificantBits", "equals", "", "other", "", "hashCode", "", "toByteArray", "", "toHexString", "", "toLongs", "T", "action", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "(Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "toString", "toULongs", "Lkotlin/ULong;", "Companion", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: Uuid.kt */
public final class Uuid implements Serializable {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final Comparator<Uuid> LEXICAL_ORDER = new Uuid$$ExternalSyntheticLambda0();
    /* access modifiers changed from: private */
    public static final Uuid NIL = new Uuid(0, 0);
    public static final int SIZE_BITS = 128;
    public static final int SIZE_BYTES = 16;
    private final long leastSignificantBits;
    private final long mostSignificantBits;

    public static /* synthetic */ void getLeastSignificantBits$annotations() {
    }

    public static /* synthetic */ void getMostSignificantBits$annotations() {
    }

    public Uuid(long j, long j2) {
        this.mostSignificantBits = j;
        this.leastSignificantBits = j2;
    }

    public final long getMostSignificantBits() {
        return this.mostSignificantBits;
    }

    public final long getLeastSignificantBits() {
        return this.leastSignificantBits;
    }

    private final <T> T toLongs(Function2<? super Long, ? super Long, ? extends T> function2) {
        Intrinsics.checkNotNullParameter(function2, "action");
        return function2.invoke(Long.valueOf(getMostSignificantBits()), Long.valueOf(getLeastSignificantBits()));
    }

    private final <T> T toULongs(Function2<? super ULong, ? super ULong, ? extends T> function2) {
        Intrinsics.checkNotNullParameter(function2, "action");
        return function2.invoke(ULong.m684boximpl(ULong.m690constructorimpl(getMostSignificantBits())), ULong.m684boximpl(ULong.m690constructorimpl(getLeastSignificantBits())));
    }

    public String toString() {
        byte[] bArr = new byte[36];
        UuidKt__UuidKt.formatBytesInto$UuidKt__UuidKt(this.leastSignificantBits, bArr, 24, 6);
        bArr[23] = 45;
        UuidKt__UuidKt.formatBytesInto$UuidKt__UuidKt(this.leastSignificantBits >>> 48, bArr, 19, 2);
        bArr[18] = 45;
        UuidKt__UuidKt.formatBytesInto$UuidKt__UuidKt(this.mostSignificantBits, bArr, 14, 2);
        bArr[13] = 45;
        UuidKt__UuidKt.formatBytesInto$UuidKt__UuidKt(this.mostSignificantBits >>> 16, bArr, 9, 2);
        bArr[8] = 45;
        UuidKt__UuidKt.formatBytesInto$UuidKt__UuidKt(this.mostSignificantBits >>> 32, bArr, 0, 4);
        return StringsKt.decodeToString(bArr);
    }

    public final String toHexString() {
        byte[] bArr = new byte[32];
        UuidKt__UuidKt.formatBytesInto$UuidKt__UuidKt(this.leastSignificantBits, bArr, 16, 8);
        UuidKt__UuidKt.formatBytesInto$UuidKt__UuidKt(this.mostSignificantBits, bArr, 0, 8);
        return StringsKt.decodeToString(bArr);
    }

    public final byte[] toByteArray() {
        byte[] bArr = new byte[16];
        UuidKt__UuidKt.toByteArray$UuidKt__UuidKt(this.mostSignificantBits, bArr, 0);
        UuidKt__UuidKt.toByteArray$UuidKt__UuidKt(this.leastSignificantBits, bArr, 8);
        return bArr;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Uuid)) {
            return false;
        }
        Uuid uuid = (Uuid) obj;
        return this.mostSignificantBits == uuid.mostSignificantBits && this.leastSignificantBits == uuid.leastSignificantBits;
    }

    public int hashCode() {
        long j = this.mostSignificantBits ^ this.leastSignificantBits;
        return ((int) j) ^ ((int) (j >> 32));
    }

    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0011J\u0016\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0014J\u001d\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u00172\u0006\u0010\u0015\u001a\u00020\u0017¢\u0006\u0004\b\u0018\u0010\u0019J\u000e\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u001cJ\u000e\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u001cJ\u0006\u0010\u001f\u001a\u00020\u0005R!\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rXT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rXT¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lkotlin/uuid/Uuid$Companion;", "", "()V", "LEXICAL_ORDER", "Ljava/util/Comparator;", "Lkotlin/uuid/Uuid;", "Lkotlin/Comparator;", "getLEXICAL_ORDER", "()Ljava/util/Comparator;", "NIL", "getNIL", "()Lkotlin/uuid/Uuid;", "SIZE_BITS", "", "SIZE_BYTES", "fromByteArray", "byteArray", "", "fromLongs", "mostSignificantBits", "", "leastSignificantBits", "fromULongs", "Lkotlin/ULong;", "fromULongs-eb3DHEI", "(JJ)Lkotlin/uuid/Uuid;", "parse", "uuidString", "", "parseHex", "hexString", "random", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: Uuid.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Uuid getNIL() {
            return Uuid.NIL;
        }

        public final Uuid fromLongs(long j, long j2) {
            if (j == 0 && j2 == 0) {
                return getNIL();
            }
            return new Uuid(j, j2);
        }

        /* renamed from: fromULongs-eb3DHEI  reason: not valid java name */
        public final Uuid m2020fromULongseb3DHEI(long j, long j2) {
            return fromLongs(j, j2);
        }

        public final Uuid fromByteArray(byte[] bArr) {
            Intrinsics.checkNotNullParameter(bArr, "byteArray");
            if (bArr.length == 16) {
                return fromLongs(UuidKt__UuidKt.toLong$UuidKt__UuidKt(bArr, 0), UuidKt__UuidKt.toLong$UuidKt__UuidKt(bArr, 8));
            }
            throw new IllegalArgumentException("Expected exactly 16 bytes".toString());
        }

        public final Uuid parse(String str) {
            Intrinsics.checkNotNullParameter(str, "uuidString");
            if (str.length() == 36) {
                String str2 = str;
                long hexToLong$default = HexExtensionsKt.hexToLong$default(str2, 0, 8, (HexFormat) null, 4, (Object) null);
                UuidKt__UuidKt.checkHyphenAt$UuidKt__UuidKt(str2, 8);
                long hexToLong$default2 = HexExtensionsKt.hexToLong$default(str2, 9, 13, (HexFormat) null, 4, (Object) null);
                UuidKt__UuidKt.checkHyphenAt$UuidKt__UuidKt(str2, 13);
                long hexToLong$default3 = HexExtensionsKt.hexToLong$default(str2, 14, 18, (HexFormat) null, 4, (Object) null);
                UuidKt__UuidKt.checkHyphenAt$UuidKt__UuidKt(str2, 18);
                long hexToLong$default4 = HexExtensionsKt.hexToLong$default(str2, 19, 23, (HexFormat) null, 4, (Object) null);
                UuidKt__UuidKt.checkHyphenAt$UuidKt__UuidKt(str2, 23);
                return fromLongs((hexToLong$default << 32) | (hexToLong$default2 << 16) | hexToLong$default3, HexExtensionsKt.hexToLong$default(str2, 24, 36, (HexFormat) null, 4, (Object) null) | (hexToLong$default4 << 48));
            }
            throw new IllegalArgumentException("Expected a 36-char string in the standard uuid format.".toString());
        }

        public final Uuid parseHex(String str) {
            Intrinsics.checkNotNullParameter(str, "hexString");
            if (str.length() == 32) {
                String str2 = str;
                return fromLongs(HexExtensionsKt.hexToLong$default(str2, 0, 16, (HexFormat) null, 4, (Object) null), HexExtensionsKt.hexToLong$default(str2, 16, 32, (HexFormat) null, 4, (Object) null));
            }
            throw new IllegalArgumentException("Expected a 32-char hexadecimal string.".toString());
        }

        public final Uuid random() {
            return UuidKt.secureRandomUuid();
        }

        public final Comparator<Uuid> getLEXICAL_ORDER() {
            return Uuid.LEXICAL_ORDER;
        }
    }

    /* access modifiers changed from: private */
    public static final int LEXICAL_ORDER$lambda$2(Uuid uuid, Uuid uuid2) {
        long j = uuid.mostSignificantBits;
        if (j != uuid2.mostSignificantBits) {
            return Long.compareUnsigned(ULong.m690constructorimpl(j), ULong.m690constructorimpl(uuid2.mostSignificantBits));
        }
        return Long.compareUnsigned(ULong.m690constructorimpl(uuid.leastSignificantBits), ULong.m690constructorimpl(uuid2.leastSignificantBits));
    }
}
