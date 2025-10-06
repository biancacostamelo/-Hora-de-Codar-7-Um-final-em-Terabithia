package Hotel

import kotlin.math.ceil

fun cadastroEvento() {
    println("Qual o número de convidados para o seu evento?")
    val convidados = readLine()?.toIntOrNull() ?: -1

    val auditorio = escolherAuditorio(convidados)
    if (auditorio == null) return
    println("Agora vamos ver a agenda do evento.\n")

    print("Qual o dia do seu evento? ")
    val dia = readLine()?.lowercase().orEmpty()

    print("Qual a hora do seu evento? ")
    val hora = readLine()?.toIntOrNull() ?: -1

    val disponivel = verificarDisponibilidade(dia, hora)
    if (!disponivel) {
        println("Auditório indisponível.")
        return
    }

    print("Qual o nome da empresa? ")
    val empresa = readLine().orEmpty()

    println("Auditório reservado para $empresa. ${dia.replaceFirstChar { it.uppercase() }} às ${hora}h.\n")

    // Parte 3 — Cálculo dos garçons
    print("Qual a duração do evento em horas? ")
    val duracao = readLine()?.toIntOrNull() ?: 0

    val (garcons, custoGarcons) = calcularGarcons(convidados, duracao)
    println("São necessários $garcons garçons.")
    println("Custo: R$ %.2f".format(custoGarcons))
    println("Agora vamos calcular o custo do buffet do hotel para o evento.\n")

    // Parte 4 — Cálculo do buffet
    val (cafe, agua, salgados, custoBuffet) = calcularBuffet(convidados)

    println(
        "O evento precisará de %.1f litros de café, %.1f litros de água e %d salgados.".format(
            cafe,
            agua,
            salgados
        )
    )

    val valorTotal = custoGarcons + custoBuffet

    println("\n--- RESUMO DO EVENTO ---")
    println("Evento no $auditorio")
    println("Nome da Empresa: $empresa")
    println("Dia: ${dia.replaceFirstChar { it.uppercase() }}, às ${hora}h")
    println("Duração do evento: ${duracao}h")
    println("Quantidade de garçons: $garcons")
    println("Quantidade de convidados: $convidados")
    println("Custo dos garçons: R$ %.2f".format(custoGarcons))
    println("Custo do buffet: R$ %.2f".format(custoBuffet))
    println("Valor total do evento: R$ %.2f".format(valorTotal))

    print("\nGostaria de efetuar a reserva? (S/N) ")
    val resposta = readLine()?.uppercase()

    if (resposta == "S") {
        println("Reserva efetuada com sucesso para $empresa!")
    } else {
        println("Reserva não efetuada.")
    }
}


    fun escolherAuditorio(convidados: Int): String? {
        if (convidados < 0) {
            println("Número de convidados inválido.")
            return null
        }
        if (convidados > 350) {
            println("Quantidade de convidados superior à capacidade máxima.")
            return null
        }

        return if (convidados <= 150) {
            println("Use o auditório Laranja")
            "Auditório Laranja"
        } else if (convidados <= 220) {
            val extras = convidados - 150
            println("Use o auditório Laranja (inclua mais $extras cadeiras)")
            "Auditório Laranja"
        } else {
            println("Use o auditório Colorado")
            "Auditório Colorado"
        }
    }

    fun verificarDisponibilidade(dia: String, hora: Int): Boolean {
        val diasSemana = listOf("segunda", "terca", "quarta", "quinta", "sexta")
        val fimDeSemana = listOf("sabado", "domingo")

        return when {
            dia in diasSemana && hora in 7..23 -> true
            dia in fimDeSemana && hora in 7..15 -> true
            else -> false
        }
    }

    fun calcularGarcons(convidados: Int, duracao: Int): Pair<Int, Double> {
        val garconsBase = ceil(convidados / 12.0).toInt()
        val adicionais = duracao / 2
        val totalGarcons = garconsBase + adicionais
        val custo = totalGarcons * 10.50 * duracao
        return Pair(totalGarcons, custo)
    }

    fun calcularBuffet(convidados: Int): Quadruple<Double, Double, Int, Double> {
        val cafe = convidados * 0.2
        val agua = convidados * 0.5
        val salgados = convidados * 7

        val custoCafe = cafe * 0.80
        val custoAgua = agua * 0.40
        val custoSalgados = (salgados / 100.0) * 34.00

        val total = custoCafe + custoAgua + custoSalgados
        return Quadruple(cafe, agua, salgados, total)
    }

    data class Quadruple<A, B, C, D>(val first: A, val second: B, val third: C, val fourth: D)