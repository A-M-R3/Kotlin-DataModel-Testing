package com.universitatcarlemany.task2.model

import java.time.LocalDate

enum class OrderStatus {
    IN_PROGRESS,
    PAYED,
    DELIVERED
}

class User(
    private var name: String,
    private var surname: String,
    private var birthDate: LocalDate,
    private var address: String,
    private var phone: String,
    private var email: String
) {
    private val orders: MutableList<Order> = mutableListOf()

    fun getName(): String {
        return name
    }

    fun setName(newName: String) {
        require(newName.isNotBlank())
        name = newName
    }

    fun getOrdersByStatus(status: OrderStatus): List<Order> {
        return orders.filter { it.getStatus() == status }
    }

    fun addOrder(order: Order) {
        orders.add(order)
    }
}