package cis436project4;

import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import goodeats.cis436project4.R;

public class SearchActivity extends AppCompatActivity
                            implements SearchFragment.OnSearchFragmentInteractionListener, SearchResultsFragment.OnSearchParamsChangedListener{

    private static SQLiteDatabase sqLiteDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
    }//end of onCreate()


    @Override
    public void onSearchParamsChange() {

    }
    @Override
    public void onSearchResetInteraction(){
        SearchResultsFragment searchResultsFragment = (SearchResultsFragment) getFragmentManager().findFragmentById(R.id.search_results_fragment);
        if(searchResultsFragment != null){
            FoodList.getList().clear();
            searchResultsFragment.foodAdapter.setData(FoodList.getList());
        }
    }

    @Override
    public void onSearchFragmentInteraction() {
        SearchResultsFragment searchResultsFragment = (SearchResultsFragment) getFragmentManager().findFragmentById(R.id.search_results_fragment);
        if(searchResultsFragment != null){
            searchResultsFragment.foodAdapter.setData(FoodList.getList());
        }
    }
}
