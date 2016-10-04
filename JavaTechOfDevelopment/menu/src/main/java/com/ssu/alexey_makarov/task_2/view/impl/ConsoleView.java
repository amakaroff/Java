package com.ssu.alexey_makarov.task_2.view.impl;


import com.ssu.alexey_makarov.task_2.view.View;

import java.util.Scanner;

/**
 * Created by Алексей on 04.10.2016.
 */
public class ConsoleView extends View {

    private static final ConsoleView instance = new ConsoleView();
    private Scanner scanner;

    private ConsoleView() {
        scanner = new Scanner(System.in);
    }

    public static ConsoleView getInstance() {
        return instance;
    }

    @Override
    public void print(String data) {
        System.out.println(data);
    }

    @Override
    public String read() {
        return scanner.next();
    }
}
