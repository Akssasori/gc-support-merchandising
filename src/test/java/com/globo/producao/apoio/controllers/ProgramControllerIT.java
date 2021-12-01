package com.globo.gc.operation.creative.controllers;

import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.doThrow;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import com.globo.gc.operation.creative.config.BaseTest;
import com.globo.gc.operation.creative.mappers.AutoTaggingStatusMapper;
import com.globo.gc.operation.creative.models.AutoTaggingStatus;
import com.globo.gc.operation.creative.services.interfaces.AutoTaggingStatusService;
import com.globo.gc.operation.creative.utils.exceptions.FindAllDataException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(controllers = AutoTaggingStatusController.class)
@AutoConfigureMockMvc(addFilters = false)
public class AutoTaggingStatusControllerIT extends BaseTest {
        private final String URI_LIST_AUTO_TAGGING_STATUS = "/rest/api/v1/auto" + "-tagging-status";

        @MockBean
        AutoTaggingStatusService autoTaggingStatusService;

        @MockBean
        AutoTaggingStatusMapper autoTaggingStatusMapper;

        @Autowired
        private MockMvc mockMvc;

        @Test
        @DisplayName("Should return All auto Tagging Status with success.")
        public void shouldReturnAllAutoTaggingStatusControllerWithSuccess() throws Exception {

                List<AutoTaggingStatus> lstAutoTaggingStatus = new ArrayList<>();
                lstAutoTaggingStatus.add(AutoTaggingStatus.builder().id(1L).name("Incompatível").build());
                lstAutoTaggingStatus.add(AutoTaggingStatus.builder().id(2L).name("Aguardando recebimento").build());
                lstAutoTaggingStatus.add(AutoTaggingStatus.builder().id(3L).name("Recebido").build());

                doReturn(lstAutoTaggingStatus).when(autoTaggingStatusService).findAll();

                mockMvc.perform(get(URI_LIST_AUTO_TAGGING_STATUS)).andExpect(status().isOk());

        }

        @Test
        @DisplayName("Should return internal server error when occurs " + "FindAllDataException.")
        public void shouldReturnInternalServerErrorWhenOccursFindAllDataException() throws Exception {

                doThrow(new FindAllDataException("Test")).when(autoTaggingStatusService).findAll();

                mockMvc.perform(get(URI_LIST_AUTO_TAGGING_STATUS)).andExpect(status().isInternalServerError());
        }
}
