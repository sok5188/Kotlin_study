package com.example.prac_kotlin

data class Car(val horse:Int)

object CarFactory{
    val cars= mutableListOf<Car>()
    fun makecar(horse: Int):Car{
        val car=Car(horse)
        cars.add(car)
        return car
    }
}

fun main(){
    val car=CarFactory.makecar(10)
    val car2=CarFactory.makecar(22)

    println(car)
    println(car2)
    println(CarFactory.cars.toString())
}