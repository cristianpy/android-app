package com.tenondelabs.hack2017.di.components;

import com.tenondelabs.hack2017.di.modules.DistritoModule;
import com.tenondelabs.hack2017.di.modules.LibsModule;
import com.tenondelabs.hack2017.di.modules.MainModule;
import com.tenondelabs.hack2017.ui.distrito.DistritoListFragment;

import javax.inject.Singleton;

import dagger.Component;

/**
 * @author Rodrigo Garcete
 * @version 1.0
 * Copyright 2016 Akibusca Inc. All rights reserved
 */
@Singleton @Component(modules = {MainModule.class, LibsModule.class, DistritoModule.class})
public interface DistritoComponent {
    void inject(DistritoListFragment fragment);
}
