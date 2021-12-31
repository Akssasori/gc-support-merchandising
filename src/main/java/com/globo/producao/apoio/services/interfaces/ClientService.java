package com.globo.producao.apoio.services.interfaces;

import com.globo.producao.apoio.models.Client;
import com.globo.producao.apoio.utils.exceptions.DeleteDataException;
import com.globo.producao.apoio.utils.exceptions.FindDataException;
import com.globo.producao.apoio.utils.exceptions.UpdateDataException;

import java.util.List;

public interface ClientService {

    Client save(Client client) throws Exception;

    List<Client> findAll() throws FindDataException;

    Client findById(Long id) throws FindDataException;

    Client update(Long id, Client client) throws UpdateDataException;

    void delete(Long id) throws DeleteDataException;

    Client findByIdSiscom(Long idSiscom);
}
