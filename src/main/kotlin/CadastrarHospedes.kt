package Hotel

import kotlin.system.exitProcess

fun cadastrarHospedes() {
    val listaHospedes = mutableListOf<String>()

    while (true) {
        println(
            """
            Cadastro de Hóspedes
            Selecione uma opção:
            1. Cadastrar
            2. Pesquisar
            3. Listar
            4. Sair
        """.trimIndent()
        )

        print("Opção: ")
        when (readLine()?.toIntOrNull()) {
            1 -> cadastrar(listaHospedes)
            2 -> pesquisar(listaHospedes)
            3 -> listar(listaHospedes)
            4 -> {
                println("Encerrando o programa. Até logo!")
                exitProcess(0)
            }
            else -> println("Opção inválida! Escolha de 1 a 4.")
        }
    }
}

fun cadastrar(listaHospedes: MutableList<String>) {
    if (listaHospedes.size >= 15) {
        println("Máximo de cadastros atingido.")
        return
    }

    print("Qual o nome do hóspede? ")
    val nome = readLine()?.trim()

    if (nome.isNullOrEmpty()) {
        println("Nome inválido. Tente novamente.")
    } else {
        listaHospedes.add(nome)
        println("Hóspede $nome foi cadastrada(o) com sucesso!")
    }
}

fun pesquisar(listaHospedes: MutableList<String>) {
    print("Qual o nome do hóspede para pesquisa? ")
    val nome = readLine()?.trim()

    if (nome.isNullOrEmpty()) {
        println("Nome inválido.")
        return
    }

    if (listaHospedes.contains(nome)) {
        println("Hóspede $nome foi encontrada(o)!")
    } else {
        println("Hóspede $nome não foi encontrada(o)!")
    }
}

fun listar(listaHospedes: MutableList<String>) {
    if (listaHospedes.isEmpty()) {
        println("Nenhum hóspede cadastrado.")
    } else {
        println("\nLista de hóspedes:")
        listaHospedes.forEachIndexed { i, nome ->
            println("${i + 1}. $nome")
        }
    }
}
