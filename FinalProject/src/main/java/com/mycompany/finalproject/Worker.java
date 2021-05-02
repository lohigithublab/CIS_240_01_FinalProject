package com.mycompany.finalproject;

import org.apache.commons.collections4.queue.CircularFifoQueue;

import java.util.Queue;

public class Worker {

    private Queue<Order> orders;
    final int maxLimit = 10;
    public void run() {
        orders = new CircularFifoQueue<Order>(5);
        new Thread(new Runnable() {
            public void run() {
                asynchronousOrderGenerator(maxLimit);
            }
        }).start();
        processPlacedOrderBy(maxLimit);

    }

    private void processPlacedOrderBy(int maxLimit) {
        try {
            for (int processCounter = 1; processCounter <= maxLimit; processCounter++) {
                Thread.sleep(1000);
                Order currentProcessingOrder = orders.element();
                currentProcessingOrder.setState(OrderState.FULFILLED);
                orders.remove();
                System.out.println("Processed Order Id :" + currentProcessingOrder.getId() +
                        "\n Order State After processed currentProcessingOrder :" + currentProcessingOrder.getState().name());
            }
            System.out.println("End Of Order Process" +
                    "\n Processed : " + maxLimit + " Orders");
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    private void asynchronousOrderGenerator(int maxOrders) {
        try {
            for (int order = 1; order <= maxOrders; order++) {
                Order newOrder= new Order();
                orders.add(newOrder);
                System.out.println("Order Placed, Id : "+newOrder.getId());
                Thread.sleep(1000);
            }
        } catch (Exception ex) {
               System.out.println(ex);
        }
    }

}
