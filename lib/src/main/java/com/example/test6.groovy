package com.example

//集合类
public class test6{
    public static void main(String[] args) {
        def lst = [1,2,3,4,5,6]
        def sublst = lst[2..3]   //新的一个ArrayList
        println lst.dump()
        println sublst.dump()

        sublst[0] = -9999
        println lst.dump()
        println sublst.dump()
    }
}