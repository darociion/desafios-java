package com.dominio.radiogaga.modelos;

public class Cancion extends Audio {

    private String artista;
    private String album;
    private String genero;

    @Override
    public int getClasificacion() {
        if (getTotalDeMeGusta() >= 1000) {
            return 10;
        } else if (getTotalDeMeGusta() > 5000) {
            return 6;
        } else return 3;
    }

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
}
