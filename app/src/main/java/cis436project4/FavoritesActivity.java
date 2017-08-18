package cis436project4;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import goodeats.cis436project4.R;

public class FavoritesActivity extends AppCompatActivity implements DrawerMenuItem.DrawerCallBack{

    private Drawer mDrawer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        SQLSingleton.selectAllFavoritesQuery(FoodTableContract.FoodEntry.FAVORITE_SELECT_STR);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorites);
        mDrawer = new Drawer(this);
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
    }

    @Override
    public void onHomeMenuSelected() {
        mDrawer.closeDrawer();
        Intent homeActivity = new Intent(this, MainActivity.class);
        startActivity(homeActivity);
        finish();
    }
    @Override
    public void onExitMenuSelected() {
        this.finish();
    }
}
