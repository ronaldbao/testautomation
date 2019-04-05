package com.netcracker.solutions.customers.telus.ed.integration.api.service;

/**
 * Created by Ronald Bao on 18/03/2019.
 */
public interface OrderService {
    String placeOrder(String fName, String lName,  String refNumber);
    boolean cancelOrder(String  refNumber);
}
