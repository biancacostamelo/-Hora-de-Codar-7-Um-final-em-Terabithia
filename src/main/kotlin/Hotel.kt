package Hotel

var nomeUser: String = ""
var hotel = "Acapulco"

fun main() {
    // Função principal que chama a função inicio().
    inicio()
}

fun inicio() {
    println("Sistema Hotel $hotel!")

    print("Digite seu nome: ")
    nomeUser = readLine().toString()

    print("Digite a senha: ")
    var senha = readLine()?.toIntOrNull()

    var count = 1
    while (senha != 2678) {
        println("Senha incorreta. tente novamete")

        println("Digite a senha")
        senha = readLine()?.toIntOrNull()

        count++
        if (count == 5) {
            println("Acesso bloqueado!")
            return
        }
    }

    println("Bem vindo ao hotel $hotel, $nomeUser")
    println("E um imenso prazer ter voce por aqui!")

    println("Escolha uma opcao:")
    println("[1] Cadastar quartos")
    println("[2] Cadastar hospedes")
    println("[3] Abastecer automovel")
    println("[4] Sair")
    //menu principal
    // A varival escolha armazena a opção escolhida pelo usuário.
    // uma variavel local é utilizada apenas dentro da função inicio().
    var escolha = readLine()?.toIntOrNull()

    while (escolha == null || escolha > 4 || escolha <= 0) {
        println("Escolha uma opção válida")
        escolha = readLine()?.toIntOrNull()
    }

    when (escolha) {
        1 -> cadastrarQuartos()
        2 -> cadastrarHospedes()
        3 -> AbastecimentoDeAutomoveis()
        4 -> sairDoHotel()
        else -> erro()
    }
}

data class Quarto(
    val numero: Int,
    var status: String
)

fun cadastrarQuartos() {
    val quartos = List(20) { i ->
        Quarto(numero = i, status = "livre")
    }
    // pegar dados do usuario(preço diario, quarto, nome, etc...)
    var loop = true

    while (loop) {
        var precoDiaria: Float?
        do {
            println("Digite o valor da diária")
            precoDiaria = readLine()?.toFloatOrNull()
        } while (precoDiaria == null || precoDiaria <= 0)

        // leitura e validação da quantidade de dias
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

fun AbastecimentoDeAutomoveis() {

}

fun erro() {
    inicio()
}

fun sairDoHotel() {
    println("Você deseja sair?")
    val confirma = readLine().toBoolean()
    if (confirma) {
        println("Muito obrigado e até logo, $nomeUser")
        println("Ate logo!")
    } else {
        inicio()
    }
}