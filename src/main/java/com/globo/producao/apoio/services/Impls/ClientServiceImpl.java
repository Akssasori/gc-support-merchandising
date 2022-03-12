package com.globo.producao.apoio.services.Impls;

import com.globo.producao.apoio.models.Client;
import com.globo.producao.apoio.repositories.ClientRepository;
import com.globo.producao.apoio.services.interfaces.ClientService;
import com.globo.producao.apoio.utils.exceptions.*;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {

    public static final long DEFAULT_REPOSITORY = 1L;
    private final ClientRepository clientRepository;

    @Override
    @SneakyThrows
    public Client save(Client client) {

        var clientDB = clientRepository.findByName(client.getName());

        if (clientDB.isPresent()) {

            if (Objects.equals(clientDB.get().getName().trim().toUpperCase(),
                    client.getName().trim().toUpperCase())) {
                return clientDB.get();
            }

        } else {
            if (StringUtils.isBlank(client.getName())) {

                client.setId(1L);
                client.setName("NO REGISTRY");
                client.setIdSiscom(0L);
            } else {
                return clientRepository.save(client);
            }
        }
        return clientRepository.save(client);
    }


    @Override
    public List<Client> findAll() {
        return clientRepository.findAll();
    }

    @Override
    public Client findById(Long id) throws FindDataException {
        return clientRepository.findById(id).orElseThrow(() -> new NoEntityException(id.toString()));
    }

    @Override
    public Client update(Long id, Client client) throws UpdateDataException {

        var clientDB = clientRepository.findById(id).orElseThrow(() -> new NoEntityException(id.toString()));

        if (Objects.equals(client.getName().trim().toUpperCase(),
                clientDB.getName().trim().toUpperCase())) {
            return clientDB;
        } else {
            clientDB.setId(id);
            clientDB.setName(client.getName());
            clientDB.setIdSiscom(client.getIdSiscom());
            return clientRepository.save(clientDB);
        }

    }

    @Override
    public void delete(Long id) throws DeleteDataException {

        if (clientRepository.existsById(id)) {
            clientRepository.deleteById(id);
        } else {
            throw new NoEntityException(id.toString());
        }

    }

    @Override
    public Client findByIdSiscom(Long idSiscom) {
        return clientRepository.findByIdSiscom(idSiscom).orElseThrow(() -> new NoEntityException(idSiscom.toString()));
    }
}
