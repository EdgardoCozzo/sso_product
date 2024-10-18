package com.sso.app.service;

import com.sso.app.entity.Inspeccion;
import com.sso.app.repository.InspeccionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.Optional;

@Service
@Transactional
@AllArgsConstructor
public class InspeccionService {

    private final InspeccionRepository inspeccionRepository;

    public Inspeccion save(Inspeccion inspeccion){ return this.inspeccionRepository.save(inspeccion);}

    public List<Inspeccion> findAllActive (){ return (List<Inspeccion>) this.inspeccionRepository.findAllActive();}

    public Optional<Inspeccion> findById(Long id){
            return this.inspeccionRepository.findById(id);
    }

    public void deletedById(Long id){
        Inspeccion inspeccion = inspeccionRepository.findById(id).orElseThrow(() -> new RuntimeException("Inspeccion no encontrada"));
        inspeccion.setEliminado(true);
        inspeccionRepository.save(inspeccion);
    }
}
