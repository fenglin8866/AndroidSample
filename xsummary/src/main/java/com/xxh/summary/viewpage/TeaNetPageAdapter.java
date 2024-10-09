package com.xxh.summary.viewpage;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.viewpager.widget.PagerAdapter;


import com.xxh.summary.R;

import java.util.ArrayList;

/**
 * 作者: yzp on 2016-09-07.
 * E-mail: 15111424807@163.com
 * QQ: 486492302
 */
public class TeaNetPageAdapter extends PagerAdapter {

    private ArrayList<Integer> viewpage_imageList;
    private Context context;
    private final int[] viewpage_images = {R.drawable.ab1, R.drawable.ab2, R.drawable.ab3, R.drawable.ab4};
    public TeaNetPageAdapter(Context context,ArrayList<Integer> viewpage_imageList) {
        this.context=context;
        this.viewpage_imageList = viewpage_imageList;

    }
    // 需要实现以下四个方法

    @Override
    public int getCount() {
//        return Integer.MAX_VALUE;
        return viewpage_images.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        // 判断view和Object对应是否有关联关系
        if (view == object) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        // 获得相应位置上的view； container view的容器，其实就是viewpage自身,
        // position: viewpager上的位置
        // 给container添加内容
        Log.i("xxxh","p="+position);
        View view = LayoutInflater.from(context).inflate(R.layout.item_viewpage_layout, container, false);
        ImageView imageView = view.findViewById(R.id.action_image);
        TextView textView = view.findViewById(R.id.text);
        imageView.setImageDrawable(context.getDrawable(viewpage_images[position % viewpage_imageList.size()]));
        textView.setText("xxxxxxxxxxxasdasdfasdf   " + position);
        //container.addView(viewpage_imageList.get(position % viewpage_imageList.size()));
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        // 销毁对应位置上的Object
        // super.destroyItem(container, position, object);
        container.removeView((View) object);
        object = null;
    }
}

