package com.example
// 接口实现： Groovy 能把一个映射或者代码块转化为接口
public class test5 {
    public static void main(String[] args) {
        def mListener = [
                do1: { println("$it") },
                do2: { println(it + "dddddddd") },
                //若仅仅实现部分方法，调用其他方法时会报空指针，此处不实现do3，报错如下
                //Exception in thread "main" java.lang.UnsupportedOperationException,at com.sun.proxy.$Proxy0.do3(Unknown Source)
//                do3: { java.lang.Object[] pars -> println("$pars") }
        ] as MListener
        mListener.do1("do1")
        mListener.do2("do2")
        mListener.do3("do3", "333333")

        //或者实现一个代码块，此时不论调用do1 ，或者do2 都会调用此代码块
//        def mListener1 = {
//           Object[] params -> println("$params")
//        } as MListener
//        mListener1.do1("do1")
//        mListener1.do2("do2" , "aaaaaaa")
    }

    // lambda 表达式 接口
    static interface MListener {
        void do1(String str)

        void do2(String str)

        void do3(String str, String str2)
    }

}