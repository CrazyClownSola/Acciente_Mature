package com.dome.appstore.params;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dome.androidtools.proxy.IRecyclerViewItem;
import com.dome.appstore.R;

/**
 * Created by 禄骥
 * 2016/4/25.
 */
public class ItemTabViewDTO implements IRecyclerViewItem {

    // ===========================================================
    // Constants
    // ===========================================================

    // ===========================================================
    // Fields
    // ===========================================================

    String name;

    float starCount;

    float apkSize;

    String description;

    String imageUrl;

    int id;

    /**
     * 用于和Title进行Id匹配
     */
    int titleKey;

    /**
     * 下载速度
     */
    float downloadSpeed;

    /**
     * 下载进度
     */
    float downloadSchedule;

    int progress;

    // ===========================================================
    // Constructors
    // ===========================================================

    // ===========================================================
    // Getter & Setter
    // ===========================================================

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getStarCount() {
        return starCount;
    }

    public void setStarCount(float starCount) {
        this.starCount = starCount;
    }

    public float getApkSize() {
        return apkSize;
    }

    public void setApkSize(float apkSize) {
        this.apkSize = apkSize;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTitleKey() {
        return titleKey;
    }

    public void setTitleKey(int titleKey) {
        this.titleKey = titleKey;
    }

    // ===========================================================
    // Methods for/from SuperClass/Interfaces
    // ===========================================================

    @Override
    public int getViewType(int position) {
        return 0;
    }

    @Override
    public View getView(Context context, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.recycler_item_recommend_dto, parent, false);
    }

    @Override
    public RecyclerView.ViewHolder getHolder(Context context, ViewGroup parent, int viewType) {
        return new ViewHolder(getView(context, parent));
    }

    @Override
    public void refreshView(Context context, RecyclerView.ViewHolder holder, int viewType) {
        ViewHolder viewHolder = (ViewHolder) holder;

    }

    @Override
    public void itemClick(View v) {

    }

    // ===========================================================
    // Methods
    // ===========================================================

    // ===========================================================
    // Inner and Anonymous Classes
    // ===========================================================

    class ViewHolder extends RecyclerView.ViewHolder {

        public ViewHolder(View itemView) {
            super(itemView);
        }
    }

}
