package com.globo.producao.apoio.fakerModal;

import com.globo.producao.apoio.models.*;
import com.globo.producao.apoio.models.enums.TypeActionEnum;

import java.time.LocalDateTime;

public class ActionFaker {

    public static Action getAction() {
        return Action.builder()
                .id(1L)
                .agency(Agency.builder()
                        .id(4L)
                        .name("FLASH")
                        .build())
                .client(Client.builder()
                        .name("3 MILENIO")
                        .idSiscom(441695L)
                        .build())
                .product(Product.builder()
                        .id(1L)
                        .name("COCA-COLA")
                        .build())
                .program(Program.builder()
                        .id(4L)
                        .name("CALDEIRAO DO HULK")
                        .build())
                .description("ACAO COM PAOLA OLIVEIRA")
                .typeAction(TypeActionEnum.ACAO)
                .startTime(LocalDateTime.now())
                .endTime(LocalDateTime.now().plusHours(1L))
                .reviewTime(LocalDateTime.now())
                .payTVFlag(false)
                .build();
    }


}
