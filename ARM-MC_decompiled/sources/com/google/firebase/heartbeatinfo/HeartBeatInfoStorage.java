package com.google.firebase.heartbeatinfo;

import android.content.Context;
import androidx.core.provider.FontRequestWorker$$ExternalSyntheticBackport0;
import androidx.datastore.preferences.core.MutablePreferences;
import androidx.datastore.preferences.core.Preferences;
import androidx.datastore.preferences.core.PreferencesKeys;
import com.google.firebase.datastorage.JavaDataStorage;
import com.google.firebase.datastorage.JavaDataStorageKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Unit;

class HeartBeatInfoStorage {
    private static final Preferences.Key<Long> GLOBAL = PreferencesKeys.longKey("fire-global");
    private static final String HEARTBEAT_PREFERENCES_NAME = "FirebaseHeartBeat";
    private static final int HEART_BEAT_COUNT_LIMIT = 30;
    private static final Preferences.Key<Long> HEART_BEAT_COUNT_TAG = PreferencesKeys.longKey("fire-count");
    private static final Preferences.Key<String> LAST_STORED_DATE = PreferencesKeys.stringKey("last-used-date");
    private static final String PREFERENCES_NAME = "FirebaseAppHeartBeat";
    private static HeartBeatInfoStorage instance;
    private final JavaDataStorage firebaseDataStore;

    public HeartBeatInfoStorage(Context context, String str) {
        this.firebaseDataStore = new JavaDataStorage(context, HEARTBEAT_PREFERENCES_NAME + str);
    }

    HeartBeatInfoStorage(JavaDataStorage javaDataStorage) {
        this.firebaseDataStore = javaDataStorage;
    }

    /* access modifiers changed from: package-private */
    public int getHeartBeatCount() {
        return ((Long) this.firebaseDataStore.getSync(HEART_BEAT_COUNT_TAG, 0L)).intValue();
    }

    /* access modifiers changed from: package-private */
    public synchronized void deleteAllHeartBeats() {
        this.firebaseDataStore.editSync(new HeartBeatInfoStorage$$ExternalSyntheticLambda3(this));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$deleteAllHeartBeats$0$com-google-firebase-heartbeatinfo-HeartBeatInfoStorage  reason: not valid java name */
    public /* synthetic */ Unit m501lambda$deleteAllHeartBeats$0$comgooglefirebaseheartbeatinfoHeartBeatInfoStorage(MutablePreferences mutablePreferences) {
        long j = 0;
        for (Map.Entry next : mutablePreferences.asMap().entrySet()) {
            if (next.getValue() instanceof Set) {
                Preferences.Key key = (Preferences.Key) next.getKey();
                String formattedDate = getFormattedDate(System.currentTimeMillis());
                if (((Set) next.getValue()).contains(formattedDate)) {
                    mutablePreferences.set(key, FontRequestWorker$$ExternalSyntheticBackport0.m((Object) formattedDate));
                    j++;
                } else {
                    mutablePreferences.remove(key);
                }
            }
        }
        if (j == 0) {
            mutablePreferences.remove(HEART_BEAT_COUNT_TAG);
            return null;
        }
        mutablePreferences.set(HEART_BEAT_COUNT_TAG, Long.valueOf(j));
        return null;
    }

    /* access modifiers changed from: package-private */
    public synchronized List<HeartBeatResult> getAllHeartBeats() {
        ArrayList arrayList;
        arrayList = new ArrayList();
        String formattedDate = getFormattedDate(System.currentTimeMillis());
        for (Map.Entry next : this.firebaseDataStore.getAllSync().entrySet()) {
            if (next.getValue() instanceof Set) {
                HashSet hashSet = new HashSet((Set) next.getValue());
                hashSet.remove(formattedDate);
                if (!hashSet.isEmpty()) {
                    arrayList.add(HeartBeatResult.create(((Preferences.Key) next.getKey()).getName(), new ArrayList(hashSet)));
                }
            }
        }
        updateGlobalHeartBeat(System.currentTimeMillis());
        return arrayList;
    }

    private synchronized Preferences.Key<Set<String>> getStoredUserAgentString(MutablePreferences mutablePreferences, String str) {
        for (Map.Entry next : mutablePreferences.asMap().entrySet()) {
            if (next.getValue() instanceof Set) {
                for (String equals : (Set) next.getValue()) {
                    if (str.equals(equals)) {
                        return PreferencesKeys.stringSetKey(((Preferences.Key) next.getKey()).getName());
                    }
                }
                continue;
            }
        }
        return null;
    }

    /* JADX WARNING: type inference failed for: r4v0, types: [androidx.datastore.preferences.core.Preferences$Key, androidx.datastore.preferences.core.Preferences$Key<java.util.Set<java.lang.String>>] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized void updateStoredUserAgent(androidx.datastore.preferences.core.MutablePreferences r3, androidx.datastore.preferences.core.Preferences.Key<java.util.Set<java.lang.String>> r4, java.lang.String r5) {
        /*
            r2 = this;
            monitor-enter(r2)
            r2.removeStoredDate(r3, r5)     // Catch:{ all -> 0x001c }
            java.util.HashSet r0 = new java.util.HashSet     // Catch:{ all -> 0x001c }
            java.util.HashSet r1 = new java.util.HashSet     // Catch:{ all -> 0x001c }
            r1.<init>()     // Catch:{ all -> 0x001c }
            java.lang.Object r1 = com.google.firebase.datastorage.JavaDataStorageKt.getOrDefault(r3, r4, r1)     // Catch:{ all -> 0x001c }
            java.util.Collection r1 = (java.util.Collection) r1     // Catch:{ all -> 0x001c }
            r0.<init>(r1)     // Catch:{ all -> 0x001c }
            r0.add(r5)     // Catch:{ all -> 0x001c }
            r3.set(r4, r0)     // Catch:{ all -> 0x001c }
            monitor-exit(r2)
            return
        L_0x001c:
            r3 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x001c }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.heartbeatinfo.HeartBeatInfoStorage.updateStoredUserAgent(androidx.datastore.preferences.core.MutablePreferences, androidx.datastore.preferences.core.Preferences$Key, java.lang.String):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x002a, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized void removeStoredDate(androidx.datastore.preferences.core.MutablePreferences r4, java.lang.String r5) {
        /*
            r3 = this;
            monitor-enter(r3)
            androidx.datastore.preferences.core.Preferences$Key r0 = r3.getStoredUserAgentString(r4, r5)     // Catch:{ all -> 0x002b }
            if (r0 != 0) goto L_0x0009
            monitor-exit(r3)
            return
        L_0x0009:
            java.util.HashSet r1 = new java.util.HashSet     // Catch:{ all -> 0x002b }
            java.util.HashSet r2 = new java.util.HashSet     // Catch:{ all -> 0x002b }
            r2.<init>()     // Catch:{ all -> 0x002b }
            java.lang.Object r2 = com.google.firebase.datastorage.JavaDataStorageKt.getOrDefault(r4, r0, r2)     // Catch:{ all -> 0x002b }
            java.util.Collection r2 = (java.util.Collection) r2     // Catch:{ all -> 0x002b }
            r1.<init>(r2)     // Catch:{ all -> 0x002b }
            r1.remove(r5)     // Catch:{ all -> 0x002b }
            boolean r5 = r1.isEmpty()     // Catch:{ all -> 0x002b }
            if (r5 == 0) goto L_0x0026
            r4.remove(r0)     // Catch:{ all -> 0x002b }
            goto L_0x0029
        L_0x0026:
            r4.set(r0, r1)     // Catch:{ all -> 0x002b }
        L_0x0029:
            monitor-exit(r3)
            return
        L_0x002b:
            r4 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x002b }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.heartbeatinfo.HeartBeatInfoStorage.removeStoredDate(androidx.datastore.preferences.core.MutablePreferences, java.lang.String):void");
    }

    /* access modifiers changed from: package-private */
    public synchronized void postHeartBeatCleanUp() {
        this.firebaseDataStore.editSync(new HeartBeatInfoStorage$$ExternalSyntheticLambda4(this, getFormattedDate(System.currentTimeMillis())));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$postHeartBeatCleanUp$1$com-google-firebase-heartbeatinfo-HeartBeatInfoStorage  reason: not valid java name */
    public /* synthetic */ Unit m502lambda$postHeartBeatCleanUp$1$comgooglefirebaseheartbeatinfoHeartBeatInfoStorage(String str, MutablePreferences mutablePreferences) {
        mutablePreferences.set(LAST_STORED_DATE, str);
        removeStoredDate(mutablePreferences, str);
        return null;
    }

    /* JADX WARNING: CFG modification limit reached, blocks count: 111 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized java.lang.String getFormattedDate(long r2) {
        /*
            r1 = this;
            monitor-enter(r1)
            java.util.Date r0 = new java.util.Date     // Catch:{ all -> 0x001e }
            r0.<init>(r2)     // Catch:{ all -> 0x001e }
            java.time.Instant r2 = r0.toInstant()     // Catch:{ all -> 0x001e }
            java.time.ZoneOffset r3 = java.time.ZoneOffset.UTC     // Catch:{ all -> 0x001e }
            java.time.OffsetDateTime r2 = r2.atOffset(r3)     // Catch:{ all -> 0x001e }
            java.time.LocalDateTime r2 = r2.toLocalDateTime()     // Catch:{ all -> 0x001e }
            java.time.format.DateTimeFormatter r3 = java.time.format.DateTimeFormatter.ISO_LOCAL_DATE     // Catch:{ all -> 0x001e }
            java.lang.String r2 = r2.format(r3)     // Catch:{ all -> 0x001e }
            monitor-exit(r1)
            return r2
        L_0x001c:
            monitor-exit(r1)     // Catch:{ all -> 0x001e }
            throw r2
        L_0x001e:
            r2 = move-exception
            goto L_0x001c
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.heartbeatinfo.HeartBeatInfoStorage.getFormattedDate(long):java.lang.String");
    }

    /* access modifiers changed from: package-private */
    public synchronized void storeHeartBeat(long j, String str) {
        this.firebaseDataStore.editSync(new HeartBeatInfoStorage$$ExternalSyntheticLambda2(this, getFormattedDate(j), str, PreferencesKeys.stringSetKey(str)));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$storeHeartBeat$2$com-google-firebase-heartbeatinfo-HeartBeatInfoStorage  reason: not valid java name */
    public /* synthetic */ Unit m503lambda$storeHeartBeat$2$comgooglefirebaseheartbeatinfoHeartBeatInfoStorage(String str, String str2, Preferences.Key key, MutablePreferences mutablePreferences) {
        Preferences.Key key2 = LAST_STORED_DATE;
        if (((String) JavaDataStorageKt.getOrDefault(mutablePreferences, key2, "")).equals(str)) {
            Preferences.Key<Set<String>> storedUserAgentString = getStoredUserAgentString(mutablePreferences, str);
            if (storedUserAgentString == null || storedUserAgentString.getName().equals(str2)) {
                return null;
            }
            updateStoredUserAgent(mutablePreferences, key, str);
            return null;
        }
        Preferences.Key key3 = HEART_BEAT_COUNT_TAG;
        long longValue = ((Long) JavaDataStorageKt.getOrDefault(mutablePreferences, key3, 0L)).longValue();
        if (longValue + 1 == 30) {
            longValue = cleanUpStoredHeartBeats(mutablePreferences);
        }
        HashSet hashSet = new HashSet((Collection) JavaDataStorageKt.getOrDefault(mutablePreferences, key, new HashSet()));
        hashSet.add(str);
        mutablePreferences.set(key, hashSet);
        mutablePreferences.set(key3, Long.valueOf(longValue + 1));
        mutablePreferences.set(key2, str);
        return null;
    }

    private synchronized long cleanUpStoredHeartBeats(MutablePreferences mutablePreferences) {
        long j;
        long longValue = ((Long) JavaDataStorageKt.getOrDefault(mutablePreferences, HEART_BEAT_COUNT_TAG, 0L)).longValue();
        String str = "";
        Set hashSet = new HashSet();
        String str2 = null;
        for (Map.Entry next : mutablePreferences.asMap().entrySet()) {
            if (next.getValue() instanceof Set) {
                Set<String> set = (Set) next.getValue();
                for (String str3 : set) {
                    if (str2 == null || str2.compareTo(str3) > 0) {
                        str = ((Preferences.Key) next.getKey()).getName();
                        hashSet = set;
                        str2 = str3;
                    }
                }
            }
        }
        HashSet hashSet2 = new HashSet(hashSet);
        hashSet2.remove(str2);
        mutablePreferences.set(PreferencesKeys.stringSetKey(str), hashSet2);
        j = longValue - 1;
        mutablePreferences.set(HEART_BEAT_COUNT_TAG, Long.valueOf(j));
        return j;
    }

    /* access modifiers changed from: package-private */
    public synchronized long getLastGlobalHeartBeat() {
        return ((Long) this.firebaseDataStore.getSync(GLOBAL, -1L)).longValue();
    }

    /* access modifiers changed from: package-private */
    public synchronized void updateGlobalHeartBeat(long j) {
        this.firebaseDataStore.editSync(new HeartBeatInfoStorage$$ExternalSyntheticLambda5(j));
    }

    /* access modifiers changed from: package-private */
    public synchronized boolean isSameDateUtc(long j, long j2) {
        return getFormattedDate(j).equals(getFormattedDate(j2));
    }

    /* JADX WARNING: type inference failed for: r4v0, types: [androidx.datastore.preferences.core.Preferences$Key, androidx.datastore.preferences.core.Preferences$Key<java.lang.Long>] */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized boolean shouldSendSdkHeartBeat(androidx.datastore.preferences.core.Preferences.Key<java.lang.Long> r4, long r5) {
        /*
            r3 = this;
            monitor-enter(r3)
            com.google.firebase.datastorage.JavaDataStorage r0 = r3.firebaseDataStore     // Catch:{ all -> 0x0028 }
            r1 = -1
            java.lang.Long r1 = java.lang.Long.valueOf(r1)     // Catch:{ all -> 0x0028 }
            java.lang.Object r0 = r0.getSync(r4, r1)     // Catch:{ all -> 0x0028 }
            java.lang.Long r0 = (java.lang.Long) r0     // Catch:{ all -> 0x0028 }
            long r0 = r0.longValue()     // Catch:{ all -> 0x0028 }
            boolean r0 = r3.isSameDateUtc(r0, r5)     // Catch:{ all -> 0x0028 }
            if (r0 == 0) goto L_0x001c
            monitor-exit(r3)
            r4 = 0
            return r4
        L_0x001c:
            com.google.firebase.datastorage.JavaDataStorage r0 = r3.firebaseDataStore     // Catch:{ all -> 0x0028 }
            java.lang.Long r5 = java.lang.Long.valueOf(r5)     // Catch:{ all -> 0x0028 }
            r0.putSync(r4, r5)     // Catch:{ all -> 0x0028 }
            monitor-exit(r3)
            r4 = 1
            return r4
        L_0x0028:
            r4 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x0028 }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.heartbeatinfo.HeartBeatInfoStorage.shouldSendSdkHeartBeat(androidx.datastore.preferences.core.Preferences$Key, long):boolean");
    }

    /* access modifiers changed from: package-private */
    public synchronized boolean shouldSendGlobalHeartBeat(long j) {
        return shouldSendSdkHeartBeat(GLOBAL, j);
    }
}
