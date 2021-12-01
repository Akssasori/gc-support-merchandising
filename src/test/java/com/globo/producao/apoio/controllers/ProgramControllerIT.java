package com.globo.producao.apoio.controllers;

import com.globo.producao.apoio.config.BaseTest;
import com.globo.producao.apoio.dtos.response.ProgramResponseDto;
import com.globo.producao.apoio.mappers.ProgramMapper;
import com.globo.producao.apoio.services.interfaces.ProgramService;
import com.globo.producao.apoio.utils.exceptions.FindAllDataException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = ProgramControllerIT.class)
@AutoConfigureMockMvc(addFilters = false)
public class ProgramControllerIT extends BaseTest {

    private final String URI_LIST_PROGRAM = "/program";

    @MockBean
    ProgramService programService;

    @MockBean
    ProgramMapper mapper;

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("Should return list programs with success.")
    public void shouldReturnListProgramResponseDtoWithSuccess() throws Exception {

        doReturn(List.of(ProgramResponseDto.class)).when(programService).findAll();

        mockMvc.perform(get(URI_LIST_PROGRAM)).andExpect(status().isOk());
    }
}
