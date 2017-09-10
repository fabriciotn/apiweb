package com.fabriciotn.apiweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fabriciotn.apiweb.model.Estado;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Integer>{

}
