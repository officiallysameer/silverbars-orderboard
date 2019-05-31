package com.tembotech.silverbars;

import com.tembotech.silverbars.exception.OrderNotFoundException;
import com.tembotech.silverbars.model.Order;
import com.tembotech.silverbars.model.OrderType;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LiveOrderBoardTest {

    private LiveOrderBoard liveOrderBoard;

    @Before
    public void setup(){
        liveOrderBoard = new LiveOrderBoard();
    }

    @Test
    public void test_board_is_empty() {
        assertTrue(liveOrderBoard.getLiveOrders().size() == 0);
    }

    @Test
    public void register_one_order() {
        int orderId = liveOrderBoard.register(new Order("John123",1.5, 250.00, OrderType.BUY));
        assertTrue(liveOrderBoard.getLiveOrders().size() == 1);
        assertTrue(liveOrderBoard.getLiveOrders().get(0).getOrderId() == orderId);

    }

    @Test
    public void register_two_orders() {

        liveOrderBoard.register(new Order("Sally234",3.0, 500.00, OrderType.BUY));
        liveOrderBoard.register(new Order("Pete123",2.5, 350.00, OrderType.BUY));
        assertTrue(liveOrderBoard.getLiveOrders().size() == 2);

    }

    @Test
    public void cancel_order_from_empty_board(){
        try {
            liveOrderBoard.cancel(12345);
        } catch (OrderNotFoundException e) {
            assertTrue(e.getMessage().contains("12345"));
        }
    }


    @Test
    public void cancel_an_order() throws OrderNotFoundException {

        int orderId = liveOrderBoard.register(new Order("Sally234",3.0, 500.00, OrderType.BUY));
        liveOrderBoard.register(new Order("Pete123",2.5, 350.00, OrderType.BUY));
        assertTrue(liveOrderBoard.getLiveOrders().size() == 2);

        liveOrderBoard.cancel(orderId);
        assertTrue(liveOrderBoard.getLiveOrders().size() == 1);
        assertFalse(liveOrderBoard.getLiveOrders().get(0).getUserId().equals("Sally234"));


    }

    @Test
    public void test_order_summary_buy() {

        liveOrderBoard.register(new Order("Sally234",3.0, 500.00, OrderType.BUY));
        liveOrderBoard.register(new Order("Pete123",2.5, 350.00, OrderType.BUY));

        assertTrue(liveOrderBoard.getOrderSummary().size() == 2);


    }


    @Test
    public void test_order_summary_buy_aggregate_quantity_sort_descending() {

        liveOrderBoard.register(new Order("Sally234",3.0, 500.00, OrderType.BUY));
        liveOrderBoard.register(new Order("Pete123",2.5, 350.00, OrderType.BUY));
        liveOrderBoard.register(new Order("Sam123",4.5, 350.00, OrderType.BUY));
        liveOrderBoard.register(new Order("Steve123",5.5, 500.00, OrderType.BUY));

        assertTrue(liveOrderBoard.getOrderSummary().size() == 2);
        assertTrue(liveOrderBoard.getOrderSummary().get(0).getAggregatedQuantity() == 8.5);
        assertTrue(liveOrderBoard.getOrderSummary().get(1).getPrice() == 350);

    }

    @Test
    public void test_order_summary_sell() {

        liveOrderBoard.register(new Order("Sally234",3.0, 500.00, OrderType.SELL));
        liveOrderBoard.register(new Order("Pete123",2.5, 350.00, OrderType.SELL));
        liveOrderBoard.register(new Order("Harry123",2.5, 450.00, OrderType.SELL));

        assertTrue(liveOrderBoard.getOrderSummary().size() == 3);


    }


    @Test
    public void test_order_summary_sell_aggregate_quantity_sort_ascending() {

        liveOrderBoard.register(new Order("Sally234",3.0, 450.00, OrderType.SELL));
        liveOrderBoard.register(new Order("Pete123",2.5, 450.00, OrderType.SELL));
        liveOrderBoard.register(new Order("Sam123",4.5, 420.00, OrderType.SELL));
        liveOrderBoard.register(new Order("Steve123",5.5, 460.00, OrderType.SELL));

        assertTrue(liveOrderBoard.getOrderSummary().size() == 3);
        assertTrue(liveOrderBoard.getOrderSummary().get(0).getAggregatedQuantity() == 4.5);
        assertTrue(liveOrderBoard.getOrderSummary().get(0).getPrice() == 420);

    }

    @Test
    public void test_order_summary() {

        liveOrderBoard.register(new Order("Sally234",3.0, 450.00, OrderType.SELL));
        liveOrderBoard.register(new Order("Pete123",2.5, 450.00, OrderType.SELL));
        liveOrderBoard.register(new Order("Sam123",4.5, 420.00, OrderType.SELL));
        liveOrderBoard.register(new Order("Steve123",5.5, 460.00, OrderType.SELL));

        liveOrderBoard.register(new Order("Sal134",3.0, 500.00, OrderType.BUY));
        liveOrderBoard.register(new Order("Pat123",2.5, 350.00, OrderType.BUY));
        liveOrderBoard.register(new Order("Sarah123",4.5, 350.00, OrderType.BUY));
        liveOrderBoard.register(new Order("Tom123",5.5, 500.00, OrderType.BUY));

        assertTrue(liveOrderBoard.getOrderSummary().size() == 5);


        assertTrue(liveOrderBoard.getOrderSummary().get(0).getAggregatedQuantity() == 8.5);
        assertTrue(liveOrderBoard.getOrderSummary().get(0).getPrice() == 500);
        assertTrue(liveOrderBoard.getOrderSummary().get(0).getOrderType().equals(OrderType.BUY));

        assertTrue(liveOrderBoard.getOrderSummary().get(1).getAggregatedQuantity() == 7.0);
        assertTrue(liveOrderBoard.getOrderSummary().get(1).getPrice() == 350);
        assertTrue(liveOrderBoard.getOrderSummary().get(1).getOrderType().equals(OrderType.BUY));

        assertTrue(liveOrderBoard.getOrderSummary().get(2).getAggregatedQuantity() == 4.5);
        assertTrue(liveOrderBoard.getOrderSummary().get(2).getPrice() == 420);
        assertTrue(liveOrderBoard.getOrderSummary().get(2).getOrderType().equals(OrderType.SELL));

        assertTrue(liveOrderBoard.getOrderSummary().get(4).getAggregatedQuantity() == 5.5);
        assertTrue(liveOrderBoard.getOrderSummary().get(4).getPrice() == 460);
        assertTrue(liveOrderBoard.getOrderSummary().get(4).getOrderType().equals(OrderType.SELL));

    }



}