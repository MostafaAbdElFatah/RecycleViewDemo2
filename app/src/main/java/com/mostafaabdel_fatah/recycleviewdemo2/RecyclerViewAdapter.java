package com.mostafaabdel_fatah.recycleviewdemo2;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Mostafa AbdEl_Fatah on 9/7/2017.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.RecyclerViewHolder> {

    final static int Type_Head = 0;
    final static int Type_List = 1;
    ArrayList<ListProvider> arrayList = new ArrayList<ListProvider>();

    public RecyclerViewAdapter(ArrayList<ListProvider> arrayList) {
        this.arrayList = arrayList;
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        RecyclerViewHolder recyclerViewHolder;
        if (viewType == Type_List ) {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_layout, parent, false);
            recyclerViewHolder = new RecyclerViewHolder(view,viewType);
            return recyclerViewHolder;
        }else if (viewType == Type_Head ){
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.header_layout, parent, false);
            recyclerViewHolder = new RecyclerViewHolder(view,viewType);
            return recyclerViewHolder;
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {
        ListProvider listProvider;
        if (holder.type == Type_List) {
            listProvider = arrayList.get(position-1);
            holder.imageView.setImageResource(listProvider.getImageId());
            holder.countryText.setText(listProvider.getCountry());
            holder.capitalText.setText(listProvider.getCapital());
        }
    }

    @Override
    public int getItemCount() {
        return arrayList.size()+1;
    }

    public  static class RecyclerViewHolder extends RecyclerView.ViewHolder {

        int type;
        ImageView imageView;
        TextView countryText,capitalText;
        TextView flagTextFlag,countryTextFlag,capitalTextFlag;

        public RecyclerViewHolder(View itemView ,int viewType) {
            super(itemView);
            if (viewType == Type_List) {
                imageView = (ImageView) itemView.findViewById(R.id.imageView);
                countryText = (TextView) itemView.findViewById(R.id.countryTextView);
                capitalText = (TextView) itemView.findViewById(R.id.capitalTextView);
                type = 1;
            }else if (viewType == Type_Head){
                flagTextFlag    = (TextView) itemView.findViewById(R.id.flagHeader);
                countryTextFlag = (TextView) itemView.findViewById(R.id.countryHeader);
                capitalTextFlag = (TextView) itemView.findViewById(R.id.capitalHeader);
                type = 0;
            }
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0)
            return Type_Head;
        return Type_List;
    }
}
