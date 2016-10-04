package com.ssu.alexey_makarov.task_2.controller;

import com.ssu.alexey_makarov.task_2.dao.DAO;
import com.ssu.alexey_makarov.task_2.handler.Executor;
import com.ssu.alexey_makarov.task_2.handler.impl.HandlerOfOrder;
import com.ssu.alexey_makarov.task_2.model.customer.Customer;
import com.ssu.alexey_makarov.task_2.model.customer.factory.CustomerFactory;
import com.ssu.alexey_makarov.task_2.model.customer.factory.impl.CustomerFactoryImpl;
import com.ssu.alexey_makarov.task_2.model.eat.Eat;
import com.ssu.alexey_makarov.task_2.model.eat.factory.EatFactory;
import com.ssu.alexey_makarov.task_2.model.eat.factory.impl.EatFactoryImpl;
import com.ssu.alexey_makarov.task_2.model.order.Order;
import com.ssu.alexey_makarov.task_2.model.order.factory.OrderFactory;
import com.ssu.alexey_makarov.task_2.model.order.factory.impl.OrderFactoryImpl;
import com.ssu.alexey_makarov.task_2.view.View;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Алексей on 04.10.2016.
 */
public class Controller {

    private View view;
    private DAO dao;

    private OrderFactory orderFactory;
    private EatFactory eatFactory;
    private CustomerFactory customerFactory;

    public Controller(View view, DAO dao) {
        this.view = view;
        this.dao = dao;
        this.orderFactory = new OrderFactoryImpl();
        this.eatFactory = new EatFactoryImpl();
        this.customerFactory = new CustomerFactoryImpl();
    }

    public void makeOrder() {
        List<Eat> listOfEat = new ArrayList<Eat>();
        List<Eat> menu = dao.getList();
        Executor<Order> executor = new HandlerOfOrder<Order>(view);
        boolean decision = true;

        view.print("Выберите еду :");
        for (int i = 0; i < menu.size(); i++) {
            view.print((i + 1) + ". " + menu.get(i).getName());
        }
        while (decision) {
            int choice = Integer.parseInt(view.read());
            choice--;
            listOfEat.add(eatFactory.create(menu.get(choice).getClass(), menu.get(choice).getName(),
                    menu.get(choice).getWeight(), menu.get(choice).getCost()));

            view.print("Хотите что нибудь ещё? да/нет");

            if ("нет".equals(view.read())) {
                decision = false;
            }
        }

        Customer customer = createCustomer();
        executor.execute(orderFactory.composite(customer, listOfEat));
    }

    private Customer createCustomer() {
        view.print("Введите ваше имя :");
        String name = view.read();

        return customerFactory.create(name);
    }
}
