package com.example.trial

/*
Inheritance means sharing the functionality between the classes
The reason for inheritance is for Method Overriding and for code reusability
We can also override properties.
We can only inherit two classes if we have is a relationship
There are 4 types of Inheritance

Single Inheritance
Multilevel Inheritance
Hierachical Inheritance
Multiple Inheritance

 */

//Single Inheritance
class IPhone: Mobile() { //-> IPhone is inherited Mobile because IPhone is a Mobile
    override fun displayPhoto() {
        println("IPhones display")
    }
        //when overriding parent class methods we have to make the method open.
        //when there is no need to do changes in the parent class method we can use super.methodName
        //to call the method
    }

//Whenever one class object is used in another class then it is called has a relationship
class Engine{
    fun start(){
        println("Engine Started")
    }
}
class Bike(engine:Engine){
    var engine:Engine
    init {
        this.engine=engine
    }
    fun start(){
        engine.start()
        println("Bike starts")
    }
}

//Hierachial inheritance

open class RedMi:Mobile(){

}
class OnePlus:Mobile(){

}
class RealMe:Mobile(){

}
class POCO:RedMi(){

}

//Multilevel inheritance

open class Animal{
    fun run(){

    }

}
open class Dog:Animal(){
    private var name:String="Mark"
    protected var age:Int=2

}
class Labrador:Dog(){
    fun getName(){
//        println(name)

    }

    //with this method we can access the functionalities of Dog and Animal
}


//calling super class method in innner class
//we cannot overide draw outer class method in a inner class method
open class Rectangle {
    open fun draw() { println("Drawing a rectangle") }
    val borderColor: String get() = "black"
}
class FilledRectangle: Rectangle() {
    override fun draw() {
        val filler = Filler()//->inner class object
        filler.drawAndFill()
    }

    inner class Filler {
        fun fill() { println("Filling") }
        fun drawAndFill() {
            super@FilledRectangle.draw() // Calls Rectangle's implementation of draw()
            fill()
            println("Drawn a filled rectangle with color ${super@FilledRectangle.borderColor}") // Uses Rectangle's implementation of borderColor's get()
        }
        fun draw(){
            println("Inner Draw")
        }
    }
}

