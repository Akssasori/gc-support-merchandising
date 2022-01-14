package com.globo.producao.apoio.services.interfaces;

import com.globo.producao.apoio.models.Agency;
import com.globo.producao.apoio.utils.exceptions.InsertDataException;

import java.util.List;

public interface AgencyService {

    Agency save(Agency agency) throws InsertDataException;

    List<Agency> findAll();

    Agency findById(Long agencyId);

    Agency update(Long agencyId, Agency agency);

    void delete(Long agencyId);

    Agency findByIdSiscom(Long idSiscom);


}
