package com.dome.appstore.ui.fragment;

import android.support.v4.app.Fragment;

import com.dome.appstore.internal.di.HasComponent;

/**
 * Created by 禄骥
 * 2016/4/6.
 */
public abstract class DGBaseFragment extends Fragment {
    // ===========================================================
    // Constants
    // ===========================================================

    // ===========================================================
    // Fields
    // ===========================================================

    static final String TAG = "Sola";

    // ===========================================================
    // Constructors
    // ===========================================================

    // ===========================================================
    // Getter & Setter
    // ===========================================================

    // ===========================================================
    // Methods for/from SuperClass/Interfaces
    // ===========================================================

    // ===========================================================
    // Methods
    // ===========================================================

    /**
     * @param componentType 需要何种组件
     * @param <C>           定义组件的类型
     * @return 返回定义好的组件的实例
     */
    @SuppressWarnings("unchecked")
    protected <C> C getComponent(Class<C> componentType) {
        return componentType.cast(((HasComponent<C>) getActivity()).getComponent());
    }

    // ===========================================================
    // Inner and Anonymous Classes
    // ===========================================================

}
