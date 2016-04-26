package com.dome.androidtools.proxy;

import android.view.View;

/**
 * 新增的用于解决RecyclerView在ItemRefresh的时候容易产生的ViewHolder不一致的问题
 * <p>
 * Created by 禄骥
 * 2016/4/25.
 */
public interface IRecyclerViewItem extends IRecycleListItem {
    // ===========================================================
    // Constants
    // ===========================================================

    // ===========================================================
    // Methods for/from SuperClass/Interfaces
    // ===========================================================

    // ===========================================================
    // Methods
    // ===========================================================

    /**
     * 注意该方法的使用，主要区分在于当RecyclerView的Item项，每一项都不相同的时候，
     * 可以根据不同的ViewType进行界面的适配;
     * 但是当每个项类型都相同的时候，这个方法返回的值就不那么重要了
     *
     * @param position 在适配器中的位置
     * @return 范围该项所对应的布局类型
     */
    int getViewType(int position);
}
