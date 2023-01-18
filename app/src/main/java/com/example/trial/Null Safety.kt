package com.example.trial

fun main(){
    //Ususlly we cannot assign a property as null
    //but through this method we can assign this property to null
    var s:String?=null
    val length=if(s!=null)s.length else -1//check whether the value is null or not

    //Safe call operator (?.)-  accessing a property on a nullable variable is using the safe call operator
    println(s?.length) //prints the length if it is null it returns null
    var head:Head?=Head("allen")
    var department:Department?=Department(head,"Appex")
    var monish:Employee?=Employee(null)
    println(monish?.department?.head?.name)//chaining
    //With the help let we can extract only non null values
    var arr:Array<Int?> = arrayOf(1,2,3,null,4,5)
    for( i in arr){
        i?. let { println(it) }
    }
    //Elvis operator ( ?:)
    {
        val l: Int = if (s != null) s.length else -1
        //This is replaced by elvis operator
        val r = s?.length ?: -1

    }

    //!! operator
    {
        //it does not accept any null values
        var b=s!!.length
        //getting input from user
        var k:String?= readLine()!!   //make sure that the input is not null
    }

    //Safe cast
    {
    //Regular casts may result in a [ClassCastException] if the object is not of the target type.
    // Another option is to use safe casts that return [null] if the attempt was not successful
    }
    var a:String="Monish"
    val aInt: Int? = a as? Int
    println(aInt)


}

class Head(var name:String?){

}
class Department(var head:Head?,var name: String?){

}
class Employee(var department:Department?){

}

