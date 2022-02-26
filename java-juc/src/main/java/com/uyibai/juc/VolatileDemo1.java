package com.uyibai.juc;

import java.util.concurrent.TimeUnit;

/**
 * volatile 的一个功能，缓存一致性（缓存一致性协议(MESI协议)），为接下来学习 JUC 做准备。
 *
 * 当然 volatile 关键字在java中还会有其他的功能，例如 happer-before、内存屏障、重排序等等
 */
public class VolatileDemo1 {

    private  boolean ready = true;

    public boolean getReady() {
        return ready;
    }
    public void setReady(boolean re) {
        this.ready = re;
    }
    public static void main(String[] args) throws InterruptedException {
        VolatileDemo1 volatileDemo1 = new VolatileDemo1();
        new Thread(() -> {
            int count = 0;
            while (volatileDemo1.getReady()) {
                count ++;
                System.out.println("___" + count);
            }
        }).start();
        TimeUnit.NANOSECONDS.sleep(500);
        volatileDemo1.setReady(false);
    }
}
