package cis436project4;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import goodeats.cis436project4.R;

public class DBConnection extends SQLiteOpenHelper {

    private static final String DB_NAME = "GoodEats.db";
    private static final String SQL_CREATE_TABLE =
            "CREATE TABLE " +
                    FoodTableContract.FoodEntry.TABLE_NAME + " (" +
                    FoodTableContract.FoodEntry.FOODS_INDEX + " INTEGER PRIMARY KEY, " +
                    FoodTableContract.FoodEntry.FOODS_NAME + " TEXT, " +
                    FoodTableContract.FoodEntry.FOODS_CATEGORY + " TEXT, " +
                    FoodTableContract.FoodEntry.FOODS_FAVORITED + " TEXT, " +
                    FoodTableContract.FoodEntry.FOODS_LINK  + " TEXT, " +
                    FoodTableContract.FoodEntry.FOODS_PHOTO_ID + " INTEGER)";

    private static final String SQL_DELETE_TABLE =
            "DROP TABLE IF EXISTS " + FoodTableContract.FoodEntry.TABLE_NAME;

    public DBConnection(Context context) {
        super(context, DB_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DELETE_TABLE);
        onCreate(db);
    }

}


