package com.pairip.licensecheck;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class LicenseClient$$ExternalSyntheticLambda9 implements Runnable {
    public final /* synthetic */ LicenseClient f$0;
    public final /* synthetic */ RepeatedCheckMetadata f$1;

    public /* synthetic */ LicenseClient$$ExternalSyntheticLambda9(LicenseClient licenseClient, RepeatedCheckMetadata repeatedCheckMetadata) {
        this.f$0 = licenseClient;
        this.f$1 = repeatedCheckMetadata;
    }

    public final void run() {
        this.f$0.lambda$scheduleRepeatedLicenseCheck$0(this.f$1);
    }
}
