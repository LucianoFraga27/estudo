package br.com.stoica.estudy.pessoa;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public interface PessoaService {
    
    Page<?> findAll(Pageable pageable);
    Pessoa findById(Long id);
    void gerarCsvBasico();
    void lerCsvBasico(String path);
}
