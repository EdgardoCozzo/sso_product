package com.sso.app.service;

import com.sso.app.entity.Recepcion;
import com.sso.app.repository.RecepcionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@AllArgsConstructor
public class RecepcionService {

    private final RecepcionRepository recepcionRepository;

    public Recepcion save (Recepcion recepcion){
        return this.recepcionRepository.save(recepcion);
    }
    public List<Recepcion> findAllActive(){
        return this.recepcionRepository.findAllActive();
    }
    public Optional<Recepcion> findById (Long id){
        return this.recepcionRepository.findById(id);
    }
    public void deleteById(Long id){
        Recepcion recepcion = this.recepcionRepository.findById(id).orElseThrow(() -> new RuntimeException("Recepción no encontrada"));
        recepcion.setEliminado(true);
        this.recepcionRepository.save(recepcion);
    }
}
