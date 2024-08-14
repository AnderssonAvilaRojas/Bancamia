package com.bancamia.prueba.com.bancamia.prueba.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bancamia.prueba.com.bancamia.prueba.entidad.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    
    
}
