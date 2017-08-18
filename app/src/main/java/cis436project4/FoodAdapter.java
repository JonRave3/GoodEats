package cis436project4;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.annotation.DrawableRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

import goodeats.cis436project4.R;

/**
 * Created by JRavelo on 8/12/2017.
 */

public class FoodAdapter extends ArrayAdapter<Food> {

    ArrayList<Food> data;
    Context context;
    int resourceID;

    public FoodAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull ArrayList<Food> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resourceID = resource;
        this.data = objects;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        if(position >= data.size())
            return null;
        View card = convertView;
        FoodHolder foodHolder = null;
        if(card == null) {
            LayoutInflater layoutInflater = ((Activity) context).getLayoutInflater();
            card = layoutInflater.inflate(resourceID, parent, false);
        }
        Context context = card.getContext();

        foodHolder = new FoodHolder();
        foodHolder.foodImage = (ImageView) card.findViewById(R.id.food_imageView);
        foodHolder.foodFavorite = (ImageView) card.findViewById(R.id.foodFav_imageView);
        foodHolder.foodName = (TextView) card.findViewById(R.id.foodName_textView);
        foodHolder.foodCategory = (TextView) card.findViewById(R.id.foodCategory_textView);

        final Food food = data.get(position);
        foodHolder.foodName.setText(food.name);
        foodHolder.foodName.setClickable(true);
        foodHolder.foodName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO start a google search!
            }
        });
        foodHolder.foodCategory.setText(food.category);
        if(food.favorite){
            foodHolder.foodFavorite.setImageResource(R.drawable.fav_checked);
        } else {
            foodHolder.foodFavorite.setImageResource(R.drawable.fav_unchecked);
        }
        foodHolder.foodFavorite.setClickable(true);
        foodHolder.foodFavorite.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                ImageView icon = (ImageView) v;
                if(food.favorite){
                    food.favorite = false;
                    icon.setImageResource(R.drawable.fav_unchecked);
                }
                else {
                    food.favorite = true;
                    icon.setImageResource(R.drawable.fav_checked);
                }
                String updateStr = FoodTableContract.FoodEntry.favoriteUpdateStr(Boolean.toString(food.favorite), Integer.toString(food.index), food.name);
                SQLSingleton.updateRecord(updateStr);
            }
        });
        int imgResourceId = context.getResources().getIdentifier(food.image, "mipmap", context.getPackageName());
        foodHolder.foodImage.setImageResource(imgResourceId);
        return card;
    }
    protected void setData(ArrayList<Food> newData){
        data = newData;
        notifyDataSetChanged();
    }


    static class FoodHolder{
        ImageView foodImage, foodFavorite;
        TextView foodName, foodCategory;
    }

}
