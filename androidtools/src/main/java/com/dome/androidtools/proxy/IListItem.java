package com.dome.androidtools.proxy;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

/**
 * author: Sola
 * 2015/11/13
 */
public interface IListItem {
    // ===========================================================
    // Constants
    // ===========================================================

    // ===========================================================
    // Fields
    // ===========================================================

    // ===========================================================
    // Methods
    // ===========================================================

    /**
     * @param context     　控件组件
     * @param convertView 　注意这个东西的使用，用的时候有可能传入的为空，同样传入的不为空，为了更好的使用内存效应，请时候懒加载的模式
     */
    View getView(Context context, View convertView, ViewGroup parent);

}
