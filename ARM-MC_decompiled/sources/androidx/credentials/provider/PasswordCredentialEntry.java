package androidx.credentials.provider;

import android.app.PendingIntent;
import android.app.slice.Slice;
import android.app.slice.SliceItem;
import android.app.slice.SliceSpec;
import android.content.Context;
import android.graphics.drawable.Icon;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.service.credentials.CredentialEntry;
import android.util.Log;
import androidx.credentials.CredentialOption;
import androidx.credentials.PasswordCredential;
import androidx.credentials.R;
import androidx.credentials.provider.BeginGetPasswordOption;
import com.google.android.gms.common.internal.BaseGmsClient;
import java.time.Instant;
import java.util.Collections;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u001c\b\u0007\u0018\u0000 +2\u00020\u0001:\u0004()*+Bi\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0010¢\u0006\u0002\u0010\u0013BS\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0010¢\u0006\u0002\u0010\u0014B\u0001\b\u0000\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0015\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\u0012\u001a\u00020\u0010\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0010¢\u0006\u0002\u0010\u001aR\u0013\u0010\n\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\u001d\u001a\u00020\u00108G¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u001eR\u0011\u0010!\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001eR\u000e\u0010\u0018\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0011\u0010\u0015\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u001cR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u001c¨\u0006,"}, d2 = {"Landroidx/credentials/provider/PasswordCredentialEntry;", "Landroidx/credentials/provider/CredentialEntry;", "context", "Landroid/content/Context;", "username", "", "pendingIntent", "Landroid/app/PendingIntent;", "beginGetPasswordOption", "Landroidx/credentials/provider/BeginGetPasswordOption;", "displayName", "lastUsedTime", "Ljava/time/Instant;", "icon", "Landroid/graphics/drawable/Icon;", "isAutoSelectAllowed", "", "affiliatedDomain", "isDefaultIconPreferredAsSingleProvider", "(Landroid/content/Context;Ljava/lang/CharSequence;Landroid/app/PendingIntent;Landroidx/credentials/provider/BeginGetPasswordOption;Ljava/lang/CharSequence;Ljava/time/Instant;Landroid/graphics/drawable/Icon;ZLjava/lang/CharSequence;Z)V", "(Landroid/content/Context;Ljava/lang/CharSequence;Landroid/app/PendingIntent;Landroidx/credentials/provider/BeginGetPasswordOption;Ljava/lang/CharSequence;Ljava/time/Instant;Landroid/graphics/drawable/Icon;Z)V", "typeDisplayName", "entryGroupId", "autoSelectAllowedFromOption", "isCreatedFromSlice", "isDefaultIconFromSlice", "(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;Landroid/app/PendingIntent;Ljava/time/Instant;Landroid/graphics/drawable/Icon;ZLandroidx/credentials/provider/BeginGetPasswordOption;ZLjava/lang/CharSequence;Ljava/lang/CharSequence;ZZZ)V", "getDisplayName", "()Ljava/lang/CharSequence;", "hasDefaultIcon", "()Z", "getIcon", "()Landroid/graphics/drawable/Icon;", "isAutoSelectAllowedFromOption", "getLastUsedTime", "()Ljava/time/Instant;", "getPendingIntent", "()Landroid/app/PendingIntent;", "getTypeDisplayName", "getUsername", "Api28Impl", "Api34Impl", "Builder", "Companion", "credentials_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: PasswordCredentialEntry.kt */
public final class PasswordCredentialEntry extends CredentialEntry {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String FALSE_STRING = "false";
    private static final int REVISION_ID = 1;
    private static final String SLICE_HINT_AFFILIATED_DOMAIN = "androidx.credentials.provider.credentialEntry.SLICE_HINT_AFFILIATED_DOMAIN";
    private static final String SLICE_HINT_AUTO_ALLOWED = "androidx.credentials.provider.credentialEntry.SLICE_HINT_AUTO_ALLOWED";
    private static final String SLICE_HINT_AUTO_SELECT_FROM_OPTION = "androidx.credentials.provider.credentialEntry.SLICE_HINT_AUTO_SELECT_FROM_OPTION";
    private static final String SLICE_HINT_DEDUPLICATION_ID = "androidx.credentials.provider.credentialEntry.SLICE_HINT_DEDUPLICATION_ID";
    private static final String SLICE_HINT_DEFAULT_ICON_RES_ID = "androidx.credentials.provider.credentialEntry.SLICE_HINT_DEFAULT_ICON_RES_ID";
    private static final String SLICE_HINT_ICON = "androidx.credentials.provider.credentialEntry.SLICE_HINT_PROFILE_ICON";
    private static final String SLICE_HINT_IS_DEFAULT_ICON_PREFERRED = "androidx.credentials.provider.credentialEntry.SLICE_HINT_IS_DEFAULT_ICON_PREFERRED";
    private static final String SLICE_HINT_LAST_USED_TIME_MILLIS = "androidx.credentials.provider.credentialEntry.SLICE_HINT_LAST_USED_TIME_MILLIS";
    private static final String SLICE_HINT_OPTION_ID = "androidx.credentials.provider.credentialEntry.SLICE_HINT_OPTION_ID";
    private static final String SLICE_HINT_PENDING_INTENT = "androidx.credentials.provider.credentialEntry.SLICE_HINT_PENDING_INTENT";
    private static final String SLICE_HINT_SUBTITLE = "androidx.credentials.provider.credentialEntry.SLICE_HINT_CREDENTIAL_TYPE_DISPLAY_NAME";
    private static final String SLICE_HINT_TITLE = "androidx.credentials.provider.credentialEntry.SLICE_HINT_USER_NAME";
    private static final String SLICE_HINT_TYPE_DISPLAY_NAME = "androidx.credentials.provider.credentialEntry.SLICE_HINT_TYPE_DISPLAY_NAME";
    private static final String TAG = "PasswordCredentialEntry";
    private static final String TRUE_STRING = "true";
    private final CharSequence displayName;
    private final Icon icon;
    private final boolean isAutoSelectAllowed;
    private final boolean isAutoSelectAllowedFromOption;
    /* access modifiers changed from: private */
    public boolean isCreatedFromSlice;
    /* access modifiers changed from: private */
    public boolean isDefaultIconFromSlice;
    private final Instant lastUsedTime;
    private final PendingIntent pendingIntent;
    private final CharSequence typeDisplayName;
    private final CharSequence username;

    @JvmStatic
    public static final PasswordCredentialEntry fromCredentialEntry(CredentialEntry credentialEntry) {
        return Companion.fromCredentialEntry(credentialEntry);
    }

    @JvmStatic
    public static final PasswordCredentialEntry fromSlice(Slice slice) {
        return Companion.fromSlice(slice);
    }

    @JvmStatic
    public static final Slice toSlice(PasswordCredentialEntry passwordCredentialEntry) {
        return Companion.toSlice(passwordCredentialEntry);
    }

    public final CharSequence getUsername() {
        return this.username;
    }

    public final CharSequence getDisplayName() {
        return this.displayName;
    }

    public final CharSequence getTypeDisplayName() {
        return this.typeDisplayName;
    }

    public final PendingIntent getPendingIntent() {
        return this.pendingIntent;
    }

    public final Instant getLastUsedTime() {
        return this.lastUsedTime;
    }

    public final Icon getIcon() {
        return this.icon;
    }

    public final boolean isAutoSelectAllowed() {
        return this.isAutoSelectAllowed;
    }

    public /* synthetic */ PasswordCredentialEntry(CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, PendingIntent pendingIntent2, Instant instant, Icon icon2, boolean z, BeginGetPasswordOption beginGetPasswordOption, boolean z2, CharSequence charSequence4, CharSequence charSequence5, boolean z3, boolean z4, boolean z5, int i, DefaultConstructorMarker defaultConstructorMarker) {
        boolean z6;
        boolean z7;
        BeginGetPasswordOption beginGetPasswordOption2;
        boolean z8;
        Icon icon3;
        Instant instant2;
        PendingIntent pendingIntent3;
        CharSequence charSequence6;
        CharSequence charSequence7;
        CharSequence charSequence8;
        PasswordCredentialEntry passwordCredentialEntry;
        int i2 = i;
        CharSequence charSequence9 = (i2 & 512) != 0 ? charSequence : charSequence4;
        CharSequence charSequence10 = (i2 & 1024) != 0 ? null : charSequence5;
        boolean extractAutoSelectValue$credentials_release = (i2 & 2048) != 0 ? CredentialOption.Companion.extractAutoSelectValue$credentials_release(beginGetPasswordOption.getCandidateQueryData()) : z3;
        boolean z9 = (i2 & 4096) != 0 ? false : z4;
        if ((i2 & 8192) != 0) {
            z6 = false;
            charSequence8 = charSequence;
            charSequence7 = charSequence2;
            charSequence6 = charSequence3;
            pendingIntent3 = pendingIntent2;
            instant2 = instant;
            icon3 = icon2;
            z8 = z;
            beginGetPasswordOption2 = beginGetPasswordOption;
            z7 = z2;
            passwordCredentialEntry = this;
        } else {
            z6 = z5;
            passwordCredentialEntry = this;
            charSequence8 = charSequence;
            charSequence7 = charSequence2;
            charSequence6 = charSequence3;
            pendingIntent3 = pendingIntent2;
            instant2 = instant;
            icon3 = icon2;
            z8 = z;
            beginGetPasswordOption2 = beginGetPasswordOption;
            z7 = z2;
        }
        new PasswordCredentialEntry(charSequence8, charSequence7, charSequence6, pendingIntent3, instant2, icon3, z8, beginGetPasswordOption2, z7, charSequence9, charSequence10, extractAutoSelectValue$credentials_release, z9, z6);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PasswordCredentialEntry(CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, PendingIntent pendingIntent2, Instant instant, Icon icon2, boolean z, BeginGetPasswordOption beginGetPasswordOption, boolean z2, CharSequence charSequence4, CharSequence charSequence5, boolean z3, boolean z4, boolean z5) {
        super(PasswordCredential.TYPE_PASSWORD_CREDENTIAL, beginGetPasswordOption, charSequence4 == null ? charSequence : charSequence4, z2, charSequence5);
        Intrinsics.checkNotNullParameter(charSequence, "username");
        Intrinsics.checkNotNullParameter(charSequence3, "typeDisplayName");
        Intrinsics.checkNotNullParameter(pendingIntent2, BaseGmsClient.KEY_PENDING_INTENT);
        Intrinsics.checkNotNullParameter(icon2, "icon");
        Intrinsics.checkNotNullParameter(beginGetPasswordOption, "beginGetPasswordOption");
        this.username = charSequence;
        this.displayName = charSequence2;
        this.typeDisplayName = charSequence3;
        this.pendingIntent = pendingIntent2;
        this.lastUsedTime = instant;
        this.icon = icon2;
        this.isAutoSelectAllowed = z;
        this.isCreatedFromSlice = z4;
        this.isDefaultIconFromSlice = z5;
        this.isAutoSelectAllowedFromOption = z3;
        if (charSequence.length() <= 0) {
            throw new IllegalArgumentException("username must not be empty".toString());
        }
    }

    public final boolean isAutoSelectAllowedFromOption() {
        return this.isAutoSelectAllowedFromOption;
    }

    public final boolean hasDefaultIcon() {
        if (Build.VERSION.SDK_INT >= 28) {
            return Api28Impl.isDefaultIcon(this);
        }
        return false;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ PasswordCredentialEntry(android.content.Context r3, java.lang.CharSequence r4, android.app.PendingIntent r5, androidx.credentials.provider.BeginGetPasswordOption r6, java.lang.CharSequence r7, java.time.Instant r8, android.graphics.drawable.Icon r9, boolean r10, java.lang.CharSequence r11, boolean r12, int r13, kotlin.jvm.internal.DefaultConstructorMarker r14) {
        /*
            r2 = this;
            r14 = r13 & 16
            r0 = 0
            if (r14 == 0) goto L_0x0006
            r7 = r0
        L_0x0006:
            r14 = r13 & 32
            if (r14 == 0) goto L_0x000b
            r8 = r0
        L_0x000b:
            r14 = r13 & 64
            if (r14 == 0) goto L_0x001a
            int r9 = androidx.credentials.R.drawable.ic_password
            android.graphics.drawable.Icon r9 = android.graphics.drawable.Icon.createWithResource(r3, r9)
            java.lang.String r14 = "createWithResource(conte…, R.drawable.ic_password)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r9, r14)
        L_0x001a:
            r14 = r13 & 128(0x80, float:1.794E-43)
            r1 = 0
            if (r14 == 0) goto L_0x0020
            r10 = r1
        L_0x0020:
            r14 = r13 & 256(0x100, float:3.59E-43)
            if (r14 == 0) goto L_0x0025
            r11 = r0
        L_0x0025:
            r13 = r13 & 512(0x200, float:7.175E-43)
            if (r13 == 0) goto L_0x002b
            r13 = r1
            goto L_0x002c
        L_0x002b:
            r13 = r12
        L_0x002c:
            r12 = r11
            r11 = r10
            r10 = r9
            r9 = r8
            r8 = r7
            r7 = r6
            r6 = r5
            r5 = r4
            r4 = r3
            r3 = r2
            r3.<init>((android.content.Context) r4, (java.lang.CharSequence) r5, (android.app.PendingIntent) r6, (androidx.credentials.provider.BeginGetPasswordOption) r7, (java.lang.CharSequence) r8, (java.time.Instant) r9, (android.graphics.drawable.Icon) r10, (boolean) r11, (java.lang.CharSequence) r12, (boolean) r13)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.credentials.provider.PasswordCredentialEntry.<init>(android.content.Context, java.lang.CharSequence, android.app.PendingIntent, androidx.credentials.provider.BeginGetPasswordOption, java.lang.CharSequence, java.time.Instant, android.graphics.drawable.Icon, boolean, java.lang.CharSequence, boolean, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public PasswordCredentialEntry(android.content.Context r20, java.lang.CharSequence r21, android.app.PendingIntent r22, androidx.credentials.provider.BeginGetPasswordOption r23, java.lang.CharSequence r24, java.time.Instant r25, android.graphics.drawable.Icon r26, boolean r27, java.lang.CharSequence r28, boolean r29) {
        /*
            r19 = this;
            r0 = r20
            java.lang.String r1 = "context"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r1)
            java.lang.String r1 = "username"
            r3 = r21
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r1)
            java.lang.String r1 = "pendingIntent"
            r6 = r22
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r1)
            java.lang.String r1 = "beginGetPasswordOption"
            r10 = r23
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r1)
            java.lang.String r1 = "icon"
            r8 = r26
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r1)
            int r1 = androidx.credentials.R.string.android_credentials_TYPE_PASSWORD_CREDENTIAL
            java.lang.String r0 = r0.getString(r1)
            java.lang.String r1 = "context.getString(R.stri…TYPE_PASSWORD_CREDENTIAL)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            r5 = r0
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            r17 = 14848(0x3a00, float:2.0806E-41)
            r18 = 0
            r12 = 0
            r14 = 0
            r15 = 0
            r16 = 0
            r2 = r19
            r4 = r24
            r7 = r25
            r9 = r27
            r13 = r28
            r11 = r29
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.credentials.provider.PasswordCredentialEntry.<init>(android.content.Context, java.lang.CharSequence, android.app.PendingIntent, androidx.credentials.provider.BeginGetPasswordOption, java.lang.CharSequence, java.time.Instant, android.graphics.drawable.Icon, boolean, java.lang.CharSequence, boolean):void");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ PasswordCredentialEntry(android.content.Context r2, java.lang.CharSequence r3, android.app.PendingIntent r4, androidx.credentials.provider.BeginGetPasswordOption r5, java.lang.CharSequence r6, java.time.Instant r7, android.graphics.drawable.Icon r8, boolean r9, int r10, kotlin.jvm.internal.DefaultConstructorMarker r11) {
        /*
            r1 = this;
            r11 = r10 & 16
            r0 = 0
            if (r11 == 0) goto L_0x0006
            r6 = r0
        L_0x0006:
            r11 = r10 & 32
            if (r11 == 0) goto L_0x000b
            r7 = r0
        L_0x000b:
            r11 = r10 & 64
            if (r11 == 0) goto L_0x001a
            int r8 = androidx.credentials.R.drawable.ic_password
            android.graphics.drawable.Icon r8 = android.graphics.drawable.Icon.createWithResource(r2, r8)
            java.lang.String r11 = "createWithResource(conte…, R.drawable.ic_password)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, r11)
        L_0x001a:
            r10 = r10 & 128(0x80, float:1.794E-43)
            if (r10 == 0) goto L_0x001f
            r9 = 0
        L_0x001f:
            r10 = r9
            r9 = r8
            r8 = r7
            r7 = r6
            r6 = r5
            r5 = r4
            r4 = r3
            r3 = r2
            r2 = r1
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.credentials.provider.PasswordCredentialEntry.<init>(android.content.Context, java.lang.CharSequence, android.app.PendingIntent, androidx.credentials.provider.BeginGetPasswordOption, java.lang.CharSequence, java.time.Instant, android.graphics.drawable.Icon, boolean, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.HIDDEN, message = "Use the constructor that allows setting all parameters.", replaceWith = @kotlin.ReplaceWith(expression = "PasswordCredentialEntry(context, username, pendingIntent, beginGetPasswordOption, displayName, lastUsedTime, icon, isAutoSelectAllowed, affiliatedDomain, isDefaultIconPreferredAsSingleProvider)", imports = {}))
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ PasswordCredentialEntry(android.content.Context r20, java.lang.CharSequence r21, android.app.PendingIntent r22, androidx.credentials.provider.BeginGetPasswordOption r23, java.lang.CharSequence r24, java.time.Instant r25, android.graphics.drawable.Icon r26, boolean r27) {
        /*
            r19 = this;
            r0 = r20
            java.lang.String r1 = "context"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r1)
            java.lang.String r1 = "username"
            r3 = r21
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r1)
            java.lang.String r1 = "pendingIntent"
            r6 = r22
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r1)
            java.lang.String r1 = "beginGetPasswordOption"
            r10 = r23
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r1)
            java.lang.String r1 = "icon"
            r8 = r26
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r1)
            int r1 = androidx.credentials.R.string.android_credentials_TYPE_PASSWORD_CREDENTIAL
            java.lang.String r0 = r0.getString(r1)
            java.lang.String r1 = "context.getString(R.stri…TYPE_PASSWORD_CREDENTIAL)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            r5 = r0
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            r17 = 15872(0x3e00, float:2.2241E-41)
            r18 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 0
            r16 = 0
            r2 = r19
            r4 = r24
            r7 = r25
            r9 = r27
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.credentials.provider.PasswordCredentialEntry.<init>(android.content.Context, java.lang.CharSequence, android.app.PendingIntent, androidx.credentials.provider.BeginGetPasswordOption, java.lang.CharSequence, java.time.Instant, android.graphics.drawable.Icon, boolean):void");
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÃ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, d2 = {"Landroidx/credentials/provider/PasswordCredentialEntry$Api34Impl;", "", "()V", "fromCredentialEntry", "Landroidx/credentials/provider/PasswordCredentialEntry;", "credentialEntry", "Landroid/service/credentials/CredentialEntry;", "credentials_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: PasswordCredentialEntry.kt */
    private static final class Api34Impl {
        public static final Api34Impl INSTANCE = new Api34Impl();

        private Api34Impl() {
        }

        @JvmStatic
        public static final PasswordCredentialEntry fromCredentialEntry(CredentialEntry credentialEntry) {
            Intrinsics.checkNotNullParameter(credentialEntry, "credentialEntry");
            Slice slice = credentialEntry.getSlice();
            Intrinsics.checkNotNullExpressionValue(slice, "credentialEntry.slice");
            return PasswordCredentialEntry.Companion.fromSlice(slice);
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\bÃ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004H\u0007J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0004H\u0007¨\u0006\u000b"}, d2 = {"Landroidx/credentials/provider/PasswordCredentialEntry$Api28Impl;", "", "()V", "fromSlice", "Landroidx/credentials/provider/PasswordCredentialEntry;", "slice", "Landroid/app/slice/Slice;", "isDefaultIcon", "", "entry", "toSlice", "credentials_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: PasswordCredentialEntry.kt */
    private static final class Api28Impl {
        public static final Api28Impl INSTANCE = new Api28Impl();

        private Api28Impl() {
        }

        @JvmStatic
        public static final boolean isDefaultIcon(PasswordCredentialEntry passwordCredentialEntry) {
            Intrinsics.checkNotNullParameter(passwordCredentialEntry, "entry");
            if (passwordCredentialEntry.isCreatedFromSlice) {
                return passwordCredentialEntry.isDefaultIconFromSlice;
            }
            return passwordCredentialEntry.getIcon().getType() == 2 && passwordCredentialEntry.getIcon().getResId() == R.drawable.ic_password;
        }

        @JvmStatic
        public static final Slice toSlice(PasswordCredentialEntry passwordCredentialEntry) {
            PasswordCredentialEntry passwordCredentialEntry2 = passwordCredentialEntry;
            Intrinsics.checkNotNullParameter(passwordCredentialEntry2, "entry");
            String type = passwordCredentialEntry2.getType();
            CharSequence username = passwordCredentialEntry2.getUsername();
            CharSequence displayName = passwordCredentialEntry2.getDisplayName();
            PendingIntent pendingIntent = passwordCredentialEntry2.getPendingIntent();
            CharSequence typeDisplayName = passwordCredentialEntry2.getTypeDisplayName();
            Instant lastUsedTime = passwordCredentialEntry2.getLastUsedTime();
            Icon icon = passwordCredentialEntry2.getIcon();
            boolean isAutoSelectAllowed = passwordCredentialEntry2.isAutoSelectAllowed();
            BeginGetCredentialOption beginGetCredentialOption = passwordCredentialEntry2.getBeginGetCredentialOption();
            CharSequence affiliatedDomain = passwordCredentialEntry2.getAffiliatedDomain();
            CharSequence entryGroupId = passwordCredentialEntry2.getEntryGroupId();
            boolean isDefaultIconPreferredAsSingleProvider = passwordCredentialEntry2.isDefaultIconPreferredAsSingleProvider();
            String str = PasswordCredentialEntry.TRUE_STRING;
            String str2 = isAutoSelectAllowed ? str : PasswordCredentialEntry.FALSE_STRING;
            if (!isDefaultIconPreferredAsSingleProvider) {
                str = PasswordCredentialEntry.FALSE_STRING;
            }
            Slice.Builder addText = new Slice.Builder(Uri.EMPTY, new SliceSpec(type, 1)).addText(typeDisplayName, (String) null, CollectionsKt.listOf(PasswordCredentialEntry.SLICE_HINT_TYPE_DISPLAY_NAME)).addText(username, (String) null, CollectionsKt.listOf(PasswordCredentialEntry.SLICE_HINT_TITLE)).addText(displayName, (String) null, CollectionsKt.listOf(PasswordCredentialEntry.SLICE_HINT_SUBTITLE)).addText(str2, (String) null, CollectionsKt.listOf(PasswordCredentialEntry.SLICE_HINT_AUTO_ALLOWED)).addText(beginGetCredentialOption.getId(), (String) null, CollectionsKt.listOf(PasswordCredentialEntry.SLICE_HINT_OPTION_ID)).addIcon(icon, (String) null, CollectionsKt.listOf(PasswordCredentialEntry.SLICE_HINT_ICON)).addText(entryGroupId, (String) null, CollectionsKt.listOf(PasswordCredentialEntry.SLICE_HINT_DEDUPLICATION_ID)).addText(affiliatedDomain, (String) null, CollectionsKt.listOf(PasswordCredentialEntry.SLICE_HINT_AFFILIATED_DOMAIN)).addText(str, (String) null, CollectionsKt.listOf(PasswordCredentialEntry.SLICE_HINT_IS_DEFAULT_ICON_PREFERRED));
            try {
                if (passwordCredentialEntry.hasDefaultIcon()) {
                    addText.addInt(1, (String) null, CollectionsKt.listOf(PasswordCredentialEntry.SLICE_HINT_DEFAULT_ICON_RES_ID));
                }
            } catch (IllegalStateException unused) {
            }
            if (passwordCredentialEntry.isAutoSelectAllowedFromOption()) {
                addText.addInt(1, (String) null, CollectionsKt.listOf(PasswordCredentialEntry.SLICE_HINT_AUTO_SELECT_FROM_OPTION));
            }
            if (lastUsedTime != null) {
                addText.addLong(lastUsedTime.toEpochMilli(), (String) null, CollectionsKt.listOf(PasswordCredentialEntry.SLICE_HINT_LAST_USED_TIME_MILLIS));
            }
            addText.addAction(pendingIntent, new Slice.Builder(addText).addHints(Collections.singletonList(PasswordCredentialEntry.SLICE_HINT_PENDING_INTENT)).build(), (String) null);
            Slice build = addText.build();
            Intrinsics.checkNotNullExpressionValue(build, "sliceBuilder.build()");
            return build;
        }

        @JvmStatic
        public static final PasswordCredentialEntry fromSlice(Slice slice) {
            Slice slice2 = slice;
            Intrinsics.checkNotNullParameter(slice2, "slice");
            List<SliceItem> items = slice2.getItems();
            Intrinsics.checkNotNullExpressionValue(items, "slice.items");
            boolean z = false;
            boolean z2 = false;
            boolean z3 = false;
            boolean z4 = false;
            CharSequence charSequence = null;
            CharSequence charSequence2 = null;
            CharSequence charSequence3 = null;
            CharSequence charSequence4 = null;
            PendingIntent pendingIntent = null;
            Instant instant = null;
            Icon icon = null;
            CharSequence charSequence5 = null;
            CharSequence charSequence6 = null;
            for (SliceItem sliceItem : items) {
                if (sliceItem.hasHint(PasswordCredentialEntry.SLICE_HINT_TYPE_DISPLAY_NAME)) {
                    charSequence4 = sliceItem.getText();
                } else if (sliceItem.hasHint(PasswordCredentialEntry.SLICE_HINT_TITLE)) {
                    charSequence2 = sliceItem.getText();
                } else if (sliceItem.hasHint(PasswordCredentialEntry.SLICE_HINT_SUBTITLE)) {
                    charSequence3 = sliceItem.getText();
                } else if (sliceItem.hasHint(PasswordCredentialEntry.SLICE_HINT_ICON)) {
                    icon = sliceItem.getIcon();
                } else if (sliceItem.hasHint(PasswordCredentialEntry.SLICE_HINT_PENDING_INTENT)) {
                    pendingIntent = sliceItem.getAction();
                } else if (sliceItem.hasHint(PasswordCredentialEntry.SLICE_HINT_OPTION_ID)) {
                    charSequence = sliceItem.getText();
                } else if (sliceItem.hasHint(PasswordCredentialEntry.SLICE_HINT_LAST_USED_TIME_MILLIS)) {
                    instant = Instant.ofEpochMilli(sliceItem.getLong());
                } else if (sliceItem.hasHint(PasswordCredentialEntry.SLICE_HINT_AUTO_ALLOWED)) {
                    if (Intrinsics.areEqual((Object) sliceItem.getText(), (Object) PasswordCredentialEntry.TRUE_STRING)) {
                        z = true;
                    }
                } else if (sliceItem.hasHint(PasswordCredentialEntry.SLICE_HINT_AUTO_SELECT_FROM_OPTION)) {
                    z3 = true;
                } else if (sliceItem.hasHint(PasswordCredentialEntry.SLICE_HINT_AFFILIATED_DOMAIN)) {
                    charSequence6 = sliceItem.getText();
                } else if (sliceItem.hasHint(PasswordCredentialEntry.SLICE_HINT_DEDUPLICATION_ID)) {
                    charSequence5 = sliceItem.getText();
                } else if (sliceItem.hasHint(PasswordCredentialEntry.SLICE_HINT_IS_DEFAULT_ICON_PREFERRED)) {
                    if (Intrinsics.areEqual((Object) sliceItem.getText(), (Object) PasswordCredentialEntry.TRUE_STRING)) {
                        z2 = true;
                    }
                } else if (sliceItem.hasHint(PasswordCredentialEntry.SLICE_HINT_DEFAULT_ICON_RES_ID)) {
                    z4 = true;
                }
            }
            try {
                Intrinsics.checkNotNull(charSequence2);
                Intrinsics.checkNotNull(charSequence4);
                Intrinsics.checkNotNull(pendingIntent);
                Intrinsics.checkNotNull(icon);
                BeginGetPasswordOption.Companion companion = BeginGetPasswordOption.Companion;
                Bundle bundle = new Bundle();
                Intrinsics.checkNotNull(charSequence);
                return new PasswordCredentialEntry(charSequence2, charSequence3, charSequence4, pendingIntent, instant, icon, z, companion.createFrom$credentials_release(bundle, charSequence.toString()), z2, charSequence5, charSequence6, z3, true, z4);
            } catch (Exception e) {
                Log.i(PasswordCredentialEntry.TAG, "fromSlice failed with: " + e.getMessage());
                return null;
            }
        }
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0007J\u0012\u0010\u001a\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u001b\u001a\u00020\u001cH\u0007J\u0012\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001e\u001a\u00020\u0017H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Landroidx/credentials/provider/PasswordCredentialEntry$Companion;", "", "()V", "FALSE_STRING", "", "REVISION_ID", "", "SLICE_HINT_AFFILIATED_DOMAIN", "SLICE_HINT_AUTO_ALLOWED", "SLICE_HINT_AUTO_SELECT_FROM_OPTION", "SLICE_HINT_DEDUPLICATION_ID", "SLICE_HINT_DEFAULT_ICON_RES_ID", "SLICE_HINT_ICON", "SLICE_HINT_IS_DEFAULT_ICON_PREFERRED", "SLICE_HINT_LAST_USED_TIME_MILLIS", "SLICE_HINT_OPTION_ID", "SLICE_HINT_PENDING_INTENT", "SLICE_HINT_SUBTITLE", "SLICE_HINT_TITLE", "SLICE_HINT_TYPE_DISPLAY_NAME", "TAG", "TRUE_STRING", "fromCredentialEntry", "Landroidx/credentials/provider/PasswordCredentialEntry;", "credentialEntry", "Landroid/service/credentials/CredentialEntry;", "fromSlice", "slice", "Landroid/app/slice/Slice;", "toSlice", "entry", "credentials_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: PasswordCredentialEntry.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final Slice toSlice(PasswordCredentialEntry passwordCredentialEntry) {
            Intrinsics.checkNotNullParameter(passwordCredentialEntry, "entry");
            if (Build.VERSION.SDK_INT >= 28) {
                return Api28Impl.toSlice(passwordCredentialEntry);
            }
            return null;
        }

        @JvmStatic
        public final PasswordCredentialEntry fromSlice(Slice slice) {
            Intrinsics.checkNotNullParameter(slice, "slice");
            if (Build.VERSION.SDK_INT >= 28) {
                return Api28Impl.fromSlice(slice);
            }
            return null;
        }

        @JvmStatic
        public final PasswordCredentialEntry fromCredentialEntry(CredentialEntry credentialEntry) {
            Intrinsics.checkNotNullParameter(credentialEntry, "credentialEntry");
            if (Build.VERSION.SDK_INT >= 34) {
                return Api34Impl.fromCredentialEntry(credentialEntry);
            }
            return null;
        }
    }

    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0006\u0010\u0014\u001a\u00020\u0015J\u0010\u0010\u0016\u001a\u00020\u00002\b\u0010\u000b\u001a\u0004\u0018\u00010\u0005J\u000e\u0010\u0017\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\rJ\u000e\u0010\u0018\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\rJ\u0010\u0010\u0019\u001a\u00020\u00002\b\u0010\u000e\u001a\u0004\u0018\u00010\u0005J\u000e\u0010\u001a\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u0010J\u0010\u0010\u001b\u001a\u00020\u00002\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Landroidx/credentials/provider/PasswordCredentialEntry$Builder;", "", "context", "Landroid/content/Context;", "username", "", "pendingIntent", "Landroid/app/PendingIntent;", "beginGetPasswordOption", "Landroidx/credentials/provider/BeginGetPasswordOption;", "(Landroid/content/Context;Ljava/lang/CharSequence;Landroid/app/PendingIntent;Landroidx/credentials/provider/BeginGetPasswordOption;)V", "affiliatedDomain", "autoSelectAllowed", "", "displayName", "icon", "Landroid/graphics/drawable/Icon;", "isDefaultIconPreferredAsSingleProvider", "lastUsedTime", "Ljava/time/Instant;", "build", "Landroidx/credentials/provider/PasswordCredentialEntry;", "setAffiliatedDomain", "setAutoSelectAllowed", "setDefaultIconPreferredAsSingleProvider", "setDisplayName", "setIcon", "setLastUsedTime", "credentials_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: PasswordCredentialEntry.kt */
    public static final class Builder {
        private CharSequence affiliatedDomain;
        private boolean autoSelectAllowed;
        private final BeginGetPasswordOption beginGetPasswordOption;
        private final Context context;
        private CharSequence displayName;
        private Icon icon;
        private boolean isDefaultIconPreferredAsSingleProvider;
        private Instant lastUsedTime;
        private final PendingIntent pendingIntent;
        private final CharSequence username;

        public Builder(Context context2, CharSequence charSequence, PendingIntent pendingIntent2, BeginGetPasswordOption beginGetPasswordOption2) {
            Intrinsics.checkNotNullParameter(context2, "context");
            Intrinsics.checkNotNullParameter(charSequence, "username");
            Intrinsics.checkNotNullParameter(pendingIntent2, BaseGmsClient.KEY_PENDING_INTENT);
            Intrinsics.checkNotNullParameter(beginGetPasswordOption2, "beginGetPasswordOption");
            this.context = context2;
            this.username = charSequence;
            this.pendingIntent = pendingIntent2;
            this.beginGetPasswordOption = beginGetPasswordOption2;
        }

        public final Builder setDisplayName(CharSequence charSequence) {
            this.displayName = charSequence;
            return this;
        }

        public final Builder setIcon(Icon icon2) {
            Intrinsics.checkNotNullParameter(icon2, "icon");
            this.icon = icon2;
            return this;
        }

        public final Builder setAutoSelectAllowed(boolean z) {
            this.autoSelectAllowed = z;
            return this;
        }

        public final Builder setAffiliatedDomain(CharSequence charSequence) {
            this.affiliatedDomain = charSequence;
            return this;
        }

        public final Builder setLastUsedTime(Instant instant) {
            this.lastUsedTime = instant;
            return this;
        }

        public final Builder setDefaultIconPreferredAsSingleProvider(boolean z) {
            this.isDefaultIconPreferredAsSingleProvider = z;
            return this;
        }

        public final PasswordCredentialEntry build() {
            if (this.icon == null) {
                this.icon = Icon.createWithResource(this.context, R.drawable.ic_password);
            }
            String string = this.context.getString(R.string.android_credentials_TYPE_PASSWORD_CREDENTIAL);
            Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.stri…TYPE_PASSWORD_CREDENTIAL)");
            PendingIntent pendingIntent2 = this.pendingIntent;
            Instant instant = this.lastUsedTime;
            Icon icon2 = this.icon;
            Intrinsics.checkNotNull(icon2);
            return new PasswordCredentialEntry(this.username, this.displayName, string, pendingIntent2, instant, icon2, this.autoSelectAllowed, this.beginGetPasswordOption, this.isDefaultIconPreferredAsSingleProvider, (CharSequence) null, this.affiliatedDomain, false, false, false, 14848, (DefaultConstructorMarker) null);
        }
    }
}
