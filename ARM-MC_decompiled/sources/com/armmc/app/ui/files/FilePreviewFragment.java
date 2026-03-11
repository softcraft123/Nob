package com.armmc.app.ui.files;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.navigation.fragment.FragmentKt;
import com.armmc.app.databinding.FragmentFilePreviewBinding;
import java.io.File;
import java.util.Locale;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.io.FilesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\u001a\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\n2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\u0010\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u0018\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\u0010\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u0019H\u0002J\u0010\u0010\u001c\u001a\u00020\u00122\u0006\u0010\u001d\u001a\u00020\u0019H\u0002J\b\u0010\u001e\u001a\u00020\u0012H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u00058BX\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006 "}, d2 = {"Lcom/armmc/app/ui/files/FilePreviewFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "_binding", "Lcom/armmc/app/databinding/FragmentFilePreviewBinding;", "binding", "getBinding", "()Lcom/armmc/app/databinding/FragmentFilePreviewBinding;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "loadImage", "file", "Ljava/io/File;", "loadText", "ext", "", "prettyPrintJson", "raw", "showError", "message", "onDestroyView", "Companion", "app_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* compiled from: FilePreviewFragment.kt */
public final class FilePreviewFragment extends Fragment {
    public static final String ARG_FILE_PATH = "filePath";
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final Set<String> IMAGE_EXTENSIONS = SetsKt.setOf("png", "jpg", "jpeg", "webp");
    private static final int MAX_IMAGE_DIM = 2048;
    private static final long MAX_TEXT_BYTES = 524288;
    /* access modifiers changed from: private */
    public static final Set<String> TEXT_EXTENSIONS = SetsKt.setOf("json", "txt", "log", "properties", "toml", "yml", "yaml");
    private FragmentFilePreviewBinding _binding;

    /* access modifiers changed from: private */
    public final FragmentFilePreviewBinding getBinding() {
        FragmentFilePreviewBinding fragmentFilePreviewBinding = this._binding;
        Intrinsics.checkNotNull(fragmentFilePreviewBinding);
        return fragmentFilePreviewBinding;
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\"\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00050\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\r¨\u0006\u0010"}, d2 = {"Lcom/armmc/app/ui/files/FilePreviewFragment$Companion;", "", "<init>", "()V", "ARG_FILE_PATH", "", "MAX_TEXT_BYTES", "", "MAX_IMAGE_DIM", "", "IMAGE_EXTENSIONS", "", "getIMAGE_EXTENSIONS", "()Ljava/util/Set;", "TEXT_EXTENSIONS", "getTEXT_EXTENSIONS", "app_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* compiled from: FilePreviewFragment.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Set<String> getIMAGE_EXTENSIONS() {
            return FilePreviewFragment.IMAGE_EXTENSIONS;
        }

        public final Set<String> getTEXT_EXTENSIONS() {
            return FilePreviewFragment.TEXT_EXTENSIONS;
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        this._binding = FragmentFilePreviewBinding.inflate(layoutInflater, viewGroup, false);
        LinearLayout root = getBinding().getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        return root;
    }

    public void onViewCreated(View view, Bundle bundle) {
        String string;
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        getBinding().backButton.setOnClickListener(new FilePreviewFragment$$ExternalSyntheticLambda0(this));
        Bundle arguments = getArguments();
        if (arguments == null || (string = arguments.getString(ARG_FILE_PATH)) == null) {
            FilePreviewFragment filePreviewFragment = this;
            showError("File path missing");
            return;
        }
        File file = new File(string);
        if (!file.exists() || !file.isFile()) {
            showError("File not found");
            return;
        }
        getBinding().previewFileName.setText(file.getName());
        String lowerCase = FilesKt.getExtension(file).toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        if (IMAGE_EXTENSIONS.contains(lowerCase)) {
            loadImage(file);
        } else if (TEXT_EXTENSIONS.contains(lowerCase)) {
            loadText(file, lowerCase);
        } else {
            showError("Preview not available for this file type");
        }
    }

    /* access modifiers changed from: private */
    public static final void onViewCreated$lambda$0(FilePreviewFragment filePreviewFragment, View view) {
        FragmentKt.findNavController(filePreviewFragment).popBackStack();
    }

    private final void loadImage(File file) {
        getBinding().previewFileType.setText("Image");
        getBinding().previewProgress.setVisibility(0);
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        Job unused = BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner), (CoroutineContext) null, (CoroutineStart) null, new FilePreviewFragment$loadImage$1(this, file, (Continuation<? super FilePreviewFragment$loadImage$1>) null), 3, (Object) null);
    }

    private final void loadText(File file, String str) {
        getBinding().previewFileType.setText(Intrinsics.areEqual((Object) str, (Object) "json") ? "JSON" : "Text");
        getBinding().previewProgress.setVisibility(0);
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        Job unused = BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner), (CoroutineContext) null, (CoroutineStart) null, new FilePreviewFragment$loadText$1(this, file, str, (Continuation<? super FilePreviewFragment$loadText$1>) null), 3, (Object) null);
    }

    /* access modifiers changed from: private */
    public final String prettyPrintJson(String str) {
        try {
            String obj = StringsKt.trim((CharSequence) str).toString();
            if (StringsKt.startsWith$default(obj, "{", false, 2, (Object) null)) {
                return new JSONObject(obj).toString(2);
            }
            return StringsKt.startsWith$default(obj, "[", false, 2, (Object) null) ? new JSONArray(obj).toString(2) : str;
        } catch (JSONException unused) {
            return str;
        }
    }

    /* access modifiers changed from: private */
    public final void showError(String str) {
        getBinding().previewProgress.setVisibility(8);
        getBinding().previewError.setText(str);
        getBinding().previewError.setVisibility(0);
    }

    public void onDestroyView() {
        super.onDestroyView();
        this._binding = null;
    }
}
