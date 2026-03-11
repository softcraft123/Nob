package androidx.core.text;

import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import kotlin.Metadata;
import kotlin.ranges.IntRange;

@Metadata(d1 = {"\u0000(\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\r\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\b\u001a\r\u0010\u0003\u001a\u00020\u0004*\u00020\u0001H\b\u001a%\u0010\u0005\u001a\u00020\u0004*\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\nH\n\u001a\u001d\u0010\u0005\u001a\u00020\u0004*\u00020\u00012\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\nH\n¨\u0006\r"}, d2 = {"toSpannable", "Landroid/text/Spannable;", "", "clearSpans", "", "set", "start", "", "end", "span", "", "range", "Lkotlin/ranges/IntRange;", "core-ktx_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* compiled from: SpannableString.kt */
public final class SpannableStringKt {
    public static final Spannable toSpannable(CharSequence charSequence) {
        return SpannableString.valueOf(charSequence);
    }

    public static final void clearSpans(Spannable spannable) {
        Spanned spanned = spannable;
        for (Object removeSpan : spanned.getSpans(0, spanned.length(), Object.class)) {
            spannable.removeSpan(removeSpan);
        }
    }

    public static final void set(Spannable spannable, int i, int i2, Object obj) {
        spannable.setSpan(obj, i, i2, 17);
    }

    public static final void set(Spannable spannable, IntRange intRange, Object obj) {
        spannable.setSpan(obj, intRange.getStart().intValue(), intRange.getEndInclusive().intValue(), 17);
    }
}
