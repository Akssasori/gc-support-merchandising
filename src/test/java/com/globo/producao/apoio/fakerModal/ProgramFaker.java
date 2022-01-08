package com.globo.producao.apoio.fakerModal;

import com.globo.producao.apoio.models.Program;

public class ProgramFaker {

    public static Program getProgram() {
        return Program.builder()
                .id(1L)
                .name("MAIS VOCE")
                .build();
    }
}
