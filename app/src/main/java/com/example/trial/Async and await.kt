package com.example.trial

import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis

//when there are several functions in a coroutine and when they execute at the same time
//by default it will execute in sequence first fun will execute first and second will execute next
/* When we are using async keyword it runs the job asynchronouslly so that time taken to complie is
less than non asynchronous. for asynchronous jobs we use await keyword inorder to control the flow of
execution. When the await is called it stops until the jobs completes and after completion of the
job it goes to the next part of the code.
 */

object AsyncAwait{
    inline fun createCoroutine(someBody:()->Unit){someBody()}
    inline suspend fun networkCall1(someBody: () -> String){delay(1000);println(someBody())}
    inline suspend fun networkCall2(someBody: () -> String){delay(1000);println(someBody())}
}

object NoAsyncAwait{
    inline fun createCoroutine(someBody:()->Unit){someBody()}
    inline suspend fun networkCall1(someBody: () -> String){delay(1000);println(someBody())}
    inline suspend fun networkCall2(someBody: () -> String){delay(1000);println(someBody())}
}
fun main(){
    AsyncAwait.createCoroutine {
        GlobalScope.launch(Dispatchers.IO) {
            val time=measureTimeMillis {//gives the compilaton time
                val call1=async {  AsyncAwait.networkCall1 {"Async NetworkCall 1"} }
                val call2=async {AsyncAwait.networkCall2 {"Async NetworkCall 2"} }
                //here both the jobs completes within 1 sec because they both are started and runs
                //successfully
                call1.await()//i am calling await here to get done with the first call and moves to the next
                call2.await()//similarly i am waiting to get the second call completed
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
                    //here i have not used async await so it takes 2 seconds to  complete the execution
                job1.join()
            }
            println("Launch time = ${time}")//takes 2 sec to complete both the task
        }
    }
    Thread.sleep(3000)
}

