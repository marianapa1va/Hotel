import kotlin.system.exitProcess

class usuario() {

    private var nome = ""

   fun dados(){

       inicio_do_acesso()
       menu()

   }

    fun inicio_do_acesso() {

        println("Olá, seja bem-vindo(a) ao Hotel Céu,")
        println("onde os seus sonhos, se tornam realidade!.")
        Thread.sleep(2000)

        println("Qual o seu nome? ")
        this.nome = readln().trim()

        println("Para continuar, informe a senha: ")
        val senha = readln().trim().toInt()

        if (senha == 2678) {

            println("Acesso liberado!")

        }
        else {
            println("Senha incorreta!")
            return
        }



    }

    fun menu() {

        Thread.sleep(2000)
        var continuar = true

        while (continuar) {
            Thread.sleep(2000)

            println(
                """
            Escolha uma ação:
            
            1 -> Reserva de quartos
            2 -> Cadastros de hóspedes
            3 -> Reservas para eventos
            4 -> Abastecimentos dos combustíveis
            5 -> Manutenções dos ar-condicionados
            6 -> Sair
            
        """.trimIndent()
            )

            val acao = readln().toInt()

            when (acao) {

                1 -> reserva_de_quartos()
                2 -> cadastros_dos_hospedes()
                3 -> reservas_para_eventos()
                4 -> abastecimentos_dos_combustiveis()
                5 -> manutencoes_dos_ares()
                6 -> {
                    println("Saindo...")
                    println("Muito obrigado e até logo, $nome!.")
                    exitProcess(0)
                }

                else -> println("Opção inválida!")

            }
        }
    }
    fun reserva_de_quartos() {
        println("Qual o valor padrão da diária? ")
        val diaria = readln().trim().toInt()

        if (diaria < 0){
            println("Valor inválido!")
            return
        }
        println("Quantas diárias serão necessárias? ")
        val dia = readln().trim().toInt()

        if (dia <= 0){
            println("Valor inválido!")
            return
        }

        if (dia > 20){
            println("Valor inválido!")
            return
        }

        println("Digite o número do quarto que você deseja reservar. E para encerrar, digite (pare) ")

        val quartos = mutableListOf("1" , "2", "3" , "4" , "5" , "6" , "7" , "8" , "9" , "10" ,
            "11" , "12", "13" , "14" , "15" , "16" , "17" , "18" , "19" , "20")

        while (quartos.isNotEmpty()){

        println("Quartos disponíveis: ${quartos.joinToString (",")}")
            val remover = readln().trim()

            if (remover == "pare"){
                return
            }

            if (quartos.contains(remover)){

                quartos.remove(remover)

                println("Quarto $remover reservado")
            }

            else(println("Quarto ocupado!"))

        }

    }

    fun cadastros_dos_hospedes() {

        println("""
            Escolha uma ação: 
            
            1 -> Cadastrar somente um hóspede. 
            2 -> Cadastrar mais de um hóspede. 
            
        """.trimIndent())

        val cadastro = readln().toInt()

        when(cadastro){

            1 -> cadastrar_hospede()
            2 -> cadastrar_familia()

            else -> println("Opção inválida!")
        }

    }

    fun cadastrar_hospede(){

        println("Qual o nome do hóspede? ")
        val hospede = readln().trim()

        println("Qual a idade? ")
        val idade = readln().trim().toInt()

        if (idade <= 0){
            println("Esse idade não existe!")
            return
        }

        if (idade >= 60){
            println("$hospede, paga meia.")
        }

        if (idade >= 125 ){
            println("Esse idade não existe!")
            return
        }

        println("$hospede, cadastrado com sucesso!")

    }

    fun cadastrar_familia(){

       val hospedes = mutableListOf<String>()

        while (true){

            println("""
                  Escolha uma ação: 
                  
                  1 -> Cadastrar 
                  2 -> Pesquisar 
                  3 -> Listar 
                  4 -> Sair 
                  
            """.trimMargin())

            val acao = readln().trim().toInt()

                when (acao) {
                    1 -> {
                        if (hospedes.size < 15) {

                            println("Qual o nome do Hóspede?")
                            val nomeHospede = readln().trim()

                            hospedes.add(nomeHospede)
                            println("Hóspede $nomeHospede foi cadastrado(a) com sucesso!")
                        } else {
                            println("Máximo de cadastros atingido.")
                        }
                    }
                    2 -> {
                        println("Qual o nome do Hóspede?")
                        val nomeHospede = readln().trim()

                        if (hospedes.contains(nomeHospede)) {
                            println("Hóspede $nomeHospede foi encontrado(a)!")
                        } else {
                            println("Hóspede não encontrado.")
                        }
                    }
                    3 -> {
                        println("Lista de Hóspedes:")
                        for (hospede in hospedes) {
                            println(hospede)
                        }
                    }
                    4 -> break
                    else -> println("Opção inválida.")
                }
            }
        }
    }

    fun reservas_para_eventos() {

        println("Qual o nome da Empresa que deseja realizar o evento no Hotel Céu? ")
        val nomeEmpresa = readln().trim()

        println("Qual o número de convidados para o seu evento?")
        val numConvidados = readln().trim().toInt()

        if (numConvidados > 350 || numConvidados < 1) {

            println("Número de convidados inválido.")

        }
        else {

            if (numConvidados <= 150 + 70) {

                val cadeirasExtras = if (numConvidados > 150) numConvidados - 150 else 0

                println("Use o auditório Laranja (inclua mais $cadeirasExtras cadeiras)")

            }

            else {

                println("Use o auditório Colorado")

            }

            println("Agora vamos ver a agenda do evento.")

            println("Qual o dia da semana ocorrerá o evento?")
            val dia = readlnOrNull() ?: ""

            println("Qual a hora do seu evento? (ex: 14)")
            val hora = readln().trim().toInt()

            if ((dia in listOf("segunda", "terça", "quarta", "quinta", "sexta") && hora in 7..23) ||
                (dia in listOf("sabado", "domingo") && hora in 7..15)) {

                println("Auditório reservado para $nomeEmpresa: $dia às ${hora}hs")

            }

            else {

                println("Auditório indisponível")

            }
        }

        println("O evento terá duração de quantas horas? ")
        val duracaoEvento = readln().trim().toInt()

        val garçonsNecessarios = Math.ceil(numConvidados / 12.0).toInt() + Math.ceil(duracaoEvento / 2.0).toInt()

        val custoGarçons = garçonsNecessarios * 10.50 * duracaoEvento

        println("São necessários $garçonsNecessarios garçons.")

        println("Custo: R$ $custoGarçons")

        println("Agora vamos calcular o custo do buffet do hotel para o evento.")

        val litrosCafe = numConvidados * 0.2
        val litrosAgua = numConvidados * 0.5
        val salgados = numConvidados * 7
        val custoCafe = litrosCafe * 0.80
        val custoAgua = litrosAgua * 0.40
        val custoSalgados = (salgados / 100) * 34

        println("O evento precisará de ${litrosCafe} litros de café, ${litrosAgua} litros de água, ${salgados} salgados.")

        val custoTotal = custoGarçons + custoCafe + custoAgua + custoSalgados

        println("Parte 5: Conferência")
        println("Nome da Empresa: $nomeEmpresa.")
        println("Duração do evento: $duracaoEvento H.")
        println("Quantidade de garçons: $garçonsNecessarios.")
        println("Quantidade de Convidados: $numConvidados")
        println("Custo dos garçons: R$ $custoGarçons")
        println("Custo do Buffet: R$ ${custoCafe + custoAgua + custoSalgados}")
        println("Valor total do Evento: R$ $custoTotal")

        println("Gostaria de efetuar a reserva? S/N")
        val respostaReserva = readln()

        if (respostaReserva == "S") {

            println("$nomeEmpresa, reserva efetuada com sucesso!.")

        }
        else {

            println("Reserva não efetuada.")

        }


    }


    fun abastecimentos_dos_combustiveis() {

        println("Alcool ou Gasolina?")

        println("Qual o valor do álcool no posto Wayne Oil?")
        val precoAlcoolWayne = readln().trim().toInt()

        println("Qual o valor da gasolina no posto Wayne Oil?")
        val precoGasolinaWayne = readln().trim().toInt()

        println("Qual o valor do álcool no posto Stark Petrol?")
        val precoAlcoolStark = readln().trim().toInt()

        println("Qual o valor da gasolina no posto Stark Petrol?")
        val precoGasolinaStark = readln().trim().toInt()

        val custoAlcoolWayne = precoAlcoolWayne * 42
        val custoGasolinaWayne = precoGasolinaWayne * 42
        val custoAlcoolStark = precoAlcoolStark * 42
        val custoGasolinaStark = precoGasolinaStark * 42

        if (precoAlcoolWayne <= precoGasolinaWayne * 0.7) {

            println("É mais barato abastecer com álcool no posto Wayne Oil.")

        } else {

            println("É mais barato abastecer com gasolina no posto Wayne Oil.")

        }

        if (precoAlcoolStark <= precoGasolinaStark * 0.7) {

            println("É mais barato abastecer com álcool no posto Stark Petrol.")

        } else {

            println("É mais barato abastecer com gasolina no posto Stark Petrol.")
        }
    }

    fun manutencoes_dos_ares() {

            val nomesEmpresas = mutableListOf<String>()
            val valoresTotais = mutableListOf<Double>()
            var continuar = "S"

            while (continuar.uppercase() == "S") {

                println("Qual o nome da empresa?")

                val nome = readLine() ?: ""

                println("Qual o valor por aparelho?")
                val valorPorAparelho = readln().trim().toInt()

                println("Qual a quantidade de aparelhos?")
                val quantidadeAparelhos = readln().trim().toInt()

                println("Qual a porcentagem de desconto?")
                val percentualDesconto = readln().trim().toInt()

                println("Qual o número mínimo de aparelhos para conseguir o desconto?")
                val quantidadeMinimaDesconto = readln().trim().toInt()


                var valorTotal = valorPorAparelho * quantidadeAparelhos

                if (quantidadeAparelhos >= quantidadeMinimaDesconto) {
                    valorTotal -= valorTotal * (percentualDesconto / 100)
                }

                println("O serviço de $nome custará R$ $valorTotal")

                nomesEmpresas.add(nome)
                valoresTotais.add(valorTotal.toDouble())

                println("Deseja informar novos dados? (S/N)")
                continuar = readLine() ?: "N"
            }

            var menorValor = Double.MAX_VALUE
            var nomeEmpresaMenorValor = ""

            for (i in valoresTotais.indices) {
                if (valoresTotais[i] < menorValor) {
                    menorValor = valoresTotais[i]
                    nomeEmpresaMenorValor = nomesEmpresas[i]
                }
            }

            println("O orçamento de menor valor é o de $nomeEmpresaMenorValor por R$ $menorValor")


    }

fun main(){

    usuario().dados()


}