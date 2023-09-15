package com.cloudap1delivery.cloudap1delivery.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloudap1delivery.cloudap1delivery.model.Pedido;
import com.cloudap1delivery.cloudap1delivery.model.Cliente;
import com.cloudap1delivery.cloudap1delivery.repository.ClienteRepository;
import com.cloudap1delivery.cloudap1delivery.repository.PedidoRepository;

@Service
public class PedidoService {
    @Autowired
    PedidoRepository pedidoRepository;

    @Autowired
    ClienteService clienteService;

    @Autowired
    ClienteRepository clienteRepository;

    public List<Pedido> findAll() {
        return this.pedidoRepository.findAll();
    }

    public Optional<Pedido> findById(long id) {
        return this.pedidoRepository.findById(id);
    }

    public Pedido create(long idCliente, Pedido newPedido) throws Exception {
        Optional<Cliente> opCliente = this.clienteService.findById(idCliente);

        if (opCliente.isPresent() == false) {
            throw new Exception("Não encontrei o cliente para adicionar o pedido");
        }

        Cliente cliente = opCliente.get();
        cliente.addPedido(newPedido);
        this.clienteRepository.save(cliente);
        Pedido result = cliente.getPedidos().get(cliente.getPedidos().size() - 1);
        return result;
    }

    public Pedido update(long id, Pedido newData) throws Exception {
        Optional<Pedido> existingItemOptional = pedidoRepository.findById(id);

        if (existingItemOptional.isPresent() == false)
            throw new Exception("Não encontrei o pedido a ser atualizado");

        Pedido existingItem = existingItemOptional.get();

        existingItem.setDescricao(newData.getDescricao());
        existingItem.setValor(newData.getValor());        

        pedidoRepository.save(existingItem);
        return existingItem;
    }

    public void delete(long id) throws Exception {
        Optional<Pedido> pedido = this.pedidoRepository.findById(id);

        if (pedido.isPresent() == false)
            throw new Exception("Não encontrei o pedido a ser atualizado");

        this.pedidoRepository.delete(pedido.get());
    }

}
