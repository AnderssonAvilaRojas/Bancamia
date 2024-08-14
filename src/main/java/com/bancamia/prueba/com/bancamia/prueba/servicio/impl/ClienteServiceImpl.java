package com.bancamia.prueba.com.bancamia.prueba.servicio.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bancamia.prueba.com.bancamia.prueba.entidad.Cliente;
import com.bancamia.prueba.com.bancamia.prueba.repositorio.ClienteRepository;
import com.bancamia.prueba.com.bancamia.prueba.servicio.ClienteService;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public List<Cliente> obtenerTodosLosClientes() {
        return clienteRepository.findAll();
    }

    @Override
    public Optional<Cliente> obtenerClientePorId(Long id) {
        return clienteRepository.findById(id);
    }

    @Override
    public Cliente crearCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @Override
    public Cliente actualizarCliente(Long id, Cliente clienteActualizado) {
        Optional<Cliente> clienteExistente = clienteRepository.findById(id);
        if (clienteExistente.isPresent()) {
            Cliente cliente = clienteExistente.get();
            cliente.setTipoIdentificacion(clienteActualizado.getTipoIdentificacion());
            cliente.setNumeroIdentificacion(clienteActualizado.getNumeroIdentificacion());
            cliente.setNombres(clienteActualizado.getNombres());
            cliente.setApellidos(clienteActualizado.getApellidos());
            cliente.setFechaCreacion(clienteActualizado.getFechaCreacion());
            return clienteRepository.save(cliente);
        } else {
            throw new RuntimeException("Cliente no encontrado");
        }
    }

    @Override
    public void eliminarCliente(Long id) {
        clienteRepository.deleteById(id);
    }

  


}

