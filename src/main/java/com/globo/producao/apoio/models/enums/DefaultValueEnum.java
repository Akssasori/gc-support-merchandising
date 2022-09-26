package com.globo.producao.apoio.models.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum DefaultValueEnum {

    NO_REGISTRY(1L);

    private final Long id;
}
