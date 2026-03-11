package com.google.firebase.auth.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
public final class zzo {
    private static zzo zza = new zzo();

    private static SharedPreferences zza(Context context, String str) {
        return context.getSharedPreferences(String.format("com.google.firebase.auth.internal.browserSignInSessionStore.%s", new Object[]{str}), 0);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x006b, code lost:
        return null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized com.google.firebase.auth.internal.zzr zza(android.content.Context r10, java.lang.String r11, java.lang.String r12) {
        /*
            r9 = this;
            monitor-enter(r9)
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r11)     // Catch:{ all -> 0x006c }
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r12)     // Catch:{ all -> 0x006c }
            android.content.SharedPreferences r10 = zza(r10, r11)     // Catch:{ all -> 0x006c }
            java.lang.String r11 = "com.google.firebase.auth.internal.EVENT_ID.%s.SESSION_ID"
            java.lang.Object[] r0 = new java.lang.Object[]{r12}     // Catch:{ all -> 0x006c }
            java.lang.String r11 = java.lang.String.format(r11, r0)     // Catch:{ all -> 0x006c }
            java.lang.String r0 = "com.google.firebase.auth.internal.EVENT_ID.%s.OPERATION"
            java.lang.Object[] r1 = new java.lang.Object[]{r12}     // Catch:{ all -> 0x006c }
            java.lang.String r0 = java.lang.String.format(r0, r1)     // Catch:{ all -> 0x006c }
            java.lang.String r1 = "com.google.firebase.auth.internal.EVENT_ID.%s.PROVIDER_ID"
            java.lang.Object[] r2 = new java.lang.Object[]{r12}     // Catch:{ all -> 0x006c }
            java.lang.String r1 = java.lang.String.format(r1, r2)     // Catch:{ all -> 0x006c }
            java.lang.String r2 = "com.google.firebase.auth.internal.EVENT_ID.%s.FIREBASE_APP_NAME"
            java.lang.Object[] r12 = new java.lang.Object[]{r12}     // Catch:{ all -> 0x006c }
            java.lang.String r12 = java.lang.String.format(r2, r12)     // Catch:{ all -> 0x006c }
            r2 = 0
            java.lang.String r4 = r10.getString(r11, r2)     // Catch:{ all -> 0x006c }
            java.lang.String r5 = r10.getString(r0, r2)     // Catch:{ all -> 0x006c }
            java.lang.String r6 = r10.getString(r1, r2)     // Catch:{ all -> 0x006c }
            java.lang.String r3 = "com.google.firebase.auth.api.gms.config.tenant.id"
            java.lang.String r7 = r10.getString(r3, r2)     // Catch:{ all -> 0x006c }
            java.lang.String r8 = r10.getString(r12, r2)     // Catch:{ all -> 0x006c }
            android.content.SharedPreferences$Editor r10 = r10.edit()     // Catch:{ all -> 0x006c }
            r10.remove(r11)     // Catch:{ all -> 0x006c }
            r10.remove(r0)     // Catch:{ all -> 0x006c }
            r10.remove(r1)     // Catch:{ all -> 0x006c }
            r10.remove(r12)     // Catch:{ all -> 0x006c }
            r10.apply()     // Catch:{ all -> 0x006c }
            if (r4 == 0) goto L_0x006a
            if (r5 == 0) goto L_0x006a
            if (r6 == 0) goto L_0x006a
            com.google.firebase.auth.internal.zzr r3 = new com.google.firebase.auth.internal.zzr     // Catch:{ all -> 0x006c }
            r3.<init>(r4, r5, r6, r7, r8)     // Catch:{ all -> 0x006c }
            monitor-exit(r9)
            return r3
        L_0x006a:
            monitor-exit(r9)
            return r2
        L_0x006c:
            r0 = move-exception
            r10 = r0
            monitor-exit(r9)     // Catch:{ all -> 0x006c }
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.auth.internal.zzo.zza(android.content.Context, java.lang.String, java.lang.String):com.google.firebase.auth.internal.zzr");
    }

    public static zzo zza() {
        return zza;
    }

    public final synchronized String zzb(Context context, String str, String str2) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        SharedPreferences zza2 = zza(context, str);
        String format = String.format("com.google.firebase.auth.internal.EVENT_ID.%s.OPERATION", new Object[]{str2});
        String string = zza2.getString(format, (String) null);
        String format2 = String.format("com.google.firebase.auth.internal.EVENT_ID.%s.FIREBASE_APP_NAME", new Object[]{str2});
        String string2 = zza2.getString(format2, (String) null);
        SharedPreferences.Editor edit = zza2.edit();
        edit.remove(format);
        edit.remove(format2);
        edit.apply();
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        return string2;
    }

    private zzo() {
    }

    private static void zza(SharedPreferences sharedPreferences) {
        SharedPreferences.Editor edit = sharedPreferences.edit();
        for (String remove : sharedPreferences.getAll().keySet()) {
            edit.remove(remove);
        }
        edit.apply();
    }

    public final synchronized void zza(Context context, String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        Preconditions.checkNotEmpty(str3);
        Preconditions.checkNotEmpty(str7);
        SharedPreferences zza2 = zza(context, str);
        zza(zza2);
        SharedPreferences.Editor edit = zza2.edit();
        edit.putString(String.format("com.google.firebase.auth.internal.EVENT_ID.%s.SESSION_ID", new Object[]{str2}), str3);
        edit.putString(String.format("com.google.firebase.auth.internal.EVENT_ID.%s.OPERATION", new Object[]{str2}), str4);
        edit.putString(String.format("com.google.firebase.auth.internal.EVENT_ID.%s.PROVIDER_ID", new Object[]{str2}), str5);
        edit.putString(String.format("com.google.firebase.auth.internal.EVENT_ID.%s.FIREBASE_APP_NAME", new Object[]{str2}), str7);
        edit.putString("com.google.firebase.auth.api.gms.config.tenant.id", str6);
        edit.apply();
    }

    public final synchronized void zza(Context context, String str, String str2, String str3, String str4) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        SharedPreferences zza2 = zza(context, str);
        zza(zza2);
        SharedPreferences.Editor edit = zza2.edit();
        edit.putString(String.format("com.google.firebase.auth.internal.EVENT_ID.%s.OPERATION", new Object[]{str2}), str3);
        edit.putString(String.format("com.google.firebase.auth.internal.EVENT_ID.%s.FIREBASE_APP_NAME", new Object[]{str2}), str4);
        edit.apply();
    }
}
