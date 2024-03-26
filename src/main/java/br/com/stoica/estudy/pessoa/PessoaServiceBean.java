package br.com.stoica.estudy.pessoa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import io.micrometer.common.lang.NonNull;

@Service
public class PessoaServiceBean implements PessoaService{

    @Autowired
    private PessoaRepository repository;

    @Override
    public Page<?> findAll(@NonNull Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public Pessoa findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new PessoaNaoEncontradaException(id));
    }
    
}
