package com.globo.producao.apoio.services.interfaces;

import com.globo.producao.apoio.models.Agency;

import java.util.List;

public interface AgencyService {

    Agency save(Agency agency);

    List<Agency> findAll();

    Agency findById(Long agencyId);

    Agency update(Long agencyId, Agency agency);

    void delete(Long agencyId);


}
