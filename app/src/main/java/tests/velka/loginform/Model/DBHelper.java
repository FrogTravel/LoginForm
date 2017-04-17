package tests.velka.loginform.Model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Classical implementation of sqlite helper plus some
 * methods specially for current app
 * Created by ekaterina on 4/14/17.
 */

public class DBHelper extends SQLiteOpenHelper {
    public static final String TABLE_NAME = "LOGIN_DB";
    public static final String COLUMN_EMAIL = "EMAIL";
    public static final String COLUMN_PASSWORD = "PASSWORD";
    private static final int DATABASE_VERSION = 1;

    public DBHelper(Context context) {
        super(context, TABLE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS " +
            TABLE_NAME +
            "(_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                COLUMN_EMAIL + " TEXT," +
                COLUMN_PASSWORD + " TEXT);");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    /**
     * Save email and password
     */
    public void save(String email, String password){
        SQLiteDatabase database = this.getWritableDatabase();

        ContentValues contentValue = new ContentValues();
        contentValue.put(DBHelper.COLUMN_EMAIL, email);
        contentValue.put(DBHelper.COLUMN_PASSWORD, password);

        database.insert(DBHelper.TABLE_NAME, null, contentValue);
    }

    /**
     * @param email if such email exists in the table
     * @return true if exists
     */
    public boolean contains(String email){
        SQLiteDatabase database = this.getWritableDatabase();
        Cursor cursor = database.query(DBHelper.TABLE_NAME, null, null, null, null, null, null);

        if(cursor.moveToFirst()) {
            int emailIndex = cursor.getColumnIndex(DBHelper.COLUMN_EMAIL);

            do {
                if (email.equals(cursor.getString(emailIndex))) {
                    return true;
                }
            } while (cursor.moveToNext());
        }
        return false;
    }

    /**
     * Checks if such password is right for current email
     */
    public boolean isRightPassword(String email, String password){
        SQLiteDatabase database = this.getWritableDatabase();
        Cursor cursor = database.query(DBHelper.TABLE_NAME, null, null, null, null, null, null);

        if(cursor.moveToFirst()) {
            int emailIndex = cursor.getColumnIndex(DBHelper.COLUMN_EMAIL);
            int passwordIndex = cursor.getColumnIndex(DBHelper.COLUMN_PASSWORD);

            do {
                if (email.equals(cursor.getString(emailIndex)) && (password.equals(cursor.getString(passwordIndex)))) {
                    return true;
                }
            } while (cursor.moveToNext());
        }
        return false;
    }
}
