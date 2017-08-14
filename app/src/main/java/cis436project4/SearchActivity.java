package cis436project4;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import goodeats.cis436project4.R;

public class SearchActivity extends AppCompatActivity
                            implements SearchFragment.OnSearchFragmentInteractionListener, SearchResultsFragment.OnSearchParamsChangedListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
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
            Bundle extras = getIntent().getExtras();
            searchFragment.setArguments(extras);
            getSupportFragmentManager().beginTransaction().add(searchFragment,"searchFragment").commit();
        }
    }

    @Override
    public void onSearchFragmentInteraction() {
        //used to communicate with SearchResultsFragment

    }

    @Override
    public void onSearchParamsChange() {
        //used to communicate with SearchResultsFragment
    }
}
