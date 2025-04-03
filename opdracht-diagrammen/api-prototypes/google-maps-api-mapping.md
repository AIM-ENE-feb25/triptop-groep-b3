# Google Maps API Mapping Document

## API Overview
The Google Maps API provides access to places, directions, and location services. This document outlines how the API data maps to our TripTop domain model.

## Required API Key
To use the Google Maps API, you need to:
1. Go to https://console.cloud.google.com/
2. Create a new project or select an existing one
3. Enable the following APIs:
   - Places API
   - Directions API
   - Distance Matrix API
4. Create credentials (API key)
5. Replace `YOUR_GOOGLE_MAPS_API_KEY` in the Postman collection

## Domain Model Mapping

| Domain Model Attribute | Google Maps API Endpoint | Input/Output | Notes |
|----------------------|-------------------------|--------------|--------|
| Trip::startLocatie | /directions | Input | Origin location for trip planning |
| Trip::eindLocatie | /directions | Input | Destination location for trip planning |
| Trip::startDatum | /directions | Input | Used for transit mode directions |
| Excursie::locatie | /place/textsearch | Output | Location information for activities |
| Excursie::naam | /place/details | Output | Name of the activity/place |
| Excursie::beschrijving | /place/details | Output | Description from place details |
| Excursie::duur | /distancematrix | Output | Travel time between locations |
| Station::naam | /place/textsearch | Output | Station names from search |
| Station::code | /place/details | Output | Place ID for future reference |

## Missing Data Analysis

### What's missing in our domain model that the API provides:
1. Detailed place information (opening hours, ratings, reviews)
2. Multiple transportation modes (walking, cycling, transit, driving)
3. Real-time traffic information
4. Geocoding capabilities
5. Place photos and media
6. Detailed address components
7. Place types and categories

### What's missing in the API that our domain model needs:
1. Booking capabilities
2. Price information
3. Availability checking
4. User-specific data
5. Historical trip data

## API Response Examples

### Places Search Response
```json
{
  "results": [
    {
      "place_id": "ChIJN1t_tDeuEmsRUsoyG83frY4",
      "name": "Anne Frank House",
      "formatted_address": "Westermarkt 20, 1016 GV Amsterdam, Netherlands",
      "rating": 4.7,
      "user_ratings_total": 123456,
      "geometry": {
        "location": {
          "lat": 52.3752,
          "lng": 4.8840
        }
      },
      "types": ["museum", "tourist_attraction", "point_of_interest"]
    }
  ],
  "status": "OK",
  "next_page_token": "CqQCFQEAA..."
}
```

### Directions Response
```json
{
  "routes": [
    {
      "legs": [
        {
          "distance": {
            "text": "73.4 km",
            "value": 73400
          },
          "duration": {
            "text": "1 hour 12 mins",
            "value": 4320
          },
          "start_address": "Amsterdam, Netherlands",
          "end_address": "Rotterdam, Netherlands",
          "steps": [
            {
              "html_instructions": "Head <b>south</b> on <b>Nieuwezijds Voorburgwal</b>",
              "distance": {
                "text": "0.2 km",
                "value": 200
              },
              "duration": {
                "text": "1 min",
                "value": 60
              }
            }
          ]
        }
      ]
    }
  ],
  "status": "OK"
}
```

## Usage Notes
1. All API calls require a valid API key
2. The API has usage limits and quotas
3. Place IDs are required for detailed information
4. The API supports multiple response formats (JSON, XML)
5. Error handling should be implemented for API failures
6. Rate limiting should be considered in production
7. The API provides rich data that can be used to enhance the user experience
8. Some features require billing to be enabled on the Google Cloud project 