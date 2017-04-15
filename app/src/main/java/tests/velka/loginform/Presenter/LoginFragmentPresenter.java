package tests.velka.loginform.Presenter;

import android.text.TextUtils;

import rx.Observable;
import rx.functions.Action1;
import rx.functions.Func1;
import tests.velka.loginform.Model.Fields;

/**
 * Created by ekaterina on 4/14/17.
 */

public class LoginFragmentPresenter {

    @SuppressWarnings("unchecked")
    public void observeChoosableFieldChanges(Observable observable){
        observable
                .map(new Func1<Fields, Boolean>() {
                    @Override
                    public Boolean call(Fields fields) {
                        return TextUtils.isEmpty(fields.getEmail()) && !TextUtils.isEmpty(fields.getPassword());
                    }
                })
                .subscribe(new Action1() {
                    @Override
                    public void call(Object o) {
                        System.out.println("LOGIN AND PASSWORD ENTERED");
                    }
                });
    }
}
