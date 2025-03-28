# Gekozen ontwerpvraag:

(Interoperability) "Wie roept een specifieke externe service aan, gebeurt dat vanuit de front-end of vanuit de back-end?
Welke redenen zijn er om voor de ene of de andere aanpak te kiezen?"

## 1e onderdeel (20 minuten)

Het bepalen welk component waarvoor verantwoordelijk is en een naam kiezen die past bij die verantwoordelijkheid
De uitkomst van deze stap is een lijst van componenten met een naam en een verantwoordelijkheid.

| Component         | Verantwoordelijkheid                                            |
|-------------------|-----------------------------------------------------------------|
| Login             | Rendert login form voor gebruiker                               |
| OAuth provider    | Behandelt authenticatie en verstrekt tokens via OAuth2          |
| HotelController   | Creëert endpoint voor gebruiker om hotelinformatie op te vragen |
| HotelService      | Behandelt ophalen van hotelgegevens van externe API             |
| BookingAPI        | Externe API voor het verstrekken van hotelgegevens              |
| Identity Provider | Authenticatie via oauth2                                        |

## 2e onderdeel (20 minuten)

Het beschrijven van de interfaces van de betrokken componenten.
De uitkomst van deze stap is een lijst van interfaces met methoden en een eerste versie van parameters en returnwaarden.

```
interface IdentityProvider {
AuthToken authenticateUser(String authCode);
boolean validateToken(AuthToken token);
}

interface HotelService {
List<Hotel> findHotels(String location, LocalDate checkIn, LocalDate checkOut);
}
```

## 3e onderdeel (20 minuten)

Het kiezen van een volgorde van aanroepen waarin de componenten samenwerken (Coupling).
De uitkomst van deze stap is een dynamic diagram met componenten.

Zie _dynamic_container_diagram_pressure_cooker_fetch_hotels.puml_
en _dynamic_container_diagram_pressure_cooker_login.puml_

## 4e onderdeel (20 minuten)

Het opdelen van de componenten in een of meerdere classes en/of functies (Open/Closed Principle, Extensibility,
Composition over inheritance, Law of Demeter, Information hiding).
De uitkomst is een class diagram met classes en functies (het code/class level van C4).

Zie _class_diagram.puml_

### Antwoord op ontwerpvraag:

In de meeste gevallen roept de backend een externe API aan, bijvoorbeeld bij databases of externe services.
Soms gebeurt dit echter ook vanuit de frontend, bijvoorbeeld bij het ophalen en weergeven van kaartgegevens via de
Google Maps API.

#### Voordelen:

| Frontend                    | Backend                             |
|:----------------------------|:------------------------------------|
| Geen tussenstap van backend | API keys blijven geheim             |
| Minder serverbelasting      | Backend kan errors beter afhandelen |

#### Nadelen:

| Frontend                            | Backend                       |
|:------------------------------------|:------------------------------|
| API keys kunnen uitlekken           | Extra netwerkverkeer          |
| Moeilijker om caching toe te passen | Hogere belasting op de server | 

