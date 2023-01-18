package com.example.trial

/* In kotlin or in java Multiple inheritance is not supported
Consider a scenario where A, B, and C are three classes.
The C class inherits A and B classes.
If A and B classes have the same method and if we call it from C class object,
there will be a confusion to call the method of A or B class.
 */

open class Father{
    fun work(){

    }
}

open class Mother{
    fun work(){

    }
}

/*class child:Father(),Mother(){}
if we try to do this it will give an error like only once class be super class
Inorder to acheive this scenario there is concept called interface

interface is a blueprint of a class .Interface methods may or may not have a  body.
they can have properties but we cannot initialize them
 */

interface Animals {
//    var name:String="Monish"
    var organismCatogery: String
    val typeOfOrganism: String//-> if u want to implement a property in interface it should be final
        get() = "Living Organism"
    fun animalSound()
    fun liveOn()
    fun sleep(){
        println("Sleeping")
        //We can initialized variables inside the body of the method
        //We can also initialize the not initialized property inside the interface methods
    }
    fun run(){
        println("Animal Running")
    }

}

internal interface Humans{
    fun run(){
        println("Human running")
    }
}

//If a class implements a interface it must override all the methods which are without body in the interface
//If both the interface has common methods then although if the method has a body we have to implement that method.
class LivingOrganism(override var organismCatogery: String) :Animals,Humans{
    override fun animalSound() {}
    override fun liveOn() {/*We have have the required body here*/}
    override fun run() {

    }

}
