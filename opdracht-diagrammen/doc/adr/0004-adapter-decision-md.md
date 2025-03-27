# 4. adapter_decision.md

Date: 2025-03-27

## Status

Proposed

## Context

Bij het ontwerpen van onze softwarearchitectuur hebben we verschillende ontwerppatronen overwogen die kunnen bijdragen aan een flexibele, onderhoudbare en herbruikbare codebase. De voornaamste kandidaten zijn Facade, Factory, Adapter, State en Strategy. Elk van deze patronen biedt unieke voordelen en is geschikt voor specifieke scenario’s.

## Considered options

| Criteria          | Facade | Factory | Adapter | State | Strategy |
|:------------------|:------:|:-------:|:-------:|:-----:|:--------:|
| Eenvoud           |   ++   |    0    |   ++    |  --   |    --    |
| Onderhoudbaarheid |   ++   |    +    |    0    |  --   |    +     |
| Herbruikbaarheid  |   0    |    +    |   ++    |   +   |    +     |
| Flexibiliteit     |   ++   |    0    |    +    |  --   |    +     |

## Decision

We hebben gekozen voor het Adapter pattern, het is een makkelijk patroon wat ook een goede herbruikbaarheid biedt met
onze bestaande code.
Het stelt ons in staat om nieuwe componenten eenvoudig te integreren zonder grote wijzigingen aan de bestaande
architectuur.

## Consequences

Het adapter-pattern verhoogt de herbruikbaarheid van de broncode, daarnaast maakt het de integratie van nieuwe componenten eenvoudiger zonder ingrijpende wijzigingen aan de bestaande architectuur.
