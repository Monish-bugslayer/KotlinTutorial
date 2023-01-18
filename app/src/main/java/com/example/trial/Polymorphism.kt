package com.example.trial

import java.text.DecimalFormat

/*A person at the same time can have different characteristics.
 Like a man at the same time is a father, a husband, an employee.
 So the same person possesses different behavior in different situations.
 This is called polymorphism.
 There are two types of polymorphism:
 1) Run-time polymorphism
 2) Compile time polymorphism
 */
 //In compile time polymorphism the name of the methods is same only the type of the
// parameter is different

class Polymorphism{
    val df:DecimalFormat=DecimalFormat("#.##")
    fun convertToDouble(a:Int):Double{
        return df.format(a).toDouble()
    }
    fun convertToDouble(a:Float):Double{
        return df.format(a).toDouble()
    }
}

/* Runtime Polymorphism :
Method overriding is called runtime polymorphism because JVM only decides which object to run at the run time only
 */

open class Vehicle{
    open fun run(){
        println("Car is running")
    }
}
class MotorBike:Vehicle(){
    override fun run(){
        println("Bike is running")
    }
}
class Lorry:Vehicle(){
    override fun run(){
        println("Lorry is running")
    }
}
class RuntimePolymorphism{
    fun drive(obj:Vehicle){
        obj.run()
    }
}
fun main(){
    var poly:Polymorphism= Polymorphism()
    var runtimePolymorphism:RuntimePolymorphism=RuntimePolymorphism()
    var motorBike:Vehicle=MotorBike()
    runtimePolymorphism.drive(motorBike)
}