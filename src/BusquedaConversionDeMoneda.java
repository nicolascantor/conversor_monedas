import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class BusquedaConversionDeMoneda {

    public ConversioDeMoneda conversion(String base, String target, float amount){
        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/a96ed987b037dd9ce20b447e/pair/"+base+"/"+target+"/"+amount);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();

        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), ConversioDeMoneda.class);
        } catch (Exception e) {
            throw new RuntimeException("No encontré esa película.");
        }
    }

}
