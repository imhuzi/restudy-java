package com.uyibai.base;

/**
 * 简单的计时器
 */
public class Stopwatch {
    private final String name;
    private final long start;

    public Stopwatch(String name) {
        this.start = System.currentTimeMillis();
        this.name = name;
    }

    public double elapsedTime() {
        long now = System.currentTimeMillis();
        return (now - start) / 1000.0;
    }

    public void printElapsedTime() {
        System.out.println(name + "elapsed time: " + elapsedTime() + " seconds");
    }
}
