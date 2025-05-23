# Software Guidebook Triptop

## 1. Introduction

Dit software guidebook geeft een overzicht van de Triptop-applicatie. Het bevat een samenvatting van het volgende:

1. De vereisten, beperkingen en principes. 
2. De software-architectuur, met inbegrip van de technologiekeuzes op hoog niveau en de structuur van de software.
3. De ontwerp- en codebeslissingen die zijn genomen om de software te realiseren.
4. De architectuur van de infrastructuur en hoe de software kan worden geïnstalleerd.

## 2. Context
![context-diagram.svg](resources/context-diagram.svg)

Triptop is een webapplicatie die ontworpen is zodat reizigers zelfstandig een vakantie kunnen samenstellen en beheren zonder afhankelijk te zijn van een reisbureau.
De reisagenten ondersteunen de reizigers in dit proces.

### 2.1 Functionaliteit 
De functionaliteiten van Triptop betreffen:
- Het samenstellen van een reis met behulp van bouwstenen.
- Boeken, aanpassen, beheren en annuleren van een reis.
- Kaartweergave met behulp van de Google Maps API.

### 2.2 Gebruikers
- Reizigers: dit is de gebruiker van de Triptop applicatie. De reiziger zal zelf reizen samenstellen en beheren.
- Reisagent: de reisagent ondersteunt (tweedelijns support) de reiziger bij het samenstellen en beheren van een reis.

### 2.3 Externe Systemen
- Booking.com API: boeken van accommodaties.
- Identity Provider API: regelt veilig inloggen voor gebruikers.
- TripAdvisor API: verantwoordelijk voor het ophalen van reviews.
- Google Maps API: haalt informatie over kaarten en locaties op.

[//]: # (Toelichting: In dit contextdiagram zie je hoe de verschillende onderdelen van het TripTop-systeem met elkaar  )

[//]: # (samenwerken. Er zijn twee hoofdgebruikers: de reiziger, die via de webapplicatie zelf reizen samenstelt, boekt of  )

[//]: # (aanpast, en de reisagent, die ondersteuning biedt waar nodig.  )

[//]: # (De TripTop Webapplicatie schakelt met een aantal externe API's. Denk bijvoorbeeld aan het boeken van accommodaties via  )

[//]: # (de Booking.com API, het ophalen van reviews via TripAdvisor en het regelen van login met een Identity Provider API.)

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

### Facade-pattern

Verdere uitleg over dit pattern en de implementatie hiervan is te lezen in [hoofdstuk 7.3 Design & Code](#facade-class-diagram) en verder in [ADR-004](#84-adr-004-identity-provider-data-structuur-past-zich-aan)

### Overige architecturele keuzes zijn:

1. **Open/Closed Principle**: Er kan gemakkelijk een nieuwe externe API call worden toegevoegd, er hoeft geen huidige code voor aangepast te worden.
2. **Dependency Injection**: In `Authorisation` wordt `AuthorisationServiceFacade` via constructor-injectie toegevoegd, wat ervoor zorgt dat dit beter te testen is.

### Adapter-pattern
#### Architecturele keuzes zijn:

1. **Open/Closed Principle**: Er kan gemakkelijk een nieuwe externe API call worden toegevoegd, er hoeft geen huidige  
   code voor aangepast te worden.
2. **Dependency Injection**: In `HotelController` wordt `HotelFactory` via constructor-injectie toegevoegd, wat ervoor  
   zorgt dat dit beter te testen is.

Verdere uitleg over dit pattern en de implementatie hiervan is te lezen in [hoofdstuk 7.3 Design & Code](#adapter-class-diagram) en in [ADR-005 Aanroepen externe API](#85-adr-005-aanroepen-externe-api)

### Factory-pattern 

In dit project is het Factory pattern toegepast bij de TripAdvisor API integratie. Het beantwoordt de vraag: "Hoe kunnen we verschillende soorten activiteiten op een flexibele en uitbreidbare manier aansturen?" Dit pattern is gekozen omdat het de controller-laag ontkoppelt van de concrete implementaties van activiteiten.

Verdere uitleg over de implementatie hiervan is te lezen in [hoofdstuk 7.3 Design & Code](#factory-class-diagram) en de architectuurkeuze wordt onderbouwd in [hoofdstuk 8.3 ADR-003](#83-adr-003-verschillende-activiteitstypes-flexibel-aansturen).

### Overige architecturele keuzes zijn:

1. **Interface-gebaseerd ontwerp**: De `Activity` interface scheidt de implementatie van het gebruik, waardoor verschillende activiteitstypes uniform behandeld worden.

2. **Dependency Injection**: In `TripAdvisorController` worden `TripAdvisorService` en `ActivityFactory` via constructor-injectie toegevoegd, wat betere testbaarheid biedt.

3. **Encapsulatie van API-details**: Elke activiteitsklasse bepaalt zijn eigen endpoint en parameters, zoals te zien in `FlightActivity.getEndpoint()` en `getQueryParams()`.

## 7. Software Architecture

### 7.1. Containers
#### Container diagram

![container-diagram.svg](resources/container-diagram.svg)  
Toelichting: In dit container-diagram zie je de verschillende componenten van het Triptop Systeem en hoe ze met elkaar communiceren. De reiziger en de reisagent gebruiken de frontend om reizen samen te stellen, boeken, aan te passen of te annuleren. De frontend is een gebruikersinterface die communiceert met de backend, het hart van het systeem, via API-verzoeken.  
De backend beheert de reisgegevens en boekingen door verbinding te maken met een SQL-database. Het regelt ook de communicatie met verschillende externe API's: de Booking.com API voor het boeken van verblijfplaatsen, de Google Maps API voor locatie-informatie, de Identity Provider API voor gebruikersauthenticatie en de TripAdvisor API voor het ophalen van reviews van boekingen.

### 7.2. Components
#### Backend component diagram
![component backend diagram](resources/component-backend-diagram.svg)  
Toelichting: In dit diagram is te zien hoe de controllers met de services in het diagram praten. De services halen de data op die de controller nodig hebben, dit wordt gedaan via de API's en de database. Deze data wordt terug gestuurd naar de controller die de data terug verstuurd naar de frontend.

#### Frontend component diagram
![component frontend diagram](resources/component-frontend-diagram.svg)  
Toelichting: In dit diagram is te zien hoe de reiziger en de reisagent met de frontend communiceren. Dit gaat eerst via de app die de routing afhandelt zodat de gebruiker op de juiste pagina beland. Het kaart component praat met de google maps api om de meest recente map data op te halen. Verder praten alle componenten met de API-client behalve het notificatiesysteem. De API-client praat met de backend om hier de data op te halen vanuit alle endpoints. Het notificatiesysteem toont de notificaties op de frontend, zoals een error of success notificatie wanneer een gebruiker een formulier heeft verstuurd. 

#### Dynamic diagram voor hotels ophalen
![dynamic diagram hotels ophalen](resources/dynamic-diagram-hotels-ophalen.svg)  
Toelichting: In dit diagram is te zien hoe het proces van het ophalen van hotels verloopt. De gebruiker vraagt via de frontend  
informatie van een hotel op, waarna deze worden doorgestuurd naar de backend. Vervolgens wordt via een service een  
koppeling gemaakt met de Booking.com API om de juiste hotel gegevens op te vragen en terug te sturen.  
Zodra de juiste gegevens gevonden zijn stuurt de API deze terug via de backend en worden deze zichtbaar op de frontend  
voor de gebruiker.

#### Dynamic diagram voor login
![dynamic diagram login](resources/dynamic-diagram-login.svg)  
Toelichting: In dit diagram is te zien hoe het inlogproces verloopt. Een gebruiker voert via de frontend zijn inloggegevens in,  
waarna deze worden doorgestuurd naar de backend. Daar wordt een koppeling gemaakt met een externe Identity Provider API  
om te controleren of de gegevens kloppen.  
Als de authenticatie succesvol is, stuurt de Identity Provider een bevestiging terug. De backend ontvangt dit signaal en  
stuurt vervolgens een acces token naar de frontend. Daarmee is de login afgerond en is de gebruiker succesvol ingelogd.

### 7.3. Design & Code

#### Adapter class diagram

![adapter class diagram](resources/adapter-class-diagram.svg)  
Toelichting: In dit diagram is te zien hoe de verschillende klassen samenwerken om het adapter pattern toe te passen.

De implementatie bestaat uit:
* Een `HotelApiAdapter` interface.
* Klassen die deze interface implementeren, in dit geval zijn dat de BookingApiAdapter en TripadvisorApiAdapter.
* Er is ook een `HotelFactory` klasse, deze klasse regelt welke adapter er gebruikt moet worden tijdens de aanroep in de controller.
* Verder is er onderaan te zien hoe de twee service klassen, die de aanroep naar de API doen allebei hun eigen methode hebben om dit af te handelen, zo wordt ook duidelijk hoe het adapter-pattern dit probleem wegwerkt door dit via de adapter klassen gelijk te trekken.

#### Facade class diagram

![facade class diagram](resources/facade-class-diagram.svg)

De implementatie bestaat uit:
* Een `AuthorisatieServiceFacade` het object dat alle autorisatie afhandelt.
* Een `IdentityProviderClient` het object dat praat met de identity provider API.
* Als de data die uit de Identity provider API aangepast wordt dan hoeft alleen de `AuthorisatieServiceFacade` aangepast worden. Zo wordt het probleem weggewerkt van: "Hoe zorg je ervoor dat je bij een wijziging in de datastructuur van een externe service niet de hele applicatie hoeft aan te passen?".

#### Factory class diagram

![factory class diagram](resources/factory-class-diagram.svg)

In het klassendiagram is te zien hoe het Factory pattern is toegepast voor het creëren van verschillende soorten activiteiten voor de TripAdvisor API. De `Activity` interface vormt het contract waar alle activiteiten aan moeten voldoen, met methoden zoals `getEndpoint()` en `getQueryParams()`. De `ActivityFactory` is verantwoordelijk voor het instantiëren van de concrete implementaties zoals `HotelActivity` en `CarActivity`.

Voor het toevoegen van een nieuw activiteitstype zijn drie stappen nodig: het type toevoegen aan de `ActivityType` enum, een nieuwe implementatieklasse maken die de `Activity` interface implementeert, en een createXXX methode toevoegen aan de `ActivityFactory`. De sequence diagrammen voor hotel- en autoverhuur-zoekfuncties tonen hoe een verzoek van de gebruiker via de TripTopApp wordt omgezet naar de juiste activiteitsklasse en hoe die vervolgens met de TripAdvisorAPI communiceert.

#### Login sequence diagram
![login sequence diagram](resources/login-sequence-diagram.svg)

Toelichting: In het eerste deel van dit diagram wordt er ingelogd via een POST request gemaakt naar `/authorisatie/login` met de json gegevens voor het inloggen. Hierna wordt de `login` functie binnen de service aangeroepen. De service roept de client aan en deze maakt een UniRest post request naar de API, het resultaat hiervan wordt terug gestuurd en opgeslagen in de database. Hierna wordt een OK teruggestuurd naar de reiziger met een cookie waar de login token in staat die de gebruiker op moet slaan.

In het tweede deel van dit diagram wordt er gecheckt of de gebruiker is ingelogd via een GET request naar `/authorisatie/logged-in` met de cookie waar de login token in staat. Hierna wordt de `isLoggedin` functie binnen de service aangeroepen. De gebruikersnaam wordt opgehaald met behulp van de login token. De service roept de client aan en deze maakt een UniRest post request naar de API. Vervolgens wordt via de service gecheckt of de gebruiker daadwerkelijk is ingelogd op basis van wat de client terug stuurt, hierna wordt er een true of false bevestiging terug gestuurd naar de client.

#### Car rental search sequence diagram
![car rental search sequence diagram](resources/car-rental-search-sequence-diagram.svg)

Toelichting: In dit diagram wordt het proces getoond voor het zoeken naar huurauto's. De gebruiker geeft zoekcriteria in zoals ophaallocatie en datums. De TripTopApp maakt een CarActivity object aan met deze gegevens en stuurt dit naar de TripAdvisorService. Deze service vraagt de juiste endpoint en parameters op bij het CarActivity object, bouwt een URI en stuurt een HTTP request naar de TripAdvisor API. De resultaten worden teruggestuurd naar de gebruiker via de app.

#### Hotel search sequence diagram
![hotel search sequence diagram](resources/hotel-search-sequence-diagram.svg)

Toelichting: In dit diagram is te zien hoe hotelzoekopdrachten worden afgehandeld. De gebruiker voert locatie- en datumgegevens in, waarna de TripTopApp een HotelActivity object aanmaakt. Dit object wordt doorgegeven aan de TripAdvisorService die de benodigde API-parameters opvraagt. Vervolgens stuurt de service een request naar de TripAdvisor API en worden de resultaten teruggegeven aan de gebruiker.

## 8. Architectural Decision Records

### 8.1. ADR-001 Google Maps API Toegang

Datum: 2025-03-21

#### Status

Accepted

#### Context

De TripTop applicatie heeft Google Maps functionaliteit nodig voor het weergeven van locaties, routes en interactieve kaarten. We moesten beslissen of de Google Maps API rechtstreeks vanaf de frontend of via de backend zou worden benaderd.

#### Considered Options

| Criteria                  | Backend | Frontend | Hybride |
|---------------------------|---------|----------|---------|
| Beveiliging               | ++      | -        | 0       |
| Gebruikerservaring        | --      | ++       | +       |
| Serverbelasting           | --      | ++       | -       |
| Implementatiecomplexiteit | -       | ++       | --      |
| Caching mogelijkheden     | ++      | -        | +       |
| Onderhoudbaarheid         | 0       | 0        | -       |
| Responsetijd              | --      | ++       | -       |

#### Decision

Na zorgvuldige afweging hebben we gekozen om de Google Maps API rechtstreeks vanuit de frontend te benaderen. Deze keuze is primair gebaseerd op de aanzienlijk betere gebruikerservaring, lagere serverbelasting (geen backend-implementatie) en eenvoudigere implementatie. De Google Maps JavaScript API is speciaal ontworpen voor naadloze integratie in webapplicaties, met snelle laadtijden en soepele interacties zoals zoomen en pannen.

Hoewel een backend-implementatie voordelen zou bieden voor API-sleutelbescherming en caching, wegen deze niet op tegen de voordelen van de frontend-benadering. We mitigeren de beveiligingsrisico's door domeinrestricties toe te passen op onze API-sleutels.

#### Consequences

##### Positief

De gebruikerservaring is aanzienlijk beter met de frontend-implementatie. Kaarten laden sneller en reageren direct op gebruikersinteracties zonder vertragingen. De serverbelasting blijft minimaal omdat alle kaartgerelateerde verwerkingen rechtstreeks plaatsvinden tussen de browser van de gebruiker en de Google servers. De implementatie is eenvoudiger en vereist minder code, wat resulteert in lagere ontwikkelingskosten en betere onderhoudbaarheid.

##### Negatief

De API-sleutel is zichtbaar in de frontend code, wat een beveiligingsrisico vormt als er geen juiste domeinrestricties zijn ingesteld. We hebben dit risico beperkt door strikte herkomst- en referrer-beperkingen te configureren in het Google Cloud Console.

We hebben beperkte mogelijkheden voor caching of voor het toevoegen van eigen logica aan de kaartfunctionaliteit. Voor geavanceerde functionaliteit kan in de toekomst alsnog een aanvullende backend-component nodig zijn.

##### Actiepunten

We implementeren de Google Maps JavaScript API in onze frontend React-componenten met de juiste domeinrestricties voor de API-sleutel. We documenteren het gebruik van de API om toekomstige ontwikkelaars te helpen.

### 8.2. ADR-002 Integratie van Identity Providers

Datum: 2025-03-21

#### Status

Proposed

#### Context

TripTop wil een identity provider integreren om gebruikers in te laten loggen. Hiervoor komt een aparte Login Service die communiceert met externe
Identity Provider API's. Binnen deze adr willen we uitzoeken met welke pattern dit het beste gedaan kan worden.

#### Considered Options

| Criteria                        | Directe integratie | Adapter Pattern | Facade pattern |
|---------------------------------|--------------------|-----------------|----------------|
| Onafhankelijkheid van providers | --                 | ++              | +              |
| Implementatie-eenvoud           | +                  | -               | ++             |
| Onderhoudbaarheid               | --                 | +               | ++             |
| Beveiliging                     | +                  | +               | ++             |

#### Decision

Na zorgvuldige afweging hebben we gekozen voor een elegante oplossing met het facade-pattern.
We centraliseren alle authenticatie in een facade. 

Het hart van deze oplossing is onze `AuthorisationServiceFacade`, die alle essentiële authenticatiefuncties definieert.

#### Consequences

##### Positief

De Login Service fungeert als beveiligingslaag en zorgt voor een consistente authenticatie-ervaring.

##### Negatief

De abstractielaag voegt complexiteit toe.

##### Actiepunten

We creëren de `AuthorisatieServiceFacade` binnen de applicatie. We maken een login systeem op de frontend die communiceert met de backend via verschillende endpoints. Hierbij moet ingelogd kunnen worden en gecheckt worden of iemand is ingelogd of niet.

### 8.3. ADR-003 Verschillende activiteitstypes flexibel aansturen

Datum: 2025-03-27
#### Status

Proposed

#### Context

Deze ADR beschrijft de keuze voor een design pattern dat specifiek gebruikt wordt bij de TripAdvisor API integratie gerelateerd aan het afhandelen van verschillende activiteitstypes.

Bij het integreren van de TripAdvisor API in onze applicatie, stuitten we op de vraag: "Hoe kunnen we verschillende soorten activiteiten op een flexibele en uitbreidbare manier aansturen?" We zochten een oplossing die het toevoegen van nieuwe activiteitstypes mogelijk zou maken zonder bestaande code aan te passen.

#### Considered options

| Criteria              | State | Strategy | Adapter | Facade | Factory Method |
|:----------------------|:-----:|:--------:|:-------:|:------:|:--------------:|
| Flexibiliteit         |   +   |    ++    |    +    |   -    |       ++       |
| Ontkoppeling          |   +   |    +     |   ++    |   -    |       ++       |
| Uitbreidbaarheid      |   +   |    +     |    +    |   -    |       ++       |
| Eenvoud implementatie |   -   |    +     |    -    |   ++   |       +        |
| Toekomstbestendigheid |   +   |    +     |    +    |   -    |       ++       |

#### Decision

Na zorgvuldige afweging hebben we specifiek voor de TripAdvisor activiteiten-integratie gekozen voor het Factory Method Pattern. Dit pattern biedt voor deze specifieke use case de beste combinatie van flexibiliteit, ontkoppeling en uitbreidbaarheid. Door een centraal punt te creëren waar activiteitsobjecten worden aangemaakt via de `ActivityFactory`, kunnen controllers op een uniforme manier met verschillende activiteitstypes werken zonder afhankelijk te zijn van de specifieke implementaties.

#### Consequences

Het Factory Method Pattern zorgt voor een duidelijke scheiding tussen creatie en gebruik van activiteitsobjecten. Het systeem wordt ook beter testbaar doordat we eenvoudiger mock-implementaties kunnen injecteren tijdens het testen.

Het patroon vereist wel meer initiële ontwikkeltijd door de extra abstractielaag. Hiervoor moeten de `Activity` interface, concrete implementatieklassen en de `ActivityFactory` worden opgesteld. Deze complexiteit is vooral bij aanvang van het project merkbaar, maar verdient zich terug naarmate het aantal activiteitstypes groeit.

##### Actiepunten

We implementeren de `Activity` interface als contract voor alle activiteitstypes, ontwikkelen concrete implementaties zoals `HotelActivity` en `CarActivity`, en creëren een `ActivityFactory` met aparte methoden voor elk type. Voor de uitbreiding met nieuwe activiteitstypes documenteren we het proces waarbij het type wordt toegevoegd aan de enum, een nieuwe implementatieklasse wordt gemaakt en een factory-methode wordt toegevoegd.

### 8.4. ADR-004 Identity provider data structuur past zich aan

Date: 2025-03-27

#### Status

Proposed

#### Context

Bij het ontwerpen van onze softwarearchitectuur staan we voor de keuze tussen verschillende design patterns. Hiermee moet de ontwerpvraag: "Hoe zorg je ervoor dat je bij een wijziging in de datastructuur van een externe service niet de hele applicatie hoeft aan te passen?" afgevangen worden. Zodat als dit gebeurt niet de hele codebase herschreven moet worden.

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
subsysteem functionaliteit, wat de code overzichtelijker maakt en de afhankelijkheden vermindert. Dit is zodat de code, maar op 1 plek aangepast moet worden als de datastructuur van de api aangepast wordt

#### Consequences

##### Positief

Het Facade-patroon maakt de interactie met complexe subsystemen eenvoudiger. Dit verlaagt de afhankelijkheid tussen
componenten. Daardoor is de code binnen de facade onafhankelijk van de code buiten de facade, als de api zich aanpast, zal de returnwaarde van de functie niet aangepast hoeven te worden.

##### Negatief

Het Facade-patroon voegt een extra abstractielaag toe. Dit kan in sommige gevallen overbodig zijn. Wijzigingen in het
subsysteem kunnen alsnog doorwerken in de facade. Hierdoor blijft het voordeel van isolatie beperkt. Ook kan deze
interface als een soort God interface worden gebruikt die door elke klasse binnen het systeem wordt gebruikt.

##### Actiepunten

We maken een klasse die alle authenticatie met de api afhandelt deze moet geïnjecteerd worden door controllers of andere services. Hiernaast komt er ook nog een client die met de api praat.

### 8.5. ADR-005 Aanroepen externe API

Date: 2025-03-27

#### Status

Proposed

#### Context

In deze ADR wordt een ontwerpbeslissing onderbouwd die voortkomt uit de vraag: "Wie roept een specifieke externe service aan, gebeurt dat vanuit de front-end of vanuit de back-end? Welke redenen zijn er om voor de ene of de andere aanpak te kiezen?"
Bij het ontwerpen van onze softwarearchitectuur hebben we verschillende ontwerppatronen overwogen die kunnen bijdragen aan een flexibele, onderhoudbare en herbruikbare codebase. De voornaamste kandidaten zijn Facade, Factory, Adapter, State en Strategy. 
Elk van deze patronen biedt unieke voordelen en is geschikt voor specifieke scenario's.
We bekijken de voor- en nadelen van beide benaderingen en leggen uit hoe het gekozen ontwerppatroon hierbij helpt.


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
Het zorgt voor modulariteit en makkelijke uitbreidbaarheid indien er later soortgelijke API's toegevoegd worden zonder grote wijzigingen aan de bestaande
architectuur te hoeven maken.

#### Consequences

Het adapter-pattern verhoogt de herbruikbaarheid van de broncode, daarnaast maakt het de integratie van nieuwe componenten eenvoudiger zonder ingrijpende wijzigingen aan de bestaande architectuur.

## 9. Deployment, Operation and Support

### Download Maven

Download maven via hun [website](https://maven.apache.org/download.cgi)

### Kloon het project

Creëer een nieuwe folder en run hierin het commando `git clone https://github.com/AIM-ENE-feb25/triptop-groep-b3.git`  
Open vervolgens het project in je favoriete IDE (Intellij aanbevolen)

### Run de applicatie

Start de terminal of command line op in de folder waar de pom.xml in staat `/prototype` en run het commando `mvn install`

Na het installeren van de dependencies run je het commando `mvn spring-boot:run`

Nu start de spring boot applicatie op. De applicatie luistert naar port 9898. 

Nu kun je de requests maken, dit kan via postman of curl, hieronder een lijst met de mogelijkheden, als er niks specifieks bij staat (post) dan gaat het om een GET-request.  

[Klik hier om de lijst met requests te bekijken](Requests.md)
