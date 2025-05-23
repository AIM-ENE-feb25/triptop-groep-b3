package han.triptop.groepB3.service;

import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.URI;

@Service
public class ExternalTripadvisorService {
    public String fetchTripadvisorHotels() {
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://tripadvisor16.p.rapidapi.com/api/v1/hotels/searchHotels?geoId=60763&checkIn=2025-05-05&checkOut=2025-05-06&pageNumber=1&currencyCode=USD"))
                    .header("x-rapidapi-key", "c452026785mshc8264ef962b3f2ep1e8bf4jsnd53f115ee8cd")
                    .header("x-rapidapi-host", "tripadvisor16.p.rapidapi.com")
                    .header("content-type", "application/json")
                    .method("GET", HttpRequest.BodyPublishers.noBody())
                    .build();
            HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
            return response.body();
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException("Fout bij het ophalen van hotels via Tripadvisor!");
        }
    }
}