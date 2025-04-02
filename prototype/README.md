# TripAdvisor API Prototype

This Spring Boot prototype demonstrates the implementation of the Factory design pattern for handling different types of activities/excursions available through the TripAdvisor API.

## Design Patterns Used

### Factory Pattern

The prototype implements the Factory design pattern to address the following design question:

> **Modularity**: How can we extend the system with new types of activities or excursions without changing existing code?

The Factory pattern allows for creating objects without specifying the exact class of object that will be created. This is done through:

- An `Activity` interface that defines the contract for all activity types
- Concrete implementation classes for each activity type (Flight, Hotel, Restaurant, etc.)
- An `ActivityFactory` class that creates instances of different activity types

This approach enables adding new types of activities by:
1. Creating a new class that implements the `Activity` interface
2. Adding a new creation method in the `ActivityFactory`
3. Creating a new endpoint in the controller

All this can be done without modifying existing code, adhering to the Open/Closed Principle.

## API Endpoints

The prototype exposes the following REST endpoints:

### Flights
```
GET /api/tripadvisor/flights?query={query}
```

### Hotels
```
GET /api/tripadvisor/hotels?pageNumber={pageNumber}&currencyCode={currencyCode}
```

### Restaurants
```
GET /api/tripadvisor/restaurants?locationId={locationId}
```

### Rentals
```
GET /api/tripadvisor/rentals?sortOrder={sortOrder}&page={page}&currencyCode={currencyCode}
```

### Cruises
```
GET /api/tripadvisor/cruises?destinationId={destinationId}&order={order}&page={page}&currencyCode={currencyCode}
```

### Cars
```
GET /api/tripadvisor/cars?order={order}&driverAge={driverAge}&page={page}&currencyCode={currencyCode}
```

## Running the Application

To run the application:

```
./mvnw spring-boot:run
```

## Testing with cURL

Example cURL requests:

### Flights
```bash
curl -X GET "http://localhost:8080/api/tripadvisor/flights?query=london"
```

### Hotels
```bash
curl -X GET "http://localhost:8080/api/tripadvisor/hotels?pageNumber=1&currencyCode=USD"
```

### Restaurants
```bash
curl -X GET "http://localhost:8080/api/tripadvisor/restaurants?locationId=304554"
```

### Rentals
```bash
curl -X GET "http://localhost:8080/api/tripadvisor/rentals?sortOrder=POPULARITY&page=1&currencyCode=USD"
```

### Cruises
```bash
curl -X GET "http://localhost:8080/api/tripadvisor/cruises?destinationId=153339&order=popularity&page=1&currencyCode=USD"
```

### Cars
```bash
curl -X GET "http://localhost:8080/api/tripadvisor/cars?order=RECOMMENDED&driverAge=20&page=1&currencyCode=USD"
``` 