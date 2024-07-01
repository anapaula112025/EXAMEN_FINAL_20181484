package com.example.demoexamen.repository;

import com.example.demoexamen.entity.Distribuidora;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DistribuidoraRepository extends JpaRepository<Distribuidora, Integer> {
}
