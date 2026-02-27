package org.iesra.revilofe

class Pila<T> : Iterable<T>{
    private var pila = mutableListOf<T>()

    override fun iterator(): Iterator<T> {
        return object : Iterator<T>{
            var puntero : Int = pila.size

            override fun hasNext(): Boolean {
                return puntero >= 0
            }

            override fun next(): T {
                puntero -= 1
                return pila[puntero]
            }
        }
    }

    fun push(elemento : T){
        size += 1
        pila.add(elemento)
    }

    fun pop() : T?{
        if(isEmpty()) return null
        size -= 1
        return pila.removeAt(pila.lastIndex)
    }

    fun peek() : T?{
        if (isEmpty()) return null
        return pila[pila.lastIndex]
    }

    fun isEmpty() : Boolean{
        return pila.isEmpty()
    }

    var size : Int = pila.size

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