package com.ssu.alexey_makarov.task_2.model;

import com.google.common.base.Predicate;
import com.google.common.collect.FluentIterable;
import com.ssu.alexey_makarov.task_2.db.reader.json.impl.JSONReader;
import com.ssu.alexey_makarov.task_2.model.eat.Eat;

import java.util.Set;

/**
 * Created by Алексей on 30.09.2016.
 */
public class Cache<T extends Eat> {
    private static Cache cache;
    private Set<T> data;

    private Cache() {
    }

    public static Cache getInstance(String path) {
        if (cache == null) {
            cache = new Cache();
            cache.data = JSONReader.getInstance().setPath(path).read();
        }

        return cache;
    }

    public Set<T> getData() {
        return cache.data;
    }



    public boolean contains(final String name) {
        return FluentIterable.from(data).anyMatch(new Predicate<T>() {
            public boolean apply(T eat) {
                return eat.getName().equals(name);
            }
        });
    }
}
