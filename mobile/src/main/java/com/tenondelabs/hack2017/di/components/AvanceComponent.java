package com.tenondelabs.hack2017.di.components;

import com.tenondelabs.hack2017.di.modules.AvanceModule;
import com.tenondelabs.hack2017.di.modules.LibsModule;
import com.tenondelabs.hack2017.di.modules.MainModule;
import com.tenondelabs.hack2017.ui.avances.AvanceListFragment;

import javax.inject.Singleton;

import dagger.Component;

/**
 * @author TenondeLabs
 * @version 1.0
 * Copyright 2017 TenondeLabs Inc. All rights reserved
 */
@Singleton @Component(modules = {MainModule.class, LibsModule.class, AvanceModule.class})
public interface AvanceComponent {
    void inject(AvanceListFragment fragment);
}
