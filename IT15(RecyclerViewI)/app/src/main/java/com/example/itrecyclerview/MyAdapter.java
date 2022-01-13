package com.example.itrecyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    ArrayList<String> ItemList;

    //帶入ArrayList作為資料
    public MyAdapter(ArrayList<String> itemList) {
        this.ItemList = itemList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {      //創建一個新的viewholder
        View view = LayoutInflater.from(parent.getContext())                    //負責找尋res/layout 下的佈局檔，功能類似findViewById()
                .inflate(R.layout.list_content, parent, false);    //載入layout
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {   //將正確的viewholder連接到正確的positon
        holder.fileTitle.setText(ItemList.get(position));            //滑動畫面時，將資料位置綁至新的欄位，用新數據將之取代
    }

    //RecyclerView長度
    @Override
    public int getItemCount() {
        return ItemList.size();
    }              //回傳titlelist總共有幾筆資料

    class ViewHolder extends RecyclerView.ViewHolder {                  //綁定recycle的套件
        public TextView fileTitle;
        public ViewHolder(View holder) {
            super(holder);
            //綁定元件ID
            fileTitle = (TextView) holder.findViewById(R.id.fileTitle);
        }
    }
}