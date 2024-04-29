import java.util.Scanner;

public class Desafio {

    public static void main(String[] args) {
        String nombre = "Bruce Wayne";
        String tipoDeCuenta = "Corriente";
        double saldo = 1599.99;
        int opcion = 0;

        System.out.println("********************");
        System.out.println("\nNombre del cliente: " + nombre);
        System.out.println("Tipo de cuenta: " + tipoDeCuenta);
        System.out.println("Su saldo disponible es: $" + saldo);
        System.out.println("\n********************");

        String menu = """
                *** Escriba el numero de la opcion deseada ***
                1. Consultar saldo.
                2. Retirar.
                3. Depositar.
                9. Salir.
                """;

        Scanner teclado = new Scanner(System.in);

        do {
            System.out.println(menu);
            opcion = teclado.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("El saldo actualizado es de: $" + saldo);
                    break;
                case 2:
                    System.out.println("Ingrese el monto a retirar: ");
                    double montoARetirar = teclado.nextDouble();
                    if (montoARetirar <= saldo) {
                        saldo -= montoARetirar;
                        System.out.println("El saldo actualizado es de: $" + saldo);
                    }
                    else System.out.println("Saldo insuficiente");
                    break;
                case 3:
                    System.out.println("Ingrese el monto a depositar: ");
                    double montoADepositar = teclado.nextDouble();
                    if (montoADepositar > 0) {
                        saldo += montoADepositar;
                        System.out.println("El saldo actualizado es de: $" + saldo);
                    }
                    else System.out.println("Valor ingresado no valido");
                    break;
                case 9:
                    System.out.println("Finalizando el sistema, gracias por utilizar nuestros servicios.");
                    break;
                default:
                    System.out.println("Opcion no valida, vuelva a intentarlo");
            }

        }while(opcion != 9);
    }

}
