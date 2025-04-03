# Software Guidebook Triptop

## 1. Introduction

Dit software guidebook geeft een overzicht van de Triptop-applicatie. Het bevat een samenvatting van het volgende:

1. De vereisten, beperkingen en principes. 
2. De software-architectuur, met inbegrip van de technologiekeuzes op hoog niveau en de structuur van de software.
3. De ontwerp- en codebeslissingen die zijn genomen om de software te realiseren.
4. De architectuur van de infrastructuur en hoe de software kan worden geinstalleerd.

## 2. Context

![context-diagram.svg](resources%2Fcontext-diagram.svg)

Toelichting op de context van de software inclusief System Context Diagram:

* Functionaliteit
* Gebruikers
* Externe systemen

## 3. Functional Overview

Om de belangrijkste features toe te lichten zijn er user stories en twee domain stories gemaakt en een overzicht van het
domein in de vorm van een domeinmodel. Op deze plek staat typisch een user story map maar die ontbreekt in dit
voorbeeld.

### 3.1 User Stories

#### 3.1.1 User Story 1: Reis plannen

Als gebruiker wil ik een zelfstandig op basis van diverse variabelen (bouwstenen) een reis kunnen plannen op basis van
mijn reisvoorkeuren (wel/niet duurzaam reizen, budget/prijsklasse, 's nachts reizen of overdag etc.) zodat ik op
vakantie kan gaan zonder dat hiervoor een reisbureau benodigd is.

#### 3.1.2 User Story 2: Reis boeken

Als gebruiker wil ik een geplande reis als geheel of per variabele (bouwsteen) boeken en betalen zodat ik op vakantie
kan gaan zonder dat hiervoor een reisbureau benodigd is.

#### 3.1.3 User Story 3: Reis cancelen

Als gebruiker wil ik een geboekte reis, of delen daarvan, kunnen annuleren zodat ik mijn geld terug kan krijgen zonder
inmenging van een intermediair zoals een reisbureau.

#### 3.1.4 User Story 4: Reisstatus bewaren

Als gebruiker wil ik mijn reisstatus kunnen bewaren zonder dat ik een extra account hoef aan te maken zodat ik mijn reis
kan volgen zonder dat ik daarvoor extra handelingen moet verrichten.

#### 3.1.5 User Story 5: Bouwstenen flexibel uitbreiden

Als gebruiker wil ik de bouwstenen van mijn reis flexibel kunnen uitbreiden met een zelf te managen stap (bijv. met
providers die niet standaard worden aangeboden zoals een andere reisorganisatie, hotelketen etc.) zodat ik mijn reis
helemaal kan aanpassen aan mijn wensen.

### 3.2 Domain Story Reis Boeken (AS IS)

![Domain Story Reis Boeken AS IS](../opdracht-diagrammen/reis-boeken-asis-coursegrained_2024-06-11.egn.svg)

### 3.3 Domain Story Reis Boeken (TO BE)

![Domain Story Reis Boeken TO BE](../opdracht-diagrammen/reis-boeken-tobe-coursegrained_2024-06-11.egn.svg)

### 3.4 Domain Model

![Domain Model](../opdracht-diagrammen/Domain%20Model.png)

## 4. Quality Attributes

Voordat deze casusomschrijving tot stand kwam, heeft de opdrachtgever de volgende ISO 25010 kwaliteitsattributen benoemd
als belangrijk:

* Compatibility -> Interoperability (Degree to which a system, product or component can exchange information with other
  products and mutually use the information that has been exchanged)
* Reliability -> Fault Tolerance (Degree to which a system or component operates as intended despite the presence of
  hardware or software faults)
* Maintainability -> Modularity (Degree to which a system or computer program is composed of discrete components such
  that a change to one component has minimal impact on other components)
* Maintainability -> Modifiability (Degree to which a product or system can be effectively and efficiently modified
  without introducing defects or degrading existing product quality)
* Security -> Integrity (Degree to which a system, product or component ensures that the state of its system and data
  are protected from unauthorized modification or deletion either by malicious action or computer error)
* Security -> Confidentiality (Degree to which a system, product or component ensures that data are accessible only to
  those authorized to have access)

## 5. Constraints

> [!IMPORTANT]
> Beschrijf zelf de beperkingen die op voorhand bekend zijn die invloed hebben op keuzes die wel of niet gemaakt kunnen
> of mogen worden.

## 6. Principles

> [!IMPORTANT]
> Beschrijf zelf de belangrijkste architecturele en design principes die zijn toegepast in de software.

### Facade

In dit project is facade gebruikt bij de autorisatie service. Dit is gebruikt voor als de data die terug gestuurd wordt via identity provider api aangepast wordt. Dan hoeft niet de hele applicatie aangepast hoeft te worden.

### Adapter-pattern

In dit project is het adapter pattern toegepast bij het communiceren met API's in de backend, bij de tripadvisor api en de booking.com API.  
Dit zorgt voor modulariteit en makkelijke uitbreidbaarheid indien er later soortgelijke API's toegevoegd worden.

### Factory

In dit project is het Factory design pattern toegepast voor het creëren van verschillende TripAdvisor activiteiten. Dit patroon beantwoordt de vraag: "Hoe breiden we het systeem uit met nieuwe activiteitstypes zonder bestaande code te wijzigen?"

De implementatie bestaat uit:

* Een `Activity` interface met gemeenschappelijke methoden
* Concrete implementatieklassen per activiteitstype (Flight, Hotel, etc.)
* Een `ActivityFactory` die de juiste objecten aanmaakt

Nieuwe activiteitstypes toevoegen kan door:

1. Een nieuwe klasse te maken die `Activity` implementeert
2. Een nieuwe factory methode toe te voegen
3. Een nieuw endpoint toe te voegen

### Andere architecturele keuzes

1. **Interface-gebaseerd ontwerp**: De `Activity` interface scheidt de implementatie van het gebruik, waardoor verschillende activiteitstypes uniform behandeld worden.

2. **Dependency Injection**: In `TripAdvisorController` worden `TripAdvisorService` en `ActivityFactory` via constructor-injectie toegevoegd, wat betere testbaarheid biedt.

3. **Encapsulatie van API details**: Elke activiteitsklasse bepaalt zijn eigen endpoint en parameters, zoals te zien in `FlightActivity.getEndpoint()` en `getQueryParams()`.

4. **Open/Closed Principle**: Nieuwe activiteiten zoals `CruiseActivity` kunnen worden toegevoegd zonder wijzigingen aan bestaande code.

## 7. Software Architecture

### 7.1. Containers

![container-diagram.svg](resources%2Fcontainer-diagram.svg)

### 7.2. Components

Backend component diagram
![component-backend-diagram.svg](resources%2Fcomponent-backend-diagram.svg)

Frontend component diagram
![component-frontend-diagram.svg](resources%2Fcomponent-frontend-diagram.svg)

Dynamic diagram voor hotels ophalen
![dynamic-diagram-hotels-ophalen.svg](resources%2Fdynamic-diagram-hotels-ophalen.svg)

Dynamic diagram voor login
![dynamic-diagram-login.svg](resources%2Fdynamic-diagram-login.svg)

### 7.3. Design & Code

Adapter class diagram
![adapter-class-diagram.svg](resources%2Fadapter-class-diagram.svg)

Facade class diagram
![facade-class-diagram.svg](resources%2Ffacade-class-diagram.svg)

Factory class diagram
![factory-class-diagram.svg](resources%2Ffactory-class-diagram.svg)

> [!IMPORTANT]
> Voeg toe: Per ontwerpvraag een Class Diagram plus een Sequence-Diagram van een aantal scenario's inclusief
> begeleidende tekst.

## 8. Architectural Decision Records

### 8.1. ADR-001 Google Maps API Toegang

Datum: 2025-03-21

#### Status

Accepted

#### Context

De TripTop applicatie heeft Google Maps functionaliteit nodig voor locaties en routes. De vraag is of we de API
rechtstreeks vanuit de frontend of via de backend moeten benaderen.

#### Considered Options

| Criteria                  | Backend | Frontend | Hybride |
|---------------------------|---------|----------|---------|
| Beveiliging               | ++      | --       | +       |
| Gebruikerservaring        | -       | ++       | ++      |
| Serverbelasting           | --      | ++       | +       |
| Implementatiecomplexiteit | +       | +        | -       |
| Caching mogelijkheden     | ++      | -        | +       |

#### Decision

We kiezen voor een hybride aanpak waarbij we het beste van twee werelden combineren. Visuele kaarten worden direct via
de frontend geladen met de Google Maps JavaScript API, wat zorgt voor een snelle en interactieve gebruikerservaring.
Tegelijkertijd worden alle gevoelige operaties zoals routeberekeningen en geocoding veilig via de backend afgehandeld.
Om de prestaties te optimaliseren, implementeert de backend een slim cachingsysteem dat veelgebruikte routes en
locatiegegevens bewaart voor hergebruik.

#### Consequences

##### Positief

De gebruiker ervaart een snelle, interactieve kaartervaring terwijl de API-sleutels veilig op de server worden bewaard.
Het systeem profiteert van effectieve caching van veelgebruikte routes, wat de prestaties verder verbetert.

##### Negatief

We moeten rekening houden met een dubbele implementatie in zowel frontend als backend, wat extra ontwikkeltijd kost. De
configuratie wordt complexer door de hybride aanpak, wat meer aandacht vereist tijdens de implementatie en het
onderhoud.

##### Actiepunten

We zullen een duidelijk functionaliteitenoverzicht maken waarin we de verdeling tussen frontend en backend specificeren.
Het implementeren van een robuust caching-systeem en het toevoegen van rate limiting zijn essentiële vervolgstappen om
de oplossing te optimaliseren.

### 8.2. ADR-002 Integratie van Identity Providers

Datum: 2025-03-21

#### Status

Proposed

#### Context

TripTop moet verschillende identity providers integreren (Google, Microsoft, AirBnB) om gebruikers in te laten loggen
zonder een extra account aan te maken. De containerdiagram toont een aparte Login Service die communiceert met externe
Identity Provider APIs. We moeten beslissen hoe deze verschillende providers te integreren zodat het systeem niet
afhankelijk wordt van één specifieke provider.

#### Considered Options

| Criteria                        | Directe integratie | Adapter Pattern | OAuth middleware |
|---------------------------------|--------------------|-----------------|------------------|
| Onafhankelijkheid van providers | --                 | ++              | +                |
| Implementatie-eenvoud           | +                  | -               | ++               |
| Gebruikerservaring              | +                  | +               | ++               |
| Onderhoudbaarheid               | --                 | +               | ++               |
| Beveiliging                     | +                  | +               | ++               |

#### Decision

Na zorgvuldige afweging hebben we gekozen voor een elegante oplossing met het OAuth 2.0 protocol en het Adapter Pattern.
We centraliseren alle authenticatie in de Login Service container, waar een generieke interface als brug fungeert tussen
onze applicatie en de diverse identity providers.

Voor elke provider, zoals Google, Microsoft en AirBnB, ontwikkelen we een specifieke adapter die de unieke eigenschappen
van die provider vertaalt naar onze standaard interface. Een slimme factory bepaalt vervolgens welke adapter nodig is,
gebaseerd op de keuze van de gebruiker.

Het hart van deze oplossing is onze `IdentityProviderInterface`, die alle essentiële authenticatiefuncties definieert:

#### Consequences

##### Positief

Gebruikers kunnen inloggen met bestaande accounts en nieuwe providers zijn eenvoudig toe te voegen zonder
systeemwijzigingen. De Login Service fungeert als beveiligingslaag en zorgt voor een consistente authenticatie-ervaring
ongeacht de gekozen provider.

##### Negatief

De abstractielaag voegt complexiteit toe en verschillende providers ondersteunen uiteenlopende features. De
synchronisatie van userdata tussen providers vereist extra logica, wat het systeem complexer maakt.

##### Actiepunten

We implementeren de OAuth 2.0 flow en ontwikkelen provider adapters voor diverse identity providers. We creëren een
gebruikersinterface voor providerkeuze en implementeren een token-validatie/refreshing mechanisme voor optimale
beveiliging.

### 8.3. ADR-003 Factory keuze

Datum: 2025-03-27
#### Status

Proposed

#### Context

TripTop biedt gebruikers de mogelijkheid om reizen samen te stellen uit verschillende "bouwstenen" zoals vluchten, accommodaties en activiteiten. Deze componenten moeten flexibel uitbreidbaar zijn zonder bestaande code aan te passen. We moeten een patroon kiezen dat het mogelijk maakt om nieuwe providers en bouwsteentypes toe te voegen terwijl de applicatie onafhankelijk blijft van specifieke implementaties.

#### Considered options

| Criteria              | State | Strategy | Adapter | Facade | Factory Method |
|:----------------------|:-----:|:--------:|:-------:|:------:|:--------------:|
| Flexibiliteit         |   +   |    ++    |    +    |   -    |       ++       |
| Ontkoppeling          |   +   |    +     |   ++    |   -    |       ++       |
| Uitbreidbaarheid      |   +   |    +     |    +    |   -    |       ++       |
| Eenvoud implementatie |   -   |    +     |    -    |  ++    |       +        |
| Toekomstbestendigheid |   +   |    +     |    +    |   -    |       ++       |

#### Decision

We implementeren het Factory Method Pattern voor TripTop. Dit patroon biedt de beste combinatie van flexibiliteit, ontkoppeling en uitbreidbaarheid voor TripTop.

#### Consequences

Het Factory Method Pattern zorgt voor een duidelijke scheiding tussen creatie en gebruik van reisbouwstenen. Nieuwe providers en types kunnen worden toegevoegd zonder bestaande code te wijzigen. Het systeem wordt beter testbaar doordat we makkelijker mock-implementaties kunnen injecteren.

Het patroon introduceert wel extra klassen en interfaces, wat de initiële complexiteit verhoogt. Dit kan voor beginnende ontwikkelaars een leercurve betekenen en de ontwikkeltijd verlengen in vergelijking met directe, minder flexibele implementaties.

##### Actiepunten

We definiëren kerninterfaces voor reisbouwstenen en factories, creëren een consistente naamgeving, en ondersteunen de implementatie met unit tests. We documenteren het patroon grondig voor toekomstige ontwikkelaars.

### 8.4. ADR-004 Facade keuze

Date: 2025-03-27

#### Status

Proposed

#### Context

Bij het ontwerpen van onze softwarearchitectuur staan we voor de keuze tussen verschillende design patterns. De
belangrijkste kandidaten zijn het Facade-pattern, Factory-pattern, Adapter-pattern, State-pattern en Strategy-pattern.
Elk van deze patronen heeft zijn eigen voordelen en toepassingen. We willen een keuze maken die de codebase
vereenvoudigt, onderhoudbaarheid verhoogt en flexibiliteit biedt.

#### Considered Options

| Criteria          | Facade | Factory | Adapter | State | Strategy |
|-------------------|--------|---------|---------|-------|----------|
| Eenvoud           | ++     | 0       | +       | --    | --       |
| Onderhoudbaarheid | ++     | +       | 0       | --    | +        |
| Herbruikbaarheid  | 0      | +       | +       | +     | +        |
| Flexibiliteit     | -      | +       | +       | +     | +        |
| Coupling          | ++     | 0       | +       | --    | +        |

#### Decision

We kiezen voor het **Facade design pattern**. Dit patroon biedt een vereenvoudigde interface voor complexe
subsysteem functionaliteit, wat de code overzichtelijker maakt en de afhankelijkheden vermindert.

#### Consequences

##### Positief

Het Facade-patroon maakt de interactie met complexe subsystemen eenvoudiger. Dit verlaagt de afhankelijkheid tussen
componenten. Daardoor ontstaat een meer modulaire architectuur. De code wordt ook leesbaarder en makkelijker te
onderhouden. Ontwikkelaars hoeven zich niet direct met de onderliggende implementatie bezig te houden.

##### Negatief

Het Facade-patroon voegt een extra abstractielaag toe. Dit kan in sommige gevallen overbodig zijn. Wijzigingen in het
subsysteem kunnen alsnog doorwerken in de facade. Hierdoor blijft het voordeel van isolatie beperkt. Ook kan deze
interface als een soort God interface worden gebruikt die door elke klasse binnen het systeem wordt gebruikt.

##### Actiepunten

Om het Facade-patroon effectief te implementeren, voegen we een centrale interface toe. Deze interface vereenvoudigt de
interactie met het subsysteem. Vervolgens beoordelen we of aanvullende patronen zoals Factory of Strategy nodig zijn
binnen de facade.

### 8.5. ADR-005 Adapter keuze

Date: 2025-03-27

#### Status

Proposed

#### Context

Bij het ontwerpen van onze softwarearchitectuur hebben we verschillende ontwerppatronen overwogen die kunnen bijdragen aan een flexibele, onderhoudbare en herbruikbare codebase. De voornaamste kandidaten zijn Facade, Factory, Adapter, State en Strategy. Elk van deze patronen biedt unieke voordelen en is geschikt voor specifieke scenario’s.

#### Considered options

| Criteria          | Facade | Factory | Adapter | State | Strategy |
|:------------------|:------:|:-------:|:-------:|:-----:|:--------:|
| Eenvoud           |   ++   |    0    |   ++    |  --   |    --    |
| Onderhoudbaarheid |   ++   |    +    |    0    |  --   |    +     |
| Herbruikbaarheid  |   0    |    +    |   ++    |   +   |    +     |
| Flexibiliteit     |   ++   |    0    |    +    |  --   |    +     |

#### Decision

We hebben gekozen voor het Adapter pattern, het is een makkelijk patroon wat ook een goede herbruikbaarheid biedt met
onze bestaande code.
Het stelt ons in staat om nieuwe componenten eenvoudig te integreren zonder grote wijzigingen aan de bestaande
architectuur.

#### Consequences

Het adapter-pattern verhoogt de herbruikbaarheid van de broncode, daarnaast maakt het de integratie van nieuwe componenten eenvoudiger zonder ingrijpende wijzigingen aan de bestaande architectuur.


## 9. Deployment, Operation and Support

### Download maven

Download maven via hun [website](https://maven.apache.org/download.cgi)

### Mvn

Start de terminal of command line op in de folder waar de pom.xml in staat en run de commando `mvn install`

Na het installen van de dependencies run het commando `mvn spring-boot:run`

Nu start de spring boot applicatie op. De applicatie luistert naar port 9898. 

[Hier zijn de beschikbare requests die je kan maken](Requests.md)
