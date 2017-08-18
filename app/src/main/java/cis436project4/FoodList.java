package cis436project4;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/**
 * Created by JRavelo on 8/13/2017.
 */

public class FoodList extends ArrayList<Food> {

    public static final int MAX_SIZE = 20;
    private static FoodList foodList = new FoodList();

    public FoodList(){
        super(MAX_SIZE);
    }
    public static FoodList getList(){
        return foodList;
    }
}
