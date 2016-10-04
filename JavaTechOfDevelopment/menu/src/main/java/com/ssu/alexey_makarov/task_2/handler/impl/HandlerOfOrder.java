package com.ssu.alexey_makarov.task_2.handler.impl;

import com.ssu.alexey_makarov.task_2.handler.Executor;
import com.ssu.alexey_makarov.task_2.model.order.Order;
import com.ssu.alexey_makarov.task_2.model.order.factory.OrderFactory;
import com.ssu.alexey_makarov.task_2.view.View;
import com.ssu.alexey_makarov.task_2.view.impl.ConsoleView;
import com.ssu.alexey_makarov.task_2.view.printer.Printer;

import java.util.List;

/**
 * Created by csit on 28.09.2016.
 */
public class HandlerOfOrder<T extends Order> implements Executor<T> {

    private View view;

    public HandlerOfOrder(View view) {
        this.view = view;
    }

    @Override
    public void execute(T order) {
        view.print(order.getDiningRoomRepost());

        view.print("Заказ выполнен");

        view.print(order.getClientRepost());
    }
}
