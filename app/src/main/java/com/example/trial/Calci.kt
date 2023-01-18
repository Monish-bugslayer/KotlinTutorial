package com.example.trial
fun main(){
    var input:String=readLine()!!
    var ans:Int=input.substring(0,input.indexOf("+")).toInt()
    var l= arrayListOf<Char>()
    var modifiedInput=input.substring(input.indexOf('+'))
    for (i in modifiedInput){
        if(i.equals('+')){
            var leftInt:Int=0
            var lastIndex:Int=0
            for(j in modifiedInput.substring(modifiedInput.indexOf(i)+1)){
                var leftString=if(!j.equals('+'))j.toString() else break
                leftInt=(leftInt*10)+leftString.toInt()
                lastIndex=modifiedInput.indexOf(j)
            }
            modifiedInput=modifiedInput.removeRange(modifiedInput.indexOf(i),lastIndex+1)
            ans+=leftInt
        }
    }
    println(ans)
}

