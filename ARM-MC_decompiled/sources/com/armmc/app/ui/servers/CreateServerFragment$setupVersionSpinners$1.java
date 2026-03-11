package com.armmc.app.ui.servers;

import android.view.View;
import android.widget.AdapterView;
import com.armmc.app.AvailableVersions;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

@Metadata(d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J0\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0016\u0010\f\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0005H\u0016¨\u0006\r"}, d2 = {"com/armmc/app/ui/servers/CreateServerFragment$setupVersionSpinners$1", "Landroid/widget/AdapterView$OnItemSelectedListener;", "onItemSelected", "", "parent", "Landroid/widget/AdapterView;", "view", "Landroid/view/View;", "position", "", "id", "", "onNothingSelected", "app_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* compiled from: CreateServerFragment.kt */
public final class CreateServerFragment$setupVersionSpinners$1 implements AdapterView.OnItemSelectedListener {
    final /* synthetic */ List<AvailableVersions.PumpkinVersion> $versions;
    final /* synthetic */ CreateServerFragment this$0;

    CreateServerFragment$setupVersionSpinners$1(CreateServerFragment createServerFragment, List<AvailableVersions.PumpkinVersion> list) {
        this.this$0 = createServerFragment;
        this.$versions = list;
    }

    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
        this.this$0.selectedVersion = (AvailableVersions.PumpkinVersion) CollectionsKt.getOrNull(this.$versions, i);
    }

    public void onNothingSelected(AdapterView<?> adapterView) {
        this.this$0.selectedVersion = null;
    }
}
