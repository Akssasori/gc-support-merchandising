package com.globo.producao.apoio.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.globo.producao.apoio.config.BaseTest;
import com.globo.producao.apoio.fakerModal.ActionFaker;
import com.globo.producao.apoio.fakerModal.AgencyFaker;
import com.globo.producao.apoio.mappers.ActionMapper;
import com.globo.producao.apoio.mappers.AgencyMapper;
import com.globo.producao.apoio.models.Action;
import com.globo.producao.apoio.models.Program;
import com.globo.producao.apoio.services.interfaces.ActionService;
import com.globo.producao.apoio.services.interfaces.AgencyService;
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

import java.util.List;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = ActionController.class)
@AutoConfigureMockMvc(addFilters = false)
public class ActionControllerIT extends BaseTest {

    private final String URI_LIST_ACTION = "/action";
    private final String URI_ACTION_BY_ID = "/action/1";
    private final String URI_SAVE_ACTION = "/action/save";
    private final String URI_DELETE = "/action/1";
    private final String URI_UPDATE = "/action/1";
    private final String URI_PAGE = "/action/page/0/1";

    @MockBean
    ActionService service;

    @MockBean
    ActionMapper mapper;

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("Should return list actions with success.")
    public void shouldReturnListActionWithSuccess() throws Exception {

        doReturn(List.of(ActionFaker.getAction())).when(service).findAll();

        mockMvc.perform(get(URI_LIST_ACTION)).andExpect(status().isOk());
    }
    @Test
    @DisplayName("Should return one actions when pass id.")
    public void shouldReturnActionFindByIdWithSuccess() throws Exception {

        doReturn(ActionFaker.getAction()).when(service).findById(anyLong());

        mockMvc.perform(get(URI_ACTION_BY_ID)).andExpect(status().isOk());
    }

    @Test
    @DisplayName("Should save action with success.")
    public void shouldReturnActionSavedWithSuccess() throws Exception {

        doReturn(ActionFaker.getAction()).when(service).save(ActionFaker.getAction());

        mockMvc.perform(post(URI_SAVE_ACTION)
                        .content(new ObjectMapper().writeValueAsString(ActionFaker.getAction()))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());
    }

    @Test
    @DisplayName("Should delete action with success.")
    public void shouldDeleteActionWithSuccess() throws Exception {

        doNothing().when(service).delete(anyLong());

        mockMvc.perform(delete(URI_DELETE)).andExpect(status().isOk());
    }

    @Test
    @DisplayName("Should update with success.")
    public void shouldReturnUpdateActionWithSuccess() throws Exception {

        doReturn(ActionFaker.getAction()).when(service).update(1L,ActionFaker.getAction());

        mockMvc.perform(put(URI_UPDATE)
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(ActionFaker.getAction())))
                .andExpect(status().isOk());


    }

    @Test
    @DisplayName("Should return pageable of action with success.")
    public void shouldReturnPageActionWithSuccess() throws Exception {

        Page<Action> programs = Mockito.mock(Page.class);

        doReturn(programs).when(service).pageAction(0,1);

        mockMvc.perform(get(URI_PAGE)).andExpect(status().isOk());


    }


}
