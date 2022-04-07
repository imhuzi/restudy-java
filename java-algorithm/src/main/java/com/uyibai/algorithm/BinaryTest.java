package com.uyibai.algorithm;

/**
 * 二进制相关
 *
 * @author : Hui.Wang [huzi.wh@gmail.com]
 * @version : 1.0
 * @date  : 2022/3/5
 */
public class BinaryTest {

  public static void main(String[] args) {
    printInt(-1);
    printInt(-5);
    // int 范围 -2的31次方-2的31次方-1
    // 0-30表示 值，最高位是符号位
    printInt(Integer.MAX_VALUE);

    // 负数二进制表示: 最高位是符号位, 取反+1
  }

  /**
   * 打印二进制
   *
   * @param num
   */
  static void printInt(int num) {
    for (int i = 31; i >= 0; i--) {
      // 左移 并与运算
      // 1.左移 1位，右边补0, 左移几位相当于 乘以 2的几次方
      // 2. 与运算,如果相对应位都是1，则结果为1，否则为0
      System.out.print((num & (1 << i)) == 0 ? "0" : "1");
    }
    System.out.println();
  }
}

