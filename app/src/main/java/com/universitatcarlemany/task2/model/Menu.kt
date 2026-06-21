package com.universitatcarlemany.task2.model

class Menu(
    private var allergyInfo: String
) {
    private val items: MutableList<MenuItem> = mutableListOf()

    init {
        validateAllergyInfo(allergyInfo)
    }

    fun getAllergyInfo(): String = allergyInfo
    fun setAllergyInfo(newAllergyInfo: String) {
        validateAllergyInfo(newAllergyInfo)
        allergyInfo = newAllergyInfo
    }

    fun getItems(): List<MenuItem> = items

    fun addItem(item: MenuItem) {
        items.add(item)
    }

    private fun validateAllergyInfo(value: String) {
        require(value.isNotBlank())
    }
}