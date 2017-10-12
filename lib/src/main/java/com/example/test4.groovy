package com.example
//闭包是一个函数   匿名函数指针 ，将部分实现逻辑委托出去
public class test4 {
    public static void main(String[] args) {
//        pickEvent(10) {
                //当闭包在最后时可以直接放到括号外边代码块中
//           str, param -> println param
//            println it
//        }

        //curry 使用
//        def multiply = { x, y -> return x * y }  // closure
//        def triple = multiply.curry(3)           // triple = { y -> return 3 * y }
//        def quadruple = multiply.curry(4)        // quadruple = { y -> return 4 * y }
//        def p = triple.call(4)                   // explicit call
//        def q = quadruple(5)                     // implicit call
//        println "p: ${p}"                        // p is 12
//        println "q: ${q}"                        // q is 20

        //尾递归的方式 ,尾递归不会一直保存栈信息，只需要覆盖即可
        //如果一个函数中所有递归形式的调用都出现在函数的末尾，我们称这个递归函数是尾递归的。
        // 当递归调用是整个函数体中最后执行的语句且它的返回值不属于表达式的一部分时，这个递归调用就是尾递归。
        // 尾递归函数的特点是在回归过程中不用做任何操作，这个特性很重要，因为大多数现代的编译器会利用这种特点自动生成优化的代码。
        Closure factorial
        factorial = {
            int number , BigInteger theFac -> number ==1?theFac : factorial.trampoline(number -1, number * theFac)
        }.trampoline()

        println "fac 5 ${factorial(5,1)}"
        println "fac 5000 ${factorial(5000,1).bitCount()}"

    }

    static def pickEvent(n,Closure block) {
        if (!block) return
        println block.maximumNumberOfParameters
        println block.parameterTypes

        2.step(n, 2) {
            def cu = block.curry(3)//传入的参数为两个，使用curry之后去掉了一个
            cu("china: $it")
        }
    }


}