package produtos

enum class ProdutoOpcao(val produto: Produto) {
    XBURGUER(XBurguer()), XSALADA(XSalada()), REFRIGERANTE(Refrigerante()), SUCO(Suco());

    companion object FuncoesProduto {
        fun getProdutoByCode(code: Int): ProdutoOpcao? {
            return values().firstOrNull { it.produto.getCodigo() == code }
        }
    }
}