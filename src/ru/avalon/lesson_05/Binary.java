package ru.avalon.lesson_05;

import java.util.Arrays;

public class Binary {

    private static final int ARRAY_SIZE = 64 ;

    int[] array = new int[ARRAY_SIZE / 32]; // каждый int 32 бита

    public boolean getByIndex(int index) {

        int elementIndex = index / 32; // индекс элемента в масиве; 32 - длина элемента в битах
        int bitIndex = index % 32; // индекс бинарного значения
        int element = array[elementIndex];
        int mask = 1 << bitIndex;
        return (element & mask) == mask;
    }

    public void inversion(int index) {
        int elementIndex = index / 32; // индекс элемента в масиве; 32 - длина элемента в битах
        int bitIndex = index % 32; // индекс бинарного значения
        int element = array[elementIndex];
        int mask = 1 << bitIndex;
        array[elementIndex] = element ^ mask;
    }

    public void setTrue(int index) {
        int elementIndex = index / 32; // индекс элемента в масиве; 32 - длина элемента в битах
        int bitIndex = index % 32; // индекс бинарного значения
        int element = array[elementIndex];
        int mask = 1 << bitIndex;
        array[elementIndex] = element | mask;
    }

    @Override
    public String toString() {
        String[] result = new String[ARRAY_SIZE];
        for (int i = 0; i < result.length; i++) {
            if (getByIndex(i))
                result[i] = "1";
            else
                result[i] = "0";
        }
        return Arrays.toString(result);
    }
}
