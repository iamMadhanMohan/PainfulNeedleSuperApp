package com.madhan.feature_hotel.ui.screens


import androidx.compose.foundation.layout.*
import androidx.compose.material3.Checkbox
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.madhan.feature_hotel.R
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.madhan.core.ui.components.PrimaryButton
import com.madhan.feature_hotel.ui.widgets.CustomIconButton
import com.madhan.feature_hotel.utils.customColors
import com.madhan.feature_hotel.utils.routes.HOMESCREEN
import com.madhan.feature_hotel.utils.routes.HOTELDETAILSCREEN

@Composable
fun FilterScreen(navController: NavController) {
    Scaffold (modifier = Modifier) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            //header
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                   // .padding(16.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.Top

            ) {
                //Back arrow
                CustomIconButton(
                    icon = painterResource(id = R.drawable.back_arrow),
                    onClick = {navController.navigate(HOMESCREEN)},
                    contentDescription = "back arrow",
                    enabled = true,
                    iconSize = 20.dp,
                )
                //Filter text
                Text("Filter")
                TextButton(onClick = {}) { Text("Clear") }
            }
            //Column
            Column(modifier = Modifier.fillMaxSize()) {
                Row(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    //Price
                    Text("Price")
                    //Divider
                    HorizontalDivider(thickness = 1.dp, color = customColors.descriptionColor)

                }
                //Space
                Spacer(Modifier.height(10.dp))
                Row(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    //Price
                    Text("Price")
                    //Divider
                    HorizontalDivider(thickness = 1.dp, color = customColors.descriptionColor)

                }
                //Ratings

                Spacer(Modifier.height(10.dp))
                //Equipment
                Row(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    //Price
                    Text("Equipment")
                    //Divider
                    HorizontalDivider(thickness = 1.dp, color = customColors.descriptionColor)

                }
                //Item with checkbox
                Row(modifier = Modifier) {
                    Text("Restaurant")
                    Spacer(Modifier.width(10.dp))
                    Checkbox(
                        checked = false,
                        enabled = true,
                        onCheckedChange = {}
                    )
                }

                //Button
                PrimaryButton(
                    modifier = Modifier.align(Alignment.CenterHorizontally),
                    text ="Apply",
                    onClick = {navController.navigate(HOTELDETAILSCREEN)}
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun FilterScreenPreview(){
    val navController = rememberNavController()
    FilterScreen(navController = navController)
}