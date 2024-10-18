package com.sso.app.service;

import com.sso.app.entity.Equipo;
import com.sso.app.repository.EquipoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@AllArgsConstructor
public class EquipoService {
    private final EquipoRepository equipoRepository;

    public Equipo save (Equipo equipo){
        return this.equipoRepository.save(equipo);
    }
    public List<Equipo> findAllActive(){
        return this.equipoRepository.findAllActive();
    }
    public Optional<Equipo> findById (Long id){
        return this.equipoRepository.findById(id);
    }
    public void deleteById(Long id){
        Equipo equipo= this.equipoRepository.findById(id).orElseThrow(() -> new RuntimeException("Equipo no encontrado"));
        equipo.setEliminado(true);
        this.equipoRepository.save(equipo);
    }


}
