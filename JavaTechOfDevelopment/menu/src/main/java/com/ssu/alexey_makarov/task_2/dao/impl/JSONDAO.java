package com.ssu.alexey_makarov.task_2.dao.impl;

import com.ssu.alexey_makarov.task_2.dao.DAO;
import com.ssu.alexey_makarov.task_2.model.Cache;
import com.ssu.alexey_makarov.task_2.model.eat.Eat;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Алексей on 04.10.2016.
 */
public class JSONDAO implements DAO{

    private static Cache cache;

    public JSONDAO(String path) {
        cache = Cache.getInstance(path);
    }

    @Override
    public <T extends Eat> List<T> getList() {
        List<T> list = new ArrayList<T>();
        list.addAll(cache.getData());
        return list;
    }
}
