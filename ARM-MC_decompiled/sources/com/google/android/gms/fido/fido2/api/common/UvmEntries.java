package com.google.android.gms.fido.fido2.api.common;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.internal.fido.zzbm;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;

/* compiled from: com.google.android.gms:play-services-fido@@21.0.0 */
public class UvmEntries extends AbstractSafeParcelable {
    public static final Parcelable.Creator<UvmEntries> CREATOR = new zzbd();
    private final List zza;

    /* compiled from: com.google.android.gms:play-services-fido@@21.0.0 */
    public static final class Builder {
        private final List zza = new ArrayList();

        public Builder addAll(List<UvmEntry> list) {
            zzbm.zzc(this.zza.size() + list.size() <= 3);
            this.zza.addAll(list);
            return this;
        }

        public Builder addUvmEntry(UvmEntry uvmEntry) {
            if (this.zza.size() < 3) {
                if (uvmEntry != null) {
                    this.zza.add(uvmEntry);
                }
                return this;
            }
            throw new IllegalStateException();
        }

        public UvmEntries build() {
            return new UvmEntries(this.zza);
        }
    }

    UvmEntries(List list) {
        this.zza = list;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0015, code lost:
        r3 = r5.zza;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(java.lang.Object r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof com.google.android.gms.fido.fido2.api.common.UvmEntries
            r1 = 0
            if (r0 != 0) goto L_0x0006
            return r1
        L_0x0006:
            com.google.android.gms.fido.fido2.api.common.UvmEntries r5 = (com.google.android.gms.fido.fido2.api.common.UvmEntries) r5
            java.util.List r0 = r4.zza
            r2 = 1
            if (r0 != 0) goto L_0x0013
            java.util.List r3 = r5.zza
            if (r3 == 0) goto L_0x0012
            goto L_0x0013
        L_0x0012:
            return r2
        L_0x0013:
            if (r0 == 0) goto L_0x002a
            java.util.List r3 = r5.zza
            if (r3 == 0) goto L_0x002a
            boolean r0 = r0.containsAll(r3)
            if (r0 == 0) goto L_0x002a
            java.util.List r5 = r5.zza
            java.util.List r0 = r4.zza
            boolean r5 = r5.containsAll(r0)
            if (r5 == 0) goto L_0x002a
            return r2
        L_0x002a:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.fido.fido2.api.common.UvmEntries.equals(java.lang.Object):boolean");
    }

    public List<UvmEntry> getUvmEntryList() {
        return this.zza;
    }

    public int hashCode() {
        List list = this.zza;
        return Objects.hashCode(list == null ? null : new HashSet(list));
    }

    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeTypedList(parcel, 1, getUvmEntryList(), false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final JSONArray zza() {
        try {
            JSONArray jSONArray = new JSONArray();
            if (this.zza != null) {
                for (int i = 0; i < this.zza.size(); i++) {
                    UvmEntry uvmEntry = (UvmEntry) this.zza.get(i);
                    JSONArray jSONArray2 = new JSONArray();
                    jSONArray2.put(uvmEntry.getMatcherProtectionType());
                    jSONArray2.put(uvmEntry.getKeyProtectionType());
                    jSONArray2.put(uvmEntry.getMatcherProtectionType());
                    jSONArray.put(i, jSONArray2);
                }
            }
            return jSONArray;
        } catch (JSONException e) {
            throw new RuntimeException("Error encoding UvmEntries to JSON object", e);
        }
    }
}
