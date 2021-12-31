package com.globo.producao.apoio.repositories;

import com.globo.producao.apoio.models.Agency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgencyRepository extends JpaRepository<Agency, Long> {

    Agency findByIdSiscom(Long idSiscom);
}
