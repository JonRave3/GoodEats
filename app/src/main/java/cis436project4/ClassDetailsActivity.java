package cis436project4;

import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


public class ClassDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        SharedPrefs.init(this);
        super.onCreate(savedInstanceState);
        //don't start activity if in landscape orientation
        if(getResources().getConfiguration().getLayoutDirection()== Configuration.ORIENTATION_LANDSCAPE)
        {
            finish();
            return;
        }
        if(savedInstanceState == null)
        {
            ClassDetailsFragment cdf = new ClassDetailsFragment();
            cdf.setArguments(getIntent().getExtras());
            getFragmentManager().beginTransaction().add(android.R.id.content, cdf).commit();
        }
    }//end of onCreate()
}//end of ClassDetailsActivity.class
