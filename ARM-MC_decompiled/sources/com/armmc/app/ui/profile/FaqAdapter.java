package com.armmc.app.ui.profile;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.RotateAnimation;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.armmc.app.databinding.ItemFaqBinding;
import com.armmc.app.databinding.ItemFaqFooterBinding;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u00172\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\u0017\u0018\u0019B#\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH\u0016J\u0018\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\fH\u0016J\u0018\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\fH\u0016J\b\u0010\u0014\u001a\u00020\fH\u0016J\u0014\u0010\u0015\u001a\u00020\b2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/armmc/app/ui/profile/FaqAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "items", "", "Lcom/armmc/app/ui/profile/FaqItem;", "onDiscordClick", "Lkotlin/Function0;", "", "<init>", "(Ljava/util/List;Lkotlin/jvm/functions/Function0;)V", "getItemViewType", "", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "holder", "getItemCount", "updateItems", "newItems", "Companion", "FaqViewHolder", "FooterViewHolder", "app_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* compiled from: FaqFragment.kt */
public final class FaqAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final int TYPE_FOOTER = 1;
    private static final int TYPE_ITEM = 0;
    private final List<FaqItem> items;
    private final Function0<Unit> onDiscordClick;

    public FaqAdapter(List<FaqItem> list, Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(list, "items");
        Intrinsics.checkNotNullParameter(function0, "onDiscordClick");
        this.items = list;
        this.onDiscordClick = function0;
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/armmc/app/ui/profile/FaqAdapter$Companion;", "", "<init>", "()V", "TYPE_ITEM", "", "TYPE_FOOTER", "app_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* compiled from: FaqFragment.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/armmc/app/ui/profile/FaqAdapter$FaqViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/armmc/app/databinding/ItemFaqBinding;", "<init>", "(Lcom/armmc/app/ui/profile/FaqAdapter;Lcom/armmc/app/databinding/ItemFaqBinding;)V", "getBinding", "()Lcom/armmc/app/databinding/ItemFaqBinding;", "app_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* compiled from: FaqFragment.kt */
    public final class FaqViewHolder extends RecyclerView.ViewHolder {
        private final ItemFaqBinding binding;
        final /* synthetic */ FaqAdapter this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public FaqViewHolder(FaqAdapter faqAdapter, ItemFaqBinding itemFaqBinding) {
            super(itemFaqBinding.getRoot());
            Intrinsics.checkNotNullParameter(itemFaqBinding, "binding");
            this.this$0 = faqAdapter;
            this.binding = itemFaqBinding;
        }

        public final ItemFaqBinding getBinding() {
            return this.binding;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/armmc/app/ui/profile/FaqAdapter$FooterViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/armmc/app/databinding/ItemFaqFooterBinding;", "<init>", "(Lcom/armmc/app/ui/profile/FaqAdapter;Lcom/armmc/app/databinding/ItemFaqFooterBinding;)V", "getBinding", "()Lcom/armmc/app/databinding/ItemFaqFooterBinding;", "app_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* compiled from: FaqFragment.kt */
    public final class FooterViewHolder extends RecyclerView.ViewHolder {
        private final ItemFaqFooterBinding binding;
        final /* synthetic */ FaqAdapter this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public FooterViewHolder(FaqAdapter faqAdapter, ItemFaqFooterBinding itemFaqFooterBinding) {
            super(itemFaqFooterBinding.getRoot());
            Intrinsics.checkNotNullParameter(itemFaqFooterBinding, "binding");
            this.this$0 = faqAdapter;
            this.binding = itemFaqFooterBinding;
        }

        public final ItemFaqFooterBinding getBinding() {
            return this.binding;
        }
    }

    public int getItemViewType(int i) {
        return i < this.items.size() ? 0 : 1;
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        if (i == 0) {
            ItemFaqBinding inflate = ItemFaqBinding.inflate(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
            Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
            return new FaqViewHolder(this, inflate);
        }
        ItemFaqFooterBinding inflate2 = ItemFaqFooterBinding.inflate(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate2, "inflate(...)");
        return new FooterViewHolder(this, inflate2);
    }

    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        Intrinsics.checkNotNullParameter(viewHolder, "holder");
        if (viewHolder instanceof FooterViewHolder) {
            ((FooterViewHolder) viewHolder).getBinding().discordButton.setOnClickListener(new FaqAdapter$$ExternalSyntheticLambda0(this));
            return;
        }
        ItemFaqBinding binding = ((FaqViewHolder) viewHolder).getBinding();
        FaqItem faqItem = this.items.get(i);
        binding.questionText.setText(faqItem.getQuestion());
        binding.answerText.setText(faqItem.getAnswer());
        if (faqItem.isExpanded()) {
            binding.answerText.setVisibility(0);
            binding.divider.setVisibility(0);
            binding.chevronIcon.setRotation(180.0f);
        } else {
            binding.answerText.setVisibility(8);
            binding.divider.setVisibility(8);
            binding.chevronIcon.setRotation(0.0f);
        }
        binding.questionRow.setOnClickListener(new FaqAdapter$$ExternalSyntheticLambda1(faqItem, binding));
    }

    /* access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$0(FaqAdapter faqAdapter, View view) {
        faqAdapter.onDiscordClick.invoke();
    }

    /* access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$2(FaqItem faqItem, ItemFaqBinding itemFaqBinding, View view) {
        boolean isExpanded = faqItem.isExpanded();
        faqItem.setExpanded(!isExpanded);
        float f = 0.0f;
        float f2 = 0.0f;
        if (isExpanded) {
            f = 180.0f;
        }
        if (!isExpanded) {
            f2 = 180.0f;
        }
        RotateAnimation rotateAnimation = new RotateAnimation(f, f2, 1, 0.5f, 1, 0.5f);
        rotateAnimation.setDuration(200);
        rotateAnimation.setFillAfter(true);
        itemFaqBinding.chevronIcon.startAnimation(rotateAnimation);
        int i = 0;
        itemFaqBinding.divider.setVisibility(faqItem.isExpanded() ? 0 : 8);
        TextView textView = itemFaqBinding.answerText;
        if (!faqItem.isExpanded()) {
            i = 8;
        }
        textView.setVisibility(i);
    }

    public int getItemCount() {
        return this.items.size() + 1;
    }

    public final void updateItems(List<FaqItem> list) {
        Intrinsics.checkNotNullParameter(list, "newItems");
        this.items.clear();
        this.items.addAll(list);
        notifyDataSetChanged();
    }
}
