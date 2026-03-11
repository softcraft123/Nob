package com.armmc.app.ui.profile;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0006HÆ\u0003J'\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00062\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0018"}, d2 = {"Lcom/armmc/app/ui/profile/FaqItem;", "", "question", "", "answer", "isExpanded", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Z)V", "getQuestion", "()Ljava/lang/String;", "getAnswer", "()Z", "setExpanded", "(Z)V", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* compiled from: FaqFragment.kt */
public final class FaqItem {
    private final String answer;
    private boolean isExpanded;
    private final String question;

    public static /* synthetic */ FaqItem copy$default(FaqItem faqItem, String str, String str2, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            str = faqItem.question;
        }
        if ((i & 2) != 0) {
            str2 = faqItem.answer;
        }
        if ((i & 4) != 0) {
            z = faqItem.isExpanded;
        }
        return faqItem.copy(str, str2, z);
    }

    public final String component1() {
        return this.question;
    }

    public final String component2() {
        return this.answer;
    }

    public final boolean component3() {
        return this.isExpanded;
    }

    public final FaqItem copy(String str, String str2, boolean z) {
        Intrinsics.checkNotNullParameter(str, "question");
        Intrinsics.checkNotNullParameter(str2, "answer");
        return new FaqItem(str, str2, z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FaqItem)) {
            return false;
        }
        FaqItem faqItem = (FaqItem) obj;
        return Intrinsics.areEqual((Object) this.question, (Object) faqItem.question) && Intrinsics.areEqual((Object) this.answer, (Object) faqItem.answer) && this.isExpanded == faqItem.isExpanded;
    }

    public int hashCode() {
        return (((this.question.hashCode() * 31) + this.answer.hashCode()) * 31) + Boolean.hashCode(this.isExpanded);
    }

    public String toString() {
        String str = this.question;
        String str2 = this.answer;
        return "FaqItem(question=" + str + ", answer=" + str2 + ", isExpanded=" + this.isExpanded + ")";
    }

    public FaqItem(String str, String str2, boolean z) {
        Intrinsics.checkNotNullParameter(str, "question");
        Intrinsics.checkNotNullParameter(str2, "answer");
        this.question = str;
        this.answer = str2;
        this.isExpanded = z;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ FaqItem(String str, String str2, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, (i & 4) != 0 ? false : z);
    }

    public final String getQuestion() {
        return this.question;
    }

    public final String getAnswer() {
        return this.answer;
    }

    public final boolean isExpanded() {
        return this.isExpanded;
    }

    public final void setExpanded(boolean z) {
        this.isExpanded = z;
    }
}
