package com.example.androiduibasics.kotlinTesting

open class Car constructor(val gears:Int) :Automobile() {


    init {
        println("Hi I am Initialised" + gears)
    }


  constructor(gears: Int,name:String):this(5){

      println("Hi I am Initialised" +gears )
  }


     override fun tryGears(){

    }

}