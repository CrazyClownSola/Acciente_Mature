package com.sola.android.architecture.data.entity.mapper;

import com.sola.android.architecture.data.entity.BannerEntity;
import com.sola.android.architecture.data.entity.BannerResultEntity;
import com.sola.android.architecture.data.entity.demo.JsonDemoEntity;
import com.sola.android.architecture.data.entity.demo.JsonDemoResultEntity;
import com.sola.android.architecture.domain.BannerResultDTO;
import com.sola.android.architecture.domain.demo.JsonDemoDTO;
import com.sola.android.architecture.domain.demo.JsonDemoResultDTO;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * author: Sola
 * 2016/1/8
 */
@Singleton
public class BannerEntityDataMapper {
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
    public BannerEntityDataMapper() {
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

    public BannerResultDTO transform(BannerEntity entity) {
        BannerResultDTO retDto = null;
        if (entity != null) {
            retDto = new BannerResultDTO();
            retDto.setDescription(entity.getDescription());
            retDto.setId(entity.getId());
            retDto.setImageSrc(entity.getImageSrc());
            retDto.setLink(entity.getLink());
            retDto.setTitle(entity.getTitle());
        }
        return retDto;
    }

    public List<BannerResultDTO> transform(Collection<BannerEntity> userEntityCollection) {
        List<BannerResultDTO> dtoList = new ArrayList<>();
        BannerResultDTO user;
        for (BannerEntity userEntity : userEntityCollection) {
            user = transform(userEntity);
            if (user != null) {
                dtoList.add(user);
            }
        }
        return dtoList;
    }

    public List<BannerResultDTO> transform(BannerResultEntity resultEntity) {
        return transform(resultEntity.getResult());
    }

    public JsonDemoDTO transform(JsonDemoEntity entity) {
        JsonDemoDTO retDto = null;
        if (entity != null) {
            retDto = new JsonDemoDTO();
            retDto.setId(entity.getId());
            retDto.setImage(entity.getImage());
            retDto.setText(entity.getText());
        }
        return retDto;
    }

    public List<JsonDemoDTO> transform(JsonDemoResultEntity resultEntity) {
        List<JsonDemoDTO> dtoList = new ArrayList<>();
        JsonDemoDTO user;
        for (JsonDemoEntity userEntity : resultEntity.getData()) {
            user = transform(userEntity);
            if (user != null) {
                dtoList.add(user);
            }
        }
        return dtoList;
    }

    public JsonDemoResultDTO transformResult(JsonDemoResultEntity resultEntity) {
        JsonDemoResultDTO retDto = new JsonDemoResultDTO();
        List<JsonDemoDTO> dtoList = new ArrayList<>();
        JsonDemoDTO user;
        for (JsonDemoEntity userEntity : resultEntity.getData()) {
            user = transform(userEntity);
            if (user != null) {
                dtoList.add(user);
            }
        }
        retDto.setMsg(resultEntity.getMsg());
        retDto.setCode(resultEntity.getCode());
        retDto.setData(dtoList);
        return retDto;
    }
    // ===========================================================
    // Inner and Anonymous Classes
    // ===========================================================

}
