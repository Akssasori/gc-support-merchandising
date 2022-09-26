package com.globo.producao.apoio.models.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TypeActionEnum {

    TEXTO_FOGUETE(1L),

    AQUECIMENTO(2L),

    CONTINUIDADE(3L),

    COMERCIAL_AO_VIVO(4L),

    COMERCIAL_CHAMADO(5L),

    ACAO(6L),

    VISUALIZACAO(7L),

    BONIFICACAO(8L),

    VAZAMENTO_AUTORIZADO(9L),

    ACAO_ESPECIAL(10L),

    VISUALIZACAO_CONTEXTUALIZADA(11L),

    INSERT(12L),

    BREAK(13L),

    MENCAO_CONTEXTUALIZADA(14L),

    PRODUCT_PLACEMENT(15L),

    QR_CODE(16L),

    OUTROS(17L);

    private final Long id;



}
