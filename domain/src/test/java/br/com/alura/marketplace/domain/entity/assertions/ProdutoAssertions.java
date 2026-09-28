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
        assertThat(atual.getDescricao())
                .isEqualTo("Descricao do Produto Teste");
        assertThat(atual.getValor())
                .isEqualByComparingTo("1.99");
        assertThat(atual.getFotos())
                .singleElement()
                .satisfies(foto -> {
                    assertThat(foto.getFotoId()).isNull();
                    assertThat(foto.getFileName())
                            .isEqualTo("file-name-1.jpg");
                    assertThat(foto.getBase64())
                            .isEqualTo("Y2Fyb2xpbmEgSGVycmVyYQ==");
                    assertThat(foto.getLink()).isNull();
                    assertThat(foto.getCriadoEm()).isNull();
                    assertThat(foto.getAtualizadoEm()).isNull();
                });
        assertThat(atual.getTags())
                .containsExactly("tag-1");
        assertThat(atual.getPetStorePetId()).isNull();
        assertThat(atual.getCriadoEm()).isNull();
        assertThat(atual.getAtualizadoEm()).isNull();
    }
}