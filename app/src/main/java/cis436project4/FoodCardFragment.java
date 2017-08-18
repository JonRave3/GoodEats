package cis436project4;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Date;
import java.util.Random;

import goodeats.cis436project4.R;


public class FoodCardFragment extends Fragment {

    TextView foodName, foodCategory;
    ImageView favIcon, foodImage;

    public FoodCardFragment() {
        // Required empty public constructor
    }

    public static FoodCardFragment newInstance(Food record) {
        FoodCardFragment fragment = new FoodCardFragment();
        fragment.init(fragment.getView());
        fragment.updateView(record);
        return fragment;
    }
    private void init(View parent){
        foodName = (TextView) parent.findViewById(R.id.foodName_fc_textView);
        foodCategory = (TextView) parent.findViewById(R.id.foodCategory_fc_textView);
        favIcon = (ImageView) parent.findViewById(R.id.foodFav_fc_imgView);
        foodImage = (ImageView) parent.findViewById(R.id.food_fc_imgView);
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View fragment = inflater.inflate(R.layout.fragment_food_card, container, false);
        init(fragment);
        int rand_index;
        while((rand_index = getNewFoodID()) > 19){
            //re-roll if the index is out of range; 1-19 (inclusive)
            ;
        }
        String randId = Integer.toString(rand_index);
        //initialize with first record
        Food record = SQLSingleton.selectRandQuery(FoodTableContract.FoodEntry.randSearchSelectStr(randId));
        updateView(record);
        return fragment;
    }
    protected void updateView(final Food record){
        foodName.setText(record.name);
        foodCategory.setText(record.category);
        if(record.favorite){
            favIcon.setImageResource(R.drawable.fav_checked);
        } else {
            favIcon.setImageResource(R.drawable.fav_unchecked);
        }
        foodImage.setImageResource(getResources().getIdentifier(record.image, "mipmap", getActivity().getPackageName()));
        favIcon.setClickable(true);
        favIcon.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                ImageView icon = (ImageView) v;
                if(record.favorite){
                    record.favorite = false;
                    icon.setImageResource(R.drawable.fav_unchecked);
                }
                else {
                    record.favorite = true;
                    icon.setImageResource(R.drawable.fav_checked);
                }
                //String updateStr = FoodTableContract.FoodEntry.favoriteUpdateStr(Boolean.toString(record.favorite), Integer.toString(record.index), record.name);
                SQLSingleton.updateRecord(record.index, FoodTableContract.FoodEntry.FOODS_FAVORITED, Boolean.toString(record.favorite));
            }
        });
    }
    public int getNewFoodID() {
        return new Random(new Date().getTime()).nextInt(18) + 1;
        //query the DB for the food with index = n
    }
}
