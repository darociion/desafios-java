import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner lectura = new Scanner(System.in);
        System.out.println("Escribe el limite de tu tarjeta: ");
        double limite = lectura.nextDouble();
        TarjetaDeCredito tarjeta = new TarjetaDeCredito(limite);
        int opcion = 1;

        while (opcion != 0) {
            System.out.println("Escribe la descripcion de la compra: ");
            String descripcion = lectura.next();

            System.out.println("Escribe el valor de la compra: ");
            double valor = lectura.nextDouble();

            Compra compra = new Compra(valor, descripcion);
            boolean compraRealizada = tarjeta.comprar(compra);

            if (compraRealizada) {
                System.out.println("Compra realizada!");
                System.out.println("Escribe 0 para salir o 1 para continuar");
                opcion = lectura.nextInt();
            } else {
                System.out.println("Saldo insuficiente");
                opcion = 0;
            }
        }

        System.out.println("*********************");
        System.out.println("COMPRAS REALIZADAS \n");

        Collections.sort(tarjeta.getListaDeCompras());

        for (Compra compra : tarjeta.getListaDeCompras()) {
            System.out.println(compra.getDescripcion() + " $" + compra.getValor());
        }

        System.out.println("*********************");
        System.out.println("Saldo de la tarjeta: $" + tarjeta.getSaldo());

    }
}