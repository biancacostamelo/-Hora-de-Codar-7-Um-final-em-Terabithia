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
    println("[4] Cadastrar evento")
    println("[5] Serviço Ar Condicionado")
    println("[6] Sair")
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
        3 -> abastecimentoDeAutomoveis()
        4 -> cadastroEvento()
        5 -> arCondicionado()
        6 -> sairDoHotel()
        else -> erro()
    }
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