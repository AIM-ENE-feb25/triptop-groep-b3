# 2. Integratie van Identity Providers

Datum: 2025-03-21 

## Status

Proposed

## Context

TripTop moet verschillende identity providers integreren (Google, Microsoft, AirBnB) om gebruikers in te laten loggen zonder een extra account aan te maken. De containerdiagram toont een aparte Login Service die communiceert met externe Identity Provider APIs. We moeten beslissen hoe deze verschillende providers te integreren zodat het systeem niet afhankelijk wordt van één specifieke provider.

## Considered Options

| Criteria | Directe integratie | Adapter Pattern | OAuth middleware |
|----------|-------------------|----------------|------------------|
| Onafhankelijkheid van providers | -- | ++ | + |
| Implementatie-eenvoud | + | - | ++ |
| Gebruikerservaring | + | + | ++ |
| Onderhoudbaarheid | -- | + | ++ |
| Beveiliging | + | + | ++ |

## Decision

Implementeer het OAuth 2.0 protocol met het Adapter Pattern:

1. Centraliseer authenticatie in de Login Service container
2. Creëer een generieke `IdentityProviderInterface`
3. Implementeer concrete adapter-klassen voor elke provider (GoogleAuthAdapter, MicrosoftAuthAdapter, etc.)
4. Voeg een factory toe die de juiste adapter instantieert op basis van gebruikerskeuze

```java
public interface IdentityProviderInterface {
    AuthToken authenticateUser(String authCode);
    UserProfile getUserProfile(AuthToken token);
    boolean validateToken(AuthToken token);
    void revokeAccess(AuthToken token);
}
```

## Consequences

### Positief
- Gebruikers kunnen inloggen met bestaande accounts
- Eenvoudig nieuwe identity providers toevoegen zonder wijzigingen in frontend of backend
- Login Service fungeert als beveiligingslaag tussen externe providers en interne systemen
- Consistente authenticatie-ervaring ongeacht de gekozen provider

### Negatief
- Extra complexiteit door abstractielaag
- Verschillende providers ondersteunen verschillende features
- Synchronisatie van userdata tussen providers vereist extra logica

### Actiepunten
- OAuth 2.0 flow implementeren in Login Service
- Provider adapters ontwikkelen en testen
- Gebruikersinterface in frontend maken voor providerkeuze
- Token-validatie/refreshing mechanisme implementeren 