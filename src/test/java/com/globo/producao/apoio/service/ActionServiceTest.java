package com.globo.producao.apoio.service;

import com.globo.producao.apoio.config.BaseTest;
import com.globo.producao.apoio.fakerModal.*;
import com.globo.producao.apoio.models.*;
import com.globo.producao.apoio.repositories.*;
import com.globo.producao.apoio.services.Impls.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

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
    public void shouldReturnActionSave() throws Exception {

        doReturn(Optional.of(ActionFaker.getAction().getClient())).when(clientRepository).findByIdSiscom(ActionFaker.getAction().getClient().getIdSiscom());
        doReturn(ActionFaker.getAction().getClient()).when(clientService).save(ActionFaker.getAction().getClient());

        doReturn(Optional.of(ActionFaker.getAction().getAgency())).when(agencyRepository).findByIdSiscom(ActionFaker.getAction().getAgency().getIdSiscom());
        doReturn(ActionFaker.getAction().getAgency()).when(agencyService).save(ActionFaker.getAction().getAgency());

        doReturn(Optional.of(ActionFaker.getAction().getProduct())).when(productRepository).findByName(ActionFaker.getAction().getProduct().getName());
        doReturn(ActionFaker.getAction().getProduct()).when(productService).save(ActionFaker.getAction().getProduct());

        doReturn(Optional.of(ActionFaker.getAction().getProgram())).when(programRepository).findByName(ActionFaker.getAction().getProgram().getName());
        doReturn(ActionFaker.getAction().getProgram()).when(programService).save(ActionFaker.getAction().getProgram());

        doReturn(ActionFaker.getAction()).when(actionRepository).save(ActionFaker.getAction());
        Action response = actionService.save(ActionFaker.getAction());

        assertNotNull(response);

    }

    @Test
    @DisplayName("Should return Action empty when action null.")
    public void shouldReturnActionEmpty() throws Exception {

        doReturn(ActionFaker.getAction()).when(actionRepository).save(ActionFaker.getAction());
        Action response = actionService.save(null);

        assertNotNull(response);

    }

    @Test
    @DisplayName("Should return List of action with success.")
    public void shouldReturnListAction() throws Exception {

        doReturn(List.of(ActionFaker.getAction())).when(actionRepository).findAll();
        List<Action> response = actionService.findAll();

        assertNotNull(response);

    }

    @Test
    @DisplayName("Should return List of action with success.")
    public void shouldReturnActionFindById() throws Exception {

        doReturn(Optional.of(ActionFaker.getAction())).when(actionRepository).findById(1L);
        Action response = actionService.findById(1L);

        assertNotNull(response);

    }

    @Test
    @DisplayName("Should return a update action with success.")
    public void shouldReturnActionForUpdate() throws Exception {

        doReturn(Optional.of(ActionFaker.getAction())).when(actionRepository).findById(anyLong());
        doReturn(ActionFaker.getAction()).when(actionRepository).save(any(Action.class));
        doReturn(ProgramFaker.getProgram()).when(programService).Update(anyLong(),any(Program.class));
        doReturn(AgencyFaker.getAgencyGet()).when(agencyService).update(anyLong(),any(Agency.class));
        doReturn(ClientFaker.getClientPost()).when(clientService).update(anyLong(),any(Client.class));
        doReturn(ProductFaker.getProduct()).when(productService).update(any(),any(Product.class));
        Action response = actionService.update(1L,ActionFaker.getAction());

        verify(actionRepository, times(1)).findById(anyLong());
        verify(actionRepository, times(1)).save(any(Action.class));

        assertNotNull(response);

    }
    @Test
    @DisplayName("Should return a delete action with success.")
    public void shouldReturnActionDelete() throws Exception {

        doReturn(true).when(actionRepository).existsById(anyLong());
        doNothing().when(actionRepository).deleteById(anyLong());

        actionService.delete(1L);

        verify(actionRepository, times(1)).existsById(anyLong());
        verify(actionRepository, times(1)).deleteById(anyLong());

    }

    @Test
    @DisplayName("Should return not found when existById false in delete action.")
    public void shouldReturnNotFoundInActionDelete() throws Exception {

        doReturn(false).when(actionRepository).existsById(anyLong());
        doNothing().when(actionRepository).deleteById(anyLong());

        actionService.delete(800000L);

        verify(actionRepository, times(1)).existsById(anyLong());

    }

    @Test
    @DisplayName("Should return a Exception when update action.")
    public void shouldReturnExceptionWhenActionForUpdate() throws Exception {

        doThrow(new RuntimeException("Teste"))
                .when(programService)
                .Update(anyLong(), any(Program.class));

        assertThrows(
                Exception.class,
                () -> {
                    actionService.update(anyLong(), any(Action.class));
                });

    }




}
