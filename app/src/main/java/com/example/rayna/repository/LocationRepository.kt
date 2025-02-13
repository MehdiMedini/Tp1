package com.example.rayna.repository

import com.rayna.data.model.Location

object LocationRepository {
    fun getLocations(): List<Location> {
        return listOf(
            Location(id = "1", name = "Paris", description = "City of Lights", address = "Paris, France", coordinates = Pair(48.8566, 2.3522), type = "City"),
            Location(id = "2", name = "London", description = "Capital of England", address = "London, UK", coordinates = Pair(51.5074, -0.1278), type = "City"),
            Location(id = "3", name = "New York", description = "The Big Apple", address = "New York, USA", coordinates = Pair(40.7128, -74.0060), type = "City")
        )
    }
}
