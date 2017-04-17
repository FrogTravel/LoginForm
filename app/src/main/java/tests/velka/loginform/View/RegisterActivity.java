package tests.velka.loginform.View;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import tests.velka.loginform.Model.FieldModel;
import tests.velka.loginform.Presenter.InsidePresenter;
import tests.velka.loginform.Presenter.RegistrationPresenter;
import tests.velka.loginform.R;

/**
 * Created by ekaterina on 4/16/17.
 */

public class RegisterActivity extends Activity {
    private Button registrationButton;
    private RegistrationPresenter regPres;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        registrationButton = (Button)findViewById(R.id.register_new_btn);
        registrationButton.setEnabled(false);

        regPres = new RegistrationPresenter(this);
        regPres.subscribeForActivation(registrationButton);
    }

    public void onNewRegister(View view){
        regPres.onRegButton();
    }
}
