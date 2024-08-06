package com.ista.retail.service;

import com.ista.retail.models.Producto;
import com.ista.retail.repository.ProductoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductoServiceImpl extends GenericServiceImpl<Producto,Long> implements IProductoService{

    private final ProductoRepository repository;

    @Override
    public CrudRepository<Producto, Long> getDao() {
        return repository;
    }
}
