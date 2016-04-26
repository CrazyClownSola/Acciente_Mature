package com.dome.appstore.uitls;

import com.dome.appstore.R;

/**
 * author: Sola
 * 2015/12/22
 */
public enum ETab {

//    RECOMMEND(RankFragment.class.getName(), "推荐", R.layout.text_tab_recommend),
//    GAME(GameFragment.class.getName(), "游戏", R.layout.text_tab_game),

    RECOMMEND("推荐", R.layout.text_tab_recommend),
    GAME("游戏", R.layout.text_tab_game),
    RANK("排行", R.layout.text_tab_rank),
    MANAGE("管理", R.layout.text_tab_manage),
    RANK_OFFLINE("单机榜", -1),
    RANK_ONLINE("网友榜", -1),
    RANK_APP("应用榜", -1),
    SOFT_DETAIL("详情", -1),
    SOFT_COMMENT("评论", -1);


    String name;
    String title;
    int resourceID;

    ETab(String name, String title, int resourceID) {
        this.name = name;
        this.title = title;
        this.resourceID = resourceID;
    }

    ETab(String title, int resourceID) {
        this.title = title;
        this.resourceID = resourceID;
    }


    public int getResourceID() {
        return resourceID;
    }

    public String getTitle() {
        return title;
    }

    public String getName() {
        return name;
    }
}
