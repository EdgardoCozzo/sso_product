package com.sso.app.service;

import com.sso.app.entity.Ensayo;
import com.sso.app.repository.EnsayoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@AllArgsConstructor
public class EnsayoService {
    private final EnsayoRepository ensayoRepository;
    public Ensayo save (Ensayo ensayo){
        return this.ensayoRepository.save(ensayo);
    }
    public List<Ensayo> findAllActive(){
        return this.ensayoRepository.findAllActive();
    }
    public Optional<Ensayo> findById (Long id){
        return this.ensayoRepository.findById(id);
    }
    public void deleteById(Long id){
        Ensayo ensayo = this.ensayoRepository.findById(id).orElseThrow(() -> new RuntimeException("Ensayo no encontrada"));
        ensayo.setEliminado(true);
        this.ensayoRepository.save(ensayo);
    }
}
