package com.gabrielsenna.gabrielprojector.service;

import com.gabrielsenna.gabrielprojector.model.Planeta;
import com.gabrielsenna.gabrielprojector.repository.PlanetaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Service
public class PlanetaService {

    @Autowired
    private PlanetaRepository planetaRepository;


    public List<Planeta> listar(){
        return (List<Planeta>) planetaRepository.findAll();

    }

    public Planeta criar( Planeta planeta){
        return planetaRepository.save(planeta);

    }

    public Planeta consultaPorId(Long id){
        return planetaRepository.findById(id).orElse(null);
    }


    public void deletPorId(Long id) {
        planetaRepository.deleteById(id);
    }


    public void atualizar (Planeta planeta, Long id) throws Exception {
        Optional<Planeta> planetaOptional = planetaRepository.findById(id);

        if(planetaOptional.isPresent()){
            planeta.setId(id);
            planetaRepository.save(planeta);
            System.out.println(planeta);
        } else {
            throw new Exception("Planeta Não Encontrado.");
        }

    }


}
