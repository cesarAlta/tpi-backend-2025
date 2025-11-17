package com.tpibakend.solicitud_service.infraestructure.persistence;

import com.tpibakend.solicitud_service.domain.Request;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpringDataRequestRepository extends JpaRepository<Request,Long> {
}
