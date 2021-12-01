package com.misiontic.holamundo05.model;

public class Pedido {

    private String usuario;
    private String producto;
    private Double total;
    private String ubicacion;

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public Pedido() {
    }

    public Pedido(String usuario, String producto, Double total, String ubicacion) {
        this.usuario = usuario;
        this.producto = producto;
        this.total = total;
        this.ubicacion = ubicacion;
    }
}
