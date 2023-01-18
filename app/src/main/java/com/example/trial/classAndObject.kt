package com.example.trial

import kotlin.concurrent.thread

/* Class is a object constructor
it is also defined as a blueprint or template of an object
logical entity that does not occupy any space or memory
 */
open class Mobile:Thread(){
    /*Class Attributes they are called fields. In java these are called as variables
     There are 3 types of variables in java
     Local variable -> Declared within the methods
     Static variable -> can be called directly with the help pf class name
     Instance variable -> created inside the class but outside the class methods
     They can be called before object of the class is instantiated
     method doesn't need to access any stored values, a static method is appropriate
     In kotlin these variables that are declared outside the method and inside the class are called as properties
     Classes can also have another class in it
     */
   open var password:String="****"
    var batteryPercentage:Int=0
    var lockSensor:Boolean=false
    //like static variables
    companion object{
        var modelNumber:Int=1234
    }
    fun unlock(){
        lockSensor=true
    }
    fun takePicture(){
        println("Capturing")
    }

    open fun displayPhoto(){
        println("Displaying Photo")
    }
    fun chargeMobile(){
        batteryPercentage++
    }

}

/* Constructor is used to initialize the object. The constructor when the object is created .In kotlin
* we can create constructor either within the class itself or we can define it saperately
* Multiple ways to initialize objects according to the number of arguments passes while declaration
* There is a keyword called lateinit where we can initilize a variable for future use case*/

class Car{
    constructor(){
        //default Constructor
    }
    constructor(modelNumber:Int):this(type = "diesel",modelNumber, modelName = "BMW"){

        //When i call this constructor the constructor that is defined in this wil execute first then
        //the constructor call will execute
    }
    constructor(modelName:String){

    }
    constructor(modelName: String,modelNumber: Int){

    }
    constructor(type:String,modelNumber: Int,modelName: String){
        println("All data")

    }

//    override fun toString(): String {
//        return "modelName: "
//    }
}


/*
Abstract class : The abstract class is used to hide the unwanted content and show only the necessary details to
the user.
Abstract class have abstract methods and non abstract methods
abstract methods are methods that does not have any implementation
We cannot create object for abstract classes
It can have constructors and static methods
*/

class SimpleCalculator: Calculator(10) { //->if it has constructor it need to be given in the abstract class brackets
    override fun add(a:Int,b:Int) :Int{
        return a+b
    }
    override fun sub(a:Int,b:Int) :Int{
        return a-b
    }
}
abstract class Calculator{

    constructor(n:Int){
        println(n)
    }
    companion object{//static object
        fun div(){
            println("division")
        }
    }
    abstract fun add(a:Int,b:Int):Int
    abstract fun sub(a:Int,b:Int):Int
}


//Singleton class
object single {
    fun display(){
        println("Singleton")
    }
}


/* data classes has some special methods like copy componentN() and so on.
* When i create two object with same data in case of ordinary class when we compare these two objects it will
* say both are not same because it deals with object , it simnply creates two objects inside heap memory.
* but in case of data it deals with the data and it says both are same
* ComponentN are the properties that we hve inside the constructor
* We cant inherit two data classes*/
data class DataClass(var data:String){

}
data class User(var name:String){
    fun getName(){
        println(name)
    }
}

/* Sealed class it is like an abstract class. It cannot be instantiated directly
Sealed class can be inherited within the same file not from other files
they can be abstract and can have abstract methods
,it can also have proterties
sealed classes can have generics
sealed classes can have instance specific data
 */

sealed class Data(){
    data class Success(var data:String):Data()
    data class Failure(var ErrorStatus:String):Data()
    object  Loading:Data()

}
fun getData():Data{
    return Data.Success((100..1000).random().toString())
}


//It is instance specific data we can have different models to different bmw cars
sealed class Cars(model:String){
    class BMW(model:String):Cars(model)
}


fun main(){
    var dataStatus=getData()
    when(dataStatus){
        Data.Loading->{"Loading"}
        is Data.Success->{println("Successfully fetched " +
                "${dataStatus}")}
        is Data.Failure->{"Failed to fetch"}

    }
}

