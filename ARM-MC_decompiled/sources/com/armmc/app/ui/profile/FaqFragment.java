package com.armmc.app.ui.profile;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.armmc.app.databinding.FragmentFaqBinding;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u0017H\u0002J\b\u0010\u0018\u001a\u00020\u0017H\u0002J\b\u0010\u0019\u001a\u00020\u0017H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u00058BX\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX.¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/armmc/app/ui/profile/FaqFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "_binding", "Lcom/armmc/app/databinding/FragmentFaqBinding;", "binding", "getBinding", "()Lcom/armmc/app/databinding/FragmentFaqBinding;", "adapter", "Lcom/armmc/app/ui/profile/FaqAdapter;", "allFaqItems", "", "Lcom/armmc/app/ui/profile/FaqItem;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "setupRecyclerView", "", "setupSearch", "onDestroyView", "app_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* compiled from: FaqFragment.kt */
public final class FaqFragment extends Fragment {
    private FragmentFaqBinding _binding;
    /* access modifiers changed from: private */
    public FaqAdapter adapter;
    /* access modifiers changed from: private */
    public final List<FaqItem> allFaqItems = CollectionsKt.listOf(new FaqItem("What is PumpkinMC?", "PumpkinMC is a high-performance Minecraft server built from the ground up using the Rust programming language. Unlike traditional servers (like Vanilla or Paper) that run on Java, Pumpkin is designed to be incredibly fast, lightweight, and memory-efficient.", false, 4, (DefaultConstructorMarker) null), new FaqItem("How do I use the free public domain?", "After creating an account, open the tunnel settings in the top right and select your preferred region. WitherHost will provide you with a free public domain (e.g. abc123.witherhost.com) that allows friends to connect to your server without any port forwarding..", false, 4, (DefaultConstructorMarker) null), new FaqItem("Why doesn't Mob AI work?", "PumpkinMC is still in active development. Full mob AI requires complex pathfinding and behavior systems that are not yet fully implemented. Basic mobs will spawn, but advanced AI behaviors (combat, fleeing, breeding) may be limited or absent. Check back for updates as development progresses.", false, 4, (DefaultConstructorMarker) null), new FaqItem("How much RAM does my phone need?", "For a small server with 1-3 players, 2 GB of RAM is usually sufficient. For 4-8 players or larger worlds, at least 5 GB is recommended.", false, 4, (DefaultConstructorMarker) null), new FaqItem("Is my world data backed up?", "World data is stored locally on your device in the app's data directory. WitherHost does not automatically back up worlds to the cloud.", false, 4, (DefaultConstructorMarker) null), new FaqItem("What Minecraft versions are supported?", "Currently WitherHost supports Minecraft Java Edition 1.21.11 via the PumpkinMC server. Additional versions will be added as dynamic updates. Make sure you connect with a matching client version.", false, 4, (DefaultConstructorMarker) null), new FaqItem("How to add mods or plugins?", "PumpkinMC currently does not have support for mods and plugins.", false, 4, (DefaultConstructorMarker) null), new FaqItem("Why does my server crash on start?", "Common causes include insufficient available RAM, a corrupted world file, or a permissions issue with storage access. Try reducing RAM, deleting the world to start fresh, or re-granting storage permissions in Android Settings → Apps → WitherHost → Permissions.", false, 4, (DefaultConstructorMarker) null));

    private final FragmentFaqBinding getBinding() {
        FragmentFaqBinding fragmentFaqBinding = this._binding;
        Intrinsics.checkNotNull(fragmentFaqBinding);
        return fragmentFaqBinding;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        this._binding = FragmentFaqBinding.inflate(layoutInflater, viewGroup, false);
        setupRecyclerView();
        setupSearch();
        LinearLayout root = getBinding().getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        return root;
    }

    private final void setupRecyclerView() {
        this.adapter = new FaqAdapter(CollectionsKt.toMutableList(this.allFaqItems), new FaqFragment$$ExternalSyntheticLambda0(this));
        getBinding().faqRecyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        RecyclerView recyclerView = getBinding().faqRecyclerView;
        FaqAdapter faqAdapter = this.adapter;
        if (faqAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            faqAdapter = null;
        }
        recyclerView.setAdapter(faqAdapter);
    }

    /* access modifiers changed from: private */
    public static final Unit setupRecyclerView$lambda$0(FaqFragment faqFragment) {
        faqFragment.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://discord.com/invite/3gQW23CXkM")));
        return Unit.INSTANCE;
    }

    private final void setupSearch() {
        getBinding().searchInput.addTextChangedListener(new FaqFragment$setupSearch$1(this));
    }

    public void onDestroyView() {
        super.onDestroyView();
        this._binding = null;
    }
}
