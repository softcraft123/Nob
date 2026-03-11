package com.google.android.gms.fido.common;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.internal.fido.zzhu;
import com.google.android.gms.internal.fido.zzhx;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;

/* compiled from: com.google.android.gms:play-services-fido@@21.0.0 */
public enum Transport implements ReflectedParcelable {
    BLUETOOTH_CLASSIC("bt"),
    BLUETOOTH_LOW_ENERGY("ble"),
    NFC("nfc"),
    USB("usb"),
    INTERNAL("internal"),
    HYBRID("cable"),
    HYBRID_V2("hybrid");
    
    public static final Parcelable.Creator<Transport> CREATOR = null;
    private final String zzc;

    /* compiled from: com.google.android.gms:play-services-fido@@21.0.0 */
    public static class UnsupportedTransportException extends Exception {
        public UnsupportedTransportException(String str) {
            super(str);
        }
    }

    static {
        CREATOR = new zza();
    }

    private Transport(String str) {
        this.zzc = str;
    }

    public static Transport fromString(String str) throws UnsupportedTransportException {
        if (str.equals("hybrid") && (!zzhu.zzb() || !zzhx.zzb())) {
            return HYBRID;
        }
        for (Transport transport : values()) {
            if (str.equals(transport.zzc)) {
                return transport;
            }
        }
        throw new UnsupportedTransportException(String.format("Transport %s not supported", new Object[]{str}));
    }

    public static List<Transport> parseTransports(JSONArray jSONArray) throws JSONException {
        if (jSONArray == null) {
            return null;
        }
        HashSet hashSet = new HashSet(jSONArray.length());
        for (int i = 0; i < jSONArray.length(); i++) {
            String string = jSONArray.getString(i);
            if (string != null && !string.isEmpty()) {
                try {
                    hashSet.add(fromString(string));
                } catch (UnsupportedTransportException unused) {
                    Log.w("Transport", "Ignoring unrecognized transport ".concat(string));
                }
            }
        }
        return new ArrayList(hashSet);
    }

    public int describeContents() {
        return 0;
    }

    public String toString() {
        return this.zzc;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.zzc);
    }
}
