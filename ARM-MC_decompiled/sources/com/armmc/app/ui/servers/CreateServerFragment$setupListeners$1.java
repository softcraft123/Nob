package com.armmc.app.ui.servers;

import android.widget.SeekBar;
import android.widget.TextView;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

@Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0012\u0010\n\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u000b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\f"}, d2 = {"com/armmc/app/ui/servers/CreateServerFragment$setupListeners$1", "Landroid/widget/SeekBar$OnSeekBarChangeListener;", "onProgressChanged", "", "seekBar", "Landroid/widget/SeekBar;", "progress", "", "fromUser", "", "onStartTrackingTouch", "onStopTrackingTouch", "app_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* compiled from: CreateServerFragment.kt */
public final class CreateServerFragment$setupListeners$1 implements SeekBar.OnSeekBarChangeListener {
    final /* synthetic */ CreateServerFragment this$0;

    public void onStartTrackingTouch(SeekBar seekBar) {
    }

    public void onStopTrackingTouch(SeekBar seekBar) {
    }

    CreateServerFragment$setupListeners$1(CreateServerFragment createServerFragment) {
        this.this$0 = createServerFragment;
    }

    public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
        double d = ((double) i) * 0.5d;
        TextView access$getMemoryValueText$p = this.this$0.memoryValueText;
        if (access$getMemoryValueText$p == null) {
            Intrinsics.throwUninitializedPropertyAccessException("memoryValueText");
            access$getMemoryValueText$p = null;
        }
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format("%.1f GB", Arrays.copyOf(new Object[]{Double.valueOf(d)}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(...)");
        access$getMemoryValueText$p.setText(format);
    }
}
