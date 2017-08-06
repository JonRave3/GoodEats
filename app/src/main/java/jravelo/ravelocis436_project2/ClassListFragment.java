package jravelo.ravelocis436_project2;


import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.app.ListFragment;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ClassListFragment extends ListFragment {

    boolean two_panes;
    int position = 0;

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        //get ListView and populate with Character.class values
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_activated_1, Character.CLASSLIST);
        setListAdapter(arrayAdapter);

        //get the ClassDetailsFragment
        View classDetail = getActivity().findViewById(R.id.class_details_fragment);
        //check if Orientation
        two_panes = (classDetail != null && classDetail.getVisibility() == View.VISIBLE);

        if(savedInstanceState != null)
        {
            position = savedInstanceState.getInt("selection", 0);
        }
        if(two_panes)
        {
            getListView().setChoiceMode(ListView.CHOICE_MODE_SINGLE);
            displayDetailsFragment(position);
        }
    }//end of onActivityCreated()

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("selection", position);
    }//end of onSaveInstanceState()

    @Override
    public void onListItemClick(ListView l, View v, int pos, long id) {
        displayDetailsFragment(pos);
    }//end of onListItemClick()

    private void displayDetailsFragment(int id) {
        position = id;
        if(two_panes) {

            getListView().setItemChecked(id, true);
            ClassDetailsFragment cdf = (ClassDetailsFragment) getActivity().getFragmentManager().findFragmentById(R.id.class_details_fragment);

            if(cdf == null || cdf.index() != id)
            {
                //fragments are not dynamically allocated - cannot use fragmentTransactions
                cdf = ClassDetailsFragment.newInstance(id);
                FragmentTransaction fm = getFragmentManager().beginTransaction();
                fm.replace(R.id.class_details_fragment, cdf).setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE).commit();
            }
        }
        else {
            Intent intent = new Intent();
            intent.setClass(getActivity(), ClassDetailsActivity.class);
            intent.putExtra("index", id);
            startActivity(intent);
        }
    }//end of displayDetailsFragment()

}//end of ClassListFragment.class
