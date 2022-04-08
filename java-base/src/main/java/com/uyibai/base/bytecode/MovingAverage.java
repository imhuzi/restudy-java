package com.uyibai.base.bytecode;

/**
 *
 *
 * @author : Hui.Wang [huzi.wh@gmail.com]
 * @version : 1.0
 * @date  : 2022/4/7
 */
public class MovingAverage {
  private int count = 0;

  private double sum = 0.00;

  public void submit(double num) {
    this.count++;
    this.sum += num;
  }

  public double getAvg() {
    if (count == 0) {
      return sum;
    }
    return this.sum / this.count;
  }
}
