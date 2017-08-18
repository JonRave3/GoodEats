package cis436project4;

import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.app.ListFragment;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import goodeats.cis436project4.R;

public class SearchResultsFragment extends ListFragment {

    private OnSearchParamsChangedListener mListener;
    protected FoodAdapter foodAdapter;
    int position = 0;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        foodAdapter = new FoodAdapter(getActivity(), R.layout.food_card_layout, FoodList.getList());
        setListAdapter(foodAdapter);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View fragment = inflater.inflate(R.layout.fragment_search_results, container, false);
        setListAdapter(foodAdapter);
        return fragment;
    }

    @Override
    public void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onListItemClick(ListView l, View v, int pos, long id) {
        //TODO expand the cardview
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnSearchParamsChangedListener) {
            mListener = (OnSearchParamsChangedListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnSearchParamsChangedListener");
        }
    }

    public interface OnSearchParamsChangedListener {
        void onSearchParamsChange();
    }
}
