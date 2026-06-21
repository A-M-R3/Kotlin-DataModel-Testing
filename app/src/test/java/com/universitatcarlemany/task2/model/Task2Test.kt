package com.universitatcarlemany.task2.model

import org.junit.Assert.assertEquals
import org.junit.Assert.assertThrows
import org.junit.Test
import java.time.LocalDate
import java.time.LocalTime

class Task2Test {

    @Test
    fun testUserCreationAndValidation() {
        val user = User("Juan", "Perez", LocalDate.of(1990, 1, 1), "Calle Principal", "+376312345", "juan@correo.com")
        assertEquals("Juan", user.getName())
        
        assertThrows(IllegalArgumentException::class.java) {
            User("", "Perez", LocalDate.of(1990, 1, 1), "Calle Principal", "+376312345", "juan@correo.com")
        }
        
        assertThrows(IllegalArgumentException::class.java) {
            user.setPhone("12345")
        }
    }

    @Test
    fun testMenuAndMenuItemValidation() {
        val item = MenuItem("Pizza", 12.50, "Pizza de queso", "http://imagen.url", 10)
        assertEquals(10, item.getStock())
        
        assertThrows(IllegalArgumentException::class.java) {
            item.setPrice(-5.0)
        }

        val menu = Menu("Contiene gluten y lactosa")
        menu.addItem(item)
        assertEquals(1, menu.getItems().size)
    }

    @Test
    fun testRestaurantTimesValidation() {
        val menu = Menu("Sin alérgenos")
        val restaurant = Restaurant("Local Central", "Plaza Mayor", LocalTime.of(10, 0), LocalTime.of(22, 0), menu)
        
        assertThrows(IllegalArgumentException::class.java) {
            restaurant.setClosingTime(LocalTime.of(9, 0))
        }
    }

    @Test
    fun testOrderLogicAndStockManagement() {
        val user = User("Ana", "Gomez", LocalDate.of(1995, 5, 20), "Avenida Central", "312345", "ana@correo.com")
        val order = Order(user, OrderStatus.IN_PROGRESS)
        val item = MenuItem("Hamburguesa", 10.99, "Carne de res", "http://imagen.url", 5)

        user.addOrder(order)
        order.addItem(item)
        
        assertEquals(4, item.getStock())
        assertEquals(10.99, order.getTotalCost(), 0.01)

        val inProgressOrders = user.getOrdersByStatus(OrderStatus.IN_PROGRESS)
        assertEquals(1, inProgressOrders.size)

        assertThrows(IllegalArgumentException::class.java) {
            order.setStatus(OrderStatus.PAYED)
            order.addItem(MenuItem("Refresco", 2.0, "Cola", "url", 10))
        }
    }
}