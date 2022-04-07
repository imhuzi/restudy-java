package com.uyibai.base.reflection;

/**
 * 4种获取 class对象的方式
 */
public class Cls {

    public static void main(String[] args) throws ClassNotFoundException {
        //    1. 知道具体类的情况下可以使用：
        //    但是我们一般是不知道具体类的，基本都是通过遍历包下面的类来获取 Class 对象，通过此方式获取 Class 对象不会进行初始化
        Class alunbarClass = Cls.class;

        //2. 通过 Class.forName()传入类的全路径获取：
        Class alunbarClass1 = Class.forName("com.uyibai.base.reflection.Cls");

        //3. 通过对象实例instance.getClass()获取：
        Cls o = new Cls();
        Class alunbarClass2 = o.getClass();
        //4. 通过类加载器xxxClassLoader.loadClass()传入类路径获取:
        // 通过类加载器获取 Class 对象不会进行初始化，意味着不进行包括初始化等一系列步骤，静态代码块和静态对象不会得到执行
//        Class clazz = ClassLoader.loadClass("com.uyibai.base.reflection.Cls");
    }

}
