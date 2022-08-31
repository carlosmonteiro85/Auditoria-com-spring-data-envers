package com.prototipo.audit.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prototipo.audit.model.UsuarioRevEntity;

public interface UsuarioRevEntityRepository extends JpaRepository<UsuarioRevEntity, Long> {
}
