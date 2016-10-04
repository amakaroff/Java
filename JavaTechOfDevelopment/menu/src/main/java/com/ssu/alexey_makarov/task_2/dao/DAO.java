package com.ssu.alexey_makarov.task_2.dao;

import com.ssu.alexey_makarov.task_2.model.eat.Eat;

import java.util.List;

/**
 * Created by Алексей on 04.10.2016.
 */
public interface DAO {

    <T extends Eat>List<T> getList();
}
