package com.pnb.myapplication.ui.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.pnb.myapplication.R
import com.pnb.myapplication.data.product.Product

@Composable
fun ProductList(viewModel: HomeViewModel) {
    val productList by viewModel.productList.observeAsState(emptyList())
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(productList) { product: Product -> ProductView(product, viewModel) }
    }
}

@Composable
fun ProductView(product: Product, viewModel: HomeViewModel) {
    Card(
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        shape = MaterialTheme.shapes.medium,
        colors = CardDefaults.cardColors(MaterialTheme.colorScheme.surfaceVariant),
        modifier = Modifier.padding(start = 16.dp, end = 16.dp, bottom = 4.dp)
    ) {
        Row(
            modifier = Modifier
                .padding(all = 8.dp)
                .fillMaxSize()
        ) {

            Image(
                painter = painterResource(R.drawable.ic_launcher_foreground),
                contentDescription = "product name",
                modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape)
                    .background(color = Color.Green)
            )

            Spacer(modifier = Modifier.width(4.dp))

            Column {
                Text(text = product.name, style = MaterialTheme.typography.titleMedium)
                Text(text = viewModel.formatAmount(product.price))
            }

        }
    }
}