package com.ssu.alexey_makarov.task_2.model.order;

import com.google.common.base.Function;
import com.google.common.collect.FluentIterable;
import com.ssu.alexey_makarov.task_2.model.Cache;
import com.ssu.alexey_makarov.task_2.model.customer.Customer;
import com.ssu.alexey_makarov.task_2.model.eat.Eat;
import org.apache.commons.lang.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by csit on 28.09.2016.
 */
public class Order<T extends Eat> {
    Customer customer;
    List<T> listOfEat;

    public Order() {
    }

    public Order(Customer customer, List<T> listOfEat) {
        this.customer = customer;
        this.listOfEat = listOfEat;
    }

    public String getDiningRoomRepost() {
        List<String> list = new ArrayList<String>();

        for (T value : listOfEat) {
            list.add(StringUtils.join(new ArrayList<String>(Arrays.<String>asList(value.getName(),
                            getNumberOfEat(value).toString(),
                            value.getCost().toString())),
                    ", "));
        }

        list.add(getCostOfOrder().toString());

        return StringUtils.join(list, '\n');
    }

    public String getClientRepost() {
        String line = StringUtils.join(FluentIterable
                .from(listOfEat)
                .transform(new Function<Eat, String>() {

                    public String apply(Eat eat) {
                        return eat.getName();
                    }
                })
                .toList(), ", ");

        return StringUtils.join(Arrays.asList(customer.getName(), line, getCostOfOrder()), " | ");
    }

    private Integer getNumberOfEat(T eat) {
        return Collections.frequency(listOfEat, eat);
    }

    private Integer getCostOfOrder() {
        int total = 0;
        for (T value : listOfEat) {
            total += value.getCost();
        }
        return total;
    }
}
