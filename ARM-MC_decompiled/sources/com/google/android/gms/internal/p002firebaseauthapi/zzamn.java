package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.firebase.firestore.model.Values;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import kotlin.text.Typography;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzamn  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
final class zzamn {
    private static final char[] zza;

    static String zza(zzamm zzamm, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("# ").append(str);
        zza(zzamm, sb, 0);
        return sb.toString();
    }

    static {
        char[] cArr = new char[80];
        zza = cArr;
        Arrays.fill(cArr, ' ');
    }

    private static void zza(int i, StringBuilder sb) {
        while (i > 0) {
            char[] cArr = zza;
            int length = i > cArr.length ? cArr.length : i;
            sb.append(cArr, 0, length);
            i -= length;
        }
    }

    static void zza(StringBuilder sb, int i, String str, Object obj) {
        if (obj instanceof List) {
            for (Object zza2 : (List) obj) {
                zza(sb, i, str, zza2);
            }
        } else if (obj instanceof Map) {
            for (Map.Entry zza3 : ((Map) obj).entrySet()) {
                zza(sb, i, str, zza3);
            }
        } else {
            sb.append(10);
            zza(i, sb);
            if (!str.isEmpty()) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(Character.toLowerCase(str.charAt(0)));
                for (int i2 = 1; i2 < str.length(); i2++) {
                    char charAt = str.charAt(i2);
                    if (Character.isUpperCase(charAt)) {
                        sb2.append("_");
                    }
                    sb2.append(Character.toLowerCase(charAt));
                }
                str = sb2.toString();
            }
            sb.append(str);
            if (obj instanceof String) {
                sb.append(": \"").append(zzann.zza(zzajv.zza((String) obj))).append(Typography.quote);
            } else if (obj instanceof zzajv) {
                sb.append(": \"").append(zzann.zza((zzajv) obj)).append(Typography.quote);
            } else if (obj instanceof zzalf) {
                sb.append(" {");
                zza((zzalf) obj, sb, i + 2);
                sb.append("\n");
                zza(i, sb);
                sb.append("}");
            } else if (obj instanceof Map.Entry) {
                sb.append(" {");
                Map.Entry entry = (Map.Entry) obj;
                int i3 = i + 2;
                zza(sb, i3, "key", entry.getKey());
                zza(sb, i3, Values.VECTOR_MAP_VECTORS_KEY, entry.getValue());
                sb.append("\n");
                zza(i, sb);
                sb.append("}");
            } else {
                sb.append(": ").append(obj);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:62:0x0199, code lost:
        if (((java.lang.Boolean) r7).booleanValue() == false) goto L_0x019b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x01ac, code lost:
        if (((java.lang.Integer) r7).intValue() == 0) goto L_0x019b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x01be, code lost:
        if (java.lang.Float.floatToRawIntBits(((java.lang.Float) r7).floatValue()) == 0) goto L_0x019b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x01d4, code lost:
        if (java.lang.Double.doubleToRawLongBits(((java.lang.Double) r7).doubleValue()) == 0) goto L_0x019b;
     */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x020c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void zza(com.google.android.gms.internal.p002firebaseauthapi.zzamm r21, java.lang.StringBuilder r22, int r23) {
        /*
            r0 = r21
            r1 = r22
            r2 = r23
            java.util.HashSet r3 = new java.util.HashSet
            r3.<init>()
            java.util.HashMap r4 = new java.util.HashMap
            r4.<init>()
            java.util.TreeMap r5 = new java.util.TreeMap
            r5.<init>()
            java.lang.Class r6 = r0.getClass()
            java.lang.reflect.Method[] r6 = r6.getDeclaredMethods()
            int r7 = r6.length
            r8 = 0
            r9 = r8
        L_0x0020:
            java.lang.String r10 = "get"
            java.lang.String r11 = "has"
            java.lang.String r12 = "set"
            r13 = 3
            if (r9 >= r7) goto L_0x0088
            r14 = r6[r9]
            int r15 = r14.getModifiers()
            boolean r15 = java.lang.reflect.Modifier.isStatic(r15)
            if (r15 != 0) goto L_0x0085
            java.lang.String r15 = r14.getName()
            int r15 = r15.length()
            if (r15 < r13) goto L_0x0085
            java.lang.String r13 = r14.getName()
            boolean r12 = r13.startsWith(r12)
            if (r12 == 0) goto L_0x0051
            java.lang.String r10 = r14.getName()
            r3.add(r10)
            goto L_0x0085
        L_0x0051:
            int r12 = r14.getModifiers()
            boolean r12 = java.lang.reflect.Modifier.isPublic(r12)
            if (r12 == 0) goto L_0x0085
            java.lang.Class[] r12 = r14.getParameterTypes()
            int r12 = r12.length
            if (r12 != 0) goto L_0x0085
            java.lang.String r12 = r14.getName()
            boolean r11 = r12.startsWith(r11)
            if (r11 == 0) goto L_0x0074
            java.lang.String r10 = r14.getName()
            r4.put(r10, r14)
            goto L_0x0085
        L_0x0074:
            java.lang.String r11 = r14.getName()
            boolean r10 = r11.startsWith(r10)
            if (r10 == 0) goto L_0x0085
            java.lang.String r10 = r14.getName()
            r5.put(r10, r14)
        L_0x0085:
            int r9 = r9 + 1
            goto L_0x0020
        L_0x0088:
            java.util.Set r6 = r5.entrySet()
            java.util.Iterator r6 = r6.iterator()
        L_0x0090:
            boolean r7 = r6.hasNext()
            if (r7 == 0) goto L_0x0223
            java.lang.Object r7 = r6.next()
            java.util.Map$Entry r7 = (java.util.Map.Entry) r7
            java.lang.Object r9 = r7.getKey()
            java.lang.String r9 = (java.lang.String) r9
            java.lang.String r9 = r9.substring(r13)
            java.lang.String r14 = "List"
            boolean r15 = r9.endsWith(r14)
            if (r15 == 0) goto L_0x00e7
            java.lang.String r15 = "OrBuilderList"
            boolean r15 = r9.endsWith(r15)
            if (r15 != 0) goto L_0x00e7
            boolean r14 = r9.equals(r14)
            if (r14 != 0) goto L_0x00e7
            java.lang.Object r14 = r7.getValue()
            java.lang.reflect.Method r14 = (java.lang.reflect.Method) r14
            if (r14 == 0) goto L_0x00e7
            java.lang.Class r15 = r14.getReturnType()
            r16 = r13
            java.lang.Class<java.util.List> r13 = java.util.List.class
            boolean r13 = r15.equals(r13)
            if (r13 == 0) goto L_0x00e9
            int r7 = r9.length()
            int r7 = r7 + -4
            java.lang.String r7 = r9.substring(r8, r7)
            java.lang.Object[] r9 = new java.lang.Object[r8]
            java.lang.Object r9 = com.google.android.gms.internal.p002firebaseauthapi.zzalf.zza((java.lang.reflect.Method) r14, (java.lang.Object) r0, (java.lang.Object[]) r9)
            zza(r1, r2, r7, r9)
            goto L_0x021f
        L_0x00e7:
            r16 = r13
        L_0x00e9:
            java.lang.String r13 = "Map"
            boolean r14 = r9.endsWith(r13)
            if (r14 == 0) goto L_0x0132
            boolean r13 = r9.equals(r13)
            if (r13 != 0) goto L_0x0132
            java.lang.Object r13 = r7.getValue()
            java.lang.reflect.Method r13 = (java.lang.reflect.Method) r13
            if (r13 == 0) goto L_0x0132
            java.lang.Class r14 = r13.getReturnType()
            java.lang.Class<java.util.Map> r15 = java.util.Map.class
            boolean r14 = r14.equals(r15)
            if (r14 == 0) goto L_0x0132
            java.lang.Class<java.lang.Deprecated> r14 = java.lang.Deprecated.class
            boolean r14 = r13.isAnnotationPresent(r14)
            if (r14 != 0) goto L_0x0132
            int r14 = r13.getModifiers()
            boolean r14 = java.lang.reflect.Modifier.isPublic(r14)
            if (r14 == 0) goto L_0x0132
            int r7 = r9.length()
            int r7 = r7 + -3
            java.lang.String r7 = r9.substring(r8, r7)
            java.lang.Object[] r9 = new java.lang.Object[r8]
            java.lang.Object r9 = com.google.android.gms.internal.p002firebaseauthapi.zzalf.zza((java.lang.reflect.Method) r13, (java.lang.Object) r0, (java.lang.Object[]) r9)
            zza(r1, r2, r7, r9)
            goto L_0x021f
        L_0x0132:
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>(r12)
            java.lang.StringBuilder r13 = r13.append(r9)
            java.lang.String r13 = r13.toString()
            boolean r13 = r3.contains(r13)
            if (r13 == 0) goto L_0x021f
            java.lang.String r13 = "Bytes"
            boolean r13 = r9.endsWith(r13)
            if (r13 == 0) goto L_0x016a
            int r13 = r9.length()
            int r13 = r13 + -5
            java.lang.String r13 = r9.substring(r8, r13)
            java.lang.StringBuilder r14 = new java.lang.StringBuilder
            r14.<init>(r10)
            java.lang.StringBuilder r13 = r14.append(r13)
            java.lang.String r13 = r13.toString()
            boolean r13 = r5.containsKey(r13)
            if (r13 != 0) goto L_0x021f
        L_0x016a:
            java.lang.Object r7 = r7.getValue()
            java.lang.reflect.Method r7 = (java.lang.reflect.Method) r7
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>(r11)
            java.lang.StringBuilder r13 = r13.append(r9)
            java.lang.String r13 = r13.toString()
            java.lang.Object r13 = r4.get(r13)
            java.lang.reflect.Method r13 = (java.lang.reflect.Method) r13
            if (r7 == 0) goto L_0x021f
            java.lang.Object[] r14 = new java.lang.Object[r8]
            java.lang.Object r7 = com.google.android.gms.internal.p002firebaseauthapi.zzalf.zza((java.lang.reflect.Method) r7, (java.lang.Object) r0, (java.lang.Object[]) r14)
            if (r13 != 0) goto L_0x020e
            boolean r13 = r7 instanceof java.lang.Boolean
            r14 = 1
            if (r13 == 0) goto L_0x01a1
            r13 = r7
            java.lang.Boolean r13 = (java.lang.Boolean) r13
            boolean r13 = r13.booleanValue()
            if (r13 != 0) goto L_0x019e
        L_0x019b:
            r13 = r14
            goto L_0x0209
        L_0x019e:
            r13 = r8
            goto L_0x0209
        L_0x01a1:
            boolean r13 = r7 instanceof java.lang.Integer
            if (r13 == 0) goto L_0x01af
            r13 = r7
            java.lang.Integer r13 = (java.lang.Integer) r13
            int r13 = r13.intValue()
            if (r13 != 0) goto L_0x019e
            goto L_0x019b
        L_0x01af:
            boolean r13 = r7 instanceof java.lang.Float
            if (r13 == 0) goto L_0x01c1
            r13 = r7
            java.lang.Float r13 = (java.lang.Float) r13
            float r13 = r13.floatValue()
            int r13 = java.lang.Float.floatToRawIntBits(r13)
            if (r13 != 0) goto L_0x019e
            goto L_0x019b
        L_0x01c1:
            boolean r13 = r7 instanceof java.lang.Double
            if (r13 == 0) goto L_0x01d7
            r13 = r7
            java.lang.Double r13 = (java.lang.Double) r13
            double r17 = r13.doubleValue()
            long r17 = java.lang.Double.doubleToRawLongBits(r17)
            r19 = 0
            int r13 = (r17 > r19 ? 1 : (r17 == r19 ? 0 : -1))
            if (r13 != 0) goto L_0x019e
            goto L_0x019b
        L_0x01d7:
            boolean r13 = r7 instanceof java.lang.String
            if (r13 == 0) goto L_0x01e2
            java.lang.String r13 = ""
            boolean r13 = r7.equals(r13)
            goto L_0x0209
        L_0x01e2:
            boolean r13 = r7 instanceof com.google.android.gms.internal.p002firebaseauthapi.zzajv
            if (r13 == 0) goto L_0x01ed
            com.google.android.gms.internal.firebase-auth-api.zzajv r13 = com.google.android.gms.internal.p002firebaseauthapi.zzajv.zza
            boolean r13 = r7.equals(r13)
            goto L_0x0209
        L_0x01ed:
            boolean r13 = r7 instanceof com.google.android.gms.internal.p002firebaseauthapi.zzamm
            if (r13 == 0) goto L_0x01fb
            r13 = r7
            com.google.android.gms.internal.firebase-auth-api.zzamm r13 = (com.google.android.gms.internal.p002firebaseauthapi.zzamm) r13
            com.google.android.gms.internal.firebase-auth-api.zzamm r13 = r13.zzs()
            if (r7 != r13) goto L_0x019e
            goto L_0x019b
        L_0x01fb:
            boolean r13 = r7 instanceof java.lang.Enum
            if (r13 == 0) goto L_0x019e
            r13 = r7
            java.lang.Enum r13 = (java.lang.Enum) r13
            int r13 = r13.ordinal()
            if (r13 != 0) goto L_0x019e
            goto L_0x019b
        L_0x0209:
            if (r13 != 0) goto L_0x020c
            goto L_0x021a
        L_0x020c:
            r14 = r8
            goto L_0x021a
        L_0x020e:
            java.lang.Object[] r14 = new java.lang.Object[r8]
            java.lang.Object r13 = com.google.android.gms.internal.p002firebaseauthapi.zzalf.zza((java.lang.reflect.Method) r13, (java.lang.Object) r0, (java.lang.Object[]) r14)
            java.lang.Boolean r13 = (java.lang.Boolean) r13
            boolean r14 = r13.booleanValue()
        L_0x021a:
            if (r14 == 0) goto L_0x021f
            zza(r1, r2, r9, r7)
        L_0x021f:
            r13 = r16
            goto L_0x0090
        L_0x0223:
            boolean r3 = r0 instanceof com.google.android.gms.internal.p002firebaseauthapi.zzalf.zzd
            if (r3 == 0) goto L_0x0249
            r3 = r0
            com.google.android.gms.internal.firebase-auth-api.zzalf$zzd r3 = (com.google.android.gms.internal.p002firebaseauthapi.zzalf.zzd) r3
            com.google.android.gms.internal.firebase-auth-api.zzakx<com.google.android.gms.internal.firebase-auth-api.zzalf$zzc> r3 = r3.zzc
            java.util.Iterator r3 = r3.zzd()
            boolean r4 = r3.hasNext()
            if (r4 != 0) goto L_0x0237
            goto L_0x0249
        L_0x0237:
            java.lang.Object r0 = r3.next()
            java.util.Map$Entry r0 = (java.util.Map.Entry) r0
            java.lang.Object r0 = r0.getKey()
            com.google.android.gms.internal.firebase-auth-api.zzalf$zzc r0 = (com.google.android.gms.internal.p002firebaseauthapi.zzalf.zzc) r0
            java.lang.NoSuchMethodError r0 = new java.lang.NoSuchMethodError
            r0.<init>()
            throw r0
        L_0x0249:
            com.google.android.gms.internal.firebase-auth-api.zzalf r0 = (com.google.android.gms.internal.p002firebaseauthapi.zzalf) r0
            com.google.android.gms.internal.firebase-auth-api.zzanx r3 = r0.zzb
            if (r3 == 0) goto L_0x0254
            com.google.android.gms.internal.firebase-auth-api.zzanx r0 = r0.zzb
            r0.zza((java.lang.StringBuilder) r1, (int) r2)
        L_0x0254:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.p002firebaseauthapi.zzamn.zza(com.google.android.gms.internal.firebase-auth-api.zzamm, java.lang.StringBuilder, int):void");
    }
}
