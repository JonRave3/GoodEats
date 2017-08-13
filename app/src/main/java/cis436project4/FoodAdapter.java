package cis436project4;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import goodeats.cis436project4.R;

/**
 * Created by JRavelo on 8/12/2017.
 */

public class FoodAdapter extends ArrayAdapter<Food> {

    List<Food> data;
    Context context;
    int resourceID;

    public FoodAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List<Food> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resourceID = resource;
        this.data = objects;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        View card = convertView;
        FoodHolder foodHolder = null;
        if(card == null) {
            LayoutInflater layoutInflater = ((Activity) context).getLayoutInflater();
            card = layoutInflater.inflate(resourceID, parent, false);
            foodHolder = new FoodHolder();
            foodHolder.foodImage = (ImageView) card.findViewById(R.id.food_imageView);
            foodHolder.foodFavorite = (ImageView) card.findViewById(R.id.foodFav_imageView);
            foodHolder.foodName = (TextView) card.findViewById(R.id.foodName_textView);
            foodHolder.foodCategory = (TextView) card.findViewById(R.id.foodCategory_textView);
        } else {
            foodHolder = (FoodHolder) card.getTag();
        }
        Food food = data.get(position);
        foodHolder.foodName.setText(food.name);
        foodHolder.foodName.setClickable(true);
        foodHolder.foodName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO start a google search!
            }
        });
        foodHolder.foodCategory.setText(food.category);
        foodHolder.foodFavorite.setClickable(true);
        foodHolder.foodFavorite.setOnClickListener(new OnFavoriteToggleListener(food, foodHolder.foodFavorite));
        //TODO update get images for food and load into drawable
        foodHolder.foodImage.setImageDrawable(null);
        return card;
    }

    static class FoodHolder{
        ImageView foodImage, foodFavorite;
        TextView foodName, foodCategory;
    }

    private class OnFavoriteToggleListener implements View.OnClickListener {

        Food food;
        ImageView fav_icon;
        int fav_icon_checked = R.drawable.fav_checked,
            fav_icon_unchecked = R.drawable.fav_unchecked;

        private OnFavoriteToggleListener(Food cardFood, ImageView iv){
            food = cardFood;
            fav_icon = iv;
        }
        @Override
        public void onClick(View v) {
            //TODO update record to reflect the favorite status

            //change image to fav_unchecked
            if(food.favorite){
                fav_icon.setImageResource(fav_icon_unchecked);
            }
            else {
                fav_icon.setImageResource(fav_icon_checked);
            }
        }
    }
}
