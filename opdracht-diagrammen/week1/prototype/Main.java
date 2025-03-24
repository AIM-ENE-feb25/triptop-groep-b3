import java.net.http.*;
import java.net.URI;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        // booking.com api call prototype
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://booking-com15.p.rapidapi.com/api/v1/attraction/getAttractionReviews?id=PR6K7ZswbGBs&page=1"))
                .header("x-rapidapi-key", "52cd520e8cmsh67cc52752269552p165af7jsn20cf7288032d")
                .header("x-rapidapi-host", "booking-com15.p.rapidapi.com")
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();

        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());
    }
}