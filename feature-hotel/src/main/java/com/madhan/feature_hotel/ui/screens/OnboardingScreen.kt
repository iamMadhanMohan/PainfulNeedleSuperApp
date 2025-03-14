package com.madhan.feature_hotel.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.madhan.feature_hotel.R

@Composable
fun OnboardingScreen(paddingValues: PaddingValues) {

    //Custom Colors
    val orange = Color(0xFFFF7A1A)
    val hotelTextColor = Color(0xFF171D33)
    val descriptionColor = Color(0xFFA6AAB4)

    Column(
        modifier = Modifier.fillMaxSize().padding(paddingValues),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Top
    ) {
        //The back button
          IconButton(
              onClick = {},
              enabled = true,
              colors = IconButtonColors(
                  containerColor =  Color.Transparent,
                  contentColor = orange,
                  disabledContainerColor = Color.Transparent,
                  disabledContentColor = Color.Gray
              )
          ) {
             Icon(
                 modifier = Modifier.size(24.dp),
                 painter = painterResource(R.drawable.back_arrow),
                 contentDescription = "back arrow"
             )
          }
        //Vector image
        Image(
            painter = painterResource(R.drawable.woman),
            contentDescription = "onboarding image",
//            contentScale = ContentScale.Fit,
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(1f)
        )
        Spacer(modifier = Modifier.height(30.dp))
        //Hotel Text
        Text(
            modifier = Modifier.fillMaxWidth(),
            text="Hotel",
            style = TextStyle(
             fontSize = 32.sp,
                textAlign = TextAlign.Center,
             fontWeight = FontWeight.SemiBold,
                color = hotelTextColor
            )
        )
        Spacer(modifier = Modifier.height(20.dp))
        //Description
        Text(
            modifier = Modifier.fillMaxWidth().padding(horizontal = 10.dp),
            text="Lorem ipsum dolor sit amet, consectetur adipiscing elit.Duis lobortis sit amet odio in egestas. Pellen tesque ultricies justo.",
            softWrap = true,
            style = TextStyle(
                fontSize = 16.sp,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Medium,
                color = descriptionColor,

            )
        )
        Spacer(modifier = Modifier.height(60.dp))
        //Button
        Button(
            onClick = {},
            enabled = true,
            colors = ButtonDefaults.buttonColors(orange),
            shape = RoundedCornerShape(10.dp),
            modifier = Modifier
                .width(257.dp)
                .height(56.dp)
                .align(Alignment.CenterHorizontally)
        ) {
            Text(
                "Let' go",
                style = TextStyle(
                    fontSize = 16.sp,
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.SemiBold,
                    )
            )
        }

    }
}