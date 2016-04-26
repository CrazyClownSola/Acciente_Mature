package com.sola.android.architecture.domain.demo;

import java.util.List;

/**
 * Created by 禄骥
 * 2016/4/6.
 */
public class JsonDemoResultDTO {
    // ===========================================================
    // Constants
    // ===========================================================

    // ===========================================================
    // Fields
    // ===========================================================

    List<JsonDemoDTO> data;

    int code;

    String msg;

    // ===========================================================
    // Constructors
    // ===========================================================

    // ===========================================================
    // Getter & Setter
    // ===========================================================

    public List<JsonDemoDTO> getData() {
        return data;
    }

    public void setData(List<JsonDemoDTO> data) {
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }


    // ===========================================================
    // Methods for/from SuperClass/Interfaces
    // ===========================================================

    // ===========================================================
    // Methods
    // ===========================================================

    // ===========================================================
    // Inner and Anonymous Classes
    // ===========================================================

}
