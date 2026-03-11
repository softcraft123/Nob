package okio.internal;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.google.common.base.Ascii;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okio.Base64;
import okio.Buffer;
import okio.SegmentedByteString;
import okio._JvmPlatformKt;

@Metadata(d1 = {"\u0000R\n\u0000\n\u0002\u0010\u0019\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\f\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0005\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0000\u001a\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0007H\u0002\u001a\u0011\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\tH\b\u001a\u0010\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0010H\u0002\u001a\r\u0010\u0011\u001a\u00020\u0012*\u00020\fH\b\u001a\r\u0010\u0013\u001a\u00020\u0012*\u00020\fH\b\u001a\u0015\u0010\u0014\u001a\u00020\u0007*\u00020\f2\u0006\u0010\u0015\u001a\u00020\fH\b\u001a-\u0010\u0016\u001a\u00020\u0017*\u00020\f2\u0006\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u0007H\b\u001a\u000f\u0010\u001c\u001a\u0004\u0018\u00010\f*\u00020\u0012H\b\u001a\r\u0010\u001d\u001a\u00020\f*\u00020\u0012H\b\u001a\r\u0010\u001e\u001a\u00020\f*\u00020\u0012H\b\u001a\u0015\u0010\u001f\u001a\u00020 *\u00020\f2\u0006\u0010!\u001a\u00020\tH\b\u001a\u0015\u0010\u001f\u001a\u00020 *\u00020\f2\u0006\u0010!\u001a\u00020\fH\b\u001a\u0017\u0010\"\u001a\u00020 *\u00020\f2\b\u0010\u0015\u001a\u0004\u0018\u00010#H\b\u001a\u0015\u0010$\u001a\u00020%*\u00020\f2\u0006\u0010&\u001a\u00020\u0007H\b\u001a\r\u0010'\u001a\u00020\u0007*\u00020\fH\b\u001a\r\u0010(\u001a\u00020\u0007*\u00020\fH\b\u001a\r\u0010)\u001a\u00020\u0012*\u00020\fH\b\u001a\u001d\u0010*\u001a\u00020\u0007*\u00020\f2\u0006\u0010\u0015\u001a\u00020\t2\u0006\u0010+\u001a\u00020\u0007H\b\u001a\r\u0010,\u001a\u00020\t*\u00020\fH\b\u001a\u001d\u0010-\u001a\u00020\u0007*\u00020\f2\u0006\u0010\u0015\u001a\u00020\t2\u0006\u0010+\u001a\u00020\u0007H\b\u001a\u001d\u0010-\u001a\u00020\u0007*\u00020\f2\u0006\u0010\u0015\u001a\u00020\f2\u0006\u0010+\u001a\u00020\u0007H\b\u001a-\u0010.\u001a\u00020 *\u00020\f2\u0006\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\t2\u0006\u0010/\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u0007H\b\u001a-\u0010.\u001a\u00020 *\u00020\f2\u0006\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\f2\u0006\u0010/\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u0007H\b\u001a\u0015\u00100\u001a\u00020 *\u00020\f2\u0006\u00101\u001a\u00020\tH\b\u001a\u0015\u00100\u001a\u00020 *\u00020\f2\u0006\u00101\u001a\u00020\fH\b\u001a\u001d\u00102\u001a\u00020\f*\u00020\f2\u0006\u00103\u001a\u00020\u00072\u0006\u00104\u001a\u00020\u0007H\b\u001a\r\u00105\u001a\u00020\f*\u00020\fH\b\u001a\r\u00106\u001a\u00020\f*\u00020\fH\b\u001a\r\u00107\u001a\u00020\t*\u00020\fH\b\u001a\u001d\u00108\u001a\u00020\f*\u00020\t2\u0006\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u0007H\b\u001a\r\u00109\u001a\u00020\u0012*\u00020\fH\b\u001a\r\u0010:\u001a\u00020\u0012*\u00020\fH\b\u001a$\u0010;\u001a\u00020\u0017*\u00020\f2\u0006\u0010<\u001a\u00020=2\u0006\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u0007H\u0000\"\u001c\u0010\u0000\u001a\u00020\u00018\u0000X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0002\u0010\u0003\u001a\u0004\b\u0004\u0010\u0005¨\u0006>"}, d2 = {"HEX_DIGIT_CHARS", "", "getHEX_DIGIT_CHARS$annotations", "()V", "getHEX_DIGIT_CHARS", "()[C", "codePointIndexToCharIndex", "", "s", "", "codePointCount", "commonOf", "Lokio/ByteString;", "data", "decodeHexDigit", "c", "", "commonBase64", "", "commonBase64Url", "commonCompareTo", "other", "commonCopyInto", "", "offset", "target", "targetOffset", "byteCount", "commonDecodeBase64", "commonDecodeHex", "commonEncodeUtf8", "commonEndsWith", "", "suffix", "commonEquals", "", "commonGetByte", "", "pos", "commonGetSize", "commonHashCode", "commonHex", "commonIndexOf", "fromIndex", "commonInternalArray", "commonLastIndexOf", "commonRangeEquals", "otherOffset", "commonStartsWith", "prefix", "commonSubstring", "beginIndex", "endIndex", "commonToAsciiLowercase", "commonToAsciiUppercase", "commonToByteArray", "commonToByteString", "commonToString", "commonUtf8", "commonWrite", "buffer", "Lokio/Buffer;", "okio"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* renamed from: okio.internal.-ByteString  reason: invalid class name */
/* compiled from: ByteString.kt */
public final class ByteString {
    private static final char[] HEX_DIGIT_CHARS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public static /* synthetic */ void getHEX_DIGIT_CHARS$annotations() {
    }

    public static final String commonUtf8(okio.ByteString byteString) {
        Intrinsics.checkNotNullParameter(byteString, "<this>");
        String utf8$okio = byteString.getUtf8$okio();
        if (utf8$okio != null) {
            return utf8$okio;
        }
        String utf8String = _JvmPlatformKt.toUtf8String(byteString.internalArray$okio());
        byteString.setUtf8$okio(utf8String);
        return utf8String;
    }

    public static final String commonBase64(okio.ByteString byteString) {
        Intrinsics.checkNotNullParameter(byteString, "<this>");
        return Base64.encodeBase64$default(byteString.getData$okio(), (byte[]) null, 1, (Object) null);
    }

    public static final String commonBase64Url(okio.ByteString byteString) {
        Intrinsics.checkNotNullParameter(byteString, "<this>");
        return Base64.encodeBase64(byteString.getData$okio(), Base64.getBASE64_URL_SAFE());
    }

    public static final char[] getHEX_DIGIT_CHARS() {
        return HEX_DIGIT_CHARS;
    }

    public static final String commonHex(okio.ByteString byteString) {
        Intrinsics.checkNotNullParameter(byteString, "<this>");
        char[] cArr = new char[(byteString.getData$okio().length * 2)];
        int i = 0;
        for (byte b : byteString.getData$okio()) {
            int i2 = i + 1;
            cArr[i] = getHEX_DIGIT_CHARS()[(b >> 4) & 15];
            i += 2;
            cArr[i2] = getHEX_DIGIT_CHARS()[b & Ascii.SI];
        }
        return StringsKt.concatToString(cArr);
    }

    public static final okio.ByteString commonToAsciiLowercase(okio.ByteString byteString) {
        Intrinsics.checkNotNullParameter(byteString, "<this>");
        int i = 0;
        while (i < byteString.getData$okio().length) {
            byte b = byteString.getData$okio()[i];
            if (b < 65 || b > 90) {
                i++;
            } else {
                byte[] data$okio = byteString.getData$okio();
                byte[] copyOf = Arrays.copyOf(data$okio, data$okio.length);
                Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, size)");
                copyOf[i] = (byte) (b + 32);
                for (int i2 = i + 1; i2 < copyOf.length; i2++) {
                    byte b2 = copyOf[i2];
                    if (b2 >= 65 && b2 <= 90) {
                        copyOf[i2] = (byte) (b2 + 32);
                    }
                }
                return new okio.ByteString(copyOf);
            }
        }
        return byteString;
    }

    public static final okio.ByteString commonToAsciiUppercase(okio.ByteString byteString) {
        Intrinsics.checkNotNullParameter(byteString, "<this>");
        int i = 0;
        while (i < byteString.getData$okio().length) {
            byte b = byteString.getData$okio()[i];
            if (b < 97 || b > 122) {
                i++;
            } else {
                byte[] data$okio = byteString.getData$okio();
                byte[] copyOf = Arrays.copyOf(data$okio, data$okio.length);
                Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, size)");
                copyOf[i] = (byte) (b - 32);
                for (int i2 = i + 1; i2 < copyOf.length; i2++) {
                    byte b2 = copyOf[i2];
                    if (b2 >= 97 && b2 <= 122) {
                        copyOf[i2] = (byte) (b2 - 32);
                    }
                }
                return new okio.ByteString(copyOf);
            }
        }
        return byteString;
    }

    public static final okio.ByteString commonSubstring(okio.ByteString byteString, int i, int i2) {
        Intrinsics.checkNotNullParameter(byteString, "<this>");
        int resolveDefaultParameter = SegmentedByteString.resolveDefaultParameter(byteString, i2);
        if (i < 0) {
            throw new IllegalArgumentException("beginIndex < 0".toString());
        } else if (resolveDefaultParameter > byteString.getData$okio().length) {
            throw new IllegalArgumentException(("endIndex > length(" + byteString.getData$okio().length + ')').toString());
        } else if (resolveDefaultParameter - i < 0) {
            throw new IllegalArgumentException("endIndex < beginIndex".toString());
        } else if (i == 0 && resolveDefaultParameter == byteString.getData$okio().length) {
            return byteString;
        } else {
            return new okio.ByteString(ArraysKt.copyOfRange(byteString.getData$okio(), i, resolveDefaultParameter));
        }
    }

    public static final byte commonGetByte(okio.ByteString byteString, int i) {
        Intrinsics.checkNotNullParameter(byteString, "<this>");
        return byteString.getData$okio()[i];
    }

    public static final int commonGetSize(okio.ByteString byteString) {
        Intrinsics.checkNotNullParameter(byteString, "<this>");
        return byteString.getData$okio().length;
    }

    public static final byte[] commonToByteArray(okio.ByteString byteString) {
        Intrinsics.checkNotNullParameter(byteString, "<this>");
        byte[] data$okio = byteString.getData$okio();
        byte[] copyOf = Arrays.copyOf(data$okio, data$okio.length);
        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, size)");
        return copyOf;
    }

    public static final byte[] commonInternalArray(okio.ByteString byteString) {
        Intrinsics.checkNotNullParameter(byteString, "<this>");
        return byteString.getData$okio();
    }

    public static final boolean commonRangeEquals(okio.ByteString byteString, int i, okio.ByteString byteString2, int i2, int i3) {
        Intrinsics.checkNotNullParameter(byteString, "<this>");
        Intrinsics.checkNotNullParameter(byteString2, "other");
        return byteString2.rangeEquals(i2, byteString.getData$okio(), i, i3);
    }

    public static final boolean commonRangeEquals(okio.ByteString byteString, int i, byte[] bArr, int i2, int i3) {
        Intrinsics.checkNotNullParameter(byteString, "<this>");
        Intrinsics.checkNotNullParameter(bArr, "other");
        return i >= 0 && i <= byteString.getData$okio().length - i3 && i2 >= 0 && i2 <= bArr.length - i3 && SegmentedByteString.arrayRangeEquals(byteString.getData$okio(), i, bArr, i2, i3);
    }

    public static final void commonCopyInto(okio.ByteString byteString, int i, byte[] bArr, int i2, int i3) {
        Intrinsics.checkNotNullParameter(byteString, "<this>");
        Intrinsics.checkNotNullParameter(bArr, TypedValues.AttributesType.S_TARGET);
        ArraysKt.copyInto(byteString.getData$okio(), bArr, i2, i, i3 + i);
    }

    public static final boolean commonStartsWith(okio.ByteString byteString, okio.ByteString byteString2) {
        Intrinsics.checkNotNullParameter(byteString, "<this>");
        Intrinsics.checkNotNullParameter(byteString2, "prefix");
        return byteString.rangeEquals(0, byteString2, 0, byteString2.size());
    }

    public static final boolean commonStartsWith(okio.ByteString byteString, byte[] bArr) {
        Intrinsics.checkNotNullParameter(byteString, "<this>");
        Intrinsics.checkNotNullParameter(bArr, "prefix");
        return byteString.rangeEquals(0, bArr, 0, bArr.length);
    }

    public static final boolean commonEndsWith(okio.ByteString byteString, okio.ByteString byteString2) {
        Intrinsics.checkNotNullParameter(byteString, "<this>");
        Intrinsics.checkNotNullParameter(byteString2, "suffix");
        return byteString.rangeEquals(byteString.size() - byteString2.size(), byteString2, 0, byteString2.size());
    }

    public static final boolean commonEndsWith(okio.ByteString byteString, byte[] bArr) {
        Intrinsics.checkNotNullParameter(byteString, "<this>");
        Intrinsics.checkNotNullParameter(bArr, "suffix");
        return byteString.rangeEquals(byteString.size() - bArr.length, bArr, 0, bArr.length);
    }

    public static final int commonIndexOf(okio.ByteString byteString, byte[] bArr, int i) {
        Intrinsics.checkNotNullParameter(byteString, "<this>");
        Intrinsics.checkNotNullParameter(bArr, "other");
        int length = byteString.getData$okio().length - bArr.length;
        int max = Math.max(i, 0);
        if (max > length) {
            return -1;
        }
        while (!SegmentedByteString.arrayRangeEquals(byteString.getData$okio(), max, bArr, 0, bArr.length)) {
            if (max == length) {
                return -1;
            }
            max++;
        }
        return max;
    }

    public static final int commonLastIndexOf(okio.ByteString byteString, okio.ByteString byteString2, int i) {
        Intrinsics.checkNotNullParameter(byteString, "<this>");
        Intrinsics.checkNotNullParameter(byteString2, "other");
        return byteString.lastIndexOf(byteString2.internalArray$okio(), i);
    }

    public static final int commonLastIndexOf(okio.ByteString byteString, byte[] bArr, int i) {
        Intrinsics.checkNotNullParameter(byteString, "<this>");
        Intrinsics.checkNotNullParameter(bArr, "other");
        for (int min = Math.min(SegmentedByteString.resolveDefaultParameter(byteString, i), byteString.getData$okio().length - bArr.length); -1 < min; min--) {
            if (SegmentedByteString.arrayRangeEquals(byteString.getData$okio(), min, bArr, 0, bArr.length)) {
                return min;
            }
        }
        return -1;
    }

    public static final boolean commonEquals(okio.ByteString byteString, Object obj) {
        Intrinsics.checkNotNullParameter(byteString, "<this>");
        if (obj == byteString) {
            return true;
        }
        if (obj instanceof okio.ByteString) {
            okio.ByteString byteString2 = (okio.ByteString) obj;
            return byteString2.size() == byteString.getData$okio().length && byteString2.rangeEquals(0, byteString.getData$okio(), 0, byteString.getData$okio().length);
        }
    }

    public static final int commonHashCode(okio.ByteString byteString) {
        Intrinsics.checkNotNullParameter(byteString, "<this>");
        int hashCode$okio = byteString.getHashCode$okio();
        if (hashCode$okio != 0) {
            return hashCode$okio;
        }
        int hashCode = Arrays.hashCode(byteString.getData$okio());
        byteString.setHashCode$okio(hashCode);
        return hashCode;
    }

    public static final int commonCompareTo(okio.ByteString byteString, okio.ByteString byteString2) {
        Intrinsics.checkNotNullParameter(byteString, "<this>");
        Intrinsics.checkNotNullParameter(byteString2, "other");
        int size = byteString.size();
        int size2 = byteString2.size();
        int min = Math.min(size, size2);
        for (int i = 0; i < min; i++) {
            byte b = byteString.getByte(i) & 255;
            byte b2 = byteString2.getByte(i) & 255;
            if (b != b2) {
                return b < b2 ? -1 : 1;
            }
        }
        if (size == size2) {
            return 0;
        }
        return size < size2 ? -1 : 1;
    }

    public static final okio.ByteString commonOf(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "data");
        byte[] copyOf = Arrays.copyOf(bArr, bArr.length);
        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, size)");
        return new okio.ByteString(copyOf);
    }

    public static final okio.ByteString commonToByteString(byte[] bArr, int i, int i2) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        int resolveDefaultParameter = SegmentedByteString.resolveDefaultParameter(bArr, i2);
        SegmentedByteString.checkOffsetAndCount((long) bArr.length, (long) i, (long) resolveDefaultParameter);
        return new okio.ByteString(ArraysKt.copyOfRange(bArr, i, resolveDefaultParameter + i));
    }

    public static final okio.ByteString commonEncodeUtf8(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        okio.ByteString byteString = new okio.ByteString(_JvmPlatformKt.asUtf8ToByteArray(str));
        byteString.setUtf8$okio(str);
        return byteString;
    }

    public static final okio.ByteString commonDecodeBase64(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        byte[] decodeBase64ToArray = Base64.decodeBase64ToArray(str);
        if (decodeBase64ToArray != null) {
            return new okio.ByteString(decodeBase64ToArray);
        }
        return null;
    }

    public static final okio.ByteString commonDecodeHex(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        if (str.length() % 2 == 0) {
            int length = str.length() / 2;
            byte[] bArr = new byte[length];
            for (int i = 0; i < length; i++) {
                int i2 = i * 2;
                bArr[i] = (byte) ((decodeHexDigit(str.charAt(i2)) << 4) + decodeHexDigit(str.charAt(i2 + 1)));
            }
            return new okio.ByteString(bArr);
        }
        throw new IllegalArgumentException(("Unexpected hex string: " + str).toString());
    }

    public static final void commonWrite(okio.ByteString byteString, Buffer buffer, int i, int i2) {
        Intrinsics.checkNotNullParameter(byteString, "<this>");
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        buffer.write(byteString.getData$okio(), i, i2);
    }

    /* access modifiers changed from: private */
    public static final int decodeHexDigit(char c) {
        if ('0' <= c && c < ':') {
            return c - '0';
        }
        if ('a' <= c && c < 'g') {
            return c - 'W';
        }
        if ('A' <= c && c < 'G') {
            return c - '7';
        }
        throw new IllegalArgumentException("Unexpected hex digit: " + c);
    }

    public static final String commonToString(okio.ByteString byteString) {
        okio.ByteString byteString2 = byteString;
        Intrinsics.checkNotNullParameter(byteString2, "<this>");
        if (byteString2.getData$okio().length == 0) {
            return "[size=0]";
        }
        int access$codePointIndexToCharIndex = codePointIndexToCharIndex(byteString2.getData$okio(), 64);
        if (access$codePointIndexToCharIndex != -1) {
            String utf8 = byteString2.utf8();
            String substring = utf8.substring(0, access$codePointIndexToCharIndex);
            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
            String replace$default = StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(substring, "\\", "\\\\", false, 4, (Object) null), "\n", "\\n", false, 4, (Object) null), "\r", "\\r", false, 4, (Object) null);
            if (access$codePointIndexToCharIndex < utf8.length()) {
                return "[size=" + byteString2.getData$okio().length + " text=" + replace$default + "…]";
            }
            return "[text=" + replace$default + ']';
        } else if (byteString2.getData$okio().length <= 64) {
            return "[hex=" + byteString2.hex() + ']';
        } else {
            StringBuilder append = new StringBuilder("[size=").append(byteString2.getData$okio().length).append(" hex=");
            int resolveDefaultParameter = SegmentedByteString.resolveDefaultParameter(byteString2, 64);
            if (resolveDefaultParameter > byteString2.getData$okio().length) {
                throw new IllegalArgumentException(("endIndex > length(" + byteString2.getData$okio().length + ')').toString());
            } else if (resolveDefaultParameter >= 0) {
                if (resolveDefaultParameter != byteString2.getData$okio().length) {
                    byteString2 = new okio.ByteString(ArraysKt.copyOfRange(byteString2.getData$okio(), 0, resolveDefaultParameter));
                }
                return append.append(byteString2.hex()).append("…]").toString();
            } else {
                throw new IllegalArgumentException("endIndex < beginIndex".toString());
            }
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0035, code lost:
        return -1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:144:0x018d, code lost:
        return -1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x005d, code lost:
        return -1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x009d, code lost:
        return -1;
     */
    /* JADX WARNING: Removed duplicated region for block: B:158:0x01ac A[EDGE_INSN: B:161:0x01ac->B:158:0x01ac ?: BREAK  
    EDGE_INSN: B:163:0x01ac->B:158:0x01ac ?: BREAK  
    EDGE_INSN: B:180:0x01ac->B:158:0x01ac ?: BREAK  
    EDGE_INSN: B:185:0x01ac->B:158:0x01ac ?: BREAK  
    EDGE_INSN: B:195:0x01ac->B:158:0x01ac ?: BREAK  , RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final int codePointIndexToCharIndex(byte[] r18, int r19) {
        /*
            r0 = r18
            r1 = r19
            int r2 = r0.length
            r3 = 0
            r4 = r3
            r5 = r4
        L_0x0008:
            if (r3 >= r2) goto L_0x01ac
            byte r6 = r0[r3]
            r7 = 160(0xa0, float:2.24E-43)
            r8 = 127(0x7f, float:1.78E-43)
            r9 = 32
            r10 = 13
            r11 = 65533(0xfffd, float:9.1831E-41)
            r12 = 10
            r13 = 65536(0x10000, float:9.18355E-41)
            r16 = -1
            if (r6 < 0) goto L_0x0065
            int r17 = r5 + 1
            if (r5 != r1) goto L_0x0025
            goto L_0x01ac
        L_0x0025:
            if (r6 == r12) goto L_0x0033
            if (r6 == r10) goto L_0x0033
            if (r6 < 0) goto L_0x002e
            if (r6 >= r9) goto L_0x002e
            goto L_0x0035
        L_0x002e:
            if (r8 > r6) goto L_0x0033
            if (r6 >= r7) goto L_0x0033
            goto L_0x0035
        L_0x0033:
            if (r6 != r11) goto L_0x0036
        L_0x0035:
            return r16
        L_0x0036:
            if (r6 >= r13) goto L_0x003a
            r5 = 1
            goto L_0x003b
        L_0x003a:
            r5 = 2
        L_0x003b:
            int r4 = r4 + r5
            int r3 = r3 + 1
        L_0x003e:
            r5 = r17
            if (r3 >= r2) goto L_0x0008
            byte r6 = r0[r3]
            if (r6 < 0) goto L_0x0008
            int r3 = r3 + 1
            int r17 = r5 + 1
            if (r5 != r1) goto L_0x004d
            return r4
        L_0x004d:
            if (r6 == r12) goto L_0x005b
            if (r6 == r10) goto L_0x005b
            if (r6 < 0) goto L_0x0056
            if (r6 >= r9) goto L_0x0056
            goto L_0x005d
        L_0x0056:
            if (r8 > r6) goto L_0x005b
            if (r6 >= r7) goto L_0x005b
            goto L_0x005d
        L_0x005b:
            if (r6 != r11) goto L_0x005e
        L_0x005d:
            return r16
        L_0x005e:
            if (r6 >= r13) goto L_0x0062
            r5 = 1
            goto L_0x0063
        L_0x0062:
            r5 = 2
        L_0x0063:
            int r4 = r4 + r5
            goto L_0x003e
        L_0x0065:
            int r14 = r6 >> 5
            r15 = -2
            r13 = 128(0x80, float:1.794E-43)
            if (r14 != r15) goto L_0x00b2
            int r14 = r3 + 1
            if (r2 > r14) goto L_0x0075
            if (r5 != r1) goto L_0x0074
            goto L_0x01ac
        L_0x0074:
            return r16
        L_0x0075:
            byte r14 = r0[r14]
            r15 = r14 & 192(0xc0, float:2.69E-43)
            if (r15 != r13) goto L_0x00ad
            r14 = r14 ^ 3968(0xf80, float:5.56E-42)
            int r6 = r6 << 6
            r6 = r6 ^ r14
            if (r6 >= r13) goto L_0x0087
            if (r5 != r1) goto L_0x0086
            goto L_0x01ac
        L_0x0086:
            return r16
        L_0x0087:
            int r13 = r5 + 1
            if (r5 != r1) goto L_0x008d
            goto L_0x01ac
        L_0x008d:
            if (r6 == r12) goto L_0x009b
            if (r6 == r10) goto L_0x009b
            if (r6 < 0) goto L_0x0096
            if (r6 >= r9) goto L_0x0096
            goto L_0x009d
        L_0x0096:
            if (r8 > r6) goto L_0x009b
            if (r6 >= r7) goto L_0x009b
            goto L_0x009d
        L_0x009b:
            if (r6 != r11) goto L_0x009e
        L_0x009d:
            return r16
        L_0x009e:
            r5 = 65536(0x10000, float:9.18355E-41)
            if (r6 >= r5) goto L_0x00a4
            r14 = 1
            goto L_0x00a5
        L_0x00a4:
            r14 = 2
        L_0x00a5:
            int r4 = r4 + r14
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            int r3 = r3 + 2
            r5 = r13
            goto L_0x0008
        L_0x00ad:
            if (r5 != r1) goto L_0x00b1
            goto L_0x01ac
        L_0x00b1:
            return r16
        L_0x00b2:
            int r14 = r6 >> 4
            r11 = 57344(0xe000, float:8.0356E-41)
            r7 = 55296(0xd800, float:7.7486E-41)
            if (r14 != r15) goto L_0x0126
            int r14 = r3 + 2
            if (r2 > r14) goto L_0x00c5
            if (r5 != r1) goto L_0x00c4
            goto L_0x01ac
        L_0x00c4:
            return r16
        L_0x00c5:
            int r15 = r3 + 1
            byte r15 = r0[r15]
            r8 = r15 & 192(0xc0, float:2.69E-43)
            if (r8 != r13) goto L_0x0121
            byte r8 = r0[r14]
            r14 = r8 & 192(0xc0, float:2.69E-43)
            if (r14 != r13) goto L_0x011c
            r13 = -123008(0xfffffffffffe1f80, float:NaN)
            r8 = r8 ^ r13
            int r13 = r15 << 6
            r8 = r8 ^ r13
            int r6 = r6 << 12
            r6 = r6 ^ r8
            r8 = 2048(0x800, float:2.87E-42)
            if (r6 >= r8) goto L_0x00e6
            if (r5 != r1) goto L_0x00e5
            goto L_0x01ac
        L_0x00e5:
            return r16
        L_0x00e6:
            if (r7 > r6) goto L_0x00ef
            if (r6 >= r11) goto L_0x00ef
            if (r5 != r1) goto L_0x00ee
            goto L_0x01ac
        L_0x00ee:
            return r16
        L_0x00ef:
            int r7 = r5 + 1
            if (r5 != r1) goto L_0x00f5
            goto L_0x01ac
        L_0x00f5:
            if (r6 == r12) goto L_0x0107
            if (r6 == r10) goto L_0x0107
            if (r6 < 0) goto L_0x00fe
            if (r6 >= r9) goto L_0x00fe
            goto L_0x010c
        L_0x00fe:
            r5 = 127(0x7f, float:1.78E-43)
            if (r5 > r6) goto L_0x0107
            r5 = 160(0xa0, float:2.24E-43)
            if (r6 >= r5) goto L_0x0107
            goto L_0x010c
        L_0x0107:
            r5 = 65533(0xfffd, float:9.1831E-41)
            if (r6 != r5) goto L_0x010d
        L_0x010c:
            return r16
        L_0x010d:
            r5 = 65536(0x10000, float:9.18355E-41)
            if (r6 >= r5) goto L_0x0113
            r14 = 1
            goto L_0x0114
        L_0x0113:
            r14 = 2
        L_0x0114:
            int r4 = r4 + r14
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            int r3 = r3 + 3
        L_0x0119:
            r5 = r7
            goto L_0x0008
        L_0x011c:
            if (r5 != r1) goto L_0x0120
            goto L_0x01ac
        L_0x0120:
            return r16
        L_0x0121:
            if (r5 != r1) goto L_0x0125
            goto L_0x01ac
        L_0x0125:
            return r16
        L_0x0126:
            int r8 = r6 >> 3
            if (r8 != r15) goto L_0x01a8
            int r8 = r3 + 3
            if (r2 > r8) goto L_0x0133
            if (r5 != r1) goto L_0x0132
            goto L_0x01ac
        L_0x0132:
            return r16
        L_0x0133:
            int r14 = r3 + 1
            byte r14 = r0[r14]
            r15 = r14 & 192(0xc0, float:2.69E-43)
            if (r15 != r13) goto L_0x01a4
            int r15 = r3 + 2
            byte r15 = r0[r15]
            r9 = r15 & 192(0xc0, float:2.69E-43)
            if (r9 != r13) goto L_0x01a0
            byte r8 = r0[r8]
            r9 = r8 & 192(0xc0, float:2.69E-43)
            if (r9 != r13) goto L_0x019c
            r9 = 3678080(0x381f80, float:5.154088E-39)
            r8 = r8 ^ r9
            int r9 = r15 << 6
            r8 = r8 ^ r9
            int r9 = r14 << 12
            r8 = r8 ^ r9
            int r6 = r6 << 18
            r6 = r6 ^ r8
            r8 = 1114111(0x10ffff, float:1.561202E-39)
            if (r6 <= r8) goto L_0x015f
            if (r5 != r1) goto L_0x015e
            goto L_0x01ac
        L_0x015e:
            return r16
        L_0x015f:
            if (r7 > r6) goto L_0x0167
            if (r6 >= r11) goto L_0x0167
            if (r5 != r1) goto L_0x0166
            goto L_0x01ac
        L_0x0166:
            return r16
        L_0x0167:
            r7 = 65536(0x10000, float:9.18355E-41)
            if (r6 >= r7) goto L_0x016f
            if (r5 != r1) goto L_0x016e
            goto L_0x01ac
        L_0x016e:
            return r16
        L_0x016f:
            int r7 = r5 + 1
            if (r5 != r1) goto L_0x0174
            goto L_0x01ac
        L_0x0174:
            if (r6 == r12) goto L_0x0188
            if (r6 == r10) goto L_0x0188
            if (r6 < 0) goto L_0x017f
            r5 = 32
            if (r6 >= r5) goto L_0x017f
            goto L_0x018d
        L_0x017f:
            r5 = 127(0x7f, float:1.78E-43)
            if (r5 > r6) goto L_0x0188
            r5 = 160(0xa0, float:2.24E-43)
            if (r6 >= r5) goto L_0x0188
            goto L_0x018d
        L_0x0188:
            r5 = 65533(0xfffd, float:9.1831E-41)
            if (r6 != r5) goto L_0x018e
        L_0x018d:
            return r16
        L_0x018e:
            r5 = 65536(0x10000, float:9.18355E-41)
            if (r6 >= r5) goto L_0x0194
            r14 = 1
            goto L_0x0195
        L_0x0194:
            r14 = 2
        L_0x0195:
            int r4 = r4 + r14
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            int r3 = r3 + 4
            goto L_0x0119
        L_0x019c:
            if (r5 != r1) goto L_0x019f
            goto L_0x01ac
        L_0x019f:
            return r16
        L_0x01a0:
            if (r5 != r1) goto L_0x01a3
            goto L_0x01ac
        L_0x01a3:
            return r16
        L_0x01a4:
            if (r5 != r1) goto L_0x01a7
            goto L_0x01ac
        L_0x01a7:
            return r16
        L_0x01a8:
            if (r5 != r1) goto L_0x01ab
            goto L_0x01ac
        L_0x01ab:
            return r16
        L_0x01ac:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.internal.ByteString.codePointIndexToCharIndex(byte[], int):int");
    }
}
