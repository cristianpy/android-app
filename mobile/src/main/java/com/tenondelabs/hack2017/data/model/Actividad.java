package com.tenondelabs.hack2017.data.model;

import io.realm.RealmObject;

/**
 * Created by rorogarcete on 08/07/17.
 */

public class Actividad extends RealmObject {

    private Long id;
    private String nombre;

    public Actividad() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
