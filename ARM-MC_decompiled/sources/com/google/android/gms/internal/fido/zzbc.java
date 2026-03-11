package com.google.android.gms.internal.fido;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-fido@@21.0.0 */
public final class zzbc {
    public static final Appendable zza(Appendable appendable, Iterator it, zzbd zzbd, String str) throws IOException {
        if (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            appendable.append(zzbd.zzd(entry.getKey()));
            appendable.append(" : ");
            appendable.append(zzbd.zzd(entry.getValue()));
            while (it.hasNext()) {
                appendable.append(zzbd.zza);
                Map.Entry entry2 = (Map.Entry) it.next();
                appendable.append(zzbd.zzd(entry2.getKey()));
                appendable.append(" : ");
                appendable.append(zzbd.zzd(entry2.getValue()));
            }
        }
        return appendable;
    }
}
