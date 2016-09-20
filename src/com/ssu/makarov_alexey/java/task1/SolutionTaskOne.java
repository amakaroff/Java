package com.ssu.makarov_alexey.java.task1;

import java.util.Scanner;

/**
 * Created by makarovaa on 14.09.2016.
 * Makarov Alexey task 1
 */

public class SolutionTaskOne {
    public static void main(String[] args) {
        SolutionTaskOne app = new SolutionTaskOne();
        app.startApplication();
    }

    public void startApplication() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] array = new int[n];

        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }

        QuickSortThread sortThread = new QuickSortThread(array);
        sortThread.run();

        for (int item : array) {
            System.out.print(item + " ");
        }
        System.out.println();
    }
}