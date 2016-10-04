package com.ssu.alexey_makarov.task_2.model.eat;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.ssu.alexey_makarov.task_2.model.eat.dishes.dessert.Dessert;
import com.ssu.alexey_makarov.task_2.model.eat.dishes.garnishe.Garnishe;
import com.ssu.alexey_makarov.task_2.model.eat.dishes.meat.Meat;
import com.ssu.alexey_makarov.task_2.model.eat.dishes.salad.Salad;
import com.ssu.alexey_makarov.task_2.model.eat.dishes.soup.Soup;

import java.util.Objects;

/**
 * Created by csit on 28.09.2016.
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.PROPERTY, property = "@class")
@JsonSubTypes(
        {
                @JsonSubTypes.Type(value = Dessert.class, name = "dessert"),
                @JsonSubTypes.Type(value = Garnishe.class, name = "garnishe"),
                @JsonSubTypes.Type(value = Meat.class, name = "meat"),
                @JsonSubTypes.Type(value = Salad.class, name = "salad"),
                @JsonSubTypes.Type(value = Soup.class, name = "soup")
        })
public abstract class Eat {
    protected String name;
    protected Integer weight;
    protected Integer cost;

    public Eat() { }

    public Eat(String name, Integer weight, Integer cost) {
        this.name = name;
        this.weight = weight;
        this.cost = cost;
    }

    public String getName() {
        return name;
    }

    public Integer getWeight() {
        return weight;
    }

    public Integer getCost() {
        return cost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Eat eat = (Eat) o;
        return Objects.equals(weight, eat.weight) &&
                Objects.equals(cost, eat.cost) &&
                Objects.equals(name, eat.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, weight, cost);
    }
}
