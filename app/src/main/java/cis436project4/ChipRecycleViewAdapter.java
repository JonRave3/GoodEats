package cis436project4;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

import goodeats.cis436project4.R;

/**
 * Created by JRavelo on 8/12/2017.
 */

public class ChipRecycleViewAdapter extends RecyclerView.Adapter {

    ArrayList<String> chipList;
    Context context;
    public ChipRecycleViewAdapter(Context cont) {
        chipList = new ArrayList();
        for(String s : Chip.category){
            chipList.add(s);
        }
        context = cont;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View layoutView = inflater.inflate(R.layout.chip_layout, parent, false);
        return new ChipHolder(layoutView);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        final ChipHolder chipHolder = (ChipHolder) holder;
        chipHolder.chipName.setText(Chip.category[position]);
        chipHolder.deleteIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int pos = chipHolder.getLayoutPosition();
                chipList.remove(pos);
                notifyItemRemoved(pos);
            }
        });
    }

    @Override
    public int getItemCount() {
        return this.chipList.size();
    }

    public ArrayList<String> getChipList(){
        return this.chipList;
    }
    public String[] getChipListToArray() {
        String[] returnArray = new String[chipList.size()];
        for(int i=0; i < chipList.size(); i++){
            returnArray[i] = chipList.get(i);
        }
        return returnArray;
    }

    public class ChipHolder extends RecyclerView.ViewHolder {
        private TextView chipName;
        private ImageView deleteIcon;
        private RelativeLayout container;

        public ChipHolder(View itemView) {
            super(itemView);

            chipName = (TextView) itemView.findViewById(R.id.chip_name);
            deleteIcon = (ImageView) itemView.findViewById(R.id.chip_delete);
            container = (RelativeLayout) itemView.findViewById(R.id.chip_container);
        }
    }
}