package br.com.stoica.estudy.jasper;

import org.springframework.data.domain.Pageable;

public interface PessoaJasper {
    
    byte[] gerarRelatorioPessoas(Pageable pageable);

}
