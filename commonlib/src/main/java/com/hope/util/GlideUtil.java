package com.hope.util;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.hope.commonlib.R;

/**
 * @anthor FanHY
 * @time 2018/11/1
 * @describe
 */
public class GlideUtil {

    /**
     * 默认占位图和错误图
     *
     * @param context
     * @param imageView
     * @param url       网络/本地的绝对路径
     */
    public static void loadImage(Context context, ImageView imageView, String url) {
        Glide.with(context)
                .load(url)
                .placeholder(R.mipmap.image_placeholder)
                .error(R.mipmap.image_load_fail)
                .into(imageView);
        RequestOptions options = new RequestOptions()
                .placeholder(R.mipmap.image_placeholder)//加载成功之前占位图
                .error(R.mipmap.image_load_fail);//加载错误之后的错误图
//                .override(400,400)//指定图片的尺寸
//                .fitCenter()//指定图片的缩放类型为fitCenter （等比例缩放图片，宽或者是高等于ImageView的宽或者是高。）
//                .centerCrop()//指定图片的缩放类型为centerCrop （等比例缩放图片，直到图片的狂高都大于等于ImageView的宽度，然后截取中间的显示。）
//                .circleCrop()//指定图片的缩放类型为centerCrop （圆形）
//                .skipMemoryCache(true)//跳过内存缓存
//                .diskCacheStrategy(DiskCacheStrategy.ALL)//缓存所有版本的图像
//                .diskCacheStrategy(DiskCacheStrategy.NONE)//跳过磁盘缓存
//                .diskCacheStrategy(DiskCacheStrategy.DATA)//只缓存原来分辨率的图片
//                .diskCacheStrategy(DiskCacheStrategy.RESOURCE);//只缓存最终的图片
        Glide.with(context).load(url)
                .apply(options)
                .into(imageView);
    }
}
