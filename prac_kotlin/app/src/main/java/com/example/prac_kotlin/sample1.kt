package com.example.prac_kotlin

fun main(){
   ignoreNull("shsh")
}
fun add(a : Int, b: Int) : Int{
    return a+b
}
fun big(a : Int ,  b: Int) : Int = if(a>b) a else b

fun cknum(score : Int){
    when(score){
        0-> println("0")
        1-> println("1")
        else -> println("idk")
    }
    var b=when(score){
        0->"zero"
        1->"one"
        else -> "idk"
    }
}
fun array(){
    val array= arrayOf(1,2,3,"wowo")
    val list= listOf(1,2,3,"soso")
    //list[0]=2;
    var arrList= arrayListOf(1,2,"5050")
    arrList.add("hello")

}
fun forawhile(){
    val students= arrayListOf("철수","영이","훈이")
    for(name in students)
        println(name)
    var sum=0
    for(i in 1..10 step 2)
        sum+=i
    println(sum)
    var sum2=0
    for(i in 10 downTo 1)
        sum2+=i
    println(sum2)
    sum=0
    for(i in 1 until 10)
        sum+=i
    println(sum)

    for((idx,name) in students.withIndex()){
        println("${idx}번째 학생 : ${name}")
    }
}

fun nullcheck(){
    //NPE : NULL pointer Exception
    //NonNull
    var name :String="cant be null"
    var name2 : String?=null

    var n_upper=name.toUpperCase()
    var null_upper=name2?.toUpperCase()
    println(n_upper)
    println(null_upper)

    var fullname=name+(name2?:"name 2 is null")
    println(fullname)

    //!! : Not Null !!

}
fun ignoreNull(str : String?){
    val noNull:String =str!!

    val email:String?=null
    email?.let{
        println(email)
        println(it)
    }
}

