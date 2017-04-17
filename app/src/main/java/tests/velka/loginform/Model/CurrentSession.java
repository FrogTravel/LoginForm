package tests.velka.loginform.Model;

/**
 * Created by ekaterina on 4/16/17.
 * Save information about current session
 */

public class CurrentSession {
    private static String email;

    public static void setEmail(String mEmail){
        email = mEmail;
    }

    public static String getEmail(){
        return email;
    }
}
