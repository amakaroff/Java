package com.ssu.alexey_makarov.task_2.db.reader;

import com.ssu.alexey_makarov.task_2.model.eat.Eat;

import java.util.Set;

/**
 * Created by csit on 28.09.2016.
 */
public interface Reader {

    <T extends Eat> Set<T> read();
}
