package com.tenondelabs.hack2017.di.scope;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * @author TenondeLabs
 * @version 1.0
 * Copyright 2017 TenondeLabs Inc. All rights reserved
 */
@Scope @Retention(RetentionPolicy.RUNTIME)
public @interface PerFragment {
}
