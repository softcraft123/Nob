package com.armmc.app.ui.files;

import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.activity.OnBackPressedDispatcher;
import androidx.appcompat.app.AlertDialog;
import androidx.core.os.BundleKt;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.FragmentKt;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.armmc.app.R;
import com.armmc.app.databinding.FragmentFilesBinding;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.io.FilesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000S\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002*\u0001\u000e\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\u001a\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00112\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\b\u0010\u001b\u001a\u00020\u0019H\u0002J\b\u0010\u001c\u001a\u00020\u0019H\u0002J\b\u0010\u001d\u001a\u00020\u0019H\u0002J\u0016\u0010\u001e\u001a\u00020\u00192\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020!0 H\u0002J\b\u0010\"\u001a\u00020\u0019H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u00058BX\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX.¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX.¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0004\n\u0002\u0010\u000f¨\u0006#"}, d2 = {"Lcom/armmc/app/ui/files/FilesFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "_binding", "Lcom/armmc/app/databinding/FragmentFilesBinding;", "binding", "getBinding", "()Lcom/armmc/app/databinding/FragmentFilesBinding;", "viewModel", "Lcom/armmc/app/ui/files/FilesViewModel;", "adapter", "Lcom/armmc/app/ui/files/FileAdapter;", "backCallback", "com/armmc/app/ui/files/FilesFragment$backCallback$1", "Lcom/armmc/app/ui/files/FilesFragment$backCallback$1;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "setupRecyclerView", "setupSearch", "observeViewModel", "updateBreadcrumb", "segments", "", "", "onDestroyView", "app_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* compiled from: FilesFragment.kt */
public final class FilesFragment extends Fragment {
    private FragmentFilesBinding _binding;
    /* access modifiers changed from: private */
    public FileAdapter adapter;
    /* access modifiers changed from: private */
    public final FilesFragment$backCallback$1 backCallback = new FilesFragment$backCallback$1(this);
    /* access modifiers changed from: private */
    public FilesViewModel viewModel;

    /* access modifiers changed from: private */
    public final FragmentFilesBinding getBinding() {
        FragmentFilesBinding fragmentFilesBinding = this._binding;
        Intrinsics.checkNotNull(fragmentFilesBinding);
        return fragmentFilesBinding;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        this._binding = FragmentFilesBinding.inflate(layoutInflater, viewGroup, false);
        LinearLayout root = getBinding().getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        return root;
    }

    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        this.viewModel = (FilesViewModel) new ViewModelProvider(this).get(FilesViewModel.class);
        setupRecyclerView();
        setupSearch();
        observeViewModel();
        OnBackPressedDispatcher onBackPressedDispatcher = requireActivity().getOnBackPressedDispatcher();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        onBackPressedDispatcher.addCallback(viewLifecycleOwner, this.backCallback);
    }

    private final void setupRecyclerView() {
        this.adapter = new FileAdapter(CollectionsKt.emptyList(), new FilesFragment$$ExternalSyntheticLambda1(this), new FilesFragment$$ExternalSyntheticLambda2(this));
        getBinding().fileRecyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        RecyclerView recyclerView = getBinding().fileRecyclerView;
        FileAdapter fileAdapter = this.adapter;
        if (fileAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            fileAdapter = null;
        }
        recyclerView.setAdapter(fileAdapter);
        getBinding().fileRecyclerView.addItemDecoration(new DividerItemDecoration(requireContext(), 1));
    }

    /* access modifiers changed from: private */
    public static final Unit setupRecyclerView$lambda$0(FilesFragment filesFragment, FileItem fileItem) {
        Intrinsics.checkNotNullParameter(fileItem, "item");
        if (fileItem.isDirectory()) {
            FilesViewModel filesViewModel = filesFragment.viewModel;
            if (filesViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                filesViewModel = null;
            }
            filesViewModel.navigateTo(fileItem);
        } else {
            String lowerCase = FilesKt.getExtension(fileItem.getFile()).toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            if (FilePreviewFragment.Companion.getIMAGE_EXTENSIONS().contains(lowerCase) || FilePreviewFragment.Companion.getTEXT_EXTENSIONS().contains(lowerCase)) {
                FragmentKt.findNavController(filesFragment).navigate(R.id.action_files_to_preview, BundleKt.bundleOf(TuplesKt.to(FilePreviewFragment.ARG_FILE_PATH, fileItem.getFile().getAbsolutePath())));
            }
        }
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit setupRecyclerView$lambda$2(FilesFragment filesFragment, FileItem fileItem) {
        String str;
        Intrinsics.checkNotNullParameter(fileItem, "item");
        AlertDialog.Builder title = new AlertDialog.Builder(filesFragment.requireContext()).setTitle((CharSequence) "Delete " + fileItem.getName() + "?");
        if (fileItem.isDirectory()) {
            str = "This will permanently delete the folder and all its contents.";
        } else {
            str = "This will permanently delete the file.";
        }
        title.setMessage((CharSequence) str).setPositiveButton((CharSequence) "Delete", (DialogInterface.OnClickListener) new FilesFragment$$ExternalSyntheticLambda0(filesFragment, fileItem)).setNegativeButton((CharSequence) "Cancel", (DialogInterface.OnClickListener) null).show();
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final void setupRecyclerView$lambda$2$lambda$1(FilesFragment filesFragment, FileItem fileItem, DialogInterface dialogInterface, int i) {
        FilesViewModel filesViewModel = filesFragment.viewModel;
        if (filesViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            filesViewModel = null;
        }
        filesViewModel.deleteItem(fileItem);
    }

    private final void setupSearch() {
        getBinding().searchField.addTextChangedListener(new FilesFragment$setupSearch$1(this));
    }

    private final void observeViewModel() {
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        Job unused = BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner), (CoroutineContext) null, (CoroutineStart) null, new FilesFragment$observeViewModel$1(this, (Continuation<? super FilesFragment$observeViewModel$1>) null), 3, (Object) null);
        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner2, "getViewLifecycleOwner(...)");
        Job unused2 = BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner2), (CoroutineContext) null, (CoroutineStart) null, new FilesFragment$observeViewModel$2(this, (Continuation<? super FilesFragment$observeViewModel$2>) null), 3, (Object) null);
        LifecycleOwner viewLifecycleOwner3 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner3, "getViewLifecycleOwner(...)");
        Job unused3 = BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner3), (CoroutineContext) null, (CoroutineStart) null, new FilesFragment$observeViewModel$3(this, (Continuation<? super FilesFragment$observeViewModel$3>) null), 3, (Object) null);
    }

    /* access modifiers changed from: private */
    public final void updateBreadcrumb(List<String> list) {
        int i;
        LinearLayout linearLayout = getBinding().breadcrumbContainer;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "breadcrumbContainer");
        linearLayout.removeAllViews();
        int i2 = 0;
        for (Object next : list) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            String str = (String) next;
            boolean z = i2 == CollectionsKt.getLastIndex(list);
            TextView textView = new TextView(requireContext());
            textView.setText(str);
            textView.setTextSize(13.0f);
            if (z) {
                i = Color.parseColor("#39FF14");
            } else {
                i = Color.parseColor("#8A9A8A");
            }
            textView.setTextColor(i);
            textView.setPadding(0, 4, 0, 4);
            if (!z) {
                textView.setClickable(true);
                textView.setOnClickListener(new FilesFragment$$ExternalSyntheticLambda3(this, i2));
            }
            linearLayout.addView(textView);
            if (!z) {
                TextView textView2 = new TextView(requireContext());
                textView2.setText(" › ");
                textView2.setTextSize(13.0f);
                textView2.setTextColor(Color.parseColor("#4A6A4A"));
                textView2.setPadding(2, 4, 2, 4);
                linearLayout.addView(textView2);
            }
            i2 = i3;
        }
    }

    /* access modifiers changed from: private */
    public static final void updateBreadcrumb$lambda$6$lambda$4$lambda$3(FilesFragment filesFragment, int i, View view) {
        FilesViewModel filesViewModel = filesFragment.viewModel;
        if (filesViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            filesViewModel = null;
        }
        filesViewModel.navigateToDepth(i);
    }

    public void onDestroyView() {
        super.onDestroyView();
        this._binding = null;
    }
}
