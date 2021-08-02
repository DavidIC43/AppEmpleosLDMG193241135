package com.david.garcia.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.david.garcia.model.Categoria;

public interface CategoriasRepository extends JpaRepository<Categoria, Integer> {

}
