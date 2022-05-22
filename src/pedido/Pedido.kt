package pedido

import produtos.Produto

class Pedido {
    private val pedido: HashMap<Produto, Int> = HashMap()

    fun adicionarProduto(produto: Produto, newQtd: Int){
        val qtd = pedido[produto] ?: 0
        pedido[produto] = qtd + newQtd
    }

    fun editarProduto(produto: Produto, newQtd: Int){
        pedido[produto] = newQtd
    }

    fun removerPedido(produto: Produto){
        pedido.remove(produto)
    }

    fun mostrarPedido(){
        println("--------Detalhe do pedido--------")
        pedido.forEach{ (produto, qtd) ->
            produto.mostrarDetalheProduto(qtd)
        }
    }

    fun compararPedido(pedidoNovo: Produto): Boolean{
        var compare = false
        pedido.forEach{ (produto, _) ->
           compare = produto == pedidoNovo
        }
        return compare
    }

    fun getPedido(): HashMap<Produto, Int>{
        return pedido
    }
}