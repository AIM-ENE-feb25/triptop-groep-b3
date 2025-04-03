# API Endpoints

Below are the available endpoints with example curl commands for testing:

### Flights

Search for airports by query:

```bash
curl "http://localhost:9898/api/tripadvisor/flights?query=london"
```

### Hotels

Search for hotels:

```bash
curl "http://localhost:9898/api/tripadvisor/hotels?pageNumber=1&currencyCode=USD&geoId=304554&checkIn=2025-04-22&checkOut=2025-04-24"
```

### Restaurants

Search for restaurants by location ID:

```bash
curl "http://localhost:9898/api/tripadvisor/restaurants?locationId=304554"
```

### Rentals

Search for rentals:

```bash
curl "http://localhost:9898/api/tripadvisor/rentals?sortOrder=POPULARITY&page=1&currencyCode=USD&geoId=304554&arrival=2025-04-22&departure=2025-04-24"
```

### Cruises

Search for cruises by destination ID:

```bash
curl "http://localhost:9898/api/tripadvisor/cruises?destinationId=153339&order=popularity&page=1&currencyCode=USD"
```

### Cars

Search for car rentals:

```bash
curl "http://localhost:9898/api/tripadvisor/cars?order=RECOMMENDED&driverAge=20&page=1&currencyCode=USD&pickUpPlaceId=LHR&pickUpLocationType=AIRPORT&pickUpDate=2025-04-22&dropOffDate=2025-04-24&pickUpTime=12:00&dropOffTime=12:00"
```

### Authentication

Login with username and password:

```bash
curl -X POST "http://localhost:9898/authorisation/login" \
  -H "Content-Type: application/json" \
  -d '{"username":"edevries","password":"3g2Rw9sT1x"}'
```

Check if user is logged in:

```bash
curl "http://localhost:9898/authorisation/logged-in" \
  -H "Cookie: login-token=your-token-here"
```

### Hotel Provider

Get hotels from specific provider:

```bash
curl "http://localhost:9898/hotels?hotelProvider=booking"
```

or 

```bash
curl "http://localhost:9898/hotels?hotelProvider=tripadvisor"
```