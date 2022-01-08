package com.globo.producao.apoio.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.globo.producao.apoio.config.BaseTest;
import com.globo.producao.apoio.fakerModal.ProgramFaker;
import com.globo.producao.apoio.mappers.ProgramMapper;
import com.globo.producao.apoio.models.Program;
import com.globo.producao.apoio.services.interfaces.ProgramService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.awt.print.Pageable;
import java.util.List;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = ProgramController.class)
@AutoConfigureMockMvc(addFilters = false)
public class ProgramControllerIT extends BaseTest {

    private final String URI_LIST_PROGRAM = "/program";
    private final String URI_PROGRAM_BY_ID = "/program/1";
    private final String URI_SAVE_PROGRAM = "/program/save";
    private final String URI_DELETE = "/program/1";
    private final String URI_UPDATE = "/program/1";
    private final String URI_PAGE = "/program/page/0/4";


    @MockBean
    ProgramService service;

    @MockBean
    ProgramMapper mapper;

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("Should return list programs with success.")
    public void shouldReturnListProgramResponseDtoWithSuccess() throws Exception {

        doReturn(List.of(ProgramFaker.getProgram())).when(service).findAll();

        mockMvc.perform(get(URI_LIST_PROGRAM)).andExpect(status().isOk());
    }
    @Test
    @DisplayName("Should return one program when pass id.")
    public void shouldReturnProgramFindByIdWithSuccess() throws Exception {

        doReturn(ProgramFaker.getProgram()).when(service).findById(anyLong());

        mockMvc.perform(get(URI_PROGRAM_BY_ID)).andExpect(status().isOk());
    }

    @Test
    @DisplayName("Should save program with success.")
    public void shouldReturnProgramSavedWithSuccess() throws Exception {

        doReturn(ProgramFaker.getProgram()).when(service).save(ProgramFaker.getProgram());

        mockMvc.perform(post(URI_SAVE_PROGRAM)
                        .content(new ObjectMapper().writeValueAsString(ProgramFaker.getProgram()))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());
    }

    @Test
    @DisplayName("Should delete program with success.")
    public void shouldDeleteProgramWithSuccess() throws Exception {

        doNothing().when(service).Delete(1L);

        mockMvc.perform(delete(URI_DELETE)).andExpect(status().isOk());
    }

    @Test
    @DisplayName("Should update with success.")
    public void shouldReturnUpdateProgramWithSuccess() throws Exception {

        doReturn(ProgramFaker.getProgram()).when(service).Update(1L,ProgramFaker.getProgram());

        mockMvc.perform(put(URI_UPDATE)
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(ProgramFaker.getProgram())))
                .andExpect(status().isOk());


    }

    @Test
    @DisplayName("Should return pageable of program with success.")
    public void shouldReturnPageProgramWithSuccess() throws Exception {

        Page<Program> programs = Mockito.mock(Page.class);

        doReturn(programs).when(service).pageProgram(0,4);

        mockMvc.perform(get(URI_PAGE)).andExpect(status().isOk());


    }




}
