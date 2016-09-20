package com.ssu.makarov_alexey.java.task1;

/**
 * Created by Алексей on 20.09.2016.
 * Makarov Alexey task 1
 */

public class QuickSortThread implements Runnable{
    private int[] array;
    private int start;
    private int end;

    public QuickSortThread(int[] array) {
        this.array = array;
        start = 0;
        end = array.length - 1;
    }

    private QuickSortThread(int[] array, int start, int end) {
        this.array = array;
        this.start = start;
        this.end = end;
    }

    @Override
    public void run() {
        quickSort();
    }

    private void quickSort() {
        int i = start;
        int j = end;
        int cur = i - (i - j) / 2;

        while (i < j) {
            while (i < cur && (array[i] <= array[cur])) {
                i++;
            }
            while (j > cur && (array[cur] <= array[j])) {
                j--;
            }

            if (i < j) {
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                if (i == cur)
                    cur = j;
                else if (j == cur)
                    cur = i;
            }
        }

        if (start != end) {
            new QuickSortThread(array, start, cur).run();
            new QuickSortThread(array, cur + 1, end).run();
        }
    }
}
