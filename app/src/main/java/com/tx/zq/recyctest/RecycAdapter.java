package com.tx.zq.recyctest;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Administrator on 2016/4/12.
 */
public class RecycAdapter extends RecyclerView.Adapter<RecycAdapter.a> implements  ItemTouchHelperAdapter {
    private Context context;
    private ArrayList list;

    public RecycAdapter(Context context, ArrayList list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public a onCreateViewHolder(ViewGroup parent, int viewType) {
        a a = new a(LayoutInflater.from(context).inflate(R.layout.a, null));

        return a;
    }

    @Override
    public void onBindViewHolder(a holder, final int position) {
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,position+"",0).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public void onItemMove(int fromPosition, int toPosition) {
        Collections.swap(list,fromPosition,toPosition);
        notifyItemMoved(fromPosition, toPosition);
    }

    @Override
    public void onItemDismiss(int position) {
        list.remove(position);
        notifyItemRemoved(position);
    }

    class a extends RecyclerView.ViewHolder implements  ItemTouchHelperViewHolder {
        public a(View itemView) {
            super(itemView);
        }
        @Override
        public void onItemSelected() {
            itemView.setBackgroundColor(Color.CYAN);
        }

        @Override
        public void onItemClear() {
            itemView.setBackgroundColor(0);
        }
    }


}
