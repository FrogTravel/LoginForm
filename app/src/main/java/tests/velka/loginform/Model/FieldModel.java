package tests.velka.loginform.Model;

import rx.subjects.PublishSubject;
import rx.subjects.Subject;

/**
 * Created by ekaterina on 4/16/17.
 */

public class FieldModel {
    private static Subject myObservable = PublishSubject.create();
    private static CharSequence email;
    private static CharSequence password;

    public FieldModel(){
    }

    public FieldModel(CharSequence email, CharSequence password){
        this.email = email;
        this.password = password;
    }

    public CharSequence getEmail() {
        return email;
    }

    public CharSequence getPassword(){
        return password;
    }

    public static void setValid(boolean val){
        myObservable.onNext(val);
    }

    public static Subject getObservable(){
        return myObservable;
    }
}
