package ru.gb.jtwo.elesson.online;

public class RunnableWithArray implements Runnable {
    float[] arr;
    long offset;

    public RunnableWithArray(float[] arr, long offset) {
        this.arr = arr;
        this.offset = offset;
    }

    @Override
    public void run() {
        long offsetI;

        for (int i = 0; i < arr.length; i++) {
            offsetI = i + offset;

            arr[i] = (float)(arr[i] * Math.sin(0.2f + offsetI / 5) * Math.cos(0.2f + offsetI / 5) * Math.cos(0.4f + offsetI / 2));
        }
    }
}
