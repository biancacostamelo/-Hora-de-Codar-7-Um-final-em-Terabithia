package Hotel

data class Quarto(
    val numero: Int,
    var status: String
)

fun cadastrarQuartos() {
    val quartos = List(20) { i ->
        Quarto(numero = i, status = "livre")
    }
    var loop = true

    while (loop) {
        var precoDiaria: Float?
        do {
            println("Digite o valor da diária")
            precoDiaria = readLine()?.toFloatOrNull()
        } while (precoDiaria == null || precoDiaria <= 0)

        var quantidadeDias: Int?
        do {
            println("Quantos dias irá ficar hospedado? (1–30)")
            quantidadeDias = readLine()?.toIntOrNull()
        } while (quantidadeDias == null || quantidadeDias !in 1..30)

        val precoFinal = quantidadeDias * precoDiaria
        println("O valor de $quantidadeDias de hospedagens é: $precoFinal")

        print("Digite o nome do hóspede? ")
        val nomeHospede = readLine().toString()

        println("Qual o quarto para reserva? (1 - 20)? ")
        val quartoSelecionado = readLine()!!.toInt()

        //println(quartos[quartoSelecionado])

        if (quartos[quartoSelecionado].status == "livre") {
            println("Quarto livre!!!")
            println("$nomeUser, você confirma a hospedagem para $nomeHospede por $quantidadeDias dias para o quarto $quartoSelecionado por R$ $precoFinal ? S/N")
            val resposta = readLine().toString()
            if (resposta.equals("S", ignoreCase = true)) {
                quartos[quartoSelecionado].status = "ocupado"
                println("Reserva feita para $nomeHospede,no quarto $quartoSelecionado, por $quantidadeDias, por $precoFinal")
            }
        } else {
            println("Quarto indisponível!")
        }

        println("Deseja fazer outra reserva?")
        loop = readLine().equals("S", ignoreCase = true)

    }
}