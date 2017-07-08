package com.tenondelabs.hack2017.helpers;

/**
 * @author Rodrigo Garcete
 * @version 1.0
 * Interfaz que encapsula las acciones del EvenBuss
 * Copyright 2016 Akibusca Inc. All rights reserved
 */
public interface EventBus {
    void register(Object object);
    void unregister(Object object);
    void post(Object object);
}
