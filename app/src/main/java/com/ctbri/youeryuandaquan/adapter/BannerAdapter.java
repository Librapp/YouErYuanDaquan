package com.ctbri.youeryuandaquan.adapter;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.ctbri.youeryuandaquan.data.AdData;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Luke on 2016/3/25 0025.
 */
public class BannerAdapter extends PagerAdapter {
    private List<AdData> datas;

    public BannerAdapter(List<AdData> datas){
        this.datas=datas;
    }
    @Override
    public int getCount() {
        return datas.size();
    }

    @Override
    public boolean isViewFromObject(View arg0, Object arg1) {
        return arg0 == arg1;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        ImageView ic = new ImageView(container.getContext());
        ic.setLayoutParams(new ViewGroup.LayoutParams(320, 180));
        ic.setScaleType(ImageView.ScaleType.FIT_XY);
        Picasso.with(container.getContext()).load(datas.get(position).imgUrl).into(ic);
        container.addView(ic, position);
        return ic;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(container.getChildAt(position));
    }
}
