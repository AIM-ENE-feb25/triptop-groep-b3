package han.triptop.groepB3.controller;
import han.triptop.groepB3.service.TripadvisorService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class TripadvisorController {
    private final TripadvisorService tripadvisorService;

    public TripadvisorController(TripadvisorService tripadvisorService) {
        this.tripadvisorService = tripadvisorService;
    }

    @GetMapping("/tripadvisorhotels")
    public String getAvailableHotelsTripadvisor() {
        return tripadvisorService.fetchTripadvisorHotels();
    }

}
