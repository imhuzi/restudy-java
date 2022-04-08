package com.uyibai.base.bytecode;

/**
 *
 *
 * @author : Hui.Wang [huzi.wh@gmail.com]
 * @version : 1.0
 * @date  : 2022/4/7
 */
public class ForLoop {
  private  static int[] nums = {1,6,8};
  public static void main(String[] args) {
    MovingAverage ma = new MovingAverage();
    for (int num: nums) {
      ma.submit(num);
    }
    double avg = ma.getAvg();
  }
}
