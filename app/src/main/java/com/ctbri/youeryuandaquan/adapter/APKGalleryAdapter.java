package com.ctbri.youeryuandaquan.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.ctbri.youeryuandaquan.R;
import com.ctbri.youeryuandaquan.data.APKData;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 梦思
 * @description 幼儿园列表适配器
 * @createTime 2014/1/22
 */
public class APKGalleryAdapter extends RecyclerView.Adapter<APKGalleryAdapter.ViewHolder> {
    private final List<APKData> mValues = new ArrayList<>();

    public APKGalleryAdapter() {

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item_agent, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.name.setText(holder.mItem.name);
        Picasso.with(holder.context).load(holder.mItem.iconPath).into(holder.imageView);
        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO
            }
        });
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView name;
        public final ImageView imageView;
        public final Context context;
        public APKData mItem;

        public ViewHolder(View view) {
            super(view);
            context = view.getContext();
            mView = view;
            name = (TextView) view.findViewById(R.id.tv_item_name);
            imageView = (ImageView) view.findViewById(R.id.iv_item_pic);
        }
    }

    public void add(List<APKData> items) {
        mValues.addAll(items);
    }

    public void clear() {
        mValues.clear();
    }
}
