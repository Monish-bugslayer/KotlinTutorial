package com.example.trial

/* Extensions are used to create an extension for a class
* it can also extends properties
* Initializers are not allowed for the extensions
* if a class has companion object then we can also create extension for that companion object
* Interface can also have extensions
* Extensions can be used only for classes those we can create obj for it
* Classes having private constructor does not support extension because we cannot create obj outside the class that
* has a private constructor*/

fun Mobile.faceLock(){
    //This creates an extention method for the mobile class
}
//Similarly we can create extension for defined classes also
fun MutableList<Int>.swap(i1:Int,i2:Int){
    val tmp = this[i1] // 'this' corresponds to the list
    this[i1] = this[i2]
    this[i2] = tmp
}
//

fun Math.power(base:Int,exponent:Int):Int{
    var power:Int=1
    var exponential:Int=exponent
    while(exponential!=0){
        power*=power
        exponential-=1
    }
    return power

}
fun String.extension(){

}
fun Boolean.extension(){

}
//creating extension for properties
val<T>List<T>.lastIndex:Int
get() = size

val<T>List<T>.secondLastIndex:Int
get() = size-1

class Zoho {
    companion object zoho {
        fun display() {
            println("Zoho")
        }
    }


    fun Zoho.zoho.address() {
        println("Chennai Estancia")
    }
}
fun main() {
    String().extension()
}
