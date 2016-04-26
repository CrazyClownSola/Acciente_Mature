package com.sola.android.architecture.domain.interactor;

import com.sola.android.architecture.domain.executor.PostExecutionThread;
import com.sola.android.architecture.domain.executor.ThreadExecutor;

/**
 * 这里预设考虑有这么一个业务逻辑
 * 就简单的登录做例子
 * 这个Case中可以包含各种各样的场景：
 * (如果是真实的项目，这部分推荐多抽象一些方法在里面，
 * 因为这不是最终的实现类)
 * 然后假设实现这些场景需要对多个服务进行访问。转换到代码级别上就是对多个Repository进行切换
 * 子类可以拥有多个仓储的实例
 * <p>
 * Created by 禄骥
 * 2016/4/6.
 */
public abstract class ComplexCase extends ComplexConnectionCase {

    // ===========================================================
    // Constants
    // ===========================================================

    // ===========================================================
    // Fields
    // ===========================================================

    // ===========================================================
    // Constructors
    // ===========================================================

    protected ComplexCase(ThreadExecutor threadExecutor,
                          PostExecutionThread postExecutionThread) {
        super(threadExecutor, postExecutionThread);
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

    // ===========================================================
    // Inner and Anonymous Classes
    // ===========================================================

}
