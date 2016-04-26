package com.sola.android.architecture.domain.repository;

import com.sola.android.architecture.domain.ItemTabDTO;

import java.util.Collection;

import rx.Observable;


/**
 * Created by 禄骥
 * 2016/4/25.
 */
public interface ItemRepository {
    // ===========================================================
    // Constants
    // ===========================================================

    // ===========================================================
    // Methods for/from SuperClass/Interfaces
    // ===========================================================

    // ===========================================================
    // Methods
    // ===========================================================

    Observable<Collection<ItemTabDTO>> getRecommendList();

    Observable<ItemTabDTO> getGameList();

    Observable<Collection<ItemTabDTO>> getRankAppList();

    Observable<ItemTabDTO> getRankOnlineList();

    Observable<ItemTabDTO> getRankOfflineList();
}
