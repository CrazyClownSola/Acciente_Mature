package com.sola.android.architecture.domain.repository;

import com.sola.android.architecture.domain.demo.JsonDemoDTO;
import com.sola.android.architecture.domain.demo.JsonDemoResultDTO;

import rx.Observable;

/**
 * Created by 禄骥
 * 2016/4/6.
 */
public interface JsonDemoCaseRepository {
    // ===========================================================
    // Constants
    // ===========================================================

    // ===========================================================
    // Fields
    // ===========================================================

    // ===========================================================
    // Methods
    // ===========================================================

    Observable<JsonDemoDTO> getJsonDemo();

    Observable<JsonDemoResultDTO> getJsonDemoResult();

}
