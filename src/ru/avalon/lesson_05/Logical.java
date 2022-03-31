package ru.avalon.lesson_05;

public class Logical implements IBool {

    private static final int ARRAY_SIZE = 8;

    boolean[] booleans = new boolean[ARRAY_SIZE];

    @Override
    public boolean getByIndex(int index) {
        if (index < 0 || index >= booleans.length)
            throw new IllegalArgumentException();
        return booleans[index];
    }

    @Override
    public void inversion(int index) {
        if (index < 0 || index >= booleans.length)
            throw new IllegalArgumentException();
        booleans[index] = !booleans[index];

    }

    @Override
    public void setTrue(int index) {
        if (index < 0 || index >= booleans.length)
            throw new IllegalArgumentException();
        booleans[index] = true;
    }

    @Override
    public void setFalse(int index) {
        if (index < 0 || index >= booleans.length)
            throw new IllegalArgumentException();
        booleans[index] = false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        for (boolean b : booleans) {
            if (b)
                sb.append("1,");
            else
                sb.append("0,");
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.append("}");
        return sb.toString();
    }
}
