package com.tenondelabs.hack2017.data.model;

import com.google.gson.annotations.SerializedName;

import io.realm.RealmObject;

/**
 * Created by tenondelabs on 08/07/17.
 */
public class Entidad extends RealmObject {

    private Long id;
    @SerializedName("ins_id")
    private String insId;
    @SerializedName("SNNA")
    private String nombre;
    private String imagen;

    public Entidad() { }

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

    public String getInsId() {
        return insId;
    }

    public void setInsId(String insId) {
        this.insId = insId;
    }

}
