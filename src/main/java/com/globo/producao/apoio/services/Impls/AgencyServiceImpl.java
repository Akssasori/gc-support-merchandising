package com.globo.producao.apoio.services.Impls;

import com.globo.producao.apoio.models.Agency;
import com.globo.producao.apoio.repositories.AgencyRepository;
import com.globo.producao.apoio.services.interfaces.AgencyService;
import com.globo.producao.apoio.utils.exceptions.InsertDataException;
import com.globo.producao.apoio.utils.exceptions.NoEntityException;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;
import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class AgencyServiceImpl implements AgencyService {

    public static final long DEFAULT_REPOSITORY = 1L;
    private final AgencyRepository repository;

    @Override
    @SneakyThrows
    public Agency save(Agency agency) throws InsertDataException {

        var agencyDB = repository.findByIdSiscom(agency.getIdSiscom());

        if (agencyDB.isPresent()) {

            if (Objects.equals(agencyDB.get().getName().trim().toUpperCase(),
                    agency.getName().trim().toUpperCase())) {
                return agencyDB.get();
            }
        } else {
            if (StringUtils.isBlank(agency.getName())) {
                return repository.findById(DEFAULT_REPOSITORY).get();

            } else {
                return repository.save(agency);
            }
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

        var agencyDB = repository.findById(id).orElseThrow(() -> new NoEntityException(id.toString()));

        if (Objects.equals(agency.getName().trim().toUpperCase(),
                agencyDB.getName().trim().toUpperCase())) {
            return agencyDB;
        } else {
            agencyDB.setId(id);
            agencyDB.setName(agency.getName());
            agencyDB.setIdSiscom(agency.getIdSiscom());
            return repository.save(agencyDB);
        }
    }

    @Override
    @SneakyThrows
    public void delete(Long agencyId) {

        if (repository.existsById(agencyId)) {
            repository.deleteById(agencyId);

        } else {
            throw new NoEntityException(agencyId.toString());
        }

    }

    @Override
    public Agency findByIdSiscom(Long idSiscom) {
        return repository.findByIdSiscom(idSiscom).orElseThrow(() -> new NoEntityException(idSiscom.toString()));
    }
}
