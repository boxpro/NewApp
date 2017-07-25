package com.dev2048.app.newapp.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dev2048.app.newapp.R;


import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/7/25.
 */

public class IndexAdapter extends RecyclerView.Adapter<IndexAdapter.IndexViewHolder> {
    private List<String> mDatas;
    private Context mContext;

    public IndexAdapter(Context context, List<String> datas) {
        this.mContext = context;
        this.mDatas = datas;
    }

    @Override
    public IndexViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        IndexViewHolder indexViewHolder  = new IndexViewHolder(LayoutInflater.from(
                mContext).inflate(R.layout.item_index_view, parent,
                false));
        return indexViewHolder;
    }

    @Override
    public void onBindViewHolder(IndexViewHolder holder, int position) {
            holder.textName.setText(mDatas.get(position));
    }

    @Override
    public int getItemCount() {
        if (mDatas != null) {
            return mDatas.size();
        } else
            return 0;
    }

    class IndexViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.text_name)
        TextView textName;
        public IndexViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }

}
