package com.tx.zq.recyctest;

/**
 * Created by Administrator on 2016/4/12.
 */
public interface ItemTouchHelperAdapter {

    void onItemMove(int fromPosition, int toPosition);

    void onItemDismiss(int position);
}