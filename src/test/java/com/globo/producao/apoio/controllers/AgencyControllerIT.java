package com.globo.producao.apoio.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.globo.producao.apoio.config.BaseTest;
import com.globo.producao.apoio.fakerModal.AgencyFaker;
import com.globo.producao.apoio.fakerModal.ProductFaker;
import com.globo.producao.apoio.mappers.AgencyMapper;
import com.globo.producao.apoio.services.interfaces.AgencyService;
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

@WebMvcTest(controllers = AgencyController.class)
@AutoConfigureMockMvc(addFilters = false)
public class AgencyControllerIT extends BaseTest {

    private final String URI_LIST_AGENCY = "/agency";
    private final String URI_AGENCY_BY_ID = "/agency/1";
    private final String URI_SAVE_AGENCY = "/agency/save";
    private final String URI_DELETE = "/agency/1";
    private final String URI_UPDATE = "/agency/1";
    private final String URI_FIND_ID_SISCOM = "/agency/siscom/44043";


    @MockBean
    AgencyService service;

    @MockBean
    AgencyMapper mapper;

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("Should return list agencies with success.")
    public void shouldReturnListAgencyResponseDtoWithSuccess() throws Exception {

        doReturn(List.of(AgencyFaker.getAgencyGet())).when(service).findAll();

        mockMvc.perform(get(URI_LIST_AGENCY)).andExpect(status().isOk());
    }
    @Test
    @DisplayName("Should return one agency when pass id.")
    public void shouldReturnAgencyFindByIdWithSuccess() throws Exception {

        doReturn(AgencyFaker.getAgencyGet()).when(service).findById(anyLong());

        mockMvc.perform(get(URI_AGENCY_BY_ID)).andExpect(status().isOk());
    }

    @Test
    @DisplayName("Should return one agency when pass idSiscom.")
    public void shouldReturnAgencyFindByIdSiscomWithSuccess() throws Exception {

        doReturn(AgencyFaker.getAgencyGet()).when(service).findByIdSiscom(anyLong());

        mockMvc.perform(get(URI_FIND_ID_SISCOM)).andExpect(status().isOk());
    }

    @Test
    @DisplayName("Should save agency with success.")
    public void shouldReturnAgencySavedWithSuccess() throws Exception {

        doReturn(AgencyFaker.getAgencyGet()).when(service).save(AgencyFaker.getAgencyPost());

        mockMvc.perform(post(URI_SAVE_AGENCY)
                        .content(new ObjectMapper().writeValueAsString(AgencyFaker.getAgencyGet()))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());
    }

    @Test
    @DisplayName("Should delete agency with success.")
    public void shouldDeleteAgencyWithSuccess() throws Exception {

        doNothing().when(service).delete(anyLong());

        mockMvc.perform(delete(URI_DELETE)).andExpect(status().isOk());
    }

    @Test
    @DisplayName("Should update with success.")
    public void shouldReturnUpdateAgencyWithSuccess() throws Exception {

        doReturn(AgencyFaker.getAgencyGet()).when(service).update(1L,AgencyFaker.getAgencyPost());

        mockMvc.perform(put(URI_UPDATE)
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(AgencyFaker.getAgencyGet())))
                .andExpect(status().isOk());


    }


}
