package com.dome.appstore.params;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.dome.androidtools.proxy.IRecycleListItem;
import com.dome.androidtools.proxy.IRecyclerViewItem;
import com.dome.appstore.R;

/**
 * Created by 禄骥
 * 2016/4/6.
 */
public class JsonDemoViewDTO implements IRecyclerViewItem {

    // ===========================================================
    // Constants
    // ===========================================================

    // ===========================================================
    // Fields
    // ===========================================================

    String text;

    int id;

    String image;

    ViewHolder mHolder;

    // ===========================================================
    // Constructors
    // ===========================================================

    // ===========================================================
    // Getter & Setter
    // ===========================================================

    public void setText(String text) {
        this.text = text;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setImage(String image) {
        this.image = image;
    }

    // ===========================================================
    // Methods for/from SuperClass/Interfaces
    // ===========================================================

    @Override
    public View getView(Context context, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.recycler_item_view,
                parent, false);
    }

    @Override
    public RecyclerView.ViewHolder getHolder(Context context, ViewGroup parent, int viewType) {
        mHolder = new ViewHolder(getView(context, parent));
        return mHolder;
    }

    @Override
    public void refreshView(Context context, RecyclerView.ViewHolder holder, int viewType) {
        ((ViewHolder) holder).id_text_test.setText(
                Html.fromHtml(context.getString(R.string.string_html_str_item_text, id, text, image))
        );
    }

    @Override
    public void itemClick(View v) {

    }

    @Override
    public int getViewType(int position) {
        return position;
    }

    // ===========================================================
    // Methods
    // ===========================================================

    // ===========================================================
    // Inner and Anonymous Classes
    // ===========================================================

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView id_text_test;

        public ViewHolder(
                View v) {
            super(v);
            id_text_test = (TextView) v.findViewById(R.id.id_text_test);
        }

    }
}
