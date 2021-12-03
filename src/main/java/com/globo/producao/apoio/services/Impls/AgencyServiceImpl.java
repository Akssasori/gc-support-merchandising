package com.globo.producao.apoio.services.Impls;

import com.globo.producao.apoio.models.Agency;
import com.globo.producao.apoio.repositories.AgencyRepository;
import com.globo.producao.apoio.services.interfaces.AgencyService;
import com.globo.producao.apoio.utils.exceptions.DeleteDataException;
import com.globo.producao.apoio.utils.exceptions.NoEntityException;
import com.globo.producao.apoio.utils.exceptions.UpdateDataException;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AgencyServiceImpl implements AgencyService {

    private final AgencyRepository repository;

    @Override
    public Agency save(Agency agency) { return repository.save(agency); }

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
    public Agency update(Long agencyId, Agency agency) {

        Agency agencyDB = repository.findById(agencyId).orElseThrow(() -> new NoEntityException(agencyId.toString()));

        try{
            agencyDB.setId(agencyId);
            agencyDB.setName(agencyDB.getName());
            repository.save(agencyDB);
        } catch (Exception e) {
            throw new UpdateDataException(e.getMessage());
        }
        return null;
    }

    @Override
    @SneakyThrows
    public void delete(Long agencyId) {

        try {
            if(repository.existsById(agencyId)){
                repository.deleteById(agencyId);
            } else {
                ResponseEntity.notFound();
            }
        } catch (Exception e) {
            throw new DeleteDataException(e.getMessage());
        }

    }
}
