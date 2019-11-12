package com.example.customdefine;

import android.content.Context;
import androidx.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.List;

/**
 * User : Blues
 * Date : 2019/2/26
 * Time : 09:24
 * Email : huajianlan@rastar.com
 */

public class ImagePagerAdapter extends PagerAdapter {

    private List<String> mDatas;
    private Context mContext;

    public ImagePagerAdapter(Context mContext, List<String> mDatas) {
        this.mDatas = mDatas;
        this.mContext = mContext;
    }

    @Override
    public int getCount() {
        return mDatas.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view == o;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        ImageView imageView = new ImageView(mContext);
        Glide.with(mContext).load(mDatas.get(position)).into(imageView);
        container.addView(imageView);
        return imageView;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {

        container.removeView((View) object);
//        super.destroyItem(container, position, object);
    }

}
