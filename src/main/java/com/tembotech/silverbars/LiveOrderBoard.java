package com.tembotech.silverbars;

import com.tembotech.silverbars.exception.OrderNotFoundException;
import com.tembotech.silverbars.model.Order;

import java.util.ArrayList;
import java.util.List;

public class LiveOrderBoard {

    private final List<Order> liveOrders = new ArrayList<>();

    public List<Order> getLiveOrders() {
        return liveOrders;
    }

    public int register (Order order) {
        liveOrders.add(order);
        return order.getOrderId();
    }

    public void cancel (int orderId) throws OrderNotFoundException {
        if (!liveOrders.removeIf(o -> o.getOrderId() == orderId)) {
            throw new OrderNotFoundException(orderId);
        }
    }


}
