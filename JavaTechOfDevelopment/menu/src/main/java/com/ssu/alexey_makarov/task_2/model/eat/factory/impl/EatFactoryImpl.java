package com.ssu.alexey_makarov.task_2.model.eat.factory.impl;

import com.ssu.alexey_makarov.task_2.model.eat.Eat;
import com.ssu.alexey_makarov.task_2.model.eat.factory.EatFactory;
import org.apache.log4j.Logger;

import java.lang.reflect.Constructor;

/**
 * Created by Алексей on 01.10.2016.
 */
public class EatFactoryImpl implements EatFactory {

    private final static Logger LOGGER = Logger.getLogger(EatFactoryImpl.class);

    public <T extends Eat> T create(Class<T> classType, String name, Integer weight, Integer cost) {
//        Type type = ((ParameterizedType)(getClass().getGenericSuperclass()))
//                        .getActualTypeArguments()[0];
//
//        String className = type.toString().split(" ")[1];
        try {
            //Class inferedClass = Class.forName(className);
            Constructor<T> cons = classType.getConstructor(String.class, Integer.class, Integer.class);
            return cons.newInstance(name, weight, cost);
        } catch (ReflectiveOperationException exception) {
            LOGGER.error(exception.getMessage());
            return null;
        }
    }
}
