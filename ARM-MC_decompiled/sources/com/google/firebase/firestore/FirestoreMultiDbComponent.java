package com.google.firebase.firestore;

import android.content.Context;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseAppLifecycleListener;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.appcheck.interop.InteropAppCheckTokenProvider;
import com.google.firebase.auth.internal.InternalAuthProvider;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.remote.GrpcMetadataProvider;
import com.google.firebase.firestore.util.Assert;
import com.google.firebase.inject.Deferred;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

class FirestoreMultiDbComponent implements FirebaseAppLifecycleListener, FirebaseFirestore.InstanceRegistry {
    private final FirebaseApp app;
    private final Deferred<InteropAppCheckTokenProvider> appCheckProvider;
    private final Deferred<InternalAuthProvider> authProvider;
    private final Context context;
    private final Map<String, FirebaseFirestore> instances = new HashMap();
    private final GrpcMetadataProvider metadataProvider;

    FirestoreMultiDbComponent(Context context2, FirebaseApp firebaseApp, Deferred<InternalAuthProvider> deferred, Deferred<InteropAppCheckTokenProvider> deferred2, GrpcMetadataProvider grpcMetadataProvider) {
        this.context = context2;
        this.app = firebaseApp;
        this.authProvider = deferred;
        this.appCheckProvider = deferred2;
        this.metadataProvider = grpcMetadataProvider;
        firebaseApp.addLifecycleEventListener(this);
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0023, code lost:
        return r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized com.google.firebase.firestore.FirebaseFirestore get(java.lang.String r9) {
        /*
            r8 = this;
            monitor-enter(r8)
            java.util.Map<java.lang.String, com.google.firebase.firestore.FirebaseFirestore> r0 = r8.instances     // Catch:{ all -> 0x0024 }
            java.lang.Object r0 = r0.get(r9)     // Catch:{ all -> 0x0024 }
            com.google.firebase.firestore.FirebaseFirestore r0 = (com.google.firebase.firestore.FirebaseFirestore) r0     // Catch:{ all -> 0x0024 }
            if (r0 != 0) goto L_0x0021
            android.content.Context r1 = r8.context     // Catch:{ all -> 0x0024 }
            com.google.firebase.FirebaseApp r2 = r8.app     // Catch:{ all -> 0x0024 }
            com.google.firebase.inject.Deferred<com.google.firebase.auth.internal.InternalAuthProvider> r3 = r8.authProvider     // Catch:{ all -> 0x0024 }
            com.google.firebase.inject.Deferred<com.google.firebase.appcheck.interop.InteropAppCheckTokenProvider> r4 = r8.appCheckProvider     // Catch:{ all -> 0x0024 }
            com.google.firebase.firestore.remote.GrpcMetadataProvider r7 = r8.metadataProvider     // Catch:{ all -> 0x0024 }
            r6 = r8
            r5 = r9
            com.google.firebase.firestore.FirebaseFirestore r0 = com.google.firebase.firestore.FirebaseFirestore.newInstance(r1, r2, r3, r4, r5, r6, r7)     // Catch:{ all -> 0x0029 }
            java.util.Map<java.lang.String, com.google.firebase.firestore.FirebaseFirestore> r9 = r6.instances     // Catch:{ all -> 0x0029 }
            r9.put(r5, r0)     // Catch:{ all -> 0x0029 }
            goto L_0x0022
        L_0x0021:
            r6 = r8
        L_0x0022:
            monitor-exit(r8)
            return r0
        L_0x0024:
            r0 = move-exception
            r6 = r8
        L_0x0026:
            r9 = r0
            monitor-exit(r8)     // Catch:{ all -> 0x0029 }
            throw r9
        L_0x0029:
            r0 = move-exception
            goto L_0x0026
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.firestore.FirestoreMultiDbComponent.get(java.lang.String):com.google.firebase.firestore.FirebaseFirestore");
    }

    public synchronized void remove(String str) {
        this.instances.remove(str);
    }

    public synchronized void onDeleted(String str, FirebaseOptions firebaseOptions) {
        Iterator it = new ArrayList(this.instances.entrySet()).iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            ((FirebaseFirestore) entry.getValue()).terminate();
            Assert.hardAssert(!this.instances.containsKey(entry.getKey()), "terminate() should have removed its entry from `instances` for key: %s", entry.getKey());
        }
    }
}
