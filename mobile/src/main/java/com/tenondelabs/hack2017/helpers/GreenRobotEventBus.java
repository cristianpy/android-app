package com.tenondelabs.hack2017.helpers;

import org.greenrobot.eventbus.EventBus;

/**
 * @author TenondeLabs
 * @version 1.0
 * Clase Wrapper para encapsular el EventBuss
 * Copyright 2017 TenondeLabs Inc. All rights reserved
 */
public class GreenRobotEventBus implements com.tenondelabs.hack2017.helpers.EventBus {

    EventBus eventBus;

    private static final GreenRobotEventBus INSTANCE = new GreenRobotEventBus();

    public GreenRobotEventBus() {
        eventBus = EventBus.getDefault();
    }

    public static GreenRobotEventBus getInstance() {
        return INSTANCE;
    }

    @Override
    public void register(Object object) {
        eventBus.register(object);
    }

    @Override
    public void unregister(Object object) {
        eventBus.unregister(object);
    }

    @Override
    public void post(Object object) {
        eventBus.post(object);
    }
}
