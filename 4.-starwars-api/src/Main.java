import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //int opcion  = 9;
        ConsultaApi consulta = new ConsultaApi();
        Scanner teclado = new Scanner(System.in);
        System.out.println("Ingrese el numero de entrega de la pelicula de star wars que quiere ver: ");

        try {
            var entrega = Integer.valueOf(teclado.nextLine());
            Pelicula pelicula = consulta.consultar(entrega);
            System.out.println(pelicula);
            GeneradorDeArchivo generador = new GeneradorDeArchivo();
            generador.guardarJson(pelicula);
        } catch (NumberFormatException e) {
            System.out.println("Numero no encontrado" + e.getMessage());
        } catch (RuntimeException | IOException e) {
            System.out.println(e.getMessage());
            System.out.println("Finalizando la aplicacion");
        }

    }
}