package com.armmc.app.ui.servers;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/armmc/app/ui/servers/ServersViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "_text", "Landroidx/lifecycle/MutableLiveData;", "", "text", "Landroidx/lifecycle/LiveData;", "getText", "()Landroidx/lifecycle/LiveData;", "app_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* compiled from: ServersViewModel.kt */
public final class ServersViewModel extends ViewModel {
    private final MutableLiveData<String> _text;
    private final LiveData<String> text;

    public ServersViewModel() {
        MutableLiveData<String> mutableLiveData = new MutableLiveData<>();
        mutableLiveData.setValue("This is home Fragment");
        this._text = mutableLiveData;
        this.text = mutableLiveData;
    }

    public final LiveData<String> getText() {
        return this.text;
    }
}
