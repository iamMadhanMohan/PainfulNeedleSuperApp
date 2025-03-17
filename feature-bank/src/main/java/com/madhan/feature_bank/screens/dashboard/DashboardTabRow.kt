package com.madhan.feature_bank.screens.dashboard

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.madhan.adamsuperapp.ui.theme.PrimaryColor
import com.madhan.feature_bank.components.TransactionItem
import com.madhan.feature_bank.data.TransactionsDummyData

@Composable
fun DashboardTabRow() {
    var selectedTab by remember { mutableStateOf(0) }

    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        TabRow(
            selectedTabIndex = selectedTab,
            containerColor = Color.Transparent,
            contentColor = Color.Black,
            indicator = { tabPositions ->

                Box(
                    modifier = Modifier
                        .tabIndicatorOffset(tabPositions[selectedTab])
                        .height(4.dp)
                        .background(PrimaryColor)
                )
            }
        ) {
            Tab(
                selected = selectedTab == 0,
                onClick = { selectedTab = 0 },
                text = { Text("Expenses", fontSize = 16.sp) }
            )
            Tab(
                selected = selectedTab == 1,
                onClick = { selectedTab = 1 },
                text = { Text("Income", fontSize = 16.sp) }
            )
        }

        when (selectedTab) {
            0 -> ExpensesComposable()
            1 -> IncomeComposable()
        }
    }
}

@Composable
fun ExpensesComposable() {
    LazyColumn(
        modifier = Modifier.fillMaxSize()
            .padding(bottom = 32.dp)
    ) {
        item {
            CustomDonutChart()
            Spacer(modifier = Modifier.height(16.dp))
        }

        TransactionsDummyData.transactionsList.forEach { transaction ->
            item {
                Text(
                    text = transaction.date,
                    fontSize = 16.sp,
                    color = Color.Gray,
                    modifier = Modifier.padding(vertical = 8.dp)
                )
                Spacer(modifier = Modifier.height(8.dp))
            }

            items(transaction.transactionsList) { eachTransaction ->
                TransactionItem(eachTransaction)
                Spacer(modifier = Modifier.height(16.dp))
            }
        }
    }
}


@Composable
fun IncomeComposable() {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {
        Text("This is the Income tab", modifier = Modifier.padding(16.dp), fontSize = 18.sp)
    }
}

@Preview(showBackground = true)
@Composable
fun DashboardTabRowPreview(){
    DashboardTabRow()
}