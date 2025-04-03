# gekozen ontwerpvraag:
Hoe zorg je ervoor dat je bij een wijziging in de datastructuur van een externe service niet de hele applicatie hoeft aan te passen?

## Eerste 20 minuten

Frontend
- is verantwoordelijk voor de versturen van gebruiker data naar de backend
- Encapsulate what varies

BookingController
- Zorgt voor het checken van gebruikers input en het transformeren van gebruikers input naar iets leesbaars in code
- Single responsibility principle

BookingService
- Zorgt ervoor dat de boekingen op de juiste manier naar de repository en BookingAPI worden verstuurd
- Separation of Concerns

BookingRepository
- Zorgt ervoor dat de data van de boekingen opgeslagen kan worden in de database
- Single responsibility principle

BookingAPIAdapter
- Zorgt voor een interface die altijd ervoor zorgt dat de data van de boekingen api hetzelfde blijft zodat dit niet de hele codebase overhoopt gooit
- Encapsulate what varies

BookingAPIAdapterImplementation
- Haalt de data op vanuit de BookingAPI en vervormt dit zodat het consistent is met de BookingAPIAdapter
- Single responsibility principle

BookingAPI
- Zorgt voor de boekingen
- Separation of Concerns

Database
- Zorgt voor het ophalen en opslaan van data
- Separation of Concerns

## Tweede 20 minuten

BookingAPIAdapter
- List\<BookingAPIDto> getAllBookings();
- void saveBooking(BookingAPIDto booking);

BookingRepository
- List\<BookingDto> getAllBookings();
- void saveBooking(BookingDto booking);
- BookingDto getBookingById(int id);

BookingService 
- List\<BookingDto> getAllBookings();
- void saveBooking(BookingDto booking);

## Derde 20 minuten

1. Frontend
2. BookingController
3. BookingService
4. BookingAPIAdapter
5. BookingAPIAdapterImplementation
6. BookingAPI
7. Terug naar de BookingService met de booking data als er dan iets is ontstaan dan is dit nog niet opgeslagen in de database
8. BookingRepository
9. Database
10. Terug naar de BookingController die dan de data terug stuurt naar de frontend

## Laatste 30 minuten

Zie class-diagram.puml