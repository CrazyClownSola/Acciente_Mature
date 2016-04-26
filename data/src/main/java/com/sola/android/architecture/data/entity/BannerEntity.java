package com.sola.android.architecture.data.entity;

/**
 * 这里的Entity注意尽量忠实呈现服务返回的数据结构
 * 具体数据字段的过滤可以到domain层，根据业务逻辑去做
 *
 * author: Sola
 * 2016/1/8
 */
public class BannerEntity {
    // ===========================================================
    // Constants
    // ===========================================================

    // ===========================================================
    // Fields
    // ===========================================================

    boolean searchFromPage;

    String delFlag;

    String id;

    String title;

    String link;

    String keywords;

    String description;

    int weight;

    int hits;

    String url;

    /**
     * 图片存于服务器的位置
     */
    String imageSrc;

    // ===========================================================
    // Constructors
    // ===========================================================

    // ===========================================================
    // Getter & Setter
    // ===========================================================

    public boolean isSearchFromPage() {
        return searchFromPage;
    }

    public String getDelFlag() {
        return delFlag;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getLink() {
        return link;
    }

    public String getKeywords() {
        return keywords;
    }

    public String getDescription() {
        return description;
    }

    public int getWeight() {
        return weight;
    }

    public int getHits() {
        return hits;
    }

    public String getUrl() {
        return url;
    }

    public String getImageSrc() {
        return imageSrc;
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
