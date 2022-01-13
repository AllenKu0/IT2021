package com.example.viewpager;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.PagerTabStrip;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    //負責儲存view的部分
    ArrayList<View> ViewContain = new ArrayList<View>();
    //負責存title
    ArrayList<String> titlecontain = new ArrayList<String>();
    ViewPager pager ;
    PagerTabStrip tabstrip;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pager = (ViewPager)findViewById(R.id.vw1);
        tabstrip = (PagerTabStrip) findViewById(R.id.tabstrip);
        //取消tab下面的長橫線
        tabstrip.setDrawFullUnderline(false);
        //設定tab的背景色
        tabstrip.setBackgroundResource(R.color.teal_200);
        //設定當前tab頁籤的下劃線顏色
        tabstrip.setTabIndicatorColorResource(R.color.purple_200);

        View view1 = LayoutInflater.from(this).inflate(R.layout.layout_tb1,null);
        View view2 = LayoutInflater.from(this).inflate(R.layout.layout_tb2,null);
        View view3 = LayoutInflater.from(this).inflate(R.layout.layout_tb3,null);
        ViewContain.add(view1);
        ViewContain.add(view2);
        ViewContain.add(view3);

        titlecontain.add("今日頭條");
        titlecontain.add("今日熱點");
        titlecontain.add("今日財經");

        pager.setAdapter(new MyPagerAdapters());
        pager.setCurrentItem(1);//指定跳到某頁，一定得設置在setAdapter後面
    }
    class MyPagerAdapters extends PagerAdapter{

        @Override
        public int getCount() {
            return ViewContain.size();
        }
        @Override
        public void destroyItem(ViewGroup container,int position,Object object){
            ((ViewPager)container).removeView(ViewContain.get(position));
        }
        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            //新增vieww
            ((ViewPager) container).addView(ViewContain.get(position));
            return ViewContain.get(position);
        }

        @Override
        public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
            return view == object;
        }
        @Override
        public  CharSequence getPageTitle(int position){
            //在TabStrip的文字
            return titlecontain.get(position);
        }
    }
}

