package com.ssu.alexey_makarov.task_2.model.eat.factory;

import com.ssu.alexey_makarov.task_2.model.eat.Eat;

/**
 * Created by Алексей on 01.10.2016.
 */
public interface EatFactory {

    <T extends Eat> T create(Class<T> classType, String name, Integer weight, Integer cost);
}
