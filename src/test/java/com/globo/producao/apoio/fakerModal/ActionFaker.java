package com.globo.producao.apoio.fakerModal;

import com.globo.producao.apoio.models.Action;
import com.globo.producao.apoio.models.enums.TypeActionEnum;

public class ActionFaker {

    public static Action getAction() {
        return Action.builder()
                .agency(AgencyFaker.getAgencyGet())
                .client(ClientFaker.getClientGet())
                .product(ProductFaker.getProduct())
                .program(ProgramFaker.getProgram())
                .description("ACAO COM PAOLA OLIVEIRA")
                .typeAction(TypeActionEnum.ACAO)
                .payTVFlag(false)
                .build();
    }


}
