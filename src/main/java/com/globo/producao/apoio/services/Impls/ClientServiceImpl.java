package com.globo.producao.apoio.services.Impls;

import com.globo.producao.apoio.models.Client;
import com.globo.producao.apoio.repositories.ClientRepository;
import com.globo.producao.apoio.services.interfaces.ClientService;
import com.globo.producao.apoio.utils.exceptions.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;

    @Override
    public Client save(Client client) throws Exception {

        Client clientDB = clientRepository.findByIdSiscom(client.getIdSiscom());


        if (Objects.nonNull(clientDB) && Objects.equals(clientDB.getName().trim().toUpperCase() ,client.getName().trim().toUpperCase()) &&
                Objects.equals(clientDB.getIdSiscom() , client.getIdSiscom())) {

            return clientDB;

        } else {

            return clientRepository.save(client);
        }
    }

    @Override
    public List<Client> findAll() throws FindDataException {
        try {
            return clientRepository.findAll();
        } catch (Exception e) {
            throw new FindDataException(e.getMessage());
        }
    }

    @Override
    public Client findById(Long id) throws FindDataException {
        try {
            return clientRepository.findById(id).orElseThrow(() -> new NoEntityException(id.toString()));
        } catch (Exception e) {
            throw new FindDataException(e.getMessage());
        }
    }

    @Override
    public Client update(Long id, Client client) throws UpdateDataException {

        Client clientDB = clientRepository.findById(id).orElseThrow(() -> new NoEntityException(id.toString()));

        if(Objects.equals(clientDB.getName().trim().toUpperCase() ,client.getName().trim().toUpperCase()) &&
                Objects.equals(clientDB.getIdSiscom() , client.getIdSiscom()) ){
                return clientDB;
        } else {
            clientDB.setName(client.getName());
            clientDB.setId(id);
            clientDB.setIdSiscom(client.getIdSiscom());
            return clientRepository.save(clientDB);
        }

    }

    @Override
    public void delete(Long id) throws DeleteDataException {
        try {
            if (clientRepository.existsById(id)) {
                clientRepository.deleteById(id);
            } else {
                ResponseEntity.notFound();
            }
        } catch (Exception e) {
            throw new DeleteDataException(e.getMessage());
        }

    }

    @Override
    public Client findByIdSiscom(Long idSiscom) {
        return clientRepository.findByIdSiscom(idSiscom);
    }
}
