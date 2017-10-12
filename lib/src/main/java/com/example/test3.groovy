package com.example
//计算器 注解
public class test3 {
    @Newify(ComplexNumber) //取代new的一种方式，可以直接使用 ComplexNumber(real: 1,imaginary: 1)
    public static void main(String[] args) {

       def c1 = new ComplexNumber(real: 1,imaginary: 2)
       def c2 = new ComplexNumber(real: 4,imaginary: 1)
//        def c3 = ComplexNumber.instance
        println c1 + c2  //plus 对应 + minus 对应 - multiply 对应 *   div 对应 ／
        println c1 - c2
        println c1 * c2
        println c1 / c2

//        @Delegate  //委托类操作 ，方便好用
//        @Immutable //不可变的 同java的final  可以做线程安全使用
//        @Lazy  //懒加载，类似单例模式中的懒加载，只有用到时才进行创建

        println ComplexNumber.new(real: 1,imaginary: 1)
    }

//    @Canonical(excludes = "") //调用println 回去找toString方法，使用此注解可以不用自己写toString方法了
//    @Singleton(lazy = true) //单例模式注解 简化使用方式
    static class ComplexNumber {
        def real,imaginary
        def plus(other) {
            new ComplexNumber(real :real+other.real, imaginary: imaginary+other.imaginary )
        }

        def minus(o) {
            new ComplexNumber(real: 99,imaginary: 99)
        }
        def multiply(o) {
            new ComplexNumber(real: 999,imaginary: 999)
        }

        def div(o) {
            new ComplexNumber(real: 9999,imaginary: 9999)
        }

        String toString() {  //默认调用toString方法
            "$real ${imaginary >0?"+":''} ${imaginary}i"
        }
    }

}