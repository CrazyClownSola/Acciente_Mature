package com.sola.module.recycle.fix_container.tools;

/**
 * Description:
 * author: Sola
 * 2015/10/16
 */
public interface IPullToRefreshViewContainer extends IPullToRefreshContainer {
    // ===========================================================
    // Constants
    // ===========================================================

    // ===========================================================
    // Fields
    // ===========================================================

    // ===========================================================
    // Methods
    // ===========================================================


    /* --------------------------- 下拉刷新的种种方法 --------------------------- */

    void addPTRUIHandler(IPullToRefreshUIHandler handler);

    void setPTRHandler(IPullToRefreshHandler handler);

}
