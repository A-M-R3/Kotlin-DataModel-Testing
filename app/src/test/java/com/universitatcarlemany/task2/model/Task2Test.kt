package com.universitatcarlemany.task2.model

import org.junit.Assert.assertEquals
import org.junit.Assert.assertThrows
import org.junit.Test
import java.time.LocalDate
import java.time.LocalTime

class Task2Test {

    @Test
    fun testUserCreationAndValidation() {
        val user = User("Marc", "Vila", LocalDate.of(1992, 8, 15), "Av. Meritxell 10", "+376612345", "marc.vila@andorra.ad")
        assertEquals("Marc", user.getName())
        
        assertThrows(IllegalArgumentException::class.java) {
            User("", "Vila", LocalDate.of(1992, 8, 15), "Av. Meritxell 10", "+376612345", "marc.vila@andorra.ad")
        }
        
        assertThrows(IllegalArgumentException::class.java) {
            user.setPhone("12345")
        }
    }

    @Test
    fun testMenuAndMenuItemValidation() {
        val item = MenuItem("Trinxat", 14.50, "Plato típico andorrano", "https://cityxerpa.com/trinxat.png", 20)
        assertEquals(20, item.getStock())
        
        assertThrows(IllegalArgumentException::class.java) {
            item.setPrice(15.555)
        }

        assertThrows(IllegalArgumentException::class.java) {
            item.setImageUrl("imagen_sin_http.png")
        }

        val menu = Menu("Contiene gluten y lactosa")
        menu.addItem(item)
        assertEquals(1, menu.getItems().size)
    }

    @Test
    fun testRestaurantTimesValidation() {
        val menu = Menu("Sin alérgenos")
        val restaurant = Restaurant("Burger Xerpa", "Escaldes-Engordany", LocalTime.of(10, 0), LocalTime.of(23, 0), menu)
        
        assertThrows(IllegalArgumentException::class.java) {
            restaurant.setClosingTime(LocalTime.of(9, 0))
        }
    }

    @Test
    fun testOrderLogicAndStockManagement() {
        val user = User("Laura", "Font", LocalDate.of(1998, 3, 10), "Encamp", "345678", "laura@andorra.ad")
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
            order.addItem(MenuItem("Refresco", 2.0, "Cola", "https://url.com", 10))
        }
    }
}