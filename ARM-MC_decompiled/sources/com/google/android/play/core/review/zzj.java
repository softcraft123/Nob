package com.google.android.play.core.review;

import com.google.android.play.core.review.internal.zzi;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/* compiled from: com.google.android.play:review@@2.0.2 */
public final class zzj {
    private static final Map zza = new HashMap();

    static {
        new HashSet(Arrays.asList(new String[]{"native", "unity"}));
        new zzi("PlayCoreVersion");
    }

    public static synchronized Map zza() {
        Map map;
        synchronized (zzj.class) {
            map = zza;
            map.put("java", 20002);
        }
        return map;
    }
}
