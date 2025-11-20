package com.tpibakend.solicitud_service.infraestructure.persistence.adapter;

import com.tpibakend.solicitud_service.domain.Request;
import com.tpibakend.solicitud_service.domain.port.out.RequestRepositoryPort;
import com.tpibakend.solicitud_service.infraestructure.persistence.SpringDataRequestRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class JpaPortRequestAdapter implements RequestRepositoryPort {
    SpringDataRequestRepository repository;


    @Override
    public Request save(Request request) {
        return repository.save(request);
    }

    @Override
    public Optional<Request> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<Request> findAll() {
        return repository.findAll();
    }
}
