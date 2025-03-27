## Status

In overweging

## Context

Bij het ontwerpen van onze softwarearchitectuur staan we voor de keuze tussen verschillende design patterns. De belangrijkste kandidaten zijn het Facade-pattern, Factory-pattern, Adapter-pattern, State-pattern en Strategy-pattern. Elk van deze patronen heeft zijn eigen voordelen en toepassingen. We willen een keuze maken die de codebase vereenvoudigt, onderhoudbaarheid verhoogt en flexibiliteit biedt.

## Considered Options

| Criteria          | Facade | Factory | Adapter | State | Strategy |
|-------------------|--------|---------|---------|-------|----------|
| Eenvoud           | ++     | 0       | +       | --    | --       |
| Onderhoudbaarheid | ++     | +       | 0       | --    | +        |
| Herbruikbaarheid  | 0      | +       | +       | +     | +        |
| Flexibiliteit     | -      | +       | +       | +     | +        |
| Coupling          | ++     | 0       | +       | --    | +        |

## Decision

We kiezen voor het **Facade design pattern**. Dit patroon biedt een vereenvoudigde interface voor complexe subsysteemfunctionaliteit, wat de code overzichtelijker maakt en de afhankelijkheden vermindert.

## Consequences

### Positief

Het Facade-patroon maakt de interactie met complexe subsystemen eenvoudiger. Dit verlaagt de afhankelijkheid tussen componenten. Daardoor ontstaat een meer modulaire architectuur. De code wordt ook leesbaarder en makkelijker te onderhouden. Ontwikkelaars hoeven zich niet direct met de onderliggende implementatie bezig te houden.

### Negatief

Het Facade-patroon voegt een extra abstractielaag toe. Dit kan in sommige gevallen overbodig zijn. Wijzigingen in het subsysteem kunnen alsnog doorwerken in de facade. Hierdoor blijft het voordeel van isolatie beperkt. Ook kan deze interface als een soort God interface worden gebruikt die door elke klasse binnen het systeem wordt gebruikt.

### Actiepunten

Om het Facade-patroon effectief te implementeren, voegen we een centrale interface toe. Deze interface vereenvoudigt de interactie met het subsysteem. Vervolgens beoordelen we of aanvullende patronen zoals Factory of Strategy nodig zijn binnen de facade. Ten slotte stellen we documentatie en best practices op. Dit biedt ontwikkelaars een duidelijke richtlijn voor het correct toepassen en uitbreiden van het patroon binnen het project.

