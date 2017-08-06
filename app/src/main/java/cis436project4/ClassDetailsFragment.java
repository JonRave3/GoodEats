package cis436project4;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import jravelo.cis436project4.R;

public class ClassDetailsFragment extends Fragment {

    private static final int TOTAL_POINTS = 10;
    float str_old_val, int_old_val, wis_old_val, dex_old_val;
    private int unused_points;
    RatingBar str_ratingBar, intel_ratingBar, wis_ratingBar, dex_ratingBar;
    TextView fragment_title, str_lbl, int_lbl, wis_lbl, dex_lbl, unused_points_lbl, unused_points_tv;
    String class_name, class_str, class_int, class_wis, class_dex;
    //TODO create a simple todo example
    public static ClassDetailsFragment newInstance(int index) {
        ClassDetailsFragment fragment = new ClassDetailsFragment();
        Bundle args = new Bundle();
        args.putInt("index", index);
        fragment.setArguments(args);
        return fragment;
    }//end of newInstance()
    public int index(){
        int id = 0;
        if(getArguments() != null)
            id = getArguments().getInt("index");
        return id;
    }//end of index()


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             final Bundle savedInstanceState) {
        RelativeLayout rl = new RelativeLayout(getActivity());
        rl.setPadding(10,10,10,10);
        init();
        initViews(getActivity());
        addViewsToLayout(rl);
        return rl;
    }//end of onCreateView()

    public void init() {
        //get the class that was clicked from the ClassListFragment
        class_name = Character.CLASSLIST[index()];
        setClassAttr();
    }//end of init()
    public void initViews(Activity act) {

        //get references for TextViews
        fragment_title = new TextView(act);
        unused_points_tv = new TextView(act);
        unused_points_lbl = new TextView(act);
        str_lbl = new TextView(act);
        int_lbl = new TextView(act);
        wis_lbl = new TextView(act);
        dex_lbl = new TextView(act);

        //get references for RatingBars
        str_ratingBar = new RatingBar(act);
        intel_ratingBar = new RatingBar(act);
        wis_ratingBar = new RatingBar(act);
        dex_ratingBar = new RatingBar(act);

        assignIDsToViews();
        formatViews();
        setRatings();

        //Setup Event Handlers
        str_ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                if(isUserInputValid()) {
                    saveState();
                    updateUnusedPointsLabel();
                }
            }
        });
        intel_ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                if(isUserInputValid()) {
                    saveState();
                    updateUnusedPointsLabel();
                }
            }
        });
        wis_ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                if(isUserInputValid()) {
                    saveState();
                    updateUnusedPointsLabel();
                }
            }
        });
        dex_ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                if(isUserInputValid()) {
                    saveState();
                    updateUnusedPointsLabel();
                }
            }
        });

    }//end of initViews()

    //View and Widget functions
    private void assignIDsToViews() {
        //assign IDs
        fragment_title.setId(R.id.frag_details_title);
        unused_points_tv.setId(R.id.unused_points_lbl);
        unused_points_lbl.setId(R.id.unused_points_lbl2);
        str_lbl.setId(R.id.str_lbl);
        int_lbl.setId(R.id.int_lbl);
        wis_lbl.setId(R.id.wis_lbl);
        dex_lbl.setId(R.id.dex_lbl);
        str_ratingBar.setId(R.id.str_rb);
        intel_ratingBar.setId(R.id.int_rb);
        wis_ratingBar.setId(R.id.wis_rb);
        dex_ratingBar.setId(R.id.dex_rb);
    }//end of assignIDsToViews()
    private void formatViews(){
        setTitleLayout();
        setStrTVLayout();
        setStrRBlayout();
        setIntTVLayout();
        setIntRBLayout();
        setWisTVLayout();
        setWisRBLayout();
        setDexTVLayout();
        setDexRBLayout();
        setUnusedPointsLbl();
        setUnusedPointsTV();
    }//end of formatViews()
    private void addViewsToLayout(RelativeLayout v) {
        //add views to parent layout
        v.addView(fragment_title);
        v.addView(unused_points_tv);
        v.addView(unused_points_lbl);
        v.addView(str_lbl);
        v.addView(int_lbl);
        v.addView(wis_lbl);
        v.addView(dex_lbl);
        v.addView(str_ratingBar);
        v.addView(intel_ratingBar);
        v.addView(wis_ratingBar);
        v.addView(dex_ratingBar);
    }//end of addViewsToLayout()
    private void setTitleLayout() {
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        params.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
        params.addRule(RelativeLayout.ALIGN_PARENT_TOP);
        fragment_title.setLayoutParams(params);
        fragment_title.setPadding(10,10,10,10);
        fragment_title.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        fragment_title.setTextSize(20);
        fragment_title.setAllCaps(true);
        fragment_title.setTextColor(Color.RED);

    }//end of setTitleLayout()
    private void setStrTVLayout() {
        RelativeLayout.LayoutParams params = layoutWrapWrap();
        params.addRule(RelativeLayout.BELOW, R.id.frag_details_title);
        params.addRule(RelativeLayout.ALIGN_PARENT_START);
        params.addRule(RelativeLayout.START_OF, R.id.str_rb);
        str_lbl.setLayoutParams(params);
        setDefaultTV(str_lbl);
        str_lbl.setText(R.string.strength);
    }//end of setStrTVLayout
    private void setStrRBlayout(){
        RelativeLayout.LayoutParams params = layoutWrapWrap();
        params.addRule(RelativeLayout.BELOW, R.id.frag_details_title);
        params.addRule(RelativeLayout.ALIGN_END, R.id.frag_details_title);
        str_ratingBar.setLayoutParams(params);
        setDefaultRB(str_ratingBar);
    }//end of setStrRBLayout
    private void setIntTVLayout(){
        RelativeLayout.LayoutParams params = layoutWrapWrap();
        params.addRule(RelativeLayout.BELOW, R.id.str_rb);
        params.addRule(RelativeLayout.ALIGN_PARENT_START);
        params.addRule(RelativeLayout.START_OF, R.id.str_rb);
        int_lbl.setLayoutParams(params);
        setDefaultTV(int_lbl);
        int_lbl.setText(R.string.intel);
    }//and or setIntTVLayout();
    private void setIntRBLayout() {
        RelativeLayout.LayoutParams params = layoutWrapWrap();
        params.addRule(RelativeLayout.BELOW, R.id.str_rb);
        params.addRule(RelativeLayout.ALIGN_END, R.id.frag_details_title);
        intel_ratingBar.setLayoutParams(params);
        setDefaultRB(intel_ratingBar);
    }//end of setIntRBLayout()
    private void setWisTVLayout() {
        RelativeLayout.LayoutParams params = layoutWrapWrap();
        params.addRule(RelativeLayout.BELOW, R.id.int_rb);
        params.addRule(RelativeLayout.START_OF, R.id.int_rb);
        params.addRule(RelativeLayout.ALIGN_PARENT_START);
        wis_lbl.setLayoutParams(params);
        setDefaultTV(wis_lbl);
        wis_lbl.setText(R.string.wisdom);
    }//end of setWisTVLayout()
    private void setWisRBLayout() {
        RelativeLayout.LayoutParams params = layoutWrapWrap();
        params.addRule(RelativeLayout.BELOW, R.id.int_rb);
        params.addRule(RelativeLayout.ALIGN_START, R.id.str_rb);
        wis_ratingBar.setLayoutParams(params);
        setDefaultRB(wis_ratingBar);
    }//end of setWisRBLayout()
    private void setDexTVLayout() {
        RelativeLayout.LayoutParams params = layoutWrapWrap();
        params.addRule(RelativeLayout.BELOW, R.id.wis_rb);
        params.addRule(RelativeLayout.START_OF, R.id.wis_rb);
        params.addRule(RelativeLayout.ALIGN_PARENT_START);
        dex_lbl.setLayoutParams(params);
        setDefaultTV(dex_lbl);
        dex_lbl.setText(R.string.dexterity);
    }//end of DexTVLayout()
    private void setDexRBLayout(){
        RelativeLayout.LayoutParams params = layoutWrapWrap();
        params.addRule(RelativeLayout.BELOW, R.id.wis_rb);
        params.addRule(RelativeLayout.ALIGN_START, R.id.str_rb);
        dex_ratingBar.setLayoutParams(params);
        setDefaultRB(dex_ratingBar);
    }//end of setDexRBLayout()
    private void setUnusedPointsTV(){
        RelativeLayout.LayoutParams params = layoutWrapWrap();
        params.addRule(RelativeLayout.BELOW, R.id.dex_rb);
        params.addRule(RelativeLayout.ALIGN_START, R.id.dex_lbl);
        unused_points_tv.setLayoutParams(params);
        unused_points_lbl.setPadding(20,20,20,20);
        unused_points_tv.setTextSize(16.0f);
        unused_points_tv.setText("Points left to spend: ");
    }//end of setUnusedPointsTV()
    private void setUnusedPointsLbl(){
        RelativeLayout.LayoutParams params = layoutWrapWrap();
        params.addRule(RelativeLayout.BELOW, R.id.dex_rb);
        params.addRule(RelativeLayout.RIGHT_OF, R.id.unused_points_lbl);
        unused_points_lbl.setLayoutParams(params);
        unused_points_tv.setPadding(0,20,0,20);
        unused_points_lbl.setTextSize(16.0f);
    }//end of setUnusedPointsLbl()
    private void setDefaultRB(RatingBar rb) {
        rb.setNumStars(4);
        rb.setStepSize(1.0f);
        rb.setRating(2.0f);
    }//end of setDefaultRB()
    private void setDefaultTV(TextView tv){
        tv.setTextSize(16.0f);
        tv.setPadding(10,10,10,10);
    }//end of setDefaultTV()
    private RelativeLayout.LayoutParams layoutWrapWrap() {
        return new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
    }//end of layoutWrapWrap()

    //Utility Functions
    private void saveState() {
        float strength, intell, wisdom, dexter;
        strength = str_ratingBar.getRating();
        intell = intel_ratingBar.getRating();
        wisdom = wis_ratingBar.getRating();
        dexter = dex_ratingBar.getRating();
        SharedPrefs.update(class_str, strength);
        SharedPrefs.update(class_int, intell);
        SharedPrefs.update(class_wis, wisdom);
        SharedPrefs.update(class_dex, dexter);
        str_old_val = strength;
        int_old_val = intell;
        wis_old_val = wisdom;
        dex_old_val = dexter;
    }//end of saveState()
    private void setClassAttr() {
        class_str = class_name +"_strength";
        class_int = class_name +"_intel";
        class_wis = class_name +"_wisdom";
        class_dex = class_name +"_dexterity";
    }//end of setClassAttr()
    private void setRatings() {
        //this version is for multi-activity (phone view)
        fragment_title.setText(class_name);
        float str_float = SharedPrefs.getPrefs().getFloat(class_str,0);
        float int_float = SharedPrefs.getPrefs().getFloat(class_int,0);
        float wis_float = SharedPrefs.getPrefs().getFloat(class_wis,0);
        float dex_float = SharedPrefs.getPrefs().getFloat(class_dex,0);

        //this is really messed up, for whatever reason the setRating() don't hold the assigned values
        do {
            str_ratingBar.setRating(str_float);
        }while(str_ratingBar.getRating() != str_float);

        do {
            intel_ratingBar.setRating(int_float);
        }while(intel_ratingBar.getRating() != int_float);

        do {
            wis_ratingBar.setRating(wis_float);
        }while(wis_ratingBar.getRating() != wis_float);

        do {
            dex_ratingBar.setRating(dex_float);
        }while(dex_ratingBar.getRating() != dex_float);

        //save shareprefs vals to the old vals
        str_old_val = str_float;
        int_old_val = int_float;
        wis_old_val = wis_float;
        dex_old_val = dex_float;

        updateUnusedPointsLabel();
    }//edn of setRatings();
    private int sumCurrentRatingBarValues() {
        float str_val = str_ratingBar.getRating();
        float int_val = intel_ratingBar.getRating();
        float wis_val = wis_ratingBar.getRating();
        float dex_val = dex_ratingBar.getRating();
        int total = (int)(str_val + int_val + wis_val + dex_val);
        return total;
    }//end of sumCurrentRatingBarValues()
    private void restoreRatingBarValues() {
        str_ratingBar.setRating(str_old_val);
        intel_ratingBar.setRating(int_old_val);
        wis_ratingBar.setRating(wis_old_val);
        dex_ratingBar.setRating(dex_old_val);
    }//end of restoreRatingBarValues()
    private void updateUnusedPointsLabel() {
        calculateUnusedPoints();
        unused_points_lbl.setText(Integer.toString(unused_points));
    }//end of updateUnusedPointsLabel()
    private void calculateUnusedPoints() {
        unused_points = TOTAL_POINTS - sumCurrentRatingBarValues();
    }//end of calculateUnusedPoints()
    private boolean isUserInputValid() {
        int sum = sumCurrentRatingBarValues();//get the current values from the RatingBars
        if(sum > TOTAL_POINTS) {
            restoreRatingBarValues();
            return false;
        }
        else {
            saveState();
            return true;
        }
    }//end of isUserInputValid()
}//end of ClassDetailsFragment.class
