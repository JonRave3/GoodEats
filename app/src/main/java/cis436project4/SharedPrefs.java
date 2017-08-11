package cis436project4;

import android.content.Context;
import android.content.SharedPreferences;


public class SharedPrefs {
    private static String pkg_name = "jravelo.cis436_project4";
    private static SharedPreferences prefs;

    public static void init(Context cont)
    {
        if(prefs == null)
            prefs = cont.getSharedPreferences(pkg_name, Context.MODE_PRIVATE);
    }
    public static SharedPreferences getPrefs()
    {
        return prefs;
    }
    public static void update(String key, float value)
    {
        prefs.edit().putFloat(key, value).apply();
    }
}
