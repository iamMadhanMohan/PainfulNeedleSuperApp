package com.madhan.feature_uber.Screens.vm



import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import com.madhan.feature_uber.Screens.Model.Driver
import com.madhan.feature_uber.Screens.Model.Location
import com.madhan.feature_uber.Screens.Model.RideInfo
import com.madhan.feature_uber.Screens.Model.VehicleType
import com.madhan.feature_uber.Screens.ui.PaymentMethod


class SharedViewModel : ViewModel() {
    // Selected Ride Information
    var selectedDriver by mutableStateOf<Driver?>(null)
    var selectedPaymentMethod by mutableStateOf<PaymentMethod?>(null)
    var selectedDateTime by mutableStateOf<Pair<Long, Long>?>(null)
    var pickupLocation by mutableStateOf<Location?>(null)
    var destinationLocation by mutableStateOf<Location?>(null)
    var rideInfo by mutableStateOf<RideInfo?>(null)
    var selectedTip by mutableStateOf(0.0)
    val ridePrice: Double
        get() = selectedDriver?.estimatedPriceRange
            ?.replace("[^\\d.]".toRegex(), "")
            ?.toDoubleOrNull() ?: 0.0







    // Available Data
    val drivers = listOf(
        Driver(
            id = "1",
            name = " Simon Aker",
            rating = 4.8,
            car = "Ford Mustang",
            carColor = "Red",
            estimatedTime = 3,
            estimatedPriceRange = "$5",
            vehicleType = VehicleType.CAR
        ),

        Driver(
            id = "2",
            name = "Sina F.",
            rating = 4.8,
            car = "Batmobile",
            carColor = "Red",
            estimatedTime = 3,
            estimatedPriceRange = "$100",
            vehicleType = VehicleType.CAR
        ),

        Driver(
            id = "3",
            name = "Adam M.",
            rating = 4.8,
            car = "Jeep Wrangler",
            carColor = "Yellow",
            estimatedTime = 7,
            estimatedPriceRange = "$13",
            vehicleType = VehicleType.CAR
        ),

        Driver(
            id = "4",
            name = "Riya D.",
            rating = 2.0,
            car = "Jeep Cherokee",
            carColor = "Pink",
            estimatedTime = 10,
            estimatedPriceRange = "12",
            vehicleType = VehicleType.CAR
        ),
        Driver(
            id = "5",
            name = "Madhan",
            rating = 4.0,
            car = "Lincoln Navigator",
            carColor = "Balck",
            estimatedTime = 9,
            estimatedPriceRange = "$19",
            vehicleType = VehicleType.CAR
        ),

        Driver(
            id = "6",
            name = "Anirudhe",
            rating = 4.0,
            car = "Lincoln Navigator",
            carColor = "Balck",
            estimatedTime = 9,
            estimatedPriceRange = "$21",
            vehicleType = VehicleType.CAR
        ),


        Driver(
            id = "7",
            name = "Adam",
            rating = 4.0,
            car = "Airbus A380",
            carColor = "Balck",
            estimatedTime = 9,
            estimatedPriceRange = "$19",
            vehicleType = VehicleType.VAN
        ),

        Driver(
            id = "8",
            name = "Adam",
            rating = 4.0,
            car = "Honda Rebel",
            carColor = "Balck",
            estimatedTime = 9,
            estimatedPriceRange = "$19",
            vehicleType = VehicleType.MOTORCYCLE
        )







    )

    val paymentMethods = listOf(
        PaymentMethod.Card(
            id = "1",
            cardNumber = "777777777777777777777",
            cardHolderName = "Adam Adamian",
            color = Color(0xFFDAA520)
        ),
        PaymentMethod.Cash
    )

    val presetLocations = listOf(
        Location(
            id = "home",
            name = "Home",
            address = "28 Orchard Road",
            coordinates = Pair(-26.2041, 28.0473)
        ),
        Location(
            id = "work",
            name = "Work",
            address = "28 Broad Street",
            coordinates = Pair(-26.2041, 28.0573)
        ),
        // Add other locations...
    )

    // Ride History
    val rideHistory = mutableListOf<RideInfo>()

    // User Balance
    var userBalance by mutableStateOf(5523.26)

    // Functions
    fun selectDriver(driver: Driver) {
        selectedDriver = driver
    }

    fun setLocations(pickup: Location, destination: Location) {
        pickupLocation = pickup
        destinationLocation = destination
    }

    fun completePayment(amount: Double) {
        userBalance -= amount
    }
}