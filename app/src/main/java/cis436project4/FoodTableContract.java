package cis436project4;

import android.database.Cursor;
import android.provider.BaseColumns;

/**
 * Created by JRavelo on 8/10/2017.
 */

public class FoodTableContract {
    private FoodTableContract() {}
    public static class FoodEntry implements BaseColumns {
        public static final String TABLE_NAME = "Foods";
        public static final String FOODS_INDEX = "Id";
        public static final String FOODS_NAME = "Name";
        public static final String FOODS_CATEGORY = "Category";
        public static final String FOODS_FAVORITED = "Favorited";
        public static final String FOODS_PHOTO_ID = "Photo_Id";
        public static final String FOODS_LINK = "Link";

        public static final String GET_ALL_RECORDS = "SELECT * FROM " + TABLE_NAME + ";";

        public static String selectStr(String[] args){
            String statement = "SELECT ";
            for(int i=0; i < args.length; i++){
                statement += (args[i] + (i != args.length-1 ? ", " : ""));
            }
            statement += ("FROM " + TABLE_NAME + ";");
            return statement;
        }
    }
}
