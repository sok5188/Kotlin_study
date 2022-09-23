package com.example.prac_kotlin

open class Human(val name : String="None"){
    init{
        println("new human is made")
    }
    constructor(name : String, age:Int):this(name){
        println("my name"+name+"  and  "+age+"years old")
    }
    open fun eatcake(){
        println("delicious")
    }
}

class kor:Human(){
    override fun eatcake(){
        super.eatcake()
        println("terrible")
        println("name is "+name)
    }

}
fun main(){
//    val human=Human()
//    human.eatcake()
//    println( human.name)
    val korean=kor()
    korean.eatcake()
}
