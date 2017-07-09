package com.tenondelabs.hack2017.helpers;

/**
 * @author TenondeLabs
 * @version 1.0
 * Interfaz que encapsula las acciones del EvenBuss
 * Copyright 2017 TenondeLabs Inc. All rights reserved
 */
public interface EventBus {
    void register(Object object);
    void unregister(Object object);
    void post(Object object);
}
