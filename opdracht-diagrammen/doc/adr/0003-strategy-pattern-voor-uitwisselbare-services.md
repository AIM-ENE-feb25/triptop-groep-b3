# 3. Strategy pattern voor uitwisselbare services

Datum: 2024-03-21

## Status

Voorgesteld

## Context

De Triptop vakantieplan app maakt gebruik van verschillende externe services voor dezelfde functionaliteit, bijvoorbeeld verschillende boekingsservices (Booking.com, Airbnb) of vervoersdiensten (NS, KLM). We willen flexibel kunnen wisselen tussen deze services, bijvoorbeeld wanneer:

- Een service tijdelijk niet beschikbaar is
- Er betere tarieven of aanbiedingen bij een andere service zijn
- We nieuwe services willen toevoegen zonder bestaande code aan te passen
- Een gebruiker een voorkeur heeft voor een bepaalde service

De ontwerpvraag die we willen beantwoorden is: "Hoe zorg je ervoor dat je makkelijk de ene externe service kan vervangen door een andere die ongeveer hetzelfde doet?"

## Beslissing

We implementeren het Strategy design pattern om eenvoudig te kunnen wisselen tussen verschillende externe services die vergelijkbare functionaliteit bieden. De implementatie omvat:

1. **Interface per functionaliteit**: Voor elke type functionaliteit (boekingen, vervoer, activiteiten) definiëren we een interface met duidelijke contracten.

2. **Concrete implementaties**: Elke externe service krijgt een eigen implementatie van de relevante interface.

3. **Service Factory**: Een factory component die de juiste strategie-implementatie instantieert op basis van configuratie of runtime beslissingen.

4. **Context Class**: Een context klasse die de client afschermt van de concrete implementatie en delegeert naar de huidige strategie.

5. **Configuratie systeem**: Een configuratiesysteem dat bepaalt welke concrete implementatie gebruikt moet worden in verschillende scenario's.

## Gevolgen

### Voordelen
- Eenvoudig nieuwe services toevoegen zonder bestaande code aan te passen
- Runtime wisselen tussen services voor failover of optimalisatie
- Duidelijke scheiding van verantwoordelijkheden door interface-gebaseerd ontwerp
- Vergemakkelijkt A/B testing door verschillende services te vergelijken
- Verbeterde testbaarheid door mock-implementaties van de interfaces

### Nadelen
- Initiële complexiteit door het toevoegen van interfaces en factory componenten
- Extra indirectie kan leiden tot hogere onderhoudskosten
- Risico op 'lowest common denominator' interfaces die niet alle functionaliteit van specifieke services benutten

### Technische implementatie
- Definieer interfaces zoals `IAccommodationService`, `ITransportService`, `IActivityService`
- Implementeer concrete klassen zoals `BookingComService`, `AirbnbService` die deze interfaces implementeren
- Bouw een ServiceFactory die de juiste implementatie instantieert op basis van configuratie
- Gebruik dependency injection om de huidige strategie te injecteren in de services die ze gebruiken
- Implementeer een monitoring systeem om de beschikbaarheid en prestaties van services te bewaken 