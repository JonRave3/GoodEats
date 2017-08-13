package cis436project4;

import android.content.ContentValues;
import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.IntegerRes;
import android.support.annotation.NonNull;

import goodeats.cis436project4.R;

/**
 * Created by JRavelo on 8/13/2017.
 */

public class SQLSingleton {
    private static SQLiteDatabase sqlWriter, sqlReader;
    private static DBConnection dbc;
    private static Context context;
    private static Resources res;

    public static void init(Context cont, DBConnection dbConn){
        res = context.getResources();
        if(dbConn == null){
            dbc = new DBConnection(cont);
        }
        else {
            dbc = dbConn;
        }
        if(sqlWriter == null){
            sqlWriter = dbc.getWritableDatabase();
        }
        if(sqlReader == null){
            sqlReader = dbc.getReadableDatabase();
        }
        context = cont;
        loadFoodTable();
    }
    public static SQLiteDatabase getSqlWriter(){
        return sqlWriter;
    }
    public static SQLiteDatabase getSqlReader(){
        return sqlReader;
    }
    public static DBConnection getDBConnection(){
        return dbc;
    }
    //SELECT METHODS
    protected static void getAllRecords(){
        Cursor cursor = sqlReader.rawQuery(FoodTableContract.FoodEntry.GET_ALL_RECORDS, null);
        Food newFood = null;
        while(cursor.moveToNext()){
            newFood = new Food();
            newFood.index = cursor.getInt(cursor.getColumnIndexOrThrow(FoodTableContract.FoodEntry.FOODS_INDEX));
            newFood.name = cursor.getString(cursor.getColumnIndexOrThrow(FoodTableContract.FoodEntry.FOODS_NAME));
            newFood.category = cursor.getString(cursor.getColumnIndexOrThrow(FoodTableContract.FoodEntry.FOODS_CATEGORY));
            String fav  = cursor.getString(cursor.getColumnIndexOrThrow(FoodTableContract.FoodEntry.FOODS_FAVORITED));
            newFood.favorite = Boolean.parseBoolean(fav);
            String image = cursor.getString(cursor.getColumnIndexOrThrow(FoodTableContract.FoodEntry.FOODS_PHOTO_ID));
            newFood.image = context.getResources().getIdentifier(image, "drawable", "cis436project4");
            newFood.link = cursor.getString(cursor.getColumnIndexOrThrow(FoodTableContract.FoodEntry.FOODS_LINK));
            FoodList.getList().add(newFood);
        }
    }//end of getAllRecords()
    protected static void selectQuery(String selectStatement, String[] selectors){
        Cursor cursor = sqlReader.rawQuery(selectStatement, selectors);
        Food newFood = null;
        while(cursor.moveToNext()){
            newFood = new Food();
            newFood.index = cursor.getInt(cursor.getColumnIndexOrThrow(FoodTableContract.FoodEntry.FOODS_INDEX));
            newFood.name = cursor.getString(cursor.getColumnIndexOrThrow(FoodTableContract.FoodEntry.FOODS_NAME));
            newFood.category = cursor.getString(cursor.getColumnIndexOrThrow(FoodTableContract.FoodEntry.FOODS_CATEGORY));
            String fav  = cursor.getString(cursor.getColumnIndexOrThrow(FoodTableContract.FoodEntry.FOODS_FAVORITED));
            newFood.favorite = Boolean.parseBoolean(fav);
            String image = cursor.getString(cursor.getColumnIndexOrThrow(FoodTableContract.FoodEntry.FOODS_PHOTO_ID));
            newFood.image = context.getResources().getIdentifier(image, "drawable", "cis436project4");
            newFood.link = cursor.getString(cursor.getColumnIndexOrThrow(FoodTableContract.FoodEntry.FOODS_LINK));
            FoodList.getList().add(newFood);
        }
    }

    //INSERT METHODS
    public static void insertRecord(String[] record){
        //record[0]:Pri Key/Index
        //record[1]:Name
        //record[2]:Category
        //record[3]:Favorited
        //record[4]:Link
        //reocrd[5]:Phone_Resource_ID
        sqlWriter.insert(FoodTableContract.FoodEntry.TABLE_NAME, null, getContentValues(record));
    }
    public static void insertRecord(Food record){
        sqlWriter.insert(FoodTableContract.FoodEntry.TABLE_NAME, null, getContentValues(record));
    }
    //UPDATE METHODS
    public static void updateRecord(String col, Food record){
        sqlWriter.update(
                FoodTableContract.FoodEntry.TABLE_NAME,
                getContentValues(record),
                null,//WHERE clause?
                null);//WHERE clause args?
    }
    public static void updateRecord(int pri, String col, String newVal){
        String updateStatement = "UPDATE ";
        sqlWriter.rawQuery(updateStatement, null);
    }
    //DELETE METHODS


    private static void loadFoodTable()
    {
        loadAmericanFoods();
        loadLatinFoods();
        loadJapaneseFoods();
        loadFrenchFoods();
        loadIndianFoods();
        loadItalianFoods();
        loadChineseFoods();
    }
    private static ContentValues getContentValues(String[] foodRec){
        ContentValues cv = new ContentValues();
        cv.put(FoodTableContract.FoodEntry.FOODS_INDEX, foodRec[0]);
        cv.put(FoodTableContract.FoodEntry.FOODS_NAME, foodRec[1]);
        cv.put(FoodTableContract.FoodEntry.FOODS_CATEGORY, foodRec[2]);
        cv.put(FoodTableContract.FoodEntry.FOODS_FAVORITED, foodRec[3]);
        cv.put(FoodTableContract.FoodEntry.FOODS_LINK, foodRec[4]);
        cv.put(FoodTableContract.FoodEntry.FOODS_PHOTO_ID, foodRec[5]);
        return cv;
    }
    private static ContentValues getContentValues(Food foodRec){
        ContentValues cv = new ContentValues();
        cv.put(FoodTableContract.FoodEntry.FOODS_INDEX, Integer.toString(foodRec.index));
        cv.put(FoodTableContract.FoodEntry.FOODS_NAME, foodRec.name);
        cv.put(FoodTableContract.FoodEntry.FOODS_CATEGORY, foodRec.category);
        cv.put(FoodTableContract.FoodEntry.FOODS_FAVORITED, Boolean.toString(foodRec.favorite));
        cv.put(FoodTableContract.FoodEntry.FOODS_LINK, foodRec.link);
        cv.put(FoodTableContract.FoodEntry.FOODS_PHOTO_ID, Resources.getSystem().getResourceEntryName(foodRec.image));
        return cv;
    }
    private static void loadAmericanFoods() {
        String[] sa = res.getStringArray(R.array.food1);
        insertRecord(sa);
        sa = res.getStringArray(R.array.food2);
        insertRecord(sa);
        sa = res.getStringArray(R.array.food3);
        insertRecord(sa);
        sa = res.getStringArray(R.array.food4);
        insertRecord(sa);
        sa = res.getStringArray(R.array.food5);
        insertRecord(sa);
    }
    private static void loadLatinFoods() {
        String[] sa = res.getStringArray(R.array.food6);
        insertRecord(sa);
        sa = res.getStringArray(R.array.food7);
        insertRecord(sa);
        sa = res.getStringArray(R.array.food8);
        insertRecord(sa);
        sa = res.getStringArray(R.array.food9);
        insertRecord(sa);
        sa = res.getStringArray(R.array.food10);
        insertRecord(sa);
    }
    private static void loadJapaneseFoods() {
        String[] sa = res.getStringArray(R.array.food11);
        insertRecord(sa);
        sa = res.getStringArray(R.array.food12);
        insertRecord(sa);
        sa = res.getStringArray(R.array.food13);
        insertRecord(sa);
        sa = res.getStringArray(R.array.food14);
        insertRecord(sa);
        sa = res.getStringArray(R.array.food15);
        insertRecord(sa);
    }
    private static void loadFrenchFoods() {
        String[] sa = res.getStringArray(R.array.food16);
        insertRecord(sa);
        sa = res.getStringArray(R.array.food17);
        insertRecord(sa);
        sa = res.getStringArray(R.array.food18);
        insertRecord(sa);
        sa = res.getStringArray(R.array.food19);
        insertRecord(sa);
        sa = res.getStringArray(R.array.food20);
        insertRecord(sa);
    }
    private static void loadIndianFoods() {
        String[] sa = res.getStringArray(R.array.food21);
        insertRecord(sa);
        sa = res.getStringArray(R.array.food22);
        insertRecord(sa);
        sa = res.getStringArray(R.array.food23);
        insertRecord(sa);
        sa = res.getStringArray(R.array.food24);
        insertRecord(sa);
        sa = res.getStringArray(R.array.food25);
        insertRecord(sa);
    }
    private static void loadItalianFoods() {
        String[] sa;
        sa = res.getStringArray(R.array.food26);
        insertRecord(sa);
        sa = res.getStringArray(R.array.food27);
        insertRecord(sa);
        sa = res.getStringArray(R.array.food28);
        insertRecord(sa);
        sa = res.getStringArray(R.array.food29);
        insertRecord(sa);
        sa = res.getStringArray(R.array.food30);
        insertRecord(sa);
    }
    private static void loadChineseFoods() {
        String[] sa = res.getStringArray(R.array.food31);
        insertRecord(sa);
        sa = res.getStringArray(R.array.food32);
        insertRecord(sa);
        sa = res.getStringArray(R.array.food33);
        insertRecord(sa);
        sa = res.getStringArray(R.array.food34);
        insertRecord(sa);
        sa = res.getStringArray(R.array.food35);
        insertRecord(sa);
    }
}
