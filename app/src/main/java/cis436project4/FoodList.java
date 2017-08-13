package cis436project4;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/**
 * Created by JRavelo on 8/13/2017.
 */

public class FoodList extends ArrayList<Food> {
    Type food = Food.class;
    private static final int MAX_SIZE = 35;
    private static FoodList foodList = new FoodList();
    public FoodList(){
        super(MAX_SIZE);
    }
    public FoodList(Collection<Food> foods){
        addAll(foods);
    }
    public static FoodList getList(){
        return foodList;
    }
}
