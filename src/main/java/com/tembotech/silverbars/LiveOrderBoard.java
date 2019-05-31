package com.tembotech.silverbars;

import com.tembotech.silverbars.exception.OrderNotFoundException;
import com.tembotech.silverbars.model.Order;
import com.tembotech.silverbars.model.OrderSummary;
import com.tembotech.silverbars.model.OrderType;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

public class LiveOrderBoard {

    private final List<Order> liveOrders = new ArrayList<>();

    public List<Order> getLiveOrders() {
        return liveOrders;
    }

    public int register(Order order) {
        liveOrders.add(order);
        return order.getOrderId();
    }

    public void cancel(int orderId) throws OrderNotFoundException {
        if (!liveOrders.removeIf(o -> o.getOrderId() == orderId)) {
            throw new OrderNotFoundException(orderId);
        }
    }

    public List<OrderSummary> getOrderSummary() {

        Map<OrderType, List<Order>> ordersMap = liveOrders.stream()
                .collect(groupingBy(Order::getOrderType, toList()));

        List<OrderSummary> orderSummaries = new ArrayList<>();


        if (ordersMap.containsKey(OrderType.BUY)) {
            List<OrderSummary> buySummary =
                    ordersMap.get(OrderType.BUY).stream()
                            .collect(groupingBy(Order::getUnitPrice, toList()))
                            .entrySet().stream()
                            .map(o -> new OrderSummary(OrderType.BUY, o.getValue().stream().collect(summingDouble(Order::getOrderQuantity)), o.getKey()))
                            .collect(toList());

            buySummary.sort(new OrderSorter().reversed());
            orderSummaries.addAll(buySummary);

        }

        if (ordersMap.containsKey(OrderType.SELL)) {


            List<OrderSummary> sellSummary = ordersMap.get(OrderType.SELL).stream()
                    .collect(groupingBy(Order::getUnitPrice, toList()))
                    .entrySet().stream()
                    .map(o -> new OrderSummary(OrderType.SELL, o.getValue().stream().collect(summingDouble(Order::getOrderQuantity)), o.getKey()))
                    .collect(toList());

            sellSummary.sort(new OrderSorter());

            orderSummaries.addAll(sellSummary);
        }


        return orderSummaries;
    }

    private Optional<?> getAsOptional(Map<OrderType, ?> map, String key) {
        return Optional.ofNullable(map.get(key));
    }


}
