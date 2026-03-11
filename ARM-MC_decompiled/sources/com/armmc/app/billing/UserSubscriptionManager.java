package com.armmc.app.billing;

import android.util.Log;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: UserSubscriptionManager.kt */
/* MODIFIED: All Firebase removed, always returns supporter=true */
public final class UserSubscriptionManager {
    public static final String FIELD_CREATED_AT = "createdAt";
    public static final String FIELD_EMAIL = "email";
    public static final String FIELD_IS_SUPPORTER = "isSupporter";
    public static final String FIELD_SUBSCRIPTION_EXPIRY = "subscriptionExpiry";
    public static final String FIELD_SUBSCRIPTION_TOKEN = "subscriptionToken";
    public static final String FIELD_UPDATED_AT = "updatedAt";
    public static final UserSubscriptionManager INSTANCE = new UserSubscriptionManager();
    private static final String TAG = "UserSubscriptionManager";
    private static final String USERS_COLLECTION = "users";

    private UserSubscriptionManager() {
    }

    public static /* synthetic */ void initializeUserDocument$default(UserSubscriptionManager userSubscriptionManager, Object firebaseUser, Function1 function1, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = null;
        }
        userSubscriptionManager.initializeUserDocument(firebaseUser, function1);
    }

    public final void initializeUserDocument(Object firebaseUser, Function1<? super Boolean, Unit> function1) {
        Log.d(TAG, "initializeUserDocument - no-op, Firebase removed");
        if (function1 != null) {
            function1.invoke(true);
        }
    }

    public final void getSubscriptionStatus(Function1<? super Boolean, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "onResult");
        /* Always return supporter=true */
        function1.invoke(true);
    }

    public final void listenToSubscriptionStatus(Function1<? super Boolean, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "onStatusChanged");
        /* Always report supporter=true */
        function1.invoke(true);
    }

    /* Stub: returns null since no Firebase listener */
    public final Object listenToSubscriptionStatus2(Function1<? super Boolean, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "onStatusChanged");
        function1.invoke(true);
        return null;
    }
}
