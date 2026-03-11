package com.armmc.app.ui.servers;

import android.graphics.Color;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlin.ranges.RangesKt;
import kotlin.text.Regex;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u000e\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u000f\u001a\u00020\u0006¢\u0006\u0002\u0010\u0010J\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00060\u0012J\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00060\u0012J\u0018\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\t2\b\b\u0002\u0010\u0017\u001a\u00020\u0018J\b\u0010\u0019\u001a\u00020\u0006H\u0002J\u000e\u0010\u001a\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\tJ\u001e\u0010\u001b\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\t2\u0006\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0006R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t0\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001d\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t0\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000b¨\u0006\u001d"}, d2 = {"Lcom/armmc/app/ui/servers/MinecraftTextFormatter;", "", "<init>", "()V", "colorCodes", "", "", "", "colorNames", "", "getColorNames", "()Ljava/util/Map;", "styleNames", "getStyleNames", "getColorForCode", "code", "(C)Ljava/lang/Integer;", "getColorCodes", "", "getStyleCodes", "format", "Landroid/text/SpannableStringBuilder;", "text", "obfuscateChars", "", "getRandomChar", "stripFormatting", "insertCode", "position", "app_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* compiled from: MinecraftTextFormatter.kt */
public final class MinecraftTextFormatter {
    public static final MinecraftTextFormatter INSTANCE = new MinecraftTextFormatter();
    private static final Map<Character, Integer> colorCodes = MapsKt.mapOf(TuplesKt.to('0', Integer.valueOf(Color.parseColor("#000000"))), TuplesKt.to('1', Integer.valueOf(Color.parseColor("#0000AA"))), TuplesKt.to('2', Integer.valueOf(Color.parseColor("#00AA00"))), TuplesKt.to('3', Integer.valueOf(Color.parseColor("#00AAAA"))), TuplesKt.to('4', Integer.valueOf(Color.parseColor("#AA0000"))), TuplesKt.to('5', Integer.valueOf(Color.parseColor("#AA00AA"))), TuplesKt.to('6', Integer.valueOf(Color.parseColor("#FFAA00"))), TuplesKt.to('7', Integer.valueOf(Color.parseColor("#AAAAAA"))), TuplesKt.to('8', Integer.valueOf(Color.parseColor("#555555"))), TuplesKt.to('9', Integer.valueOf(Color.parseColor("#5555FF"))), TuplesKt.to('a', Integer.valueOf(Color.parseColor("#55FF55"))), TuplesKt.to('b', Integer.valueOf(Color.parseColor("#55FFFF"))), TuplesKt.to('c', Integer.valueOf(Color.parseColor("#FF5555"))), TuplesKt.to('d', Integer.valueOf(Color.parseColor("#FF55FF"))), TuplesKt.to('e', Integer.valueOf(Color.parseColor("#FFFF55"))), TuplesKt.to('f', Integer.valueOf(Color.parseColor("#FFFFFF"))));
    private static final Map<Character, String> colorNames = MapsKt.mapOf(TuplesKt.to('0', "Black"), TuplesKt.to('1', "Dark Blue"), TuplesKt.to('2', "Dark Green"), TuplesKt.to('3', "Dark Aqua"), TuplesKt.to('4', "Dark Red"), TuplesKt.to('5', "Dark Purple"), TuplesKt.to('6', "Gold"), TuplesKt.to('7', "Gray"), TuplesKt.to('8', "Dark Gray"), TuplesKt.to('9', "Blue"), TuplesKt.to('a', "Green"), TuplesKt.to('b', "Aqua"), TuplesKt.to('c', "Red"), TuplesKt.to('d', "Light Purple"), TuplesKt.to('e', "Yellow"), TuplesKt.to('f', "White"));
    private static final Map<Character, String> styleNames = MapsKt.mapOf(TuplesKt.to('k', "Obfuscated"), TuplesKt.to('l', "Bold"), TuplesKt.to('m', "Strikethrough"), TuplesKt.to('n', "Underline"), TuplesKt.to('o', "Italic"), TuplesKt.to('r', "Reset"));

    private MinecraftTextFormatter() {
    }

    public final Map<Character, String> getColorNames() {
        return colorNames;
    }

    public final Map<Character, String> getStyleNames() {
        return styleNames;
    }

    public final Integer getColorForCode(char c) {
        return colorCodes.get(Character.valueOf(Character.toLowerCase(c)));
    }

    public final List<Character> getColorCodes() {
        return CollectionsKt.listOf('0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f');
    }

    public final List<Character> getStyleCodes() {
        return CollectionsKt.listOf('l', 'o', 'n', 'm', 'k', 'r');
    }

    public static /* synthetic */ SpannableStringBuilder format$default(MinecraftTextFormatter minecraftTextFormatter, String str, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return minecraftTextFormatter.format(str, z);
    }

    public final SpannableStringBuilder format(String str, boolean z) {
        int i;
        String str2 = str;
        Intrinsics.checkNotNullParameter(str2, "text");
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        int i2 = -1;
        int i3 = 0;
        boolean z2 = false;
        boolean z3 = false;
        boolean z4 = false;
        boolean z5 = false;
        boolean z6 = false;
        while (i3 < str2.length()) {
            char charAt = str2.charAt(i3);
            if ((charAt == 167 || charAt == '&') && (i = i3 + 1) < str2.length()) {
                char lowerCase = Character.toLowerCase(str2.charAt(i));
                Map<Character, Integer> map = colorCodes;
                if (map.containsKey(Character.valueOf(lowerCase))) {
                    Integer num = map.get(Character.valueOf(lowerCase));
                    Intrinsics.checkNotNull(num);
                    z3 = false;
                    z4 = false;
                    z5 = false;
                    z6 = false;
                    i2 = num.intValue();
                    z2 = false;
                } else if (lowerCase == 'l') {
                    z3 = true;
                } else if (lowerCase == 'o') {
                    z4 = true;
                } else if (lowerCase == 'n') {
                    z5 = true;
                } else if (lowerCase == 'm') {
                    z6 = true;
                } else if (lowerCase == 'k') {
                    z2 = true;
                } else if (lowerCase == 'r') {
                    i2 = -1;
                    z2 = false;
                    z3 = false;
                    z4 = false;
                    z5 = false;
                    z6 = false;
                }
                i3 += 2;
            } else {
                int length = spannableStringBuilder.length();
                if (z2 && z && charAt != ' ' && charAt != 10) {
                    charAt = getRandomChar();
                }
                spannableStringBuilder.append(charAt);
                int length2 = spannableStringBuilder.length();
                spannableStringBuilder.setSpan(new ForegroundColorSpan(i2), length, length2, 33);
                if (z3 && z4) {
                    spannableStringBuilder.setSpan(new StyleSpan(3), length, length2, 33);
                } else if (z3) {
                    spannableStringBuilder.setSpan(new StyleSpan(1), length, length2, 33);
                } else if (z4) {
                    spannableStringBuilder.setSpan(new StyleSpan(2), length, length2, 33);
                }
                if (z5) {
                    spannableStringBuilder.setSpan(new UnderlineSpan(), length, length2, 33);
                }
                if (z6) {
                    spannableStringBuilder.setSpan(new StrikethroughSpan(), length, length2, 33);
                }
                i3++;
            }
        }
        return spannableStringBuilder;
    }

    private final char getRandomChar() {
        return "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()".charAt(Random.Default.nextInt("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()".length()));
    }

    public final String stripFormatting(String str) {
        Intrinsics.checkNotNullParameter(str, "text");
        return new Regex("[§&][0-9a-fA-Fk-oK-OrR]").replace((CharSequence) str, "");
    }

    public final String insertCode(String str, int i, char c) {
        Intrinsics.checkNotNullParameter(str, "text");
        String str2 = "§" + c;
        String substring = str.substring(0, RangesKt.coerceIn(i, 0, str.length()));
        Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
        String substring2 = str.substring(RangesKt.coerceIn(i, 0, str.length()));
        Intrinsics.checkNotNullExpressionValue(substring2, "substring(...)");
        return substring + str2 + substring2;
    }
}
