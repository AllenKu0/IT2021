package com.example.recycleview_plus;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Canvas;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.Adapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import it.xabaras.android.recyclerview.swipedecorator.RecyclerViewSwipeDecorator;

public class MainActivity extends AppCompatActivity {
    String list[]={"A","B","C","D","E","F","G","H","I","J"};
    ArrayList<String> data = new ArrayList<>();
    RecyclerView recyclerView;
    MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        for (int i = 0; i < list.length; i++) {
            data.add(list[i]);
        }
        recyclerView = (RecyclerView)findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
        adapter = new MyAdapter(data);
        recyclerView.setAdapter(adapter);
        //呼叫含有ItemTouchHelper功能的函數
        recyclerViewAction(recyclerView,data,adapter);
    }

    /*private class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder>{
        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item,parent,false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            holder.textView.setText(data.get(position));
        }

        @Override
        public int getItemCount() {
            return data.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder {
            TextView textView;
            public ViewHolder(@NonNull View itemView) {
                super(itemView);
                textView = itemView.findViewById(R.id.tx1);
            }
        }
    }*/
    private void recyclerViewAction(RecyclerView recyclerView, final ArrayList<String> choose,final MyAdapter adapter){
        ItemTouchHelper helper = new ItemTouchHelper(new ItemTouchHelper.Callback() {
            @Override
            public int getMovementFlags(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder) {
                //加入需要移動的方向，有分dragFlags和swipeFlags
                return makeMovementFlags(ItemTouchHelper.UP | ItemTouchHelper.DOWN , ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT);
            }
            @Override
            public void onSelectedChanged(RecyclerView.ViewHolder viewHolder, int actionState) {
                super.onSelectedChanged(viewHolder, actionState);
                // 當item被選取並且是在移動的狀態下
                if (actionState == ItemTouchHelper.ACTION_STATE_DRAG) {
                    // 將透明度設為原來的70%
                    viewHolder.itemView.setAlpha(0.5f);
                }
            }
            @Override
            public void clearView(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
                super.clearView(recyclerView, viewHolder);
                // 將Item的透明度復原，如果不這麼做移動後的透明度會維持剛剛的設定
                viewHolder.itemView.setAlpha(1.0f);
            }
            @Override
            //對資料移動作設定
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                int position_dragged = viewHolder.getAdapterPosition();       //選取的位置
                int position_target = target.getAdapterPosition();            //放置的位置
                Collections.swap(choose,position_dragged,position_target);   //交換陣列中兩資料位置，choose為陣列
                adapter.notifyItemMoved(position_dragged,position_target);   //告知配適器資料有更換
                return false;
            }

            @Override
            //對滑動做功能設定
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                int position = viewHolder.getAdapterPosition();
                switch(direction){
                    case ItemTouchHelper.LEFT:                  //資料左滑
                    case ItemTouchHelper.RIGHT:
                         choose.remove(position);               //移除資料
                         adapter.notifyItemRemoved(position);   //告知配適器資料有更換
                         if(position!=choose.size()){
                             adapter.notifyItemRangeChanged(position,choose.size()-position);  //開始改變的位置和總共被影響的位置數量，相當重要否則資料的position不會更改
                         }
                         break;
                }
            }
            @Override
            //如果希望加上圖片則需要以下
            public void onChildDraw(@NonNull Canvas c, @NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, float dX, float dY, int actionState, boolean isCurrentlyActive) {
                new RecyclerViewSwipeDecorator.Builder(c,recyclerView,viewHolder,dX,dY,actionState,isCurrentlyActive)
                        .addBackgroundColor(ContextCompat.getColor(MainActivity.this,android.R.color.holo_red_dark))    //設定圖的背景顏色，也可使用getResourses.getColor(id)
                        .addActionIcon(R.drawable.ic_baseline_delete_24)                                                        //設定圖片
                        .create()
                        .decorate();
                //拖曳狀態下不做改變需要呼叫父類別的方法
                super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive);
            }
        });
        helper.attachToRecyclerView(recyclerView);                //綁上recyclerView
    }
}