package com.example.rayna.repository

import com.example.rayna.R
import com.example.rayna.model.Product

object ProductRepository {

    private val productList = listOf(
        Product(
            id = "1",
            name = "iPhone 16 Pro max",
            cat ="Product",
            description = "The latest iPhone with the new A18 Pro chip, titanium design, and 48MP camera.",
            price = 1999.0,
            rating = 4.0,
            pictureUrl = R.drawable.iphone16        ),
        Product(
            id = "2",
            name = "El Mordjene Chocolate",
            cat ="Product",
            description = "El Mordjene is an Algerian roasted hazelnut cream spread..",
            price = 600.0,
            rating = 4.5,
            pictureUrl = R.drawable.mordjene     ),
        Product(
            id = "3",
            name = "Apple Watch Ultra 2",
            cat ="Product",
            description = "The ultimate sports and adventure watch",
            price = 799.0,
            rating = 3.6,
            pictureUrl = R.drawable.applewatch      ),
        Product(
            id = "4",
            name = "Samsung Galaxy Ultra 24",
            cat ="Product",
            description = "the latest and the best that samsung has to offer",
            price = 1299.0,
            rating = 4.0,
            pictureUrl = R.drawable.samsung   ),
        Product(
            id = "5",
            name = "SuperMarket Ben Sassi",
            cat = "Shop",
            description = "the most well-known SuperMarket in ELoued.",
            price = 0.0,
            rating = 4.0,
            pictureUrl = R.drawable.supermarket),
        Product(
            id = "6",
            name = "Galaxy Food",
            cat = "Shop",
            description = "One of the best Fast Food in Guemar",
            price = 0.0,
            rating = 4.0,
            pictureUrl = R.drawable.fastfood),
        Product(
            id = "7",
            name = "Makam Tech",
            cat = "Service",
            description = "Expert repair services for all major Electronics.",
            price = 0.0,
            rating = 4.7,
            pictureUrl = R.drawable.makam),
        Product(
            id = "8",
            name = "Oil Change Shop",
            cat = "Service",
            description = "for fast and reliable oil change.",
            price = 0.0,
            rating = 4.8,
            pictureUrl = R.drawable.oil),
    )

    fun getAllProducts(): List<Product> {
        return productList
    }
}
