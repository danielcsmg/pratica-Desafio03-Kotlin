package pagamento

import pedido.Pedido

class Utils {
    companion object FuncoesPagamento{
        fun calcularTotalPedido(pedido: Pedido): Double{
            var total = 0.0
            pedido.getPedido().forEach{ (produto, qtd) ->
                total += produto.getPreco() * qtd
            }
            return total
        }

        fun receberDinheiro(): Double{
            println("Pagamento em dinheiro.")
            println("Insira o valor:")
            val dinheiro = readln().toDoubleOrNull() ?: -1.0
            if(dinheiro <= 0.0){
                println("Dado inválido! Tente novamente.")
                receberDinheiro()
            }
            return dinheiro
        }
    }
}