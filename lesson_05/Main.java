package ru.gb.jtwo.elesson.online;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        float[] arr1 = firstMethod();
        float[] arr2 = secondMethod();

        System.out.println(Arrays.equals(arr1, arr2));
    }

    static final int size = 10_000_000;
    static final int h = size / 2;

    public static float[] firstMethod() {
        float[] arr = new float[size];

        for (int i = 0; i < size; i++) {
            arr[i] = 1;
        }
        long a = System.currentTimeMillis();

        for (int i = 0; i < size; i++) {
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }

        System.out.println(System.currentTimeMillis() - a);

        return arr;
    }

    public static float[] secondMethod() {
        float[] arr = new float[size];
        float[] a1 = new float[h];
        float[] a2 = new float[h];

        for (int i = 0; i < size; i++) {
            arr[i] = 1;
        }
        long a = System.currentTimeMillis();

        System.arraycopy(arr, 0, a1, 0, h);
        System.arraycopy(arr, h, a2, 0, h);

        Thread t1 = new Thread(new RunnableWithArray(a1, 0));
        Thread t2 = new Thread(new RunnableWithArray(a2, h));

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
            t1.interrupt();
            t2.interrupt();
        }

        System.arraycopy(a1, 0, arr, 0, h);
        System.arraycopy(a2, 0, arr, h, h);

        System.out.println(System.currentTimeMillis() - a);

        return arr;
    }
}
