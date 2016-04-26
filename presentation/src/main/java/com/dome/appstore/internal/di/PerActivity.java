package com.dome.appstore.internal.di;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * author: Sola
 * 2015/11/3
 */
@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface PerActivity {
}
