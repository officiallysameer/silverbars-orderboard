package com.tembotech.silverbars.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

public class Order {

    private String orderId;
    private String userId;
    private BigDecimal orderQuantity;
    private BigDecimal unitPrice;
    private OrderType orderType;
    private LocalDateTime orderExecutiontime;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public BigDecimal getOrderQuantity() {
        return orderQuantity;
    }

    public void setOrderQuantity(BigDecimal orderQuantity) {
        this.orderQuantity = orderQuantity;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
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
        return orderId.equals(order.orderId);
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
