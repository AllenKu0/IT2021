package com.example.banner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.widget.ExpandableListView;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ArrayList<String> images = new ArrayList<>();
        ArrayList<String> title = new ArrayList<>();
        Banner banner = (Banner) findViewById(R.id.banner);

        images.add("https://www.asus.com/tw/events/eventES/epic/1185.jpg");
        images.add("https://www.i-spotmedia.com/Blog/wp-content/uploads/2018/06/youtube-ads-part1-cover-0706-1024x518.png");
        images.add("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQvV_0xWbMC1jBpcBukePRC34c9mklb_dDJuw&usqp=CAU");
        images.add("https://imjaylin.com/wp-content/uploads/2020/08/Instagram%E5%BB%A3%E5%91%8A%E6%8A%95%E6%94%BE%E6%AD%A5%E9%A9%9F-740x389.jpg");
        title.add("天天向上");
        title.add("日行一善");
        title.add("每日任務");
        title.add("好好學習");
        //設置圖片輪播的撥放器
        banner.setImageLoader(new GlideImageLoader());
        //設置圖片得集合
        banner.setImages(images);
        //設置標題集合（當banner樣式有顯示title時）
        banner.setBannerTitles(title);
        //設置banner的樣式，此樣式可以包含title
        banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE_INSIDE);
        //設置下方點的位置
        //banner.setIndicatorGravity(BannerConfig.CENTER);
        //設置自動輪播，默認為true
        banner.isAutoPlay(true);
        //設置輪播的時間，單位毫秒
        banner.setDelayTime(3000);
        //啟動banner，放在最後
        banner.start();
    }
    public class GlideImageLoader extends ImageLoader {
        @Override
        public void displayImage(Context context, Object path, ImageView imageView) {
            Glide.with(context).load(path).into(imageView);
        }
    }
}