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
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
public class AgencyServiceTest extends BaseTest {

    @InjectMocks
    private AgencyServiceImpl agencyService;

    @Mock
    private AgencyRepository agencyRepository;

    @Test
    @DisplayName("Should return Agency saved with success.")
    public void shouldReturnAgencySave() throws Exception {

        doReturn(Optional.of(AgencyFaker.getAgencyGet())).when(agencyRepository).findByIdSiscom(1L);
        doReturn(AgencyFaker.getAgencyPost()).when(agencyRepository).save(any(Agency.class));
        doReturn(Optional.of(AgencyFaker.getAgencyPost())).when(agencyRepository).findById(anyLong());

        Agency response = agencyService.save(AgencyFaker.getAgencyPost());

        verify(agencyRepository, times(1)).save(any(Agency.class));

        assertNotNull(response);

    }

    @Test
    @DisplayName("Should return List of agency with success.")
    public void shouldReturnListAction() throws Exception {

        doReturn(List.of(AgencyFaker.getAgencyGet())).when(agencyRepository).findAll();
        List<Agency> response = agencyService.findAll();

        assertNotNull(response);

    }

    @Test
    @DisplayName("Should return agency with success.")
    public void shouldReturnAgencyFindById() throws Exception {

        doReturn(Optional.of(AgencyFaker.getAgencyGet())).when(agencyRepository).findById(1L);
        Agency response = agencyService.findById(1L);

        assertNotNull(response);

    }

    @Test
    @DisplayName("Should return agency by id siscom with success.")
    public void shouldReturnAgencyFindByIdSiscom() throws Exception {

        doReturn(Optional.of(AgencyFaker.getAgencyGet())).when(agencyRepository).findByIdSiscom(anyLong());
        Agency response = agencyService.findByIdSiscom(anyLong());

        assertNotNull(response);

    }

    @Test
    @DisplayName("Should return a update action with same name agencyDB with success.")
    public void shouldReturnActionForUpdateWithSameName() throws Exception {

        doReturn(Optional.of(AgencyFaker.getAgencyGet())).when(agencyRepository).findById(4L);
        doReturn(Optional.of(AgencyFaker.getAgencyGet())).when(agencyRepository).findById(4L);

        Agency response = agencyService.update(4L,AgencyFaker.getAgencyGet());

        assertNotNull(response);

    }

    @Test
    @DisplayName("Should return a update action with success.")
    public void shouldReturnActionForUpdate() throws Exception {

        doReturn(Optional.of(AgencyFaker.getAgencyGetEmptyName())).when(agencyRepository).findById(4L);
        doReturn(Optional.of(AgencyFaker.getAgencyGetEmptyName())).when(agencyRepository).findById(4L);
        doReturn(AgencyFaker.getAgencyPost()).when(agencyRepository).save(any(Agency.class));

        Agency response = agencyService.update(4L,AgencyFaker.getAgencyGetDifferentName());

        verify(agencyRepository, times(1)).save(any(Agency.class));

        assertNotNull(response);

    }




}
