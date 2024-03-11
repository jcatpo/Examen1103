package org.cibertec.edu.pe.repository;

import org.cibertec.edu.pe.modelo.Ciudad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CiudadRepository extends JpaRepository<Ciudad, String> {

}