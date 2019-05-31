package com.tembotech.silverbars;

import com.tembotech.silverbars.model.OrderSummary;

import java.util.Comparator;

public class OrderSorter implements Comparator<OrderSummary> {
    @Override
    public int compare(OrderSummary o1, OrderSummary o2) {
        return o1.getPrice().compareTo(o2.getPrice());
    }

}
