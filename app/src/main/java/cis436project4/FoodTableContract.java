package cis436project4;

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
        public static final String FOODS_TAGS = "Tags";
    }
}
