package cis436project4;

import android.app.Activity;
import android.content.Context;
import android.support.v4.widget.DrawerLayout;

import com.mindorks.placeholderview.PlaceHolderView;

import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.View;

import goodeats.cis436project4.R;

/**
 * Created by JRavelo on 8/18/2017.
 */

public class Drawer {
    private PlaceHolderView mDrawerView;
    private DrawerLayout mDrawer;
    private Toolbar mToolBar;
    private DrawerMenuItem home, search, favorites, exit;
    private DrawerHeader header;

    public Drawer(Activity activity){
        mDrawer = (DrawerLayout) activity.findViewById(R.id.drawerLayout);
        mDrawerView = (PlaceHolderView) activity.findViewById(R.id.drawerView);
        mToolBar = (Toolbar) activity.findViewById(R.id.toolbar);
        Context context = activity.getApplicationContext();

        header = new DrawerHeader();
        home = new DrawerMenuItem(context,DrawerMenuItem.DRAWER_MENU_ITEM_HOME);
        search = new DrawerMenuItem(context, DrawerMenuItem.DRAWER_MENU_ITEM_SEARCH);
        favorites = new DrawerMenuItem(context, DrawerMenuItem.DRAWER_MENU_ITEM_FAVORITES);
        exit = new DrawerMenuItem(context, DrawerMenuItem.DRAWER_MENU_ITEM_EXIT);
        home.setDrawerCallBack((DrawerMenuItem.DrawerCallBack) activity);
        search.setDrawerCallBack((DrawerMenuItem.DrawerCallBack) activity);
        favorites.setDrawerCallBack((DrawerMenuItem.DrawerCallBack) activity);
        exit.setDrawerCallBack((DrawerMenuItem.DrawerCallBack) activity);
        mDrawerView.addView(header).addView(home).addView(search).addView(favorites).addView(exit);

        int openStr = activity.getResources().getIdentifier("open_drawer", "string", activity.getCallingPackage());
        int closeStr = activity.getResources().getIdentifier("close_drawer", "string", activity.getCallingPackage());
        ActionBarDrawerToggle drawerToggle = new ActionBarDrawerToggle(activity, mDrawer, mToolBar, openStr, closeStr) {
            @Override
            public void onDrawerOpened(View drawerView){
                super.onDrawerOpened(drawerView);
            }
            @Override
            public void onDrawerClosed(View drawerView){
                super.onDrawerClosed(drawerView);
            }
        };
        mDrawer.addDrawerListener(drawerToggle);
        drawerToggle.syncState();
    }

    public void closeDrawer(){
        mDrawer.closeDrawer(Gravity.LEFT, true);
    }
}
