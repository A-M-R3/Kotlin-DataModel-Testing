package com.universitatcarlemany.task2.model

class Order(
    private var user: User,
    private var status: OrderStatus
) {
    private val items: MutableList<MenuItem> = mutableListOf()
    private var totalCost: Double = 0.0

    fun getUser(): User = user
    fun setUser(newUser: User) {
        user = newUser
    }

    fun getStatus(): OrderStatus = status
    fun setStatus(newStatus: OrderStatus) {
        status = newStatus
    }

    fun getItems(): List<MenuItem> = items

    fun addItem(item: MenuItem) {
        require(status == OrderStatus.IN_PROGRESS)
        require(item.getStock() > 0)
        item.setStock(item.getStock() - 1)
        items.add(item)
        calculateTotalCost()
    }

    fun getTotalCost(): Double = totalCost

    private fun calculateTotalCost() {
        var total = 0.0
        for (item in items) {
            total += item.getPrice()
        }
        totalCost = Math.round(total * 100.0) / 100.0
    }
}