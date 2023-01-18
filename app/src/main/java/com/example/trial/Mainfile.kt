package com.example.trial

import android.provider.ContactsContract.CommonDataKinds.Im

fun main(){
    var mobile:Mobile=Mobile()

//    var tata:Car=Car("petrol",12,"harrier")
    var tata1:Car=Car(123)
    var testing:User=User("Monish")
    testing.component1()
    var simpleCalculator:Calculator=SimpleCalculator()
    Calculator.div()//calling the static object of the abstract class
    simpleCalculator.add(10,20)
    var iphone:Mobile=IPhone()
    iphone.displayPhoto()

    var single=single
    var single1=single
    var k= arrayListOf<Int>()
    var dog:Dog=Dog()


    //scope funtions
    //let fun
    var n:Int?=null
    val x=n?.let { it+1 }?:3//prints the value if it is not null else it prints 3
    println(x)

    //also fun
    var i=0
    println(i)//here i is 0
    fun getSquaredI()=(i*i).also { i++ }//we get the squared of i also we add i++
    println(getSquaredI())
    println(i)//i turns to 1


    //apply is used to do some changes in the objects . Instead of doing staff.firname=this,staff.lasname=this
    //we can use apply function and change whatever changes we want to do with the data
    var staff:Staff= Staff("Monish","Kumar",21)
    staff.apply { firsName="Sarath"
    lastName=""
    age=22}
    println(staff.firsName)
    //run is also do the same job as apply but run returns a unit and apply returns the same object
    //with is also same as run

}
/*private fun foo() { ... } // visible inside the same file

public var bar: Int = 5 // property is visible everywhere
    private set         // setter is visible only in particular file

internal val baz = 6    // visible inside the same module

 */

data class Staff(var firsName:String,var lastName:String,var age:Int){

}