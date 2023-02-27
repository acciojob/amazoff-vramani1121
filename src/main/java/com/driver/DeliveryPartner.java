package com.driver;

public class DeliveryPartner {

    private String id;
    private int numberOfOrders;

    public DeliveryPartner(){}
    public DeliveryPartner(String id) {
        this.id = id;
        this.numberOfOrders = 0;
    }

    public String getId() {
        return id;
    }

    public Integer getNumberOfOrders(int size){
        return numberOfOrders;
    }

    public void setNumberOfOrders(Integer numberOfOrders) {
        this.numberOfOrders = numberOfOrders;
    }
}