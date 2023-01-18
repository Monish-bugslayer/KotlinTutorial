package com.example.trial

import android.support.v4.os.IResultReceiver.Default
import android.util.Log
import kotlinx.coroutines.*
import kotlinx.coroutines.Dispatchers.Default
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main
import kotlin.random.Random

/* Coroutine
When our app starts it first creates a main thread . This main thread contains only small light weight operations
When heavy weight operations happens in main thread means our main thread gets blocked and our app gets crashes
In order to avoid this we will create background thread. Creating lots of background thread is also and bad idea
To solve this we will create a Coroutine for each operation in the background thread.
In case of Coroutine the app will end when main thread ends it won't wait for the background thread to complete
 */

//suspend keyword it will mark this fun that can be asynchrounous then only we can use it in coroutine
//Coroutine Scope is a way to organise grouping . Coroutine is basically grouping a bunch of job. So that
/*  There are 3 Scopes
GlobalScope:

GlobalScope is the scope that cretes a coroutine. This coroutine remains in the application until its job is done.
When the job is done the coroutine dies and when while the job is running but the application has been closed
means the coroutine is also dies since the max life of the coroutine is equal to the life of the app.
Global Scope does not return a job and we cannont cancel the entire Global scope.

LifecycleScope:

The lifecycle scope is the same as the global scope, but the only difference is that when we use the lifecycle scope,
all the coroutines launched within the activity also dies when the activity dies.
It is beneficial as our coroutines will not keep running even after our activity dies.

ViewModelScope:

It is also the same as the lifecycle scope,
only difference is that the coroutine in this scope will live as long the view model is alive.
 */
//if any one job fail we can cancel them all
//We can create a suspend fun only inside another suspend fun or inside a coroutine
//delay is used in coroutine to pause a coroutine

//Input output Network request , interacting with UI, reading and writing a file
//main ->doing work in the main thread
//default -> doing any heavy computational work
//UnConfine-> it is not confined in specific thread

//we can switch the context of the coroutine by using withContext() method
//the runblocking will block the main thread until the job of the coroutine is done
class CoroutineClass{

    private val RESULT_1:String="RESULT #1"
    val scope= CoroutineScope(Dispatchers.Default)
     fun createCoroutine(){
         runBlocking {//pause the main thread untill the coroutine completes its work
             //getting network request
             println("Out of Coroutine")
             val job = scope.launch {
                 println("In of Coroutine")
                 println(fakeAPIRequest())
             }
             job.join()
         }

    }

    private fun logThread(methodName:String){
        println("${methodName}: ${Thread.currentThread().name}")
    }
    private suspend fun getResult1FromAPI():String{
        logThread("getResut1FromAPI")
        delay(1000)
        return RESULT_1
    }
    private suspend fun fakeAPIRequest(){
        val result1=getResult1FromAPI()
        println(result1)
    }

}



suspend fun main(){
    var coroutine:CoroutineClass=CoroutineClass()
    coroutine.createCoroutine()
    GlobalScope.launch{ println(Thread.currentThread().name) }
    println(Thread.currentThread().name)//This will run on diff thread

    val request=GlobalScope.launch {//parent
        launch(Job()) {//child
            println("Job${1}")
            delay(1000)
            println("job${1} will execute even when the parent request is cancelled because it is not affected")
        }
        launch {
            delay(100)
            println("Job${2}")
            delay(1000)
            println("job${2} will not execute this line if my parent request is cancelled")
        }
    }
    delay(500)
    request.cancel()
    println("request is cancelled")
    delay(1000)

    /*A parent coroutine always waits for completion of all its children.
    A parent does not have to explicitly track all the children it launches, and it does not have to use job.join
    to wait for them at the end
     */
}