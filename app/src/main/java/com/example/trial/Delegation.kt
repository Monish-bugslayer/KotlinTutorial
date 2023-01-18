package com.example.trial

//Delegation is applicable only to interfaces
//doing a job with the help of another object
interface DelegationInterface{
    fun print()
}


class Delegation(val name:String):DelegationInterface{
    override fun print() {
        println(name)
    }
}
class Delegate(obj:DelegationInterface):DelegationInterface by obj{
    fun printText() {
        println("Delegate class by means of printText method")
    }

    override fun print() {
        println("Delegate class by means of print method")
    }
}

val lazyValue: String by lazy {
    println("computed!")
    "Hello"
}


fun main(){
    var delegation:Delegation= Delegation("Delegation class")
    Delegate(delegation).print()//it prints delegate class because it overrides the print method
    Delegate(delegation).printText()//it also prints delegate class
    delegation.print()//prints the name given in delegation class
    println(lazyValue)
    println(lazyValue)
}

