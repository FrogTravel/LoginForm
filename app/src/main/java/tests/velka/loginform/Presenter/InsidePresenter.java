package tests.velka.loginform.Presenter;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.TextView;

import tests.velka.loginform.Model.CurrentSession;
import tests.velka.loginform.Model.DBHelper;

/**
 * Created by ekaterina on 4/14/17.
 */

public class InsidePresenter {
    private DBHelper dbHelper;
    
    public InsidePresenter(Context context){
        dbHelper = new DBHelper(context);
    }
    
    public String getEmail(){
        return CurrentSession.getEmail();
    }

}
