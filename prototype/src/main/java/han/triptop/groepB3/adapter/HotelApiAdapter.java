package han.triptop.groepB3.adapter;

import java.io.IOException;

public interface HotelApiAdapter {
    String fetchHotels() throws IOException, InterruptedException;
}
