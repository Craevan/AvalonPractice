package ru.avalon.lesson_05;

public class Main {

    public static void main(String[] args) {
        IBool binary = new Binary();

        System.out.println(binary);
        binary.inversion(4);
        System.out.println(binary);
        binary.setTrue(1);
        binary.setTrue(1);
        binary.setTrue(3);
        System.out.println(binary);
        binary.inversion(3);
        System.out.println(binary);
        binary.setFalse(1);
        System.out.println(binary);

        IBool logic = new Logical();

        System.out.println(logic);
        logic.setTrue(1);
        logic.setTrue(2);
        System.out.println(logic);
        logic.setFalse(2);
        System.out.println(logic);
        logic.inversion(1);
        System.out.println(logic);
        logic.setTrue(6);
        System.out.println(logic.getByIndex(6));

    }

}
