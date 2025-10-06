package Hotel

//import kotlin.system.exitProcess

fun arCondicionado(){
        val orcamentos = mutableListOf<Pair<String, Double>>()

        do {
            print("Qual o nome da empresa? ")
            val nomeEmpresa = readLine().orEmpty()

            print("Qual o valor por aparelho? ")
            val valorPorAparelho = readLine()?.toDoubleOrNull() ?: 0.0

            print("Qual a quantidade de aparelhos? ")
            val qtdAparelhos = readLine()?.toIntOrNull() ?: 0

            print("Qual a porcentagem de desconto? ")
            val descontoPercentual = readLine()?.toDoubleOrNull() ?: 0.0

            print("Qual o número mínimo de aparelhos para conseguir o desconto? ")
            val minimoParaDesconto = readLine()?.toIntOrNull() ?: 0

            val totalSemDesconto = valorPorAparelho * qtdAparelhos

            val totalComDesconto = if (qtdAparelhos >= minimoParaDesconto && minimoParaDesconto > 0) {
                totalSemDesconto - (totalSemDesconto * descontoPercentual / 100)
            } else {
                totalSemDesconto
            }

            println("O serviço de $nomeEmpresa custará R$ ${"%.2f".format(totalComDesconto)}")

            orcamentos.add(nomeEmpresa to totalComDesconto)

            print("Deseja informar novos dados? (S/N): ")
            val continuar = readLine()?.trim()?.uppercase()

        } while (continuar == "S")

        val menorOrcamento = orcamentos.minByOrNull { it.second }

        if (menorOrcamento != null) {
            println("O orçamento de menor valor é o de ${menorOrcamento.first} por R$ ${"%.2f".format(menorOrcamento.second)}")
        } else {
            println("Nenhum orçamento foi informado.")
        }


}