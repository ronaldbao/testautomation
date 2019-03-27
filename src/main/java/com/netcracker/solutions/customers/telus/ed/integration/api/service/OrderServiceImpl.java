package com.netcracker.solutions.customers.telus.ed.integration.api.service;

import org.springframework.stereotype.Service;

/**
 * Created by Ronald Bao on 18/03/2019.
 */
@Service
public class OrderServiceImpl implements OrderService{

    private String firstName;
    private String lastName;
    private String referenceName;

    public String placeOrder( String fName,String lName,String refNumber){
        setFirstName(fName);
        setLastName(lName);
        setReferenceName(refNumber);

        return "order-"+getFirstName()+"_"+getLastName()+"_"+ getReferenceName();
    }

    public boolean cancelOrder( String refNumber ){
        return true;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getReferenceName() {
        return referenceName;
    }

    public void setReferenceName(String referenceName) {
        this.referenceName = referenceName;
    }
}
