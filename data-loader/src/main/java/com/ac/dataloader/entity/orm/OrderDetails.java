package com.ac.dataloader.entity.orm;

import javax.persistence.*;

@Entity(name = "orderdetails")
public class OrderDetails extends ORMObject {

    @GeneratedValue
    @Id
    private int orderDetailId;

    //@ManyToOne
    //@JoinColumn(name = "order_number", nullable = false)
    //private Order order;
    private int quantityOrdered;
    private String productCode;
    private double priceEach;
    private int orderLineNumber;

    public int getOrderDetailId() {
        return orderDetailId;
    }

    public void setOrderDetailId(int orderDetailId) {
        this.orderDetailId = orderDetailId;
    }

    /*public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }*/

    public int getQuantityOrdered() {
        return quantityOrdered;
    }

    public void setQuantityOrdered(int quantityOrdered) {
        this.quantityOrdered = quantityOrdered;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public double getPriceEach() {
        return priceEach;
    }

    public void setPriceEach(double priceEach) {
        this.priceEach = priceEach;
    }

    public int getOrderLineNumber() { return orderLineNumber; }

    public void setOrderLineNumber(int orderLineNumber) {
        this.orderLineNumber = orderLineNumber;
    }
}
