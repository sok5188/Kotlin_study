package com.example.prac_kotlin

data class Airticket(val company_name:String , val cus_name:String, var date:String, var seat:Int)
//toString(), hashCode(),equals(),copy()가 자동 생성됨
class nom_Airticket(val company_name:String , val cus_name:String, var date:String, var seat:Int)
fun main(){
    val ticketA=Airticket("Korean","Sirong","2022-09-24",33)
    val ticketB=nom_Airticket("Korean","Sirong","2022-09-24",33)

    println(ticketA)
    println(ticketB)
}