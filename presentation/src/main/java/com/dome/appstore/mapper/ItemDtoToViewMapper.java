package com.dome.appstore.mapper;

import com.dome.androidtools.proxy.IRecyclerViewItem;
import com.dome.appstore.internal.di.PerActivity;
import com.dome.appstore.params.ItemTabViewDTO;
import com.sola.android.architecture.domain.ItemTabDTO;

import java.util.Collection;

import javax.inject.Inject;

/**
 * Created by 禄骥
 * 2016/4/25.
 */
@PerActivity
public class ItemDtoToViewMapper {
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
    public ItemDtoToViewMapper() {
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

    public Collection<IRecyclerViewItem> transform(Collection<ItemTabDTO> itemTabDTO) {
        Collection<IRecyclerViewItem> retList = new java.util.ArrayList<>();
        for (ItemTabDTO dto :
                itemTabDTO) {
            retList.add(transform(dto));
        }
        return retList;
    }

    public IRecyclerViewItem transform(ItemTabDTO dto) {
        ItemTabViewDTO retDto = new ItemTabViewDTO();
        if (dto != null) {
            retDto.setTitleKey(dto.getTitleKey());
            retDto.setStarCount(dto.getStarCount());
            retDto.setImageUrl(dto.getImageUrl());
            retDto.setName(dto.getName());
            retDto.setId(dto.getId());
            retDto.setApkSize(dto.getApkSize());
            retDto.setDescription(dto.getDescription());
        }
        return retDto;
    }

    // ===========================================================
    // Inner and Anonymous Classes
    // ===========================================================

}
