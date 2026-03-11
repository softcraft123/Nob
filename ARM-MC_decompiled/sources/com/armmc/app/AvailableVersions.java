package com.armmc.app;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0013B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\t\u001a\u0004\u0018\u00010\u00062\u0006\u0010\n\u001a\u00020\u000bJ\u0010\u0010\f\u001a\u0004\u0018\u00010\u00062\u0006\u0010\r\u001a\u00020\u000bJ\b\u0010\u000e\u001a\u0004\u0018\u00010\u0006J\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0005J\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0005J\u000e\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u000bJ\u000e\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000bR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0014"}, d2 = {"Lcom/armmc/app/AvailableVersions;", "", "<init>", "()V", "AVAILABLE_VERSIONS", "", "Lcom/armmc/app/AvailableVersions$PumpkinVersion;", "getAVAILABLE_VERSIONS", "()Ljava/util/List;", "getByVersion", "version", "", "getByModuleName", "moduleName", "getRecommended", "getVersionStrings", "getModuleNames", "versionToModuleName", "moduleNameToVersion", "PumpkinVersion", "app_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* compiled from: AvailableVersions.kt */
public final class AvailableVersions {
    private static final List<PumpkinVersion> AVAILABLE_VERSIONS = CollectionsKt.listOf(new PumpkinVersion("1.21.11", "pumpkin_1_21_11", "Pumpkin 1.21.11", (String) null, true, "3 February 2026", 8, (DefaultConstructorMarker) null));
    public static final AvailableVersions INSTANCE = new AvailableVersions();

    private AvailableVersions() {
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0016\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\bHÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003JE\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001c\u001a\u00020\b2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\t\u0010 \u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u0011R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\rR\u0011\u0010\u0013\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\r¨\u0006!"}, d2 = {"Lcom/armmc/app/AvailableVersions$PumpkinVersion;", "", "version", "", "moduleName", "displayName", "libraryFileName", "isRecommended", "", "description", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;)V", "getVersion", "()Ljava/lang/String;", "getModuleName", "getDisplayName", "getLibraryFileName", "()Z", "getDescription", "packageName", "getPackageName", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* compiled from: AvailableVersions.kt */
    public static final class PumpkinVersion {
        private final String description;
        private final String displayName;
        private final boolean isRecommended;
        private final String libraryFileName;
        private final String moduleName;
        private final String version;

        public static /* synthetic */ PumpkinVersion copy$default(PumpkinVersion pumpkinVersion, String str, String str2, String str3, String str4, boolean z, String str5, int i, Object obj) {
            if ((i & 1) != 0) {
                str = pumpkinVersion.version;
            }
            if ((i & 2) != 0) {
                str2 = pumpkinVersion.moduleName;
            }
            if ((i & 4) != 0) {
                str3 = pumpkinVersion.displayName;
            }
            if ((i & 8) != 0) {
                str4 = pumpkinVersion.libraryFileName;
            }
            if ((i & 16) != 0) {
                z = pumpkinVersion.isRecommended;
            }
            if ((i & 32) != 0) {
                str5 = pumpkinVersion.description;
            }
            boolean z2 = z;
            String str6 = str5;
            String str7 = str4;
            String str8 = str2;
            return pumpkinVersion.copy(str, str8, str3, str7, z2, str6);
        }

        public final String component1() {
            return this.version;
        }

        public final String component2() {
            return this.moduleName;
        }

        public final String component3() {
            return this.displayName;
        }

        public final String component4() {
            return this.libraryFileName;
        }

        public final boolean component5() {
            return this.isRecommended;
        }

        public final String component6() {
            return this.description;
        }

        public final PumpkinVersion copy(String str, String str2, String str3, String str4, boolean z, String str5) {
            Intrinsics.checkNotNullParameter(str, "version");
            Intrinsics.checkNotNullParameter(str2, PumpkinService.EXTRA_MODULE_NAME);
            Intrinsics.checkNotNullParameter(str3, "displayName");
            Intrinsics.checkNotNullParameter(str4, "libraryFileName");
            Intrinsics.checkNotNullParameter(str5, "description");
            return new PumpkinVersion(str, str2, str3, str4, z, str5);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof PumpkinVersion)) {
                return false;
            }
            PumpkinVersion pumpkinVersion = (PumpkinVersion) obj;
            return Intrinsics.areEqual((Object) this.version, (Object) pumpkinVersion.version) && Intrinsics.areEqual((Object) this.moduleName, (Object) pumpkinVersion.moduleName) && Intrinsics.areEqual((Object) this.displayName, (Object) pumpkinVersion.displayName) && Intrinsics.areEqual((Object) this.libraryFileName, (Object) pumpkinVersion.libraryFileName) && this.isRecommended == pumpkinVersion.isRecommended && Intrinsics.areEqual((Object) this.description, (Object) pumpkinVersion.description);
        }

        public int hashCode() {
            return (((((((((this.version.hashCode() * 31) + this.moduleName.hashCode()) * 31) + this.displayName.hashCode()) * 31) + this.libraryFileName.hashCode()) * 31) + Boolean.hashCode(this.isRecommended)) * 31) + this.description.hashCode();
        }

        public String toString() {
            String str = this.version;
            String str2 = this.moduleName;
            String str3 = this.displayName;
            String str4 = this.libraryFileName;
            boolean z = this.isRecommended;
            return "PumpkinVersion(version=" + str + ", moduleName=" + str2 + ", displayName=" + str3 + ", libraryFileName=" + str4 + ", isRecommended=" + z + ", description=" + this.description + ")";
        }

        public PumpkinVersion(String str, String str2, String str3, String str4, boolean z, String str5) {
            Intrinsics.checkNotNullParameter(str, "version");
            Intrinsics.checkNotNullParameter(str2, PumpkinService.EXTRA_MODULE_NAME);
            Intrinsics.checkNotNullParameter(str3, "displayName");
            Intrinsics.checkNotNullParameter(str4, "libraryFileName");
            Intrinsics.checkNotNullParameter(str5, "description");
            this.version = str;
            this.moduleName = str2;
            this.displayName = str3;
            this.libraryFileName = str4;
            this.isRecommended = z;
            this.description = str5;
        }

        public final String getVersion() {
            return this.version;
        }

        public final String getModuleName() {
            return this.moduleName;
        }

        public final String getDisplayName() {
            return this.displayName;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ PumpkinVersion(String str, String str2, String str3, String str4, boolean z, String str5, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, str2, str3, (i & 8) != 0 ? "libpumpkin.so" : str4, (i & 16) != 0 ? false : z, (i & 32) != 0 ? "" : str5);
        }

        public final String getLibraryFileName() {
            return this.libraryFileName;
        }

        public final boolean isRecommended() {
            return this.isRecommended;
        }

        public final String getDescription() {
            return this.description;
        }

        public final String getPackageName() {
            return "com.armmc." + this.moduleName;
        }
    }

    public final List<PumpkinVersion> getAVAILABLE_VERSIONS() {
        return AVAILABLE_VERSIONS;
    }

    public final PumpkinVersion getByVersion(String str) {
        Object obj;
        Intrinsics.checkNotNullParameter(str, "version");
        Iterator it = AVAILABLE_VERSIONS.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (Intrinsics.areEqual((Object) ((PumpkinVersion) obj).getVersion(), (Object) str)) {
                break;
            }
        }
        return (PumpkinVersion) obj;
    }

    public final PumpkinVersion getByModuleName(String str) {
        Object obj;
        Intrinsics.checkNotNullParameter(str, PumpkinService.EXTRA_MODULE_NAME);
        Iterator it = AVAILABLE_VERSIONS.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (Intrinsics.areEqual((Object) ((PumpkinVersion) obj).getModuleName(), (Object) str)) {
                break;
            }
        }
        return (PumpkinVersion) obj;
    }

    public final PumpkinVersion getRecommended() {
        Object obj;
        Iterator it = AVAILABLE_VERSIONS.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (((PumpkinVersion) obj).isRecommended()) {
                break;
            }
        }
        PumpkinVersion pumpkinVersion = (PumpkinVersion) obj;
        return pumpkinVersion == null ? (PumpkinVersion) CollectionsKt.firstOrNull(AVAILABLE_VERSIONS) : pumpkinVersion;
    }

    public final List<String> getVersionStrings() {
        Iterable<PumpkinVersion> iterable = AVAILABLE_VERSIONS;
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
        for (PumpkinVersion version : iterable) {
            arrayList.add(version.getVersion());
        }
        return (List) arrayList;
    }

    public final List<String> getModuleNames() {
        Iterable<PumpkinVersion> iterable = AVAILABLE_VERSIONS;
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
        for (PumpkinVersion moduleName : iterable) {
            arrayList.add(moduleName.getModuleName());
        }
        return (List) arrayList;
    }

    public final String versionToModuleName(String str) {
        Intrinsics.checkNotNullParameter(str, "version");
        return "pumpkin_" + StringsKt.replace$default(str, ".", "_", false, 4, (Object) null);
    }

    public final String moduleNameToVersion(String str) {
        Intrinsics.checkNotNullParameter(str, PumpkinService.EXTRA_MODULE_NAME);
        return StringsKt.replace$default(StringsKt.removePrefix(str, (CharSequence) "pumpkin_"), "_", ".", false, 4, (Object) null);
    }
}
