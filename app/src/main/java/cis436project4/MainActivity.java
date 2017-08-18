package cis436project4;

import android.app.FragmentTransaction;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import goodeats.cis436project4.R;

public class MainActivity extends AppCompatActivity implements MainFragment.OnRandButtonPressed, DrawerMenuItem.DrawerCallBack {

    protected Drawer mDrawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //setup the database
        SQLSingleton.init(this, new DBConnection(this));
        SQLSingleton.getAllRecords();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mDrawer = new Drawer(this);
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

    @Override
    public void onSearchMenuSelected() {
        mDrawer.closeDrawer();
        Intent searchActivity = new Intent(this, SearchActivity.class);
        startActivity(searchActivity);
        finish();
    }

    @Override
    public void onFavoritesMenuSelected() {
        mDrawer.closeDrawer();
        Intent favoritesActivity =  new Intent(this, FavoritesActivity.class);
        //start Favorites intent;
        startActivity(favoritesActivity);
        finish();
    }

    @Override
    public void onHomeMenuSelected() {
        mDrawer.closeDrawer();
    }

    @Override
    public void onExitMenuSelected() {
        this.finish();
    }


}
