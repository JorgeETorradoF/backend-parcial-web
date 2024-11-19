package com.example.ProyectoWeb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ProyectoWeb.model.Contratos;

@Repository
public interface ContratosRepository extends JpaRepository<Contratos, Integer> {
}