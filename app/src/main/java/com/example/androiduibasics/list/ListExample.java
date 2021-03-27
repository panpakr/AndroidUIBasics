package com.example.androiduibasics.list;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.helper.ItemTouchHelper;

import com.example.androiduibasics.R;

import java.util.ArrayList;
import java.util.List;

import timber.log.Timber;

public class ListExample extends AppCompatActivity implements TestAdapter.OnItemClickListener{

    private List<TestData> data;

    private RecyclerView recyclerView;
    private SwipeRefreshLayout swipeRefreshLayout;

    private TestAdapter testAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        initViews();
        createListData();
        initRecyclerView();
        initListView();
        initTouchHelper();


    }

    private void initTouchHelper() {

        ItemTouchHelper.Callback recyclerHelper = new RecyclerHelper(testAdapter);
        ItemTouchHelper touchHelper = new ItemTouchHelper(recyclerHelper);

        touchHelper.attachToRecyclerView(recyclerView);
    }

    private void createListData() {

        data = new ArrayList<>();


        TestData testData1 = new TestData("https://picsum.photos/20/30", "Heading 0", "08:00");
        TestData testData2 = new TestData("https://picsum.photos/200/300", "Heading 1", "06:00");
        TestData testData3 = new TestData("https://picsum.photos/200/300", "Heading 2", "09:00");
        TestData testData4 = new TestData("https://picsum.photos/200/300", "Heading 3", "12:00");
        TestData testData5 = new TestData("https://picsum.photos/200/300", "Heading 4", "16:00");


        data.add(testData1);
        data.add(testData2);
        data.add(testData3);
        data.add(testData4);
        data.add(testData5);


        for (int count = 0; count <= 50; count++) {

            TestData testData = new TestData("https://picsum.photos/20/30", "Heading "+(count+5), "08:00");

            data.add(testData);
        }
    }

    private void initListView() {
    }

    private void initRecyclerView() {


        //1. Show First Default Vertical
        final LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);

        //LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);

        // GridLayoutManager gridLayoutManager = new GridLayoutManager(this,2);

        //StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);


        recyclerView.setLayoutManager(layoutManager);

        testAdapter = new TestAdapter(data);
        recyclerView.setAdapter(testAdapter);


        //1.Show On Item click listener first on directly but when u want to
        // interact with activity  show listener

        //2. Show to implement not only on title but completely on ViewGroup Container
        testAdapter.setOnItemClickListener(this);


        //show  how to use swipeToRefresh  without setting setRefreshing(false ) to dismiss


        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {

                Timber.d("Trying to refresh");


                swipeRefreshLayout.setRefreshing(false);

            }
        });


        //4. To Show Divider and Offset use background on row xml

        //Divider Decoration
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(dividerItemDecoration);

        OffsetDecoration offsetDecoration = new OffsetDecoration();
         recyclerView.addItemDecoration(offsetDecoration);


        DefaultItemAnimator defaultItemAnimator = new DefaultItemAnimator();
        TestAnimator testAnimator = new TestAnimator();
        recyclerView.setItemAnimator(defaultItemAnimator);

        //Optimistation When No shape is changing
        recyclerView.setHasFixedSize(true);


        Timber.w("Total Child " + layoutManager.getChildCount());
        Timber.w("Total Items " + layoutManager.getItemCount());

        Timber.w("Total Items Adapter  " + testAdapter.getItemCount());


        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                int visibleItemCount = layoutManager.getChildCount();
                int totalItemCount = layoutManager.getItemCount();

                int firstCompletelyVisibleItemPosition  =((LinearLayoutManager) layoutManager).findFirstCompletelyVisibleItemPosition();
                int lastVisibleItemPosition = ((LinearLayoutManager) layoutManager).findLastVisibleItemPosition();
                int lastCompletelyVisibleItemPosition = ((LinearLayoutManager) layoutManager).findLastCompletelyVisibleItemPosition();
                int firstVisibleItemPosition =  ((LinearLayoutManager) layoutManager).findFirstVisibleItemPosition();




              /*  Timber.w("Scrolling Childs " + visibleItemCount);
                Timber.w("Scrolling Total Items " +totalItemCount);

                Timber.e("firstVisibleItemPosition " +firstVisibleItemPosition);
                Timber.e("firstCompletelyVisibleItemPosition " +firstCompletelyVisibleItemPosition);
                Timber.e("lastVisibleItemPosition " +lastVisibleItemPosition);
                Timber.e("lastCompletelyVisibleItemPosition " +lastCompletelyVisibleItemPosition);
                */


                if(firstVisibleItemPosition+visibleItemCount >= totalItemCount){

                    Timber.w("Scrolling i am ");

                }




            }
        });


    }

    private void initViews() {

        swipeRefreshLayout = findViewById(R.id.swipe);
        recyclerView = findViewById(R.id.list);


    }

    @Override
    public void itemClick(TestData testData) {

        Timber.d(" TestData :" + testData.getTitle());

    }

}
