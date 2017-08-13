package cis436project4;

import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.app.ListFragment;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import goodeats.cis436project4.R;

public class SearchResultsFragment extends ListFragment {

    int position = 0;
    @Override
    public void onActivityCreated(Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);
        //populate FoodList
        Context context = getActivity().getApplicationContext();
        SQLSingleton.getAllRecords();
        //populate ListView with cards
        FoodAdapter foodAdapter = new FoodAdapter(context, R.layout.food_card_layout, FoodList.getList());
        setListAdapter(foodAdapter);
    }

    @Override
    public void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onListItemClick(ListView l, View v, int pos, long id) {
        //TODO expand the cardview
    }
    public interface OnSearchParamsChangedListener {
        void onSearchParamsChange(Uri uri);
    }
}
