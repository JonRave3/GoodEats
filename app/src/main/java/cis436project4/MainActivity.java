package cis436project4;

import android.app.FragmentTransaction;
import android.content.ContentValues;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import goodeats.cis436project4.R;

public class MainActivity extends AppCompatActivity implements MainFragment.OnRandButtonPressed{

    protected static SQLiteDatabase sqLiteDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //setup the database
        SQLSingleton.init(this, new DBConnection(this));
        SQLSingleton.getAllRecords();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }//end of onCreate()

    @Override
    public void updateFoodCardMain(Food record) {
        FoodCardFragment fcf = (FoodCardFragment) this.getSupportFragmentManager().findFragmentById(R.id.food_card_layout_main);
        if(fcf == null){
            fcf = FoodCardFragment.newInstance(record);
            android.support.v4.app.FragmentTransaction fm = getSupportFragmentManager().beginTransaction();
            fm.replace(R.id.food_card_layout_main, fcf).setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE).commit();
        }
        else {
            fcf.updateView(record);
        }
    }
}
