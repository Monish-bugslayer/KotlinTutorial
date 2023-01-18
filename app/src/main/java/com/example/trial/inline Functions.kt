package com.example.trial
//before using inline
fun main(){
    println("Hi")
    callFunction{
        println("call function")
        //return if i use return here it will stop the entire flow it wont execute even twoActions method. These
        //return are called non-local returns
    }
    println("fun called")

    twoActions({println("Printing")},{for (i in 1..10){println(i)} })
    callNonInlineFun { println("callNonInline") }
    lambda(someBody = {a,b ->a+b})

}

inline fun lambda(someBody: (a:Int,b:Int) -> Int){
    println(someBody(30,40))
}

inline fun callFunction(someBody:()->Unit){
    someBody()
}
/* while doing so a function object is created in the memory.
To avoid this we can use a keyword called inlined before the function
functions with large amount of code and with repeated calls is not good to inline because it might
cause performance issues thats why we are using noinline keyword
inline fun with return will stop the flow of execution
 */


//inline with two actions

inline fun twoActions(someBody: () -> Unit,anotherBody:()->Unit){
    someBody()
    anotherBody()
}
//the noinline is used to remove the inline property
// It prints the same but in the decompile it creates a seperate call.


//calling inline fun from another

fun call(f:()->Unit){}
inline fun callNonInlineFun(crossinline someBody: () -> Unit){
    call { someBody() }//it gives a error that this may contain non-local return to avoid this we need to
    //add a keyword called crossinline or make the call method inline
}

//let-> only used to get the non null values from the list of non null values and null values
//also-> do some additional operations with null values
//run->