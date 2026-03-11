package okio;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.RandomAccess;
import kotlin.Metadata;
import kotlin.collections.AbstractList;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\u0018\u0000 \u00152\b\u0012\u0004\u0012\u00020\u00020\u00012\u00060\u0003j\u0002`\u0004:\u0001\u0015B\u001f\b\u0002\u0012\u000e\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0011\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u000eH\u0002R\u001e\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00020\u0006X\u0004¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\r\u001a\u00020\u000e8VX\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0016"}, d2 = {"Lokio/Options;", "Lkotlin/collections/AbstractList;", "Lokio/ByteString;", "Ljava/util/RandomAccess;", "Lkotlin/collections/RandomAccess;", "byteStrings", "", "trie", "", "([Lokio/ByteString;[I)V", "getByteStrings$okio", "()[Lokio/ByteString;", "[Lokio/ByteString;", "size", "", "getSize", "()I", "getTrie$okio", "()[I", "get", "index", "Companion", "okio"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: Options.kt */
public final class Options extends AbstractList<ByteString> implements RandomAccess {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final ByteString[] byteStrings;
    private final int[] trie;

    public /* synthetic */ Options(ByteString[] byteStringArr, int[] iArr, DefaultConstructorMarker defaultConstructorMarker) {
        this(byteStringArr, iArr);
    }

    @JvmStatic
    public static final Options of(ByteString... byteStringArr) {
        return Companion.of(byteStringArr);
    }

    public final /* bridge */ boolean contains(Object obj) {
        if (!(obj instanceof ByteString)) {
            return false;
        }
        return contains((ByteString) obj);
    }

    public /* bridge */ boolean contains(ByteString byteString) {
        return super.contains(byteString);
    }

    public final /* bridge */ int indexOf(Object obj) {
        if (!(obj instanceof ByteString)) {
            return -1;
        }
        return indexOf((ByteString) obj);
    }

    public /* bridge */ int indexOf(ByteString byteString) {
        return super.indexOf(byteString);
    }

    public final /* bridge */ int lastIndexOf(Object obj) {
        if (!(obj instanceof ByteString)) {
            return -1;
        }
        return lastIndexOf((ByteString) obj);
    }

    public /* bridge */ int lastIndexOf(ByteString byteString) {
        return super.lastIndexOf(byteString);
    }

    public final ByteString[] getByteStrings$okio() {
        return this.byteStrings;
    }

    public final int[] getTrie$okio() {
        return this.trie;
    }

    private Options(ByteString[] byteStringArr, int[] iArr) {
        this.byteStrings = byteStringArr;
        this.trie = iArr;
    }

    public int getSize() {
        return this.byteStrings.length;
    }

    public ByteString get(int i) {
        return this.byteStrings[i];
    }

    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JT\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\r2\b\b\u0002\u0010\u0012\u001a\u00020\r2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\r0\u000fH\u0002J!\u0010\u0014\u001a\u00020\u00152\u0012\u0010\u000e\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00100\u0016\"\u00020\u0010H\u0007¢\u0006\u0002\u0010\u0017R\u0018\u0010\u0003\u001a\u00020\u0004*\u00020\u00058BX\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0018"}, d2 = {"Lokio/Options$Companion;", "", "()V", "intCount", "", "Lokio/Buffer;", "getIntCount", "(Lokio/Buffer;)J", "buildTrieRecursive", "", "nodeOffset", "node", "byteStringOffset", "", "byteStrings", "", "Lokio/ByteString;", "fromIndex", "toIndex", "indexes", "of", "Lokio/Options;", "", "([Lokio/ByteString;)Lokio/Options;", "okio"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: Options.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final Options of(ByteString... byteStringArr) {
            ByteString[] byteStringArr2 = byteStringArr;
            Intrinsics.checkNotNullParameter(byteStringArr2, "byteStrings");
            int i = 0;
            if (byteStringArr2.length == 0) {
                return new Options(new ByteString[0], new int[]{0, -1}, (DefaultConstructorMarker) null);
            }
            List mutableList = ArraysKt.toMutableList((T[]) byteStringArr2);
            CollectionsKt.sort(mutableList);
            Collection arrayList = new ArrayList(byteStringArr2.length);
            for (ByteString byteString : byteStringArr2) {
                arrayList.add(-1);
            }
            Integer[] numArr = (Integer[]) ((List) arrayList).toArray(new Integer[0]);
            List mutableListOf = CollectionsKt.mutableListOf(Arrays.copyOf(numArr, numArr.length));
            int length = byteStringArr2.length;
            int i2 = 0;
            int i3 = 0;
            while (i2 < length) {
                mutableListOf.set(CollectionsKt.binarySearch$default(mutableList, (Comparable) byteStringArr2[i2], 0, 0, 6, (Object) null), Integer.valueOf(i3));
                i2++;
                i3++;
            }
            if (((ByteString) mutableList.get(0)).size() > 0) {
                int i4 = 0;
                while (i4 < mutableList.size()) {
                    ByteString byteString2 = (ByteString) mutableList.get(i4);
                    int i5 = i4 + 1;
                    int i6 = i5;
                    while (i6 < mutableList.size()) {
                        ByteString byteString3 = (ByteString) mutableList.get(i6);
                        if (!byteString3.startsWith(byteString2)) {
                            continue;
                            break;
                        } else if (byteString3.size() == byteString2.size()) {
                            throw new IllegalArgumentException(("duplicate option: " + byteString3).toString());
                        } else if (((Number) mutableListOf.get(i6)).intValue() > ((Number) mutableListOf.get(i4)).intValue()) {
                            mutableList.remove(i6);
                            mutableListOf.remove(i6);
                        } else {
                            i6++;
                        }
                    }
                    i4 = i5;
                }
                Buffer buffer = new Buffer();
                List list = mutableList;
                buildTrieRecursive$default(this, 0, buffer, 0, list, 0, 0, mutableListOf, 53, (Object) null);
                int[] iArr = new int[((int) getIntCount(buffer))];
                while (!buffer.exhausted()) {
                    iArr[i] = buffer.readInt();
                    i++;
                }
                Object[] copyOf = Arrays.copyOf(byteStringArr2, byteStringArr2.length);
                Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, size)");
                return new Options((ByteString[]) copyOf, iArr, (DefaultConstructorMarker) null);
            }
            throw new IllegalArgumentException("the empty byte string is not a supported option".toString());
        }

        static /* synthetic */ void buildTrieRecursive$default(Companion companion, long j, Buffer buffer, int i, List list, int i2, int i3, List list2, int i4, Object obj) {
            int i5;
            if ((i4 & 1) != 0) {
                j = 0;
            }
            long j2 = j;
            int i6 = (i4 & 4) != 0 ? 0 : i;
            int i7 = (i4 & 16) != 0 ? 0 : i2;
            if ((i4 & 32) != 0) {
                i5 = list.size();
            } else {
                i5 = i3;
            }
            companion.buildTrieRecursive(j2, buffer, i6, list, i7, i5, list2);
        }

        private final void buildTrieRecursive(long j, Buffer buffer, int i, List<? extends ByteString> list, int i2, int i3, List<Integer> list2) {
            int i4;
            int i5;
            int i6;
            long j2;
            Buffer buffer2 = buffer;
            int i7 = i;
            List<? extends ByteString> list3 = list;
            int i8 = i2;
            int i9 = i3;
            List<Integer> list4 = list2;
            if (i8 < i9) {
                int i10 = i8;
                while (i10 < i9) {
                    if (((ByteString) list3.get(i10)).size() >= i7) {
                        i10++;
                    } else {
                        throw new IllegalArgumentException("Failed requirement.".toString());
                    }
                }
                ByteString byteString = (ByteString) list.get(i2);
                ByteString byteString2 = (ByteString) list3.get(i9 - 1);
                if (i7 == byteString.size()) {
                    int intValue = list4.get(i8).intValue();
                    int i11 = i8 + 1;
                    i4 = i11;
                    i5 = intValue;
                    byteString = (ByteString) list3.get(i11);
                } else {
                    i4 = i8;
                    i5 = -1;
                }
                if (byteString.getByte(i7) != byteString2.getByte(i7)) {
                    int i12 = 1;
                    for (int i13 = i4 + 1; i13 < i9; i13++) {
                        if (((ByteString) list3.get(i13 - 1)).getByte(i7) != ((ByteString) list3.get(i13)).getByte(i7)) {
                            i12++;
                        }
                    }
                    long intCount = j + getIntCount(buffer2) + ((long) 2) + ((long) (i12 * 2));
                    buffer2.writeInt(i12);
                    buffer2.writeInt(i5);
                    for (int i14 = i4; i14 < i9; i14++) {
                        byte b = ((ByteString) list3.get(i14)).getByte(i7);
                        if (i14 == i4 || b != ((ByteString) list3.get(i14 - 1)).getByte(i7)) {
                            buffer2.writeInt((int) b & 255);
                        }
                    }
                    Buffer buffer3 = new Buffer();
                    while (i4 < i9) {
                        byte b2 = ((ByteString) list3.get(i4)).getByte(i7);
                        int i15 = i4 + 1;
                        int i16 = i15;
                        while (true) {
                            if (i16 >= i9) {
                                i6 = i9;
                                break;
                            } else if (b2 != ((ByteString) list3.get(i16)).getByte(i7)) {
                                i6 = i16;
                                break;
                            } else {
                                i16++;
                            }
                        }
                        if (i15 == i6 && i7 + 1 == ((ByteString) list3.get(i4)).size()) {
                            buffer2.writeInt(list4.get(i4).intValue());
                            j2 = intCount;
                        } else {
                            buffer2.writeInt(((int) (getIntCount(buffer3) + intCount)) * -1);
                            j2 = intCount;
                            buildTrieRecursive(j2, buffer3, i7 + 1, list3, i4, i6, list4);
                        }
                        intCount = j2;
                        i4 = i6;
                    }
                    buffer2.writeAll(buffer3);
                    return;
                }
                int min = Math.min(byteString.size(), byteString2.size());
                int i17 = 0;
                int i18 = i7;
                while (i18 < min && byteString.getByte(i18) == byteString2.getByte(i18)) {
                    i17++;
                    i18++;
                }
                long intCount2 = j + getIntCount(buffer2) + ((long) 2) + ((long) i17) + 1;
                buffer2.writeInt(-i17);
                buffer2.writeInt(i5);
                int i19 = i7 + i17;
                while (i7 < i19) {
                    buffer2.writeInt((int) byteString.getByte(i7) & 255);
                    i7++;
                }
                if (i4 + 1 != i9) {
                    int i20 = i19;
                    long j3 = intCount2;
                    Buffer buffer4 = new Buffer();
                    buffer2.writeInt(((int) (getIntCount(buffer4) + j3)) * -1);
                    buildTrieRecursive(j3, buffer4, i20, list3, i4, i9, list4);
                    buffer2.writeAll(buffer4);
                } else if (i19 == ((ByteString) list3.get(i4)).size()) {
                    buffer2.writeInt(list4.get(i4).intValue());
                } else {
                    throw new IllegalStateException("Check failed.".toString());
                }
            } else {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
        }

        private final long getIntCount(Buffer buffer) {
            return buffer.size() / ((long) 4);
        }
    }
}
