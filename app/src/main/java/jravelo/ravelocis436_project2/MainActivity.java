package jravelo.ravelocis436_project2;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        SharedPrefs.init(this);
        SharedPreferences.Editor spe = SharedPrefs.getPrefs().edit();
        spe.putFloat("Warrior_str",0).apply();
        spe.putFloat("Warrior_int",0).apply();
        spe.putFloat("Warrior_wis",0).apply();
        spe.putFloat("Warrior_dex",0).apply();
        spe.putFloat("Mage_str",0).apply();
        spe.putFloat("Mage_int",0).apply();
        spe.putFloat("Mage_wis",0).apply();
        spe.putFloat("Mage_dex",0).apply();
        spe.putFloat("Healer_str",0).apply();
        spe.putFloat("Healer_int",0).apply();
        spe.putFloat("Healer_wis",0).apply();
        spe.putFloat("Healer_dex",0).apply();
        spe.putFloat("Hunter_str",0).apply();
        spe.putFloat("Hunter_int",0).apply();
        spe.putFloat("Hunter_wis",0).apply();
        spe.putFloat("Hunter_dex",0).apply();
        spe.putFloat("Paladin_str",0).apply();
        spe.putFloat("Paladin_int",0).apply();
        spe.putFloat("Paladin_wis",0).apply();
        spe.putFloat("Paladin_dex",0).apply();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }//end of onCreate()

}
