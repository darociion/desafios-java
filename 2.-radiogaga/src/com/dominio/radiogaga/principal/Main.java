package com.dominio.radiogaga.principal;

import com.dominio.radiogaga.modelos.Cancion;
import com.dominio.radiogaga.modelos.MisFavoritos;
import com.dominio.radiogaga.modelos.Podcast;

public class Main {
    public static void main(String[] args) {

        Cancion miCancion = new Cancion();
        miCancion.setTitulo("Estranged");
        miCancion.setArtista("Guns n Roses");
        miCancion.setAlbum("Use Your Illusion II");

        Podcast miPodcast = new Podcast();
        miPodcast.setPresentador("Mente_Presocratica");
        miPodcast.setTitulo("Tu desarrollo personal");
        miPodcast.setDescripcion("Nos embarcaremos en el maravilloso mundo del desarrollo.");

        for (int i = 0; i < 500; i++) {
            miCancion.reproduce();
            miPodcast.meGusta();
        }

        for (int i = 0; i < 10000; i++) {
            miPodcast.reproduce();
        }

        System.out.println("Total de reproducciones de " + miCancion.getTitulo() + " de la banda " + miCancion.getArtista() + " es de " + miCancion.getTotalDeReproducciones() + " reproducciones");
        System.out.println("La cantidad total de Me Gusta del Podcast '" + miPodcast.getTitulo() + "' de " + miPodcast.getPresentador() + " es de " + miPodcast.getTotalDeMeGusta());

        MisFavoritos favoritos = new MisFavoritos();
        favoritos.agregarAFavoritos(miCancion);
        favoritos.agregarAFavoritos(miPodcast);
    }
}