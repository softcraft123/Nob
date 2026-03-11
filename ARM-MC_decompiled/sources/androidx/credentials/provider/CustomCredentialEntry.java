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
import androidx.credentials.R;
import com.google.android.gms.common.internal.BaseGmsClient;
import java.time.Instant;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0019\b\u0007\u0018\u0000 /2\u00020\u0001:\u0004,-./B_\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0011¢\u0006\u0002\u0010\u0012Bs\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0011¢\u0006\u0002\u0010\u0015B\u0001\b\u0000\u0012\u0006\u0010\u0016\u001a\u00020\u0017\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\u0014\u001a\u00020\u0011\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0011¢\u0006\u0002\u0010\u001cR\u0011\u0010\u001d\u001a\u00020\u00118G¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u001eR\u0011\u0010!\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001eR\u000e\u0010\u001a\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b(\u0010'R\u0014\u0010\u0016\u001a\u00020\u0017X\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b+\u0010'¨\u00060"}, d2 = {"Landroidx/credentials/provider/CustomCredentialEntry;", "Landroidx/credentials/provider/CredentialEntry;", "context", "Landroid/content/Context;", "title", "", "pendingIntent", "Landroid/app/PendingIntent;", "beginGetCredentialOption", "Landroidx/credentials/provider/BeginGetCredentialOption;", "subtitle", "typeDisplayName", "lastUsedTime", "Ljava/time/Instant;", "icon", "Landroid/graphics/drawable/Icon;", "isAutoSelectAllowed", "", "(Landroid/content/Context;Ljava/lang/CharSequence;Landroid/app/PendingIntent;Landroidx/credentials/provider/BeginGetCredentialOption;Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/time/Instant;Landroid/graphics/drawable/Icon;Z)V", "entryGroupId", "isDefaultIconPreferredAsSingleProvider", "(Landroid/content/Context;Ljava/lang/CharSequence;Landroid/app/PendingIntent;Landroidx/credentials/provider/BeginGetCredentialOption;Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/time/Instant;Landroid/graphics/drawable/Icon;ZLjava/lang/CharSequence;Z)V", "type", "", "affiliatedDomain", "autoSelectAllowedFromOption", "isCreatedFromSlice", "isDefaultIconFromSlice", "(Ljava/lang/String;Ljava/lang/CharSequence;Landroid/app/PendingIntent;ZLjava/lang/CharSequence;Ljava/lang/CharSequence;Landroid/graphics/drawable/Icon;Ljava/time/Instant;Landroidx/credentials/provider/BeginGetCredentialOption;ZLjava/lang/CharSequence;Ljava/lang/CharSequence;ZZZ)V", "hasDefaultIcon", "()Z", "getIcon", "()Landroid/graphics/drawable/Icon;", "isAutoSelectAllowedFromOption", "getLastUsedTime", "()Ljava/time/Instant;", "getPendingIntent", "()Landroid/app/PendingIntent;", "getSubtitle", "()Ljava/lang/CharSequence;", "getTitle", "getType", "()Ljava/lang/String;", "getTypeDisplayName", "Api28Impl", "Api34Impl", "Builder", "Companion", "credentials_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: CustomCredentialEntry.kt */
public final class CustomCredentialEntry extends CredentialEntry {
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
    private static final String TAG = "CredentialEntry";
    private static final String TRUE_STRING = "true";
    private final Icon icon;
    private final boolean isAutoSelectAllowed;
    private final boolean isAutoSelectAllowedFromOption;
    /* access modifiers changed from: private */
    public boolean isCreatedFromSlice;
    /* access modifiers changed from: private */
    public boolean isDefaultIconFromSlice;
    private final Instant lastUsedTime;
    private final PendingIntent pendingIntent;
    private final CharSequence subtitle;
    private final CharSequence title;
    private final String type;
    private final CharSequence typeDisplayName;

    @JvmStatic
    public static final CustomCredentialEntry fromCredentialEntry(CredentialEntry credentialEntry) {
        return Companion.fromCredentialEntry(credentialEntry);
    }

    @JvmStatic
    public static final CustomCredentialEntry fromSlice(Slice slice) {
        return Companion.fromSlice(slice);
    }

    @JvmStatic
    public static final Slice toSlice(CustomCredentialEntry customCredentialEntry) {
        return Companion.toSlice(customCredentialEntry);
    }

    public String getType() {
        return this.type;
    }

    public final CharSequence getTitle() {
        return this.title;
    }

    public final PendingIntent getPendingIntent() {
        return this.pendingIntent;
    }

    public final boolean isAutoSelectAllowed() {
        return this.isAutoSelectAllowed;
    }

    public final CharSequence getSubtitle() {
        return this.subtitle;
    }

    public final CharSequence getTypeDisplayName() {
        return this.typeDisplayName;
    }

    public final Icon getIcon() {
        return this.icon;
    }

    public final Instant getLastUsedTime() {
        return this.lastUsedTime;
    }

    public /* synthetic */ CustomCredentialEntry(String str, CharSequence charSequence, PendingIntent pendingIntent2, boolean z, CharSequence charSequence2, CharSequence charSequence3, Icon icon2, Instant instant, BeginGetCredentialOption beginGetCredentialOption, boolean z2, CharSequence charSequence4, CharSequence charSequence5, boolean z3, boolean z4, boolean z5, int i, DefaultConstructorMarker defaultConstructorMarker) {
        boolean z6;
        boolean z7;
        BeginGetCredentialOption beginGetCredentialOption2;
        Instant instant2;
        Icon icon3;
        CharSequence charSequence6;
        CharSequence charSequence7;
        boolean z8;
        PendingIntent pendingIntent3;
        CharSequence charSequence8;
        String str2;
        CustomCredentialEntry customCredentialEntry;
        int i2 = i;
        CharSequence charSequence9 = (i2 & 1024) != 0 ? charSequence : charSequence4;
        CharSequence charSequence10 = (i2 & 2048) != 0 ? null : charSequence5;
        boolean extractAutoSelectValue$credentials_release = (i2 & 4096) != 0 ? CredentialOption.Companion.extractAutoSelectValue$credentials_release(beginGetCredentialOption.getCandidateQueryData()) : z3;
        boolean z9 = (i2 & 8192) != 0 ? false : z4;
        if ((i2 & 16384) != 0) {
            z6 = false;
            str2 = str;
            charSequence8 = charSequence;
            pendingIntent3 = pendingIntent2;
            z8 = z;
            charSequence7 = charSequence2;
            charSequence6 = charSequence3;
            icon3 = icon2;
            instant2 = instant;
            beginGetCredentialOption2 = beginGetCredentialOption;
            z7 = z2;
            customCredentialEntry = this;
        } else {
            z6 = z5;
            customCredentialEntry = this;
            str2 = str;
            charSequence8 = charSequence;
            pendingIntent3 = pendingIntent2;
            z8 = z;
            charSequence7 = charSequence2;
            charSequence6 = charSequence3;
            icon3 = icon2;
            instant2 = instant;
            beginGetCredentialOption2 = beginGetCredentialOption;
            z7 = z2;
        }
        new CustomCredentialEntry(str2, charSequence8, pendingIntent3, z8, charSequence7, charSequence6, icon3, instant2, beginGetCredentialOption2, z7, charSequence9, charSequence10, extractAutoSelectValue$credentials_release, z9, z6);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public CustomCredentialEntry(java.lang.String r8, java.lang.CharSequence r9, android.app.PendingIntent r10, boolean r11, java.lang.CharSequence r12, java.lang.CharSequence r13, android.graphics.drawable.Icon r14, java.time.Instant r15, androidx.credentials.provider.BeginGetCredentialOption r16, boolean r17, java.lang.CharSequence r18, java.lang.CharSequence r19, boolean r20, boolean r21, boolean r22) {
        /*
            r7 = this;
            java.lang.String r0 = "type"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            java.lang.String r0 = "title"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            java.lang.String r0 = "pendingIntent"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            java.lang.String r0 = "icon"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r0)
            java.lang.String r0 = "beginGetCredentialOption"
            r3 = r16
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            if (r18 != 0) goto L_0x001f
            r4 = r9
            goto L_0x0021
        L_0x001f:
            r4 = r18
        L_0x0021:
            r1 = r7
            r2 = r8
            r5 = r17
            r6 = r19
            r1.<init>(r2, r3, r4, r5, r6)
            r7.type = r8
            r7.title = r9
            r7.pendingIntent = r10
            r7.isAutoSelectAllowed = r11
            r7.subtitle = r12
            r7.typeDisplayName = r13
            r7.icon = r14
            r7.lastUsedTime = r15
            r8 = r21
            r7.isCreatedFromSlice = r8
            r8 = r22
            r7.isDefaultIconFromSlice = r8
            r8 = r20
            r7.isAutoSelectAllowedFromOption = r8
            java.lang.String r8 = r7.getType()
            java.lang.CharSequence r8 = (java.lang.CharSequence) r8
            int r8 = r8.length()
            if (r8 <= 0) goto L_0x0065
            int r8 = r9.length()
            if (r8 <= 0) goto L_0x0059
            return
        L_0x0059:
            java.lang.IllegalArgumentException r8 = new java.lang.IllegalArgumentException
            java.lang.String r9 = "title must not be empty"
            java.lang.String r9 = r9.toString()
            r8.<init>(r9)
            throw r8
        L_0x0065:
            java.lang.IllegalArgumentException r8 = new java.lang.IllegalArgumentException
            java.lang.String r9 = "type must not be empty"
            java.lang.String r9 = r9.toString()
            r8.<init>(r9)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.credentials.provider.CustomCredentialEntry.<init>(java.lang.String, java.lang.CharSequence, android.app.PendingIntent, boolean, java.lang.CharSequence, java.lang.CharSequence, android.graphics.drawable.Icon, java.time.Instant, androidx.credentials.provider.BeginGetCredentialOption, boolean, java.lang.CharSequence, java.lang.CharSequence, boolean, boolean, boolean):void");
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
    public /* synthetic */ CustomCredentialEntry(android.content.Context r2, java.lang.CharSequence r3, android.app.PendingIntent r4, androidx.credentials.provider.BeginGetCredentialOption r5, java.lang.CharSequence r6, java.lang.CharSequence r7, java.time.Instant r8, android.graphics.drawable.Icon r9, boolean r10, int r11, kotlin.jvm.internal.DefaultConstructorMarker r12) {
        /*
            r1 = this;
            r12 = r11 & 16
            r0 = 0
            if (r12 == 0) goto L_0x0006
            r6 = r0
        L_0x0006:
            r12 = r11 & 32
            if (r12 == 0) goto L_0x000b
            r7 = r0
        L_0x000b:
            r12 = r11 & 64
            if (r12 == 0) goto L_0x0010
            r8 = r0
        L_0x0010:
            r12 = r11 & 128(0x80, float:1.794E-43)
            if (r12 == 0) goto L_0x001f
            int r9 = androidx.credentials.R.drawable.ic_other_sign_in
            android.graphics.drawable.Icon r9 = android.graphics.drawable.Icon.createWithResource(r2, r9)
            java.lang.String r12 = "createWithResource(conte…rawable.ic_other_sign_in)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r9, r12)
        L_0x001f:
            r11 = r11 & 256(0x100, float:3.59E-43)
            if (r11 == 0) goto L_0x0024
            r10 = 0
        L_0x0024:
            r11 = r10
            r10 = r9
            r9 = r8
            r8 = r7
            r7 = r6
            r6 = r5
            r5 = r4
            r4 = r3
            r3 = r2
            r2 = r1
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.credentials.provider.CustomCredentialEntry.<init>(android.content.Context, java.lang.CharSequence, android.app.PendingIntent, androidx.credentials.provider.BeginGetCredentialOption, java.lang.CharSequence, java.lang.CharSequence, java.time.Instant, android.graphics.drawable.Icon, boolean, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.HIDDEN, message = "Use the constructor that allows setting all parameters.", replaceWith = @kotlin.ReplaceWith(expression = "CustomCredentialEntry(context, title, pendingIntent,beginGetCredentialOption, subtitle, typeDisplayName, lastUsedTime, icon, isAutoSelectAllowed, entryGroupId, isDefaultIconPreferredAsSingleProvider)", imports = {}))
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ CustomCredentialEntry(android.content.Context r20, java.lang.CharSequence r21, android.app.PendingIntent r22, androidx.credentials.provider.BeginGetCredentialOption r23, java.lang.CharSequence r24, java.lang.CharSequence r25, java.time.Instant r26, android.graphics.drawable.Icon r27, boolean r28) {
        /*
            r19 = this;
            java.lang.String r0 = "context"
            r1 = r20
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r0)
            java.lang.String r0 = "title"
            r3 = r21
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            java.lang.String r0 = "pendingIntent"
            r4 = r22
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            java.lang.String r0 = "beginGetCredentialOption"
            r10 = r23
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            java.lang.String r0 = "icon"
            r8 = r27
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            java.lang.String r2 = r10.getType()
            r17 = 31744(0x7c00, float:4.4483E-41)
            r18 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 0
            r16 = 0
            r1 = r19
            r6 = r24
            r7 = r25
            r9 = r26
            r5 = r28
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.credentials.provider.CustomCredentialEntry.<init>(android.content.Context, java.lang.CharSequence, android.app.PendingIntent, androidx.credentials.provider.BeginGetCredentialOption, java.lang.CharSequence, java.lang.CharSequence, java.time.Instant, android.graphics.drawable.Icon, boolean):void");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ CustomCredentialEntry(android.content.Context r2, java.lang.CharSequence r3, android.app.PendingIntent r4, androidx.credentials.provider.BeginGetCredentialOption r5, java.lang.CharSequence r6, java.lang.CharSequence r7, java.time.Instant r8, android.graphics.drawable.Icon r9, boolean r10, java.lang.CharSequence r11, boolean r12, int r13, kotlin.jvm.internal.DefaultConstructorMarker r14) {
        /*
            r1 = this;
            r14 = r13 & 16
            r0 = 0
            if (r14 == 0) goto L_0x0006
            r6 = r0
        L_0x0006:
            r14 = r13 & 32
            if (r14 == 0) goto L_0x000b
            r7 = r0
        L_0x000b:
            r14 = r13 & 64
            if (r14 == 0) goto L_0x0010
            r8 = r0
        L_0x0010:
            r14 = r13 & 128(0x80, float:1.794E-43)
            if (r14 == 0) goto L_0x001f
            int r9 = androidx.credentials.R.drawable.ic_other_sign_in
            android.graphics.drawable.Icon r9 = android.graphics.drawable.Icon.createWithResource(r2, r9)
            java.lang.String r14 = "createWithResource(conte…rawable.ic_other_sign_in)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r9, r14)
        L_0x001f:
            r14 = r13 & 256(0x100, float:3.59E-43)
            r0 = 0
            if (r14 == 0) goto L_0x0025
            r10 = r0
        L_0x0025:
            r14 = r13 & 512(0x200, float:7.175E-43)
            if (r14 == 0) goto L_0x002a
            r11 = r3
        L_0x002a:
            r13 = r13 & 1024(0x400, float:1.435E-42)
            if (r13 == 0) goto L_0x0030
            r13 = r0
            goto L_0x0031
        L_0x0030:
            r13 = r12
        L_0x0031:
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
            r2 = r1
            r2.<init>((android.content.Context) r3, (java.lang.CharSequence) r4, (android.app.PendingIntent) r5, (androidx.credentials.provider.BeginGetCredentialOption) r6, (java.lang.CharSequence) r7, (java.lang.CharSequence) r8, (java.time.Instant) r9, (android.graphics.drawable.Icon) r10, (boolean) r11, (java.lang.CharSequence) r12, (boolean) r13)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.credentials.provider.CustomCredentialEntry.<init>(android.content.Context, java.lang.CharSequence, android.app.PendingIntent, androidx.credentials.provider.BeginGetCredentialOption, java.lang.CharSequence, java.lang.CharSequence, java.time.Instant, android.graphics.drawable.Icon, boolean, java.lang.CharSequence, boolean, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public CustomCredentialEntry(android.content.Context r20, java.lang.CharSequence r21, android.app.PendingIntent r22, androidx.credentials.provider.BeginGetCredentialOption r23, java.lang.CharSequence r24, java.lang.CharSequence r25, java.time.Instant r26, android.graphics.drawable.Icon r27, boolean r28, java.lang.CharSequence r29, boolean r30) {
        /*
            r19 = this;
            java.lang.String r0 = "context"
            r1 = r20
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r0)
            java.lang.String r0 = "title"
            r3 = r21
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            java.lang.String r0 = "pendingIntent"
            r4 = r22
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            java.lang.String r0 = "beginGetCredentialOption"
            r10 = r23
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            java.lang.String r0 = "icon"
            r8 = r27
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            java.lang.String r0 = "entryGroupId"
            r1 = r29
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r0)
            java.lang.String r2 = r10.getType()
            int r0 = r1.length()
            if (r0 != 0) goto L_0x0036
            r12 = r3
            goto L_0x0037
        L_0x0036:
            r12 = r1
        L_0x0037:
            r17 = 30720(0x7800, float:4.3048E-41)
            r18 = 0
            r13 = 0
            r14 = 0
            r15 = 0
            r16 = 0
            r1 = r19
            r6 = r24
            r7 = r25
            r9 = r26
            r5 = r28
            r11 = r30
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.credentials.provider.CustomCredentialEntry.<init>(android.content.Context, java.lang.CharSequence, android.app.PendingIntent, androidx.credentials.provider.BeginGetCredentialOption, java.lang.CharSequence, java.lang.CharSequence, java.time.Instant, android.graphics.drawable.Icon, boolean, java.lang.CharSequence, boolean):void");
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÃ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, d2 = {"Landroidx/credentials/provider/CustomCredentialEntry$Api34Impl;", "", "()V", "fromCredentialEntry", "Landroidx/credentials/provider/CustomCredentialEntry;", "credentialEntry", "Landroid/service/credentials/CredentialEntry;", "credentials_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: CustomCredentialEntry.kt */
    private static final class Api34Impl {
        public static final Api34Impl INSTANCE = new Api34Impl();

        private Api34Impl() {
        }

        @JvmStatic
        public static final CustomCredentialEntry fromCredentialEntry(CredentialEntry credentialEntry) {
            Intrinsics.checkNotNullParameter(credentialEntry, "credentialEntry");
            Slice slice = credentialEntry.getSlice();
            Intrinsics.checkNotNullExpressionValue(slice, "credentialEntry.slice");
            return CustomCredentialEntry.Companion.fromSlice(slice);
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\bÃ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004H\u0007J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0004H\u0007¨\u0006\u000b"}, d2 = {"Landroidx/credentials/provider/CustomCredentialEntry$Api28Impl;", "", "()V", "fromSlice", "Landroidx/credentials/provider/CustomCredentialEntry;", "slice", "Landroid/app/slice/Slice;", "isDefaultIcon", "", "entry", "toSlice", "credentials_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: CustomCredentialEntry.kt */
    private static final class Api28Impl {
        public static final Api28Impl INSTANCE = new Api28Impl();

        private Api28Impl() {
        }

        @JvmStatic
        public static final boolean isDefaultIcon(CustomCredentialEntry customCredentialEntry) {
            Intrinsics.checkNotNullParameter(customCredentialEntry, "entry");
            if (customCredentialEntry.isCreatedFromSlice) {
                return customCredentialEntry.isDefaultIconFromSlice;
            }
            return customCredentialEntry.getIcon().getType() == 2 && customCredentialEntry.getIcon().getResId() == R.drawable.ic_other_sign_in;
        }

        @JvmStatic
        public static final Slice toSlice(CustomCredentialEntry customCredentialEntry) {
            CustomCredentialEntry customCredentialEntry2 = customCredentialEntry;
            Intrinsics.checkNotNullParameter(customCredentialEntry2, "entry");
            String type = customCredentialEntry2.getType();
            CharSequence title = customCredentialEntry2.getTitle();
            CharSequence subtitle = customCredentialEntry2.getSubtitle();
            PendingIntent pendingIntent = customCredentialEntry2.getPendingIntent();
            CharSequence typeDisplayName = customCredentialEntry2.getTypeDisplayName();
            Instant lastUsedTime = customCredentialEntry2.getLastUsedTime();
            Icon icon = customCredentialEntry2.getIcon();
            boolean isAutoSelectAllowed = customCredentialEntry2.isAutoSelectAllowed();
            BeginGetCredentialOption beginGetCredentialOption = customCredentialEntry2.getBeginGetCredentialOption();
            CharSequence entryGroupId = customCredentialEntry2.getEntryGroupId();
            CharSequence affiliatedDomain = customCredentialEntry2.getAffiliatedDomain();
            boolean isDefaultIconPreferredAsSingleProvider = customCredentialEntry2.isDefaultIconPreferredAsSingleProvider();
            String str = CustomCredentialEntry.TRUE_STRING;
            String str2 = isAutoSelectAllowed ? str : CustomCredentialEntry.FALSE_STRING;
            if (!isDefaultIconPreferredAsSingleProvider) {
                str = CustomCredentialEntry.FALSE_STRING;
            }
            Slice.Builder addText = new Slice.Builder(Uri.EMPTY, new SliceSpec(type, 1)).addText(typeDisplayName, (String) null, CollectionsKt.listOf(CustomCredentialEntry.SLICE_HINT_TYPE_DISPLAY_NAME)).addText(title, (String) null, CollectionsKt.listOf(CustomCredentialEntry.SLICE_HINT_TITLE)).addText(subtitle, (String) null, CollectionsKt.listOf(CustomCredentialEntry.SLICE_HINT_SUBTITLE)).addText(str2, (String) null, CollectionsKt.listOf(CustomCredentialEntry.SLICE_HINT_AUTO_ALLOWED)).addText(beginGetCredentialOption.getId(), (String) null, CollectionsKt.listOf(CustomCredentialEntry.SLICE_HINT_OPTION_ID)).addText(entryGroupId, (String) null, CollectionsKt.listOf(CustomCredentialEntry.SLICE_HINT_DEDUPLICATION_ID)).addText(affiliatedDomain, (String) null, CollectionsKt.listOf(CustomCredentialEntry.SLICE_HINT_AFFILIATED_DOMAIN)).addIcon(icon, (String) null, CollectionsKt.listOf(CustomCredentialEntry.SLICE_HINT_ICON)).addText(str, (String) null, CollectionsKt.listOf(CustomCredentialEntry.SLICE_HINT_IS_DEFAULT_ICON_PREFERRED));
            try {
                if (customCredentialEntry.hasDefaultIcon()) {
                    addText.addInt(1, (String) null, CollectionsKt.listOf(CustomCredentialEntry.SLICE_HINT_DEFAULT_ICON_RES_ID));
                }
            } catch (IllegalStateException unused) {
            }
            if (customCredentialEntry.isAutoSelectAllowedFromOption()) {
                addText.addInt(1, (String) null, CollectionsKt.listOf(CustomCredentialEntry.SLICE_HINT_AUTO_SELECT_FROM_OPTION));
            }
            if (lastUsedTime != null) {
                addText.addLong(lastUsedTime.toEpochMilli(), (String) null, CollectionsKt.listOf(CustomCredentialEntry.SLICE_HINT_LAST_USED_TIME_MILLIS));
            }
            addText.addAction(pendingIntent, new Slice.Builder(addText).addHints(Collections.singletonList(CustomCredentialEntry.SLICE_HINT_PENDING_INTENT)).build(), (String) null);
            Slice build = addText.build();
            Intrinsics.checkNotNullExpressionValue(build, "sliceBuilder.build()");
            return build;
        }

        @JvmStatic
        public static final CustomCredentialEntry fromSlice(Slice slice) {
            Iterator it;
            Slice slice2 = slice;
            Intrinsics.checkNotNullParameter(slice2, "slice");
            SliceSpec spec = slice2.getSpec();
            Intrinsics.checkNotNull(spec);
            String type = spec.getType();
            Intrinsics.checkNotNullExpressionValue(type, "slice.spec!!.type");
            List<SliceItem> items = slice2.getItems();
            Intrinsics.checkNotNullExpressionValue(items, "slice.items");
            Iterator it2 = items.iterator();
            boolean z = false;
            boolean z2 = false;
            boolean z3 = false;
            boolean z4 = false;
            CharSequence charSequence = null;
            CharSequence charSequence2 = null;
            PendingIntent pendingIntent = null;
            CharSequence charSequence3 = null;
            CharSequence charSequence4 = null;
            Icon icon = null;
            Instant instant = null;
            CharSequence charSequence5 = null;
            CharSequence charSequence6 = null;
            while (it2.hasNext()) {
                SliceItem sliceItem = (SliceItem) it2.next();
                if (sliceItem.hasHint(CustomCredentialEntry.SLICE_HINT_TYPE_DISPLAY_NAME)) {
                    charSequence4 = sliceItem.getText();
                } else if (sliceItem.hasHint(CustomCredentialEntry.SLICE_HINT_TITLE)) {
                    charSequence2 = sliceItem.getText();
                } else if (sliceItem.hasHint(CustomCredentialEntry.SLICE_HINT_SUBTITLE)) {
                    charSequence3 = sliceItem.getText();
                } else if (sliceItem.hasHint(CustomCredentialEntry.SLICE_HINT_ICON)) {
                    icon = sliceItem.getIcon();
                } else if (sliceItem.hasHint(CustomCredentialEntry.SLICE_HINT_PENDING_INTENT)) {
                    pendingIntent = sliceItem.getAction();
                } else if (sliceItem.hasHint(CustomCredentialEntry.SLICE_HINT_OPTION_ID)) {
                    charSequence = sliceItem.getText();
                } else if (sliceItem.hasHint(CustomCredentialEntry.SLICE_HINT_LAST_USED_TIME_MILLIS)) {
                    instant = Instant.ofEpochMilli(sliceItem.getLong());
                } else {
                    it = it2;
                    if (sliceItem.hasHint(CustomCredentialEntry.SLICE_HINT_AUTO_ALLOWED)) {
                        if (Intrinsics.areEqual((Object) sliceItem.getText(), (Object) CustomCredentialEntry.TRUE_STRING)) {
                            z = true;
                        }
                    } else if (sliceItem.hasHint(CustomCredentialEntry.SLICE_HINT_DEDUPLICATION_ID)) {
                        charSequence5 = sliceItem.getText();
                    } else if (sliceItem.hasHint(CustomCredentialEntry.SLICE_HINT_AUTO_SELECT_FROM_OPTION)) {
                        z3 = true;
                    } else if (sliceItem.hasHint(CustomCredentialEntry.SLICE_HINT_IS_DEFAULT_ICON_PREFERRED)) {
                        if (Intrinsics.areEqual((Object) sliceItem.getText(), (Object) CustomCredentialEntry.TRUE_STRING)) {
                            z2 = true;
                        }
                    } else if (sliceItem.hasHint(CustomCredentialEntry.SLICE_HINT_DEFAULT_ICON_RES_ID)) {
                        z4 = true;
                    } else if (sliceItem.hasHint(CustomCredentialEntry.SLICE_HINT_AFFILIATED_DOMAIN)) {
                        charSequence6 = sliceItem.getText();
                    }
                    it2 = it;
                }
                it = it2;
                it2 = it;
            }
            try {
                Intrinsics.checkNotNull(charSequence2);
                Intrinsics.checkNotNull(pendingIntent);
                Intrinsics.checkNotNull(icon);
                Intrinsics.checkNotNull(charSequence);
                return new CustomCredentialEntry(type, charSequence2, pendingIntent, z, charSequence3, charSequence4, icon, instant, new BeginGetCustomCredentialOption(charSequence.toString(), type, new Bundle()), z2, charSequence5, charSequence6, z3, true, z4);
            } catch (Exception e) {
                Log.i(CustomCredentialEntry.TAG, "fromSlice failed with: " + e.getMessage());
                return null;
            }
        }
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0007J\u0012\u0010\u001a\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u001b\u001a\u00020\u001cH\u0007J\u0012\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001e\u001a\u00020\u0017H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Landroidx/credentials/provider/CustomCredentialEntry$Companion;", "", "()V", "FALSE_STRING", "", "REVISION_ID", "", "SLICE_HINT_AFFILIATED_DOMAIN", "SLICE_HINT_AUTO_ALLOWED", "SLICE_HINT_AUTO_SELECT_FROM_OPTION", "SLICE_HINT_DEDUPLICATION_ID", "SLICE_HINT_DEFAULT_ICON_RES_ID", "SLICE_HINT_ICON", "SLICE_HINT_IS_DEFAULT_ICON_PREFERRED", "SLICE_HINT_LAST_USED_TIME_MILLIS", "SLICE_HINT_OPTION_ID", "SLICE_HINT_PENDING_INTENT", "SLICE_HINT_SUBTITLE", "SLICE_HINT_TITLE", "SLICE_HINT_TYPE_DISPLAY_NAME", "TAG", "TRUE_STRING", "fromCredentialEntry", "Landroidx/credentials/provider/CustomCredentialEntry;", "credentialEntry", "Landroid/service/credentials/CredentialEntry;", "fromSlice", "slice", "Landroid/app/slice/Slice;", "toSlice", "entry", "credentials_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: CustomCredentialEntry.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final Slice toSlice(CustomCredentialEntry customCredentialEntry) {
            Intrinsics.checkNotNullParameter(customCredentialEntry, "entry");
            if (Build.VERSION.SDK_INT >= 28) {
                return Api28Impl.toSlice(customCredentialEntry);
            }
            return null;
        }

        @JvmStatic
        public final CustomCredentialEntry fromSlice(Slice slice) {
            Intrinsics.checkNotNullParameter(slice, "slice");
            if (Build.VERSION.SDK_INT >= 28) {
                return Api28Impl.fromSlice(slice);
            }
            return null;
        }

        @JvmStatic
        public final CustomCredentialEntry fromCredentialEntry(CredentialEntry credentialEntry) {
            Intrinsics.checkNotNullParameter(credentialEntry, "credentialEntry");
            if (Build.VERSION.SDK_INT >= 34) {
                return Api34Impl.fromCredentialEntry(credentialEntry);
            }
            return null;
        }
    }

    @Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\u0006\u0010\u0017\u001a\u00020\u0018J\u000e\u0010\u0019\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\u000eJ\u000e\u0010\u001a\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u000eJ\u000e\u0010\u001b\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u0007J\u000e\u0010\u001c\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u0011J\u0010\u0010\u001d\u001a\u00020\u00002\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014J\u0010\u0010\u001e\u001a\u00020\u00002\b\u0010\u0015\u001a\u0004\u0018\u00010\u0007J\u0010\u0010\u001f\u001a\u00020\u00002\b\u0010\u0016\u001a\u0004\u0018\u00010\u0007R\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Landroidx/credentials/provider/CustomCredentialEntry$Builder;", "", "context", "Landroid/content/Context;", "type", "", "title", "", "pendingIntent", "Landroid/app/PendingIntent;", "beginGetCredentialOption", "Landroidx/credentials/provider/BeginGetCredentialOption;", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/CharSequence;Landroid/app/PendingIntent;Landroidx/credentials/provider/BeginGetCredentialOption;)V", "autoSelectAllowed", "", "entryGroupId", "icon", "Landroid/graphics/drawable/Icon;", "isDefaultIconPreferredAsSingleProvider", "lastUsedTime", "Ljava/time/Instant;", "subtitle", "typeDisplayName", "build", "Landroidx/credentials/provider/CustomCredentialEntry;", "setAutoSelectAllowed", "setDefaultIconPreferredAsSingleProvider", "setEntryGroupId", "setIcon", "setLastUsedTime", "setSubtitle", "setTypeDisplayName", "credentials_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: CustomCredentialEntry.kt */
    public static final class Builder {
        private boolean autoSelectAllowed;
        private final BeginGetCredentialOption beginGetCredentialOption;
        private final Context context;
        private CharSequence entryGroupId;
        private Icon icon;
        private boolean isDefaultIconPreferredAsSingleProvider;
        private Instant lastUsedTime;
        private final PendingIntent pendingIntent;
        private CharSequence subtitle;
        private final CharSequence title;
        private final String type;
        private CharSequence typeDisplayName;

        public Builder(Context context2, String str, CharSequence charSequence, PendingIntent pendingIntent2, BeginGetCredentialOption beginGetCredentialOption2) {
            Intrinsics.checkNotNullParameter(context2, "context");
            Intrinsics.checkNotNullParameter(str, "type");
            Intrinsics.checkNotNullParameter(charSequence, "title");
            Intrinsics.checkNotNullParameter(pendingIntent2, BaseGmsClient.KEY_PENDING_INTENT);
            Intrinsics.checkNotNullParameter(beginGetCredentialOption2, "beginGetCredentialOption");
            this.context = context2;
            this.type = str;
            this.title = charSequence;
            this.pendingIntent = pendingIntent2;
            this.beginGetCredentialOption = beginGetCredentialOption2;
            this.entryGroupId = charSequence;
        }

        public final Builder setSubtitle(CharSequence charSequence) {
            this.subtitle = charSequence;
            return this;
        }

        public final Builder setTypeDisplayName(CharSequence charSequence) {
            this.typeDisplayName = charSequence;
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

        public final Builder setEntryGroupId(CharSequence charSequence) {
            Intrinsics.checkNotNullParameter(charSequence, "entryGroupId");
            if (charSequence.length() > 0) {
                this.entryGroupId = charSequence;
                return this;
            }
            throw new IllegalArgumentException("entryGroupId must not be empty".toString());
        }

        public final Builder setLastUsedTime(Instant instant) {
            this.lastUsedTime = instant;
            return this;
        }

        public final Builder setDefaultIconPreferredAsSingleProvider(boolean z) {
            this.isDefaultIconPreferredAsSingleProvider = z;
            return this;
        }

        public final CustomCredentialEntry build() {
            if (this.icon == null) {
                this.icon = Icon.createWithResource(this.context, R.drawable.ic_other_sign_in);
            }
            String str = this.type;
            CharSequence charSequence = this.title;
            PendingIntent pendingIntent2 = this.pendingIntent;
            boolean z = this.autoSelectAllowed;
            CharSequence charSequence2 = this.subtitle;
            CharSequence charSequence3 = this.typeDisplayName;
            Icon icon2 = this.icon;
            Intrinsics.checkNotNull(icon2);
            return new CustomCredentialEntry(str, charSequence, pendingIntent2, z, charSequence2, charSequence3, icon2, this.lastUsedTime, this.beginGetCredentialOption, this.isDefaultIconPreferredAsSingleProvider, this.entryGroupId, (CharSequence) null, false, false, false, 30720, (DefaultConstructorMarker) null);
        }
    }
}
