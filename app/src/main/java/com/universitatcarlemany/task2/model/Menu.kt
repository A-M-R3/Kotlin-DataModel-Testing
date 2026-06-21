package com.universitatcarlemany.task2.model

class Menu {
    private val items: MutableList<MenuItem> = mutableListOf()

    fun getItems(): List<MenuItem> {
        return items
    }

    fun addItem(item: MenuItem) {
        items.add(item)
    }
}