package com.bancamia.prueba.com.bancamia.prueba.servicio;

import java.util.List;
import java.util.Optional;

import com.bancamia.prueba.com.bancamia.prueba.entidad.Cliente;

public interface ClienteService {
    
    List<Cliente> obtenerTodosLosClientes();

    Optional<Cliente> obtenerClientePorId(Long id);

    Cliente crearCliente(Cliente cliente);

    Cliente actualizarCliente(Long id, Cliente clienteActualizado);

    void eliminarCliente(Long id);
}

