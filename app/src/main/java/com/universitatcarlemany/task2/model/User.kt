package com.universitatcarlemany.task2.model

import java.time.LocalDate

class User(
    private var name: String,
    private var surname: String,
    private var birthDate: LocalDate,
    private var address: String,
    private var phone: String,
    private var email: String
) {
    private val orders: MutableMap<OrderStatus, MutableList<Order>> = mutableMapOf(
        OrderStatus.IN_PROGRESS to mutableListOf(),
        OrderStatus.PAYED to mutableListOf(),
        OrderStatus.DELIVERED to mutableListOf()
    )

    init {
        validateName(name)
        validateSurname(surname)
        validateAddress(address)
        validatePhone(phone)
        validateEmail(email)
    }

    fun getName(): String = name
    fun setName(newName: String) {
        validateName(newName)
        name = newName
    }

    fun getSurname(): String = surname
    fun setSurname(newSurname: String) {
        validateSurname(newSurname)
        surname = newSurname
    }

    fun getBirthDate(): LocalDate = birthDate
    fun setBirthDate(newBirthDate: LocalDate) {
        birthDate = newBirthDate
    }

    fun getAddress(): String = address
    fun setAddress(newAddress: String) {
        validateAddress(newAddress)
        address = newAddress
    }

    fun getPhone(): String = phone
    fun setPhone(newPhone: String) {
        validatePhone(newPhone)
        phone = newPhone
    }

    fun getEmail(): String = email
    fun setEmail(newEmail: String) {
        validateEmail(newEmail)
        email = newEmail
    }

    fun getOrdersByStatus(status: OrderStatus): List<Order> {
        return orders[status]?.toList() ?: emptyList()
    }

    fun addOrder(order: Order) {
        orders[order.getStatus()]?.add(order)
    }

    fun updateOrderStatus(order: Order, newStatus: OrderStatus) {
        val currentStatus = order.getStatus()
        if (currentStatus != newStatus) {
            orders[currentStatus]?.remove(order)
            order.setStatus(newStatus)
            orders[newStatus]?.add(order)
        }
    }

    private fun validateName(value: String) {
        require(value.isNotBlank())
    }

    private fun validateSurname(value: String) {
        require(value.isNotBlank())
    }

    private fun validateAddress(value: String) {
        require(value.isNotBlank())
    }

    private fun validatePhone(value: String) {
        require(value.matches(Regex("^(?:\\+376)?[3468]\\d{5}$")))
    }

    private fun validateEmail(value: String) {
        require(value.matches(Regex("^[A-Za-z0-9+_.-]+@(.+)$")))
    }
}