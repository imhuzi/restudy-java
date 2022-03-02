package com.uyibai.base;

public class BaseTest {
    public static void main(String[] args) {
        // i++ 与 ++i区别
//        int i = 1;
//        int temp = i;
//        i++;
//        i = temp;
//        System.out.println(i);

//        int count = 0;
//        for (int i = 0; i < 100; i++) {
//            count = count++;
//        }
//        System.out.println("count:" + count);

        // break, continue, return
        boolean flag = false;
        for (int i = 0; i <= 3; i++) {
            System.out.println("i:" + i);
            if (i == 0) {
                System.out.println("0");
            } else if (i == 1) {
                System.out.println("1");
                continue;
            } else if (i == 2) {
                System.out.println("2");
                flag = true;
            } else if (i == 3) {
                System.out.println("3");
                break;
            } else if (i == 4) {
                System.out.println("4");
            }
            System.out.println("xixi");
        }
        if (flag) {
            System.out.println("haha");
            return;
        }
        System.out.println("heihei");
    }
}
