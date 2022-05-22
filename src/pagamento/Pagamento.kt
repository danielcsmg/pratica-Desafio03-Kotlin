package pagamento

import pagamento.Utils.FuncoesPagamento.calcularTotalPedido
import pagamento.Utils.FuncoesPagamento.receberDinheiro
import pedido.Pedido
import kotlin.system.exitProcess

class Pagamento(private val pedido: Pedido) {
    private var totalPedido = calcularTotalPedido(pedido)
    private var pedidoNaoFeito = calcularTotalPedido(pedido) <= 0.0


    private fun mostrarTotalPedido() {
        println("O total a pagar é R$${"%.2f".format(totalPedido)}")
    }

    fun pagarPedido() {
        if (verificarStatusPedido()) {
            return
        }
        mostrarTotalPedido()
        var pagamentoConcluido = false
        println("------Sessão de Pagamentos------")
        while (!pagamentoConcluido) {
            println("Escolha a forma de pagamento:")
            println("[1] para pagar em dinheiro;")
            println("[2] para pagar no cartão;")
            println("[3] para pagar com vale-alimentação;")
            println("[4] para sair.")
            val opcao = readln().toIntOrNull()
            when (opcao) {
                1 -> {
                    pagamentoConcluido = pagarEmDinheiro()
                }
                2 -> {
                    pagamentoConcluido = pagarNoCartao()
                }
                3 -> {
                    pagamentoConcluido = pagarComValeAlimentacao()
                }
                4 -> exitProcess(0)
                else -> println("Opção inválida! Tente novamente.")
            }
        }
        exitProcess(0)
    }

    private fun verificarStatusPedido(): Boolean {
        totalPedido = calcularTotalPedido(pedido)
        pedidoNaoFeito = calcularTotalPedido(pedido) <= 0.0
        if (pedidoNaoFeito) {
            println("Faça o pedido antes de pagar.")
        }
        return pedidoNaoFeito
    }

    private fun pagarComValeAlimentacao(): Boolean {
        println("Pedido pago com vale-alimentação.")
        println("Pedido concluído. Bom apetite!")
        return true
    }

    private fun pagarNoCartao(): Boolean {
        println("Pedido pago no cartão.")
        println("Pedido concluído. Bom apetite!")
        return true
    }

    private fun pagarEmDinheiro(): Boolean {
        val dinheiroRecebido = receberDinheiro()
        if (totalPedido > dinheiroRecebido) {
            println("Valor insuficiente para o pagamento. Tente novamente.")
            return false
        }
        if (totalPedido < dinheiroRecebido) {
            val troco: Double = dinheiroRecebido - totalPedido
            println("Seu troco é de R$${"%.2f".format(troco)}")
        }
        println("Pedido pago no dinheiro.")
        println("Pedido concluído. Bom apetite!")
        return true
    }
}