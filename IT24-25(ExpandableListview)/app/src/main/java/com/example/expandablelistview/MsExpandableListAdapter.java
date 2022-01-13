package com.example.expandablelistview;

import android.content.Context;
import android.database.DataSetObserver;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MsExpandableListAdapter implements ExpandableListAdapter {

    private ArrayList<Group> gData;
    private ArrayList<ArrayList<Content>> iData;
    private Context mContext;

    public MsExpandableListAdapter(ArrayList<Group> gData,ArrayList<ArrayList<Content>> iData, Context mContext) {
        this.gData = gData;
        this.iData = iData;
        this.mContext = mContext;
    }
    @Override
    public void registerDataSetObserver(DataSetObserver observer) {

    }

    @Override
    public void unregisterDataSetObserver(DataSetObserver observer) {

    }
    //取得組的大小
    @Override
    public int getGroupCount() {
        return gData.size();
    }
    //取得子類的大小
    @Override
    public int getChildrenCount(int groupPosition) {
        return iData.get(groupPosition).size();
    }
    //取的組的資料
    @Override
    public Object getGroup(int groupPosition) {
        return gData.get(groupPosition);
    }
    //取得子類的資料
    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return iData.get(groupPosition).get(childPosition);
    }
    //取得指定組的位置id
    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }
    //取得指定子類的位置id
    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }
    //組和子元素是否有穩定的ID,也就是底層資料的改變不會影響到它們。
    @Override
    public boolean hasStableIds() {
        return true;
    }
    //設定子類別是否可以選擇
    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
    private static class ViewHolderGroup{
        private TextView group_name;
    }

    private static class ViewHolderItem{
        private TextView language_name;
    }
    //取得組的View，內包含創建
    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        ViewHolderGroup groupHolder;
        //convertView負責存已建立的View
        if(convertView == null){
            convertView = LayoutInflater.from(mContext).inflate(
                    R.layout.language_title, parent, false);
            groupHolder = new ViewHolderGroup();
            groupHolder.group_name = (TextView) convertView.findViewById(R.id.title_name);
            convertView.setTag(groupHolder);
        }else{
            groupHolder = (ViewHolderGroup) convertView.getTag();
        }
        groupHolder.group_name.setText(gData.get(groupPosition).getName());
        return convertView;
    }
    //取得子類的View，內包含創建
    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        ViewHolderItem itemHolder;
        if(convertView == null){
            convertView = LayoutInflater.from(mContext).inflate(
                    R.layout.language_content, parent, false);
            itemHolder = new ViewHolderItem();
            itemHolder.language_name = (TextView) convertView.findViewById(R.id.content_name);
            convertView.setTag(itemHolder);
        }else{
            itemHolder = (ViewHolderItem) convertView.getTag();
        }
        itemHolder.language_name.setText(iData.get(groupPosition).get(childPosition).getName());
        return convertView;
    }

    @Override
    public boolean areAllItemsEnabled() {
        return false;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public void onGroupExpanded(int groupPosition) {

    }

    @Override
    public void onGroupCollapsed(int groupPosition) {

    }

    @Override
    public long getCombinedChildId(long groupId, long childId) {
        return 0;
    }

    @Override
    public long getCombinedGroupId(long groupId) {
        return 0;
    }
}
