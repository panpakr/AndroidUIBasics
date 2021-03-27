package com.example.androiduibasics.list;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.androiduibasics.R;

import java.util.Collections;
import java.util.List;

import timber.log.Timber;

public class TestAdapter extends RecyclerView.Adapter<TestAdapter.MyViewHolder> implements ItemTouchHelperAdapter{


    private OnItemClickListener onItemClickListener;
    private List<TestData> data;

    public TestAdapter(List<TestData> data) {
        this.data = data;
    }

    @Override
    public void onItemMove(int fromPosition, int toPosition) {

        for (int i = fromPosition; i < toPosition; i++) {
            Collections.swap(data, i, i + 1);
        }



    }

    @Override
    public void onItemDismiss(int position) {

        data.remove(position);
        notifyItemRemoved(position);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView title;
        private TextView time;
        private ImageView logo;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            logo = itemView.findViewById(R.id.iv_logo);
            title = itemView.findViewById(R.id.tv_title);
            time = itemView.findViewById(R.id.tv_time);

        }

    }

    void setOnItemClickListener(OnItemClickListener onItemClickListener){
        this.onItemClickListener = onItemClickListener;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_row, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(view);

        Timber.e("Creating Views @ "+parent.getChildCount());
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, final int i) {

        Timber.w("Binding Views @ " + i);

        //Teach with Glide Library
        Glide.with(myViewHolder.itemView).load(data.get(i).getImgURL()).into(myViewHolder.logo);

        myViewHolder.title.setText(data.get(i).getTitle());
        myViewHolder.title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(onItemClickListener !=null){

                    Timber.d("Test ");
                    onItemClickListener.itemClick(data.get(i));
                }

            }
        });


        myViewHolder.time.setText(data.get(i).getTime());

    }

    @Override
    public int getItemCount() {
       // Timber.w("Counting Items " );

        return data.size();
    }


    public interface OnItemClickListener {
        void itemClick(TestData testData);

    }
}

