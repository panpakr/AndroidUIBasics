package com.example.androiduibasics.list;

import android.graphics.Rect;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;

public class OffsetDecoration extends RecyclerView.ItemDecoration {


    @Override
    public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {

        //super.getItemOffsets(outRect, view, parent, state);

        outRect.set(0,12,0,12);

    }
}
