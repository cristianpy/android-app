package com.tenondelabs.hack2017.data.model;

import io.realm.RealmObject;

/**
 * Created by tenondelabs on 08/07/17.
 */


public class Distrito extends RealmObject {

    private Long id;
    private String nombre;
    private String imagen;

    public Distrito() { }

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

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
}
