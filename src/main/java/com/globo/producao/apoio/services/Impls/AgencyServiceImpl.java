package com.globo.producao.apoio.services.Impls;

import com.globo.producao.apoio.models.Agency;
import com.globo.producao.apoio.repositories.AgencyRepository;
import com.globo.producao.apoio.services.interfaces.AgencyService;
import com.globo.producao.apoio.utils.exceptions.DeleteDataException;
import com.globo.producao.apoio.utils.exceptions.InsertDataException;
import com.globo.producao.apoio.utils.exceptions.NoEntityException;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AgencyServiceImpl implements AgencyService {

    private final AgencyRepository repository;

    @Override
    @SneakyThrows
    public Agency save(Agency agency) throws InsertDataException {

        Optional<Agency> agencyDB;

        try {

            agencyDB = repository.findByIdSiscom(agency.getIdSiscom());

            if (agencyDB.isPresent()) {

                if (Objects.equals(agencyDB.get().getName().trim().toUpperCase(),
                        agency.getName().trim().toUpperCase())) {
                    return agencyDB.get();
                }
            } else {
                if (Objects.isNull(agency.getName()) || agency.getName().isEmpty()) {
                    Agency agencyDefault = repository.findById(1L).get();
                    return agencyDefault;
                } else {
                    return repository.save(agency);
                }
            }

        } catch (Exception e) {
            throw new InsertDataException(e.getMessage());
        }

        return agencyDB.get();
    }

    @Override
    public List<Agency> findAll() {
        return repository.findAll();
    }

    @Override
    public Agency findById(Long agencyId) {

        return repository.findById(agencyId).orElseThrow(() -> new NoEntityException(agencyId.toString()));
    }

    @Override
    @SneakyThrows
    public Agency update(Long id, Agency agency) {

        Agency agencyDB = repository.findById(id).orElseThrow(() -> new NoEntityException(id.toString()));

        if (Objects.equals(agencyDB.getName().trim().toUpperCase(), agency.getName().trim().toUpperCase()) &&
                Objects.equals(agencyDB.getIdSiscom(), agency.getIdSiscom())) {
            return agencyDB;
        } else {
            agencyDB.setName(agency.getName());
            agencyDB.setId(id);
            agencyDB.setIdSiscom(agency.getIdSiscom());
            return repository.save(agencyDB);
        }
    }

    @Override
    @SneakyThrows
    public void delete(Long agencyId) {

        try {
            if (repository.existsById(agencyId)) {
                repository.deleteById(agencyId);
            } else {
                ResponseEntity.notFound();
            }
        } catch (Exception e) {
            throw new DeleteDataException(e.getMessage());
        }

    }

    @Override
    public Agency findByIdSiscom(Long idSiscom) {
        return repository.findByIdSiscom(idSiscom).get();
    }
}
