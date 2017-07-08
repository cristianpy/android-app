package com.tenondelabs.hack2017.di.scope;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * @author Rodrigo Garcete
 * @version 1.0
 * Copyright 2016 Akibusca Inc. All rights reserved
 */
@Scope @Retention(RetentionPolicy.RUNTIME)
public @interface PerFragment {
}
