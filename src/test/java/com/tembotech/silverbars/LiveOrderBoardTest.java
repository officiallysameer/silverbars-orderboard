package com.tembotech.silverbars;

import com.tembotech.silverbars.model.Order;
import com.tembotech.silverbars.model.OrderType;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.IsCollectionContaining.hasItem;
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


}