package org.iesra.revilofe.un4.eje4_4
class Pila<T> : Iterable<T>{
    private var pila = mutableListOf<T>()

    override fun iterator(): Iterator<T> {
        return object : Iterator<T>{
            var puntero : Int = pila.size - 1

            override fun hasNext(): Boolean {
                return puntero >= 0
            }

            override fun next(): T {
                val elemento = pila[puntero]
                puntero -= 1
                return elemento
            }
        }
    }

    fun push(elemento : T){
        pila.add(elemento)
    }

    fun pop() : T{
        if(isEmpty()) throw NoSuchElementException()
        return pila.removeAt(pila.lastIndex)
    }

    fun peek() : T{
        if (isEmpty()) throw NoSuchElementException()
        return pila[pila.lastIndex]
    }

    fun isEmpty() : Boolean{
        return pila.isEmpty()
    }

    val size : Int
        get() = pila.size
}

fun <T> reverse(origen : List<T>) : List<T>{
    val pila = Pila<T>()
    val listaInvertida : MutableList<T> = mutableListOf()
    val iteradorLista = origen.iterator()
    while(iteradorLista.hasNext()){
        pila.push(iteradorLista.next())
    }

    for(elemento in pila){
        listaInvertida.add(elemento)
    }
    return listaInvertida.toList()
}

fun main() {
    val numbers = listOf("one", "two", "three", "four")
    val numbersRev = reverse(numbers)

    if (listOf("four", "three", "two", "one") != numbersRev) {
        println("Error")
    } else {
        println("Correcto")
    }

    println(numbersRev)
}