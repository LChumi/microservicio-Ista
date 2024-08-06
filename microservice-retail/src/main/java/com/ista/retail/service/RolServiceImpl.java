package com.ista.retail.service;

import com.ista.retail.models.Rol;
import com.ista.retail.repository.RolRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RolServiceImpl extends GenericServiceImpl<Rol,Long> implements IRolService{

    private final RolRepository repository;

    @Override
    public CrudRepository<Rol, Long> getDao() {
        return repository;
    }
}
