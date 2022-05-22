import carrinho.Carrinho
import menu.Menu
import pagamento.Pagamento
import pedido.Pedido

fun main(){
    val pedido = Pedido()
    val carrinho = Carrinho(pedido)
    val pagamento = Pagamento(pedido)
    Menu(carrinho, pagamento)
}