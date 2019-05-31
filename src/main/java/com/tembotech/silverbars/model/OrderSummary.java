package com.tembotech.silverbars.model;

public class OrderSummary {
    private OrderType orderType;
    private Double aggregatedQuantity;
    private Double price;

    public OrderSummary(OrderType orderType, Double aggregatedQuantity, Double unitPrice) {
        this.orderType = orderType;
        this.aggregatedQuantity = aggregatedQuantity;
        this.price = unitPrice;
    }


//    public static OrderSummary from(OrderType orderType, Double aggregatedQuantity Double ){
//        return new OrderSummary(order.getOrderType(), aggregatedQuantity, order.getUnitPrice());
//    }

    public OrderType getOrderType() {
        return orderType;
    }

    public void setOrderType(OrderType orderType) {
        this.orderType = orderType;
    }

    public Double getAggregatedQuantity() {
        return aggregatedQuantity;
    }

    public void setAggregatedQuantity(Double aggregatedQuantity) {
        this.aggregatedQuantity = aggregatedQuantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return  orderType +
                " " + aggregatedQuantity +
                " kg  for £" + price;
    }
}
