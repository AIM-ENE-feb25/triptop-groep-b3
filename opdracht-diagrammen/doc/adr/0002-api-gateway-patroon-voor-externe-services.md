# 2. API Gateway patroon voor externe services

Datum: 2024-03-21

## Status

Voorgesteld

## Context

Bij de Triptop vakantieplan app worden verschillende externe services geïntegreerd, zoals boekingssystemen (Booking.com, Airbnb), vervoersdiensten (NS, KLM) en activiteitenplatforms (GetYourGuide, Tripadvisor). Deze externe services wijzigen regelmatig hun API's, wat kan leiden tot frequente aanpassingen in onze applicatie.

De ontwerpvraag die we willen beantwoorden is: "Hoe zorg je dat een wijziging in een of meerdere APIs niet leidt tot een grote wijziging in de applicatie? Specifieker: hoe zorg je ervoor dat een wijziging in de API van een externe service niet leidt tot een wijziging in de front-end maar flexibel kan worden opgevangen door de back-end?"

## Beslissing

We implementeren een API Gateway patroon met een adapter-laag voor elke externe service. De architectuur ziet er als volgt uit:

1. **API Gateway**: Een centrale component die alle communicatie tussen de frontend en externe services afhandelt.
2. **Service Adapters**: Specifieke adapters voor elke externe service die de conversie tussen onze interne modellen en de externe API formats afhandelen.
3. **Interface Contract**: Een stabiele interne API die door de frontend wordt gebruikt, onafhankelijk van externe API wijzigingen.

Wanneer een externe service zijn API wijzigt, hoeven we alleen de betreffende adapter aan te passen zonder wijzigingen in de frontend of andere delen van de applicatie.

## Gevolgen

### Voordelen
- De frontend is geïsoleerd van wijzigingen in externe API's
- Uniforme error handling en logging voor alle externe services
- Mogelijkheid tot caching en rate limiting op gateway-niveau
- Eenvoudiger testen door mock implementaties van de adapters
- Flexibele vervanging van externe services zonder frontend aanpassingen

### Nadelen
- Extra architectuurlaag die onderhouden moet worden
- Potentiële performance overhead door extra abstraction layer
- Initiële ontwikkelingstijd voor het opzetten van de gateway en adapters

### Technische implementatie
- We implementeren de gateway als een RESTful API in onze backend
- Elke adapter wordt geïmplementeerd als een aparte module/klasse die de adapter interface implementeert
- We maken gebruik van dependency injection voor het injecteren van de juiste adapters
- We gebruiken het facade pattern om een uniforme interface naar de frontend te bieden 