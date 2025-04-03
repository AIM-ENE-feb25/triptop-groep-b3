## TripTop API Mapping

| Class::Attribuut         | Is input voor API+Endpoint | Wordt gevuld door API+Endpoint | Wordt geleverd door eindgebruiker | Moet worden opgeslagen in de applicatie |
|--------------------------|----------------------------|--------------------------------|-----------------------------------|-----------------------------------------|
| Trip::eindDatum          | Booking /search (POST)     |                                |                                   |                                         |
| Excursie::datum          |                            | TripAdvisor /search            |                                   |                                         |
| Reiziger::telefoonNummer |                            |                                | x                                 | x                                       |