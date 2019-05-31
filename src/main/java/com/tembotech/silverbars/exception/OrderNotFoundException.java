package com.tembotech.silverbars.exception;

public class OrderNotFoundException extends Exception {
    public OrderNotFoundException(int orderId) {
        super ("No order found with orderId: " +orderId);
    }
}
