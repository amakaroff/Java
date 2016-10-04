package com.ssu.alexey_makarov.task_2.model.order.factory.impl;

import com.ssu.alexey_makarov.task_2.model.customer.Customer;
import com.ssu.alexey_makarov.task_2.model.eat.Eat;
import com.ssu.alexey_makarov.task_2.model.order.Order;
import com.ssu.alexey_makarov.task_2.model.order.factory.OrderFactory;

import java.util.List;

/**
 * Created by Алексей on 01.10.2016.
 */
public class OrderFactoryImpl implements OrderFactory {

    public <T extends Eat> Order<T> composite(Customer customer, List<T> list) {
        return new Order<T>(customer, list);
    }
}
