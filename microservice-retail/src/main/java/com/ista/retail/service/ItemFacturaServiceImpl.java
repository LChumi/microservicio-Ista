package com.ista.retail.service;

import com.ista.retail.models.ItemFactura;
import com.ista.retail.repository.ItemFacturaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ItemFacturaServiceImpl extends GenericServiceImpl<ItemFactura,Long> implements IItemFacturaService{

    private final ItemFacturaRepository repository;

    @Override
    public CrudRepository<ItemFactura, Long> getDao() {
        return repository;
    }
}
