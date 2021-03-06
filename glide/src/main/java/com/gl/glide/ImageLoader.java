package com.gl.glide;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.gl.glide.transformation.BlurTransformation;
import com.gl.glide.transformation.RoundedCornersTransformation;


public class ImageLoader {
    public static ImageLoader instance;
    public static RequestOptions options;

    private ImageLoader() {
    }

    public static ImageLoader getInstance() {
        if (instance == null) {
            instance = new ImageLoader();
            options = new RequestOptions()
//                .placeholder(R.drawable.ic_launcher)// 正在加载中的图片
//                .error(R.drawable.video_error) // 加载失败的图片
//                    .transform(new RoundedCornersTransformation(20, 0))
                    .transform(new BlurTransformation(App.context,20))
                    .diskCacheStrategy(DiskCacheStrategy.ALL); // 磁盘缓存策略

        }
        return instance;
    }

    /**
     * 使用Glide加载圆形ImageView(如头像)时，不要使用占位图
     *
     * @param context context
     * @param url     image url
     * @param iv      imageView
     */
    public void load(Context context, String url, ImageView iv) {

        Glide.with(context)
                .load(new MyGlideUrl(url))
                .apply(options)
                .centerCrop()
                .diskCacheStrategy(DiskCacheStrategy.RESOURCE) //DiskCacheStrategy.NONE
                .into(iv);

    }
}