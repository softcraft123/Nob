package com.armmc.app.ui.servers;

import android.widget.TextView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"com/armmc/app/ui/servers/MotdBuilderDialog$startObfuscatedAnimation$1", "Ljava/lang/Runnable;", "run", "", "app_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* compiled from: MotdBuilderDialog.kt */
public final class MotdBuilderDialog$startObfuscatedAnimation$1 implements Runnable {
    final /* synthetic */ String $text;
    final /* synthetic */ MotdBuilderDialog this$0;

    MotdBuilderDialog$startObfuscatedAnimation$1(MotdBuilderDialog motdBuilderDialog, String str) {
        this.this$0 = motdBuilderDialog;
        this.$text = str;
    }

    public void run() {
        if (this.this$0.isAdded() && this.this$0.getView() != null) {
            TextView access$getMotdPreview$p = this.this$0.motdPreview;
            if (access$getMotdPreview$p == null) {
                Intrinsics.throwUninitializedPropertyAccessException("motdPreview");
                access$getMotdPreview$p = null;
            }
            access$getMotdPreview$p.setText(MinecraftTextFormatter.INSTANCE.format(this.$text, true));
            this.this$0.obfuscateHandler.postDelayed(this, 50);
        }
    }
}
