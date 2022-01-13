package com.globo.producao.apoio.repositories;

import com.globo.producao.apoio.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

    Optional<Client> findByIdSiscom(Long idSiscom);
}
