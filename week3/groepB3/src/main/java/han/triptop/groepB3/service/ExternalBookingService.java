package han.triptop.groepB3.service;
import org.springframework.stereotype.Service;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Service
public class ExternalBookingService {
    public String fetchBookingHotels() {
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://booking-com15.p.rapidapi.com/api/v1/hotels/searchHotels?dest_id=929&search_type=district&arrival_date=2025-05-05&departure_date=2025-05-06&adults=1&children_age=0%2C17&room_qty=1&page_number=1&units=metric&temperature_unit=c&languagecode=en-us&currency_code=AED&location=US"))
                    .header("x-rapidapi-key", "c452026785mshc8264ef962b3f2ep1e8bf4jsnd53f115ee8cd")
                    .header("x-rapidapi-host", "booking-com15.p.rapidapi.com")
                    .header("content-type", "application/json")
                    .method("GET", HttpRequest.BodyPublishers.noBody())
                    .build();
            HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
            return response.body();
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException("Fout bij het ophalen van hotels via Bookingservice!");
        }
    }
}