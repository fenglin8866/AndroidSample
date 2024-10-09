package com.xxh.summary.viewpage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;


import com.xxh.summary.R;

import java.util.ArrayList;


public class MyAdapter2 extends BaseAdapter {

    private final int[] images = {R.drawable.ab1, R.drawable.ab2, R.drawable.ab3, R.drawable.ab4, R.drawable.ab1, R.drawable.ab2, R.drawable.ab3, R.drawable.ab4};
    private final int[] viewpage_images = {R.drawable.ab1, R.drawable.ab2, R.drawable.ab3, R.drawable.ab4};
    private ArrayList<ImageView> viewpage_imageList;


    private Context context;

    public MyAdapter2(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return images.length;
    }

    @Override
    public Object getItem(int position) {
        return images[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Holder holder;
        if (position == 3) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_viewpage, parent, false);
            Instantiation(convertView);
        } else {
            holder = new Holder();
            convertView = LayoutInflater.from(context).inflate(R.layout.item_layout, parent, false);
            holder.imageView = convertView.findViewById(R.id.iv);
            holder.imageView.setImageDrawable(context.getDrawable(images[position]));
        }


        return convertView;
    }

    public void Instantiation(View convertView) {

        // ViewPage_Detail = (ViewPager)convertView.findViewById(R.id.ViewPage_Detail);
        //point_detail = (LinearLayout)convertView.findViewById(R.id.point_detail);

        //初始化图片资源
        viewpage_imageList = new ArrayList<ImageView>();
        for (int i : viewpage_images) {
            // 初始化图片资源
            ImageView imageView = new ImageView(context);
            imageView.setBackgroundResource(i);
            viewpage_imageList.add(imageView);

        }

        //首页轮播
        CarouselShow2 carouselShow = new CarouselShow2(context, viewpage_imageList);
        carouselShow.CarouselShow_Info_Detail(convertView);
        //handler.sendEmptyMessageDelayed(0, 3000);

    }


    class Holder {
        ImageView imageView;
    }
}
