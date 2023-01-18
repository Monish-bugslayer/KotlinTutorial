package com.example.trial

import android.os.Build
import androidx.annotation.RequiresApi

/* Enums are named list of Constants
* When u have defined set of constants u will be using enums
* Enums can also inherited with interfaces
* Enums can also used to handle errors */
enum class MONTHS{
    JAN,FEB,MAR,APR,MAY,JUN,JLY,AUG,SEPT,NOV,DEC
}
//We can also pass params in enum
enum class FLOWERS (val color:String){
    ROSE("red"),JASMIN("WHITE")
    //TO GET THIS COLOR:
    //val itemColor=FLOWERS.ROSE.color
}

enum class DAYS(val isWeekend:Boolean=false){
    SUNDAY(true),
    MONDAY,
    TUESDAY,
    WEDNESDAY,
    THURSDAY,
    FRIDAY,
    SATURDAY(true)

}

//We can also hve abstract methods in enum
enum class Seasons(Weather:String){

    Summer("hot"){
        override fun fetch(){
            println("Hot days of the year")
        }
    },
    Winter("cold"){
        override fun fetch(){
            println("Cold days")
        }
    };
    abstract fun fetch()
}


//Enums with interface implementation
@RequiresApi(Build.VERSION_CODES.N)
enum class Cal:ScientificCalculator<Int> {

    PLUS {
        override fun substitute(a: Int, b: Int): Int {
            return a+b
        }

    },
    TIMES {
        override fun substitute(a:Int, b:Int):Int{
            return a*b
        }
    },
    POW{
        override fun substitute(base: Int, expo: Int): Int {
            var exponent=expo
            var power:Int=1
            while(exponent!=0){
                power*=base
                exponent-=1
            }
            return power
        }
    }

}

interface ScientificCalculator<T>{
    fun substitute(a:T,b:T):T

}
@RequiresApi(Build.VERSION_CODES.N)
fun main() {
    val a =13
    val b = 31
    println(Cal.PLUS.substitute(10,20))

}

