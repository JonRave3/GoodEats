package cis436project4;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.StringRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import goodeats.cis436project4.R;

public class FavoriteListFragment extends ListFragment {

    protected FoodAdapter foodAdapter;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        foodAdapter = new FoodAdapter(getActivity(), R.layout.food_card_layout, FoodList.getFavList());
        setListAdapter(foodAdapter);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View fragment = inflater.inflate(R.layout.fragment_favorite_list, container, false);
        // Inflate the layout for this fragment
        setListAdapter(foodAdapter);

        if(FoodList.getFavList().size() == 0){
            {
                Toast.makeText(getContext(), R.string.empty_list, Toast.LENGTH_SHORT);
            }
        }
        setListAdapter(foodAdapter);
        return fragment;
    }

}
