import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.google.android.gms.maps.model.LatLng
import com.madhan.feature_delivery.ui.components.BottomOrangeButton
import com.madhan.feature_delivery.ui.components.CustomBackButton
import com.madhan.feature_delivery.ui.components.MapContent
import com.madhan.feature_delivery.R

@Composable
fun OrderDetailsScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White) // Set background color to white
    ) {
        // Map Section (Top)
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp) // Adjust height as needed
        ) {
            // Google Map Implementation
            // Using markerPosition parameter
            val markerPosition = remember { mutableStateOf<LatLng?>(null) }

            MapContent(markerPosition = markerPosition.value)

            CustomBackButton {
                navController.popBackStack() // Navigate back when clicked
            }
        }


        Column(
            modifier = Modifier
                .fillMaxSize() // Fill the remaining space
                .padding(6.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.delivery_guy), // Replace with your profile picture
                contentDescription = "Profile Picture",
                modifier = Modifier
                    .size(100.dp)
                    .clip(CircleShape)
                    .background(Color.LightGray) // Add a background for better visibility
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "John Jones",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )
            // Details Section
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = "⭐ 4.8", fontSize = 16.sp)
                Text(text = "$ 15/kg", fontSize = 16.sp)
            }

            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Duis lobortis sit amet odio in egestas. Pellentesque ultricies justo.",
                fontSize = 14.sp,
                color = Color.Gray
            )

            Spacer(modifier = Modifier.height(16.dp))
            Row(verticalAlignment = Alignment.CenterVertically) {
                Image(
                    painter = painterResource(id =R.drawable.location), // Replace with your location icon
                    contentDescription = "Location",
                    modifier = Modifier.size(20.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(text = "28 Broad Street, Johannesburg", fontSize = 14.sp)
            }

            Spacer(modifier = Modifier.height(180.dp)) // Push button to bottom

            // Button Section
            BottomOrangeButton("Confirm") {
                // Handle confirm click
                navController.navigate("order_summary")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun OrderDetailsPreview() {
    OrderDetailsScreen(rememberNavController())
}