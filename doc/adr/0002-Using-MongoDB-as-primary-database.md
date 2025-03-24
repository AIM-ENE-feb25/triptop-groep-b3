# 2. Tripadvisor

Date: 2025-03-20

## Status

Accepted

## Context

Our application requires a reliable, no-sql database. We are consindering MongoDB vs. PostgreSQL.

## Decision

We will use MongoDB for our database of choice because of scalability and fast read/write performance.

## Consequences

#### Pros:

Easy to implement.

#### Cons:

More complex query optimization compared to relational databases.