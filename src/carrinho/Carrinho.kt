package carrinho

import carrinho.Utils.FuncoesCarrinho.verificarCodigo
import carrinho.Utils.FuncoesCarrinho.verificarQuantidade
import pedido.Pedido
import produtos.Produto
import produtos.ProdutoOpcao.FuncoesProduto.getProdutoByCode

class Carrinho(private val pedido: Pedido) {
    fun adicionarItemPedido(produto: Produto){
        val qtd = verificarQuantidade()
        pedido.adicionarProduto(produto, qtd)
    }

    fun editarItemPedido(){
        val code = verificarCodigo()
        val produtoOpcao = getProdutoByCode(code)
        val produto = produtoOpcao?.produto

        if (produto != null) {
            val compareProdutos = pedido.compararPedido(produto)
            if(!compareProdutos) {
                println("Produto não existente no carrinho.")
            }else{
                val qtd = verificarQuantidade()
                pedido.editarProduto(produto, qtd)
            }
            return
        }
        println("O código não corresponde a nenhum produto cadastrado no sistema.")
    }

    fun removerItemPedido(){
        val code = verificarCodigo()
        val produto = getProdutoByCode(code)?.produto
        if (produto != null) {
            val compareProdutos = pedido.compararPedido(produto)
            if(!compareProdutos) {
                println("Produto não existente no carrinho.")
            }else{
                pedido.removerPedido(produto)
                println("Produto removido com sucesso")
            }
            return
        }
        println("O código não corresponde a nenhum produto cadastrado no sistema.")
    }

    fun mostrarCarrinho(){
        pedido.mostrarPedido()
        println()
    }
}