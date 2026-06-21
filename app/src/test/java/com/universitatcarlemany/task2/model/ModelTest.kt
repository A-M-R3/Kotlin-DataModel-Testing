package com.universitatcarlemany.task2.model

import org.junit.Assert.assertEquals
import org.junit.Test
import java.time.LocalDate

class ModelTest {

    @Test
    fun testUserAddOrder() {
        val user = User("Ana", "Gomez", LocalDate.of(1995, 5, 20), "Avenida Central", "123456", "ana@correo.com")
        val restaurant = Restaurant("R1", "City Pizza", "Centro Comercial")
        val order = Order("O1", restaurant, OrderStatus.IN_PROGRESS)

        user.addOrder(order)
        val inProgressOrders = user.getOrdersByStatus(OrderStatus.IN_PROGRESS)

        assertEquals(1, inProgressOrders.size)
    }

    @Test
    fun testOrderCalculateTotal() {
        val restaurant = Restaurant("R2", "Burger Xerpa", "Plaza Norte")
        val order = Order("O2", restaurant, OrderStatus.PAYED)
        val item1 = MenuItem("I1", "Hamburguesa", "Carne de res", 12.5)
        val item2 = MenuItem("I2", "Refresco", "Cola", 2.5)

        order.addItem(item1)
        order.addItem(item2)

        assertEquals(15.0, order.calculateTotal(), 0.01)
    }

    @Test(expected = IllegalArgumentException::class)
    fun testMenuItemNegativePriceValidation() {
        val item = MenuItem("I3", "Cafe", "Expreso", 1.5)
        item.setPrice(-5.0)
    }
}