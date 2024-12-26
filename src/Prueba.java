import com.google.gson.Gson;

import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Prueba {

    public static void main(String[] args) throws Exception{

        Scanner teclado = new Scanner(System.in);

        Map<Integer, String> monedas = new HashMap<>();
        monedas.put(1, "USD");
        monedas.put(2, "ARS");
        monedas.put(3, "USD");
        monedas.put(4, "BRL");
        monedas.put(5, "USD");
        monedas.put(6, "COP");

        int opcion = 0;

        do {
            System.out.println("\n*****************************************************");
            System.out.println("Sea bienvenido/a al Conversor de Moneda =]");
            System.out.println("1) Dólar => Peso argentino");
            System.out.println("2) Peso argentino => Dólar");
            System.out.println("3) Dólar => Real brasileño");
            System.out.println("4) Real brasileño => Dólar");
            System.out.println("5) Dólar => Peso colombiano");
            System.out.println("6) Peso colombiano => Dólar");
            System.out.println("7) Salir");
            System.out.println("Elija una opción válida: ");
            System.out.println("*****************************************************");

            while (!teclado.hasNextInt()) {
                System.out.println("Opción inválida. Ingrese un número entero.");
                teclado.next();
            }

            opcion = teclado.nextInt();
            String divisa = monedas.get(opcion);

            String moneda = String.valueOf(divisa);
            String busqueda = URLEncoder.encode(moneda, "UTF-8");
            URI direccion = URI.create("https://v6.exchangerate-api.com/v6/edc9e5450d9143516a2735fb/latest/" + busqueda );
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(direccion)
                    .build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            String json = response.body();
            Gson gson = new Gson();
            Map<String, Object> data = gson.fromJson(json, Map.class);
            Map<String, Double> conversionRates = (Map<String, Double>) data.get("conversion_rates");

            double valorConvertir;
            Double nombre;
            double valorMoneda;
            double valorConvertido;

            switch (opcion) {
                case 1:
                    System.out.println("Conversión de Dólar a Peso argentino");
                    System.out.print("Ingrese el valor que deseas convertir:");
                    valorConvertir = teclado.nextDouble();
                    nombre = conversionRates.get("ARS");
                    valorMoneda = nombre;
                    valorConvertido = valorConvertir * valorMoneda;
                    System.out.print("El valor " + valorConvertir +
                            " [USD]  corresponde al valor final =>> " + valorConvertido +
                            " [ARS]" );
                    break;
                case 2:
                    System.out.println("Conversión de Peso argentino a Dólar");
                    System.out.print("Ingrese el valor que deseas convertir:");
                    valorConvertir = teclado.nextDouble();
                    nombre = conversionRates.get("USD");
                    valorMoneda = nombre;
                    valorConvertido = valorConvertir * valorMoneda;
                    System.out.print("El valor " + valorConvertir +
                            " [ARS]  corresponde al valor final =>> " + valorConvertido +
                            " [USD]" );
                    break;
                case 3:
                    System.out.println("Conversión de Dólar a Real brasileño");
                    System.out.print("Ingrese el valor que deseas convertir:");
                    valorConvertir = teclado.nextDouble();
                    nombre = conversionRates.get("BRL");
                    valorMoneda = nombre;
                    valorConvertido = valorConvertir * valorMoneda;
                    System.out.print("El valor " + valorConvertir +
                            " [USD]  corresponde al valor final =>> " + valorConvertido +
                            " [BRL]" );
                    break;
                case 4:
                    System.out.println("Conversión de Real brasileño a Dólar");
                    System.out.print("Ingrese el valor que deseas convertir:");
                    valorConvertir = teclado.nextDouble();
                    nombre = conversionRates.get("USD");
                    valorMoneda = nombre;
                    valorConvertido = valorConvertir * valorMoneda;
                    System.out.print("El valor " + valorConvertir +
                            " [BRL]  corresponde al valor final =>> " + valorConvertido +
                            " [USD]" );
                    break;
                case 5:
                    System.out.println("Conversión de Dólar a Peso colombiano");
                    System.out.print("Ingrese el valor que deseas convertir:");
                    valorConvertir = teclado.nextDouble();
                    nombre = conversionRates.get("COP");
                    valorMoneda = nombre;
                    valorConvertido = valorConvertir * valorMoneda;
                    System.out.print("El valor " + valorConvertir +
                            " [USD]  corresponde al valor final =>> " + valorConvertido +
                            " [COP]" );
                    break;
                case 6:
                    System.out.println("Conversión de Peso colombiano a Dólar");
                    System.out.print("Ingrese el valor que deseas convertir:");
                    valorConvertir = teclado.nextDouble();
                    nombre = conversionRates.get("ARS");
                    valorMoneda = nombre;
                    valorConvertido = valorConvertir * valorMoneda;
                    System.out.print("El valor " + valorConvertir +
                            " [COP]  corresponde al valor final =>> " + valorConvertido +
                            " [USD]" );
                    break;
                case 7:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        } while (opcion != 7);
    }
}