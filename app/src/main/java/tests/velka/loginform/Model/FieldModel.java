package tests.velka.loginform.Model;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import rx.subjects.PublishSubject;
import rx.subjects.Subject;

/**
 * Created by ekaterina on 4/16/17.
 * Save information about state of fields
 */

public class FieldModel {
    private static Subject myObservable = PublishSubject.create();
    private static CharSequence email;
    private static CharSequence password;
    private static boolean valid;

    public FieldModel(){
    }

    public FieldModel(CharSequence email, CharSequence password){
        this.email = email;
        this.password = password;
    }

    public static CharSequence getEmail() {
        return email;
    }

    public static CharSequence getPassword(){
        return password;
    }

    public static void setValid(boolean val){
        myObservable.onNext(val);
        valid = val;
    }

    public static Subject getObservable(){
        return myObservable;
    }

    public static boolean isValid(){
        return valid;
    }

}

