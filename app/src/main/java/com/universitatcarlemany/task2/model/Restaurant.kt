package com.universitatcarlemany.task2.model

import java.time.LocalTime

class Restaurant(
    private var name: String,
    private var address: String,
    private var openingTime: LocalTime,
    private var closingTime: LocalTime,
    private var menu: Menu
) {
    init {
        validateName(name)
        validateAddress(address)
        validateTimes(openingTime, closingTime)
    }

    fun getName(): String = name
    fun setName(newName: String) {
        validateName(newName)
        name = newName
    }

    fun getAddress(): String = address
    fun setAddress(newAddress: String) {
        validateAddress(newAddress)
        address = newAddress
    }

    fun getOpeningTime(): LocalTime = openingTime
    fun setOpeningTime(newOpeningTime: LocalTime) {
        validateTimes(newOpeningTime, closingTime)
        openingTime = newOpeningTime
    }

    fun getClosingTime(): LocalTime = closingTime
    fun setClosingTime(newClosingTime: LocalTime) {
        validateTimes(openingTime, newClosingTime)
        closingTime = newClosingTime
    }

    fun getMenu(): Menu = menu
    fun setMenu(newMenu: Menu) {
        menu = newMenu
    }

    private fun validateName(value: String) { require(value.isNotBlank()) }
    private fun validateAddress(value: String) { require(value.isNotBlank()) }
    private fun validateTimes(open: LocalTime, close: LocalTime) {
        require(open.isBefore(close))
    }
}