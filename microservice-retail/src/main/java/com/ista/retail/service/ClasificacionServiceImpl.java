package com.ista.retail.service;

import com.ista.retail.models.Clasificacion;
import com.ista.retail.repository.ClasificacionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClasificacionServiceImpl extends GenericServiceImpl<Clasificacion,Long> implements IClasificacionService{

    private final ClasificacionRepository repository;

    @Override
    public CrudRepository<Clasificacion, Long> getDao() {
        return repository;
    }
}
