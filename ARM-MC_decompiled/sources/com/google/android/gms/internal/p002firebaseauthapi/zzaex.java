package com.google.android.gms.internal.p002firebaseauthapi;

import java.lang.reflect.Type;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaex  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
public class zzaex {
    public static Object zza(String str, Type type) throws zzacn {
        if (type == String.class) {
            try {
                zzagt zzagt = (zzagt) new zzagt().zza(str);
                if (zzagt.zzb()) {
                    return zzagt.zza();
                }
                throw new zzacn("No error message: " + str);
            } catch (Exception e) {
                throw new zzacn("Json conversion failed! " + e.getMessage(), e);
            }
        } else if (type == Void.class) {
            return null;
        } else {
            try {
                try {
                    return ((zzaez) ((Class) type).getConstructor(new Class[0]).newInstance(new Object[0])).zza(str);
                } catch (Exception e2) {
                    throw new zzacn("Json conversion failed! " + e2.getMessage(), e2);
                }
            } catch (Exception e3) {
                throw new zzacn("Instantiation of JsonResponse failed! " + String.valueOf(type), e3);
            }
        }
    }

    private zzaex() {
    }
}
