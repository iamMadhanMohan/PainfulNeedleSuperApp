package com.madhan.feature_uber.Screens.Model

import androidx.compose.ui.graphics.Color
import com.madhan.feature_uber.Screens.ui.PaymentMethod


data class LocationInfo(
    val name: String,
    val address: String,
    val city: String
)

data class RideInfo(
    val driverName: String,
    val driverRating: Double,
    val carModel: String,
    val carColor: String,
    val estimatedTime: Int,
    val estimatedPriceRange: String,
    val pickupLocation: LocationInfo,
    val destinationLocation: LocationInfo
)

data class Driver(
    val id: String,
    val name: String,
    val rating: Double,
    val car: String,
    val carColor: String,
    val estimatedTime: Int,
    val estimatedPriceRange: String,
    val vehicleType: VehicleType
)




data class Location(
    val id: String,
    val name: String,
    val address: String,
    val coordinates: Pair<Double, Double>
)



enum class VehicleType {
    CAR, VAN, MOTORCYCLE
}

// App-wide constants
object AppConstants {
    const val DEFAULT_CITY = "Johannesburg"
    val DEFAULT_LOCATION = Location(
        id = "default",
        name = "Central Johannesburg",
        address = "28 Orchard Road",
        coordinates = Pair(-26.2041, 28.0473)
    )
    val presetLocations = listOf(
        Location(
            "Home", "AdamAbad, 28 Orchard Road",
            address = "Johannesburg, 28 Orchard Road",
            coordinates = Pair(-26.2041, 28.0473)
        ),
        Location(
            "Work", "AdamAbad, 20 Orchard Road",
            address = "AdamAbad, 20 Orchard Road",
            coordinates = Pair(-26.2041, 28.0473)
        ),
        Location(
            "Gym", "AdamAbad, 15 Fitness Road",
            address = "AdamAbad,15 Fitness Road",
            coordinates = Pair(-26.2041, 28.0473)
        ),
        Location(
            "Bar", "AdamAbad, 10 Party Street",
            address = "AdamAbad, 10 Party Street",
            coordinates = Pair(-26.2041, 28.0473)
        )
    )

    val Colors = object {
        val orange = Color(0xFFFF7D1E)
        val lightGray = Color(0xFFF5F5F5)
        val mediumGray = Color(0xFFAAAAAA)
        val darkGray = Color(0xFF9E9E9E)
        val blue = Color(0xFF2196F3)
        val green = Color(0xFF4CAF50)
    }
    val presetPaymentMethods = listOf(
        PaymentMethod.Card(
            cardNumber = "777777777777777777777",
            cardHolderName = "Adam Adamian",
            color = Color(0xFFDAA520),
            id = "1"
        ),
        PaymentMethod.Cash
    )



}