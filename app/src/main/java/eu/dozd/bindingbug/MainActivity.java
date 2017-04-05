package eu.dozd.bindingbug;

import android.databinding.DataBindingUtil;
import android.databinding.ObservableField;
import android.databinding.ViewDataBinding;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import eu.dozd.bindingbug.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ObservableField<PojoObservable> model = new ObservableField<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        PojoObservable pojo = new PojoObservable();
        pojo.setText("Click the button");
        model.set(pojo);

        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setActivity(this);
    }

    public void buttonClicked() {
        model.get().setText("Hello world");
    }

    public ObservableField<PojoObservable> getModel() {
        return model;
    }
}
