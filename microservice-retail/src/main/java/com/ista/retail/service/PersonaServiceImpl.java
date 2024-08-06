package com.ista.retail.service;

import com.ista.retail.models.Persona;
import com.ista.retail.repository.PersonaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PersonaServiceImpl extends GenericServiceImpl<Persona,Long> implements IPersonaService{

    private final PersonaRepository repository;


    @Override
    public CrudRepository<Persona, Long> getDao() {
        return repository;
    }
}
