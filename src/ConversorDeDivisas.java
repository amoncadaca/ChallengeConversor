import com.google.gson.Gson;

import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.Map;

public class ConversorDeDivisas {
    private final String apiUrl;
    private final HttpClient httpClient;
    private final Gson gson;
    private final Map<Integer, String[]> paresDeDivisas;

    public ConversorDeDivisas(String apiUrl) {
        this.apiUrl = apiUrl;
        this.httpClient = HttpClient.newHttpClient();
        this.gson = new Gson();
        this.paresDeDivisas = inicializarParesDeDivisas();
    }

    private Map<Integer, String[]> inicializarParesDeDivisas() {
        Map<Integer, String[]> pares = new HashMap<>();
        pares.put(1, new String[]{"USD", "ARS"});
        pares.put(2, new String[]{"ARS", "USD"});
        pares.put(3, new String[]{"USD", "BRL"});
        pares.put(4, new String[]{"BRL", "USD"});
        pares.put(5, new String[]{"USD", "COP"});
        pares.put(6, new String[]{"COP", "USD"});
        return pares;
    }

    public String getFromMoneda(int opcion) {
        String[] par = paresDeDivisas.get(opcion);
        return par != null ? par[0] : null;
    }

    public String getToMoneda(int opcion) {
        String[] par = paresDeDivisas.get(opcion);
        return par != null ? par[1] : null;
    }

    public double convertir(String fromMoneda, String toMoneda, double cantidad) throws Exception {
        String encodedMoneda = URLEncoder.encode(fromMoneda, "UTF-8");
        URI uri = URI.create(apiUrl + encodedMoneda);

        HttpRequest request = HttpRequest.newBuilder().uri(uri).build();
        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        Map<String, Object> data = gson.fromJson(response.body(), Map.class);
        Map<String, Double> tasasDeConversion = (Map<String, Double>) data.get("conversion_rates");

        Double tasa = tasasDeConversion.get(toMoneda);
        if (tasa == null) {
            throw new IllegalArgumentException("No se encontró la tasa de conversión para la moneda " + toMoneda);
        }
        return cantidad * tasa;
    }
}
