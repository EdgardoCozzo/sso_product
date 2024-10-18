package com.sso.app.service;

import com.sso.app.entity.Salida;
import com.sso.app.repository.SalidaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@AllArgsConstructor
public class SalidaService {
    private final SalidaRepository salidaRepository;

    public Salida save (Salida salida){
        return this.salidaRepository.save(salida);
    }
    public List<Salida> findAllActive(){
        return this.salidaRepository.findAllActive();
    }
    public Optional<Salida> findById (Long id){
        return this.salidaRepository.findById(id);
    }
    public void deleteById(Long id){
        Salida salida = this.salidaRepository.findById(id).orElseThrow(() -> new RuntimeException("Salida no encontrada"));
        salida.setEliminado(true);
        this.salidaRepository.save(salida);
    }
}
