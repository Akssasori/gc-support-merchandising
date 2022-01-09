package com.globo.producao.apoio.service;

import com.globo.producao.apoio.config.BaseTest;
import com.globo.producao.apoio.fakerModal.ActionFaker;
import com.globo.producao.apoio.fakerModal.ProgramFaker;
import com.globo.producao.apoio.models.Action;
import com.globo.producao.apoio.repositories.*;
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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import static org.mockito.Mockito.doReturn;

@ExtendWith(SpringExtension.class)
public class ActionServiceTest extends BaseTest {

    @InjectMocks
    private ActionServiceImpl actionService;

    @Mock
    private ActionRepository actionRepository;

    @Mock
    private ProgramRepository programRepository;

    @Mock
    private ProgramServiceImpl programService;

    @Mock
    private ProductRepository productRepository;

    @Mock
    private ProductServiceImpl productService;

    @Mock
    private AgencyRepository agencyRepository;

    @Mock
    private AgencyServiceImpl agencyService;

    @Mock
    private ClientServiceImpl clientService;

    @Mock
    private ClientRepository clientRepository;

    @Test
    @DisplayName("Should return Action saved with success.")
    public void shouldReturnPersonAgencyAddressFindByFilter() throws Exception {

        doReturn(ActionFaker.getAction().getClient()).when(clientRepository).findByIdSiscom(ActionFaker.getAction().getClient().getIdSiscom());
        doReturn(ActionFaker.getAction().getClient()).when(clientService).save(ActionFaker.getAction().getClient());

        doReturn(ActionFaker.getAction().getAgency()).when(agencyRepository).findByIdSiscom(ActionFaker.getAction().getAgency().getIdSiscom());
        doReturn(ActionFaker.getAction().getAgency()).when(agencyService).save(ActionFaker.getAction().getAgency());

        doReturn(ActionFaker.getAction().getProduct()).when(productRepository).findByName(ActionFaker.getAction().getProduct().getName());
        doReturn(ActionFaker.getAction().getProduct()).when(productService).save(ActionFaker.getAction().getProduct());

        doReturn(ActionFaker.getAction().getProgram()).when(programRepository).findByName(ActionFaker.getAction().getProgram().getName());
        doReturn(ActionFaker.getAction().getProgram()).when(programService).save(ActionFaker.getAction().getProgram());

        doReturn(ActionFaker.getAction()).when(actionRepository).save(ActionFaker.getAction());
        Action response = actionService.save(ActionFaker.getAction());

        assertNotNull(response);

    }




}
