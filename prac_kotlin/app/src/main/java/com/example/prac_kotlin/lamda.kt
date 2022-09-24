package com.example.prac_kotlin

val sqr:(Int)->Int={num->num*num}
val nameage={name:String,age:Int -> "my name is : ${name} age is ${age}"}
fun main(){
//    println(sqr(12))
//    println(nameage("sirong",25))
//    var a="he said"
//    var b="she said"
//    println(a.pizza())
//    println(b.pizza())
//    println(extst("sirogn",33))
//    println(calc(80))
//    println(calc(111))
//    println(calc(20))
    val lam={num:Double ->
        num==4.3213
    }
    println(invokeLamda(lam))
    println(invokeLamda({it>3.22}))
    println(invokeLamda { it>3.22 })

}

val pizza:String.()->String={this+"pizza is good"}

fun extst(name:String,age:Int):String{
    val intro : String.(Int)->String={"I am ${this} and ${it}years old"}
    return name.intro(age)
}

val calc : (Int)->String={
    when(it){
        in 0..40 -> "F"
        in 41..70 -> "Cool"
        in 71..100->"Great"
        else ->"Err"
    }
}
fun invokeLamda(lamda:(Double)->Boolean):Boolean{
    return lamda(5.2343)
}