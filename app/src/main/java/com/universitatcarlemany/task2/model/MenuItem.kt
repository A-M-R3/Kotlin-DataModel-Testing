package com.universitatcarlemany.task2.model

class MenuItem(
    private var id: String,
    private var name: String,
    private var description: String,
    private var price: Double
) {
    fun getId(): String {
        return id
    }

    fun getName(): String {
        return name
    }

    fun getPrice(): Double {
        return price
    }

    fun setPrice(newPrice: Double) {
        require(newPrice >= 0.0)
        price = newPrice
    }
}