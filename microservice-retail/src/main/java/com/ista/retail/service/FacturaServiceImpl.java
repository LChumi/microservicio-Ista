package com.ista.retail.service;

import com.ista.retail.models.Factura;
import com.ista.retail.repository.FacturaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FacturaServiceImpl extends GenericServiceImpl<Factura,Long> implements IFacturaService{

    private final FacturaRepository repository;

    @Override
    public CrudRepository<Factura, Long> getDao() {
        return repository;
    }
}
