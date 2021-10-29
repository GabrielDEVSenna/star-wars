package com.gabrielsenna.gabrielprojector.controller;


import com.gabrielsenna.gabrielprojector.model.Planeta;
import com.gabrielsenna.gabrielprojector.repository.PlanetaRepository;
import com.gabrielsenna.gabrielprojector.service.PlanetaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("planeta") // declaração de rota
public class PlanetaController {

    @Autowired
    private PlanetaService planetaService;


    @GetMapping
    public List<Planeta> listar(){
        return planetaService.listar();

    }
     @PostMapping
    public Planeta criar(@RequestBody Planeta planeta){
        return planetaService.criar(planeta);

    }
    @GetMapping("/{id}")
    public Planeta consultaPorId(@PathVariable Long id){
        return planetaService.consultaPorId(id);
    }

   @DeleteMapping("/{id}")
   @ResponseStatus(HttpStatus.NO_CONTENT)
   public void deletPorId(@PathVariable Long id) {
        planetaService.deletPorId(id);
    }


    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void atualizar (@RequestBody Planeta planeta, @PathVariable Long id){
        try {
            planetaService.atualizar(planeta, id);
            System.out.println(planeta);
        } catch (Exception e) {
           throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }


    }
}
