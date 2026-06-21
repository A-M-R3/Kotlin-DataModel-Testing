package com.universitatcarlemany.task2.model

class Restaurant(
    private var id: String,
    private var name: String,
    private var address: String
) {
    private var menu: Menu = Menu()

    fun getName(): String {
        return name
    }

    fun getMenu(): Menu {
        return menu
    }

    fun setMenu(newMenu: Menu) {
        menu = newMenu
    }
}