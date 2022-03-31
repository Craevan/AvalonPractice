package ru.avalon.lesson_05;

public class Main {

    public static void main(String[] args) {
        Binary binary = new Binary();

        System.out.println(binary);
        binary.inversion(4);
        System.out.println(binary);
        binary.setTrue(3);
        binary.setTrue(3);
        System.out.println(binary);
        binary.inversion(3);
        System.out.println(binary);
    }

}
