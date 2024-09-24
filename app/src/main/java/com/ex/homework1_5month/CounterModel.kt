package com.ex.homework1_5month

import android.widget.Toast

class CounterModel {
    var count = 0

    fun increment(){
        count++
    }
    fun decrement(){
        count--
    }
    fun isOver10():Boolean{
        return count == 10
    }
    fun isOver15():Boolean{
        return count == 15

    }


}