package com.netcracker.solutions.customers.telus.ed.integration.api.service;

import org.springframework.stereotype.Service;

/**
 * Created by Ronald Bao on 18/03/2019.
 */
@Service
public class OrderServiceImpl implements OrderService{

    public String placeOrder( String fName,String lName,String refNumber){
        return "order-"+fName+"_"+lName+"_"+refNumber;
    }

    public boolean cancelOrder( String refNumber ){
        return true;
    }

}
