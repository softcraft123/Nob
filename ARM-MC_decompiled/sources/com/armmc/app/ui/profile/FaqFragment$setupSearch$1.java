package com.armmc.app.ui.profile;

import android.text.Editable;
import android.text.TextWatcher;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J*\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0016J*\u0010\n\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0012\u0010\f\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\rH\u0016¨\u0006\u000e"}, d2 = {"com/armmc/app/ui/profile/FaqFragment$setupSearch$1", "Landroid/text/TextWatcher;", "beforeTextChanged", "", "s", "", "start", "", "count", "after", "onTextChanged", "before", "afterTextChanged", "Landroid/text/Editable;", "app_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* compiled from: FaqFragment.kt */
public final class FaqFragment$setupSearch$1 implements TextWatcher {
    final /* synthetic */ FaqFragment this$0;

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    FaqFragment$setupSearch$1(FaqFragment faqFragment) {
        this.this$0 = faqFragment;
    }

    public void afterTextChanged(Editable editable) {
        String str;
        List list;
        String obj;
        if (editable == null || (obj = editable.toString()) == null || (str = StringsKt.trim((CharSequence) obj).toString()) == null) {
            str = "";
        }
        CharSequence charSequence = str;
        if (charSequence.length() == 0) {
            list = CollectionsKt.toMutableList(this.this$0.allFaqItems);
        } else {
            Collection arrayList = new ArrayList();
            for (Object next : this.this$0.allFaqItems) {
                FaqItem faqItem = (FaqItem) next;
                if (StringsKt.contains((CharSequence) faqItem.getQuestion(), charSequence, true) || StringsKt.contains((CharSequence) faqItem.getAnswer(), charSequence, true)) {
                    arrayList.add(next);
                }
            }
            list = CollectionsKt.toMutableList((List) arrayList);
        }
        FaqAdapter access$getAdapter$p = this.this$0.adapter;
        if (access$getAdapter$p == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            access$getAdapter$p = null;
        }
        access$getAdapter$p.updateItems(list);
    }
}
