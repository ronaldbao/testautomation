package com.netcracker.solutions.customers.telus.ed.integration.api.service;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;

/**
 * Created by Ronald Bao on 24/03/2019.
 */
public class OrderServiceImplTest {

    OrderService orderService = new OrderServiceImpl();


    @Test
    public void placeOrder() {
        String order = orderService.placeOrder("firstName", "lastName", "refNumber");
        assertNotNull(order);
        assertEquals(order, "order-firstName_lastName_refNumber" );
    }

    @Test
    public void cancelOrder() {
        boolean result = orderService.cancelOrder("refNumber");
        assertEquals(true, result);
    }


}