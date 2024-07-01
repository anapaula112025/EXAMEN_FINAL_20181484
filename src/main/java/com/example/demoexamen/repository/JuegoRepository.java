package com.example.demoexamen.repository;

import com.example.demoexamen.entity.Juego;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JuegoRepository extends JpaRepository<Juego, Integer> {
}
