package tests.velka.loginform.View;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.jakewharton.rxbinding.widget.RxTextView;

import rx.Observable;
import rx.functions.Func2;
import tests.velka.loginform.Model.FieldModel;
import tests.velka.loginform.Presenter.LoginFragmentPresenter;
import tests.velka.loginform.R;

/**
 * @author ekaterina
 */

public class LoginFormFragment extends Fragment {
    private EditText emailEditText;
    private EditText passwordEditText;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login, container, false);

        emailEditText = (EditText) view.findViewById(R.id.email_text_view);
        passwordEditText = (EditText) view.findViewById(R.id.password_text_view);

        Observable observable = Observable.combineLatest(
                RxTextView.textChanges(emailEditText),
                RxTextView.textChanges(passwordEditText),
                new Func2<CharSequence, CharSequence, FieldModel>() {
                    @Override
                    public FieldModel call(CharSequence charSequence, CharSequence charSequence2) {
                        return new FieldModel(charSequence, charSequence2);
                    }

                }
        );

        LoginFragmentPresenter loginFragmentPresenter = new LoginFragmentPresenter();
        loginFragmentPresenter.observeChoosableFieldChanges(observable);

        return view;
    }
}
