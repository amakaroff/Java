package com.ssu.alexey_makarov.task_2.model.customer.factory;

import com.ssu.alexey_makarov.task_2.model.customer.Customer;

/**
 * Created by Алексей on 01.10.2016.
 */
public interface CustomerFactory {

    Customer create(String name);
}
