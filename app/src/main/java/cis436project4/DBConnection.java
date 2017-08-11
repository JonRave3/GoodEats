package cis436project4;

import android.content.ContentValues;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

import java.lang.reflect.Array;
import java.util.ArrayList;

import goodeats.cis436project4.R;

/**
 * Created by JRavelo on 8/8/2017.
 */

public class DBConnection extends SQLiteOpenHelper {

    private static final String SQL_CREATE_TABLE =
            "CREATE TABLE " + FoodTableContract.FoodEntry.TABLE_NAME + " (" +
                    FoodTableContract.FoodEntry.FOODS_INDEX + " INTEGER PRIMARY KEY, " +
                    FoodTableContract.FoodEntry.FOODS_NAME + " TEXT, " +
                    FoodTableContract.FoodEntry.FOODS_CATEGORY + " TEXT, " +
                    FoodTableContract.FoodEntry.FOODS_FAVORITED + " TEXT, " +
                    FoodTableContract.FoodEntry.FOODS_TAGS  + " TEXT, " +
                    FoodTableContract.FoodEntry.FOODS_PHOTO_ID + " INTEGER)";
    private static final String SQL_DELETE_TABLE =
            "DROP TABLE IF EXISTS " + FoodTableContract.FoodEntry.TABLE_NAME;
    private Resources res;
    private static final String DB_NAME = "GoodEats.db";

    public DBConnection(Context context) {
        super(context, DB_NAME, null, 1);
        res = context.getResources();

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_TABLE);
        //insert records
        loadFoodTable();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DELETE_TABLE);
        onCreate(db);
    }
    private void loadFoodTable()
    {
        loadAmericanFoods();
        loadLatinFoods();
        loadJapaneseFoods();
        loadFrenchFoods();
        loadIndianFoods();
        loadItalianFoods();
        loadChineseFoods();
    }
    private ContentValues getContentValues(String[] foodRec){
        ContentValues cv = new ContentValues();
        cv.put(FoodTableContract.FoodEntry.FOODS_INDEX, foodRec[0]);
        cv.put(FoodTableContract.FoodEntry.FOODS_NAME, foodRec[1]);
        cv.put(FoodTableContract.FoodEntry.FOODS_CATEGORY, foodRec[2]);
        cv.put(FoodTableContract.FoodEntry.FOODS_FAVORITED, foodRec[3]);
        cv.put(FoodTableContract.FoodEntry.FOODS_TAGS, foodRec[4]);
        cv.put(FoodTableContract.FoodEntry.FOODS_PHOTO_ID, foodRec[5]);
        return cv;
    }
    private void loadAmericanFoods() {
        String[] sa = res.getStringArray(R.array.food1);
        getWritableDatabase().insert(FoodTableContract.FoodEntry.TABLE_NAME, null, getContentValues(sa));
        sa = res.getStringArray(R.array.food2);
        getWritableDatabase().insert(FoodTableContract.FoodEntry.TABLE_NAME, null, getContentValues(sa));
        sa = res.getStringArray(R.array.food3);
        getWritableDatabase().insert(FoodTableContract.FoodEntry.TABLE_NAME, null, getContentValues(sa));
        sa = res.getStringArray(R.array.food4);
        getWritableDatabase().insert(FoodTableContract.FoodEntry.TABLE_NAME, null, getContentValues(sa));
        sa = res.getStringArray(R.array.food5);
        getWritableDatabase().insert(FoodTableContract.FoodEntry.TABLE_NAME, null, getContentValues(sa));
    }
    private void loadLatinFoods() {
        String[] sa = res.getStringArray(R.array.food6);
        getWritableDatabase().insert(FoodTableContract.FoodEntry.TABLE_NAME, null, getContentValues(sa));
        sa = res.getStringArray(R.array.food7);
        getWritableDatabase().insert(FoodTableContract.FoodEntry.TABLE_NAME, null, getContentValues(sa));
        sa = res.getStringArray(R.array.food8);
        getWritableDatabase().insert(FoodTableContract.FoodEntry.TABLE_NAME, null, getContentValues(sa));
        sa = res.getStringArray(R.array.food9);
        getWritableDatabase().insert(FoodTableContract.FoodEntry.TABLE_NAME, null, getContentValues(sa));
        sa = res.getStringArray(R.array.food10);
        getWritableDatabase().insert(FoodTableContract.FoodEntry.TABLE_NAME, null, getContentValues(sa));
    }
    private void loadJapaneseFoods() {
        String[] sa = res.getStringArray(R.array.food11);
        getWritableDatabase().insert(FoodTableContract.FoodEntry.TABLE_NAME, null, getContentValues(sa));
        sa = res.getStringArray(R.array.food12);
        getWritableDatabase().insert(FoodTableContract.FoodEntry.TABLE_NAME, null, getContentValues(sa));
        sa = res.getStringArray(R.array.food13);
        getWritableDatabase().insert(FoodTableContract.FoodEntry.TABLE_NAME, null, getContentValues(sa));
        sa = res.getStringArray(R.array.food14);
        getWritableDatabase().insert(FoodTableContract.FoodEntry.TABLE_NAME, null, getContentValues(sa));
        sa = res.getStringArray(R.array.food15);
        getWritableDatabase().insert(FoodTableContract.FoodEntry.TABLE_NAME, null, getContentValues(sa));
    }
    private void loadFrenchFoods() {
        String[] sa = res.getStringArray(R.array.food16);
        getWritableDatabase().insert(FoodTableContract.FoodEntry.TABLE_NAME, null, getContentValues(sa));
        sa = res.getStringArray(R.array.food17);
        getWritableDatabase().insert(FoodTableContract.FoodEntry.TABLE_NAME, null, getContentValues(sa));
        sa = res.getStringArray(R.array.food18);
        getWritableDatabase().insert(FoodTableContract.FoodEntry.TABLE_NAME, null, getContentValues(sa));
        sa = res.getStringArray(R.array.food19);
        getWritableDatabase().insert(FoodTableContract.FoodEntry.TABLE_NAME, null, getContentValues(sa));
        sa = res.getStringArray(R.array.food20);
        getWritableDatabase().insert(FoodTableContract.FoodEntry.TABLE_NAME, null, getContentValues(sa));
    }
    private void loadIndianFoods() {
        String[] sa = res.getStringArray(R.array.food21);
        getWritableDatabase().insert(FoodTableContract.FoodEntry.TABLE_NAME, null, getContentValues(sa));
        sa = res.getStringArray(R.array.food22);
        getWritableDatabase().insert(FoodTableContract.FoodEntry.TABLE_NAME, null, getContentValues(sa));
        sa = res.getStringArray(R.array.food23);
        getWritableDatabase().insert(FoodTableContract.FoodEntry.TABLE_NAME, null, getContentValues(sa));
        sa = res.getStringArray(R.array.food24);
        getWritableDatabase().insert(FoodTableContract.FoodEntry.TABLE_NAME, null, getContentValues(sa));
        sa = res.getStringArray(R.array.food25);
        getWritableDatabase().insert(FoodTableContract.FoodEntry.TABLE_NAME, null, getContentValues(sa));
    }
    private void loadItalianFoods() {
        String[] sa = res.getStringArray(R.array.food26);
        getWritableDatabase().insert(FoodTableContract.FoodEntry.TABLE_NAME, null, getContentValues(sa));
        sa = res.getStringArray(R.array.food27);
        getWritableDatabase().insert(FoodTableContract.FoodEntry.TABLE_NAME, null, getContentValues(sa));
        sa = res.getStringArray(R.array.food28);
        getWritableDatabase().insert(FoodTableContract.FoodEntry.TABLE_NAME, null, getContentValues(sa));
        sa = res.getStringArray(R.array.food29);
        getWritableDatabase().insert(FoodTableContract.FoodEntry.TABLE_NAME, null, getContentValues(sa));
        sa = res.getStringArray(R.array.food30);
        getWritableDatabase().insert(FoodTableContract.FoodEntry.TABLE_NAME, null, getContentValues(sa));
    }
    private void loadChineseFoods() {
        String[] sa = res.getStringArray(R.array.food31);
        getWritableDatabase().insert(FoodTableContract.FoodEntry.TABLE_NAME, null, getContentValues(sa));
        sa = res.getStringArray(R.array.food32);
        getWritableDatabase().insert(FoodTableContract.FoodEntry.TABLE_NAME, null, getContentValues(sa));
        sa = res.getStringArray(R.array.food33);
        getWritableDatabase().insert(FoodTableContract.FoodEntry.TABLE_NAME, null, getContentValues(sa));
        sa = res.getStringArray(R.array.food34);
        getWritableDatabase().insert(FoodTableContract.FoodEntry.TABLE_NAME, null, getContentValues(sa));
        sa = res.getStringArray(R.array.food35);
        getWritableDatabase().insert(FoodTableContract.FoodEntry.TABLE_NAME, null, getContentValues(sa));
    }
}


