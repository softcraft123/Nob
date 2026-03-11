package com.armmc.app.ui.files;

import android.app.Application;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.ViewModelKt;
import com.armmc.app.ui.servers.ServerRepository;
import com.google.android.gms.actions.SearchIntents;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.SharingStarted;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001+B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u001d\u001a\u00020\u001eH\u0002J\u000e\u0010\u001f\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020\u000eJ\u0006\u0010!\u001a\u00020\u0013J\u000e\u0010\"\u001a\u00020\u001e2\u0006\u0010#\u001a\u00020$J\u000e\u0010%\u001a\u00020\u001e2\u0006\u0010&\u001a\u00020\u0010J\u0010\u0010'\u001a\u00020\u001e2\u0006\u0010(\u001a\u00020)H\u0002J\u000e\u0010*\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020\u000eR\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\fX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\fX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\r0\fX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\fX\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00100\u0015¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u001d\u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\r0\u0015¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0017R\u0017\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00130\u0015¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0017R\u001d\u0010\u001b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\u0015¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0017¨\u0006,"}, d2 = {"Lcom/armmc/app/ui/files/FilesViewModel;", "Landroidx/lifecycle/AndroidViewModel;", "application", "Landroid/app/Application;", "<init>", "(Landroid/app/Application;)V", "serverRepository", "Lcom/armmc/app/ui/servers/ServerRepository;", "directoryStack", "", "Lcom/armmc/app/ui/files/FilesViewModel$DirectoryEntry;", "_allItems", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "Lcom/armmc/app/ui/files/FileItem;", "_searchQuery", "", "_breadcrumb", "_isAtRoot", "", "searchQuery", "Lkotlinx/coroutines/flow/StateFlow;", "getSearchQuery", "()Lkotlinx/coroutines/flow/StateFlow;", "breadcrumb", "getBreadcrumb", "isAtRoot", "items", "getItems", "loadRoot", "", "navigateTo", "item", "navigateUp", "navigateToDepth", "breadcrumbIndex", "", "setSearchQuery", "query", "loadDirectory", "dir", "Ljava/io/File;", "deleteItem", "DirectoryEntry", "app_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* compiled from: FilesViewModel.kt */
public final class FilesViewModel extends AndroidViewModel {
    /* access modifiers changed from: private */
    public final MutableStateFlow<List<FileItem>> _allItems;
    /* access modifiers changed from: private */
    public final MutableStateFlow<List<String>> _breadcrumb;
    /* access modifiers changed from: private */
    public final MutableStateFlow<Boolean> _isAtRoot;
    /* access modifiers changed from: private */
    public final MutableStateFlow<String> _searchQuery;
    private final StateFlow<List<String>> breadcrumb;
    /* access modifiers changed from: private */
    public final List<DirectoryEntry> directoryStack = new ArrayList();
    private final StateFlow<Boolean> isAtRoot;
    private final StateFlow<List<FileItem>> items;
    private final StateFlow<String> searchQuery;
    /* access modifiers changed from: private */
    public final ServerRepository serverRepository;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FilesViewModel(Application application) {
        super(application);
        Intrinsics.checkNotNullParameter(application, "application");
        this.serverRepository = new ServerRepository(application);
        MutableStateFlow<List<FileItem>> MutableStateFlow = StateFlowKt.MutableStateFlow(CollectionsKt.emptyList());
        this._allItems = MutableStateFlow;
        MutableStateFlow<String> MutableStateFlow2 = StateFlowKt.MutableStateFlow("");
        this._searchQuery = MutableStateFlow2;
        MutableStateFlow<List<String>> MutableStateFlow3 = StateFlowKt.MutableStateFlow(CollectionsKt.listOf("Home"));
        this._breadcrumb = MutableStateFlow3;
        MutableStateFlow<Boolean> MutableStateFlow4 = StateFlowKt.MutableStateFlow(true);
        this._isAtRoot = MutableStateFlow4;
        this.searchQuery = MutableStateFlow2;
        this.breadcrumb = MutableStateFlow3;
        this.isAtRoot = MutableStateFlow4;
        this.items = FlowKt.stateIn(FlowKt.combine(MutableStateFlow, MutableStateFlow2, new FilesViewModel$items$1((Continuation<? super FilesViewModel$items$1>) null)), ViewModelKt.getViewModelScope(this), SharingStarted.Companion.WhileSubscribed$default(SharingStarted.Companion, 5000, 0, 2, (Object) null), CollectionsKt.emptyList());
        loadRoot();
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/armmc/app/ui/files/FilesViewModel$DirectoryEntry;", "", "label", "", "file", "Ljava/io/File;", "<init>", "(Ljava/lang/String;Ljava/io/File;)V", "getLabel", "()Ljava/lang/String;", "getFile", "()Ljava/io/File;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* compiled from: FilesViewModel.kt */
    private static final class DirectoryEntry {
        private final File file;
        private final String label;

        public static /* synthetic */ DirectoryEntry copy$default(DirectoryEntry directoryEntry, String str, File file2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = directoryEntry.label;
            }
            if ((i & 2) != 0) {
                file2 = directoryEntry.file;
            }
            return directoryEntry.copy(str, file2);
        }

        public final String component1() {
            return this.label;
        }

        public final File component2() {
            return this.file;
        }

        public final DirectoryEntry copy(String str, File file2) {
            Intrinsics.checkNotNullParameter(str, "label");
            return new DirectoryEntry(str, file2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof DirectoryEntry)) {
                return false;
            }
            DirectoryEntry directoryEntry = (DirectoryEntry) obj;
            return Intrinsics.areEqual((Object) this.label, (Object) directoryEntry.label) && Intrinsics.areEqual((Object) this.file, (Object) directoryEntry.file);
        }

        public int hashCode() {
            int hashCode = this.label.hashCode() * 31;
            File file2 = this.file;
            return hashCode + (file2 == null ? 0 : file2.hashCode());
        }

        public String toString() {
            String str = this.label;
            return "DirectoryEntry(label=" + str + ", file=" + this.file + ")";
        }

        public DirectoryEntry(String str, File file2) {
            Intrinsics.checkNotNullParameter(str, "label");
            this.label = str;
            this.file = file2;
        }

        public final File getFile() {
            return this.file;
        }

        public final String getLabel() {
            return this.label;
        }
    }

    public final StateFlow<String> getSearchQuery() {
        return this.searchQuery;
    }

    public final StateFlow<List<String>> getBreadcrumb() {
        return this.breadcrumb;
    }

    public final StateFlow<Boolean> isAtRoot() {
        return this.isAtRoot;
    }

    public final StateFlow<List<FileItem>> getItems() {
        return this.items;
    }

    /* access modifiers changed from: private */
    public final void loadRoot() {
        Job unused = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), (CoroutineStart) null, new FilesViewModel$loadRoot$1(this, (Continuation<? super FilesViewModel$loadRoot$1>) null), 2, (Object) null);
    }

    public final void navigateTo(FileItem fileItem) {
        Intrinsics.checkNotNullParameter(fileItem, "item");
        if (fileItem.isDirectory()) {
            Job unused = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), (CoroutineStart) null, new FilesViewModel$navigateTo$1(this, fileItem, (Continuation<? super FilesViewModel$navigateTo$1>) null), 2, (Object) null);
        }
    }

    public final boolean navigateUp() {
        if (this.directoryStack.isEmpty()) {
            return false;
        }
        List<DirectoryEntry> list = this.directoryStack;
        list.remove(CollectionsKt.getLastIndex(list));
        MutableStateFlow<List<String>> mutableStateFlow = this._breadcrumb;
        Collection listOf = CollectionsKt.listOf("Home");
        Iterable<DirectoryEntry> iterable = this.directoryStack;
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
        for (DirectoryEntry label : iterable) {
            arrayList.add(label.getLabel());
        }
        mutableStateFlow.setValue(CollectionsKt.plus(listOf, (List) arrayList));
        this._searchQuery.setValue("");
        Job unused = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), (CoroutineStart) null, new FilesViewModel$navigateUp$2(this, (Continuation<? super FilesViewModel$navigateUp$2>) null), 2, (Object) null);
        return true;
    }

    public final void navigateToDepth(int i) {
        if (i < this.directoryStack.size() + 1) {
            this._searchQuery.setValue("");
            while (this.directoryStack.size() > i) {
                List<DirectoryEntry> list = this.directoryStack;
                list.remove(CollectionsKt.getLastIndex(list));
            }
            MutableStateFlow<List<String>> mutableStateFlow = this._breadcrumb;
            Collection listOf = CollectionsKt.listOf("Home");
            Iterable<DirectoryEntry> iterable = this.directoryStack;
            Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
            for (DirectoryEntry label : iterable) {
                arrayList.add(label.getLabel());
            }
            mutableStateFlow.setValue(CollectionsKt.plus(listOf, (List) arrayList));
            Job unused = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), (CoroutineStart) null, new FilesViewModel$navigateToDepth$2(this, (Continuation<? super FilesViewModel$navigateToDepth$2>) null), 2, (Object) null);
        }
    }

    public final void setSearchQuery(String str) {
        Intrinsics.checkNotNullParameter(str, SearchIntents.EXTRA_QUERY);
        this._searchQuery.setValue(str);
    }

    /* access modifiers changed from: private */
    public final void loadDirectory(File file) {
        File[] listFiles;
        if (!file.exists() || !file.isDirectory()) {
            this._allItems.setValue(CollectionsKt.emptyList());
            return;
        }
        File[] listFiles2 = file.listFiles();
        if (listFiles2 == null) {
            listFiles2 = new File[0];
        }
        Iterable<File> sortedWith = ArraysKt.sortedWith((T[]) listFiles2, new FilesViewModel$loadDirectory$$inlined$thenBy$1(new FilesViewModel$loadDirectory$$inlined$compareByDescending$1()));
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(sortedWith, 10));
        for (File file2 : sortedWith) {
            String name = file2.getName();
            Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
            Intrinsics.checkNotNull(file2);
            arrayList.add(new FileItem(name, file2, file2.isDirectory(), file2.isFile() ? file2.length() : 0, file2.lastModified(), (!file2.isDirectory() || (listFiles = file2.listFiles()) == null) ? 0 : listFiles.length, false, 64, (DefaultConstructorMarker) null));
        }
        this._allItems.setValue((List) arrayList);
    }

    public final void deleteItem(FileItem fileItem) {
        Intrinsics.checkNotNullParameter(fileItem, "item");
        Job unused = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), (CoroutineStart) null, new FilesViewModel$deleteItem$1(fileItem, this, (Continuation<? super FilesViewModel$deleteItem$1>) null), 2, (Object) null);
    }
}
