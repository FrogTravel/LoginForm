package tests.velka.loginform.View;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import tests.velka.loginform.R;

public class MainActivity extends AppCompatActivity {
    private Button enterButton;
    private Button registerButton;
    private Button googleButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


}
