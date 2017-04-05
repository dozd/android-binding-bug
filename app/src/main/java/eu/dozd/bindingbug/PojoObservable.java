package eu.dozd.bindingbug;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

public class PojoObservable extends BaseObservable {
    private String text;

    @Bindable
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
        notifyPropertyChanged(BR.text);
    }
}
