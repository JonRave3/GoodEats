package cis436project4;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

import goodeats.cis436project4.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link SearchFragment.OnSearchFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link SearchFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SearchFragment extends Fragment {


    private OnSearchFragmentInteractionListener mListener;
    private StaggeredGridLayoutManager layoutManager;
    private EditText search_editText;
    private Button search_btn;
    private RecyclerView recyclerView;
    private ChipRecycleViewAdapter chipRecycleViewAdapter;

    public SearchFragment() {
        // Required empty public constructor
    }

    public static SearchFragment newInstance() {
        SearchFragment fragment = new SearchFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        init(this.getContext());
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View fragment = inflater.inflate(R.layout.fragment_search, container, false);
        recyclerView = (RecyclerView) fragment.findViewById(R.id.chip_recycler_view);
        search_editText = (EditText) fragment.findViewById(R.id.search_input_editText);
        search_btn = (Button) fragment.findViewById(R.id.search_submit_btn);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(chipRecycleViewAdapter);

        search_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onButtonPressed();
            }
        });
        return fragment;
    }

    private void init(Context context){
        layoutManager = new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL);
        chipRecycleViewAdapter = new ChipRecycleViewAdapter(context);

    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed() {
        //get the search params
        String[] params = search_editText.getText().toString().split(" ");
        //get the categories from the remaining chips
        String[] selectors = chipRecycleViewAdapter.getChipListToArray();
        //build a new query
        String rawQuery = FoodTableContract.FoodEntry.selectStr(params, selectors);
        SQLSingleton.selectQuery(rawQuery);

        if (mListener != null) {
            mListener.onSearchFragmentInteraction();
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnSearchFragmentInteractionListener) {
            mListener = (OnSearchFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnSearchFragmentInteractionListener {
        // TODO: Update argument type and name
        void onSearchFragmentInteraction();
    }

}
