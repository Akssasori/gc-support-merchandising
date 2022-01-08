package com.globo.producao.apoio.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.globo.producao.apoio.config.BaseTest;
import com.globo.producao.apoio.fakerModal.AgencyFaker;
import com.globo.producao.apoio.fakerModal.ClientFaker;
import com.globo.producao.apoio.mappers.AgencyMapper;
import com.globo.producao.apoio.mappers.ClientMapper;
import com.globo.producao.apoio.services.interfaces.AgencyService;
import com.globo.producao.apoio.services.interfaces.ClientService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = ClientController.class)
@AutoConfigureMockMvc(addFilters = false)
public class ClientControllerIT extends BaseTest {

    private final String URI_LIST_CLIENT = "/client";
    private final String URI_CLIENT_BY_ID = "/client/1";
    private final String URI_CLIENT_AGENCY = "/client/save";
    private final String URI_DELETE = "/client/1";
    private final String URI_UPDATE = "/client/1";
    private final String URI_FIND_ID_SISCOM = "/client/siscom/441695";


    @MockBean
    ClientService service;

    @MockBean
    ClientMapper mapper;

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("Should return list clients with success.")
    public void shouldReturnListClientsWithSuccess() throws Exception {

        doReturn(List.of(ClientFaker.getClientGet())).when(service).findAll();

        mockMvc.perform(get(URI_LIST_CLIENT)).andExpect(status().isOk());
    }
    @Test
    @DisplayName("Should return one client when pass id.")
    public void shouldReturnClientFindByIdWithSuccess() throws Exception {

        doReturn(ClientFaker.getClientGet()).when(service).findById(anyLong());

        mockMvc.perform(get(URI_CLIENT_BY_ID)).andExpect(status().isOk());
    }

    @Test
    @DisplayName("Should return one client when pass idSiscom.")
    public void shouldReturnClientFindByIdSiscomWithSuccess() throws Exception {

        doReturn(ClientFaker.getClientGet()).when(service).findByIdSiscom(anyLong());

        mockMvc.perform(get(URI_FIND_ID_SISCOM)).andExpect(status().isOk());
    }

    @Test
    @DisplayName("Should save client with success.")
    public void shouldReturnClientSavedWithSuccess() throws Exception {

        doReturn(ClientFaker.getClientGet()).when(service).save(ClientFaker.getClientPost());

        mockMvc.perform(post(URI_CLIENT_AGENCY)
                        .content(new ObjectMapper().writeValueAsString(ClientFaker.getClientGet()))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());
    }

    @Test
    @DisplayName("Should delete client with success.")
    public void shouldDeleteClientWithSuccess() throws Exception {

        doNothing().when(service).delete(anyLong());

        mockMvc.perform(delete(URI_DELETE)).andExpect(status().isOk());
    }

    @Test
    @DisplayName("Should update with success.")
    public void shouldReturnUpdateClientWithSuccess() throws Exception {

        doReturn(ClientFaker.getClientGet()).when(service).update(1L,ClientFaker.getClientPost());

        mockMvc.perform(put(URI_UPDATE)
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(ClientFaker.getClientGet())))
                .andExpect(status().isOk());


    }


}
