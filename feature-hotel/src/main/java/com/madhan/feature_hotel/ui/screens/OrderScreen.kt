package com.madhan.feature_hotel.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.madhan.feature_hotel.R
import com.madhan.feature_hotel.ui.widgets.CustomIconButton
import com.madhan.feature_hotel.ui.widgets.IconTextRow
import com.madhan.feature_hotel.utils.customColors
import com.madhan.feature_hotel.utils.routes.HOMESCREEN

@Composable
fun OrderScreen(navController: NavController) {
    Scaffold (modifier = Modifier.fillMaxSize()) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            Column(
                modifier = Modifier
                    .height(259.dp)
                    .background(customColors.orange)
            ) {
                  //Header
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
                        contentColor = Color.White,
                        iconSize = 20.dp,
                    )
                    //Filter text
                    Text("Order")
                    TextButton(onClick = {}) { Text("Cancel") }
                }

                //Texts
                Column {
                    Text("Hotel")
                    Text("Ressort Hotel")
                }
                Spacer(Modifier.height(20.dp))
                Row(modifier = Modifier.fillMaxWidth()) {
                    Column {
                        Text("Check In")
                        Text("20 March, Thu")
                    }
                    Spacer(Modifier.width(10.dp))
                    //2N Text
                    Text("2N")
                    Spacer(Modifier.width(10.dp))
                    Column {
                        Text("Check Out")
                        Text("22 March, Sat")
                    }
                }
                Spacer(Modifier.height(20.dp))
                //Column
                Column() {
                    Row(modifier = Modifier.fillMaxWidth()) {
                        Column {
                            Text("Room")
                            Text("1")
                        }
                        Spacer(Modifier.width(10.dp))
                        Column {
                            Text("Adults")
                            Text("2")
                        }
                        Spacer(Modifier.width(10.dp))
                        Column {
                            Text("Kids")
                            Text("1")
                        }
                    }
                }
            }
            Spacer(Modifier.height(20.dp))
            Column {
            //Text and image
                Row(modifier = Modifier.fillMaxWidth()) {
                    Text("Junior Suite")
                    Spacer(Modifier.width(10.dp))
                    Image(
                        modifier = Modifier
                            .width(90.dp)
                            .height(40.dp),
                        contentDescription = null,
                        painter = painterResource(id=R.drawable.hotelimg2)
                    )
                }
                Spacer(Modifier.height(15.dp))
                //Row of columns
                Row(modifier = Modifier.fillMaxWidth()) {
                    Column {
                        Text("Standard")
                        TextButton(
                            onClick = {}
                        ) { Text("Remove")}
                    }
                    Spacer(Modifier.width(20.dp))
                    //
                    Column {
                        IconTextRow(
                            icon= painterResource(id=R.drawable.moon),
                            text = "$ 150"
                        )
                        Spacer(Modifier.height(10.dp))
                        Text("X2")
                    }
                }
                //Divider
                HorizontalDivider(thickness = 0.4.dp, color = customColors.descriptionColor)
                Spacer(Modifier.height(20.dp))
                Column {
                    Row(modifier = Modifier) {
                        Text("Subtotal")
                        Spacer(Modifier.width(20.dp))
                        Text("$ 300.00")
                    }
                    Spacer(Modifier.height(15.dp))
                    Row(modifier = Modifier) {
                        Text("Delivery Fees")
                        Spacer(Modifier.width(20.dp))
                        Text("$ 2.50")
                    }
                }
                Spacer(Modifier.height(20.dp))
                Column {
                    Text("Total Amount")
                    Spacer(Modifier.height(15.dp))
                    Text("$ 302.50")
                }

            }


        }
    }
}

@Preview(showBackground = true)
@Composable
fun OrderScreenPreview(){
    OrderScreen(
        navController = rememberNavController()
    )
}