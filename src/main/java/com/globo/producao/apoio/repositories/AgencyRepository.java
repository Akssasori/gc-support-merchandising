package com.globo.producao.apoio.repositories;

import com.globo.producao.apoio.models.Agency;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AgencyRepository extends JpaRepository<Agency, Long> {

    @EntityGraph(attributePaths = {"action"})
    Optional<Agency> findByIdSiscom(Long idSiscom);
}
