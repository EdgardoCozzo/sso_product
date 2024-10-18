package com.sso.app.service;


import com.sso.app.entity.TipoEquipo;
import com.sso.app.repository.TipoEquipoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@AllArgsConstructor
public class TipoEquipoService {

    private final TipoEquipoRepository tipoEquipoRepository;

    public TipoEquipo save (TipoEquipo tipoEquipo){
        return this.tipoEquipoRepository.save(tipoEquipo);
    }

    public List<TipoEquipo> findAllActive(){return this.tipoEquipoRepository.findAllActive();}

    public Optional<TipoEquipo> findById (Long id){
        return this.tipoEquipoRepository.findById(id);
    }

    public void deleteById(Long id){
        TipoEquipo tipoEquipo = this.tipoEquipoRepository.findById(id).orElseThrow(() -> new RuntimeException("Tipo de Equipo no encontrado"));
        tipoEquipo.setEliminado(true);
        this.tipoEquipoRepository.save(tipoEquipo);
    }

    public List<TipoEquipo> findByModelo(String modelo){
        return this.tipoEquipoRepository.findByModelo(modelo);
    }
}
