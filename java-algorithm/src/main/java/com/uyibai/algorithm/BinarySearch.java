package com.uyibai.algorithm;

/**
 * 二分查找
 */
public class BinarySearch {
    /**
     * 二分查找
     *
     * @param key 要查找的 key
     * @param arr 目标有序集合
     * @return
     */
    public static int rank(int key, int[] arr) {
        int lo = 0;
        int hi = arr.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (key < arr[mid]) {
                hi = mid - 1;
            } else if (key > arr[mid]) {
                lo = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {

    }
}
