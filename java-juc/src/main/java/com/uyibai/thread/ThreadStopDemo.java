package com.uyibai.thread;

/**
 * 线程 优雅关闭
 */
public class ThreadStopDemo {

    /**
     * “运行到一半的线程能否强制杀死？”
     *
     * ::::
     * “答案是：不能。在Java中，有stop（）、destory（）之类的函数，但这些函数都是官方明确不建议使用的。原因很简单，如果强制杀死线程，则线程中所使用的资源，例如文件描述符、网络连接等不能正常关闭。
     * 因此，一个线程一旦运行起来，就不要去强行打断它，合理的关闭办法是让其运行完（也就是函数执行完毕），干净地释放掉所有资源，然后退出。如果是一个不断循环运行的线程，就需要用到线程间的通信机制，让主线程通知其退出。”
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("main Thread start!");
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        System.out.println(" executing");
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        // 守护线程不会阻止 JVM 退出, main 函数运行完之后 就会终止
        // setDaemon(true) 必须 在 start方法之前调用 否则会抛出 IllegalThreadStateException
//        t1.setDaemon(true);
        t1.start();
        System.out.println("Main exit");
    }
}
