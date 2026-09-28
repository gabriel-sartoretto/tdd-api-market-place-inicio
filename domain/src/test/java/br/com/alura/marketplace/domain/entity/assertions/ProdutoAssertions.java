package br.com.alura.marketplace.domain.entity.assertions;

import br.com.alura.marketplace.domain.entity.Produto;
import lombok.RequiredArgsConstructor;

import static lombok.AccessLevel.PRIVATE;
import static org.assertj.core.api.Assertions.assertThat;

@RequiredArgsConstructor(access = PRIVATE)
public final class ProdutoAssertions {

    private final Produto atual;

    public static ProdutoAssertions afirmaQue_Produto(Produto atual) {
        return new ProdutoAssertions(atual);
    }

    /**
     * @see br.com.alura.marketplace.application.v1.dto.factory.ProdutoDtoFactory
     */
    public void foiConvertidoDe_ProdutoDto_Request() {
        assertThat(atual.getProdutoId()).isNull();
        assertThat(atual.getNome())
                .isEqualTo("Produto Teste");
        assertThat(atual.getCategoria())
                .isEqualTo("Categoria 1");
        assertThat(atual.getStatus())
                .isEqualTo(Produto.Status.AVAILABLE);
    }
}