package com.ssu.alexey_makarov.task_2.model.customer.factory.impl;

import com.ssu.alexey_makarov.task_2.model.customer.Customer;
import com.ssu.alexey_makarov.task_2.model.customer.factory.CustomerFactory;

/**
 * Created by Алексей on 01.10.2016.
 */
public class CustomerFactoryImpl implements CustomerFactory {

    public Customer create(String name) {
        return new Customer(name);
    }
}
