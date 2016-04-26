package com.sola.android.architecture.domain.repository;

import com.sola.android.architecture.domain.BannerResultDTO;
import com.sola.android.architecture.domain.demo.JsonDemoDTO;

import rx.Observable;

/**
 * 这里用Case1 这种命名方式是希望明确定义，这是对应于Case1这一种业务逻辑的情况下的代码
 * <p>
 * author: Sola
 * 2016/1/8
 */
public interface Case1Repository {
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
     * 测试接口，别在意名字
     *
     * @return 返回Domain关心的业务数据
     */
    Observable<BannerResultDTO> getImageList();

    /**
     * @param categoryId 测试数据别在意
     * @return 返回Domain关心的业务数据
     */
    Observable<BannerResultDTO> getArticleList(String categoryId);




}
