package org.iesra.revilofe

class Pila<T> : Iterable<T>{
    private var pila = mutableListOf<T>()
    constructor(){
        pila = mutableListOf()
    }

    fun push(elemento : T){
        pila.add(elemento)
    }

    fun pop(){
        pila.removeAt(pila.lastIndex)
    }

    fun peek() : T?{
       return pila[pila.lastIndex]
    }

    fun isEmpty() : Boolean{
        return if(pila.size == 0) true
        else false
    }

    fun size() : Int{
        return pila.size
    }


}