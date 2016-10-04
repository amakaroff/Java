package com.ssu.alexey_makarov.task_2.model.order.factory;

import com.ssu.alexey_makarov.task_2.model.customer.Customer;
import com.ssu.alexey_makarov.task_2.model.eat.Eat;
import com.ssu.alexey_makarov.task_2.model.order.Order;

import java.util.List;

/**
 * Created by Алексей on 01.10.2016.
 */
public interface OrderFactory {

    <T extends Eat> Order composite(Customer customer, List<T> list);
}
