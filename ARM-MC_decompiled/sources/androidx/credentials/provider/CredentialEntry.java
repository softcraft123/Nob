package androidx.credentials.provider;

import android.app.slice.Slice;
import android.app.slice.SliceSpec;
import android.os.Build;
import androidx.credentials.PasswordCredential;
import androidx.credentials.PublicKeyCredential;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\b&\u0018\u0000 \u00152\u00020\u0001:\u0002\u0014\u0015B3\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\u000bR\u0013\u0010\n\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0011R\u0016\u0010\u0002\u001a\u00020\u00038\u0017X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0016"}, d2 = {"Landroidx/credentials/provider/CredentialEntry;", "", "type", "", "beginGetCredentialOption", "Landroidx/credentials/provider/BeginGetCredentialOption;", "entryGroupId", "", "isDefaultIconPreferredAsSingleProvider", "", "affiliatedDomain", "(Ljava/lang/String;Landroidx/credentials/provider/BeginGetCredentialOption;Ljava/lang/CharSequence;ZLjava/lang/CharSequence;)V", "getAffiliatedDomain", "()Ljava/lang/CharSequence;", "getBeginGetCredentialOption", "()Landroidx/credentials/provider/BeginGetCredentialOption;", "getEntryGroupId", "()Z", "getType", "()Ljava/lang/String;", "Api34Impl", "Companion", "credentials_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: CredentialEntry.kt */
public abstract class CredentialEntry {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final CharSequence affiliatedDomain;
    private final BeginGetCredentialOption beginGetCredentialOption;
    private final CharSequence entryGroupId;
    private final boolean isDefaultIconPreferredAsSingleProvider;
    private final String type;

    @JvmStatic
    public static final CredentialEntry fromCredentialEntry(android.service.credentials.CredentialEntry credentialEntry) {
        return Companion.fromCredentialEntry(credentialEntry);
    }

    @JvmStatic
    public static final CredentialEntry fromSlice$credentials_release(Slice slice) {
        return Companion.fromSlice$credentials_release(slice);
    }

    @JvmStatic
    public static final Slice toSlice$credentials_release(CredentialEntry credentialEntry) {
        return Companion.toSlice$credentials_release(credentialEntry);
    }

    public CredentialEntry(String str, BeginGetCredentialOption beginGetCredentialOption2, CharSequence charSequence, boolean z, CharSequence charSequence2) {
        Intrinsics.checkNotNullParameter(str, "type");
        Intrinsics.checkNotNullParameter(beginGetCredentialOption2, "beginGetCredentialOption");
        Intrinsics.checkNotNullParameter(charSequence, "entryGroupId");
        this.type = str;
        this.beginGetCredentialOption = beginGetCredentialOption2;
        this.entryGroupId = charSequence;
        this.isDefaultIconPreferredAsSingleProvider = z;
        this.affiliatedDomain = charSequence2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CredentialEntry(String str, BeginGetCredentialOption beginGetCredentialOption2, CharSequence charSequence, boolean z, CharSequence charSequence2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, beginGetCredentialOption2, charSequence, z, (i & 16) != 0 ? null : charSequence2);
    }

    public String getType() {
        return this.type;
    }

    public final BeginGetCredentialOption getBeginGetCredentialOption() {
        return this.beginGetCredentialOption;
    }

    public final CharSequence getEntryGroupId() {
        return this.entryGroupId;
    }

    public final boolean isDefaultIconPreferredAsSingleProvider() {
        return this.isDefaultIconPreferredAsSingleProvider;
    }

    public final CharSequence getAffiliatedDomain() {
        return this.affiliatedDomain;
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÃ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, d2 = {"Landroidx/credentials/provider/CredentialEntry$Api34Impl;", "", "()V", "fromCredentialEntry", "Landroidx/credentials/provider/CredentialEntry;", "credentialEntry", "Landroid/service/credentials/CredentialEntry;", "credentials_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: CredentialEntry.kt */
    private static final class Api34Impl {
        public static final Api34Impl INSTANCE = new Api34Impl();

        private Api34Impl() {
        }

        @JvmStatic
        public static final CredentialEntry fromCredentialEntry(android.service.credentials.CredentialEntry credentialEntry) {
            Intrinsics.checkNotNullParameter(credentialEntry, "credentialEntry");
            Slice slice = credentialEntry.getSlice();
            Intrinsics.checkNotNullExpressionValue(slice, "credentialEntry.slice");
            return CredentialEntry.Companion.fromSlice$credentials_release(slice);
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0017\u0010\u0007\u001a\u0004\u0018\u00010\u00042\u0006\u0010\b\u001a\u00020\tH\u0001¢\u0006\u0002\b\nJ\u0017\u0010\u000b\u001a\u0004\u0018\u00010\t2\u0006\u0010\f\u001a\u00020\u0004H\u0001¢\u0006\u0002\b\r¨\u0006\u000e"}, d2 = {"Landroidx/credentials/provider/CredentialEntry$Companion;", "", "()V", "fromCredentialEntry", "Landroidx/credentials/provider/CredentialEntry;", "credentialEntry", "Landroid/service/credentials/CredentialEntry;", "fromSlice", "slice", "Landroid/app/slice/Slice;", "fromSlice$credentials_release", "toSlice", "entry", "toSlice$credentials_release", "credentials_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: CredentialEntry.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final CredentialEntry fromCredentialEntry(android.service.credentials.CredentialEntry credentialEntry) {
            Intrinsics.checkNotNullParameter(credentialEntry, "credentialEntry");
            if (Build.VERSION.SDK_INT >= 34) {
                return Api34Impl.fromCredentialEntry(credentialEntry);
            }
            return null;
        }

        @JvmStatic
        public final CredentialEntry fromSlice$credentials_release(Slice slice) {
            Intrinsics.checkNotNullParameter(slice, "slice");
            try {
                SliceSpec spec = slice.getSpec();
                String type = spec != null ? spec.getType() : null;
                if (Intrinsics.areEqual((Object) type, (Object) PasswordCredential.TYPE_PASSWORD_CREDENTIAL)) {
                    PasswordCredentialEntry fromSlice = PasswordCredentialEntry.Companion.fromSlice(slice);
                    Intrinsics.checkNotNull(fromSlice);
                    return fromSlice;
                } else if (Intrinsics.areEqual((Object) type, (Object) PublicKeyCredential.TYPE_PUBLIC_KEY_CREDENTIAL)) {
                    PublicKeyCredentialEntry fromSlice2 = PublicKeyCredentialEntry.Companion.fromSlice(slice);
                    Intrinsics.checkNotNull(fromSlice2);
                    return fromSlice2;
                } else {
                    CustomCredentialEntry fromSlice3 = CustomCredentialEntry.Companion.fromSlice(slice);
                    Intrinsics.checkNotNull(fromSlice3);
                    return fromSlice3;
                }
            } catch (Exception unused) {
                return CustomCredentialEntry.Companion.fromSlice(slice);
            }
        }

        @JvmStatic
        public final Slice toSlice$credentials_release(CredentialEntry credentialEntry) {
            Intrinsics.checkNotNullParameter(credentialEntry, "entry");
            if (credentialEntry instanceof PasswordCredentialEntry) {
                return PasswordCredentialEntry.Companion.toSlice((PasswordCredentialEntry) credentialEntry);
            }
            if (credentialEntry instanceof PublicKeyCredentialEntry) {
                return PublicKeyCredentialEntry.Companion.toSlice((PublicKeyCredentialEntry) credentialEntry);
            }
            if (credentialEntry instanceof CustomCredentialEntry) {
                return CustomCredentialEntry.Companion.toSlice((CustomCredentialEntry) credentialEntry);
            }
            return null;
        }
    }
}
