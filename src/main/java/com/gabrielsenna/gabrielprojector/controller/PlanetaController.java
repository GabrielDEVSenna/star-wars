package com.gabrielsenna.gabrielprojector.controller;


import com.gabrielsenna.gabrielprojector.model.Planeta;
import com.gabrielsenna.gabrielprojector.repository.PlanetaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("planeta") // declaração de rota
public class PlanetaController {

    @Autowired
    private PlanetaRepository planetaRepository;


    @GetMapping
    public List<Planeta> listar(){
        return (List<Planeta>) planetaRepository.findAll();

    }
     @PostMapping
    public Planeta criar(@RequestBody Planeta planeta){
        return planetaRepository.save(planeta);

    }
    @GetMapping("/{id}")
    public Planeta consultaPorId(@PathVariable Long id){
        return planetaRepository.findById(id).orElse(null);
    }

   /* @DeleteMapping
    public void consultaPorId(@PathVariable Long id) {
        planetaRepository.deleteById(id);
    }

    */
@PutMapping("/{id}")
@ResponseStatus(HttpStatus.NO_CONTENT)
 public void atualizar (@RequestBody Planeta planeta, @PathVariable Long id){
//    Optional<Planeta> planetaOptional = planetaRepository.findById(id);
    planetaRepository.save(planeta);
    System.out.println(planeta);

 }
}
