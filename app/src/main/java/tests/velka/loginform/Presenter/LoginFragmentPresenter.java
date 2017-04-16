package tests.velka.loginform.Presenter;

import android.text.TextUtils;

import java.io.FileOutputStream;

import rx.Observable;
import rx.functions.Action1;
import rx.functions.Func1;
import tests.velka.loginform.Model.FieldModel;

/**
 * Created by ekaterina on 4/14/17.
 */

public class LoginFragmentPresenter {

    @SuppressWarnings("unchecked")
    public void observeChoosableFieldChanges(Observable observable){
        observable
                .map(new Func1<FieldModel, Boolean>() {
                    @Override
                    public Boolean call(FieldModel fields) {
                        return !TextUtils.isEmpty(fields.getEmail()) && !TextUtils.isEmpty(fields.getPassword());
                    }
                })
                .subscribe(new Action1<Boolean>() {
                    @Override
                    public void call(Boolean o) {
                        //TODO check if email is right
                        //TODO activate login button
                        if(o) {
                            System.out.println("LOGIN AND PASSWORD ENTERED");
                            FieldModel.setValid(true);
                        }else{
                            FieldModel.setValid(false);
                            System.out.println("NOPE");
                        }
                    }
                });
    }
}
