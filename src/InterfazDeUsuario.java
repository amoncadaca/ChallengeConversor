import java.util.Scanner;

class InterfazDeUsuario {
    private final ConversorDeDivisas convertir;
    private final Scanner scanner;

    public InterfazDeUsuario(ConversorDeDivisas convertir) {
        this.convertir = convertir;
        this.scanner = new Scanner(System.in);
    }

    public void ejecutar() {
        int opcion;
        do {
            imprimirMenu();
            opcion = leerInteger("Elija una opción válida: ");
            manejarOpcion(opcion);
        } while (opcion != 7);
    }

    private void imprimirMenu() {
        System.out.println("\n*****************************************************");
        System.out.println("Sea bienvenido/a al Conversor de Moneda =]");
        System.out.println("1) Dólar => Peso argentino");
        System.out.println("2) Peso argentino => Dólar");
        System.out.println("3) Dólar => Real brasileño");
        System.out.println("4) Real brasileño => Dólar");
        System.out.println("5) Dólar => Peso colombiano");
        System.out.println("6) Peso colombiano => Dólar");
        System.out.println("7) Salir");
        System.out.println("*****************************************************");
    }

    private int leerInteger(String entrada) {
        System.out.print(entrada);
        while (!scanner.hasNextInt()) {
            System.out.println("Opción inválida. Ingrese un número entero.");
            scanner.next();
        }
        return scanner.nextInt();
    }

    private void manejarOpcion(int opcion) {
        try {
            if (opcion == 7) {
                System.out.println("Saliendo...");
                return;
            }

            String fromMoneda = convertir.getFromMoneda(opcion);
            String toMoneda = convertir.getToMoneda(opcion);

            if (fromMoneda == null || toMoneda == null) {
                System.out.println("Opción inválida.");
                return;
            }

            double cantidad = leerCantidad("Ingrese el valor que desea convertir: ");
            double cantidadConvertida = convertir.convertir(fromMoneda, toMoneda, cantidad);
            System.out.printf("El valor %.2f [%s] corresponde al valor final => %.2f [%s]%n",
                    cantidad, fromMoneda, cantidadConvertida, toMoneda);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    private double leerCantidad(String entrada) {
        System.out.print(entrada);
        while (!scanner.hasNextDouble()) {
            System.out.println("Entrada inválida. Ingrese un número.");
            scanner.next();
        }
        return scanner.nextDouble();
    }
}