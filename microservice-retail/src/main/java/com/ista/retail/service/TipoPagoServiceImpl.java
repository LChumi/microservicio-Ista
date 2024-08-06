package com.ista.retail.service;

import com.ista.retail.models.TipoPago;
import com.ista.retail.repository.TipoPagoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TipoPagoServiceImpl extends GenericServiceImpl<TipoPago,Long> implements ITipoPagoService{

    private final TipoPagoRepository repository;


    @Override
    public CrudRepository<TipoPago, Long> getDao() {
        return repository;
    }
}
