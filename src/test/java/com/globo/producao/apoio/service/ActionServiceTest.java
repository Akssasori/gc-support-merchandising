package com.globo.producao.apoio.service;

import com.globo.producao.apoio.config.BaseTest;
import com.globo.producao.apoio.fakerModal.ActionFaker;
import com.globo.producao.apoio.fakerModal.ProgramFaker;
import com.globo.producao.apoio.models.Action;
import com.globo.producao.apoio.repositories.ActionRepository;
import com.globo.producao.apoio.repositories.ProgramRepository;
import com.globo.producao.apoio.services.Impls.*;
import com.globo.producao.apoio.services.interfaces.AgencyService;
import com.globo.producao.apoio.services.interfaces.ClientService;
import com.globo.producao.apoio.services.interfaces.ProductService;
import com.globo.producao.apoio.services.interfaces.ProgramService;
import com.globo.producao.apoio.utils.exceptions.InsertDataException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import static org.mockito.Mockito.doReturn;

@ExtendWith(SpringExtension.class)
public class ActionServiceTest extends BaseTest {

//    @InjectMocks
//    private AgencyServiceImpl agencyService;
//
//    @InjectMocks
//    private ClientServiceImpl clientService;
//
    @InjectMocks
    private ActionServiceImpl actionService;

    @Mock
    private ActionRepository actionRepository;

//    @InjectMocks
//    private ProgramServiceImpl programService;

    @Mock
    private ProgramRepository programRepository;

    @MockBean
    private ProgramService programService;

    @Test
    @DisplayName("Should return Action saved with success.")
    public void shouldReturnPersonAgencyAddressFindByFilter() throws Exception {

        doReturn(ActionFaker.getAction().getProgram()).when(programRepository).findByName(ActionFaker.getAction().getProgram().getName());
        doReturn(ActionFaker.getAction().getProgram()).when(programService).save(ActionFaker.getAction().getProgram());

        doReturn(ActionFaker.getAction()).when(actionRepository).save(ActionFaker.getAction());
        Action response = actionService.save(ActionFaker.getAction());

        assertNotNull(response);

    }




}
