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

                        return isValidEmail(fields.getEmail().toString()) && isValidPassword(fields.getPassword().toString());
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


    /**
     * Checks if email is valid
     */
    private boolean isValidEmail(String email){
        boolean flag = false;
        flag = email.contains(".") && email.contains("@");
        if(flag) {
            String[] tokens = email.split("[.]");
            flag &= tokens[tokens.length - 1].length() <= 4 && !tokens[tokens.length-1].contains("@");

            if (flag) {
                String[] t = tokens[tokens.length - 2].split("[@]");
                flag &= t.length > 1;
            }

        }
        return flag;
    }

    /**
     * Checks if password is valid
     */
    private boolean isValidPassword(String password){
        return password.length() >= 6;
    }
}
