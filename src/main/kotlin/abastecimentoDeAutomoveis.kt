package Hotel

import kotlin.system.exitProcess

fun abastecimentoDeAutomoveis() {
    println("Qual o valor do álcool no posto Wayne Oil?")
    val alcoolWayne = readLine()?.toDoubleOrNull() ?: 0.0

    println("Qual o valor da gasolina no posto Wayne Oil?")
    val gasolinaWayne = readLine()?.toDoubleOrNull() ?: 0.0

    println("Qual o valor do álcool no posto Stark Petrol?")
    val alcoolStark = readLine()?.toDoubleOrNull() ?: 0.0

    println("Qual o valor da gasolina no posto Stark Petrol?")
    val gasolinaStark = readLine()?.toDoubleOrNull() ?: 0.0

    val tanque = 42

    val combustivelWayne = if (alcoolWayne <= gasolinaWayne * 0.7) "álcool" else "gasolina"
    val precoWayne = if (combustivelWayne == "álcool") alcoolWayne else gasolinaWayne
    val totalWayne = precoWayne * tanque

    val combustivelStark = if (alcoolStark <= gasolinaStark * 0.7) "álcool" else "gasolina"
    val precoStark = if (combustivelStark == "álcool") alcoolStark else gasolinaStark
    val totalStark = precoStark * tanque

    if (totalWayne < totalStark) {
        println("É mais barato abastecer com $combustivelWayne no posto Wayne Oil.")
    } else if (totalStark < totalWayne) {
        println("É mais barato abastecer com $combustivelStark no posto Stark Petrol.")
    } else {
        println("Os dois postos têm o mesmo custo total para abastecer.")
    }


}