package com.uyibai.algorithm.solution.sort;


import java.util.Arrays;

import lombok.extern.slf4j.Slf4j;

/**
 * 时间复杂度为 O(n2) 的 排序算法
 *
 * @author : Hui.Wang [huzi.wh@gmail.com]
 * @version : 1.0
 * @date  : 2022/4/14
 */
@Slf4j
public class On2SortUtils {
  public static void main(String[] args) {
    int[] arr = new int[] {2, 1, 6, 5, 12, 3, 1, 3, 78, 4, 90, 7};
//    Arrays.sort(arr);
//    log.info("Arrays.sort:{}", arr);
//    bubbleSort(arr);
//    log.info("Arr BubbleSort:{}", arr);
//    insertSort(arr);
//    log.info("Arr insertSort:{}", arr);
    selectionSort(arr);
    log.info("Arr selectionSort:{}", arr);
  }

  /**
   * 冒泡排序
   * [2, 1, 6,5, 12, 3, 1, 3, 78, 4, 7, 90]
   * [1, 1, 2, 3, 3, 4, 5, 6, 7, 12, 78, 90]
   *
   * @param arr
   */
  public static void bubbleSort(int[] arr) {
    if (arr != null && arr.length > 1) {
      int size = arr.length;
      for (int i = 0; i < size; ++i) {
        for (int j = 0; j < size - (i + 1); ++j) {
          if (arr[j] > arr[j + 1]) {
            int temp = arr[j];
            arr[j] = arr[j + 1];
            arr[j + 1] = temp;
          }
          log.info("Bubble:第{}次冒泡,第{}次比较,{}", i, j, arr);
        }
      }
    }
  }

  /**
   * 插入排序: 对于一个有序数组，往里添加一个新数据后，继续保持数组中数据的有序性
   * 实现思路：将数组分为 两个区间：已排序区间(初始只有一个元素)和未排序区间，
   * 排序过程：取未排序区间元素在已排序区间找合适的位置将其插入，并保证已排序区间一直有序
   * 重复整个过程，直到未排序区间中的元素为空
   * @param arr
   */
  public static void insertSort(int[] arr) {
    if (arr != null && arr.length > 1) {
      int size = arr.length;
      // 从数组的第二个元素开始,循环将数组中的元素插入
      for (int i = 1; i < size; ++i) {
        int value = arr[i]; // 设置数组中第二个元素为第一次要插入的数据
        // 将数组分为两个区域，初始值:第一个数组元素
        int j = i - 1;
        // 查找插入位置
        for (; j >= 0; --j) {

          if (arr[j] > value) {
            // 数据移动:要插入的元素小于 第j个，就向后移动,
            arr[j + 1] = arr[j];
          } else {
            break;
          }
        }
        arr[j + 1] = value;
      }
    }
  }

  /**
   * 选择排序： 将整个数组划分为已排序区间和未排序区间，每次从未排序区间选择最小的元素，将其放到已排序区间的末尾。
   * @param arr
   */
  public static void selectionSort(int[] arr) {
    if (arr != null && arr.length > 1) {
      int size = arr.length;
      //  总共要经过 N-1 轮比较
      for (int i=0; i<size-1; i++) {
         int minPos = i;
         // 每轮需要比较的次数 N-i
         for (int j=i+1; j< size; j++) {
           if (arr[j] < arr[minPos]) {
             minPos = j;
           }
         }
         // 找到最小的交换位置
         int temp = arr[i];
         arr[i] = arr[minPos];
         arr[minPos] = temp;
      }
    }

  }

}
