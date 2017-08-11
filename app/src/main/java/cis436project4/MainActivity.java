package cis436project4;

import android.content.ContentValues;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import goodeats.cis436project4.R;

public class MainActivity extends AppCompatActivity {

    DBConnection dbConnection;
    private static SQLiteDatabase sqLiteDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        SharedPrefs.init(this);
        SharedPreferences.Editor spe = SharedPrefs.getPrefs().edit();
        //setup the database
        dbConnection = new DBConnection(getBaseContext());
        sqLiteDatabase = dbConnection.getWritableDatabase();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }//end of onCreate()
}
