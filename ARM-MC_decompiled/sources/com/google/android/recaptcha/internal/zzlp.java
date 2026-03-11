package com.google.android.recaptcha.internal;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.6.1 */
final class zzlp implements zznh {
    static final zznh zza = new zzlp();

    private zzlp() {
    }

    public final boolean zza(int i) {
        zzlq zzlq;
        zzlq zzlq2 = zzlq.EDITION_UNKNOWN;
        if (i == 0) {
            zzlq = zzlq.EDITION_UNKNOWN;
        } else if (i == 1) {
            zzlq = zzlq.EDITION_1_TEST_ONLY;
        } else if (i == 2) {
            zzlq = zzlq.EDITION_2_TEST_ONLY;
        } else if (i == 900) {
            zzlq = zzlq.EDITION_LEGACY;
        } else if (i != Integer.MAX_VALUE) {
            switch (i) {
                case EDITION_PROTO2_VALUE:
                    zzlq = zzlq.EDITION_PROTO2;
                    break;
                case 999:
                    zzlq = zzlq.EDITION_PROTO3;
                    break;
                case 1000:
                    zzlq = zzlq.EDITION_2023;
                    break;
                case 1001:
                    zzlq = zzlq.EDITION_2024;
                    break;
                default:
                    switch (i) {
                        case EDITION_99997_TEST_ONLY_VALUE:
                            zzlq = zzlq.EDITION_99997_TEST_ONLY;
                            break;
                        case EDITION_99998_TEST_ONLY_VALUE:
                            zzlq = zzlq.EDITION_99998_TEST_ONLY;
                            break;
                        case EDITION_99999_TEST_ONLY_VALUE:
                            zzlq = zzlq.EDITION_99999_TEST_ONLY;
                            break;
                        default:
                            zzlq = null;
                            break;
                    }
            }
        } else {
            zzlq = zzlq.EDITION_MAX;
        }
        return zzlq != null;
    }
}
