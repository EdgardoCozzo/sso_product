package com.sso.app.service;

import com.sso.app.entity.Cliente;
import com.sso.app.repository.ClienteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@AllArgsConstructor
public class ClienteService {
    private final ClienteRepository clienteRepository;

    public Cliente save(Cliente cliente){
        return this.clienteRepository.save(cliente);
    }
    public List<Cliente> findAllActive(){
        return (List<Cliente>)this.clienteRepository.findByEliminadoFalse();
    }
    public Optional<Cliente> findByRazonSocial(String razonSocial){
        return this.clienteRepository.findByRazonSocialContaining(razonSocial);
    }
    public Optional<Cliente> findById (Long id){
        return clienteRepository.findByIdAndEliminadoFalse(id);
    }

    public void deleteById(Long id){
        Cliente cliente = clienteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));
        cliente.setEliminado(true);
        clienteRepository.save(cliente);
    }
}
