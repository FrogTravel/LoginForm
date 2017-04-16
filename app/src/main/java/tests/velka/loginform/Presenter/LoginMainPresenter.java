package tests.velka.loginform.Presenter;

import android.widget.Button;

import com.jakewharton.rxbinding.view.RxView;

import java.util.StringTokenizer;
import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.functions.Action1;
import rx.functions.Func1;
import tests.velka.loginform.Model.FieldModel;

/**
 * Created by ekaterina on 4/14/17.
 */

public class LoginMainPresenter {

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
}
