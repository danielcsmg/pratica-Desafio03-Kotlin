package menu

import carrinho.Carrinho
import menu.Utils.FuncoesMenu.escolherItem
import pagamento.Pagamento
import kotlin.system.exitProcess

class Menu(private val carrinho: Carrinho, private var pagamento: Pagamento) {
    init {
        menu()
    }
    private fun menu(){
        while (true){
            println("Para adicionar um item ao carrinho, digite [a] ou [adicionar]:")
            println("Para editar a quantidade de um item do carrinho, digite [e]ou [editar]:")
            println("Para mostrar o pedido, digite [m] ou [mostrar]:")
            println("Para remover um item, digite [r] ou [remover]:")
            println("Para pagar o pedido, digite [p] ou [pagar]:")
            println("Para remover um item, digite [s] ou [sair]:")
            val opcao = readln().lowercase()
            when(opcao){
                "a", "adicionar" -> {
                    val produto = escolherItem()
                    carrinho.adicionarItemPedido(produto)
                }
                "m", "mostrar" -> carrinho.mostrarCarrinho()
                "e", "editar" -> carrinho.editarItemPedido()
                "r", "remover" -> {
                    carrinho.removerItemPedido()
                    carrinho.mostrarCarrinho()
                }
                "p", "pagar" -> {
                    carrinho.mostrarCarrinho()
                    pagamento.pagarPedido()
                }
                "s", "sair" -> exitProcess(0)
                else -> println("Opção inválida! Tente novamente.")
            }
        }
    }
}