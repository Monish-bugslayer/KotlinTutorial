package com.example.trial

import androidx.core.graphics.translationMatrix

/* Generics makes a class to accept any type of data to be in it
* Generics code is checked at compile time so it can avoid runtime errors */

//fun add(a:Int,b:Int):Int{
//    return a+b
//}
//here we can pass only integers to pass double type parameters we need to write another function
//in order to avoid it generics are used
//in keyword is used to pass the generic as input and out keyword is used tp get the generic as output


interface Details<out T>{
    fun get():T
}
fun fetch(parms:Details<String>){
   val objects : Details<Any> = parms
}

interface Calci<T>{
    fun add(a:T,b:T):T
    fun mul(a:T,b:T):T
}

class SCalculator:Calci<Int>{
    override fun add(a: Int, b: Int): Int {
        return a+b

    }

    override fun mul(a: Int, b: Int): Int {
        return a*b
    }

}


