package com.avaliacao.projetoindividualcontinuada2.controladores;

import com.avaliacao.projetoindividualcontinuada2.dominios.Campanha;
import com.avaliacao.projetoindividualcontinuada2.repositorios.CampanhaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Optional;

@RestController
@RequestMapping("/campanhas")
public class CampanhaController {


    @Autowired
    private CampanhaRepository repository;

    @GetMapping
    public ResponseEntity getTodo() {
        if (repository.count() <= 0) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(repository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity getPorId(@PathVariable int id){
        Optional<Campanha> campanha = repository.findById(id);
        return ResponseEntity.of(campanha);
    }

    @PostMapping
    public ResponseEntity getCadastrar(@RequestBody Campanha newCampanha){
        repository.save(newCampanha);
        return ResponseEntity.created(null).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity getExcluir(@PathVariable int id) {
        if (repository.existsById(id)) {
            try {
                repository.deleteById(id);
                return ResponseEntity.ok().build();
            }
            catch (DataIntegrityViolationException e){
                return ResponseEntity.badRequest().body(
                        Arrays.asList("NÃO É POSSÍVEL DELETAR: id:"+id+" está referenciada. A jogador está nessa campanha.")
                );
            }
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity getAtualizar(@PathVariable int id, @RequestBody Campanha campanha) {

        if (repository.existsById(id)) {
            campanha.setId(id);
            repository.save(campanha);
            return ResponseEntity.ok().build();
        }

        return ResponseEntity.notFound().build();
    }
}
