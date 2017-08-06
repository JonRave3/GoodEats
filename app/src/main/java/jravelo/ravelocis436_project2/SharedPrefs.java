package jravelo.ravelocis436_project2;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by JRavelo on 7/3/2017.
 */

public class SharedPrefs {
    private static String pkg_name = "jravelo.ravelocis436_project2";
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
