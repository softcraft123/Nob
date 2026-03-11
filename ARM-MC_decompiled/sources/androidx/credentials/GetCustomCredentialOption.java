package androidx.credentials;

import android.content.ComponentName;
import android.os.Bundle;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001BA\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\u0002\u0010\rBK\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f¢\u0006\u0002\u0010\u0010BK\b\u0000\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f¢\u0006\u0002\u0010\u0011¨\u0006\u0012"}, d2 = {"Landroidx/credentials/GetCustomCredentialOption;", "Landroidx/credentials/CredentialOption;", "type", "", "requestData", "Landroid/os/Bundle;", "candidateQueryData", "isSystemProviderRequired", "", "isAutoSelectAllowed", "allowedProviders", "", "Landroid/content/ComponentName;", "(Ljava/lang/String;Landroid/os/Bundle;Landroid/os/Bundle;ZZLjava/util/Set;)V", "typePriorityHint", "", "(Ljava/lang/String;Landroid/os/Bundle;Landroid/os/Bundle;ZZLjava/util/Set;I)V", "(Landroid/os/Bundle;Ljava/lang/String;Landroid/os/Bundle;ZZLjava/util/Set;I)V", "credentials_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: GetCustomCredentialOption.kt */
public class GetCustomCredentialOption extends CredentialOption {
    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public GetCustomCredentialOption(String str, Bundle bundle, Bundle bundle2, boolean z) {
        this(str, bundle, bundle2, z, false, (Set) null, 48, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(str, "type");
        Intrinsics.checkNotNullParameter(bundle, "requestData");
        Intrinsics.checkNotNullParameter(bundle2, "candidateQueryData");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public GetCustomCredentialOption(String str, Bundle bundle, Bundle bundle2, boolean z, boolean z2) {
        this(str, bundle, bundle2, z, z2, (Set) null, 32, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(str, "type");
        Intrinsics.checkNotNullParameter(bundle, "requestData");
        Intrinsics.checkNotNullParameter(bundle2, "candidateQueryData");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ GetCustomCredentialOption(Bundle bundle, String str, Bundle bundle2, boolean z, boolean z2, Set set, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(bundle, str, bundle2, z, (i2 & 16) != 0 ? false : z2, (Set<ComponentName>) (i2 & 32) != 0 ? SetsKt.emptySet() : set, (i2 & 64) != 0 ? 2000 : i);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GetCustomCredentialOption(Bundle bundle, String str, Bundle bundle2, boolean z, boolean z2, Set<ComponentName> set, int i) {
        super(str, bundle, bundle2, z, z2, set, i);
        Intrinsics.checkNotNullParameter(bundle, "requestData");
        Intrinsics.checkNotNullParameter(str, "type");
        Intrinsics.checkNotNullParameter(bundle2, "candidateQueryData");
        Intrinsics.checkNotNullParameter(set, "allowedProviders");
        if (str.length() <= 0) {
            throw new IllegalArgumentException("type should not be empty".toString());
        } else if (i == 100) {
            throw new IllegalArgumentException("Custom types should not have passkey level priority.".toString());
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ GetCustomCredentialOption(String str, Bundle bundle, Bundle bundle2, boolean z, boolean z2, Set set, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, bundle, bundle2, z, (i & 16) != 0 ? false : z2, (i & 32) != 0 ? SetsKt.emptySet() : set);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public GetCustomCredentialOption(java.lang.String r12, android.os.Bundle r13, android.os.Bundle r14, boolean r15, boolean r16, java.util.Set<android.content.ComponentName> r17) {
        /*
            r11 = this;
            java.lang.String r0 = "type"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
            java.lang.String r0 = "requestData"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r0)
            java.lang.String r0 = "candidateQueryData"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r0)
            java.lang.String r0 = "allowedProviders"
            r7 = r17
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            r9 = 64
            r10 = 0
            r8 = 0
            r1 = r11
            r3 = r12
            r2 = r13
            r4 = r14
            r5 = r15
            r6 = r16
            r1.<init>((android.os.Bundle) r2, (java.lang.String) r3, (android.os.Bundle) r4, (boolean) r5, (boolean) r6, (java.util.Set) r7, (int) r8, (int) r9, (kotlin.jvm.internal.DefaultConstructorMarker) r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.credentials.GetCustomCredentialOption.<init>(java.lang.String, android.os.Bundle, android.os.Bundle, boolean, boolean, java.util.Set):void");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ GetCustomCredentialOption(String str, Bundle bundle, Bundle bundle2, boolean z, boolean z2, Set set, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, bundle, bundle2, z, (i2 & 16) != 0 ? false : z2, (Set<ComponentName>) (i2 & 32) != 0 ? SetsKt.emptySet() : set, (i2 & 64) != 0 ? 2000 : i);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public GetCustomCredentialOption(String str, Bundle bundle, Bundle bundle2, boolean z, boolean z2, Set<ComponentName> set, int i) {
        this(bundle, str, bundle2, z, z2, set, i);
        Intrinsics.checkNotNullParameter(str, "type");
        Intrinsics.checkNotNullParameter(bundle, "requestData");
        Intrinsics.checkNotNullParameter(bundle2, "candidateQueryData");
        Intrinsics.checkNotNullParameter(set, "allowedProviders");
    }
}
