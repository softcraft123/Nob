package kotlin.io.encoding;

import com.google.common.base.Ascii;
import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.collections.AbstractList;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;
import kotlin.text.Charsets;
import okio.Utf8;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\b\u0017\u0018\u0000 <2\u00020\u0001:\u0002<=B\u001f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0015\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0000¢\u0006\u0002\b\u0011J%\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0015H\u0000¢\u0006\u0002\b\u0017J \u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\u00152\u0006\u0010\u001c\u001a\u00020\u0015H\u0002J\u0010\u0010\u001d\u001a\u00020\u00192\u0006\u0010\u001e\u001a\u00020\u0015H\u0002J%\u0010\u001f\u001a\u00020\u00192\u0006\u0010 \u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0015H\u0000¢\u0006\u0002\b!J\"\u0010\"\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u0015J\"\u0010\"\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u0015J0\u0010#\u001a\u00020\u00152\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010$\u001a\u00020\u00102\u0006\u0010\u001b\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0015H\u0002J4\u0010%\u001a\u00020\u00152\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010$\u001a\u00020\u00102\b\b\u0002\u0010\u001b\u001a\u00020\u00152\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u0015J4\u0010%\u001a\u00020\u00152\u0006\u0010\u000f\u001a\u00020\u00132\u0006\u0010$\u001a\u00020\u00102\b\b\u0002\u0010\u001b\u001a\u00020\u00152\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u0015J%\u0010&\u001a\u00020\u00152\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0015H\u0000¢\u0006\u0002\b'J\"\u0010(\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u0015J4\u0010)\u001a\u00020\u00152\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010$\u001a\u00020\u00102\b\b\u0002\u0010\u001b\u001a\u00020\u00152\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u0015J5\u0010*\u001a\u00020\u00152\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010$\u001a\u00020\u00102\u0006\u0010\u001b\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0015H\u0000¢\u0006\u0002\b+J\u0015\u0010,\u001a\u00020\u00152\u0006\u0010 \u001a\u00020\u0015H\u0000¢\u0006\u0002\b-J=\u0010.\u001a\u0002H/\"\f\b\u0000\u0010/*\u000600j\u0002`12\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010$\u001a\u0002H/2\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u0015¢\u0006\u0002\u00102J\"\u00103\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u0015J%\u00104\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0015H\u0000¢\u0006\u0002\b5J(\u00106\u001a\u00020\u00152\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u001e\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u00107\u001a\u00020\u0015H\u0002J\b\u00108\u001a\u00020\u0003H\u0002J \u00109\u001a\u00020\u00152\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0015H\u0002J\u0010\u0010:\u001a\u00020\u00002\u0006\u0010;\u001a\u00020\u0006H\u0007R\u0014\u0010\u0004\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0014\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006>"}, d2 = {"Lkotlin/io/encoding/Base64;", "", "isUrlSafe", "", "isMimeScheme", "paddingOption", "Lkotlin/io/encoding/Base64$PaddingOption;", "(ZZLkotlin/io/encoding/Base64$PaddingOption;)V", "isMimeScheme$kotlin_stdlib", "()Z", "isUrlSafe$kotlin_stdlib", "getPaddingOption$kotlin_stdlib", "()Lkotlin/io/encoding/Base64$PaddingOption;", "bytesToStringImpl", "", "source", "", "bytesToStringImpl$kotlin_stdlib", "charsToBytesImpl", "", "startIndex", "", "endIndex", "charsToBytesImpl$kotlin_stdlib", "checkDestinationBounds", "", "destinationSize", "destinationOffset", "capacityNeeded", "checkPaddingIsAllowed", "padIndex", "checkSourceBounds", "sourceSize", "checkSourceBounds$kotlin_stdlib", "decode", "decodeImpl", "destination", "decodeIntoByteArray", "decodeSize", "decodeSize$kotlin_stdlib", "encode", "encodeIntoByteArray", "encodeIntoByteArrayImpl", "encodeIntoByteArrayImpl$kotlin_stdlib", "encodeSize", "encodeSize$kotlin_stdlib", "encodeToAppendable", "A", "Ljava/lang/Appendable;", "Lkotlin/text/Appendable;", "([BLjava/lang/Appendable;II)Ljava/lang/Appendable;", "encodeToByteArray", "encodeToByteArrayImpl", "encodeToByteArrayImpl$kotlin_stdlib", "handlePaddingSymbol", "byteStart", "shouldPadOnEncode", "skipIllegalSymbolsIfMime", "withPadding", "option", "Default", "PaddingOption", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: Base64.kt */
public class Base64 {
    public static final Default Default = new Default((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final Base64 Mime = new Base64(false, true, PaddingOption.PRESENT);
    /* access modifiers changed from: private */
    public static final Base64 UrlSafe = new Base64(true, false, PaddingOption.PRESENT);
    private static final int bitsPerByte = 8;
    private static final int bitsPerSymbol = 6;
    public static final int bytesPerGroup = 3;
    private static final int mimeGroupsPerLine = 19;
    public static final int mimeLineLength = 76;
    /* access modifiers changed from: private */
    public static final byte[] mimeLineSeparatorSymbols = {Ascii.CR, 10};
    public static final byte padSymbol = 61;
    public static final int symbolsPerGroup = 4;
    private final boolean isMimeScheme;
    private final boolean isUrlSafe;
    private final PaddingOption paddingOption;

    public /* synthetic */ Base64(boolean z, boolean z2, PaddingOption paddingOption2, DefaultConstructorMarker defaultConstructorMarker) {
        this(z, z2, paddingOption2);
    }

    private Base64(boolean z, boolean z2, PaddingOption paddingOption2) {
        this.isUrlSafe = z;
        this.isMimeScheme = z2;
        this.paddingOption = paddingOption2;
        if (z && z2) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
    }

    public final boolean isUrlSafe$kotlin_stdlib() {
        return this.isUrlSafe;
    }

    public final boolean isMimeScheme$kotlin_stdlib() {
        return this.isMimeScheme;
    }

    public final PaddingOption getPaddingOption$kotlin_stdlib() {
        return this.paddingOption;
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lkotlin/io/encoding/Base64$PaddingOption;", "", "(Ljava/lang/String;I)V", "PRESENT", "ABSENT", "PRESENT_OPTIONAL", "ABSENT_OPTIONAL", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: Base64.kt */
    public enum PaddingOption {
        PRESENT,
        ABSENT,
        PRESENT_OPTIONAL,
        ABSENT_OPTIONAL;

        public static EnumEntries<PaddingOption> getEntries() {
            return $ENTRIES;
        }

        static {
            PaddingOption[] $values;
            $ENTRIES = EnumEntriesKt.enumEntries((E[]) (Enum[]) $values);
        }
    }

    public final Base64 withPadding(PaddingOption paddingOption2) {
        Intrinsics.checkNotNullParameter(paddingOption2, "option");
        if (this.paddingOption == paddingOption2) {
            return this;
        }
        return new Base64(this.isUrlSafe, this.isMimeScheme, paddingOption2);
    }

    public static /* synthetic */ byte[] encodeToByteArray$default(Base64 base64, byte[] bArr, int i, int i2, int i3, Object obj) {
        if (obj == null) {
            if ((i3 & 2) != 0) {
                i = 0;
            }
            if ((i3 & 4) != 0) {
                i2 = bArr.length;
            }
            return base64.encodeToByteArray(bArr, i, i2);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: encodeToByteArray");
    }

    public final byte[] encodeToByteArray(byte[] bArr, int i, int i2) {
        Intrinsics.checkNotNullParameter(bArr, "source");
        return encodeToByteArrayImpl$kotlin_stdlib(bArr, i, i2);
    }

    public static /* synthetic */ int encodeIntoByteArray$default(Base64 base64, byte[] bArr, byte[] bArr2, int i, int i2, int i3, int i4, Object obj) {
        if (obj == null) {
            if ((i4 & 4) != 0) {
                i = 0;
            }
            if ((i4 & 8) != 0) {
                i2 = 0;
            }
            if ((i4 & 16) != 0) {
                i3 = bArr.length;
            }
            return base64.encodeIntoByteArray(bArr, bArr2, i, i2, i3);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: encodeIntoByteArray");
    }

    public final int encodeIntoByteArray(byte[] bArr, byte[] bArr2, int i, int i2, int i3) {
        Intrinsics.checkNotNullParameter(bArr, "source");
        Intrinsics.checkNotNullParameter(bArr2, "destination");
        return encodeIntoByteArrayImpl$kotlin_stdlib(bArr, bArr2, i, i2, i3);
    }

    public static /* synthetic */ String encode$default(Base64 base64, byte[] bArr, int i, int i2, int i3, Object obj) {
        if (obj == null) {
            if ((i3 & 2) != 0) {
                i = 0;
            }
            if ((i3 & 4) != 0) {
                i2 = bArr.length;
            }
            return base64.encode(bArr, i, i2);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: encode");
    }

    public final String encode(byte[] bArr, int i, int i2) {
        Intrinsics.checkNotNullParameter(bArr, "source");
        return new String(encodeToByteArrayImpl$kotlin_stdlib(bArr, i, i2), Charsets.ISO_8859_1);
    }

    public static /* synthetic */ Appendable encodeToAppendable$default(Base64 base64, byte[] bArr, Appendable appendable, int i, int i2, int i3, Object obj) {
        if (obj == null) {
            if ((i3 & 4) != 0) {
                i = 0;
            }
            if ((i3 & 8) != 0) {
                i2 = bArr.length;
            }
            return base64.encodeToAppendable(bArr, appendable, i, i2);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: encodeToAppendable");
    }

    public final <A extends Appendable> A encodeToAppendable(byte[] bArr, A a, int i, int i2) {
        Intrinsics.checkNotNullParameter(bArr, "source");
        Intrinsics.checkNotNullParameter(a, "destination");
        a.append(new String(encodeToByteArrayImpl$kotlin_stdlib(bArr, i, i2), Charsets.ISO_8859_1));
        return a;
    }

    public static /* synthetic */ byte[] decode$default(Base64 base64, byte[] bArr, int i, int i2, int i3, Object obj) {
        if (obj == null) {
            if ((i3 & 2) != 0) {
                i = 0;
            }
            if ((i3 & 4) != 0) {
                i2 = bArr.length;
            }
            return base64.decode(bArr, i, i2);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: decode");
    }

    public final byte[] decode(byte[] bArr, int i, int i2) {
        Intrinsics.checkNotNullParameter(bArr, "source");
        checkSourceBounds$kotlin_stdlib(bArr.length, i, i2);
        int decodeSize$kotlin_stdlib = decodeSize$kotlin_stdlib(bArr, i, i2);
        byte[] bArr2 = new byte[decodeSize$kotlin_stdlib];
        if (decodeImpl(bArr, bArr2, 0, i, i2) == decodeSize$kotlin_stdlib) {
            return bArr2;
        }
        throw new IllegalStateException("Check failed.".toString());
    }

    public static /* synthetic */ int decodeIntoByteArray$default(Base64 base64, byte[] bArr, byte[] bArr2, int i, int i2, int i3, int i4, Object obj) {
        if (obj == null) {
            if ((i4 & 4) != 0) {
                i = 0;
            }
            if ((i4 & 8) != 0) {
                i2 = 0;
            }
            if ((i4 & 16) != 0) {
                i3 = bArr.length;
            }
            return base64.decodeIntoByteArray(bArr, bArr2, i, i2, i3);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: decodeIntoByteArray");
    }

    public final int decodeIntoByteArray(byte[] bArr, byte[] bArr2, int i, int i2, int i3) {
        Intrinsics.checkNotNullParameter(bArr, "source");
        Intrinsics.checkNotNullParameter(bArr2, "destination");
        checkSourceBounds$kotlin_stdlib(bArr.length, i2, i3);
        checkDestinationBounds(bArr2.length, i, decodeSize$kotlin_stdlib(bArr, i2, i3));
        return decodeImpl(bArr, bArr2, i, i2, i3);
    }

    public static /* synthetic */ byte[] decode$default(Base64 base64, CharSequence charSequence, int i, int i2, int i3, Object obj) {
        if (obj == null) {
            if ((i3 & 2) != 0) {
                i = 0;
            }
            if ((i3 & 4) != 0) {
                i2 = charSequence.length();
            }
            return base64.decode(charSequence, i, i2);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: decode");
    }

    public final byte[] decode(CharSequence charSequence, int i, int i2) {
        byte[] bArr;
        Intrinsics.checkNotNullParameter(charSequence, "source");
        if (charSequence instanceof String) {
            checkSourceBounds$kotlin_stdlib(charSequence.length(), i, i2);
            String substring = ((String) charSequence).substring(i, i2);
            Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
            Charset charset = Charsets.ISO_8859_1;
            Intrinsics.checkNotNull(substring, "null cannot be cast to non-null type java.lang.String");
            bArr = substring.getBytes(charset);
            Intrinsics.checkNotNullExpressionValue(bArr, "getBytes(...)");
        } else {
            bArr = charsToBytesImpl$kotlin_stdlib(charSequence, i, i2);
        }
        return decode$default(this, bArr, 0, 0, 6, (Object) null);
    }

    public static /* synthetic */ int decodeIntoByteArray$default(Base64 base64, CharSequence charSequence, byte[] bArr, int i, int i2, int i3, int i4, Object obj) {
        if (obj == null) {
            if ((i4 & 4) != 0) {
                i = 0;
            }
            if ((i4 & 8) != 0) {
                i2 = 0;
            }
            if ((i4 & 16) != 0) {
                i3 = charSequence.length();
            }
            return base64.decodeIntoByteArray(charSequence, bArr, i, i2, i3);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: decodeIntoByteArray");
    }

    public final int decodeIntoByteArray(CharSequence charSequence, byte[] bArr, int i, int i2, int i3) {
        byte[] bArr2;
        Intrinsics.checkNotNullParameter(charSequence, "source");
        Intrinsics.checkNotNullParameter(bArr, "destination");
        if (charSequence instanceof String) {
            checkSourceBounds$kotlin_stdlib(charSequence.length(), i2, i3);
            String substring = ((String) charSequence).substring(i2, i3);
            Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
            Charset charset = Charsets.ISO_8859_1;
            Intrinsics.checkNotNull(substring, "null cannot be cast to non-null type java.lang.String");
            bArr2 = substring.getBytes(charset);
            Intrinsics.checkNotNullExpressionValue(bArr2, "getBytes(...)");
        } else {
            bArr2 = charsToBytesImpl$kotlin_stdlib(charSequence, i2, i3);
        }
        return decodeIntoByteArray$default(this, bArr2, bArr, i, 0, 0, 24, (Object) null);
    }

    public final byte[] encodeToByteArrayImpl$kotlin_stdlib(byte[] bArr, int i, int i2) {
        Intrinsics.checkNotNullParameter(bArr, "source");
        checkSourceBounds$kotlin_stdlib(bArr.length, i, i2);
        byte[] bArr2 = new byte[encodeSize$kotlin_stdlib(i2 - i)];
        encodeIntoByteArrayImpl$kotlin_stdlib(bArr, bArr2, 0, i, i2);
        return bArr2;
    }

    public final int encodeIntoByteArrayImpl$kotlin_stdlib(byte[] bArr, byte[] bArr2, int i, int i2, int i3) {
        byte[] bArr3 = bArr;
        byte[] bArr4 = bArr2;
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        Intrinsics.checkNotNullParameter(bArr3, "source");
        Intrinsics.checkNotNullParameter(bArr4, "destination");
        checkSourceBounds$kotlin_stdlib(bArr3.length, i5, i6);
        checkDestinationBounds(bArr4.length, i4, encodeSize$kotlin_stdlib(i6 - i5));
        byte[] access$getBase64UrlEncodeMap$p = this.isUrlSafe ? Base64Kt.base64UrlEncodeMap : Base64Kt.base64EncodeMap;
        int i7 = this.isMimeScheme ? 19 : Integer.MAX_VALUE;
        int i8 = i4;
        while (i5 + 2 < i6) {
            int min = Math.min((i6 - i5) / 3, i7);
            for (int i9 = 0; i9 < min; i9++) {
                int i10 = i5 + 2;
                i5 += 3;
                byte b = ((bArr3[i5 + 1] & 255) << 8) | ((bArr3[i5] & 255) << Ascii.DLE) | (bArr3[i10] & 255);
                bArr4[i8] = access$getBase64UrlEncodeMap$p[b >>> Ascii.DC2];
                bArr4[i8 + 1] = access$getBase64UrlEncodeMap$p[(b >>> Ascii.FF) & 63];
                int i11 = i8 + 3;
                bArr4[i8 + 2] = access$getBase64UrlEncodeMap$p[(b >>> 6) & 63];
                i8 += 4;
                bArr4[i11] = access$getBase64UrlEncodeMap$p[b & Utf8.REPLACEMENT_BYTE];
            }
            if (min == i7 && i5 != i6) {
                int i12 = i8 + 1;
                byte[] bArr5 = mimeLineSeparatorSymbols;
                bArr4[i8] = bArr5[0];
                i8 += 2;
                bArr4[i12] = bArr5[1];
            }
        }
        int i13 = i6 - i5;
        if (i13 == 1) {
            int i14 = i5 + 1;
            int i15 = (bArr3[i5] & 255) << 4;
            bArr4[i8] = access$getBase64UrlEncodeMap$p[i15 >>> 6];
            int i16 = i8 + 2;
            bArr4[i8 + 1] = access$getBase64UrlEncodeMap$p[i15 & 63];
            if (shouldPadOnEncode()) {
                int i17 = i8 + 3;
                bArr4[i16] = padSymbol;
                i8 += 4;
                bArr4[i17] = padSymbol;
                i5 = i14;
            } else {
                i5 = i14;
                i8 = i16;
            }
        } else if (i13 == 2) {
            int i18 = i5 + 1;
            i5 += 2;
            int i19 = ((bArr3[i18] & 255) << 2) | ((bArr3[i5] & 255) << 10);
            bArr4[i8] = access$getBase64UrlEncodeMap$p[i19 >>> 12];
            bArr4[i8 + 1] = access$getBase64UrlEncodeMap$p[(i19 >>> 6) & 63];
            int i20 = i8 + 3;
            bArr4[i8 + 2] = access$getBase64UrlEncodeMap$p[i19 & 63];
            if (shouldPadOnEncode()) {
                i8 += 4;
                bArr4[i20] = padSymbol;
            } else {
                i8 = i20;
            }
        }
        if (i5 == i6) {
            return i8 - i4;
        }
        throw new IllegalStateException("Check failed.".toString());
    }

    public final int encodeSize$kotlin_stdlib(int i) {
        int i2 = i / 3;
        int i3 = i % 3;
        int i4 = 4;
        int i5 = i2 * 4;
        if (i3 != 0) {
            if (!shouldPadOnEncode()) {
                i4 = i3 + 1;
            }
            i5 += i4;
        }
        if (this.isMimeScheme) {
            i5 += ((i5 - 1) / 76) * 2;
        }
        if (i5 >= 0) {
            return i5;
        }
        throw new IllegalArgumentException("Input is too big");
    }

    private final boolean shouldPadOnEncode() {
        return this.paddingOption == PaddingOption.PRESENT || this.paddingOption == PaddingOption.PRESENT_OPTIONAL;
    }

    private final int decodeImpl(byte[] bArr, byte[] bArr2, int i, int i2, int i3) {
        int i4;
        int i5;
        int i6;
        byte[] bArr3 = bArr;
        int i7 = i3;
        int[] access$getBase64UrlDecodeMap$p = this.isUrlSafe ? Base64Kt.base64UrlDecodeMap : Base64Kt.base64DecodeMap;
        int i8 = -8;
        int i9 = i;
        int i10 = i2;
        int i11 = -8;
        int i12 = 0;
        while (true) {
            if (i10 >= i7) {
                i4 = 8;
                i5 = 0;
                break;
            }
            if (i11 != i8 || i10 + 3 >= i7) {
                i4 = 8;
                i6 = 1;
            } else {
                i4 = 8;
                i6 = 1;
                int i13 = i10 + 4;
                int i14 = (access$getBase64UrlDecodeMap$p[bArr3[i10 + 1] & 255] << 12) | (access$getBase64UrlDecodeMap$p[bArr3[i10] & 255] << 18) | (access$getBase64UrlDecodeMap$p[bArr3[i10 + 2] & 255] << 6) | access$getBase64UrlDecodeMap$p[bArr3[i10 + 3] & 255];
                if (i14 >= 0) {
                    bArr2[i9] = (byte) (i14 >> 16);
                    int i15 = i9 + 2;
                    bArr2[i9 + 1] = (byte) (i14 >> 8);
                    i9 += 3;
                    bArr2[i15] = (byte) i14;
                    i10 = i13;
                    i8 = -8;
                }
            }
            byte b = bArr3[i10] & 255;
            int i16 = access$getBase64UrlDecodeMap$p[b];
            if (i16 >= 0) {
                i10++;
                i12 = (i12 << 6) | i16;
                int i17 = i11 + 6;
                if (i17 >= 0) {
                    bArr2[i9] = (byte) (i12 >>> i17);
                    i12 &= (i6 << i17) - 1;
                    i11 -= 2;
                    i9++;
                } else {
                    i11 = i17;
                }
            } else if (i16 == -2) {
                i10 = handlePaddingSymbol(bArr3, i10, i7, i11);
                i5 = i6;
                break;
            } else if (this.isMimeScheme) {
                i10++;
            } else {
                StringBuilder append = new StringBuilder("Invalid symbol '").append((char) b).append("'(");
                String num = Integer.toString(b, CharsKt.checkRadix(i4));
                Intrinsics.checkNotNullExpressionValue(num, "toString(...)");
                throw new IllegalArgumentException(append.append(num).append(") at index ").append(i10).toString());
            }
            i8 = -8;
        }
        if (i11 == -2) {
            throw new IllegalArgumentException("The last unit of input does not have enough bits");
        } else if (i11 != -8 && i5 == 0 && this.paddingOption == PaddingOption.PRESENT) {
            throw new IllegalArgumentException("The padding option is set to PRESENT, but the input is not properly padded");
        } else if (i12 == 0) {
            int skipIllegalSymbolsIfMime = skipIllegalSymbolsIfMime(bArr3, i10, i7);
            if (skipIllegalSymbolsIfMime >= i7) {
                return i9 - i;
            }
            byte b2 = bArr3[skipIllegalSymbolsIfMime] & 255;
            StringBuilder append2 = new StringBuilder("Symbol '").append((char) b2).append("'(");
            String num2 = Integer.toString(b2, CharsKt.checkRadix(i4));
            Intrinsics.checkNotNullExpressionValue(num2, "toString(...)");
            throw new IllegalArgumentException(append2.append(num2).append(") at index ").append(skipIllegalSymbolsIfMime - 1).append(" is prohibited after the pad character").toString());
        } else {
            throw new IllegalArgumentException("The pad bits must be zeros");
        }
    }

    public final int decodeSize$kotlin_stdlib(byte[] bArr, int i, int i2) {
        Intrinsics.checkNotNullParameter(bArr, "source");
        int i3 = i2 - i;
        if (i3 == 0) {
            return 0;
        }
        if (i3 != 1) {
            if (this.isMimeScheme) {
                while (true) {
                    if (i >= i2) {
                        break;
                    }
                    int i4 = Base64Kt.base64DecodeMap[bArr[i] & 255];
                    if (i4 < 0) {
                        if (i4 == -2) {
                            i3 -= i2 - i;
                            break;
                        }
                        i3--;
                    }
                    i++;
                }
            } else if (bArr[i2 - 1] == 61) {
                i3 = bArr[i2 + -2] == 61 ? i3 - 2 : i3 - 1;
            }
            return (int) ((((long) i3) * ((long) 6)) / ((long) 8));
        }
        throw new IllegalArgumentException("Input should have at least 2 symbols for Base64 decoding, startIndex: " + i + ", endIndex: " + i2);
    }

    public final byte[] charsToBytesImpl$kotlin_stdlib(CharSequence charSequence, int i, int i2) {
        Intrinsics.checkNotNullParameter(charSequence, "source");
        checkSourceBounds$kotlin_stdlib(charSequence.length(), i, i2);
        byte[] bArr = new byte[(i2 - i)];
        int i3 = 0;
        while (i < i2) {
            char charAt = charSequence.charAt(i);
            if (charAt <= 255) {
                bArr[i3] = (byte) charAt;
                i3++;
            } else {
                bArr[i3] = Utf8.REPLACEMENT_BYTE;
                i3++;
            }
            i++;
        }
        return bArr;
    }

    public final String bytesToStringImpl$kotlin_stdlib(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "source");
        StringBuilder sb = new StringBuilder(bArr.length);
        for (byte b : bArr) {
            sb.append((char) b);
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "toString(...)");
        return sb2;
    }

    private final int handlePaddingSymbol(byte[] bArr, int i, int i2, int i3) {
        if (i3 == -8) {
            throw new IllegalArgumentException("Redundant pad character at index " + i);
        } else if (i3 == -6) {
            checkPaddingIsAllowed(i);
            return i + 1;
        } else if (i3 == -4) {
            checkPaddingIsAllowed(i);
            int skipIllegalSymbolsIfMime = skipIllegalSymbolsIfMime(bArr, i + 1, i2);
            if (skipIllegalSymbolsIfMime != i2 && bArr[skipIllegalSymbolsIfMime] == 61) {
                return skipIllegalSymbolsIfMime + 1;
            }
            throw new IllegalArgumentException("Missing one pad character at index " + skipIllegalSymbolsIfMime);
        } else if (i3 == -2) {
            return i + 1;
        } else {
            throw new IllegalStateException("Unreachable".toString());
        }
    }

    private final void checkPaddingIsAllowed(int i) {
        if (this.paddingOption == PaddingOption.ABSENT) {
            throw new IllegalArgumentException("The padding option is set to ABSENT, but the input has a pad character at index " + i);
        }
    }

    private final int skipIllegalSymbolsIfMime(byte[] bArr, int i, int i2) {
        if (!this.isMimeScheme) {
            return i;
        }
        while (i < i2) {
            if (Base64Kt.base64DecodeMap[bArr[i] & 255] != -1) {
                break;
            }
            i++;
        }
        return i;
    }

    public final void checkSourceBounds$kotlin_stdlib(int i, int i2, int i3) {
        AbstractList.Companion.checkBoundsIndexes$kotlin_stdlib(i2, i3, i);
    }

    private final void checkDestinationBounds(int i, int i2, int i3) {
        if (i2 < 0 || i2 > i) {
            throw new IndexOutOfBoundsException("destination offset: " + i2 + ", destination size: " + i);
        }
        int i4 = i2 + i3;
        if (i4 < 0 || i4 > i) {
            throw new IndexOutOfBoundsException("The destination array does not have enough capacity, destination offset: " + i2 + ", destination size: " + i + ", capacity needed: " + i3);
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\u0005\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0006\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u0005R\u000e\u0010\b\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\u0013XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\tXT¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lkotlin/io/encoding/Base64$Default;", "Lkotlin/io/encoding/Base64;", "()V", "Mime", "getMime", "()Lkotlin/io/encoding/Base64;", "UrlSafe", "getUrlSafe", "bitsPerByte", "", "bitsPerSymbol", "bytesPerGroup", "mimeGroupsPerLine", "mimeLineLength", "mimeLineSeparatorSymbols", "", "getMimeLineSeparatorSymbols$kotlin_stdlib", "()[B", "padSymbol", "", "symbolsPerGroup", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: Base64.kt */
    public static final class Default extends Base64 {
        public /* synthetic */ Default(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Default() {
            super(false, false, PaddingOption.PRESENT, (DefaultConstructorMarker) null);
        }

        public final byte[] getMimeLineSeparatorSymbols$kotlin_stdlib() {
            return Base64.mimeLineSeparatorSymbols;
        }

        public final Base64 getUrlSafe() {
            return Base64.UrlSafe;
        }

        public final Base64 getMime() {
            return Base64.Mime;
        }
    }
}
