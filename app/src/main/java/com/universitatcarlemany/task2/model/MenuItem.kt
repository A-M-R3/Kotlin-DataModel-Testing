package com.universitatcarlemany.task2.model

class MenuItem(
    private var name: String,
    private var price: Double,
    private var description: String,
    private var imageUrl: String,
    private var stock: Int
) {
    init {
        validateName(name)
        validatePrice(price)
        validateDescription(description)
        validateImageUrl(imageUrl)
        validateStock(stock)
    }

    fun getName(): String = name
    fun setName(newName: String) {
        validateName(newName)
        name = newName
    }

    fun getPrice(): Double = price
    fun setPrice(newPrice: Double) {
        validatePrice(newPrice)
        price = newPrice
    }

    fun getDescription(): String = description
    fun setDescription(newDescription: String) {
        validateDescription(newDescription)
        description = newDescription
    }

    fun getImageUrl(): String = imageUrl
    fun setImageUrl(newImageUrl: String) {
        validateImageUrl(newImageUrl)
        imageUrl = newImageUrl
    }

    fun getStock(): Int = stock
    fun setStock(newStock: Int) {
        validateStock(newStock)
        stock = newStock
    }

    private fun validateName(value: String) { require(value.isNotBlank()) }
    private fun validatePrice(value: Double) { require(value >= 0.0) }
    private fun validateDescription(value: String) { require(value.isNotBlank()) }
    private fun validateImageUrl(value: String) { require(value.isNotBlank()) }
    private fun validateStock(value: Int) { require(value >= 0) }
}