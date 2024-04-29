package com.dominio.radiogaga.modelos;

public class MisFavoritos {

    public void agregarAFavoritos (Audio audio) {
        if (audio.getClasificacion() == 10) {
            System.out.println(audio.getTitulo() + " es uno de los favoritos del momento en la comunidad.");
        } else System.out.println(audio.getTitulo() + " es uno de los favoritos");
    }

}
