package com.example.Parcial.Service;

import com.example.Parcial.Model.Cliente;
import com.example.Parcial.Repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    // Guardar un nuevo Cliente
    public Cliente guardar(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    // Listar todos los Clientes
    public List<Cliente> listar() {
        return clienteRepository.findAll();
    }

    // Buscar un Cliente por su ID
    public Cliente buscarPorId(Integer id) {
        return clienteRepository.findById(id).orElse(null);
    }

    // Actualizar un Cliente existente
    public Cliente actualizar(Cliente cliente) {
        if (cliente.getId() != null && clienteRepository.existsById(cliente.getId())) {
            return clienteRepository.save(cliente);
        } else {
            throw new RuntimeException("Cliente no encontrado con ID: " + cliente.getId());
        }
    }

    // Eliminar un Cliente por su ID
    public void eliminar(Integer id) {
        if (clienteRepository.existsById(id)) {
            clienteRepository.deleteById(id);
        } else {
            throw new RuntimeException("Cliente no encontrado con ID: " + id);
        }
    }
    //querys insecci
    public List<Cliente> listarTodosLosClientes() {
        return clienteRepository.findAllClientes();
    }

    public Cliente buscarClientePorId(Integer id) {
        return clienteRepository.findClienteById(id);
    }


}
