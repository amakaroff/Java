package com.ssu.alexey_makarov.task_2;

import com.ssu.alexey_makarov.task_2.controller.Controller;
import com.ssu.alexey_makarov.task_2.dao.impl.JSONDAO;
import com.ssu.alexey_makarov.task_2.db.reader.Reader;
import com.ssu.alexey_makarov.task_2.db.reader.json.impl.JSONReader;
import com.ssu.alexey_makarov.task_2.model.eat.Eat;
import com.ssu.alexey_makarov.task_2.view.impl.ConsoleView;

/**
 * Created by csit on 28.09.2016.
 */
public class SolutionTaskTwo {
    public static void main(String[] args) {
        SolutionTaskTwo solutionTaskTwo = new SolutionTaskTwo();
        solutionTaskTwo.StartApplication();
    }

    public void StartApplication() {
        Controller controller = new Controller(ConsoleView.getInstance(), new JSONDAO("D:\\Java\\menu\\src\\main\\resources\\menu.json"));
        //JSONReader jsonReader = JSONReader.getInstance().setPath("D:\\Java\\menu\\src\\main\\resources\\menu.json");
        controller.makeOrder();
    }
}
