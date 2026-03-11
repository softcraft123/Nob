package com.armmc.app.util;

import java.util.Locale;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u000fB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u0006J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\u00062\u0006\u0010\n\u001a\u00020\u0006H\u0002J\u001c\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u00060\r2\u0006\u0010\n\u001a\u00020\u0006R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/armmc/app/util/SubdomainValidator;", "", "<init>", "()V", "profanityList", "", "", "reservedSubdomains", "validate", "Lcom/armmc/app/util/SubdomainValidator$ValidationResult;", "subdomain", "containsProfanity", "getRealtimeHint", "Lkotlin/Pair;", "", "ValidationResult", "app_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* compiled from: SubdomainValidator.kt */
public final class SubdomainValidator {
    public static final SubdomainValidator INSTANCE = new SubdomainValidator();
    private static final Set<String> profanityList = SetsKt.setOf("fuck", "shit", "ass", "bitch", "damn", "cunt", "dick", "cock", "pussy", "bastard", "whore", "slut", "fag", "faggot", "nigger", "nigga", "retard", "porn", "xxx", "sex", "sexy", "nude", "naked", "penis", "vagina", "anus", "dildo", "cum", "jizz", "wank", "masturbat", "orgasm", "erotic", "hentai", "f4ck", "sh1t", "b1tch", "d1ck", "c0ck", "p0rn", "s3x", "a55", "azz", "fuk", "fuq", "phuck", "phuk", "fck", "sht", "btch", "dck", "pnis", "nazi", "hitler", "holocaust", BillingClient.FeatureType.EXTERNAL_OFFER, "rape", "pedo", "pedophile", "molest", "terrorist", "jihad", "kill", "murder", "suicide", "bomb", "hacker", "cheater", "exploit", "crack", "warez", "pirat");
    private static final Set<String> reservedSubdomains = SetsKt.setOf("www", "api", "app", "admin", "dashboard", "mail", "email", "ftp", "ssh", "vpn", "vps", "server", "host", "dns", "ns1", "ns2", "test", "dev", "staging", "prod", "production", "beta", "alpha", "arm", "armmc", "witherhost", "minecraft", "mc", "play", "game", "support", "help", "billing", "account", "login", "signup", "tunnel", "tunnels", "proxy", "frp", "frps", "frpc", "official", "mojang", "microsoft", "notch", "jeb");

    private SubdomainValidator() {
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J+\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00032\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/armmc/app/util/SubdomainValidator$ValidationResult;", "", "isValid", "", "normalizedSubdomain", "", "errorMessage", "<init>", "(ZLjava/lang/String;Ljava/lang/String;)V", "()Z", "getNormalizedSubdomain", "()Ljava/lang/String;", "getErrorMessage", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* compiled from: SubdomainValidator.kt */
    public static final class ValidationResult {
        private final String errorMessage;
        private final boolean isValid;
        private final String normalizedSubdomain;

        public static /* synthetic */ ValidationResult copy$default(ValidationResult validationResult, boolean z, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                z = validationResult.isValid;
            }
            if ((i & 2) != 0) {
                str = validationResult.normalizedSubdomain;
            }
            if ((i & 4) != 0) {
                str2 = validationResult.errorMessage;
            }
            return validationResult.copy(z, str, str2);
        }

        public final boolean component1() {
            return this.isValid;
        }

        public final String component2() {
            return this.normalizedSubdomain;
        }

        public final String component3() {
            return this.errorMessage;
        }

        public final ValidationResult copy(boolean z, String str, String str2) {
            return new ValidationResult(z, str, str2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ValidationResult)) {
                return false;
            }
            ValidationResult validationResult = (ValidationResult) obj;
            return this.isValid == validationResult.isValid && Intrinsics.areEqual((Object) this.normalizedSubdomain, (Object) validationResult.normalizedSubdomain) && Intrinsics.areEqual((Object) this.errorMessage, (Object) validationResult.errorMessage);
        }

        public int hashCode() {
            int hashCode = Boolean.hashCode(this.isValid) * 31;
            String str = this.normalizedSubdomain;
            int i = 0;
            int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.errorMessage;
            if (str2 != null) {
                i = str2.hashCode();
            }
            return hashCode2 + i;
        }

        public String toString() {
            boolean z = this.isValid;
            String str = this.normalizedSubdomain;
            return "ValidationResult(isValid=" + z + ", normalizedSubdomain=" + str + ", errorMessage=" + this.errorMessage + ")";
        }

        public ValidationResult(boolean z, String str, String str2) {
            this.isValid = z;
            this.normalizedSubdomain = str;
            this.errorMessage = str2;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ ValidationResult(boolean z, String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(z, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : str2);
        }

        public final boolean isValid() {
            return this.isValid;
        }

        public final String getNormalizedSubdomain() {
            return this.normalizedSubdomain;
        }

        public final String getErrorMessage() {
            return this.errorMessage;
        }
    }

    public final ValidationResult validate(String str) {
        CharSequence charSequence = str;
        if (charSequence == null || StringsKt.isBlank(charSequence)) {
            return new ValidationResult(false, (String) null, "Subdomain is required", 2, (DefaultConstructorMarker) null);
        }
        String lowerCase = str.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        String obj = StringsKt.trim((CharSequence) lowerCase).toString();
        if (obj.length() < 3) {
            return new ValidationResult(false, (String) null, "Subdomain must be at least 3 characters", 2, (DefaultConstructorMarker) null);
        }
        if (obj.length() > 20) {
            return new ValidationResult(false, (String) null, "Subdomain must be 20 characters or less", 2, (DefaultConstructorMarker) null);
        }
        CharSequence charSequence2 = obj;
        if (!new Regex("^[a-z0-9-]+$").matches(charSequence2)) {
            return new ValidationResult(false, (String) null, "Only letters, numbers, and hyphens allowed", 2, (DefaultConstructorMarker) null);
        }
        if (StringsKt.startsWith$default(obj, "-", false, 2, (Object) null) || StringsKt.endsWith$default(obj, "-", false, 2, (Object) null)) {
            return new ValidationResult(false, (String) null, "Cannot start or end with a hyphen", 2, (DefaultConstructorMarker) null);
        }
        if (StringsKt.contains$default(charSequence2, (CharSequence) "--", false, 2, (Object) null)) {
            return new ValidationResult(false, (String) null, "Cannot contain consecutive hyphens", 2, (DefaultConstructorMarker) null);
        }
        if (reservedSubdomains.contains(obj)) {
            return new ValidationResult(false, (String) null, "This subdomain is reserved", 2, (DefaultConstructorMarker) null);
        }
        if (containsProfanity(obj) != null) {
            return new ValidationResult(false, (String) null, "Subdomain contains inappropriate content", 2, (DefaultConstructorMarker) null);
        }
        return new ValidationResult(true, obj, (String) null, 4, (DefaultConstructorMarker) null);
    }

    /* JADX WARNING: Removed duplicated region for block: B:3:0x0028  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.lang.String containsProfanity(java.lang.String r9) {
        /*
            r8 = this;
            r4 = 4
            r5 = 0
            java.lang.String r1 = "-"
            java.lang.String r2 = ""
            r3 = 0
            r0 = r9
            java.lang.String r9 = kotlin.text.StringsKt.replace$default((java.lang.String) r0, (java.lang.String) r1, (java.lang.String) r2, (boolean) r3, (int) r4, (java.lang.Object) r5)
            java.lang.CharSequence r9 = (java.lang.CharSequence) r9
            kotlin.text.Regex r1 = new kotlin.text.Regex
            java.lang.String r2 = "[0-9]"
            r1.<init>((java.lang.String) r2)
            java.lang.String r2 = ""
            java.lang.String r9 = r1.replace((java.lang.CharSequence) r9, (java.lang.String) r2)
            java.util.Set<java.lang.String> r1 = profanityList
            java.util.Iterator r1 = r1.iterator()
        L_0x0021:
            boolean r2 = r1.hasNext()
            r3 = 0
            if (r2 == 0) goto L_0x0046
            java.lang.Object r2 = r1.next()
            java.lang.String r2 = (java.lang.String) r2
            r4 = r0
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            r5 = r2
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            r6 = 0
            r7 = 2
            boolean r4 = kotlin.text.StringsKt.contains$default((java.lang.CharSequence) r4, (java.lang.CharSequence) r5, (boolean) r6, (int) r7, (java.lang.Object) r3)
            if (r4 != 0) goto L_0x0045
            r4 = r9
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            boolean r3 = kotlin.text.StringsKt.contains$default((java.lang.CharSequence) r4, (java.lang.CharSequence) r5, (boolean) r6, (int) r7, (java.lang.Object) r3)
            if (r3 == 0) goto L_0x0021
        L_0x0045:
            return r2
        L_0x0046:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.armmc.app.util.SubdomainValidator.containsProfanity(java.lang.String):java.lang.String");
    }

    public final Pair<Boolean, String> getRealtimeHint(String str) {
        Intrinsics.checkNotNullParameter(str, "subdomain");
        if (str.length() == 0) {
            return new Pair<>(true, null);
        }
        String lowerCase = str.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        CharSequence charSequence = lowerCase;
        if (!new Regex("^[a-z0-9-]*$").matches(charSequence)) {
            return new Pair<>(false, "Only letters, numbers, and hyphens allowed");
        }
        if (StringsKt.startsWith$default(lowerCase, "-", false, 2, (Object) null)) {
            return new Pair<>(false, "Cannot start with a hyphen");
        }
        if (StringsKt.contains$default(charSequence, (CharSequence) "--", false, 2, (Object) null)) {
            return new Pair<>(false, "Cannot have consecutive hyphens");
        }
        if (lowerCase.length() < 3) {
            return new Pair<>(true, "At least 3 characters required");
        }
        if (lowerCase.length() > 20) {
            return new Pair<>(false, "Maximum 20 characters allowed");
        }
        if (containsProfanity(lowerCase) != null) {
            return new Pair<>(false, "Contains inappropriate content");
        }
        if (reservedSubdomains.contains(lowerCase)) {
            return new Pair<>(false, "This subdomain is reserved");
        }
        return new Pair<>(true, null);
    }
}
