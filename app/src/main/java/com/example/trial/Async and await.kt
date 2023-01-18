package com.example.trial

import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis

//when there are several functions in a coroutine and when they execute at the same time
//by default it will execute in sequence first fun will execute first and second will execute next

object AsyncAwait{
    inline fun createCoroutine(someBody:()->Unit){someBody()}
    inline suspend fun networkCall1(someBody: () -> String){delay(1000);println(someBody())}
    inline suspend fun networkCall2(someBody: () -> String){delay(1000);println(someBody())}
    //the time taken to execute the two calls is 1s
}

object NoAsyncAwait{
    inline fun createCoroutine(someBody:()->Unit){someBody()}
    inline suspend fun networkCall1(someBody: () -> String){delay(1000);println(someBody())}
    inline suspend fun networkCall2(someBody: () -> String){delay(1000);println(someBody())}
}
fun main(){
    AsyncAwait.createCoroutine {
        GlobalScope.launch(Dispatchers.IO) {
            val time=measureTimeMillis {
                val call1=async {  AsyncAwait.networkCall1 {"Async NetworkCall 1"} }//waits till the network 1 call is completed
                val call2=async {AsyncAwait.networkCall2 {"Async NetworkCall 2"} }
                call1.await()
                call2.await()
            }

            println("Async time = ${time}")//takes only 1 sec to complete both the task
        }
    }
    NoAsyncAwait.createCoroutine{
        GlobalScope.launch(Dispatchers.IO) {
            val time=measureTimeMillis {
                val job1=launch{
                    NoAsyncAwait.networkCall1 {"launch NetworkCall 1"}
                    NoAsyncAwait.networkCall2 {"launch NetworkCall 2"} }
                job1.join()
            }
            println("Launch time = ${time}")//takes 2 sec to complete both the task
        }
    }
    Thread.sleep(3000)
}

