package com.google.android.gms.internal.fido;

import java.util.Comparator;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-fido@@21.0.0 */
final class zzfd implements Comparator {
    zzfd() {
    }

    public final int compare(Object obj, Object obj2) {
        return ((String) ((Map.Entry) obj).getKey()).compareTo((String) ((Map.Entry) obj2).getKey());
    }
}
