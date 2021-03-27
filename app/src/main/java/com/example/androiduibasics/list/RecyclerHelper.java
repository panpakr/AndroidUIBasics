package com.example.androiduibasics.list;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

import timber.log.Timber;

public class RecyclerHelper extends ItemTouchHelper.Callback {

    private ItemTouchHelperAdapter itemTouchHelperAdapter;

    RecyclerHelper(ItemTouchHelperAdapter itemTouchHelperAdapter){

        this.itemTouchHelperAdapter = itemTouchHelperAdapter;
    }


    @Override
    public boolean isLongPressDragEnabled() {
        return true;
    }

    @Override
    public boolean isItemViewSwipeEnabled() {
        return true;
    }

    @Override
    public int getMovementFlags(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder) {

        int dragFlags = ItemTouchHelper.DOWN|ItemTouchHelper.UP;
        int swipeFlags = ItemTouchHelper.START|ItemTouchHelper.END;
        Timber.w(" drag : " +dragFlags + "  swipe : " +swipeFlags);

        return makeMovementFlags(dragFlags,swipeFlags);
    }

    @Override
    public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder initial, @NonNull RecyclerView.ViewHolder target) {

       itemTouchHelperAdapter.onItemMove(initial.getAdapterPosition(),target.getAdapterPosition());

        return true;
    }

    @Override
    public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int i) {


        itemTouchHelperAdapter.onItemDismiss(viewHolder.getAdapterPosition());

    }
}
