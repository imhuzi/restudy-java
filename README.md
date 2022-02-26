## Review Java

以初学者的心态再次 review 下  java的相关知识，并以问题的方式记录下来


### Java 线程

1. 运行到一半的线程能否强制杀死？
> “答案是：不能。在Java中，有stop（）、destory（）之类的函数，但这些函数都是官方明确不建议使用的。原因很简单，如果强制杀死线程，则线程中所使用的资源，例如文件描述符、网络连接等不能正常关闭。 
> 因此，一个线程一旦运行起来，就不要去强行打断它，合理的关闭办法是让其运行完（也就是函数执行完毕），干净地释放掉所有资源，然后退出。如果是一个不断循环运行的线程，就需要用到线程间的通信机制，让主线程通知其退出。”


2. 守护线程有什么作用？
> 由于守护线程的作用是为用户线程提供服务，并且仅在用户线程运行时才需要，因此一旦所有用户线程完成执行，JVM 就会终止。也就是说 守护线程不会阻止 JVM 退出。
> 但是在 正在运行的守护线程上调用Thread.join() 可以阻止应用程序的关闭
> 作用：用于后台支持任务，比如垃圾回收、释放未使用对象的内存、从缓存中删除不需要的条目。

https://www.twle.cn/c/yufei/javatm/javatm-basic-daemon-thread.html