package com.globo.producao.apoio.fakerModal;

import com.globo.producao.apoio.models.Agency;

public class AgencyFaker {

    public static Agency getAgencyPost() {
        return Agency.builder()
                .id(4L)
                .name("FLASH")
                .build();
    }

    public static Agency getAgencyGet() {
        return Agency.builder()
                .id(4L)
                .name("FLASH")
                .idSiscom(44043L)
                .build();
    }



}
