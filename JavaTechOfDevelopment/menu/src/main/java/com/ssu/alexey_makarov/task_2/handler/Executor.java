package com.ssu.alexey_makarov.task_2.handler;

import com.ssu.alexey_makarov.task_2.model.order.Order;

import java.util.List;

/**
 * Created by ������� on 28.09.2016.
 */
public interface Executor<T> {

    void execute(T object);
}
