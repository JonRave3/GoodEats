package cis436project4;

import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;

import com.mindorks.placeholderview.annotations.Click;
import com.mindorks.placeholderview.annotations.Layout;
import com.mindorks.placeholderview.annotations.Resolve;
import com.mindorks.placeholderview.annotations.View;

import goodeats.cis436project4.R;

/**
 * Created by JRavelo on 8/18/2017.
 */
@Layout(R.layout.drawer_item)
public class DrawerMenuItem {
    public static final int DRAWER_MENU_ITEM_HOME = 1;
    public static final int DRAWER_MENU_ITEM_SEARCH = 2;
    public static final int DRAWER_MENU_ITEM_FAVORITES = 3;
    public static final int DRAWER_MENU_ITEM_EXIT = 4;

    private int mMenuPosition;
    private Context mContext;
    private DrawerCallBack mCallBack;

    @View(R.id.itemNameTxt)
    private TextView itemNameTxt;

    @View(R.id.itemIcon)
    private ImageView itemIcon;

    public DrawerMenuItem(Context context, int menuPosition){
        mContext = context;
        mMenuPosition = menuPosition;
        if(context instanceof DrawerCallBack){
            mCallBack = (DrawerCallBack) context;
        }
    }

    @Resolve
    private void onResolved(){
        switch(mMenuPosition){
            case DRAWER_MENU_ITEM_SEARCH:
                itemNameTxt.setText("Search");
                itemIcon.setImageResource(R.drawable.ic_search_black_24dp);
                break;
            case DRAWER_MENU_ITEM_FAVORITES:
                itemNameTxt.setText("Favorites");
                itemIcon.setImageResource(R.drawable.ic_favorite_black_24dp);
                break;
            case DRAWER_MENU_ITEM_EXIT:
                itemNameTxt.setText("Exit");
                itemIcon.setImageResource(R.drawable.ic_exit_to_app_black_24dp);
                break;
            default:
                itemNameTxt.setText("Home");
                itemIcon.setImageResource(R.drawable.ic_home_black_24dp);
                break;
        }
    }
    @Click(R.id.mainView)
    private void onMenuItemClick(){
        switch(mMenuPosition){
            case DRAWER_MENU_ITEM_SEARCH:
                if(mCallBack != null) mCallBack.onSearchMenuSelected();
                break;
            case DRAWER_MENU_ITEM_FAVORITES:
                if(mCallBack != null) mCallBack.onFavoritesMenuSelected();
                break;
            case DRAWER_MENU_ITEM_EXIT:
                if(mCallBack != null) mCallBack.onExitMenuSelected();
            default:
                if(mCallBack != null) mCallBack.onHomeMenuSelected();
                break;
        }
    }

    public void setDrawerCallBack(DrawerCallBack callBack){
        mCallBack = callBack;
    }
    public interface DrawerCallBack{
        void onSearchMenuSelected();
        void onFavoritesMenuSelected();
        void onHomeMenuSelected();
        void onExitMenuSelected();
    }

}
