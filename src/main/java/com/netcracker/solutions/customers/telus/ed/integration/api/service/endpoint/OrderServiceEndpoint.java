package com.netcracker.solutions.customers.telus.ed.integration.api.service.endpoint;

import com.netcracker.solutions.customers.telus.ed.integration.api.domain.PlaceOrderRequest;
import com.netcracker.solutions.customers.telus.ed.integration.api.domain.PlaceOrderResponse;
import com.netcracker.solutions.customers.telus.ed.integration.api.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.util.JAXBSource;
import javax.xml.transform.Source;

/**
 * Created by Ronald Bao on 18/03/2019.
 */
@Endpoint
public class OrderServiceEndpoint {

    private final String SERVICE_NS = "http://www.telus.com/b2bapi/OrderService/schema";
    private OrderService orderService;

    @Autowired
    public OrderServiceEndpoint(OrderService orderService) {
        this.orderService = orderService;
    }

    @PayloadRoot(localPart = "placeOrderRequest", namespace = SERVICE_NS)
    public @ResponsePayload
    Source handlePlaceOrderRequest(@RequestPayload Source source) throws Exception {

        PlaceOrderRequest request = (PlaceOrderRequest) unmarshal(source, PlaceOrderRequest.class);
        PlaceOrderResponse response = new PlaceOrderResponse();
        String refNumber=request.getOrder().getRefNumber();
        String fName=request.getOrder().getCustomer().getName().getFName();
        String lName=request.getOrder().getCustomer().getName().getLName();
        response.setRefNumber(orderService.placeOrder(fName,lName,refNumber));
        System.out.println("add some changes 1");
        return marshal(response);

    }

    private Object unmarshal(Source source, Class clazz) throws JAXBException {
        JAXBContext context;
        try {
            context = JAXBContext.newInstance(clazz);
            Unmarshaller um = context.createUnmarshaller();
            return um.unmarshal(source);
        } catch (JAXBException e) {
            e.printStackTrace();
            throw e;
        }
    }

    private Source marshal(Object obj) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(obj.getClass());
        return new JAXBSource(context, obj);
    }


}
