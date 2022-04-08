package com.uyibai.base.bytecode;

/**
 *
 *
 * @author : Hui.Wang [huzi.wh@gmail.com]
 * @version : 1.0
 * @date  : 2022/4/7
 */
public class LocalVariableTest {
  public static void main(String[] args) {
    MovingAverage ma = new MovingAverage();
    int num1 = 1;
    int num2 = 2;
    ma.submit(num1);
    ma.submit(num2);
    double avg = ma.getAvg();
  }
}
