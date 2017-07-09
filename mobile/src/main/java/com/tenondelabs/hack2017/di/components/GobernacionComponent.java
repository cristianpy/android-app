package com.tenondelabs.hack2017.di.components;

import com.tenondelabs.hack2017.di.modules.GobernacionModule;
import com.tenondelabs.hack2017.di.modules.LibsModule;
import com.tenondelabs.hack2017.di.modules.MainModule;
import com.tenondelabs.hack2017.ui.gobernacion.GobernacionListFragment;

import javax.inject.Singleton;

import dagger.Component;

/**
 * @author TenondeLabs
 * @version 1.0
 * Copyright 2017 TenondeLabs Inc. All rights reserved
 */
@Singleton @Component(modules = {MainModule.class, LibsModule.class, GobernacionModule.class})
public interface GobernacionComponent {
    void inject(GobernacionListFragment fragment);
}
