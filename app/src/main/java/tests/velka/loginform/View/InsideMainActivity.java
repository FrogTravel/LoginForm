package tests.velka.loginform.View;

import android.app.Activity;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.widget.TextView;

import tests.velka.loginform.Presenter.InsidePresenter;
import tests.velka.loginform.R;

/**
 * Created by ekaterina on 4/16/17.
 */

public class InsideMainActivity {
    private Context context;
    private InsidePresenter insidePresenter;

    public void startActivity(Context context){
        Activity activity = (Activity) context;
        activity.setContentView(R.layout.activity_inside);

        TextView emailTextView = (TextView) ((Activity) context).findViewById(R.id.emailView);
        insidePresenter = new InsidePresenter(context);
        emailTextView.setText(insidePresenter.getEmail());
    }
}
