package menu

import produtos.Produto
import produtos.ProdutoOpcao

class Utils {
    companion object FuncoesMenu {
        fun escolherItem(): Produto {
            while (true) {
                println("O que deseja inserir ao carrinho?")
                println("[1] Lanche:")
                println("[2] Bebida:")
                val opcao = readln().toIntOrNull()
                when (opcao) {
                    1 -> {
                        return opcaoLanche()
                    }
                    2 -> {
                        return opcaoBebida()
                    }
                    else -> println("Opção inválida. Tente novamente.")
                }
            }
        }

        private fun opcaoLanche(): Produto {
            while (true) {
                println("O que deseja inserir ao carrinho?")
                println("[1] X-Burguer:")
                println("[2] X-Salada:")
                val opcao = readln().toIntOrNull()
                when (opcao) {
                    1 -> {
                        return ProdutoOpcao.XBURGUER.produto
                    }
                    2 -> {
                        return ProdutoOpcao.XSALADA.produto

                    }
                    else -> println("Opção inválida. Tente novamente.")
                }
            }
        }

        private fun opcaoBebida(): Produto {
            while (true) {
                println("O que deseja inserir ao carrinho?")
                println("[1] Refrigerante:")
                println("[2] Suco:")
                val opcao = readln().toIntOrNull()
                when (opcao) {
                    1 -> {
                        return ProdutoOpcao.REFRIGERANTE.produto
                    }
                    2 -> {
                        return ProdutoOpcao.SUCO.produto
                    }
                    else -> println("Opção inválida. Tente novamente.")
                }
            }
        }
    }
}