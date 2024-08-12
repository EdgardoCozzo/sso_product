package com.sso.app.controller;
import com.sso.app.entity.Orden;
import com.sso.app.service.OrdenService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Optional;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("api/ordenes")
@AllArgsConstructor
@CrossOrigin
public class OrdenController {
    private final OrdenService ordenService;

    @GetMapping
    public ResponseEntity<List<Orden>> getAllOrdenes() {
        List<Orden> ordenes = ordenService.findAllAllActive();
        return ResponseEntity.ok(ordenes);
    }

    @GetMapping("/{numeroOT}")
    public ResponseEntity<Orden> getOrdenByNumeroOT(@PathVariable String numeroOT) {
        Optional<Orden> orden = ordenService.findByNumeroOT(numeroOT);
        return orden.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Orden> createOrden(@RequestBody Orden orden) {
        Orden savedOrden = ordenService.save(orden);
        return ResponseEntity.ok(savedOrden);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Orden> updateOrden(@PathVariable Long id, @RequestBody Orden orden) {
        orden.setId(id);
        Orden updatedOrden = ordenService.save(orden);
        return ResponseEntity.ok(updatedOrden);
    }
    //softdeleted para Orden
    @PutMapping("/softdelete/{id}")
    public ResponseEntity<Void> softDeleteCliente(@PathVariable Long id) {
        try {
            ordenService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

   // @DeleteMapping("/{id}")
   // public ResponseEntity<Void> deleteOrden(@PathVariable Long id) {
   //     ordenService.deleteById(id);
   //     return ResponseEntity.noContent().build();
   // }
}
