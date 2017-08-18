package cis436project4;

import android.widget.ImageView;
import android.widget.TextView;

import com.mindorks.placeholderview.annotations.Layout;
import com.mindorks.placeholderview.annotations.NonReusable;
import com.mindorks.placeholderview.annotations.Resolve;
import com.mindorks.placeholderview.annotations.View;

import goodeats.cis436project4.R;

/**
 * Created by JRavelo on 8/18/2017.
 */
@NonReusable
@Layout(R.layout.drawer_header)
public class DrawerHeader {
    @View(R.id.profileImageView)
    private ImageView profileImage;

    @View(R.id.nameTxt)
    private TextView nameTxt;

    @View(R.id.emailTxt)
    private TextView emailTxt;

    @Resolve
    private void onResolve(){
        nameTxt.setText("Jon Ravelo");
        emailTxt.setText("jravelo@umich.edu");
    }
}
