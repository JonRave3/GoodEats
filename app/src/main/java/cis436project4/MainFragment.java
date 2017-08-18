package cis436project4;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.format.DateUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.Date;
import java.util.Random;

import goodeats.cis436project4.R;

public class MainFragment extends Fragment {

    Button searchRandBtn;
    private OnRandButtonPressed mListener;

    public MainFragment() {
        // Required empty public constructor
    }

    public static MainFragment newInstance(String param1, String param2) {
        MainFragment fragment = new MainFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View fragment = inflater.inflate(R.layout.fragment_main, container, false);
        searchRandBtn = (Button) fragment.findViewById(R.id.rand_search_btn);
        searchRandBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //generate a random number n, where 1 <= n <= 20
                int rand_index;
                while((rand_index = getNewFoodID()) > 19){
                    //re-roll if the index is out of range; 1-19 (inclusive)
                    ;
                }
                String randId = Integer.toString(rand_index);
                Food record = SQLSingleton.selectRandQuery(FoodTableContract.FoodEntry.randSearchSelectStr(randId));
                //update the fragment_food_card_main
                if(mListener != null){
                    mListener.updateFoodCardMain(record);
                }
            }
        });

        return fragment;
    }

    public int getNewFoodID() {
        return new Random(new Date().getTime()).nextInt(18) + 1;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnRandButtonPressed) {
            mListener = (OnRandButtonPressed) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    protected interface OnRandButtonPressed {
        void updateFoodCardMain(Food record);
    }
}
