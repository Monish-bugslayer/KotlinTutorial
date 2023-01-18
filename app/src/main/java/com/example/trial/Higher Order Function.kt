package com.example.trial

import java.util.*
import java.util.concurrent.locks.Lock

/* Higher order function is a function that has function as parameter.We pass a function into a higher
order function as a parameter
 */
fun add(a:Int,b:Int):Int{
    return a+b
}
fun higherOrder(a:Int,b:Int,fu:(Int,Int)->Int){
    println(fu(a,b))
}
//lambda function
fun higherOrderAndLamda(a:Int,b:Int,lambdaAdd:(Int)->Int):Int{
    var add:Int=a+b
    return(lambdaAdd(add))
}

fun multiply(a:Int,b:Int,mul:(Int,Int)->Int):Int{
    return mul(a,b)
}




fun main(){
    higherOrder(10,20,::add)
    var lambdaAdd:(Int)->Int={s:Int->s}//lambda fun of add two numbers
    println(higherOrderAndLamda(10,20,lambdaAdd))
    //var mul:(Int,Int)->Int={a:Int,b:Int->a*b}//lambda function that multiplies two numbers
    println(multiply(10,20) { a: Int, b: Int -> a * b })
    //lambda for traversing a list
    traverse{
        var list= listOf<Int>(1,2,34,5,5)
        for(i in list){
            println(i)
        }
    }
}

fun traverse(someBody:()->Unit){
    someBody()
}








