package com.google.firebase.firestore.remote;

import com.google.firebase.firestore.remote.TestingHooks;

final class AutoValue_TestingHooks_ExistenceFilterMismatchInfo extends TestingHooks.ExistenceFilterMismatchInfo {
    private final TestingHooks.ExistenceFilterBloomFilterInfo bloomFilter;
    private final String databaseId;
    private final int existenceFilterCount;
    private final int localCacheCount;
    private final String projectId;

    AutoValue_TestingHooks_ExistenceFilterMismatchInfo(int i, int i2, String str, String str2, TestingHooks.ExistenceFilterBloomFilterInfo existenceFilterBloomFilterInfo) {
        this.localCacheCount = i;
        this.existenceFilterCount = i2;
        if (str != null) {
            this.projectId = str;
            if (str2 != null) {
                this.databaseId = str2;
                this.bloomFilter = existenceFilterBloomFilterInfo;
                return;
            }
            throw new NullPointerException("Null databaseId");
        }
        throw new NullPointerException("Null projectId");
    }

    /* access modifiers changed from: package-private */
    public int localCacheCount() {
        return this.localCacheCount;
    }

    /* access modifiers changed from: package-private */
    public int existenceFilterCount() {
        return this.existenceFilterCount;
    }

    /* access modifiers changed from: package-private */
    public String projectId() {
        return this.projectId;
    }

    /* access modifiers changed from: package-private */
    public String databaseId() {
        return this.databaseId;
    }

    /* access modifiers changed from: package-private */
    public TestingHooks.ExistenceFilterBloomFilterInfo bloomFilter() {
        return this.bloomFilter;
    }

    public String toString() {
        return "ExistenceFilterMismatchInfo{localCacheCount=" + this.localCacheCount + ", existenceFilterCount=" + this.existenceFilterCount + ", projectId=" + this.projectId + ", databaseId=" + this.databaseId + ", bloomFilter=" + this.bloomFilter + "}";
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0033, code lost:
        r1 = r4.bloomFilter;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(java.lang.Object r5) {
        /*
            r4 = this;
            r0 = 1
            if (r5 != r4) goto L_0x0004
            return r0
        L_0x0004:
            boolean r1 = r5 instanceof com.google.firebase.firestore.remote.TestingHooks.ExistenceFilterMismatchInfo
            r2 = 0
            if (r1 == 0) goto L_0x0049
            com.google.firebase.firestore.remote.TestingHooks$ExistenceFilterMismatchInfo r5 = (com.google.firebase.firestore.remote.TestingHooks.ExistenceFilterMismatchInfo) r5
            int r1 = r4.localCacheCount
            int r3 = r5.localCacheCount()
            if (r1 != r3) goto L_0x0049
            int r1 = r4.existenceFilterCount
            int r3 = r5.existenceFilterCount()
            if (r1 != r3) goto L_0x0049
            java.lang.String r1 = r4.projectId
            java.lang.String r3 = r5.projectId()
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x0049
            java.lang.String r1 = r4.databaseId
            java.lang.String r3 = r5.databaseId()
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x0049
            com.google.firebase.firestore.remote.TestingHooks$ExistenceFilterBloomFilterInfo r1 = r4.bloomFilter
            if (r1 != 0) goto L_0x003e
            com.google.firebase.firestore.remote.TestingHooks$ExistenceFilterBloomFilterInfo r5 = r5.bloomFilter()
            if (r5 != 0) goto L_0x0049
            goto L_0x0048
        L_0x003e:
            com.google.firebase.firestore.remote.TestingHooks$ExistenceFilterBloomFilterInfo r5 = r5.bloomFilter()
            boolean r5 = r1.equals(r5)
            if (r5 == 0) goto L_0x0049
        L_0x0048:
            return r0
        L_0x0049:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.firestore.remote.AutoValue_TestingHooks_ExistenceFilterMismatchInfo.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        int hashCode = (((((((this.localCacheCount ^ 1000003) * 1000003) ^ this.existenceFilterCount) * 1000003) ^ this.projectId.hashCode()) * 1000003) ^ this.databaseId.hashCode()) * 1000003;
        TestingHooks.ExistenceFilterBloomFilterInfo existenceFilterBloomFilterInfo = this.bloomFilter;
        return hashCode ^ (existenceFilterBloomFilterInfo == null ? 0 : existenceFilterBloomFilterInfo.hashCode());
    }
}
