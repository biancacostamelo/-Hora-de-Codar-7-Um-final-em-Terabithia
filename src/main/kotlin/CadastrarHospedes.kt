package Hotel

import kotlin.system.exitProcess

fun cadastrarHospedes() {
    val listaHospedes = mutableListOf(
        "Carlos Villagran", "Maria Antonieta de las Nieves", "Roberto Gómez Bolaños", "Florinda Meza", "Ramón Valdés", "Rubén Aguirre", "Angelines Fernández", "Edgar Vivar", "Horácio Gómez Bolaños", "Raúl Padilla"
    )

    while (true) {
        println("""Cadastro de Hóspedes
            Selecione uma opção:
            1. Cadastrar
            2. Pesquisar
            3. Sair""")

        val escolha = readLine()?.toIntOrNull()

        when (escolha) {
            1 -> cadastrarHospede(listaHospedes)
            2 -> pesquisarHospede(listaHospedes)
            3 -> sairCadastroDeHospedes()
            else -> erroCadastroDeHospedes()
        }
    }
}

fun cadastrarHospede(listaHospedes: MutableList<String>) {
    var totalHospedes = 0
    var meia = 0
    var gratis = 0
    var total = 0.0

    print("Qual o valor da diária? ")
    val valorDiaria = readLine()!!.toFloat()

    while (true) {
        println("\nCadastro de Hóspedes.\nDigite o nome do hóspede (ou 'pare' para encerrar):")
        val novoHospede = readLine().orEmpty()

        if (novoHospede.equals("pare", ignoreCase = true)) {
            break
        }

        print("Qual a idade do hóspede? ")
        val idadeHospede = readLine()?.toIntOrNull()

        if (idadeHospede != null) {
            when {
                idadeHospede <= 6 -> {
                    println("Tem direito a gratuidade")
                    gratis++
                }
                idadeHospede >= 60 -> {
                    println("Tem direito a meia entrada")
                    total += valorDiaria / 2
                    meia++
                }
                else -> {
                    total += valorDiaria
                }
            }
            listaHospedes.add(novoHospede)
            totalHospedes++
            println("$novoHospede cadastrado com sucesso!")
        } else {
            println("Idade inválida, tente novamente.")
        }
    }

    println("\n--- RESUMO ---")
    println("Total de hóspedes: $totalHospedes")
    println("Com gratuidade: $gratis")
    println("Com meia: $meia")
    println("Valor total arrecadado: R$ $total")
    println("Lista de hóspedes: $listaHospedes")
}


fun pesquisarHospede(listaHospedes: MutableList<String>) {
    println("Pesquisa de Hóspedes.\nPor favor, informe o nome do Hóspede:")
    val nomeHospede = readLine()?.trim() // remove espaços extras

    if (nomeHospede.isNullOrBlank()) {
        println("Você não digitou nenhum nome.")
        return
    }

    val encontrados = listaHospedes.filter { it.contains(nomeHospede, ignoreCase = true) }

    if (encontrados.isNotEmpty()) {
        println("\nEncontramos a(s) hóspede(s):")
        encontrados.forEach { println(it) }
    } else {
        println("Não encontramos nenhuma hóspede com esse nome.")
    }
}


fun sairCadastroDeHospedes() {
    println("Você deseja sair? S/N")
    val escolha = readLine()

    if (escolha != null) {
        when (escolha.uppercase()) {
            // uppercase fará o que for digitado ser convertido para maiúsculo por exemplpo x -> X
            "S" -> {
                println("Hasta la vista, Baby.")
                println("Muito obrigado e até logo, $nomeUser")
                exitProcess(0)
            }
            "N" -> {
                println("Ok, voltando ao início.")
                cadastrarHospedes()
            }
            else -> {
                println("Desculpe, mas não compreendi.")
                sairCadastroDeHospedes()
            }
        }
    }
}

fun erroCadastroDeHospedes() {
    println("Por favor, informe um número entre 1 e 3.")
}