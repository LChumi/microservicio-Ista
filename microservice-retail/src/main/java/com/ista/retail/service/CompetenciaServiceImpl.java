package com.ista.retail.service;

import com.ista.retail.models.Competencia;
import com.ista.retail.repository.CompetenciaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CompetenciaServiceImpl extends GenericServiceImpl<Competencia,Long> implements ICompetenciaService{

    private final CompetenciaRepository repository;

    @Override
    public CrudRepository<Competencia, Long> getDao() {
        return repository;
    }
}
