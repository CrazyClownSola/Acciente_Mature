package com.dome.appstore.ui.activity;

import android.content.Context;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.Extra;
import org.androidannotations.annotations.ViewById;

import java.lang.ref.WeakReference;

/**
 * Created by 禄骥
 * 2016/4/26.
 */
@EActivity
public abstract class RxBaseActivity extends DGBaseActivity {
    // ===========================================================
    // Constants
    // ===========================================================

    // ===========================================================
    // Fields
    // ===========================================================

    @ViewById
    Toolbar id_tool_bar;

    @ViewById
    TextView id_text_title;

    /*
     * Activity的菜单Id，如果想自适配menu
     */
    @Extra("menu")
    int menu_id = -1;

    @Extra
    String title;

    protected final WeakReference<Context> mContext = new WeakReference<>(this);

    // ===========================================================
    // Constructors
    // ===========================================================

    // ===========================================================
    // Getter & Setter
    // ===========================================================

    // ===========================================================
    // Methods for/from SuperClass/Interfaces
    // ===========================================================

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if (menu_id == -1)
            return super.onCreateOptionsMenu(menu);
        else {
            getMenuInflater().inflate(menu_id, menu);
            return true;
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();// 当返回键被主动点击之后
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    // ===========================================================
    // Methods
    // ===========================================================

    @AfterViews
    protected void afterViews() {
        if (id_text_title != null)
            id_text_title.setText(title);
        if (id_tool_bar != null) {
            id_tool_bar.setTitle("");
            setSupportActionBar(id_tool_bar);
            // 设置默认的back键
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        doAfterViews();
    }

    // ===========================================================
    // Inner and Anonymous Classes
    // ===========================================================


    protected abstract void doAfterViews();

}
