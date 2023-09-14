package com.cloudap1delivery.cloudap1delivery.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloudap1delivery.cloudap1delivery.model.Cliente;
import com.cloudap1delivery.cloudap1delivery.repository.ClienteRepository;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository _clienteRepository;

    public List<Cliente> findAll() {
        return this._clienteRepository.findAll();
    }

    public Optional<Cliente> findById(long id) {
        return this._clienteRepository.findById(id);
    }

    public Cliente save(Cliente cliente) throws Exception {
        if (this._clienteRepository.countByCpf(cliente.getCpf()) > 0) {
            throw new Exception("Este Cpf já existe na base de dados");
        }
        if (this._clienteRepository.countByEmail(cliente.getEmail()) > 0) {
            throw new Exception("Este Email já existe na base de dados");
        }
        this._clienteRepository.save(cliente);
        return cliente;
    }

    public Cliente update(long id, Cliente newData) throws Exception {
        Optional<Cliente> result = this._clienteRepository.findById(id);

        if (result.isPresent() == false) {
            throw new Exception("Não encontrei a cliente a ser atualizada");
        }

        if (this._clienteRepository.countByCpf(newData.getCpf()) > 0) {
            throw new Exception("Este Cpf já existe na base de dados");
        }

        if (this._clienteRepository.countByEmail(newData.getEmail()) > 0) {
            throw new Exception("Este Email já existe na base de dados");
        }

        Cliente clienteASerAtualizada = result.get();
        clienteASerAtualizada.setNome(newData.getNome());
        clienteASerAtualizada.setCpf(newData.getCpf());
        clienteASerAtualizada.setEmail(newData.getEmail());
        this._clienteRepository.save(clienteASerAtualizada);
        return clienteASerAtualizada;
    }

    public void delete(long id) throws Exception {
        Optional<Cliente> clienteASerExcluida = this._clienteRepository.findById(id);
        // Não achei a cliente a ser excluida
        if (clienteASerExcluida.isPresent() == false) {
            throw new Exception("Não encontrei o cliente a ser excluído");
        }
        this._clienteRepository.delete(clienteASerExcluida.get());
    }

    public void savePedido(Cliente cliente) {
        this._clienteRepository.save(cliente);
    }

}
