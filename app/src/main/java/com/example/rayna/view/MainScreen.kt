package com.example.rayna.view

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.rayna.viewmodel.LocationViewModel
import com.example.rayna.viewmodel.ProductViewModel
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import com.example.rayna.model.Product
import com.rayna.data.model.Location

@Composable
fun MainScreen(
    productViewModel: ProductViewModel,
    locationViewModel: LocationViewModel,
    modifier: Modifier = Modifier
) {
    val productUiState by productViewModel.productUiState.collectAsState()
    val locationUiState by locationViewModel.locationUiState.collectAsState()

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {


        Text(
            text = "Locations",
            style = MaterialTheme.typography.headlineLarge,
            modifier = Modifier.padding(bottom = 8.dp)
        )
        when {
            locationUiState.isLoading -> {
                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    CircularProgressIndicator()
                }
            }
            locationUiState.error != null -> {
                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    Text(text = "Error: ${locationUiState.error}", color = MaterialTheme.colorScheme.error)
                }
            }
            else -> {
                LazyColumn {
                    items(locationUiState.locations) { location ->
                        LocationCard(location = location)
                        Spacer(modifier = Modifier.height(8.dp))
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Products",
            style = MaterialTheme.typography.headlineLarge,
            modifier = Modifier.padding(bottom = 8.dp)
        )
        when {
            productUiState.isLoading -> {
                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    CircularProgressIndicator()
                }
            }
            productUiState.error != null -> {
                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    Text(text = "Error: ${productUiState.error}", color = MaterialTheme.colorScheme.error)
                }
            }
            else -> {
                LazyColumn {
                    items(productUiState.products) { product ->
                        ProductCard(product = product)
                        Spacer(modifier = Modifier.height(8.dp))
                    }
                }
            }
        }
    }
}

@Composable
fun ProductCard(product: Product) {
    Card(modifier = Modifier.fillMaxWidth()) {
        Column(modifier = Modifier.padding(16.dp)) {
            AsyncImage(
                model = product.pictureUrl,
                contentDescription = product.name,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .clip(MaterialTheme.shapes.medium)
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = product.name, style = MaterialTheme.typography.headlineMedium)
            Text(text = product.description, style = MaterialTheme.typography.bodyLarge)
            Text(text = "$${product.price}", style = MaterialTheme.typography.bodySmall)
        }
    }
}

@Composable
fun LocationCard(location: Location) {
    Card(modifier = Modifier.fillMaxWidth()) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = location.name, style = MaterialTheme.typography.headlineMedium)
            Text(text = location.description, style = MaterialTheme.typography.bodyLarge)
            Text(text = location.address, style = MaterialTheme.typography.bodySmall)
        }
    }
}
