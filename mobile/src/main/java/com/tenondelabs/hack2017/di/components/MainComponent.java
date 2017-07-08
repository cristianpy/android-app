package com.tenondelabs.hack2017.di.components;

import com.tenondelabs.hack2017.di.modules.MainModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * @author Rodrigo Garcete
 * @version 1.0
 * Copyright 2016 Akibusca Inc. All rights reserved
 */
@Singleton
@Component(modules = {MainModule.class})
public interface MainComponent {
}
