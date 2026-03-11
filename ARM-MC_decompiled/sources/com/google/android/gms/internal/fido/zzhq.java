package com.google.android.gms.internal.fido;

import java.io.IOException;
import java.io.InputStream;
import java.util.TreeMap;

/* compiled from: com.google.android.gms:play-services-fido@@21.0.0 */
final class zzhq {
    static final zzhp zza(InputStream inputStream, zzhs zzhs) throws zzhj {
        try {
            return zzb(inputStream, zzhs);
        } finally {
            try {
                zzhs.close();
            } catch (IOException unused) {
            }
        }
    }

    private static final zzhp zzb(InputStream inputStream, zzhs zzhs) throws zzhj {
        try {
            zzhr zzd = zzhs.zzd();
            if (zzd != null) {
                try {
                    byte zza = zzd.zza();
                    byte zzb = zzd.zzb();
                    int i = 0;
                    if (zzb == Byte.MIN_VALUE) {
                        long zza2 = zzhs.zza();
                        if (zza2 <= 1000) {
                            zzc(zza, zza2, inputStream, zzhs);
                            zzhp[] zzhpArr = new zzhp[((int) zza2)];
                            while (((long) i) < zza2) {
                                zzhpArr[i] = zzb(inputStream, zzhs);
                                i++;
                            }
                            return new zzhg(zzcc.zzi(zzhpArr));
                        }
                        throw new zzhj("Parser being asked to read a large CBOR array");
                    } else if (zzb == -96) {
                        long zzc = zzhs.zzc();
                        if (zzc <= 1000) {
                            zzc(zza, zzc, inputStream, zzhs);
                            int i2 = (int) zzc;
                            zzhl[] zzhlArr = new zzhl[i2];
                            zzhp zzhp = null;
                            int i3 = 0;
                            while (((long) i3) < zzc) {
                                zzhp zzb2 = zzb(inputStream, zzhs);
                                if (zzhp != null) {
                                    if (zzb2.compareTo(zzhp) <= 0) {
                                        throw new zzhf(String.format("Keys in CBOR Map not in strictly ascending natural order:\nPrevious key: %s\nCurrent key: %s", new Object[]{zzhp.toString(), zzb2.toString()}));
                                    }
                                }
                                zzhlArr[i3] = new zzhl(zzb2, zzb(inputStream, zzhs));
                                i3++;
                                zzhp = zzb2;
                            }
                            TreeMap treeMap = new TreeMap();
                            while (i < i2) {
                                zzhl zzhl = zzhlArr[i];
                                if (!treeMap.containsKey(zzhl.zza())) {
                                    treeMap.put(zzhl.zza(), zzhl.zzb());
                                    i++;
                                } else {
                                    throw new zzhf("Attempted to add duplicate key to canonical CBOR Map.");
                                }
                            }
                            return new zzhm(zzcj.zzf(treeMap));
                        }
                        throw new zzhj("Parser being asked to read a large CBOR map");
                    } else if (zzb == -64) {
                        throw new zzhj("Tags are currently unsupported");
                    } else if (zzb == -32) {
                        return new zzhh(zzhs.zzf());
                    } else {
                        if (zzb == 0 || zzb == 32) {
                            long zzb3 = zzhs.zzb();
                            zzc(zza, zzb3 > 0 ? zzb3 : ~zzb3, inputStream, zzhs);
                            return new zzhk(zzb3);
                        } else if (zzb == 64) {
                            byte[] zzg = zzhs.zzg();
                            int length = zzg.length;
                            zzc(zza, (long) length, inputStream, zzhs);
                            return new zzhi(zzgx.zzl(zzg, 0, length));
                        } else if (zzb == 96) {
                            String zze = zzhs.zze();
                            zzc(zza, (long) zze.length(), inputStream, zzhs);
                            return new zzhn(zze);
                        } else {
                            throw new zzhj("Unidentifiable major type: " + zzd.zzc());
                        }
                    }
                } catch (IOException | RuntimeException e) {
                    throw new zzhj("Error in decoding CborValue from bytes", e);
                }
            } else {
                throw new zzhj("Parser being asked to parse an empty input stream");
            }
        } catch (IOException e2) {
            throw new zzhj("Error in decoding CborValue from bytes", e2);
        }
    }

    private static final void zzc(byte b, long j, InputStream inputStream, zzhs zzhs) throws IOException {
        switch (b) {
            case 24:
                if (j < 24) {
                    throw new zzhf("Integer value " + j + " after add info could have been represented in 0 additional bytes, but used 1");
                }
                return;
            case 25:
                if (j < 256) {
                    throw new zzhf("Integer value " + j + " after add info could have been represented in 0-1 additional bytes, but used 2");
                }
                return;
            case 26:
                if (j < 65536) {
                    throw new zzhf("Integer value " + j + " after add info could have been represented in 0-2 additional bytes, but used 4");
                }
                return;
            case 27:
                if (j < 4294967296L) {
                    throw new zzhf("Integer value " + j + " after add info could have been represented in 0-4 additional bytes, but used 8");
                }
                return;
            default:
                return;
        }
    }
}
