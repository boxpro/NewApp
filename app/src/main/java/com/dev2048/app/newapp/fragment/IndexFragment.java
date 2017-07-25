package com.dev2048.app.newapp.fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import com.dev2048.app.newapp.R;
import com.dev2048.app.newapp.adapter.IndexAdapter;
import com.dev2048.app.newapp.base.BaseFragment;
import java.util.ArrayList;
import java.util.List;
import butterknife.BindView;

public class IndexFragment extends BaseFragment  {
    @BindView(R.id.index_swipe_container)
    SwipeRefreshLayout mIndexSwipeContainer;
    @BindView(R.id.index_recycle_view)
    RecyclerView mIndexRecycleView;
    private List<String> mArrayList = new ArrayList<>();
    private IndexAdapter mIndexAdapter = new IndexAdapter(getContext(),mArrayList);

    @Override
    protected int setLayout() {
        return R.layout.fragment_index;
    }

    @Override
    protected void initBiz() {
        initRecycle();
    }


    /**
     * 所有的本地相关函数处理
     *
     */
    private void initRecycle() {
        mIndexSwipeContainer.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                mIndexSwipeContainer.post(new Runnable() {
                    @Override
                    public void run() {
                        getDatas();
                    }
                });
            }
        });
        mIndexRecycleView.setLayoutManager(new LinearLayoutManager(mActivity));
        mIndexRecycleView.setAdapter(mIndexAdapter);
    }


    private void getDatas(){
        for (int i=0;i<100;i++){
            mArrayList.add("i");
        }
        mIndexAdapter.notifyDataSetChanged();

    }





}
