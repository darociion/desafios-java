package com.dominio.radiogaga.modelos;

public class Podcast extends Audio {

    private String presentador;
    private String descripcion;

    @Override
    public int getClasificacion() {
        if (getTotalDeReproducciones() >= 1000) {
            return 10;
        } else if (getTotalDeReproducciones() > 5000) {
            return 6;
        } else return 3;
    }

    public String getPresentador() {
        return presentador;
    }

    public void setPresentador(String presentador) {
        this.presentador = presentador;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
