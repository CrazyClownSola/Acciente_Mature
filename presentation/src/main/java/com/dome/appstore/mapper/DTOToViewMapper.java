package com.dome.appstore.mapper;

import com.dome.appstore.internal.di.PerActivity;
import com.dome.appstore.params.JsonDemoViewDTO;
import com.sola.android.architecture.domain.demo.JsonDemoDTO;
import com.sola.android.architecture.domain.demo.JsonDemoResultDTO;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by 禄骥
 * 2016/4/6.
 */
@PerActivity
public class DTOToViewMapper {
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
    public DTOToViewMapper() {
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

    public JsonDemoViewDTO transform(JsonDemoDTO dto) {
        JsonDemoViewDTO retDto = new JsonDemoViewDTO();
        retDto.setText(dto.getText());
        retDto.setImage(dto.getImage());
        retDto.setId(dto.getId());
        return retDto;
    }

    public List<JsonDemoViewDTO> transformResult(JsonDemoResultDTO resultDTO) {
        List<JsonDemoViewDTO> retDto = new ArrayList<>();

        for (JsonDemoDTO dto : resultDTO.getData()) {
            retDto.add(transform(dto));
        }
//
//        retDto.setText(dto.getText());
//        retDto.setImage(dto.getImage());
//        retDto.setId(dto.getId());
        return retDto;
    }

    // ===========================================================
    // Inner and Anonymous Classes
    // ===========================================================

}
