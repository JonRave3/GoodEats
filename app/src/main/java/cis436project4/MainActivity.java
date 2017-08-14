package cis436project4;

import android.content.ContentValues;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import goodeats.cis436project4.R;

public class MainActivity extends AppCompatActivity implements SearchFragment.OnSearchFragmentInteractionListener, SearchResultsFragment.OnSearchParamsChangedListener{

    private static SQLiteDatabase sqLiteDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //SharedPrefs.init(this);
        //SharedPreferences.Editor spe = SharedPrefs.getPrefs().edit();
        SQLSingleton.init(this, new DBConnection(this));
        SQLSingleton.getAllRecords();
        //setup the database
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

    }//end of onCreate()

    @Override
    public void onSearchParamsChange() {

    }

    @Override
    public void onSearchFragmentInteraction() {
        SearchResultsFragment searchResultsFragment = (SearchResultsFragment) getFragmentManager().findFragmentById(R.id.search_fragment);
        if(searchResultsFragment != null){
            searchResultsFragment.refreshResults(this);
        }
    }
}
