package com.ista.retail.service;

import com.ista.retail.models.Usuario;
import com.ista.retail.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsuarioServiceImpl extends GenericServiceImpl<Usuario,Long> implements IUsuarioService{

    private final UsuarioRepository repository;


    @Override
    public CrudRepository<Usuario, Long> getDao() {
        return repository;
    }
}
