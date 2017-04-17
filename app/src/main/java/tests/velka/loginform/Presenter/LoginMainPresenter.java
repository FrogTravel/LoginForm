package tests.velka.loginform.Presenter;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.View;
import android.widget.Button;

import com.jakewharton.rxbinding.view.RxView;

import java.util.StringTokenizer;
import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.functions.Action1;
import rx.functions.Func1;
import tests.velka.loginform.Model.CurrentSession;
import tests.velka.loginform.Model.DBHelper;
import tests.velka.loginform.Model.FieldModel;
import tests.velka.loginform.View.InsideMainActivity;

/**
 * @author ekaterina
 */

public class LoginMainPresenter{
    private Context context;
    private DBHelper dbHelper;

    public LoginMainPresenter(Context context){
        this.context = context;
        dbHelper = new DBHelper(context);
    }

    /**
     * When all fields are filled in properly, button turns on
     * @param enterButton that will be updated
     */
    public void subscribeForActivation(final Button enterButton) {
        Observable<Boolean> observable = FieldModel.getObservable();

        Action1<Boolean> action = new Action1<Boolean>() {
            @Override
            public void call(Boolean o) {
                System.out.println("Call for button " + o);
                if(o)
                    enterButton.setEnabled(true);
                else
                    enterButton.setEnabled(false);
            }
        };

        observable.subscribe(action);
    }

    /**
     * Checks if entered password is right
     * Saves email to current session
     */
    public void onLoginButton(){
        if(dbHelper.isRightPassword(FieldModel.getEmail().toString(), FieldModel.getPassword().toString())) {
            CurrentSession.setEmail(FieldModel.getEmail().toString());
            InsideMainActivity insideMainActivity = new InsideMainActivity();
            insideMainActivity.startActivity(context);
        }
    }

    /**
     * Set that in current session user has such email
     * Starts "EmailView"
     * @param email
     */
    public void onGooglePlus(String email) {
        if(email != null)
            CurrentSession.setEmail(email);

        InsideMainActivity insideMainActivity = new InsideMainActivity();
        insideMainActivity.startActivity(context);
    }
}
