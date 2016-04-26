package com.sola.module.recycle.fix_container.tools;

import com.sola.module.recycle.fix_container.RecyclerContainerBase;

/**
 * Description:
 * author: Sola
 * 2015/10/16
 */
public interface IPullToRefreshContainer {
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
     * 更新完成
     */
    void refreshComplete();

    /**
     * 开始更新的入口方法
     *
     * @param atOnce 是否是一次性的
     */
    void autoRefresh(boolean atOnce);


    RecyclerContainerBase getContainerBase();
}
