package com.sso.app.service;

import com.sso.app.entity.Orden;
import com.sso.app.repository.OrdenRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@AllArgsConstructor
public class OrdenService {
    private final OrdenRepository ordenRepository;
    public List<Orden> findAllActive(){
        return (List<Orden>) this.ordenRepository.findAllActive();
    }
    public Optional<Orden> findById(Long id) {
        return this.ordenRepository.findById(id);
    }
    public Optional<Orden> findByNumeroOT(String numeroOT) {
        return ordenRepository.findByNumeroOT(numeroOT);
    }
    public Orden save(Orden orden) {
        return ordenRepository.save(orden);
    }

    //sofDeleted para Orden
    public void deleteById(Long id){
        Orden orden = ordenRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Orden no encontrada"));
        orden.setEliminado(true);
        ordenRepository.save(orden);
    }

    public List<Orden> getActiveOrdenesByClienteId(Long id){
        return this.ordenRepository.findAllActiveByClienteId(id);
    }

}
