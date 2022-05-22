package carrinho

import constantes.MSG_CODIGO
import constantes.MSG_QTD

class Utils {
    companion object FuncoesCarrinho{
        private fun getValor(msg: String): Int {
            println(msg)
            return readln().toIntOrNull() ?: 0
        }

        fun verificarQuantidade(): Int{
            var qtd = getValor(MSG_QTD)
            while(qtd <= 0){
                println("Valor inválido. Tente novamente.")
                qtd = getValor(MSG_QTD)
            }
            return qtd
        }

        fun verificarCodigo(): Int{
            var valor = getValor(MSG_CODIGO)
            while(valor <= 0){
                println("Valor inválido. Tente novamente.")
                valor = getValor(MSG_CODIGO)
            }
            return valor
        }
    }
}