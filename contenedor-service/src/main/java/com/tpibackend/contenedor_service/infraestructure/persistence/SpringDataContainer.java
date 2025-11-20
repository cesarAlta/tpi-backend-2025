package com.tpibakend.contenedor_service.infraestructure.persistence;

import com.tpibakend.contenedor_service.domain.Container;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpringDataContainer extends JpaRepository<Container,Long> {
}
