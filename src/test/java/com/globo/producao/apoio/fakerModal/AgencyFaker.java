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

    public static Agency getAgencyGetDifferentName() {
        return Agency.builder()
                .id(4L)
                .name("FLASH2563")
                .idSiscom(44043L)
                .build();
    }

    public static Agency getAgencyGetEmptyName() {
        return Agency.builder()
                .id(4L)
                .name("")
                .idSiscom(44043L)
                .build();
    }

    public static Agency getAgencyNoPresent() {
        return Agency.builder()
                .id(900L)
                .name(null)
                .idSiscom(9000L)
                .build();
    }

    public static Agency getAgencyDefault() {
        return Agency.builder()
                .id(1L)
                .name("no registry")
                .idSiscom(0L)
                .build();
    }



}
