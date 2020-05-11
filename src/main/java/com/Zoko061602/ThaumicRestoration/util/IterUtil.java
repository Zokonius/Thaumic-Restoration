package com.Zoko061602.ThaumicRestoration.util;

public class IterUtil {
    /**
     * @param i iterator
     * @return value that iterates like 1 -1 1 -1 1 -1 1 -1
     */
    public static int tick1(int i) {
        if (i % 2 < 1) return -1;
        else return 1;
    }
    /**
     * @param i iterator
     * @return value that iterates like 1 1 -1 -1 1 1 -1 -1
     */
    public static int tick2(int i) {
        if (i % 4 < 2) return -1;
        else return 1;
    }
    /**
     * @param i iterator
     * @return value that iterates like 1 1 1 1 -1 -1 -1 -1
     */
    public static int tick3(int i) {
        if (i % 8 < 4) return -1;
        else return 1;
    }
    /**
     * @param n ticking number
     * @param i iterator
     * @return value that iterates n times -1 and then n times 1
     */
    public static int tick(int n, int i) { // Inefficient
        if (i % (n*2) < n) return -1;
        else return 1;
    }
}
