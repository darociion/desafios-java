package com.domain.bookapi.main;

import com.domain.bookapi.model.*;
import com.domain.bookapi.service.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    private Scanner teclado = new Scanner(System.in);
    private final String URL = "https://gutendex.com/books/";
    private ConsumoAPI consumoAPI = new ConsumoAPI();
    private ConvierteDatos conversor = new ConvierteDatos();

    public void mostrarMenu() {

        var json = consumoAPI.obtenerDatos(URL);
        var datos = conversor.obtenerDatos(json, Datos.class);

        var opcion = -1;
        while (opcion != 0) {
            var menu = """
                    1 - Mostrar TOP 10 libros mas descargados
                    2 - Buscar libro por titulo
                    3 - Buscar libros por epoca de vida de autor
                    4 - Mostrar estadisticas
                    0 - Salir
                    """;
            System.out.println(menu);
            opcion = teclado.nextInt();
            teclado.nextLine();

            switch (opcion) {
                case 1:
                    mostrarTop10Libros(datos);
                    break;
                case 2:
                    buscarLibroPorTitulo();
                    break;
                case 3:
                    buscarPorEpoca();
                    break;
                case 4:
                    mostrarEstadisticas(datos);
                    break;
                case 0:
                    System.out.println("Cerrando la aplicación...");
                    break;
                default:
                    System.out.println("Opción inválida");
            }
        }
    }

    private void mostrarTop10Libros(Datos datos) {
        //TOP 10 LIBROS MAS DESCARGADOS
        System.out.println("TOP 10 LIBROS MAS DESCARGADOS");
        datos.resultados().stream()
                .sorted(Comparator.comparing(DatosLibros::descargas).reversed())
                .limit(10)
                .map(l -> l.titulo().toUpperCase())
                .forEach(System.out::println);
    }

    private void buscarLibroPorTitulo() {
        //Buscar libro por titulo
        System.out.println("Ingrese el titulo del libro que desea buscar");
        var titulo = teclado.nextLine();
        var json = consumoAPI.obtenerDatos(URL + "?search=" + titulo.replace(" ","+"));
        Datos datosBusquedaTitulo = conversor.obtenerDatos(json, Datos.class);
        Optional<DatosLibros> libroBuscado = datosBusquedaTitulo.resultados().stream()
                .filter(l -> l.titulo().toLowerCase().contains(titulo.toLowerCase()))
                .findFirst();

        if (libroBuscado.isPresent()) {
            System.out.println("Libro encontrado");
            System.out.println(libroBuscado.get());
        } else {
            System.out.println("Libro no encontrado");
        }
    }

    private void buscarPorEpoca() {
        //Buscar libros por autores vivo en rango de años ingresados
        System.out.println("Ingrese primer año a comparar: ");
        var primerAnio = teclado.nextInt();
        System.out.println("Ingrese segundo año a comparar: ");
        var segundoAnio = teclado.nextInt();

        var json = consumoAPI.obtenerDatos(URL + "?author_year_start=" + primerAnio + "&author_year_end=" + segundoAnio);
        Datos datos = conversor.obtenerDatos(json, Datos.class);
        Optional<DatosLibros> busquedaPorAnio = datos.resultados().stream()
                .filter(l -> l.autor().stream()
                        .anyMatch(a -> {
                            int fechaNacimiento = Integer.parseInt(a.fechaNacimiento());
                            return fechaNacimiento >= primerAnio && fechaNacimiento <= segundoAnio;
                        })
                )
                .findFirst();

        if (busquedaPorAnio.isPresent()) {
            System.out.println("Libro encontrado");
            System.out.println(busquedaPorAnio.get());
        } else {
            System.out.println("Libro no encontrado");
        }
    }

    private void mostrarEstadisticas(Datos datos) {
        //Trabajando con estadisticas
        IntSummaryStatistics est = datos.resultados().stream()
                .filter(d -> d.descargas() > 0)
                .collect(Collectors.summarizingInt(DatosLibros::descargas));

        System.out.println("Cantidad media de descargas: " + est.getAverage());
        System.out.println("Cantidad maxima de descargas: " + est.getMax());
        System.out.println("Cantidad minima de descargas: " + est.getMin());
        System.out.println("Cantidad de libros evaluados para calcular las estadisticas: " + est.getCount());
    }

}
