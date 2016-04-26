package com.sola.android.architecture.data.entity.mapper;

import com.sola.android.architecture.data.entity.app.ItemEntity;
import com.sola.android.architecture.data.entity.app.Result_ItemEntity;
import com.sola.android.architecture.domain.ItemTabDTO;

import java.util.Collection;
import java.util.List;

import javax.inject.Inject;

/**
 * Created by 禄骥
 * 2016/4/25.
 */
public class ItemEntityDataMapper {
    // ===========================================================
    // Constants
    // ===========================================================

    // ===========================================================
    // Fields
    // ===========================================================

    // ===========================================================
    // Constructors
    // ===========================================================

    @Inject
    public ItemEntityDataMapper() {
    }

    // ===========================================================
    // Getter & Setter
    // ===========================================================

    // ===========================================================
    // Methods for/from SuperClass/Interfaces
    // ===========================================================

    // ===========================================================
    // Methods
    // ===========================================================

    public Collection<ItemTabDTO> transform(Result_ItemEntity result_itemEntity) {
        List<ItemTabDTO> retList = new java.util.ArrayList<>();
        if (result_itemEntity != null) {
            List<ItemEntity> entities = result_itemEntity.getData();
            if (entities != null && entities.size() != 0)
                for (ItemEntity entity :
                        entities)
                    retList.add(transform(entity));
        }
        return retList;
    }

    public ItemTabDTO transform(ItemEntity entity) {
        ItemTabDTO retDto = null;
        if (entity != null) {
            retDto = new ItemTabDTO();
            retDto.setApkSize(entity.getApkSize());
            retDto.setDescription(entity.getDescription());
            retDto.setId(entity.getId());
            retDto.setImageUrl(entity.getImageUrl());
            retDto.setName(entity.getName());
            retDto.setStarCount(entity.getStarCount());
            retDto.setTitleKey(entity.getTitleKey());
        }
        return retDto;
    }

    // ===========================================================
    // Inner and Anonymous Classes
    // ===========================================================

}
