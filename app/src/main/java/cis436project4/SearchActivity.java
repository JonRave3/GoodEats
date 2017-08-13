package cis436project4;

import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import goodeats.cis436project4.R;

public class SearchActivity extends AppCompatActivity
                            implements SearchFragment.OnSearchFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        SharedPrefs.init(this);
        super.onCreate(savedInstanceState);
        //don't start activity if in landscape orientation
        /*if(getResources().getConfiguration().getLayoutDirection()== Configuration.ORIENTATION_LANDSCAPE)
        {
            finish();
            return;
        }*/
        if(savedInstanceState == null)
        {
            SearchFragment searchFragment = new SearchFragment();
            searchFragment.setArguments(getIntent().getExtras());
            getSupportFragmentManager().beginTransaction().add(searchFragment,"searchFragment").commit();
        }
    }

    @Override
    public void onSearchFragmentInteraction(Uri uri) {
        //used to communicate with SearchResultsFragment
    }
}
