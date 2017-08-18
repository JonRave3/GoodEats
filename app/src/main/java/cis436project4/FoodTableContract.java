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

        public static final String FAVORITE_SELECT_STR = "SELECT * FROM " + TABLE_NAME +
                " WHERE " + FOODS_FAVORITED + " = 'true';";

        public static String searchSelectStr(String[] foodNames, String[] categories){
            String statement = "SELECT * FROM " + TABLE_NAME + " WHERE ";
            if(foodNames != null && foodNames.length > 0 && foodNames[0] != ""){
                for(int i = 0; i < foodNames.length; i++){
                    statement += ("(" + FOODS_NAME + " LIKE '%" + foodNames[i] + "%') " + ( i != foodNames.length-1 ? "OR ": " "));
                }
                statement += ("GROUP BY " + FOODS_NAME + " HAVING ");
                for(int j = 0; j < categories.length; j++){
                    statement += ("(" + FOODS_CATEGORY + " = '" + categories[j] + "') " + (j != categories.length-1 ? "OR " : ";"));
                }
            }
            else {
                for(int j = 0; j < categories.length; j++){
                    statement += ("(" + FOODS_CATEGORY + " = '" + categories[j] + "') " + (j != categories.length-1 ? "OR " : ";"));
                }
            }

            return statement;
        }
        public static String randSearchSelectStr(String rand_index){
            String statement = "SELECT * FROM " + TABLE_NAME
                    + " WHERE " + FOODS_INDEX + " = '" + rand_index + "';";
            return statement;
        }
        public static String favoriteUpdateStr(String val, String recordID, String foodName) {
            String statement = "UPDATE " + TABLE_NAME +
                    " SET " + FOODS_FAVORITED + " = '" + val + "' " +
                    "WHERE " + FOODS_INDEX + " = " + recordID + " AND " +
                    FOODS_NAME + " = '" + foodName + "';";
            return statement;
        }
    }
}
