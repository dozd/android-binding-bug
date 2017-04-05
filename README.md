# Showcase of Android nested databinding bug

https://code.google.com/p/android/issues/detail?id=325969

After upgrading gradle plugin from 2.2.3 to 2.3.0 (2.3.1 as well), some databinding feature is broken.

When I have class extending `BaseObservable` inside `ObservableField` and make change to that class (calling `notifyPropertyChanged`), it is not propagated to the `ObservableField` and thus into view.

- run app
- click the button - nothing happends
- change version of gradle plugin to 2.2.3
- click the button - text is automatically changed

## More info

PojoObservable.java
```
public void setText(String text) {
        this.text = text;
        notifyPropertyChanged(BR.text);
    }
```

MainActivity.java
```
private ObservableField<PojoObservable> model;

...

model.get().setText("Hello world"); // THIS won't change the view with gradle version 2.3.0
```