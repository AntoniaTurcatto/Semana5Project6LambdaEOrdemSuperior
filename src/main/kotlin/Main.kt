fun main() {
    //1 - Como posso usar uma função lambda para classificar uma lista em ordem crescente
    //em Kotlin?
    val lista1 = listOf(1,43,23,43)
    val crescente = {lista : List<Int> -> lista.sorted() }
    println(crescente(lista1).toString())

    //2
    val multiplicacao = {valor:Int, multiplicando:Int -> valor*multiplicando}
    val subtracao = {valor:Int, subtrador:Int -> valor-subtrador}
    println(lista1)
    println(operation(multiplicacao, lista1,2))
    println(operation(subtracao, lista1,3))

    //3 - Como posso usar uma função lambda para filtrar elementos de uma lista em Kotlin?
    val filtro = {lista:List<Any>, filter : Any -> lista.minusElement(filter)}
    println(filtro(lista1,43))

    //4 - Como posso usar uma função lambda para encontrar o maior valor em uma lista em
    //Kotlin?
    val maior = {lista:List<Int> -> lista.max()}
    println(maior(lista1))

    //5
    val adicao = {valor: Int, proximo:Int->valor+proximo}
    val multiplicacaoAll = {valor:Int,proximo:Int->valor*proximo}
    println(sumAll(lista1,adicao))
    println(sumAll(lista1,multiplicacaoAll))

    //6
    println(sumTwo(adicao,1,3))

    //7
    val repetir = {mensagem:Any, vezes:Int -> for(i in 1..vezes){ println(mensagem) } }
    println(printAgain("bom dia",4,repetir))
}



//2 - Como posso usar uma função de ordem superior para aplicar uma operação a cada
//elemento de uma lista em Kotlin?
fun operation(operacao:(Int,Int)->Int, lista:List<Int>, operador:Int):List<Int> {
    val listaFun= mutableListOf<Int>()
    for (i in 0..lista.lastIndex) {
        listaFun.add(operacao(lista[i], operador))
    }
    return listaFun
} //continua no main

//5 - Como posso usar uma função de ordem superior para somar todos os elementos de
//uma lista em Kotlin?
fun sumAll(list : List<Int>, operacao:(Int,Int)->Int):Int{
    if(list.lastIndex==0){
        return list[0]
    } else {
        val list2= list.minusElement(list[0])
        return operacao(list[0],sumAll(list2, operacao))
    }
} //continua no main

//6 - Como posso usar uma função de ordem superior para criar uma função que retorna
//a soma de dois números em Kotlin?
fun sumTwo(soma:(Int,Int)->Int, valor1:Int, valor2:Int):Int{
    return soma(valor1,valor2)
} //continua no main

//7 - Como posso usar uma função de ordem superior para imprimir uma mensagem n
//vezes em Kotlin?
fun printAgain(message:Any, times:Int, repeats:(Any,Int)->Any):Any{
    if(times==1){
        return message
    } else {
        return repeats(message,times)
    }
} //continua no main