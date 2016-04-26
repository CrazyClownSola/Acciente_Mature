package com.sola.android.architecture.data.repository;

import com.sola.android.architecture.data.entity.app.ItemEntity;
import com.sola.android.architecture.data.entity.app.Result_ItemEntity;
import com.sola.android.architecture.data.entity.mapper.ItemEntityDataMapper;
import com.sola.android.architecture.data.net.ApiConnection;
import com.sola.android.architecture.data.net.ItemService;
import com.sola.android.architecture.domain.ItemTabDTO;
import com.sola.android.architecture.domain.repository.ItemRepository;

import java.util.Collection;

import javax.inject.Inject;
import javax.inject.Singleton;

import rx.Observable;
import rx.functions.Func1;

/**
 * Created by 禄骥
 * 2016/4/25.
 */
@Singleton
public class ItemDataRepository implements ItemRepository {

    // ===========================================================
    // Constants
    // ===========================================================

    // ===========================================================
    // Fields
    // ===========================================================

    final ItemEntityDataMapper mapper;

    // ===========================================================
    // Constructors
    // ===========================================================

    @Inject
    public ItemDataRepository(ItemEntityDataMapper mapper) {
        this.mapper = mapper;
    }

    // ===========================================================
    // Getter & Setter
    // ===========================================================

    // ===========================================================
    // Methods for/from SuperClass/Interfaces
    // ===========================================================

    @Override
    public Observable<Collection<ItemTabDTO>> getRecommendList() {
        return ApiConnection.createService(ItemService.BASE_URL, ItemService.class)
                .getRecommendItems()
                .flatMap(result_itemEntity ->
                        Observable.just(mapper.transform(result_itemEntity)));
    }

    @Override
    public Observable<ItemTabDTO> getGameList() {
        return null;
    }

    @Override
    public Observable<Collection<ItemTabDTO>> getRankAppList() {
        return ApiConnection.createService(ItemService.BASE_URL, ItemService.class)
                .getRankAppItems()
                .flatMap(result_itemEntity ->
                        Observable.just(mapper.transform(result_itemEntity)));
    }

    @Override
    public Observable<ItemTabDTO> getRankOnlineList() {
        return null;
    }

    @Override
    public Observable<ItemTabDTO> getRankOfflineList() {
        return null;
    }

    // ===========================================================
    // Methods
    // ===========================================================

    // ===========================================================
    // Inner and Anonymous Classes
    // ===========================================================

}
