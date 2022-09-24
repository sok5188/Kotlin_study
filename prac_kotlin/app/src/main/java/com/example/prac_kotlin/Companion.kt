package com.example.prac_kotlin

class Book private constructor(val id: Int, val name: String){
    companion object BookFac:Idprovider{
        override fun getId(): Int {
            return 321
        }
        val mybook="name"
        fun create()=Book(30,mybook)
    }
}

interface Idprovider{
    fun getId() :Int
}
fun main(){
    val b=Book.create()
    val bkid=Book.getId()
    println("${b.id} / "+b.name)
    println(bkid)
}