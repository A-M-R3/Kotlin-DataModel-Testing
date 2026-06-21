package com.universitatcarlemany.task2.model

class Order(
    private var id: String,
    private var restaurant: Restaurant,
    private var status: OrderStatus
) {
    private val items: MutableList<MenuItem> = mutableListOf()

    fun getStatus(): OrderStatus {
        return status
    }

    fun setStatus(newStatus: OrderStatus) {
        status = newStatus
    }

    fun addItem(item: MenuItem) {
        items.add(item)
    }

    fun getItems(): List<MenuItem> {
        return items
    }

    fun calculateTotal(): Double {
        var total = 0.0
        for (item in items) {
            total += item.getPrice()
        }
        return total
    }
}