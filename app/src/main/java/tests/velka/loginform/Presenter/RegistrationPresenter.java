package tests.velka.loginform.Presenter;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import rx.Observable;
import rx.functions.Action1;
import tests.velka.loginform.Model.CurrentSession;
import tests.velka.loginform.Model.DBHelper;
import tests.velka.loginform.Model.FieldModel;
import tests.velka.loginform.View.InsideMainActivity;
import tests.velka.loginform.View.MainActivity;

/**
 * Created by Ekaterina on 4/14/17.
 */

public class RegistrationPresenter {
    private DBHelper dbHelper;
    private Context context;

    public RegistrationPresenter(Context context){
        this.context = context;
        dbHelper = new DBHelper(context);
    }

    /**
     * When all fields are filled in properly, button turns on
     * @param button that will be updated
     */
    public void subscribeForActivation(final Button button){
        Observable<Boolean> observable = FieldModel.getObservable();

        Action1<Boolean> action = new Action1<Boolean>() {
            @Override
            public void call(Boolean o) {
                System.out.println("Call for button " + o);
                if(o)
                    button.setEnabled(true);
                else
                    button.setEnabled(false);
            }
        };

        observable.subscribe(action);
    }

    /**
     * Save mail and password to DB
     * Start "EmailView"
     */
    public void onRegButton(){
        dbHelper.save(FieldModel.getEmail().toString(), FieldModel.getPassword().toString());
        CurrentSession.setEmail(FieldModel.getEmail().toString());

        InsideMainActivity insideMainActivity = new InsideMainActivity();
        insideMainActivity.startActivity(context);
    }

}
