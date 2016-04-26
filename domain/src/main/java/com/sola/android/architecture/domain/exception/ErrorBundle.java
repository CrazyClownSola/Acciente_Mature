package com.sola.android.architecture.domain.exception;

/**
 * author: Sola
 * 2015/10/28
 */
public interface ErrorBundle {
    // ===========================================================
    // Constants
    // ===========================================================

    // ===========================================================
    // Fields
    // ===========================================================

    // ===========================================================
    // Methods
    // ===========================================================

    Exception getException();

    String getErrorMessage();

}
