package com.tenondelabs.hack2017.data.model;

import com.google.gson.annotations.SerializedName;

import io.realm.RealmObject;

/**
 * Created by tenondelabs on 08/07/17.
 */


public class Gobernacion extends RealmObject {

    private Long id;
    @SerializedName("dpto")
    private String dpto;
    @SerializedName("dpto_desc")
    private String nombre;
    private String imagen;

    public Gobernacion () { }

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

    public String getDpto() {
        return dpto;
    }

    public void setDpto(String dpto) {
        this.dpto = dpto;
    }
}
