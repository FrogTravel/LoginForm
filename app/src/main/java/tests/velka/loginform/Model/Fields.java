package tests.velka.loginform.Model;

/**
 * Created by ekaterina on 4/15/17.
 */

public class Fields {
    private CharSequence email;
    private CharSequence password;

    public Fields(CharSequence email, CharSequence password){
        this.email = email;
        this.password = password;
    }

    public CharSequence getEmail(){
        return email;
    }

    public CharSequence getPassword() {
        return password;
    }
}
