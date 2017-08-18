package cis436project4;

import android.content.ContentValues;
import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

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
        res = context.getResources();
    }
    //SELECT METHODS
    protected static void getAllRecords(){
        Cursor cursor = sqlReader.rawQuery(FoodTableContract.FoodEntry.GET_ALL_RECORDS, null);
        if(cursor.getCount() == 0){
            loadFoodTable();
            getAllRecords();
        } else {
            Food newFood = null;
            while(cursor.moveToNext() && FoodList.getList().size() <= FoodList.MAX_SIZE){
                newFood = new Food();
                newFood.index = cursor.getInt(cursor.getColumnIndexOrThrow(FoodTableContract.FoodEntry.FOODS_INDEX));
                newFood.name = cursor.getString(cursor.getColumnIndexOrThrow(FoodTableContract.FoodEntry.FOODS_NAME));
                newFood.category = cursor.getString(cursor.getColumnIndexOrThrow(FoodTableContract.FoodEntry.FOODS_CATEGORY));
                String fav  = cursor.getString(cursor.getColumnIndexOrThrow(FoodTableContract.FoodEntry.FOODS_FAVORITED));
                newFood.favorite = Boolean.parseBoolean(fav);
                newFood.image = cursor.getString(cursor.getColumnIndexOrThrow(FoodTableContract.FoodEntry.FOODS_PHOTO_ID));
                newFood.link = cursor.getString(cursor.getColumnIndexOrThrow(FoodTableContract.FoodEntry.FOODS_LINK));
                FoodList.getList().add(newFood);
            }
        }

    }//end of getAllRecords()
    protected static void selectQuery(String selectStatement){
        Cursor cursor = sqlReader.rawQuery(selectStatement, null);
        FoodList.getList().clear();
        Food newFood = null;
        while(cursor.moveToNext()){
            newFood = new Food();
            newFood.index = cursor.getInt(cursor.getColumnIndexOrThrow(FoodTableContract.FoodEntry.FOODS_INDEX));
            newFood.name = cursor.getString(cursor.getColumnIndexOrThrow(FoodTableContract.FoodEntry.FOODS_NAME));
            newFood.category = cursor.getString(cursor.getColumnIndexOrThrow(FoodTableContract.FoodEntry.FOODS_CATEGORY));
            String fav  = cursor.getString(cursor.getColumnIndexOrThrow(FoodTableContract.FoodEntry.FOODS_FAVORITED));
            newFood.favorite = Boolean.parseBoolean(fav);
            newFood.image = cursor.getString(cursor.getColumnIndexOrThrow(FoodTableContract.FoodEntry.FOODS_PHOTO_ID));
            newFood.link = cursor.getString(cursor.getColumnIndexOrThrow(FoodTableContract.FoodEntry.FOODS_LINK));
            FoodList.getList().add(newFood);
        }
    }
    protected static Food selectRandQuery(String statement){
        Cursor cursor = sqlReader.rawQuery(statement, null);
        Food newFood = null;
        int count = 0;
        while(cursor.moveToNext() && count < 1){
            newFood = new Food();
            newFood.index = cursor.getInt(cursor.getColumnIndexOrThrow(FoodTableContract.FoodEntry.FOODS_INDEX));
            newFood.name = cursor.getString(cursor.getColumnIndexOrThrow(FoodTableContract.FoodEntry.FOODS_NAME));
            newFood.category = cursor.getString(cursor.getColumnIndexOrThrow(FoodTableContract.FoodEntry.FOODS_CATEGORY));
            String fav  = cursor.getString(cursor.getColumnIndexOrThrow(FoodTableContract.FoodEntry.FOODS_FAVORITED));
            newFood.favorite = Boolean.parseBoolean(fav);
            newFood.image = cursor.getString(cursor.getColumnIndexOrThrow(FoodTableContract.FoodEntry.FOODS_PHOTO_ID));
            newFood.link = cursor.getString(cursor.getColumnIndexOrThrow(FoodTableContract.FoodEntry.FOODS_LINK));
            count++;
        }
        return newFood;
    }
    protected static void selectAllFavoritesQuery(String statement) {
        Cursor cursor = sqlReader.rawQuery(statement, null);
        FoodList.getFavList().clear();
        Food newFood = null;
        while (cursor.moveToNext()) {
            newFood = new Food();
            newFood.index = cursor.getInt(cursor.getColumnIndexOrThrow(FoodTableContract.FoodEntry.FOODS_INDEX));
            newFood.name = cursor.getString(cursor.getColumnIndexOrThrow(FoodTableContract.FoodEntry.FOODS_NAME));
            newFood.category = cursor.getString(cursor.getColumnIndexOrThrow(FoodTableContract.FoodEntry.FOODS_CATEGORY));
            String fav = cursor.getString(cursor.getColumnIndexOrThrow(FoodTableContract.FoodEntry.FOODS_FAVORITED));
            newFood.favorite = Boolean.parseBoolean(fav);
            newFood.image = cursor.getString(cursor.getColumnIndexOrThrow(FoodTableContract.FoodEntry.FOODS_PHOTO_ID));
            newFood.link = cursor.getString(cursor.getColumnIndexOrThrow(FoodTableContract.FoodEntry.FOODS_LINK));
            FoodList.getFavList().add(newFood);
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
    public static void updateRecord(int recordID, String column, String val){
        ContentValues cv = new ContentValues();
        String whereClause = FoodTableContract.FoodEntry.FOODS_INDEX + "=" + recordID;
        cv.put(column, val);
        sqlWriter.update(FoodTableContract.FoodEntry.TABLE_NAME,
                cv,
                whereClause,
                null);
        //sqlWriter.rawQuery(statement, null);
    }

    private static void loadFoodTable() {
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
        sa = res.getStringArray(R.array.food6);
        insertRecord(sa);
        sa = res.getStringArray(R.array.food7);
        insertRecord(sa);
        sa = res.getStringArray(R.array.food8);
        insertRecord(sa);
        sa = res.getStringArray(R.array.food9);
        insertRecord(sa);
        sa = res.getStringArray(R.array.food10);
        insertRecord(sa);
        sa = res.getStringArray(R.array.food11);
        insertRecord(sa);
        sa = res.getStringArray(R.array.food12);
        insertRecord(sa);
        sa = res.getStringArray(R.array.food13);
        insertRecord(sa);
        sa = res.getStringArray(R.array.food14);
        insertRecord(sa);
        sa = res.getStringArray(R.array.food15);
        insertRecord(sa);
        sa = res.getStringArray(R.array.food16);
        insertRecord(sa);
        sa = res.getStringArray(R.array.food17);
        insertRecord(sa);
        sa = res.getStringArray(R.array.food18);
        insertRecord(sa);
        sa = res.getStringArray(R.array.food19);
        insertRecord(sa);
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

}
