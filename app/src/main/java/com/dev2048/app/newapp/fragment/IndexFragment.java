package com.dev2048.app.newapp.fragment;
import android.support.v7.widget.RecyclerView;
import android.widget.ArrayAdapter;

import com.dev2048.app.newapp.R;
import com.dev2048.app.newapp.base.BaseFragment;

import java.util.ArrayList;

import butterknife.BindView;
import xiao.free.refreshlayoutlib.SwipeRefreshLayout;
import xiao.free.refreshlayoutlib.base.OnLoadMoreListener;
import xiao.free.refreshlayoutlib.base.OnRefreshListener;

public class IndexFragment extends BaseFragment implements OnRefreshListener, OnLoadMoreListener {
    @BindView(R.id.index_swipe_container)
    SwipeRefreshLayout mIndexSwipeContainer;
    @BindView(R.id.index_recycle_view)
    RecyclerView mIndexRecycleView;

    private ArrayList<String> mArrayList = new ArrayList<>();



    @Override
    protected int setLayout() {
        return R.layout.fragment_index;
    }

    @Override
    protected void initView() {
         initRecycle();
    }

    private void initRecycle() {
        mIndexSwipeContainer.setOnRefreshListener(this);
        mIndexSwipeContainer.setOnLoadMoreListener(this);
    }

    @Override
    public void onLoadMore() {

    }

    @Override
    public void onRefresh() {
        mIndexSwipeContainer.postDelayed(new Runnable() {
            @Override
            public void run() {

            }
        },3000);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initConfig() {

    }
//测试专用
    private ArrayList<String> getData() {
        for (int i=0; i<50; i++){
            mArrayList.add("测试数据" + i);
        }
        return mArrayList;
    }

}
