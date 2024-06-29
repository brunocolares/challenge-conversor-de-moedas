import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import modelo.Conversion;
import modelo.ConversionRates;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Requisicoes {
    private static final String API_KEY = "9b9e3331054e95d2f41e5606";

    public ConversionRates findConversionRates(Conversion conversion) {
        String baseCode = conversion.getBaseCode();
        String targetCode = conversion.getTargetCode();
        String url = "https://v6.exchangerate-api.com/v6/"+API_KEY+"/pair/"+baseCode+"/"+targetCode;
        URI endereco = URI.create(url);
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder(endereco)
                    .build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            Gson gson = new GsonBuilder()
                    .setPrettyPrinting()
                    .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                    .create();
            return gson.fromJson(response.body(), ConversionRates.class);
        } catch (InterruptedException e) {
            System.out.println("Conexão interrompida: "+e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("O argumento passado não torna uma solicitação válida: "+e.getMessage());
        } catch (IOException e) {
            System.out.println("Não foi possível enviar/receber os dados: "+e.getMessage());
        }
        return null;
    }
}
