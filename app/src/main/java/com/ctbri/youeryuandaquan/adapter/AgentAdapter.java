package com.ctbri.youeryuandaquan.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.ctbri.youeryuandaquan.R;
import com.ctbri.youeryuandaquan.data.YouErYuanData;
import com.ctbri.youeryuandaquan.fragment.FavFragment;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * @author 梦思
 * @description 幼儿园列表适配器
 * @createTime 2014/1/22
 */
public class AgentAdapter extends RecyclerView.Adapter<AgentAdapter.ViewHolder> {
    private final List<YouErYuanData> mValues;
    private final FavFragment.OnListFragmentInteractionListener mListener;

    public AgentAdapter(List<YouErYuanData> items, FavFragment.OnListFragmentInteractionListener listener) {
        mValues = items;
        mListener = listener;
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
        holder.mark.setText(holder.mItem.mark + "");
        Picasso.with(holder.context).load(holder.mItem.cover).into(holder.imageView);
        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                    mListener.onListFragmentInteraction(holder.mItem);
                }
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
        public final TextView mark;
        public final ImageView imageView;
        public final Context context;
        public YouErYuanData mItem;

        public ViewHolder(View view) {
            super(view);
            context=view.getContext();
            mView = view;
            name = (TextView) view.findViewById(R.id.tv_item_name);
            mark = (TextView) view.findViewById(R.id.tv_item_mark);
            imageView = (ImageView) view.findViewById(R.id.iv_item_pic);
        }
    }

}
