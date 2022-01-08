package com.globo.producao.apoio.fakerModal;

import com.globo.producao.apoio.models.Product;

public class ProductFaker {

    public static Product getProduct() {
        return Product.builder()
                .id(1L)
                .name("COCA COLA")
                .build();
    }
}
