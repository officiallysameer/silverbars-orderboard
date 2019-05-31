package com.tembotech.silverbars.model;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Random;

public class Order {

    private int orderId;
    private String userId;
    private Double orderQuantity;
    private Double unitPrice;
    private OrderType orderType;
    private LocalDateTime orderExecutiontime;
    private Random orderIdGenerator = new Random();

    public Order(String userId, Double orderQuantity, Double unitPrice, OrderType orderType) {
        this.orderId = orderIdGenerator.nextInt(1000);
        this.userId = userId;
        this.orderQuantity = orderQuantity;
        this.unitPrice = unitPrice;
        this.orderType = orderType;
        this.orderExecutiontime = LocalDateTime.now();
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Double getOrderQuantity() {
        return orderQuantity;
    }

    public void setOrderQuantity(Double orderQuantity) {
        this.orderQuantity = orderQuantity;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public OrderType getOrderType() {
        return orderType;
    }

    public void setOrderType(OrderType orderType) {
        this.orderType = orderType;
    }

    public LocalDateTime getOrderExecutiontime() {
        return orderExecutiontime;
    }

    public void setOrderExecutiontime(LocalDateTime orderExecutiontime) {
        this.orderExecutiontime = orderExecutiontime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return orderId == order.orderId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId);
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId='" + orderId + '\'' +
                ", userId='" + userId + '\'' +
                ", orderQuantity=" + orderQuantity +
                ", unitPrice=" + unitPrice +
                ", orderType=" + orderType +
                ", orderExecutiontime=" + orderExecutiontime +
                '}';
    }
}
