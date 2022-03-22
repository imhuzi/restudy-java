package com.uyibai.thread;

public class MyThread extends  Thread{
    private boolean stopped = false;

    @Override
    public void run() {
        while (!stopped) {
            System.out.println("My Thread");
        }
    }

    /**
     * 停止 死循环
     */
    public void  doStop() {
        this.stopped = true;
    }

    public static void main(String[] args) throws InterruptedException {
        MyThread myThread = new MyThread();
        myThread.start();
        Thread.sleep(1000);
        myThread.doStop();
//        myThread.join();
    }
}
