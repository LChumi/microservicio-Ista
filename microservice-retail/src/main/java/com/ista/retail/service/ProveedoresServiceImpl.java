package com.ista.retail.service;

import com.ista.retail.models.Proveedores;
import com.ista.retail.repository.ProveedoresRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProveedoresServiceImpl extends GenericServiceImpl<Proveedores,Long> implements IProveedoresService {

    private final ProveedoresRepository repository;

    @Override
    public CrudRepository<Proveedores, Long> getDao() {
        return repository;
    }
}
