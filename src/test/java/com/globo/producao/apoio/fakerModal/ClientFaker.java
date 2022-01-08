package com.globo.producao.apoio.fakerModal;

import com.globo.producao.apoio.models.Client;

public class ClientFaker {

    public static Client getClientPost() {
        return Client.builder()
                .id(3L)
                .name("3 MILENIO")
                .build();
    }

    public static Client getClientGet() {
        return Client.builder()
                .id(3L)
                .name("3 MILENIO")
                .idSiscom(441695L)
                .build();
    }

}
