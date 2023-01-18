package com.example.trial

import kotlinx.coroutines.*
//run blocking will run on main thread itself whereas in global scope it creates a seperate thread
class CoroutineRunBlocking{
   fun createCoroutine(){
        println("Before run blocking: ${Thread.currentThread().name}")
        runBlocking {
            println("Start of Run Blocking")
            println(Thread.currentThread().name)
            //both the coroutine will execute parallely after 3s both the coroutine completes its job
            launch(Dispatchers.IO) {
                delay(3000)
                println("${Thread.currentThread().name} Coroutine 1")
            }
            launch(Dispatchers.IO) {
                delay(3000)
                println("${Thread.currentThread().name} Coroutine2")
            }
            delay(5000)
            println("End of Run Blocking")
        }
       println("After Run Blocking")
    }
    fun createGlobalScopeCoroutine(){
        println("Before Global Scope: ${Thread.currentThread().name}")
        GlobalScope.launch {
            println("Start of Global Scope")
            println(Thread.currentThread().name)
            //both the coroutine will execute parallely after 3s both the coroutine completes its job
            launch(Dispatchers.IO) {
                delay(3000)
                println("${Thread.currentThread().name} Coroutine 1")
            }
            launch(Dispatchers.IO) {
                delay(3000)
                println("${Thread.currentThread().name} Coroutine2")
            }
            delay(5000)
            println("End of Global Scope")
        }
    }
    fun join(someBody:()->Unit){
        someBody()
    }
    fun fibo(n:Int):Long{
        return if (n == 0) 0
        else if(n==1) 1
        else(fibo(n-1)+fibo(n-2))
    }
}
fun main(){
    var coroutine:CoroutineRunBlocking= CoroutineRunBlocking()
//    coroutine.createCoroutine()
//    coroutine.createGlobalScopeCoroutine()
//    Thread.sleep(6000)
    coroutine.join {
        //Whenever we launch a coroutine it returns a job
        // The join() fun will block our thread until the coroutine is finished
        println("Creating Global Scope")
        var coroutineName:String?=null
        var job=GlobalScope.async {
            coroutineName=Thread.currentThread().name
            for( i in 30..40){
                println("${i} = ${coroutine.fibo(i)}")
                delay(1000)
            }
        }
        runBlocking {
//            job.join()
            delay(2000)
            job.cancel()
            //after 2 seconds job will be cancelled
            println("job canceled")
        }
    }
}
