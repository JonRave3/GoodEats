package cis436project4;

import android.content.Context;
import android.support.v4.view.LayoutInflaterFactory;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import goodeats.cis436project4.R;

/**
 * Created by JRavelo on 8/12/2017.
 */

public class ChipRecycleViewAdapter extends RecyclerView.Adapter {

    List<String> chipList;
    private Context context;

    public ChipRecycleViewAdapter(Context con) {
        context = con;
        for(String s : Chip.category){
            chipList.add(s);
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.chip_layout, null, false);
        return new ChipHolder(layoutView);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ChipHolder chipHolder = (ChipHolder) holder;
        //TODO create POJO for chips
        chipHolder.chipName.setText(Chip.category[position]);
        chipHolder.deleteIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.setVisibility(View.GONE);
            }
        });
    }
    @Override
    public int getItemCount() {
        return this.chipList.size();
    }



    public class ChipHolder extends RecyclerView.ViewHolder {
        private TextView chipName;
        private View deleteIcon;
        private View container;

        public ChipHolder(View itemView) {
            super(itemView);

            chipName = (TextView) itemView.findViewById(R.id.chip_name);
            deleteIcon = itemView.findViewById(R.id.chip_delete);
            container = itemView.findViewById(R.id.chip_container);
        }
    }
}