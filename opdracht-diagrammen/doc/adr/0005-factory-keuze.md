# 5. Factory keuze

Date: 2025-03-27

## Status

Proposed

## Context

TripTop biedt gebruikers de mogelijkheid om reizen samen te stellen uit verschillende "bouwstenen" zoals vluchten, accommodaties en activiteiten. Deze componenten moeten flexibel uitbreidbaar zijn zonder bestaande code aan te passen. We moeten een patroon kiezen dat het mogelijk maakt om nieuwe providers en bouwsteentypes toe te voegen terwijl de applicatie onafhankelijk blijft van specifieke implementaties.

## Considered options

| Criteria              | State | Strategy | Adapter | Facade | Factory Method |
|:----------------------|:-----:|:--------:|:-------:|:------:|:--------------:|
| Flexibiliteit         |   +   |    ++    |    +    |   -    |       ++       |
| Ontkoppeling          |   +   |    +     |   ++    |   -    |       ++       |
| Uitbreidbaarheid      |   +   |    +     |    +    |   -    |       ++       |
| Eenvoud implementatie |   -   |    +     |    -    |  ++    |       +        |
| Toekomstbestendigheid |   +   |    +     |    +    |   -    |       ++       |

## Decision

We implementeren het Factory Method Pattern voor TripTop. Dit patroon biedt de beste combinatie van flexibiliteit, ontkoppeling en uitbreidbaarheid voor TripTop.

## Consequences

Het Factory Method Pattern zorgt voor een duidelijke scheiding tussen creatie en gebruik van reisbouwstenen. Nieuwe providers en types kunnen worden toegevoegd zonder bestaande code te wijzigen. Het systeem wordt beter testbaar doordat we makkelijker mock-implementaties kunnen injecteren.

Het patroon introduceert wel extra klassen en interfaces, wat de initiële complexiteit verhoogt. Dit kan voor beginnende ontwikkelaars een leercurve betekenen en de ontwikkeltijd verlengen in vergelijking met directe, minder flexibele implementaties.

### Actiepunten

We definiëren kerninterfaces voor reisbouwstenen en factories, creëren een consistente naamgeving, en ondersteunen de implementatie met unit tests. We documenteren het patroon grondig voor toekomstige ontwikkelaars.
