package com.nextdot.realtimesearchwithrxandroid.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.nextdot.realtimesearchwithrxandroid.Model.RetrofitModel.NoticeItem;
import com.nextdot.realtimesearchwithrxandroid.Model.RetrofitModel.NoticeRoot;
import com.nextdot.realtimesearchwithrxandroid.R;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import butterknife.BindView;

/**
 * Created by sakib on 10/11/2017.
 */

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.MainAdapterViewHolder> {

    private final LayoutInflater inflater;

    private Context context;
    List<NoticeItem> list = Collections.emptyList();

    public MainAdapter(Context context, List<NoticeItem> list) {
        this.context = context;
        this.list = list;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public MainAdapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.item_main, parent, false);
        MainAdapterViewHolder mainAdapterViewHolder = new MainAdapterViewHolder(view);
        return mainAdapterViewHolder;
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public void onBindViewHolder(MainAdapterViewHolder holder, int position) {
        NoticeItem noticeItem = list.get(position);
        holder.name.setText(noticeItem.getTitle());
    }

    public class MainAdapterViewHolder extends RecyclerView.ViewHolder {

        TextView name, age;

        public MainAdapterViewHolder(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.name);
            age = (TextView) itemView.findViewById(R.id.age);
        }
    }

    public void setFilter(List<NoticeItem> searchlist){
        this.list.clear();
        this.list = searchlist ;
        notifyDataSetChanged();
    }

    public void clearList(){
        this.list.clear();
        notifyDataSetChanged();
    }
}

