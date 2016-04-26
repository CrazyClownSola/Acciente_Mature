package com.sola.android.architecture.data.entity.app;

/**
 * Created by 禄骥
 * 2016/4/25.
 */
public class ItemEntity {
    // ===========================================================
    // Constants
    // ===========================================================

    // ===========================================================
    // Fields
    // ===========================================================

    String name;

    float starCount;

    float apkSize;

    String description;

    String imageUrl;

    int id;

    /**
     * 用于和Title进行Id匹配
     */
    int titleKey;

    // ===========================================================
    // Constructors
    // ===========================================================

    // ===========================================================
    // Getter & Setter
    // ===========================================================

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getStarCount() {
        return starCount;
    }

    public void setStarCount(float starCount) {
        this.starCount = starCount;
    }

    public float getApkSize() {
        return apkSize;
    }

    public void setApkSize(float apkSize) {
        this.apkSize = apkSize;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTitleKey() {
        return titleKey;
    }

    public void setTitleKey(int titleKey) {
        this.titleKey = titleKey;
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
