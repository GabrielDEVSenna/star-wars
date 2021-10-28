package com.gabrielsenna.gabrielprojector.repository;

import com.gabrielsenna.gabrielprojector.model.Planeta;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlanetaRepository extends CrudRepository<Planeta, Long> {
}
