package com.misiontic.holamundo05.model;

public class Producto {

    private String id;
    private String codigo;
    private String nombre;
    private String desc_corta;
    private String desc_larga;
    private double precio;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDesc_corta() {
        return desc_corta;
    }

    public void setDesc_corta(String desc_corta) {
        this.desc_corta = desc_corta;
    }

    public String getDesc_larga() {
        return desc_larga;
    }

    public void setDesc_larga(String desc_larga) {
        this.desc_larga = desc_larga;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Producto() {
    }

    public Producto(String id, String codigo, String nombre, String desc_corta, String desc_larga, double precio) {
        this.id = id;
        this.codigo = codigo;
        this.nombre = nombre;
        this.desc_corta = desc_corta;
        this.desc_larga = desc_larga;
        this.precio = precio;
    }
}
